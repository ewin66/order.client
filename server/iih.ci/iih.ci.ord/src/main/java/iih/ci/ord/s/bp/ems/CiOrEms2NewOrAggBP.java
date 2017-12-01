package iih.ci.ord.s.bp.ems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorsrvhp.d.CiOrSrvHpDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.OrSrvSyncInfoDTO;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 根据临床Ems信息创建临床医嘱聚集数据操作BP
 */
public class CiOrEms2NewOrAggBP {
	/**
	 * 根据临床Ems信息创建临床医嘱聚集数据操作
	 * @param aggorder 
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public  Hashtable exec(CiorderAggDO aggorder,CiEmsDTO ems)  throws BizException{
		Hashtable ht=new Hashtable();
		
		//有效性校验
		if(!isValidate(aggorder,ems))return null;
		
		//生成并设置主对象
		createCiOrderInfo(aggorder,ems,ht);
		CiOrderDO ciord=aggorder.getParentDO();
		
		CiEnContextDTO context = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		long tBeginTime = System.currentTimeMillis();
		//生成并设置医嘱项目集合信息
		ArrayList<OrdSrvDO> orsrvs=new ArrayList<OrdSrvDO>();
		ciOrSrvInfoHandle(aggorder,orsrvs,ht,ems);
		OrdBizLogger.info(context, String.format("保存医嘱[%s]，生成聚合结构——医嘱服务列表,耗时:%s(ms)", ems.getName(),System.currentTimeMillis()-tBeginTime));
		
		
		tBeginTime = System.currentTimeMillis();
		//医嘱关联费用信息创建医嘱服务项目
		OrdSrvDO[] usgrelorsrvs=getCiOrRelUsgFeeOrSrvInfo(aggorder,ems,ht);
		ordSrvDOFreqMod(usgrelorsrvs,CiOrdUtils.getOrSrvSyncInfo(CiOrdUtils.getUsageRelFeeIdFreq(ciord),new FBoolean(false)));//医嘱项目频次修正逻辑添加  2016-06-14
		OrdBizLogger.info(context, String.format("保存医嘱[%s]，生成聚合结构——用法关联服务项目,耗时:%s(ms)", ems.getName(),System.currentTimeMillis()-tBeginTime));
		
		
		//设置医嘱聚合数据中对应的医嘱项目集合
		OrdSrvDO[] orsrvdos=null;
		orsrvdos=merge(usgrelorsrvs, orsrvs);
		
		tBeginTime = System.currentTimeMillis();
		//组合定价计价模式创建医嘱服务项目  2016-05-18新增逻辑分支
		ArrayList<OrdSrvDO> comppriorsrvs=getCiOrCompPriOrSrvs(aggorder,ems,orsrvdos);
		orsrvdos=merge(orsrvdos, comppriorsrvs);
		OrdBizLogger.info(context, String.format("保存医嘱[%s]，生成聚合结构——计算组合计价服务项目,耗时:%s(ms)", ems.getName(),System.currentTimeMillis()-tBeginTime));
		
		//添加 会诊时  医嘱项目添加按邀请科室添加个数
		CiOrCreateOrSrvConsBP  bp  = new CiOrCreateOrSrvConsBP();
		orsrvdos = bp.exe(ems, orsrvdos);
		
		orSrvDOSortNoHandle(orsrvdos);
		
		if(!(orsrvdos==null || orsrvdos.length==0)){
			aggorder.setOrdSrvDO(orsrvdos);
		}
		
		return ht;
	}
	
	/**
	 * 临床医嘱服务项目序号处理
	 * @param orsrvdos
	 */
	private void orSrvDOSortNoHandle(OrdSrvDO[] orsrvdos){
		CiOrdUtils.doSortNoHandle(orsrvdos, OrdSrvDO.SORTNO);
	}
	

	/**
	 * 有效信息校验
	 * @param aggorder
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	private boolean isValidate(CiorderAggDO aggorder,CiEmsDTO ems) throws BizException{
		if(aggorder==null || ems==null)return false;
		return true;
	}
	
	/**
	 * 生成医嘱主对象信息（公共）
	 * @param aggdo
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	private void createCiOrderInfo(CiorderAggDO aggdo,CiEmsDTO ems,Hashtable ht) throws BizException{
		CiOrCreateOrd8EmsBP bp=new CiOrCreateOrd8EmsBP();
		bp.exec(aggdo, ems, ht);
	}
	
	/**
	 * 根据ems服务物品信息生成医嘱项目信息
	 * @param ordo
	 * @param ems
	 * @param index
	 * @return
	 * @throws BizException
	 */
	private OrdSrvItemDatum createSrvMmInfo(CiorderAggDO aggdo,CiEmsDTO ems,int index) throws BizException{
		CiOrCreateSrvMm8EmsBP bp=new CiOrCreateSrvMm8EmsBP();
		return bp.exec(aggdo, ems, index);
	}
	
	
	/**
	 * 根据ems服务物品信息生成医嘱项目集合信息
	 * @param ordo
	 * @param ems
	 * @param srvsetitemindexs
	 * @param ht
	 * @return
	 * @throws BizException
	 */
	private ArrayList<OrdSrvDO> createSrvMmInfo(CiorderAggDO aggdo,CiEmsDTO ems,Integer[] srvsetitemindexs,Hashtable ht) throws BizException{
		//空校验
		if(ems==null || ems.getEmssrvs()==null || ems.getEmssrvs().size()==0)return null;
		
		//参数设置
		ArrayList<OrdSrvDO> list=new ArrayList<OrdSrvDO>();
		OrdSrvItemDatum datum=null;
		FArrayList srvdtos=ems.getEmssrvs();
		String matchstr=CiOrdUtils.COMMA_STR+CiOrdUtils.aryToString(srvsetitemindexs)+CiOrdUtils.COMMA_STR;
		MedSrvSetItemDO[] bdsrvinset=CiOrdUtils.getBdSrvSetItems(srvdtos,srvsetitemindexs, FBoolean.FALSE);//获得  非clinical服务项
		CiEmsSrvDTO setitmsrv=null;
		String id_srv="";
		ArrayList<HashMap<String, CiOrSrvHpDO>> orSrvHpList = new ArrayList<HashMap<String, CiOrSrvHpDO>>();
		//遍历
		for(int i=0;i<srvdtos.size();i++){
			//是否为匹配串中的项判断
			if(CiOrdUtils.isInStr(CiOrdUtils.COMMA_STR+Integer.toString(i)+CiOrdUtils.COMMA_STR, matchstr)){
				//continue; 2016-09-01  门诊费用页签调试时   注释掉   增加 如下代码逻辑
				setitmsrv=(CiEmsSrvDTO)srvdtos.get(i);
				if(!CiOrdUtils.isFeeItm4Set(setitmsrv,bdsrvinset,srvdtos,srvsetitemindexs)){continue;}//2016-08-31  新增判断逻辑
			}
			
			//创建医嘱项目物品相关信息
			datum=createSrvMmInfo(aggdo,ems,i);
			
			//返回结果判断
			if(datum.getSrvdo()==null)continue;
			id_srv=datum.getSrvdo().getId_srv();
			
			//医嘱项目对应物品记录处理
			CiOrAttachInfoUtils.addOrdSrvMmDO(ht, id_srv, datum.getSrvmm());
			//代办人的记录修改为在签署的时候录入
			//医嘱项目对应代办人记录处理
			//CiOrAttachInfoUtils.addOrSrvAgentInfoDO(ht, id_srv, datum.getSrvagent());
			
			//医嘱项目对应变动用药处理
			CiOrAttachInfoUtils.addOrdSrvDoseDOs(ht, id_srv, datum.getSrvdoses());
			
			//医嘱项目对应需皮试药对应的皮试医嘱处理
			CiOrAttachInfoUtils.addOrSrvRelSkinOr(ht, CiOrdUtils.getIdSrvAndMm(srvdtos,i), datum.getSkintestagginfo());
			
			//医嘱项目列表处理
			list.add(datum.getSrvdo());
			if(!CiOrdUtils.isEmpty(datum.getCiorsrvhpdo())) orSrvHpList.add(datum.getCiorsrvhpdo());
		}
		ht.put(ICiDictCodeConst.CI_OR_SRV_HP_KEY, orSrvHpList);
		return list;
	}
	
	/**
	 * 医嘱关联费用信息创建医嘱项目集合
	 * @param ordo
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	private  OrdSrvDO[] getCiOrRelUsgFeeOrSrvInfo(CiorderAggDO aggdo,CiEmsDTO ems,Hashtable ht) throws BizException{
		if(CiOrdUtils.isHasPriSrvHandled(ems).booleanValue()) return null;//前台是否已经算过费用项目
		//2016-08-01 新增逻辑 主要为费用页签使用 还是有漏洞
		if(EmsHelper.isEmsSrvsGenerated(ems, aggdo.getParentDO().getId_srv(), new Integer[]{OrSrvSourceFromEnum.USAGERELFEE,OrSrvSourceFromEnum.BOILRELFEE,OrSrvSourceFromEnum.SPECIMENRELFEE,OrSrvSourceFromEnum.RELSRVTACTIC},null))return null;
			
		//获得医嘱关联费用服务数据
		CiOrUsageRelFeeSrvGetBP bp=new CiOrUsageRelFeeSrvGetBP();
		UsageRelFeeSrvDO[] relfeesrvdos=bp.exec(ems);
		
		//医嘱关联费用服务信息创建医嘱项目
		CiOrRelUsgFeeOrSrvBuildBP bp1=new CiOrRelUsgFeeOrSrvBuildBP();
		return bp1.exec(aggdo, relfeesrvdos,ht);
	}
	
	/**
	 * 合并获得医嘱项目集合信息
	 * @param usgrelorsrvs
	 * @param orsrvs
	 * @return
	 */
	private OrdSrvDO[] merge(OrdSrvDO[] usgrelorsrvs,ArrayList<OrdSrvDO> orsrvs){
		if(orsrvs==null || orsrvs.size()==0){
			return usgrelorsrvs;
		}
		OrdSrvDO[] orsrvdos=(OrdSrvDO[]) orsrvs.toArray((OrdSrvDO[]) Array.newInstance(OrdSrvDO.class, 0));
		
		//返回处理
		return (OrdSrvDO[])CiOrdUtils.mergeObjAry(orsrvdos, usgrelorsrvs);
	}
	
	/**
	 * 生成并设置医嘱项目信息处理
	 * @param ciord
	 * @param rtn
	 * @param ht
	 * @param ems
	 * @throws BizException 
	 */
	private void ciOrSrvInfoHandle(CiorderAggDO aggdo,ArrayList<OrdSrvDO> rtn,Hashtable ht,CiEmsDTO ems) throws BizException{
		Integer[] srvsetitemindexs=getEmsSrvsetAndItemIndexes(ems);
		
		 ArrayList<OrdSrvDO> unsetsrvs = null;
		//套处理逻辑
		if(!(srvsetitemindexs==null || srvsetitemindexs.length==0)){
			String id_srv_set=CiOrdUtils.getIdSrvSet4Ems(ems,srvsetitemindexs);
			MedSrvDO srvdo=CiOrdAppUtils.getMedsrvMDORService().findById(id_srv_set);
			if(IBdSrvDictCodeConst.SD_SETORD_ORMODE.equals(srvdo.getSd_setord())){  //医嘱模式
				ciOrSrvInfoHandleForOrMode(aggdo,rtn,ht,ems,srvsetitemindexs,srvdo);
			}else if(IBdSrvDictCodeConst.SD_SETORD_SRVMODE.equals(srvdo.getSd_setord())){//服务模式 
				//已废弃不用
			}else if(IBdSrvDictCodeConst.SD_SETORD_COMBINATION.equals(srvdo.getSd_setord())){//服务组合模式 
				//暂不处理
			}
			
		}
		CiEnContextDTO context = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		long tBeginTime = System.currentTimeMillis();	
		//非套项目的处理
		unsetsrvs=createSrvMmInfo(aggdo,ems,srvsetitemindexs,ht);
		OrdBizLogger.info(context, String.format("保存医嘱[%s]，生成聚合结构——医嘱服务列表——非套项目处理,耗时:%s(ms)", ems.getName(),System.currentTimeMillis()-tBeginTime));
		

		 //合并处理
		 if(!(unsetsrvs==null || unsetsrvs.size()==0)){rtn.addAll(unsetsrvs);}
	}
	
	/**
	 * 套医嘱开立模式时套内服务项目处理逻辑
	 * @param ciord
	 * @param ems
	 * @param srvsetitemindexs
	 * @param rtn
	 * @throws BizException 
	 */
	private ArrayList<OrdSrvDO> srvSetRelSrvHandle4OrMode(CiorderAggDO aggdo,CiEmsDTO ems,Integer[] srvsetitemindexs,ArrayList<OrdSrvDO> rtn,MedSrvDO setsrvdo,Hashtable ht) throws BizException{
		CiOrSrvSetHandle4OrModeBP bp=new CiOrSrvSetHandle4OrModeBP();
		return bp.exec(aggdo, ems, srvsetitemindexs, setsrvdo,ht);
	}
	
	/**
	 * 根据医嘱模式的服务套项目医嘱数据的处理逻辑
	 * @param ciord
	 * @param srvdo
	 */
	private  void CiOrderHandle4SrvSet(CiOrderDO ciord,MedSrvDO srvdo){
		ciord.setId_srv(srvdo.getId_srv());
		//......
	}
	
	/**
	 * 获得ems医疗单中套及套内项目集合索引信息
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	private Integer[] getEmsSrvsetAndItemIndexes(CiEmsDTO ems) throws BizException{
		CiOrEmsGetSrvSetAndItemsBP bp=new CiOrEmsGetSrvSetAndItemsBP();
		return bp.exec(ems);
	}
	
	/**
	 *  创建临床医嘱相关服务套内项目集合信息
	 * @param ems
	 * @param srvsetitemindexs
	 * @return
	 * @throws BizException
	 */
	private OrdSrvSetDO[] createOrSrvSetInfo(CiEmsDTO ems,Integer[] srvsetitemindexs) throws BizException{
		CiOrCreateOrSrvSetInfoBP bp=new CiOrCreateOrSrvSetInfoBP();
		ArrayList<OrdSrvSetDO> list= bp.exec(ems, srvsetitemindexs);
		if(list==null || list.size()==0)return null;
		return (OrdSrvSetDO[]) list.toArray((OrdSrvSetDO[]) Array.newInstance(OrdSrvSetDO.class, 0));
	}
	
	/**
	 * 生成并设置医嘱项目信息处理（医嘱模式）
	 * @param ciord
	 * @param rtn
	 * @param ht
	 * @param ems
	 * @param srvsetitemindexs
	 * @param srvdo
	 * @throws BizException
	 */
	private void ciOrSrvInfoHandleForOrMode(CiorderAggDO aggdo,ArrayList<OrdSrvDO> rtn,Hashtable ht,CiEmsDTO ems,Integer[] srvsetitemindexs,MedSrvDO srvdo) throws BizException{
		//套医嘱开立模式时套内服务项目的医嘱服务处理逻辑
		ArrayList<OrdSrvDO> setrelsrvs=srvSetRelSrvHandle4OrMode(aggdo,ems,srvsetitemindexs,rtn,srvdo,ht);
		if(!(setrelsrvs==null || setrelsrvs.size()==0)){rtn.addAll(setrelsrvs);}
		//医嘱相关信息套相关信息修改
		CiOrderHandle4SrvSet(aggdo.getParentDO(),srvdo);
		
		//医嘱服务套内项目处理
		OrdSrvSetDO[] orsrvsets=createOrSrvSetInfo(ems,srvsetitemindexs);
		// lizheng 添加   服务套内项目个数
	    if(orsrvsets != null && orsrvsets.length>0){
	    	CiOrAttachInfoUtils.addOrdSrvSetDOs(ht, "", orsrvsets);
	    }
		
	}
	
	/**
	 * 创建组合定价模式医嘱项目对应的医嘱项目
	 * @param aggdo
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	private ArrayList<OrdSrvDO> getCiOrCompPriOrSrvs(CiorderAggDO aggdo,CiEmsDTO ems,OrdSrvDO[] orsrvdos) throws BizException{
		//有效性校验
		if(ems==null || ems.getEmssrvs()==null || ems.getEmssrvs().size()==0)return null;
		if(CiOrdUtils.isHasPriSrvHandled(ems).booleanValue()) return null;//前台是否已经算过费用项目
		ArrayList<OrdSrvDO> rtnlist=new ArrayList<OrdSrvDO>();
		ArrayList<OrdSrvDO> rtnTmp=null;
		long startTIme = System.currentTimeMillis(); 
		//遍历
		for(int i=0;i<ems.getEmssrvs().size();i++){
			long stmp = System.currentTimeMillis(); 
			//服务项目组合定价模式逻辑判断
			CiEmsSrvDTO emssrvdto=(CiEmsSrvDTO)ems.getEmssrvs().get(i);
			if(!isSrvCompPriMd(emssrvdto)||isSetOrSrv(ems,emssrvdto))continue;
			
			//2016-08-01 新增逻辑 主要为费用页签使用 还是有些漏洞
			if(EmsHelper.isEmsSrvsGenerated(ems, emssrvdto.getId_srv(), new Integer[]{OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD},null)){
				continue;
			}
			//2016-08-30  新增逻辑   组合费用项执行科室等于组合项目执行科室
			emssrvdto.setId_dep(CiOrdUtils.getIdDepMpInfo(orsrvdos,emssrvdto.getId_srv()));
			stmp = System.currentTimeMillis(); 
			
			//组合定价模式处理
			rtnTmp=getSrvMm8CompPriSrv(aggdo,ems,i);
			stmp = System.currentTimeMillis(); 
			if(!CiOrdUtils.isEmpty(rtnTmp)){
				OrSrvSyncInfoDTO syncdto=CiOrdUtils.getOrSrvSyncInfo(emssrvdto);
				syncdto.setFg_or(FBoolean.FALSE);
				ordSrvDOFreqMod(rtnTmp,syncdto);
				rtnlist.addAll(rtnTmp);
			}
			
		}
		return rtnlist;
	}
	
/**
 * 套是个数加收和个数定价时，套内临床项目不用再计算组合计价
 * @param ems
 * @param emssrvdto
 * @return
 * @throws BizException 
 */
	private boolean isSetOrSrv(CiEmsDTO ems, CiEmsSrvDTO emssrvdto) throws BizException {
		if(ems==null||emssrvdto==null) return false;
		if(!CiOrdUtils.isEmpty(ems.getFg_set())&&ems.getFg_set().booleanValue()){
			Integer[] srvsetitemindexs=getEmsSrvsetAndItemIndexes(ems);
			String id_srv_set=CiOrdUtils.getIdSrvSet4Ems(ems,srvsetitemindexs);
			MedSrvDO srvdo=CiOrdAppUtils.getMedsrvMDORService().findById(id_srv_set);
			//个数加收和个数定价时不需要计算套内临床的组合计价
			if(CiOrdUtils.isSrvsetMemberCntPrimd(srvdo.getId_primd())||CiOrdUtils.isSrvsetMemCntAdditionalPrimd(srvdo.getId_primd())){
				if(id_srv_set.equals(emssrvdto.getId_srv_set())&&!CiOrdUtils.isEmpty(emssrvdto.getFg_or())&&emssrvdto.getFg_or().booleanValue())
				{
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 获得组合定价模式医嘱项目对应的费用医嘱项目集合数据信息
	 * @param aggdo
	 * @param ems
	 * @param ipos
	 * @return
	 * @throws BizException
	 */
	private ArrayList<OrdSrvDO> getSrvMm8CompPriSrv(CiorderAggDO aggdo,CiEmsDTO ems,Integer ipos) throws BizException{
		CiOrCreateSrvMm8CompPriSrv0BP bp=new CiOrCreateSrvMm8CompPriSrv0BP();
		return bp.exec(aggdo, ems, ipos);
	}
	
	/**
	 * 医疗单项目是否为组合定价模式的逻辑判断
	 * （非套 非套内项目的情形）
	 * 套的已经在套逻辑中处理了
	 * @param emssrvdto
	 * @return
	 * @throws BizException 
	 */
	private boolean isSrvCompPriMd(CiEmsSrvDTO emssrvdto) throws BizException{
		return CiOrdUtils.isSrvCompPriMd(emssrvdto);
	}
	/**
	 * 医嘱项目频次修正
	 * @param ordsrvdos
	 * @param id_freq
	 * @throws BizException
	 */
	private void ordSrvDOFreqMod(OrdSrvDO[] ordsrvdos,OrSrvSyncInfoDTO syncinfo) throws BizException{
		CiOrOrdSrvDOsFreqModBP bp=new CiOrOrdSrvDOsFreqModBP();
		bp.exec(ordsrvdos, syncinfo);
		
	}
	
	/**
	 * 医嘱项目频次修正
	 * @param ordsrvdos
	 * @param id_freq
	 * @throws BizException
	 */
	private void ordSrvDOFreqMod(ArrayList<OrdSrvDO> ordsrvdos,OrSrvSyncInfoDTO syncinfo) throws BizException{
		CiOrOrdSrvDOsFreqMod1BP bp=new CiOrOrdSrvDOsFreqMod1BP();
		bp.exec(ordsrvdos, syncinfo);
		
	}
	

}

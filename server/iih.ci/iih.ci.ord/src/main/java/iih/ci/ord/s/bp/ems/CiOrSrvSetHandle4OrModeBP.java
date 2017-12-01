package iih.ci.ord.s.bp.ems;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.OrSrvSyncInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.exception.CiOrSetMemCntAddPriMdSrvNullException;
import iih.ci.ord.s.bp.exception.CiOrSetMemCntPriMdSrvNullException;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;

/*
 * 临床医嘱服务套开立模式服务处理操作BP
 */
public class CiOrSrvSetHandle4OrModeBP {
	/**
	 * 临床医嘱服务套开立模式服务处理
	 * @param ciord
	 * @param ems
	 * @param srvsetitemindexs
	 * @param setsrvdo
	 * @param ht
	 * @return
	 * @throws BizException
	 */
	public  ArrayList<OrdSrvDO> exec(CiorderAggDO aggdo,CiEmsDTO ems,Integer[] srvsetitemindexs,MedSrvDO setsrvdo,Hashtable ht)  throws BizException{
		long startTime = System.currentTimeMillis();
		String id_srv_set=setsrvdo.getId_srv();
		int iN=CiOrdUtils.getSrvsetMemberValidCnt(ems, srvsetitemindexs);//srvsetitemindexs.length-1;
		MedSrvSetItemDO[] bdsrvinsetItems=CiOrdUtils.getBdSrvSetItems(id_srv_set);//查询套内已经启用的临床和非临床项目的集合
		MedSrvSetItemDO[] bdsrvinset = CiOrdUtils.getBdSrvSetItemsNotClinical(bdsrvinsetItems);//查询套内已经启用的非临床项目的集合
		Map<String,MedSrvSetItemDO> bdsrvinsetClinicalMap = CiOrdUtils.getBdSrvSetItemsClinicalMap(bdsrvinsetItems);//查询套内已经启用的非临床项目的集合
		Context.get().setAttribute("bdsrvinsetClinicalMap", bdsrvinsetClinicalMap);
		ArrayList<OrdSrvDO> srvdos=new ArrayList<OrdSrvDO>();
		boolean isSum=false;
		// 就诊上下文
		CiEnContextDTO context = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		
		Hashtable isGenerated=new Hashtable();
		if(CiOrdUtils.isSrvsetMemberSumPrimd(setsrvdo.getId_primd())){//成员合计  去0的srvsetitemindexs+非srvsetitemindexs+bdsrvinset   套逻辑bdsrvinset
			long tBeginTime = System.currentTimeMillis();
			//套合计部分的处理
			srvdos=createSrvMmInfo(aggdo,ems,srvsetitemindexs,ht,isGenerated,bdsrvinsetClinicalMap);//isSum=true;
			OrdBizLogger.info(context, String.format("保存医嘱[%s]，生成聚合结构——医嘱服务列表——成员合计,耗时:%s(ms)", setsrvdo.getName(),System.currentTimeMillis()-tBeginTime));
			
		}else if(CiOrdUtils.isSrvsetMemberCntPrimd(setsrvdo.getId_primd())){//成员个数定价 srvsetitemindexs对应服务+非srvsetitemindexs   套逻辑bdsrvinset
			long tBeginTime = System.currentTimeMillis();
			PriStdSrvDTO[] prisrvs=CiOrSrvPriCalUtils.CalSrvSetFIXPrices(id_srv_set,iN);
			if(!priStdSrvCheck(prisrvs)){throw new CiOrSetMemCntPriMdSrvNullException();}
			srvdos=createSrvMmInfos(aggdo,ems,srvsetitemindexs[0],prisrvs,1,Integer.toString(iN),isGenerated);
			agentOrSrvStatusMod4SetMemCntHandle(aggdo,srvdos); //2016-06-27 增加该逻辑
			OrdBizLogger.info(context, String.format("保存医嘱[%s]，生成聚合结构——医嘱服务列表——成员个数定价,耗时:%s(ms)", setsrvdo.getName(),System.currentTimeMillis()-tBeginTime));
			
		}else if(CiOrdUtils.isSrvsetMemCntAdditionalPrimd(setsrvdo.getId_primd())){//成员个数加收   srvsetitemindexs对应服务+非srvsetitemindexs   套逻辑bdsrvinset
			long tBeginTime = System.currentTimeMillis();
			PriStdSrvDTO[] prisrvs=CiOrSrvPriCalUtils.CalSrvSetMUPrices(id_srv_set,iN);
			if(!priStdSrvCheck(prisrvs)){throw new CiOrSetMemCntAddPriMdSrvNullException();}
			srvdos=createSrvMmInfos(aggdo,ems,srvsetitemindexs[0],prisrvs,iN,Integer.toString(iN),isGenerated);	
			agentOrSrvStatusMod4SetMemCntHandle(aggdo,srvdos); //2016-06-27 增加该逻辑
			OrdBizLogger.info(context, String.format("保存医嘱[%s]，生成聚合结构——医嘱服务列表——成员个数加收,耗时:%s(ms)", setsrvdo.getName(),System.currentTimeMillis()-tBeginTime));
		}else{
			//暂不存在  不处理
		}
		
		if(isGenerated(isGenerated))return null;//2016-08-18    费用页签逻辑增加 
		
		long tBeginTime = System.currentTimeMillis();
		//套内非临床项目处理  套内合计价时应为null
		ArrayList<OrdSrvDO> srvdos1=createSrvMmInfo4SetItems(aggdo.getParentDO(),ems,srvsetitemindexs,bdsrvinset,ht,isSum);
		srvdos1Handle(srvdos1,id_srv_set);
		OrdBizLogger.info(context, String.format("保存医嘱[%s]，生成聚合结构——医嘱服务列表——套内非临床,耗时:%s(ms)", setsrvdo.getName(),System.currentTimeMillis()-tBeginTime));
		
		//合并返回
		if(!(srvdos1==null || srvdos1.size()==0)){
			if(srvdos == null){
				srvdos=new ArrayList<OrdSrvDO>();
				srvdos.addAll(srvdos1);
			   }else{
				   srvdos.addAll(srvdos1);
			   }
			}
		ordSrvDOFreqMod(srvdos,CiOrdUtils.getOrSrvSyncInfo(aggdo.getParentDO().getId_freq(),null));//医嘱项目频次修正逻辑添加  2016-06-14
		CiOrdUtils.LogerOutInfo(" 临床医嘱服务套开立模式服务处理 CiOrSrvSetHandle4OrModeBP  的exec 耗时"+(System.currentTimeMillis()-startTime));
		return srvdos;
	}
	
	/**
	 * 是否已经生成过
	 * @param o
	 * @return
	 */
	private boolean isGenerated(Hashtable o){
		if(CiOrdUtils.isEmpty(o))return false;
		return true;
	}
	
	/**
	 * 根据ems服务物品信息生成医嘱项目集合（医嘱模式套合计处理逻辑）
	 */
	private ArrayList<OrdSrvDO> createSrvMmInfo(CiorderAggDO aggdo,CiEmsDTO ems,Integer[] indexes,Hashtable ht,Hashtable isGenerated) throws BizException{
		
		//生成医嘱项目信息
		CiOrCreateSrvMms8EmsBP bp=new CiOrCreateSrvMms8EmsBP();
		ArrayList<OrdSrvDO> rtn=bp.exec(aggdo, ems, indexes,ht);
		
		//空判断
		if(CiOrdUtils.isEmpty(rtn))return null;
		
		//组合定价模式的处理逻辑   这个逻辑是后期增加的2016-05-18新增逻辑分支
		long startTime = System.currentTimeMillis();
		ArrayList<OrdSrvDO> rtnComp=null;//getCiOrCompPriOrSrvs(aggdo,ems,indexes); // 2016-12-19 注释改代码，套内项目组合时，重复计算问题
		CiOrdUtils.LogerOutInfo("类 CiOrSrvSetHandle4OrModeBP 组合定价模式的处理逻辑 的方法 getCiOrCompPriOrSrvs耗时"+(System.currentTimeMillis()-startTime));
		if(CiOrdUtils.isEmpty(rtnComp))return rtn;
		
		//返回值处理
		rtn.addAll(rtnComp);
		return rtn;
	}
	private ArrayList<OrdSrvDO> createSrvMmInfo(CiorderAggDO aggdo,CiEmsDTO ems,Integer[] indexes,Hashtable ht,Hashtable isGenerated,Map<String,MedSrvSetItemDO> bdsrvinsetClinicalMap) throws BizException{
		
		//生成医嘱项目信息
		CiOrCreateSrvMms8EmsBP bp=new CiOrCreateSrvMms8EmsBP();
		ArrayList<OrdSrvDO> rtn=bp.exec(aggdo, ems, indexes,ht,bdsrvinsetClinicalMap);
		
		//空判断
		if(CiOrdUtils.isEmpty(rtn))return null;
		
		//组合定价模式的处理逻辑   这个逻辑是后期增加的2016-05-18新增逻辑分支
		long startTime = System.currentTimeMillis();
		ArrayList<OrdSrvDO> rtnComp=null;//getCiOrCompPriOrSrvs(aggdo,ems,indexes); // 2016-12-19 注释改代码，套内项目组合时，重复计算问题
		CiOrdUtils.LogerOutInfo("类 CiOrSrvSetHandle4OrModeBP 组合定价模式的处理逻辑 的方法 getCiOrCompPriOrSrvs耗时"+(System.currentTimeMillis()-startTime));
		if(CiOrdUtils.isEmpty(rtnComp))return rtn;
		
		//返回值处理
		rtn.addAll(rtnComp);
		return rtn;
	}
	/**
	 * 根据定价模式返回的价格服务生成医嘱项目
	 * @param aggdo
	 * @param ems
	 * @param setindex
	 * @param prisrvs
	 * @param quan
	 * @return
	 * @throws BizException
	 */
	private ArrayList<OrdSrvDO> createSrvMmInfos(CiorderAggDO aggdo,CiEmsDTO ems,Integer setindex,PriStdSrvDTO[] prisrvs,Integer quan,String priby,Hashtable isGenerated) throws BizException{
		//有效性检查
		if(CiOrdUtils.isEmpty(prisrvs))return null;
		
		//参数设置
		ArrayList<OrdSrvDO> rtn=new ArrayList<OrdSrvDO>();
		long startTime = System.currentTimeMillis();
		//下面一行代码注释原因：2016-11-11  代码优化 改进   每个查询耗时将近50ms多  将这部分代码调整到入口参数中以便做批量查询
		//批量查询时，比如10个服务查询时间基本上也是稳定在50ms多一点
		//CiOrCreateSrvMm8CalSrvBP bp = new CiOrCreateSrvMm8CalSrvBP();
		CiOrCreateSrvMm8CalSrvNBP bp = new CiOrCreateSrvMm8CalSrvNBP();  //调优新增   2016-11-11
		MedSrvDO[] medsrvdos=CiOrdUtils.getMedSrvInfoDOs(prisrvs);//调优新增   2016-11-11
		OrdSrvDO orsrvdo;
		
		
		//2016-08-01 新增逻辑 主要为费用页签使用 还是有漏洞
		if(EmsHelper.isEmsSrvsGenerated(ems, aggdo.getParentDO().getId_srv(), new Integer[]{OrSrvSourceFromEnum.AGENTFROMPRIMD},priby)){
			isGenerated.put("1", "1");
			return  rtn;
		}
		

		//遍历
		for(int i=0;i<prisrvs.length;i++){
			if(CiOrdUtils.isEmpty(prisrvs[i].getId_srv()))continue;
			
			//bp=new CiOrCreateSrvMm8CalSrvBP();
			orsrvdo= bp.exec(aggdo, ems, setindex, prisrvs[i],medsrvdos[i],quan,priby);	//orsrvdo= bp.exec(aggdo, ems, setindex, prisrvs[i],quan,priby);	//调优调整   2016-11-11	
			if(CiOrdUtils.isEmpty(orsrvdo))continue;
			rtn.add(orsrvdo);
		}

		CiOrdUtils.getlogger().info("根据组合定价模式返回的价格服务生成医嘱项目（仅对套的情形） 耗时"+( System.currentTimeMillis()-startTime));
		//返回
		return rtn;
	}
	
	/**
	 * 根据定价模式返回的价格服务生成医嘱项目
	 * @param ordo
	 * @param ems
	 * @param setindex
	 * @param prisrv
	 * @param quan
	 * @return
	 * @throws BizException
	 */
	private OrdSrvDO createSrvMmInfo(CiorderAggDO aggdo,CiEmsDTO ems,Integer setindex,PriStdSrvDTO prisrv,Integer quan) throws BizException{
		CiOrCreateSrvMm8CalSrvBP bp=new CiOrCreateSrvMm8CalSrvBP();
		return bp.exec(aggdo, ems, setindex, prisrv, quan,"");
	}
	
	
	/**
	 * 根据套内非临床标识服务生成医嘱项目集合（仅对套的情形）
	 * 套内合计价时则直接返回
	 * @param ordo
	 * @param ems
	 * @param setindex
	 * @param bdsrvinset
	 * @return
	 * @throws BizException
	 */
	private ArrayList<OrdSrvDO> createSrvMmInfo4SetItems(CiOrderDO ordo,CiEmsDTO ems,Integer[] setindex,MedSrvSetItemDO[] bdsrvinset,Hashtable ht,boolean isSum) throws BizException{
		if(isSum)return null;//套内合计价时则返回
		CiOrCreateSrvMm8SetItemBP bp=new CiOrCreateSrvMm8SetItemBP();
		return bp.exec(ordo, ems, setindex, bdsrvinset,ht);
	}
	
	/**
	 * 套对应价格服务存在性检查
	 * @param prisrv
	 * @return
	 */
	private boolean priStdSrvCheck(PriStdSrvDTO prisrv){
		if(CiOrdUtils.isEmpty(prisrv))return false;
		if(CiOrdUtils.isEmpty(prisrv.getId_srv()))return false;
		return true;
	}
	
	/**
	 * 套对应价格服务存在性检查
	 * @param prisrv
	 * @return
	 */
	private boolean priStdSrvCheck(PriStdSrvDTO[] prisrvs){
		if(CiOrdUtils.isEmpty(prisrvs))return false;
		int iN=0;
		for(int i=0;i<prisrvs.length;i++){
			if(CiOrdUtils.isEmpty(prisrvs[i].getId_srv())){
				return false;
			}else{
				iN+=1;
			}
		}
		if(iN==0)return false;
		return true;
	}
	
	/**
	 * 创建组合定价模式医嘱项目对应的医嘱项目
	 * @param aggdo
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	private ArrayList<OrdSrvDO> getCiOrCompPriOrSrvs(CiorderAggDO aggdo,CiEmsDTO ems,Integer[] indexes) throws BizException{
		//有效性校验
		if(ems==null || ems.getEmssrvs()==null || ems.getEmssrvs().size()==0)return null;
		ArrayList<OrdSrvDO> rtnlist=new ArrayList<OrdSrvDO>();
		ArrayList<OrdSrvDO> rtnTmp=null;
		
		//遍历
		for(int i=1;i<indexes.length;i++){
			
			//服务项目组合定价模式逻辑判断
			CiEmsSrvDTO emssrvdto=(CiEmsSrvDTO)ems.getEmssrvs().get(indexes[i]);
			if(!isSrvCompPriMd(emssrvdto))continue;
			
			//2016-08-01 新增逻辑 主要为费用页签使用 还是有些漏洞
			if(EmsHelper.isEmsSrvsGenerated(ems, emssrvdto.getId_srv(), new Integer[]{OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD},null)){
				continue;
			}
			
			//组合定价模式处理
			long startTime = System.currentTimeMillis();
			rtnTmp=getSrvMm8CompPriSrv(aggdo,ems,i);
			CiOrdUtils.LogerOutInfo("类 CiOrSrvSetHandle4OrModeBP 组合定价模式处理 耗时  "+(System.currentTimeMillis() -startTime));
			if(!CiOrdUtils.isEmpty(rtnTmp)){
				ordSrvDOFreqMod(rtnTmp,CiOrdUtils.getOrSrvSyncInfo(aggdo.getParentDO().getId_freq(),emssrvdto.getFg_or()));
				rtnlist.addAll(rtnTmp);
			}
		}
		
		return rtnlist;
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
	
	/**
	 * 套成员计价派生医嘱项目状态修改
	 * @param aggdo
	 * @param srvdos
	 */
	private void agentOrSrvStatusMod4SetMemCntHandle(CiorderAggDO aggdo,ArrayList<OrdSrvDO> srvdos){
		ArrayList<OrdSrvDO> delorsrvs=CiOrdUtils.agentOrSrvStatusMod4SetMemCntHandle(aggdo);
		if(CiOrdUtils.isEmpty(delorsrvs))return;
		srvdos.addAll(delorsrvs);
	}
	
	/**
	 * 套内项目设置套id
	 * @param srvdos1
	 * @param id_srv_set
	 */
	private void srvdos1Handle(ArrayList<OrdSrvDO> srvdos1,String id_srv_set){
		if(CiOrdUtils.isEmpty(srvdos1))return;
		for(int i=0;i<srvdos1.size();i++){
			srvdos1.get(i).setId_srv_src(id_srv_set);
		}
	}
	
	private MedSrvDO getsrv8idsrv(MedSrvDO[] medsrvdos,String id_srv){

		for (MedSrvDO medSrvDO : medsrvdos) {
			if(medSrvDO.getId_srv().equals(id_srv)){
				return medSrvDO;
			}
		}
		return null;
	}

}

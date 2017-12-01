package iih.ci.ord.s.bp.ems;

import java.util.ArrayList;
import java.util.Hashtable;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.EnumFlow;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.d.MedSrvRelMmDO;
import iih.bd.srv.medsrv.d.MedSrvRelMmDTO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.ci.ord.ciordems.d.QuantumParamDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.emsdi.d.ExeDeptCalParamDTO;
import iih.ci.ord.emsdi.d.ExeWhDeptDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 根据套内非临床标识服务生成医嘱项目集合操作BP（仅对套的情形）
 */
public class CiOrCreateSrvMm8SetItemBP {
	/**
	 * 根据套内非临床标识服务生成医嘱项目集合
	 * @param ordo
	 * @param ems
	 * @param setindex
	 * @param bdsrvinset
	 * @return
	 * @throws BizException
	 */
	public  ArrayList<OrdSrvDO> exec(CiOrderDO ordo,CiEmsDTO ems,Integer[] setindex,MedSrvSetItemDO[] bdsrvinset,Hashtable ht)  throws BizException{
		//有效性校验
		if(bdsrvinset==null || bdsrvinset.length==0)return null;
		//参数设置
		ArrayList<OrdSrvDO> list=new ArrayList<OrdSrvDO>();
		CiEmsSrvDTO setsrv=(CiEmsSrvDTO)ems.getEmssrvs().get(setindex[0]);
		MedSrvDO srvinsetdo=null;
		MedSrvSetItemDO tmpdo=null;
		OrdSrvDO srvdo=null;
		OrdSrvItemDatum datum=null;
		String id_srv="";
		String id_dept_set="";
		
		//遍历
		for(int i=0;i<bdsrvinset.length;i++){
			
			tmpdo=bdsrvinset[i];
			if(isSrvSetItemHandled(tmpdo.getId_srv_itm(),ems,setindex))continue; //2016-06-23 新增逻辑 以去除重复处理的情况
			//判断套内的非费用项是否已经处理过 zwq 2017-1-12
			if(EmsHelper.isEmsSrvsGenerated(ems.getEmssrvs(),ems.getId_srv(),tmpdo.getId_srv_itm()).booleanValue()) continue ;
			srvinsetdo=CiOrdAppUtils.getMedsrvMDORService().findById(tmpdo.getId_srv_itm());
			
			//创建医嘱项目项目相关数据信息
			datum=createOrdSrvDO(ordo,ems,srvinsetdo,setsrv,tmpdo);
			
			//获得医嘱项目DO数据并进行有效性判断
			srvdo=datum.getSrvdo();
			if(datum.getSrvdo()==null)continue;
			id_srv=datum.getSrvdo().getId_srv();
			
			//医嘱项目对应物品记录处理
			CiOrAttachInfoUtils.addOrdSrvMmDO(ht, id_srv, datum.getSrvmm());
			
			//医嘱项目对应变动用药处理
			CiOrAttachInfoUtils.addOrdSrvDoseDOs(ht, id_srv, datum.getSrvdoses());

			//添加到列表中
			list.add(srvdo);
			
		}
		
		return list;
	}
	
	/**
	 * 获得最近医嘱生成日期
	 * @param id_freq
	 * @param dt_effe
	 * @param firstdaytimes
	 * @return
	 * @throws BizException
	 */
	private FDateTime getLastDt(String id_freq,FDateTime dt_effe,Integer firstdaytimes,FBoolean fg_long) throws BizException{
		CiOrDtLastBlCal4OpenBP bp=new CiOrDtLastBlCal4OpenBP();
		return bp.exec(id_freq, dt_effe, firstdaytimes,fg_long);
	}
	
	/**
	 * 获得服务价格
	 * @param id_srv
	 * @param id_primd
	 * @return
	 * @throws BizException
	 */
	private FDouble getPrice(String id_srv,String id_primd) throws BizException{
		CiOrCalSrvPriceBP bp=new CiOrCalSrvPriceBP();
		return bp.exec(id_srv, id_primd);
	}
	

	/**
	 * 创建医嘱项目相关信息
	 * @param ordo
	 * @param ems
	 * @param srvinsetdo
	 * @param setsrv
	 * @param tmpdo
	 * @return
	 * @throws BizException
	 */
	private OrdSrvItemDatum createOrdSrvDO(CiOrderDO ordo,CiEmsDTO ems,MedSrvDO srvinsetdo,CiEmsSrvDTO setsrv,MedSrvSetItemDO tmpdo) throws BizException{
		OrdSrvItemDatum datum=new OrdSrvItemDatum();
		MedSrvRelMmDTO srvrelmmdo=null;
		OrdSrvDO srvdo=new OrdSrvDO(); 
				
		//srvdo.setId_orsrv(srvdto.getId_orsrv());
		//srvdo.setId_or(srvdto.getId_or());
		//srvdo.setId_pres(srvdto.getId_pres());
		srvdo.setId_pat(ordo.getId_pat());
		srvdo.setId_entp(ordo.getId_entp());
		srvdo.setCode_entp(ordo.getCode_entp());
		srvdo.setId_en(ordo.getId_en());
		//srvdo.setSortno(srvdto.getSortno());
		if(CiOrdUtils.isEmpty(srvinsetdo)){
			throw new BizException("套内明细项目在基础数据中不存在！");
		}
		srvdo.setId_srvtp(srvinsetdo.getId_srvtp());
		srvdo.setSd_srvtp(srvinsetdo.getSd_srvtp());
		srvdo.setId_srv(srvinsetdo.getId_srv());
		srvdo.setName(srvinsetdo.getName());
		srvdo.setFg_dose_anoma(FBoolean.FALSE);
		srvdo.setQuan_medu(tmpdo.getQuan_medu());
		
		srvdo.setId_medu(tmpdo.getId_medu());
		srvdo.setId_route(tmpdo.getId_route());
		srvdo.setId_routedes(tmpdo.getId_routedes());
		srvdo.setId_boil(tmpdo.getId_boil());
		srvdo.setId_boildes(tmpdo.getId_boildes());
		srvdo.setId_freq(ordo.getId_freq());
		
		srvdo.setId_org_srv(ordo.getId_org_or());
		srvdo.setId_dep_srv(ordo.getId_dep_or());
		srvdo.setId_wg_or(ordo.getId_wg_or());
		srvdo.setId_emp_srv(ordo.getId_emp_or());
		srvdo.setDt_create(ordo.getDt_entry());
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		//srvdo.setDt_last_mp(srvdto.getDt_last_mp());
		srvdo.setDt_last_cg(getLastDt(setsrv.getId_freq(),ordo.getDt_effe(),ems.getTimes_firday_mp(),ordo.getFg_long()));
		srvdo.setDt_last_bl(getLastDt(setsrv.getId_freq(),ordo.getDt_effe(),ems.getTimes_firday_mp(),ordo.getFg_long()));
		srvdo.setFg_or(FBoolean.FALSE);
		srvdo.setEu_blmd(srvinsetdo.getEu_blmd());  //本服务定价
		srvdo.setFg_mm(srvinsetdo.getFg_mm());
		srvdo.setFg_set(FBoolean.FALSE);
		//srvdo.setFg_indic(srvdto.getFg_indic());
		srvdo.setFg_propc(FBoolean.FALSE);
		srvdo.setFg_self(FBoolean.FALSE);
		srvdo.setFg_pres_outp(FBoolean.FALSE);
		srvdo.setNote_srv("");
		srvdo.setId_srvca(srvinsetdo.getId_srvca());
		srvdo.setFg_bl(CiOrdUtils.nullHandle(srvinsetdo.getFg_bl()));
		srvdo.setCode_srv(srvinsetdo.getCode());
		srvdo.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
		srvdo.setId_primd(srvinsetdo.getId_primd());//zwq 2016-08-18添加
		if(OrSrvSplitUtil.isTrue(srvdo.getFg_mm())){srvrelmmdo=CiOrdUtils.getSrvRelDefaultMmDTO(srvinsetdo.getId_srv(), srvdo.getId_dep_srv());}
		ExeWhDeptDTO exeandwhdeptinfo=null;  //2016-07-28  新执行科室逻辑调整    调整到新的时将如下语句进行对应处理
		if(srvdo.getId_dep_mp()== null){
			exeandwhdeptinfo=getMpDeptID(ordo,ems,srvinsetdo,tmpdo,srvrelmmdo);  //待打开
			srvdo.setId_org_mp(exeandwhdeptinfo.getId_org_mp());   //待打开
			srvdo.setId_dep_mp(exeandwhdeptinfo.getId_dep_mp());   //待打开
			srvdo.setId_dep_wh(exeandwhdeptinfo.getId_dep_wh());   //待打开
			//srvdo.setId_dep_mp(CiOrdUtils.getMpDeptID(ems,srvdo));   //调整到最后
		}else{
			//srvdo.setId_dep_mp(setsrv.getId_dep()); 
			//srvdo.setId_dep_wh(setsrv.getId_dep_wh());
		}
		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
		MaterialUnitDTO[] materials=null;
		if(OrSrvSplitUtil.isTrue(srvdo.getFg_mm())){
			IMaterialBaseInfoService materService = ServiceFinder.find(IMaterialBaseInfoService.class);
			materials = materService.getMMunitByEntp(new String[]{srvrelmmdo.getId_mm()}, 
					IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		}
		if(CiOrdUtils.isOpMode(ems.getCode_entp(), ems.getFg_pres_outp(),srvdo.getSd_srvtp()).booleanValue()){
			CalQuantumBP bp = new CalQuantumBP();
			if(!CiOrdUtils.isEmpty(srvinsetdo.getFg_mm())&&srvinsetdo.getFg_mm().booleanValue()){
				if(!CiOrdUtils.isEmpty(materials)&&materials.length>0){
					srvdo.setQuan_total_medu(bp.getMMQuantum(srvrelmmdo.getSd_opmutp(), srvinsetdo.getQuan_med(), srvrelmmdo.getFactor_mb(), materials[0].getFactor(), ems.getTimes_cur()));
				}
				//srvdo.setQuan_total_medu(bp.getMMQuantum(ems.getCode_entp(), ems.getFg_pres_outp(), ems.getTimes_cur(), srvrelmmdo.getId_mm(), materials[0].getId_measdoc(),srvinsetdo.getQuan_med()));
			}else{
				srvdo.setQuan_total_medu(bp.getQuantum(srvinsetdo.getQuan_med(), ems.getTimes_cur()));
			}
		}
		srvdo.setFg_feertnable(FBoolean.TRUE);	
		srvdo.setStatus(DOStatus.NEW);	
		srvdo.setId_or(ordo.getId_or());
		//医保信息
		srvdo.setId_hp(setsrv.getId_hp());
		srvdo.setId_hpsrvtp(setsrv.getId_hpsrvtp());
		srvdo.setSd_hpsrvtp(setsrv.getSd_hpsrvtp());
		srvdo.setName_hpsrvtp(setsrv.getName_hpsrvtp());
		
		srvdo.setId_grp(CiOrdAppUtils.getEnvContext().getGroupId()); // 集团id
		srvdo.setId_org(CiOrdAppUtils.getEnvContext().getOrgId()); // 组织id
		datum.setSrvdo(srvdo);
		//医嘱项目对应的物品处理  todo
		//需要修改添加 物品绑定时机  开立  执行 
		if(OrSrvSplitUtil.isTrue(srvdo.getFg_mm())){
			OrdSrvMmDO ordsrvmmdo=createCiOrdSrvMmDO(srvdo,srvinsetdo,srvrelmmdo,setsrv.getDays_available(),materials);
			datum.setSrvmm(ordsrvmmdo);
		}else{
			CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(ems.getCode_entp(),srvdo.getId_srv(),srvdo.getId_primd(),srvdo);
		}
		
		//变动用药处理  应该是不存在这个情况
		
		return datum;
	}
	
	private FDouble getOrSrvQuanMed(CiEmsDTO ems,Integer ipos,OrdSrvDO srvdo){
		if(CiOrdUtils.isEmpty(ems.getTimes_cur())){
			FDouble quan_cur = ((CiEmsSrvDTO)ems.getEmssrvs().get(0)).getQuan_cur();
			if(quan_cur!=null){
				return quan_cur.multiply(srvdo.getQuan_medu());
			}else{
				Integer freqct = ((CiEmsSrvDTO)ems.getEmssrvs().get(ipos)).getFreqct();
				freqct = freqct==null?1:freqct;
				Integer days = (ems.getDays_or()==null||ems.getDays_or()==0)?1:ems.getDays_or();
				return new FDouble(freqct.doubleValue()*days.doubleValue()).multiply(srvdo.getQuan_medu());
			}
			
		}else{
			return srvdo.getQuan_medu().multiply(ems.getTimes_cur());
		}
	}
	/**
	 * 创建医嘱项目对应的物品DO信息
	 * @param srvdo
	 * @param bdsrvdo
	 * @return
	 * @throws BizException 
	 */
	private OrdSrvMmDO createCiOrdSrvMmDO(OrdSrvDO srvdo,MedSrvDO bdsrvdo,MedSrvRelMmDTO srvrelmmdo, Integer days_available,MaterialUnitDTO[] materials) throws BizException{
		//MedSrvRelMmDTO srvrelmmdo=CiOrdUtils.getSrvRelDefaultMmDTO(bdsrvdo.getId_srv(), srvdo.getId_dep_srv());
		MeterialDO mmdo=null;
		MedSrvDrugDO medSrvDrugDO =null;
		//medSrvDrugDO =   CiOrdAppUtils.getIMedSrvDrugDORService().findById(bdsrvdo.getId_srv());
		medSrvDrugDO =    CiOrdUtils.getBdSrvDrugDO(bdsrvdo.getId_srv());
		if(srvrelmmdo!=null){mmdo=CiOrdAppUtils.getMaterialQryService().findById(srvrelmmdo.getId_mm());}
		if(mmdo==null)return null;
		  
		OrdSrvMmDO srvmmdo=new OrdSrvMmDO();
		
		//srvmmdo.setId_orsrvmm();
		//srvmmdo.setId_orsrv();
		srvmmdo.setId_mm(mmdo.getId_mm());
		srvmmdo.setCode_mm(mmdo.getCode());
		srvmmdo.setName_mm(mmdo.getName());
		if(materials!=null&&materials.length>0){
			srvmmdo.setId_pgku_cur(materials[0].getId_measdoc());
			srvmmdo.setPrice_pgku_cur(getMaterialStockPrice(srvdo.getId_dep_wh(),mmdo.getId_mm(),srvmmdo.getId_pgku_cur()));
		}
		//srvmmdo.setQuan_cur(srvdto.getQuan_cur());
		srvmmdo.setId_pgku_base(mmdo.getId_unit_pkgbase());
		int[] numben=OrSrvSplitUtil.getNumDen(bdsrvdo.getQuan_med(), mmdo.getFactor_mb());
		srvmmdo.setQuan_num_base(numben[0]);
		srvmmdo.setQuan_den_base(numben[1]);
		srvmmdo.setQuan_cur(srvdo.getQuan_total_medu());
		//srvmmdo.setQuan_bed_medu(srvdto.getQuan_bed_medu());
		srvmmdo.setFactor(mmdo.getFactor_sb());
		srvmmdo.setFactor_mb(mmdo.getFactor_mb());
		 
		srvmmdo.setId_dosage(medSrvDrugDO.getId_dosage());
		srvmmdo.setSd_dosage(medSrvDrugDO.getSd_dosage());
		srvmmdo.setId_pharm(medSrvDrugDO.getId_pharm());
		srvmmdo.setSd_pharm(medSrvDrugDO.getSd_pharm());
		srvmmdo.setId_val(mmdo.getId_val());
		srvmmdo.setSd_val(mmdo.getSd_val());
		srvmmdo.setId_pois(medSrvDrugDO.getId_pois());
		srvmmdo.setSd_pois(medSrvDrugDO.getSd_pois());
		srvmmdo.setId_anti(medSrvDrugDO.getId_anti());
		srvmmdo.setSd_anti(medSrvDrugDO.getSd_anti());
		srvmmdo.setId_mmtp(mmdo.getId_mmtp());
		srvmmdo.setSd_mmtp(mmdo.getSd_mmtp());
		//srvmmdo.setId_antipsy(mmdo.getId_antipsy());  //暂时没有这个概念
		//srvmmdo.setSd_antipsy(mmdo.getSd_antipsy());
		//srvmmdo.setFg_otc(mmdo.getFg_otc()); //物品中需要增加此字段
		srvmmdo.setDays_available(days_available);
		srvmmdo.setStatus(DOStatus.NEW);
		
		return srvmmdo;
	}
	
	/**
	 * 获得价格  结存量信息
	 * @param id_dep
	 * @param id_mm
	 * @param id_unit
	 * @return
	 * @throws BizException
	 */
	private FDouble  getMaterialStockPrice(String id_dep,String id_mm,String id_unit)  throws BizException{
		CiOrGetMmPriceBP bp=new CiOrGetMmPriceBP();
		return bp.exec(id_dep, id_mm, id_unit);
	}
	
	/**
	 * 套内非临床项目是否已经被处理过
	 * 主要是成员合计价时的处理逻辑
	 * @param id_set_itm_srv
	 * @param ems
	 * @param setindex
	 * @return
	 */
	private boolean isSrvSetItemHandled(String id_set_itm_srv,CiEmsDTO ems,Integer[] setindex){
		if(CiOrdUtils.isEmpty(ems))return true;
		FArrayList list=ems.getEmssrvs();
		if(CiOrdUtils.isEmpty(list))return false;
		CiEmsSrvDTO emssrvdto=null;
		
		for(int i=0;i<setindex.length;i++){
			emssrvdto=(CiEmsSrvDTO)list.get(setindex[i]);
			if(id_set_itm_srv.equals(emssrvdto.getId_srv())&&emssrvdto.getStatus()!=DOStatus.DELETED)return true;
		}
		
		return false;
	}
	
	/**
	 * 获得执行科室数据信息
	 * @param ordo
	 * @param ems
	 * @param srvinsetdo
	 * @param tmpdo
	 * @param srvrelmmdo
	 * @return
	 * @throws BizException
	 */
	private ExeWhDeptDTO getMpDeptID(CiOrderDO ordo,CiEmsDTO ems,MedSrvDO srvinsetdo,MedSrvSetItemDO tmpdo,MedSrvRelMmDTO srvrelmmdo) throws BizException{
		ExeDeptCalParamDTO param=getExeDeptCalParamDTO(ordo,ems,srvinsetdo,tmpdo,srvrelmmdo);
		return CiOrdUtils.getMpDeptID(param);
	}
	
	/**
	 * 获得执行科室计算参数信息DTO
	 * @param ordo
	 * @param ems
	 * @param srvinsetdo
	 * @param tmpdo
	 * @param srvrelmmdo
	 * @return
	 */
	private ExeDeptCalParamDTO getExeDeptCalParamDTO(CiOrderDO ordo,CiEmsDTO ems,MedSrvDO srvinsetdo,MedSrvSetItemDO tmpdo,MedSrvRelMmDTO srvrelmmdo){
		ExeDeptCalParamDTO paramdto=new ExeDeptCalParamDTO();
		paramdto.setCode_entp(ems.getCode_entp());
		paramdto.setId_dep_en(ems.getId_dept_en());
		paramdto.setId_dep_or(ems.getId_dep_phy());
		paramdto.setId_dep_ns(ems.getId_dept_ns());
		paramdto.setId_dep_exe(ordo.getId_dep_mp());
		paramdto.setFg_long(ems.getFg_long());
		paramdto.setId_srv(tmpdo.getId_srv_itm());
		if(!CiOrdUtils.isEmpty(srvrelmmdo)){
		paramdto.setId_mm(srvrelmmdo.getId_mm());}
		paramdto.setSd_srvtp(srvinsetdo.getSd_srvtp());
		paramdto.setId_srvca(srvinsetdo.getId_srvca());
		paramdto.setInnercode_srvca(srvinsetdo.getSrvca_innercode());
		paramdto.setId_route(tmpdo.getId_route());
		paramdto.setDt_effe(ordo.getDt_effe());
		//paramdto.setDef1();
		//paramdto.setDef2();
		paramdto.setDef3(tmpdo.getSd_mpdepcalmd()+CiOrdUtils.COMMA_STR+tmpdo.getId_dep_mp()+CiOrdUtils.COMMA_STR+ordo.getId_dep_mp());
		//paramdto.setDef4();
		//paramdto.setDef5();
		if(!CiOrdUtils.isTrue(srvinsetdo.getFg_mm())){
			paramdto.setEu_wftp(EnumFlow.EXECUTEFLOW);  //只求执行科室
		}else{
			paramdto.setEu_wftp(EnumFlow.NULL);   //求物资流向科室
		}
		
		return paramdto;
	}
}

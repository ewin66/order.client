package iih.ci.ord.s.ems.biz.op.ems.def;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.bdprisamp.d.BdPriSampDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.i.IMedSrvLisDORService;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.ciordems.d.EmsObsItemDO;
import iih.ci.ord.ciordems.d.EmsObsLap;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParamList;
import iih.ci.ord.s.ems.biz.meta.ObjectList;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvList;
import iih.ci.ord.s.ems.biz.utils.BdSrvInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderUtils;
import iih.ci.ord.s.ems.define.StringList;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 默认检验医嘱创建逻辑
 * @author wangqingzhu
 *
 */
public class DefaultLisCreateOrderInfo extends DefaultSetCreateOrderInfo{
	
	
	@Override
	public OrderPackageInfo[] createOrderPakageInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam) throws BizException {
		// TODO Auto-generated method stub
		OrderPackageInfo[] szOrderPakageInfo = super.createOrderPakageInfo(ctx, szParam);
		
//		for (OrderPackageInfo opInfo : szOrderPakageInfo){
//			ObjectList appSheetList=new ObjectList();
//			appSheetList.add(assembleOrderApLisInfo(ctx,(EmsObsItemDO)opInfo.getUiModel(),opInfo.getOrderInfo().getId_or()));
//			opInfo.setOrderAppSheetList(appSheetList);
//			opInfo.getOrderSrvMmList().append(specimenTpRelSrvHandle(opInfo,ctx).asArray());
//		}

//		获取检验申请单id_srv与agg对应map
				Map<String,OrdApLabDO> ordApLabDOMap=new HashMap<String,OrdApLabDO>();
				MedSrvLisDO[] srvlisdos= ServiceFinder.find(IMedSrvLisDORService.class).findByAttrValStrings("Id_srv", 
						new DefaultCreateParamList(szParam).asIdSrvArray());
				
				for(MedSrvLisDO srvlis:srvlisdos){
					ordApLabDOMap.put(srvlis.getId_srv(), assembleOrderLisInfo(srvlis));
				}
				//放回检验申请单信息
				for(OrderPackageInfo info:szOrderPakageInfo){
					String id_srv=info.getOrderInfo().getId_srv();
					if(ordApLabDOMap.containsKey(id_srv)){
					ObjectList appSheetList=new ObjectList();
						OrdApLabDO ordApLabDO = ordApLabDOMap.get(id_srv);
						ordApLabDO.setId_or(info.getOrderInfo().getId_or());
						appSheetList.add(ordApLabDO);
						info.setOrderAppSheetList(appSheetList);
						info.getOrderSrvMmList().append(specimenTpRelSrvHandle(info,ordApLabDO.getSd_samptp(),ordApLabDO.getSd_contp(),ctx).asArray());
		}

				}
		
		return szOrderPakageInfo;
	}




	public OrdApLabDO assembleOrderLisInfo(MedSrvLisDO srvlis){
		OrdApLabDO ordlis=new OrdApLabDO();
		ordlis.setStatus(DOStatus.NEW);
		//		ordlis.setId_orlab();//医嘱检验申请主键标识	
		//		ordlis.setId_or();//医嘱	
		//		ordlis.setId_di();//临床诊断	
		//		ordlis.setId_diitm();//临床诊断子项
		//		ordlis.setStr_id_diitm();//临床诊断明细
		//		ordlis.setStr_code_di();//诊断编码拼接
		//		ordlis.setStr_name_di();//诊断名称拼接
		//		ordlis.setNo_applyform();//申请单号	
		//		ordlis.setId_srvca(id_srvca);//检验分类	
		//		ordlis.setSd_pps();//检验目的编码
		//		ordlis.setDt_plan();//计划检验日期
		//		ordlis.setId_pps();//检验目的	
		//		ordlis.setDes_pps();//检验目的描述	
		ordlis.setId_su_lab(ICiDictCodeConst.ID_CI_LAB_SQ);//检验过程状态	
		ordlis.setSd_su_lab(ICiDictCodeConst.SD_CI_LAB_SQ);//检验过程状态编码
		//		ordlis.setDes_sympsign();//病情描述	
		//		ordlis.setClinicalzztz();//临床症状及体征
		//		ordlis.setPastillness();//既往病史 
		//		ordlis.setAuximtexam();//其它检查所见 
		//		ordlis.setAnnouncements();//注意事项 
		//		ordlis.setFg_urgent();//加急标识	 
		ordlis.setId_samptp(srvlis.getId_samptp());//标本类型	 
		ordlis.setSd_samptp(srvlis.getSd_samptp());//标本类型编码	 
		ordlis.setQuan(srvlis.getQuan());//标本需求量	 
		ordlis.setSd_colltp(srvlis.getSd_colltp());//采集方法	 
		ordlis.setId_colltp(srvlis.getId_colltp());//采集方法编码	 
		ordlis.setDes_labsamp(srvlis.getDes_labsamp());//标本说明	 	
		ordlis.setSd_contp(srvlis.getSd_contp());//容器编码 
		ordlis.setId_contp(srvlis.getId_contp());//容器	 
		ordlis.setId_unit_quan(srvlis.getId_unit_sampcoltime());//需求数量单位	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	a0b14
		//		ordlis.setName_diag();//诊断名称		 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
		ordlis.setId_sampcoltime(srvlis.getId_sampcoltime());//标本采集时间	REF	标本
		ordlis.setId_sampcollecttimetp(srvlis.getId_sampcollecttimetp());//标本采集时间类型	
		ordlis.setSd_sampcollecttimetp(srvlis.getSd_sampcollecttimetp());//标本采集时间类型编码
		ordlis.setLen_sampcoltime(srvlis.getLen_sampcoltime());//标本采集时长	SINGLE	
		ordlis.setId_unit_sampcoltime(srvlis.getId_unit_sampcoltime());//标本采集时间时长单位
		//		ordlis.setFg_prn();//打印标识	
		//		ordlis.setCnt_prn();//打印次数	
		ordlis.setId_labgroup(srvlis.getId_labgroup());//检验分组	
		ordlis.setSd_labgroup(srvlis.getSd_labgroup());//检验分组编码
		return ordlis;
	}


	/**
	 * 创建检验申请单DO模型对象
	 * @param ctx
	 * @param emsLis
	 * @return
	 */
	protected OrdApLabDO assembleOrderApLisInfo(CiEnContextDTO ctx, EmsObsItemDO emsLis,String id_or){
		OrdApLabDO lab = new OrdApLabDO();
		lab.setStatus(DOStatus.NEW);
		lab.setId_or(id_or);
		 lab.setId_di (emsLis.getId_di());
         lab.setName_diag(emsLis.getName_diag());
         lab.setId_diitm ( emsLis.getId_diitm());
         lab.setStr_code_di ( emsLis.getStr_code_di());
         lab.setStr_id_diitm ( emsLis.getStr_id_diitm());
         lab.setStr_name_di ( emsLis.getStr_name_di());
         lab.setNo_applyform( emsLis.getNo_applyobs());
         lab.setFg_urgent( emsLis.getFg_urgent());
         lab.setDt_plan ( emsLis.getDt_plan());
         lab.setId_pps ( emsLis.getId_pps());
         lab.setSd_pps ( emsLis.getSd_pps());
         lab.setDes_pps( emsLis.getDes_pps());
         lab.setSd_pps (emsLis.getSd_pps());
         //lab.setDes_pps( emsLis.getName_pos());// ??
         lab.setDes_sympsign ( emsLis.getDes_sympsign());
         lab.setName_samptp(emsLis.getName_samptp());
         lab.setSd_samptp ( emsLis.getSd_samptp());
         lab.setId_samptp ( emsLis.getId_samptp());
         lab.setDes_labsamp ( emsLis.getDes_labsamp());
         //标本采集时间
         lab.setId_sampcoltime( emsLis.getId_sampcoltime());//标本采集时间
         lab.setId_sampcollecttimetp( emsLis.getId_sampcollecttimetp());//标本采集时间类型
         lab.setSd_sampcollecttimetp( emsLis.getSd_sampcollecttimetp());//标本采集时间类型编码
         lab.setLen_sampcoltime( emsLis.getLen_sampcoltime());//标本采集时长
         lab.setId_unit_sampcoltime( emsLis.getId_unit_sampcoltime());//标本采集时间时长单位
         lab.setCreatedby( ctx.getId_emp_or());
         lab.setId_su_lab( ICiDictCodeConst.ID_CI_LAB_SQ);
         lab.setSd_su_lab ( ICiDictCodeConst.SD_CI_LAB_SQ);
         // 
        
         lab.setId_srvca ( emsLis.getId_srvca());
         if (!CiOrdUtils.isEmpty(emsLis.getEmsOrObsListEx()) )
         {
        	 EmsObsLap emsObsLap = (EmsObsLap)emsLis.getEmsOrObsListEx().get(0);
             lab.setAnnouncements ( emsObsLap.getAnnouncements());
             lab.setQuan ( emsObsLap.getQuan());
             lab.setId_unit_quan ( emsObsLap.getId_quan());
             lab.setSd_contp ( emsObsLap.getSd_contp());
             lab.setId_contp ( emsObsLap.getId_contp());
             lab.setSd_colltp ( emsObsLap.getSd_colltp());
             lab.setId_colltp ( emsObsLap.getId_colltp());
             lab.setId_labgroup ( emsObsLap.getId_labgroup());
             lab.setSd_labgroup ( emsObsLap.getSd_labgroup());
         }
         return lab;
	}

	

	/**
	 * 标本、容器关联费用
	 * @param opInfo
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public OrderSrvList specimenTpRelSrvHandle(OrderPackageInfo opInfo,String Sd_samptp,String Sd_contp,CiEnContextDTO ctx) throws BizException {
		//标本关联费用
		BdPriSampDO[] bdPriSampDOs=OrderUtils.getSpecimenTpRelFeeSrvInfo(Sd_samptp, ctx.getId_org());
//		//容器关联费用
		Map<String, Object> vesselMap=OrderUtils.getLisSrvVesselTpRelFeeSrvInfo(Sd_contp, ctx.getId_org(),
				ctx.getCode_entp());
		OrderSrvList orderSrvInfoList = new OrderSrvList();
		StringList idsrvs=new StringList();
		if(!CiOrdUtils.isEmpty(bdPriSampDOs)){
			for(BdPriSampDO bdPriSampDO:bdPriSampDOs){
				idsrvs.add(bdPriSampDO.getId_srv());
			}
		}
		
		if(!CiOrdUtils.isEmpty(vesselMap) && !CiOrdUtils.isEmpty(vesselMap.get("id_srv"))){

			idsrvs.add(vesselMap.get("id_srv").toString());
		}
		if(CiOrdUtils.isEmpty(idsrvs))return null;
		MedSrvDO[] medsrvs=BdSrvInfoUtils.QueryBdSrvInfo(idsrvs.asArray());

		if(CiOrdUtils.isEmpty(medsrvs))return null;
		int index=(CiOrdUtils.isEmpty(opInfo.getOrderSrvList())?0:opInfo.getOrderSrvList().length);
		for(MedSrvDO medsrv:medsrvs){
			BdSrvMmInfo bdSrvMmInfo=new BdSrvMmInfo();
			bdSrvMmInfo.setBdSrvInfo(medsrv);
			OrdSrvDO ordsrvdo=assembleOrderSrvInfo(ctx, opInfo.getOrderInfo(),bdSrvMmInfo, index);
			if(!CiOrdUtils.isEmpty(vesselMap) && !CiOrdUtils.isEmpty(vesselMap.get("id_srv")) && medsrv.getId_srv().equals(vesselMap.get("id_srv"))){
				ordsrvdo.setEu_sourcemd(OrSrvSourceFromEnum.SPECIMENVESSELRELFEE);

			}else{
				ordsrvdo.setEu_sourcemd(OrSrvSourceFromEnum.SPECIMENRELFEE);

			}
			orderSrvInfoList.add(ordsrvdo);
			index++;
		}
		return orderSrvInfoList;
	}
	



}

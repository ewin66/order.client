/**
 * 
 */
package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendInpBillParamDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLOrderAppendBillService;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiordInviteConsDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.mp.nr.foreign.i.IForeignService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @ClassName: SaveCompleteConsultAggDOBP
 * @Description: 完成会诊信息
 * @author Comsys-li_zheng
 * @date 2016年6月21日 下午3:30:28
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class SaveCompleteConsultAggDOBP {

	
	public  CiorappconsultAggDO   exe(CiorappconsultAggDO[] aggdos) throws BizException{
		if(aggdos == null || aggdos.length==0) throw new BizException("会诊信息为空");
		CiorappconsultAggDO agg = aggdos[0];
		Map map = new HashMap();
		if(agg != null){
		   CiordInviteConsDO[] inviteCons = agg.getCiordInviteConsDO();
		    //医嘱信息
		   CiorderAggDO oraggdos = CiOrdAppUtils.getOrAggQryService().findById(agg.getParentDO().getId_or());
		   if(inviteCons != null && inviteCons.length >0){
			   for(CiordInviteConsDO  invite:inviteCons){
				   //不参加会诊的
				   if(!invite.getFg_join_cons().booleanValue()){
					   map.put(invite.getId_dep(), agg.getParentDO().getId_or());
				   }
			   }
			   // 删除不参加会诊的科室
			   getCiSrvDODelete(oraggdos, map);
		   }
		   /*5)	更新执行状态（CI_ORDER. sd_su_mp=4已执行，医嘱下所有的SRV都更新为已执行
		    * CI_OR_SRV.sd_su_mp=4 执行完成）。
		    * （如果医嘱是未执行的，那么转科和出院核查时会校验出来，护士会要求医生来点这个按钮）。
		    */
		   //UpdateOrderSdMp(oraggdos);
		   //保存医嘱信息
		  /* oraggdos.getParentDO().setId_su_or(ICiDictCodeConst.SD_SU_ID_FINISH);
		   oraggdos.getParentDO().setSd_su_or(ICiDictCodeConst.SD_SU_FINISH);
		   oraggdos.getParentDO().setStatus(DOStatus.UPDATED);
		   CiOrdAppUtils.getOrAggService().save(new CiorderAggDO[]{oraggdos});*/
		   
		   // 更新执行的状态
		 
		   IForeignService service = ServiceFinder.find(IForeignService.class);
		   String[] id_ors = new  String[] {oraggdos.getParentDO().getId_or()};
		   service.ConsultationOrHandle(id_ors);
		   
	      /* 6)	调用费用记账接口，插入收费记录。*/
		   SetOrderAppendBill_ByCi(oraggdos);
		  
		   // 会诊完成
		   agg.getParentDO().setSd_su_cons(ICiDictCodeConst.SD_CI_CONS_HZWC);
		   agg.getParentDO().setId_su_cons(ICiDictCodeConst.ID_CI_CONS_HZWC);
		   CiOrdAppUtils.getICiorappconsultCudService().save(aggdos);
		}
		return aggdos[0];
	}
	
	/**
	 * 不参加会诊的医嘱项目 删除
	 * @param oraggdos
	 * @param map
	 * @throws BizException
	 */
	private void getCiSrvDODelete(CiorderAggDO oraggdos,Map map) throws BizException{
		if(oraggdos != null && oraggdos.getOrdSrvDO().length >0 && map.size() >0){
			for(OrdSrvDO srvdo:oraggdos.getOrdSrvDO()){
	    		if(map != null && map.size() >0){
	    			if(map.containsKey(srvdo.getId_dep_mp()))
	    			{
	    				srvdo.setStatus(DOStatus.DELETED);
	    			}
	    		}
	    	}
		}
	}
	
	/**
	 * 更新医嘱状态
	 * @param oraggdosICiDictCodeConst
	 * @throws BizException
	 */
	private void  UpdateOrderSdMp(CiorderAggDO oraggdos)throws BizException{
		if(oraggdos != null){
			oraggdos.getParentDO().setSd_su_mp("4");
			oraggdos.getParentDO().setSd_su_or(ICiDictCodeConst.SD_SU_ID_CHECKTHROUGH);
			oraggdos.getParentDO().setId_su_or(ICiDictCodeConst.SD_SU_ID_CHECKTHROUGH);
		}
	}
	/**
	 * 费用接口
	 * @param oraggdos
	 * @throws BizException
	 */
	private void SetOrderAppendBill_ByCi(CiorderAggDO oraggdos)throws BizException{
		IBLOrderAppendBillService service =ServiceFinder.find(IBLOrderAppendBillService.class);
		
		if(service != null){
			
	    	OperatorInfoDTO info = new OperatorInfoDTO();
	    	BlOrderAppendBillParamDTO[] param= setParam(info,oraggdos);
	    	if(param==null) return;
	    	String   code_enttp  = oraggdos.getParentDO().getCode_entp();
	    	String  Id_pripat = param[0].getId_pripat();
	    	service.SetOrderAppendBill_ByCi(param, info, code_enttp,Id_pripat);
	    }
	}
	
	/**
	 * 费用的参数设置
	 * @param param
	 * @param info
	 * @param oraggdos
	 */
	private BlOrderAppendBillParamDTO[]  setParam(OperatorInfoDTO info,CiorderAggDO oraggdos)throws BizException{
		/*1.id_pat,
		id_enttp,
		code_enttp,
		id_srv,
		quan,
		eu_direct(Ci填1),
		id_org_mp,
		id_dep_mp,
		id_or,
		id_orsrv
		必填,其他字段可省;*/
		List<BlOrderAppendBillParamDTO> param = null;
		if(oraggdos != null && oraggdos.getOrdSrvDO().length >0){
			IPativisitRService pativService = ServiceFinder.find(IPativisitRService.class);
			PatiVisitDO entDO = pativService.findById(oraggdos.getParentDO().getId_en());
			 int i =0;
			 param = new ArrayList<BlOrderAppendBillParamDTO>();
			for(OrdSrvDO srvDO:oraggdos.getOrdSrvDO()){
				if(srvDO.getStatus() !=DOStatus.DELETED && srvDO.getFg_bl() != null && srvDO.getFg_bl().booleanValue()){
					BlOrderAppendBillParamDTO paramDTO = new BlOrderAppendBillParamDTO();
					BlOrderAppendInpBillParamDTO  dto = new BlOrderAppendInpBillParamDTO();
					paramDTO.setId_or(oraggdos.getParentDO().getId_or());
					paramDTO.setId_pat(oraggdos.getParentDO().getId_pat());
					paramDTO.setId_enttp(oraggdos.getParentDO().getId_entp());
					paramDTO.setCode_enttp(oraggdos.getParentDO().getCode_entp());
					paramDTO.setId_srv(srvDO.getId_srv());
					paramDTO.setId_org_mp(srvDO.getId_org_mp()); 
					paramDTO.setId_dep_mp(srvDO.getId_dep_mp());
					paramDTO.setId_orsrv(srvDO.getId_orsrv());
					paramDTO.setQuan(srvDO.getQuan_medu());
					paramDTO.setId_ent(srvDO.getId_en());
					paramDTO.setSupportAppendBill(FBoolean.FALSE);
					paramDTO.setEu_direct(1);
					paramDTO.setSrcfunc_des(iih.bl.cg.service.udi.IBlCgCodeConst.IpDocStationCharge);
					paramDTO.setId_pripat(entDO.getId_pripat());
					dto.setId_dep_nur(srvDO.getId_dep_nur_srv());
					paramDTO.setDt_or(oraggdos.getParentDO().getDt_effe());
					paramDTO.setInpBillDTO(dto);
					param.add(paramDTO);
					i++;
				}
			}
		}
		info.setId_dep(oraggdos.getParentDO().getId_dep_or());
		info.setId_grp(oraggdos.getParentDO().getId_grp());
		info.setId_org(oraggdos.getParentDO().getId_org());
		info.setId_org_emp(oraggdos.getParentDO().getId_emp_or());
		 
		
	 return param.size()==0?null:param.toArray(new BlOrderAppendBillParamDTO[param.size()]);	 
	}
}

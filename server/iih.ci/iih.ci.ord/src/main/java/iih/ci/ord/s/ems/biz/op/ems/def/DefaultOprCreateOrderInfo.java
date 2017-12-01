package iih.ci.ord.s.ems.biz.op.ems.def;

import iih.bd.srv.medsrv.d.MedSrvOpDO;
import iih.bd.srv.medsrv.i.IMedSrvOpDORService;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParamList;
import iih.ci.ord.s.ems.biz.meta.ObjectList;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 默认手术医嘱创建逻辑
 * @author wangqingzhu
 *
 */
public class DefaultOprCreateOrderInfo extends DefaultSingleSrvCreateOrderInfo {
	
	
	@Override
	public OrderPackageInfo[] createOrderPakageInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam) throws BizException {
		// TODO Auto-generated method stub
		OrderPackageInfo[] szOrderPakageInfo =  super.createOrderPakageInfo(ctx, szParam);
		//获取手术申请单id_srv与agg对应map
		Map<String,CiorappsurgeryAggDO> opMap=new HashMap<String,CiorappsurgeryAggDO>();
		MedSrvOpDO[] srvopdos= ServiceFinder.find(IMedSrvOpDORService.class).findByAttrValStrings(MedSrvOpDO.ID_SRV, 
				new DefaultCreateParamList(szParam).asIdSrvArray());
		if(srvopdos.length==0) return szOrderPakageInfo;
		for(MedSrvOpDO srvcons:srvopdos){
			CiorappsurgeryAggDO ordopagg=assembleOrderOpAggInfo(srvcons);
			opMap.put(srvcons.getId_srv(), ordopagg);
		}
		//放回手术申请单信息
		for(OrderPackageInfo info:szOrderPakageInfo){
			String id_srv=info.getOrderInfo().getId_srv();
			if(opMap.containsKey(id_srv)){
				ObjectList agglist=new ObjectList();
				agglist.add(opMap.get(id_srv));
				info.setOrderAppSheetList(agglist);
			}
		}
		return szOrderPakageInfo;
	}




	public CiorappsurgeryAggDO assembleOrderOpAggInfo(MedSrvOpDO srvop){
		CiorappsurgeryAggDO aggdo=new CiorappsurgeryAggDO();
		OrdApOpDO ordop=creatOrdOpInfo(srvop);
		aggdo.setParentDO(ordop);		
		return aggdo;
		
	}

	private OrdApOpDO creatOrdOpInfo(MedSrvOpDO srvop){
		OrdApOpDO ordop=new OrdApOpDO();
//		ordop.setId_apop();
//		ordop.setId_or(srvop.getId_or());
//		ordop.setId_di(srvop.getId_di());	
//		ordop.setStr_id_diitm(srvop.getStr_id_diitm());
//		ordop.setStr_code_di(srvop.getStr_code_di());
//		ordop.setStr_name_di(srvop.getStr_name_di());
//		ordop.setNo_applyform(srvop.getNo_applyform());
//		ordop.setDt_plan(srvop.getDt_plan());
//		ordop.setSugplantime(srvop.get);//???
		ordop.setId_lvlsug(srvop.getId_opclass());
		ordop.setSd_lvlsug(srvop.getSd_opclass());
//		ordop.setId_anestp(srvop.getId_anestp());
//		ordop.setSd_anestp(srvop.getSd_anestp());
		ordop.setId_incitp(srvop.getId_incitp());
		ordop.setSd_incitp(srvop.getSd_incitp());
//		ordop.setFg_allergy(srvop.getFg_allergy());
//		ordop.setFg_patho(srvop.getFg_patho());
//		ordop.setId_su_op(srvop.getId_su());
//		ordop.setSd_su_op(srvop.getSd_su());
//		ordop.setAnnouncements(srvop.getAnnouncements());
		ordop.setId_srv(srvop.getId_srv());
//		ordop.setId_srv_code(srv_code);
//		ordop.setQuan_bt_paln(srvop.getQuan_bt_plan());
//		ordop.setId_emp_operate(srvop.getId_emp_operator());	
//		ordop.setId_emp_helper(srvop.getId_emp_help1());
//		ordop.setId_sugbody(srvop.getid);
//		ordop.setSd_sugbody(srvop.ge);
//		ordop.setSpecialreq(srvop.getSpecialreq());
//		ordop.setSpecialinstrument(srvop.getSpecialinstrument());	
//		ordop.setSpecialdes(srvop.getSpecialdes());
//		ordop.setFg_er_sug(srvop.getFg_er_sug());
//		ordop.setFg_xq_sug(srvop.getFg_xq_sug());
//		ordop.setFg_zq_sug(srvop.getFg_zq_sug());
		ordop.setFg_new_sug(srvop.getFg_new_sug());
//		ordop.setName_diag(srvop.getName_diag());
//		ordop.setId_diitm(srvop.getId_diitm());
//		ordop.setFg_prn();
//		srvop.setCnt_prn();
//		srvop.setId_didef_relstd(ordop.getid_d);//???	
		ordop.setStatus(DOStatus.NEW);
		return ordop;
	}
	
	
}

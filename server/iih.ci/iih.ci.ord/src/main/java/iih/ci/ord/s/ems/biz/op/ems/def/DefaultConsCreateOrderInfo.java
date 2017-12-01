package iih.ci.ord.s.ems.biz.op.ems.def;

import java.util.HashMap;
import java.util.Map;


import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvConsDO;
import iih.bd.srv.medsrv.i.IMedSrvConsDORService;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.OrdApConsDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.ObjectList;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.define.StringList;

/**
 * 默认会诊医嘱创建逻辑
 * @author wangqingzhu
 *
 */
public class DefaultConsCreateOrderInfo extends DefaultBaseCreateOrderInfo {

	
	
	@Override
	public OrderPackageInfo[] createOrderPakageInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam) throws BizException {
		// TODO Auto-generated method stub
		OrderPackageInfo[] szOrderPakageInfo =  super.createOrderPakageInfo(ctx, szParam);
		//获取会诊申请单id_srv与agg对应map
		
		StringList listId_srv = new StringList();
		for (DefaultCreateParam p : szParam){
			listId_srv.add(p.getMainSrvInfo().getBdSrvInfo().getId_srv());
		}
		Map<String,CiorappconsultAggDO> consMap=new HashMap<String,CiorappconsultAggDO>();
		Map<String,MedSrvConsDO> medcons=new HashMap<String,MedSrvConsDO>();//会诊属性表map
		MedSrvConsDO[] srvconsdos= getMedsrvConsdo(listId_srv.toArray(new String[listId_srv.size()]));
		if(srvconsdos.length==0) return szOrderPakageInfo;
		for(MedSrvConsDO srvcons:srvconsdos){
			CiorappconsultAggDO ordconsagg=assembleOrderConsAggInfo(srvcons);
			consMap.put(srvcons.getId_srv(), ordconsagg);
			medcons.put(srvcons.getId_srv(), srvcons);
		}
		//放回会诊申请单信息
		for(OrderPackageInfo info:szOrderPakageInfo){
			String id_srv=info.getOrderInfo().getId_srv();
			if(consMap.containsKey(id_srv)){
				ObjectList agglist=new ObjectList();
				agglist.add(consMap.get(id_srv));
				info.setOrderAppSheetList(agglist);
				
			}
			//放入会诊基础数据属性表
			if(medcons.containsKey(id_srv)){
				ObjectList conslist=new ObjectList();
				conslist.add(medcons.get(id_srv));
				info.setExtInfoList(conslist);
			}
		}
		return szOrderPakageInfo;
	}



	/**
	 * 获取会诊申请单agg
	 * @param srvcons
	 * @return
	 */
	private CiorappconsultAggDO assembleOrderConsAggInfo(MedSrvConsDO srvcons){
		CiorappconsultAggDO aggdo=new CiorappconsultAggDO();
		OrdApConsDO consdo= creatOrdConsInfo(srvcons);
		aggdo.setParentDO(consdo);
		return aggdo;
	}
	/**
	 * 会诊申请单主表映射
	 * @param srvcons
	 * @return
	 */
	private OrdApConsDO creatOrdConsInfo(MedSrvConsDO srvcons){
		OrdApConsDO consdo=new OrdApConsDO();
		
//		consdo.setId_apcons();
//		consdo.setId_or();
//		consdo.setNo_applyform();
		consdo.setId_constp(srvcons.getId_constp());
		consdo.setSd_constp(srvcons.getSd_constp());
//		consdo.setDt_ap(ems.getDt_creat());	
//		consdo.setTel(srvcons.getTel());
//		consdo.setDes_emr(ems.getDes_emr());
//		consdo.setDt_plan(ems.getDt_plan());
//		consdo.setPlace(ems.getName_place());	
//		consdo.setDes_psp(ems.getDes_psp());
		if(FBoolean.TRUE.equals(srvcons.getFg_audit_clidep())){
			consdo.setId_su_cons(ICiDictCodeConst.ID_CI_CONS_DKSSP);
			consdo.setSd_su_cons(ICiDictCodeConst.SD_CI_CONS_DKSSP);
		}else{
			consdo.setId_su_cons(ICiDictCodeConst.ID_CI_CONS_DKSYD);
			consdo.setSd_su_cons(ICiDictCodeConst.SD_CI_CONS_DKSYD);
		}
		
//		consdo.setFg_urgent(ems.getFg_urgent());
//		consdo.setDes_dep(ems.getDes_dep());//--
//		consdo.setDt_constimelimit(srvcons.get);
		consdo.setFg_audit_clidep(srvcons.getFg_audit_clidep());
		consdo.setFg_audit_admdep(srvcons.getFg_audit_admdep());
		FDateTime time=new FDateTime();
		
//		consdo.setFg_prn();
//		consdo.setCnt_prn();
		consdo.setStatus(DOStatus.NEW);

		
		return consdo;
	}
	/**
	 * 获取服务会诊属性
	 * @param id_srvs
	 * @return
	 * @throws BizException
	 */
	private MedSrvConsDO[] getMedsrvConsdo(String[] id_srvs) throws BizException{
		
		return ServiceFinder.find(IMedSrvConsDORService.class).findByAttrValStrings(MedSrvConsDO.ID_SRV, id_srvs);
	}

}

package iih.ci.ord.s.ems.biz.op.ems.def;

import java.util.HashMap;
import java.util.Map;

import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.i.IMedSrvLisDORService;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.OrdApPathgyDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParamList;
import iih.ci.ord.s.ems.biz.meta.ObjectList;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 默认病理医嘱创建逻辑
 * @author wangqingzhu
 *
 */
public class DefaultPathgyCreateOrderInfo extends DefaultSingleSrvCreateOrderInfo {
	

	
	@Override
	public OrderPackageInfo[] createOrderPakageInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam) throws BizException {
		// TODO Auto-generated method stub
		OrderPackageInfo[] szOrderPakageInfo = super.createOrderPakageInfo(ctx, szParam);
		//获取病理申请单id_srv与agg对应map
		Map<String,CiorapppathgyAggDO> consMap=new HashMap<String,CiorapppathgyAggDO>();
		MedSrvLisDO[] srvpathdos= ServiceFinder.find(IMedSrvLisDORService.class).findByAttrValStrings("Id_srv", 
				new DefaultCreateParamList(szParam).asIdSrvArray());
		if(srvpathdos.length==0) return szOrderPakageInfo;
		for(MedSrvLisDO srvpathdo:srvpathdos){
			consMap.put(srvpathdo.getId_srv(), assembleOrderPathgyAggInfo(srvpathdo));
		}
		//放回病理申请单信息
		for(OrderPackageInfo info:szOrderPakageInfo){
			String id_srv=info.getOrderInfo().getId_srv();
			if(consMap.containsKey(id_srv)){
				ObjectList agglist=new ObjectList();
				agglist.add(consMap.get(id_srv));
				info.setOrderAppSheetList(agglist);
			}
		}
		return szOrderPakageInfo;
	}



	public CiorapppathgyAggDO assembleOrderPathgyAggInfo(MedSrvLisDO srvris){
		CiorapppathgyAggDO aggdo=new CiorapppathgyAggDO();
		OrdApPathgyDO pathgydo=creatOrdPathgyInfo(srvris);
		aggdo.setParentDO(pathgydo);
		return aggdo;
	}
	
	private OrdApPathgyDO creatOrdPathgyInfo(MedSrvLisDO srvris){
		OrdApPathgyDO ordpath=new OrdApPathgyDO();
//		ordpath.setId_or();
//		ordpath.setNo_applyform();
		ordpath.setId_samptp(srvris.getId_samptp());
		ordpath.setSd_samptp(srvris.getSd_samptp());
		ordpath.setName_samptp(srvris.getSamptp_name());
		ordpath.setQuan(Integer.parseInt(srvris.getQuan().toString()));
		ordpath.setId_colltp(srvris.getId_colltp());
		ordpath.setSd_colltp(srvris.getSd_colltp());
		ordpath.setName_cooltp(srvris.getColltp_name());
		ordpath.setDes_labsamp(srvris.getDes_labsamp());
//		ordpath.setFg_urgent(srvris.getFg_urgent());
//		ordpath.setId_di(srvris.getId_di());
//		ordpath.setStr_code_di(srvris.getStr_code_di());
//		ordpath.setStr_name_di(srvris.getStr_name_di());
//		ordpath.setName_diag(srvris.getName_diag());
//		ordpath.setId_diitm(srvris.getId_diitm());
//		ordpath.setStr_id_diitm(srvris.getStr_id_diitm());
//		ordpath.setAnnouncements(srvris.getAnnouncements());
//		ordpath.setDes_sympsign(srvris.getDes_sympsign());
//		ordpath.setFg_outer(srvris.getFg_outer());
//		ordpath.setNo_pathgy_old(srvris.getNo_pathgy_old());
//		ordpath.setDt_pathgy_old(srvris.getDt_pathgy_old());
//		ordpath.setDi_pathgy_old(srvris.getName_di_pathgy_old());
//		ordpath.setOrg_pathgy_old(srvris.getOrg_pathgy_old());
//		ordpath.setCollectdes(srvris.getCollectdes());
//		ordpath.setId_emp(srvris.getId_emp_coll());
//		ordpath.setName_coll_emp(srvris.getName_emp_coll());
//		ordpath.setId_dep(srvris.getId_dep_coll());
//		ordpath.setName_dep(srvris.getName_dep_coll());
//		ordpath.setDt_coll(srvris.getDt_coll());
//		ordpath.setId_su_pathgy(ICiDictCodeConst.ID_SU_PATHGY_YSQ);
//		ordpath.setSd_su_pathgy(ICiDictCodeConst.SD_SU_PATHGY_YSQ);
//		ordpath.setName_su("已申请");
//		ordpath.setNo_pathgy(srvris.getNo_pathgy());
//		ordpath.setDt_rptpathgy(srvris.getDt_rptpathgy());
		//		ordpath.setFg_prn(Fg_prn);//---
		//		ordpath.setCnt_prn(Cnt_prn);//---
		ordpath.setStatus(DOStatus.NEW);
		return ordpath;
	}
	
}

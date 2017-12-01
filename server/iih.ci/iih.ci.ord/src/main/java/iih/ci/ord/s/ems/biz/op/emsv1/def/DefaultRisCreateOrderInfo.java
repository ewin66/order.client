package iih.ci.ord.s.ems.biz.op.emsv1.def;

import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.i.IMedSrvRisDORService;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.ciordems.d.EmsObsItemDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParamList;
import iih.ci.ord.s.ems.biz.meta.ObjectList;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

public class DefaultRisCreateOrderInfo extends DefaultSetCreateOrderInfo {
	
	
	
	@Override
	public OrderPackageInfo[] createOrderPakageInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam) throws BizException {
		// TODO Auto-generated method stub
		OrderPackageInfo[] szOrderPakageInfo =  super.createOrderPakageInfo(ctx, szParam);
		
		for (OrderPackageInfo opInfo : szOrderPakageInfo){
			ObjectList appSheetList=new ObjectList();
			appSheetList.add(assembleOrderApRisInfo(ctx,(EmsObsItemDO)opInfo.getUiModel(),opInfo.getOrderInfo().getId_or()));
			opInfo.setOrderAppSheetList(appSheetList);
		}
		
		
		return szOrderPakageInfo;
	}

	

	/**
	 * 生成检查申请单DO模型对象（废弃）
	 * @param srvris
	 * @return
	 */
	@Deprecated
	public OrdApObsDO assembleOrderRisInfo(MedSrvRisDO srvris){
		OrdApObsDO ordris=new OrdApObsDO();
		ordris.setStatus(DOStatus.NEW);
		ordris.setId_orobs(this.generatePks());//医嘱检查申请单主键标识	
//		ordris.setId_or(orderInfo.getId_or());//医嘱	
//		ordris.setId_di();//临床诊断	
//		ordris.setName_diag();//诊断名称	
//		ordris.setStr_code_di();//诊断编码拼接
//		ordris.setStr_name_di();//诊断名称拼接
//		ordris.setNo_applyform();//申请单号	
//		ordris.setDt_plan();//计划检查日期	
//		ordris.setBiopsy();//检查组织描述	
//		ordris.setDes_sympsign();//病情描述	
//		ordris.setClinicalzztz();//临床症状及体征
//		ordris.setPastillness();//既往病史	
//		ordris.setAuximtexam();//其它检查所见
//		ordris.setFg_urgent();//加急标识	
		ordris.setAnnouncements	(srvris.getNote());//注意事项	
//		ordris.setId_pps(srvris.getid);//检查目的	
//		ordris.setSd_pps();//检查目的编码	
//		ordris.setDes_pps();//检查目的描述	
		ordris.setId_su_obs(ICiDictCodeConst.ID_CI_OBS_SQ);//检查申请状态	
		ordris.setSd_su_obs(ICiDictCodeConst.SD_CI_OBS_SQ);//
//		ordris.setStr_id_diitm();//临床诊断Id字符串	
//		ordris.setId_diitm();//诊断子项id	
//		ordris.setFg_prn();//打印标识	
//		ordris.setCnt_prn();//打印次数	
//		ordris.setId_body(srvris.getId_body());//检查部位	
//		ordris.setSd_body(srvris.getSd_body());//检查部位编码
//		ordris.setId_pos(srvris.getId_pos());//检查体位	
//		ordris.setSd_pos(srvris.getSd_pos());//检查体位编码
//		ordris.setFg_mp_bed();//床旁执行标识
		return ordris;
	}
	
	/**
	 * 生成检查申请单DO模型对象
	 * @param ctx
	 * @param emsRis
	 * @return
	 */
	protected OrdApObsDO assembleOrderApRisInfo(CiEnContextDTO ctx, Object objEmsRis, String id_or){
		EmsObsItemDO emsRis = (EmsObsItemDO)objEmsRis;
		OrdApObsDO obs = new OrdApObsDO();
		obs.setStatus(DOStatus.NEW);
		obs.setId_or(id_or);
		//诊断信息拼接
        obs.setName_diag ( emsRis.getName_diag());
        obs.setId_di ( emsRis.getId_di());
        obs.setId_diitm ( emsRis.getId_diitm());
        obs.setStr_code_di ( emsRis.getStr_code_di());
        obs.setStr_name_di ( emsRis.getStr_name_di());
        obs.setStr_id_diitm ( emsRis.getStr_id_diitm());

        obs.setNo_applyform ( emsRis.getNo_applyobs());
        obs.setDt_plan ( emsRis.getDt_plan());
        obs.setBiopsy ( emsRis.getName_body());
        obs.setFg_urgent ( emsRis.getFg_urgent());
       
        obs.setAnnouncements ( emsRis.getAnnouncements());
        obs.setId_pps ( emsRis.getId_pps());//todo
        obs.setSd_pps ( emsRis.getSd_pps());
        obs.setDes_pps ( emsRis.getDes_pps());
      
        obs.setDes_sympsign ( emsRis.getDes_sympsign());
        //拓展字段
        for(int index = 1; index < 31; ++index){
        	obs.setAttrVal(String.format("Def%d", index), emsRis.getAttrVal(String.format("Def%d", index)));
        }
        
        obs.setClinicalzztz ( emsRis.getClinicalzztz());
        obs.setPastillness ( emsRis.getPastillness());
        obs.setAuximtexam ( emsRis.getAuximtexam());
        obs.setId_su_obs ( ICiDictCodeConst.ID_CI_OBS_SQ);//TODO: 取sd字段
        obs.setSd_su_obs ( ICiDictCodeConst.SD_CI_LAB_SQ);
        
        return obs;
	}
}

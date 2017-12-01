package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciprn.i.ICiprintExtService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.bp.validate.OpSignBackOrValidateBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;

/*
 * 门诊已签署未核对临床医嘱的签署撤回处理操作BP
 */
public class CiOderSignBack4OpBP {
	/**
	 * 门诊已签署未核对临床医嘱的签署撤回处理
	 * 
	 * @param id_en
	 * @throws BizException
	 */
	public CiOrderDO[] exec(String[] ids) throws BizException {

		// 获得患者医嘱信息
		CiOrderDO[] ciors = CiOrdAppUtils.getOrQryService().findByBIds(ids, FBoolean.FALSE);
		if (ciors == null)
			new BizException("ciOrderDO is null  没有查询到数据");
		
		String id_en = ciors[0].getId_en();

		// 医嘱有效性判断
		OpSignBackOrValidateBP bp1 = new OpSignBackOrValidateBP();
		bp1.exec(ciors);

		// 获取需要修改和删除的session
		OpLatelySessionOrsGetBP bp = new OpLatelySessionOrsGetBP();
		bp.exec(id_en, ids);

		// 清医嘱项目中处方标识
		MOdOrdsrv4PresBP modsrvbp = new MOdOrdsrv4PresBP();
		modsrvbp.exec(ids);

		// 医嘱状态修改
		UpdateOrdStatusInfo1BP bp4 = new UpdateOrdStatusInfo1BP();
		bp4.exec(ciors, null, ICiDictCodeConst.SD_SU_OPEN);
		//撤回时，如果存在服务已经判断过特殊病标志，应该将特殊病标志设置为N未判断状态
		this.resetSpecill(ids);
		
		//删除打印数据
		deleteCiPrintData(ids);
		
		//执行患者核对信息的删除
	    //CiOrdUtils.delOrSrvAgentInfoDO(ids);
		for (CiOrderDO ord : ciors) {
			//IE集成平台需要使用的数据 begin
			 ord.setFg_sign(FBoolean.TRUE);
			 ord.setFg_chk(FBoolean.FALSE);
			 ord.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
			 ord.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
//			 ord.setCode_entp(p.getCode_entp());
//			 ord.setSd_srvtp(p.getSd_srvtp());
			 //end
		}
		CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_SIGN2OPEN_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, ciors);
//		CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_AGAIN_NEW, IEventType.TYPE_UPDATE_AFTER, ciors);

		// ICiEventConst.CIOR_STATUS_EVENT_SOURCEID 2016-08-26forlc

		return ciors;
	}
	
	/**
	 * 删除打印数据
	 * @param ids
	 * @throws BizException
	 */
	private void deleteCiPrintData(String[] ids) throws BizException{
		ICiprintExtService service=ServiceFinder.find(ICiprintExtService.class);
		service.DeleteAppLisData(ids);
		service.DeleteAppRisData(ids);
		service.DeleteAppPathgyData(ids);
		service.DeleteFeeBillsData(ids);
		service.DeleteTreateExecData(ids);
	}

	/**
	 * 获得医嘱主DO数组
	 * 
	 * @param aggors
	 * @return
	 */
	private CiOrderDO[] getCiOrderDOs(CiorderAggDO[] aggors) {
		CiOrderDO[] rtns = new CiOrderDO[aggors.length];
		for (int i = 0; i < aggors.length; i++) {
			rtns[i] = aggors[i].getParentDO();
		}
		return rtns;
	}
	/**
	 * 重置特殊病标志
	 * @param id_ors_temp
	 * @throws BizException 
	 */
	private void resetSpecill(String[] id_ors_temp) throws BizException {
		if(CiOrdUtils.isEmpty(id_ors_temp)||id_ors_temp.length==0)return;
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < id_ors_temp.length; i++){
		 sb. append(",'"+id_ors_temp[i]+"'");
		}
		OrdSrvDO[] ordSrvDOs = CiOrdAppUtils.getOrSrvQryService().find(String.format("id_or in (%s) and fg_specill='Y'", sb.toString().substring(1)), "", FBoolean.FALSE);
		
		if(ordSrvDOs.length>0){
			for(OrdSrvDO srv : ordSrvDOs){
				srv.setFg_specill(FBoolean.FALSE);
			}
			CiOrdAppUtils.getOrSrvService().update(ordSrvDOs);
		}
	}
}

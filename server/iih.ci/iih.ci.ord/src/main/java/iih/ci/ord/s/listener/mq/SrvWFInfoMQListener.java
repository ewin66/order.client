package iih.ci.ord.s.listener.mq;

import java.util.Map;

import iih.bd.srv.medsrv.d.desc.MedSrvDODesc;
import iih.bd.srv.oth.d.BizCntDTO;
import iih.bd.srv.oth.d.MedSrvWordFreqDO;
import iih.bd.srv.oth.d.WfBizClassTypeEnum;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.d.desc.OrdSrvDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.ICIMQConst;
import iih.ci.ord.s.bp.GetEntUseStatisticCntBP;
import xap.lui.core.mq.IMQListener;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;

/**
 * MQ保存词频监听
 *
 */
public class SrvWFInfoMQListener implements IMQListener {

	@SuppressWarnings("unchecked")
	@Override
	public void doListener(Object arg0) throws Exception {

		if(arg0 == null || !(arg0 instanceof Map)){
			return ;
		}
		
		Map<String,Object> map = (Map<String,Object>)arg0;

		String idors = map.get("idors").toString();
		Context ctx = (Context)map.get("ctx");
		
		// 获得签署医嘱对应的服务使用个数数量统计信息
		BizCntDTO[] bizcntinfos = getSrvCnt4IDOrs(idors);
		if (CiOrdUtils.isEmpty(bizcntinfos))
			return;

		// 词频使用统计信息数据保存更新
		wordFreqInfoSave(bizcntinfos,ctx);

	}

	@Override
	public String getListenerType() {

		return ICIMQConst.MSGTYPE_CI_SRV_WORD_FREQ;
	}

	/**
	 * 词频使用统计信息数据保存更新
	 * 
	 * @param bizcntinfos
	 * @throws BizException
	 */
	private void wordFreqInfoSave(BizCntDTO[] bizcntinfos,Context ctx) throws BizException {
		
		MedSrvWordFreqDO wfpkdata = new MedSrvWordFreqDO();
		wfpkdata.setId_grp(ctx.getGroupId());
		wfpkdata.setId_org(ctx.getOrgId());
		wfpkdata.setId_dept(ctx.getDeptId());
		wfpkdata.setBiz_classtype(WfBizClassTypeEnum.MEDSRV);
		wfpkdata.setId_emp(ctx.getUserId());
		CiOrdAppUtils.getBdSrvMaintainService().wordFreqStatisticInfoUpdate(wfpkdata, bizcntinfos);
	}

	/**
	 * 获得签署医嘱对应的服务使用个数数量统计信息
	 * 
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	private BizCntDTO[] getSrvCnt4IDOrs(String idors) throws BizException {
		GetEntUseStatisticCntBP bp = new GetEntUseStatisticCntBP();
		String tblname = OrdSrvDODesc.TABLE_NAME;
		String keyfld = MedSrvDODesc.PRIMARYKEY_FIELDNAME;
		String condfld = CiOrderDODesc.PRIMARYKEY_FIELDNAME;
		return bp.exec(idors, tblname, keyfld, condfld);
	}
}

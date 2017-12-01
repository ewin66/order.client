package iih.ci.ord.s.listener.mq;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.srv.oth.d.BizCntDTO;
import iih.bd.srv.oth.d.MedSrvWordFreqDO;
import iih.bd.srv.oth.d.WfBizClassTypeEnum;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.cidiag.d.desc.CiDiagDODesc;
import iih.ci.diag.cidiag.d.desc.CiDiagItemDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.ICIMQConst;
import iih.ci.ord.s.bp.GetEntUseStatisticCntBP;
import iih.ci.ord.s.listener.IBizPlugInSourecIDConst;
import xap.lui.core.mq.IMQListener;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

/**
 * MQ保存诊断词频
 * 
 * @author HUMS
 *
 */
public class DiagWFInfoMQListener implements IMQListener {

	@Override
	public void doListener(Object arg0) throws Exception {

		if (arg0 == null || !(arg0 instanceof Map)) {
			return;
		}

		Map<String, Object> map = (Map<String, Object>) arg0;

		String[] idendiinfos = (String[]) map.get("idendiinfos");
		Context context = (Context) map.get("context");

		// 获得签署诊断对应的服务使用个数数量统计信息
		BizCntDTO[] bizcntinfos = getDiagCnt4IDDiags(idendiinfos);
		if (CiOrdUtils.isEmpty(bizcntinfos))
			return;

		// 词频使用统计信息数据保存更新
		wordFreqInfoSave(bizcntinfos, context);
	}

	@Override
	public String getListenerType() {

		return ICIMQConst.MSGTYPE_CI_DIAG_WORD_FREQ;
	}

	public void doAction(IBusinessEvent event) throws BizException {

		// 事件源及事件类型判断
		if (!(event.getSourceID().equals(IBizPlugInSourecIDConst.CIDIAGAGGDO_FULLCLASSNAME)
				&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))
			return;

		// 签署诊断的诊断数据及空判断逻辑
		BDCommonEvent dbevent = (BDCommonEvent) event;
		Object[] newObjs = dbevent.getNewObjs();
		if (ArrayUtils.isEmpty(newObjs))
			return;

		// 获得诊断主键字符串及空判断逻辑
		String[] idendiinfos = getIdEnDiDefInfo(newObjs);
		if (CiOrdUtils.isEmpty(idendiinfos))
			return;

	}

	/**
	 * 词频使用统计信息数据保存更新
	 * 
	 * @param bizcntinfos
	 * @throws BizException
	 */
	private void wordFreqInfoSave(BizCntDTO[] bizcntinfos, Context context) throws BizException {

		MedSrvWordFreqDO wfpkdata = new MedSrvWordFreqDO();
		wfpkdata.setId_grp(context.getGroupId()); // 集团id
		wfpkdata.setId_org(context.getOrgId()); // 组织id
		wfpkdata.setId_dept(context.getDeptId()); // 科室id
		wfpkdata.setId_emp(context.getUserId()); // 人员id
		wfpkdata.setBiz_classtype(WfBizClassTypeEnum.DIAGDEF);
		CiOrdAppUtils.getBdSrvMaintainService().wordFreqStatisticInfoUpdate(wfpkdata, bizcntinfos);
	}

	/**
	 * 获得签署诊断对应的诊断使用个数数量统计信息
	 * 
	 * @param iddiags
	 * @return
	 * @throws BizException
	 */
	private BizCntDTO[] getDiagCnt4IDDiags(String[] idendiinfos) throws BizException {
		GetEntUseStatisticCntBP bp = new GetEntUseStatisticCntBP();
		String tblname = CiDiagItemDODesc.TABLE_NAME;
		String keyfld = CiDiagItemDO.ID_DIDEF;
		String condfld = getCondFldStr(idendiinfos);
		BizCntDTO[] rtn = bp.exec(idendiinfos[1], tblname, keyfld, condfld);
		return bizCntDTOHandle(rtn);
	}

	private BizCntDTO[] bizCntDTOHandle(BizCntDTO[] bizcntdtos) {
		// 有效性校验
		if (CiOrdUtils.isEmpty(bizcntdtos))
			return null;
		ArrayList<BizCntDTO> list = new ArrayList<BizCntDTO>();

		// 遍历
		for (int i = 0; i < bizcntdtos.length; i++) {
			if (bizcntdtos[i].getCnt().equals(1)) {
				list.add(bizcntdtos[i]);
			}
		}

		// 空判断
		if (CiOrdUtils.isEmpty(list))
			return null;

		// 返回
		return (BizCntDTO[]) list.toArray((BizCntDTO[]) Array.newInstance(BizCntDTO.class, 0));
	}

	/**
	 * 获得条件串
	 * 
	 * @param idendiinfos
	 * @return
	 */
	private String getCondFldStr(String[] idendiinfos) {
		return CiDiagDODesc.PRIMARYKEY_FIELDNAME + " in (select " + CiDiagDODesc.PRIMARYKEY_FIELDNAME + " from "
				+ CiDiagDODesc.TABLE_NAME + " where " + CiDiagDO.ID_EN + "=" + idendiinfos[0] + " ) and "
				+ CiDiagItemDO.ID_DIDEF;
	}

	/**
	 * 获得就诊主键
	 * 
	 * @param newObj
	 * @return
	 */
	private String getIdEnStr(Object newObj) {
		if (CiOrdUtils.isEmpty(newObj))
			return null;
		CiDiagDO diagdo = ((CidiagAggDO) newObj).getParentDO();
		if (!CiOrdUtils.isDiagSign(diagdo))
			return null;
		String idens = CiOrdUtils.getSqlCondStrWithComma(diagdo.getId_en());
		return idens.substring(1);
	}

	/**
	 * 获得诊断就诊与诊断数据信息
	 * 
	 * @param newObjs
	 * @return
	 */
	private String[] getIdEnDiDefInfo(Object[] newObjs) {
		// 有效性校验
		if (CiOrdUtils.isEmpty(newObjs))
			return null;
		String[] rtn = new String[2]; // 就诊主键 诊断主键串

		// 获得就诊主键
		rtn[0] = getIdEnStr(newObjs[0]);
		if (CiOrdUtils.isEmpty(rtn[0]))
			return null;

		int iN = 0;
		StringBuffer sb = new StringBuffer();
		CiDiagItemDO[] diagitmdos = ((CidiagAggDO) newObjs[0]).getCiDiagItemDO();
		if (CiOrdUtils.isEmpty(diagitmdos))
			return null;

		// 遍历
		for (CiDiagItemDO diagitm : diagitmdos) {
			iN += 1;
			sb.append(CiOrdUtils.getSqlCondStrWithComma(diagitm.getId_didef()));
		}

		if (iN == 0)
			return null; // 判断

		// 返回值
		rtn[1] = sb.toString().substring(1);
		return rtn;
	}
}

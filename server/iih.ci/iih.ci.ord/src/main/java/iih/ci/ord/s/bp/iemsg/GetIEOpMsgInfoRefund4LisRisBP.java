package iih.ci.ord.s.bp.iemsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.bl.cg.service.IBlcgqueryService;
import iih.ci.ord.iemsg.d.IEOpOrCancStpDTO;
import iih.ci.ord.iemsg.d.IEOpOrCancStpEnDTO;
import iih.ci.ord.iemsg.d.IEOpPharmHerbOrDTO;
import iih.ci.ord.iemsg.d.IEOpPharmOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpPharmOrFeeDTO;
import iih.ci.ord.iemsg.d.IEOpPharmPresDTO;
import iih.ci.ord.iemsg.d.IEOpPharmWcOrDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiOpDrugConfirmQry;
import iih.ci.ord.s.bp.iemsg.qry.CiOpDrugPres8IdPresQry;
import iih.ci.ord.s.bp.iemsg.qry.CiOpDrugPres8idenQry;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * BS005：检查和检验</br>
 * 生成集成平台检查和检验医嘱退费服务数据信息操作BP （门诊）
 */
public class GetIEOpMsgInfoRefund4LisRisBP extends GetIEOpMsgInfoRefundAbstractBP{

	/**
	 * 生成集成平台检查和检验医嘱服务退费数据信息 （门诊）
	 * 
	 * @param OpRefund4IpEsDTO[]
	 *            医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpOrCancStpEnDTO[] exec(OpRefund4IpEsDTO[] refundDTOs) throws BizException {
		String id_ors = this.getIdOrs(refundDTOs);
		HashMap<String, OpRefund4IpEsDTO> refundMap = this.getOpRefundDTOMapKeyIdor(refundDTOs);
		// 退费人的信息
		Map<String, String[]> cancPsnMaps = getCancIdPats(refundDTOs);
		if (CiOrdUtils.isEmpty(id_ors))
			return null;
		//查询出组装集成平台的主子do的数据
		List<Map<String, Object>> lisRisMaps = getLisRisIEData(id_ors);
		List<IEOpOrCancStpEnDTO> ieOpOrCancStpEnDTOs = new ArrayList<IEOpOrCancStpEnDTO>();
		for (Map<String, Object> map : lisRisMaps) {
			IEOpOrCancStpEnDTO ieOpOrCancStpEnDTO = new IEOpOrCancStpEnDTO();
			IEOpOrCancStpDTO iEOpOrCancStpDTO = new IEOpOrCancStpDTO();
			// 组装主do
			setIeOpOrCancStpEnDTO(ieOpOrCancStpEnDTO, map);
			// 组装子do
			setIEOpOrCancStpDTO(iEOpOrCancStpDTO, map, refundMap, cancPsnMaps);
			FArrayList2 list2 = new FArrayList2();
			list2.add(iEOpOrCancStpDTO);
			ieOpOrCancStpEnDTO.setId_ieorcancstps(list2);

			ieOpOrCancStpEnDTOs.add(ieOpOrCancStpEnDTO);
		}
		return ieOpOrCancStpEnDTOs.toArray(new IEOpOrCancStpEnDTO[0]);
	}
	/**
	 * 查询出组装集成平台的主子do的数据
	 * @param id_orsrvs
	 * @return
	 * @throws BizException
	 */
	private List<Map<String, Object>> getLisRisIEData(String id_ors) throws BizException {
		// 查询出检查和检验的集成平台数据
		String sql = String.format(ICiIEMsgRelSqlConst.CI_OP_LISRIS_IE_SQL, CiOrdUtils.getSqlInOrEqualStrs(id_ors));
		List<Map<String, Object>> lisRisMaps = CiOrdUtils.getRsMapList(sql);
		return lisRisMaps;
	}

	/**
	 * 组装主DO
	 * 
	 * @param ieOpOrCancStpEnDTO
	 * @param map
	 */
	private void setIeOpOrCancStpEnDTO(IEOpOrCancStpEnDTO ieOpOrCancStpEnDTO, Map<String, Object> map) {
		ieOpOrCancStpEnDTO.setPatient_id(CiOrdUtils.nullHandle(map.get("patient_id")));
		ieOpOrCancStpEnDTO.setTimes(CiOrdUtils.nullHandle(map.get("times")));
		ieOpOrCancStpEnDTO.setExec_unit(CiOrdUtils.nullHandle(map.get("exec_unit")));
		ieOpOrCancStpEnDTO.setExec_unit_name(CiOrdUtils.nullHandle(map.get("exec_unit_name")));
		ieOpOrCancStpEnDTO.setDomain_id("01");
		ieOpOrCancStpEnDTO.setDept_code(CiOrdUtils.nullHandle(map.get("dept_code")));
		ieOpOrCancStpEnDTO.setDept_name(CiOrdUtils.nullHandle(map.get("dept_name")));
		ieOpOrCancStpEnDTO.setOrg_code(CiOrdUtils.nullHandle(map.get("org_code")));
		ieOpOrCancStpEnDTO.setOrg_name(CiOrdUtils.nullHandle(map.get("org_name")));
		ieOpOrCancStpEnDTO.setIemsgca_code(CiOrdUtils.nullHandle(map.get("iemsgca_code")));
	}

	/**
	 * 组装子DO
	 * 
	 * @param iEOpOrCancStpDTO
	 * @param map
	 * @param refundMap
	 * @param cancPsnMaps
	 */
	private void setIEOpOrCancStpDTO(IEOpOrCancStpDTO iEOpOrCancStpDTO, Map<String, Object> map,
			HashMap<String, OpRefund4IpEsDTO> refundMap, Map<String, String[]> cancPsnMaps) {
		iEOpOrCancStpDTO.setOrder_id(CiOrdUtils.nullHandle(map.get("order_id")));
		iEOpOrCancStpDTO.setOrder_type(CiOrdUtils.nullHandle(map.get("order_type")));
		String id_or = CiOrdUtils.nullHandle(map.get("id_or"));
		if (!CiOrdUtils.isEmpty(id_or)) {
			OpRefund4IpEsDTO opRefund = refundMap.get(id_or);
			if (!CiOrdUtils.isEmpty(opRefund)) {
				iEOpOrCancStpDTO.setCancel_date(opRefund.getDt_refund());
				iEOpOrCancStpDTO.setCancel_reason(opRefund.getReason());
				String[] cancPsnArr = cancPsnMaps.get(opRefund.getId_emp_refund());
				if (!CiOrdUtils.isEmpty(cancPsnArr)) {
					iEOpOrCancStpDTO.setCancel_opera(cancPsnArr[0]);
					iEOpOrCancStpDTO.setCancel_opera_name(cancPsnArr[1]);
				}
			}
		}
	}
	/**
	 * 查询退费人信息
	 * 
	 * @param refundDTOs
	 * @return
	 * @throws BizException
	 */
	private Map<String, String[]> getCancIdPats(OpRefund4IpEsDTO[] refundDTOs) throws BizException {
		String id_pats = "";
		for (OpRefund4IpEsDTO es : refundDTOs) {
			id_pats += es.getId_emp_refund() + CiOrdUtils.COMMA_STR;
		}
		if (!CiOrdUtils.isEmpty(id_pats)) {
			Map<String, String[]> psnDocMap = new HashMap<String, String[]>();
			id_pats = id_pats.substring(0, id_pats.length() - 1).replaceAll(CiOrdUtils.COMMA_STR,
					CiOrdUtils.SQUOTE_MARK_STR + CiOrdUtils.COMMA_STR + CiOrdUtils.SQUOTE_MARK_STR);
			String sql = " select bd_psndoc.code,bd_psndoc.name,bd_psndoc.id_psndoc from bd_psndoc where bd_psndoc.id_psndoc in ('"
					+ id_pats + "')";
			List<Map<String, Object>> psnDocs = CiOrdUtils.getRsMapList(sql);
			for (Map<String, Object> map : psnDocs) {
				String id_psndoc = CiOrdUtils.nullHandle(map.get("id_psndoc"));
				if (!CiOrdUtils.isEmpty(id_psndoc)) {
					String[] psnArray = new String[2];
					String code = CiOrdUtils.nullHandle(map.get("code"));
					if (!CiOrdUtils.isEmpty(code)) {
						psnArray[0] = code;
					}
					String name = CiOrdUtils.nullHandle(map.get("name"));
					if (!CiOrdUtils.isEmpty(name)) {
						psnArray[1] = name;
					}
					psnDocMap.put(id_psndoc, psnArray);
				}
			}
			return psnDocMap;
		}

		return null;
	}
}

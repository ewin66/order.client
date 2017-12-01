package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.splitpres.OrdPresSplitSaveBP;
import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 高端商保的退费
 * @author li_zheng
 *
 */
public class setOrderRefundBillCancelReserveBP {

  /***
   * 
   * @param idOrs 医嘱id
   * @param id_psndoc 当前登录人员id
   * @param ciEnContextDTO
   * @return 操作结果消息
   * @throws BizException
   */
	public String setOrderRefundBillCancelReserve(String[] idOrs, String id_psndoc, CiEnContextDTO ciEnContextDTO)
			throws BizException {

		List<OrdSrvDO> ordSrvList = getorderSrv(idOrs, id_psndoc);
		if (ordSrvList == null || ordSrvList.size() == 0) {
			return "没有需要退费的项目";
		}

		List<String> list = new ArrayList<String>();
		Ent4BannerDTO banner = ciEnContextDTO.getEnt4BannerDTO();
		BlOrderAppendBillParamDTO[] refundBillParamDTO = new BlOrderAppendBillParamDTO[ordSrvList.size()];
		String code_entp = banner.getCode_entp();

		for (int i = 0; i < ordSrvList.size(); i++) {
			
			OrdSrvDO srvDO = ordSrvList.get(i);
			// 医嘱取消记账且取消物品预留，必填：id_pat,id_org,id_or,id_orsrv,id_emp_cg
			BlOrderAppendBillParamDTO dto = new BlOrderAppendBillParamDTO();
			dto.setId_pat(ciEnContextDTO.getId_pat());
			dto.setId_org(ciEnContextDTO.getId_org());
			dto.setId_or(srvDO.getId_or());
			dto.setId_orsrv(srvDO.getId_orsrv());
			dto.setId_emp_cg(id_psndoc);
			refundBillParamDTO[i] = dto;
			list.add(srvDO.getId_pres());

		}

		String str = CiOrdAppUtils.getIBLOrderAppendBillService()
				.SetOrderRefundBill_ByIdor_cancelReserve(refundBillParamDTO, code_entp);
		OrdPresSplitSaveBP saveBP = new OrdPresSplitSaveBP();
		saveBP.DeletePresDO(list);
		return str;
	}
	
	/**
	 * 根据医嘱id查询已经可退费的医嘱项目
	 * @param idOrs 有效医嘱ID字符串
	 * @return 当前有效医嘱对应的费用项目
	 * @throws BizException
	 */
	private List<OrdSrvDO> getorderSrv(String[] idors, String id_psndoc) throws BizException {
		// 当前医生 已签署、未作废、可退费的、已记账、未销账、未结算（由费用判断）  去掉未执行判断，因为第三方可取消执行，但应我们中的执行状态还是已执行
		String sql = "select Id_or,Id_orsrv,Id_pres "
				+ "from ci_or_srv "
				+ "where fg_bl='Y' and sd_su_bl='1' and fg_feertnable='Y' "
				+ "and (eu_feereversetp is null or eu_feereversetp=0) and ds=0 and id_or in "
				+ "(select id_or from ci_order "
				+ "where id_emp_sign='" + id_psndoc + "' and fg_sign='Y' and fg_canc='N' "
				+ "and id_or in (" + CiOrdUtils.getSqlInStrsWithOutIn(idors) + "))";
		List<OrdSrvDO> ordSrvList = (List<OrdSrvDO>) new DAFacade().execQuery(sql, new BeanListHandler(OrdSrvDO.class));
		return ordSrvList;

	}
}

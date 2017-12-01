package iih.ci.ord.s.bp.iemsg;

import iih.ci.ord.iemsg.d.IEOpTreatOrDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiTreatOpOrCItmQry;
import iih.ci.ord.s.bp.iemsg.qry.CiTreatOpOrConfirmQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * BS303：诊疗处置信息服务</br>
 * 生成集成平台治疗服务数据信息操作BP （门诊）
 */
public class GetIEOpMsgInfo4TreatNBP {
	/**
	 * 生成集成平台治疗服务数据信息 （门诊）
	 * 
	 * @param id_ors 医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpTreatOrEnDTO[] exec(String id_ors) throws BizException {
		//有效性校验
		if (CiOrdUtils.isEmpty(id_ors))
			return null;

		//查询并获得就诊及确认数据信息
		IEOpTreatOrEnDTO[] rtn = getIEOpTreatOrEnDTOs(id_ors);
		if (CiOrdUtils.isEmpty(rtn))
			return null;
		//计算年龄
		rtn[0].setAge(AgeCalcUtil.getAge(rtn[0].getBirthday()));
		//查询并设置确认数据对应的  治疗医嘱数据信息集合
		IEOpTreatOrEnDTO[] trns = HandleCiTreatOpOrCItms4Confirm(id_ors, rtn[0]);

		//返回
		return trns;
	}

	/**
	 * 查询并设置确认数据对应的 治疗医嘱数据信息集合
	 * 
	 * @param id_ors
	 * @param rtn
	 * @throws BizException
	 */
	private IEOpTreatOrEnDTO[] HandleCiTreatOpOrCItms4Confirm(String id_ors, IEOpTreatOrEnDTO rtn) throws BizException {
		CiTreatOpOrCItmQry qry1 = new CiTreatOpOrCItmQry(id_ors);
		IEOpTreatOrDTO[] itms = (IEOpTreatOrDTO[]) AppFwUtil.getDORstWithDao(qry1, IEOpTreatOrDTO.class);
		if (CiOrdUtils.isEmpty(itms))
			return null;

		IEOpTreatOrEnDTO[] endtos = new IEOpTreatOrEnDTO[itms.length];
		int i = 0;
		for (IEOpTreatOrDTO ieOpTreatOrDTO : itms) {
			IEOpTreatOrEnDTO endto = new IEOpTreatOrEnDTO();
			TreatOrEnDTOCopy(rtn, endto);
			FArrayList2 fa = new FArrayList2();
			fa.add(ieOpTreatOrDTO);
			endto.setIetreators(fa);
			endtos[i] = endto;
			i++;
		}
		return endtos;
	}

	/**
	 * 查询并获得就诊及确认数据信息
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOpTreatOrEnDTO[] getIEOpTreatOrEnDTOs(String id_ors) throws BizException {
		CiTreatOpOrConfirmQry qry = new CiTreatOpOrConfirmQry(getIdOr(id_ors));
		IEOpTreatOrEnDTO[] rtn = (IEOpTreatOrEnDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpTreatOrEnDTO.class);
		return rtn;
	}

	/**
	 * 获得一个医嘱id
	 * 
	 * @param id_ors
	 * @return
	 */
	private String getIdOr(String id_ors) {
		return (id_ors.split(CiOrdUtils.COMMA_STR))[0];
	}

	private void TreatOrEnDTOCopy(IEOpTreatOrEnDTO treatendto, IEOpTreatOrEnDTO copytreatendto) {

		copytreatendto.setId_ietreatoren(treatendto.getId_ietreatoren());
		copytreatendto.setIetreatfees(treatendto.getIetreatfees());
		copytreatendto.setPatient_id(treatendto.getPatient_id());
		copytreatendto.setP_bar_code(treatendto.getP_bar_code());
		copytreatendto.setAdmiss_times(treatendto.getAdmiss_times());
		copytreatendto.setName(treatendto.getName());
		copytreatendto.setSex(treatendto.getSex());
		copytreatendto.setAge(treatendto.getAge());
		copytreatendto.setBirthday(treatendto.getBirthday());
		copytreatendto.setApply_unit(treatendto.getApply_unit());
		copytreatendto.setApply_unit_name(treatendto.getApply_unit_name());
		copytreatendto.setWard_code(treatendto.getWard_code());
		copytreatendto.setWard_code_name(treatendto.getWard_code_name());
		copytreatendto.setBed_no(treatendto.getBed_no());
		copytreatendto.setConfrim_date(treatendto.getConfrim_date());
		copytreatendto.setConfirm_opera(treatendto.getConfirm_opera());
		copytreatendto.setConfrim_opera_name(treatendto.getConfrim_opera_name());
		copytreatendto.setDomain_id("01");

	}

}

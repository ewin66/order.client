package iih.ci.ord.s.bp.iemsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.ci.ord.iemsg.d.IEOpTreatFeeDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiTreatOpOrCItmQry;
import iih.ci.ord.s.bp.iemsg.qry.CiTreatOpOrConfirmQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * BS303：诊疗处置信息服务</br>
 * 生成集成平台治疗服务数据信息操作BP （门诊）
 */
public class GetIEOpMsgInfoRefund4TreatBP extends GetIEOpMsgInfoRefundAbstractBP {
	/**
	 * 生成集成平台治疗服务数据信息 （门诊）
	 * 
	 * @param id_ors 医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpTreatOrEnDTO[] exec(OpRefund4IpEsDTO[] refund4IpEsDTOs) throws BizException {
		//有效性校验
		if (CiOrdUtils.isEmpty(refund4IpEsDTOs))
			return null;
		String id_ors = getIdOrs(refund4IpEsDTOs);
		HashMap<String,OpRefund4IpEsDTO> refundMap = this.getOpRefundDTOMapKeyIdorsrv(refund4IpEsDTOs);
		//查询并获得就诊及确认数据信息
		IEOpTreatOrEnDTO[] rtn = getIEOpTreatOrEnDTOs(id_ors);
		if (CiOrdUtils.isEmpty(rtn))
			return null;
		//计算年龄
		rtn[0].setAge(AgeCalcUtil.getAge(rtn[0].getBirthday()));
		//查询并设置确认数据对应的  治疗医嘱数据信息集合
		IEOpTreatOrEnDTO[] trns = HandleCiTreatOpOrCItms4Confirm(id_ors, rtn[0],refundMap);

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
	private IEOpTreatOrEnDTO[] HandleCiTreatOpOrCItms4Confirm(String id_ors, IEOpTreatOrEnDTO rtn,HashMap<String,OpRefund4IpEsDTO> refundMap) throws BizException {
		CiTreatOpOrCItmQry qry1 = new CiTreatOpOrCItmQry(id_ors);
		IEOpTreatOrDTO[] itms = (IEOpTreatOrDTO[]) AppFwUtil.getDORstWithDao(qry1, IEOpTreatOrDTO.class);
		if (CiOrdUtils.isEmpty(itms))
			return null;
		List<IEOpTreatOrEnDTO> endtolist = new ArrayList<IEOpTreatOrEnDTO>();
		int i = 0;
		for (IEOpTreatOrDTO ieOpTreatOrDTO : itms) {
			IEOpTreatOrEnDTO endto = new IEOpTreatOrEnDTO();
			TreatOrEnDTOCopy(rtn, endto);
			endto.setExec_sn(ieOpTreatOrDTO.getExec_sn());
			FArrayList2 fa = new FArrayList2();
			String id_ietreator = ieOpTreatOrDTO.getId_ietreator();
			if(CiOrdUtils.isEmpty(refundMap.get(id_ietreator)))
				continue;
			FDouble quan =refundMap.get(id_ietreator).getQuan();
			String strAmount = ieOpTreatOrDTO.getCharge_amount();
			if(!CiOrdUtils.isEmpty(strAmount)){
				FDouble surplus = new FDouble(strAmount).sub(quan);
				if(surplus.compareTo(new FDouble(0))<=0){
					
				}else{
					ieOpTreatOrDTO.setCharge_amount(surplus.toString());
					fa.add(ieOpTreatOrDTO);
					endto.setIetreators(fa);
				}
			}
			FArrayList2 fa1 = new FArrayList2();
			IEOpTreatFeeDTO feedto = new IEOpTreatFeeDTO();
			feedto.setPres_no(ieOpTreatOrDTO.getId_ietreator());
			feedto.setPres_item_no(ieOpTreatOrDTO.getParent_no());
			fa1.add(feedto);
			endto.setIetreatfees(fa1);
			endtolist.add(endto);
			i++;
		}
		return endtolist.toArray(new IEOpTreatOrEnDTO[0]);
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

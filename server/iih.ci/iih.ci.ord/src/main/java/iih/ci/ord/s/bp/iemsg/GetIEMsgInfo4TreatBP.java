package iih.ci.ord.s.bp.iemsg;

import iih.ci.ord.iemsg.d.IETreatOrDTO;
import iih.ci.ord.iemsg.d.IETreatOrEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiTreatOrCItmQry;
import iih.ci.ord.s.bp.iemsg.qry.CiTreatOrConfirmQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 生成集成平台治疗服务数据信息操作BP
 */
public class GetIEMsgInfo4TreatBP {
	/**
	 * 生成集成平台治疗服务数据信息
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IETreatOrEnDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//查询并获得就诊及确认数据信息
		IETreatOrEnDTO[] rtn=getIETreatOrEnDTOs(id_ors);
		
		for(IETreatOrEnDTO dto:rtn){
			dto.setAge(AgeCalcUtil.getAge(dto.getBirthdaydate()));
		}
		
		if(CiOrdUtils.isEmpty(rtn))return null;
		
		//查询并设置确认数据对应的  治疗医嘱数据信息集合
		setCiTreatOrCItms4Confirm(id_ors,rtn[0]);
		
		//返回
		return rtn;
	}
	
	/**
	 * 查询并设置确认数据对应的  治疗医嘱数据信息集合
	 * @param id_ors
	 * @param rtn
	 * @throws BizException
	 */
	private void setCiTreatOrCItms4Confirm(String id_ors,IETreatOrEnDTO rtn) throws BizException{
		CiTreatOrCItmQry qry1=new CiTreatOrCItmQry(id_ors);
		IETreatOrDTO[] itms = (IETreatOrDTO[])AppFwUtil.getDORstWithDao(qry1, IETreatOrDTO.class);
		if(CiOrdUtils.isEmpty(itms))return;
		
		rtn.setId_ietreators(CiOrdUtils.array2FArrayList2(itms));
	}
	
	
	/**
	 * 查询并获得就诊及确认数据信息
	 * @param id_ors
	 * @return
	 * @throws BizException 
	 */
	private IETreatOrEnDTO[] getIETreatOrEnDTOs(String id_ors) throws BizException{
		CiTreatOrConfirmQry qry=new CiTreatOrConfirmQry(getIdOr(id_ors));
		IETreatOrEnDTO[] rtn = (IETreatOrEnDTO[])AppFwUtil.getDORstWithDao(qry, IETreatOrEnDTO.class);
		return rtn;
	}
	
	/**
	 * 获得一个医嘱id
	 * @param id_ors
	 * @return
	 */
	private String getIdOr(String id_ors){
		return (id_ors.split(CiOrdUtils.COMMA_STR))[0];
	}
}

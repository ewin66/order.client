package iih.ci.ord.s.bp.iemsg;

import iih.ci.ord.iemsg.d.IEOpTreatOrDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiTreatOpOrCItmQry;
import iih.ci.ord.s.bp.iemsg.qry.CiTreatOpOrConfirmQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 生成集成平台治疗服务数据信息操作BP
 * （门诊）
 */
public class GetIEOpMsgInfo4TreatBP {
	/**
	 * 生成集成平台治疗服务数据信息
	 * （门诊）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpTreatOrEnDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//查询并获得就诊及确认数据信息
		IEOpTreatOrEnDTO[] rtn=getIEOpTreatOrEnDTOs(id_ors);
		if(CiOrdUtils.isEmpty(rtn))return null;
		
		//查询并设置确认数据对应的  治疗医嘱数据信息集合
		setCiTreatOpOrCItms4Confirm(id_ors,rtn[0]);
		
		//返回
		return rtn;
	}
	
	/**
	 * 查询并设置确认数据对应的  治疗医嘱数据信息集合
	 * @param id_ors
	 * @param rtn
	 * @throws BizException
	 */
	private void setCiTreatOpOrCItms4Confirm(String id_ors,IEOpTreatOrEnDTO rtn) throws BizException{
		CiTreatOpOrCItmQry qry1=new CiTreatOpOrCItmQry(id_ors);
		IEOpTreatOrDTO[] itms = (IEOpTreatOrDTO[])AppFwUtil.getDORstWithDao(qry1, IEOpTreatOrDTO.class);
		if(CiOrdUtils.isEmpty(itms))return;
		
		rtn.setIetreators(CiOrdUtils.array2FArrayList2(itms));
	}
	
	
	/**
	 * 查询并获得就诊及确认数据信息
	 * @param id_ors
	 * @return
	 * @throws BizException 
	 */
	private IEOpTreatOrEnDTO[] getIEOpTreatOrEnDTOs(String id_ors) throws BizException{
		CiTreatOpOrConfirmQry qry=new CiTreatOpOrConfirmQry(getIdOr(id_ors));
		IEOpTreatOrEnDTO[] rtn = (IEOpTreatOrEnDTO[])AppFwUtil.getDORstWithDao(qry, IEOpTreatOrEnDTO.class);
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

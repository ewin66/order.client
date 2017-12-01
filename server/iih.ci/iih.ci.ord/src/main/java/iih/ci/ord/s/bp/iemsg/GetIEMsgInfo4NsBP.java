package iih.ci.ord.s.bp.iemsg;

import java.util.Map;

import iih.ci.ord.iemsg.d.IENsOrDTO;
import iih.ci.ord.iemsg.d.IENsOrEnDTO;
import iih.ci.ord.iemsg.d.IETreatOrEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiNsOrCItmQry;
import iih.ci.ord.s.bp.iemsg.qry.CiNsOrConfirmQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * BS304：护理医嘱信息服务</br>
 * 生成集成平台护理服务数据信息操作BP
 */
public class GetIEMsgInfo4NsBP {
	/**
	 * 生成集成平台护理服务数据信息
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IENsOrEnDTO[] exec(String id_ors,Map<String,Object> confirminfo) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//查询并获得就诊及确认数据信息
		IENsOrEnDTO[] rtn=getIENsOrEnDTOs(id_ors);
		if(CiOrdUtils.isEmpty(rtn))return null;
		
		//查询并设置确认数据对应的  其它医嘱数据信息集合
		setCiNsOrCItms4Confirm(id_ors,rtn[0]);
		
		//返回
		return rtn;
	}
	
	/**
	 * 查询并设置确认数据对应的  其它医嘱数据信息集合
	 * @param id_ors
	 * @param rtn
	 * @throws BizException
	 */
	private void setCiNsOrCItms4Confirm(String id_ors,IENsOrEnDTO rtn) throws BizException{
		CiNsOrCItmQry qry1=new CiNsOrCItmQry(id_ors);
		IENsOrDTO[] itms = (IENsOrDTO[])AppFwUtil.getDORstWithDao(qry1, IENsOrDTO.class);
		
		if(CiOrdUtils.isEmpty(itms))return;
		
		rtn.setId_iensors(CiOrdUtils.array2FArrayList2(itms));
	}
	
	
	/**
	 * 查询并获得就诊及确认数据信息
	 * @param id_ors
	 * @return
	 * @throws BizException 
	 */
	private IENsOrEnDTO[] getIENsOrEnDTOs(String id_ors) throws BizException{
		CiNsOrConfirmQry qry=new CiNsOrConfirmQry(getIdOr(id_ors));
		IENsOrEnDTO[] rtn = (IENsOrEnDTO[])AppFwUtil.getDORstWithDao(qry, IENsOrEnDTO.class);
		for(IENsOrEnDTO dto:rtn){
			dto.setAge(AgeCalcUtil.getAge(dto.getBirthdaydate()));
		}
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

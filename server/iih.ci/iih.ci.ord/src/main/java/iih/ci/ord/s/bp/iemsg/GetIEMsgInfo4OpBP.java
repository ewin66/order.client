package iih.ci.ord.s.bp.iemsg;

import iih.ci.ord.iemsg.d.IEOpOrEnDTO;
import iih.ci.ord.iemsg.d.IETreatOrEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiSugOrQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 生成集成平台手术申请服务数据信息操作BP
 */
public class GetIEMsgInfo4OpBP {
	/**
	 * 生成集成平台手术申请服务数据信息
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpOrEnDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//查询并获得返回值
		CiSugOrQry qry=new CiSugOrQry(id_ors);
		IEOpOrEnDTO[] rtn = (IEOpOrEnDTO[])AppFwUtil.getDORstWithDao(qry, IEOpOrEnDTO.class);

		for(IEOpOrEnDTO dto:rtn){
			dto.setAge(AgeCalcUtil.getAge(dto.getBirthdaydate()));
		}
		
		return rtn;
	}
}

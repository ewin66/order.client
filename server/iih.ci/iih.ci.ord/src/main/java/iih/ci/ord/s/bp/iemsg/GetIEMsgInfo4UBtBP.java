package iih.ci.ord.s.bp.iemsg;

import java.util.Map;

import iih.ci.ord.iemsg.d.IEBtOrEnDTO;
import iih.ci.ord.iemsg.d.IEBtUseOrDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiBuOrQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * BS309：生成集成平台用血服务数据信息操作BP</br>
 * 住院用血医嘱
 */
public class GetIEMsgInfo4UBtBP {
	/**
	 * 生成集成平台用血服务数据信息
	 * 
	 * @param id_ors 医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEBtUseOrDTO[] exec(String id_ors, Map<String, Object> confirminfo) throws BizException {
		//有效性校验
		if (CiOrdUtils.isEmpty(id_ors))
			return null;

		//查询并获得返回值
		CiBuOrQry qry = new CiBuOrQry(id_ors);
		IEBtUseOrDTO[] rtn = (IEBtUseOrDTO[]) AppFwUtil.getDORstWithDao(qry, IEBtUseOrDTO.class);

		for (IEBtUseOrDTO dto : rtn) {
			dto.setAge(AgeCalcUtil.getAge(dto.getBirthdaydate()));
		}

		return rtn;
	}
}

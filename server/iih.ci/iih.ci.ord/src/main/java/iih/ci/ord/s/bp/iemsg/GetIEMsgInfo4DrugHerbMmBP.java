package iih.ci.ord.s.bp.iemsg;

import iih.ci.ord.iemsg.d.IEPharmOrMmDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiPharmHerbOrMmQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 生成集成平台草药医嘱物品数据信息操作BP
 */
public class GetIEMsgInfo4DrugHerbMmBP {
	/**
	 * 生成集成平台草药医嘱物品数据信息
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEPharmOrMmDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//查询并获得返回值
		CiPharmHerbOrMmQry qry=new CiPharmHerbOrMmQry(id_ors);
		IEPharmOrMmDTO[] rtn = (IEPharmOrMmDTO[])AppFwUtil.getDORstWithDao(qry, IEPharmOrMmDTO.class);

		return rtn;
	}
}

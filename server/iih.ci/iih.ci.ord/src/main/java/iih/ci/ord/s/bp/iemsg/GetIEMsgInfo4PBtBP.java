package iih.ci.ord.s.bp.iemsg;

import java.util.Map;

import iih.ci.ord.iemsg.d.IEBtOrEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiBtOrQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * BS008：生成集成平台备血申请服务数据信息操作BP
 * 住院
 */
public class GetIEMsgInfo4PBtBP {
	/**
	 * 生成集成平台备血申请服务数据信息
	 * 住院
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEBtOrEnDTO[] exec(String id_ors,Map<String,Object> confirminfo) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//获得备血医嘱申请数据信息集合
		IEBtOrEnDTO[] rtndtos=getIEBtOrEnDTOs(id_ors);
		
		for(IEBtOrEnDTO dto:rtndtos){
			dto.setAge(AgeCalcUtil.getAge(dto.getBirthdaydate()));
		}
		
		//返回备血申请医嘱数据集合信息
		return rtndtos;
	}
	
	/**
	 * 获得备血医嘱申请数据信息集合
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEBtOrEnDTO[] getIEBtOrEnDTOs(String id_ors) throws BizException{		
		CiBtOrQry qry=new CiBtOrQry(id_ors);
		IEBtOrEnDTO[] rtn = (IEBtOrEnDTO[])AppFwUtil.getDORstWithDao(qry, IEBtOrEnDTO.class);
		 return rtn;
	}
}

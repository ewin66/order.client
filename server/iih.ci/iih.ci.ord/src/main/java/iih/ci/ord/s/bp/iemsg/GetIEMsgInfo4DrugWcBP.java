package iih.ci.ord.s.bp.iemsg;

import iih.ci.ord.iemsg.d.IEPharmWcOrDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiPharmWcOrQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 生成集成平台西成药医嘱服务数据信息操作BP
 */
public class GetIEMsgInfo4DrugWcBP {
	/**
	 * 生成集成平台西成医嘱服务数据信息
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEPharmWcOrDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//查询并获得返回值
		CiPharmWcOrQry qry=new CiPharmWcOrQry(id_ors);
		IEPharmWcOrDTO[] rtn = (IEPharmWcOrDTO[])AppFwUtil.getDORstWithDao(qry, IEPharmWcOrDTO.class);
		
		//返回值处理
		RtnHandle(rtn);
		
		//返回
		return rtn;
	}
	
	/**
	 * 返回值处理
	 * @param rtn
	 */
	private void RtnHandle(IEPharmWcOrDTO[] rtn){
		if(CiOrdUtils.isEmpty(rtn))return;
		String id_or="";
		String id_or_parent="";
		for(int i=0;i<rtn.length;i++){
			id_or_parent=rtn[i].getXy_zcy_f_order_no();
			if(!id_or.equals(id_or_parent)){
				rtn[i].setXy_zcy_order_code(id_or_parent);
				rtn[i].setXy_zcy_f_order_no(null);
				id_or=id_or_parent;
			}
		}

	}
}

package iih.ci.ord.s.bp;

import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.qry.CiOrOpenSrvReactOrSrvQry;
import iih.ci.ord.srvreact.d.OrOpenSrvReactDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 * 医嘱开立时，与其互斥医嘱信息数据集合操作BP
 */
public class CiOrOpenSrvReactOrSrvInfoBP {
	/**
	 *  医嘱开立时，与其互斥医嘱信息数据集合
	 * @param id_pi
	 * @param id_pv
	 * @param id_or
	 * @param id_srvreact
	 * @return
	 * @throws BizException
	 */
	public OrOpenSrvReactDTO[] exec(String id_pi,String id_pv,String id_or,String id_srvreacts) throws BizException{
		//有效性校验
		if(!validateCheck(id_pi,id_pv,id_srvreacts)) return null;
		
		//获得查询串并查询
		CiOrOpenSrvReactOrSrvQry qry = new CiOrOpenSrvReactOrSrvQry(id_pi,id_pv,id_or,id_srvreacts);
		OrOpenSrvReactDTO[] rtn = (OrOpenSrvReactDTO[])AppFwUtil.getDORstWithDao(qry, OrOpenSrvReactDTO.class);
		
		//返回
		return  rtn;
		 
	}
	
	/**
	 * 有效性校验
	 * @param id_pi
	 * @param id_pv
	 * @param id_srvreact
	 * @return
	 */
	private boolean validateCheck(String id_pi,String id_pv,String id_srvreacts){
		if(CiOrdUtils.isEmpty(id_pi) || CiOrdUtils.isEmpty(id_pv) || CiOrdUtils.isEmpty(id_srvreacts))return false;
		return true;
	}
}

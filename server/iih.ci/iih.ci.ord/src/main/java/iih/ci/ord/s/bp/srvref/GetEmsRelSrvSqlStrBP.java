package iih.ci.ord.s.bp.srvref;

import iih.bd.srv.ems.d.EmsRelSrvDO;
import iih.bd.srv.ems.d.desc.EmsRelSrvDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 获得医疗单关联服务对应sql串操作BP
 */
public class GetEmsRelSrvSqlStrBP {
	/**
	 * 获得医疗单关联服务对应sql串数据信息
	 * @param id_ems
	 * @return
	 * @throws BizException
	 */
	public String exec(String id_ems)   throws BizException {
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ems))return "";
		
		//获得医疗单关联的服务数据信息
		EmsRelSrvDO[] emsrelsrvs=getEmsrelSrvs(id_ems);
		
		//返回值处理
		return SrvRefUtils.getEmsrelSrvSqlStr(emsrelsrvs);
	}
	/**
	 * 获得医疗单关联的服务数据信息
	 * @param id_ems
	 * @return
	 * @throws BizException
	 */
	private EmsRelSrvDO[] getEmsrelSrvs(String id_ems) throws BizException{
		String whereStr=EmsRelSrvDODesc.TABLE_ALIAS_NAME+"."+EmsRelSrvDO.ID_SRVOF+"='"+id_ems+"'";
		EmsRelSrvDO[] emsrelsrvdos=CiOrdAppUtils.getEmsRelSrvQryService().find(whereStr, "", FBoolean.FALSE);
		return emsrelsrvdos;
	}
}

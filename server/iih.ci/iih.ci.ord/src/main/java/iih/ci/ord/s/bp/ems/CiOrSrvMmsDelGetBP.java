package iih.ci.ord.s.bp.ems;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 获得删除医嘱项目对应的物品操作BP
 */
public class CiOrSrvMmsDelGetBP {
	/**
	 * 获得删除医嘱项目对应的物品
	 * @param orsrvdo
	 * @return
	 * @throws BizException
	 */
	public  OrdSrvMmDO exec(OrdSrvDO orsrvdo)  throws BizException{
		if(orsrvdo==null)return null;
		//医嘱项目对应的物品处理
		if(OrSrvSplitUtil.isTrue(orsrvdo.getFg_mm())){
			return getCiSrvMmDO(orsrvdo.getId_orsrv());
		}
		return null;
	}
	
	/**
	 * 医嘱项目关联物品数据
	 * @param id_or
	 * @throws BizException
	 */
	private OrdSrvMmDO getCiSrvMmDO(String id_orsrv) throws BizException{
		GetMmOfCiOrSrvBP bp=new GetMmOfCiOrSrvBP();
		return bp.exec(id_orsrv, true);
	}

}

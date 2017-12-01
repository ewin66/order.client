package iih.ci.ord.s.bp.ems;

import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.sys.appfw.orm.utils.AuditInfoUtil;

/**
 * 皮试医嘱结果预存操作BP
 */
public class CiOrSkinTestRsPreSaveBP {
	public void  exec(CiorderAggDO aggskindo)  throws BizException{
		//有效性校验
		if(aggskindo==null)return;
		
		//创建预存皮试结果信息
		CiSkinTestRstDO rsdo=createCiSkinTestRstDO(aggskindo);
		
		//do保存
		CiOrdAppUtils.getCiskintestrstService().save(new CiSkinTestRstDO[]{rsdo});
	}
	
	/**
	 * 创建皮试医嘱结果数据信息
	 * @param aggskindo
	 * @return
	 */
	private CiSkinTestRstDO createCiSkinTestRstDO(CiorderAggDO aggskindo){
		CiSkinTestRstDO rsdo=new CiSkinTestRstDO();
		rsdo.setStatus(DOStatus.NEW);// 李政 添加 20160127号 调试皮试医嘱
		//rsdo.setId_skintest();
		rsdo.setId_or(aggskindo.getParentDO().getId_or());
		//rsdo.setId_rst_skintest();
		//rsdo.setSd_rst_skintest();
		//rsdo.setId_emp_create();
		//rsdo.setDt_create();
		AuditInfoUtil.addData(rsdo);
		return rsdo;
	}
}

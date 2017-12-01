package iih.ci.mr.nu.criticalillrec.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.criticalillrec.d.CriticalillDO;
import iih.ci.mr.nu.criticalillrec.d.CriticalillRecDO;
import iih.ci.mr.nu.criticalillrec.d.desc.CriticalillRecDODesc;

/**
 * 危重症护理记录单
 * @author
 *
 */
public class CriticalillrecAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CriticalillrecAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CriticalillDO.class);
        addChildren(CriticalillRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CriticalillRecDODesc.class).getFKAttrDesc());        
	  }	  
}
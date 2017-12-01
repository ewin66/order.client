package iih.ci.mr.nu.obstetrics.gynurbefore.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.obstetrics.gynurbefore.d.GyNurBeforeAssDO;
import iih.ci.mr.nu.obstetrics.gynurbefore.d.GyNurBeforeRecDO;
import iih.ci.mr.nu.obstetrics.gynurbefore.d.desc.GyNurBeforeRecDODesc;

/**
 * 妇科护理记录单(非手术、术前)
 * @author
 *
 */
public class GynurbeforeAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public GynurbeforeAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(GyNurBeforeAssDO.class);
        addChildren(GyNurBeforeRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(GyNurBeforeRecDODesc.class).getFKAttrDesc());        
	  }	  
}
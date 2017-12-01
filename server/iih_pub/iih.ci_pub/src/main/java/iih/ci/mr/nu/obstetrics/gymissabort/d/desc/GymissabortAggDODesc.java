package iih.ci.mr.nu.obstetrics.gymissabort.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.obstetrics.gymissabort.d.GyMissAbortAssDO;
import iih.ci.mr.nu.obstetrics.gymissabort.d.GyMissAbortRecDO;
import iih.ci.mr.nu.obstetrics.gymissabort.d.desc.GyMissAbortRecDODesc;

/**
 * 妇科稽留流产护理记录单
 * @author
 *
 */
public class GymissabortAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public GymissabortAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(GyMissAbortAssDO.class);
        addChildren(GyMissAbortRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(GyMissAbortRecDODesc.class).getFKAttrDesc());        
	  }	  
}
package iih.ci.mr.nu.healthyedunsrec.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.healthyedunsrec.d.HealthyEduNsDO;
import iih.ci.mr.nu.healthyedunsrec.d.HealthyEduNsRecDO;
import iih.ci.mr.nu.healthyedunsrec.d.desc.HealthyEduNsRecDODesc;

/**
 * 健康教育记录
 * @author
 *
 */
public class HealthyedunsrecAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public HealthyedunsrecAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(HealthyEduNsDO.class);
        addChildren(HealthyEduNsRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HealthyEduNsRecDODesc.class).getFKAttrDesc());        
	  }	  
}
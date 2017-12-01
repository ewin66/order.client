package iih.ci.mr.nu.obstetrics.gynurafter.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.obstetrics.gynurafter.d.GyNurAfterAssDO;
import iih.ci.mr.nu.obstetrics.gynurafter.d.GyNurAfterRecDO;
import iih.ci.mr.nu.obstetrics.gynurafter.d.desc.GyNurAfterRecDODesc;

/**
 * 妇科护理记录单(术后)
 * @author
 *
 */
public class GynurafterAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public GynurafterAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(GyNurAfterAssDO.class);
        addChildren(GyNurAfterRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(GyNurAfterRecDODesc.class).getFKAttrDesc());        
	  }	  
}
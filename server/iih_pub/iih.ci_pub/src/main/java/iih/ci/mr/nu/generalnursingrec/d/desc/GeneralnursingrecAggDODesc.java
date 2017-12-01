package iih.ci.mr.nu.generalnursingrec.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.generalnursingrec.d.GeneralNursingDO;
import iih.ci.mr.nu.generalnursingrec.d.GeneralNursingRecDO;
import iih.ci.mr.nu.generalnursingrec.d.desc.GeneralNursingRecDODesc;

/**
 * 一般护理记录
 * @author
 *
 */
public class GeneralnursingrecAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public GeneralnursingrecAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(GeneralNursingDO.class);
        addChildren(GeneralNursingRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(GeneralNursingRecDODesc.class).getFKAttrDesc());        
	  }	  
}
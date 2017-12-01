package iih.ci.mr.nu.chidrenass.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.chidrenass.d.ChildrenInAsseDO;
import iih.ci.mr.nu.chidrenass.d.ChildrenInAsseNurRecordDO;
import iih.ci.mr.nu.chidrenass.d.desc.ChildrenInAsseNurRecordDODesc;

/**
 * 高危儿观察护理记录单
 * @author
 *
 */
public class ChidrenassAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ChidrenassAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ChildrenInAsseDO.class);
        addChildren(ChildrenInAsseNurRecordDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ChildrenInAsseNurRecordDODesc.class).getFKAttrDesc());        
	  }	  
}
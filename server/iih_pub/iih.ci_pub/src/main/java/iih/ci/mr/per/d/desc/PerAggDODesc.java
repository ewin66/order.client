package iih.ci.mr.per.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.per.d.PerDO;
import iih.ci.mr.per.d.PerListDO;
import iih.ci.mr.per.d.desc.PerListDODesc;

/**
 * 组件
 * @author
 *
 */
public class PerAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PerAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PerDO.class);
        addChildren(PerListDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PerListDODesc.class).getFKAttrDesc());        
	  }	  
}
package iih.ci.ord.cior.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.cior.d.OrdApPathgyDO;
import iih.ci.ord.cior.d.OrdApPathgySampDO;
import iih.ci.ord.cior.d.desc.OrdApPathgySampDODesc;

/**
 * 病理申请单
 * @author
 *
 */
public class CiorapppathgyAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CiorapppathgyAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(OrdApPathgyDO.class);
        addChildren(OrdApPathgySampDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OrdApPathgySampDODesc.class).getFKAttrDesc());        
	  }	  
}
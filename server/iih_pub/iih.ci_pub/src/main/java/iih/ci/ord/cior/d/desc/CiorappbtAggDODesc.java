package iih.ci.ord.cior.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.OrdApBtViewItemDO;
import iih.ci.ord.cior.d.desc.OrdApBtViewItemDODesc;

/**
 * 备血申请单
 * @author
 *
 */
public class CiorappbtAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CiorappbtAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(OrdApBtDO.class);
        addChildren(OrdApBtViewItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OrdApBtViewItemDODesc.class).getFKAttrDesc());        
	  }	  
}
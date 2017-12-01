package iih.ci.ord.cior.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.d.OrdOpEmpDO;
import iih.ci.ord.cior.d.desc.OrdOpEmpDODesc;
import iih.ci.ord.cior.d.OrdOpMmDO;
import iih.ci.ord.cior.d.desc.OrdOpMmDODesc;
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.cior.d.desc.OrdApSugViewItemDODesc;

/**
 * 手术申请
 * @author
 *
 */
public class CiorappsurgeryAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CiorappsurgeryAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(OrdApOpDO.class);
        addChildren(OrdOpEmpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OrdOpEmpDODesc.class).getFKAttrDesc());        
        addChildren(OrdOpMmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OrdOpMmDODesc.class).getFKAttrDesc());        
        addChildren(OrdApSugViewItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OrdApSugViewItemDODesc.class).getFKAttrDesc());        
	  }	  
}
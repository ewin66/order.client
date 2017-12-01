package iih.ci.ord.app.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.app.d.CiAppPathgySheetDO;
import iih.ci.ord.app.d.CiAppPathgySheetSampDO;
import iih.ci.ord.app.d.desc.CiAppPathgySheetSampDODesc;

/**
 * 病理打印申请单
 * @author
 *
 */
public class CiapppathgysheetAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CiapppathgysheetAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiAppPathgySheetDO.class);
        addChildren(CiAppPathgySheetSampDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiAppPathgySheetSampDODesc.class).getFKAttrDesc());        
	  }	  
}
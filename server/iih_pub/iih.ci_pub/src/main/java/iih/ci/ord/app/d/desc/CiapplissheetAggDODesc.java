package iih.ci.ord.app.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.app.d.CiAppLisSheetDO;
import iih.ci.ord.app.d.CiAppLisSheetOrDO;
import iih.ci.ord.app.d.desc.CiAppLisSheetOrDODesc;

/**
 * 检验申请单
 * @author
 *
 */
public class CiapplissheetAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CiapplissheetAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiAppLisSheetDO.class);
        addChildren(CiAppLisSheetOrDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiAppLisSheetOrDODesc.class).getFKAttrDesc());        
	  }	  
}
package iih.ci.ord.app.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.app.d.CiAppTreatSheetDO;
import iih.ci.ord.app.d.CiAppTreatSheetOrDO;
import iih.ci.ord.app.d.desc.CiAppTreatSheetOrDODesc;

/**
 * 诊疗申请单
 * @author
 *
 */
public class CiapptreatsheetAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CiapptreatsheetAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiAppTreatSheetDO.class);
        addChildren(CiAppTreatSheetOrDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiAppTreatSheetOrDODesc.class).getFKAttrDesc());        
	  }	  
}
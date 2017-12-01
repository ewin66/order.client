package iih.ci.ord.cior.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.cior.d.OrdApRptOpDO;
import iih.ci.ord.cior.d.OrdApRptOpItemDO;
import iih.ci.ord.cior.d.desc.OrdApRptOpItemDODesc;
import iih.ci.ord.cior.d.RptOpEmpDO;
import iih.ci.ord.cior.d.desc.RptOpEmpDODesc;

/**
 * 医嘱手术记录
 * @author
 *
 */
public class OrdrptopAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public OrdrptopAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(OrdApRptOpDO.class);
        addChildren(OrdApRptOpItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OrdApRptOpItemDODesc.class).getFKAttrDesc());        
        addChildren(RptOpEmpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(RptOpEmpDODesc.class).getFKAttrDesc());        
	  }	  
}
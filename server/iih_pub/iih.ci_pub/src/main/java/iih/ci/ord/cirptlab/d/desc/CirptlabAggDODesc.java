package iih.ci.ord.cirptlab.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.cirptlab.d.CiRptLabDO;
import iih.ci.ord.cirptlab.d.CiRptLabItmDO;
import iih.ci.ord.cirptlab.d.desc.CiRptLabItmDODesc;

/**
 * 组件
 * @author
 *
 */
public class CirptlabAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CirptlabAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiRptLabDO.class);
        addChildren(CiRptLabItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiRptLabItmDODesc.class).getFKAttrDesc());        
	  }	  
}
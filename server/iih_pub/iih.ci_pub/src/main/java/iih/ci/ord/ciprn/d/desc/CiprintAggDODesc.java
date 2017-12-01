package iih.ci.ord.ciprn.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.ciprn.d.CiPrnDO;
import iih.ci.ord.ciprn.d.CiPrnItmDO;
import iih.ci.ord.ciprn.d.desc.CiPrnItmDODesc;

/**
 * 临床打印单
 * @author
 *
 */
public class CiprintAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CiprintAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiPrnDO.class);
        addChildren(CiPrnItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiPrnItmDODesc.class).getFKAttrDesc());        
	  }	  
}
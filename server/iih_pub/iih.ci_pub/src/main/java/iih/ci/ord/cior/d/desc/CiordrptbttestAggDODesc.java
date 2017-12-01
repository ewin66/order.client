package iih.ci.ord.cior.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.cior.d.CiOrdBtTestDO;
import iih.ci.ord.cior.d.CiOrdBtTestItmDO;
import iih.ci.ord.cior.d.desc.CiOrdBtTestItmDODesc;

/**
 * 备血检验结果
 * @author
 *
 */
public class CiordrptbttestAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CiordrptbttestAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiOrdBtTestDO.class);
        addChildren(CiOrdBtTestItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiOrdBtTestItmDODesc.class).getFKAttrDesc());        
	  }	  
}
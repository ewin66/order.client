package iih.ci.diag.cidiag.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.desc.CiDiagItemDODesc;

/**
 * 临床诊断
 * @author
 *
 */
public class CidiagAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CidiagAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiDiagDO.class);
        addChildren(CiDiagItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiDiagItemDODesc.class).getFKAttrDesc());        
	  }	  
}
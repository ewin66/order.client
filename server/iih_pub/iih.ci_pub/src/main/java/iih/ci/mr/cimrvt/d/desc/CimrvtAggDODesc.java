package iih.ci.mr.cimrvt.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.cimrvt.d.CiMrVtDO;
import iih.ci.mr.cimrvt.d.CiMrVtItmDO;
import iih.ci.mr.cimrvt.d.desc.CiMrVtItmDODesc;
import iih.ci.mr.cimrvt.d.CiMrVtEvDO;
import iih.ci.mr.cimrvt.d.desc.CiMrVtEvDODesc;

/**
 * 临床生命体征测量
 * @author
 *
 */
public class CimrvtAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CimrvtAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiMrVtDO.class);
        addChildren(CiMrVtItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiMrVtItmDODesc.class).getFKAttrDesc());        
        addChildren(CiMrVtEvDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiMrVtEvDODesc.class).getFKAttrDesc());        
	  }	  
}
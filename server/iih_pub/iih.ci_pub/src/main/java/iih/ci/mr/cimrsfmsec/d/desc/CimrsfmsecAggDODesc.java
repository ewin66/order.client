package iih.ci.mr.cimrsfmsec.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.cimrsfmsec.d.CimrsfmsecDO;
import iih.ci.mr.cimrsfmsec.d.CimrsfmsecitmDO;
import iih.ci.mr.cimrsfmsec.d.desc.CimrsfmsecitmDODesc;

/**
 * 医疗记录智能表单段落
 * @author
 *
 */
public class CimrsfmsecAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CimrsfmsecAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CimrsfmsecDO.class);
        addChildren(CimrsfmsecitmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CimrsfmsecitmDODesc.class).getFKAttrDesc());        
	  }	  
}
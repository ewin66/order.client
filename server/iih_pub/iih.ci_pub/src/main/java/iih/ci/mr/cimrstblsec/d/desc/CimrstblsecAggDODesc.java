package iih.ci.mr.cimrstblsec.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.cimrstblsec.d.CiMrSTblSecDO;
import iih.ci.mr.cimrstblsec.d.CiMrSTblSecItmDO;
import iih.ci.mr.cimrstblsec.d.desc.CiMrSTblSecItmDODesc;

/**
 * 临床医疗记录智能表格段落
 * @author
 *
 */
public class CimrstblsecAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CimrstblsecAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiMrSTblSecDO.class);
        addChildren(CiMrSTblSecItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiMrSTblSecItmDODesc.class).getFKAttrDesc());        
	  }	  
}
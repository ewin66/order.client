package iih.ci.ord.cior.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.cior.d.OrdApConsDO;
import iih.ci.ord.cior.d.CiordInviteConsDO;
import iih.ci.ord.cior.d.desc.CiordInviteConsDODesc;
import iih.ci.ord.cior.d.OrConsApAuditDO;
import iih.ci.ord.cior.d.desc.OrConsApAuditDODesc;

/**
 * 会诊申请单
 * @author
 *
 */
public class CiorappconsultAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CiorappconsultAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(OrdApConsDO.class);
        addChildren(CiordInviteConsDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiordInviteConsDODesc.class).getFKAttrDesc());        
        addChildren(OrConsApAuditDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OrConsApAuditDODesc.class).getFKAttrDesc());        
	  }	  
}
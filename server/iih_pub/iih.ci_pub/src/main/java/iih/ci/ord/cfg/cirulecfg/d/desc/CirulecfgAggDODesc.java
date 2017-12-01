package iih.ci.ord.cfg.cirulecfg.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.cfg.cirulecfg.d.CiRuleCfg;
import iih.ci.ord.cfg.cirulecfg.d.CiRuleCfgRelRule;
import iih.ci.ord.cfg.cirulecfg.d.desc.CiRuleCfgRelRuleDesc;

/**
 * 医嘱规则配置
 * @author
 *
 */
public class CirulecfgAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CirulecfgAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiRuleCfg.class);
        addChildren(CiRuleCfgRelRule.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiRuleCfgRelRuleDesc.class).getFKAttrDesc());        
	  }	  
}
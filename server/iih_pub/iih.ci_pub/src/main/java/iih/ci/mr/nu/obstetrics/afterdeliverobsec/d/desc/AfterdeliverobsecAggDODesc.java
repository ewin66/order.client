package iih.ci.mr.nu.obstetrics.afterdeliverobsec.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.obstetrics.afterdeliverobsec.d.AfterDeliveInfoDO;
import iih.ci.mr.nu.obstetrics.afterdeliverobsec.d.AfterDeliveRecDO;
import iih.ci.mr.nu.obstetrics.afterdeliverobsec.d.desc.AfterDeliveRecDODesc;

/**
 * 产后观察记录
 * @author
 *
 */
public class AfterdeliverobsecAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public AfterdeliverobsecAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(AfterDeliveInfoDO.class);
        addChildren(AfterDeliveRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(AfterDeliveRecDODesc.class).getFKAttrDesc());        
	  }	  
}
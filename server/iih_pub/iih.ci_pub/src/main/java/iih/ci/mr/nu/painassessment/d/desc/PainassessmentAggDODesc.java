package iih.ci.mr.nu.painassessment.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.painassessment.d.PainAssessDO;
import iih.ci.mr.nu.painassessment.d.PainAssessItmDO;
import iih.ci.mr.nu.painassessment.d.desc.PainAssessItmDODesc;

/**
 * 疼痛护理评估表
 * @author
 *
 */
public class PainassessmentAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PainassessmentAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PainAssessDO.class);
        addChildren(PainAssessItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PainAssessItmDODesc.class).getFKAttrDesc());        
	  }	  
}
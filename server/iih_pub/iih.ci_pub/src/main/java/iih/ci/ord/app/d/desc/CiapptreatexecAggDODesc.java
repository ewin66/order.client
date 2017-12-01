package iih.ci.ord.app.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.app.d.CiAppTreatExecDO;
import iih.ci.ord.app.d.CiAppTreatExecOrDO;
import iih.ci.ord.app.d.desc.CiAppTreatExecOrDODesc;

/**
 * 门诊诊疗执行单
 * @author
 *
 */
public class CiapptreatexecAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CiapptreatexecAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiAppTreatExecDO.class);
        addChildren(CiAppTreatExecOrDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiAppTreatExecOrDODesc.class).getFKAttrDesc());        
	  }	  
}
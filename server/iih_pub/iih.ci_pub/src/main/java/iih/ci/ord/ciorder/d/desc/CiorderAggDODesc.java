package iih.ci.ord.ciorder.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.desc.OrdSrvDODesc;
import iih.ci.ord.ciorder.d.OrdDrugDO;
import iih.ci.ord.ciorder.d.desc.OrdDrugDODesc;
import iih.ci.ord.ciorder.d.OrdFreqTimeDO;
import iih.ci.ord.ciorder.d.desc.OrdFreqTimeDODesc;

/**
 * 临床医嘱
 * @author
 *
 */
public class CiorderAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CiorderAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiOrderDO.class);
        addChildren(OrdSrvDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OrdSrvDODesc.class).getFKAttrDesc());        
        addChildren(OrdDrugDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OrdDrugDODesc.class).getFKAttrDesc());        
        addChildren(OrdFreqTimeDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OrdFreqTimeDODesc.class).getFKAttrDesc());        
	  }	  
}
package iih.ci.mr.nu.newbabypicc.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.newbabypicc.d.NewBabyPiccDO;
import iih.ci.mr.nu.newbabypicc.d.NewBabyPiccRecDO;
import iih.ci.mr.nu.newbabypicc.d.desc.NewBabyPiccRecDODesc;

/**
 * 新生儿科picc护理信息
 * @author
 *
 */
public class NewbabypiccAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NewbabypiccAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NewBabyPiccDO.class);
        addChildren(NewBabyPiccRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NewBabyPiccRecDODesc.class).getFKAttrDesc());        
	  }	  
}
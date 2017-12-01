package iih.ci.mr.nu.newbornveinnur.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.newbornveinnur.d.NewBornVeinNurDO;
import iih.ci.mr.nu.newbornveinnur.d.NewBornVeinNurRecordDO;
import iih.ci.mr.nu.newbornveinnur.d.desc.NewBornVeinNurRecordDODesc;

/**
 * 新生儿科脐静脉护理记录单（一）
 * @author
 *
 */
public class NewbornveinnurAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NewbornveinnurAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NewBornVeinNurDO.class);
        addChildren(NewBornVeinNurRecordDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NewBornVeinNurRecordDODesc.class).getFKAttrDesc());        
	  }	  
}
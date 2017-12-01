package iih.ci.mr.nu.obstetrics.birthrec.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.obstetrics.birthrec.d.BirthrecInfoDO;
import iih.ci.mr.nu.obstetrics.birthrec.d.BirthrecInDO;
import iih.ci.mr.nu.obstetrics.birthrec.d.desc.BirthrecInDODesc;
import iih.ci.mr.nu.obstetrics.birthrec.d.BirthrecProDO;
import iih.ci.mr.nu.obstetrics.birthrec.d.desc.BirthrecProDODesc;

/**
 * 临产记录
 * @author
 *
 */
public class BirthrecAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BirthrecAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BirthrecInfoDO.class);
        addChildren(BirthrecInDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BirthrecInDODesc.class).getFKAttrDesc());        
        addChildren(BirthrecProDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BirthrecProDODesc.class).getFKAttrDesc());        
	  }	  
}
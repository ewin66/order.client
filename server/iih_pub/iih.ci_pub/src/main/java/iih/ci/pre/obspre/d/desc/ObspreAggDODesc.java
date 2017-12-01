package iih.ci.pre.obspre.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.pre.obspre.d.ObsPreDO;
import iih.ci.pre.obspre.d.ObsPreSrvDO;
import iih.ci.pre.obspre.d.desc.ObsPreSrvDODesc;

/**
 * 预检
 * @author
 *
 */
public class ObspreAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ObspreAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ObsPreDO.class);
        addChildren(ObsPreSrvDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ObsPreSrvDODesc.class).getFKAttrDesc());        
	  }	  
}
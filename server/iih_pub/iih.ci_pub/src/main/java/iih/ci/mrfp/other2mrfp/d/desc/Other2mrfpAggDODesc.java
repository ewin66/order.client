package iih.ci.mrfp.other2mrfp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mrfp.other2mrfp.d.CiMrFpOtherDO;
import iih.ci.mrfp.other2mrfp.d.CiMrfpIntenCareDO;
import iih.ci.mrfp.other2mrfp.d.desc.CiMrfpIntenCareDODesc;

/**
 * 病案首页其他信息
 * @author
 *
 */
public class Other2mrfpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public Other2mrfpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiMrFpOtherDO.class);
        addChildren(CiMrfpIntenCareDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiMrfpIntenCareDODesc.class).getFKAttrDesc());        
	  }	  
}
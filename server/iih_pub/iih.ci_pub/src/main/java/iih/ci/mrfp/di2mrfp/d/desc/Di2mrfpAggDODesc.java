package iih.ci.mrfp.di2mrfp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mrfp.di2mrfp.d.CiMrfpDiDO;
import iih.ci.mrfp.di2mrfp.d.CiMrFpXydiDO;
import iih.ci.mrfp.di2mrfp.d.desc.CiMrFpXydiDODesc;
import iih.ci.mrfp.di2mrfp.d.CiMrfpZydiDO;
import iih.ci.mrfp.di2mrfp.d.desc.CiMrfpZydiDODesc;

/**
 * 住院病案首页_诊断
 * @author
 *
 */
public class Di2mrfpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public Di2mrfpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiMrfpDiDO.class);
        addChildren(CiMrFpXydiDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiMrFpXydiDODesc.class).getFKAttrDesc());        
        addChildren(CiMrfpZydiDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiMrfpZydiDODesc.class).getFKAttrDesc());        
	  }	  
}
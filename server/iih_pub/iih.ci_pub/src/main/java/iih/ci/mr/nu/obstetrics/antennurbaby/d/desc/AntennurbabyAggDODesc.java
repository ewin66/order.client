package iih.ci.mr.nu.obstetrics.antennurbaby.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.obstetrics.antennurbaby.d.AntNurBabyDO;
import iih.ci.mr.nu.obstetrics.antennurbaby.d.AntNurBabyBrserDO;
import iih.ci.mr.nu.obstetrics.antennurbaby.d.desc.AntNurBabyBrserDODesc;

/**
 * 产科婴儿护理记录
 * @author
 *
 */
public class AntennurbabyAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public AntennurbabyAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(AntNurBabyDO.class);
        addChildren(AntNurBabyBrserDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(AntNurBabyBrserDODesc.class).getFKAttrDesc());        
	  }	  
}
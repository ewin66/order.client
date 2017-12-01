package iih.ci.mr.nu.obstetrics.breathmachnur.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.obstetrics.breathmachnur.d.BreathMachInfoDO;
import iih.ci.mr.nu.obstetrics.breathmachnur.d.BreathMachRecDO;
import iih.ci.mr.nu.obstetrics.breathmachnur.d.desc.BreathMachRecDODesc;

/**
 * 呼吸机治疗观察记录单
 * @author
 *
 */
public class BreathmachnurAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BreathmachnurAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BreathMachInfoDO.class);
        addChildren(BreathMachRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BreathMachRecDODesc.class).getFKAttrDesc());        
	  }	  
}
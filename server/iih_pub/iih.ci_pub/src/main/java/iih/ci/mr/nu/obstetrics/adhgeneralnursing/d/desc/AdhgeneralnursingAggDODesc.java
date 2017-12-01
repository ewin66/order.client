package iih.ci.mr.nu.obstetrics.adhgeneralnursing.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.obstetrics.adhgeneralnursing.d.AdhNursingDO;
import iih.ci.mr.nu.obstetrics.adhgeneralnursing.d.AdhNursingRecDO;
import iih.ci.mr.nu.obstetrics.adhgeneralnursing.d.desc.AdhNursingRecDODesc;

/**
 * 妇产科护理观察记录
 * @author
 *
 */
public class AdhgeneralnursingAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public AdhgeneralnursingAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(AdhNursingDO.class);
        addChildren(AdhNursingRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(AdhNursingRecDODesc.class).getFKAttrDesc());        
	  }	  
}
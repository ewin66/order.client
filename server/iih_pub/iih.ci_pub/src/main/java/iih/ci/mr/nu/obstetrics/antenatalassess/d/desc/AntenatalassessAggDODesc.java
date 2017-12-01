package iih.ci.mr.nu.obstetrics.antenatalassess.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.obstetrics.antenatalassess.d.AntenAssDO;
import iih.ci.mr.nu.obstetrics.antenatalassess.d.AntenNurBserRecDO;
import iih.ci.mr.nu.obstetrics.antenatalassess.d.desc.AntenNurBserRecDODesc;

/**
 * 产科护理记录单(产后、术后)
 * @author
 *
 */
public class AntenatalassessAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public AntenatalassessAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(AntenAssDO.class);
        addChildren(AntenNurBserRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(AntenNurBserRecDODesc.class).getFKAttrDesc());        
	  }	  
}
package iih.ci.mr.nu.obstetrics.opernurecord.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.obstetrics.opernurecord.d.OperNuRecordDO;
import iih.ci.mr.nu.obstetrics.opernurecord.d.OperNuRecordEqmDO;
import iih.ci.mr.nu.obstetrics.opernurecord.d.desc.OperNuRecordEqmDODesc;
import iih.ci.mr.nu.obstetrics.opernurecord.d.OperNuRecordDressDO;
import iih.ci.mr.nu.obstetrics.opernurecord.d.desc.OperNuRecordDressDODesc;

/**
 * 手术护理记录单
 * @author
 *
 */
public class OpernurecordAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public OpernurecordAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(OperNuRecordDO.class);
        addChildren(OperNuRecordEqmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OperNuRecordEqmDODesc.class).getFKAttrDesc());        
        addChildren(OperNuRecordDressDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OperNuRecordDressDODesc.class).getFKAttrDesc());        
	  }	  
}
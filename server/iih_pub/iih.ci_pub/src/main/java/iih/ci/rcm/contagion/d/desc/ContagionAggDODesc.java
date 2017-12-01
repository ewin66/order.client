package iih.ci.rcm.contagion.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.rcm.contagion.d.ContagionDO;
import iih.ci.rcm.contagion.d.StdDO;
import iih.ci.rcm.contagion.d.desc.StdDODesc;
import iih.ci.rcm.contagion.d.HepatitisBDO;
import iih.ci.rcm.contagion.d.desc.HepatitisBDODesc;
import iih.ci.rcm.contagion.d.SyphilisDO;
import iih.ci.rcm.contagion.d.desc.SyphilisDODesc;
import iih.ci.rcm.contagion.d.HFMDO;
import iih.ci.rcm.contagion.d.desc.HFMDODesc;
import iih.ci.rcm.contagion.d.AidsDO;
import iih.ci.rcm.contagion.d.desc.AidsDODesc;
import iih.ci.rcm.contagion.d.CondylomaDO;
import iih.ci.rcm.contagion.d.desc.CondylomaDODesc;

/**
 * 传染病报告卡
 * @author
 *
 */
public class ContagionAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ContagionAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ContagionDO.class);
        addChildren(StdDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(StdDODesc.class).getFKAttrDesc());        
        addChildren(HepatitisBDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HepatitisBDODesc.class).getFKAttrDesc());        
        addChildren(SyphilisDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SyphilisDODesc.class).getFKAttrDesc());        
        addChildren(HFMDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HFMDODesc.class).getFKAttrDesc());        
        addChildren(AidsDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(AidsDODesc.class).getFKAttrDesc());        
        addChildren(CondylomaDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CondylomaDODesc.class).getFKAttrDesc());        
	  }	  
}
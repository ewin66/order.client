package iih.ci.ord.cfg.cirulecfg.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.cfg.cirulecfg.d.desc.CirulecfgAggDODesc;



/**
 * 医嘱规则配置
 */
public class CirulecfgAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiRuleCfg getParentDO() {
		return ((CiRuleCfg) super.getParentDO());
	}

	public void setParentDO(CiRuleCfg headDO) {
		setParent(headDO);
	}

	public CiRuleCfgRelRule[] getCiRuleCfgRelRule() {
		IBaseDO[] dos = getChildren(CiRuleCfgRelRule.class);
		if(dos==null) return null;
		CiRuleCfgRelRule[] result=new CiRuleCfgRelRule[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiRuleCfgRelRule)dos[i];
		}
		return result;
	}
	
	public void setCiRuleCfgRelRule(CiRuleCfgRelRule[] dos) {
		setChildren(CiRuleCfgRelRule.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CirulecfgAggDODesc desc = new CirulecfgAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiRuleCfg();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.cfg.cirulecfg.d.CiRuleCfgRelRule")) {
             return new CiRuleCfgRelRule();
         }
         return null;
     }
}
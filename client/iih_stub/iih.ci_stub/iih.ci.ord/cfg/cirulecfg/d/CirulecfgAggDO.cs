using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.ord.cfg.cirulecfg.d
{
	/// <summary>
	/// 医嘱规则配置DO
	/// </summary>
	public class CirulecfgAggDO : BaseAggDO
	{	
	    private static string CIRULECFG_CIRULECFGRELRULE="iih.ci.ord.cfg.cirulecfg.d.CiRuleCfgRelRule";

        public CirulecfgAggDO() {
            this.setParentDO(new CiRuleCfg());
        }

  	    public CiRuleCfg getParentDO() {
		    return ((CiRuleCfg) base.ParentDO);
	    }      
	    
	    public void setParentDO(CiRuleCfg headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public CiRuleCfgRelRule[] getCiRuleCfgRelRule() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CIRULECFG_CIRULECFGRELRULE));
		    if (dos == null || dos.Length==0){return null;}
            CiRuleCfgRelRule[] r = new CiRuleCfgRelRule[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as CiRuleCfgRelRule;
            }
	        return r;
		    
	    }
	    
	    public void setCiRuleCfgRelRule(CiRuleCfgRelRule[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new CiRuleCfg();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (CIRULECFG_CIRULECFGRELRULE == clzName)
	        {
                return new CiRuleCfgRelRule();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.ord.cfg.cirulecfg.d.CiRuleCfgRelRule"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

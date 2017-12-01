using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mrfp.other2mrfp.d
{
	/// <summary>
	/// 病案首页其他信息DO
	/// </summary>
	public class Other2mrfpAggDO : BaseAggDO
	{	
	    private static string CIMRFPOTHERDO_CIMRFPINTENCAREDO="iih.ci.mrfp.other2mrfp.d.CiMrfpIntenCareDO";

        public Other2mrfpAggDO() {
            this.setParentDO(new CiMrFpOtherDO());
        }

  	    public CiMrFpOtherDO getParentDO() {
		    return ((CiMrFpOtherDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(CiMrFpOtherDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public CiMrfpIntenCareDO[] getCiMrfpIntenCareDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CIMRFPOTHERDO_CIMRFPINTENCAREDO));
		    if (dos == null || dos.Length==0){return null;}
            CiMrfpIntenCareDO[] r = new CiMrfpIntenCareDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as CiMrfpIntenCareDO;
            }
	        return r;
		    
	    }
	    
	    public void setCiMrfpIntenCareDO(CiMrfpIntenCareDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new CiMrFpOtherDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (CIMRFPOTHERDO_CIMRFPINTENCAREDO == clzName)
	        {
                return new CiMrfpIntenCareDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mrfp.other2mrfp.d.CiMrfpIntenCareDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

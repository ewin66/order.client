using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.ord.ciprn.d
{
	/// <summary>
	/// 临床打印单DO
	/// </summary>
	public class CiprintAggDO : BaseAggDO
	{	
	    private static string CIPRNDO_CIPRNITMDO="iih.ci.ord.ciprn.d.CiPrnItmDO";

        public CiprintAggDO() {
            this.setParentDO(new CiPrnDO());
        }

  	    public CiPrnDO getParentDO() {
		    return ((CiPrnDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(CiPrnDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public CiPrnItmDO[] getCiPrnItmDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CIPRNDO_CIPRNITMDO));
		    if (dos == null || dos.Length==0){return null;}
            CiPrnItmDO[] r = new CiPrnItmDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as CiPrnItmDO;
            }
	        return r;
		    
	    }
	    
	    public void setCiPrnItmDO(CiPrnItmDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new CiPrnDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (CIPRNDO_CIPRNITMDO == clzName)
	        {
                return new CiPrnItmDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.ord.ciprn.d.CiPrnItmDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

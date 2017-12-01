using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.ord.cior.d
{
	/// <summary>
	/// 病理申请单DO
	/// </summary>
	public class CiorapppathgyAggDO : BaseAggDO
	{	
	    private static string ORDAPPATHGYDO_ORDAPPATHGYSAMPDO="iih.ci.ord.cior.d.OrdApPathgySampDO";

        public CiorapppathgyAggDO() {
            this.setParentDO(new OrdApPathgyDO());
        }

  	    public OrdApPathgyDO getParentDO() {
		    return ((OrdApPathgyDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(OrdApPathgyDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public OrdApPathgySampDO[] getOrdApPathgySampDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(ORDAPPATHGYDO_ORDAPPATHGYSAMPDO));
		    if (dos == null || dos.Length==0){return null;}
            OrdApPathgySampDO[] r = new OrdApPathgySampDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as OrdApPathgySampDO;
            }
	        return r;
		    
	    }
	    
	    public void setOrdApPathgySampDO(OrdApPathgySampDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new OrdApPathgyDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (ORDAPPATHGYDO_ORDAPPATHGYSAMPDO == clzName)
	        {
                return new OrdApPathgySampDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.ord.cior.d.OrdApPathgySampDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

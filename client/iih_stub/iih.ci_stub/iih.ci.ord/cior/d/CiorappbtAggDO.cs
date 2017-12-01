using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.ord.cior.d
{
	/// <summary>
	/// 备血申请单DO
	/// </summary>
	public class CiorappbtAggDO : BaseAggDO
	{	
	    private static string ORDAPBTDO_ORDAPBTVIEWITEMDO="iih.ci.ord.cior.d.OrdApBtViewItemDO";

        public CiorappbtAggDO() {
            this.setParentDO(new OrdApBtDO());
        }

  	    public OrdApBtDO getParentDO() {
		    return ((OrdApBtDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(OrdApBtDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public OrdApBtViewItemDO[] getOrdApBtViewItemDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(ORDAPBTDO_ORDAPBTVIEWITEMDO));
		    if (dos == null || dos.Length==0){return null;}
            OrdApBtViewItemDO[] r = new OrdApBtViewItemDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as OrdApBtViewItemDO;
            }
	        return r;
		    
	    }
	    
	    public void setOrdApBtViewItemDO(OrdApBtViewItemDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new OrdApBtDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (ORDAPBTDO_ORDAPBTVIEWITEMDO == clzName)
	        {
                return new OrdApBtViewItemDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.ord.cior.d.OrdApBtViewItemDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

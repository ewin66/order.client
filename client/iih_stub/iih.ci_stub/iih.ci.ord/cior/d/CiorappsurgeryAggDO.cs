using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.ord.cior.d
{
	/// <summary>
	/// 手术申请DO
	/// </summary>
	public class CiorappsurgeryAggDO : BaseAggDO
	{	
	    private static string ORDAPOPDO_ORDOPEMPDO="iih.ci.ord.cior.d.OrdOpEmpDO";
	    private static string ORDAPOPDO_ORDOPMMDO="iih.ci.ord.cior.d.OrdOpMmDO";
	    private static string ORDAPOPDO_ORDAPSUGVIEWITEMDO="iih.ci.ord.cior.d.OrdApSugViewItemDO";

        public CiorappsurgeryAggDO() {
            this.setParentDO(new OrdApOpDO());
        }

  	    public OrdApOpDO getParentDO() {
		    return ((OrdApOpDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(OrdApOpDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public OrdOpEmpDO[] getOrdOpEmpDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(ORDAPOPDO_ORDOPEMPDO));
		    if (dos == null || dos.Length==0){return null;}
            OrdOpEmpDO[] r = new OrdOpEmpDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as OrdOpEmpDO;
            }
	        return r;
		    
	    }
	    
	    public void setOrdOpEmpDO(OrdOpEmpDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }
	    public OrdOpMmDO[] getOrdOpMmDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(ORDAPOPDO_ORDOPMMDO));
		    if (dos == null || dos.Length==0){return null;}
            OrdOpMmDO[] r = new OrdOpMmDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as OrdOpMmDO;
            }
	        return r;
		    
	    }
	    
	    public void setOrdOpMmDO(OrdOpMmDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }
	    public OrdApSugViewItemDO[] getOrdApSugViewItemDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(ORDAPOPDO_ORDAPSUGVIEWITEMDO));
		    if (dos == null || dos.Length==0){return null;}
            OrdApSugViewItemDO[] r = new OrdApSugViewItemDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as OrdApSugViewItemDO;
            }
	        return r;
		    
	    }
	    
	    public void setOrdApSugViewItemDO(OrdApSugViewItemDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new OrdApOpDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (ORDAPOPDO_ORDOPEMPDO == clzName)
	        {
                return new OrdOpEmpDO();
	        }
           else if (ORDAPOPDO_ORDOPMMDO == clzName)
	        {
                return new OrdOpMmDO();
	        }
           else if (ORDAPOPDO_ORDAPSUGVIEWITEMDO == clzName)
	        {
                return new OrdApSugViewItemDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.ord.cior.d.OrdOpEmpDO","iih.ci.ord.cior.d.OrdOpMmDO","iih.ci.ord.cior.d.OrdApSugViewItemDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

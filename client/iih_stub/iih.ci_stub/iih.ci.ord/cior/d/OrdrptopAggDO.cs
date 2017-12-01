using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.ord.cior.d
{
	/// <summary>
	/// 医嘱手术记录DO
	/// </summary>
	public class OrdrptopAggDO : BaseAggDO
	{	
	    private static string ORDAPRPTOPDO_ORDAPRPTOPITEMDO="iih.ci.ord.cior.d.OrdApRptOpItemDO";
	    private static string ORDAPRPTOPDO_RPTOPEMPDO="iih.ci.ord.cior.d.RptOpEmpDO";

        public OrdrptopAggDO() {
            this.setParentDO(new OrdApRptOpDO());
        }

  	    public OrdApRptOpDO getParentDO() {
		    return ((OrdApRptOpDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(OrdApRptOpDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public OrdApRptOpItemDO[] getOrdApRptOpItemDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(ORDAPRPTOPDO_ORDAPRPTOPITEMDO));
		    if (dos == null || dos.Length==0){return null;}
            OrdApRptOpItemDO[] r = new OrdApRptOpItemDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as OrdApRptOpItemDO;
            }
	        return r;
		    
	    }
	    
	    public void setOrdApRptOpItemDO(OrdApRptOpItemDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }
	    public RptOpEmpDO[] getRptOpEmpDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(ORDAPRPTOPDO_RPTOPEMPDO));
		    if (dos == null || dos.Length==0){return null;}
            RptOpEmpDO[] r = new RptOpEmpDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as RptOpEmpDO;
            }
	        return r;
		    
	    }
	    
	    public void setRptOpEmpDO(RptOpEmpDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new OrdApRptOpDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (ORDAPRPTOPDO_ORDAPRPTOPITEMDO == clzName)
	        {
                return new OrdApRptOpItemDO();
	        }
           else if (ORDAPRPTOPDO_RPTOPEMPDO == clzName)
	        {
                return new RptOpEmpDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.ord.cior.d.OrdApRptOpItemDO","iih.ci.ord.cior.d.RptOpEmpDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

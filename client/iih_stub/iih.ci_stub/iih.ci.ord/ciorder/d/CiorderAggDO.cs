using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.ord.ciorder.d
{
	/// <summary>
	/// 临床医嘱DO
	/// </summary>
	public class CiorderAggDO : BaseAggDO
	{	
	    private static string CIORDERDO_ORDSRVDO="iih.ci.ord.ciorder.d.OrdSrvDO";
	    private static string CIORDERDO_ORDDRUGDO="iih.ci.ord.ciorder.d.OrdDrugDO";
	    private static string CIORDERDO_ORDFREQTIMEDO="iih.ci.ord.ciorder.d.OrdFreqTimeDO";

        public CiorderAggDO() {
            this.setParentDO(new CiOrderDO());
        }

  	    public CiOrderDO getParentDO() {
		    return ((CiOrderDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(CiOrderDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public OrdSrvDO[] getOrdSrvDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CIORDERDO_ORDSRVDO));
		    if (dos == null || dos.Length==0){return null;}
            OrdSrvDO[] r = new OrdSrvDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as OrdSrvDO;
            }
	        return r;
		    
	    }
	    
	    public void setOrdSrvDO(OrdSrvDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }
	    public OrdDrugDO[] getOrdDrugDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CIORDERDO_ORDDRUGDO));
		    if (dos == null || dos.Length==0){return null;}
            OrdDrugDO[] r = new OrdDrugDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as OrdDrugDO;
            }
	        return r;
		    
	    }
	    
	    public void setOrdDrugDO(OrdDrugDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }
	    public OrdFreqTimeDO[] getOrdFreqTimeDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CIORDERDO_ORDFREQTIMEDO));
		    if (dos == null || dos.Length==0){return null;}
            OrdFreqTimeDO[] r = new OrdFreqTimeDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as OrdFreqTimeDO;
            }
	        return r;
		    
	    }
	    
	    public void setOrdFreqTimeDO(OrdFreqTimeDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new CiOrderDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (CIORDERDO_ORDSRVDO == clzName)
	        {
                return new OrdSrvDO();
	        }
           else if (CIORDERDO_ORDDRUGDO == clzName)
	        {
                return new OrdDrugDO();
	        }
           else if (CIORDERDO_ORDFREQTIMEDO == clzName)
	        {
                return new OrdFreqTimeDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.ord.ciorder.d.OrdSrvDO","iih.ci.ord.ciorder.d.OrdDrugDO","iih.ci.ord.ciorder.d.OrdFreqTimeDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{ "OrdDrugDO"};
	        return meta;
	    }
	    
	}
}

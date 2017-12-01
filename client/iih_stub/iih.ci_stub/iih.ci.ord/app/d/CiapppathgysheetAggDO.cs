using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.ord.app.d
{
	/// <summary>
	/// 病理打印申请单DO
	/// </summary>
	public class CiapppathgysheetAggDO : BaseAggDO
	{	
	    private static string CIAPPPATHGYSHEETDO_CIAPPPATHGYSHEETSAMPDO="iih.ci.ord.app.d.CiAppPathgySheetSampDO";

        public CiapppathgysheetAggDO() {
            this.setParentDO(new CiAppPathgySheetDO());
        }

  	    public CiAppPathgySheetDO getParentDO() {
		    return ((CiAppPathgySheetDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(CiAppPathgySheetDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public CiAppPathgySheetSampDO[] getCiAppPathgySheetSampDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CIAPPPATHGYSHEETDO_CIAPPPATHGYSHEETSAMPDO));
		    if (dos == null || dos.Length==0){return null;}
            CiAppPathgySheetSampDO[] r = new CiAppPathgySheetSampDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as CiAppPathgySheetSampDO;
            }
	        return r;
		    
	    }
	    
	    public void setCiAppPathgySheetSampDO(CiAppPathgySheetSampDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new CiAppPathgySheetDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (CIAPPPATHGYSHEETDO_CIAPPPATHGYSHEETSAMPDO == clzName)
	        {
                return new CiAppPathgySheetSampDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.ord.app.d.CiAppPathgySheetSampDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

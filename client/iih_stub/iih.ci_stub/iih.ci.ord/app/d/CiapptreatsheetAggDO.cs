using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.ord.app.d
{
	/// <summary>
	/// 诊疗申请单DO
	/// </summary>
	public class CiapptreatsheetAggDO : BaseAggDO
	{	
	    private static string CIAPPTREATSHEETDO_CIAPPTREATSHEETORDO="iih.ci.ord.app.d.CiAppTreatSheetOrDO";

        public CiapptreatsheetAggDO() {
            this.setParentDO(new CiAppTreatSheetDO());
        }

  	    public CiAppTreatSheetDO getParentDO() {
		    return ((CiAppTreatSheetDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(CiAppTreatSheetDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public CiAppTreatSheetOrDO[] getCiAppTreatSheetOrDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CIAPPTREATSHEETDO_CIAPPTREATSHEETORDO));
		    if (dos == null || dos.Length==0){return null;}
            CiAppTreatSheetOrDO[] r = new CiAppTreatSheetOrDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as CiAppTreatSheetOrDO;
            }
	        return r;
		    
	    }
	    
	    public void setCiAppTreatSheetOrDO(CiAppTreatSheetOrDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new CiAppTreatSheetDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (CIAPPTREATSHEETDO_CIAPPTREATSHEETORDO == clzName)
	        {
                return new CiAppTreatSheetOrDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.ord.app.d.CiAppTreatSheetOrDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

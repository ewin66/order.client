using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.ord.app.d
{
	/// <summary>
	/// 检验申请单DO
	/// </summary>
	public class CiapplissheetAggDO : BaseAggDO
	{	
	    private static string CIAPPLISSHEETDO_CIAPPLISSHEETORDO="iih.ci.ord.app.d.CiAppLisSheetOrDO";

        public CiapplissheetAggDO() {
            this.setParentDO(new CiAppLisSheetDO());
        }

  	    public CiAppLisSheetDO getParentDO() {
		    return ((CiAppLisSheetDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(CiAppLisSheetDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public CiAppLisSheetOrDO[] getCiAppLisSheetOrDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CIAPPLISSHEETDO_CIAPPLISSHEETORDO));
		    if (dos == null || dos.Length==0){return null;}
            CiAppLisSheetOrDO[] r = new CiAppLisSheetOrDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as CiAppLisSheetOrDO;
            }
	        return r;
		    
	    }
	    
	    public void setCiAppLisSheetOrDO(CiAppLisSheetOrDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new CiAppLisSheetDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (CIAPPLISSHEETDO_CIAPPLISSHEETORDO == clzName)
	        {
                return new CiAppLisSheetOrDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.ord.app.d.CiAppLisSheetOrDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

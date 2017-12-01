using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mr.cimrvt.d
{
	/// <summary>
	/// 临床生命体征测量DO
	/// </summary>
	public class CimrvtAggDO : BaseAggDO
	{	
	    private static string CIMRVTDO_CIMRVTITMDO="iih.ci.mr.cimrvt.d.CiMrVtItmDO";
	    private static string CIMRVTDO_CIMRVTEVDO="iih.ci.mr.cimrvt.d.CiMrVtEvDO";

        public CimrvtAggDO() {
            this.setParentDO(new CiMrVtDO());
        }

  	    public CiMrVtDO getParentDO() {
		    return ((CiMrVtDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(CiMrVtDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public CiMrVtItmDO[] getCiMrVtItmDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CIMRVTDO_CIMRVTITMDO));
		    if (dos == null || dos.Length==0){return null;}
            CiMrVtItmDO[] r = new CiMrVtItmDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as CiMrVtItmDO;
            }
	        return r;
		    
	    }
	    
	    public void setCiMrVtItmDO(CiMrVtItmDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }
	    public CiMrVtEvDO[] getCiMrVtEvDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CIMRVTDO_CIMRVTEVDO));
		    if (dos == null || dos.Length==0){return null;}
            CiMrVtEvDO[] r = new CiMrVtEvDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as CiMrVtEvDO;
            }
	        return r;
		    
	    }
	    
	    public void setCiMrVtEvDO(CiMrVtEvDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new CiMrVtDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (CIMRVTDO_CIMRVTITMDO == clzName)
	        {
                return new CiMrVtItmDO();
	        }
           else if (CIMRVTDO_CIMRVTEVDO == clzName)
	        {
                return new CiMrVtEvDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mr.cimrvt.d.CiMrVtItmDO","iih.ci.mr.cimrvt.d.CiMrVtEvDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

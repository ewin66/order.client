using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mrfp.di2mrfp.d
{
	/// <summary>
	/// 住院病案首页_诊断DO
	/// </summary>
	public class Di2mrfpAggDO : BaseAggDO
	{	
	    private static string CIMRFPDIDO_CIMRFPXYDIDO="iih.ci.mrfp.di2mrfp.d.CiMrFpXydiDO";
	    private static string CIMRFPDIDO_CIMRFPZYDIDO="iih.ci.mrfp.di2mrfp.d.CiMrfpZydiDO";

        public Di2mrfpAggDO() {
            this.setParentDO(new CiMrfpDiDO());
        }

  	    public CiMrfpDiDO getParentDO() {
		    return ((CiMrfpDiDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(CiMrfpDiDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public CiMrFpXydiDO[] getCiMrFpXydiDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CIMRFPDIDO_CIMRFPXYDIDO));
		    if (dos == null || dos.Length==0){return null;}
            CiMrFpXydiDO[] r = new CiMrFpXydiDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as CiMrFpXydiDO;
            }
	        return r;
		    
	    }
	    
	    public void setCiMrFpXydiDO(CiMrFpXydiDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }
	    public CiMrfpZydiDO[] getCiMrfpZydiDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CIMRFPDIDO_CIMRFPZYDIDO));
		    if (dos == null || dos.Length==0){return null;}
            CiMrfpZydiDO[] r = new CiMrfpZydiDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as CiMrfpZydiDO;
            }
	        return r;
		    
	    }
	    
	    public void setCiMrfpZydiDO(CiMrfpZydiDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new CiMrfpDiDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (CIMRFPDIDO_CIMRFPXYDIDO == clzName)
	        {
                return new CiMrFpXydiDO();
	        }
           else if (CIMRFPDIDO_CIMRFPZYDIDO == clzName)
	        {
                return new CiMrfpZydiDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mrfp.di2mrfp.d.CiMrFpXydiDO","iih.ci.mrfp.di2mrfp.d.CiMrfpZydiDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

using System;
using xap.mw.core.data;

namespace iih.ci.diag.dto.d
{
	/// <summary>
	/// 诊断headdtoDTO
	/// </summary>
	public class DidtoAggDTO : BaseAggDO
	{	
	    private static string HEADDTO_CIDIDTOZY="iih.ci.diag.dto.d.Cididtozy";
	    private static string HEADDTO_CIDIXY="iih.ci.diag.dto.d.Cidixy";

        public DidtoAggDTO() {
            this.setParentDO(new Headdto());
        }

  	    public Headdto getParentDO() {
		    return ((Headdto) base.ParentDO);
	    }      
	    
	    public void setParentDO(Headdto headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public Cididtozy[] getCididtozy() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(HEADDTO_CIDIDTOZY));
		    if (dos == null || dos.Length==0){return null;}
            Cididtozy[] r = new Cididtozy[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as Cididtozy;
            }
	        return r;
		    
	    }
	    
	    public void setCididtozy(Cididtozy[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }
	    public Cidixy[] getCidixy() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(HEADDTO_CIDIXY));
		    if (dos == null || dos.Length==0){return null;}
            Cidixy[] r = new Cidixy[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as Cidixy;
            }
	        return r;
		    
	    }
	    
	    public void setCidixy(Cidixy[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new Headdto();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (HEADDTO_CIDIDTOZY == clzName)
	        {
                return new Cididtozy();
	        }
           else if (HEADDTO_CIDIXY == clzName)
	        {
                return new Cidixy();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.diag.dto.d.Cididtozy","iih.ci.diag.dto.d.Cidixy"};
        }
	    
	}
}

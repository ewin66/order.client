using System;
using xap.mw.core.data;

namespace iih.ci.ord.tmpl.d
{
	/// <summary>
	/// 临床医嘱模板DTODTO
	/// </summary>
	public class CiortmplAggDTO : BaseAggDO
	{	
	    private static string CIORTMPLDTO_CIORTMPLSRVDTO="iih.ci.ord.tmpl.d.CiOrTmplSrvDTO";

        public CiortmplAggDTO() {
            this.setParentDO(new CiOrTmplDTO());
        }

  	    public CiOrTmplDTO getParentDO() {
		    return ((CiOrTmplDTO) base.ParentDO);
	    }      
	    
	    public void setParentDO(CiOrTmplDTO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public CiOrTmplSrvDTO[] getCiOrTmplSrvDTO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CIORTMPLDTO_CIORTMPLSRVDTO));
		    if (dos == null || dos.Length==0){return null;}
            CiOrTmplSrvDTO[] r = new CiOrTmplSrvDTO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as CiOrTmplSrvDTO;
            }
	        return r;
		    
	    }
	    
	    public void setCiOrTmplSrvDTO(CiOrTmplSrvDTO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new CiOrTmplDTO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (CIORTMPLDTO_CIORTMPLSRVDTO == clzName)
	        {
                return new CiOrTmplSrvDTO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.ord.tmpl.d.CiOrTmplSrvDTO"};
        }
	    
	}
}

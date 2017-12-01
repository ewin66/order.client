using System;
using xap.mw.core.data;

namespace iih.ci.rcm.contagion.dto.d
{
	/// <summary>
	/// 组件DTO
	/// </summary>
	public class ContagiondtoAggDTO : BaseAggDO
	{	
	    private static string ENTDTO_CONTAGIONDTO="iih.ci.rcm.contagion.dto.d.Contagiondto";

        public ContagiondtoAggDTO() {
            this.setParentDO(new EntDto());
        }

  	    public EntDto getParentDO() {
		    return ((EntDto) base.ParentDO);
	    }      
	    
	    public void setParentDO(EntDto headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public Contagiondto[] getContagiondto() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(ENTDTO_CONTAGIONDTO));
		    if (dos == null || dos.Length==0){return null;}
            Contagiondto[] r = new Contagiondto[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as Contagiondto;
            }
	        return r;
		    
	    }
	    
	    public void setContagiondto(Contagiondto[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new EntDto();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (ENTDTO_CONTAGIONDTO == clzName)
	        {
                return new Contagiondto();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.rcm.contagion.dto.d.Contagiondto"};
        }
	    
	}
}

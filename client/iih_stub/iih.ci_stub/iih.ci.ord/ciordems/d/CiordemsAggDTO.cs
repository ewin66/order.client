using System;
using xap.mw.core.data;

namespace iih.ci.ord.ciordems.d
{
	/// <summary>
	/// 医嘱医疗单DTO
	/// </summary>
	public class CiordemsAggDTO : BaseAggDO
	{	
	    private static string EmsUIDTO_EMSDRUGITEMDO="iih.ci.ord.ciordems.d.EmsDrugItemDO";
	    private static string EmsUIDTO_EMSOBSITEMDO="iih.ci.ord.ciordems.d.EmsObsItemDO";
        private static string EmsUIDTO_ESMBT = "iih.ci.ord.ciordems.d.EmsBtItemDO";

        public CiordemsAggDTO() {
            this.setParentDO(new EmsUIDTO());
        }

  	    public EmsUIDTO getParentDO() {
		    return ((EmsUIDTO) base.ParentDO);
	    }      
	    
	    public void setParentDO(EmsUIDTO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public EmsDrugItemDO[] getEmsDrugItemDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(EmsUIDTO_EMSDRUGITEMDO));
		    if (dos == null || dos.Length==0){return null;}
            EmsDrugItemDO[] r = new EmsDrugItemDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as EmsDrugItemDO;
            }
	        return r;
		    
	    }
	    
	    public void setEmsDrugItemDO(EmsDrugItemDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }
	    public EmsObsItemDO[] getEmsObsItemDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(EmsUIDTO_EMSOBSITEMDO));
		    if (dos == null || dos.Length==0){return null;}
            EmsObsItemDO[] r = new EmsObsItemDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as EmsObsItemDO;
            }
	        return r;
		    
	    }
	    
	    public void setEmsObsItemDO(EmsObsItemDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }
        public EmsBtItemDO[] getEsmBt()
        {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(EmsUIDTO_ESMBT));
		    if (dos == null || dos.Length==0){return null;}
            EmsBtItemDO[] r = new EmsBtItemDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as EmsBtItemDO;
            }
	        return r;
		    
	    }

        public void setEsmBt(EmsBtItemDO[] dos)
        {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new EmsUIDTO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (EmsUIDTO_EMSDRUGITEMDO == clzName)
	        {
                return new EmsDrugItemDO();
	        }
           else if (EmsUIDTO_EMSOBSITEMDO == clzName)
	        {
                return new EmsObsItemDO();
	        }
           else if (EmsUIDTO_ESMBT == clzName)
	        {
                return new EmsBtItemDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return new string[] { "iih.ci.ord.ciordems.d.EmsDrugItemDO", "iih.ci.ord.ciordems.d.EmsObsItemDO", "iih.ci.ord.ciordems.d.EsmBtItemDO" };
        }
	    
	}
}

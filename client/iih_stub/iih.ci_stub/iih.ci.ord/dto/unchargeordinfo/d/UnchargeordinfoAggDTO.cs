using System;
using xap.mw.core.data;

namespace iih.ci.ord.dto.unchargeordinfo.d
{
	/// <summary>
	/// 未记账医嘱数据信息DTO
	/// </summary>
	public class UnchargeordinfoAggDTO : BaseAggDO
	{	
	    private static string UNCHARGEORDDTO_UNCHARGEORDSRVDTO="iih.ci.ord.dto.unchargeordinfo.d.UnchargeOrdSrvDTO";

        public UnchargeordinfoAggDTO() {
            this.setParentDO(new UnchargeOrdDTO());
        }

  	    public UnchargeOrdDTO getParentDO() {
		    return ((UnchargeOrdDTO) base.ParentDO);
	    }      
	    
	    public void setParentDO(UnchargeOrdDTO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public UnchargeOrdSrvDTO[] getUnchargeOrdSrvDTO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(UNCHARGEORDDTO_UNCHARGEORDSRVDTO));
		    if (dos == null || dos.Length==0){return null;}
            UnchargeOrdSrvDTO[] r = new UnchargeOrdSrvDTO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as UnchargeOrdSrvDTO;
            }
	        return r;
		    
	    }
	    
	    public void setUnchargeOrdSrvDTO(UnchargeOrdSrvDTO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new UnchargeOrdDTO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (UNCHARGEORDDTO_UNCHARGEORDSRVDTO == clzName)
	        {
                return new UnchargeOrdSrvDTO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.ord.dto.unchargeordinfo.d.UnchargeOrdSrvDTO"};
        }
	    
	}
}

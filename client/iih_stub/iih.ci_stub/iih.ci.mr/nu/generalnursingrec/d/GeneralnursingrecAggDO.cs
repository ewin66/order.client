using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mr.nu.generalnursingrec.d
{
	/// <summary>
	/// 一般护理记录DO
	/// </summary>
	public class GeneralnursingrecAggDO : BaseAggDO
	{	
	    private static string GENERALNURSINGDO_GENERALNURSINGRECDO="iih.ci.mr.nu.generalnursingrec.d.GeneralNursingRecDO";

        public GeneralnursingrecAggDO() {
            this.setParentDO(new GeneralNursingDO());
        }

  	    public GeneralNursingDO getParentDO() {
		    return ((GeneralNursingDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(GeneralNursingDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public GeneralNursingRecDO[] getGeneralNursingRecDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(GENERALNURSINGDO_GENERALNURSINGRECDO));
		    if (dos == null || dos.Length==0){return null;}
            GeneralNursingRecDO[] r = new GeneralNursingRecDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as GeneralNursingRecDO;
            }
	        return r;
		    
	    }
	    
	    public void setGeneralNursingRecDO(GeneralNursingRecDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new GeneralNursingDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (GENERALNURSINGDO_GENERALNURSINGRECDO == clzName)
	        {
                return new GeneralNursingRecDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mr.nu.generalnursingrec.d.GeneralNursingRecDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mr.nu.healthyedunsrec.d
{
	/// <summary>
	/// 健康教育记录DO
	/// </summary>
	public class HealthyedunsrecAggDO : BaseAggDO
	{	
	    private static string HEALTHYEDUNSDO_HEALTHYEDUNSRECDO="iih.ci.mr.nu.healthyedunsrec.d.HealthyEduNsRecDO";

        public HealthyedunsrecAggDO() {
            this.setParentDO(new HealthyEduNsDO());
        }

  	    public HealthyEduNsDO getParentDO() {
		    return ((HealthyEduNsDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(HealthyEduNsDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public HealthyEduNsRecDO[] getHealthyEduNsRecDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(HEALTHYEDUNSDO_HEALTHYEDUNSRECDO));
		    if (dos == null || dos.Length==0){return null;}
            HealthyEduNsRecDO[] r = new HealthyEduNsRecDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as HealthyEduNsRecDO;
            }
	        return r;
		    
	    }
	    
	    public void setHealthyEduNsRecDO(HealthyEduNsRecDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new HealthyEduNsDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (HEALTHYEDUNSDO_HEALTHYEDUNSRECDO == clzName)
	        {
                return new HealthyEduNsRecDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mr.nu.healthyedunsrec.d.HealthyEduNsRecDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

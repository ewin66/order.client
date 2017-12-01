using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mr.nu.painassessment.d
{
	/// <summary>
	/// 疼痛护理评估表DO
	/// </summary>
	public class PainassessmentAggDO : BaseAggDO
	{	
	    private static string PAINASSESSDO_PAINASSESSITMDO="iih.ci.mr.nu.painassessment.d.PainAssessItmDO";

        public PainassessmentAggDO() {
            this.setParentDO(new PainAssessDO());
        }

  	    public PainAssessDO getParentDO() {
		    return ((PainAssessDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(PainAssessDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public PainAssessItmDO[] getPainAssessItmDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(PAINASSESSDO_PAINASSESSITMDO));
		    if (dos == null || dos.Length==0){return null;}
            PainAssessItmDO[] r = new PainAssessItmDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as PainAssessItmDO;
            }
	        return r;
		    
	    }
	    
	    public void setPainAssessItmDO(PainAssessItmDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new PainAssessDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (PAINASSESSDO_PAINASSESSITMDO == clzName)
	        {
                return new PainAssessItmDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mr.nu.painassessment.d.PainAssessItmDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

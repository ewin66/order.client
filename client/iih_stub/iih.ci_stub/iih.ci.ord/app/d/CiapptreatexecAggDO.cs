using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.ord.app.d
{
	/// <summary>
	/// 门诊诊疗执行单DO
	/// </summary>
	public class CiapptreatexecAggDO : BaseAggDO
	{	
	    private static string CIAPPTREATEXECDO_CIAPPTREATEXECORDO="iih.ci.ord.app.d.CiAppTreatExecOrDO";

        public CiapptreatexecAggDO() {
            this.setParentDO(new CiAppTreatExecDO());
        }

  	    public CiAppTreatExecDO getParentDO() {
		    return ((CiAppTreatExecDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(CiAppTreatExecDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public CiAppTreatExecOrDO[] getCiAppTreatExecOrDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CIAPPTREATEXECDO_CIAPPTREATEXECORDO));
		    if (dos == null || dos.Length==0){return null;}
            CiAppTreatExecOrDO[] r = new CiAppTreatExecOrDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as CiAppTreatExecOrDO;
            }
	        return r;
		    
	    }
	    
	    public void setCiAppTreatExecOrDO(CiAppTreatExecOrDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new CiAppTreatExecDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (CIAPPTREATEXECDO_CIAPPTREATEXECORDO == clzName)
	        {
                return new CiAppTreatExecOrDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.ord.app.d.CiAppTreatExecOrDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

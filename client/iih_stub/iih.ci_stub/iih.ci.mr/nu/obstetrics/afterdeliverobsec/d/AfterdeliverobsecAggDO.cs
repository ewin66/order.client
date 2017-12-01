using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mr.nu.obstetrics.afterdeliverobsec.d
{
	/// <summary>
	/// 产后观察记录DO
	/// </summary>
	public class AfterdeliverobsecAggDO : BaseAggDO
	{	
	    private static string AFTERDELIVEINFODO_AFTERDELIVERECDO="iih.ci.mr.nu.obstetrics.afterdeliverobsec.d.AfterDeliveRecDO";

        public AfterdeliverobsecAggDO() {
            this.setParentDO(new AfterDeliveInfoDO());
        }

  	    public AfterDeliveInfoDO getParentDO() {
		    return ((AfterDeliveInfoDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(AfterDeliveInfoDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public AfterDeliveRecDO[] getAfterDeliveRecDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(AFTERDELIVEINFODO_AFTERDELIVERECDO));
		    if (dos == null || dos.Length==0){return null;}
            AfterDeliveRecDO[] r = new AfterDeliveRecDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as AfterDeliveRecDO;
            }
	        return r;
		    
	    }
	    
	    public void setAfterDeliveRecDO(AfterDeliveRecDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new AfterDeliveInfoDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (AFTERDELIVEINFODO_AFTERDELIVERECDO == clzName)
	        {
                return new AfterDeliveRecDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mr.nu.obstetrics.afterdeliverobsec.d.AfterDeliveRecDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

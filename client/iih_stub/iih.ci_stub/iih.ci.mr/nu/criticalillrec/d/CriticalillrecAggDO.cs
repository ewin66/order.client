using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mr.nu.criticalillrec.d
{
	/// <summary>
	/// 危重症护理记录单DO
	/// </summary>
	public class CriticalillrecAggDO : BaseAggDO
	{	
	    private static string CRITICALILLDO_CRITICALILLRECDO="iih.ci.mr.nu.criticalillrec.d.CriticalillRecDO";

        public CriticalillrecAggDO() {
            this.setParentDO(new CriticalillDO());
        }

  	    public CriticalillDO getParentDO() {
		    return ((CriticalillDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(CriticalillDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public CriticalillRecDO[] getCriticalillRecDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CRITICALILLDO_CRITICALILLRECDO));
		    if (dos == null || dos.Length==0){return null;}
            CriticalillRecDO[] r = new CriticalillRecDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as CriticalillRecDO;
            }
	        return r;
		    
	    }
	    
	    public void setCriticalillRecDO(CriticalillRecDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new CriticalillDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (CRITICALILLDO_CRITICALILLRECDO == clzName)
	        {
                return new CriticalillRecDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mr.nu.criticalillrec.d.CriticalillRecDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

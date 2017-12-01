using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mr.nu.obstetrics.gynurbefore.d
{
	/// <summary>
	/// 妇科护理记录单(非手术、术前)DO
	/// </summary>
	public class GynurbeforeAggDO : BaseAggDO
	{	
	    private static string GYNURBEFOREASSDO_GYNURBEFORERECDO="iih.ci.mr.nu.obstetrics.gynurbefore.d.GyNurBeforeRecDO";

        public GynurbeforeAggDO() {
            this.setParentDO(new GyNurBeforeAssDO());
        }

  	    public GyNurBeforeAssDO getParentDO() {
		    return ((GyNurBeforeAssDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(GyNurBeforeAssDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public GyNurBeforeRecDO[] getGyNurBeforeRecDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(GYNURBEFOREASSDO_GYNURBEFORERECDO));
		    if (dos == null || dos.Length==0){return null;}
            GyNurBeforeRecDO[] r = new GyNurBeforeRecDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as GyNurBeforeRecDO;
            }
	        return r;
		    
	    }
	    
	    public void setGyNurBeforeRecDO(GyNurBeforeRecDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new GyNurBeforeAssDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (GYNURBEFOREASSDO_GYNURBEFORERECDO == clzName)
	        {
                return new GyNurBeforeRecDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mr.nu.obstetrics.gynurbefore.d.GyNurBeforeRecDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

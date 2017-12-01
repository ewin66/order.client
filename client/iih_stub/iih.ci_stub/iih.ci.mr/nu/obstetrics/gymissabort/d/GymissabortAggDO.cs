using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mr.nu.obstetrics.gymissabort.d
{
	/// <summary>
	/// 妇科稽留流产护理记录单DO
	/// </summary>
	public class GymissabortAggDO : BaseAggDO
	{	
	    private static string GYMISSABORTASSDO_GYMISSABORTRECDO="iih.ci.mr.nu.obstetrics.gymissabort.d.GyMissAbortRecDO";

        public GymissabortAggDO() {
            this.setParentDO(new GyMissAbortAssDO());
        }

  	    public GyMissAbortAssDO getParentDO() {
		    return ((GyMissAbortAssDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(GyMissAbortAssDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public GyMissAbortRecDO[] getGyMissAbortRecDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(GYMISSABORTASSDO_GYMISSABORTRECDO));
		    if (dos == null || dos.Length==0){return null;}
            GyMissAbortRecDO[] r = new GyMissAbortRecDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as GyMissAbortRecDO;
            }
	        return r;
		    
	    }
	    
	    public void setGyMissAbortRecDO(GyMissAbortRecDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new GyMissAbortAssDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (GYMISSABORTASSDO_GYMISSABORTRECDO == clzName)
	        {
                return new GyMissAbortRecDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mr.nu.obstetrics.gymissabort.d.GyMissAbortRecDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

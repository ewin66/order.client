using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mr.nu.obstetrics.gynurafter.d
{
	/// <summary>
	/// 妇科护理记录单(术后)DO
	/// </summary>
	public class GynurafterAggDO : BaseAggDO
	{	
	    private static string GYNURAFTERASSDO_GYNURAFTERRECDO="iih.ci.mr.nu.obstetrics.gynurafter.d.GyNurAfterRecDO";

        public GynurafterAggDO() {
            this.setParentDO(new GyNurAfterAssDO());
        }

  	    public GyNurAfterAssDO getParentDO() {
		    return ((GyNurAfterAssDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(GyNurAfterAssDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public GyNurAfterRecDO[] getGyNurAfterRecDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(GYNURAFTERASSDO_GYNURAFTERRECDO));
		    if (dos == null || dos.Length==0){return null;}
            GyNurAfterRecDO[] r = new GyNurAfterRecDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as GyNurAfterRecDO;
            }
	        return r;
		    
	    }
	    
	    public void setGyNurAfterRecDO(GyNurAfterRecDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new GyNurAfterAssDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (GYNURAFTERASSDO_GYNURAFTERRECDO == clzName)
	        {
                return new GyNurAfterRecDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mr.nu.obstetrics.gynurafter.d.GyNurAfterRecDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

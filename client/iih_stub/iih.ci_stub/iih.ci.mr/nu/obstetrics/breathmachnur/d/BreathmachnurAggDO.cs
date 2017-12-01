using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mr.nu.obstetrics.breathmachnur.d
{
	/// <summary>
	/// 呼吸机治疗观察记录单DO
	/// </summary>
	public class BreathmachnurAggDO : BaseAggDO
	{	
	    private static string BREATHMACHINFODO_BREATHMACHRECDO="iih.ci.mr.nu.obstetrics.breathmachnur.d.BreathMachRecDO";

        public BreathmachnurAggDO() {
            this.setParentDO(new BreathMachInfoDO());
        }

  	    public BreathMachInfoDO getParentDO() {
		    return ((BreathMachInfoDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(BreathMachInfoDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public BreathMachRecDO[] getBreathMachRecDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(BREATHMACHINFODO_BREATHMACHRECDO));
		    if (dos == null || dos.Length==0){return null;}
            BreathMachRecDO[] r = new BreathMachRecDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as BreathMachRecDO;
            }
	        return r;
		    
	    }
	    
	    public void setBreathMachRecDO(BreathMachRecDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new BreathMachInfoDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (BREATHMACHINFODO_BREATHMACHRECDO == clzName)
	        {
                return new BreathMachRecDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mr.nu.obstetrics.breathmachnur.d.BreathMachRecDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

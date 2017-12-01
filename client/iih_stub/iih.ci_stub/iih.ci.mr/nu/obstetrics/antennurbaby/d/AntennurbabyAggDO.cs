using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mr.nu.obstetrics.antennurbaby.d
{
	/// <summary>
	/// 产科婴儿护理记录DO
	/// </summary>
	public class AntennurbabyAggDO : BaseAggDO
	{	
	    private static string ANTNURBABYDO_ANTNURBABYBRSERDO="iih.ci.mr.nu.obstetrics.antennurbaby.d.AntNurBabyBrserDO";

        public AntennurbabyAggDO() {
            this.setParentDO(new AntNurBabyDO());
        }

  	    public AntNurBabyDO getParentDO() {
		    return ((AntNurBabyDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(AntNurBabyDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public AntNurBabyBrserDO[] getAntNurBabyBrserDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(ANTNURBABYDO_ANTNURBABYBRSERDO));
		    if (dos == null || dos.Length==0){return null;}
            AntNurBabyBrserDO[] r = new AntNurBabyBrserDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as AntNurBabyBrserDO;
            }
	        return r;
		    
	    }
	    
	    public void setAntNurBabyBrserDO(AntNurBabyBrserDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new AntNurBabyDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (ANTNURBABYDO_ANTNURBABYBRSERDO == clzName)
	        {
                return new AntNurBabyBrserDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mr.nu.obstetrics.antennurbaby.d.AntNurBabyBrserDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mr.per.d
{
	/// <summary>
	/// 组件DO
	/// </summary>
	public class PerAggDO : BaseAggDO
	{	
	    private static string PERDO_PERLISTDO="iih.ci.mr.per.d.PerListDO";

        public PerAggDO() {
            this.setParentDO(new PerDO());
        }

  	    public PerDO getParentDO() {
		    return ((PerDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(PerDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public PerListDO[] getPerListDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(PERDO_PERLISTDO));
		    if (dos == null || dos.Length==0){return null;}
            PerListDO[] r = new PerListDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as PerListDO;
            }
	        return r;
		    
	    }
	    
	    public void setPerListDO(PerListDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new PerDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (PERDO_PERLISTDO == clzName)
	        {
                return new PerListDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mr.per.d.PerListDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

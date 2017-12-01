using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.ord.cirptlab.d
{
	/// <summary>
	/// 组件DO
	/// </summary>
	public class CirptlabAggDO : BaseAggDO
	{	
	    private static string CIRPTLABDO_CIRPTLABITMDO="iih.ci.ord.cirptlab.d.CiRptLabItmDO";

        public CirptlabAggDO() {
            this.setParentDO(new CiRptLabDO());
        }

  	    public CiRptLabDO getParentDO() {
		    return ((CiRptLabDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(CiRptLabDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public CiRptLabItmDO[] getCiRptLabItmDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CIRPTLABDO_CIRPTLABITMDO));
		    if (dos == null || dos.Length==0){return null;}
            CiRptLabItmDO[] r = new CiRptLabItmDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as CiRptLabItmDO;
            }
	        return r;
		    
	    }
	    
	    public void setCiRptLabItmDO(CiRptLabItmDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new CiRptLabDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (CIRPTLABDO_CIRPTLABITMDO == clzName)
	        {
                return new CiRptLabItmDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.ord.cirptlab.d.CiRptLabItmDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.ord.cior.d
{
	/// <summary>
	/// 备血检验结果DO
	/// </summary>
	public class CiordrptbttestAggDO : BaseAggDO
	{	
	    private static string CIORDBTTESTDO_CIORDBTTESTITMDO="iih.ci.ord.cior.d.CiOrdBtTestItmDO";

        public CiordrptbttestAggDO() {
            this.setParentDO(new CiOrdBtTestDO());
        }

  	    public CiOrdBtTestDO getParentDO() {
		    return ((CiOrdBtTestDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(CiOrdBtTestDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public CiOrdBtTestItmDO[] getCiOrdBtTestItmDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CIORDBTTESTDO_CIORDBTTESTITMDO));
		    if (dos == null || dos.Length==0){return null;}
            CiOrdBtTestItmDO[] r = new CiOrdBtTestItmDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as CiOrdBtTestItmDO;
            }
	        return r;
		    
	    }
	    
	    public void setCiOrdBtTestItmDO(CiOrdBtTestItmDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new CiOrdBtTestDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (CIORDBTTESTDO_CIORDBTTESTITMDO == clzName)
	        {
                return new CiOrdBtTestItmDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.ord.cior.d.CiOrdBtTestItmDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

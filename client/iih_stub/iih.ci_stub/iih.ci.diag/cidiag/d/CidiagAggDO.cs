using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.diag.cidiag.d
{
	/// <summary>
	/// 临床诊断DO
	/// </summary>
	public class CidiagAggDO : BaseAggDO
	{	
	    private static string CIDIAGDO_CIDIAGITEMDO="iih.ci.diag.cidiag.d.CiDiagItemDO";

        public CidiagAggDO() {
            this.setParentDO(new CiDiagDO());
        }

  	    public CiDiagDO getParentDO() {
		    return ((CiDiagDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(CiDiagDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public CiDiagItemDO[] getCiDiagItemDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CIDIAGDO_CIDIAGITEMDO));
		    if (dos == null || dos.Length==0){return null;}
            CiDiagItemDO[] r = new CiDiagItemDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as CiDiagItemDO;
            }
	        return r;
		    
	    }
	    
	    public void setCiDiagItemDO(CiDiagItemDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new CiDiagDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (CIDIAGDO_CIDIAGITEMDO == clzName)
	        {
                return new CiDiagItemDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.diag.cidiag.d.CiDiagItemDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

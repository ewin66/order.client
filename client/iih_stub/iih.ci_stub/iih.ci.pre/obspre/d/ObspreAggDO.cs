using System;
using xap.mw.core.data;

namespace iih.ci.pre.obspre.d
{
	/// <summary>
	/// 预检DO
	/// </summary>
	public class ObspreAggDO : BaseAggDO
	{	
	    private static string OBSPREDO_OBSPRESRVDO="iih.ci.pre.obspre.d.ObsPreSrvDO";

        public ObspreAggDO() {
            this.setParentDO(new ObsPreDO());
        }

  	    public ObsPreDO getParentDO() {
		    return ((ObsPreDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(ObsPreDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public ObsPreSrvDO[] getObsPreSrvDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(OBSPREDO_OBSPRESRVDO));
		    if (dos == null || dos.Length==0){return null;}
            ObsPreSrvDO[] r = new ObsPreSrvDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as ObsPreSrvDO;
            }
	        return r;
		    
	    }
	    
	    public void setObsPreSrvDO(ObsPreSrvDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new ObsPreDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (OBSPREDO_OBSPRESRVDO == clzName)
	        {
                return new ObsPreSrvDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.pre.obspre.d.ObsPreSrvDO"};
        }
	    
	}
}

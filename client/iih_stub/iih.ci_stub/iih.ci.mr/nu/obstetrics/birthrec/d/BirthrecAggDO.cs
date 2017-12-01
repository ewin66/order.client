using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mr.nu.obstetrics.birthrec.d
{
	/// <summary>
	/// 临产记录DO
	/// </summary>
	public class BirthrecAggDO : BaseAggDO
	{	
	    private static string BIRTHRECINFODO_BIRTHRECINDO="iih.ci.mr.nu.obstetrics.birthrec.d.BirthrecInDO";
	    private static string BIRTHRECINFODO_BIRTHRECPRODO="iih.ci.mr.nu.obstetrics.birthrec.d.BirthrecProDO";

        public BirthrecAggDO() {
            this.setParentDO(new BirthrecInfoDO());
        }

  	    public BirthrecInfoDO getParentDO() {
		    return ((BirthrecInfoDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(BirthrecInfoDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public BirthrecInDO[] getBirthrecInDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(BIRTHRECINFODO_BIRTHRECINDO));
		    if (dos == null || dos.Length==0){return null;}
            BirthrecInDO[] r = new BirthrecInDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as BirthrecInDO;
            }
	        return r;
		    
	    }
	    
	    public void setBirthrecInDO(BirthrecInDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }
	    public BirthrecProDO[] getBirthrecProDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(BIRTHRECINFODO_BIRTHRECPRODO));
		    if (dos == null || dos.Length==0){return null;}
            BirthrecProDO[] r = new BirthrecProDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as BirthrecProDO;
            }
	        return r;
		    
	    }
	    
	    public void setBirthrecProDO(BirthrecProDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new BirthrecInfoDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (BIRTHRECINFODO_BIRTHRECINDO == clzName)
	        {
                return new BirthrecInDO();
	        }
           else if (BIRTHRECINFODO_BIRTHRECPRODO == clzName)
	        {
                return new BirthrecProDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mr.nu.obstetrics.birthrec.d.BirthrecInDO","iih.ci.mr.nu.obstetrics.birthrec.d.BirthrecProDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

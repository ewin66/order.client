using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mr.nu.chidrenass.d
{
	/// <summary>
	/// 高危儿观察护理记录单DO
	/// </summary>
	public class ChidrenassAggDO : BaseAggDO
	{	
	    private static string CHILDRENINASSEDO_CHILDRENINASSENURRECORDDO="iih.ci.mr.nu.chidrenass.d.ChildrenInAsseNurRecordDO";

        public ChidrenassAggDO() {
            this.setParentDO(new ChildrenInAsseDO());
        }

  	    public ChildrenInAsseDO getParentDO() {
		    return ((ChildrenInAsseDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(ChildrenInAsseDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public ChildrenInAsseNurRecordDO[] getChildrenInAsseNurRecordDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CHILDRENINASSEDO_CHILDRENINASSENURRECORDDO));
		    if (dos == null || dos.Length==0){return null;}
            ChildrenInAsseNurRecordDO[] r = new ChildrenInAsseNurRecordDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as ChildrenInAsseNurRecordDO;
            }
	        return r;
		    
	    }
	    
	    public void setChildrenInAsseNurRecordDO(ChildrenInAsseNurRecordDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new ChildrenInAsseDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (CHILDRENINASSEDO_CHILDRENINASSENURRECORDDO == clzName)
	        {
                return new ChildrenInAsseNurRecordDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mr.nu.chidrenass.d.ChildrenInAsseNurRecordDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

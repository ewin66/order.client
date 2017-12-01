using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mr.nu.newbabypicc.d
{
	/// <summary>
	/// 新生儿科picc护理信息DO
	/// </summary>
	public class NewbabypiccAggDO : BaseAggDO
	{	
	    private static string NEWBABYPICCDO_NEWBABYPICCRECDO="iih.ci.mr.nu.newbabypicc.d.NewBabyPiccRecDO";

        public NewbabypiccAggDO() {
            this.setParentDO(new NewBabyPiccDO());
        }

  	    public NewBabyPiccDO getParentDO() {
		    return ((NewBabyPiccDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(NewBabyPiccDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public NewBabyPiccRecDO[] getNewBabyPiccRecDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(NEWBABYPICCDO_NEWBABYPICCRECDO));
		    if (dos == null || dos.Length==0){return null;}
            NewBabyPiccRecDO[] r = new NewBabyPiccRecDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as NewBabyPiccRecDO;
            }
	        return r;
		    
	    }
	    
	    public void setNewBabyPiccRecDO(NewBabyPiccRecDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new NewBabyPiccDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (NEWBABYPICCDO_NEWBABYPICCRECDO == clzName)
	        {
                return new NewBabyPiccRecDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mr.nu.newbabypicc.d.NewBabyPiccRecDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

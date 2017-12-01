using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mr.nu.newbornveinnur.d
{
	/// <summary>
	/// 新生儿科脐静脉护理记录单（一）DO
	/// </summary>
	public class NewbornveinnurAggDO : BaseAggDO
	{	
	    private static string NEWBORNVEINNURDO_NEWBORNVEINNURRECORDDO="iih.ci.mr.nu.newbornveinnur.d.NewBornVeinNurRecordDO";

        public NewbornveinnurAggDO() {
            this.setParentDO(new NewBornVeinNurDO());
        }

  	    public NewBornVeinNurDO getParentDO() {
		    return ((NewBornVeinNurDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(NewBornVeinNurDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public NewBornVeinNurRecordDO[] getNewBornVeinNurRecordDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(NEWBORNVEINNURDO_NEWBORNVEINNURRECORDDO));
		    if (dos == null || dos.Length==0){return null;}
            NewBornVeinNurRecordDO[] r = new NewBornVeinNurRecordDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as NewBornVeinNurRecordDO;
            }
	        return r;
		    
	    }
	    
	    public void setNewBornVeinNurRecordDO(NewBornVeinNurRecordDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new NewBornVeinNurDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (NEWBORNVEINNURDO_NEWBORNVEINNURRECORDDO == clzName)
	        {
                return new NewBornVeinNurRecordDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mr.nu.newbornveinnur.d.NewBornVeinNurRecordDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

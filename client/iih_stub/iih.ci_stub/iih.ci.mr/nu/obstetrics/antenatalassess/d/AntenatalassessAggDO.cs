using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mr.nu.obstetrics.antenatalassess.d
{
	/// <summary>
	/// 产科护理记录单(产后、术后)DO
	/// </summary>
	public class AntenatalassessAggDO : BaseAggDO
	{	
	    private static string ANTENASSDO_ANTENNURBSERRECDO="iih.ci.mr.nu.obstetrics.antenatalassess.d.AntenNurBserRecDO";

        public AntenatalassessAggDO() {
            this.setParentDO(new AntenAssDO());
        }

  	    public AntenAssDO getParentDO() {
		    return ((AntenAssDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(AntenAssDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public AntenNurBserRecDO[] getAntenNurBserRecDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(ANTENASSDO_ANTENNURBSERRECDO));
		    if (dos == null || dos.Length==0){return null;}
            AntenNurBserRecDO[] r = new AntenNurBserRecDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as AntenNurBserRecDO;
            }
	        return r;
		    
	    }
	    
	    public void setAntenNurBserRecDO(AntenNurBserRecDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new AntenAssDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (ANTENASSDO_ANTENNURBSERRECDO == clzName)
	        {
                return new AntenNurBserRecDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mr.nu.obstetrics.antenatalassess.d.AntenNurBserRecDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

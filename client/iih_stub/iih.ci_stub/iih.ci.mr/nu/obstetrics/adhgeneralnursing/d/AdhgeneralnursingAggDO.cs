using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mr.nu.obstetrics.adhgeneralnursing.d
{
	/// <summary>
	/// 妇产科护理观察记录DO
	/// </summary>
	public class AdhgeneralnursingAggDO : BaseAggDO
	{	
	    private static string ADHNURSINGDO_ADHNURSINGRECDO="iih.ci.mr.nu.obstetrics.adhgeneralnursing.d.AdhNursingRecDO";

        public AdhgeneralnursingAggDO() {
            this.setParentDO(new AdhNursingDO());
        }

  	    public AdhNursingDO getParentDO() {
		    return ((AdhNursingDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(AdhNursingDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public AdhNursingRecDO[] getAdhNursingRecDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(ADHNURSINGDO_ADHNURSINGRECDO));
		    if (dos == null || dos.Length==0){return null;}
            AdhNursingRecDO[] r = new AdhNursingRecDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as AdhNursingRecDO;
            }
	        return r;
		    
	    }
	    
	    public void setAdhNursingRecDO(AdhNursingRecDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new AdhNursingDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (ADHNURSINGDO_ADHNURSINGRECDO == clzName)
	        {
                return new AdhNursingRecDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mr.nu.obstetrics.adhgeneralnursing.d.AdhNursingRecDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

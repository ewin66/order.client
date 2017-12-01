using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.mr.nu.obstetrics.opernurecord.d
{
	/// <summary>
	/// 手术护理记录单DO
	/// </summary>
	public class OpernurecordAggDO : BaseAggDO
	{	
	    private static string OPERNURECORDDO_OPERNURECORDEQMDO="iih.ci.mr.nu.obstetrics.opernurecord.d.OperNuRecordEqmDO";
	    private static string OPERNURECORDDO_OPERNURECORDDRESSDO="iih.ci.mr.nu.obstetrics.opernurecord.d.OperNuRecordDressDO";

        public OpernurecordAggDO() {
            this.setParentDO(new OperNuRecordDO());
        }

  	    public OperNuRecordDO getParentDO() {
		    return ((OperNuRecordDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(OperNuRecordDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public OperNuRecordEqmDO[] getOperNuRecordEqmDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(OPERNURECORDDO_OPERNURECORDEQMDO));
		    if (dos == null || dos.Length==0){return null;}
            OperNuRecordEqmDO[] r = new OperNuRecordEqmDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as OperNuRecordEqmDO;
            }
	        return r;
		    
	    }
	    
	    public void setOperNuRecordEqmDO(OperNuRecordEqmDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }
	    public OperNuRecordDressDO[] getOperNuRecordDressDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(OPERNURECORDDO_OPERNURECORDDRESSDO));
		    if (dos == null || dos.Length==0){return null;}
            OperNuRecordDressDO[] r = new OperNuRecordDressDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as OperNuRecordDressDO;
            }
	        return r;
		    
	    }
	    
	    public void setOperNuRecordDressDO(OperNuRecordDressDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new OperNuRecordDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (OPERNURECORDDO_OPERNURECORDEQMDO == clzName)
	        {
                return new OperNuRecordEqmDO();
	        }
           else if (OPERNURECORDDO_OPERNURECORDDRESSDO == clzName)
	        {
                return new OperNuRecordDressDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.mr.nu.obstetrics.opernurecord.d.OperNuRecordEqmDO","iih.ci.mr.nu.obstetrics.opernurecord.d.OperNuRecordDressDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

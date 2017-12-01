using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.ord.cior.d
{
	/// <summary>
	/// 会诊申请单DO
	/// </summary>
	public class CiorappconsultAggDO : BaseAggDO
	{	
	    private static string ORDAPCONSDO_CIORDINVITECONSDO="iih.ci.ord.cior.d.CiordInviteConsDO";
	    private static string ORDAPCONSDO_ORCONSAPAUDITDO="iih.ci.ord.cior.d.OrConsApAuditDO";

        public CiorappconsultAggDO() {
            this.setParentDO(new OrdApConsDO());
        }

  	    public OrdApConsDO getParentDO() {
		    return ((OrdApConsDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(OrdApConsDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public CiordInviteConsDO[] getCiordInviteConsDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(ORDAPCONSDO_CIORDINVITECONSDO));
		    if (dos == null || dos.Length==0){return null;}
            CiordInviteConsDO[] r = new CiordInviteConsDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as CiordInviteConsDO;
            }
	        return r;
		    
	    }
	    
	    public void setCiordInviteConsDO(CiordInviteConsDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }
	    public OrConsApAuditDO[] getOrConsApAuditDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(ORDAPCONSDO_ORCONSAPAUDITDO));
		    if (dos == null || dos.Length==0){return null;}
            OrConsApAuditDO[] r = new OrConsApAuditDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as OrConsApAuditDO;
            }
	        return r;
		    
	    }
	    
	    public void setOrConsApAuditDO(OrConsApAuditDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new OrdApConsDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (ORDAPCONSDO_CIORDINVITECONSDO == clzName)
	        {
                return new CiordInviteConsDO();
	        }
           else if (ORDAPCONSDO_ORCONSAPAUDITDO == clzName)
	        {
                return new OrConsApAuditDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.ord.cior.d.CiordInviteConsDO","iih.ci.ord.cior.d.OrConsApAuditDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}

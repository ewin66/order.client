using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.auditdto.d
{
    /// <summary>
    /// AuditDTO 的摘要说明。
    /// </summary>
    public class AuditDTO : BaseDTO {

        public AuditDTO() {
 
        }

        /// <summary>
        /// 审核日期
        /// </summary>
		public DateTime? Dt_audit {
            get { return getAttrVal<FDateTime>("Dt_audit",null); }
            set { setAttrVal<FDateTime>("Dt_audit", value); }
        }

        /// <summary>
        /// 审核医生编码
        /// </summary>
		public string Code_audit_doc {
            get { return getAttrVal<string>("Code_audit_doc",null); }
            set { setAttrVal<string>("Code_audit_doc", value); }
        }

        /// <summary>
        /// 审核医生名称
        /// </summary>
		public string Audit_doc {
            get { return getAttrVal<string>("Audit_doc",null); }
            set { setAttrVal<string>("Audit_doc", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Dt_audit", "Code_audit_doc", "Audit_doc"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.auditdto.d.AuditDTO";
        }
    }
}

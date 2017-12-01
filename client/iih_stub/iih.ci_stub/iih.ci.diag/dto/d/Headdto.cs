using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.diag.dto.d
{
    /// <summary>
    /// Headdto 的摘要说明。
    /// </summary>
    public class Headdto : BaseDTO {

        public Headdto() {
 
        }

        /// <summary>
        /// 类型
        /// </summary>
		public string Id_ditp {
            get { return getAttrVal<string>("Id_ditp",null); }
            set { setAttrVal<string>("Id_ditp", value); }
        }

        /// <summary>
        /// 类型名称
        /// </summary>
		public string Id_ditp_name {
            get { return getAttrVal<string>("Id_ditp_name",null); }
            set { setAttrVal<string>("Id_ditp_name", value); }
        }

        /// <summary>
        /// 类型编码
        /// </summary>
		public string Id_ditp_code {
            get { return getAttrVal<string>("Id_ditp_code",null); }
            set { setAttrVal<string>("Id_ditp_code", value); }
        }

        /// <summary>
        /// 诊断医生
        /// </summary>
		public string Id_emp_create {
            get { return getAttrVal<string>("Id_emp_create",null); }
            set { setAttrVal<string>("Id_emp_create", value); }
        }

        /// <summary>
        /// 诊断医生名称
        /// </summary>
		public string Id_emp_create_name {
            get { return getAttrVal<string>("Id_emp_create_name",null); }
            set { setAttrVal<string>("Id_emp_create_name", value); }
        }

        /// <summary>
        /// 诊断时间
        /// </summary>
		public DateTime? Dt_di {
            get { return getAttrVal<FDateTime>("Dt_di",null); }
            set { setAttrVal<FDateTime>("Dt_di", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_ditp", "Id_ditp_name", "Id_ditp_code", "Id_emp_create", "Id_emp_create_name", "Dt_di"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.diag.dto.d.Headdto";
        }
    }
}

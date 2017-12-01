using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.orderverify.d
{
    /// <summary>
    /// OrderVerifyDTO 的摘要说明。
    /// </summary>
    public class OrderVerifyDTO : BaseDTO {

        public OrderVerifyDTO() {
 
        }

        /// <summary>
        /// 选择
        /// </summary>
		public bool? Select {
            get { return getAttrVal<FBoolean>("Select",null); }
            set { setAttrVal<FBoolean>("Select", value); }
        }

        /// <summary>
        /// 医嘱ID
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 医嘱编码
        /// </summary>
		public string Code_or {
            get { return getAttrVal<string>("Code_or",null); }
            set { setAttrVal<string>("Code_or", value); }
        }

        /// <summary>
        /// 生效日期
        /// </summary>
		public DateTime? Dt_effe {
            get { return getAttrVal<FDateTime>("Dt_effe",null); }
            set { setAttrVal<FDateTime>("Dt_effe", value); }
        }

        /// <summary>
        /// 失效日期
        /// </summary>
		public DateTime? Dt_invalid {
            get { return getAttrVal<FDateTime>("Dt_invalid",null); }
            set { setAttrVal<FDateTime>("Dt_invalid", value); }
        }

        /// <summary>
        /// 医嘱内容
        /// </summary>
		public string Content_or {
            get { return getAttrVal<string>("Content_or",null); }
            set { setAttrVal<string>("Content_or", value); }
        }

        /// <summary>
        /// 长临标识
        /// </summary>
		public bool? Fg_long {
            get { return getAttrVal<FBoolean>("Fg_long",null); }
            set { setAttrVal<FBoolean>("Fg_long", value); }
        }

        /// <summary>
        /// 婴儿标识
        /// </summary>
		public bool? Fg_bb {
            get { return getAttrVal<FBoolean>("Fg_bb",null); }
            set { setAttrVal<FBoolean>("Fg_bb", value); }
        }

        /// <summary>
        /// 药师审核状态
        /// </summary>
		public int? Eu_verify_pharm {
            get { return getAttrVal<int?>("Eu_verify_pharm",null); }
            set { setAttrVal<int?>("Eu_verify_pharm", value); }
        }

        /// <summary>
        /// 药师审核建议
        /// </summary>
		public string Des_verify_pharm {
            get { return getAttrVal<string>("Des_verify_pharm",null); }
            set { setAttrVal<string>("Des_verify_pharm", value); }
        }

        /// <summary>
        /// 药师审核异常级别
        /// </summary>
		public string Id_excep_level_pharm {
            get { return getAttrVal<string>("Id_excep_level_pharm",null); }
            set { setAttrVal<string>("Id_excep_level_pharm", value); }
        }

        /// <summary>
        /// 药师审核异常级别编码
        /// </summary>
		public string Sd_excep_level_pharm {
            get { return getAttrVal<string>("Sd_excep_level_pharm",null); }
            set { setAttrVal<string>("Sd_excep_level_pharm", value); }
        }

        /// <summary>
        /// 药师审核异常级别名称
        /// </summary>
		public string Name_excep_level_pharm {
            get { return getAttrVal<string>("Name_excep_level_pharm",null); }
            set { setAttrVal<string>("Name_excep_level_pharm", value); }
        }

        /// <summary>
        /// 合理用药审核结果
        /// </summary>
		public string Des_verify_sys {
            get { return getAttrVal<string>("Des_verify_sys",null); }
            set { setAttrVal<string>("Des_verify_sys", value); }
        }

        /// <summary>
        /// 合理用药审核异常级别
        /// </summary>
		public string Id_excep_level_sys {
            get { return getAttrVal<string>("Id_excep_level_sys",null); }
            set { setAttrVal<string>("Id_excep_level_sys", value); }
        }

        /// <summary>
        /// 合理用药审核异常级别编码
        /// </summary>
		public string Sd_excep_level_sys {
            get { return getAttrVal<string>("Sd_excep_level_sys",null); }
            set { setAttrVal<string>("Sd_excep_level_sys", value); }
        }

        /// <summary>
        /// 合理用药审核异常级别名称
        /// </summary>
		public string Name_excep_level_sys {
            get { return getAttrVal<string>("Name_excep_level_sys",null); }
            set { setAttrVal<string>("Name_excep_level_sys", value); }
        }

        /// <summary>
        /// 审核人
        /// </summary>
		public string Id_emp_verify_pharm {
            get { return getAttrVal<string>("Id_emp_verify_pharm",null); }
            set { setAttrVal<string>("Id_emp_verify_pharm", value); }
        }

        /// <summary>
        /// 审核人姓名
        /// </summary>
		public string Name_emp_verify_pharm {
            get { return getAttrVal<string>("Name_emp_verify_pharm",null); }
            set { setAttrVal<string>("Name_emp_verify_pharm", value); }
        }

        /// <summary>
        /// 审核时间
        /// </summary>
		public DateTime? Dt_verify_pharm {
            get { return getAttrVal<FDateTime>("Dt_verify_pharm",null); }
            set { setAttrVal<FDateTime>("Dt_verify_pharm", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Select", "Id_or", "Code_or", "Dt_effe", "Dt_invalid", "Content_or", "Fg_long", "Fg_bb", "Eu_verify_pharm", "Des_verify_pharm", "Id_excep_level_pharm", "Sd_excep_level_pharm", "Name_excep_level_pharm", "Des_verify_sys", "Id_excep_level_sys", "Sd_excep_level_sys", "Name_excep_level_sys", "Id_emp_verify_pharm", "Name_emp_verify_pharm", "Dt_verify_pharm"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.orderverify.d.OrderVerifyDTO";
        }
    }
}

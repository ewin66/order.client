using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.d
{
    /// <summary>
    /// MedicalSharingDTO 的摘要说明。
    /// </summary>
    public class MedicalSharingDTO : BaseDTO {

        public MedicalSharingDTO() {
 
        }

        /// <summary>
        /// 医嘱项目
        /// </summary>
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 医嘱
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 药品的编码（医保）
        /// </summary>
		public string Code {
            get { return getAttrVal<string>("Code",null); }
            set { setAttrVal<string>("Code", value); }
        }

        /// <summary>
        /// 开药天数
        /// </summary>
		public int? Days_or {
            get { return getAttrVal<int?>("Days_or",null); }
            set { setAttrVal<int?>("Days_or", value); }
        }

        /// <summary>
        /// 有效时间
        /// </summary>
		public DateTime? Dt_effe {
            get { return getAttrVal<FDateTime>("Dt_effe",null); }
            set { setAttrVal<FDateTime>("Dt_effe", value); }
        }

        /// <summary>
        /// 开立时间
        /// </summary>
		public DateTime? Dt_entry {
            get { return getAttrVal<FDateTime>("Dt_entry",null); }
            set { setAttrVal<FDateTime>("Dt_entry", value); }
        }

        /// <summary>
        /// 处方号
        /// </summary>
		public string Id_pres {
            get { return getAttrVal<string>("Id_pres",null); }
            set { setAttrVal<string>("Id_pres", value); }
        }

        /// <summary>
        /// 服务类型
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 药品主键
        /// </summary>
		public string Id_mm {
            get { return getAttrVal<string>("Id_mm",null); }
            set { setAttrVal<string>("Id_mm", value); }
        }

        /// <summary>
        /// 服务名称
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 医嘱内容
        /// </summary>
		public string Content_or {
            get { return getAttrVal<string>("Content_or",null); }
            set { setAttrVal<string>("Content_or", value); }
        }

        /// <summary>
        /// 医嘱名称
        /// </summary>
		public string Name_or {
            get { return getAttrVal<string>("Name_or",null); }
            set { setAttrVal<string>("Name_or", value); }
        }

        /// <summary>
        /// 扩展字段3
        /// </summary>
		public string Name14 {
            get { return getAttrVal<string>("Name14",null); }
            set { setAttrVal<string>("Name14", value); }
        }

        /// <summary>
        /// 扩展字段4
        /// </summary>
		public string Name15 {
            get { return getAttrVal<string>("Name15",null); }
            set { setAttrVal<string>("Name15", value); }
        }

        /// <summary>
        /// 扩展字段5
        /// </summary>
		public string Name16 {
            get { return getAttrVal<string>("Name16",null); }
            set { setAttrVal<string>("Name16", value); }
        }

        /// <summary>
        /// 扩展字段6
        /// </summary>
		public string Name17 {
            get { return getAttrVal<string>("Name17",null); }
            set { setAttrVal<string>("Name17", value); }
        }

        /// <summary>
        /// 扩展字段7
        /// </summary>
		public string Name18 {
            get { return getAttrVal<string>("Name18",null); }
            set { setAttrVal<string>("Name18", value); }
        }

        /// <summary>
        /// 医保验证失败原因
        /// </summary>
		public string Reason {
            get { return getAttrVal<string>("Reason",null); }
            set { setAttrVal<string>("Reason", value); }
        }

        /// <summary>
        /// 医嘱编码
        /// </summary>
		public string Code_or {
            get { return getAttrVal<string>("Code_or",null); }
            set { setAttrVal<string>("Code_or", value); }
        }

        /// <summary>
        /// 科室名称
        /// </summary>
		public string Dept_name {
            get { return getAttrVal<string>("Dept_name",null); }
            set { setAttrVal<string>("Dept_name", value); }
        }

        /// <summary>
        /// 医生名称
        /// </summary>
		public string Doctor_name {
            get { return getAttrVal<string>("Doctor_name",null); }
            set { setAttrVal<string>("Doctor_name", value); }
        }

        /// <summary>
        /// 物品名称
        /// </summary>
		public string Mm_name {
            get { return getAttrVal<string>("Mm_name",null); }
            set { setAttrVal<string>("Mm_name", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_orsrv", "Id_or", "Code", "Days_or", "Dt_effe", "Dt_entry", "Id_pres", "Sd_srvtp", "Code_entp", "Id_mm", "Name_srv", "Content_or", "Name_or", "Name14", "Name15", "Name16", "Name17", "Name18", "Reason", "Code_or", "Dept_name", "Doctor_name", "Mm_name"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.d.MedicalSharingDTO";
        }
    }
}

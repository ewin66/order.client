using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.diag.dto.d
{
    /// <summary>
    /// Cidixy 的摘要说明。
    /// </summary>
    public class Cidixy : BaseDTO {

        public Cidixy() {
 
        }

        /// <summary>
        /// 西医诊断主键
        /// </summary>
		public string Id_cidi_xy {
            get { return getAttrVal<string>("Id_cidi_xy",null); }
            set { setAttrVal<string>("Id_cidi_xy", value); }
        }

        /// <summary>
        /// 诊断类型
        /// </summary>
		public string Id_ditp {
            get { return getAttrVal<string>("Id_ditp",null); }
            set { setAttrVal<string>("Id_ditp", value); }
        }

        /// <summary>
        /// 诊断类型名称
        /// </summary>
		public string Id_ditp_name {
            get { return getAttrVal<string>("Id_ditp_name",null); }
            set { setAttrVal<string>("Id_ditp_name", value); }
        }

        /// <summary>
        /// 诊断类型编码
        /// </summary>
		public string Id_ditp_code {
            get { return getAttrVal<string>("Id_ditp_code",null); }
            set { setAttrVal<string>("Id_ditp_code", value); }
        }

        /// <summary>
        /// 诊断名称
        /// </summary>
		public string Id_didef_name {
            get { return getAttrVal<string>("Id_didef_name",null); }
            set { setAttrVal<string>("Id_didef_name", value); }
        }

        /// <summary>
        /// 诊断编码
        /// </summary>
		public string Id_didef_code {
            get { return getAttrVal<string>("Id_didef_code",null); }
            set { setAttrVal<string>("Id_didef_code", value); }
        }

        /// <summary>
        /// 诊断id
        /// </summary>
		public string Id_didef {
            get { return getAttrVal<string>("Id_didef",null); }
            set { setAttrVal<string>("Id_didef", value); }
        }

        /// <summary>
        /// 诊断补充说明
        /// </summary>
		public string Supplement {
            get { return getAttrVal<string>("Supplement",null); }
            set { setAttrVal<string>("Supplement", value); }
        }

        /// <summary>
        /// 开立科室
        /// </summary>
		public string Id_dep_create {
            get { return getAttrVal<string>("Id_dep_create",null); }
            set { setAttrVal<string>("Id_dep_create", value); }
        }

        /// <summary>
        /// 开立科室名科室
        /// </summary>
		public string Id_dep_creat_name {
            get { return getAttrVal<string>("Id_dep_creat_name",null); }
            set { setAttrVal<string>("Id_dep_creat_name", value); }
        }

        /// <summary>
        /// 疑似
        /// </summary>
		public bool? Fg_suspdi {
            get { return getAttrVal<FBoolean>("Fg_suspdi",null); }
            set { setAttrVal<FBoolean>("Fg_suspdi", value); }
        }

        /// <summary>
        /// 主诊断
        /// </summary>
		public bool? Fg_majdi {
            get { return getAttrVal<FBoolean>("Fg_majdi",null); }
            set { setAttrVal<FBoolean>("Fg_majdi", value); }
        }

        /// <summary>
        /// 诊断标准
        /// </summary>
		public string Di_standard {
            get { return getAttrVal<string>("Di_standard",null); }
            set { setAttrVal<string>("Di_standard", value); }
        }

        /// <summary>
        /// 诊断标准编码
        /// </summary>
		public string Di_standard_code {
            get { return getAttrVal<string>("Di_standard_code",null); }
            set { setAttrVal<string>("Di_standard_code", value); }
        }

        /// <summary>
        /// 诊断标准名称
        /// </summary>
		public string Di_standard_name {
            get { return getAttrVal<string>("Di_standard_name",null); }
            set { setAttrVal<string>("Di_standard_name", value); }
        }

        /// <summary>
        /// 体系
        /// </summary>
		public string Id_disys {
            get { return getAttrVal<string>("Id_disys",null); }
            set { setAttrVal<string>("Id_disys", value); }
        }

        /// <summary>
        /// 体系编码
        /// </summary>
		public string Sd_disys {
            get { return getAttrVal<string>("Sd_disys",null); }
            set { setAttrVal<string>("Sd_disys", value); }
        }

        /// <summary>
        /// 体系名称
        /// </summary>
		public string Id_disys_name {
            get { return getAttrVal<string>("Id_disys_name",null); }
            set { setAttrVal<string>("Id_disys_name", value); }
        }

        /// <summary>
        /// 字表主键
        /// </summary>
		public string Id_diitm {
            get { return getAttrVal<string>("Id_diitm",null); }
            set { setAttrVal<string>("Id_diitm", value); }
        }

        /// <summary>
        /// 自定义诊断标识
        /// </summary>
		public bool? Fg_self {
            get { return getAttrVal<FBoolean>("Fg_self",null); }
            set { setAttrVal<FBoolean>("Fg_self", value); }
        }

        /// <summary>
        /// 内部编码
        /// </summary>
		public string Innercode {
            get { return getAttrVal<string>("Innercode",null); }
            set { setAttrVal<string>("Innercode", value); }
        }

        /// <summary>
        /// 上级节点id
        /// </summary>
		public string Id_parent {
            get { return getAttrVal<string>("Id_parent",null); }
            set { setAttrVal<string>("Id_parent", value); }
        }

        /// <summary>
        /// 序号
        /// </summary>
		public string Sortno {
            get { return getAttrVal<string>("Sortno",null); }
            set { setAttrVal<string>("Sortno", value); }
        }

        /// <summary>
        /// 上报标识
        /// </summary>
		public bool? Fg_ur {
            get { return getAttrVal<FBoolean>("Fg_ur",null); }
            set { setAttrVal<FBoolean>("Fg_ur", value); }
        }

        /// <summary>
        /// 慢性病标志
        /// </summary>
		public bool? Fg_chronic {
            get { return getAttrVal<FBoolean>("Fg_chronic",null); }
            set { setAttrVal<FBoolean>("Fg_chronic", value); }
        }

        /// <summary>
        /// 特种病标志
        /// </summary>
		public bool? Fg_special {
            get { return getAttrVal<FBoolean>("Fg_special",null); }
            set { setAttrVal<FBoolean>("Fg_special", value); }
        }

        /// <summary>
        /// 保外诊断标识
        /// </summary>
		public bool? Fg_hpbeyond {
            get { return getAttrVal<FBoolean>("Fg_hpbeyond",null); }
            set { setAttrVal<FBoolean>("Fg_hpbeyond", value); }
        }

        /// <summary>
        /// 传染病种类
        /// </summary>
		public string Id_infectiontp {
            get { return getAttrVal<string>("Id_infectiontp",null); }
            set { setAttrVal<string>("Id_infectiontp", value); }
        }

        /// <summary>
        /// 传染病种类编码
        /// </summary>
		public string Sd_infectiontp {
            get { return getAttrVal<string>("Sd_infectiontp",null); }
            set { setAttrVal<string>("Sd_infectiontp", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_cidi_xy", "Id_ditp", "Id_ditp_name", "Id_ditp_code", "Id_didef_name", "Id_didef_code", "Id_didef", "Supplement", "Id_dep_create", "Id_dep_creat_name", "Fg_suspdi", "Fg_majdi", "Di_standard", "Di_standard_code", "Di_standard_name", "Id_disys", "Sd_disys", "Id_disys_name", "Id_diitm", "Fg_self", "Innercode", "Id_parent", "Sortno", "Fg_ur", "Fg_chronic", "Fg_special", "Fg_hpbeyond", "Id_infectiontp", "Sd_infectiontp"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.diag.dto.d.Cidixy";
        }
    }
}

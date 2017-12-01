using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ems.uiemsdto.d
{
    /// <summary>
    /// EmsPathgyHDWViewDTO 的摘要说明。
    /// </summary>
    public class EmsPathgyHDWViewDTO : BaseDTO {

        public EmsPathgyHDWViewDTO() {
 
        }

        /// <summary>
        /// 医嘱ID
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 服务id
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 处置项目
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 明细
        /// </summary>
		public string Details {
            get { return getAttrVal<string>("Details",null); }
            set { setAttrVal<string>("Details", value); }
        }

        /// <summary>
        /// 标本类型ID
        /// </summary>
		public string Id_samptp {
            get { return getAttrVal<string>("Id_samptp",null); }
            set { setAttrVal<string>("Id_samptp", value); }
        }

        /// <summary>
        /// 标本类型SD
        /// </summary>
		public string Sd_samptp {
            get { return getAttrVal<string>("Sd_samptp",null); }
            set { setAttrVal<string>("Sd_samptp", value); }
        }

        /// <summary>
        /// 标本类型名称
        /// </summary>
		public string Name_samptp {
            get { return getAttrVal<string>("Name_samptp",null); }
            set { setAttrVal<string>("Name_samptp", value); }
        }

        /// <summary>
        /// 临床诊断ID
        /// </summary>
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }

        /// <summary>
        /// 临床诊断
        /// </summary>
		public string Name_di {
            get { return getAttrVal<string>("Name_di",null); }
            set { setAttrVal<string>("Name_di", value); }
        }

        /// <summary>
        /// 诊断子项ID
        /// </summary>
		public string Id_diitm {
            get { return getAttrVal<string>("Id_diitm",null); }
            set { setAttrVal<string>("Id_diitm", value); }
        }

        /// <summary>
        /// 加急标识
        /// </summary>
		public bool? Fg_urgent {
            get { return getAttrVal<FBoolean>("Fg_urgent",null); }
            set { setAttrVal<FBoolean>("Fg_urgent", value); }
        }

        /// <summary>
        /// 申请单号
        /// </summary>
		public string No_pathgy {
            get { return getAttrVal<string>("No_pathgy",null); }
            set { setAttrVal<string>("No_pathgy", value); }
        }

        /// <summary>
        /// 执行科室ID
        /// </summary>
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Name_dep_mp {
            get { return getAttrVal<string>("Name_dep_mp",null); }
            set { setAttrVal<string>("Name_dep_mp", value); }
        }

        /// <summary>
        /// 单价
        /// </summary>
		public FDouble Price {
            get { return getAttrVal<FDouble>("Price",null); }
            set { setAttrVal<FDouble>("Price", value); }
        }

        /// <summary>
        /// 病情描述
        /// </summary>
		public string Des_sympsign {
            get { return getAttrVal<string>("Des_sympsign",null); }
            set { setAttrVal<string>("Des_sympsign", value); }
        }

        /// <summary>
        /// 检查要求
        /// </summary>
		public string Announcements {
            get { return getAttrVal<string>("Announcements",null); }
            set { setAttrVal<string>("Announcements", value); }
        }

        /// <summary>
        /// 肿瘤生长时间（def9）
        /// </summary>
		public string Tumourtime {
            get { return getAttrVal<string>("Tumourtime",null); }
            set { setAttrVal<string>("Tumourtime", value); }
        }

        /// <summary>
        /// 肿瘤生长时间单位(def10)
        /// </summary>
		public string Tumourtimeunit {
            get { return getAttrVal<string>("Tumourtimeunit",null); }
            set { setAttrVal<string>("Tumourtimeunit", value); }
        }

        /// <summary>
        /// 肿瘤大小(def11)
        /// </summary>
		public string Tumoursize {
            get { return getAttrVal<string>("Tumoursize",null); }
            set { setAttrVal<string>("Tumoursize", value); }
        }

        /// <summary>
        /// 肿瘤位置(def12)
        /// </summary>
		public string Tumourplace {
            get { return getAttrVal<string>("Tumourplace",null); }
            set { setAttrVal<string>("Tumourplace", value); }
        }

        /// <summary>
        /// 转移瘤位置(def13)
        /// </summary>
		public string Tumourtransfer {
            get { return getAttrVal<string>("Tumourtransfer",null); }
            set { setAttrVal<string>("Tumourtransfer", value); }
        }

        /// <summary>
        /// 上次月经(def3)
        /// </summary>
		public DateTime? Menslast {
            get { return getAttrVal<FDateTime>("Menslast",null); }
            set { setAttrVal<FDateTime>("Menslast", value); }
        }

        /// <summary>
        /// 本次月经（def4）
        /// </summary>
		public DateTime? Mensthis {
            get { return getAttrVal<FDateTime>("Mensthis",null); }
            set { setAttrVal<FDateTime>("Mensthis", value); }
        }

        /// <summary>
        /// 出血量(def5)
        /// </summary>
		public string Bloodv {
            get { return getAttrVal<string>("Bloodv",null); }
            set { setAttrVal<string>("Bloodv", value); }
        }

        /// <summary>
        /// 人工周期治疗标识(def6)
        /// </summary>
		public bool? Fg_hascure {
            get { return getAttrVal<FBoolean>("Fg_hascure",null); }
            set { setAttrVal<FBoolean>("Fg_hascure", value); }
        }

        /// <summary>
        /// 治疗时间(def7)
        /// </summary>
		public DateTime? Treattiem {
            get { return getAttrVal<FDateTime>("Treattiem",null); }
            set { setAttrVal<FDateTime>("Treattiem", value); }
        }

        /// <summary>
        /// 剂量(def8)
        /// </summary>
		public FDouble Dosage {
            get { return getAttrVal<FDouble>("Dosage",null); }
            set { setAttrVal<FDouble>("Dosage", value); }
        }

        /// <summary>
        /// 既往病理外院标识
        /// </summary>
		public bool? Fg_outer {
            get { return getAttrVal<FBoolean>("Fg_outer",null); }
            set { setAttrVal<FBoolean>("Fg_outer", value); }
        }

        /// <summary>
        /// 既往医院名称
        /// </summary>
		public string Org_pathgy_old {
            get { return getAttrVal<string>("Org_pathgy_old",null); }
            set { setAttrVal<string>("Org_pathgy_old", value); }
        }

        /// <summary>
        /// 既往病理号
        /// </summary>
		public string No_pathgy_old {
            get { return getAttrVal<string>("No_pathgy_old",null); }
            set { setAttrVal<string>("No_pathgy_old", value); }
        }

        /// <summary>
        /// 既往报告日期
        /// </summary>
		public DateTime? Dt_pathgy_old {
            get { return getAttrVal<FDateTime>("Dt_pathgy_old",null); }
            set { setAttrVal<FDateTime>("Dt_pathgy_old", value); }
        }

        /// <summary>
        /// 既往病理诊断
        /// </summary>
		public string Di_pathgy_old {
            get { return getAttrVal<string>("Di_pathgy_old",null); }
            set { setAttrVal<string>("Di_pathgy_old", value); }
        }

        /// <summary>
        /// 采集所见
        /// </summary>
		public string Collectdes {
            get { return getAttrVal<string>("Collectdes",null); }
            set { setAttrVal<string>("Collectdes", value); }
        }

        /// <summary>
        /// 采集人id
        /// </summary>
		public string Id_emp {
            get { return getAttrVal<string>("Id_emp",null); }
            set { setAttrVal<string>("Id_emp", value); }
        }

        /// <summary>
        /// 采集人
        /// </summary>
		public string Name_emp {
            get { return getAttrVal<string>("Name_emp",null); }
            set { setAttrVal<string>("Name_emp", value); }
        }

        /// <summary>
        /// 采集时间
        /// </summary>
		public DateTime? Dt_coll {
            get { return getAttrVal<FDateTime>("Dt_coll",null); }
            set { setAttrVal<FDateTime>("Dt_coll", value); }
        }

        /// <summary>
        /// sv
        /// </summary>
		public string Sv {
            get { return getAttrVal<string>("Sv",null); }
            set { setAttrVal<string>("Sv", value); }
        }

        /// <summary>
        /// 服务套标识
        /// </summary>
		public bool? Fg_set {
            get { return getAttrVal<FBoolean>("Fg_set",null); }
            set { setAttrVal<FBoolean>("Fg_set", value); }
        }

        /// <summary>
        /// 病理标本信息
        /// </summary>
		public FArrayList Emspathgyitems {
            get { return getAttrVal<FArrayList>("Emspathgyitems",null); }
            set { setAttrVal<FArrayList>("Emspathgyitems", value); }
        }

        /// <summary>
        /// 单选标识
        /// </summary>
		public string Fg_radio {
            get { return getAttrVal<string>("Fg_radio",null); }
            set { setAttrVal<string>("Fg_radio", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Id_srv", "Name_srv", "Details", "Id_samptp", "Sd_samptp", "Name_samptp", "Id_di", "Name_di", "Id_diitm", "Fg_urgent", "No_pathgy", "Id_dep_mp", "Name_dep_mp", "Price", "Des_sympsign", "Announcements", "Tumourtime", "Tumourtimeunit", "Tumoursize", "Tumourplace", "Tumourtransfer", "Menslast", "Mensthis", "Bloodv", "Fg_hascure", "Treattiem", "Dosage", "Fg_outer", "Org_pathgy_old", "No_pathgy_old", "Dt_pathgy_old", "Di_pathgy_old", "Collectdes", "Id_emp", "Name_emp", "Dt_coll", "Sv", "Fg_set", "Emspathgyitems", "Fg_radio"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ems.uiemsdto.d.EmsPathgyHDWViewDTO";
        }
    }
}

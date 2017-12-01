using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.contagionrecordop.d
{
    /// <summary>
    /// ContagionRecordOpDTO 的摘要说明。
    /// </summary>
    public class ContagionRecordOpDTO : BaseDTO {

        public ContagionRecordOpDTO() {
 
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id_contagiondto {
            get { return getAttrVal<string>("Id_contagiondto",null); }
            set { setAttrVal<string>("Id_contagiondto", value); }
        }

        /// <summary>
        /// 门诊号
        /// </summary>
		public string Op_code {
            get { return getAttrVal<string>("Op_code",null); }
            set { setAttrVal<string>("Op_code", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }

        /// <summary>
        /// 性别
        /// </summary>
		public string Name_sex {
            get { return getAttrVal<string>("Name_sex",null); }
            set { setAttrVal<string>("Name_sex", value); }
        }

        /// <summary>
        /// 年龄
        /// </summary>
		public string Exact_age {
            get { return getAttrVal<string>("Exact_age",null); }
            set { setAttrVal<string>("Exact_age", value); }
        }

        /// <summary>
        /// 诊断
        /// </summary>
		public string Diagnose {
            get { return getAttrVal<string>("Diagnose",null); }
            set { setAttrVal<string>("Diagnose", value); }
        }

        /// <summary>
        /// 就诊时间
        /// </summary>
		public DateTime? Clinic_time {
            get { return getAttrVal<FDate>("Clinic_time",null); }
            set { setAttrVal<FDate>("Clinic_time", value); }
        }

        /// <summary>
        /// 初诊或复诊
        /// </summary>
		public bool? Is_first_en {
            get { return getAttrVal<FBoolean>("Is_first_en",null); }
            set { setAttrVal<FBoolean>("Is_first_en", value); }
        }

        /// <summary>
        /// 就诊科室
        /// </summary>
		public string Clinic_unit {
            get { return getAttrVal<string>("Clinic_unit",null); }
            set { setAttrVal<string>("Clinic_unit", value); }
        }

        /// <summary>
        /// 发病日期
        /// </summary>
		public DateTime? Fbrq {
            get { return getAttrVal<FDate>("Fbrq",null); }
            set { setAttrVal<FDate>("Fbrq", value); }
        }

        /// <summary>
        /// 职业
        /// </summary>
		public string Profession {
            get { return getAttrVal<string>("Profession",null); }
            set { setAttrVal<string>("Profession", value); }
        }

        /// <summary>
        /// 现住址
        /// </summary>
		public string Addr_now {
            get { return getAttrVal<string>("Addr_now",null); }
            set { setAttrVal<string>("Addr_now", value); }
        }

        /// <summary>
        /// 就诊id
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 自定义（备用）属性1
        /// </summary>
		public string Def1 {
            get { return getAttrVal<string>("Def1",null); }
            set { setAttrVal<string>("Def1", value); }
        }

        /// <summary>
        /// 自定义（备用）属性2
        /// </summary>
		public string Def2 {
            get { return getAttrVal<string>("Def2",null); }
            set { setAttrVal<string>("Def2", value); }
        }

        /// <summary>
        /// 自定义（备用）属性3
        /// </summary>
		public string Def3 {
            get { return getAttrVal<string>("Def3",null); }
            set { setAttrVal<string>("Def3", value); }
        }

        /// <summary>
        /// 自定义（备用）属性4
        /// </summary>
		public string Def4 {
            get { return getAttrVal<string>("Def4",null); }
            set { setAttrVal<string>("Def4", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_contagiondto", "Op_code", "Name_pat", "Name_sex", "Exact_age", "Diagnose", "Clinic_time", "Is_first_en", "Clinic_unit", "Fbrq", "Profession", "Addr_now", "Id_ent", "Def1", "Def2", "Def3", "Def4"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.contagionrecordop.d.ContagionRecordOpDTO";
        }
    }
}

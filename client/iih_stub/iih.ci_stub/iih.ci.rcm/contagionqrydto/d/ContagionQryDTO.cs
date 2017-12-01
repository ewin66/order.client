using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.contagionqrydto.d
{
    /// <summary>
    /// ContagionQryDTO 的摘要说明。
    /// </summary>
    public class ContagionQryDTO : BaseDTO {

        public ContagionQryDTO() {
 
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id_contagiondto {
            get { return getAttrVal<string>("Id_contagiondto",null); }
            set { setAttrVal<string>("Id_contagiondto", value); }
        }

        /// <summary>
        /// 收卡时间
        /// </summary>
		public DateTime? Dt_contagion {
            get { return getAttrVal<FDate>("Dt_contagion",null); }
            set { setAttrVal<FDate>("Dt_contagion", value); }
        }

        /// <summary>
        /// 报卡类别
        /// </summary>
		public string Name_eu_bklb {
            get { return getAttrVal<string>("Name_eu_bklb",null); }
            set { setAttrVal<string>("Name_eu_bklb", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }

        /// <summary>
        /// 患者家长姓名
        /// </summary>
		public string Hzjzxm {
            get { return getAttrVal<string>("Hzjzxm",null); }
            set { setAttrVal<string>("Hzjzxm", value); }
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
        /// 职业
        /// </summary>
		public string Name_eu_rqfl {
            get { return getAttrVal<string>("Name_eu_rqfl",null); }
            set { setAttrVal<string>("Name_eu_rqfl", value); }
        }

        /// <summary>
        /// 工作单位
        /// </summary>
		public string Workunit {
            get { return getAttrVal<string>("Workunit",null); }
            set { setAttrVal<string>("Workunit", value); }
        }

        /// <summary>
        /// 现住址
        /// </summary>
		public string Addr_now {
            get { return getAttrVal<string>("Addr_now",null); }
            set { setAttrVal<string>("Addr_now", value); }
        }

        /// <summary>
        /// 联系电话
        /// </summary>
		public string Mob {
            get { return getAttrVal<string>("Mob",null); }
            set { setAttrVal<string>("Mob", value); }
        }

        /// <summary>
        /// 病例分类
        /// </summary>
		public string Name_eu_blfl {
            get { return getAttrVal<string>("Name_eu_blfl",null); }
            set { setAttrVal<string>("Name_eu_blfl", value); }
        }

        /// <summary>
        /// 发病日期
        /// </summary>
		public DateTime? Fbrq {
            get { return getAttrVal<FDate>("Fbrq",null); }
            set { setAttrVal<FDate>("Fbrq", value); }
        }

        /// <summary>
        /// 诊断日期
        /// </summary>
		public DateTime? Zdrq {
            get { return getAttrVal<FDateTime>("Zdrq",null); }
            set { setAttrVal<FDateTime>("Zdrq", value); }
        }

        /// <summary>
        /// 死亡日期
        /// </summary>
		public DateTime? Swrq {
            get { return getAttrVal<FDate>("Swrq",null); }
            set { setAttrVal<FDate>("Swrq", value); }
        }

        /// <summary>
        /// 报告科室
        /// </summary>
		public string Dep_deport {
            get { return getAttrVal<string>("Dep_deport",null); }
            set { setAttrVal<string>("Dep_deport", value); }
        }

        /// <summary>
        /// 报告医生
        /// </summary>
		public string Doctor_card {
            get { return getAttrVal<string>("Doctor_card",null); }
            set { setAttrVal<string>("Doctor_card", value); }
        }

        /// <summary>
        /// 访视日期
        /// </summary>
		public string Dt_fangshi {
            get { return getAttrVal<string>("Dt_fangshi",null); }
            set { setAttrVal<string>("Dt_fangshi", value); }
        }

        /// <summary>
        /// 转归
        /// </summary>
		public string Zhuangui {
            get { return getAttrVal<string>("Zhuangui",null); }
            set { setAttrVal<string>("Zhuangui", value); }
        }

        /// <summary>
        /// 订正卡编号
        /// </summary>
		public string Code_dingzhika {
            get { return getAttrVal<string>("Code_dingzhika",null); }
            set { setAttrVal<string>("Code_dingzhika", value); }
        }

        /// <summary>
        /// 订正人
        /// </summary>
		public string Dingzhengren {
            get { return getAttrVal<string>("Dingzhengren",null); }
            set { setAttrVal<string>("Dingzhengren", value); }
        }

        /// <summary>
        /// 备注
        /// </summary>
		public string Beizhu {
            get { return getAttrVal<string>("Beizhu",null); }
            set { setAttrVal<string>("Beizhu", value); }
        }

        /// <summary>
        /// 疾病名称
        /// </summary>
		public string Name_disease {
            get { return getAttrVal<string>("Name_disease",null); }
            set { setAttrVal<string>("Name_disease", value); }
        }

        /// <summary>
        /// 就诊id
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_contagiondto", "Dt_contagion", "Name_eu_bklb", "Name_pat", "Hzjzxm", "Name_sex", "Exact_age", "Name_eu_rqfl", "Workunit", "Addr_now", "Mob", "Name_eu_blfl", "Fbrq", "Zdrq", "Swrq", "Dep_deport", "Doctor_card", "Dt_fangshi", "Zhuangui", "Code_dingzhika", "Dingzhengren", "Beizhu", "Name_disease", "Id_ent"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.contagionqrydto.d.ContagionQryDTO";
        }
    }
}

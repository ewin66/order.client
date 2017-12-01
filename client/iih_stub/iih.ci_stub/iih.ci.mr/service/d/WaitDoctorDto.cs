using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.d
{
    /// <summary>
    /// WaitDoctorDto 的摘要说明。
    /// </summary>
    public class WaitDoctorDto : BaseDTO {

        public WaitDoctorDto() {
 
        }

        /// <summary>
        /// 就诊号
        /// </summary>
		public string Code {
            get { return getAttrVal<string>("Code",null); }
            set { setAttrVal<string>("Code", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }

        /// <summary>
        /// 患者性别
        /// </summary>
		public string Id_sex_pat {
            get { return getAttrVal<string>("Id_sex_pat",null); }
            set { setAttrVal<string>("Id_sex_pat", value); }
        }

        /// <summary>
        /// 年龄
        /// </summary>
		public string Pat_age {
            get { return getAttrVal<string>("Pat_age",null); }
            set { setAttrVal<string>("Pat_age", value); }
        }

        /// <summary>
        /// 就诊接诊日期时间
        /// </summary>
		public string Dt_acpt {
            get { return getAttrVal<string>("Dt_acpt",null); }
            set { setAttrVal<string>("Dt_acpt", value); }
        }

        /// <summary>
        /// 患者价格分类_本次
        /// </summary>
		public string Id_pripat {
            get { return getAttrVal<string>("Id_pripat",null); }
            set { setAttrVal<string>("Id_pripat", value); }
        }

        /// <summary>
        /// 当前就诊科室
        /// </summary>
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }

        /// <summary>
        /// 就诊状态
        /// </summary>
		public string Sd_status {
            get { return getAttrVal<string>("Sd_status",null); }
            set { setAttrVal<string>("Sd_status", value); }
        }

        /// <summary>
        /// 诊断描述
        /// </summary>
		public string Di_des {
            get { return getAttrVal<string>("Di_des",null); }
            set { setAttrVal<string>("Di_des", value); }
        }

        /// <summary>
        /// 诊毕时间
        /// </summary>
		public string Dt_end {
            get { return getAttrVal<string>("Dt_end",null); }
            set { setAttrVal<string>("Dt_end", value); }
        }

        /// <summary>
        /// 患者id
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
            return new string[]{ "Code", "Name_pat", "Id_sex_pat", "Pat_age", "Dt_acpt", "Id_pripat", "Id_dep_phy", "Sd_status", "Di_des", "Dt_end", "Id_ent"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.d.WaitDoctorDto";
        }
    }
}

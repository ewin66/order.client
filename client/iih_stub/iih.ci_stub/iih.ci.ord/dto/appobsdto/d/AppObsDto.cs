using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.appobsdto.d
{
    /// <summary>
    /// AppObsDto 的摘要说明。
    /// </summary>
    public class AppObsDto : BaseDTO {

        public AppObsDto() {
 
        }

        /// <summary>
        /// 医嘱id
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 医嘱名称
        /// </summary>
		public string Name_or {
            get { return getAttrVal<string>("Name_or",null); }
            set { setAttrVal<string>("Name_or", value); }
        }

        /// <summary>
        /// 医嘱内容
        /// </summary>
		public string Content_or {
            get { return getAttrVal<string>("Content_or",null); }
            set { setAttrVal<string>("Content_or", value); }
        }

        /// <summary>
        /// 就诊id
        /// </summary>
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }

        /// <summary>
        /// 患者id
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Sd_entp {
            get { return getAttrVal<string>("Sd_entp",null); }
            set { setAttrVal<string>("Sd_entp", value); }
        }

        /// <summary>
        /// 计划检查时间
        /// </summary>
		public DateTime? Dt_effe {
            get { return getAttrVal<FDateTime>("Dt_effe",null); }
            set { setAttrVal<FDateTime>("Dt_effe", value); }
        }

        /// <summary>
        /// 签署人
        /// </summary>
		public string Id_emp_sign {
            get { return getAttrVal<string>("Id_emp_sign",null); }
            set { setAttrVal<string>("Id_emp_sign", value); }
        }

        /// <summary>
        /// 签署人名称
        /// </summary>
		public string Name_emp_sign {
            get { return getAttrVal<string>("Name_emp_sign",null); }
            set { setAttrVal<string>("Name_emp_sign", value); }
        }

        /// <summary>
        /// 签署科室
        /// </summary>
		public string Id_dep_sign {
            get { return getAttrVal<string>("Id_dep_sign",null); }
            set { setAttrVal<string>("Id_dep_sign", value); }
        }

        /// <summary>
        /// 签署科室名称
        /// </summary>
		public string Name_dep_sign {
            get { return getAttrVal<string>("Name_dep_sign",null); }
            set { setAttrVal<string>("Name_dep_sign", value); }
        }

        /// <summary>
        /// 服务
        /// </summary>
		public string Id_srvset {
            get { return getAttrVal<string>("Id_srvset",null); }
            set { setAttrVal<string>("Id_srvset", value); }
        }

        /// <summary>
        /// 服务名称
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 部位名称
        /// </summary>
		public string Body_name {
            get { return getAttrVal<string>("Body_name",null); }
            set { setAttrVal<string>("Body_name", value); }
        }

        /// <summary>
        /// 体位名称
        /// </summary>
		public string Sd_pos {
            get { return getAttrVal<string>("Sd_pos",null); }
            set { setAttrVal<string>("Sd_pos", value); }
        }

        /// <summary>
        /// 医学单位数值
        /// </summary>
		public string Quan_medu {
            get { return getAttrVal<string>("Quan_medu",null); }
            set { setAttrVal<string>("Quan_medu", value); }
        }

        /// <summary>
        /// 医学单位
        /// </summary>
		public string Id_medu {
            get { return getAttrVal<string>("Id_medu",null); }
            set { setAttrVal<string>("Id_medu", value); }
        }

        /// <summary>
        /// 性别
        /// </summary>
		public string Sd_sex {
            get { return getAttrVal<string>("Sd_sex",null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }

        /// <summary>
        /// 出生日期
        /// </summary>
		public DateTime? Dt_birth {
            get { return getAttrVal<FDateTime>("Dt_birth",null); }
            set { setAttrVal<FDateTime>("Dt_birth", value); }
        }

        /// <summary>
        /// 就诊类型id
        /// </summary>
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }

        /// <summary>
        /// 加急标志
        /// </summary>
		public bool? Fg_urgent {
            get { return getAttrVal<FBoolean>("Fg_urgent",null); }
            set { setAttrVal<FBoolean>("Fg_urgent", value); }
        }

        /// <summary>
        /// 检查状态
        /// </summary>
		public string Sd_su_obs {
            get { return getAttrVal<string>("Sd_su_obs",null); }
            set { setAttrVal<string>("Sd_su_obs", value); }
        }

        /// <summary>
        /// 医疗服务id
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 医嘱项目id_orsrv
        /// </summary>
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }

        /// <summary>
        /// 执行科室名称
        /// </summary>
		public string Name_dep_mp {
            get { return getAttrVal<string>("Name_dep_mp",null); }
            set { setAttrVal<string>("Name_dep_mp", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Name_or", "Content_or", "Id_en", "Id_pat", "Sd_entp", "Dt_effe", "Id_emp_sign", "Name_emp_sign", "Id_dep_sign", "Name_dep_sign", "Id_srvset", "Name_srv", "Body_name", "Sd_pos", "Quan_medu", "Id_medu", "Sd_sex", "Dt_birth", "Id_entp", "Fg_urgent", "Sd_su_obs", "Id_srv", "Id_orsrv", "Id_dep_mp", "Name_dep_mp"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.appobsdto.d.AppObsDto";
        }
    }
}

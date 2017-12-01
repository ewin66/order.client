using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ems.uiorderdto.d
{
    /// <summary>
    /// UiOrderListDTO 的摘要说明。
    /// </summary>
    public class UiOrderListDTO : BaseDTO {

        public UiOrderListDTO() {
 
        }

        /// <summary>
        /// 医嘱ID
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 医嘱综合状态
        /// </summary>
		public string Ord_colligate {
            get { return getAttrVal<string>("Ord_colligate",null); }
            set { setAttrVal<string>("Ord_colligate", value); }
        }

        /// <summary>
        /// 医嘱状态ID
        /// </summary>
		public string Id_su_or {
            get { return getAttrVal<string>("Id_su_or",null); }
            set { setAttrVal<string>("Id_su_or", value); }
        }

        /// <summary>
        /// 医嘱状态编码
        /// </summary>
		public string Sd_su_or {
            get { return getAttrVal<string>("Sd_su_or",null); }
            set { setAttrVal<string>("Sd_su_or", value); }
        }

        /// <summary>
        /// 医嘱状态
        /// </summary>
		public string Name_su_or {
            get { return getAttrVal<string>("Name_su_or",null); }
            set { setAttrVal<string>("Name_su_or", value); }
        }

        /// <summary>
        /// 医嘱类型编码
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 医嘱类型
        /// </summary>
		public string Name_srvtp {
            get { return getAttrVal<string>("Name_srvtp",null); }
            set { setAttrVal<string>("Name_srvtp", value); }
        }

        /// <summary>
        /// 医嘱内容
        /// </summary>
		public string Content_or {
            get { return getAttrVal<string>("Content_or",null); }
            set { setAttrVal<string>("Content_or", value); }
        }

        /// <summary>
        /// 医生
        /// </summary>
		public string Doctor {
            get { return getAttrVal<string>("Doctor",null); }
            set { setAttrVal<string>("Doctor", value); }
        }

        /// <summary>
        /// 开立医生ID
        /// </summary>
		public string Id_emp_or {
            get { return getAttrVal<string>("Id_emp_or",null); }
            set { setAttrVal<string>("Id_emp_or", value); }
        }

        /// <summary>
        /// 开立医生
        /// </summary>
		public string Name_emp_or {
            get { return getAttrVal<string>("Name_emp_or",null); }
            set { setAttrVal<string>("Name_emp_or", value); }
        }

        /// <summary>
        /// 执行状态ID
        /// </summary>
		public string Id_su_mp {
            get { return getAttrVal<string>("Id_su_mp",null); }
            set { setAttrVal<string>("Id_su_mp", value); }
        }

        /// <summary>
        /// 执行状态编码
        /// </summary>
		public string Sd_su_mp {
            get { return getAttrVal<string>("Sd_su_mp",null); }
            set { setAttrVal<string>("Sd_su_mp", value); }
        }

        /// <summary>
        /// 记账状态ID
        /// </summary>
		public string Id_su_bl {
            get { return getAttrVal<string>("Id_su_bl",null); }
            set { setAttrVal<string>("Id_su_bl", value); }
        }

        /// <summary>
        /// 记账状态编码
        /// </summary>
		public string Sd_su_bl {
            get { return getAttrVal<string>("Sd_su_bl",null); }
            set { setAttrVal<string>("Sd_su_bl", value); }
        }

        /// <summary>
        /// 皮试标识
        /// </summary>
		public bool? Fg_skintest {
            get { return getAttrVal<FBoolean>("Fg_skintest",null); }
            set { setAttrVal<FBoolean>("Fg_skintest", value); }
        }

        /// <summary>
        /// 皮试结果
        /// </summary>
		public string Skintest_result {
            get { return getAttrVal<string>("Skintest_result",null); }
            set { setAttrVal<string>("Skintest_result", value); }
        }

        /// <summary>
        /// 签署标识
        /// </summary>
		public bool? Fg_sign {
            get { return getAttrVal<FBoolean>("Fg_sign",null); }
            set { setAttrVal<FBoolean>("Fg_sign", value); }
        }

        /// <summary>
        /// 签署医生ID
        /// </summary>
		public string Id_emp_sign {
            get { return getAttrVal<string>("Id_emp_sign",null); }
            set { setAttrVal<string>("Id_emp_sign", value); }
        }

        /// <summary>
        /// 签署医生
        /// </summary>
		public string Name_emp_sign {
            get { return getAttrVal<string>("Name_emp_sign",null); }
            set { setAttrVal<string>("Name_emp_sign", value); }
        }

        /// <summary>
        /// 审核/结果
        /// </summary>
		public string Check_result {
            get { return getAttrVal<string>("Check_result",null); }
            set { setAttrVal<string>("Check_result", value); }
        }

        /// <summary>
        /// 开始时间
        /// </summary>
		public DateTime? Dt_effe {
            get { return getAttrVal<FDateTime>("Dt_effe",null); }
            set { setAttrVal<FDateTime>("Dt_effe", value); }
        }

        /// <summary>
        /// 医保适应症判断标识枚举
        /// </summary>
		public int? Eu_hpindicjudge {
            get { return getAttrVal<int?>("Eu_hpindicjudge",null); }
            set { setAttrVal<int?>("Eu_hpindicjudge", value); }
        }

        /// <summary>
        /// 非径内医嘱判断标识枚举
        /// </summary>
		public int? Eu_uncporjudge {
            get { return getAttrVal<int?>("Eu_uncporjudge",null); }
            set { setAttrVal<int?>("Eu_uncporjudge", value); }
        }

        /// <summary>
        /// 医嘱结果ID
        /// </summary>
		public string Id_orrsttp {
            get { return getAttrVal<string>("Id_orrsttp",null); }
            set { setAttrVal<string>("Id_orrsttp", value); }
        }

        /// <summary>
        /// 医嘱结果编码
        /// </summary>
		public string Sd_orrsttp {
            get { return getAttrVal<string>("Sd_orrsttp",null); }
            set { setAttrVal<string>("Sd_orrsttp", value); }
        }

        /// <summary>
        /// sv
        /// </summary>
		public string Sv {
            get { return getAttrVal<string>("Sv",null); }
            set { setAttrVal<string>("Sv", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Ord_colligate", "Id_su_or", "Sd_su_or", "Name_su_or", "Sd_srvtp", "Name_srvtp", "Content_or", "Doctor", "Id_emp_or", "Name_emp_or", "Id_su_mp", "Sd_su_mp", "Id_su_bl", "Sd_su_bl", "Fg_skintest", "Skintest_result", "Fg_sign", "Id_emp_sign", "Name_emp_sign", "Check_result", "Dt_effe", "Eu_hpindicjudge", "Eu_uncporjudge", "Id_orrsttp", "Sd_orrsttp", "Sv"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ems.uiorderdto.d.UiOrderListDTO";
        }
    }
}

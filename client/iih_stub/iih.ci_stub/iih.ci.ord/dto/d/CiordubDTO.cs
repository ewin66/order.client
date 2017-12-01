using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using iih.ci.iih.ci.ord.ciordems.d;

namespace iih.ci.ord.dto.d
{
    /// <summary>
    /// CiordubDTO 的摘要说明。
    /// </summary>
    public class CiordubDTO : OrCommonFieldsDTO{

        public CiordubDTO() {
 
        }

        /// <summary>
        /// 医嘱主键
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 备血申请单号
        /// </summary>
		public string Applyform {
            get { return getAttrVal<string>("Applyform",null); }
            set { setAttrVal<string>("Applyform", value); }
        }

        /// <summary>
        /// 服务id
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 输血成分
        /// </summary>
		public string Orsrvname {
            get { return getAttrVal<string>("Orsrvname",null); }
            set { setAttrVal<string>("Orsrvname", value); }
        }

        /// <summary>
        /// 备血申请量
        /// </summary>
		public double? Quan_medu {
            get { return getAttrVal<FDouble>("Quan_medu",null); }
            set { setAttrVal<FDouble>("Quan_medu", value); }
        }

        /// <summary>
        /// 界面中使用的用血单位
        /// </summary>
		public string Id_unit {
            get { return getAttrVal<string>("Id_unit",null); }
            set { setAttrVal<string>("Id_unit", value); }
        }

        /// <summary>
        /// 实际备血量
        /// </summary>
		public double? Num_bt {
            get { return getAttrVal<FDouble>("Num_bt",null); }
            set { setAttrVal<FDouble>("Num_bt", value); }
        }

        /// <summary>
        /// 计划输血日期
        /// </summary>
		public DateTime? Dt_bt_pl {
            get { return getAttrVal<FDate>("Dt_bt_pl",null); }
            set { setAttrVal<FDate>("Dt_bt_pl", value); }
        }

        /// <summary>
        /// 备血申请医师
        /// </summary>
		public string Id_emp_sign {
            get { return getAttrVal<string>("Id_emp_sign",null); }
            set { setAttrVal<string>("Id_emp_sign", value); }
        }

        /// <summary>
        /// 可用血余量
        /// </summary>
		public double? Num_margin_bu {
            get { return getAttrVal<FDouble>("Num_margin_bu",null); }
            set { setAttrVal<FDouble>("Num_margin_bu", value); }
        }

        /// <summary>
        /// 单位名称
        /// </summary>
		public string Name_unit {
            get { return getAttrVal<string>("Name_unit",null); }
            set { setAttrVal<string>("Name_unit", value); }
        }

        /// <summary>
        /// 本次用血量
        /// </summary>
		public double? Quan_medu_ub {
            get { return getAttrVal<FDouble>("Quan_medu_ub",null); }
            set { setAttrVal<FDouble>("Quan_medu_ub", value); }
        }

        /// <summary>
        /// 用法
        /// </summary>
		public string Id_route {
            get { return getAttrVal<string>("Id_route",null); }
            set { setAttrVal<string>("Id_route", value); }
        }

        /// <summary>
        /// 申请医师
        /// </summary>
		public string Id_emp_create {
            get { return getAttrVal<string>("Id_emp_create",null); }
            set { setAttrVal<string>("Id_emp_create", value); }
        }

        /// <summary>
        /// 嘱托
        /// </summary>
		public string Des_or {
            get { return getAttrVal<string>("Des_or",null); }
            set { setAttrVal<string>("Des_or", value); }
        }

        /// <summary>
        /// 申请时间
        /// </summary>
		public DateTime? Dt_create {
            get { return getAttrVal<FDateTime>("Dt_create",null); }
            set { setAttrVal<FDateTime>("Dt_create", value); }
        }

        /// <summary>
        /// 用血医嘱对应的备血医嘱id号
        /// </summary>
		public string Id_or_rel {
            get { return getAttrVal<string>("Id_or_rel",null); }
            set { setAttrVal<string>("Id_or_rel", value); }
        }

        /// <summary>
        /// 备血申请医师名称
        /// </summary>
		public string Name_emp_sign {
            get { return getAttrVal<string>("Name_emp_sign",null); }
            set { setAttrVal<string>("Name_emp_sign", value); }
        }

        /// <summary>
        /// 申请医师名称
        /// </summary>
		public string Name_emp_create {
            get { return getAttrVal<string>("Name_emp_create",null); }
            set { setAttrVal<string>("Name_emp_create", value); }
        }

        /// <summary>
        /// 用法名称
        /// </summary>
		public string Name_route {
            get { return getAttrVal<string>("Name_route",null); }
            set { setAttrVal<string>("Name_route", value); }
        }

        /// <summary>
        /// 计划用血时间
        /// </summary>
		public DateTime? Dt_bu_pl_ub {
            get { return getAttrVal<FDateTime>("Dt_bu_pl_ub", null); }
            set { setAttrVal<FDateTime>("Dt_bu_pl_ub", value); }
        }

        /// <summary>
        /// 用血申请单号
        /// </summary>
		public string No_applyform_ub {
            get { return getAttrVal<string>("No_applyform_ub",null); }
            set { setAttrVal<string>("No_applyform_ub", value); }
        }

        /// <summary>
        /// 备血申请单
        /// </summary>
		public string Prebt {
            get { return getAttrVal<string>("Prebt",null); }
            set { setAttrVal<string>("Prebt", value); }
        }

        /// <summary>
        /// 用血主键
        /// </summary>
		public string Id_apbu {
            get { return getAttrVal<string>("Id_apbu",null); }
            set { setAttrVal<string>("Id_apbu", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Id_mp_dep {
            get { return getAttrVal<string>("Id_mp_dep",null); }
            set { setAttrVal<string>("Id_mp_dep", value); }
        }

        /// <summary>
        /// 执行科室名称
        /// </summary>
		public string Name_mp_dep {
            get { return getAttrVal<string>("Name_mp_dep",null); }
            set { setAttrVal<string>("Name_mp_dep", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Applyform", "Id_srv", "Orsrvname", "Quan_medu", "Id_unit", "Num_bt", "Dt_bt_pl", "Id_emp_sign", "Num_margin_bu", "Name_unit", "Quan_medu_ub", "Id_route", "Id_emp_create", "Des_or", "Dt_create", "Id_or_rel", "Name_emp_sign", "Name_emp_create", "Name_route", "Dt_bu_pl_ub", "No_applyform_ub", "Prebt", "Id_apbu", "Id_mp_dep", "Name_mp_dep"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.d.CiordubDTO";
        }
    }
}

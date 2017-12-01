using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciordems.d
{
    /// <summary>
    /// OrConfirm 的摘要说明。
    /// </summary>
    public class OrConfirm : BaseDTO {

        public OrConfirm() {
 
        }

        /// <summary>
        /// 医嘱确认主键
        /// </summary>
		public string Id_confirm {
            get { return getAttrVal<string>("Id_confirm",null); }
            set { setAttrVal<string>("Id_confirm", value); }
        }

        /// <summary>
        /// 选择
        /// </summary>
		public bool? Fg_chk {
            get { return getAttrVal<FBoolean>("Fg_chk",null); }
            set { setAttrVal<FBoolean>("Fg_chk", value); }
        }

        /// <summary>
        /// 床位主键
        /// </summary>
		public string Id_bed {
            get { return getAttrVal<string>("Id_bed",null); }
            set { setAttrVal<string>("Id_bed", value); }
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
		public string Name_sex_pat {
            get { return getAttrVal<string>("Name_sex_pat",null); }
            set { setAttrVal<string>("Name_sex_pat", value); }
        }

        /// <summary>
        /// 性别id患者
        /// </summary>
		public string Id_sex_pat {
            get { return getAttrVal<string>("Id_sex_pat",null); }
            set { setAttrVal<string>("Id_sex_pat", value); }
        }

        /// <summary>
        /// 患者年龄
        /// </summary>
		public string Age_pat {
            get { return getAttrVal<string>("Age_pat",null); }
            set { setAttrVal<string>("Age_pat", value); }
        }

        /// <summary>
        /// 医嘱状态
        /// </summary>
		public string Id_su_or {
            get { return getAttrVal<string>("Id_su_or",null); }
            set { setAttrVal<string>("Id_su_or", value); }
        }

        /// <summary>
        /// 医嘱状态id
        /// </summary>
		public string Name_su_or {
            get { return getAttrVal<string>("Name_su_or",null); }
            set { setAttrVal<string>("Name_su_or", value); }
        }

        /// <summary>
        /// 状态
        /// </summary>
		public string Sd_su_or {
            get { return getAttrVal<string>("Sd_su_or",null); }
            set { setAttrVal<string>("Sd_su_or", value); }
        }

        /// <summary>
        /// 长临标识
        /// </summary>
		public bool? Fg_long {
            get { return getAttrVal<FBoolean>("Fg_long",null); }
            set { setAttrVal<FBoolean>("Fg_long", value); }
        }

        /// <summary>
        /// 医嘱内容
        /// </summary>
		public string Content_or {
            get { return getAttrVal<string>("Content_or",null); }
            set { setAttrVal<string>("Content_or", value); }
        }

        /// <summary>
        /// 频次id
        /// </summary>
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 频次
        /// </summary>
		public string Name_freq {
            get { return getAttrVal<string>("Name_freq",null); }
            set { setAttrVal<string>("Name_freq", value); }
        }

        /// <summary>
        /// 生效日期
        /// </summary>
		public DateTime? Dt_effe {
            get { return getAttrVal<FDateTime>("Dt_effe",null); }
            set { setAttrVal<FDateTime>("Dt_effe", value); }
        }

        /// <summary>
        /// 开立医生id
        /// </summary>
		public string Id_emp_create {
            get { return getAttrVal<string>("Id_emp_create",null); }
            set { setAttrVal<string>("Id_emp_create", value); }
        }

        /// <summary>
        /// 开立医生姓名
        /// </summary>
		public string Name_emp_sign {
            get { return getAttrVal<string>("Name_emp_sign",null); }
            set { setAttrVal<string>("Name_emp_sign", value); }
        }

        /// <summary>
        /// 停止时间
        /// </summary>
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }

        /// <summary>
        /// 停止医生id
        /// </summary>
		public string Id_emp_stop {
            get { return getAttrVal<string>("Id_emp_stop",null); }
            set { setAttrVal<string>("Id_emp_stop", value); }
        }

        /// <summary>
        /// 停止医生
        /// </summary>
		public string Name_emp_stop {
            get { return getAttrVal<string>("Name_emp_stop",null); }
            set { setAttrVal<string>("Name_emp_stop", value); }
        }

        /// <summary>
        /// 作废时间
        /// </summary>
		public DateTime? Dt_canc {
            get { return getAttrVal<FDateTime>("Dt_canc",null); }
            set { setAttrVal<FDateTime>("Dt_canc", value); }
        }

        /// <summary>
        /// 作废医生id
        /// </summary>
		public string Id_emp_canc {
            get { return getAttrVal<string>("Id_emp_canc",null); }
            set { setAttrVal<string>("Id_emp_canc", value); }
        }

        /// <summary>
        /// 作废医生
        /// </summary>
		public string Name_emp_canc {
            get { return getAttrVal<string>("Name_emp_canc",null); }
            set { setAttrVal<string>("Name_emp_canc", value); }
        }

        /// <summary>
        /// 患者科室id
        /// </summary>
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }

        /// <summary>
        /// 患者科室
        /// </summary>
		public string Name_dep_phy {
            get { return getAttrVal<string>("Name_dep_phy",null); }
            set { setAttrVal<string>("Name_dep_phy", value); }
        }

        /// <summary>
        /// 版本号
        /// </summary>
		public DateTime? Sv {
            get { return getAttrVal<FDateTime>("Sv",null); }
            set { setAttrVal<FDateTime>("Sv", value); }
        }

        /// <summary>
        /// 医嘱标志
        /// </summary>
		public bool? Fg_or {
            get { return getAttrVal<FBoolean>("Fg_or",null); }
            set { setAttrVal<FBoolean>("Fg_or", value); }
        }

        /// <summary>
        /// 长临状态
        /// </summary>
		public string Str_long {
            get { return getAttrVal<string>("Str_long",null); }
            set { setAttrVal<string>("Str_long", value); }
        }

        /// <summary>
        /// 病床号
        /// </summary>
		public string Code_bed {
            get { return getAttrVal<string>("Code_bed",null); }
            set { setAttrVal<string>("Code_bed", value); }
        }

        /// <summary>
        /// 就诊主键
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 就诊编码
        /// </summary>
		public string Entcode {
            get { return getAttrVal<string>("Entcode",null); }
            set { setAttrVal<string>("Entcode", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 患者主键
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 患者性别sex
        /// </summary>
		public string Sd_sex {
            get { return getAttrVal<string>("Sd_sex",null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }

        /// <summary>
        /// 患者出生日期
        /// </summary>
		public DateTime? Dt_birth_pat {
            get { return getAttrVal<FDate>("Dt_birth_pat",null); }
            set { setAttrVal<FDate>("Dt_birth_pat", value); }
        }

        /// <summary>
        /// 医保计划
        /// </summary>
		public string Id_hp {
            get { return getAttrVal<string>("Id_hp",null); }
            set { setAttrVal<string>("Id_hp", value); }
        }

        /// <summary>
        /// 医保计划名称
        /// </summary>
		public string Name_id_hp {
            get { return getAttrVal<string>("Name_id_hp",null); }
            set { setAttrVal<string>("Name_id_hp", value); }
        }

        /// <summary>
        /// 当前病区
        /// </summary>
		public string Id_dep_nur {
            get { return getAttrVal<string>("Id_dep_nur",null); }
            set { setAttrVal<string>("Id_dep_nur", value); }
        }

        /// <summary>
        /// 当前病区名称
        /// </summary>
		public string Name_dep_nur {
            get { return getAttrVal<string>("Name_dep_nur",null); }
            set { setAttrVal<string>("Name_dep_nur", value); }
        }

        /// <summary>
        /// 床号
        /// </summary>
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }

        /// <summary>
        /// 签署标志
        /// </summary>
		public bool? Fg_sign {
            get { return getAttrVal<FBoolean>("Fg_sign",null); }
            set { setAttrVal<FBoolean>("Fg_sign", value); }
        }

        /// <summary>
        /// 停止标志
        /// </summary>
		public bool? Fg_stop {
            get { return getAttrVal<FBoolean>("Fg_stop",null); }
            set { setAttrVal<FBoolean>("Fg_stop", value); }
        }

        /// <summary>
        /// 作废标志
        /// </summary>
		public bool? Fg_canc {
            get { return getAttrVal<FBoolean>("Fg_canc",null); }
            set { setAttrVal<FBoolean>("Fg_canc", value); }
        }

        /// <summary>
        /// 医嘱确认分类id
        /// </summary>
		public string Id_orderchkca {
            get { return getAttrVal<string>("Id_orderchkca",null); }
            set { setAttrVal<string>("Id_orderchkca", value); }
        }

        /// <summary>
        /// 医嘱确认分类
        /// </summary>
		public string Name_orderchkca {
            get { return getAttrVal<string>("Name_orderchkca",null); }
            set { setAttrVal<string>("Name_orderchkca", value); }
        }

        /// <summary>
        /// 作废核对
        /// </summary>
		public bool? Fg_chk_canc {
            get { return getAttrVal<FBoolean>("Fg_chk_canc",null); }
            set { setAttrVal<FBoolean>("Fg_chk_canc", value); }
        }

        /// <summary>
        /// 停止核对
        /// </summary>
		public bool? Fg_chk_stop {
            get { return getAttrVal<FBoolean>("Fg_chk_stop",null); }
            set { setAttrVal<FBoolean>("Fg_chk_stop", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }

        /// <summary>
        /// 出院带药标识
        /// </summary>
		public bool? Fg_pres_outp {
            get { return getAttrVal<FBoolean>("Fg_pres_outp",null); }
            set { setAttrVal<FBoolean>("Fg_pres_outp", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_confirm", "Fg_chk", "Id_bed", "Name_pat", "Name_sex_pat", "Id_sex_pat", "Age_pat", "Id_su_or", "Name_su_or", "Sd_su_or", "Fg_long", "Content_or", "Id_freq", "Name_freq", "Dt_effe", "Id_emp_create", "Name_emp_sign", "Dt_end", "Id_emp_stop", "Name_emp_stop", "Dt_canc", "Id_emp_canc", "Name_emp_canc", "Id_dep_phy", "Name_dep_phy", "Sv", "Fg_or", "Str_long", "Code_bed", "Id_ent", "Entcode", "Code_entp", "Id_pat", "Sd_sex", "Dt_birth_pat", "Id_hp", "Name_id_hp", "Id_dep_nur", "Name_dep_nur", "Name_bed", "Fg_sign", "Fg_stop", "Fg_canc", "Id_orderchkca", "Name_orderchkca", "Fg_chk_canc", "Fg_chk_stop", "Id_dep_mp", "Fg_pres_outp"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.OrConfirm";
        }
    }
}

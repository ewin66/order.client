using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrfp.dto.patinfo2mrfpdto.d
{
    /// <summary>
    /// PatInfo2MrfpDTO 的摘要说明。
    /// </summary>
    public class PatInfo2MrfpDTO : BaseDTO
    {

        public PatInfo2MrfpDTO()
        {

        }

        /// <summary>
        /// 住院病历首页ID
        /// </summary>
        public string Id_mrfp
        {
            get { return getAttrVal<string>("Id_mrfp", null); }
            set { setAttrVal<string>("Id_mrfp", value); }
        }

        /// <summary>
        /// 住院首页类型
        /// </summary>
        public string Sd_mrfptp
        {
            get { return getAttrVal<string>("Sd_mrfptp", null); }
            set { setAttrVal<string>("Sd_mrfptp", value); }
        }

        /// <summary>
        /// 患者ID
        /// </summary>
        public string Id_pat
        {
            get { return getAttrVal<string>("Id_pat", null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 机构
        /// </summary>
        public string Id_org
        {
            get { return getAttrVal<string>("Id_org", null); }
            set { setAttrVal<string>("Id_org", value); }
        }

        /// <summary>
        /// 就诊号
        /// </summary>
        public string Id_ent
        {
            get { return getAttrVal<string>("Id_ent", null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
        public string Name_pat
        {
            get { return getAttrVal<string>("Name_pat", null); }
            set { setAttrVal<string>("Name_pat", value); }
        }

        /// <summary>
        /// 住院病案号
        /// </summary>
        public string Code_amr_ip
        {
            get { return getAttrVal<string>("Code_amr_ip", null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }

        /// <summary>
        /// 就诊类型ID
        /// </summary>
        public string Id_entp
        {
            get { return getAttrVal<string>("Id_entp", null); }
            set { setAttrVal<string>("Id_entp", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
        public string Code_entp
        {
            get { return getAttrVal<string>("Code_entp", null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 性别
        /// </summary>
        public string Sex_pat
        {
            get { return getAttrVal<string>("Sex_pat", null); }
            set { setAttrVal<string>("Sex_pat", value); }
        }

        /// <summary>
        /// 性别编码
        /// </summary>
        public string Sd_sex
        {
            get { return getAttrVal<string>("Sd_sex", null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }

        /// <summary>
        /// 性别ID
        /// </summary>
        public string Id_sex_pat
        {
            get { return getAttrVal<string>("Id_sex_pat", null); }
            set { setAttrVal<string>("Id_sex_pat", value); }
        }

        /// <summary>
        /// 出生日期
        /// </summary>
        public DateTime? Dt_birth_pat
        {
            get { return getAttrVal<FDate>("Dt_birth_pat", null); }
            set { setAttrVal<FDate>("Dt_birth_pat", value); }
        }

        /// <summary>
        /// 年龄
        /// </summary>
        public string Age
        {
            get { return getAttrVal<string>("Age", null); }
            set { setAttrVal<string>("Age", value); }
        }

        /// <summary>
        /// 国籍
        /// </summary>
        public string Name_country
        {
            get { return getAttrVal<string>("Name_country", null); }
            set { setAttrVal<string>("Name_country", value); }
        }

        /// <summary>
        /// 民族
        /// </summary>
        public string Name_nation
        {
            get { return getAttrVal<string>("Name_nation", null); }
            set { setAttrVal<string>("Name_nation", value); }
        }

        /// <summary>
        /// 婚姻编码
        /// </summary>
        public string Sd_marry
        {
            get { return getAttrVal<string>("Sd_marry", null); }
            set { setAttrVal<string>("Sd_marry", value); }
        }

        /// <summary>
        /// 证件类型
        /// </summary>
        public string Sd_idtp
        {
            get { return getAttrVal<string>("Sd_idtp", null); }
            set { setAttrVal<string>("Sd_idtp", value); }
        }

        /// <summary>
        /// 证件类型名称
        /// </summary>
        public string Name_idtp
        {
            get { return getAttrVal<string>("Name_idtp", null); }
            set { setAttrVal<string>("Name_idtp", value); }
        }

        /// <summary>
        /// 证件号码
        /// </summary>
        public string Id_code
        {
            get { return getAttrVal<string>("Id_code", null); }
            set { setAttrVal<string>("Id_code", value); }
        }

        /// <summary>
        /// 职业
        /// </summary>
        public string Name_occu
        {
            get { return getAttrVal<string>("Name_occu", null); }
            set { setAttrVal<string>("Name_occu", value); }
        }

        /// <summary>
        /// 出生地址
        /// </summary>
        public string Addr_born
        {
            get { return getAttrVal<string>("Addr_born", null); }
            set { setAttrVal<string>("Addr_born", value); }
        }

        /// <summary>
        /// 籍贯
        /// </summary>
        public string Addr_origin
        {
            get { return getAttrVal<string>("Addr_origin", null); }
            set { setAttrVal<string>("Addr_origin", value); }
        }

        /// <summary>
        /// 现住址
        /// </summary>
        public string Addr_now
        {
            get { return getAttrVal<string>("Addr_now", null); }
            set { setAttrVal<string>("Addr_now", value); }
        }

        /// <summary>
        /// 现住址电话
        /// </summary>
        public string Tel_addr_now
        {
            get { return getAttrVal<string>("Tel_addr_now", null); }
            set { setAttrVal<string>("Tel_addr_now", value); }
        }

        /// <summary>
        /// 现住址邮编
        /// </summary>
        public string Zip_addr_now
        {
            get { return getAttrVal<string>("Zip_addr_now", null); }
            set { setAttrVal<string>("Zip_addr_now", value); }
        }

        /// <summary>
        /// 户口地址
        /// </summary>
        public string Addr_cencus
        {
            get { return getAttrVal<string>("Addr_cencus", null); }
            set { setAttrVal<string>("Addr_cencus", value); }
        }

        /// <summary>
        /// 户口地址邮编
        /// </summary>
        public string Zip_addr_cencus
        {
            get { return getAttrVal<string>("Zip_addr_cencus", null); }
            set { setAttrVal<string>("Zip_addr_cencus", value); }
        }

        /// <summary>
        /// 工作单位
        /// </summary>
        public string Workunit
        {
            get { return getAttrVal<string>("Workunit", null); }
            set { setAttrVal<string>("Workunit", value); }
        }

        /// <summary>
        /// 工作地址
        /// </summary>
        public string Addr_work
        {
            get { return getAttrVal<string>("Addr_work", null); }
            set { setAttrVal<string>("Addr_work", value); }
        }

        /// <summary>
        /// 工作地址电话
        /// </summary>
        public string Del_addr_work
        {
            get { return getAttrVal<string>("Del_addr_work", null); }
            set { setAttrVal<string>("Del_addr_work", value); }
        }

        /// <summary>
        /// 工作地址邮编
        /// </summary>
        public string Zip_addr_work
        {
            get { return getAttrVal<string>("Zip_addr_work", null); }
            set { setAttrVal<string>("Zip_addr_work", value); }
        }

        /// <summary>
        /// 联系人
        /// </summary>
        public string Name_cont
        {
            get { return getAttrVal<string>("Name_cont", null); }
            set { setAttrVal<string>("Name_cont", value); }
        }

        /// <summary>
        /// 关系
        /// </summary>
        public string Name_conttp
        {
            get { return getAttrVal<string>("Name_conttp", null); }
            set { setAttrVal<string>("Name_conttp", value); }
        }

        /// <summary>
        /// 联系人地址
        /// </summary>
        public string Addr_cont
        {
            get { return getAttrVal<string>("Addr_cont", null); }
            set { setAttrVal<string>("Addr_cont", value); }
        }

        /// <summary>
        /// 联系人电话
        /// </summary>
        public string Tel_cont
        {
            get { return getAttrVal<string>("Tel_cont", null); }
            set { setAttrVal<string>("Tel_cont", value); }
        }

        /// <summary>
        /// 责任医生ID
        /// </summary>
        public string Id_emp_phy
        {
            get { return getAttrVal<string>("Id_emp_phy", null); }
            set { setAttrVal<string>("Id_emp_phy", value); }
        }

        /// <summary>
        /// 责任医生
        /// </summary>
        public string Name_emp_phy
        {
            get { return getAttrVal<string>("Name_emp_phy", null); }
            set { setAttrVal<string>("Name_emp_phy", value); }
        }

        /// <summary>
        /// 责任护士ID
        /// </summary>
        public string Id_emp_nur
        {
            get { return getAttrVal<string>("Id_emp_nur", null); }
            set { setAttrVal<string>("Id_emp_nur", value); }
        }

        /// <summary>
        /// 责任护士
        /// </summary>
        public string Name_emp_nur
        {
            get { return getAttrVal<string>("Name_emp_nur", null); }
            set { setAttrVal<string>("Name_emp_nur", value); }
        }

        /// <summary>
        /// 主任医师ID
        /// </summary>
        public string Id_zr_doc
        {
            get { return getAttrVal<string>("Id_zr_doc", null); }
            set { setAttrVal<string>("Id_zr_doc", value); }
        }

        /// <summary>
        /// 主任医师
        /// </summary>
        public string Name_zr_doc
        {
            get { return getAttrVal<string>("Name_zr_doc", null); }
            set { setAttrVal<string>("Name_zr_doc", value); }
        }

        /// <summary>
        /// 主治医生ID
        /// </summary>
        public string Id_zz_doc
        {
            get { return getAttrVal<string>("Id_zz_doc", null); }
            set { setAttrVal<string>("Id_zz_doc", value); }
        }

        /// <summary>
        /// 主治医生
        /// </summary>
        public string Name_zz_doc
        {
            get { return getAttrVal<string>("Name_zz_doc", null); }
            set { setAttrVal<string>("Name_zz_doc", value); }
        }

        /// <summary>
        /// 住院医生ID
        /// </summary>
        public string Id_zy_doc
        {
            get { return getAttrVal<string>("Id_zy_doc", null); }
            set { setAttrVal<string>("Id_zy_doc", value); }
        }

        /// <summary>
        /// 住院医生
        /// </summary>
        public string Name_zy_doc
        {
            get { return getAttrVal<string>("Name_zy_doc", null); }
            set { setAttrVal<string>("Name_zy_doc", value); }
        }

        /// <summary>
        /// 医疗付费方式
        /// </summary>
        public string Name_pay_method
        {
            get { return getAttrVal<string>("Name_pay_method", null); }
            set { setAttrVal<string>("Name_pay_method", value); }
        }

        /// <summary>
        /// 医疗付费方式ID
        /// </summary>
        public string Id_pay_method
        {
            get { return getAttrVal<string>("Id_pay_method", null); }
            set { setAttrVal<string>("Id_pay_method", value); }
        }

        /// <summary>
        /// 医疗付费方式编码
        /// </summary>
        public string Sd_pay_method
        {
            get { return getAttrVal<string>("Sd_pay_method", null); }
            set { setAttrVal<string>("Sd_pay_method", value); }
        }

        /// <summary>
        /// 第几次住院
        /// </summary>
        public string N_times_inhospital
        {
            get { return getAttrVal<string>("N_times_inhospital", null); }
            set { setAttrVal<string>("N_times_inhospital", value); }
        }

        /// <summary>
        /// 入院途径
        /// </summary>
        public string Sd_referalsrc
        {
            get { return getAttrVal<string>("Sd_referalsrc", null); }
            set { setAttrVal<string>("Sd_referalsrc", value); }
        }

        /// <summary>
        /// 入院日期
        /// </summary>
        public DateTime? Dt_acpt
        {
            get { return getAttrVal<FDateTime>("Dt_acpt", null); }
            set { setAttrVal<FDateTime>("Dt_acpt", value); }
        }

        /// <summary>
        /// 入院科别
        /// </summary>
        public string Id_dep_phyadm
        {
            get { return getAttrVal<string>("Id_dep_phyadm", null); }
            set { setAttrVal<string>("Id_dep_phyadm", value); }
        }

        /// <summary>
        /// 转科科别
        /// </summary>
        public string Id_dep_trans
        {
            get { return getAttrVal<string>("Id_dep_trans", null); }
            set { setAttrVal<string>("Id_dep_trans", value); }
        }

        /// <summary>
        /// 出院日期
        /// </summary>
        public DateTime? Dt_end
        {
            get { return getAttrVal<FDateTime>("Dt_end", null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }

        /// <summary>
        /// 出院科别
        /// </summary>
        public string Id_dep_phydisc
        {
            get { return getAttrVal<string>("Id_dep_phydisc", null); }
            set { setAttrVal<string>("Id_dep_phydisc", value); }
        }

        /// <summary>
        /// 实际住院天数
        /// </summary>
        public int? Hosdays
        {
            get { return getAttrVal<int?>("Hosdays", null); }
            set { setAttrVal<int?>("Hosdays", value); }
        }

        /// <summary>
        /// 入院病房
        /// </summary>
        public string In_id_bed
        {
            get { return getAttrVal<string>("In_id_bed", null); }
            set { setAttrVal<string>("In_id_bed", value); }
        }

        /// <summary>
        /// 出院病房
        /// </summary>
        public string Out_id_bed
        {
            get { return getAttrVal<string>("Out_id_bed", null); }
            set { setAttrVal<string>("Out_id_bed", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Id_mrfp", "Sd_mrfptp", "Id_pat", "Id_org", "Id_ent", "Name_pat", "Code_amr_ip", "Id_entp", "Code_entp", "Sex_pat", "Sd_sex", "Id_sex_pat", "Dt_birth_pat", "Age", "Name_country", "Name_nation", "Sd_marry", "Sd_idtp", "Name_idtp", "Id_code", "Name_occu", "Addr_born", "Addr_origin", "Addr_now", "Tel_addr_now", "Zip_addr_now", "Addr_cencus", "Zip_addr_cencus", "Workunit", "Addr_work", "Del_addr_work", "Zip_addr_work", "Name_cont", "Name_conttp", "Addr_cont", "Tel_cont", "Id_emp_phy", "Name_emp_phy", "Id_emp_nur", "Name_emp_nur", "Id_zr_doc", "Name_zr_doc", "Id_zz_doc", "Name_zz_doc", "Id_zy_doc", "Name_zy_doc", "Name_pay_method", "Id_pay_method", "Sd_pay_method", "N_times_inhospital", "Sd_referalsrc", "Dt_acpt", "Id_dep_phyadm", "Id_dep_trans", "Dt_end", "Id_dep_phydisc", "Hosdays", "In_id_bed", "Out_id_bed" };
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrfp.dto.patinfo2mrfpdto.d.PatInfo2MrfpDTO";
        }
    }
}

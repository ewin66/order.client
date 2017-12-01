using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.srvref.d
{
    /// <summary>
    /// CiSrvRefParamDTO 的摘要说明。
    /// </summary>
    public class CiSrvRefParamDTO : BaseDTO {

        public CiSrvRefParamDTO() {
 
        }

        /// <summary>
        /// 表单id
        /// </summary>
		public string Id_billform {
            get { return getAttrVal<string>("Id_billform",null); }
            set { setAttrVal<string>("Id_billform", value); }
        }

        /// <summary>
        /// 就诊类型编码
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 所属集团
        /// </summary>
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }

        /// <summary>
        /// 所属组织
        /// </summary>
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }

        /// <summary>
        /// 科室
        /// </summary>
		public string Id_dep {
            get { return getAttrVal<string>("Id_dep",null); }
            set { setAttrVal<string>("Id_dep", value); }
        }

        /// <summary>
        /// 主医保计划
        /// </summary>
		public string Id_hp {
            get { return getAttrVal<string>("Id_hp",null); }
            set { setAttrVal<string>("Id_hp", value); }
        }

        /// <summary>
        /// 服务类型编码
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 模糊查询标识
        /// </summary>
		public bool? Fg_blurred {
            get { return getAttrVal<FBoolean>("Fg_blurred",null); }
            set { setAttrVal<FBoolean>("Fg_blurred", value); }
        }

        /// <summary>
        /// 按编码查询标识
        /// </summary>
		public bool? Fg_code {
            get { return getAttrVal<FBoolean>("Fg_code",null); }
            set { setAttrVal<FBoolean>("Fg_code", value); }
        }

        /// <summary>
        /// 按名称查询标识
        /// </summary>
		public bool? Fg_name {
            get { return getAttrVal<FBoolean>("Fg_name",null); }
            set { setAttrVal<FBoolean>("Fg_name", value); }
        }

        /// <summary>
        /// 按简称查询标识
        /// </summary>
		public bool? Fg_shortname {
            get { return getAttrVal<FBoolean>("Fg_shortname",null); }
            set { setAttrVal<FBoolean>("Fg_shortname", value); }
        }

        /// <summary>
        /// 按拼音码查询标识
        /// </summary>
		public bool? Fg_pycode {
            get { return getAttrVal<FBoolean>("Fg_pycode",null); }
            set { setAttrVal<FBoolean>("Fg_pycode", value); }
        }

        /// <summary>
        /// 按五笔查询标识
        /// </summary>
		public bool? Fg_wbcode {
            get { return getAttrVal<FBoolean>("Fg_wbcode",null); }
            set { setAttrVal<FBoolean>("Fg_wbcode", value); }
        }

        /// <summary>
        /// 按助记码查询标识
        /// </summary>
		public bool? Fg_mnemonic {
            get { return getAttrVal<FBoolean>("Fg_mnemonic",null); }
            set { setAttrVal<FBoolean>("Fg_mnemonic", value); }
        }

        /// <summary>
        /// 返回记录数
        /// </summary>
		public string Result_cnt {
            get { return getAttrVal<string>("Result_cnt",null); }
            set { setAttrVal<string>("Result_cnt", value); }
        }

        /// <summary>
        /// 医疗单
        /// </summary>
		public string Id_ems {
            get { return getAttrVal<string>("Id_ems",null); }
            set { setAttrVal<string>("Id_ems", value); }
        }

        /// <summary>
        /// 医生场景标识
        /// </summary>
		public bool? Fg_doctor {
            get { return getAttrVal<FBoolean>("Fg_doctor",null); }
            set { setAttrVal<FBoolean>("Fg_doctor", value); }
        }

        /// <summary>
        /// 输入串
        /// </summary>
		public string Inputstr {
            get { return getAttrVal<string>("Inputstr",null); }
            set { setAttrVal<string>("Inputstr", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_billform", "Code_entp", "Id_grp", "Id_org", "Id_dep", "Id_hp", "Sd_srvtp", "Fg_blurred", "Fg_code", "Fg_name", "Fg_shortname", "Fg_pycode", "Fg_wbcode", "Fg_mnemonic", "Result_cnt", "Id_ems", "Fg_doctor", "Inputstr"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.srvref.d.CiSrvRefParamDTO";
        }
    }
}

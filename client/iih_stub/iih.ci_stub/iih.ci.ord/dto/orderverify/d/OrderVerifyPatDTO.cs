using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.orderverify.d
{
    /// <summary>
    /// OrderVerifyPatDTO 的摘要说明。
    /// </summary>
    public class OrderVerifyPatDTO : BaseDTO {

        public OrderVerifyPatDTO() {
 
        }

        /// <summary>
        /// 患者id
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 就诊id
        /// </summary>
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }

        /// <summary>
        /// 医嘱id
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 患者编码
        /// </summary>
		public string Code_pat {
            get { return getAttrVal<string>("Code_pat",null); }
            set { setAttrVal<string>("Code_pat", value); }
        }

        /// <summary>
        /// 患者名称
        /// </summary>
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }

        /// <summary>
        /// 病区
        /// </summary>
		public string Id_dep_chk {
            get { return getAttrVal<string>("Id_dep_chk",null); }
            set { setAttrVal<string>("Id_dep_chk", value); }
        }

        /// <summary>
        /// 病区名称
        /// </summary>
		public string Name_dep_chk {
            get { return getAttrVal<string>("Name_dep_chk",null); }
            set { setAttrVal<string>("Name_dep_chk", value); }
        }

        /// <summary>
        /// 科室id
        /// </summary>
		public string Id_dep {
            get { return getAttrVal<string>("Id_dep",null); }
            set { setAttrVal<string>("Id_dep", value); }
        }

        /// <summary>
        /// 科室名称
        /// </summary>
		public string Name_dep {
            get { return getAttrVal<string>("Name_dep",null); }
            set { setAttrVal<string>("Name_dep", value); }
        }

        /// <summary>
        /// 医嘱数
        /// </summary>
		public int? Ord_num {
            get { return getAttrVal<int?>("Ord_num",null); }
            set { setAttrVal<int?>("Ord_num", value); }
        }

        /// <summary>
        /// 审核状态
        /// </summary>
		public int? Eu_verify_pharm {
            get { return getAttrVal<int?>("Eu_verify_pharm",null); }
            set { setAttrVal<int?>("Eu_verify_pharm", value); }
        }

        /// <summary>
        /// 最近医嘱开时间
        /// </summary>
		public DateTime? Max_dt_entry {
            get { return getAttrVal<FDateTime>("Max_dt_entry",null); }
            set { setAttrVal<FDateTime>("Max_dt_entry", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_pat", "Id_en", "Id_or", "Code_pat", "Name_pat", "Id_dep_chk", "Name_dep_chk", "Id_dep", "Name_dep", "Ord_num", "Eu_verify_pharm", "Max_dt_entry"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.orderverify.d.OrderVerifyPatDTO";
        }
    }
}

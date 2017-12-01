using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciordems.d
{
    /// <summary>
    /// EmsItemInPathgy 的摘要说明。
    /// </summary>
    public class EmsItemInPathgy : BaseDTO {

        public EmsItemInPathgy() {
 
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id_oriteminpathgy {
            get { return getAttrVal<string>("Id_oriteminpathgy",null); }
            set { setAttrVal<string>("Id_oriteminpathgy", value); }
        }

        /// <summary>
        /// 医嘱主键
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 标本名称
        /// </summary>
		public string Name_labsamp {
            get { return getAttrVal<string>("Name_labsamp",null); }
            set { setAttrVal<string>("Name_labsamp", value); }
        }

        /// <summary>
        /// 标本采集部位id
        /// </summary>
		public string Id_body_coll {
            get { return getAttrVal<string>("Id_body_coll",null); }
            set { setAttrVal<string>("Id_body_coll", value); }
        }

        /// <summary>
        /// 标本采集部位sd
        /// </summary>
		public string Sd_body_coll {
            get { return getAttrVal<string>("Sd_body_coll",null); }
            set { setAttrVal<string>("Sd_body_coll", value); }
        }

        /// <summary>
        /// 采集部位
        /// </summary>
		public string Body_coll {
            get { return getAttrVal<string>("Body_coll",null); }
            set { setAttrVal<string>("Body_coll", value); }
        }

        /// <summary>
        /// 标本数量
        /// </summary>
		public int? Quan_coll {
            get { return getAttrVal<int?>("Quan_coll",null); }
            set { setAttrVal<int?>("Quan_coll", value); }
        }

        /// <summary>
        /// 标本固定液id
        /// </summary>
		public string Id_fixative {
            get { return getAttrVal<string>("Id_fixative",null); }
            set { setAttrVal<string>("Id_fixative", value); }
        }

        /// <summary>
        /// 标本固定液sd
        /// </summary>
		public string Sd_fixative {
            get { return getAttrVal<string>("Sd_fixative",null); }
            set { setAttrVal<string>("Sd_fixative", value); }
        }

        /// <summary>
        /// 固定液
        /// </summary>
		public string Fixative {
            get { return getAttrVal<string>("Fixative",null); }
            set { setAttrVal<string>("Fixative", value); }
        }

        /// <summary>
        /// 采集所见
        /// </summary>
		public string Collectdes {
            get { return getAttrVal<string>("Collectdes",null); }
            set { setAttrVal<string>("Collectdes", value); }
        }

        /// <summary>
        /// 采集时间
        /// </summary>
		public DateTime? Dt_coll {
            get { return getAttrVal<FDateTime>("Dt_coll",null); }
            set { setAttrVal<FDateTime>("Dt_coll", value); }
        }

        /// <summary>
        /// 采集者编码
        /// </summary>
		public string Id_emp_coll {
            get { return getAttrVal<string>("Id_emp_coll",null); }
            set { setAttrVal<string>("Id_emp_coll", value); }
        }

        /// <summary>
        /// 采集者名称
        /// </summary>
		public string Name_emp_coll {
            get { return getAttrVal<string>("Name_emp_coll",null); }
            set { setAttrVal<string>("Name_emp_coll", value); }
        }

        /// <summary>
        /// 序号
        /// </summary>
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }

        /// <summary>
        /// 标本状态id
        /// </summary>
		public string Id_su_labsamp {
            get { return getAttrVal<string>("Id_su_labsamp",null); }
            set { setAttrVal<string>("Id_su_labsamp", value); }
        }

        /// <summary>
        /// 标本状态编码
        /// </summary>
		public string Sd_su_labsamp {
            get { return getAttrVal<string>("Sd_su_labsamp",null); }
            set { setAttrVal<string>("Sd_su_labsamp", value); }
        }

        /// <summary>
        /// 标本签收科室
        /// </summary>
		public string Id_dep_sign {
            get { return getAttrVal<string>("Id_dep_sign",null); }
            set { setAttrVal<string>("Id_dep_sign", value); }
        }

        /// <summary>
        /// 标本签收人
        /// </summary>
		public string Id_emp_sign {
            get { return getAttrVal<string>("Id_emp_sign",null); }
            set { setAttrVal<string>("Id_emp_sign", value); }
        }

        /// <summary>
        /// 医保
        /// </summary>
		public string Id_haeth {
            get { return getAttrVal<string>("Id_hp",null); }
            set { setAttrVal<string>("Id_hp", value); }
        }

        /// <summary>
        /// 医保名称
        /// </summary>
		public string Name_heath {
            get { return getAttrVal<string>("Name_hp",null); }
            set { setAttrVal<string>("Name_hp", value); }
        }

        /// <summary>
        /// 医保类型
        /// </summary>
		public string Id_hpsrvtp {
            get { return getAttrVal<string>("Id_hpsrvtp",null); }
            set { setAttrVal<string>("Id_hpsrvtp", value); }
        }

        /// <summary>
        /// 医保类型编码
        /// </summary>
		public string Sd_hpsrvtp {
            get { return getAttrVal<string>("Sd_hpsrvtp",null); }
            set { setAttrVal<string>("Sd_hpsrvtp", value); }
        }

        /// <summary>
        /// 医疗单来源
        /// </summary>
		public String Eu_sourcemd {
            get { return getAttrVal<String>("Eu_sourcemd",null); }
            set { setAttrVal<String>("Eu_sourcemd", value); }
        }

        /// <summary>
        /// 费用标识
        /// </summary>
		public bool? Fg_bl {
            get { return getAttrVal<FBoolean>("Fg_bl",null); }
            set { setAttrVal<FBoolean>("Fg_bl", value); }
        }

        /// <summary>
        /// 临床标识
        /// </summary>
		public bool? Fg_or {
            get { return getAttrVal<FBoolean>("Fg_or",null); }
            set { setAttrVal<FBoolean>("Fg_or", value); }
        }

        /// <summary>
        /// 服务来源
        /// </summary>
		public string Id_srv_src {
            get { return getAttrVal<string>("Id_srv_src",null); }
            set { setAttrVal<string>("Id_srv_src", value); }
        }

        /// <summary>
        /// 计价方式
        /// </summary>
		public string Priby {
            get { return getAttrVal<string>("Priby",null); }
            set { setAttrVal<string>("Priby", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_oriteminpathgy", "Id_or", "Name_labsamp", "Id_body_coll", "Sd_body_coll", "Body_coll", "Quan_coll", "Id_fixative", "Sd_fixative", "Fixative", "Collectdes", "Dt_coll", "Id_emp_coll", "Name_emp_coll", "Sortno", "Id_su_labsamp", "Sd_su_labsamp", "Id_dep_sign", "Id_emp_sign", "Id_hp", "Name_hp", "Id_hpsrvtp", "Sd_hpsrvtp", "Eu_sourcemd", "Fg_bl", "Fg_or", "Id_srv_src", "Priby"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.EmsItemInPathgy";
        }
    }
}

using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.pre.dto.d
{
    /// <summary>
    /// EmergPreDTO 的摘要说明。
    /// </summary>
    public class EmergPreDTO : BaseDTO {

        public EmergPreDTO() {
 
        }

        /// <summary>
        /// 预检id
        /// </summary>
		public string Id_obspre {
            get { return getAttrVal<string>("Id_obspre",null); }
            set { setAttrVal<string>("Id_obspre", value); }
        }

        /// <summary>
        /// 就诊id
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 患者id
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }

        /// <summary>
        /// 病情等级
        /// </summary>
		public string Id_level_dise {
            get { return getAttrVal<string>("Id_level_dise",null); }
            set { setAttrVal<string>("Id_level_dise", value); }
        }

        /// <summary>
        /// 病情等级编码
        /// </summary>
		public string Sd_level_dise {
            get { return getAttrVal<string>("Sd_level_dise",null); }
            set { setAttrVal<string>("Sd_level_dise", value); }
        }

        /// <summary>
        /// 到院时间
        /// </summary>
		public DateTime? Dt_entry {
            get { return getAttrVal<FDateTime>("Dt_entry",null); }
            set { setAttrVal<FDateTime>("Dt_entry", value); }
        }

        /// <summary>
        /// 到院方式
        /// </summary>
		public string Id_come_way {
            get { return getAttrVal<string>("Id_come_way",null); }
            set { setAttrVal<string>("Id_come_way", value); }
        }

        /// <summary>
        /// 到院方式编码
        /// </summary>
		public string Sd_come_way {
            get { return getAttrVal<string>("Sd_come_way",null); }
            set { setAttrVal<string>("Sd_come_way", value); }
        }

        /// <summary>
        /// 到院方式名称
        /// </summary>
		public string Name_come_way {
            get { return getAttrVal<string>("Name_come_way",null); }
            set { setAttrVal<string>("Name_come_way", value); }
        }

        /// <summary>
        /// 抢救开始时间
        /// </summary>
		public DateTime? Dt_rescue_b {
            get { return getAttrVal<FDateTime>("Dt_rescue_b",null); }
            set { setAttrVal<FDateTime>("Dt_rescue_b", value); }
        }

        /// <summary>
        /// 抢救结束时间
        /// </summary>
		public DateTime? Dt_rescue_e {
            get { return getAttrVal<FDateTime>("Dt_rescue_e",null); }
            set { setAttrVal<FDateTime>("Dt_rescue_e", value); }
        }

        /// <summary>
        /// 陪伴人员id
        /// </summary>
		public string Ids_companion {
            get { return getAttrVal<string>("Ids_companion",null); }
            set { setAttrVal<string>("Ids_companion", value); }
        }

        /// <summary>
        /// 陪伴人员
        /// </summary>
		public string Sds_companion {
            get { return getAttrVal<string>("Sds_companion",null); }
            set { setAttrVal<string>("Sds_companion", value); }
        }

        /// <summary>
        /// 询问流行病史标志
        /// </summary>
		public bool? Fg_chk_eqidemic {
            get { return getAttrVal<FBoolean>("Fg_chk_eqidemic",null); }
            set { setAttrVal<FBoolean>("Fg_chk_eqidemic", value); }
        }

        /// <summary>
        /// 有24时发热
        /// </summary>
		public bool? Fg_has_hot {
            get { return getAttrVal<FBoolean>("Fg_has_hot",null); }
            set { setAttrVal<FBoolean>("Fg_has_hot", value); }
        }

        /// <summary>
        /// 有3天发热
        /// </summary>
		public bool? Fg_has_hot2 {
            get { return getAttrVal<FBoolean>("Fg_has_hot2",null); }
            set { setAttrVal<FBoolean>("Fg_has_hot2", value); }
        }

        /// <summary>
        /// 有最近疫区旅游
        /// </summary>
		public bool? Fg_has_eqidarea {
            get { return getAttrVal<FBoolean>("Fg_has_eqidarea",null); }
            set { setAttrVal<FBoolean>("Fg_has_eqidarea", value); }
        }

        /// <summary>
        /// 有接触动物
        /// </summary>
		public bool? Fg_has_touchanim {
            get { return getAttrVal<FBoolean>("Fg_has_touchanim",null); }
            set { setAttrVal<FBoolean>("Fg_has_touchanim", value); }
        }

        /// <summary>
        /// 询问补充
        /// </summary>
		public string Chk_note {
            get { return getAttrVal<string>("Chk_note",null); }
            set { setAttrVal<string>("Chk_note", value); }
        }

        /// <summary>
        /// 预检服务项目集合
        /// </summary>
		public FArrayList Srvarray {
            get { return getAttrVal<FArrayList>("Srvarray",null); }
            set { setAttrVal<FArrayList>("Srvarray", value); }
        }

        /// <summary>
        /// 复诊
        /// </summary>
		public bool? Fg_revisit {
            get { return getAttrVal<FBoolean>("Fg_revisit",null); }
            set { setAttrVal<FBoolean>("Fg_revisit", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_obspre", "Id_ent", "Code_entp", "Id_pat", "Name_pat", "Id_level_dise", "Sd_level_dise", "Dt_entry", "Id_come_way", "Sd_come_way", "Name_come_way", "Dt_rescue_b", "Dt_rescue_e", "Ids_companion", "Sds_companion", "Fg_chk_eqidemic", "Fg_has_hot", "Fg_has_hot2", "Fg_has_eqidarea", "Fg_has_touchanim", "Chk_note", "Srvarray", "Fg_revisit"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.pre.dto.d.EmergPreDTO";
        }
    }
}

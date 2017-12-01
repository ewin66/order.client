using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.cimrrecallentdto.d
{
    /// <summary>
    /// CiMrRecallEntDTO 的摘要说明。
    /// </summary>
    public class CiMrRecallEntDTO : BaseDTO
    {

        public CiMrRecallEntDTO()
        {

        }

        /// <summary>
        /// 就诊id
        /// </summary>
        public string Id_ent
        {
            get { return getAttrVal<string>("Id_ent", null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 姓名
        /// </summary>
        public string Pat_name
        {
            get { return getAttrVal<string>("Pat_name", null); }
            set { setAttrVal<string>("Pat_name", value); }
        }

        /// <summary>
        /// 性别
        /// </summary>
        public string Pat_sex
        {
            get { return getAttrVal<string>("Pat_sex", null); }
            set { setAttrVal<string>("Pat_sex", value); }
        }

        /// <summary>
        /// 年龄
        /// </summary>
        public string Pat_age
        {
            get { return getAttrVal<string>("Pat_age", null); }
            set { setAttrVal<string>("Pat_age", value); }
        }

        /// <summary>
        /// 就诊时间
        /// </summary>
        public DateTime? Dt_ent
        {
            get { return getAttrVal<FDateTime>("Dt_ent", null); }
            set { setAttrVal<FDateTime>("Dt_ent", value); }
        }

        /// <summary>
        /// 就诊科室
        /// </summary>
        public string Name_dep_ent
        {
            get { return getAttrVal<string>("Name_dep_ent", null); }
            set { setAttrVal<string>("Name_dep_ent", value); }
        }

        /// <summary>
        /// 初诊或复诊
        /// </summary>
        public string Fg_first
        {
            get { return getAttrVal<string>("Fg_first", null); }
            set { setAttrVal<string>("Fg_first", value); }
        }

        /// <summary>
        /// 就诊科室id
        /// </summary>
        public string Id_dep_ent
        {
            get { return getAttrVal<string>("Id_dep_ent", null); }
            set { setAttrVal<string>("Id_dep_ent", value); }
        }

        /// <summary>
        /// 就诊科室code
        /// </summary>
        public string Code_dep_ent
        {
            get { return getAttrVal<string>("Code_dep_ent", null); }
            set { setAttrVal<string>("Code_dep_ent", value); }
        }

        /// <summary>
        /// 条码号
        /// </summary>
        public string Barcode_chis
        {
            get { return getAttrVal<string>("Barcode_chis", null); }
            set { setAttrVal<string>("Barcode_chis", value); }
        }

        /// <summary>
        /// 就诊编码
        /// </summary>
        public string Ent_code
        {
            get { return getAttrVal<string>("Ent_code", null); }
            set { setAttrVal<string>("Ent_code", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Id_ent", "Pat_name", "Pat_sex", "Pat_age", "Dt_ent", "Name_dep_ent", "Fg_first", "Id_dep_ent", "Code_dep_ent", "Barcode_chis", "Ent_code" };
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.cimrrecallentdto.d.CiMrRecallEntDTO";
        }
    }
}

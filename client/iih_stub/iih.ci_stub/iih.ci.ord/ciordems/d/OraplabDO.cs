using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciordems.d
{
    /// <summary>
    /// OraplabDO 的摘要说明。
    /// </summary>
    public class OraplabDO : BaseDTO
    {

        public OraplabDO()
        {

        }
        public string Name_srv
        {
            get { return getAttrVal<string>("Name_srv", null); }
            set { setAttrVal<string>("Name_srv", value); }
        }
        public string Id_speca
        {
            get { return getAttrVal<string>("Id_speca", null); }
            set { setAttrVal<string>("Id_speca", value); }
        }
        public string Name_speca
        {
            get { return getAttrVal<string>("Name_speca", null); }
            set { setAttrVal<string>("Name_speca", value); }
        }
        public string Num_spe
        {
            get { return getAttrVal<string>("Num_spe", null); }
            set { setAttrVal<string>("Num_spe", value); }
        }
        public string Id_col_met
        {
            get { return getAttrVal<string>("Id_col_met", null); }
            set { setAttrVal<string>("Id_col_met", value); }
        }
        public string Name_col_met
        {
            get { return getAttrVal<string>("Name_col_met", null); }
            set { setAttrVal<string>("Name_col_met", value); }
        }
        public string Spe_des
        {
            get { return getAttrVal<string>("Spe_des", null); }
            set { setAttrVal<string>("Spe_des", value); }
        }
        public string Id_orlab_group
        {
            get { return getAttrVal<string>("Id_orlab_group", null); }
            set { setAttrVal<string>("Id_orlab_group", value); }
        }
        public string Orlab_group
        {
            get { return getAttrVal<string>("Orlab_group", null); }
            set { setAttrVal<string>("Orlab_group", value); }
        }
        public string Id_ordi
        {
            get { return getAttrVal<string>("Id_ordi", null); }
            set { setAttrVal<string>("Id_ordi", value); }
        }
        public string Name_ordi
        {
            get { return getAttrVal<string>("Name_ordi", null); }
            set { setAttrVal<string>("Name_ordi", value); }
        }
        public bool? Urgent_flag
        {
            get { return getAttrVal<FBoolean>("Urgent_flag", null); }
            set { setAttrVal<FBoolean>("Urgent_flag", value); }
        }
        public string Note
        {
            get { return getAttrVal<string>("Note", null); }
            set { setAttrVal<string>("Note", value); }
        }
        public string Id_or
        {
            get { return getAttrVal<string>("Id_or", null); }
            set { setAttrVal<string>("Id_or", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Name_srv", "Id_speca", "Name_speca", "Num_spe", "Id_col_met", "Name_col_met", "Spe_des", "Id_orlab_group", "Orlab_group", "Id_ordi", "Name_ordi", "Urgent_flag", "Note", "Id_or" };
        }
    }
}

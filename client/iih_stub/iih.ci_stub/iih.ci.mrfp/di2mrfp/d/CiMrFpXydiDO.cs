
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrfp.di2mrfp.d
{
    /// <summary>
    /// CiMrFpXydiDO 的摘要说明。
    /// </summary>
    public class CiMrFpXydiDO : BaseDO {

        public CiMrFpXydiDO() {
        }
		public string Id_mrfpxydi {
            get { return getAttrVal<string>("Id_mrfpxydi",null); }
            set { setAttrVal<string>("Id_mrfpxydi", value); }
        }
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }
		public string Sd_di {
            get { return getAttrVal<string>("Sd_di",null); }
            set { setAttrVal<string>("Sd_di", value); }
        }
		public string Name_di {
            get { return getAttrVal<string>("Name_di",null); }
            set { setAttrVal<string>("Name_di", value); }
        }
		public int? Id_dislvl_inp {
            get { return getAttrVal<int?>("Id_dislvl_inp",null); }
            set { setAttrVal<int?>("Id_dislvl_inp", value); }
        }
		public string Name_dislvl_inp {
            get { return getAttrVal<string>("Name_dislvl_inp",null); }
            set { setAttrVal<string>("Name_dislvl_inp", value); }
        }
		public string Id_di_type {
            get { return getAttrVal<string>("Id_di_type",null); }
            set { setAttrVal<string>("Id_di_type", value); }
        }
		public string Sd_di_type {
            get { return getAttrVal<string>("Sd_di_type",null); }
            set { setAttrVal<string>("Sd_di_type", value); }
        }
		public string Name_di_type {
            get { return getAttrVal<string>("Name_di_type",null); }
            set { setAttrVal<string>("Name_di_type", value); }
        }
		public string Id_mrfpdi {
            get { return getAttrVal<string>("Id_mrfpdi",null); }
            set { setAttrVal<string>("Id_mrfpdi", value); }
        }
		public string Sd_di_code {
            get { return getAttrVal<string>("Sd_di_code",null); }
            set { setAttrVal<string>("Sd_di_code", value); }
        }
		public string Di_name {
            get { return getAttrVal<string>("Di_name",null); }
            set { setAttrVal<string>("Di_name", value); }
        }
		public string Di_type_code {
            get { return getAttrVal<string>("Di_type_code",null); }
            set { setAttrVal<string>("Di_type_code", value); }
        }
		public string Di_type_name {
            get { return getAttrVal<string>("Di_type_name",null); }
            set { setAttrVal<string>("Di_type_name", value); }
        }
        public int Ds {
            get { return getAttrVal<int>("Ds",0);}
            set { setAttrVal<int>("Ds", value); }
        }

        public DateTime? Sv        {
            get { return getAttrVal<FDateTime>("Sv",null); }
            set { setAttrVal<FDateTime>("Sv", value); }
        }
        
        /// <summary>
        /// 返回表名
        /// </summary>
        /// <returns></returns>
        public override string getTableName()
        {
            return "CI_MR_FP_XYDI";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_mrfpxydi";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrfp.di2mrfp.d.CiMrFpXydiDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_mrfpxydi", "Sortno", "Id_di", "Sd_di", "Name_di", "Id_dislvl_inp", "Name_dislvl_inp", "Id_di_type", "Sd_di_type", "Name_di_type", "Id_mrfpdi", "Sd_di_code", "Di_name", "Di_type_code", "Di_type_name"};
        }
        
    }
}


using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.mrlogitm.d
{
    /// <summary>
    /// CiMrLogItmDO 的摘要说明。
    /// </summary>
    public class CiMrLogItmDO : BaseDO {

        public CiMrLogItmDO() {
        }
		public string Id_mr_log_itm {
            get { return getAttrVal<string>("Id_mr_log_itm",null); }
            set { setAttrVal<string>("Id_mr_log_itm", value); }
        }
		public string Id_mr_log {
            get { return getAttrVal<string>("Id_mr_log",null); }
            set { setAttrVal<string>("Id_mr_log", value); }
        }
		public string Text_operate_itm {
            get { return getAttrVal<string>("Text_operate_itm",null); }
            set { setAttrVal<string>("Text_operate_itm", value); }
        }
		public string Id_type_operate_itm {
            get { return getAttrVal<string>("Id_type_operate_itm",null); }
            set { setAttrVal<string>("Id_type_operate_itm", value); }
        }
		public string Sd_type_operate_itm {
            get { return getAttrVal<string>("Sd_type_operate_itm",null); }
            set { setAttrVal<string>("Sd_type_operate_itm", value); }
        }
		public int? Premissionlevel {
            get { return getAttrVal<int?>("Premissionlevel",null); }
            set { setAttrVal<int?>("Premissionlevel", value); }
        }
		public string Id_user_in {
            get { return getAttrVal<string>("Id_user_in",null); }
            set { setAttrVal<string>("Id_user_in", value); }
        }
		public string User_in_name {
            get { return getAttrVal<string>("User_in_name",null); }
            set { setAttrVal<string>("User_in_name", value); }
        }
		public string Title_operate_itm {
            get { return getAttrVal<string>("Title_operate_itm",null); }
            set { setAttrVal<string>("Title_operate_itm", value); }
        }
		public DateTime? Dt_operate_itm {
            get { return getAttrVal<FDateTime>("Dt_operate_itm",null); }
            set { setAttrVal<FDateTime>("Dt_operate_itm", value); }
        }
		public string Type_operate_itm_code {
            get { return getAttrVal<string>("Type_operate_itm_code",null); }
            set { setAttrVal<string>("Type_operate_itm_code", value); }
        }
		public string Type_operate_itm_name {
            get { return getAttrVal<string>("Type_operate_itm_name",null); }
            set { setAttrVal<string>("Type_operate_itm_name", value); }
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
            return "ci_mr_log_itm";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_mr_log_itm";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.mrlogitm.d.CiMrLogItmDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_mr_log_itm", "Id_mr_log", "Text_operate_itm", "Id_type_operate_itm", "Sd_type_operate_itm", "Premissionlevel", "Id_user_in", "User_in_name", "Title_operate_itm", "Dt_operate_itm", "Type_operate_itm_code", "Type_operate_itm_name"};
        }
        
    }
}

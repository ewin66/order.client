
using System;
using System.Text;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.mrtask.d
{
    /// <summary>
    /// MrTaskDO 的摘要说明。
    /// </summary>
    public class MrTaskDO : BaseDO
    {

        public MrTaskDO()
        {
        }
        public string Id_mrtask
        {
            get { return getAttrVal<string>("Id_mrtask", null); }
            set { setAttrVal<string>("Id_mrtask", value); }
        }
        public string Id_grp
        {
            get { return getAttrVal<string>("Id_grp", null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
        public string Id_org
        {
            get { return getAttrVal<string>("Id_org", null); }
            set { setAttrVal<string>("Id_org", value); }
        }
        public string Mrtask_name
        {
            get { return getAttrVal<string>("Mrtask_name", null); }
            set { setAttrVal<string>("Mrtask_name", value); }
        }
        public string Id_qa_itm_config
        {
            get { return getAttrVal<string>("Id_qa_itm_config", null); }
            set { setAttrVal<string>("Id_qa_itm_config", value); }
        }
        public string Id_mrtask_sta
        {
            get { return getAttrVal<string>("Id_mrtask_sta", null); }
            set { setAttrVal<string>("Id_mrtask_sta", value); }
        }
        public string Sd_mrtask_sta
        {
            get { return getAttrVal<string>("Sd_mrtask_sta", null); }
            set { setAttrVal<string>("Sd_mrtask_sta", value); }
        }
        public string Id_pat
        {
            get { return getAttrVal<string>("Id_pat", null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
        public string Id_ent
        {
            get { return getAttrVal<string>("Id_ent", null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
        public string Id_exec_dept
        {
            get { return getAttrVal<string>("Id_exec_dept", null); }
            set { setAttrVal<string>("Id_exec_dept", value); }
        }
        public string Id_exec_doctor
        {
            get { return getAttrVal<string>("Id_exec_doctor", null); }
            set { setAttrVal<string>("Id_exec_doctor", value); }
        }
        public string Id_mrcactm
        {
            get { return getAttrVal<string>("Id_mrcactm", null); }
            set { setAttrVal<string>("Id_mrcactm", value); }
        }
        public string Id_mrtp
        {
            get { return getAttrVal<string>("Id_mrtp", null); }
            set { setAttrVal<string>("Id_mrtp", value); }
        }
        public string Id_source
        {
            get { return getAttrVal<string>("Id_source", null); }
            set { setAttrVal<string>("Id_source", value); }
        }
        public string Source_type
        {
            get { return getAttrVal<string>("Source_type", null); }
            set { setAttrVal<string>("Source_type", value); }
        }
        public string Source_name
        {
            get { return getAttrVal<string>("Source_name", null); }
            set { setAttrVal<string>("Source_name", value); }
        }
        public DateTime? Dt_begin
        {
            get { return getAttrVal<FDateTime>("Dt_begin", null); }
            set { setAttrVal<FDateTime>("Dt_begin", value); }
        }
        public DateTime? Dt_end
        {
            get { return getAttrVal<FDateTime>("Dt_end", null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }
        public DateTime? Dt_complete
        {
            get { return getAttrVal<FDateTime>("Dt_complete", null); }
            set { setAttrVal<FDateTime>("Dt_complete", value); }
        }
        public string Time_has
        {
            get
            {
                if (Dt_end != null || Dt_begin != null)
                {
                    TimeSpan timepan = Dt_end.Value - DateTime.Now;

                    if (timepan.TotalDays > 0)
                    {
                        String s = timepan.Hours == 0
                            ? string.Format("{0}分钟", timepan.Minutes)
                            : string.Format("{0}小时{1}分钟", timepan.Hours, timepan.Minutes);
                        StringBuilder sb = new StringBuilder(s);
                        if (timepan.Days > 0)
                        {
                            sb.Insert(0, string.Format("{0}天", timepan.Days));
                        }
                        return getAttrVal<string>("Time_has", sb.ToString());

                    }
                    if (timepan.TotalDays < 0)
                        return getAttrVal<string>("Time_has", "已超时！");
                }

                return getAttrVal<string>("Time_has", null);
            }
            set { setAttrVal<string>("Time_has", value); }
        }
        public string Reason_cancel
        {
            get { return getAttrVal<string>("Reason_cancel", null); }
            set { setAttrVal<string>("Reason_cancel", value); }
        }
        public string Createdby
        {
            get { return getAttrVal<string>("Createdby", null); }
            set { setAttrVal<string>("Createdby", value); }
        }
        public DateTime? Createdtime
        {
            get { return getAttrVal<FDateTime>("Createdtime", null); }
            set { setAttrVal<FDateTime>("Createdtime", value); }
        }
        public string Modifiedby
        {
            get { return getAttrVal<string>("Modifiedby", null); }
            set { setAttrVal<string>("Modifiedby", value); }
        }
        public DateTime? Modifiedtime
        {
            get { return getAttrVal<FDateTime>("Modifiedtime", null); }
            set { setAttrVal<FDateTime>("Modifiedtime", value); }
        }
        public bool? Israte
        {
            get { return getAttrVal<FBoolean>("Israte", null); }
            set { setAttrVal<FBoolean>("Israte", value); }
        }
        public string Rate
        {
            get { return getAttrVal<string>("Rate", null); }
            set { setAttrVal<string>("Rate", value); }
        }
        public string Id_or
        {
            get { return getAttrVal<string>("Id_or", null); }
            set { setAttrVal<string>("Id_or", value); }
        }
        public string Mrtasksta_name
        {
            get { return getAttrVal<string>("Mrtasksta_name", null); }
            set { setAttrVal<string>("Mrtasksta_name", value); }
        }
        public string Mrtasksta_code
        {
            get { return getAttrVal<string>("Mrtasksta_code", null); }
            set { setAttrVal<string>("Mrtasksta_code", value); }
        }
        public string Pat_name
        {
            get { return getAttrVal<string>("Pat_name", null); }
            set { setAttrVal<string>("Pat_name", value); }
        }
        public string Mrcactm_name
        {
            get { return getAttrVal<string>("Mrcactm_name", null); }
            set { setAttrVal<string>("Mrcactm_name", value); }
        }
        public string Mrcactm_code
        {
            get { return getAttrVal<string>("Mrcactm_code", null); }
            set { setAttrVal<string>("Mrcactm_code", value); }
        }
        public string Mrtp_code
        {
            get { return getAttrVal<string>("Mrtp_code", null); }
            set { setAttrVal<string>("Mrtp_code", value); }
        }
        public string Mrtp_name
        {
            get { return getAttrVal<string>("Mrtp_name", null); }
            set { setAttrVal<string>("Mrtp_name", value); }
        }
        public int Ds
        {
            get { return getAttrVal<int>("Ds", 0); }
            set { setAttrVal<int>("Ds", value); }
        }

        public DateTime? Sv
        {
            get { return getAttrVal<FDateTime>("Sv", null); }
            set { setAttrVal<FDateTime>("Sv", value); }
        }

        /// <summary>
        /// 返回表名
        /// </summary>
        /// <returns></returns>
        public override string getTableName()
        {
            return "ci_qa_mrtask";
        }

        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_mrtask";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.mrtask.d.MrTaskDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Ds", "Sv", "Id_mrtask", "Id_grp", "Id_org", "Mrtask_name", "Id_qa_itm_config", "Id_mrtask_sta", "Sd_mrtask_sta", "Id_pat", "Id_ent", "Id_exec_dept", "Id_exec_doctor", "Id_mrcactm", "Id_mrtp", "Id_source", "Source_type", "Source_name", "Dt_begin", "Dt_end", "Dt_complete", "Time_has", "Reason_cancel", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Israte", "Rate", "Id_or", "Mrtasksta_name", "Mrtasksta_code", "Pat_name", "Mrcactm_name", "Mrcactm_code", "Mrtp_code", "Mrtp_name" };
        }

    }
}


using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.qcreport.d
{
    /// <summary>
    /// QcReportGrpDO 的摘要说明。
    /// </summary>
    public class QcReportGrpDO : BaseDO {

        public QcReportGrpDO() {
        }
		public string Id_qcreportgrp {
            get { return getAttrVal<string>("Id_qcreportgrp",null); }
            set { setAttrVal<string>("Id_qcreportgrp", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
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
            return "ci_qc_report_grp";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_qcreportgrp";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.qcreport.d.QcReportGrpDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_qcreportgrp", "Id_grp", "Id_org", "Name"};
        }
        
    }
}

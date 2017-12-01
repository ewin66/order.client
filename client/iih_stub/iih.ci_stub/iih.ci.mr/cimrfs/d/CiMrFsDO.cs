
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.cimrfs.d
{
    /// <summary>
    /// CiMrFsDO 的摘要说明。
    /// </summary>
    public class CiMrFsDO : BaseDO {

        public CiMrFsDO() {
        }
		public string Id_mrfs {
            get { return getAttrVal<string>("Id_mrfs",null); }
            set { setAttrVal<string>("Id_mrfs", value); }
        }
		public string Id_mr {
            get { return getAttrVal<string>("Id_mr",null); }
            set { setAttrVal<string>("Id_mr", value); }
        }
		public byte[] Emrfs {
            get { return getAttrVal<byte[]>("Emrfs",null); }
            set { setAttrVal<byte[]>("Emrfs", value); }
        }
		public byte[] Emrxml {
            get { return getAttrVal<byte[]>("Emrxml",null); }
            set { setAttrVal<byte[]>("Emrxml", value); }
        }
		public byte[] Emrfs_prn {
            get { return getAttrVal<byte[]>("Emrfs_prn",null); }
            set { setAttrVal<byte[]>("Emrfs_prn", value); }
        }
		public bool? Fg_compress {
            get { return getAttrVal<FBoolean>("Fg_compress",null); }
            set { setAttrVal<FBoolean>("Fg_compress", value); }
        }
		public string Createdby {
            get { return getAttrVal<string>("Createdby",null); }
            set { setAttrVal<string>("Createdby", value); }
        }
		public DateTime? Createdtime {
            get { return getAttrVal<FDateTime>("Createdtime",null); }
            set { setAttrVal<FDateTime>("Createdtime", value); }
        }
		public string Modifiedby {
            get { return getAttrVal<string>("Modifiedby",null); }
            set { setAttrVal<string>("Modifiedby", value); }
        }
		public DateTime? Modifiedtime {
            get { return getAttrVal<FDateTime>("Modifiedtime",null); }
            set { setAttrVal<FDateTime>("Modifiedtime", value); }
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
            return "ci_mr_fs";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_mrfs";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.cimrfs.d.CiMrFsDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_mrfs", "Id_mr", "Emrfs", "Emrxml", "Emrfs_prn", "Fg_compress", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime"};
        }
        
    }
}

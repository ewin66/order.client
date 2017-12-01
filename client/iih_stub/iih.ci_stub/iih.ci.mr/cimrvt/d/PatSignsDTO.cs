using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.cimrpatsigns.d
{
    /// <summary>
    /// PatSignsDTO 的摘要说明。
    /// </summary>
    public class PatSignsDTO : BaseDTO {

        public PatSignsDTO() {
 
        }

        /// <summary>
        /// 查询条件
        /// </summary>
		public int? Searchitem {
            get { return getAttrVal<int?>("Searchitem",null); }
            set { setAttrVal<int?>("Searchitem", value); }
        }

        /// <summary>
        /// 关键字
        /// </summary>
		public string Keys {
            get { return getAttrVal<string>("Keys",null); }
            set { setAttrVal<string>("Keys", value); }
        }

        /// <summary>
        /// 测量日期
        /// </summary>
		public DateTime? Measuredate {
            get { return getAttrVal<FDate>("Measuredate",null); }
            set { setAttrVal<FDate>("Measuredate", value); }
        }

        /// <summary>
        /// 日期分组
        /// </summary>
		public string Id_dayslot {
            get { return getAttrVal<string>("Id_dayslot",null); }
            set { setAttrVal<string>("Id_dayslot", value); }
        }

        /// <summary>
        /// 测量时间名称
        /// </summary>
		public DateTime? Measuretime {
            get { return getAttrVal<FTime>("Measuretime",null); }
            set { setAttrVal<FTime>("Measuretime", value); }
        }

        /// <summary>
        /// 测量ID
        /// </summary>
		public string Id_mrtplvt {
            get { return getAttrVal<string>("Id_mrtplvt",null); }
            set { setAttrVal<string>("Id_mrtplvt", value); }
        }

        /// <summary>
        /// 测量名称
        /// </summary>
		public string Name_mrtplvt {
            get { return getAttrVal<string>("Name_mrtplvt",null); }
            set { setAttrVal<string>("Name_mrtplvt", value); }
        }

        /// <summary>
        /// 患者列表
        /// </summary>
		public string Id_ents {
            get { return getAttrVal<string>("Id_ents",null); }
            set { setAttrVal<string>("Id_ents", value); }
        }

        /// <summary>
        /// 分组开始时间
        /// </summary>
		public string Time_begin {
            get { return getAttrVal<string>("Time_begin",null); }
            set { setAttrVal<string>("Time_begin", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Searchitem", "Keys", "Measuredate", "Id_dayslot", "Measuretime", "Id_mrtplvt", "Name_mrtplvt", "Id_ents", "Time_begin"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.cimrpatsigns.d.PatSignsDTO";
        }
    }
}

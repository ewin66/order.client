using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.opdrugrtncond.d
{
    /// <summary>
    /// ${EntityMeta.fullClassName} 的摘要说明。
    /// </summary>
    public class OpDrugRtnCondDTO : BaseDTO {

        public OpDrugRtnCondDTO() {
 
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Pat_name {
            get { return getAttrVal<string>("Pat_name",null); }
            set { setAttrVal<string>("Pat_name", value); }
        }
		public string Or_code {
            get { return getAttrVal<string>("Or_code",null); }
            set { setAttrVal<string>("Or_code", value); }
        }
		public string Receipt_no {
            get { return getAttrVal<string>("Receipt_no",null); }
            set { setAttrVal<string>("Receipt_no", value); }
        }
		public DateTime? Dt_entry_begin {
            get { return getAttrVal<FDateTime>("Dt_entry_begin",null); }
            set { setAttrVal<FDateTime>("Dt_entry_begin", value); }
        }
		public DateTime? Dt_entry_end {
            get { return getAttrVal<FDateTime>("Dt_entry_end",null); }
            set { setAttrVal<FDateTime>("Dt_entry_end", value); }
        }
		public DateTime? Disp_time_begin {
            get { return getAttrVal<FDateTime>("Disp_time_begin",null); }
            set { setAttrVal<FDateTime>("Disp_time_begin", value); }
        }
		public DateTime? Disp_time_end {
            get { return getAttrVal<FDateTime>("Disp_time_end",null); }
            set { setAttrVal<FDateTime>("Disp_time_end", value); }
        }
    }
}

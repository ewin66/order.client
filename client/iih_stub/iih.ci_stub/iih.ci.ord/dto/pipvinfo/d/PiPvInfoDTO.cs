using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.pipvinfo.d
{
    /// <summary>
    /// ${EntityMeta.fullClassName} 的摘要说明。
    /// </summary>
    public class PiPvInfoDTO : BaseDTO {

        public PiPvInfoDTO() {
 
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Code_pat {
            get { return getAttrVal<string>("Code_pat",null); }
            set { setAttrVal<string>("Code_pat", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Name_sex {
            get { return getAttrVal<string>("Name_sex",null); }
            set { setAttrVal<string>("Name_sex", value); }
        }
		public DateTime? Dt_birth {
            get { return getAttrVal<FDate>("Dt_birth",null); }
            set { setAttrVal<FDate>("Dt_birth", value); }
        }
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }
		public string Code_en {
            get { return getAttrVal<string>("Code_en",null); }
            set { setAttrVal<string>("Code_en", value); }
        }
		public string Desc_en {
            get { return getAttrVal<string>("Desc_en",null); }
            set { setAttrVal<string>("Desc_en", value); }
        }
		public DateTime? Dt_en {
            get { return getAttrVal<FDateTime>("Dt_en",null); }
            set { setAttrVal<FDateTime>("Dt_en", value); }
        }
		public string Name_emp {
            get { return getAttrVal<string>("Name_emp",null); }
            set { setAttrVal<string>("Name_emp", value); }
        }
		public string Name_dep {
            get { return getAttrVal<string>("Name_dep",null); }
            set { setAttrVal<string>("Name_dep", value); }
        }
    }
}

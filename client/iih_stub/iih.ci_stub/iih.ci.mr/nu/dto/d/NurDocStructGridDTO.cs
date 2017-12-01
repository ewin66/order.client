using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.nu.dto.d
{
    /// <summary>
    /// NurDocStructGridDTO 的摘要说明。
    /// </summary>
    public class NurDocStructGridDTO : BaseDTO {

        public NurDocStructGridDTO() {
 
        }

        /// <summary>
        /// 医疗记录ID
        /// </summary>
		public string Id_mr {
            get { return getAttrVal<string>("Id_mr",null); }
            set { setAttrVal<string>("Id_mr", value); }
        }

        /// <summary>
        /// 就诊ID
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }

        /// <summary>
        /// 病区id
        /// </summary>
		public string Id_dep_nur {
            get { return getAttrVal<string>("Id_dep_nur",null); }
            set { setAttrVal<string>("Id_dep_nur", value); }
        }

        /// <summary>
        /// 病区
        /// </summary>
		public string Name_dep_nur {
            get { return getAttrVal<string>("Name_dep_nur",null); }
            set { setAttrVal<string>("Name_dep_nur", value); }
        }

        /// <summary>
        /// 床号id
        /// </summary>
		public string Id_bed {
            get { return getAttrVal<string>("Id_bed",null); }
            set { setAttrVal<string>("Id_bed", value); }
        }

        /// <summary>
        /// 床号
        /// </summary>
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }

        /// <summary>
        /// 医疗记录类型ID
        /// </summary>
		public string Id_mrtp {
            get { return getAttrVal<string>("Id_mrtp",null); }
            set { setAttrVal<string>("Id_mrtp", value); }
        }

        /// <summary>
        /// 医疗记录类型自定义分类ID
        /// </summary>
		public string Id_mrcactm {
            get { return getAttrVal<string>("Id_mrcactm",null); }
            set { setAttrVal<string>("Id_mrcactm", value); }
        }

        /// <summary>
        /// 医疗记录类型
        /// </summary>
		public string Name_mrtp {
            get { return getAttrVal<string>("Name_mrtp",null); }
            set { setAttrVal<string>("Name_mrtp", value); }
        }

        /// <summary>
        /// 医疗记录类型自定义分类
        /// </summary>
		public string Name_mrcactm {
            get { return getAttrVal<string>("Name_mrcactm",null); }
            set { setAttrVal<string>("Name_mrcactm", value); }
        }

        /// <summary>
        /// 医疗记录
        /// </summary>
		public string Name_mr {
            get { return getAttrVal<string>("Name_mr",null); }
            set { setAttrVal<string>("Name_mr", value); }
        }

        /// <summary>
        /// 最后签署人ID
        /// </summary>
		public string Id_emp_lat {
            get { return getAttrVal<string>("Id_emp_lat",null); }
            set { setAttrVal<string>("Id_emp_lat", value); }
        }

        /// <summary>
        /// 最后签署人
        /// </summary>
		public string Name_emp_lat {
            get { return getAttrVal<string>("Name_emp_lat",null); }
            set { setAttrVal<string>("Name_emp_lat", value); }
        }

        /// <summary>
        /// 最后签署时间
        /// </summary>
		public DateTime? Dt_sign_lat {
            get { return getAttrVal<FDateTime>("Dt_sign_lat",null); }
            set { setAttrVal<FDateTime>("Dt_sign_lat", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_mr", "Id_ent", "Name_pat", "Id_dep_nur", "Name_dep_nur", "Id_bed", "Name_bed", "Id_mrtp", "Id_mrcactm", "Name_mrtp", "Name_mrcactm", "Name_mr", "Id_emp_lat", "Name_emp_lat", "Dt_sign_lat"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.dto.d.NurDocStructGridDTO";
        }
    }
}

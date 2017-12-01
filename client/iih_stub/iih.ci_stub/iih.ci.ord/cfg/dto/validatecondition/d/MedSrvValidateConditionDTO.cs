using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cfg.dto.validatecondition.d
{
    /// <summary>
    /// MedSrvValidateConditionDTO 的摘要说明。
    /// </summary>
    public class MedSrvValidateConditionDTO : BaseDTO {

        public MedSrvValidateConditionDTO() {
 
        }

        /// <summary>
        /// 集团id
        /// </summary>
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }

        /// <summary>
        /// displaynam3
        /// </summary>
		public string Code_grp {
            get { return getAttrVal<string>("Code_grp",null); }
            set { setAttrVal<string>("Code_grp", value); }
        }

        /// <summary>
        /// 集团名称
        /// </summary>
		public string Name_grp {
            get { return getAttrVal<string>("Name_grp",null); }
            set { setAttrVal<string>("Name_grp", value); }
        }

        /// <summary>
        /// 组织id
        /// </summary>
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }

        /// <summary>
        /// 组织编码
        /// </summary>
		public string Code_org {
            get { return getAttrVal<string>("Code_org",null); }
            set { setAttrVal<string>("Code_org", value); }
        }

        /// <summary>
        /// 组织名称
        /// </summary>
		public string Name_org {
            get { return getAttrVal<string>("Name_org",null); }
            set { setAttrVal<string>("Name_org", value); }
        }

        /// <summary>
        /// 服务类型id
        /// </summary>
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }

        /// <summary>
        /// 服务类型编码
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 服务类型名称
        /// </summary>
		public string Name_srvtp {
            get { return getAttrVal<string>("Name_srvtp",null); }
            set { setAttrVal<string>("Name_srvtp", value); }
        }

        /// <summary>
        /// 服务id
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 服务编码
        /// </summary>
		public string Code_srv {
            get { return getAttrVal<string>("Code_srv",null); }
            set { setAttrVal<string>("Code_srv", value); }
        }

        /// <summary>
        /// 服务名称
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 启用标识
        /// </summary>
		public bool? Fg_active {
            get { return getAttrVal<FBoolean>("Fg_active",null); }
            set { setAttrVal<FBoolean>("Fg_active", value); }
        }

        /// <summary>
        /// 更新服务状态
        /// </summary>
		public bool? Fg_update {
            get { return getAttrVal<FBoolean>("Fg_update",null); }
            set { setAttrVal<FBoolean>("Fg_update", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_grp", "Code_grp", "Name_grp", "Id_org", "Code_org", "Name_org", "Id_srvtp", "Sd_srvtp", "Name_srvtp", "Id_srv", "Code_srv", "Name_srv", "Fg_active", "Fg_update"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cfg.dto.validatecondition.d.MedSrvValidateConditionDTO";
        }
    }
}

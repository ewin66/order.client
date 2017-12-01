using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ordinput.d
{
    /// <summary>
    /// OrdInputDto 的摘要说明。
    /// </summary>
    public class OrdInputDto : BaseDTO {

        public OrdInputDto() {
 
        }

        /// <summary>
        /// 模板名称
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 模板id
        /// </summary>
		public string Id_srvortpl {
            get { return getAttrVal<string>("Id_srvortpl",null); }
            set { setAttrVal<string>("Id_srvortpl", value); }
        }

        /// <summary>
        /// 模板类别
        /// </summary>
		public string Sd_tpl {
            get { return getAttrVal<string>("Sd_tpl",null); }
            set { setAttrVal<string>("Sd_tpl", value); }
        }

        /// <summary>
        /// 服务id
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 排序
        /// </summary>
		public string Sortno {
            get { return getAttrVal<string>("Sortno",null); }
            set { setAttrVal<string>("Sortno", value); }
        }

        /// <summary>
        /// 服务名称
        /// </summary>
		public string Srv_name {
            get { return getAttrVal<string>("Srv_name",null); }
            set { setAttrVal<string>("Srv_name", value); }
        }

        /// <summary>
        /// 服务类型
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id {
            get { return getAttrVal<string>("Id",null); }
            set { setAttrVal<string>("Id", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Name", "Id_srvortpl", "Sd_tpl", "Id_srv", "Sortno", "Srv_name", "Sd_srvtp", "Id"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ordinput.d.OrdInputDto";
        }
    }
}

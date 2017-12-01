using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.srvpri.d
{
    /// <summary>
    /// BdSrvPriCalParamDTO 的摘要说明。
    /// </summary>
    public class BdSrvPriCalParamDTO : BaseDTO {

        public BdSrvPriCalParamDTO() {
 
        }

        /// <summary>
        /// 医疗服务
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 价格策略
        /// </summary>
		public string Id_primd {
            get { return getAttrVal<string>("Id_primd",null); }
            set { setAttrVal<string>("Id_primd", value); }
        }

        /// <summary>
        /// 套加收或定价个数
        /// </summary>
		public int? Num {
            get { return getAttrVal<int?>("Num",null); }
            set { setAttrVal<int?>("Num", value); }
        }

        /// <summary>
        /// 合计价套内项目信息
        /// </summary>
		public FArrayList Srvsetitms {
            get { return getAttrVal<FArrayList>("Srvsetitms",null); }
            set { setAttrVal<FArrayList>("Srvsetitms", value); }
        }

        /// <summary>
        /// 医疗服务名称
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_srv", "Id_primd", "Num", "Srvsetitms", "Name_srv"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO";
        }
    }
}

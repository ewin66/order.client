
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.iih.ci.ord.dto.ordsrvchangeddto.d
{
    /// <summary>
    /// 服务是否可开立判断DTO
    /// </summary>
    public class OrdSrvChangedInfoDTO : BaseDTO
    {
        /// <summary>
        /// 服务主键
        /// </summary>
        public string Id_srv
        {
            get { return getAttrVal<string>("Id_srv", null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 物品主键
        /// </summary>
        public string Id_mm
        {
            get { return getAttrVal<string>("Id_mm", null); }
            set { setAttrVal<string>("Id_mm", value); }
        }

        /// <summary>
        /// 不可开立原因提示
        /// </summary>
        public string Info_reason
        {
            get { return getAttrVal<string>("Info_reason", null); }
            set { setAttrVal<string>("Info_reason", value); }
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Id_srv", "Id_mm", "Info_reason" };
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.iih.ci.ord.dto.ordsrvchangeddto.d.OrdSrvChangedInfoDTO";
        }
    }
}

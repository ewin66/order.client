using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ems.uiemsdto.d
{
    /// <summary>
    /// EmsLisViewItemDTO 的摘要说明。
    /// </summary>
    public class EmsLisViewItemDTO : BaseDTO {

        public EmsLisViewItemDTO() {
 
        }

        /// <summary>
        /// 服务ID
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 服务
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 选中标识
        /// </summary>
		public bool? Fg_check {
            get { return getAttrVal<FBoolean>("Fg_check",null); }
            set { setAttrVal<FBoolean>("Fg_check", value); }
        }

        /// <summary>
        /// 编辑标识
        /// </summary>
		public bool? Fg_edit {
            get { return getAttrVal<FBoolean>("Fg_edit",null); }
            set { setAttrVal<FBoolean>("Fg_edit", value); }
        }

        /// <summary>
        /// 医嘱服务ID
        /// </summary>
		public string Id_or_srv {
            get { return getAttrVal<string>("Id_or_srv",null); }
            set { setAttrVal<string>("Id_or_srv", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_srv", "Name_srv", "Fg_check", "Fg_edit", "Id_or_srv"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ems.uiemsdto.d.EmsLisViewItemDTO";
        }
    }
}

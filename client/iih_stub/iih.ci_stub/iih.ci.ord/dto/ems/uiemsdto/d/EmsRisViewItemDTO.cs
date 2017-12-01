using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ems.uiemsdto.d
{
    /// <summary>
    /// EmsRisViewItemDTO 的摘要说明。
    /// </summary>
    public class EmsRisViewItemDTO : BaseDTO {

        public EmsRisViewItemDTO() {
 
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
        /// 部位ID
        /// </summary>
		public string Id_body {
            get { return getAttrVal<string>("Id_body",null); }
            set { setAttrVal<string>("Id_body", value); }
        }

        /// <summary>
        /// 部位SD
        /// </summary>
		public string Sd_body {
            get { return getAttrVal<string>("Sd_body",null); }
            set { setAttrVal<string>("Sd_body", value); }
        }

        /// <summary>
        /// 部位
        /// </summary>
		public string Name_body {
            get { return getAttrVal<string>("Name_body",null); }
            set { setAttrVal<string>("Name_body", value); }
        }

        /// <summary>
        /// 方位ID
        /// </summary>
		public string Id_pos {
            get { return getAttrVal<string>("Id_pos",null); }
            set { setAttrVal<string>("Id_pos", value); }
        }

        /// <summary>
        /// 方位SD
        /// </summary>
		public string Sd_pos {
            get { return getAttrVal<string>("Sd_pos",null); }
            set { setAttrVal<string>("Sd_pos", value); }
        }

        /// <summary>
        /// 方位
        /// </summary>
		public string Name_pos {
            get { return getAttrVal<string>("Name_pos",null); }
            set { setAttrVal<string>("Name_pos", value); }
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
            return new string[]{ "Id_srv", "Name_srv", "Fg_check", "Fg_edit", "Id_body", "Sd_body", "Name_body", "Id_pos", "Sd_pos", "Name_pos", "Id_or_srv"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ems.uiemsdto.d.EmsRisViewItemDTO";
        }
    }
}

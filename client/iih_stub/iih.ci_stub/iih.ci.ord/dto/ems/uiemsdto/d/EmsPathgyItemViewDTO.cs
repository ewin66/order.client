using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ems.uiemsdto.d
{
    /// <summary>
    /// EmsPathgyItemViewDTO 的摘要说明。
    /// </summary>
    public class EmsPathgyItemViewDTO : BaseDTO {

        public EmsPathgyItemViewDTO() {
 
        }

        /// <summary>
        /// 标本id
        /// </summary>
		public string Id_lagsamp {
            get { return getAttrVal<string>("Id_lagsamp",null); }
            set { setAttrVal<string>("Id_lagsamp", value); }
        }

        /// <summary>
        /// 标本名称
        /// </summary>
		public string Name_labsamp {
            get { return getAttrVal<string>("Name_labsamp",null); }
            set { setAttrVal<string>("Name_labsamp", value); }
        }

        /// <summary>
        /// 采集部位ID
        /// </summary>
		public string Id_body_coll {
            get { return getAttrVal<string>("Id_body_coll",null); }
            set { setAttrVal<string>("Id_body_coll", value); }
        }

        /// <summary>
        /// 采集部位SD
        /// </summary>
		public string Sd_body_coll {
            get { return getAttrVal<string>("Sd_body_coll",null); }
            set { setAttrVal<string>("Sd_body_coll", value); }
        }

        /// <summary>
        /// 采集部位
        /// </summary>
		public string Name_body_coll {
            get { return getAttrVal<string>("Name_body_coll",null); }
            set { setAttrVal<string>("Name_body_coll", value); }
        }

        /// <summary>
        /// 标本数量
        /// </summary>
		public string Quan_coll {
            get { return getAttrVal<string>("Quan_coll",null); }
            set { setAttrVal<string>("Quan_coll", value); }
        }

        /// <summary>
        /// 固定液ID
        /// </summary>
		public string Id_fixative {
            get { return getAttrVal<string>("Id_fixative",null); }
            set { setAttrVal<string>("Id_fixative", value); }
        }

        /// <summary>
        /// 固定液SD
        /// </summary>
		public string Sd_fixative {
            get { return getAttrVal<string>("Sd_fixative",null); }
            set { setAttrVal<string>("Sd_fixative", value); }
        }

        /// <summary>
        /// 固定液
        /// </summary>
		public string Name_fixative {
            get { return getAttrVal<string>("Name_fixative",null); }
            set { setAttrVal<string>("Name_fixative", value); }
        }

        /// <summary>
        /// 序号
        /// </summary>
		public string Sortno {
            get { return getAttrVal<string>("Sortno",null); }
            set { setAttrVal<string>("Sortno", value); }
        }

        /// <summary>
        /// 病理标本ID
        /// </summary>
		public string Id_appathgysamp {
            get { return getAttrVal<string>("Id_appathgysamp",null); }
            set { setAttrVal<string>("Id_appathgysamp", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_lagsamp", "Name_labsamp", "Id_body_coll", "Sd_body_coll", "Name_body_coll", "Quan_coll", "Id_fixative", "Sd_fixative", "Name_fixative", "Sortno", "Id_appathgysamp"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ems.uiemsdto.d.EmsPathgyItemViewDTO";
        }
    }
}

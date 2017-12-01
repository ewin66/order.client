
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ordprn.d;

namespace iih.ci.iih.ci.ord.dto.ordprintdto.d
{
    /// <summary>
    /// <para>描    述 : </para>
    /// <para>说    明 : </para>
    /// <para>项目名称 :  iih.ci.iih.ci.ord.dto.ordprintdto.d    </para>    
    /// <para>类 名 称 :  OrdPrintDataDTO					</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/8/22 11:34:10</para>
    /// <para>更新时间 :  2016/8/22 11:34:10</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OrdPrintDataDTO : OrdPrintDO
    {

        /// <summary>
        /// 服务名
        /// </summary>
        public string Name_srv
        {
            get { return getAttrVal<string>("Name_srv", null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 剂量
        /// </summary>
        public string Quan_medu
        {
            get { return getAttrVal<string>("Quan_medu", null); }
            set { setAttrVal<string>("Quan_medu", value); }
        }

        /// <summary>
        /// 剂量单位
        /// </summary>
        public string Medu_name
        {
            get { return getAttrVal<string>("Medu_name", null); }
            set { setAttrVal<string>("Medu_name", value); }
        }

        /// <summary>
        /// 物品名称
        /// </summary>
        public string Name_mm
        {
            get { return getAttrVal<string>("Name_mm", null); }
            set { setAttrVal<string>("Name_mm", value); }
        }

        /// <summary>
        /// 物品规格
        /// </summary>
        public string Spec
        {
            get { return getAttrVal<string>("Spec", null); }
            set { setAttrVal<string>("Spec", value); }
        }

        /// <summary>
        /// 用法名称
        /// </summary>
        public string Route_name
        {
            get { return getAttrVal<string>("Route_name", null); }
            set { setAttrVal<string>("Route_name", value); }
        }

        /// <summary>
        /// 频次名称
        /// </summary>
        public string Freq_name
        {
            get { return getAttrVal<string>("Freq_name", null); }
            set { setAttrVal<string>("Freq_name", value); }
        }
    }
}

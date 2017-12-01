
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using xap.rui.appfw;
using iih.en.pv.dto.d;

namespace iih.ci.ord.ciorder.ordertotalcount
{
    /// <summary>
    /// <para>描    述 : 住院和门诊计算总量类                    			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.ordertotalcount    </para>    
    /// <para>类 名 称 :  IpOpTotalCount					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  zhangwq        				</para> 
    /// <para>修 改 人 :  zhangwq         				</para> 
    /// <para>创建时间 :  2016/7/13 10:53:05             </para>
    /// <para>更新时间 :  2016/7/13 10:53:05             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class IpOpTotalCount:GetTotalCountBase
    {
        /// <summary>
        /// 医疗单DO
        /// </summary>
        private EmsDrugItemDO emsDrugItemDO{ get; set;}
        /// <summary>
        /// 患者信息
        /// </summary>
        private Ent4BannerDTO PatInfo { get; set; }

        public IpOpTotalCount(EmsDrugItemDO emsDrugItemDO, Ent4BannerDTO PatInfo)
        {
            this.emsDrugItemDO = emsDrugItemDO;
            this.PatInfo = PatInfo;
        }
        public override void getTotalCount()
        {
            
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.en.pv.dto.d;
using xap.rui.appfw;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.ciorder.d;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.opemergency.ems.common;
using iih.bd.bc.udi;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.declare;

namespace iih.ci.ord.opemergency.ems.dp
{
    /// <summary>
    /// <para>描    述 : CBCT-NEW【00010734】数据处理模型                </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.ems.dp  </para>    
    /// <para>类 名 称 : ApobsModelDP                    </para> 
    /// <para>版 本 号 : v1.0.0.0                        </para> 
    /// <para>作    者 : qzwang                           </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05              </para>
    /// <para>修 改 人 :                                  </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05             </para> 
    /// <para>说    明 :                     </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    class EmsStomatologyCBCTNEWViewModel : EmsRisViewModel
    {
        #region 构造函数
        public EmsStomatologyCBCTNEWViewModel(Ent4BannerDTO ent)
            : base(ent)
        {

        }
        #endregion
    }
}

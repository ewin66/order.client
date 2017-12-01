
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.appfw;
using iih.ci.ord.ciordems.d;
using xap.mw.serviceframework;
using iih.mm.itf.material.i;
using iih.mm.itf.material.d;
using iih.ci.ord.ciorder.utils;
using iih.en.pv.dto.d;
using iih.ci.ord.cards.thread.dp;
using System.Threading;

namespace iih.ci.ord.ciorder.cards.thread
{
    /// <summary>
    /// <para>描    述 :        皮试逻辑判断             			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.cards.drugext    </para>    
    /// <para>类 名 称 :  ThreadSetMaterialInfoOfDrug					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  张万青         				</para> 
    /// <para>修 改 人 :  张万青         				</para> 
    /// <para>创建时间 :  2016/7/15 17:01:21             </para>
    /// <para>更新时间 :  2016/7/15 17:01:21             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class ThreadSkinTestLogic
    {
        public EmsOrDrug emsordrug;
        public Ent4BannerDTO PatInfo;
        public string id_dep_mp;
        public void run() {
            if (emsordrug.Fg_skintest != null && emsordrug.Fg_skintest == true)
            {
                if (emsordrug.Fg_skintest != null && emsordrug.Fg_skintest == true)
                {
                    SkinTestLogic logic = new SkinTestLogic(PatInfo);
                    if (logic.skinTestLogic(emsordrug).Equals("0"))
                    {
                        return;
                    }

                }
            }
        }
    }
}

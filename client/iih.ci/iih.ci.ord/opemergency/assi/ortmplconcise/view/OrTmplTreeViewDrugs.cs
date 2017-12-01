
using System;
using iih.bd.bc.udi;

namespace iih.ci.ord.opemergency.assi.ortmplconcise.view
{
    /// <summary>
    /// <para>描    述 :  西成药医嘱模板简洁Tree视图	</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.ortmplconcise.view    </para>    
    /// <para>类 名 称 :  OrTmplTreeViewDrugs					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Young         				</para> 
    /// <para>修 改 人 :  Young         				</para> 
    /// <para>创建时间 :  2017/10/23 19:20:13             </para>
    /// <para>更新时间 :  2017/10/23 19:20:13             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class OrTmplTreeViewDrugs : OrTmplTreeView
    {
        public OrTmplTreeViewDrugs()
            : base()
        {
            this.sdortmpltp = BdSrvDictCodeConst.SD_ORTMPLTP_CZXCY;
        }
    }
}

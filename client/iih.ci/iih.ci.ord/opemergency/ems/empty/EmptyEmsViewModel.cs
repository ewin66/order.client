using iih.ci.ord.ciordems.d;
using iih.ci.ord.opemergency.declare;
using iih.en.pv.dto.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.appfw;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.opemergency.ems.dp
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ems.dp    </para>    
    /// <para>类 名 称 :  EmptyEmsViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  9/13/2016 4:39:54 PM             </para>
    /// <para>更新时间 :  9/13/2016 4:39:54 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmptyEmsViewModel : BaseEmsViewModel
    {
       
        public EmptyEmsViewModel(Ent4BannerDTO ent)
            : base(ent)
        {
        }
        public override object GetTableDataSource()
        {
            return new XapDataList<EmsOrDrug> { new EmsOrDrug { Use_days = null} };
        }

        public override object GetFormDataSource()
        {
            return GetTableDataSource();
        }

        public override string OnRefFilterData(string filedName,StringObjectMap sbm)
        {
            var wherePart = base.OnRefFilterData(filedName, sbm);

           
            return wherePart;
        }

        public override string[] GetHiddenFields()
        {
            return new String[] { "Name_boildes", "Fg_skintest", "Spec_mm", "Fg_urgent", "Price", "Totalprice", "Fg_treat", "Use_days", "Name_diag", "Dt_plan" };
        }
    }
}

using System;
using System.Collections.Generic;
using System.ComponentModel;
using iih.ci.diag.dto.judgedideletedto.d;
using xap.rui.uipattern2.basemodel.gridnew;

namespace iih.ci.ord.opemergency.orddi.didepend
{
    public class DiDependModel : NIndexGridModel<Judgedideletedto>
    {
        public DiDependModel(DiDependMgr mgr)
            : base(mgr)
        {
        }

        public override void LoadData(object cond = null)
        {
            var x = RelView.VGetStartParamValue("showinfo");
            if (x is List<Judgedideletedto>)
            {
                this.dataList = new BindingList<Judgedideletedto>((x as List<Judgedideletedto>));
            }
        }
    }
}

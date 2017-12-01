using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using iih.ci.ord.dto.d;
using xap.rui.uipattern2.basemodel.gridnew;

namespace iih.ci.ord.medicaresharing.medicareshar
{
    class MedicaresharModel : NIndexGridModel<MedicalSharingDTO>
    {
        public MedicaresharModel(MedicaresharMgr mgr)
            : base(mgr)
        {
        }

        public override void LoadData(object cond = null)
        {
            var x = RelView.VGetStartParamValue("showinfo");
            if (x is List<MedicalSharingDTO>)
            {
                this.dataList = new BindingList<MedicalSharingDTO>((x as List<MedicalSharingDTO>));
            }
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.bd.srv.medsrv.d;
using xap.mw.coreitf.d;
using iih.ci.ord.i;

namespace iih.ci.ord.ciorder.viewmodel
{
    class OrderDrugHerbViewModel
    {
        public OrderDrugHerbViewModel()
        {
        }

        public void judgeBeginEndTimeHasMpTimes(FDateTime begin,FDateTime end,string id_freq)
        {
            if (end == null || begin == null) return;
            XapServiceMgr.find<ICiOrdQryService>().judgeBeginEndTimeHasMpTimes(begin,end,id_freq);
        }
    }


   
}

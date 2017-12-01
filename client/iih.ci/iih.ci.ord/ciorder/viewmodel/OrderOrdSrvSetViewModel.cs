using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ordsrvset.i;
using xap.mw.serviceframework;
using iih.ci.ord.ordsrvset.d;

namespace iih.ci.ord.ciorder.viewmodel
{
    [Obsolete]
    class OrderOrdSrvSetViewModel
    {
        IOrdsrvsetCrudService service;
        public OrderOrdSrvSetViewModel()
        {
            service = XapServiceMgr.find<IOrdsrvsetCrudService>();
        }
        public void GetOrdSrvSetItem()
        {
          OrdSrvSetDO[] setItems= service.find("","",false);
        }

        public void Save(OrdSrvSetDO[] orSrvItems)
        {
            service.save(orSrvItems);
        }
    }
}

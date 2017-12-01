using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;
using xap.rui.appfw.collections;
using iih.ci.ord.ordsrvmm.i;
using iih.ci.ord.ordsrvmm.d;
using xap.rui.appfw;
using iih.ci.ord.ciordems.d;

namespace iih.ci.ord.ciorder.viewmodel
{
   
    class OrdermmViewModel
    {
        IOrdsrvmmCrudService service;
        XapDataList<OrdSrvMmDO> mmDoList;
        OrdSrvMmDO[] srvMms;
        public OrdermmViewModel()
        {
            service = XapServiceMgr.find<IOrdsrvmmCrudService>();
        }

        public OrdSrvMmDO[] GetMm(string id_orsrv)
        {
            srvMms = service.find(string.Format("id_orsrv in ('{0}')", id_orsrv), "", false);
            mmDoList = new XapDataList<OrdSrvMmDO>(service, srvMms);
            return srvMms;
        }


        public OrdSrvMmDO[] Save(OrdSrvMmDO[] mms)
        {
           return  service.save(mms);
        }

    }
}

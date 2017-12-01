using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.medsrv.i;
using xap.mw.serviceframework;

namespace iih.ci.ord.ciorder.viewmodel.impext
{
    class GetSrvLabItemImp
    {
        IMedSrvLisDOCrudService service;
        IMedSrvRisDOCrudService risservice;
        
        public GetSrvLabItemImp()
        { 
             this.service = XapServiceMgr.find<IMedSrvLisDOCrudService>();
             this.risservice = XapServiceMgr.find<IMedSrvRisDOCrudService>();
        }

        public MedSrvRisDO[] getMedSrvRisDO(string id_srvs)
        {
            return risservice.find(string.Format("a1.id_srv in '{0}'", id_srvs), "", false);
        }

        public MedSrvLisDO[] GetSrvLabItem(string id_srvs)
        {
            return service.find(string.Format("a1.id_srv in '{0}'", id_srvs), "", false);
       
        }
       
    }
}

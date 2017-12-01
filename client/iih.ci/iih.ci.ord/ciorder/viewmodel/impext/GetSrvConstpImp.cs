using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.medsrv.i;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;

namespace iih.ci.ord.ciorder.viewmodel.impext
{
    class GetSrvConstpImp
    {
        private IMedSrvConsDOCrudService srvConsDoCrudService;
        public GetSrvConstpImp()
        {
            this.srvConsDoCrudService = XapServiceMgr.find<IMedSrvConsDOCrudService>();
        }

        public MedSrvConsDO findByIdsrv(String id_srv)
        {
            MedSrvConsDO[] conslist = this.srvConsDoCrudService.find(" id_srv='"+id_srv+"'", null, FBoolean.False);
            if (conslist.Count() == 0)
                return null;
            return conslist[0];
        }
    }
}

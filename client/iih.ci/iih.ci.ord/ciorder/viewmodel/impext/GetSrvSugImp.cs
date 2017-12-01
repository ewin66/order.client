using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.medsrv.i;
using xap.mw.serviceframework;
using iih.bd.srv.medsrv.d;

namespace iih.ci.ord.ciorder.viewmodel.impext
{
    class GetSrvSugImp
    {
        IMedSrvOpDOCrudService service;
        public GetSrvSugImp()
        {
            service = XapServiceMgr.find<IMedSrvOpDOCrudService>();
        }
        public MedSrvOpDO GetSrvSup(string id_srv)
        {
            MedSrvOpDO op = new MedSrvOpDO();
            MedSrvOpDO[] ops = service.find(string.Format("a3.id_srv='{0}'", id_srv), "", false);
            if (ops.Length > 0)
                op = ops[0];
            return op;
        }




    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using iih.bd.pp.hp.d;
using iih.bd.fc.orwf.d;
using iih.bd.pp.hpsrvorca.d;

namespace iih.ci.ord.ciorder.viewmodel
{
    class ExtOrderDrugDialogModel
    {
        private ICiOrdQryService service;
        public ExtOrderDrugDialogModel()
        {
            service = XapServiceMgr.find<ICiOrdQryService>();
        }
        public HPSrvorcaDO getHpSrvOrCaDO(string id_hp,string id_srv)
        {
            return service.GetHpSrvOrCaDo(id_hp,id_srv);
        }
        public OrWfExDeptDTO[] getMpDept(OrWfExDeptParamDTO pam)
        {
            return service.getMpDept(pam);
        } 
    }
}

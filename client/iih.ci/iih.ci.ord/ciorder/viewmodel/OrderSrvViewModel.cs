using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;
using iih.ci.ord.ciorder.i;
using iih.ci.ord.ciorder.d;

namespace iih.ci.ord.ciorder.viewmodel {
    /// <summary>
    /// 医嘱服务
    /// </summary>
    public class OrderSrvViewModel {
        ICiorderSrvDOCrudService service;
        public OrderSrvViewModel() {
            service = XapServiceMgr.find<ICiorderSrvDOCrudService>();
        }

        public OrdSrvDO[] GetSrvs(string id_pat) {
            service = XapServiceMgr.find<ICiorderSrvDOCrudService>();
            return service.find(string.Format("a1.id_pat='{0}' and a1.id_pres='~'", id_pat), "", false);
        }
        public OrdSrvDO[] GetSrvsByIdPres(string id_prs) {
            service = XapServiceMgr.find<ICiorderSrvDOCrudService>();
            return service.find(string.Format(" a1.id_pres='{0}'", id_prs), "", false);
        }

        public OrdSrvDO[] Save(OrdSrvDO[] srvs) {
            return service.save(srvs);
        }
    }
}

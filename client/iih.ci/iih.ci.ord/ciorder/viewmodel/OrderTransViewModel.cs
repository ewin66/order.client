using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;
using iih.ci.ord.ciorder.i;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.i;

namespace iih.ci.ord.ciorder.viewmodel {
    /// <summary>
    /// 医嘱服务
    /// </summary>
    public class OrderTransViewModel {
        ICiOrdQryService service;
        public OrderTransViewModel()
        {
            service = XapServiceMgr.find<ICiOrdQryService>();
        }

        public string getNurAreaOfDep(string id_dep)
        {
            string ids = service.getNurAreaOfDep(id_dep);
            if (ids != null)
            {
                if (ids.IndexOf(",") > 0) {
                    ids = ids.Replace(",", "','");
                }
                return "'" + ids + "'";
            }
            return null;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.i;
using Microsoft.SqlServer.Server;
using xap.mw.serviceframework;
using xap.rui.appfw;

namespace iih.ci.ord.doctorhelper.past.viewmodel
{
   public  class PastOrderListViewModel
    {
       public  XapDataList<CiOrderDO>  listCiOrderDo { get; set; }
       private ICiorderMDOCrudService service;
       public PastOrderListViewModel(String id_pat)
       {
           this.service = XapServiceMgr.find<ICiorderMDOCrudService>();

           this.listCiOrderDo = this.service.find("a0.id_en = '" + id_pat + "'", "id_en", false);
           this.listCiOrderDo.ToList().ForEach(p => { p.Str_long = p.Fg_long.Value == true ? "长期" : "临时"; });
       }
    }
}

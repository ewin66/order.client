using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using iih.ci.ord.i;
using iih.ci.ord_stub.dto.d;
using xap.mw.serviceframework;
using xap.rui.bizcontrol.OverViewCard;

namespace iih.ci.ord.ciorder.overview
{
   public  class CiDiView : OverViewTableCard
    {
       private ICiOrdQryService qryService;
      
       
       public override void OnSetData(Dictionary<string, object> datadict)
       {
       
           if (datadict != null && datadict.Count >0)
           {
               string id_ent = datadict["id_ent"] as string;
               if (id_ent != null)
               {
                   List<string> fieldNameList = new List<string>();
                   BindingList<object> valueList = new BindingList<object>();
                   qryService = XapServiceMgr.find<ICiOrdQryService>();
                   IpViewDiagDTO[] diagItem = qryService.getCiDiagItemDOList(id_ent, "");

                   foreach (IpViewDiagDTO item in diagItem)
                   {
                       valueList.Add(item);
                   }
                   fieldNameList.Add("name");
                   this.SetData(fieldNameList, valueList, null);
               }

           }
       }
    }
}

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.i;
using iih.ci.ord.i;
using iih.ci.ord_stub.dto.d;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.bizcontrol.OverViewCard;

namespace iih.ci.ord.ciorder.overview
{
    public class CiOrderListView : OverViewTableCard
    {
        private ICiorderMDOCrudService ciOrderService;
      
       
       public override void OnSetData(Dictionary<string, object> datadict)
       {
           this.Text = "诊断";
           if (datadict != null && datadict.Count >0)
           {
               string id_ent = datadict["id_ent"] as string;
               if (id_ent != null)
               {
                   List<string> fieldNameList = new List<string>();
                   BindingList<object> valueList = new BindingList<object>();
                   ciOrderService = XapServiceMgr.find<ICiorderMDOCrudService>();
 
                   CiOrderDO[] ciorders = ciOrderService.find("a0.id_en = '" + id_ent + "' and  a0.sd_su_or in ('10','20') ", " a0.dt_effe  ", FBoolean.False);
                   if (ciorders != null && ciorders.Count() > 0)
                   {
                       foreach (CiOrderDO item in ciorders)
                       {
                           valueList.Add(item);
                       }
                   }

                   fieldNameList.Add("Content_or");
                   this.SetData(fieldNameList, valueList, null);
               }

           }
       }
    }
}

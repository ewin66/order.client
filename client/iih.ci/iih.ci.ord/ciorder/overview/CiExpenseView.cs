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
    public class CiExpenseView : ExpenseCard
    {
       private ICiOrdQryService qryService;
      
       
       public override void OnSetData(Dictionary<string, object> datadict)
       {
           if (datadict != null && datadict.Count > 0)
           {
               string id_ent = datadict["id_ent"] as string;
               string id_pat = datadict["id_pat"] as string;
               if (id_ent!=null&&id_pat!=null)
               {
                   qryService = XapServiceMgr.find<ICiOrdQryService>();
                   string[] amt = this.qryService.getBlcgAmtVsDrugRation(id_pat, id_ent, "01");

                   if (amt != null && amt.Length > 0)
                   {
                       this.BalanceValue(amt[0], false);
                       this.ExpendAmountValue(amt[1]);
                       this.DrugProportionValue(amt[2]);
                   }
                   else
                   {
                       this.BalanceValue("1000", false);
                       this.ExpendAmountValue("100");
                       this.DrugProportionValue("10%");
                   }
               }
           }
       }
    }
}

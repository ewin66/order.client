using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using iih.ci.ord.dto.allergy.d;
using iih.ci.ord.i;
using iih.ci.ord_stub.dto.d;
using xap.mw.serviceframework;
using xap.rui.bizcontrol.OverViewCard;

namespace iih.ci.ord.ciorder.overview
{
    public class CiAlHisView : OverViewTableCard
    {
       private ICiOrdQryService qryService;
      
       
       public override void OnSetData(Dictionary<string, object> datadict)
       {
          
           if (datadict != null && datadict.Count >0)
           {
               string id_pat = datadict["id_pat"] as string;
               if (id_pat != null)
               {
                   List<string> fieldNameList = new List<string>();
                   BindingList<object> valueList = new BindingList<object>();
                   qryService = XapServiceMgr.find<ICiOrdQryService>();
                   AllergyDto[] allergy = this.qryService.getAllergyDto(id_pat);

                   foreach (AllergyDto item in allergy)
                   {
                       valueList.Add(item);
                   }
                   fieldNameList.Add("Name_alcla");
                   this.SetData(fieldNameList, valueList, null);
               }

           }
       }
    }
}

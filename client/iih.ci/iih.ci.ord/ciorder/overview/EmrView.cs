using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using iih.ci.ord.dto.orderpandectemrdto.d;
using iih.ci.ord.i;
using iih.ci.ord_stub.dto.d;
using xap.mw.serviceframework;
using xap.rui.bizcontrol.OverViewCard;

namespace iih.ci.ord.ciorder.overview
{
    public class EmrView : MedicalRecordCard
    {
        private ICiOrdQryService qryService;


        public override void OnSetData(Dictionary<string, object> datadict)
        {

            if (datadict != null && datadict.Count > 0)
            {
                string id_ent = datadict["id_ent"] as string;
                if (id_ent != null)
                {
                    qryService = XapServiceMgr.find<ICiOrdQryService>();
                       OrderPandectEmrDTO[] oderPandectEmr =qryService.getOrderPandectEmrDTO("10", id_ent);
                if (oderPandectEmr != null && oderPandectEmr.Count()>0)
                {
                    this.Data = oderPandectEmr[0];
                }
                else
                {
                    this.Data = null;
                }
                    

                }

            }
        }
    }
}

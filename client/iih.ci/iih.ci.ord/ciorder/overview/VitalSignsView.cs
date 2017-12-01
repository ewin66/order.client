using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using iih.ci.ord.dto.vitalsignsdto.d;
using iih.ci.ord.i;
using iih.ci.ord_stub.dto.d;
using xap.mw.core.data;
using xap.mw.serviceframework;
using xap.rui.bizcontrol.OverViewCard;

namespace iih.ci.ord.ciorder.overview
{
    public class VitalSignsView : VitalSignsCard
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
                    VitalSignsDto allergy = this.qryService.getCiorderPreviewDTOS(id_ent,"");
                    if (allergy != null)
                    {
                       
                        this.TemperatureValue(allergy.Temperature, false, false);
                        this.BreathValue(allergy.Breath, false, true);
                        this.PulseValue(allergy.Pulse, true, false);
                        this.BPMinValue(allergy.Bpmin, true, true);
                        this.BPMaxValue(allergy.Bpmax, false, true);
                    }
                }

            }
        }
    }
}

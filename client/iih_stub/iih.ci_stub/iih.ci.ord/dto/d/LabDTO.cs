using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.d
{
   public class LabDTO :BaseDTO
    {
        //private String id_rptlab, id_srv, val_rstrptlab;
        //private FDateTime dt_rptlab;

      
        public string Id_rptlab
        {
            get { return getAttrVal<string>("Id_rptlab", null); }
            set { setAttrVal<string>("Id_rptlab", value); }
        }

      
        public string Id_srv
        {
            get { return getAttrVal<string>("Id_srv", null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

    
        public string Val_rstrptlab
        {
            get { return getAttrVal<string>("Val_rstrptlab", null); }
            set { setAttrVal<string>("Val_rstrptlab", value); }
        }


        public DateTime? Dt_rptlab
        {
            get { return getAttrVal<FDateTime>("Dt_rptlab", null); }
            set { setAttrVal<FDateTime>("Dt_rptlab", value); }
        }
        public string Sd_restrptlabtp
        {
            get { return getAttrVal<string>("Sd_restrptlabtp", null); }
            set { setAttrVal<string>("Sd_restrptlabtp", value); }
        }
      


    }
}

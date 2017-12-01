using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    class OPProofOfDiagnosisAction: XBroadcastAction
    {
        public OPProofOfDiagnosisAction()
            : base("OPProofOfDiagnosis", "OPProofOfDiagnosis", Keys.None, "诊断证明",
                "诊断证明"
                )
        {
            
        }
    }
     
}

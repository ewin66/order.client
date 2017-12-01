using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.cicheck.xactions
{
    class UploadAction : XBroadcastAction
    {
        public UploadAction()
            : base("Upload", "Upload", Keys.None, "上传附件",
                      "上传"
                      )
        {
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.iih.ci.ord.cirptlab.i;
using iih.ci.ord.cirptpathgy.d;
using iih.ci.ord.cirptpathgy.i;
using xap.mw.core.data;
using xap.mw.serviceframework;
using xap.rui.control.extentions;
using xap.rui.engine;

namespace iih.ci.ord.pathgyreportform.viewmodel
{
    public class OpRptpathgyViewModel
    {
        private ICirptpathgyCrudService _Service;
        public CiRptPathgyDO ciDO;
        private string id_or;
        public OpRptpathgyViewModel(string id_or)
        {
            this.id_or = id_or;
            this._Service = XapServiceMgr.find<ICirptpathgyCrudService>();
        }
        public CiRptPathgyDO getCiDO()
        {
            if (string.IsNullOrEmpty(id_or)) return null;
            if (ciDO != null) {
                return ciDO;
            }
            CiRptPathgyDO[] rptPathyDOs = this._Service.find(string.Format("id_or='{0}'", this.id_or), "", false);
            if (rptPathyDOs != null && rptPathyDOs.Length > 0) {
                return rptPathyDOs[0];
            }
            return null;
        }
    }
}

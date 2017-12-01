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

namespace iih.ci.ord.cirptpathgy.viewmodel
{
    public class CiRptpathgyViewModel
    {
        private ICiRptPathgyService ICService;
        private ICirptpathgyCrudService _Service;
        public CiRptPathgyDO ciDO;
        private ICirptExtService extService;
        public CiRptpathgyViewModel(BaseContext baseContext)
        {
            this._Service = XapServiceMgr.find<ICirptpathgyCrudService>();
            this.ICService = XapServiceMgr.find<ICiRptPathgyService>();
            this.extService = XapServiceMgr.find<ICirptExtService>();
            ciDO = new CiRptPathgyDO();
            ciDO.Dt_rptpathgy = this.NowTime();
            ciDO.Id_emp_rpt = baseContext.PsnInfo.Id_psndoc;
            ciDO.Rpt_name = baseContext.PsnInfo.Name;
        }

        public CiRptPathgyDO findByIdAF(CiRptPathgyDO ciRptPathgy)
        {
            CiRptPathgyDO pathgyDO = this.ICService.getRptPathgyByReqNo(ciRptPathgy);
            return pathgyDO;
        }

        public void Save()
        {
            if (this.ciDO.Id_rptpathgy == null)
            {
                this.ciDO.Status = DOStatus.NEW;
            }
            else
            {
                this.ciDO.Status = DOStatus.UPDATED;
            }
            this.ciDO.Replace(this.extService.saveCiRptPathgyDO(new CiRptPathgyDO[]{ciDO})[0]);
        }
    }
}

using System;
using System.Collections.Generic;
using iih.ci.iih.ci.ord.cirptlab.i;
using iih.ci.ord.cirptobs.i;
using xap.mw.serviceframework;
using iih.ci.ord.cirptobs.d;
using xap.rui.appfw;
using xap.mw.core.data;
using xap.rui.control.extentions;
using xap.rui.engine;

namespace iih.ci.ord.cicheck.viewmodel
{
    public class CiCheckCardViewModel
    {
        public CiRptObsDO ciRptObsDO;
        private ICirptobsCrudService _Service;
        private ICirptExtService _extService;
        private ICiRptObsService ICService;

        public CiCheckCardViewModel()
        {
            this._Service = XapServiceMgr.find<ICirptobsCrudService>();
            this.ICService = XapServiceMgr.find<ICiRptObsService>();
            _extService = XapServiceMgr.find<ICirptExtService>();
        }

        public void findByIdAF(CiRptObsDO param,BaseContext context)
        {
            CiRptObsDO ciDO = this.ICService.getRptObsByReqNo(param.Applyformno);
            if (ciDO == null)
            {
                ciDO = new CiRptObsDO();
                ciDO.No_applyform = param.No_applyform;
            }
            ciDO.Applyformno = param.Applyformno;
            ciDO.Dt_rptobs = this.NowTime();
            ciDO.Id_emp = context.PsnInfo.Id_psndoc;
            ciDO.Rpt_name = context.PsnInfo.Name;
            ciRptObsDO.Replace(ciDO);

        }


        public void Save()
        {
            if (ciRptObsDO.Id_rptobs == null)
            {
                ciRptObsDO.Status = DOStatus.NEW;
            }
            else
            {
                ciRptObsDO.Status = DOStatus.UPDATED;
            }

            ciRptObsDO = _extService.saveCiRptObsDO(new CiRptObsDO[] { ciRptObsDO })[0];
            
            //ciRptObsDO.Id_rptobs = this._Service.save(DOList.ToArray())[0].Id_rptobs;
        }
    }
}

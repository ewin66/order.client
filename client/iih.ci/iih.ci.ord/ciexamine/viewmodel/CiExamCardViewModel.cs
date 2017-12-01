using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.iih.ci.ord.cirptlab.i;
using iih.ci.ord.cirptlab.i;
using xap.mw.serviceframework;
using xap.rui.appfw.collections;
using iih.ci.ord.cirptlab.d;
using xap.rui.engine;
using xap.rui.control.extentions;
using xap.mw.core.data;

namespace iih.ci.ord.ciexamine.viewmodel
{
    public class CiExamCardViewModel
    {
        private ICirptlabCrudService service;
        private ICiRptLabService _Service;
        private ICirptExtService _extService;

        private XapAggDO<CirptlabAggDO> AggDo;
        public CiExamCardViewModel(BaseContext baseContext)
        {
            this.service = XapServiceMgr.find<ICirptlabCrudService>();
            this._Service = XapServiceMgr.find<ICiRptLabService>();
            this._extService = XapServiceMgr.find<ICirptExtService>();

            CirptlabAggDO CiAggDO = new CirptlabAggDO();
            CiRptLabDO CiDO = CiAggDO.Parent as CiRptLabDO;
            CiDO.Dt_rptlab = this.NowTime();
            CiDO.Id_emp = baseContext.PsnInfo.Id_psndoc;
            CiDO.Rpt_name = baseContext.PsnInfo.Name;
            this.AggDo = new XapAggDO<CirptlabAggDO>(this.service, CiAggDO); 
        }

        public XapAggDO<CirptlabAggDO> XapAggDO
        {
            get { return this.AggDo; }
        }

        public void Save()
        {
           CirptlabAggDO rtnAggDo= _extService.saveCirptlabAggDO(AggDo);
            AggDo.Replace(rtnAggDo);
        }

        public void DataChanged(CiRptLabDO ciRptLabDO, BaseContext baseContext)
        {
            if (ciRptLabDO.Applyformno == null)
            {
                return;
            }
            CirptlabAggDO cirptlabAggDO = this._Service.getRptLabByReqNo(ciRptLabDO.Applyformno);
            if (cirptlabAggDO == null)
            {
                cirptlabAggDO = new CirptlabAggDO();  
             }
            CiRptLabDO CiDO = cirptlabAggDO.Parent as CiRptLabDO;
            if (CiDO.Id_rptlab == null)
            {
                cirptlabAggDO.Status = DOStatus.NEW;
                CiDO.Status = DOStatus.NEW;
            }
            else
            {
                cirptlabAggDO.Status = DOStatus.UPDATED;
                CiDO.Status = DOStatus.UPDATED;
            }
            CiDO.No_applyform = ciRptLabDO.No_applyform;
            CiDO.Applyformno = ciRptLabDO.Applyformno;
            CiDO.Dt_rptlab = this.NowTime();
            CiDO.Id_emp = baseContext.PsnInfo.Id_psndoc;
            CiDO.Rpt_name = baseContext.PsnInfo.Name;
            CiDO.SetUpdated();
            //this.AggDo = new XapAggDO<CirptlabAggDO>(this.service, cirptlabAggDO); 
            this.AggDo.Replace(cirptlabAggDO);
        }
    }
}

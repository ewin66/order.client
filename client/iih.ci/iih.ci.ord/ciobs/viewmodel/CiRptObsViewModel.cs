using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.cirptobs.d;
using iih.ci.ord.cirptobs.i;
using iih.ci.ord.dto.orobsandlab.d;
using iih.ci.ord.i;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;

namespace iih.ci.ord.ciobs.viewmodel
{
    public class CiRptObsViewModel
    {
        private ICirptobsCrudService service;
        private readonly ICiOrdQryService qryservice;
        public CiRptObsDO CiRptObsDo { get; set; }

        public CiRptObsViewModel()
        {
            service = XapServiceMgr.find<ICirptobsCrudService>();
            qryservice = XapServiceMgr.find<ICiOrdQryService>();
        }

       

        public void getCiRptObsDO(string id_or)
        {    // todo 修改成 检查的 id 
            //return service.findById(id_or);
            if (id_or != null && id_or != "")
            {
                CiRptObsDO[] cirptObs = service.find("a0.id_rptobs ='" + id_or + "'", "", FBoolean.False);
                if (cirptObs != null && cirptObs.Count()>0)
                {
                    CiRptObsDo= cirptObs[0];
                }
            }
          //  return null;
        }

        /// <summary>
        ///     通过医嘱获取检查检验明细
        /// </summary>
        public OrObsAandLabDTO GetObsAandLabDto(string id_or, string type)
        {
            OrObsAandLabDTO obsAandLabDto = qryservice.getObsAndLabDto(id_or, type);
            return obsAandLabDto;
        }

    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using iih.ci.ord.cirptlab.d;
using iih.ci.ord.cirptlab.i;
using iih.ci.ord.cirptpathgy.d;
using iih.ci.ord.cirptpathgy.i;
using iih.ci.ord.dto.orobsandlab.d;
using iih.ci.ord.i;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;


namespace iih.ci.ord.opippathgy.viewmodel
{
    public class OpippathgyCardModel
    {
        private ICirptpathgyCrudService service;
        private readonly ICiOrdQryService qryservice;
        public CiRptPathgyDO CiRptPathgyDo { get; set; }

        public OpippathgyCardModel()
        {
            this.service = XapServiceMgr.find<ICirptpathgyCrudService>();
            qryservice = XapServiceMgr.find<ICiOrdQryService>();
        }


        public void getCiRptlabDO(string Id_appathgy)
        {

            CiRptPathgyDO[] cipat = this.service.find("a0.id_appathgy='" + Id_appathgy + "'", null, FBoolean.False);
            if (cipat != null && cipat.Count() > 0)
                this.CiRptPathgyDo = cipat[0];
            
        }

        public OrObsAandLabDTO GetObsAandLabDto(string id_or, string type)
        {
            OrObsAandLabDTO obsAandLabDto = qryservice.getObsAndLabDto(id_or, type);
            return obsAandLabDto;
        }

   
    }
}
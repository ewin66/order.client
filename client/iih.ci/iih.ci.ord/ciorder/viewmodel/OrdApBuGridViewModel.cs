using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.dto.d;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.rui.engine.xactions.standard;

namespace iih.ci.ord.ciorder.viewmodel
{
    public class OrdApBuGridViewModel
    {
        private ICiOrdQryService qryservice;
        public XapDataList<CiordubDTO> Ciordublist { get; set; }

        public OrdApBuGridViewModel()
        {
            this.qryservice = XapServiceMgr.find<ICiOrdQryService>();
        }

        public void getOrderUBDto(string ident)
        {
            this.Ciordublist = this.qryservice.getOrderUBDtoList(ident);
        }

        public void Copy(CiordubDTO ciubdto, CiordubDTO ciub)
        {
            if (ciub == null)
                return;
  //          ciub.No_applyform_ub = ciubdto.No_applyform;
      //      ciub.Dt_bu_pl_ub = ciubdto.Dt_bu_pl_ub;

                                    //ciub.Applyform=odp.
            ciub.Orsrvname = ciubdto.Orsrvname;
            ciub.Id_srv = ciubdto.Id_srv;
            ciub.Name_unit = ciubdto.Name_unit;
            ciub.Id_unit = ciubdto.Id_unit;
            ciub.Quan_medu_ub = ciubdto.Quan_medu_ub;
            ciub.Num_margin_bu = ciubdto.Num_margin_bu;
            if(ciub.Id_apbu==null)
            ciub.Id_route = ciubdto.Id_route;
            //ciub.Id_route = ciubdto.Id_route;
            //ciub.Name_route = ciubdto.Name_route;
                        //            ciub.Status = DOStatus.UPDATED;
            //ciub.Id_apbu = ciubdto.Id_apbu;
            //ciub.Name_emp_create = ciubdto.Name_emp_phy;
            //ciub.Id_emp_create = ciubdto.Id_emp_phy;
            ciub.Id_or_rel = ciubdto.Id_or;
            ciub.Applyform = ciubdto.Applyform;
            ciub.Quan_medu = ciubdto.Quan_medu;
           
        }
    }
}

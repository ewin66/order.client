using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorcof.i;
using xap.mw.serviceframework;
using iih.ci.ord.ciorcof.d;

namespace iih.ci.ord.ciorcof.viewmodel
{
    class CiOrdSrvVsSheetViewModel
    {

        ISrvvssheetCrudService service;
        public CiOrdSrvVsSheetViewModel()
        {
            service = XapServiceMgr.find<ISrvvssheetCrudService>();
        }


        public string GetSeetIdBySdsrvtp(string  sdsrvtp)
        {
             CiOrSrvVsSheet[] sheets= service.find(string.Format("sd_srvtp='{0}'",sdsrvtp), "", false);
             if (sheets != null&&sheets.Length>0)
             {
                 return sheets[0].Id_sheet;
            }
             return "";
        }













    }
}

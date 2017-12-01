using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.ems.d;
using iih.bd.srv.service.i;
using iih.ci.ord.ciorcof.i;
using xap.mw.serviceframework;
using xap.rui.appfw;
using iih.ci.ord.ciorcof.d;

namespace iih.ci.ord.ciorcof.viewmodel {
    /// <summary>
    /// zhou_zhijian 7.3做阅读注释
    /// </summary>
    class CiOrdSheetItemViewModel {
        /// <summary>
        /// 
        /// </summary>
        IOrdsheetCrudService services;
        /// <summary>
        /// 
        /// </summary>
        private IBdSrvQryService bdSrvService;
        /// <summary>
        /// 
        /// </summary>
        XapDataList<CiOrdSheet> SheetList { get; set; }

        #region 构造
        public CiOrdSheetItemViewModel() {
            services = XapServiceMgr.find<IOrdsheetCrudService>();
            bdSrvService = XapServiceMgr.find<IBdSrvQryService>();
            //CiOrdSheet[] sheets = services.find("1=1", "", false);
            //SheetList = new XapDataList<CiOrdSheet>(services, sheets);
        } 
        #endregion

        public CiOrdSheet GetSheetById(string sheetId) {
            return services.findById(sheetId);
        }

        public void Save(CiOrdSheet[] sheet) {
            services.save(sheet);
        }
    }
}

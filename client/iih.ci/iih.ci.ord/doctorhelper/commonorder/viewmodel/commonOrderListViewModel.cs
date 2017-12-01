using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.ortpl.d;
using iih.ci.ord.dto.newordertemplatedto.d;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using xap.rui.appfw;
///
/// 常规医嘱项目
/// 
namespace iih.ci.ord.doctorhelper.commonorder.viewmodel
{
    public class commonOrderListViewModel
    {
        private ICiOrdQryService qryService;
        public XapDataList<OrTplNItmDO> regularOrRelSrvDO { get; set; }

        

        public NewOrderTemplateDTO[] newOrderTemplate;
        private ICiOrdQryService ordQryService;
        public commonOrderListViewModel(String id_regularorca)
        {
            this.qryService = XapServiceMgr.find<ICiOrdQryService>();
            this.ordQryService = XapServiceMgr.find<ICiOrdQryService>();
           // this.regularOrRelSrvDO = this.qryService.getOrTplNItmDO(id_regularorca);
            this.newOrderTemplate = this.ordQryService.getNewOrderTemplateDTO(id_regularorca);
        }
    }
}

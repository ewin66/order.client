using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.sys.devcfg.func.d;


namespace iih.ci.ord.doctorhelper
{
    public class HelperViewModel
    {
        private ICiOrdQryService service;
        public XapDataList<PageDO>  pageList { get; set; }
        public HelperViewModel(string doctor_id,string dept_id,string biz_id)
        {
            this.service = XapServiceMgr.find<ICiOrdQryService>();
            this.pageList = this.service.getPageDOList(doctor_id, dept_id, biz_id);
        }
    }
}

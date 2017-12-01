using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.en.pv.inpatient.i;
using xap.mw.serviceframework;
using xap.mw.coreitf.d;
using iih.en.pv.i;
using iih.en.pv.dto.d;


namespace iih.ci.ord.ciorder.viewmodel.impext
{

    
    /// <summary>
    /// 获取入科时间 接口
    /// </summary>
    /// Author:admin
    /// Date:2015-09-23
    class GetInHosTime
    {
        IEnOutQryService service;
        public GetInHosTime()
        {
            this.service = XapServiceMgr.find<IEnOutQryService>();
        }
        public DateTime? GetPatInHosTime(string id_en)
        {
            IpBasicDTO ip =  service.GetIpBasicInfo(id_en);
            if (ip != null)
            {
                return ip.Dt_acpt;
            }
            return null;
        }
    }
}

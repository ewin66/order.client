using xap.mw.serviceframework;
using iih.ci.rcm.coninfodto.d;
using System.Collections.Generic;
using iih.ci.rcm.hospitalinfectiondto.d;
namespace iih.ci.rcm.hospitalinfectiondto.i
{
    public class IHospInfectionServiceImpl : IHospInfectionService
    {
        private readonly string _url = XapSvrConfig.BaseUrl + "iihci.rcm/iih.ci.rcm.hospitalinfectiondto.i.IHospInfectionService";
   
        private readonly ServiceInvocation _si;
        /// <summary>
        /// 构造函数
        /// </summary>
        public IHospInfectionServiceImpl()
        {
            _si = new ServiceInvocationImpl();
            _si.url = _url;
        }

        public HospitalInfectionDTO[] GetHospInfecDto(string id_ent)
        {
            _si.url = _url;
            List<object> param = new List<object>();
            param.Add(id_ent);
            HospitalInfectionDTO[] rtn = _si.invokeList<HospitalInfectionDTO>("getHospInfecDto", param.ToArray());
            return rtn;
        }
       
    }
}
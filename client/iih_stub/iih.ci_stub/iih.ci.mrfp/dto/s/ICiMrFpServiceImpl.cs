

using System.Collections.Generic;
using iih.ci.mrfp.dto.patinfo2mrfpdto.d;
using iih.en.pv.dto.d;
using iih.pi.reg.dto.d;
using xap.mw.serviceframework;
using xap.rui.appfw;

namespace iih.ci.mrfp.dto.i
{
    public class ICiMrFpServiceImpl : ICiMrFpService
    {

        #region 变量定义区域

        private readonly string _url = XapSvrConfig.BaseUrl + "iihci.mrfp/iih.ci.mrfp.dto.i.CiMrFpService";

        private readonly ServiceInvocation _si;

        private CacheHelper<PatInfo2MrfpDTO> _ch;


        #endregion

        #region 构造方法区域

        public ICiMrFpServiceImpl()
        {
            _ch = new CacheHelper<PatInfo2MrfpDTO>();
            _si = new ServiceInvocationImpl();
            _si.url = _url;
        }

        #endregion

        #region 接口实现区域

        public PatiInfoForMrDTO GetPatiInfoForMrDto(string idPat)
        {
            List<object> param = new List<object>();
            param.Add(idPat);
            _si.url = _url;
            PatiInfoForMrDTO rtn = _si.invoke<PatiInfoForMrDTO>("getPatiInfoForMrDTO", param.ToArray());
            return rtn;
        }

        public IpDetailDTO GetIpDetailInfo(string idEnt)
        {
            List<object> param = new List<object>();
            param.Add(idEnt);
            _si.url = _url;
            IpDetailDTO rtn = _si.invoke<IpDetailDTO>("getIpDetailInfo", param.ToArray());
            return rtn;
        }

        #endregion


    }
}

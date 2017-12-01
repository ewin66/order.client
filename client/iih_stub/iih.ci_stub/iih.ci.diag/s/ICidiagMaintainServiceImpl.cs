using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.diag.cidiag.d;
using iih.ci.diag.dto.d;
using iih.ci.ord.ems.d;
using iih.en.pv.entdi.d;
using xap.mw.serviceframework;
using xap.rui.appfw;

namespace iih.ci.diag_stub.i
{
   public  class ICidiagMaintainServiceImpl : ICidiagMaintainService
    {

        private string url = XapSvrConfig.BaseUrl + "iihci.diag/iih.ci.diag.i.ICidiagMaintainService";//ConfigUtil.getServiceUrl();
        private string url_r = XapSvrConfig.BaseUrl + "iihci.diag/iih.ci.diag.i.ICidiagMaintainService";//ConfigUtil.getServiceUrl();

        private ServiceInvocation si;
        private CacheHelper<EntDiDO> ch;

       public ICidiagMaintainServiceImpl()
       {
           ch = new CacheHelper<EntDiDO>();
           si = new ServiceInvocationImpl();
           si.url = url;
       }

       public string saveEntDiag(EntDiDO[] list, CiDiagDO ciDiagDo, string type)
       {
           List<object> param = new List<object>();
           param.Add(list);
           param.Add(ciDiagDo);
           param.Add(type);
           si.url = url;
           EntDiDO[] rtn = si.invokeList<EntDiDO>("SaveEntDiagList", param.ToArray());
           return "";

       }

       /// <summary>
       /// 医嘱诊断保存
       /// </summary>
       /// <param name="diDTO"></param>
       /// <returns></returns>
       public DIDTO[] SaveCiDiDto(DIDTO[] diDTO,string id,string sd,string tp)
       {
           List<object> param = new List<object>();
           param.Add(diDTO);
           param.Add(id);
           param.Add(sd);
           param.Add(tp);
           si.url = url;
           DIDTO[] rtn = si.invokeList<DIDTO>("SaveCiDiDto", param.ToArray());
           return rtn;

       }

       /// <summary>
       /// 医嘱诊断保存
       /// </summary>
       /// <param name="diDTO"></param>
       /// <returns></returns>
       public DIDTO[] SaveCiDiDtos(DIDTO[] diDTO,string des,CiEnContextDTO ciEnContextDto)
       {
           List<object> param = new List<object>();
           param.Add(diDTO);
           param.Add(des);
           param.Add(ciEnContextDto);
           si.url = url;
           DIDTO[] rtn = si.invokeList<DIDTO>("SaveCiDiDto", param.ToArray());
           return rtn;

       }

       public CidiagAggDO DeleteCiDiag(CiDiagDO ciDiagDo)
       {
           List<object> param = new List<object>();
           param.Add(ciDiagDo);
           si.url = url;
           CidiagAggDO rtn = si.invoke<CidiagAggDO>("DeleteCiDiag", param.ToArray());
           return rtn;
       }
    }
}

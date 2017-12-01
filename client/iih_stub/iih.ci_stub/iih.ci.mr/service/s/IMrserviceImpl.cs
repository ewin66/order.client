using System.Collections.Generic;
using iih.ci.mr.d;
using iih.ci.mr.knowledge.d;
using iih.ci.mr.service.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.cirptlab.d;
using iih.ci.ord.cirptobs.d;
using iih.ci.ord.dto.ordermr.d;
using xap.mw.serviceframework;

namespace iih.ci.mr_stub.service.i
{
   public  class IMrserviceImpl :IMrservice
    {


         private readonly string _url = XapSvrConfig.BaseUrl + "iih.ci.mr/iih.ci.mr.i.ICiMrServiceExt";//ConfigUtil.getServiceUrl();
         private readonly string _urlL = XapSvrConfig.BaseUrl + "iih.ci.mr/iih.ci.mr.assist.i.ILabRService";//ConfigUtil.getServiceUrl();
         private readonly string _urlT = XapSvrConfig.BaseUrl + "iih.ci.mr/iih.ci.mr.assist.i.IOrderRService";//ConfigUtil.getServiceUrl();
         private readonly string _urlB = XapSvrConfig.BaseUrl + "iih.ci.mr/iih.ci.mr.assist.i.IObservationRService";//ConfigUtil.getServiceUrl();

       
        private readonly ServiceInvocation _si;
       // private CacheHelper<MrTplTreeDTO> _ch;

        public IMrserviceImpl()
        {

          //  _ch = new CacheHelper<MrTplTreeDTO>();
            _si = new ServiceInvocationImpl();
            _si.url = _url;
            //si.url = url_r;
        }
        //根据自定义分类 查询 属于该分类的id_mrtp
        public string[] GetMrTpList(string strWhat)
        {
            List<object> param = new List<object>();
            param.Add(strWhat);
            _si.url = _url;
            string[] rtn = _si.invokeStringList("GetMrTpList", param.ToArray());
            return rtn;
        }
       public MrTplTreeDTO[] GetMrTreeList()
       {
           List<object> param = new List<object>();
           param.Add("");
           _si.url = _url;
           MrTplTreeDTO[] rtn = _si.invokeList<MrTplTreeDTO>("getMrTreeList", param.ToArray());
           return rtn;
       }
       public string GetCiOrderDoList(string strWhere)
       {
           List<object> param = new List<object>();
           param.Add(strWhere);
           _si.url = _url;
           return _si.invokeString("getCiOrderDOList", param.ToArray());

       }
       //根据登陆者id检索知识库数据
       public Knowledgedto[] GetKnowledges(string idUser, string gr)
       {
           List<object> param = new List<object>();
           param.Add(idUser);
           param.Add(gr);
           _si.url = _url;
           Knowledgedto[] rtn = _si.invokeList<Knowledgedto>("GetKnowledges", param.ToArray());
           return rtn;
       }

       public Knowledgedto[] GetKnowledge(string idUser, string idDept, string grName, string ksName)
       {
           List<object> param = new List<object>();
           _si.url = _url;
           param.Add(idUser);
           param.Add(idDept);
           param.Add(grName);
           param.Add(ksName);
           Knowledgedto[] rtn = _si.invokeList<Knowledgedto>("GetKnowledge", param.ToArray());
           return rtn;
       }

       public Knowledgedto[] GetKnowledgeks(string idDept, string ks)
       {
           List<object> param = new List<object>();
           param.Add(idDept);
           param.Add(ks);
           _si.url = _url;
           Knowledgedto[] rtn = _si.invokeList<Knowledgedto>("GetKnowledgeks", param.ToArray());
           return rtn;
       }


       public Knowledgedto[] GetKnowledgeksName(string idDept,string ksName, string name)
       {
           List<object> param = new List<object>();
           param.Add(idDept);
           param.Add(ksName);
           param.Add(name);
           _si.url = _url;
           Knowledgedto[] rtn = _si.invokeList<Knowledgedto>("GetKnowledgeksName", param.ToArray());
           return rtn;
       }

       public Knowledgedto[] GetKnowledgeName(string idUser, string idDept, string grName, string ksName, string name)
       {
           List<object> param = new List<object>();
           param.Add(idUser);
           param.Add(idDept);
           param.Add(grName);
           param.Add(ksName);
           param.Add(name);
           _si.url = _url;
           Knowledgedto[] rtn = _si.invokeList<Knowledgedto>("GetKnowledgeName", param.ToArray());
           return rtn;
       }

       public Knowledgedto[] GetKnowledgeNamegr(string idUser,string grName, string name)
       {
           List<object> param = new List<object>();
           param.Add(idUser);
           param.Add(grName);
           param.Add(name);
           _si.url = _url;
           Knowledgedto[] rtn = _si.invokeList<Knowledgedto>("GetKnowledgeNamegr", param.ToArray());
           return rtn;
       }
       //检查
       public CiRptObsDO[] GetCiRptObsDo(string idEnt)
       {
           List<object> param = new List<object>();
           param.Add(idEnt);
           _si.url = _urlL;
           CiRptObsDO[] rtn = _si.invokeList<CiRptObsDO>("getCiRptObsDO", param.ToArray());
           return rtn;
       }
       //检验
       public CirptlabAggDO[] GetCirptlabAggDo(string idEnt)
       {
           List<object> param = new List<object>();
           param.Add(idEnt);
           _si.url = _urlB;
           CirptlabAggDO[] rtn = _si.invokeList<CirptlabAggDO>("getCirptlabAggDO", param.ToArray());
           return rtn;
       }

       public OrderMrDto[] GetOrderMrDtoList(string idEnt,string codeEntp)
       {
           List<object> param = new List<object>();
           param.Add(idEnt);
           param.Add(codeEntp);
           _si.url = _urlT;
           OrderMrDto[] rtn = _si.invokeList<OrderMrDto>("getOrderMrDtoList", param.ToArray());
           return rtn;
       }
       public OrderMrDto[] GetOrderMrDtoFlushList(string idEnt, string codeEntp,CiOrderDO[] ciorders)
       {
           List<object> param = new List<object>();
           param.Add(idEnt);
           param.Add(codeEntp);
           param.Add(ciorders);
           _si.url = _urlT;
           OrderMrDto[] rtn = _si.invokeList<OrderMrDto>("getOrderMrDtoFlush2MrList", param.ToArray());
           return rtn;
       }

       public WaitDoctorDto[] GetWaitDoctorDto(string idUser, string idDepPhy, string sdStatus)
       {
           List<object> param = new List<object>();
           param.Add(idUser);
           param.Add(idDepPhy);
           param.Add(sdStatus);
           _si.url = _url;
           WaitDoctorDto[] rtn = _si.invokeList<WaitDoctorDto>("getWaitDoctorDto", param.ToArray());
           return rtn;
       }

       //已诊查询
       public WaitDoctorDto[] QueryWaitDoctorDto(string code, string name, string dtAcpt, string dtEnd, string idUser, string idDepPhy, string sdStatus)
       {
           List<object> param = new List<object>();
           param.Add(code);
           param.Add(name);
           param.Add(dtAcpt);
           param.Add(dtEnd);
           param.Add(idUser);
           param.Add(idDepPhy);
           param.Add(sdStatus);
           _si.url = _url;
           WaitDoctorDto[] rtn = _si.invokeList<WaitDoctorDto>("queryWaitDoctorDto", param.ToArray());
           return rtn;
       }
    }
}

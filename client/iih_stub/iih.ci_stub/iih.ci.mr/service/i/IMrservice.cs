using System;
using iih.ci.mr.service.d;
using iih.ci.mr.knowledge.d;
using iih.ci.ord.cirptobs.d;
using iih.ci.ord.cirptlab.d;
using iih.ci.ord.dto.ordermr.d;
using iih.ci.mr.d;
using iih.ci.ord.ciorder.d;

namespace iih.ci.mr_stub.service.i
{
    public interface IMrservice
    {
        string[] GetMrTpList(string strWhat);//根据自定义分类 查询 属于该分类的id_mrtp
        MrTplTreeDTO[] GetMrTreeList();

        //根据登陆者id检索知识库数据
        Knowledgedto[] GetKnowledges(string idUser,string gr);
        Knowledgedto[] GetKnowledge(string idUser, string idDept,string grName,string ksName);
        Knowledgedto[] GetKnowledgeks(string idDept, string ks);
        Knowledgedto[] GetKnowledgeName(string idUser, string idDept,string grName,string ksName, string name);
        Knowledgedto[] GetKnowledgeksName(string idDept,string ksName ,string name);
        Knowledgedto[] GetKnowledgeNamegr(string idUser,string grName ,string name);
        //检查接口
        CiRptObsDO[] GetCiRptObsDo(string idEnt);
        //检验接口
        CirptlabAggDO[] GetCirptlabAggDo(string idEnt);

        OrderMrDto[] GetOrderMrDtoList(string idEnt,string codeEntp);
        //候诊已诊
        WaitDoctorDto[] GetWaitDoctorDto(string idUser, string idDepPhy, string sdStatus);
        //已诊查询
        WaitDoctorDto[] QueryWaitDoctorDto(string code, string name, string dtAcpt, string dtEnd, string idUser, string idDepPhy, string sdStatus);
        //查询处置
        string GetCiOrderDoList(String strWhere);
        OrderMrDto[] GetOrderMrDtoFlushList(string idEnt, string codeEntp, CiOrderDO[] ciorders);
    }
}

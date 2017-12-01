using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.medsrv.i;
using iih.bd.srv.ortpl.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.i;
using iih.ci.ord.moreemsdto.d;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;

namespace iih.ci.ord.opemergency.viewmodel
{
   public  class AssButtonViewModel
   {
       public ICiOrdQryService OrderQryService;
       public IMedSrvSetItemDOCrudService MedSrvSetItemDoCrudService;
       public MoreEmsParamDTO moreEmsParamDTO { get; set; }
   
       public AssButtonViewModel()
       {
           this.OrderQryService = XapServiceMgr.find<ICiOrdQryService>();
           this.MedSrvSetItemDoCrudService = XapServiceMgr.find<IMedSrvSetItemDOCrudService>();

       }
       /// <summary>
       ///  医嘱模板多医疗单
       /// </summary>
       /// <param name="envinfo"></param>
       /// <param name="ortplItemDO"></param>
       /// <returns></returns>
       public MoreEmsParamDTO getMoreEmsParamDTO(CiEnContextDTO envinfo, OrTplNItmDO[] ortplItemDO)
       {
            if (ortplItemDO == null || ortplItemDO.Length == 0)
            {
                return null;
            }
            return  OrderQryService.getMoreEmsParamDTO(envinfo, ortplItemDO);
           
       }    

       /// <summary>
       /// 
       /// </summary>
       /// <param name="id_srv"></param>
       /// <returns></returns>
       public MedSrvSetItemDO[] getMedSrvSetItemDO(String id_srv)
       {   
           String condition = " id_srv = '" + id_srv + "'";
           return this.MedSrvSetItemDoCrudService.find(condition, "", FBoolean.False);
       }

       /// <summary>
       /// 医嘱助手开立医嘱个数限制
       /// </summary>
       /// <returns></returns>
       public int getOrHelperOpenOrCountLimitSet()
       {
           return OrderQryService.getOrHelperOpenOrCountLimitSet();
       }
   }
}

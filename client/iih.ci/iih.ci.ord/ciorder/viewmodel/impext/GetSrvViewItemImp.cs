using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.medsrv.i;
using iih.ci.ord.ciorder.d;
using xap.rui.appfw;
using iih.bd.srv.emsobsindex.d;
using iih.bd.srv.emsobsindex.i;
using iih.ci.ord.cior.d;

namespace iih.ci.ord.ciorder.viewmodel.impext
{
    class GetSrvViewItemImp
    {
        IEmsobsindexCrudService service;
        IMedSrvRelOfDOCrudService srvrefService;
        public GetSrvViewItemImp()
        {
            this.service = XapServiceMgr.find<IEmsobsindexCrudService>();
            this.srvrefService = XapServiceMgr.find<IMedSrvRelOfDOCrudService>();
        }
   


        /// <summary>
        /// 根据服务id 获取 动态指标的id
        /// </summary>
        /// <param name="id_srv">The id_srv.</param>
        /// <returns></returns>
 
        public string  GetSrvRefIds(string id_srv)
        {
            MedSrvRelOfDO[] srvRef = srvrefService.find(string.Format("a15.id_srv='{0}'", id_srv), "", false);
          return  string.Join("','", srvRef.Select(p => p.Id_srvof));
        }
 
        /// <summary>
        /// 根据指标id获取 检验项目的id_srv
        /// </summary>
        /// <param name="id_srvofs">The id_srvofs.</param>
        /// <returns></returns>
        public string GetIdsrvByIdsrvof(string id_srvofs)
        {
            EmsObsIndexDO[] items = service.find(string.Format("a0.id_srvof in ('{0}')", id_srvofs), "", false);
            return string.Join("','",items.Select(p=>p.Id_srv));
        }
        public XapDataList<OrdApSugViewItemDO> GetSrvLabItemByIdSrv(string id_srv )
        {
           string id_srvofs=  GetSrvRefIds(  id_srv);
           string id_srvs = GetIdsrvByIdsrvof(id_srvofs);

            MedSrvLisDO[] labs = new GetSrvLabItemImp().GetSrvLabItem(id_srvs);
            XapDataList<OrdApSugViewItemDO> btLabitem = new XapDataList<OrdApSugViewItemDO>();
            labs.ToList().ForEach(p =>
            {
                btLabitem.Add(new OrdApSugViewItemDO
                {
                    // Id_ordbtlabitm	//输血检验主键	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
                    // Id_or	        //医嘱服务id	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
                    Id_srv = p.Id_srv,	        //检验项目编码	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
                    Name_srv = p.Srv_name,	    //检验项目名称	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
                     Val_rstrptla = "",//项目结果值	 
                    Val_restrptlab = p.Val_restrptlab,	//值域
 	 	 	 	     Sd_restrptlabtp=p.Sd_restrptlabtp,//值类型			 	 			 	 	 		 	 	 	 	 
                    Id_unit = p.Id_unit_nuit,   	//检验项目单位id	  	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
                    Name_unit ="xxx"// p.Nuit_name	    //检验项目单位
                });
            });
            return btLabitem; 
        }




      



      
    }
}

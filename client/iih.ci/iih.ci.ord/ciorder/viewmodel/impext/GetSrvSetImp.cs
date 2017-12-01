using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.mm.itf_stub.material.i;
using xap.mw.serviceframework;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.i;
using iih.bd.srv.medsrv.i;

namespace iih.ci.ord.ciorder.viewmodel.impext
{
    /// <summary>
    /// 获取服务套
    /// </summary>
    /// Author:admin
    /// Date:2015-09-24
    class GetSrvSetImp
    {
        /// <summary>
        /// The service
        /// </summary>
        /// Author:admin
        /// Date:2015-09-24
        IMaterialService service;
        ICiOrdQryService serviceQry;
        IMedSrvSetItemDOCrudService serviceSet;
         IMedsrvCrudService medsrvService;
        public GetSrvSetImp()
        {
            service = XapServiceMgr.find<IMaterialService>();
            serviceQry = XapServiceMgr.find<ICiOrdQryService>();
            serviceSet = XapServiceMgr.find<IMedSrvSetItemDOCrudService>();
            medsrvService = XapServiceMgr.find<IMedsrvCrudService>();
        }
          //* 获取物品的皮试医疗服务ID 已经服务套
          //* @param materialId 物品ID
          //* @return String 皮试服务ID        
        /// <summary>
        /// 获取物品的皮试医疗服务ID 
        /// </summary>
        /// <param name="id_mm">The id_mm.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-09-25
        public string GetSrvSetId(string id_mm)
        {
           return service.getMaterialSkinTestServerId(id_mm);
        }

        /// <summary>
        ///根据服务套id 获取套内服务
        /// </summary>
        /// <param name="id_srv">The id_srv.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-09-25
        public List<MedSrvDO> GetInSetSrv(string id_srv)
        {

            return serviceQry.GetSrvSetItemList(id_srv).ToList();
        }
        /// <summary>
        ///获取bd 服务套定义表的数据集合
        /// </summary>
        /// <param name="id_srv">The id_srv.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-09-30
        public List<MedSrvSetItemDO> GetItemInSet(string id_srv,bool is_clinical=true)
        {
            string clinical = "Y";
            if (is_clinical == true)
            {
                clinical = "Y";
            }
            else {
                clinical = "N";
            }
            return serviceSet.find(string.Format("a8.fg_clinical='{0}' and a8.id_srv='{1}' and a8.fg_active='Y'",clinical, id_srv), "", false).ToList();
        }

        
    }
}

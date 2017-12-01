using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.medsrv.i;
using xap.mw.serviceframework;

namespace iih.ci.ord.ciorder.viewmodel.impext
{
    class GetMedSrvImpl
    {
          IMedsrvCrudService medSrvservice;
          IMedsrvMDOCrudService service;
        public GetMedSrvImpl()
        {
            medSrvservice = XapServiceMgr.find<IMedsrvCrudService>();
            service = XapServiceMgr.find<IMedsrvMDOCrudService>();
        }


        public MedsrvAggDO[] getMedSrvAggDO(String id_srv)
        {
            return medSrvservice.find(" id_srv = '" + id_srv + "'", "id_srv", false);
        }

        public MedsrvAggDO getMedSrvAggDOfindById(String id_srv)
        {
            return medSrvservice.findById(id_srv);
        }

        public MedsrvAggDO[] getMedSrvDO(List<MedSrvSetItemDO> medSrvSet)
        {
            List<MedSrvDO> MedSrvList = new List<MedSrvDO>();
            MedsrvAggDO[] medsrvAggDO = new MedsrvAggDO[] {};
            if (medSrvSet != null && medSrvSet.Count > 0 )
            {
                string[] id_srv = new string[medSrvSet.Count];
                int i = 0;
                foreach (MedSrvSetItemDO medSrvSetItem in medSrvSet)
                {
                    id_srv[i] = medSrvSetItem.Id_srv_itm;
                    i++;
                }

                    medsrvAggDO = medSrvservice.findByIds(id_srv, false);
                    //if (medsrvAggDO != null && medsrvAggDO.Length >0)
                    //{
                    //    foreach (MedsrvAggDO  medsrvagg in medsrvAggDO)
                    //    {
                    //        //MedSrvDO medsrv = new MedSrvDO();
                    //        MedSrvList.Add(medsrvagg.getParentDO());
                    //    }
                    //}
            }
            return medsrvAggDO;
        }

        /// <summary>
        /// Gets the med SRV by identifier.
        /// </summary>
        /// <param name="id_srv">The id_srv.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-10-29
        public MedSrvDO GetMedSrvById(string id_srv)
        {
            return service.findById(id_srv);
        }

        /// <summary>
        /// Gets the med SRVS.
        /// </summary>
        /// <param name="strWhere">The string where.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-10-29
        public MedSrvDO[] GetMedSrvs(string strWhere)
        {
            return service.find(strWhere, "", false);
        }
    }
}

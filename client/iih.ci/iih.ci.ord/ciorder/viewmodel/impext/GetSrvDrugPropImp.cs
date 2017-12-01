using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.medsrv.i;
using iih.bd.srv.medsrv.d;
using xap.mw.serviceframework;

namespace iih.ci.ord.ciorder.viewmodel.impext
{
    class GetSrvDrugPropImp
    {

        IMedSrvDrugDOCrudService services;

        public GetSrvDrugPropImp()
        {
            services = XapServiceMgr.find<IMedSrvDrugDOCrudService>();
        }


        public MedSrvDrugDO GetMedSrvDrupProp(string id_srv)
        {
            MedSrvDrugDO[] drugs = services.find(string.Format(" a5.id_srv='{0}'", id_srv), "", false);
            if (drugs!=null&&drugs.Length>0)
            {
                return drugs[0];
            }
            return null;
        }
        public MedSrvDrugDO[] GetMedSrvDrupProps(string strWhere)
        {
            MedSrvDrugDO[] drugs = services.find(strWhere, "", false);
            return drugs;
        }

    }
}

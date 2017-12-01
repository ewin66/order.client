using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
 
using iih.ci.ord.ciorder.utils;
using xap.mw.serviceframework;
using iih.ci.ord.ciordems.d;
using xap.rui.appfw;
 
using xap.mw.core.data;
using iih.ci.ord.cior.d;
using iih.ci.ord.cior.i;

namespace iih.ci.ord.ciconsresponse.viewmodel
{
    class InviteConsViewModel
    {

        ICiordInviteConsDOCrudService service;
        OrDataBing orDataBing = new OrDataBing();
        public InviteConsViewModel()
        {
            service = XapServiceMgr.find<ICiordInviteConsDOCrudService>();
        }

        public XapDataList<EmsItemInCons> GetInviteCons(string id_invitecons)
        {
            XapDataList<EmsItemInCons> list = new XapDataList<EmsItemInCons>();
            CiordInviteConsDO[] invitecons = GetConsInvite(string.Format("id_invitecons='{0}'", id_invitecons));
            invitecons.ToList().ForEach(p =>
            {
                EmsItemInCons con = new EmsItemInCons();
                orDataBing.EditIvnteConsDataBing(con, p);
                con.Status = DOStatus.UPDATED;
                list.Add(con);
            });
            return list;
        }

        public XapDataList<EmsItemInCons> GetInviteConsByIdapCons(string id_apcons)
        {
            XapDataList<EmsItemInCons> list = new XapDataList<EmsItemInCons>();
            CiordInviteConsDO[] invitecons = GetConsInvite(string.Format("id_apcons='{0}'", id_apcons));
            invitecons.ToList().ForEach(p =>
            {
                EmsItemInCons con = new EmsItemInCons();
                orDataBing.EditIvnteConsDataBing(con, p);
                con.Status = DOStatus.UPDATED;
                list.Add(con);
            });
            return list;
        }

        public CiordInviteConsDO[] GetConsInvite(string where)
        {
            return service.find(where, "", false);
        }


        public void Save(CiordInviteConsDO[] cons)
        {
           CiordInviteConsDO[] res= service.save(cons);
        }

        public CiordInviteConsDO GetInviteConsById(string id)
        {
          return   service.findById(id);
        }

    }
}

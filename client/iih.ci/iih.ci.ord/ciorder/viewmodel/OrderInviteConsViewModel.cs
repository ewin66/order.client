using System.Linq;
using xap.mw.serviceframework;
 
using iih.ci.ord.ciordems.d;
using xap.rui.appfw;
using iih.ci.ord.ciorder.utils;
using xap.mw.core.data;
using iih.ci.ord.cior.d;
using iih.ci.ord.cior.i;

namespace iih.ci.ord.ciorder.viewmodel
{
    /// <summary>
    /// 受邀科室
    /// </summary>
    /// Author:admin
    /// Date:2015-11-11
    class OrderInviteConsViewModel
    {

        ICiordInviteConsDOCrudService service;
        OrDataBing orDataBing = new OrDataBing();
        public OrderInviteConsViewModel()
        {
            service = XapServiceMgr.find<ICiordInviteConsDOCrudService>();
        }

        public XapDataList<EmsItemInCons> GetInviteCons(string id_Cons)
        {
            XapDataList<EmsItemInCons> list = new XapDataList<EmsItemInCons>();
            CiordInviteConsDO[] invitecons = GetConsInvite(string.Format("id_apcons='{0}'", id_Cons));
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

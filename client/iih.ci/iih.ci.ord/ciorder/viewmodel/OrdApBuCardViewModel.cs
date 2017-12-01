using System;
using iih.bd.srv.medusage.d;
using iih.bd.srv.medusage.i;
using iih.ci.ord.cior.d;
using iih.ci.ord.dto.d;
using iih.ci.ord.i;
using iih.ci.ord_stub.i;
using xap.mw.serviceframework;
using xap.sys.xbd.udi.i;
using iih.ci.ord.cior.i;

namespace iih.ci.ord.ciorder.viewmodel
{
    public class OrdApBuCardViewModel
    {
        private readonly ICiOrdMaintainService ordMaintainService;
        private readonly ICiOrdQryService qryservice;
        private readonly IMedusageCrudService medservice;
        private readonly IUdidocServiceExt usService;
        private ICiorappbtMDOCrudService btservice;
        public OrdApBuCardViewModel()
        {
            qryservice = XapServiceMgr.find<ICiOrdQryService>();
            ordMaintainService = XapServiceMgr.find<ICiOrdMaintainService>();
            medservice = XapServiceMgr.find<IMedusageCrudService>();
            usService = XapServiceMgr.find<IUdidocServiceExt>();
            btservice = XapServiceMgr.find<ICiorappbtMDOCrudService>();
        }

        //public UdidocDO GetUdis(string udicode)
        //{
        //      UdidocDO[] dos= usService.findByUdidoclistCode(udicode);
        //    UdidocDO di = null;
        //      foreach (UdidocDO u in dos)
        //    {
        //        if (u.Code.Equals("2"))
        //        {
        //            di = u;
        //            break;
        //        }
        //    }
        //    return di;
        //}
        public CiordubDTO CiordubDto { get; set; }

        public CiordubDTO getOrderUBDto(string idor)
        {
            return qryservice.getOrderUBDto(idor);
        }

        public OrdApBtDO getOrDerBtDto(string id_or)
        {
            OrdApBtDO[] btdos = btservice.find(string.Format("id_or='{0}'",id_or),"",false);
            if (btdos != null && btdos.Length > 0) {
                return btdos[0];
            }
            return null;
        }

        public string getNoapp()
        {
            return qryservice.getNoapplyform(new OrdAppBtUseDO().getFullClassName());
        }

        public String getRotName(string idrout)
        {
            MedUsageDO med=this.medservice.findById(idrout);
            if (med != null)
                return med.Name;
            else
            {
                return null;
            }
        }


    }
}
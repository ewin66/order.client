using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.bc.udi;
using iih.ci.ord.ciorder.i;
using xap.mw.serviceframework;
using iih.ci.ord.ciorder.d;
using xap.rui.appfw;
using iih.ci.ord.ciorder.viewmodel;
 
using xap.cli.context;
using iih.ci.ord.i;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.cior.d;
using iih.ci.ord.cior.i;
using iih.ci.ord.dto.consdto.d;
using iih.ci.ord.dto.patdetaildto.d;
using xap.rui.appfw.collections;

namespace iih.ci.ord.ciordcons.viewmodel
{
    public class ConsCardViewModel
    {

        ICiOrdQryService service;//从自定义接口取数据
        private ICiorappconsultMDOCrudService consDoService;
        private ICiorappconsultCrudService consAggService;
        public OrdConsDTO ConsDto;
        private CiorappconsultAggDO consAggDo;
        public XapAggDO<CiorappconsultAggDO> xapAggDo;
        public ConsCardViewModel()
        {

            service = XapServiceMgr.find<ICiOrdQryService>();
            consAggService = XapServiceMgr.find<ICiorappconsultCrudService>();
            this.consDoService = XapServiceMgr.find<ICiorappconsultMDOCrudService>();
        }

        
        


        public OrdApConsDO GetApConsById(string id_apcons)
        {
          return   consDoService.findById(id_apcons);
        }

        public void Save(OrdApConsDO[] ap)
        {
            consDoService.save(ap);
        }

        public void GetConsApData(string id_apcons,string type)
        {
            consAggDo = consAggService.findById(id_apcons);
            //if (type == CiDictCodeConst.CONS_RESPONSE)
            //{
            //    List<CiordInviteConsDO> invitelist = new List<CiordInviteConsDO>();
            //    foreach (CiordInviteConsDO obj in consAggDo.getCiordInviteConsDO())
            //    {
            //        if (obj.Id_dep == UserManager.getInstance().CurrentDept.Id_dep)
            //        {
            //            invitelist.Add(obj);
            //        }
            //    }
            //    consAggDo.setCiordInviteConsDO(invitelist.ToArray());
            //}
            if (consAggDo == null)return;
            consAggDo = AuditResult(consAggDo);
            xapAggDo=new XapAggDO<CiorappconsultAggDO>(consAggService, consAggDo);
            //return xapAggDo;
        }

        public PatDetailDTO GetConsPat(string id_en)
        {
            return service.getConsPatDetail(id_en);
        }

        public void GetConsByIdent(String id_dep,string id_ent)
        {
            if (id_dep == null || id_ent == null) return;
            string str = string.Format(" AND t3.id_en='{0}' and t2.sd_su_cons in ('{1}','{2}')", id_ent, CiDictCodeConst.SD_CIDI_DKSYD, CiDictCodeConst.SD_CIDI_KSBFYD);
            OrdConsDTO[] cons = service.GetConsList(id_dep, str);
            if (cons != null && cons.Length > 0)
            {
                this.ConsDto = cons[0];
                consAggDo = consAggService.findById(ConsDto.Id_apcons);
                if (consAggDo == null) return;
                consAggDo = AuditResult(consAggDo);
                xapAggDo = new XapAggDO<CiorappconsultAggDO>(consAggService, consAggDo);
            }
               
        }

        public void SaveEdit()
        {
            consAggService.save(new CiorappconsultAggDO[] {this.xapAggDo.AggDO});
        }


        public CiorappconsultAggDO AuditResult(CiorappconsultAggDO aggDo)
        {
            if (aggDo.getOrConsApAuditDO() != null && aggDo.getOrConsApAuditDO().Count() != 0)
            {
                foreach (OrConsApAuditDO auditDo in aggDo.getOrConsApAuditDO())
                {
                    if (auditDo.Fg_audit == true)
                    {
                        auditDo.Result = "同意会诊";
                    }
                    else
                    {
                        auditDo.Result = "拒绝会诊";
                    }
                }
            }
            return aggDo;
        }
    }
}

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
using iih.ci.ord_stub.i;
using xap.mw.core.data;
using xap.rui.control.extentions;
using xap.sys.bdfw.bbd.d;
using xap.sys.bdfw.bbd.i;

namespace iih.ci.ord.ciordcons.viewmodel
{
    class ConsGridViewModel
    {

        ICiOrdQryService serviceCons;//从自定义接口取数据
        private ICiOrdMaintainService saveService;
        //private ICiorappconsultMDOCrudService consDoService;
        public XapDataList<OrdConsDTO> consList;
        private ICiorappconsultCrudService consAggService;
        private IPsndocCrudService psndocCrudService;
        public ConsGridViewModel(string str)
        {

            serviceCons = XapServiceMgr.find<ICiOrdQryService>();
            psndocCrudService = XapServiceMgr.find<IPsndocCrudService>();
            consAggService = XapServiceMgr.find<ICiorappconsultCrudService>();
            //this.consDoService = XapServiceMgr.find<ICiorappconsultMDOCrudService>();
            saveService = XapServiceMgr.find<ICiOrdMaintainService>();
            OrdConsDTO[] cons = serviceCons.GetConsList(UserManager.getInstance().CurrentDept.Id_dep, str);
            consList = new XapDataList<OrdConsDTO>(serviceCons,setValue(cons) );
        }

        public XapDataList<OrdConsDTO> GetConList(string id_dep, string sd_su)
        {

            OrdConsDTO[] cons = serviceCons.GetConsList(id_dep, sd_su);
            this.consList = new XapDataList<OrdConsDTO>(serviceCons, setValue(cons));
            return this.consList;
        }


        public OrdConsDTO[] setValue(OrdConsDTO[] cons)
        {
            cons.ToList().ForEach(p =>
            {
                p.Urgent = p.Fg_urgent.Value == true ? "急" : "普通";
                p.Name_constp = p.Fg_inorg.Value == true ? "院内会诊" : "院外会诊";
                if (p.Sd_su_cons == CiDictCodeConst.SD_CIDI_DKSSP || p.Sd_su_cons == CiDictCodeConst.SD_CIDI_DYWSP)
                {
                    p.Name_reviewtp = "未审批";
                }
                else if (p.Sd_su_cons == CiDictCodeConst.SD_CIDI_KSBH || p.Sd_su_cons == CiDictCodeConst.SD_CIDI_YWBH)
                {
                    p.Name_reviewtp = "审批驳回";
                }
                else
                {
                    p.Name_reviewtp = "审批通过";
                }

            });
            return cons;
        }

        public OrdConsDTO GetApConsById(OrdConsDTO dto)
        {
            CiorappconsultAggDO aggDo = consAggService.findById(dto.Id_apcons);
            foreach (CiordInviteConsDO inviteConsDo in aggDo.getCiordInviteConsDO())
            {
                if (inviteConsDo.Id_dep == UserManager.getInstance().CurrentDept.Id_dep)
                    if (inviteConsDo.Id_emp != null)
                    {
                        dto.Id_emp = inviteConsDo.Id_emp;
                        
                    }
                    else
                    {
                        dto.Id_emp = UserManager.getInstance().CurrentUser.Id_user;
                    }
            }
            PsndocAggDO psn=psndocCrudService.findById(dto.Id_emp);
            if (psn!=null)
            dto.Emp_name = psn.getParentDO().Name;
            return dto;
        }

        public void Save(OrdConsDTO dto,string type,string idUser,string idDept)
        {
            CiorappconsultAggDO consAggDo = consAggService.findById(dto.Id_apcons);
            if (type == CiDictCodeConst.CONS_RESPONSE)
            {
                if(consAggDo.getCiordInviteConsDO()==null)return;
                bool flag = true;
                foreach (CiordInviteConsDO inviteConsDo in consAggDo.getCiordInviteConsDO())
                {
                    if (inviteConsDo.Id_dep == idDept)
                    {
                        inviteConsDo.Id_emp = dto.Id_emp;
                        inviteConsDo.Fg_response = true;
                        inviteConsDo.Id_emp_response = idUser;
                        inviteConsDo.Dt_response = new DateTime().NowTime();
                        inviteConsDo.Status = DOStatus.UPDATED;
                    }
                    if (inviteConsDo.Fg_response == false) flag = false;
                    
                }
                if (flag)
                {
                    consAggDo.getParentDO().Id_su_cons = CiDictCodeConst.ID_CIDI_KSYYD;
                    consAggDo.getParentDO().Sd_su_cons = CiDictCodeConst.SD_CIDI_KSYYD;
                }
                else
                {
                    consAggDo.getParentDO().Id_su_cons = CiDictCodeConst.ID_CIDI_KSBFYD;
                    consAggDo.getParentDO().Sd_su_cons = CiDictCodeConst.SD_CIDI_KSBFYD;
                }
               
            }
              
            else
            {
                
                OrConsApAuditDO reviewDO=new OrConsApAuditDO();
                reviewDO.Id_apcons = dto.Id_apcons;
                reviewDO.Id_emp = idUser;
                reviewDO.Id_dep = idDept;
                reviewDO.Dt_review = CommonExtentions.NowTime(this);
                reviewDO.Fg_audit = dto.Fg_audit;
                reviewDO.Des_review = dto.Des_review;
                List<OrConsApAuditDO> dolist =new List<OrConsApAuditDO>();
                if(consAggDo.getOrConsApAuditDO()!=null)
                    dolist = consAggDo.getOrConsApAuditDO().ToList();
                dolist.Add(reviewDO);
                consAggDo.setOrConsApAuditDO(dolist.ToArray());
                if (type == CiDictCodeConst.CONS_DEPREVIEW)
                {
                    if (reviewDO.Fg_audit == true)
                    {
                        if (consAggDo.getParentDO().Fg_audit_admdep == true)
                        {
                            consAggDo.getParentDO().Id_su_cons = CiDictCodeConst.ID_CIDI_DYWSP;
                            consAggDo.getParentDO().Sd_su_cons = CiDictCodeConst.SD_CIDI_DYWSP;
                        }
                        else
                        {
                            consAggDo.getParentDO().Id_su_cons = CiDictCodeConst.ID_CIDI_DKSYD;
                            consAggDo.getParentDO().Sd_su_cons = CiDictCodeConst.SD_CIDI_DKSYD;
                        }
                    }
                    else
                    {
                        consAggDo.getParentDO().Id_su_cons = CiDictCodeConst.ID_CIDI_KSBH;
                        consAggDo.getParentDO().Sd_su_cons = CiDictCodeConst.SD_CIDI_KSBH;
                    }
                    
                }
                else
                {
                    if (reviewDO.Fg_audit == true)
                    {
                        consAggDo.getParentDO().Id_su_cons = CiDictCodeConst.ID_CIDI_DKSYD;
                        consAggDo.getParentDO().Sd_su_cons = CiDictCodeConst.SD_CIDI_DKSYD;
                    }
                    else
                    {
                        consAggDo.getParentDO().Id_su_cons = CiDictCodeConst.ID_CIDI_YWBH;
                        consAggDo.getParentDO().Sd_su_cons = CiDictCodeConst.SD_CIDI_YWBH;
                    }
                }

            }
            consAggDo.Status = DOStatus.UPDATED;
            consAggDo.getParentDO().Status = DOStatus.UPDATED;
            saveService.SaveOrAppConsultAggDO(new CiorappconsultAggDO[] { consAggDo }, type);
        }

        public CiordInviteConsDO btnEnable(string id)
        {
            CiorappconsultAggDO consAggDo = consAggService.findById(id);
            CiordInviteConsDO inviteDo=new CiordInviteConsDO();
            //bool fg = false;
            foreach (CiordInviteConsDO inviteConsDo in consAggDo.getCiordInviteConsDO())
            {
                if (inviteConsDo.Id_dep == UserManager.getInstance().CurrentDept.Id_dep )
                {
                    inviteDo = inviteConsDo;
                }

            }
            return inviteDo;
        }
        

    }
}

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

namespace iih.ci.ord.ciconsresponse.viewmodel
{
    class ApConsViewModel
    {
        ICiorappconsultMDOCrudService service;

        ICiOrdQryService serviceCons;//从自定义接口取数据
        private ICiorappconsultMDOCrudService consDoService;
        public ApConsViewModel()
        {

            service = XapServiceMgr.find<ICiorappconsultMDOCrudService>();
            serviceCons = XapServiceMgr.find<ICiOrdQryService>();
            this.consDoService = XapServiceMgr.find<ICiorappconsultMDOCrudService>();
        }

        public XapDataList<EmsConsItemDO> GetConList(string id_dep, string sd_su)
        {
            XapDataList<EmsConsItemDO> list = new XapDataList<EmsConsItemDO>();
            //EmsConsItemDO[] cons = serviceCons.GetConsList(id_dep, sd_su);
            //cons.ToList().ForEach(p =>
            //{
            //    p.Str_urgent = p.Fg_urgent.Value == true ? "急" : "普通";
            //    if (p.Sd_su_cons == CiDictCodeConst.SD_SU_CONS_CONFIRMING)
            //    {
            //        p.Name_su_cons = "待应答";
            //    }
            //    if (p.Sd_su_cons == CiDictCodeConst.SD_SU_CONS_CONFIRMED)
            //    {
            //        p.Name_su_cons = "已应答";
            //    }
            //    list.Add(p);
            //});
            return list;
        }

        /// <summary>
        /// Gets 所有未写会诊记录的会诊单
        /// </summary>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-11-19
        public XapDataList<OrdApConsDO> GetApConsItem()
        {
            XapDataList<OrdApConsDO> list = new XapDataList<OrdApConsDO>();
             //所以未提交会诊记录的 会诊申请
            OrdApConsDO[] cons = consDoService.find(string.Format("a0.sd_su_cons='{0}'", CiDictCodeConst.SD_SU_CONS_CONFIRMING), "", false);
            cons.ToList().ForEach(p => { list.Add(p); });
            return list;
        }


        public OrdApConsDO GetApConsById(string id_apcons)
        {
          return   consDoService.findById(id_apcons);
        }

        public void Save(OrdApConsDO[] ap)
        {
            consDoService.save(ap);
        }

        //public XapDataList<OrdApConsDO> GetConsList(string sd_su_cons)
        //{
        //    //取到本科室所有应邀 未应答 的人员
        //    CiordInviteConsDO[] InviteCons = new OrderInviteConsViewModel().GetConsInvite(string.Format("id_dep='{0}'", UserManager.getInstance().CurrentDept.Id_dep) + " and fg_response='N'");
        //    //找到所有本科室相关的医疗单
        //    OrdApConsDO[] aps = service.find(string.Format("sd_su_cons='{0}'", sd_su_cons) + "AND ", "", false);




        //    XapDataList<OrdApConsDO> list = new XapDataList<OrdApConsDO>();



        //    return list;
        //}





    }
}

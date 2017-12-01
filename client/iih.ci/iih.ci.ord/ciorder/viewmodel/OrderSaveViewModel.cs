using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.i;
using xap.mw.serviceframework;
using xap.rui.appfw.collections;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciordems.d;
using xap.mw.core.data;
using iih.ci.ciet.cievent.i;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.ems.d;
using iih.ci.ord.i;
using iih.en.pv.inpatient.dto.d;
using iih.ci.ord.ordsrvset.i;
using iih.ci.ord_stub.i;
using xap.rui.appfw;

using iih.ci.ord.cior.d;


namespace iih.ci.ord.ciorder.viewmodel {
    /// <summary>
    /// 对医嘱单进行保存，和修改
    /// </summary>
    public class OrderSaveViewModel {
        ICiorderCrudService service;
        private ICieventCrudService ciEventService;
        private IOrdsrvsetCrudService orsrvsetService;
        private ICiOrdMaintainService ordMaintainService;
        private ICiOrdQryService qryService;
        public OrderSaveViewModel() {
            service = XapServiceMgr.find<ICiorderCrudService>();
            ciEventService = XapServiceMgr.find<ICieventCrudService>();
            orsrvsetService = XapServiceMgr.find<IOrdsrvsetCrudService>();
            ordMaintainService = XapServiceMgr.find<ICiOrdMaintainService>();
            qryService = XapServiceMgr.find<ICiOrdQryService>();
        }
        public XapAggDO<CiorderAggDO> AggDOs { get; set; }
        public CiorderAggDO agg;
        OrderSrvDoseViewModel ordsrvDose = new OrderSrvDoseViewModel();
        private OrdermmViewModel modelMm = new OrdermmViewModel();
        PatientsDTO patDo = new PatientsDTO();
        LogicEx cof = LogicEx.GetInstance();
        OrDataBing orDataBing = new OrDataBing();

        /// <summary>
        /// 
        /// </summary>
        /// <param name="order_id"></param>
        /// <returns></returns>
        public CiorderAggDO GetAgg(string order_id) {
            agg = service.findById(order_id);
            return agg;
        }

        /// <summary>
        /// Saves the aggregate.
        /// </summary>
        /// <param name="ciAgg">The ci aggregate.</param>
        /// <returns></returns>
        public CiorderAggDO[] SaveAgg(CiorderAggDO ciAgg) {
            return service.save(new[] { ciAgg });
        }

        /// <summary>
        /// 根据 医嘱 id_or  取得 医嘱的信息 CiEmsDTO
        /// </summary>
        /// <param name="id_or"></param>
        /// <returns></returns>
        public CiEmsDTO getCiEmsDTO(string id_or) {
            FMap fmap = qryService.getCiEmsDTO(new string[] { id_or });
            return fmap[id_or] as CiEmsDTO;
        }

        /// <summary>
        /// Sets the手术服务
        /// </summary>
        /// <summary>
        /// 检查项目
        /// </summary>
        /// <param name="id_srv"></param>
        /// <param name="type"></param>
        /// <returns></returns>
        public EmsObsItemDO[] getEmsObsItemDO(string id_srv, string type) {
            FArrayList list = new FArrayList();
            EmsObsItemDO[] emsObsItem = qryService.getEmsObsItemDO(id_srv, type);
            return emsObsItem;
            //    if (emsObsItem != null && emsObsItem.Length>0)
            //    {
            //        foreach (EmsObsItemDO item in emsObsItem)
            //        {
            //            list.Add(item);
            //        }
            //    }
            //return list;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="emsHeadDO"></param>
        /// <param name="srvList"></param>
        public void SetOpORSrv(EmsUIDTO emsHeadDO, List<OrdSrvDO> srvList) {
            OrdSrvDO srv = new OrdSrvDO();
            if (agg.getOrdSrvDO() != null) {
                OrdSrvDO srvtmp = agg.getOrdSrvDO().FirstOrDefault(p => p.Id_orsrv == emsHeadDO.Emsapbt.Id_orsrv);
                if (srvtmp != null) {
                    srv = srvtmp;
                    srv.Status = DOStatus.UPDATED;
                }
            }

            orDataBing.SaveOpOrSrvDataBing(emsHeadDO, srv);
            srvList.Add(srv);
        }


        #region 无用的
        /// <summary>
        /// 根据医嘱id_or 取得数据
        /// </summary>
        /// <param name="id_or"></param>
        /// <returns></returns>
        //public EmsUIDTO GetEmsHeadDo(string id_or)
        //{
        //    EmsUIDTO emsHeadDo = qryService.getEmsUIDTO(id_or,"");
        //    if (emsHeadDo != null)
        //    {
        //        XapDataList<EmsObsLap> list = new XapDataList<EmsObsLap>();
        //        if (emsHeadDo.Emsapobs.EmsOrObsArrayList != null)
        //        {
        //            foreach (EmsObsLap item in emsHeadDo.Emsapobs.EmsOrObsArrayList)
        //            {
        //                list.Add(item);
        //            }
        //            emsHeadDo.Emsapobs.EmsOrObsList = list;
        //        }

        //    }
        //    return emsHeadDo;
        //}





        /// <summary>
        /// Sets the 手术申请单
        /// </summary>
        public void SetOpSug(EmsUIDTO emsHeadDO, CiorderAggDO agg) {
            //OrdApOpDO apOp = new OrdApOpDO();
            //if (agg.getOrdApOpDO() != null)
            //{
            //    OrdApOpDO op = agg.getOrdApOpDO().FirstOrDefault(p => p.Id_apop == emsHeadDO.Emsapop.Id_emsopitem);
            //    if (op != null)
            //    {
            //        apOp = op;
            //        apOp.Status = DOStatus.UPDATED;
            //    }
            //}
            //orDataBing.SaveOpSugDataBing(emsHeadDO, apOp);
            //agg.setOrdApOpDO(new OrdApOpDO[] { apOp });
        }

        /// <summary>
        /// Sets 手术人员
        /// </summary>
        /// <param name="emsHeadDO">The ems head do.</param>
        /// <param name="agg">The aggregate.</param>
        /// Author:admin
        /// Date:2015-11-05
        public void SetOpEmp(EmsUIDTO emsHeadDO, CiorderAggDO agg) {
            List<OrdOpEmpDO> emps = new List<OrdOpEmpDO>();
            //  emsHeadDO.Emsapop.OpEmpItem.ToList().ForEach(p =>
            // {
            //    OrdOpEmpDO emp = new OrdOpEmpDO();
            //    if (agg.getOrdOpEmpDO() != null)
            //    {
            //        OrdOpEmpDO op = agg.getOrdOpEmpDO().FirstOrDefault(px => px.Id_apopemp == p.Id_oropitem);
            //        if (op != null)
            //        {
            //            emp = op;
            //            emp.Status = DOStatus.UPDATED;
            //        }
            //    }
            //    emps.Add(orDataBing.SaveOpSugEmpDataBing(p, emp));
            //});
            //agg.setOrdOpEmpDO(emps.ToArray());

        }
        /// <summary>
        /// Sets手术卫材
        /// </summary>
        /// <param name="emsHeadDO">The ems head do.</param>
        /// <param name="agg">The aggregate.</param>
        private void SetOpMm(EmsUIDTO emsHeadDO, CiorderAggDO agg) {
            //    List<OrdOpMmDO> mms = new List<OrdOpMmDO>();
            //    emsHeadDO.Emsapop.OpMmItem.ToList().ForEach(p =>
            //{
            //    OrdOpMmDO mm = new OrdOpMmDO();
            //    if (agg.getOrdOpEmpDO() != null)
            //    {
            //        OrdOpMmDO op = agg.getOrdOpMmDO().FirstOrDefault(px => px.Id_apopmm == p.Id_oropitem);
            //        if (op != null)
            //        {
            //            mm = op;
            //            mm.Status = DOStatus.UPDATED;
            //        }
            //    }
            //    mms.Add(orDataBing.SaveOpSugMmDataBing(p, mm));
            //});
            //    agg.setOrdOpMmDO(mms.ToArray());
        }

        /// <summary>
        /// Sets附加手术
        /// </summary>
        /// <param name="emsHeadDO">The ems head do.</param>
        /// <param name="agg">The aggregate.</param>
        private void SetAppendOp(EmsUIDTO emsHeadDO, List<OrdSrvDO> srvList) {
            //emsHeadDO.Emsapop.OpAppendOpItem.ToList().ForEach(p =>
            //{
            //    OrdSrvDO op = new OrdSrvDO();
            //    OrdSrvDO srvtmp = agg.getOrdSrvDO().FirstOrDefault(px => px.Id_orsrv == p.Id_oropitem);
            //    if (srvtmp != null)
            //    {
            //        op = srvtmp;
            //        op.Status = DOStatus.UPDATED;
            //    }
            //   srvList.Add( orDataBing.SaveOpAppendOpDataBing(emsHeadDO, p, op));
            //});

        }



        /// <summary>
        /// Sets the病理服务
        /// </summary>
        public void SetPathgyOrSrv(EmsUIDTO emsHeadDO, List<OrdSrvDO> srvList) {
            //OrdSrvDO srv = new OrdSrvDO();
            //if (agg.getOrdSrvDO() != null)
            //{
            //    OrdSrvDO srvtmp = agg.getOrdSrvDO().FirstOrDefault(p => p.Id_orsrv == emsHeadDO.Emsappathgy.Id_orsrv);
            //    if (srvtmp != null)
            //    {
            //        srv = srvtmp;
            //        srv.Status = DOStatus.UPDATED;
            //    }
            //}

            //orDataBing.SaveOpOrSrvDataBing(emsHeadDO, srv);
            //srvList.Add(srv);
        }

        /// <summary>
        /// Sets the病理申请单
        /// </summary>
        public void SetPathgy(EmsUIDTO emsHeadDO, CiorderAggDO agg) {
            //OrdApPathgyDO pathgy = new OrdApPathgyDO();
            //if (agg.getOrdApPathgyDO() != null)
            //{
            //    OrdApPathgyDO ap = agg.getOrdApPathgyDO().FirstOrDefault(p => p.Id_appathgy == emsHeadDO.Emsappathgy.Id_ordpathgyitem);
            //    if (ap != null)
            //    {
            //        pathgy = ap;
            //        pathgy.Status = DOStatus.UPDATED;
            //    }
            //}

            //orDataBing.SavePathgyDataBing(emsHeadDO, pathgy);

            //agg.setOrdApPathgyDO(new OrdApPathgyDO[] { pathgy });
        }

        /// <summary>
        /// Sets the病理标本
        /// </summary>
        private void SetPathgySamp(EmsUIDTO emsHeadDO, CiorderAggDO agg) {

            //List<OrdApPathgySampDO> list = new List<OrdApPathgySampDO>();
            //emsHeadDO.Emsappathgy.EmsItemInpathgy.ToList().ForEach(p =>
            //{
            //    OrdApPathgySampDO samp = new OrdApPathgySampDO();

            //    if (agg.getOrdApPathgySampDO() != null)
            //    {
            //        OrdApPathgySampDO ap = agg.getOrdApPathgySampDO().FirstOrDefault(px => px.Id_appathgysamp == p.Id_oriteminpathgy);
            //        if (ap != null)
            //        {
            //            samp = ap;
            //            samp.Status = DOStatus.UPDATED;
            //        }
            //    }
            //    list.Add(orDataBing.SavePathgySampDataBing(p, samp));
            //});
            //agg.setOrdApPathgySampDO(list.ToArray());
        }


        /// <summary>
        /// Sets the通用医嘱
        /// </summary>
        private void SetCommonSrv(EmsUIDTO emsHeadDO, List<OrdSrvDO> srvList) {
            //OrdSrvDO srv = new OrdSrvDO();
            //if (agg != null && agg.getOrdSrvDO() != null)
            //{
            //    OrdSrvDO sr = agg.getOrdSrvDO().FirstOrDefault(p => p.Id_orsrv == emsHeadDO.Emsdrugs.Id_orsrv);
            //    if (sr != null)
            //    {
            //        srv = sr;
            //    }
            //}
            //orDataBing.SaveDrugOrSrvDataBing(emsHeadDO, srv);
            //srvList.Add(srv);
        }
        /// <summary>
        /// Sets the会诊的服务
        /// </summary>
        private void SetConsOrSrv(EmsUIDTO emsHeadDO, List<OrdSrvDO> srvList) {
            //OrdSrvDO srv = new OrdSrvDO();
            //if (agg != null && agg.getOrdSrvDO() != null)
            //{
            //    OrdSrvDO sr = agg.getOrdSrvDO().FirstOrDefault(p => p.Id_orsrv == emsHeadDO.Emsapcons.Id_orsrv);
            //    if (sr != null)
            //    {
            //        srv = sr;
            //        srv.Status = DOStatus.UPDATED;
            //    }
            //}
            //orDataBing.SaveDrugOrSrvDataBing(emsHeadDO, srv);
            //srvList.Add(srv);
        }

        /// <summary>
        /// Sets the会诊的申请单
        /// </summary>
        private void SetCons(EmsUIDTO emsHeadDO, CiorderAggDO Agg) {
            //   OrdApConsDO cons = new OrdApConsDO();
            //   if (agg != null && agg.getOrdApConsDO() != null)
            //   {
            //       OrdApConsDO sr = agg.getOrdApConsDO().FirstOrDefault(p => p.Id_apcons == emsHeadDO.Emsapcons.Id_emsconsitem);
            //       if (sr != null)
            //       {
            //           cons = sr;
            //           cons.Status = DOStatus.UPDATED;
            //       }
            //   }
            //agg.setOrdApConsDO(new OrdApConsDO[]{orDataBing.SaveConsDataBing(emsHeadDO, cons)});

        }


        /// <summary>
        /// Sets the会诊受邀对象
        /// </summary>
        private void SetInviteCons(EmsUIDTO emsHeadDO, string id_cons) {
            //List<CiordInviteConsDO> listInvite = new List<CiordInviteConsDO>();

            //emsHeadDO.Emsapcons.EmsConsAssistItem.ToList().ForEach(p =>
            //{
            //    CiordInviteConsDO cons = new CiordInviteConsDO();//对于新增还是修改无需判断,修改的话 存在id，和sv  新增的则没有
            //    listInvite.Add(orDataBing.SaveConsInvite(p, cons, id_cons));
            //});
            //new OrderInviteConsViewModel().Save(listInvite.ToArray());



        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="id_srv"></param>
        /// <returns></returns>
        public EmsOrSrvSc getEmsOrSrvScID(string id_srv) {
            //EmsOrSrvSc[] emsOrSrvSc =   qryService.getMedSrvId(id_srv);
            //if (emsOrSrvSc != null && emsOrSrvSc.Length >0)
            //{
            //    return emsOrSrvSc[0];
            //}
            return null;
        }


        public void SetTransSrv(EmsUIDTO emsHeadDO, List<OrdSrvDO> srvList) {
            //OrdSrvDO srv = new OrdSrvDO();
            //if (agg != null && agg.getOrdSrvDO() != null)
            //{
            //    OrdSrvDO sr = agg.getOrdSrvDO().FirstOrDefault(p => p.Id_orsrv == emsHeadDO.Emsaptrans.Id_orsrv);
            //    if (sr != null)
            //    {
            //        srv = sr;
            //        srv.Status = DOStatus.UPDATED;
            //    }
            //}
            //orDataBing.SaveTransOrSrvDataBing(emsHeadDO, srv);
            //srvList.Add(srv);
        }

        public void SetApTrans(EmsUIDTO emsHeadDO, CiorderAggDO agg) {
            //OrdApTransDO trans = new OrdApTransDO();

            //if (agg != null && agg.getOrdApConsDO() != null)
            //{
            //    OrdApTransDO sr = agg.getOrdApTransDO().FirstOrDefault(p => p.Id_ortrans == emsHeadDO.Emsaptrans.Id_emsaptrans);
            //    if (sr != null)
            //    {
            //        trans = sr;
            //        trans.Status = DOStatus.UPDATED;
            //    }
            //}

            //agg.setOrdApTransDO(new OrdApTransDO[] { orDataBing.SaveApTransDataBing(emsHeadDO, trans) });
        }




        public void SetOutSrv(EmsUIDTO emsHeadDO, List<OrdSrvDO> srvList) {
            //OrdSrvDO srv = new OrdSrvDO();
            //if (agg != null && agg.getOrdSrvDO() != null)
            //{
            //    OrdSrvDO sr = agg.getOrdSrvDO().FirstOrDefault(p => p.Id_orsrv == emsHeadDO.Emsapout.Id_orsrv);
            //    if (sr != null)
            //    {
            //        srv = sr;
            //        srv.Status = DOStatus.UPDATED;
            //    }
            //}
            //orDataBing.SaveOutOrSrvDataBing(emsHeadDO, srv);
            //srvList.Add(srv);
        }


        public void SetApOut(EmsUIDTO emsHeadDO, CiorderAggDO agg) {
            OrdApOutDO apout = new OrdApOutDO();

            //if (agg != null && agg.getOrdApConsDO() != null)
            //{
            //    OrdApOutDO sr = agg.getOrdApOutDO().FirstOrDefault(p => p.Id_orout == emsHeadDO.Emsapout.Id_emsapout);
            //    if (sr != null)
            //    {
            //        apout = sr;
            //        apout.Status = DOStatus.UPDATED;
            //    }
            //}

            //agg.setOrdApOutDO(new OrdApOutDO[] { orDataBing.SaveApOutDataBing(emsHeadDO, apout) });
        } 

        /// <summary>
        /// Saves the specified ems head do.
        /// </summary>
        /// <param name="emsHeadDO">The ems head do.</param>
        /// <param name="emsType">Type of the ems.</param>
        /// Author:admin
        /// Date:2015-09-28
        public void Save(EmsUIDTO emsHeadDO, EmsType emsType, PatientsDTO patDo) {

            if (emsHeadDO == null) return;

            //老孟版本的 数据转换
            //ordMaintainService.SaveCiEmsDTO(new OrDataConvert().UIEmsToEms(emsHeadDO));
            return;
        }

        /// <summary>
        /// Sets the 输血申请单
        /// </summary>
        /// <param name="emsHeadDO">The ems head do.</param>
        /// <param name="bt">The bt.</param>
        /// Author:admin
        /// Date:2015-10-28
        private void SetApBt(EmsUIDTO emsHeadDO, CiorderAggDO agg) {
            //OrdApBtDO bt = new OrdApBtDO();
            //if (agg.getOrdApBtDO() != null)
            //{
            //    OrdApBtDO bttmp = agg.getOrdApBtDO().FirstOrDefault(p => p.Id_apbt == emsHeadDO.Emsapbt.Id_emsbt);
            //    if (bttmp != null)
            //    {
            //        bt = bttmp;
            //        bt.Status = DOStatus.UPDATED;
            //    }
            //}
            //orDataBing.SaveApBtDataBing(emsHeadDO, bt);
            //agg.setOrdApBtDO(new OrdApBtDO[] { bt });
        }
        #endregion

    }


}

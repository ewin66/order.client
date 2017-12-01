using System;
using System.Linq;
using iih.bd.fc.orwf.d;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.medsrv.i;
using iih.ci.ord.cior.d;
using iih.ci.ord.cior.i;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.dto.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.i;
using iih.en.pv.dto.d;
using xap.cli.context;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using iih.ci.ord.emsdi.d;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.ord.opemergency.ems.common;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.rui.control.extentions;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.dto.emsmain;
using iih.ci.ord.common.utils;
using xap.mw.core.data;
using iih.ci.ord.opemergency.declare;
using iih.ci.iih.ci.ord.i;
using System.Collections.Generic;

/*
********************************************************************************

** 作者： 李程

** 创始时间：2016-6-30

** 修改人：李程

** 修改时间：2016-6-30

** 描述： 医嘱确认显示页面


*********************************************************************************
*/

namespace iih.ci.ord.opemergency.ems.dp
{
    /// <summary>
    /// 用血医疗单数据处理模型
    /// </summary>
    class EmsApbuViewModel : BaseEmsViewModel
    {

        private XapDataList<CiordubDTO> tableDatasource = new XapDataList<CiordubDTO>();
        private ICiOrdQryService qryservice;
        public EmsApbuViewModel(Ent4BannerDTO ent) : base(ent) { }

        public override void Init()
        {

            qryservice = XapServiceMgr.find<ICiOrdQryService>();
            base.Init();
            this.uiEmsDTO.EmsType = EmsType.BTUSE;
        }

        public override bool IsEmpty()
        {
            return tableDatasource == null || tableDatasource.Count == 0 ||
                (tableDatasource.Count == 1 && String.IsNullOrEmpty(tableDatasource[0].Id_srv));
        }

        public override object GetTableDataSource()
        {
            return tableDatasource;
        }

        public override object GetFormDataSource()
        {
            return this.uiEmsDTO.CiordubDTO;
        }

        public override int GetCountWithOutDelete()
        {
            XapDataList<CiordubDTO> itemList = this.GetTableDataSource() as XapDataList<CiordubDTO>;
            if (itemList.Count == 0)
                return 0;

            return itemList.ToList().Count(p => !p.IsDELETED);
        }

        public override bool LoadMedSrv(EmsCreatedParameter emsCreateParameter, int pos) // //EmsCreateParameter
        {

            // Old_LoadMedSrv( emsCreateParameter,  pos);

            New_LoadMedSrv(emsCreateParameter, pos);
            return true;
          }

        /// <summary>
        /// 优化前方法
        /// </summary>
        /// <param name="emsCreateParameter"></param>
        /// <param name="pos"></param>
        /// <returns></returns>
          private bool Old_LoadMedSrv(EmsCreatedParameter emsCreateParameter, int pos)
          {
            base.LoadMedSrv(emsCreateParameter, pos);
            MedSrvDO med = emsCreateParameter.getMedSrvDO();
            med = XapServiceMgr.find<IMedsrvMDOCrudService>().findById(med.Id_srv);
            this.uiEmsDTO.MedSrvDO = med;
            orDataBing.AddBtDataBing(this.uiEmsDTO, med);
              var ub = GetCustomParam() as CiordubDTO;
              this.uiEmsDTO.CiordubDTO = ub;
              this.uiEmsDTO.CiordubDTO.Dt_bu_pl_ub = CommonExtentions.NowTime(this);
              tableDatasource = new XapDataList<CiordubDTO>();
              //执行科室
              OrWfDeptInfoDTO wf = new GetDeptMpImp().GetDept_mp_ids(this.uiEmsDTO.PatInfo.Code_entp,
                 this.uiEmsDTO.PatInfo.Id_entp,
                 this.uiEmsDTO.MedSrvDO.Sd_srvtp,
                 this.uiEmsDTO.MedSrvDO.Id_srvca,
                 this.uiEmsDTO.MedSrvDO.Id_srv,
                 this.uiEmsDTO.MedSrvDO.Id_route,
                 "", this.uiEmsDTO.PatInfo.Id_dep_nur, this.uiEmsDTO.PatInfo.Id_dep_phy);
              if (wf != null)
              {
                  uiEmsDTO.CiordubDTO.Id_mp_dep = wf.Firstid_mp_dept;
                  uiEmsDTO.CiordubDTO.Name_mp_dep = wf.Firstname_mp_dept;
              }
              this.uiEmsDTO.CiordubDTO.Dt_bu_pl_ub = this.uiEmsDTO.CiordubDTO.Dt_begin_ui = this.uiEmsDTO.CiordubDTO.Dt_bu_pl_ub == null ? this.NowTime() : this.uiEmsDTO.CiordubDTO.Dt_bu_pl_ub;
              this.uiEmsDTO.CiordubDTO.Use_days = 1;
              this.uiEmsDTO.CiordubDTO.Dt_end_ui = ((DateTime)this.uiEmsDTO.CiordubDTO.Dt_begin_ui).AddDays((int)this.uiEmsDTO.CiordubDTO.Use_days);
              this.uiEmsDTO.CiordubDTO.Times_cur = CalQuantumUtil.GetInstance().getTotalTimes(med.Id_freq, this.uiEmsDTO.CiordubDTO.Use_days);
           
              tableDatasource.Add(this.uiEmsDTO.CiordubDTO);
              //*/

            // ++


            return true;
        }

        /// <summary>
        /// 优化后方法
        /// </summary>
        /// <param name="emsCreateParameter"></param>
        /// <param name="pos"></param>
        /// <returns></returns>
        private bool New_LoadMedSrv(EmsCreatedParameter emsCreateParameter, int pos)
        {
            base.LoadMedSrv(emsCreateParameter, pos);
            MedSrvDO med = emsCreateParameter.getMedSrvDO();
            this.uiEmsDTO.MedSrvDO = med;
            var ub = GetCustomParam() as CiordubDTO;
            Dictionary<String, Object> ctmInfo = new Dictionary<string, object>();
            ctmInfo.Add("CustomInfo", ub.Id_or_rel);
            EmsRstDTO[] rsts = CreateRemote(med.Id_srv, null, ctmInfo);
            EmsRstDTO rst = rsts[0];

                if (rst != null)
                {
                    if (null == this.uiEmsDTO.CiordubDTO)
                    {
                        this.uiEmsDTO.CiordubDTO = new CiordubDTO();
                    }

                uiEmsDTO.CiordubDTO.deSerializeJson((rst.Document[0] as CiordubDTO).serializeJson());
                //String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(rst.DocumentString));
                //uiEmsDTO.CiordubDTO.deSerializeJson(utf8Str);

                    if (rst.Extension != null && rst.Extension.Keys.Contains("MedSrvDO"))
                    {
                        this.uiEmsDTO.MedSrvDO = rst.Extension["MedSrvDO"] as MedSrvDO;
                    }

                    tableDatasource.Add(this.uiEmsDTO.CiordubDTO);
                }

            return true;
        }

        protected override void OnBeforeCallServiceSave(CiEmsDTO ems)
        {
            base.OnBeforeCallServiceSave(ems);

            ems.Fg_mp_in = true;
            if (ems.Emssrvs != null)
                ems.Emssrvs.Cast<CiEmsSrvDTO>().Where(srv => srv.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN).ToList().ForEach(srv =>
                {
                srv.Quan_total_medu = 0;
            });
        }

        public override string OnRefFilterData(string filedName, StringObjectMap sbm)
        {
            string whereString = base.OnRefFilterData(filedName, sbm);

            if (whereString != "") return whereString;

            if (filedName.Equals("Name_route"))
            {
                whereString = " id_srvtp ='1001W11000000003UM0H'";
            }
            else if (filedName.Equals("Name_mp_dep"))
            {

                OrWfExDeptDTO[] ow = null;
                string depis = "";
                ow = this.getMpDept();


                if (ow != null)
                {
                    foreach (OrWfExDeptDTO o in ow)
                    {
                        depis += "'" + o.Id_dept + "',";
                    }

                    whereString = " bd_dep.id_dep in (" + depis.Substring(0, depis.Count() - 1) + ")";
                }
            }
            return whereString;
        }

        public override void OnDataChanged(object ds, string fieldName, string value)
        {
            base.OnDataChanged(ds, fieldName, value);
        }

        public override void EditOrder(CiOrderDO ciOrderDO)
        {
            // Old_EditOrder(ciOrderDO);

            New_EditOrder(ciOrderDO);
        }

        /// <summary>
        /// 优化前方法
        /// </summary>
        /// <param name="ciOrderDO"></param>
        private void Old_EditOrder(CiOrderDO ciOrderDO)
        {
            base.EditOrder(ciOrderDO);
            orCiEmsToUiEms.EditApbtuse(uiEmsDTO, ciEmsDTO);

            var srvCommon = (CiEmsSrvDTO)ciEmsDTO.Emssrvs[0];

            var service = XapServiceMgr.find<IMedsrvMDOCrudService>();
            //查询用血对应的服务
            uiEmsDTO.MedSrvDO = service.findById(srvCommon.Id_srv);

            var btService = XapServiceMgr.find<ICiorappbtMDOCrudService>();
            OrdApBtDO[] btdos = btService.find("a0.id_or='" + ciEmsDTO.Id_or_rel + "'", null, FBoolean.False);
            OrdApBtDO btdo = btdos[0];
            this.uiEmsDTO.CiordubDTO.Id_mp_dep = srvCommon.Id_dep;
            this.uiEmsDTO.CiordubDTO.Name_mp_dep = srvCommon.Name_dep;
            uiEmsDTO.CiordubDTO.Applyform = btdo.No_applyform;
            uiEmsDTO.CiordubDTO.Dt_bt_pl = Convert.ToDateTime(btdo.Dt_bt_pl);
            uiEmsDTO.CiordubDTO.Num_margin_bu = btdo.Num_margin_bu;
            uiEmsDTO.CiordubDTO.Quan_medu = btdo.Num_margin_bu;
            uiEmsDTO.CiordubDTO.Des_or = ciEmsDTO.Note;
            tableDatasource = new XapDataList<CiordubDTO>();
            tableDatasource.Add(uiEmsDTO.CiordubDTO);
        }

        /// <summary>
        /// 优化后方法
        /// </summary>
        /// <param name="ciOrderDO"></param>
        private void New_EditOrder(CiOrderDO ciOrderDO)
        {
            ICiEmsMainService emsMainService = XapServiceMgr.find<ICiEmsMainService>();
            if (null != emsMainService)
            {
                EmsLoadDTO[] emsloads = new EmsLoadDTO[1];
                var emsload = new EmsLoadDTO();
                emsload.Id_or = ciOrderDO.Id_or;
                emsload.Extension = new FMap2();
                emsload.EnContext = CiEnContextUtil.GetCiEnContext(this.GetEnt4BannerDTO(), this.GetContext());
                emsload.EmsDriver = ((int)this.uiEmsDTO.EmsType).ToString();
                emsloads[0] = emsload;
                EmsRstDTO[] rsts = emsMainService.load(emsloads);
                EmsRstDTO rst = rsts[0];
                if (rst != null)
                {

                    uiEmsDTO.CiordubDTO = (rst.Document[0] as CiordubDTO);
                    //String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(rst.DocumentString));
                    //uiEmsDTO.CiordubDTO.deSerializeJson(utf8Str);

                    if (rst.Extension != null && rst.Extension.Keys.Contains("CiEmsDTO"))
                    {
                        this.ciEmsDTO = rst.Extension["CiEmsDTO"] as CiEmsDTO;
                    }
                    if (rst.Extension != null && rst.Extension.Keys.Contains("MedSrvDO"))
                    {
                        this.uiEmsDTO.MedSrvDO = rst.Extension["MedSrvDO"] as MedSrvDO;
                    }

                    tableDatasource = new XapDataList<CiordubDTO>();
                    this.tableDatasource.Add(uiEmsDTO.CiordubDTO);

                    //其他处理
                    uiEmsDTO.Id_srvof = ciEmsDTO.Id_srvof;
                    this.ciEmsDTO.Status = DOStatus.UPDATED;
                    this.uiEmsDTO.Status = DOStatus.UPDATED;

                    HandleExpenseItems(ciEmsDTO);
                }

            }//*/
        }


        public override void EditEms(CiEmsDTO ems)
        {
            base.EditEms(ems);
            orCiEmsToUiEms.EditApbtuse(uiEmsDTO, ems);

            var srvCommon = (CiEmsSrvDTO)ems.Emssrvs[0];

            var service = XapServiceMgr.find<IMedsrvMDOCrudService>();
            //查询用血对应的服务
            uiEmsDTO.MedSrvDO = service.findById(srvCommon.Id_srv);

            var btService = XapServiceMgr.find<ICiorappbtMDOCrudService>();
            OrdApBtDO[] btdos = btService.find("a0.id_or='" + ems.Id_or_rel + "'", null, FBoolean.False);
            OrdApBtDO btdo = btdos[0];
            this.uiEmsDTO.CiordubDTO.Id_mp_dep = srvCommon.Id_dep;
            this.uiEmsDTO.CiordubDTO.Name_mp_dep = srvCommon.Name_dep;
            uiEmsDTO.CiordubDTO.Applyform = btdo.No_applyform;
            uiEmsDTO.CiordubDTO.Dt_bt_pl = Convert.ToDateTime(btdo.Dt_bt_pl);
            uiEmsDTO.CiordubDTO.Num_margin_bu = btdo.Num_margin_bu;
            uiEmsDTO.CiordubDTO.Quan_medu = btdo.Num_margin_bu;
            uiEmsDTO.CiordubDTO.Des_or = ems.Note;
            tableDatasource = new XapDataList<CiordubDTO>();
            tableDatasource.Add(uiEmsDTO.CiordubDTO);
        }

        public override CiOrderDO Save2Order()
        {
            return base.Save2Order();
        }

       

        /// <summary>
        /// 获取执行科室
        /// </summary>
        /// <param name="drug"></param>
        /// <param name="or"></param>
        /// <returns></returns>

        public OrWfExDeptDTO[] getMpDept()
        {
            OrWfExDeptParamDTO orWf = new OrWfExDeptParamDTO();
            orWf.Id_dept_ns = UserManager.getInstance().CurrentDept.Id_dep;
            orWf.Id_srv = this.uiEmsDTO.MedSrvDO.Id_srv;
            orWf.Id_srvca = this.uiEmsDTO.MedSrvDO.Id_srvca;
            orWf.Code_entp = this.uiEmsDTO.PatInfo.Code_entp;
            orWf.Sd_srvtp = this.uiEmsDTO.MedSrvDO.Sd_srvtp;
            return this.qryservice.getMpDept(orWf);
        }

        public override string[] GetReadonlyFields()
        {
            return new string[] { "Name_srv" };
        }
    }
}

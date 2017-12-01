using System;
using System.ComponentModel;
using System.Linq;
using iih.bd.fc.orwf.d;
using iih.bd.srv.ems.d;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.medsrv.i;
using iih.ci.ord.cior.d;
using iih.ci.ord.cior.i;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.i;
using iih.ci.ord.dto.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.i;
using iih.ci.ord.opemergency.viewmodel;
using iih.en.pv.dto.d;
using xap.cli.context;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using iih.ci.ord.emsdi.d;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.ord.opemergency.ems.common;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.dto.emsmain;
using iih.ci.ord.common.utils;
using xap.rui.control.extentions;
using iih.ci.ord.opemergency.declare;
using iih.ci.iih.ci.ord.i;

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
    ///     备血医疗单数据处理模型
    /// </summary>
    public class EmsApbtViewModel : BaseEmsViewModel
    {
        private ICiorappbtMDOCrudService btService;
        private ICiorderCrudService orService;
        private ICiOrdQryService qryservice;

        private XapDataList<EmsBtItemDO> tableDatasource;
        private String strMpDeps = "";


        //public static String Apbu_Srv_ID = "0001Z7100000000EQYGA"; // 0001AA10000000060H8O // ##????

        public EmsApbtViewModel(Ent4BannerDTO ent)
            : base(ent)
        {
        }

        public override void Init()
        {
            btService = XapServiceMgr.find<ICiorappbtMDOCrudService>();
            orService = XapServiceMgr.find<ICiorderCrudService>();
            qryservice = XapServiceMgr.find<ICiOrdQryService>();
            base.Init();
            uiEmsDTO.EmsType = EmsType.BT;
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
            return uiEmsDTO.Emsapbt;
        }

        public override bool LoadMedSrv(EmsCreatedParameter emsCreateParameter, int pos) //EmsCreateParameter
        {

            base.LoadMedSrv(emsCreateParameter, pos);
            MedSrvDO med = emsCreateParameter.getMedSrvDO();
            uiEmsDTO.MedSrvDO = med;
            tableDatasource = new XapDataList<EmsBtItemDO>();
            EmsRstDTO[] rsts = CreateRemote(med.Id_srv);
            EmsRstDTO rst = rsts[0];
                if (rst != null)
                {

                uiEmsDTO.Emsapbt.deSerializeJson((rst.Document[0] as EmsBtItemDO).serializeJson());
                //String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(rst.DocumentString));
                //uiEmsDTO.Emsapbt.deSerializeJson(utf8Str);

                    if (rst.Extension != null && rst.Extension.Keys.Contains("MedSrvDO"))
                    {
                        this.uiEmsDTO.MedSrvDO = rst.Extension["MedSrvDO"] as MedSrvDO;
                        this.strSd_srvtp = this.uiEmsDTO.MedSrvDO.Sd_srvtp;
                    }
                    if (rst.Extension != null && rst.Extension.Keys.Contains("MpDepFilter"))
                    {
                        strMpDeps = rst.Extension["MpDepFilter"] as String;
                    }

                    tableDatasource.Add(uiEmsDTO.Emsapbt);

                    // 动态指标
                    if (null != uiEmsDTO.Emsapbt.BtLabItemEx)
                    {
                    uiEmsDTO.Emsapbt.BtLabItemEx.Cast<OrdApSugViewItemDO>().ToList().ForEach(item =>
                    {
                            uiEmsDTO.Emsapbt.BtLabItem.Add(item);
                            item.PropertyChanged += ordApSugViewItemDO_PropertyChanged;
                        });
                    }

                }


            return true;
        }

        public override void EditOrder(CiOrderDO ciOrderDO)
        {
            EmsRstDTO[] rsts = LoadRemote(ciOrderDO.Id_or);
            EmsRstDTO rst = rsts[0];
                if (rst != null)
                {
                uiEmsDTO.Emsapbt = rst.Document[0] as EmsBtItemDO;
                //String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(rst.DocumentString));
                //uiEmsDTO.Emsapbt.deSerializeJson(utf8Str);

                    if (rst.Extension!=null&&rst.Extension.Keys.Contains("CiordubDTO"))
                    {
                        uiEmsDTO.CiordubDTO = rst.Extension["CiordubDTO"] as CiordubDTO;
                    }
                    if (rst.Extension != null && rst.Extension.Keys.Contains("CiEmsDTO"))
                    {
                        this.ciEmsDTO = rst.Extension["CiEmsDTO"] as CiEmsDTO;
                    }
                    if (rst.Extension != null && rst.Extension.Keys.Contains("MedSrvDO"))
                    {
                        this.uiEmsDTO.MedSrvDO = rst.Extension["MedSrvDO"] as MedSrvDO;
                        this.strSd_srvtp = this.uiEmsDTO.MedSrvDO.Sd_srvtp;
                    }

                    tableDatasource = new XapDataList<EmsBtItemDO>();
                    this.tableDatasource.Add(uiEmsDTO.Emsapbt);

                    if (this.uiEmsDTO.Emsapbt.BtLabItemEx != null)
                    {
                        if (null == this.uiEmsDTO.Emsapbt.BtLabItem)
                        {
                            this.uiEmsDTO.Emsapbt.BtLabItem = new XapDataList<OrdApSugViewItemDO>();
                        }
                        this.uiEmsDTO.Emsapbt.BtLabItem.Clear();
                    this.uiEmsDTO.Emsapbt.BtLabItemEx.Cast<OrdApSugViewItemDO>().ToList().ForEach(o =>
                    {
                            this.uiEmsDTO.Emsapbt.BtLabItem.Add(o);
                        });
                    }
                   
                }


            uiEmsDTO.Id_srvof = ciEmsDTO.Id_srvof;
            this.ciEmsDTO.Status = DOStatus.UPDATED;
            this.uiEmsDTO.Status = DOStatus.UPDATED;
            
            HandleExpenseItems(ciEmsDTO);

        }

        public override void EditEms(CiEmsDTO ems)
        {
            base.EditEms(ems);
            this.uiEmsDTO.Id_srvof = ems.Id_srvof;
            this.uiEmsDTO.Funcclassstr = ems.Funcclassstr;
            this.uiEmsDTO.Status = DOStatus.NEW;
            HandleEditLogic(ems);
        }

        public override int GetCountWithOutDelete()
        {
            XapDataList<EmsBtItemDO> itemList = this.GetTableDataSource() as XapDataList<EmsBtItemDO>;
            if (itemList.Count == 0)
                return 0;

            return itemList.ToList().Count(p => !p.IsDELETED);
        }

        protected void HandleEditLogic(CiEmsDTO ems)
        {
            string unitname = "";

            var srvCommon = (CiEmsSrvDTO)ems.Emssrvs[0];

            var service = XapServiceMgr.find<IMedsrvMDOCrudService>();
            ////查询用血对应的服务
            //MedSrvDO medSrcDO = service.findById(Apbu_Srv_ID);
            uiEmsDTO.MedSrvDO = service.findById(ems.Id_srv);

            if (uiEmsDTO.Emsapbt.BtLabItem.Count == 0)
            {
                LoadIndicatorData();
            }
            orCiEmsToUiEms.EditApbt(uiEmsDTO, ems, ref unitname);
            this.uiEmsDTO.Status = DOStatus.NEW;

            uiEmsDTO.Emsapbt.Dt_create = ems.Dt_begin;
            
            this.uiEmsDTO.Emsapbt.Id_mp_dep = srvCommon.Id_dep;
            this.uiEmsDTO.Emsapbt.Name_mp_dep = srvCommon.Name_dep;
            tableDatasource = new XapDataList<EmsBtItemDO>();
            tableDatasource.Add(uiEmsDTO.Emsapbt);

            if (ems.Id_or != null)
            {

                CiorderAggDO ciagg = orService.findById(ems.Id_or);
                this.ciOrder = ciagg.getParentDO();
                OrdApBtDO[] btdos = btService.find("id_or='" + ciOrder.Id_or + "'", null, FBoolean.False);
                OrdApBtDO btdo = btdos[0];
                uiEmsDTO.CiordubDTO = new CiordubDTO();
                uiEmsDTO.CiordubDTO.Id_or_rel = ciOrder.Id_or;
                uiEmsDTO.CiordubDTO.Applyform = btdo.No_applyform;
                uiEmsDTO.CiordubDTO.Orsrvname = ciagg.getOrdSrvDO()[0].Name;
                uiEmsDTO.CiordubDTO.Id_srv = ciOrder.Id_srv;
                uiEmsDTO.CiordubDTO.Quan_medu = ciagg.getOrdSrvDO()[0].Quan_medu;
                uiEmsDTO.CiordubDTO.Id_unit = ciagg.getOrdSrvDO()[0].Id_medu;
                uiEmsDTO.CiordubDTO.Dt_bt_pl = Convert.ToDateTime(btdo.Dt_bt_pl);
                uiEmsDTO.CiordubDTO.Num_margin_bu = btdo.Num_margin_bu;
                uiEmsDTO.CiordubDTO.Id_emp_sign = ciOrder.Id_emp_sign;
                uiEmsDTO.CiordubDTO.Name_emp_sign = ciOrder.Emp_sign_name;
                //uiEmsDTO.CiordubDTO.Id_route = medSrcDO.Id_route;
                //uiEmsDTO.CiordubDTO.Name_route = medSrcDO.Route_name;
                uiEmsDTO.CiordubDTO.Quan_medu_ub = uiEmsDTO.CiordubDTO.Quan_medu;
                uiEmsDTO.CiordubDTO.Name_unit = uiEmsDTO.MedSrvDO.Med_name;
                uiEmsDTO.CiordubDTO.Id_unit = uiEmsDTO.MedSrvDO.Id_unit_med;

            }
            CiorappbtAggDO agg = ems.Orapplysheet[((int)EmsType.BT).ToString()] as CiorappbtAggDO;
            agg.Status = DOStatus.UPDATED;
            agg.getParentDO().Status = DOStatus.UPDATED;
        }

        protected override void OnBeforeCallServiceSave(CiEmsDTO ems)
        {
            base.OnBeforeCallServiceSave(ems);
            // 在院执行标志
            ems.Fg_mp_in = true;

            ems.Emssrvs.Cast<CiEmsSrvDTO>().Where(srv => srv.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN).ToList().ForEach(srv =>
            {
                srv.Quan_total_medu = 0;
            });
        }

        public override CiOrderDO Save2Order()
        {
            
            
            ciOrder = base.Save2Order();
            if (this.ciEmsDTO.Id_or == null)
            {
                MedSrvDO medSrcDO = LogicEx.GetInstance().getApBuSrv();
                if (medSrcDO != null)
                {
                    CiorderAggDO ciagg = orService.findById(ciOrder.Id_or);
                    OrdApBtDO[] btdos = btService.find("id_or='" + ciOrder.Id_or + "'", null, FBoolean.False);
                    OrdApBtDO btdo = btdos[0];
                    uiEmsDTO.CiordubDTO = new CiordubDTO();
                    uiEmsDTO.CiordubDTO.Id_or_rel = ciOrder.Id_or;
                    uiEmsDTO.CiordubDTO.Applyform = btdo.No_applyform;
                    uiEmsDTO.CiordubDTO.Orsrvname = ciagg.getOrdSrvDO()[0].Name;
                    uiEmsDTO.CiordubDTO.Id_srv = ciOrder.Id_srv;
                    uiEmsDTO.CiordubDTO.Quan_medu = ciagg.getOrdSrvDO()[0].Quan_medu;
                    uiEmsDTO.CiordubDTO.Id_unit = ciagg.getOrdSrvDO()[0].Id_medu;
                    uiEmsDTO.CiordubDTO.Dt_bt_pl = Convert.ToDateTime(btdo.Dt_bt_pl);
                    uiEmsDTO.CiordubDTO.Num_margin_bu = btdo.Num_margin_bu;
                    uiEmsDTO.CiordubDTO.Id_emp_sign = ciOrder.Id_emp_sign;
                    uiEmsDTO.CiordubDTO.Name_emp_sign = ciOrder.Emp_sign_name;
                    uiEmsDTO.CiordubDTO.Id_route = medSrcDO.Id_route;
                    uiEmsDTO.CiordubDTO.Name_route = medSrcDO.Route_name;
                    uiEmsDTO.CiordubDTO.Quan_medu_ub = uiEmsDTO.CiordubDTO.Quan_medu;
                    uiEmsDTO.CiordubDTO.Name_unit = ciagg.getOrdSrvDO()[0].Medu_name;
                    uiEmsDTO.CiordubDTO.Id_unit = uiEmsDTO.MedSrvDO.Id_unit_med;
                }
                
            }
            return ciOrder;
        }

        public override string OnRefFilterData(string filedName, StringObjectMap sbm)
        {
            string whereString = "";
            if (filedName.Equals("Components_name"))
            {
                if (!sbm.ContainsKey("code_entp"))
                {
                    sbm.Add("code_entp", "00");
                }
                if (!sbm.ContainsKey("id_pripat"))
                {
                    sbm.Add("id_pripat", this.ent4BannerDTO.Id_pripat);
                }
                CiEnContextDTO ciEnContextDTO = BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO;
                string id_hp = ciEnContextDTO.Id_hp_default;
                if (!string.IsNullOrEmpty(id_hp))
                {
                    if (!sbm.ContainsKey("id_hp"))
            {
                        sbm.Add("id_hp", id_hp);
                    }
                }
                whereString = string.Format(" Sd_srvtp ='{0}' and quan_med is not null", strSd_srvtp);
            }
            else if (filedName.Equals("Name_mp_dep"))
            {


                whereString = " bd_dep.id_dep in (" + strMpDeps + ")";
            }
            else
            {
                whereString = base.OnRefFilterData(filedName, sbm);
                if (whereString != "") return whereString;
            }
            return whereString;
        }

        private void LoadIndicatorData()
        {
            if (uiEmsDTO == null || uiEmsDTO.Emsapbt == null || uiEmsDTO.Emsapbt.BtLabItem == null)
                return;

            uiEmsDTO.Emsapbt.BtLabItem.Clear();

            var viewmodel = new PreBloodCardViewModel();

            EmsDynamicIndexDTO[] dtos = viewmodel.getEmsDynamicIndexInfos(uiEmsDTO,this.ciEmsDTO.Id_srvof);
            if (dtos == null)
                return;
            foreach (EmsDynamicIndexDTO dto in dtos)
            {
                if (dto.Enumvalues != null)
                {
                    dto.Enumvalues = " ," + dto.Enumvalues;
                }
                var ordApSugViewItemDO = new OrdApSugViewItemDO
                {
                    Val_rstrptla = dto.Indexval == null ? "" : dto.Indexval,
                    Val_restrptlab = dto.Enumvalues == null ? " " : dto.Enumvalues.Replace(',', '|'),
                    Sd_restrptlabtp = dto.Datatype,
                    Name_srv = dto.Showname,
                    Name_unit = dto.Unitname,
                    Id_unit = dto.Id_unit,
                    Id_srv = dto.Id_srv
                };
                ordApSugViewItemDO.PropertyChanged += ordApSugViewItemDO_PropertyChanged;
                uiEmsDTO.Emsapbt.BtLabItem.Add(ordApSugViewItemDO);
            }
        }

        private void ordApSugViewItemDO_PropertyChanged(object sender, PropertyChangedEventArgs e)
        {
            //只要有一个动态指标没有赋值，输血前检查说明就为必填


            //bool flag = true;
            foreach (OrdApSugViewItemDO dto in uiEmsDTO.Emsapbt.BtLabItem)
            {

                if (string.IsNullOrEmpty(dto.Val_rstrptla) || string.IsNullOrEmpty(dto.Val_rstrptla.Trim()))
                {
                    //flag = false;
                    break;
                }
            }

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
            return new string[] { };
        }
    }
}
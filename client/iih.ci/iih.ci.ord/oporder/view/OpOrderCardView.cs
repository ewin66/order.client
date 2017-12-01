using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using iih.ci.ord.ciorder.cards;
using xap.rui.engine;
using iih.ci.ord.ciorder.viewmodel;

using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using xap.mw.core.data;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.cior.d;
using iih.ci.ord.ciorder.utils;
using xap.rui.appfw;
using iih.ci.ord.ciorder;
using iih.ci.ord.oporder.cards;
using iih.ci.ord.ciorder.render;
using iih.ci.ord.ems.d;
using iih.en.pv.dto.d;
using iih.en.pv.pativisit.d;
using xap.rui.control.extentions;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;
using iih.ci.ord.dto.d;
using System.Runtime.InteropServices;
using xap.cli.sdk.controls.navbar;
using iih.bd.srv.ortpl.d;
using System.Drawing;

namespace iih.ci.ord.oporder.view
{
    public partial class OpOrderCardView : CiorderBaseControl, IWorkStationRegist
    {

        #region 成员变量
        /// <summary>
        /// 当前的多医疗单情况下的索引数字控件
        /// </summary>
        private XRoundRender TMPrender;

        /// <summary>
        /// 代表当前的医疗单控件
        /// </summary>
        private CiorderBaseControl currentEmsControl = null;

        /// <summary>
        /// Banner上的信息DTO
        /// </summary>
        private Ent4BannerDTO bannerDto = new Ent4BannerDTO();

        /// <summary>
        /// 检查和病理申请单功能类
        /// </summary>
        private AppObsAndlabUtil obslab = new AppObsAndlabUtil();
        /// <summary>
        /// CI（后台）的EMS到UI（前台）上的EMS的转换类
        /// </summary>
        private OrCIEmsTOUIEms orCiEmsToUiEms = new OrCIEmsTOUIEms();
        /// <summary>
        /// 医嘱数据绑定对象
        /// </summary>
        private OrDataBing orDataBing = new OrDataBing();
        /// <summary>
        /// 医嘱保存部分的前台模型
        /// </summary>
        private OrderSaveViewModel model = new OrderSaveViewModel();
        /// <summary>
        /// 代表医疗单UI的DTO对象
        /// </summary>
        private EmsUIDTO emsDO;
        /// <summary>
        /// 新增的时候，该DTO是空的，当修改的时候该DTO就有值了。后台的医疗单的DTO
        /// 把这条医嘱关联的所有后台数据都拿过来了
        /// </summary>
        private CiEmsDTO dto;
        /// <summary>
        /// （CI_OR表）主表的DO
        /// </summary>
        private CiOrderDO ciorderDO;
        /// <summary>
        /// 医疗单数据的状态
        /// </summary>
        private int status = DOStatus.UNCHANGED;
        /// <summary>
        /// 医疗单卡片保存的视图模型
        /// todo:未来可能会废弃
        /// </summary>
        private OrderSaveCommonViewModel dtoSaveViewModel = new OrderSaveCommonViewModel();
        /// <summary>
        /// todo:未来可能会废弃
        /// </summary>
        private OrderCardViewModel orderCardViewModel = new OrderCardViewModel();
        /// <summary>
        /// 多医疗单处理
        /// 医疗单的名称处理
        /// </summary>
        private OpOrderItemView orderItemView;
        /// <summary>
        /// 医疗单来源
        /// </summary>
        private int orderDataFrom = (int)OrSrvSourceFromEnum.PHYSIAN;
        /// <summary>
        /// 医疗单根据患者信息的编辑状态
        /// </summary>
        public bool viewEditState;
        /// <summary>
        /// 获取医疗单的对象
        /// </summary>
        private OrderGetSheetEx sheets = new OrderGetSheetEx();
        /// <summary>
        /// 右边收起控件
        /// </summary>
        private TabNavigatorControl tabNaviControl;
        /// <summary>
        /// 医疗单信息来源方式 ：服务选中（bd_srv）， 
        /// 医嘱助手（服务分类，患者既往，医嘱模板，协定处方，常规医嘱），临床路径(cp)
        /// </summary>
        private string orderDataFromStr = "";
        /// <summary>
        /// 设置缓存,表单集合
        /// </summary>
        private Dictionary<string, CiorderBaseControl> ctls = new Dictionary<string, CiorderBaseControl>();
        /// <summary>
        /// [医疗单，医疗单数据]
        /// </summary>
        private Dictionary<CiorderBaseControl, Object> ciControl;
        /// <summary>
        /// 代表EMS的数据集合，[前面是index序号，[医疗单控件，医疗单数据]]
        /// </summary>
        private Dictionary<string, Dictionary<CiorderBaseControl, Object>> emsList =
            new Dictionary<string, Dictionary<CiorderBaseControl, Object>>();
        /// <summary>
        /// UIEmsDTO 字典
        /// </summary>
        private Dictionary<string, Object> UiEmsDict = new Dictionary<string, Object>();
        /// <summary>
        /// CIEmsDTO 字典
        /// </summary>
        private Dictionary<string, Object> CiEmsDict = new Dictionary<string, Object>();
        /// <summary>
        /// [医疗单index序号,医疗单的提示标题]
        /// </summary>
        private Dictionary<string, string> ciControlNameDict = new Dictionary<string, string>();
        #endregion

        #region 构造函数

        public OpOrderCardView()
        {
            InitializeComponent();
        }

        #endregion

        #region 公共函数
        /// <summary>
        /// 设置上列表视图
        /// </summary>
        /// <param name="itemobj"></param>
        public void SetOrderItemView(OpOrderItemView itemobj) {
            this.orderItemView = itemobj;
        }

        /// <summary>
        /// 清空医疗单缓存列表
        /// </summary>
        public void ClearEmsList() {
            this.emsList.Clear();
        }

        /// <summary>
        /// 判断医疗单缓存列表是否是空的
        /// </summary>
        /// <returns></returns>
        public bool IsEmsListEmpty() {
            if (this.emsList.Count <= 1) {
                return true;
            }
            return false;
        } 
        #endregion

        #region 打开医疗单

        /// <summary>
        /// 多医疗单处理,医疗单入口
        /// </summary>
        /// <param name="dataList">医嘱对象集合(第一个不是医嘱，是医嘱的数据来源)</param>
        /// <param name="patientsDto">患者信息DTO</param>
        /// <param name="tabNaviControl">右缩面板对象</param>
        public void ManyRecordSheet(List<Object> dataList, Ent4BannerDTO patientsDto, TabNavigatorControl tabNaviControl) {
            this.emsList.Clear();
            this.ciControlNameDict.Clear();
            this.UiEmsDict.Clear();
            this.CiEmsDict.Clear();
            this.ctls.Clear();
            this.emsIndexAndButtonArea.DataSource.Clear();
            if (this.emsDO != null)
            {
                this.emsDO.Emsdrugs.EmsOrDrugList.Clear();
            }
          
            this.tabNaviControl = tabNaviControl;
            if (dataList != null && dataList.Count > 0 && patientsDto != null) {
                ParseOrderDataFrom(dataList);

                for (int i = 1; i < dataList.Count; ++i) {
                    // 默认医疗单
                    this.SetEmsFromOrdOrSrv(dataList[i], patientsDto);
                    emsList.Add(i+"", ciControl);
                    this.UiEmsDict.Add(i+"",this.emsDO);
                    this.CiEmsDict.Add(i+"",this.dto);
                    ciControlNameDict.Add(i + "", SheetName);
                }

                // 处理多医疗单显示
                emsIndexAndButtonArea.RenderVisable = true;
                emsIndexAndButtonArea.Dock = DockStyle.None;
                if (emsList.Count > 1) {
                    emsIndexAndButtonArea.DataSource = emsList;
                    emsIndexAndButtonArea.NameDict = ciControlNameDict;
                    emsIndexAndButtonArea.IndexRenderList[emsIndexAndButtonArea.IndexRenderList.Count - 1].Crossflag = false;
                    TMPrender = emsIndexAndButtonArea.IndexRenderList[emsIndexAndButtonArea.IndexRenderList.Count - 1];
                    emsIndexAndButtonArea.IndexRenderList[emsIndexAndButtonArea.IndexRenderList.Count - 1].Editflag = true;
                    this.emsDO = emsIndexAndButtonArea.IndexRenderList[emsIndexAndButtonArea.IndexRenderList.Count - 1].Ci.EmsHeadDO;
                    //this.splitContainer1.SplitterDistance = 427;
                    //splitContainer1.BottomWidth = 75;
                    emsIndexAndButtonArea.xapScrollBarPanel1.Invalidate();
                    this.splitContainer1.AddControl(emsIndexAndButtonArea, xap.cli.sdk.controls.ControlPosition.Bottom, 71);
                }
                else {
                    foreach (XRoundRender Pastrender in emsIndexAndButtonArea.IndexRenderList) {
                        emsIndexAndButtonArea.xapScrollBarPanel1.RemoveRender(Pastrender);
                    }
                    emsIndexAndButtonArea.IndexRenderList.Clear();
                    emsIndexAndButtonArea.RenderVisable = false;
                    //this.splitContainer1.SplitterDistance = 460;
                    splitContainer1.BottomWidth = 40;
                    emsIndexAndButtonArea.xapScrollBarPanel1.Invalidate();
                    this.splitContainer1.AddControl(emsIndexAndButtonArea, xap.cli.sdk.controls.ControlPosition.Bottom, 40);
                }
                //this.splitContainer1.Panel2.Controls.Add(orCom);
                //不要在这里注册，每次注册都会累加（位置调整到创建emsIndexAndButtonArea的位置，确保只创建一次 wzz）
                //emsIndexAndButtonArea.RounderClick += new MouseEventHandler(orCom_MouseClick);
                //emsIndexAndButtonArea.DeleteEvent += new EventHandler(orCom_deleteevent);
            }
        }

        /// <summary>
        /// 将服务或者医嘱上的数据设置到医疗单上
        /// </summary>
        /// <param name="e">具体的一条医嘱</param>
        /// <param name="dto">患者信息</param>
        private void SetEmsFromOrdOrSrv(Object e, Ent4BannerDTO dto) {
            this.bannerDto = dto;
            this.orDataBing.patDo = dto;
            this.emsDO = cof.CreatEmsIntance();
            this.emsDO.PatInfo = dto;

            ClearCurrentEms();
          
            emsIndexAndButtonArea.RenderEnabled = true;

            // 服务选择
            if (e is EmsOrSrvSc)//这是新增
            {
                status = DOStatus.NEW;
                MedSrvDO med = (e as EmsOrSrvSc).MedSrvDO;
                this.dto = cof.CreatEmsDTO();
                LoadOrderView(med.Sd_srvtp, med);
                if (emsIndexAndButtonArea != null) {
                    emsIndexAndButtonArea.RenderEnabled = true;
                }
            }
            else if (e is RegularOrRelSrvDO) //医嘱助手 常用模板348112
            {
                status = DOStatus.NEW;
                String id_srv = (e as RegularOrRelSrvDO).Id_srv;
                MedSrvDO med = this.dtoSaveViewModel.getMedSrvDO(id_srv);
                this.dto = cof.CreatEmsDTO();
                LoadOrderView(med.Sd_srvtp, med);
                if (emsIndexAndButtonArea != null) {
                    emsIndexAndButtonArea.RenderEnabled = true;
                }
            }
            else if (e is EntHisDiDTO) {
                //医嘱助手 患者既往
                status = DOStatus.NEW;
                String id_srv = (e as RegularOrRelSrvDO).Id_srv;
                MedSrvDO med = this.dtoSaveViewModel.getMedSrvDO(id_srv);
                this.dto = cof.CreatEmsDTO();
                LoadOrderView(med.Sd_srvtp, med);
                if (emsIndexAndButtonArea != null) {
                    emsIndexAndButtonArea.RenderEnabled = true;
                }
            }
            else if (e is OrTplItmDtDO) {
                //医嘱助手 协定处方
                status = DOStatus.NEW;
                string id_srv = (e as OrTplItmDtDO).Id_srv;
                MedSrvDO med = this.dtoSaveViewModel.getMedSrvDO(id_srv);
                this.dto = cof.CreatEmsDTO();
                LoadOrderView(med.Sd_srvtp, med);
                if (emsIndexAndButtonArea != null) {
                    emsIndexAndButtonArea.RenderEnabled = true;
                }
            }
            else if (e is SrvortplitemAggDO) {
                //医嘱助手 医嘱模板
                status = DOStatus.NEW;

                MedSrvDO med = new MedSrvDO();
                this.dto = cof.CreatEmsDTO();
                LoadOrderView(med.Sd_srvtp, med);

                if (emsIndexAndButtonArea != null) {
                    emsIndexAndButtonArea.RenderEnabled = true;
                }

            }
            else if (e is MedSrvDO) {
                // 医嘱助手 分类选取？
                status = DOStatus.NEW;
                MedSrvDO med = e as MedSrvDO;
                this.dto = cof.CreatEmsDTO();
                LoadOrderView(med.Sd_srvtp, med);
                if (emsIndexAndButtonArea != null) {
                    emsIndexAndButtonArea.RenderEnabled = true;
                }
            }

            else if (e is CiOrderDO) //已经存在要进行修改
            {
                status = DOStatus.UPDATED;
                CiOrderDO ciDO = e as CiOrderDO;
                if (orderDataFromStr == "patipast" && ciDO != null) {
                    ciDO.Sd_su_or = "0"; //既往数据可以编辑
                }
                ciorderDO = ciDO;
                emsDO.SetUpdated();
                CiEmsDTO ciEmsDTO = this.model.getCiEmsDTO(ciDO.Id_or);

                this.dto = ciEmsDTO;
                this.dto.SetUpdated();
                emsDO.PatInfo = bannerDto;
                emsDO.Funcclassstr = this.dto.Funcclassstr;
                emsDO.Id_srvof = this.dto.Id_srvof;
                MedSrvDO med = new MedSrvDO();
                med.Id_srv = this.dto.Id_srv;
                med.Sd_srvtp = this.dto.Sd_srvtp;
                this.dto.Name = this.dto.Name;
                LoadOrderView(ciDO.Sd_srvtp, med);
                SheetName = ciDO.Name_or;
                //viewEditState是通过患者的状态判断得到，当viewEditState为false，医疗单不可编辑；当viewEditState为True，通过医嘱的状态判断医疗单是否可编辑；
                currentEmsControl.IsReadOnly = this.viewEditState == true ? !(ciDO.Sd_su_or == "0") : this.viewEditState;
                //ci.IsReadOnly = !(ciDO.Sd_su_or == "0"); //只有开立的可以修改
                if (emsIndexAndButtonArea != null) {
                    if (ciDO.Sd_su_or != null && ciDO.Sd_su_or != "0") {
                        emsIndexAndButtonArea.RenderEnabled = false;
                    }
                    else {
                        emsIndexAndButtonArea.RenderEnabled = true;
                    }
                }
            }

            if (emsDO != null) {
                ciControl = new Dictionary<CiorderBaseControl, Object>();

                ////ciControl.Add(ci, cardName);
                ////ssci.Enabled = this.bEnabled;
                ////if (!this.CiFlag)
                ////{
                ////    this.splitContainer1.Panel1.Controls.Add(ci);
                ////    this.CiFlag = true;
                ////}

                //emsDO.IsOpData = false;
                //if (orderItemView != null)
                //    orderItemView.SetTabText(currentEmsControl.SheetName);
                //emsDO.PatInfo = dto;
                //currentEmsControl.OnRefreshData(emsDO, this.dto);//数据传递给 医嘱表单
                ////为医疗单传Context对象
                //currentEmsControl.Context = this.Context;
                //currentEmsControl.EmsHeadDO = emsDO;
                //currentEmsControl.CiEmsDTO = this.dto;
                //ciControl.Add(currentEmsControl, SheetName);
                //currentEmsControl.Dock = DockStyle.None;
                //this.splitContainer1.AddControl(currentEmsControl, xap.cli.sdk.controls.ControlPosition.Center);

                emsDO.IsOpData = false;
                if (orderItemView != null)
                    orderItemView.SetTabText(currentEmsControl.SheetName);
                emsDO.PatInfo = dto;
                currentEmsControl.OnRefreshData(emsDO, this.dto);//数据传递给 医嘱表单
                //为医疗单传Context对象
                currentEmsControl.Context = this.Context;
                currentEmsControl.EmsHeadDO = emsDO;
                currentEmsControl.CiEmsDTO = this.dto;
                ciControl.Add(currentEmsControl, emsDO);
                currentEmsControl.Dock = DockStyle.None;
                this.splitContainer1.AddControl(currentEmsControl, xap.cli.sdk.controls.ControlPosition.Center);

            }
            else {
                emsIndexAndButtonArea.RenderEnabled = false;
            }
        }


        /// <summary>
        /// 加载医嘱对应的医疗单视图
        /// </summary>
        /// <param name="srvTp">服务类型</param>
        /// <param name="med"></param>
        private void LoadOrderView(string srvTp, MedSrvDO med)
        {
            if (srvTp.Length < 4)
            {
                this.ShowInfo(string.Format("服务类型有误长度不足4位！目前是{0},请检查", srvTp));
                return;
            }
            //  20190919的优化   把创建过的对象放到一个字典中，每次用时候  去集合判断 存在直接取用 
            string ctlKey = "";
            switch (srvTp.Substring(0, 2))
            {

                case "01": //药品 
                    switch (srvTp.Substring(2, 2))
                    {
                        case "01": //西药
                        case "02":
                            switch (srvTp.Substring(4))
                            {
                                case "03":
                                case "04"://注射类
                                    currentEmsControl = new OpOrderInfusionView() { Dock = DockStyle.Fill };
                                    emsDO.EmsType = EmsType.IV;
                                    break;
                                default://口服类
                                    currentEmsControl = new OpOrderDrugsView() { Dock = DockStyle.Fill };
                                    emsDO.EmsType = EmsType.COMMONDRUG;
                                    break;
                            }
                            break;

                        case "03"://草药
                            currentEmsControl = new OpOrderHerbsView() { Dock = DockStyle.Fill };
                            emsDO.EmsType = EmsType.HERB;
                            break;
                    }
                    if (status == DOStatus.NEW)
                    {
                        emsDO.MedSrvDO = med;
                        orDataBing.AddDrugDataBing(emsDO, med);//绑定药品带过来的数据//自定义服务和非自定义服务列表数据绑定的值不同
                        if (med.Fg_ctm == null || med.Fg_ctm == false)//非自定义服务
                        {
                            emsDO.Emsdrugs.EmsOrDrug = cof.GetSrvMm(emsDO, med.Id_srv, emsDO.PatInfo.Code_entp);// 
                            emsDO.Emsdrugs.EmsOrDrug = cof.MmSortList(emsDO.Emsdrugs.EmsOrDrug);
                            if (emsDO.Emsdrugs.EmsOrDrug.Count > 0)
                            {//每次将关联药品的第一条插入到 药品列表
                                emsDO.Emsdrugs.EmsOrDrugList.Add(cof.DoCopy(emsDO.Emsdrugs.EmsOrDrug.First()));
                            }
                            if (emsDO.Emsdrugs.EmsOrDrug.Count == 1 && string.IsNullOrEmpty(emsDO.Emsdrugs.EmsOrDrug[0].Id_mm))
                            {
                                this.ShowInfo(emsDO.Emsdrugs.EmsOrDrug[0].Name_srv + "编码" + emsDO.Emsdrugs.EmsOrDrug[0].Code_srv + "未绑定物品，请与信息科联系!", "提示");
                                this.emsDO = null;
                                return;
                            }
                        }
                        else
                        {
                            EmsOrDrug customSrv = new EmsOrDrug();
                            customSrv.Name_srv = med.Name;
                            customSrv.Fg_mm = false;
                            customSrv.Fg_ctm = true;
                            customSrv.Id_srv = med.Id_srv;
                            customSrv.Id_srvtp = med.Id_srvtp;
                            customSrv.Sd_srvtp = med.Sd_srvtp;
                            customSrv.Fg_self = true;
                            customSrv.Id_unit_med = med.Id_unit_med;
                            customSrv.Name_unit_med = med.Med_name;
                            customSrv.Quan_med = med.Quan_med;
                            emsDO.Emsdrugs.EmsOrDrugList.Add(customSrv);
                        }
                    }
                    else
                    {
                        orCiEmsToUiEms.EditDrug(dto, emsDO);
                    }
                    cof.concateExtNote(emsDO.Emsdrugs.EmsOrDrugList, this.bannerDto, emsDO);

                    break;

                case "02"://检查属性
                    //emsDO = cof.CreatEmsIntance();

                    emsDO.PatInfo = bannerDto;
                    emsDO.EmsType = EmsType.RIS;
                    ctlKey = srvTp + "obs";

                    if (status == DOStatus.NEW)
                    {
                        emsDO.PatInfo = bannerDto;
                        orDataBing.AddCommonHeadDataBing(emsDO, med);
                        obslab.AddObsLoadData(emsDO, med);


                    }
                    else
                    {
                        //orDataBing.EditObsDataBing(emsDO, dto);//检查对照
                        //emsDO.Emsapobs.EmsOrDrugList.Clear();//检查药品绑定
                        //emsDO.Emsapobs.EmsOrDrugList = cof.GetOrdMm(emsDO, string.Join("','", agg.getOrdSrvDO().Select(p => p.Id_orsrv)));
                        emsDO.Emsapobs.EmsOrDrugList.Clear();//检查药品绑定
                        orCiEmsToUiEms.EditEmsObs(emsDO, dto);
                    }
                    //if(ci==null)
                    this.currentEmsControl = new OpOrderApobsView() { Dock = DockStyle.Fill };
                    break;
                case "03"://检验属性
                    //emsDO = cof.CreatEmsIntance();
                    emsDO.PatInfo = bannerDto;

                    ctlKey = srvTp + "lab";
                    emsDO.EmsType = EmsType.LIS;
                    if (status == DOStatus.NEW)
                    {
                        emsDO.PatInfo = bannerDto;
                        //医嘱信息 
                        orDataBing.AddCommonHeadDataBing(emsDO, med);
                        //检验属性和 检验的项目 

                        obslab.AddLabLoadData(emsDO, med);
                        //（服务套）

                    }
                    else
                    {
                        //
                        //orDataBing.EditLabDataBing(emsDO, agg);
                        // emsDO.Emsaplab.EmsOrDrugList.Clear();//检查药品绑定

                    }
                    // if(ci==null)
                    this.currentEmsControl = new OpOrderAplabView() { Dock = DockStyle.Fill };
                    break;
                case "04": //手术属性
                    //LoadOrderView2(srvTp, dto, med);

                    switch (srvTp.Substring(2, 2))
                    {
                        case "01":
                            break;


                        default:
                            break;
                    }
                    ctlKey = srvTp + "oper";
                    if (status == DOStatus.NEW)
                    {
                        //emsDO = cof.CreatEmsIntance();
                        //公共信息
                        orDataBing.AddCommonHeadDataBing(emsDO, med);
                        //绑定表单数据
                        orDataBing.AddOpDataBing(emsDO, med);
                        //手术前检查指标数据
                        //emsDO.Emsapop.OpLabItem = cof.GetBtLabItme(med.Id_srv);//获取术前检验项目


                        //EmsItemInOp item = new EmsItemInOp();
                        //item.Id_mmtp = "0001AA1000000000ELL6";
                        //item.Name_mmtp = "物品类型";
                        //emsDO.Emsapop.OpMmItem.Add(item);

                    }
                    else
                    {
                        orCiEmsToUiEms.EditApop(emsDO, dto);

                        //  orDataBing.EditHeadDataBing(emsDO, agg);
                        // orDataBing.EditOpDataBing(emsDO, agg);//表单

                        //  orDataBing.EditOpEmpDataBing(emsDO, agg);//手术人员

                        //  orDataBing.EditOpMmDataBing(emsDO, agg);//手术卫材
                    }


                    emsDO.EmsType = EmsType.OPER;
                    // if(ci==null)    
                    this.currentEmsControl = new OrderOpView() { Dock = DockStyle.Fill };
                    break;
                case "14": //血液属性
                    switch (srvTp.Substring(4, 2))
                    {

                        //140101 血液制品
                        //140102 用血
                        case "01"://输血 备血

                            if (status == DOStatus.NEW)
                            {
                                //emsDO = cof.CreatEmsIntance();
                                orDataBing.AddCommonHeadDataBing(emsDO, med);
                                orDataBing.AddBtDataBing(emsDO, med);
                                //emsDO.Emsapbt.BtLabItem = cof.GetBtLabItme(med.Id_srv);//获取输血前检验项目
                            }
                            else
                            {
                                orDataBing.editApbtDataBiding(emsDO, dto);
                            }
                            emsDO.EmsType = EmsType.BT;
                            // if(ci==null)
                            this.currentEmsControl = new OrderApbtView() { Dock = DockStyle.Fill };
                            break;

                        case "02"://用血
                            if (status == DOStatus.NEW)
                            {
                                orDataBing.AddCommonHeadDataBing(emsDO, med);
                            }
                            else
                            {
                                OrdAppBtUseDO odp = dto.Orapplysheet[((int)EmsType.BTUSE).ToString()] as OrdAppBtUseDO;
                                FArrayList li = dto.Emssrvs;
                                CiEmsSrvDTO srvDto = li[0] as CiEmsSrvDTO;
                                if (odp != null)
                                {
                                    emsDO.CiordubDTO = new CiordubDTO();
                                    emsDO.CiordubDTO.No_applyform_ub = odp.No_applyform;
                                    emsDO.CiordubDTO.Dt_bu_pl_ub = odp.Dt_bu_plan;
                                    //emsDO.CiordubDTO.Applyform=odp.
                                    emsDO.CiordubDTO.Orsrvname = dto.Name;
                                    emsDO.CiordubDTO.Id_srv = dto.Id_srv;
                                    emsDO.CiordubDTO.Name_unit = srvDto.Name_unit_med;
                                    emsDO.CiordubDTO.Quan_medu_ub = srvDto.Quan_med;
                                    emsDO.CiordubDTO.Id_route = dto.Id_route;
                                    emsDO.CiordubDTO.Name_route = dto.Name_route;
                                    emsDO.CiordubDTO.Status = DOStatus.UPDATED;
                                    emsDO.CiordubDTO.Id_apbu = odp.Id_apbu;
                                    emsDO.CiordubDTO.Name_emp_create = dto.Name_emp_phy;
                                    emsDO.CiordubDTO.Id_emp_create = dto.Id_emp_phy;
                                    emsDO.CiordubDTO.Id_or_rel = dto.Id_or_rel;
                                }

                            }
                            emsDO.EmsType = EmsType.BTUSE;
                            //if(ci==null)
                            this.currentEmsControl = new OrdApBuView() { Dock = DockStyle.Fill };
                            break;
                    }
                    break;
                default:
                    break;
            }
            emsDO.MedSrvDO = med;
        }

        /// <summary>
        /// 分析医嘱数据的来源
        /// </summary>
        /// <param name="dataList"></param>
        private void ParseOrderDataFrom(List<object> dataList) {
            this.orderDataFromStr = dataList[0] as String; //第一位代表数据来源
            if (orderDataFromStr != null && orderDataFromStr == "cp") {
                this.orderDataFrom = (int) OrSrvSourceFromEnum.CP;
            }
        }

        #endregion

        #region 事件处理函数

        /// <summary>
        /// 关闭某个医疗单
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void orCom_deleteevent(object sender, EventArgs e) {
            //处理
            List<XRoundRender> list = new List<XRoundRender>();
            XRoundRender activeRender = null ; 
            foreach (XRoundRender render in  emsIndexAndButtonArea.IndexRenderList)
            {
                if (!render.Editflag)
                {
                    list.Add(render);
                }
                else
                {
                    activeRender = render;
                    emsIndexAndButtonArea.xapScrollBarPanel1.RemoveRender(render); //只有处于编辑状态的是激活的，删除的也是这个
                }
            }
            //按钮区已删除，处理上边对应的view区域
            if (activeRender!=null)
            {
                XRoundRender nextRender = GetNextActiveRender(activeRender);
                if (nextRender == null)
                {
                    emsDO = null;
                    this.splitContainer1.RemoveRender(this.EmsIndexAndButtonArea); //清除“确认”、“取消”按钮
                    this.tabNaviControl.CanShowForm = false;
                    this.ClearEmsList(); //清空数据
                    this.tabNaviControl.TabNavigationForm.Close(); //关闭右缩面板
                }
                else
                {
                    nextRender.Editflag = true;
                    this.emsDO = nextRender.Ci.EmsHeadDO;
                    this.dto = nextRender.Ci.CiEmsDTO;
                    nextRender.Ci.Dock = DockStyle.None;
                    TMPrender = nextRender;
                    currentEmsControl = nextRender.Ci;
                    orderItemView.SetTabText(currentEmsControl.SheetName);
                    this.splitContainer1.AddControl(nextRender.Ci, xap.cli.sdk.controls.ControlPosition.Center);
                }
            }
            emsIndexAndButtonArea.IndexRenderList = list; //zzj，最好能直接删除，不要这样直接替换，能够节约内存
            emsIndexAndButtonArea.xapScrollBarPanel1.Invalidate();
        }

        /// <summary>
        /// 获取下一个医疗单
        /// </summary>
        /// <param name="render"></param>
        /// <returns></returns>
        private XRoundRender GetNextActiveRender(XRoundRender render)
        {
            //获取当前关闭对像的索引
            int index = emsIndexAndButtonArea.IndexRenderList.IndexOf(render);

            XRoundRender nextRender;
            if (index < 0)
            {
                return null;
            }
            else if (index == 0)
            {
                if (emsIndexAndButtonArea.IndexRenderList.Count > 1)
                {
                    nextRender = emsIndexAndButtonArea.IndexRenderList[1];
                }
                else
                {
                    return null;
                }
            }
            else
            {
                if (index + 1 < emsIndexAndButtonArea.IndexRenderList.Count)
                {
                    //先往后寻找，找到了直接是后面的
                    nextRender = emsIndexAndButtonArea.IndexRenderList[index + 1];
                }
                else
                {
                    //后面没有了，往前定位
                    if (index - 1 == 0)
                    {
                        //没有前面的直接定位到0
                        nextRender = emsIndexAndButtonArea.IndexRenderList[0];
                    }
                    else
                    {
                        nextRender = emsIndexAndButtonArea.IndexRenderList[index - 1];
                    }
                }
            }
            return nextRender;
        }

        /// <summary>
        /// 单击多医疗单情况下的底下的索引序号
        /// </summary>
        /// <param name="sender">点的是哪个序号的控件</param>
        /// <param name="e"></param>
        private void orCom_MouseClick(object sender, MouseEventArgs e) {
            if (TMPrender != null) {
                TMPrender.Invalidate();
            }
            //splitContainer1.Panel1.Controls.Clear();

            XRoundRender render = sender as XRoundRender;
            //做校验的地方
            foreach (XRoundRender Pastrender in emsIndexAndButtonArea.IndexRenderList) {
                if (Pastrender.Equals(render)) {
                    Pastrender.Crossflag = false;
                    Pastrender.Editflag = true;
                     //currentEmsControl.OnRefreshData(this.UiEmsDict[Pastrender.ID] as EmsUIDTO, this.UiEmsDict[Pastrender.ID] as CiEmsDTO);
                    Pastrender.Ci.EmsHeadDO = this.UiEmsDict[Pastrender.ID] as EmsUIDTO;
                    Pastrender.Ci.CiEmsDTO = this.CiEmsDict[Pastrender.ID] as CiEmsDTO;

                    this.emsDO = Pastrender.Ci.EmsHeadDO;
                    this.dto = Pastrender.Ci.CiEmsDTO;
                    //this.splitContainer1.Panel1.Controls.Add(render.Ci);
                    render.Ci.Dock = DockStyle.None;
                    currentEmsControl = Pastrender.Ci;
                    //界面更换完毕后要刷新界面，否则数据无法显示
                    currentEmsControl.OnRefreshData(this.UiEmsDict[Pastrender.ID] as EmsUIDTO, this.CiEmsDict[Pastrender.ID] as CiEmsDTO);
                    orderItemView.SetTabText(currentEmsControl.SheetName);
                    this.splitContainer1.AddControl(Pastrender.Ci, xap.cli.sdk.controls.ControlPosition.Center);
                }
                else {
                   if(Pastrender.Editflag)
                    Pastrender.Editflag = false;
                }
               // TMPrender = render; //zzj:这句没必要放循环里，因为每次都是一样的          
            }
            TMPrender = render; //zzj:这句没必要放循环里，因为每次都是一样的
        }
        #endregion

        #region 父类覆写函数

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public override void OnSelected(object sender, xap.rui.control.basecontrol.TargetEventArgs e) {
            if (e.Object is Ent4BannerDTO) {
                Ent4BannerDTO VisitDO = ((Ent4BannerDTO)e.Object);
                this.bannerDto.Id_ent = VisitDO.Id_ent;
                this.bannerDto.Id_pat = VisitDO.Id_pat;
                //this.LoadData();
            }
            else if (e.Object is PatiVisitDO) {
                this.bannerDto = ((Ent4BannerDTO)e.Object);
            }
        }

        #endregion

        #region 辅助处理函数

        /// <summary>
        /// 保存CI, 并切换到下一个CI
        /// </summary>
        public void ClearCurrentEms() {
            bool deleateflag = false;
            int deleateindex = -1;
            //emsDO = null;// 不能在这里面，因为会影响草药
            if (currentEmsControl != null) {
                splitContainer1.RemoveRender(currentEmsControl);
                for (int index = 0; index < emsIndexAndButtonArea.IndexRenderList.Count; index++) {
                    if (deleateflag) {
                        if (index == deleateindex) {
                            emsIndexAndButtonArea.IndexRenderList[index].Crossflag = false;
                            emsIndexAndButtonArea.IndexRenderList[index].Editflag = true;
                            this.emsDO = emsIndexAndButtonArea.IndexRenderList[index].Ci.EmsHeadDO;
                            this.dto = emsIndexAndButtonArea.IndexRenderList[index].Ci.CiEmsDTO;
                            //this.splitContainer1.Panel1.Controls.Add(render.Ci);
                            emsIndexAndButtonArea.IndexRenderList[index].Ci.Dock = DockStyle.None;
                            emsIndexAndButtonArea.IndexRenderList[index].Location = TMPrender.Location;
                            TMPrender = emsIndexAndButtonArea.IndexRenderList[index];
                            currentEmsControl = emsIndexAndButtonArea.IndexRenderList[index].Ci;
                            this.splitContainer1.AddControl(emsIndexAndButtonArea.IndexRenderList[index].Ci, xap.cli.sdk.controls.ControlPosition.Center);
                        }
                        else {
                            emsIndexAndButtonArea.IndexRenderList[index].Location = new Point(emsIndexAndButtonArea.IndexRenderList[index - 1].Location.X + 40, emsIndexAndButtonArea.IndexRenderList[index - 1].Location.Y);
                        }
                        emsIndexAndButtonArea.IndexRenderList[index].Invalidate();
                    }
                    else if (emsIndexAndButtonArea.IndexRenderList[index].Editflag) {
                        this.emsList.Remove(emsIndexAndButtonArea.IndexRenderList[index].ID);
                        emsIndexAndButtonArea.xapScrollBarPanel1.RemoveRender(emsIndexAndButtonArea.IndexRenderList[index]);
                        TMPrender = emsIndexAndButtonArea.IndexRenderList[index];
                        emsIndexAndButtonArea.IndexRenderList.Remove(emsIndexAndButtonArea.IndexRenderList[index]);
                        deleateflag = true;
                        deleateindex = index--;
                    }
                }
                emsIndexAndButtonArea.xapScrollBarPanel1.Invalidate();
            }
            GC.Collect();
        }

        /// <summary>
        /// 医疗单的容器控件上，点击确定后的响应函数
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void orCom_SaveClickEvent(object sender, EventArgs e) {
            Save();
        }

        /// <summary>
        /// 医疗单的容器控件上，点击取消后的响应函数
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void orCom_CancelClickEvent(object sender, EventArgs e) {
            ClearCurrentEms();
            emsDO = null;
            this.tabNaviControl.CanShowForm = false;
            DictionaryEventArgs dic = new DictionaryEventArgs();
            dic.Data[UIConst.UI_EVENT] = UIEvent.CANCEL;
            this.FireEventSent(this, dic);
        }


        /// <summary>
        /// 保存医嘱
        /// </summary>
        public void Save() {
            OrderDataVerify ver = new OrderDataVerify();
            currentEmsControl.OrdErrorList.Clear();
            currentEmsControl.SaveBefore();
            ver.OrdValidateMustInput(currentEmsControl);//必填项
            ver.OrdBPValidate(emsDO, currentEmsControl);//业务

            if (currentEmsControl.OrdErrorList.Count == 0) {
                CiOrderDO ciorder = dtoSaveViewModel.SaveDTO(emsDO, dto, orderDataFrom);//1保存
                if (ciorder == null) return;
                SendMgs(ciorder.Id_or);//2发消息
                emsDO = null;//清空对象
                ClearCurrentEms();//3清表单

            }
            else {
                string strErr = "";
                currentEmsControl.OrdErrorList.ForEach(
                    p => { strErr += string.Format("{0}.{1}\n", currentEmsControl.OrdErrorList.IndexOf(p) + 1, p); });
                string errInfo = " 验证失败，操作取消！\n" + strErr;
                //cof.OrVoice(errInfo);
                this.ShowInfo(errInfo, "提示:");
            }
        }
        #endregion

        #region 状态处理区域
        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="eventArgs"></param>
        public override void HandleState(object sender, DictionaryEventArgs eventArgs) {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent) {
                case UIEvent.LOAD:

                    Dictionary<string, object> dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    if (dic != null) {
                        //if (dic.Keys.Contains("PatientData"))
                        //{
                        //    patDo = dic["PatientData"] as Ent4BannerDTO;
                        //    orDataBing.patDo = patDo;
                        //}
                        //if (dic.Keys.Contains("EncounterID"))
                        //{
                        //    patDo.Id_ent = dic["EncounterID"].ToString();
                        //    patDo.Code_entp = "01";
                        //}
                    }
                    break;

                case UIEvent.SAVE_SUCCESS:
                    this.LoadData();
                    break;
                case "ID_EVENT":
                    Dictionary<string, object> dics = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    string Id_srv = null;
                    //目前先这样写 因为Values有且有一个值
                    foreach (var values in dics.Values) {
                        Id_srv = values.ToString();
                    }

                    this.SetEmsFromOrdOrSrv(this.model.getEmsOrSrvScID(Id_srv), this.bannerDto);
                    break;
                //case UIEvent.PRINT:
                //    // this.OnPrint();
                //    break;
                //case UIEvent.ADD:
                //    //this.OnAdd();
                //    break;
                //case UIEvent.DELETE:
                //    //this.Delete();
                //    break;
                //case UIEvent.DISABLE:
                //    // this.UpdateActivestate(ActiveStateEnum.STOP);
                //    break;
                //case UIEvent.ENABLE:
                //    //this.UpdateActivestate(ActiveStateEnum.ACTIVE);
                //    break;
                default:
                    break;
            }
        }
        #endregion

        #region 医嘱注册处理
        public void Regist(EventBroker eventBroker) {
            eventBroker.Register(this);
        }
        public void UnRegist(EventBroker eventBroker) {
            eventBroker.Unregister(this);
        }
        public void UpdatePatientInfo(object sender, DictionaryEventArgs eventArgs) {

        }
        #endregion

        #region 药物皮试判断是否能开立医疗单

        private int? drugSkinTestLogic(XapDataList<EmsOrDrug> drugs)
        {
                //服务对应的物品中是否存在皮试物品，是皮试物品且为禁用时，切换到下一个物品
                for (int i = 0; drugs != null && i < drugs.Count; i++)
                {
                    EmsOrDrug skinDrug = drugs[i];
                    if (i == 0 && (skinDrug.Fg_skintest == null || skinDrug.Fg_skintest == false))
                    {
                        return 0;
                    }
                    else if (skinDrug.Fg_skintest == true)
                    {
                        SkinTestParamDTO param = new SkinTestParamDTO();
                        param.Id_mm = skinDrug.Id_mm;
                        param.Id_org = this.Context.Org.Id_org;
                        param.Id_pi = this.bannerDto.Id_pat;
                        param.Dt_birth = DateTime.Parse(this.bannerDto.Dt_birth);
                        param.Id_srv = emsDO.Emsdrugs.Id_srv;
                        param.Id_skinsrv = skinDrug.Id_srvskin;
                        try
                        {
                            SkinTestRstDTO retDTO = this.orderCardViewModel.skinTestLogic(param);
                            string code = retDTO.Allergicpharmhandlemode.ToString();
                            if (code.Equals("0") && (i == emsDO.Emsdrugs.EmsOrDrug.Count - 1))
                            {
                                this.ShowInfo("用药医嘱时，患者存在该药品过敏史并禁用该药异常！");
                                return null;
                            }
                        }
                        catch (Exception ex)
                        {
                            throw ex;
                        }
                        return i;
                    }
                }
                return null;
        }
        
        #endregion

        #region 其他

        #region Windows-API本地调用声明
        [DllImport("user32.dll", EntryPoint = "keybd_event")]
        public static extern void keybd_event(
        byte bVk,
        byte bScan,
        int dwFlags,
        int dwExtraInfo
        );
        #endregion

        #region 事件发送区域
        public void SendMgs(string id_or) {
            Dictionary<string, object> param = new Dictionary<string, object>();
            DictionaryEventArgs dic = new DictionaryEventArgs();
            dic.Data[UIConst.UI_EVENT] = UIEvent.SAVE_SUCCESS;
            param.Add("ID_OR", id_or);
            dic.Data.Add(UIConst.DATA, param);
            //this.EventSent(this, dic);
            this.FireEventSent(this, dic);
            //cof.OrVoice("保存成功！");
        }
        #endregion

        #region 服务类型说明
        /*	　	　	　	　
030000 服务类型定义
	　	　	　	　
	　	　	　	　
01  药品	
        0101 西药
                    010199  其它
                    010101  口服类药品
                    010102  外用药
                    010103  注射类药品
                    010104  溶媒
                    010105  皮试液
        0102 成药
                   010201 中成药
                   010202 蒙成药
        0103 草药    
                   010301 中药材
                   010302 蒙药材 

   
02 检查	　
        0299   其它	
        0201   透视　	　
        0202   X线        
        0203   CT
        0204  核磁
        0205   导管介入
        0206   B超
        0207   病理
        0208   电生理
        0209   内镜
        0210 功能性检查（如肺活量）
        0211 核医学

03 检验
        0399 其它
        0301 常规检验
        0302 生化检验
        0303 免疫检验
        0304 微生物检验
        0305  皮肤敏感性试验

04 手术
       0401 台次手术
       0402 床边手术
      	　
05 治疗
       0501 普通治疗
       0502  放疗
       0503  吸氧
       0504  雾化吸入
       0505 膳食(包括肠内外营养)      
	　	　	　
06 护理
       0601 护理等级
       0602 治疗性护理
       0603 生命体征
	　	　
07 卫材
       0701 卫生材料
	　	　	　
08 嘱托
       0801 嘱托
       0802 宣教

09 诊疗
    0901 门急诊诊疗
             090101 专家
             090102 普通
             090103 急诊
     0902 会诊与跨科

10 健康
     1001 基本公共卫生服务
     1002 公共卫生管理

11 诊疗方案服务包 
    1101 体检包
    1199 其它

12 患者管理类
     1201 转科床
      1202 出院
      1203 宣布临床死亡
      1204取消出院

13 固定费用类
      1301 住院固定收费

14 血液制品
      1401 血液制品
      1402 血液代用品

99 其他	　
      9901 其他


         * 
         */
        #endregion 
        #endregion

    

    }
}

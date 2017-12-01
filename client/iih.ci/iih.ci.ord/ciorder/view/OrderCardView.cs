using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using iih.ci.ord.ciorder.cards;
using iih.ci.ord.dto.d;
using xap.rui.engine;
using iih.ci.ord.ciorder.viewmodel;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.cior.d;
using xap.mw.core.data;
using iih.bd.srv.medsrv.d;
using iih.en.pv.pativisit.d;
using iih.ci.ord.ciorder.utils;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;
using iih.ci.ord.ciorder.render;
using iih.ci.ord.ems.d;
using iih.bd.srv.ortpl.d;
using iih.en.pv.dto.d;
using xap.rui.control.extentions;
using System.Drawing;
using System.Speech.Synthesis;
using System.Runtime.InteropServices;
using iih.bd.srv.ems.d;
using xap.cli.sdk.controls.navbar;
using iih.bd.fc.orwf.d;
using iih.ci.ord.emsdi.d;
using xap.mw.serviceframework;
using iih.ci.ord.i;
using xap.rui.appfw;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.bd.srv.medsrv.i;
using iih.ci.ord.ciorder.cards.thread;
using xap.mw.coreitf.d;
using iih.ci.ord.common.utils;
using iih.ci.ord.cior.i;
using iih.ci.ord.common.utils.msg;
using iih.ci.ord.opemergency.tool;

namespace iih.ci.ord.ciorder.view {
    /// <summary>
    /// 医疗单卡片视图类
    /// zhou_zhijian 7.3做阅读注释
    /// </summary>
    public partial class OrderCardView : CiorderBaseControl, IWorkStationRegist {

        #region 成员变量
        /// <summary>
        /// 当前的多医疗单情况下的索引数字控件
        /// </summary>
        private XRoundRender TMPrender;

        /// <summary>
        /// 代表当前展示的医疗单视图
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
        //private EmsUIDTO emsDO;
        /// <summary>
        /// 新增的时候，该DTO是空的，当修改的时候该DTO就有值了。后台的医疗单的DTO
        /// 把这条医嘱关联的所有后台数据都拿过来了
        /// </summary>
        //private CiEmsDTO dto;
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
        private OrderItemView orderItemView;
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
        //private Dictionary<string, CiorderBaseControl> ctls = new Dictionary<string, CiorderBaseControl>();
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
        //本次就诊下的诊断信息
        private String[] diagNameAndCodeArray;
        #endregion

        #region 构造函数

        public OrderCardView() {
            InitializeComponent();

            //this.Padding = new Padding(4, 4, 4, 4);
        }

        #endregion

        #region 公共函数
        /// <summary>
        /// 设置上列表视图
        /// </summary>
        /// <param name="itemobj"></param>
        public void SetOrderItemView(OrderItemView itemobj) {
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
        public bool ManyRecordSheet(List<Object> dataList, Ent4BannerDTO patientsDto, TabNavigatorControl tabNaviControl) {
            Log.writelog("ManyRecordSheet 开始  进入医疗单");
           if (this.emsList != null && this.emsList.Count > 0)
            {
                if (!this.currentEmsControl.IsReadOnly) {
                    if (!this.IsContinue("提示", "还有医疗单处于打开状态是否继续！"))
                    {
                        return false;
                    }    
                }
                
            }
            this.bannerDto = patientsDto;
            this.diagNameAndCodeArray = orderCardViewModel.getDiagArray(this.bannerDto.Id_ent);
            this.emsList.Clear();
           this.ciControlNameDict.Clear();
            this.UiEmsDict.Clear();
            this.CiEmsDict.Clear();
            //this.ctls.Clear();
            this.emsIndexAndButtonArea.DataSource.Clear();
            //if (this.emsDO != null)
            //{
            //    this.emsDO.Emsdrugs.EmsOrDrugList.Clear();
            //}
          
            this.tabNaviControl = tabNaviControl;
            if (dataList != null && dataList.Count > 0 && patientsDto != null)
            {
                ParseOrderDataFrom(dataList);

                for (int i = 1; i < dataList.Count; ++i)
                {
                    // 默认医疗单
                    if (!this.SetEmsFromOrdOrSrv(dataList[i], patientsDto)) continue;
                    emsList.Add(i + "", ciControl);
                    this.UiEmsDict.Add(i + "", this.currentEmsControl.EmsHeadDO);
                    this.CiEmsDict.Add(i + "", this.currentEmsControl.CiEmsDTO);
                    ciControlNameDict.Add(i + "", SheetName);
                }
                if (emsList.Count == 0) return false;
                this.tabNaviControl.NavTabControl.Refresh();
                // 处理多医疗单显示
                emsIndexAndButtonArea.RenderVisable = true;
                emsIndexAndButtonArea.Dock = DockStyle.None;
                if (emsList.Count > 1)
                {
                    emsIndexAndButtonArea.DataSource = emsList;
                    emsIndexAndButtonArea.NameDict = ciControlNameDict;
                    emsIndexAndButtonArea.IndexRenderList[emsIndexAndButtonArea.IndexRenderList.Count - 1].Crossflag = false;
                    TMPrender = emsIndexAndButtonArea.IndexRenderList[emsIndexAndButtonArea.IndexRenderList.Count - 1];
                    emsIndexAndButtonArea.IndexRenderList[emsIndexAndButtonArea.IndexRenderList.Count - 1].Editflag = true;
                    this.currentEmsControl.EmsHeadDO = emsIndexAndButtonArea.IndexRenderList[emsIndexAndButtonArea.IndexRenderList.Count - 1].Ci.EmsHeadDO;
                    //this.splitContainer1.SplitterDistance = 427;
                    //splitContainer1.BottomWidth = 75;
                    emsIndexAndButtonArea.xapScrollBarPanel1.Invalidate();
                    this.splitContainer1.AddControl(emsIndexAndButtonArea, xap.cli.sdk.controls.ControlPosition.Bottom, 71);
                }
                else
                {
                    foreach (XRoundRender Pastrender in emsIndexAndButtonArea.IndexRenderList)
                    {
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
                return true;
            }
            else {
                return false;
            }
            //Log.writelog("ManyRecordSheet 结束  进入医疗单");
        }

        /// <summary>
        /// 将服务或者医嘱上的数据设置到医疗单上
        /// </summary>
        /// <param name="e">具体的一条医嘱</param>
        /// <param name="dto">患者信息</param>
        private bool SetEmsFromOrdOrSrv(Object e, Ent4BannerDTO ent4bannerDto) {
            Log.writelog("SetEmsFromOrdOrSrv 方法 开始  将服务或者医嘱上的数据设置到医疗单上");
            this.orDataBing.patDo = ent4bannerDto;
            //this.emsDO = cof.CreatEmsIntance();
            //this.emsDO.PatInfo = ent4bannerDto;
            //this.emsDO.Fg_cp = ent4bannerDto.Def1;
            ClearCurrentEms();
          
            emsIndexAndButtonArea.RenderEnabled = true;
            //var diagNameAndCodeArray = orderCardViewModel.getDiagArray(ent4bannerDto.Id_ent);
            //this.emsDO.Str_name_di = diagNameAndCodeArray[0];
            //this.emsDO.Str_code_di = diagNameAndCodeArray[1];
            //this.emsDO.Str_id_diitm = diagNameAndCodeArray[2];
            //this.emsDO.Id_diitm = diagNameAndCodeArray[3];
           // this.emsDO.Fg_cp = true;
            // 服务选择
            if (e is EmsOrSrvSc)//这是新增
            {  

                status = DOStatus.NEW;
                MedSrvDO med = (e as EmsOrSrvSc).MedSrvDO;
                if (ent4bannerDto.Fg_newborn.Value && med.Sd_srvtp == "1201")
                {
                    this.ShowAlert("新生儿不能转科！");
                    return false;
                }
                //this.dto = cof.CreatEmsDTO();
                if(!getEmsControl(med))return false;
                if (!LoadOrderView(med.Sd_srvtp, med)) return false;
                if (emsIndexAndButtonArea != null) {
                    emsIndexAndButtonArea.RenderEnabled = true;
                }
            }
            else if (e is RegularOrRelSrvDO) //医嘱助手 常用模板348112
            {
                status = DOStatus.NEW;
                String id_srv = (e as RegularOrRelSrvDO).Id_srv;
                var med = this.dtoSaveViewModel.getMedSrvDO(id_srv);
                //this.dto = cof.CreatEmsDTO();
                if (!getEmsControl(med)) return false;
                if (!LoadOrderView(med.Sd_srvtp, med)) return false;
                if (emsIndexAndButtonArea != null) {
                    emsIndexAndButtonArea.RenderEnabled = true;
                }
            }
            else if (e is EntHisDiDTO) {
                //医嘱助手 患者既往
                status = DOStatus.NEW;
                String id_srv = (e as RegularOrRelSrvDO).Id_srv;
                var med = this.dtoSaveViewModel.getMedSrvDO(id_srv);
                //this.dto = cof.CreatEmsDTO();
                if (!getEmsControl(med)) return false;
                if (!LoadOrderView(med.Sd_srvtp, med)) return false;
                if (emsIndexAndButtonArea != null) {
                    emsIndexAndButtonArea.RenderEnabled = true;
                }
            }
            else if (e is OrTplItmDtDO) {
                //医嘱助手 协定处方
                status = DOStatus.NEW;
                string id_srv = (e as OrTplItmDtDO).Id_srv;
                var med = this.dtoSaveViewModel.getMedSrvDO(id_srv);
                //this.dto = cof.CreatEmsDTO();
                if (!getEmsControl(med)) return false;
                if (!LoadOrderView(med.Sd_srvtp, med)) return false;
                if (emsIndexAndButtonArea != null) {
                    emsIndexAndButtonArea.RenderEnabled = true;
                }
            }
            else if (e is SrvortplitemAggDO) {
                //医嘱助手 医嘱模板
                status = DOStatus.NEW;

                var med = new MedSrvDO();
                //this.dto = cof.CreatEmsDTO();
                if (!getEmsControl(med)) return false;
                if (!LoadOrderView(med.Sd_srvtp, med)) return false;

                if (emsIndexAndButtonArea != null) {
                    emsIndexAndButtonArea.RenderEnabled = true;
                }

            }
            else if (e is MedSrvDO) {
                // 医嘱助手 分类选取？
                status = DOStatus.NEW;
                var med = e as MedSrvDO;
                //this.dto = cof.CreatEmsDTO();
                if (!getEmsControl(med)) return false;
                if (!LoadOrderView(med.Sd_srvtp, med)) return false;
               
                //LoadDataView(med);
                //根据人员的状态，来处理页面的编辑状态
                viewEditState = cof.viewEditState8EntSd(bannerDto.Entpattp);
                if (emsIndexAndButtonArea != null) {
                    emsIndexAndButtonArea.RenderEnabled = true;
                }
            }

            else if (e is CiOrderDO) //已经存在要进行修改
            {
                Log.writelog("修改医嘱 方法 开始  " );
                status = DOStatus.UPDATED;
                var ciDO = e as CiOrderDO;
                if (orderDataFromStr == "patipast" && ciDO != null) {
                    ciDO.Sd_su_or = "0"; //既往数据可以编辑
                }
                var med = getMedSrvDO(ciDO.Id_srv);
                if (!getEmsControl(med)) return false;
                var ciEmsDTO = this.model.getCiEmsDTO(ciDO.Id_or);
                ciorderDO = ciDO;
                Log.writelog("修改医嘱 方法 开始  ==" + ciorderDO.Name_or);
                this.currentEmsControl.CiEmsDTO = ciEmsDTO;
                this.currentEmsControl.EmsHeadDO.SetUpdated();
                if (!LoadOrderView(ciDO.Sd_srvtp, med)) return false;
                
                SheetName = ciDO.Name_or;
                //viewEditState是通过患者的状态判断得到，当viewEditState为false，医疗单不可编辑；当viewEditState为True，通过医嘱的状态判断医疗单是否可编辑；
                currentEmsControl.IsReadOnly = this.viewEditState == true ? !(ciDO.Sd_su_or == "0" || ciDO.Sd_su_or==null) : this.viewEditState;
                //ci.IsReadOnly = !(ciDO.Sd_su_or == "0"); //只有开立的可以修改
                if (emsIndexAndButtonArea != null) {
                    if (!this.viewEditState) {
                        emsIndexAndButtonArea.RenderEnabled = false;
                    }
                    else if (ciDO.Sd_su_or != null && ciDO.Sd_su_or != "0") {
                        emsIndexAndButtonArea.RenderEnabled = false;
                    }
                    else {
                        emsIndexAndButtonArea.RenderEnabled = true;
                    }
                }
                Log.writelog("修改医嘱 方法 结束  ==" + ciorderDO.Name_or);
            }
            else if (e is CiEmsDTO) {
                this.status = DOStatus.UPDATED;
                var ciEmsDTO = e as CiEmsDTO;
                var med = getMedSrvDO(ciEmsDTO.Id_srv);
                if (!getEmsControl(med)) return false;
                this.currentEmsControl.CiEmsDTO = ciEmsDTO;
                //this.currentEmsControl.EmsHeadDO.SetUpdated();
                if (!LoadOrderView(ciEmsDTO.Sd_srvtp, med)) return false;
                currentEmsControl.IsReadOnly = false;
                emsIndexAndButtonArea.RenderEnabled = true;
                this.status = DOStatus.NEW;
                this.currentEmsControl.EmsHeadDO.Status = this.status;
            }

            if (this.currentEmsControl.EmsHeadDO != null && currentEmsControl != null)
            {
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
                currentEmsControl.IsReadOnly = this.viewEditState == true ? !(this.currentEmsControl.CiEmsDTO.Sd_su_or == "0" || this.currentEmsControl.CiEmsDTO.Sd_su_or == null) : !this.viewEditState;
                this.currentEmsControl.EmsHeadDO.IsOpData = false;
                if (orderItemView != null)
                    orderItemView.SetTabText(currentEmsControl.SheetName);
                this.currentEmsControl.EmsHeadDO.PatInfo = ent4bannerDto;
                currentEmsControl.OnRefreshData(this.currentEmsControl.EmsHeadDO, this.currentEmsControl.CiEmsDTO);//数据传递给 医嘱表单
                //为医疗单传Context对象
                currentEmsControl.Context = this.Context;
                currentEmsControl.EmsHeadDO = this.currentEmsControl.EmsHeadDO;
                currentEmsControl.CiEmsDTO = this.currentEmsControl.CiEmsDTO;
                ciControl.Add(currentEmsControl, this.currentEmsControl.EmsHeadDO);
                currentEmsControl.Dock = DockStyle.None;
                this.splitContainer1.AddControl(currentEmsControl, xap.cli.sdk.controls.ControlPosition.Center);

            }
            else {
                emsIndexAndButtonArea.RenderEnabled = false;
            }

            this.currentEmsControl.CiEmsDTO.Fg_cp = ent4bannerDto.Def1;//  临床路径患者 
            Log.writelog("SetEmsFromOrdOrSrv 方法 结束  将服务或者医嘱上的数据设置到医疗单上");
            return true;
        }

        private MedSrvDO getMedSrvDO(string id) {
            if (string.IsNullOrEmpty(id)) return null;
            return XapServiceMgr.find<IMedsrvMDOCrudService>().findById(id);
        }


        CiEmsSrvDTO getDeletedSrv(CiEmsSrvDTO srv)
        {
            CiEmsSrvDTO s = new CiEmsSrvDTO();
            s.deSerializeJson(srv.serializeJson());
            s.Status = DOStatus.DELETED;
            return s;
        }

        /// <summary>
        /// 加载医嘱对应的医疗单视图
        /// </summary>
        /// <param name="srvTp">服务类型</param>
        /// <param name="med"></param>
        private bool LoadOrderView(string srvTp, MedSrvDO med) {
            Log.writelog("LoadOrderView 方法 开始  加载医嘱对应的医疗单视图");
            //currentEmsControl.IsReadOnly = false;
            //  20190919的优化   把创建过的对象放到一个字典中，每次用时候  去集合判断 存在直接取用 
            // string ctlKey = "";
            if (status != DOStatus.NEW)
            {
                var feeList = from srv in this.currentEmsControl.CiEmsDTO.Emssrvs.Cast<CiEmsSrvDTO>()
                              where srv.Id_srv != null /*&& true == srv.Fg_bl*/
                              select getDeletedSrv(srv);
                currentEmsControl.setFeelCiEmsSrvs(feeList.ToList());
            }
            
            switch (srvTp.Substring(0, 2)) {
                #region 药品
                case "01": //药品 
                    switch (srvTp.Substring(2, 2)) {
                        case "01": //西药
                        case "02":
                            switch (srvTp.Substring(4)) {
                                case "03":
                                case "04"://注射类
                                    this.currentEmsControl.EmsHeadDO.EmsType = EmsType.IV;
                                    break;
                                default://口服类
                                    this.currentEmsControl.EmsHeadDO.EmsType = EmsType.COMMONDRUG;
                                    break;
                            }
                            break;

                        case "03"://草药
                            this.currentEmsControl.EmsHeadDO.EmsType = EmsType.HERB;
                            break;
                    }
                    if (status == DOStatus.NEW) {
                        Log.writelog(" 新增是开始==");
                        Log.writelog("绑定药品带过来的数据 方法 开始  ==");
                        orDataBing.AddDrugDataBing(this.currentEmsControl.EmsHeadDO, med);//绑定药品带过来的数据
                        Log.writelog("绑定药品带过来的数据 方法 结束  ==");
                      
                        //自定义服务和非自定义服务列表数据绑定的值不同
                        if (med.Fg_ctm == null || med.Fg_ctm == false)//非自定义服务
                        {
                            //获得物品信息
                            Log.writelog("this.currentEmsControl.EmsHeadDO.Emsdrugs.EmsOrDrug  方法 开始  ==" + "获得物品信息 和 /执行科室填充");
                            this.currentEmsControl.EmsHeadDO.Emsdrugs.EmsOrDrug = DrugUtils.getMMOfDrug(med.Id_srv, this.currentEmsControl.EmsHeadDO.PatInfo);
                            //执行科室填充
                            DrugUtils.fillExecDetps(this.currentEmsControl.EmsHeadDO.Emsdrugs.EmsOrDrug, this.currentEmsControl.EmsHeadDO.Emsdrugs.Id_route, this.currentEmsControl.EmsHeadDO.PatInfo);
                            //emsDO.Emsdrugs.EmsOrDrug = cof.GetSrvMm(emsDO, med.Id_srv, emsDO.PatInfo.Code_entp);// 
                            this.currentEmsControl.EmsHeadDO.Emsdrugs.EmsOrDrug = cof.MmSortList(this.currentEmsControl.EmsHeadDO.Emsdrugs.EmsOrDrug);
                            Log.writelog("this.currentEmsControl.EmsHeadDO.Emsdrugs.EmsOrDrug  方法 结束  ==" + "获得物品信息 和 /执行科室填充");
                            if (this.currentEmsControl.EmsHeadDO.Emsdrugs.EmsOrDrug != null && this.currentEmsControl.EmsHeadDO.Emsdrugs.EmsOrDrug.Count > 0)
                            {
                                //皮试逻辑，判断该服务能否开立医疗单 2016-07-05添加zwq
                                var selectDrugIndex = drugSkinTestLogic(this.currentEmsControl.EmsHeadDO.Emsdrugs.EmsOrDrug);
                                if (selectDrugIndex == null) {
                                    var de = new DictionaryEventArgs();
                                    de.Data.Add(UIConst.UI_EVENT, UIEvent.CANCEL);
                                    FireEventSent(this, de);
                                    return false;
                                }
                                if (med.Quan_med != null)
                                    this.currentEmsControl.EmsHeadDO.Emsdrugs.EmsOrDrug[(int)selectDrugIndex].Quan_med = med.Quan_med;
                                //每次将关联药品的第一条插入到 药品列表
                                this.currentEmsControl.EmsHeadDO.Emsdrugs.EmsOrDrugList.Add(cof.DoCopy(this.currentEmsControl.EmsHeadDO.Emsdrugs.EmsOrDrug[(int)selectDrugIndex]));
                            }
                            if (this.currentEmsControl.EmsHeadDO.Emsdrugs.EmsOrDrug.Count == 0 || (this.currentEmsControl.EmsHeadDO.Emsdrugs.EmsOrDrug.Count == 1 && string.IsNullOrEmpty(this.currentEmsControl.EmsHeadDO.Emsdrugs.EmsOrDrug[0].Id_mm)))
                            {
                                var de = new DictionaryEventArgs();
                                de.Data.Add(UIConst.UI_EVENT, UIEvent.CANCEL);
                                FireEventSent(this, de);
                                this.ShowInfo(this.currentEmsControl.EmsHeadDO.Emsdrugs.Name_srv + "未绑定物品，请与信息科联系!", "提示");
                              return false;
                            }
                            Log.writelog(" 新增是结束==");
                        }
                        else {
                            var customSrv = new EmsOrDrug();
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
                            this.currentEmsControl.EmsHeadDO.Emsdrugs.EmsOrDrugList.Add(customSrv);
                        }
                        this.currentEmsControl.EmsHeadDO.MedSrvDO = med;
                    }
                    else {
                        orCiEmsToUiEms.EditDrug(this.currentEmsControl.CiEmsDTO, this.currentEmsControl.EmsHeadDO);
                    }
                    //草药不处理 2016-07-07zwq
                    //if (!"03".Equals(srvTp.Substring(2, 2))) {
                    cof.concateExtNote(this.currentEmsControl.EmsHeadDO.Emsdrugs.EmsOrDrugList, this.bannerDto, this.currentEmsControl.EmsHeadDO);
                    //}
                    break;
                #endregion
                #region 检查
                case "02"://检查属性

                    switch (srvTp.Substring(2, 2)) {
                        case "07"://病理
                            // ctlKey = srvTp + "pathgy";
                            if (status == DOStatus.NEW) {
                                orDataBing.AddCommonHeadDataBing(this.currentEmsControl.EmsHeadDO, med);
                                //绑定表单数据
                                orDataBing.AddPathgyDataBing(this.currentEmsControl.EmsHeadDO, med);
                                var palabDO = cof.GetPathgyLab(this.currentEmsControl.EmsHeadDO.MedSrvDO.Id_srv);
                                if (palabDO != null) {
                                    this.currentEmsControl.EmsHeadDO.Emsappathgy.Quan = palabDO.Quan == null ? 0 : (int)palabDO.Quan;
                                    this.currentEmsControl.EmsHeadDO.Emsappathgy.Id_colltp = palabDO.Id_colltp;
                                    this.currentEmsControl.EmsHeadDO.Emsappathgy.Sd_colltp = palabDO.Sd_samptp;
                                }

                                this.currentEmsControl.EmsHeadDO.MedSrvDO = med;
                            }
                            else {

                                orCiEmsToUiEms.EditPathgy(this.currentEmsControl.EmsHeadDO, this.currentEmsControl.CiEmsDTO);

                            }
                            this.currentEmsControl.EmsHeadDO.EmsType = EmsType.PATHGY;
                            if (currentEmsControl == null) {
                                currentEmsControl = new OrderPathgyView { Dock = DockStyle.Fill };
                            }
                            break;
                        default://检查
                            if (status == DOStatus.NEW) {

                                orDataBing.patDo = this.bannerDto;

                                //orDataBing.AddCommonHeadDataBing(emsDO, med);
                                obslab.AddObsLoadData(this.currentEmsControl.EmsHeadDO, med);
                            }
                            else {
                                this.currentEmsControl.EmsHeadDO.Emsapobs.EmsOrDrugList.Clear();//检查药品绑定
                                this.currentEmsControl.EmsHeadDO.Emsapobs.EmsOrObsListDel.Clear();//处理删除的绑定
                                orCiEmsToUiEms.EditEmsObs(this.currentEmsControl.EmsHeadDO, this.currentEmsControl.CiEmsDTO);

                            }
                            this.currentEmsControl.EmsHeadDO.EmsType = EmsType.RIS;
                            if (currentEmsControl == null) {
                                currentEmsControl = new OrderApobsView { Dock = DockStyle.Fill };
                            }
                            break;
                    }
                    break;
                #endregion
                #region 检验
                case "03"://检验属性
                    // ctlKey = srvTp + "lab";

                    if (status == DOStatus.NEW) {
                        //emsDO.PatInfo = this.patDo;
                        //医嘱信息 
                        orDataBing.AddCommonHeadDataBing(this.currentEmsControl.EmsHeadDO, med);
                        //检验属性和 检验的项目 
                        obslab.AddLabLoadData(this.currentEmsControl.EmsHeadDO, med);
                    }
                    else {
                        this.currentEmsControl.EmsHeadDO.Emsaplab.EmsOrObsList.Clear();
                        this.currentEmsControl.EmsHeadDO.Emsaplab.EmsOrObsListDel.Clear();
                        orCiEmsToUiEms.EditEmsLab(this.currentEmsControl.EmsHeadDO, this.currentEmsControl.CiEmsDTO);
                        //
                        //orDataBing.EditLabDataBing(emsDO, agg);
                    }
                    this.currentEmsControl.EmsHeadDO.EmsType = EmsType.LIS;
                    if (currentEmsControl == null) {
                        currentEmsControl = new OrderAplabView { Dock = DockStyle.Fill };
                    }
                    break;
                #endregion
                #region 手术
                case "04": //手术属性
                    //LoadOrderView2(srvTp, dto, med);

                    switch (srvTp.Substring(2, 2)) {
                        case "01":
                            break;


                    }
                    //ctlKey = srvTp + "oper";
                    if (status == DOStatus.NEW) {
                        //emsDO = cof.CreatEmsIntance();
                        //公共信息
                        orDataBing.AddCommonHeadDataBing(this.currentEmsControl.EmsHeadDO, med);
                        //绑定表单数据
                        orDataBing.AddOpDataBing(this.currentEmsControl.EmsHeadDO, med);
                        //手术前检查指标数据
                        //emsDO.Emsapop.OpLabItem = cof.GetBtLabItme(med.Id_srv);//获取术前检验项目


                        //EmsItemInOp item = new EmsItemInOp();
                        //item.Id_mmtp = "0001AA1000000000ELL6";
                        //item.Name_mmtp = "物品类型";
                        //emsDO.Emsapop.OpMmItem.Add(item);

                    }
                    else {
                        orCiEmsToUiEms.EditApop(this.currentEmsControl.EmsHeadDO, this.currentEmsControl.CiEmsDTO);
                        //if (ciorderDO != null) {
                        //    this.currentEmsControl.EmsHeadDO.Emsapop.Dt_creat = ciorderDO.Createdtime;
                        //}
                        //  orDataBing.EditHeadDataBing(emsDO, agg);
                        // orDataBing.EditOpDataBing(emsDO, agg);//表单

                        //  orDataBing.EditOpEmpDataBing(emsDO, agg);//手术人员

                        //  orDataBing.EditOpMmDataBing(emsDO, agg);//手术卫材
                    }


                    this.currentEmsControl.EmsHeadDO.EmsType = EmsType.OPER;
                    if (currentEmsControl == null)
                        currentEmsControl = new OrderOpView { Dock = DockStyle.Fill };
                    break;
                #endregion
                #region 通用医疗单
                case "05":
                case "06":
                case "08":
                case "99":
                    //LoadOrderView2(srvTp, dto, med);

                    if (status == DOStatus.NEW) {
                        // emsDO = cof.CreatEmsIntance();
                        //orDataBing.AddCommonHeadDataBing(this.currentEmsControl.EmsHeadDO, med);
                        orDataBing.AddDrugDataBing(this.currentEmsControl.EmsHeadDO, med);
                    }
                    else {
                        orCiEmsToUiEms.EditCommon(this.currentEmsControl.CiEmsDTO, this.currentEmsControl.EmsHeadDO);
                    }
                    this.currentEmsControl.EmsHeadDO.EmsType = EmsType.COMMON;
                    // ctlKey = srvTp + "common";
                    if (currentEmsControl == null)
                        currentEmsControl = new OrderCommonView { Dock = DockStyle.Fill };
                    break;
                #endregion
                #region  会诊
                case "09"://会诊
                    switch (srvTp.Substring(2, 2)) {
                        case "01"://会诊
                        case "02"://会诊
                            if (status == DOStatus.NEW) {
                                orDataBing.AddCommonHeadDataBing(this.currentEmsControl.EmsHeadDO, med);
                                orDataBing.AddConsDataBing(this.currentEmsControl.EmsHeadDO, med);
                               
                                var item = new EmsItemInCons();
                                item.Name_srv = this.currentEmsControl.EmsHeadDO.MedSrvDO.Name;
                                item.Id_srv = this.currentEmsControl.EmsHeadDO.MedSrvDO.Id_srv;
                                var srvcons = cof.GetCons(this.currentEmsControl.EmsHeadDO.MedSrvDO.Id_srv);
                                if (srvcons == null)
                                {
                                    BizAssMessageBoxUtil.ShowWarningMsg("未获取到会诊属性,无法打开会诊医疗单！");
                                    return false;
                                }

                                item.Id_constp = srvcons.Id_constp;
                                item.Name_constp = srvcons.Name_constp;
                                item.Sd_constp = srvcons.Sd_constp;
                                this.currentEmsControl.EmsHeadDO.Emsapcons.Id_constp = srvcons.Id_constp;
                                this.currentEmsControl.EmsHeadDO.Emsapcons.Sd_constp = srvcons.Sd_constp;
                                this.currentEmsControl.EmsHeadDO.Emsapcons.Name_constp = srvcons.Name_constp;

                                this.currentEmsControl.EmsHeadDO.Emsapcons.EmsConsItem.Add(item);
                            }
                            else {
                                orCiEmsToUiEms.EditCons(this.currentEmsControl.EmsHeadDO, this.currentEmsControl.CiEmsDTO);

                                var item = new EmsItemInCons();
                                item.Name_srv = this.currentEmsControl.EmsHeadDO.Emsapcons.Name_srv;
                                item.Id_srv = this.currentEmsControl.EmsHeadDO.Emsapcons.Id_srv;
                                item.Id_constp = this.currentEmsControl.EmsHeadDO.Emsapcons.Id_constp;
                                item.Name_constp = this.currentEmsControl.EmsHeadDO.Emsapcons.Name_constp;
                                item.Sd_constp = this.currentEmsControl.EmsHeadDO.Emsapcons.Sd_constp;
                                this.currentEmsControl.EmsHeadDO.Emsapcons.EmsConsItem.Add(item);
                            }

                            this.currentEmsControl.EmsHeadDO.EmsType = EmsType.CONS;
                            if (currentEmsControl == null)
                                currentEmsControl = new OrderConsAppView { Dock = DockStyle.Fill };
                            break;
                        
                    }
                    break;
                #endregion
                #region 12 转科 出院 跨科
                case "12": {
                        switch (srvTp.Substring(2, 2)) {
                            case "01"://转科
                            case "04"://跨科
                                {
                                    if (status == DOStatus.NEW) {
                                        orDataBing.AddCommonHeadDataBing(this.currentEmsControl.EmsHeadDO, med);
                                        orDataBing.AddTransDataBing(this.currentEmsControl.EmsHeadDO, med);
                                        this.currentEmsControl.EmsHeadDO.MedSrvDO = med;
                                    }
                                    else {
                                        orCiEmsToUiEms.EditEmsTrans(this.currentEmsControl.EmsHeadDO, this.currentEmsControl.CiEmsDTO);
                                    }
                                    this.currentEmsControl.EmsHeadDO.EmsType = EmsType.TRANSDEPT;
                                    //ctlKey = srvTp + "trans";
                                    if (currentEmsControl == null) {
                                        currentEmsControl = new OrderTransView { Dock = DockStyle.Fill };
                                    }
                                    break;
                                }
                            case "02":// // 1202 出院 1203 宣布临床死亡
                            case "03":// 
                                if (status == DOStatus.NEW) {
                                    // emsDO = cof.CreatEmsIntance();
                                    orDataBing.AddCommonHeadDataBing(this.currentEmsControl.EmsHeadDO, med);
                                    orDataBing.AddOutDataBing(this.currentEmsControl.EmsHeadDO, med);
                                }
                                else {

                                    orCiEmsToUiEms.EditEmsOut(this.currentEmsControl.EmsHeadDO, this.currentEmsControl.CiEmsDTO);

                                }
                                this.currentEmsControl.EmsHeadDO.EmsType = EmsType.OUTHOSP;
                                //ictlKey = srvTp + "out";
                                if (currentEmsControl == null) {
                                    currentEmsControl = new OrderOutView { Dock = DockStyle.Fill };
                                }
                                break;
                            case "05":// 转病区
                                {
                                    if (status == DOStatus.NEW)
                                    {
                                        orDataBing.AddCommonHeadDataBing(this.currentEmsControl.EmsHeadDO, med);
                                        orDataBing.AddTransDataBing(this.currentEmsControl.EmsHeadDO, med);
                                        this.currentEmsControl.EmsHeadDO.MedSrvDO = med;
                                        this.currentEmsControl.EmsHeadDO.EmsType = EmsType.TRANSDEPT;
                                    }
                                    else
                                    {
                                        orCiEmsToUiEms.EditEmsTrans(this.currentEmsControl.EmsHeadDO, this.currentEmsControl.CiEmsDTO);
                                        this.currentEmsControl.EmsHeadDO.MedSrvDO = med;
                                        this.currentEmsControl.EmsHeadDO.EmsType = EmsType.TRANSDEPT;
                                    }

                                }
                                break;
                            
                        }
                    }

                    break;

                #endregion
                #region 14 输血 用血
                case "14"://输血
                    // LoadOrderView2(srvTp, dto, med);

                    switch (srvTp.Substring(4, 2)) {

                        //140101 血液制品
                        //140102 用血
                        case "01"://输血 备血

                            if (status == DOStatus.NEW) {
                                orDataBing.AddBtDataBing(this.currentEmsControl.EmsHeadDO, med);
                                //备血的执行科室由后台计算
                                //OrWfDeptInfoDTO wf = new GetDeptMpImp().GetDept_mp_ids(emsDO.PatInfo.Code_entp, emsDO.PatInfo.Id_entp, emsDO.MedSrvDO.Sd_srvtp, emsDO.MedSrvDO.Id_srvca, emsDO.MedSrvDO.Id_srv, emsDO.MedSrvDO.Id_route, "id_mm", emsDO.PatInfo.Id_dep_nur, emsDO.PatInfo.Id_dep_phy);
                                //if (wf!=null)
                                //{
                                //    emsDO.Emsapbt.Id_mp_dep = wf.Firstid_mp_dept;
                                //    emsDO.Emsapbt.Name_mp_dep = wf.Firstname_mp_dept;
                                //}
                                
                            }
                            else {
                                orDataBing.editApbtDataBiding(this.currentEmsControl.EmsHeadDO, this.currentEmsControl.CiEmsDTO);
                            }
                            this.currentEmsControl.EmsHeadDO.EmsType = EmsType.BT;
                            break;

                        case "02"://用血
                            if (status == DOStatus.NEW) {
                                //emsDO = cof.CreatEmsIntance();
                                var array = orderCardViewModel.getOrderUBDto(bannerDto.Id_ent);
                                if (array == null || array.Length == 0) {

                                    this.ShowInfo("备血申请不存在，请先开立备血申请！");
                                    this.tabNaviControl.CanShowForm = false;
                                    return false;
                                }
                                orDataBing.AddCommonHeadDataBing(this.currentEmsControl.EmsHeadDO, med);
                                if (this.currentEmsControl.EmsHeadDO.CiordubDTO != null) this.currentEmsControl.EmsHeadDO.CiordubDTO = null;
                                //orDataBing.AddBtDataBing(emsDO, med);
                                //emsDO.Emsapbt.BtLabItem = cof.GetBtLabItme(med.Id_srv);//获取输血前检验项目
                            }
                            else {
                                //orDataBing.EditHeadDataBing(emsDO, dto);
                                //orDataBing.EditBtDataBing(emsDO, dto);
                                //emsDO.Emsapbt.BtLabItem = agg.getOrdApSugViewItemDO();
                                var odp = this.currentEmsControl.CiEmsDTO.Orapplysheet[((int)EmsType.BTUSE).ToString()] as OrdAppBtUseDO;
                                FArrayList li = this.currentEmsControl.CiEmsDTO.Emssrvs;
                                var srvDto  = this.currentEmsControl.CiEmsDTO.Emssrvs.Cast<CiEmsSrvDTO>().ToArray().FirstOrDefault(p => p.Id_srv == this.currentEmsControl.CiEmsDTO.Id_srv);
                                if (odp != null) {
                                    this.currentEmsControl.EmsHeadDO.CiordubDTO = new CiordubDTO();
                                    ICiorappbtMDOCrudService mdService = XapServiceMgr.find<ICiorappbtMDOCrudService>();
                                    OrdApBtDO[] apbts = mdService.findByAttrValString("Id_or", this.currentEmsControl.CiEmsDTO.Id_or_rel);
                                    if (apbts != null && apbts.Length > 0) {
                                        this.currentEmsControl.EmsHeadDO.CiordubDTO.Num_margin_bu = apbts[0].Num_margin_bu;
                                    }
                                    this.currentEmsControl.EmsHeadDO.CiordubDTO.No_applyform_ub = odp.No_applyform;
                                    this.currentEmsControl.EmsHeadDO.CiordubDTO.Dt_bu_pl_ub = odp.Dt_bu_plan;
                                    //emsDO.CiordubDTO.Applyform=odp.
                                    this.currentEmsControl.EmsHeadDO.CiordubDTO.Orsrvname = this.currentEmsControl.CiEmsDTO.Name;
                                    this.currentEmsControl.EmsHeadDO.CiordubDTO.Id_srv = this.currentEmsControl.CiEmsDTO.Id_srv;
                                    this.currentEmsControl.EmsHeadDO.CiordubDTO.Name_unit = srvDto.Name_unit_med;
                                    //this.currentEmsControl.EmsHeadDO.CiordubDTO.Quan_medu = srvDto.Quan_med;
                                    this.currentEmsControl.EmsHeadDO.CiordubDTO.Quan_medu_ub = srvDto.Quan_med;
                                    this.currentEmsControl.EmsHeadDO.CiordubDTO.Id_route = this.currentEmsControl.CiEmsDTO.Id_route;
                                    this.currentEmsControl.EmsHeadDO.CiordubDTO.Name_route = this.currentEmsControl.CiEmsDTO.Name_route;
                                    this.currentEmsControl.EmsHeadDO.CiordubDTO.Status = DOStatus.UPDATED;
                                    this.currentEmsControl.EmsHeadDO.CiordubDTO.Id_apbu = odp.Id_apbu;
                                    this.currentEmsControl.EmsHeadDO.CiordubDTO.Name_emp_create = this.currentEmsControl.CiEmsDTO.Name_emp_phy;
                                    this.currentEmsControl.EmsHeadDO.CiordubDTO.Id_emp_create = this.currentEmsControl.CiEmsDTO.Id_emp_phy;
                                    this.currentEmsControl.EmsHeadDO.CiordubDTO.Id_or_rel = this.currentEmsControl.CiEmsDTO.Id_or_rel;
                                    this.currentEmsControl.EmsHeadDO.CiordubDTO.Id_mp_dep = srvDto.Id_dep;
                                    this.currentEmsControl.EmsHeadDO.CiordubDTO.Id_unit = srvDto.Id_unit_med;
                                    this.currentEmsControl.EmsHeadDO.CiordubDTO.Id_route = srvDto.Id_route;
                                    this.currentEmsControl.EmsHeadDO.CiordubDTO.Name_route = srvDto.Name_route;
                                    this.currentEmsControl.EmsHeadDO.CiordubDTO.Des_or = this.currentEmsControl.CiEmsDTO.Des_or;
                                }

                            }
                            this.currentEmsControl.EmsHeadDO.EmsType = EmsType.BTUSE;
                            break;


                    }
                    break;
              
            }
                #endregion
            #region 对象赋值

            this.currentEmsControl.EmsHeadDO.Status = this.status;
            if (med != null) {
                SheetName = med.Name;
            }
            #endregion
            Log.writelog("LoadOrderView 方法 结束  加载医嘱对应的医疗单视图");
            return true;
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
        /// 
        /// 多医疗单保存到下一个医疗单
        /// </summary>
        private void SaveNextView()
        {
            //处理
            var list = new List<XRoundRender>();
            XRoundRender activeRender = null;
            foreach (XRoundRender render in emsIndexAndButtonArea.IndexRenderList)
            {
                
                    list.Add(render);
                    activeRender = render;
               
               
            }
            //按钮区已删除，处理上边对应的view区域
            if (activeRender != null)
            {
                    activeRender.Ci.Dock = DockStyle.None;
                    TMPrender = activeRender;
                    currentEmsControl = activeRender.Ci;
                    orderItemView.SetTabText(currentEmsControl.SheetName);
                    currentEmsControl.IsReadOnly = this.viewEditState == true ? !(currentEmsControl.CiEmsDTO.Sd_su_or == "0" || currentEmsControl.CiEmsDTO.Sd_su_or == null) : this.viewEditState;
                    if (emsIndexAndButtonArea != null)
                    {
                        emsIndexAndButtonArea.RenderEnabled = !currentEmsControl.IsReadOnly;
                    }
                    this.splitContainer1.AddControl(activeRender.Ci, xap.cli.sdk.controls.ControlPosition.Center);
                
            }
            emsIndexAndButtonArea.IndexRenderList = list; //zzj，最好能直接删除，不要这样直接替换，能够节约内存
            emsIndexAndButtonArea.xapScrollBarPanel1.Invalidate();
            this.tabNaviControl.CanShowForm &= (list == null || list.Count != 0);
        }

        /// <summary>
        /// 关闭某个医疗单
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public void orCom_deleteevent(object sender, EventArgs e) {
            //处理
            var list = new List<XRoundRender>();
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
                var nextRender = GetNextActiveRender(activeRender);
                if (nextRender == null)
                {
                    this.splitContainer1.RemoveRender(this.EmsIndexAndButtonArea); //清除“确认”、“取消”按钮
                    this.tabNaviControl.CanShowForm = false;
                    this.ClearEmsList(); //清空数据
                    this.tabNaviControl.TabNavigationForm.Close(); //关闭右缩面板
                }
                else
                {
                    nextRender.Editflag = true;

                    nextRender.Ci.EmsHeadDO = this.UiEmsDict[nextRender.ID] as EmsUIDTO;
                    nextRender.Ci.CiEmsDTO = this.CiEmsDict[nextRender.ID] as CiEmsDTO;

                    //this.emsDO = nextRender.Ci.EmsHeadDO;
                    //this.dto = nextRender.Ci.CiEmsDTO;

                    nextRender.Ci.Dock = DockStyle.None;
                    TMPrender = nextRender;
                    currentEmsControl = nextRender.Ci;
                    currentEmsControl.OnRefreshData(this.UiEmsDict[nextRender.ID] as EmsUIDTO, this.CiEmsDict[nextRender.ID] as CiEmsDTO);
                    orderItemView.SetTabText(currentEmsControl.SheetName);
                    currentEmsControl.IsReadOnly = this.viewEditState == true ? !(currentEmsControl.CiEmsDTO.Sd_su_or == "0"||currentEmsControl.CiEmsDTO.Sd_su_or == null) : this.viewEditState;
                    if (emsIndexAndButtonArea != null)
                    {
                        emsIndexAndButtonArea.RenderEnabled = !currentEmsControl.IsReadOnly;
                    }
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
            var index = emsIndexAndButtonArea.IndexRenderList.IndexOf(render);

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

            var render = sender as XRoundRender;
            //做校验的地方
            foreach (XRoundRender Pastrender in emsIndexAndButtonArea.IndexRenderList) {
                if (Pastrender.Equals(render)) {
                    Pastrender.Crossflag = false;
                    Pastrender.Editflag = true;
                     //currentEmsControl.OnRefreshData(this.UiEmsDict[Pastrender.ID] as EmsUIDTO, this.UiEmsDict[Pastrender.ID] as CiEmsDTO);
                    Pastrender.Ci.EmsHeadDO = this.UiEmsDict[Pastrender.ID] as EmsUIDTO;
                    Pastrender.Ci.CiEmsDTO = this.CiEmsDict[Pastrender.ID] as CiEmsDTO;

                    //this.splitContainer1.Panel1.Controls.Add(render.Ci);
                    render.Ci.Dock = DockStyle.None;
                    currentEmsControl = Pastrender.Ci;
                    //界面更换完毕后要刷新界面，否则数据无法显示
                    currentEmsControl.OnRefreshData(this.UiEmsDict[Pastrender.ID] as EmsUIDTO, this.CiEmsDict[Pastrender.ID] as CiEmsDTO);
                    orderItemView.SetTabText(currentEmsControl.SheetName);
                    this.tabNaviControl.NavTabControl.Refresh();
                    currentEmsControl.IsReadOnly = this.viewEditState == true ? !(currentEmsControl.CiEmsDTO.Sd_su_or == "0" || currentEmsControl.CiEmsDTO.Sd_su_or==null) : this.viewEditState;
                    if (emsIndexAndButtonArea != null)
                    {
                        emsIndexAndButtonArea.RenderEnabled = !currentEmsControl.IsReadOnly;
                    }
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
            this.tabNaviControl.CanShowForm = false;
            var dic = new DictionaryEventArgs();
            dic.Data[UIConst.UI_EVENT] = UIEvent.CANCEL;
            this.FireEventSent(this, dic);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="strtxt"></param>
        private void OrVoice(string strtxt) {
            var reader = new SpeechSynthesizer();
            reader.SpeakAsync(strtxt);
        }

        /// <summary>
        /// 保存医嘱
        /// </summary>
        public void Save() {
            Log.writelog("保存医嘱 方法 开始  ==");
            var ver = new OrderDataVerify();
            currentEmsControl.OrdErrorList.Clear();
            currentEmsControl.SaveBefore();
            if (ver.OrdValidateMustInput(currentEmsControl)) {
                ver.OrdBPValidate(this.currentEmsControl.EmsHeadDO, currentEmsControl);//业务
            }

            if (currentEmsControl.OrdErrorList.Count == 0) {
                var ciorder = dtoSaveViewModel.SaveDTO(this.currentEmsControl.EmsHeadDO, this.currentEmsControl.CiEmsDTO, orderDataFrom, ems =>
                {
                    if (ems.Emssrvs != null)
                    {
                        var idsrvKeys = ems.Emssrvs.Cast<CiEmsSrvDTO>().Select(p => p.Id_srv);
                        if (null != idsrvKeys && currentEmsControl.getFeelCiEmsSrvs()!=null)
                        {
                            currentEmsControl.getFeelCiEmsSrvs().Where(p =>p.Fg_or!=true&& !idsrvKeys.Contains<String>(p.Id_srv)).ToList().ForEach(p =>
                            {
                                ems.Emssrvs.Add(p);
                            });
                        }
                    }
                    
                });//1保存
                if (ciorder == null) return;
                // 发送保存成功消息，刷新按钮状态
                if (ciorder.Mdicalinfo != null && ciorder.Mdicalinfo != "")
                {
                    this.ShowInfo(ciorder.Mdicalinfo);
                }
                SendMgs(ciorder.Id_or);//2发消息
                //ClearCurrentEms();//3清表单
               // SaveNextView();
                orCom_deleteevent(null,null);
                if (this.emsList.Count ==1){
                    this.emsList.Clear();
                    this.splitContainer1.RemoveRender(this.EmsIndexAndButtonArea); //清除“确认”、“取消”按钮
                    this.tabNaviControl.CanShowForm = false;
                    this.ClearEmsList(); //清空数据
                    this.tabNaviControl.TabNavigationForm.Close(); //关闭右缩面板
                }
            }
            else {
                string strErr = "";
                currentEmsControl.OrdErrorList.ForEach(
                    p => { strErr += string.Format("{0}.{1}\n", currentEmsControl.OrdErrorList.IndexOf(p) + 1, p); });
                string errInfo = " 验证失败!\r\n" + strErr;
                //cof.OrVoice(errInfo);
                this.ShowInfo(errInfo,"提示");
            }
            Log.writelog("保存医嘱 方法 结束  ==");
        }
        #endregion

        #region 状态处理区域
        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="eventArgs"></param>
        public override void HandleState(object sender, DictionaryEventArgs eventArgs) {
            var uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            var newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent) {
                case UIEvent.LOAD:

                    var dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
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
                    var dics = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
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
                        var param = new SkinTestParamDTO();
                        param.Id_mm = skinDrug.Id_mm;
                        param.Id_org = this.Context.Org.Id_org;
                        param.Id_pi = this.bannerDto.Id_pat;
                        param.Dt_birth = DateTime.Parse(this.bannerDto.Dt_birth);
                        param.Id_srv = this.currentEmsControl.EmsHeadDO.Emsdrugs.Id_srv;
                        param.Id_skinsrv = skinDrug.Id_srvskin;
                        try
                        {
                            var retDTO = this.orderCardViewModel.skinTestLogic(param);
                            var code = retDTO.Allergicpharmhandlemode.ToString();
                            if (code.Equals("0") && (i == this.currentEmsControl.EmsHeadDO.Emsdrugs.EmsOrDrug.Count - 1))
                            {
                                this.ShowInfo("用药医嘱时，患者存在该药品过敏史并禁用该药！");
                                return null;
                            }
                            else if (code.Equals("0"))
                            {
                                continue;
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
            var param = new Dictionary<string, object>();
            var dic = new DictionaryEventArgs();
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
        #region 多医疗测试

        ///
        /// 
        /// 
        private void LoadDataView(MedSrvDO medSrvs )
        {
            var envinfo = getUIEmsEnvDTO();
            var param = new BdSrv4EmsDiDTO();
            this.currentEmsControl.EmsHeadDO.EmsType = this.currentEmsControl.EmsHeadDO.EmsType = EmsType.RIS;
            param.Id_srv = medSrvs.Id_srv;
             var ciEmsDto =  orderCardViewModel.getEmsDiDTO(envinfo,param);
            ciEmsDto.Emsappmode = orderDataFrom;
            var  fieldMaping = new FiledMapping();
            fieldMaping.ObsViewFieldMapping(this.currentEmsControl.EmsHeadDO, ciEmsDto, medSrvs);
            getCiorderBaseControl(medSrvs);
        }

        /// <summary>
        /// 患者信息
        /// </summary>
        /// <returns></returns>
        private UIEmsEnvDTO getUIEmsEnvDTO()
        {
            var envinfo = new UIEmsEnvDTO();
      
            envinfo.Code_entp = this.bannerDto.Code_entp;
            envinfo.Emsappmode = (int)EmsAppModeEnum.IVEMSAPPMODE;//智慧版;
            envinfo.Id_dep_or = this.Context.Dept.Id_dep;
            envinfo.Id_emp_or = this.Context.PsnInfo.Id_psndoc;
            envinfo.Id_en = this.bannerDto.Id_ent;
            envinfo.Id_entp = this.bannerDto.Id_entp;
            envinfo.Id_grp = this.Context.Group.Id_grp;
            envinfo.Id_hp = this.bannerDto.Id_hp;
            envinfo.Id_org = this.Context.Org.Id_org;
            envinfo.Id_pat = this.bannerDto.Id_pat;
            
            return envinfo;
        }
        /// <summary>
        /// 医疗单的Control
        /// </summary>
        /// <param name="med"></param>
        private void getCiorderBaseControl(MedSrvDO med)
        {

            if (med.Sd_srvtp.Length < 4)
            {
                this.ShowInfo(string.Format(med.Name + "服务类型有误长度不足4位！目前是{0},请检查", med.Sd_srvtp));
                return;
            }
            //医疗单匹配问题
            //if (ctls.ContainsKey(med.Sd_srvtp))
            //{

            //    currentEmsControl = ctls[med.Sd_srvtp];        // currentEmsControl = sheets.GetCiorderBaseControl(emsDO.Funcclassstr);
            //}
            //else
            //{
                var paramDto = EmsMatchTool.GetSrvMatchEmsParamDTO(this.Context.Org.Id_org, this.Context.Group.Id_grp, this.Context.Dept.Id_dep, this.Context.PsnInfo.Id_psndoc, bannerDto.Code_entp, med.Sd_srvtp, med.Id_srv, EmsAppModeEnum.IVEMSAPPMODE);
                var srvemsDto = sheets.getSrvMatchEmsParamDTO(paramDto);
                if (srvemsDto != null)
                {
                    this.SheetName = srvemsDto.Name_show;
                    //if (ctls.ContainsKey(srvemsDto.Funcclassstr + med.Sd_srvtp))
                    //{

                    //    currentEmsControl = ctls[srvemsDto.Funcclassstr + med.Sd_srvtp];
                    //    // currentEmsControl = sheets.GetCiorderBaseControl(srvemsDto.Funcclassstr);
                    //}
                    //else
                    //{
                        currentEmsControl = sheets.GetCiorderBaseControl(srvemsDto.Funcclassstr);
                        //ctls.Add(srvemsDto.Funcclassstr + med.Sd_srvtp, currentEmsControl);
                    //}
                }
                else
                {
                    currentEmsControl = null;
                    this.ShowAlert("没有匹配到医疗单,请信息科维护！");
                    return;
                    // throw new Exception("没有匹配到医疗单");
                }
            //}
            currentEmsControl.EmsHeadDO = cof.CreatEmsIntance();
            currentEmsControl.EmsHeadDO.PatInfo = this.bannerDto;
            currentEmsControl.EmsHeadDO.Fg_cp = this.bannerDto.Def1;
            currentEmsControl.EmsHeadDO.Str_name_di = diagNameAndCodeArray[0];
            currentEmsControl.EmsHeadDO.Str_code_di = diagNameAndCodeArray[1];
            currentEmsControl.EmsHeadDO.Str_id_diitm = diagNameAndCodeArray[2];
            currentEmsControl.EmsHeadDO.Id_diitm = diagNameAndCodeArray[3];
            currentEmsControl.EmsHeadDO.MedSrvDO = med;

        }

        #endregion

        private bool getEmsControl(MedSrvDO med) {
            if (string.IsNullOrEmpty(med.Sd_srvtp)) {
                this.ShowInfo(string.Format(med.Name + "服务类型为空！请检查"));
                return false;
            }
            if (med.Sd_srvtp.Length < 4)
            {
                this.SetStatusMsg(string.Format("服务类型有误长度不足4位！目前是{0},使用治疗医疗单！", med.Sd_srvtp));
                currentEmsControl = new OrderCommonView();
                setEmsControlParam(med);
                return true;
            }
            //医疗单匹配问题
            //if (ctls.ContainsKey(med.Sd_srvtp))
            //{

            //    currentEmsControl = ctls[med.Sd_srvtp];        // currentEmsControl = sheets.GetCiorderBaseControl(emsDO.Funcclassstr);
            //    string id_srvof = currentEmsControl.EmsHeadDO.Id_srvof;
            //    string funcclassstr = currentEmsControl.EmsHeadDO.Funcclassstr;
            //    setEmsControlParam(med);
            //    currentEmsControl.EmsHeadDO.Id_srvof = id_srvof;
            //    currentEmsControl.EmsHeadDO.Funcclassstr = funcclassstr;
            //}
            //else
            //{
            var paramDto = EmsMatchTool.GetSrvMatchEmsParamDTO(this.Context.Org.Id_org, this.Context.Group.Id_grp, this.Context.Dept.Id_dep, this.Context.PsnInfo.Id_psndoc, bannerDto.Code_entp, med.Sd_srvtp, med.Id_srv, EmsAppModeEnum.IVEMSAPPMODE);
            var srvemsDto = sheets.getSrvMatchEmsParamDTO(paramDto);
                if (srvemsDto != null)
                {
                    this.SheetName = srvemsDto.Name_show;
                    //if (ctls.ContainsKey(srvemsDto.Funcclassstr + med.Sd_srvtp))
                    //{
                    //    currentEmsControl = ctls[srvemsDto.Funcclassstr + med.Sd_srvtp];//缓存取医疗单对象
                    //    string id_srvof = currentEmsControl.EmsHeadDO.Id_srvof;
                    //    string funcclassstr = currentEmsControl.EmsHeadDO.Funcclassstr;
                    //    setEmsControlParam(med);
                    //    currentEmsControl.EmsHeadDO.Id_srvof = id_srvof;
                    //    currentEmsControl.CiEmsDTO.Id_srvof = id_srvof;
                    //    currentEmsControl.EmsHeadDO.Funcclassstr = funcclassstr;

                    //    // currentEmsControl = sheets.GetCiorderBaseControl(srvemsDto.Funcclassstr);
                    //}
                    //else
                    //{
                        currentEmsControl = sheets.GetCiorderBaseControl(srvemsDto.Funcclassstr);//反射实例化医疗单对象
                        if (med != null && med.Sd_srvtp.StartsWith("04"))
                        {
                        }
                        else
                        {
                            currentEmsControl.Padding = new Padding(4, 4, 4, 4);
                        }
                   
                        setEmsControlParam(med);
                        currentEmsControl.EmsHeadDO.Id_srvof = srvemsDto.Id_ems;
                        currentEmsControl.CiEmsDTO.Id_srvof = srvemsDto.Id_ems;
                        //currentEmsControl.EmsHeadDO.Funcclassstr = srvemsDto.Funcclassstr;
                        //ctls.Add(srvemsDto.Funcclassstr + med.Sd_srvtp, currentEmsControl);
                    //}
                }
                else
                {
                    currentEmsControl = null;
                    this.ShowAlert("没有匹配到医疗单,请信息科维护！");
                    return false;
                    // throw new Exception("没有匹配到医疗单");
                }
            //}
            return true;
        }
        private void setEmsControlParam(MedSrvDO med) {
            currentEmsControl.EmsHeadDO = cof.CreatEmsIntance();
            currentEmsControl.CiEmsDTO = cof.CreatEmsDTO(); ;
            currentEmsControl.EmsHeadDO.PatInfo = this.bannerDto;
            currentEmsControl.EmsHeadDO.Fg_cp = this.bannerDto.Def1;
            currentEmsControl.EmsHeadDO.Str_name_di = diagNameAndCodeArray[0];
            currentEmsControl.EmsHeadDO.Str_code_di = diagNameAndCodeArray[1];
            currentEmsControl.EmsHeadDO.Str_id_diitm = diagNameAndCodeArray[2];
            currentEmsControl.EmsHeadDO.Id_diitm = diagNameAndCodeArray[3];
            currentEmsControl.EmsHeadDO.MedSrvDO = med;
            currentEmsControl.setFeelCiEmsSrvs(null);
        }
    }
}

using iih.ci.diag.dto.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.opemergency.emsfactory;
using iih.ci.ord.opemergency.tool;
using iih.en.pv.dto.d;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;
using iih.ci.ord.reportcard;
using xap.cli.sdk.controls;
using xap.rui.appfw;
using xap.rui.bizcontrol.bannerview;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.engine;
using iih.ci.ord.opemergency.view.basic;
using xap.rui.bizcontrol.bannercontrol;
using iih.bd.bc.udi;
using iih.bd.pp.hpsrvorca.d;
using iih.bl.hp.bdhpindicationdto.d;
using iih.ci.iih.ci.ord.ems.d;
using iih.ci.iih.ci.ord.i;
using xap.mw.serviceframework.ex;
using iih.ci.ord.opemergency.ems;
using iih.ci.ord.opemergency.orddi;
using iih.ci.ord.dicertificate.view;
using xap.cli.sdk.form;
using xap.rui.appfw.extentions;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.dto.d;
using iih.ci.ord.medicaresharing;
using iih.ci.ord.opemergency.dialog;
using iih.ci.ord.opemergency.orderlist.view;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.opemergency.view
{

    /// <summary>
    /// <para>描    述 : 门急诊医生工作站-【医嘱编辑容器】视图 </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.view       </para>    
    /// <para>类 名 称 : MedSrvItemListContainer           </para> 
    /// <para>版 本 号 : v1.0.0.0                          </para> 
    /// <para>作    者 : qzwang                            </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05                </para>
    /// <para>修 改 人 :                                   </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05                </para> 
    /// <para>说    明 :                                   </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class OrdEmsView : BaseFormBizView
    {
        #region 变量定义区域
        private XLayoutPanel rootView;

        // 患者就诊信息（来自于选中就诊患者时候）
        private Ent4BannerDTO ent4BannerDTO;

        private BaseEmsView tableControl;

        private CiOrderDO orderDo;

        private bool isFirstVisit ;

        static int nOpOrValidTime = -1;

        private bool isCreateEms ;        

        #endregion

        #region 构造函数区域
        public OrdEmsView(IEventDelegate o) : base(o)
        {
            isFirstVisit = true;
            isCreateEms = false;
        }
        public OrdEmsView(IEventDelegate o, Ent4BannerDTO ent)
            : base(o)
        {
            this.Name = "处置";
            this.ent4BannerDTO = ent;
            this.GetDefaultEmsView().GetViewModel().SetEnt4BannerDTO(this.ent4BannerDTO);
            this.SwitchEmsView(this.GetDefaultEmsView());
        }

        protected override void InitializeBizView()
        {
            rootView = new XLayoutPanel { Dock = DockStyle.Fill };
            this.AddRender(rootView);
            //base.InitializeBizView();
            // 创建原始表格 - 药品

            this.tableControl = DefaultTableControl;

        }

        private EmptyEmsViewGrid _defaultTableControl;
        private EmptyEmsViewGrid DefaultTableControl
        {
            get { return _defaultTableControl ?? (_defaultTableControl = new EmptyEmsViewGrid(this)); }
        }

        public bool IsCreateEms()
        {
            return this.isCreateEms;
        }

        public override void SetDataPolicy(bool flag)
        {
            base.SetDataPolicy(flag);
            GetEmsView().SetDataPolicy(flag);
        }

        public OrdEmsView SwitchEmsView(BaseEmsView newCard)
        {
            rootView.RemoveRenderAll();
    
            newCard.Dock = DockStyle.None;
            newCard.Context = this.Context;
            this.rootView.AddControl(newCard, ControlPosition.Center);

            return this;
        }

        /// <summary>
        /// 创建固定数据表格部件
        /// </summary>
        //         private void contructControls()
        //         {
        // 
        //             if (!emsViewCache.ContainsKey("EmsDrugsTableViewCard"))
        //             {
        //                 this.tableControl = new EmptyDrugSrvGridView(this);
        // 
        //                 emsViewCache.Add("EmptyDrugSrvGridView", this.tableControl);
        //             }
        //             else
        //             {
        //                 this.tableControl = emsViewCache["EmptyDrugSrvGridView"];
        //             }
        //         }
        #endregion

        #region 父类继承区域

        protected override void DisposeManaged()
        {
            if (tableControl != null) {
                tableControl.Dispose();
                tableControl = null;
            }

            if (_defaultTableControl != null) {
                _defaultTableControl.Dispose();
                _defaultTableControl = null;
            }
            rootView = null;

            // 患者就诊信息（来自于选中就诊患者时候）
            ent4BannerDTO = null;

            tableControl = null;

            orderDo = null;

            isFirstVisit = true;

            nOpOrValidTime = -1;

            isCreateEms = false;
            base.DisposeManaged();
        }

        /// <summary>
        /// 接受系统内的 Banner 控件的患者选中事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if (!this.Created || !(sender is bannerOpdocstation))
                return;

            this.HandleCancelEmsEvent();

            this.ent4BannerDTO = null;

            if (e.Object != null && e.Object is xap.rui.bizcontrol.bannercontrol.BannerData) {
                this.ent4BannerDTO = (e.Object as xap.rui.bizcontrol.bannercontrol.BannerData).Ent4BannerDTO;
            }

            this.GetDefaultEmsView().GetViewModel().SetEnt4BannerDTO(this.ent4BannerDTO);

        }

        #endregion

        #region 内部事件区域
        /// <summary>
        /// 处理诊断证明
        /// </summary>
        private bool HandleProofOfDiagEvent(Ent4BannerDTO e)
        {
            if (e == null || e.Id_ent == null) {
                this.ShowAlert("没有患者信息");

                return false;
            }
            if (BaseEmsView.EmptyPatDIInfo) {
                this.ShowAlert("没有诊断信息");

                return false;
            }

            using (DiCertificateDialog dicerDialog = new DiCertificateDialog(this.ent4BannerDTO, this)) {
                dicerDialog.ShowDialog();
            }

            return true;
        }


        private bool DisplayBlSrvDesTip(CiOrderDO ord)
        {
            bool isFg_selfpay = false;
            HpIndicDocJudgeForm docJudge = new HpIndicDocJudgeForm(new string[] { ord.Id_or }, ord.Sd_srvtp);
           
          
            docJudge.loadFormView(this);
            List<string> msglist = this.GetEmsView().getBlSrvDesList(ord);

            if (msglist == null || msglist.Count == 0) return true;
            Control ctr = this.FindParent<XUserControl>();
            if (ctr == null) return true;
            XMessageDialog form = new XMessageDialog();
            form.MessageList = msglist;
            //form.TimeInterval = 10;//时间设置，默认5秒
            form.Location = new Point(ctr.Left, ctr.Bottom - form.Bounds.Height);
           // form.Show(this);
            return isFg_selfpay;
        } 
        #endregion

        #region 状态处理区域

        /// <summary>
        /// Banner选择事件处理逻辑
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="bannerData"></param>
        /// <returns></returns>
        public override bool OnEventSelected(object sender, object bannerData)
        {
            base.OnEventSelected(sender, bannerData);

            if (bannerData == null) {
                //GetEmsView().SetDataPolicy(false);
                this.GetDefaultEmsView().GetViewModel().SetEnt4BannerDTO(null);
                return true;
            }

            this.HandleCancelEmsEvent();

            if (bannerData is BannerData)
            {
                this.ent4BannerDTO = (bannerData as BannerData).Ent4BannerDTO;

                //if (null != this.ent4BannerDTO && this.ent4BannerDTO.Sd_status == EnDictCodeConst.SD_ENSTATUS_OP_FINISH) {
                //    this.GetDefaultEmsView().SetDataPolicy(false);
                //}
            }

            this.GetDefaultEmsView().GetViewModel().SetEnt4BannerDTO(this.ent4BannerDTO);



            return true;
        }

        /// <summary>
        /// 事件状态处理方法
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="eventArgs"></param>
        public override bool OnEventHandle(object sender, DictionaryEventArgs e)
        {
            bool result = true;
            switch (AssToolEx.EventCodeOfEventArgs(e)) {
                /*执行新建医疗单操作*/
                case EventCodeType.EVENT_EMS_CREATE:
                    result = HandleCreateEms(AssToolEx.ObjectOfEventArgs(e, EmsCreatedParameter.TAGKEY) as EmsCreatedParameter,
                       AssToolEx.ParameterOfEventArgs(e));
                    if (!result) {
                        HandleCancelEmsEvent();
                    }
                    break;

                /*执行编辑修改操作*/
                case EventCodeType.EVENT_EMS_ORDER_EDIT:
                    result = HandleEditOrder((AssToolEx.ObjectOfEventArgs(e, OrderEditParameter.TAGKEY) as OrderEditParameter).OrderItem);
                    break;
                case EventCodeType.EVENT_EMS_DIRECT_EDIT:

                    result = HandleEditEmsDTO((AssToolEx.ObjectOfEventArgs(e, EmsEditParameter.TAGKEY) as EmsEditParameter).EmsDTO);
                    break;
                /*执行保存医疗单操作*/
                case EventCodeType.EVENT_EMS_SAVE:
                    result = HandleSaveEmsEvent(AssToolEx.ObjectOfEventArgs(e, "EmsOrDrugList"));
                    break;

                /*执行保存医疗单操作*/
                case EventCodeType.EVENT_EMS_SAVESUCCESS:
                    result = HandleSaveSuccessEvent();
                    break;

                /*执行取消操作*/
                case EventCodeType.EVENT_EMS_CLOSE:
                    result = HandleCancelEmsEvent();
                    break;

                /*新增一行空数据*/
                case EventCodeType.EVENT_EMS_APPEND:
                    result = this.HandleAppendSrvEvent();
                    break;

                /*执行删除操作*/
                case EventCodeType.EVENT_EMS_DELETE:
                    result = HandleDeleteSrvEvent();
                    break;

                /*处理打开诊断对话框*/
                case EventCodeType.EVENT_ORDI_EDIT:
                    result = HandleOpenDIEvent(this, this.ent4BannerDTO);
                    break;

                /*处理诊断证明*/
                case EventCodeType.THIRD_EVENT_ORSRV_OPOD_OPEN:
                    result = HandleProofOfDiagEvent(this.ent4BannerDTO);
                    break;

                case EventCodeType.EVENT_ORDI_SAVESUCCE:
                    HandleOrDiSaveSuccess(this.isFirstVisit, AssToolEx.ObjectOfEventArgs(e, "DIDTOLIST") as List<DIDTO>);
                    break;

                case EventCodeType.EVENT_EMS_APBU_ADD:
                    result = this.GetEmsView().OnEventHandle(sender, e);
                    break;
                case EventCodeType.EVENT_EMS_ENSTATUS_FIRST:
                    this.isFirstVisit = true;
                    break;
                case EventCodeType.EVENT_EMS_ENSTATUS_RETURN:
                    this.isFirstVisit = false;
                    break;
                case EventCodeType.EVENT_EMS_REFRESH:
                    result = HandleFreshEvent();
                    break;
                case EventCodeType.EVENT_EXPENSE_DATACHANGED:
                    result = this.GetEmsView().OnEventHandle(sender,e);
                    break;
                case EventCodeType.EVENT_EMS_DRUG_USAGE:
                    result = this.GetEmsView().OnEventHandle(sender,e);
                    break;
                case EventCodeType.EVENT_EMS_CARDFOCUS:
                    result = this.GetEmsView().OnEventHandle(sender, e);
                    break;
                default:
                    result = base.OnEventHandle(sender, e);
                    break;
                    
            }
            return result;

        }

        /// <summary>
        /// 处理诊断保存成功逻辑
        /// </summary>
        /// <param name="isFirst"></param>
        /// <param name="listDiDTO"></param>
        private void HandleOrDiSaveSuccess(bool isFirst, List<DIDTO> listDiDTO)
        {
            if (null == listDiDTO)
                return;
            var report = new ReportCardFillJudge(this.ent4BannerDTO);
            var fg = report.IsInfectionReport(listDiDTO);

        }

        /// <summary>
        /// 处理内部的通知消息
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        /// <returns></returns>
        public override bool OnChildNotify(object sender, DictionaryEventArgs e)
        {
            if (this.ent4BannerDTO == null) {
                return base.OnChildNotify(sender, e);
            }

            // 分拣消息通知事件
            switch (AssToolEx.EventCodeOfEventArgs(e)) {
                
                case EventCodeType.NM_ORDI_EDIT:
                    OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_ORDI_EDIT));
                    return true;
                case EventCodeType.NM_EMS_ORSRV_SELECTCHANGED:

                    return GetEmsView().OnEventHandle(sender, e);
                  
                case EventCodeType.NM_UIMSG_LAYOUTCHANGED:
                    GetEmsView().AdjustLayout();
                    return true;
                case EventCodeType.EVENT_EMS_REFRESH:
                    OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EMS_REFRESH));
                    return true;
                case EventCodeType.EVENT_EMS_ORSRV_HP_DATACHANGED:
                    EmsHpDataChangedForMappingExpensView(sender,e);
                    break;
                case EventCodeType.NM_EMS_REFRESULT:
                    GetEmsView().OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EMS_REFRESULT));
                    break;
            }


            return base.OnChildNotify(sender, e);
        }

     /// <summary>
     /// 是否已经判断自费
     /// </summary>
     /// <returns></returns>
        private bool getFgselfpay(BaseEmsViewModel model)
        {
            if (model == null )return false;
            EmsUIDTO uidto =  (model.GetEmsUIDTO() as EmsUIDTO);
            if (uidto != null && uidto.Emsdrugs != null && uidto.Emsdrugs.EmsOrDrug != null)
            {
                XapDataList<EmsOrDrug> emsOrDrug = uidto.Emsdrugs.EmsOrDrug;
               
                foreach (EmsOrDrug drug in emsOrDrug)
                {
                    FArrayList bdhp = drug.BdHpIndicationDTO;
                    if (bdhp == null) return true;
                    foreach (BdHpIndicationDTO bdhpDTO in bdhp)
                    {   /*
                        1	甲类
                        2	乙类
                        3	丙类*/
                        if (bdhpDTO != null && bdhpDTO.Code_hpindicjudged == HpIndicationRuleEnum.NO_CONTROL && bdhpDTO.Sd_hpsrvtp == BdPpDictCodeConst.SD_HP_BJ_THREE)
                        {
                            return true;
                        }
                        if (bdhpDTO != null && bdhpDTO.Code_hpindicjudged == HpIndicationRuleEnum.SYS_CONFIRM && bdhpDTO.Fg_indic == FBoolean.False)
                        {
                            return true;
                        }
                    }
                    
                }
             }   
         return false;
        }



        /// <summary>
        /// 创建医疗服务单
        /// </summary>
        /// <param name="medSrvDO"></param> 
        private bool HandleCreateEms(EmsCreatedParameter emsCreateParameter, object param = null)
        {
            #region 1.有效性验证
            // 针对 Banner 的 有效性判断，该结构中含有患者就诊信息结构
            if (this.ent4BannerDTO == null || emsCreateParameter == null || emsCreateParameter.getMedSrvDO() == null)
                return false;

            var medSrvDO = emsCreateParameter.getMedSrvDO();

            #endregion

            #region 2.获取指定类型的医疗单UI对象
            var t0 = new AssCostTimeTool(String.Format("创建医疗单时候({0})，总耗时：", medSrvDO.Name), false);

            var t1 = new AssCostTimeTool("创建医疗单时候，实例化UI模型耗时：", false);
            var ins = EmsDriverFactory.EmsDriverShare().DriverWith(medSrvDO.Id_srv, medSrvDO.Sd_srvtp, this, this.ent4BannerDTO);
            if (ins == null) {
                return false;
            }

            var emsView = ins.GetEmsView();

            GetDefaultEmsView().ClearContext();

            SwitchEmsView(emsView);

            t1.SaveTimeLog();
            #endregion

            #region 3.医疗单模型加载数据
            emsView.GetViewModel().AddNew();
            if (param == null) {
                param = emsCreateParameter.GetParameter();
            }

            emsView.GetViewModel().SetCustomParam(param);

            // 加载数据
            t1.Reset("创建医疗单时候，数据模型加载数据耗时：");
            if (!emsView.GetViewModel().LoadMedSrv(emsCreateParameter))
            {
                if (!String.IsNullOrEmpty(emsView.GetViewModel().GetErrorMsg()))
                this.SetStatusMsg(emsView.GetViewModel().GetErrorMsg());

                return false;
            }
            if (emsView.GetViewModel().GetTipInfoMsg().Length > 0 && !getFgselfpay(emsView.GetViewModel()))
            {
                this.ShowInfo(this,emsView.GetViewModel().GetTipInfoMsg());
                //emsView.GetViewModel().ClearTipInfo();
            }
            //服务不可开立校验
            if (medSrvDO != null && !String.IsNullOrEmpty(medSrvDO.Id_srv))
            {
                var dic = AssToolEx.OrdEnabelValivate((new String[] { medSrvDO.Id_srv }),this.ent4BannerDTO.Code_entp);
                if (dic.ContainsKey(medSrvDO.Id_srv))
                {
                    //this.SetStatusMsg(dic[medSrvDO.Id_srv]);
                    this.ShowInfo(dic[medSrvDO.Id_srv]);
                    return false;
                }
            }



            ////异步执行的委托
            //xap.rui.appfw.async.AsyncExecuteDelegate workDelegate = workArgs =>
            //{
            //    //参数是Argument，这是自己传入的，自行转化类型
            //    var argList = workArgs.Argument as List<object>;
            //    BaseEmsViewModel model = argList[0] as BaseEmsViewModel;
            //    EmsCreatedParameter crt = argList[1] as EmsCreatedParameter;
            //    // 异步调用，远程服务等。返回结果保存在参数的Result中。
            //    workArgs.Result = model.LoadMedSrv(crt);
            //};
            ////异步执行完毕后，回到调用线程执行的完毕委托
            //xap.rui.appfw.async.AsyncDoneDelegate doneDelegate = doneArgs =>
            //{
            //    //如果已经取消了，则返回
            //    if (doneArgs.Cancelled)
            //        return;
            //    //如果异步执行时发生了异常，可以在这里处理
            //    if (doneArgs.Error != null)
            //    {
            //        Exception ex = doneArgs.Error;
            //        //记录日志
            //        LogManager.GetLogger().ErrorEx(ex.Message, ex);
            //        //发布异常到UI
            //        ex.Publish();
            //        //标记为已处理异常，如果不标记，框架会抛出异常
            //        //doneArgs.ErrorHandled = true;
            //        return;
            //    }

            //    //异步执行完毕后，处理异步数据结果
            //    var data = doneArgs.Result ;
            //};

            ////
            //List<object> argsList = new List<object>();
            //argsList.Add(emsView.GetViewModel());
            //argsList.Add(emsCreateParameter);
            ////
            //workDelegate.AsyncExecute(argsList, doneDelegate);



            // 设置状态
            this.isCreateEms = true;

            // 刷新UI
            emsView.Refresh();
            t1.SaveTimeLog();
            #endregion

            #region 4.其他医疗单状态处理
            // 
            t1.Reset("创建医疗单时候，其他事件处理耗时："); 
            this.allowEdit = true;
            // 允许 UI 编辑
            var ret = this.SentNotify(EventCodeType.NM_UIMSG_ALLOW_EDIT);

            t1.SaveTimeLog();
            t0.SaveTimeLog();
            #endregion

            return ret;
        }
       
        /// <summary>
        ///  处理医嘱编辑逻辑
        /// </summary>
        /// <param name="ciOrderDO"></param>
        /// <returns></returns>
        private bool HandleEditOrder(CiOrderDO ciOrderDO)
        {
            if (this.ent4BannerDTO == null || null == ciOrderDO) {
                this.SetStatusMsg("没有患者相关的就诊信息");
                return false;
            }

            if (string.IsNullOrEmpty(ciOrderDO.Sd_srvtp)) {
                this.ShowInfo("该医嘱没有服务类型");
                return false;
            }

            this.orderDo = ciOrderDO;

            var ins = EmsDriverFactory.EmsDriverShare().DriverWith(ciOrderDO.Id_srv, ciOrderDO.Sd_srvtp, this, this.ent4BannerDTO);
            if (ins == null) {
                return false;
            }

            var emsView = ins.GetEmsView();

            SwitchEmsView(emsView);

            emsView.GetViewModel().EditOrder(ciOrderDO);

            emsView.Refresh();

            // 设置状态
            this.isCreateEms = false;

           
            this.allowEdit = QureyEditEnbale(ciOrderDO, ent4BannerDTO);


            if (!this.allowEdit) {
              
                this.SentNotify(EventCodeType.NM_UIMSG_DISABLE_EDIT);
            }
            else {
               
                this.SentNotify(EventCodeType.NM_UIMSG_ALLOW_EDIT);
            }

            emsView.SetFocus();

            return true;
        }

        /// <summary>
        /// 查询医疗单使能编辑状态
        /// </summary>
        /// <param name="o"></param>
        /// <param name="e"></param>
        /// <returns></returns>
        private bool QureyEditEnbale(CiOrderDO o, Ent4BannerDTO e)
        {
            bool bEnable = o.Sd_su_or.Equals("0") && e.Sd_status != EnDictCodeConst.SD_ENSTATUS_OP_FINISH&&LogicEx.GetInstance().isIdEmpOrEqualIdpsn(o);
            if (-1 == nOpOrValidTime) {
                try {
                    nOpOrValidTime = this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_OpOrValidTime);

                    bEnable &= ((o.Dt_invalid.Value - DateTime.Now).Hours <= nOpOrValidTime);
                }
                catch (XapServiceException ex) {
                    this.SetStatusMsg(ex.ErrorMsg.Message);
                    bEnable = false;
                }

            }

            return bEnable;
        }

        /// <summary>
        /// 处理辅助录入助手新建医疗单逻辑
        /// </summary>
        /// <param name="ems"></param>
        /// <returns></returns>
        private bool HandleEditEmsDTO(CiEmsDTO ems)
        {
            if (this.ent4BannerDTO == null || null == ems) {
                this.SetStatusMsg("没有患者相关的就诊信息");
                return false;
            }

            if (string.IsNullOrEmpty(ems.Sd_srvtp)) {
                this.ShowInfo("该医嘱没有服务类型");
                return false;
            }


            var ins = EmsDriverFactory.EmsDriverShare().DriverWith(ems.Id_srv, ems.Sd_srvtp, this, this.ent4BannerDTO);
            if (ins == null) {
                return false;
            }

            var emsView = ins.GetEmsView();

            SwitchEmsView(emsView);

            emsView.GetViewModel().EditEms(ems);

            emsView.Refresh();

            // 设置状态
            this.isCreateEms = false;

            //this.SentNotify(EventCodeType.NM_UIMSG_CREATE_BUTTONGROUP);
            this.allowEdit = true;

            this.SentNotify(EventCodeType.NM_UIMSG_ALLOW_EDIT);


            return true;
        }


        /// <summary>
        /// 刷新
        /// </summary>
        //private bool HandleRefreshEmsEvent()
        //{
        //    if (GetEmsView() != null) {
        //        GetEmsView().Refresh();

        //        return true;
        //    }

        //    return false;
        //}

        /// <summary>
        /// 向医疗单中追加空数据
        /// </summary>
        private bool HandleAppendSrvEvent()
        {

            this.GetEmsView().AddRow();

            return true;

        }

        /// <summary>
        /// 删除医疗单中服务项目事件
        /// </summary>
        private bool HandleDeleteSrvEvent()
        {

            this.GetEmsView().DeleteRow();

            return true;

        }

        /// <summary>
        /// 取消医嘱录入
        /// </summary>
        private bool HandleCancelEmsEvent()
        {
            if (this.GetEmsView() != this.GetDefaultEmsView())
            {
                // 取消时候清空模型对象
                this.ClearContext().
                    Add<OrdEmsView>().
                    SwitchEmsView(this.GetDefaultEmsView()).
                    GetEmsView().Refresh();
                // 默认的服务录入列表获取焦点
                this.GetDefaultEmsView().SetFocus();
            }

            return true;
        }


        /// <summary>
        /// 保存医疗服务
        /// </summary>
        private bool HandleSaveEmsEvent(Object param = null)
        {
            // 保存的时候，是否成功（成功则返回 医嘱对象）
            //CiOrderTransMissionDTO transMissionDto =  this.GetEmsView().SaveNew();
            //if (transMissionDto.Ciorderaggdo != null)
            //{
                   
              
            //}
            //CiorderAggDO aggDO = ((CiorderAggDO) transMissionDto.Ciorderaggdo[0]);
            CiOrderDO tmpOrderDo = this.GetEmsView().Save();
            List<MedicalSharingDTO> medicalSharinglist = new List<MedicalSharingDTO>();
            if (ent4BannerDTO != null &&   ent4BannerDTO.No_hp != null && ent4BannerDTO.Sd_hptp != null && ent4BannerDTO.Sd_hptp.StartsWith("1"))
             {
                
                 tmpOrderDo =  MedicalInfoRule(tmpOrderDo,medicalSharinglist);
            }
           
            if (tmpOrderDo== null)
            {
                return false;
            }
            if (tmpOrderDo != null && tmpOrderDo.Id_or != null)
            {
                this.orderDo = tmpOrderDo;
                //TODO 弹出提示信息,需要调整成单独线程处理提示信息
                if (tmpOrderDo.Eu_hpindicjudge != (int) HpIndicJudgeEnum.SELFPAY)
                {
                    DisplayBlSrvDesTip(orderDo);
                    bool IsShowMedicalRule = medicalInfoCache.getRepeatMessageDic(orderDo.Id_or);
                    if (!IsShowMedicalRule && medicalSharinglist .Count >0)
                    {
                        MedicalInfoRuleTemporary(medicalSharinglist);
                        medicalInfoCache.ReMoveRepeatMessageDic(orderDo.Id_or);
                   }
                   return this.SentNotify(EventCodeType.NM_EMS_SAVESUCCESS);
                }
               
               return this.SentNotify(EventCodeType.NM_EMS_SAVESUCCESS);
            }
          
            return false;
        }
        /// <summary>
        /// 医保规则
        /// </summary>
        /// <param name="tmpOrderDo"></param>
        private CiOrderDO MedicalInfoRule(CiOrderDO tmpOrderDo, List<MedicalSharingDTO>  medicalSharinglist)
        {
            bool information = false; // fasle  提示， true 终止

            if (tmpOrderDo != null && tmpOrderDo.Mdicalinfo != "" && tmpOrderDo.Mdicalinfo != null)
            {

                String[] hpmessage = tmpOrderDo.Mdicalinfo.Split('^');
                if (medicalSharinglist == null || medicalSharinglist.Count==0)
                {
                        if (hpmessage != null && hpmessage.Length > 1)
                        {
                            foreach (string hpmess in hpmessage)
                            {
                                if (hpmess != null && (hpmess == "Stop"))
                                {
                                    information = true;
                                }

                            }
                            MedicalSharingDTO dto = new MedicalSharingDTO();
                            if (tmpOrderDo.Code_or != null)
                            {
                                dto.Code_or = tmpOrderDo.Code_or;
                            }
                            else
                            {
                                dto.Code_or = "";
                            }
                            dto.Name_srv = tmpOrderDo.Name_or;
                            dto.Reason = hpmessage[1];
                            medicalSharinglist.Add(dto);
                        }
            }
             using(MedicalSharingInfoForm from = new MedicalSharingInfoForm(medicalSharinglist))
                {
                    from.Text = "医保规则验证";
                    if (information)
                    {
                        from.confirmBtn.Visible = false;
                        from.cancelBtn.Text = "确定";
                        if (from.ShowDialog() == DialogResult.OK)
                        {
                            return this.GetEmsView().AgainSaveOrder();
                        }
                        else
                        {
                            medicalSharinglist.Clear();
                            return null;
                        }
                    }
                    else
                    {
                        from.cancelBtn.Visible = false;
                        from.confirmBtn.Text = "确定";
                        return this.GetEmsView().AgainSaveOrder();
                    }
                   
                }
            }
            return tmpOrderDo;
        }


        /// <summary>
        /// 医保规则
        /// </summary>
        /// <param name="tmpOrderDo"></param>
        private string MedicalInfoRuleTemporary(List<MedicalSharingDTO> medicalSharinglist)
        {
            bool information = false; // fasle  提示， true 终止
            
            using (MedicalSharingInfoForm from = new MedicalSharingInfoForm(medicalSharinglist))
            {
                from.Text = "医保规则验证";
                if (!information)
                {
                    from.confirmBtn.Visible = false;
                    from.cancelBtn.Text = "确定";
                    from.ShowDialog();
                    from.Show(this);
                    //if (from.ShowDialog() == DialogResult.OK)
                    //{
                    //    medicalSharinglist.Clear();
                    //    return null;
                    //}
                    //else
                    //{
                    //    medicalSharinglist.Clear();
                    //    return null;

                    //}
                }
            }
            return null;
        }

        /// <summary>
        /// 接收处理医嘱保存成功消息
        /// </summary>
        private bool HandleSaveSuccessEvent()
        {
            // 合理用药
            //this.SentMessage(EventCodeType.EVENT_ORDLIST_NEEDVALIDATE);
            AssToolEx.SentMessage(this, EventCodeType.EVENT_ORDLIST_NEEDVALIDATE);

            string id_or = this.orderDo==null?"":this.orderDo.Id_or;
            AssToolEx.SentMessage(this, UIEvent.SAVE_SUCCESS, "ID_OR", id_or);
           

            if (this.GetEmsViewType() != EmsViewType.EmsApbtViewType)
                this.HandleCancelEmsEvent();

            return true;
        }

        /// <summary>
        /// 刷新
        /// </summary>
        /// <returns></returns>
        private bool HandleFreshEvent()
        {
            AssToolEx.SentMessage(this, UIEvent.REFRESH);
            return true;
        }

        /// <summary>
        /// 打开诊断管理逻辑
        /// </summary>
        /// <param name="o"></param>
        /// <param name="e"></param>
        /// <returns></returns>
        private bool HandleOpenDIEvent(XapBaseControl o, Ent4BannerDTO e)
        {
            bool isOrdersEmpty = false;
            var OrdGridView = this.Context.Config.GetInstance("OrdListView") as OrdGridView;
            if (null != OrdGridView)
            {
                isOrdersEmpty = OrdGridView.IsOrdersEmpty();
            }

            using (OrdDiOpenDialog dlg = new OrdDiOpenDialog(o, e, isOrdersEmpty))
            {
                dlg.ShowDialog(this);
            }

            return true;
        }

        /// <summary>
        /// 获取当前默认医疗单（空医疗单）
        /// </summary>
        /// <returns></returns>
        protected virtual BaseEmsView GetDefaultEmsView()
        {
            if (tableControl.GetViewModel() == null) {
                tableControl.SetViewModel(new EmptyEmsViewModel(this.ent4BannerDTO));
            }
            else {
                tableControl.GetViewModel().SetEnt4BannerDTO(this.ent4BannerDTO);
            }
            return this.tableControl;
        }

        /// <summary>
        /// 当前选项卡
        /// </summary>
        /// <returns></returns>
        public BaseEmsView GetEmsView()
        {
            return this.rootView.ControlCenter as BaseEmsView; ;// this.currentItemView;
        }
        /// <summary>
        /// 医疗单中医保数据变化时，需要同步到费用页签中
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void EmsHpDataChangedForMappingExpensView(object sender, DictionaryEventArgs e)
        {
            EmsOrDrug drug = null;
            if (AssToolEx.ObjectOfEventArgs(e, "Fg_treat") != null)
            {
                var obj = AssToolEx.ObjectOfEventArgs(e, "Fg_treat");
                if (obj != null)
                    drug = obj as EmsOrDrug;
            }
            else if (AssToolEx.ObjectOfEventArgs(e, "Fg_selfpay") != null)
            {
                var obj = AssToolEx.ObjectOfEventArgs(e, "Fg_selfpay");
                if (obj != null)
                    drug = obj as EmsOrDrug;
            }
            if (drug != null)
            {
                this.GetExpenseDatasource().ForEach(p =>
                {
                    if (p.Id_srv == drug.Id_srv)
                    {
                        p.Fg_selfpay = drug.Fg_selfpay;
                        p.Fg_treat = drug.Fg_treat;
                        p.Fg_hpindicjudged = drug.Fg_hpindicjudged;
                    }
                });
            }
        }

        // 临时缓存
        Dictionary<String, BaseEmsView> emsViewCache = new Dictionary<string, BaseEmsView>();

        #endregion

        #region 公共接口

        public CiOrderDO GetOrderObj()
        {
            return this.orderDo;
        }

        public new bool HasErrors()
        {
            return GetEmsView().ExistErrors();
        }

      

        public Ent4BannerDTO GetEnt4BannerDTO()
        {
            return this.ent4BannerDTO;
        }
        /// <summary>
        /// 清空上下文环境
        /// </summary>
        public override BaseFormBizView ClearContext()
        {
            this.GetEmsView().ClearContext(); ;
            return this;
        }


        public object GetEmsTableModel()
        {
            if (this.GetEmsView() != null && this.GetEmsView().GetViewModel() != null) {
                if (this.GetEmsView().GetEmsViewType() == EmsViewType.EmsHerbsViewType) {
                    return (this.GetEmsView().GetViewModel().GetFormDataSource() as EmsDrugItemDO).EmsOrDrugList;
                }
                return this.GetEmsView().GetViewModel().GetTableDataSource();
            }
            return null;
        }

        public EmsViewType GetEmsViewType()
        {
            if (this.GetEmsView() != null) {
                return this.GetEmsView().GetEmsViewType();
            }
            return EmsViewType.EmptyEmsViewType;
        }

        public CiEmsDTO GetCiEmsDTO(bool forceUpdate = false)
        {
            if (this.GetEmsView() != null && this.GetEmsView().GetViewModel() != null) {
                return this.GetEmsView().Save2CiEmsDTO(forceUpdate);
            }
            return null;
        }

        public XapDataList<EmsOrDrug> GetExpenseDatasource()
        {
            if (this.GetEmsView() != null && this.GetEmsView().GetViewModel() != null) {

                return this.GetEmsView().GetViewModel().GetExpenseDatasource();
            }
            return null;
        }

        public void SetClearFeeSrv(bool isClear)
        {
            if (this.GetEmsView() != null && this.GetEmsView().GetViewModel() != null)
            {
                CiEmsDTO emsDto = this.GetEmsView().GetViewModel().getCiEmsDTO();
                if (null != emsDto)
                {
                    emsDto.Fg_prisrvhandled = !isClear;
                }
            }
            
        }

        public bool AllowEdit()
        {
            return this.allowEdit;
        }
       
        #endregion

        
    }
}

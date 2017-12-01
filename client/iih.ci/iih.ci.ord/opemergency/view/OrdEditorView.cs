
using System;
using System.Collections.Generic;
using System.Linq;
using xap.cli.sdk.controls.tabControl;
using System.Windows.Forms;
using System.Drawing;
using iih.ci.ord.opemergency.tool;
using xap.rui.control.extentions;
using iih.ci.ord.opemergency.view.expenseview;
using xap.rui.bizcontrol.bannerview;
using iih.ci.iih.ci.ord.i;
using xap.cli.sdk.controls;
using iih.ci.ord.opemergency.ems.common;
using xap.cli.sdk.render;
using iih.ci.ord.opemergency.controls;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.rui.engine;
using iih.en.pv.dto.d;
using iih.ci.ord.opemergency.emsfactory;
using iih.ci.ord.moreemsdto.d;
using iih.ci.ord.ems.d;
using xap.mw.serviceframework.ex;
using iih.bd.bc.udi;
using iih.ci.ord.opemergency.medreferral.view;
using iih.ci.ord.common.utils.msg;
using iih.bd.srv.ems.d;
using iih.ci.ord.common.utils;
using iih.ci.ord.ciorder.d;
using xap.cli.sdk.form;
using iih.ci.ord.opemergency.declare;
using iih.bd.iih.bd.pp.primd.i;
using xap.mw.serviceframework;
using xap.mw.core.data;
using iih.ci.ord.opemergency.orderlist.view;
using iih.ci.ord.opemergency.action.costant;
using xap.rui.engine2.appwaiting;
using iih.ci.ord.opemergency.view.basic;

namespace iih.ci.ord.opemergency.view
{
    /// <summary>
    /// <para>描    述 : 医嘱录入视图                     </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.view       </para>    
    /// <para>类 名 称 : EmsEditorContainer                       </para> 
    /// <para>版 本 号 : v1.0.0.0                          </para> 
    /// <para>作    者 : qzwang                            </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05                </para>
    /// <para>修 改 人 :                                   </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05                </para> 
    /// <para>说    明 :                                   </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class OrdEditorView : BaseFormBizView,IControlSizeChanged
    {
        #region 私有变量
        private XLayoutPanel rootView = new XLayoutPanel { Dock = DockStyle.Fill };
        private XBaseControl emsLayout = new XBaseControl { Dock = DockStyle.None };
       
        private EmsButtonGroupView buttonGroupView;

        // 患者就诊信息（来自于选中就诊患者时候）
        private Ent4BannerDTO _ent4BannerDTO;
        public Ent4BannerDTO ent4BannerDTO
        {
            get { return _ent4BannerDTO; }
            set {  _ent4BannerDTO = value; }
        }

        private XOrderButtonGroup multiEmsGroup;
        private bool isInited = true;
        private Size orgSize;
        #endregion

        #region 构造方法
        public OrdEditorView()
        {   
        }
        public OrdEditorView(BaseBizView o):base(o)
        {
            this.Context = o.GetContext();
        }

        protected override void InitializeBizView()
        {
            this.Load += OrdEditorView_Load;
        }

        #endregion

        #region 辅助接口方法
        /// <summary>
        /// 开始执行初始化并设置上下文
        /// </summary>
        /// <returns></returns>
        private OrdEditorView BeginInitContext()
        {
            this.isInited = false;

            this.AddRender(rootView);

            buttonGroupView = new EmsButtonGroupView(this) { Dock = DockStyle.None };

            return this;
        }

        /// <summary>
        /// 创建一个复合医疗单对象
        /// </summary>
        /// <param name="title"></param>
        /// <returns></returns>
        private TabEmsView CreateTabEmsView(String title)
        {
            var tabControl = new TabEmsView(this) { Dock = DockStyle.Fill, EmsTitle = title };

            int param = 0;
            try
            {
                param = this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_OpDocBillOperationMode);
            }
            catch (XapServiceException ex)
            {
                this.SetStatusMsg(ex.ErrorMsg.Message);
            }
            catch (System.Exception ex)
            {
                this.SetStatusMsg(ex.Message);
            }
   
            tabControl.CreateTabEmsView(ent4BannerDTO, param);

            tabControl.SelectedChanging += OnTabEmsView_SelectedChanging;
            tabControl.SelectedIndexChanged += OnTabEmsView_SelectedChanged;

            return tabControl;

        }

        /// <summary>
        /// 切换费用页签时候
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void OnTabEmsView_SelectedChanging(object sender, TabChangeEventArgs e)
        {
            if (e.PrevPage.PageControl is OrdEmsView && ((e.PrevPage.PageControl as OrdEmsView).HasErrors()|| this.GetSelectedEmsView().IsEmptyEmsViewType())) {
                e.Cancel = true;
                if (!this.GetSelectedEmsView().IsEmptyEmsViewType()) {
                    this.ShowInfo("处置中含有必填项为空，请填写完整后查看费用信息");
                }   
            }
            else if (e.PrevPage.PageControl is OrdExpenseView && (e.PrevPage.PageControl as OrdExpenseView).ExistErrors()) {
                e.Cancel = true;
                this.ShowInfo("费用中含有必填项为空，请填写完整后查看处置信息");
            }
            else
                e.Cancel = false;
        }

        /// <summary>
        /// 费用页签选择事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void OnTabEmsView_SelectedChanged(object sender, EventArgs e)
        {
            // 切换到费用页签时候
            if ((sender as XTabPage).PageControl is OrdExpenseView)
            {
                // 费用页签内容是否可以编辑
                bool allowEdit = this.GetSelectedEmsView().AllowEdit() && this.GetSelectedEmsView().HasReadOnlyExpenseView();
                if (allowEdit && !this.GetSelectedEmsView().IsEmptyEmsViewType())
                {
                    this.buttonGroupView.ShowEmsButtonGroup(EmsViewType.EmsExpenseViewType, allowEdit);
                }
                else
                {
                    this.buttonGroupView.ShowEmsButtonGroup(EmsViewType.EmptyEmsViewType, GetSelectedEmsView().AllowEdit());
                }

                if (!this.GetSelectedEmsView().IsEmptyEmsViewType() && this.GetSelectedEmsView().GetExpenseView().NeedRefresh()!=0)
                {
                    //只有刷新费用页签的数据时，才重新设置页面的编辑状态
                    this.GetSelectedEmsView().GetExpenseView().SetDataPolicy(allowEdit);
                    this.LoadData();
                    this.GetSelectedEmsView().GetEmsView().GetEmsView().GetViewModel().getCiEmsDTO().Fg_prisrvhandled = true;
                }
                
            } // 切换到医疗单页签时候
            else
            {
               
                this.buttonGroupView.ShowEmsButtonGroup(this.GetSelectedEmsView().GetEmsViewType(), GetSelectedEmsView().AllowEdit());
            }
        }

        /// <summary>
        /// 结束初始化过程，并处理相应上下文
        /// </summary>
        /// <returns></returns>
        public OrdEditorView EndInitContext()
        {
            this.isInited = true;
            return this;
        }

        /// <summary>
        /// 初始化多医疗单容器以及顶部按钮区域
        /// </summary>
        /// <returns></returns>
        public OrdEditorView InitMultiEmsControl()
        {
            if (isInited)  return this;

            // 添加医疗单布局容器
            this.rootView.AddControl(emsLayout, ControlPosition.Center);
            this.rootView.AddControl(new XLayoutPanel { Dock = DockStyle.None }, ControlPosition.Bottom, 36);

            // 利用XBaseControl包装多医疗单Render
            var leftControl = new XBaseControl();
            (rootView.ControlBottom as XLayoutPanel).AddControl(leftControl, ControlPosition.Center);
            // 实例化多医疗单Render
            multiEmsGroup = new XOrderButtonGroup { Location = new Point(0, 0), Size = leftControl.Size, RoundSize = leftControl.Size.Height / 2 };
            multiEmsGroup.SelectChanged += OnMultiEmsPageSelectChanged;
            leftControl.AddRender(multiEmsGroup);

            // 实例化顶部共同按钮区域
            (rootView.ControlBottom as XLayoutPanel).AddControl(this.buttonGroupView, ControlPosition.Right, 360);

            return this;
        }

        /// <summary>
        /// 多医疗单选择事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void OnMultiEmsPageSelectChanged(object sender, EventArgs e)
        {
            Object obj = (sender as XOrderButton).ValueObj;

            if (null != obj && obj is TabEmsView)
            {
                this.SwitchEmsContainer(obj as TabEmsView);
            }
        }
        /// <summary>
        /// 初始化一个默认的医疗单视图
        /// </summary>
        /// <returns></returns>
        public OrdEditorView InitDefaultContainer()
        {
            if (isInited)
                return this;
            // 增加一个默认空医疗单组对象
            SwitchEmsContainer(AddTabEmsView());
            return this;
        }
       
        /// <summary>
        /// 多医疗单显示的情况下，切换方法
        /// </summary>
        /// <param name="o"></param>
        private void SwitchEmsContainer(TabEmsView o)
        {
            this.emsLayout.RenderControls.ToList().ForEach(ctrl =>
            {
                if (ctrl is TabEmsView)
                {
                    (ctrl as TabEmsView).Visible = false;
                }
            });
            o.Visible = true;
                
            o.SelectedIndex = 0;
                
            this.buttonGroupView.ShowEmsButtonGroup(o.GetEmsViewType(), o.AllowEdit());
            this.multiEmsGroup.SetButtonVisible(0, !(this.multiEmsGroup.ButtonCount == 1));
        }

        /// <summary>
        /// 添加一个医疗单视图到编辑器中
        /// </summary>
        /// <param name="param"></param>
        /// <returns></returns>
        protected TabEmsView AddTabEmsView (Object param = null)
        {
            // 多医疗单圆圈序号标题（1、2、3、4、......）
            var o = CreateTabEmsView((multiEmsGroup.ButtonCount+1).ToString());
            // 将医疗单组对象添加到多医疗单容器中，并返回多医疗单的索引按钮对象
            var orderButton = this.multiEmsGroup.AddButton(o.EmsTitle, o) ;
            // 设置医疗单索引按钮圆角直径
            orderButton.RoundSize = orderButton.Size.Width / 2;
            o.Context = this.Context;
            // 将医疗单组对象添加到医疗单布局容器区域
            this.emsLayout.AddRender(o);
          
            return o;
        }

        /// <summary>
        /// 获取当前选中的医疗单
        /// </summary>
        /// <returns></returns>
        private TabEmsView GetSelectedEmsView()
        {
            return this.multiEmsGroup.SelectedButton.ValueObj as TabEmsView;
        }

        /// <summary>
        /// 获取医疗单操作按钮
        /// </summary>
        /// <returns></returns>
        private EmsButtonGroupView GetEmsActionButtonGroupView()
        {
            return buttonGroupView;
        }

        /// <summary>
        /// 设置选中医疗单的按钮提示
        /// </summary>
        /// <param name="tooltip"></param>
        private void SetSelectedEmsViewTooltip(String tooltip)
        {
            this.multiEmsGroup.SelectedButton.ToolTipText = tooltip;
        }

        #endregion

        #region 重写父类

        public override void OnClose()
        {
            // 清理工厂中残存信息
            EmsDriverFactory.EmsDriverShare().Clear();
            BaseEmsView.BaseEmsInfoContext.Clear();
            base.OnClose();
        }
        

        /// <summary>
        /// 接受外部模块发出的 OnSelected 消息事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public override void OnSelected(object sender, xap.rui.control.basecontrol.TargetEventArgs e)
        {

            if (!this.Created || !(sender is bannerOpdocstation))
                return;
            this.ent4BannerDTO = null;
            BaseEmsView.EmptyPatDIInfo = true;
            this.EventCloseEmsHandle(null);
            if (e.Object != null)
            {
                this.ent4BannerDTO = (e.Object as xap.rui.bizcontrol.bannercontrol.BannerData).Ent4BannerDTO;
                if (ent4BannerDTO != null && ent4BannerDTO.Fg_inhpbbr.GetValueOrDefault(false) && ent4BannerDTO.Fg_hpfundpay.GetValueOrDefault(false))
                {
                    this.ShowInfo("患者：" + this.ent4BannerDTO.Name_pat + "存在医保黑名单！");
                }
                
                // 转移到具体医疗单类中
                BaseEmsView.EmptyPatDIInfo = AssToolEx.CheckPatDiInfo(this.ent4BannerDTO);
                BaseEmsView.BaseEmsInfoContext.Clear();
                if (this.ent4BannerDTO != null)
                {
                    resetCiEnContextDTOFromBaseEmsContext();
                }
                
                try {
                    // 是否启用医保标志
                    BaseEmsView.BaseEmsInfoContext.Add("isMedicalInsuranceEnable", this.Context.GetOrgParam<bool>(ICiOrdNSysParamConst.SYS_PARAM_IsMedicalInsuranceEnable));
                    //门诊医保审核处理模式：0:实时交互模式，1：集中交互模式，2：医保部门审核模式
                    BaseEmsView.BaseEmsInfoContext.Add("opMedInsuranceAuditHandel", this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_OpMedInsuranceAuditHandleMode));
                }catch//(Exception ex)
                {
                    this.SetStatusMsg("获取医保参数失败！");
                }
                //组手相关系统参数：1、医生编辑处置区域时，是否自动弹出医嘱组手界面(个人级别)；2、诊疗类医嘱的开单模式；（科室级别）3、组手模板的显示和显示顺序（科室级别）
                BaseEmsView.BaseEmsInfoContext.Add("IsShowOphelperWhenOrOpen", this.Context.GetInstanceParam<bool>(this.Context.PsnInfo.Id_psndoc, "IsShowOphelperWhenOrOpen"));
                BaseEmsView.BaseEmsInfoContext.Add(ICiOrdNSysParamConst.OPDiagTreatTmplOrOpenMode, this.Context.GetDeptParam<string>(ICiOrdNSysParamConst.OPDiagTreatTmplOrOpenMode));
                BaseEmsView.BaseEmsInfoContext.Add(ICiOrdNSysParamConst.OrTmplTypeAndSeqSet4OPOrHelper, this.Context.GetDeptParam<string>(ICiOrdNSysParamConst.OrTmplTypeAndSeqSet4OPOrHelper));

            }
            this.GetSelectedEmsView().OnEventSelected(sender, e.Object);
            this.GetSelectedEmsView().SetSelectDefault();  
           
        }

        private Ent4BannerDTO GetEnt4BannerDTO()
        {
            return this.ent4BannerDTO;
        }




        /// <summary>
        /// 处理消息订阅，并进行内部分发
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public override void HandleState(object sender, xap.rui.engine.DictionaryEventArgs e)
        {
            base.HandleState(sender, e);

            if (IsValidateEvent(AssToolEx.EventCodeOfEventArgs(e))) {
                this.OnEventHandle(sender, e);
            }
        }

        /// <summary>
        /// 内部分发事件处理方法
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        /// <returns></returns>
        public override bool OnEventHandle(object sender, xap.rui.engine.DictionaryEventArgs e)
        {
            bool bRet = true;
            switch (AssToolEx.EventCodeOfEventArgs(e))
            {
                // 处理删除按钮和签署按钮发出的消息
                case EventCodeType.EVENT_ACTION_ORDERDELETE:// UIEvent.DELETE://删除
                case EventCodeType.EVENT_ACTION_ORDERSUBMIT:// "CiSubmit"://签署
                case EventCodeType.EVENT_ACTION_REVETSUBMIT:
                    if (!IsEmptyEms())
                    {
                       // this.SentNotify(EventCodeType.NM_EMS_CLOSE);
                    }
                    break;
                
                case EventCodeType.EVENT_ACTION_HPTRANSFORMFILE:
                    EventOpenMedReferralHandle();
                    break;

                    // 切换到分方页签
                case EventCodeType.EVENT_ORDLIST_SWITCH2PRESS://切换到分方页面
                case EventCodeType.EVENT_ORDLIST_SWITCH2FEEBILL:
                    if (this.Visible) {
                        orgSize = this.Size;
                        this.Size = new System.Drawing.Size(this.Size.Width, 0);
                        this.Visible = false;
                    }
                    
                    break;
                    // 切换到医嘱页面
                case EventCodeType.EVENT_ORDLIST_SWITCH2ORDLIST://切换到分方页面
                    if (!this.Visible) {
                        this.Size = orgSize;
                        this.Visible = true;
                    }
                    
                    break;

                case EventCodeType.EVENT_EMS_TMPL_EDIT:// "ordertemplate":
                    bRet = EventOrderTmplHandle(AssToolEx.ObjectOfEventArgs(e, "order") as MoreEmsParamDTO);
                    break;
                
                // 处理创建医疗单消息
                case EventCodeType.EVENT_EMS_CREATE:
                    bRet = EventCreateMultiEmsHandle(AssToolEx.ObjectOfEventArgs(e, EmsCreatedParamList.TAGKEY) as EmsCreatedParamList);
                   
                    break;
                    // 处理编辑医嘱消息
                case EventCodeType.EVENT_EMS_ORDER_EDIT:
                    // 处理多医疗单编辑逻辑
                    bRet = EventEditSingleOrderHandle(AssToolEx.ObjectOfEventArgs(e, OrderEditParamList.TAGKEY) as OrderEditParamList);
                   
                    break;
                    // 处理删除医疗单消息
                case EventCodeType.EVENT_EMS_DELETE:
                    bRet = this.GetSelectedEmsView().OnEventHandle(sender, e);
                    break;
                    // 处理关闭医疗单消息
                case EventCodeType.EVENT_EMS_CLOSE:

                    bRet = this.EventCloseEmsHandle(this.GetSelectedEmsView());
                    break;
                    // 处理保存医疗单消息
                case EventCodeType.EVENT_EMS_SAVE:
                    bRet = this.GetSelectedEmsView().OnEventHandle(sender, e);
                    break;
                case EventCodeType.EVENT_EMS_SAVESUCCESS:
                    this.GetSelectedEmsView().OnEventHandle(sender, e);
                    EventCloseEmsHandle(this.GetSelectedEmsView());
                    this.buttonGroupView.ShowEmsButtonGroup(this.GetSelectedEmsView().GetEmsViewType(), GetSelectedEmsView().AllowEdit());
                    GetSelectedEmsView().SetSelectDefault();
                    break;
                /*诊断保存成功消息事件*/
                case EventCodeType.EVENT_ORDI_SAVESUCCE:
                case EventCodeType.EVENT_ORDI_CHECK:
                    bRet = this.GetSelectedEmsView().OnEventHandle(sender, e);
                    BaseEmsView.EmptyPatDIInfo = AssToolEx.CheckPatDiInfo(this.ent4BannerDTO);
                    //重置医疗单上下文中的就诊上下文信息
                    resetCiEnContextDTOFromBaseEmsContext();
                    break;
                case EventCodeType.EVENT_EMS_ALLOW_EDIT:
                    this.GetSelectedEmsView().SetEditEnable(true);
                    bRet = buttonGroupView.OnEventHandle(sender, e);
                    break;
                case EventCodeType.EVENT_EMS_DISABLE_EDIT:
                    this.GetSelectedEmsView().SetEditEnable(false);
                    bRet = buttonGroupView.OnEventHandle(sender,e);
                    break;
                case EventCodeType.EVENT_ORDLIST_DELETEORDER:
                    AssToolEx.SentMessage(this, AssToolEx.ResetEventOfEventArgs(e, UIEvent.DELETE));
                    break;
                case EventCodeType.EVENT_EMS_ADD:
                    if (!CheckNewEmsView())
                    {
                        this.OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EMS_CLOSE));
                    }
                    break;
                case EventCodeType.EVENT_EMS_SAVE_FOCUS:
                    bRet = buttonGroupView.OnEventHandle(sender, e);
                    break;
                //case EventCodeType.EVENT_EMS_CARDFOCUS:
                //    AssToolEx.SentMessage(this, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EMS_CARDFOCUS));
                //    break;
                default:
                    bRet = this.GetSelectedEmsView().OnEventHandle(sender, e);
                    break;

            }
            
            return bRet;
        }

        /// <summary>
        /// 处理上层控件发出的消息通知
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        /// <returns></returns>
        public override bool OnChildNotify(object sender, xap.rui.engine.DictionaryEventArgs e)
        {
            bool result = true;
            // 费用保存消息，需要转发到医疗单容器中进行处理
    
            switch(AssToolEx.EventCodeOfEventArgs(e))
            {
                case EventCodeType.NM_EMS_CREATE:
                    result = this.OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EMS_CREATE));
                    break;
                case EventCodeType.NM_EMS_APPEND:
                    result = this.OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EMS_APPEND));
                    break;
                case EventCodeType.NM_EMS_DELETE:
                    result = this.OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EMS_DELETE));
                    break;
                case EventCodeType.NM_EMS_SAVE:
                    result = this.OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EMS_SAVE));
                    break;
                case EventCodeType.NM_EMS_CLOSE:
                    this.OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EMS_CLOSE));
                    break;
              
                case EventCodeType.NM_EMS_APBU_ADD:
                    result = this.OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EMS_APBU_ADD));
                    break;
                
                case EventCodeType.NM_EMS_SAVESUCCESS:
                    this.OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EMS_SAVESUCCESS));
                    break;

                // 费用通知
                case EventCodeType.NM_EXPENSE_SAVE:
                    if (!GetSelectedEmsView().GetExpenseView().ExistErrors()) {
                        result = this.OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EMS_SAVE));
                    }
                    else {
                        this.ShowInfo("费用中含有存在必填项目，请填写完整后在保存！");
                    }
                    
                    break;
                case EventCodeType.NM_EXPENSE_ADD:
                    result = this.GetSelectedEmsView().OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EXPENSE_ADD)); 
                    break;
                case EventCodeType.NM_EXPENSE_DELETE:
                    result = this.GetSelectedEmsView().OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EXPENSE_DELETE));
                    break;
                case EventCodeType.NM_EXPENSE_REFRESH:
                    this.OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EXPENSE_REFRESH));
                    break;

                case EventCodeType.NM_UIMSG_DISABLE_EDIT:
                    this.OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EMS_DISABLE_EDIT));
                    
                    break;
                case EventCodeType.NM_UIMSG_ALLOW_EDIT:
                    this.OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EMS_ALLOW_EDIT));
                    
                    break;
                case EventCodeType.NM_ORDLIST_DELETEORDER:
                    result = this.OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_ORDLIST_DELETEORDER));
                    break;
                case EventCodeType.NM_EMS_SAVE_FOCUS:
                    result = this.OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EMS_SAVE_FOCUS));
                    break;
                case EventCodeType.NM_EMS_CARDFOCUS:
                    result = this.OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EMS_CARDFOCUS));
                    break;
                default:
                    result = false;
                    break;
            }

            return result;
        }

        /// <summary>
        /// 数据异步加载过程
        /// </summary>
        protected override void OnLoadData()
        {
           
            if (HasExpenseView() && !IsEmptyEms())
            {
                var emsOrDrugList = this.GetSelectedEmsView().GetExpenseDatasource();

                bool bRefresh = this.GetSelectedEmsView().GetExpenseView().NeedRefresh() == -1 && GetSelectedEmsView().IsCreateEms();
                this.GetSelectedEmsView().GetExpenseView().ResetModel(this.GetEnt4BannerDTO(), this.GetSelectedEmsView().GetEmsViewType(), emsOrDrugList);
                if (bRefresh) {
                    GetSelectedEmsView().GetExpenseView().SetNeedRefresh(1);
                } 
            }
            
        }

        /// <summary>
        /// 数据填充
        /// </summary>
        protected override void OnFillData()
        {
                this.GetSelectedEmsView().GetExpenseView()
                       .SetEmsContext(this.GetSelectedEmsView().GetEmsTableModel(), this.GetSelectedEmsView().GetCiEmsDTO()).Refresh();

        }


        #endregion

        #region 内部事件
        /// <summary>
        /// 触发 OnInit 接口
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void OrdEditorView_Load(object sender, EventArgs e)
        {
            //AssCostTimeTool.Enabled = false; // 不记录耗时日志统计
            this.
                BeginInitContext().
                InitMultiEmsControl().
                InitDefaultContainer().
                EndInitContext();

            //var orderListView = this.Context.Config.GetInstance("OrdListView") as OrdListView;
            //if (null != orderListView && orderListView.OnDelegateOrdAction == null)
            //{
            //    orderListView.OnDelegateOrdAction = OnDelegateOrdAction;
            //}

            var ordGridView = this.Context.Config.GetInstance("OrdListView") as OrdGridView;
            if (null != ordGridView && ordGridView.OnDelegateOrdAction == null)
            {
                ordGridView.OnDelegateOrdAction = OnDelegateOrdAction;
            }
        }

        public event ControlSizeChangedHandler ControlSizeChanged;

        protected override void OnResize(EventArgs e)
        {
            base.OnResize(e);

            if(ControlSizeChanged!=null)
            {
                ControlSizeChanged(this.Size);
            }
        }


        #endregion

        #region 多医疗单处理过程

        /// <summary>
        /// 医嘱模板处理
        /// </summary>
        /// <param name="o"></param>
        /// <returns></returns>
        protected bool EventOrderTmplHandle(MoreEmsParamDTO o)
        {
            if (!string.IsNullOrEmpty(o.Prompt_msg)) {
                BizAssMessageBoxUtil.ShowInforMsg(o.Prompt_msg);                
            }
          // 有效性检查
            if (o.Errormap2 == null || o.Errormap2.Values.Count == 0)
                return false;

            
            //var waitting = new AssWaittingTool(this.FindForm());

        
            bool hasError = false;

            // 异常处理
            try {
                // 建立等待标志
                NAppWaiting.Instance.Show(this);
                ClearEmsEditorView();
               
                 var emsList = o.Errormap2.Values.Cast<CiEmsDTO>().ToList();
                GetSelectedEmsView().OnEventHandle(this, AssToolEx.DictionaryEventArgsWith(EventCodeType.EVENT_EMS_DIRECT_EDIT, EmsEditParameter.TAGKEY, new EmsEditParameter { EmsDTO = emsList[0] as CiEmsDTO }));
                SetSelectedEmsViewTooltip(o.Errormap2.Keys.Cast<String>().ToList()[0]);
                for (int index = 1; index < emsList.Count; ++index) {
                    var te = this.AddTabEmsView();
                    try {
                        te.OnEventHandle(this, AssToolEx.DictionaryEventArgsWith(EventCodeType.EVENT_EMS_DIRECT_EDIT, EmsEditParameter.TAGKEY, new EmsEditParameter { EmsDTO = emsList[index] as CiEmsDTO }));

                    }
                    catch(Exception e) {
                        this.SetStatusMsg(e.StackTrace);
                        EventCloseEmsHandle(te);
                    }

                    SetSelectedEmsViewTooltip(o.Errormap2.Keys.Cast<String>().ToList()[index]);
                }

                this.SwitchEmsContainer(GetSelectedEmsView());
               // GetEmsButtonGroupView().OnEventHandle(this, AssToolEx.DictionaryEventArgsWith(EventCodeType.EVENT_EMS_ALLOW_EDIT));
            }
            catch(XapServiceException e) {
                this.SetStatusMsg(e.ErrorMsg.Message);
                hasError = true;
            }
            catch(Exception e) {
                this.SetStatusMsg(e.StackTrace);
                hasError = true;
            }
            finally {
                NAppWaiting.Instance.Close();
                if (hasError) {
                    EventCloseEmsHandle(null);
                    this.ShowInfo("医疗单中存在错误，打开失败！");
                }
            }
            //this.ResumeLayout(false);
            //this.PerformLayout();
           
            return true;
        }

        /// <summary>
        /// 创建医疗单
        /// </summary>
        /// <param name="emsCreatedParams"></param>
        /// <returns></returns>
        protected bool EventCreateMultiEmsHandle(EmsCreatedParamList emsCreatedParams)
        {
            if (emsCreatedParams != null && emsCreatedParams.Count > 0)
            {
                if (multiEmsGroup.ButtonCount == 1) {
                    if (!GetSelectedEmsView().IsEmptyEmsViewType()) {
                        GetSelectedEmsView().OnEventHandle(this, AssToolEx.DictionaryEventArgsWith(EventCodeType.EVENT_EMS_CLOSE));
                    }
                    GetSelectedEmsView().OnEventHandle(this, AssToolEx.DictionaryEventArgsWith(EventCodeType.EVENT_EMS_CREATE, EmsCreatedParameter.TAGKEY, emsCreatedParams[0]));
                }
                else {
                    ClearEmsEditorView();

                    GetSelectedEmsView().OnEventHandle(this, AssToolEx.DictionaryEventArgsWith(EventCodeType.EVENT_EMS_CREATE, EmsCreatedParameter.TAGKEY, emsCreatedParams[0]));

                    for (int index = 1; index < emsCreatedParams.Count; ++index) {
                        var o = this.AddTabEmsView();
                        o.GetEmsView().OnEventHandle(this, AssToolEx.DictionaryEventArgsWith(EventCodeType.EVENT_EMS_CREATE, EmsCreatedParameter.TAGKEY, emsCreatedParams[index]));
                    }
                }
                  
                this.SwitchEmsContainer(this.multiEmsGroup.SelectedButton.ValueObj as TabEmsView);
            }
            return true;
        }

        /// <summary>
        /// 编辑医疗单
        /// </summary>
        /// <param name="emsEditParamList"></param>
        /// <returns></returns>
        List<String> hasOpenedOrderList = new List<string>();
        protected bool EventEditMultiEditHandle(OrderEditParamList emsEditParamList)
        {
            if (emsEditParamList != null && emsEditParamList.Count > 0)
            {

                int nCanOpenNum = 6 - this.multiEmsGroup.ButtonCount;
             //   RemoveAllTabEms();
                emsEditParamList.ToList().ForEach(order =>{

                    if (!hasOpenedOrderList.Contains(order.OrderItem.Id_or)) {

                        
                        if (nCanOpenNum-- > 0)
                        {
                            var emsView = this.multiEmsGroup.SelectedButton.ValueObj as TabEmsView;
                            if (this.multiEmsGroup.ButtonCount == 1 && emsView.UID == "") {
                                
                            }
                            else {
                                emsView = this.AddTabEmsView();
                            }
                                
                            emsView.OnEventHandle(this,
                                    AssToolEx.DictionaryEventArgsWith(EventCodeType.EVENT_EMS_ORDER_EDIT, OrderEditParameter.TAGKEY, order)
                                );
                            emsView.UID = order.OrderItem.Id_or;
                            hasOpenedOrderList.Add(emsView.UID);
                        }
                    }
                });
               
               this.SwitchEmsContainer(this.multiEmsGroup.SelectedButton.ValueObj as TabEmsView);
            

            if (null != this.GetSelectedEmsView())
            {
                this.GetSelectedEmsView().SelectedIndex = 0; // 显示医嘱页签
            }
            // 当只有一个医疗单时候，不显示多医疗单按钮
            if (this.multiEmsGroup.ButtonCount == 1)
            {
                this.multiEmsGroup.SetButtonVisible(0, false); // 0， 第一个，隐藏唯一的一个按钮
            }
            else
            {
                this.multiEmsGroup.SetButtonVisible(-1, true); // -1， 全部
            }

            if (emsEditParamList.Count > 6)
            {
                this.SetStatusMsg("最多只能同时打开 6 个医疗单");
            }
            }
            return true;
        }

        /// <summary>
        /// 检查当前所有医疗单中是否存在新建医疗单，或者存在没有保存的医疗单，并提出提示，用户自己决定知否向下执行
        /// </summary>
        /// <returns></returns>
        private bool CheckNewEmsView()
        {
            if (multiEmsGroup.ButtonCount > 1) {
                return !CommonExtentions.IsContinue(this, "提示信息", "存在新建多医疗单，是否继续？");
            }

            if (!GetSelectedEmsView().IsEmptyEmsViewType() && GetSelectedEmsView().IsNew()) {
                return !CommonExtentions.IsContinue(this, "提示信息", "存在未保存医疗单，是否继续？");
            }
            return false;
        }

        private bool beLoading = false;

        /// <summary>
        /// 编辑单医疗单
        /// </summary>
        /// <param name="emsEditParamList"></param>
        /// <returns></returns>
        protected bool EventEditSingleOrderHandle(OrderEditParamList emsEditParamList)
        {
            if (emsEditParamList != null && emsEditParamList.Count > 0) {
                
                if (CheckNewEmsView())
                    return true;

                if (beLoading)
                    return true;
                
                OrderEditParameter ordEditParam = emsEditParamList[0];

                if (GetSelectedEmsView().UID.Equals(ordEditParam.OrderItem.Id_or)) {
                    return true;
                }
                beLoading = true;
              
                bool hasError = false;
                try {
                   // NAppWaiting.Instance.Show(this);
                    ClearEmsEditorView();

                    var emsView = GetSelectedEmsView();
                    emsView.UID = ordEditParam.OrderItem.Id_or;
                    emsView.OnEventHandle(this, AssToolEx.DictionaryEventArgsWith(EventCodeType.EVENT_EMS_ORDER_EDIT, OrderEditParameter.TAGKEY, ordEditParam)
                                    );
                    
                    this.SwitchEmsContainer(this.GetSelectedEmsView());

                }
                catch (XapServiceException e) {
                    this.SetStatusMsg(e.ErrorMsg.Message?? e.ErrorMsg.data);
                    hasError = true;
                }
                catch(Exception e) {
                    this.SetStatusMsg(e.StackTrace);
                    hasError = true;
                }
                finally {
                    beLoading = false;
                   // NAppWaiting.Instance.Close();
                    if (hasError) {
                        EventCloseEmsHandle(null);
                        this.ShowInfo("打开医嘱出现异常情况，请查看日志");
                    }
                }
            }
            return true;
        }
        /// <summary>
        /// 关闭医疗单
        /// </summary>
        /// <param name="emsView"></param>
        /// <returns></returns>
        protected bool  EventCloseEmsHandle(TabEmsView emsView)
        {
            if (emsView == null)
            {
                ClearEmsEditorView();

                hasOpenedOrderList.Clear();
            }
            else if (this.emsLayout.RenderControls.Contains(emsView))
            {
                // 如果当前只有一个医疗单视图，则复用该视图
                if (this.multiEmsGroup.ButtonCount == 1) {
                    emsView.OnEventHandle(this, AssToolEx.DictionaryEventArgsWith(EventCodeType.EVENT_EMS_CLOSE));
                    SwitchEmsContainer(emsView);
                }
                else { // 多个医疗单视图，将传入的医疗单删除
                    this.multiEmsGroup.RemoveButton(this.multiEmsGroup.SelectedButton);
                    this.emsLayout.RemoveRender(emsView);

                    if (!String.IsNullOrEmpty(emsView.UID) && this.hasOpenedOrderList.Contains(emsView.UID)) {
                        this.hasOpenedOrderList.Remove(emsView.UID);
                    }
                        
                    if (this.multiEmsGroup.ButtonCount > 0 ) {
                       
                        SwitchEmsContainer(GetSelectedEmsView());
                    }
                    emsView.Dispose();
                }
                
            }
            
            //if (this.multiEmsGroup.ButtonCount == 0)
            //{
            //    SwitchEmsContainer(AddEmsView());
            //}

            return true;
        }

        /// <summary>
        /// 清除医疗单编辑器上下文，恢复原状
        /// </summary>
        private void ClearEmsEditorView()
        {
            for(int index = this.multiEmsGroup.ButtonCount - 1; index >= 1 ; --index) {
                var emsView = this.multiEmsGroup.GetButtonParamAt(index) as TabEmsView;
 
                this.multiEmsGroup.RemoveButtonAt(index);
                this.emsLayout.RemoveRender(emsView);
                if (emsView != null) {
                    emsView.Dispose();
                }
            }
            this.multiEmsGroup.GetButtonAt(0).Text = "1";
            this.multiEmsGroup.GetButtonAt(0).ToolTipText = "";
            var firstView = this.multiEmsGroup.GetButtonParamAt(0) as TabEmsView;
            if (!firstView.IsEmptyEmsViewType())
                firstView.OnEventHandle(this, AssToolEx.DictionaryEventArgsWith(EventCodeType.EVENT_EMS_CLOSE));
            this.buttonGroupView.ShowEmsButtonGroup(firstView.GetEmsViewType());
        }

        /// <summary>
        /// 打开医疗转诊单
        /// </summary>
        /// <returns></returns>
        protected bool EventOpenMedReferralHandle()
        {
            using (CiMedReferralDialog dlg = new CiMedReferralDialog(this, this.ent4BannerDTO))
            {
                dlg.ShowDialog();
            }

            return true;
        }
        #endregion

        #region 私有辅助方法
        private bool HasExpenseView()
        {
            return this.GetSelectedEmsView().GetExpenseView() != null;
        }

        private bool IsEmptyEms()
        {
            return this.GetSelectedEmsView().GetEmsView() != null && this.GetSelectedEmsView().GetEmsView().GetEmsViewType() == EmsViewType.EmptyEmsViewType;
        }


        private bool IsEntCompleted(Ent4BannerDTO e)
        {
            return (null != e && e.Sd_status == EnDictCodeConst.SD_ENSTATUS_OP_FINISH);
           
        }
        /// <summary>
        /// 重置医疗单上下文中的就诊上下文信息
        /// </summary>
        private void resetCiEnContextDTOFromBaseEmsContext()
        {
            //诊断信息修改后，更新临床上下文信息，包含保外诊断信息
            if (BaseEmsView.BaseEmsInfoContext.ContainsKey("CiEnContextDTO"))
            {
                BaseEmsView.BaseEmsInfoContext.Remove("CiEnContextDTO");
            }
            CiEnContextDTO ciEnContext = CiEnContextUtil.GetCiEnContext(this.ent4BannerDTO, EmsAppModeEnum.SVEMSAPPMODE,this.Context);

            BaseEmsView.BaseEmsInfoContext.Add("CiEnContextDTO", ciEnContext);
            //如果患者的医保计划为空或者患者是高端商保，查询默认医保计划 改为在构造CiEnContextDTO 中查询
            //IPpQueService ppQueService = XapServiceMgr.find<IPpQueService>();
            //FMap hpIdMap = ppQueService.getHpIdForHpCatalog(new string[] { ciEnContext.Id_en });
            //if (hpIdMap != null && hpIdMap[ciEnContext.Id_en] != null)
            //{
            //    ciEnContext.Id_hp_default = (string)hpIdMap[ciEnContext.Id_en];
            //}
        }
        #endregion

        #region 代理实现
        public int OnDelegateOrdAction(CiOrderDO[] szOrder, String evtCode, Object objData)
        {
            String id_or = "";
            int rtn = check(szOrder, ref id_or);
            if (rtn > 0)
                return rtn;
            var curOrder = szOrder.FirstOrDefault(o => o.Id_or.Equals(id_or));
            if (null != curOrder)
            {
                // 针对于【签署】医嘱处理
                if (evtCode.Equals(EventCodeType.EVENT_ACTION_ORDERSUBMIT)) // 签署医嘱
                {
                    var ret = MessageBoxEx.Show("签署的医嘱已经在医疗单中打开，保存(是)、取消(否)、放弃（取消）？", "提示信息", MessageBoxButtons.YesNoCancel, MessageBoxIconEx.Information);
                    if (ret == DialogResult.Yes)
                    {
                        // 不能保存成功，则返回去掉签署
                        if (!this.SentNotify(EventCodeType.NM_EMS_SAVE))
                        {
                            ret = DialogResult.Cancel;
                        }
                    }
                    // 不保存医疗单并签署医嘱
                    else if (ret == DialogResult.No)
                    {
                        this.SentNotify(EventCodeType.NM_EMS_CLOSE);
                    }

                    return (ret != DialogResult.Cancel) ? 1 : 0;
                }
                else if (evtCode.Equals(EventCodeType.EVENT_ORDLIST_DELETEORDER))// 删除医嘱
                {
                    var ret = MessageBoxEx.Show("删除的医嘱已经在医疗单中打开，是否继续？", "提示信息", MessageBoxButtons.YesNo, MessageBoxIconEx.Information);
                    if (ret == DialogResult.Yes)
                    {
                        this.SentNotify(EventCodeType.NM_EMS_CLOSE);
                    }
                    return ret == DialogResult.Yes ? 1 : 0;
                }
                else if (evtCode.Equals(EventCodeType.EVENT_ACTION_REVETSUBMIT)) // 撤回医嘱
                {
                    var ret = MessageBoxEx.Show("撤回的医嘱已经在医疗单中打开，是否继续？", "提示信息", MessageBoxButtons.YesNo, MessageBoxIconEx.Information);
                    if (ret == DialogResult.Yes)
                    {
                        this.SentNotify(EventCodeType.NM_EMS_CLOSE);
                    }
                    return ret == DialogResult.Yes ? 1 : 0;
                }
                else if (evtCode.Equals(OpActionConstant.OP_ORDER_CANCEL_ACTION))
                {
                    var ret = MessageBoxEx.Show("作废的医嘱已经在医疗单中打开，是否继续？", "提示信息", MessageBoxButtons.YesNo, MessageBoxIconEx.Information);
                    if (ret == DialogResult.Yes)
                    {
                        this.SentNotify(EventCodeType.NM_EMS_CLOSE);
                    }
                    return ret == DialogResult.Yes ? 1 : 0;
                }
            }

            return 1;
        }

        private int check(CiOrderDO[] szOrder, ref String id_or)
        {
            // 如果当前为空医疗单，则直接返回True
            if (GetSelectedEmsView().IsEmptyEmsViewType())
            {
                return 2;
            }
            // 获取医疗单对象
            CiOrderDO ord = GetSelectedEmsView().GetEmsView().GetOrderObj();
            // 获取医疗单的CiOrderDO对象，如果为空或者该Order并没有在医疗单中打开，则返回正常签署
            if (ord == null || szOrder.Count(o => o.Id_or.Equals(ord.Id_or)) == 0)
            {
                return 1;
            }
            id_or = ord.Id_or;
            return 0;
        }

        public bool IsValidateEvent(string eventCode)
        {
            string[] third_valid_event_sets =  {
            EventCodeType.EVENT_ACTION_ORDERDELETE,
            EventCodeType.EVENT_ACTION_ORDERSUBMIT,
            EventCodeType.EVENT_ACTION_REVETSUBMIT,
            EventCodeType.EVENT_ORDLIST_SWITCH2FEEBILL,
            EventCodeType.EVENT_ORDLIST_SWITCH2PRESS,
            EventCodeType.EVENT_ORDLIST_SWITCH2ORDLIST,
            EventCodeType.EVENT_EMS_TMPL_EDIT,
            EventCodeType.THIRD_EVENT_MKRMS_ADD,
            EventCodeType.THIRD_EVENT_ORSRV_OPOD_OPEN,
            EventCodeType.EVENT_ACTION_HPTRANSFORMFILE,
            EventCodeType.EVENT_EMS_DRUG_USAGE};
            return eventCode.StartsWith("EVENT_EMS")|| 
                eventCode.StartsWith("EVENT_ORDI") ||
                eventCode.StartsWith("EVENT_EXP") || 
                third_valid_event_sets.Contains(eventCode);

        }
        #endregion
    }
}

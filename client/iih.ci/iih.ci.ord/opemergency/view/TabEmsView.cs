using iih.ci.diag.cidiag.i;
using iih.ci.iih.ci.ord.i;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ems.d;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.view.basic;
using iih.ci.ord.opemergency.view.expenseview;
using iih.en.pv.dto.d;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciorder.d;
using xap.cli.sdk.controls.tabControl;
using xap.cli.sdk.form;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.rui.control.extentions;
using xap.rui.engine;
using xap.rui.engine.registers;
using iih.ci.ord.opemergency.ems;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.opemergency.orddi;
using xap.cli.sdk.common;

namespace iih.ci.ord.opemergency.view
{
    /// <summary>
    /// <para>描    述 :  医疗单组件类                   			</para>
    /// <para>说    明 :  包含处置和费用信息的交互操作                   			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.view    </para>    
    /// <para>类 名 称 :  TabEmsView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  9/28/2016 8:01:23 PM             </para>
    /// <para>更新时间 :  9/28/2016 8:01:23 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class TabEmsView : XTabControl, IEventDelegate, IContext, IXEventPublication
    {
        #region 系统参数Code定义
       
        public const int SYSTEM_PARAM_EXPENSE_NO = 0;
        public const int SYSTEM_PARAM_EXPENSE_RO = 1;
        public const int SYSTEM_PARAM_EXPENSE_RW = 2;
        #endregion

        #region 变量定义
        private IEventDelegate mEeventDelegate = null;

        public String UID = "";
        public String EmsTitle { set; get; }

        public event EventHandler<DictionaryEventArgs> EventSent;

        private BaseContext _context;
        public BaseContext Context
        {
            get
            {
                return _context;
            }
            set
            {
                _context = value;
                if(value!=null)
                {
                    foreach (XTabPage page in this.XTabPages)
                    {
                        if(page.PageControl is IContext)
                        {
                            (page.PageControl as IContext).Context = value;
                        }
                    }
                }
            }
        }
        #endregion

        #region 构造方法
        public TabEmsView(IEventDelegate o)
        {
            this.mEeventDelegate = o;
            this.EventSent += o_EventSent;
        }

        /// <summary>
        /// 增加医疗单页签
        /// </summary>
        /// <param name="o"></param>
        private void AddEmsPage(OrdEmsView o)
        {
            XTabPages.Add(new XTabPage(this)
            {
                Text = o.Name,
                PageControl = o
            });
        }
        /// <summary>
        /// 增加费用页签
        /// </summary>
        /// <param name="o"></param>
        private void AddExpensePage(OrdExpenseView o)
        {
            XTabPages.Add(new XTabPage(this)
            {
                Text = o.Name,
                PageControl = o
            });
        }
        private void TipBlSrvDes(List<string> msglist)
        {
            if (msglist==null || msglist.Count == 0) return;
            Control ctr = this.FindParent<XUserControl>();
            if (ctr == null) return;
            XMessageDialog form = new XMessageDialog();
            form.MessageList = msglist;
            //form.TimeInterval = 10;//时间设置，默认5秒
            form.Location = new Point(ctr.Left, ctr.Bottom - form.Bounds.Height);
           
            form.Show(this);

        }

       

        #endregion

        #region 公共接口
        public bool CreateTabEmsView(Ent4BannerDTO ent, int param )
        {
            // 处置页签
            var ordEmsContainer=new OrdEmsView(this, ent) { Context = this.Context };
            ordEmsContainer.EventSent -= ordEmsContainer_EventSent;
            ordEmsContainer.EventSent += ordEmsContainer_EventSent;
            AddEmsPage(ordEmsContainer);

            // 费用页签
           
            OrdExpenseView ordExpenseView = param > SYSTEM_PARAM_EXPENSE_NO ? new OrdExpenseView(this, param != SYSTEM_PARAM_EXPENSE_RO) : null;
            if (ordExpenseView!=null)
            {
                ordExpenseView.Context = this.Context;
                AddExpensePage(ordExpenseView);
            }
            return true;
        }


        public bool IsCreateEms()
        {
            return GetEmsView().IsCreateEms();
        }
        

        /// <summary>
        /// 获取医疗单视图对象
        /// </summary>
        /// <returns></returns>
        public OrdEmsView GetEmsView()
        {
            for (int index = 0; index < XTabPages.Count; ++index)
            {
                if (XTabPages[index].PageControl is OrdEmsView)
                {
                    return XTabPages[index].PageControl as OrdEmsView;
                }
            }
            return null;
        }
        /// <summary>
        /// 获取费用页签视图对象
        /// </summary>
        /// <returns></returns>
        public OrdExpenseView GetExpenseView()
        {
            for (int index = 0; index < XTabPages.Count; ++index)
            {
                if (XTabPages[index].PageControl is OrdExpenseView)
                {
                    return XTabPages[index].PageControl as OrdExpenseView;

                }
            }
            return null;

        }

        public XapDataList<EmsOrDrug> GetExpenseDatasource()
        {
            return GetEmsView().GetExpenseDatasource();
        }

        /// <summary>
        /// 获取CiEmsDTO 结构对象，用于查询费用项目
        /// </summary>
        /// <returns></returns>
        public CiEmsDTO GetCiEmsDTO()
        {
            return GetEmsView().GetCiEmsDTO();
        }

        /// <summary>
        /// 获取当前医疗单的医嘱模型
        /// </summary>
        /// <returns></returns>
        public Object GetEmsTableModel()
        {
            return GetEmsView().GetEmsTableModel();
        }

        /// <summary>
        /// 设置默认选择页签
        /// </summary>
        /// <param name="index"></param>
        public void SetSelectDefault(int index = 0)
        {
            this.SelectedIndex = index;
        }

        /// <summary>
        /// 获取医疗单类型
        /// </summary>
        /// <returns></returns>
        public EmsViewType GetEmsViewType()
        {
            return GetEmsView().GetEmsViewType();
        }
        /// <summary>
        /// 设置使能编辑状态
        /// </summary>
        /// <param name="enable"></param>
        public void SetEditEnable(bool enable)
        {
            GetEmsView().SetDataPolicy(enable);

            if (HasExpenseView()) {
                GetExpenseView().SetDataPolicy(enable);
            }
        }
#endregion

        #region 使能判断
        public bool IsNew()
        {

            return GetEmsView().IsCreateEms(); ;
        }
        public bool IsEmptyEmsViewType()
        {
            return GetEmsViewType() == EmsViewType.EmptyEmsViewType;
        }

        public bool AllowEdit()
        {
            return GetEmsView().AllowEdit();
        }

        public bool HasExpenseView()
        {
            return GetExpenseView() != null;
        }

        public bool HasReadOnlyExpenseView()
        {
            return GetExpenseView().EnableEdit();
        }

        #endregion

        #region 实现业务事件处理接口
        void o_EventSent(object sender, DictionaryEventArgs e)
        {
            if (GetEventDelegate() is BaseFormBizView) {
                (GetEventDelegate() as BaseFormBizView).FireEventSent(sender, e);
            }
            

        }
        public IEventDelegate GetEventDelegate()
        {
            return this.mEeventDelegate;
        }

        
        public  bool OnEventSelected(object sender, object bannerData)
        {
            var result = GetEmsView().OnEventSelected(sender, bannerData);
            if (this.HasExpenseView())
            {
                GetExpenseView().OnEventSelected(sender, bannerData);
            }
            return result;
        }

        public bool OnEventHandle(object sender, xap.rui.engine.DictionaryEventArgs e)
        {
            bool result = false;
            switch (AssToolEx.EventCodeOfEventArgs(e))
            {
                case EventCodeType.EVENT_EMS_ORDER_EDIT:
                    GetEmsView().OnEventHandle(sender, e);
                    this.XTabPages[0].HasError = GetEmsView().HasErrors();
                    if (this.HasExpenseView()) {
                        this.XTabPages[1].HasError = GetExpenseView().ExistErrors();
                    }
                    
                    break;
                // 处理删除医疗单消息
                case EventCodeType.EVENT_EMS_DELETE:
                    if (GetEmsViewType() == EmsViewType.EmptyEmsViewType)
                        return result;
                    result = GetEmsView().OnEventHandle(sender, e);
                    this.XTabPages[0].HasError = GetEmsView().HasErrors();
                    if (this.HasExpenseView())
                    {
                        GetExpenseView().SetNeedRefresh(1);
                    }
                    break;
                // 处理保存医疗单消息
                case EventCodeType.EVENT_EXPENSE_SAVE:
                case EventCodeType.EVENT_EMS_SAVE:
                    //开立医嘱（点击医疗单确认按钮），判断诊断是否为空，诊断是否更改
                    bool rst = true;
                    if(RelativeUIParam.RELATIVERATIO > RelativeUIParam.TEMPLETECHANGEDRATIO)
                    {
                        var DiListView = this.Context.Config.GetInstance("DiListView") as DiListView;
                        if (null != DiListView)
                        {
                            rst = DiListView.CheckDiEditable(true);
                        }
                    }
                    else
                    {
                        var DiBannerView = this.Context.Config.GetInstance("DiBannerView") as DiBannerView;
                        if (null != DiBannerView)
                        {
                            rst = DiBannerView.CheckDiEditable();
                        }
                    }
                    
                    if (rst)
                    {
                        if (GetEmsViewType() == EmsViewType.EmptyEmsViewType)
                            return result;
                        result = GetEmsView().OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EMS_SAVE));
                    }
                    break;
                // 处理保存医疗单成功时候的消息
                case EventCodeType.EVENT_EMS_SAVESUCCESS:
                    result = GetEmsView().OnEventHandle(sender, e);
                    if (this.HasExpenseView())
                    {
                        GetExpenseView().OnEventHandle(sender, e);
                    }
                    break;
                // 处理医疗单添加空白行消息
                case EventCodeType.EVENT_EMS_APPEND:
                    if (GetEmsViewType() == EmsViewType.EmptyEmsViewType)
                        return result;
                    result = GetEmsView().OnEventHandle(sender, e);

                    this.XTabPages[0].HasError = GetEmsView().HasErrors();
                    // 新增空行，医疗单的数据源内容改变，需要刷新费用页签
                    if (this.HasExpenseView())
                    {
                        GetExpenseView().SetNeedRefresh(1);
                        this.XTabPages[1].HasError = GetExpenseView().ExistErrors();
                    }
                    break;
                case EventCodeType.EVENT_EMS_ORSRV_DATACHANGED:
                    if (GetEmsViewType() == EmsViewType.EmptyEmsViewType)
                        return result;
                    this.XTabPages[0].HasError = GetEmsView().HasErrors();
                    if (HasExpenseView())
                    {
                        GetExpenseView().OnEventHandle(sender,e);
                        this.XTabPages[1].HasError = GetExpenseView().ExistErrors();
                    }
                    // 设置后台重算费用标志
                    GetEmsView().SetClearFeeSrv(true);

                    // 删除费用项目
                    GetExpenseDatasource().ToList().ForEach(p => { GetExpenseDatasource().Delete(p, p.IsNEW); });
                    break;
                // 处理医疗单添加用血消息
                case EventCodeType.EVENT_EMS_APBU_ADD:
                    if (GetEmsViewType() == EmsViewType.EmptyEmsViewType)
                        return result;
                    this.XTabPages[0].HasError = GetEmsView().HasErrors();
                    result = GetEmsView().OnEventHandle(sender, e);
                    break;
                
                case EventCodeType.EVENT_EXPENSE_ADD:
                    if (GetEmsViewType() == EmsViewType.EmptyEmsViewType)
                        return result;
                    if (HasExpenseView())
                    {
                        GetExpenseView().OnEventHandle(sender, e);
                        this.XTabPages[1].HasError = GetExpenseView().ExistErrors();
                    }
                    break;
                case EventCodeType.EVENT_EXPENSE_DELETE:
                    if (GetEmsViewType() == EmsViewType.EmptyEmsViewType)
                        return result;
                    if (HasExpenseView())
                    {
                        GetExpenseView().OnEventHandle(sender, e);
                        this.XTabPages[1].HasError = GetExpenseView().ExistErrors();
                    }
                    break;
                case EventCodeType.EVENT_EXPENSE_DATACHANGED:
                    result = GetEmsView().OnEventHandle(sender, e);
                    break;
                case EventCodeType.EVENT_EMS_CLOSE:
                    GetEmsView().OnEventHandle(sender, e);
                    this.UID = "";
                    this.XTabPages[0].HasError = false;
                    if (HasExpenseView()) {
                        this.XTabPages[1].HasError = false;
                        GetExpenseView().OnEventHandle(sender, e);
                    }
                    break;
                default:
                    result = GetEmsView().OnEventHandle(sender, e);
                    break;

            }
            return result ;
        }

        public bool OnChildNotify(object sender, xap.rui.engine.DictionaryEventArgs e)
        {
            bool result = false;
            // 费用保存消息，需要转发到医疗单容器中进行处理
            var eventCode = AssToolEx.EventCodeOfEventArgs(e);
            switch (eventCode)
            {
                    
                case EventCodeType.NM_EMS_ORSRV_DATACHANGED:
                    //this.XTabPages[0].HasError = GetEmsView().ExistErrors();
                    //if (HasExpenseView()) {
                    //    result = this.GetExpenseView().OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EMS_ORSRV_DATACHANGED));
                    //}
                    this.OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EMS_ORSRV_DATACHANGED));
                    break;

                case EventCodeType.NM_EXPENSE_DATACHANGED:
                    this.XTabPages[1].HasError = GetExpenseView().ExistErrors();
                    this.OnEventHandle(sender, AssToolEx.ResetEventOfEventArgs(e, EventCodeType.EVENT_EXPENSE_DATACHANGED));
                    result = true;
                    break; 

            }
            if (!result)
                return mEeventDelegate.OnChildNotify(sender, e);
            else
                return true;
        }
        #endregion

        #region 系统事件处理
        void ordEmsContainer_EventSent(object sender, DictionaryEventArgs e)
        {
            if (this.EventSent != null) {
                EventSent(sender, e);
            }
            //throw new NotImplementedException();
        }
        protected override void DisposeManaged()
        {
            this.EventSent = null;
            this.mEeventDelegate = null;
            this._context = null;

            base.DisposeManaged();
        }

        public BaseContext GetContext()
        {
            return Context;
        }
        #endregion
    }

    
}

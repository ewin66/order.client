using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.control.basecontrol;
using iih.ci.ord.opemergency.ems.dp;
using xap.cli.sdk.controls.DataView;
using xap.rui.control.forms.control;
using xap.rui.control.forms.model;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.opemergency.tool;
using xap.rui.control.forms.view;
using xap.rui.control.formcontrol.model;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.resource;
using iih.ci.ord.opemergency.view.basic;
using xap.rui.engine.registers;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.control.extentions;
using iih.ci.iih.ci.ord.i;
using iih.en.pv.dto.d;

namespace iih.ci.ord.opemergency.view
{
    #region 医疗单内部类型定义
	/// <summary>
    /// 医疗单内部类型
    /// </summary>
    public enum EmsViewType
    {
        EmptyEmsViewType = -1, // 空状态
        CustomSrvItemViewType = 100,
        EmsDrugsViewType = CustomSrvItemViewType + 1,// 西药
        EmsHerbsViewType = CustomSrvItemViewType + 2,  // 草药
        EmsRisViewType = CustomSrvItemViewType + 3,  // 检查
        EmsLisViewType = CustomSrvItemViewType + 4,  // 检验
        EmsTreatViewType = CustomSrvItemViewType + 5,  //治疗
        EmsApbtViewType = CustomSrvItemViewType + 6,  //备血
        EmsApbuViewType = CustomSrvItemViewType + 7,  //用血
        EmsOpsViewType = CustomSrvItemViewType + 8,  //手术
        EmsPathgyViewType = CustomSrvItemViewType + 9,  // 病理
        EmsConsViewType = CustomSrvItemViewType + 10,  //会诊
        EmsExpenseViewType = CustomSrvItemViewType + 11,  //费用页签
    }
    #endregion
    /// <summary>
    /// <para>描    述 : 业务视图基类定义   </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.view    </para>    
    /// <para>类 名 称 : BaseFormBizView </para> 
	/// <para>版 本 号 :  v1.0.0.0           			</para> 
	/// <para>作    者 :  qzwang         				</para> 
	/// <para>修 改 人 :  qzwang         				</para> 
	/// <para>创建时间 :  2016/7/4 19:35:40             </para>
	/// <para>更新时间 :  2016/7/4 19:35:40             </para> 
	/// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
	/// </summary>
	public class BaseFormBizView : BaseBizView
	{
        #region 常亮定义
        public const string FORM_CARD_PAGECODE = "card";
        public const string FORM_BODY_PAGECODE = "table";
        public const int FORM_CARD_HEIGHT = 140;

        public const int TABLE_HEIGHT_OFFSET = 2;
        #endregion

        #region 公共属性

        /// <summary>
        /// 有效性检查错误列表
        /// </summary>
        public List<string> OrdErrorList = new List<string>();
        /// <summary>
        /// Xap窗口对象是否创建完毕
        /// </summary>
        public bool IsXapFormReady { get
            {
                return this.isXapFormReady;
            }
        }
        

        #endregion 
     
        #region 保护类型变量
        
        /// <summary>
        /// 是否允许编辑
        /// </summary>
        protected bool allowEdit = true;

        /// <summary>
        /// 是否启用医保标志
        /// </summary>
        protected bool isMedicalInsuranceEnable;
        /// <summary>
        /// 门诊医保审核处理模式：0:实时交互模式，1：集中交互模式，2：医保部门审核模式
        /// </summary>
        protected int opMedInsuranceAuditHandel;

        /// <summary>
        /// Xap窗口对象是否创建完毕
        /// </summary>
        protected bool isXapFormReady = false;

        #endregion

        #region 私有变量
        /// <summary>
        /// 表单ID
        /// </summary>
        private String formId;

        /// <summary>
        /// 表单数据源对象
        /// </summary>
        private object formDataSource;
        
        /// <summary>
        /// 基础表单容器
        /// </summary>
        private XapFormControl xapFormControl;

        
        #endregion

        #region 公有方法接口
        public virtual void SetModifiedFlag(bool mdf)
        {

            if (this.GetXapFormControl() != null)
            {
                this.GetXapFormControl().SetFormModified(mdf);
            }
        }

        protected override void OnLoadData()
        {
            if(null != this.Context)
            {
                isMedicalInsuranceEnable = this.Context.GetOrgParam<bool>(ICiOrdNSysParamConst.SYS_PARAM_IsMedicalInsuranceEnable);
                this.opMedInsuranceAuditHandel = this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_OpMedInsuranceAuditHandleMode);
            }
            
        }
        protected override void DisposeManaged()
        {
            UnRegisteFormEventImpl();
            base.DisposeManaged();
        }

        public virtual bool ExistErrors()
        {
            
            if (this.GetXapFormControl() != null) {
                return this.GetXapFormControl().HasErrors;
            }
            return false;
        }

        public virtual string GetErrorText()
        {
            if (this.GetXapFormControl() != null)
            {
                return this.GetXapFormControl().ErrorAlertText;
            }
            return "";
        }

        public virtual void SetFocus()
        {

        }

        public BaseFormBizView SetFormId(String id)
        {
            this.formId = id;

            return this;
        }

        public String GetFormId()
        {
            return this.formId;
        }

        public BaseFormBizView SetFormDataSource(object ds)
        {
            this.formDataSource = ds;

            return this;
        }

        public Object GetFormDataSource()
        {
            return this.formDataSource;
        }

        public Boolean IsEmptyDataSource()
        {
            return this.formDataSource == null;
        }
        

        /// <summary>
        /// 说明：重新布局
        /// </summary>
        public virtual BaseFormBizView AdjustLayout() { return this; }

        /// <summary>
        /// 说明：获取行高
        /// </summary>
        /// <returns></returns>
    

        /// <summary>
        /// 说明：刷新数据
        /// </summary>
        /// <param name="param"></param>
        public virtual void Refresh(object param = null)
        {
            if (this.Created)
            {
                this.LoadData(); // 测试
              
            }
            
        }

        

        /// <summary>
        /// 获取内置算法工具对象
        /// </summary>
        /// <returns></returns>
        public LogicEx GetLogicEx()
        {
            return LogicEx.GetInstance(); 
        }
       

        /// <summary>
        /// 获取表单容器对象
        /// </summary>
        /// <returns></returns>
        public XapFormControl GetXapFormControl()
        {
            return this.xapFormControl;
        }

        /// <summary>
        /// 设置列表的数据访问规则
        /// </summary>
        /// <param name="flag"></param>
        public virtual void SetDataPolicy(bool flag)
        {
            if (this.xapFormControl == null)
                return;

//             if (this.allowEdit == flag)
//                 return;

            this.allowEdit = flag;

            DataPolicy policy = new DataPolicy();
            // 允许新建
            policy.AllowNew = false;
            // 允许编辑
            policy.AllowEdit = flag;
            // 允许删除
            policy.AllowRemove = false;
            // 允许保存
            policy.AllowSave = false;
            // 
            policy.FullEdit = true;
            // 多选
            policy.MultiSelect = true;
            policy.InlineEdit = true;
            // 自动增加新行
            policy.AutoNewRow = false;
            
            // 表单容器对象设置规则
            this.xapFormControl.SetEditPolicy(flag, new DataPolicy[1] { policy });
        }

        /// <summary>
        /// 清理上下文环境
        /// </summary>
        public virtual BaseFormBizView ClearContext()
        {
            this.OrdErrorList.Clear();

            return this;
        }

        public virtual String ErrorDescroption()
        {
            String strErr = "";
                List<String> errorList = this.OrdErrorList;
                errorList.ForEach(
                    p => { strErr += string.Format("{0}.{1}\n", errorList.IndexOf(p) + 1, p); });

                return strErr;

        }
        #endregion

        #region 构造函数

        public BaseFormBizView()
        {
           
        }

        public BaseFormBizView(IEventDelegate o):base(o)
        {
            
        }

        #endregion

        #region 覆盖方法

        protected override void InitializeBizView()
        {
            // 暂停布局
            this.SuspendLayout();
            this.xapFormControl = new xap.rui.control.forms.view.XapFormControl();
            // 
            // xapFormControl
            // 
            this.xapFormControl.AutoSize = true;
            this.xapFormControl.Context = null;
            this.xapFormControl.File = null;
            this.xapFormControl.Dock = System.Windows.Forms.DockStyle.Fill;
            this.xapFormControl.Location = new System.Drawing.Point(0, 0);
            this.xapFormControl.Name = "xapFormControl";
            this.xapFormControl.Size = new System.Drawing.Size(592, 365);
            this.xapFormControl.TabIndex = 0;
            this.xapFormControl.ViewFile = null;

            //this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 14F);
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AddRender(this.xapFormControl);

            this.Name = "业务处理基类";
            // 唤醒布局
            this.ResumeLayout(false);
            this.PerformLayout();
        }

        protected override void OnFillData()
        {
            this.GetXapFormControl().ViewFile = new FormFile()
            {
                FormId = this.formId,
                FormStyle = FormStyle.Card,
                ViewModel = GetFormDataSource(),
            };


            this.SetDataPolicy(this.allowEdit);
        }
        #endregion
        
        

       

        #region  表单事件继承处理
        protected virtual void RegisteFormEventImpl()
        {
            if (this.GetXapFormControl() != null) {
                this.GetXapFormControl().Load += OnXapFormControl_Load;
                this.GetXapFormControl().DataInitNew += OnXapFormControl_DataInitNew;
                this.GetXapFormControl().FormCreated += OnXapFormControl_FormCreated;
                this.GetXapFormControl().ModelFilled += OnXapFormControl_ModelFilled;
                this.GetXapFormControl().AllowEditing += OnXapFormControl_AllowEditing;
                this.GetXapFormControl().RefCanSelect += OnXapFormControl_RefCanSelect;
            }
        }

        protected virtual void UnRegisteFormEventImpl()
        {
            if (this.GetXapFormControl() != null) {
                this.GetXapFormControl().Load -= OnXapFormControl_Load;
                this.GetXapFormControl().DataInitNew -= OnXapFormControl_DataInitNew;
                this.GetXapFormControl().FormCreated -= OnXapFormControl_FormCreated;
                this.GetXapFormControl().ModelFilled -= OnXapFormControl_ModelFilled;
                this.GetXapFormControl().AllowEditing -= OnXapFormControl_AllowEditing;

                this.GetXapFormControl().RefFilter -= OnXapFormControl_RefFilter;
                this.GetXapFormControl().RefResult -= OnXapFormControl_RefResult;
                this.GetXapFormControl().DataChanged -= OnXapFormControl_DataChanged;
                this.GetXapFormControl().DataDisplay -= OnXapFormControl_DataDisplay;
                this.GetXapFormControl().DataVisible -= OnXapFormControl_DataVisible;
                this.GetXapFormControl().RefCanSelect -= OnXapFormControl_RefCanSelect;
            }
        }

        public void RegFormEvent_DataChanged()
        {
            this.GetXapFormControl().DataChanged += OnXapFormControl_DataChanged;
        }

        public void UnRegFormEvent_DataChanged()
        {
            this.GetXapFormControl().DataChanged -= OnXapFormControl_DataChanged;
        }

        public void RegFormEvent_AllowEditing()
        {
            this.GetXapFormControl().AllowEditing += OnXapFormControl_AllowEditing;
        }

        public void UnRegFormEvent_AllowEditing()
        {
            this.GetXapFormControl().AllowEditing -= OnXapFormControl_AllowEditing;
        }

        protected virtual void OnXapFormControl_Load(object sender, EventArgs e)
        {

        }

        protected virtual void OnXapFormControl_DataInitNew(object sender, DataInitNewEventArgs e)
        {

        }

        protected virtual void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            XapFormControl formControl = sender as XapFormControl;
            if (null != formControl && formControl == GetXapFormControl()) {
                formControl.RefFilter += OnXapFormControl_RefFilter;
                formControl.RefResult += OnXapFormControl_RefResult;
                formControl.DataChanged += OnXapFormControl_DataChanged;
                formControl.DataDisplay += OnXapFormControl_DataDisplay;
                formControl.DataVisible += OnXapFormControl_DataVisible;
                
            }
            this.isXapFormReady = true;
        }

        protected virtual void OnXapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            
        }

        protected virtual void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {

        }

        protected virtual void OnXapFormControl_RefFilter(object sender, xap.rui.control.refcontrol.events.RefActivatingEventArgs e)
        {

        }

        protected virtual void OnXapFormControl_RefResult(object sender, xap.rui.control.refcontrol.events.RefResultEventArgs e)
        {

        }
        protected virtual void OnXapFormControl_DataChanged(object sender, DataChangedEventArgs e)
        {

        }
        protected virtual void OnXapFormControl_DataDisplay(object sender, xap.cli.sdk.controls.DataView.Model.XDataDisplayEventArgs e)
        {

        }

        protected virtual void OnXapFormControl_DataVisible(object sender, DataVisibleEventArgs e)
        {

        }

        protected virtual void OnXapFormControl_RefCanSelect(object sender, xap.rui.control.refcontrol.events.RefCanSelectEventArgs e)
        {
            
        }
        /// <summary>
        /// 是否隐藏自费控件
        /// </summary>
        /// <param name="Ent4BannerDTO"></param>
        /// <returns></returns>
        protected virtual bool isHideSelfpay(Ent4BannerDTO Ent4BannerDTO)
        {
            return (Ent4BannerDTO.Id_hp == null) || (Ent4BannerDTO.Fg_hpfundpay != null && !(bool)Ent4BannerDTO.Fg_hpfundpay) || (Ent4BannerDTO.Sd_hptp != null && Ent4BannerDTO.Sd_hptp.StartsWith("2"));
        }
        #endregion



	}
}

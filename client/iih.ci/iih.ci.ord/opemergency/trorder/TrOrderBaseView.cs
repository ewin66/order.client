using iih.bd.bc.udi;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.view;
using iih.ci.ord.opemergency.view.basic;
using System;
using System.Windows.Forms;
using xap.cli.sdk.controls;
using xap.cli.sdk.controls.DataView;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using iih.ci.ord.ems.d;
using xap.cli.sdk.common;
using iih.ci.ord.opemergency.declare;

namespace iih.ci.ord.opemergency.trorder
{
    /// <summary>
    /// <para>描    述 :  医疗单                   			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.trorder    </para>    
    /// <para>类 名 称 :  TrOrderBaseView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  7/28/2016 8:30:12 AM             </para>
    /// <para>更新时间 :  7/28/2016 8:30:12 AM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class TrOrderBaseView : BaseEmsView
    {
        #region 私有变量
        private XLayoutPanel rootPanel;
        private BaseEmsView tableViewControl;
        private BaseEmsView cardViewControl;
        #endregion

        #region 构造方法
        public TrOrderBaseView(IEventDelegate owner = null)
            : base(owner)
        {
        }
        /// <summary>
        /// 初始化业务视图
        /// </summary>
        protected override void InitializeBizView()
        {
            rootPanel = new XLayoutPanel();
            rootPanel.Dock = DockStyle.Fill;


            this.tableViewControl = CreateEmsGridView(this);// 
            this.tableViewControl.Dock = DockStyle.None;
            rootPanel.AddControl(this.tableViewControl, ControlPosition.Center);
            //
            this.cardViewControl = CreateEmsCardView(this);
           
            if (null != this.cardViewControl)
            {
                this.cardViewControl.Dock = DockStyle.None;
                this.srvItemViewType = cardViewControl.GetEmsViewType();
                this.tableViewControl.SetEmsViewType(this.srvItemViewType);
                this.OrdErrorList = cardViewControl.OrdErrorList;
                this.tableViewControl.OrdErrorList = cardViewControl.OrdErrorList;
                this.tableViewControl.SetEmsValidate(cardViewControl.GetEmsValidate());

               
                rootPanel.AddControl(this.cardViewControl, ControlPosition.Bottom, (RelativeUIParam.RELATIVERATIO < 1920 ? BaseEmsView.FORM_CARD_HEIGHT : BaseEmsView.FORM_CARD_HEIGHT + 30));
                rootPanel.BottomWidth = (RelativeUIParam.RELATIVERATIO < 1920 ? BaseEmsView.FORM_CARD_HEIGHT: BaseEmsView.FORM_CARD_HEIGHT+30);
            }

            this.AddRender(rootPanel);
            this.tableViewControl.UnRegFormEvent_AllowEditing(); // 取消原始的AllowEditing事件
            this.tableViewControl.GetXapFormControl().AllowEditing += OnXapFormControl_AllowEditing; // 绑定当前的 AllowEditing

        }

        /// <summary>
        /// 判断视图中是否存在错误
        /// </summary>
        /// <returns></returns>
        public override bool ExistErrors()
        {
            return this.tableViewControl.ExistErrors() || this.cardViewControl.ExistErrors();
        }

        public override void SetFocus()
        {
           if (this.tableViewControl != null && this.tableViewControl.Created)
            {
                this.tableViewControl.SetFocus();
            }
        }

        /// <summary>
        /// 内存回收
        /// </summary>
        protected override void DisposeManaged()
        {
            if (this.tableViewControl != null) {
                this.tableViewControl.GetXapFormControl().AllowEditing -= OnXapFormControl_AllowEditing;
                this.tableViewControl.Dispose();
            }
            if (this.cardViewControl != null) {
                this.cardViewControl.Dispose();
            }

            
            base.DisposeManaged();
        }

        /// <summary>
        /// 刷新布局
        /// </summary>
        /// <param name="e"></param>
        protected override void OnResize(EventArgs e)
        {
            base.OnResize(e);
            if (null != rootPanel)
            rootPanel.DoLayout();
        }

        /// <summary>
        /// 是否允许编辑
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_AllowEditing(object sender, xap.rui.control.formcontrol.model.AllowEditingEventArgs e)
        {
            // 
            var ds = e.Object as EmsOrDrug;

            // 如果判断空行记录，除了服务名称列之外都不可以编辑
            if (!e.PropName.Equals("Name_srv") && String.IsNullOrEmpty(ds.Id_srv))
            {
                e.Cancel = true;
               
            }
            // 当频次下次数是一次的时候，检查的使用天数、总量都不能修改
            else if (e.PropName.Equals("Use_days")) {
                e.Cancel = string.IsNullOrEmpty(ds.Id_freq) || ds.Sd_frequnitct.Equals(BdSrvDictCodeConst.SD_FREQUNIT_ONCE);
            }
            else
            {

            }
        }

        /// <summary>
        /// 创建医疗单选项卡视图
        /// </summary>
        /// <param name="owner"></param>
        /// <returns></returns>
        protected virtual BaseEmsView CreateEmsGridView(IEventDelegate owner = null)
        {
            return new EmsDrugSrvGridView(this); ;
        }
        /// <summary>
        /// 创建医疗单选项卡视图
        /// </summary>
        /// <param name="owner"></param>
        /// <returns></returns>
        protected virtual BaseEmsView CreateEmsCardView(IEventDelegate owner = null)
        {
            return null;
        }

        #endregion

        #region 系统方法
        protected override void OnLoadData()
        {
            //allowEdit = true;
            
        }

        protected override void OnFillData()
        {
            // 设置可编辑状态
//             this.tableViewControl.SetDataPolicy(this.allowEdit);
//             if (null != this.cardViewControl)
//             {
//                 this.cardViewControl.SetDataPolicy(this.allowEdit);
//             }
        }

        public override void SetModifiedFlag(bool mdf)
        {
            if (this.tableViewControl != null)
            {
                this.tableViewControl.SetModifiedFlag(mdf);
            }
            if (null != this.cardViewControl)
            {
                this.cardViewControl.SetModifiedFlag(mdf);
            }
        }
        #endregion

        #region 消息事件


        public override bool OnEventHandle(object sender, xap.rui.engine.DictionaryEventArgs e)
        {
            if (null != tableViewControl)
            {
                tableViewControl.OnEventHandle(sender, e);
            }
            if (null != cardViewControl)
            {
                if (AssToolEx.EventCodeOfEventArgs(e) == EventCodeType.EVENT_EXPENSE_DATACHANGED&&null != tableViewControl)
                {
                    tableViewControl.UnRegFormEvent_DataChanged();
                    cardViewControl.OnEventHandle(sender, e);
                    tableViewControl.RegFormEvent_DataChanged();
                }
                else {
                    cardViewControl.OnEventHandle(sender, e);
                }
                
            }
            return base.OnEventHandle(sender, e);
        }

        public override bool OnChildNotify(object sender, xap.rui.engine.DictionaryEventArgs e)
        {
            if (AssToolEx.EventCodeOfEventArgs(e) == EventCodeType.NM_UIMSG_LAYOUTCHANGED)
            {
                AdjustLayout();
                return true;
            }
            
            return base.OnChildNotify(sender, e);
        }

        #endregion

        #region 接口方法

        /// <summary>
        /// 获取表单选项卡
        /// </summary>
        /// <returns></returns>
        public BaseEmsView GetCardViewControl()
        {
            return cardViewControl;
        }
        /// <summary>
        /// 获取表格控件
        /// </summary>
        /// <returns></returns>
        public BaseEmsView GetTableViewControl()
        {
            return tableViewControl;
        }

        /// <summary>
        /// 设置使能编辑
        /// </summary>
        /// <param name="flag"></param>
        public override void SetDataPolicy(bool flag)
        {
           
            this.allowEdit = flag;

            this.tableViewControl.SetDataPolicy(this.allowEdit);
            if (null != this.cardViewControl)
            {
               
                cardViewControl.SetDataPolicy(allowEdit);
            }
        }
        /// <summary>
        /// 设置模型
        /// </summary>
        /// <param name="m"></param>
        public override void SetViewModel(ems.dp.BaseEmsViewModel m)
        {
            base.SetViewModel(m);

            this.tableViewControl.SetViewModel(m);
            if (null != this.cardViewControl)
            {this.cardViewControl.SetViewModel(m);}
        }


        /// <summary>
        /// 布局调整
        /// </summary>
        /// <returns></returns>
        public override BaseFormBizView AdjustLayout()
        {
           
            if (null != this.cardViewControl)
            {
                int bottomHeight = (RelativeUIParam.RELATIVERATIO < 1920 ? BaseEmsView.FORM_CARD_HEIGHT : BaseEmsView.FORM_CARD_HEIGHT + 30);
                int unfixedHeight = this.tableViewControl.GetFixedSize().Height + TABLE_HEIGHT_OFFSET;
                if ((this.Size.Height - unfixedHeight) < BaseFormBizView.FORM_CARD_HEIGHT)
                {
                    rootPanel.BottomWidth = bottomHeight-6;
                }
                else
                {
                    rootPanel.BottomWidth = this.Size.Height - unfixedHeight;
                }
                this.rootPanel.DoLayout();

                this.cardViewControl.AdjustLayout();
            }
            return this;
        }

        /// <summary>
        /// 新增行
        /// </summary>
        /// <param name="param"></param>
        /// <returns></returns>
        public override BaseFormBizView AddRow(object param = null)
        {
            if (tableViewControl != null)
            {
                tableViewControl.AddRow(param);
            }

             return this;// AdjustLayout();
        }

        /// <summary>
        /// 删除行
        /// </summary>
        /// <param name="param"></param>
        /// <returns></returns>
        public override BaseFormBizView DeleteRow(object param = null)
        {
            if (this.GetViewModel().GetCountWithOutDelete() == 1) {
                this.ShowInfo("不允许删除最后一个，请直接修改服务名称或者取消");
                return this;
            }
            base.DeleteRow(param);
            
            this.SentNotify(EventCodeType.NM_EMS_ORSRV_DATACHANGED);
            return AdjustLayout();
        }

        public override BaseFormBizView ClearContext()
        {
            base.ClearContext();
            if (this.tableViewControl != null)
                this.tableViewControl.ClearContext();
            this.tableViewControl.SetEmsViewType(this.GetEmsViewType());
            if (this.cardViewControl != null)
                this.cardViewControl.ClearContext();
            return this;
        }

        public override bool OrdValivate()
        {
            return true;
        }

        public override string ErrorDescroption()
        {
            return base.ErrorDescroption();
        }

        public override CiOrderDO Save()
        {
            // 判断医疗单所有的UI是否加载完毕
            if (this.GetTableViewControl().IsLoading || this.GetCardViewControl().IsLoading)
            {
                this.SetStatusMsg("医疗单正在处理数据，请稍后保存");
                return null;
            }
            // 保存前映射数据以及有效性检查（由于表格部件为公用，所以医疗单的的选项卡检查数据有效性即可）
            // 判断检查列表中是否含有错误信息
            if (this.GetTableViewControl().OrdValivate() && this.GetCardViewControl().OrdValivate())
            {
                return this.GetViewModel().Save2Order();
            }
            else
            {
                this.ShowInfo(" 医疗单有效性验证失败，请检查错误！\n" + this.ErrorDescroption(), "提示:");
            }
            return null;
        }

        public override CiEmsDTO Save2CiEmsDTO(bool forceUpdate)
        {
            if (GetCardViewControl() != null)
            {
                return GetCardViewControl().Save2CiEmsDTO(forceUpdate);
            }
            return null;
        }

        public override void Refresh(object param = null)
        {
            base.Refresh(param);
            if (this.tableViewControl != null) {
                this.tableViewControl.Refresh(param);
            }

            if (this.cardViewControl != null) {
                this.cardViewControl.Refresh(param);
            }
        }

        #endregion
    }
}

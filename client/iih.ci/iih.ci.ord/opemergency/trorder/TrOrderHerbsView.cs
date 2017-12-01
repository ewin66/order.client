using iih.ci.ord.opemergency.ems;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.view.basic;
using xap.rui.control.basecontrol;
using iih.ci.ord.opemergency.tool;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.cli.sdk.controls.DataView;
using xap.rui.control.extentions;
using iih.ci.ord.opemergency.view;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.ciordems.d;
using System.Windows.Forms;
using System;
using iih.ci.ord.opemergency.declare;
using xap.rui.control.formcontrol.model;
using iih.bd.srv.medsrv.d;

namespace iih.ci.ord.opemergency.trorder
{
    /// <summary>
    /// <para>描    述 :  草药医疗单视图                   	</para>
    /// <para>说    明 :  简洁版                   			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.trorder    </para>    
    /// <para>类 名 称 :  TrOrderHerbsView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  7/28/2016 8:23:12 AM             </para>
    /// <para>更新时间 :  7/28/2016 8:23:12 AM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class TrOrderHerbsView : TrOrderBaseView
    {
        #region 构造函数
        public TrOrderHerbsView(IEventDelegate owner = null)
            : base(owner)
        {
            
        }
        #endregion

        #region 重载方法

        protected override BaseEmsView CreateEmsGridView(IEventDelegate owner = null)
        {
            return new EmsHerbsViewGrid(owner);
        }

        /// <summary>
        /// 创建选项卡视图
        /// </summary>
        /// <param name="owner"></param>
        /// <returns></returns>
        protected override BaseEmsView CreateEmsCardView(IEventDelegate owner = null)
        {
            return new EmsHerbsViewCard(owner);
        }

        protected override void InitializeBizView()
        {
            base.InitializeBizView();

            this.GetTableViewControl().RegEnterKeyOverEvent((row) => {
                // 追加一行
                this.SentNotify(EventCodeType.NM_EMS_APPEND);
                return true;
            });
             //enter键调整光标位置
            this.GetTableViewControl().GetXapFormControl().EnterKeyDown += TrOrderDrugsView_EnterKeyDown;
        }

        void TrOrderDrugsView_EnterKeyDown(object sender, KeyEventArgs e)
        {
            XDataRow row = sender as XDataRow;
            bool result = true;
            if (row != null && row.DataTable!=null && row.DataTable.ParentControl.FocusedCell != null)
            {
                switch (row.DataTable.ParentControl.FocusedCell.FieldName)
                {
                    case "Name_srv":
                        if (string.IsNullOrEmpty(row.RowData["Name_srv"].ToString()))
                        {
                            if (row.IsLast)
                            {
                                this.SentNotify(EventCodeType.NM_EMS_CARDFOCUS);
                                (this.GetViewModel() as EmsHerbsViewModel).SelectLastHerbs();
                                
                            }
                        }
                        else
                        {
                            result = false;
                        }
                        break;
                    case "Name_mp_dep":
                        this.SentNotify(EventCodeType.NM_EMS_APPEND);
                        break;
                    default:
                        result = false;
                        break;
                }
            }

            e.Handled = result;
        }

        protected override void OnXapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            var ds = e.Object as EmsOrDrug;
            if (e.PropName.Equals("Price"))
            {
                e.Cancel = !(ds.Eu_blmd == Convert.ToInt32(MedSrvBlModeEnum.MANUALBL));
            }
            else
            {
                base.OnXapFormControl_AllowEditing(sender, e);
            }

        }

        /// <summary>
        /// 处理子窗口通知事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        /// <returns></returns>
        public override bool OnChildNotify(object sender, xap.rui.engine.DictionaryEventArgs e)
        {
            if (AssToolEx.EventCodeOfEventArgs(e) == EventCodeType.NM_TABLE_CLICK)
            {
                XDataRow row = AssToolEx.ObjectOfEventArgs(e, EventCodeType.NM_TABLE_CLICK) as XDataRow;
                this.GetCardViewControl().Cell_MouseClick(row);
                return true;
            }
            return base.OnChildNotify(sender, e);
        }

        /// <summary>
        /// 增加一空行记录
        /// </summary>
        /// <param name="param"></param>
        /// <returns></returns>
        public override BaseFormBizView AddRow(object param = null)
        {
            if (GetViewModel() is EmsHerbsViewModel) {

                if ((GetViewModel() as EmsHerbsViewModel).HasEmptyHerbs()) {
                    this.ShowInfo("已经追加了一条空行记录，请先填写完整");
                    return this;
                }
            }

            return base.AddRow(param);
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

            this.GetCardViewControl().OnEventHandle(this, AssToolEx.DictionaryEventArgsWith(EventCodeType.EVENT_EMS_ORSRV_DATACHANGED));
            return AdjustLayout();
        }

        
        #endregion
    }
}

using xap.rui.control.basecontrol;
using iih.ci.ord.opemergency.validate;
using xap.rui.control.refcontrol.events;
using xap.rui.control.forms.model;
using xap.rui.control.forms.control;
using iih.ci.ord.ciordems.d;
using xap.cli.sdk.controls;
using iih.bd.srv.medsrv.i;
using xap.mw.serviceframework;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.view;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.view.basic;
using System.Windows.Forms;
using System;
using iih.ci.ord.opemergency.emsfactory;
using iih.ci.ord.ems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.opemergency.declare;
using xap.rui.control.formcontrol.model;

namespace iih.ci.ord.opemergency.ems
{

    /// <summary>
    /// <para>描    述 : 病理医疗单                      </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.ems     </para>    
    /// <para>类 名 称 : PathgySrvItemView               </para> 
    /// <para>版 本 号 : v1.0.0.0                        </para> 
    /// <para>作    者 : qzwang                          </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05              </para>
    /// <para>修 改 人 :                                  </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05              </para> 
    /// <para>说    明 :                                 </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EmsPathgyViewCard : BaseEmsFormView
    {
        #region 变量定义区域
        private PathgySrvTableView pathgySrvTableView;
        private XLayoutPanel tabPropertyTable;

        protected EnumPathyCardTp enumPathyCardTp;
        #endregion

        #region 构造函数区域
        public EmsPathgyViewCard(IEventDelegate owner = null)
            : base(owner)
        {
            
            this.srvItemViewType = EmsViewType.EmsPathgyViewType;
            this.iValidate = new EmsPathgyValidate();

            tabPropertyTable = new XLayoutPanel() { Dock = DockStyle.Bottom };
            tabPropertyTable.Height = this.Height;
            this.Controls.Add(tabPropertyTable);
        }
       
        protected override void InitializeBizView()
        {
            base.InitializeBizView();

            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsPathgyViewCard/*"2016060810175260011H"*/);
            this.SetGridPageCode("name_samptp");
            this.RegisteFormEventImpl();
            
        }

        protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            base.OnXapFormControl_ModelFilled(sender, e);
            if (this.GetViewModel() != null)
            {
                this.GetGridControl().DataTable.DataSource = this.GetViewModel().GetTableDataSource();
            }

            AdjustLayout();
            
        }

        
        #endregion

        #region 父类继承区域
        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            if (pathgySrvTableView != null)
                pathgySrvTableView.RefreshData(this.GetViewModel());
        }

        /// <summary>
        /// 发送树节点选中事件到卡上显示数据
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public override void SetDataPolicy(bool flag)
        {
            //base.SetDataPolicy(flag);
            this.allowEdit = flag;
            this.GetXapFormControl().SetEditable(flag);
        }

        public override CiOrderDO Save()
        {
            this.pathgySrvTableView.SaveBefore();

            return base.Save();
        }
        #endregion

        #region 内部事件区域

        protected override void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.OnXapFormControl_FormCreated(sender, e);

            switch (enumPathyCardTp)
            {
                case EnumPathyCardTp.PKU:
                    this.pathgySrvTableView = new PKUPathgySrvTableView(this.GetViewModel());
                    break;
                case EnumPathyCardTp.HDW:
                    this.pathgySrvTableView = new HDWPathgySrvTableView(this.GetViewModel());
                    break;
                default:
                    this.pathgySrvTableView = new PathgySrvTableView(this.GetViewModel());
                    break;
            }
            //this.pathgySrvTableView.delegateMouseClick += PathgySrvItemView_MouseClick;
            this.tabPropertyTable.AddControl(pathgySrvTableView, ControlPosition.Center);

            pathgySrvTableView.SetDataPolicy(this.allowEdit);
        }

        /// <summary>
        /// 引用参照结果处理
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_RefResult(object sender, RefResultEventArgs e)
        {
            // 参照取回数据后，处理显示名称 服务名称
            if (e.BindingFieldName.Equals("Name_srv"))
            {
                //// 如模型为空  第一次创建
                //IMedsrvMDOCrudService service = XapServiceMgr.find<IMedsrvMDOCrudService>();
                //MedSrvDO medSrcDO = service.findById((e.DataObject as EmsPathgyItemDO).Id_srv);
                //// 第一次新建或者服务不一致，都认为重新计算UI展现
                //int rowCount = this.GetGridControl().DataTable.Rows.Count;
                //if (this.GetViewModel() == null || rowCount == 1)
                //{

                //    // SentNotify(EventCodeType.NM_EMS_CREATE, EmsCreatedParameter.TAGKEY, new EmsCreatedParameter(medSrcDO, null));
                //    this.SentNotify(EventCodeType.NM_EMS_CREATE, EmsCreatedParamList.TAGKEY, new EmsCreatedParamList() { new EmsCreatedParameter(medSrcDO, null) });
                //}
                if (e.RefResultSet.IsEmpty)
                {
                    SentNotify(EventCodeType.NM_EMS_CLOSE);
                }
                else
                {
                    this.GetViewModel().LoadMedSrv(new EmsCreatedParameter(new bd.srv.medsrv.d.MedSrvDO() { Id_srv = (e.DataObject as EmsPathgyItemDO).Id_srv }, null));
                }
            }
        }

        protected override void OnXapFormControl_RefFilter(object sender, RefActivatingEventArgs e)
        {
            if (null != this.GetViewModel()) {
                var sbm = new StringObjectMap();
                e.WherePart = GetViewModel().OnRefFilterData(e.BindingFieldName,sbm);
                if (e.BindingFieldName.Equals("Name_diag"))
                {
                    e.RefParams.AddParam("id_ent", (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).PatInfo.Id_ent);
                }
                foreach (var item in sbm)
                {
                    e.RefParams.AddParam(item.Key, item.Value);
                }
            }
           
        }
        protected override void OnXapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            if (e.PropName.Equals("Name_srv") && null != this.GetViewModel() && !System.String.IsNullOrEmpty(GetViewModel().getCiEmsDTO().Id_or))
            {
                e.Cancel = true;
            }
            else
            {
                base.OnXapFormControl_AllowEditing(sender, e);
            }
            
        }
        #endregion

        #region 辅助处理区域
        private void PathgySrvItemView_MouseClick(string strCommond)
        {
            this.SentNotify(strCommond, null);
        }
        #endregion

        public override BaseFormBizView AdjustLayout()
        {

            this.tabPropertyTable.Height = this.Size.Height - this.GetFixedSize().Height-5;

            return this;
        }
    }
}

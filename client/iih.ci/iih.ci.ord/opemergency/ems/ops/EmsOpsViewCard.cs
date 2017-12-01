using System;
using System.Collections.Generic;
using xap.rui.control.forms.control;
using iih.ci.ord.ciordems.d;
using xap.rui.appfw;
using xap.cli.sdk.controls.DataView;
using System.Windows.Forms;
using xap.cli.sdk.bindings;
using xap.mw.serviceframework;
using xap.rui.bizcontrol.IndicatorControl;
using xap.cli.sdk.controls.DataView.Model;
using xap.rui.control.refcontrol.events;
using iih.bd.srv.medsrv.i;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.opemergency.validate;
using iih.ci.ord.opemergency.view;
using iih.ci.ord.opemergency.ems.common;
using xap.rui.control.basecontrol;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.view.basic;
using iih.ci.ord.cior.d;
using xap.mw.core.data;
using iih.ci.ord.opemergency.declare;
using xap.rui.control.formcontrol.model;

namespace iih.ci.ord.opemergency.ems
{
    /// <summary>
    /// <para>描    述 : 手术医疗单                      </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.ems     </para>    
    /// <para>类 名 称 : OperationSrvItemView               </para> 
    /// <para>版 本 号 : v1.0.0.0                        </para> 
    /// <para>作    者 : qzwang                          </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05              </para>
    /// <para>修 改 人 :                                  </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05              </para> 
    /// <para>说    明 :                                 </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EmsOpsViewCard : BaseEmsFormView
    {
      
        private XIndicatorControl indicatorControl;

        public EmsOpsViewCard(IEventDelegate o)
            : base(o)
        {
           
            this.srvItemViewType = EmsViewType.EmsOpsViewType;
            this.iValidate = new EmsOpsValidate();

            
        }

        protected override void InitializeBizView()
        {
            base.InitializeBizView();

            XBindingList bindingList = new XBindingList();
            indicatorControl = new XIndicatorControl();
            indicatorControl.Location = new System.Drawing.Point();
            bindingList.Add(new XBinding("ValueText", "Val_rstrptla"));

            indicatorControl.Category = "Val_restrptlab";
            indicatorControl.TitleName = "Name_srv";
            indicatorControl.Type = "Sd_restrptlabtp";
            indicatorControl.ValueString = "Val_rstrptla";
            indicatorControl.Unit = "Name_unit";//
            indicatorControl.TopSpace = 0;
            indicatorControl.LeftSpace = 0;
            indicatorControl.RenderWidth = 230;
            indicatorControl.RenderTitleWidth = 60;
            indicatorControl.ColumnSpace = 0;
            indicatorControl.RenderTitleWidth = 114;
            Dictionary<string, Control> controls = new Dictionary<string, Control>();
            controls.Add("item", indicatorControl);
            this.GetXapFormControl().RegisterControl(controls);

            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsOpsViewCard/*"201606130356497205ZD"*/);
            this.SetGridPageCode("table");
            this.RegisteFormEventImpl();
            this.allowEdit = true;
        }

        protected override void OnXapFormControl_DataChanged(object sender, xap.rui.control.forms.model.DataChangedEventArgs e)
       {
            if (this.GetViewModel() != null && !this.GetViewModel().IsEmpty() && e.Input != null)
            {
                this.GetViewModel().OnDataChanged(e.Data, e.PropName, e.Input.ToString());
            }
        }

        protected override void OnXapFormControl_RefFilter(object sender, RefActivatingEventArgs e)
        {
            var sbm = new StringObjectMap();
            if (this.GetViewModel() != null && !this.GetViewModel().IsEmpty())
            {

                e.WherePart = this.GetViewModel().OnRefFilterData(e.BindingFieldName,sbm);
                if (e.BindingFieldName.Equals("Name_diag"))
                {
                    e.RefParams.AddParam("id_ent", (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).PatInfo.Id_ent);
                }
            }
            else
            {
                e.WherePart = "";
            }
            foreach (var item in sbm)
            {
                e.RefParams.AddParam(item.Key, item.Value);
            }
        }

        protected override void OnXapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            var ds = e.Object as EmsOpitemDO;
            if (e.PropName.Equals("Price"))
            {
                e.Cancel = !(ds.Eu_blmd == Convert.ToInt32(MedSrvBlModeEnum.MANUALBL));
            }
            else if (e.PropName.Equals("Name_srv") && null != this.GetViewModel() && !System.String.IsNullOrEmpty(GetViewModel().getCiEmsDTO().Id_or))
            {
                e.Cancel = true;
            }
            else
            {
                base.OnXapFormControl_AllowEditing(sender, e);
            }

        }

        protected override void OnXapFormControl_RefResult(object sender, RefResultEventArgs e)
        {

            if (null == this.GetViewModel() || !this.GetViewModel().OnRefResultData(e.BindingFieldName, e.RefResultSet))
            {
                // 参照取回数据后，处理显示名称 服务名称
                if (e.BindingFieldName.Equals("Name_srv"))
                {

                    if (e.RefResultSet.IsEmpty)
                    {
                        SentNotify(EventCodeType.NM_EMS_CLOSE);
                    }
                    else
                    {
                        this.GetViewModel().LoadMedSrv(new EmsCreatedParameter(new bd.srv.medsrv.d.MedSrvDO() { Id_srv = (e.DataObject as EmsOpitemDO).Id_srv }, null));
                    }
                    

                    //IMedsrvMDOCrudService service = XapServiceMgr.find<IMedsrvMDOCrudService>();
                    //MedSrvDO medSrcDO = service.findById((e.DataObject as EmsOpitemDO).Id_srv);
                    //if (null == medSrcDO)
                    //{
                    //    return;
                    //}
                    ////
                    //int rowCount = this.GetGridControl().DataTable.Rows.Count;
                    //var rowDatasource = this.GetGridControl().GetFocusedRow<EmsOpitemDO>();

                    //if (this.GetViewModel() == null || rowCount == 1 ) {
                    //    this.SentNotify(EventCodeType.NM_EMS_CREATE, EmsCreatedParamList.TAGKEY, new EmsCreatedParamList() { new EmsCreatedParameter(medSrcDO, null) });
                    //}
                    // 暂时注释下列代码，由于保存逻辑不支持 诊疗服务 更新
                    //if (this.GetViewModel() == null || (rowCount == 1 && string.IsNullOrEmpty(rowDatasource.Id_orsrv)))
                    //{
                    //    this.SentNotify(EventCodeType.NM_EMS_CREATE, EmsCreatedParamList.TAGKEY, new EmsCreatedParamList() { new EmsCreatedParameter(medSrcDO, null) });
                    //}
                    //else {
                    //    AppendSrv2Ems(medSrcDO);
                    //    this.SentNotify(EventCodeType.NM_EMS_ORSRV_DATACHANGED);
                    //    LoadData();
                    //}
                }
                else if (e.BindingFieldName.Equals("Name_opex_srvs")) {
                    if (e.RefResultSet.IsEmpty) {
                        (this.GetViewModel().GetFormDataSource() as EmsOpitemDO).Id_opex_srvs = null;    
                    }
                }
            }
            
            
        }
        public override void SetFocus()
        {
            if (GetGridControl() != null && GetGridControl().DataTable.Rows.Count > 0)
            {
                GetGridControl().Focus();
                GetGridControl().DataTable.Rows[0].CellList[0].Focus();
                GetGridControl().DataTable.Rows[0].Selected = true;
            }
        }

      
        protected override void OnXapFormControl_DataDisplay(object sender, XDataDisplayEventArgs e)
        {
            XDataRow row = sender as XDataRow;
            EmsOpitemDO opItemDO = e.Object as EmsOpitemDO;
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_optime_limit"))
            {
                string value = "";
                if (opItemDO.Fg_xq_sug != null && opItemDO.Fg_xq_sug.Value)
                {
                    value = "1";// "限期";
                }
                else if (opItemDO.Fg_er_sug != null && opItemDO.Fg_er_sug.Value)
                {
                    value = "2";// "急症";
                }
                else
                {
                    opItemDO.Fg_zq_sug = true;
                    value = "0";// "择期";
                }
                row.ColumnCellDict["customercolumn_optime_limit"].SetValue(value);
             
            }
            
        }

        protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            base.OnXapFormControl_ModelFilled(sender,e);
            ResetColumnsInfo(this.GetGridControl());

            // 数据模型存在
            if (this.GetViewModel() != null && !this.GetViewModel().IsEmpty())
            {
                GetGridControl().DataTable.DataSource = this.GetViewModel().GetTableDataSource();
                // 处理变动列表中的数据
                XBindingList bindingList = new XBindingList();
                bindingList.Add(new XBinding("ValueText", "Val_rstrptla"));
                indicatorControl.BindingList = bindingList;

                var ds = new XapDataList<OrdApSugViewItemDO>();
                OrdApSugViewItemDO[] itemList = (this.GetViewModel().GetFormDataSource() as EmsOpitemDO).OpLabItem.ToArray();
                foreach (OrdApSugViewItemDO item in itemList) {
                    if (item.Status != DOStatus.DELETED) {
                        ds.Add(item);
                    }
                }

                indicatorControl.DataSource = ds;
                
                indicatorControl.Visible = ds.Count != 0;
                
                
            }
            else
            {
                // 模型不存在则创建一个空的数据模型列表
                XapDataList<EmsOpitemDO> ds = new XapDataList<EmsOpitemDO>();
                ds.Add(new EmsOpitemDO());
                GetGridControl().DataTable.DataSource = ds;
                indicatorControl.Visible = false;
            }


            AdjustLayout();

            this.SetFocus();
        }

    }
}

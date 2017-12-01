using System;
using System.Collections.Generic;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using xap.rui.control.forms.model;
using iih.ci.ord.opemergency.ems.dp;
using xap.cli.sdk.render;
using xap.cli.context;
using xap.cli.sdk.render.labelcontrol;
using xap.cli.sdk.controls.tabControl;
using iih.ci.ord.opemergency.ems.common;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.rui.control.refcontrol.events;
using iih.ci.ord.opemergency.declare;

namespace iih.ci.ord.opemergency.ems
{
    public delegate void DelegateMouseClick(string strCommond);

    public partial class PathgySrvTableView : BaseEmsView
    {
        #region 变量定义区域
        //public DelegateMouseClick delegateMouseClick;
        private PathgyObsItemView emsItemInPathgyView;

        private XLabelBaseUserRender fg_outer;
        private XLabelBaseUserRender org_pathgy_old;
        private XLabelBaseUserRender no_pathgy_old;
        private XLabelBaseUserRender ex_no_pathgy;
        private XLabelBaseUserRender dt_pathgy_old;
        private XLabelBaseUserRender name_di_pathgy_old;
        private XLabelBaseUserRender collectdes;

        protected BaseEmsViewModel model;
        #endregion

        #region 构造函数区域
        public PathgySrvTableView(BaseEmsViewModel model)
        {

            this.model = model;

            this.SetViewModel(model);
            this.emsItemInPathgyView = new PathgyObsItemView(model.GetFormDataSource() as EmsPathgyItemDO,model);
            Dictionary<string, Control> dicControls = new Dictionary<string, Control>();
            dicControls.Add("collcontainer", emsItemInPathgyView);
            this.GetXapFormControl().RegisterControl(dicControls);
        }

        protected override void InitializeBizView()
        {
            base.InitializeBizView();

            this.GetXapFormControl().Load += new EventHandler(xapFormControl1_Load);
        }
        #endregion

        #region 父类继承区域
        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_PathgySrvTableView/*"20160607085117889PIY"*/);
        }

        public override void SetDataPolicy(bool flag)
        {
            this.allowEdit = flag;
            this.GetXapFormControl().SetEditable(flag);
            this.emsItemInPathgyView.bEdit = flag;
        }
        #endregion

        #region 内部事件区域
        private void xapFormControl1_Load(object sender, EventArgs e)
        {
            this.OnInit();

            this.GetXapFormControl().FormCreated += new EventHandler(xapFormControl_FormCreated);
            this.GetXapFormControl().ModelFilled += new EventHandler(xapFormControl_ModelFilled);
            this.GetXapFormControl().DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
            this.GetXapFormControl().RefFilter += new EventHandler<RefActivatingEventArgs>(xapFormControl1_RefFilter);
            this.GetXapFormControl().RefResult += new EventHandler<RefResultEventArgs>(xapFormControl1_RefResult);
            this.GetXapFormControl().TabPageSelectChanged += new EventHandler<EventArgs>(xapFormControl1_TabPageSelectChanged);
        }

        protected virtual void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            name_di_pathgy_old.ValueText = (this.model.GetFormDataSource() as EmsPathgyItemDO).Name_di_pathgy_old;
            collectdes.ValueText = (this.model.GetFormDataSource() as EmsPathgyItemDO).Collectdes;
        }

        private void xapFormControl1_TabPageSelectChanged(object sender, EventArgs e)
        {
            this.GetXapFormControl().Refresh();
        }

        protected virtual void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            this.GetXapFormControl().SetToilHeight(30);
            this.GetXapFormControl().Padding = new Padding(4);
            fg_outer = this.GetXapFormControl().GetUserRender("history", "fg_outer") as XLabelBaseUserRender;
            org_pathgy_old = this.GetXapFormControl().GetUserRender("history", "org_pathgy_old") as XLabelBaseUserRender;
            org_pathgy_old.Enabled = (this.model.GetFormDataSource() as EmsPathgyItemDO).Fg_outer == true;
            no_pathgy_old = this.GetXapFormControl().GetUserRender("history", "no_pathgy_old") as XLabelBaseUserRender;
            no_pathgy_old.Visible = (this.model.GetFormDataSource() as EmsPathgyItemDO).Fg_outer != true;
            ex_no_pathgy = this.GetXapFormControl().GetUserRender("history", "ex_no_pathgy") as XLabelBaseUserRender;
            ex_no_pathgy.ValueText = (this.model.GetFormDataSource() as EmsPathgyItemDO).No_pathgy_old;
            ex_no_pathgy.Visible = (this.model.GetFormDataSource() as EmsPathgyItemDO).Fg_outer == true;
            ex_no_pathgy.ValueTextChanged += new EventHandler(ex_no_pathgy_ValueTextChanged);

            dt_pathgy_old = this.GetXapFormControl().GetUserRender("history", "dt_pathgy_old") as XLabelBaseUserRender;
            dt_pathgy_old.Enabled = (this.model.GetFormDataSource() as EmsPathgyItemDO).Fg_outer == true;
            name_di_pathgy_old = this.GetXapFormControl().GetUserRender("history", "name_di_pathgy_old") as XLabelBaseUserRender;
            collectdes = this.GetXapFormControl().GetUserRender("coll", "collectdes") as XLabelBaseUserRender;
        }

        private void xapFormControl1_DataChanged(object sender, DataChangedEventArgs e)
        {
            switch (e.PropName)
            {
                case "Fg_outer":
                    org_pathgy_old.Enabled = fg_outer.Checked;
                    dt_pathgy_old.Enabled = fg_outer.Checked;
                    no_pathgy_old.Visible = !fg_outer.Checked;
                    ex_no_pathgy.Visible = fg_outer.Checked;
                    ex_no_pathgy.ValueText = null;
                    (this.model.GetFormDataSource() as EmsPathgyItemDO).Org_pathgy_old = fg_outer.Checked ? null : UserManager.getInstance().CurrentOrg.Name;
                    (this.model.GetFormDataSource() as EmsPathgyItemDO).Dt_pathgy_old = null;
                    (this.model.GetFormDataSource() as EmsPathgyItemDO).Id_di_pathgy_old = null;
                    (this.model.GetFormDataSource() as EmsPathgyItemDO).Name_di_pathgy_old = null;
                    (this.model.GetFormDataSource() as EmsPathgyItemDO).No_pathgy_old = null;
                    break;
                default:
                    break;
            }
        }

        private void xapFormControl1_RefFilter(object sender, xap.rui.control.refcontrol.events.RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("No_pathgy_old"))
            {
                e.WherePart = string.Format(" B.id_pat='{0}' and A.no_pathgy is not null", this.GetViewModel().GetEnt4BannerDTO().Id_pat);
            }
        }

        private void xapFormControl1_RefResult(object sender, RefResultEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_srv"))
            {
                if (e.RefResultSet.IsEmpty)
                {
                    SentNotify(EventCodeType.NM_EMS_CLOSE);
                }
                else
                {
                    this.GetViewModel().LoadMedSrv(new EmsCreatedParameter(new bd.srv.medsrv.d.MedSrvDO() { Id_srv = (e.DataObject as EmsPathgyItemDO).Id_srv }, null));
                }
            }
            else if (e.BindingFieldName.Equals("No_pathgy_old"))
            {
                (this.model.GetFormDataSource() as EmsPathgyItemDO).Name_di_pathgy_old = (e.DataObject as EmsPathgyItemDO).Str_name_di;
            }
        }

        private void ex_no_pathgy_ValueTextChanged(object sender, EventArgs e)
        {
            (this.model.GetFormDataSource() as EmsPathgyItemDO).No_pathgy_old = (sender as XLabelBaseUserRender).ValueText;
        }

        private void btnAdd_MouseClick(object sender, MouseEventArgs e)
        {
            emsItemInPathgyView.AddPathgyItem();
        }

        private void btnDelete_MouseClick(object sender, MouseEventArgs e)
        {
            emsItemInPathgyView.DeletePathgyItem();
        }
        #endregion

        #region 辅助处理区域
        public void RefreshData(BaseEmsViewModel model)
        {
            this.SetViewModel(model);
            if (emsItemInPathgyView != null)
                emsItemInPathgyView.RefreshData(model.GetFormDataSource() as EmsPathgyItemDO);
            this.LoadData();
            
        }

        public virtual void SaveBefore()
        {
            (this.model.GetFormDataSource() as EmsPathgyItemDO).Name_di_pathgy_old = name_di_pathgy_old.ValueText;
            (this.model.GetFormDataSource() as EmsPathgyItemDO).Collectdes = collectdes.ValueText;
        }
        #endregion
    }
}

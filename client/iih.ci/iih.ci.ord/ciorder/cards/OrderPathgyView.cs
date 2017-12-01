using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.ems.d;
using xap.rui.control.forms.control;
using xap.cli.sdk.render;
using xap.rui.control.forms.model;
using xap.rui.control.refcontrol.events;
using iih.ci.ord.emsdi.d;
using xap.cli.sdk.render.labelcontrol;
using iih.ci.ord.cior.d;
using iih.ci.ord.opemergency.ems;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.rui.control.extentions;

namespace iih.ci.ord.ciorder.cards
{
    /********************************************************************************

** 作者： 刘晓颖

** 创始时间：2016-6-30

** 修改人：刘晓颖

** 修改时间：2016-6-30

** 描述： 病理申请单页面


*********************************************************************************/
    public partial class OrderPathgyView : CiorderBaseControl
    {
        #region 变量定义区域
        private string idDepMps;

        protected PathgyObsItemView emsItemInPathgyView;

        protected XLabelBaseUserRender fg_outer; // 是否外院
        protected XLabelBaseUserRender org_pathgy_old; // 医院名称
        protected XLabelBaseUserRender no_pathgy_old; // 
        protected XLabelBaseUserRender ex_no_pathgy; // 病理号
        protected XLabelBaseUserRender dt_pathgy_old; // 报告日期
        protected XLabelBaseUserRender name_di_pathgy_old; // 病理诊断
        #endregion

        #region 构造函数区域
        public OrderPathgyView()
        {
            this.InitializeComponent();
            this.xapFormControl1.Load += new EventHandler(xapFormControl1_Load);
            this.xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            this.xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
            this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
            this.xapFormControl1.RefFilter += this.OnRefFilter;
            this.xapFormControl1.RefResult += this.OnRefResult;
            SheetName = "病理医疗单";
        }
        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = getFormId();
            file.FormStyle = FormStyle.Card;
            file.ViewModel = this.EmsHeadDO.Emsappathgy;// 新的
            this.xapFormControl1.ViewFile = file;
        }

        public override void OnRefreshData(EmsUIDTO headDo, object e)
        {
            this.EmsHeadDO = headDo;
            OrWfDeptInfoDTO wf = new viewmodel.impext.GetDeptMpImp().GetDept_mp_ids(this.EmsHeadDO.PatInfo.Code_entp, this.EmsHeadDO.PatInfo.Id_entp, this.EmsHeadDO.MedSrvDO.Sd_srvtp, this.EmsHeadDO.MedSrvDO.Id_srvca, this.EmsHeadDO.MedSrvDO.Id_srv, this.EmsHeadDO.MedSrvDO.Id_route, "id_mm", headDo.PatInfo.Id_dep_nur, headDo.PatInfo.Id_dep_phy);
            if (wf != null) idDepMps = wf.Id_mp_depts;
            string[] di = new string[2];
            if (this.EmsHeadDO.IsNEW)
            {
                if (wf != null)
                {
                    this.EmsHeadDO.Emsappathgy.Id_mp_dep = wf.Firstid_mp_dept;
                    this.EmsHeadDO.Emsappathgy.Name_mp_dep = wf.Firstname_mp_dept;
                }
            }
            base.OnRefreshData(headDo, e);

            if (emsItemInPathgyView != null)
            {
                emsItemInPathgyView.bEdit = !IsReadOnly;
                emsItemInPathgyView.RefreshData(this.EmsHeadDO.Emsappathgy);
            }
        }
        #endregion

        #region 内部事件区域

        protected virtual void xapFormControl1_Load(object sender, EventArgs e)
        {
            this.OnInit();

            this.emsItemInPathgyView = new PathgyObsItemView(this.EmsHeadDO.Emsappathgy,null);
            emsItemInPathgyView.bEdit = !IsReadOnly;
            Dictionary<string, Control> dicControls = new Dictionary<string, Control>();
            dicControls.Add("collcontainer", emsItemInPathgyView);
            this.xapFormControl1.RegisterControl(dicControls);
        }

        protected virtual void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            this.xapFormControl1.Padding = new Padding(4);
            this.xapFormControl1.SetTopPanelHeight(xap.cli.sdk.common.RelativeUIParam.RELATIVERATIO > xap.cli.sdk.common.RelativeUIParam.TEMPLETECHANGEDRATIO ? 375 : 295);
            this.xapFormControl1.SetEditPolicy(true);

            fg_outer = this.xapFormControl1.GetUserRender("history", "fg_outer") as XLabelBaseUserRender;
            org_pathgy_old = this.xapFormControl1.GetUserRender("history", "org_pathgy_old") as XLabelBaseUserRender;
            no_pathgy_old = this.xapFormControl1.GetUserRender("history", "no_pathgy_old") as XLabelBaseUserRender;
            ex_no_pathgy = this.xapFormControl1.GetUserRender("history", "ex_no_pathgy") as XLabelBaseUserRender;
            ex_no_pathgy.ValueTextChanged += new EventHandler(ex_no_pathgy_ValueTextChanged);
            dt_pathgy_old = this.xapFormControl1.GetUserRender("history", "dt_pathgy_old") as XLabelBaseUserRender;
            name_di_pathgy_old = this.xapFormControl1.GetUserRender("history", "name_di_pathgy_old") as XLabelBaseUserRender;
        }

        protected virtual void xapFormControl1_DataChanged(object sender, DataChangedEventArgs e)
        {
            switch (e.PropName)
            {
                case "Fg_outer":
                    org_pathgy_old.Enabled = fg_outer.Checked;
                    dt_pathgy_old.Enabled = fg_outer.Checked;
                    no_pathgy_old.Visible = !fg_outer.Checked;
                    ex_no_pathgy.Visible = fg_outer.Checked;
                    ex_no_pathgy.ValueText = null;
                    this.EmsHeadDO.Emsappathgy.Org_pathgy_old = fg_outer.Checked ? null : this.Context.Org.Name; ;
                    this.EmsHeadDO.Emsappathgy.Dt_pathgy_old = null;
                    this.EmsHeadDO.Emsappathgy.Id_di_pathgy_old = null;
                    this.EmsHeadDO.Emsappathgy.Name_di_pathgy_old = null;
                    this.EmsHeadDO.Emsappathgy.No_pathgy_old = null;
                    break;
                default:
                    break;
            }
        }

        protected virtual void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            UserRender dt_out = xapFormControl1.GetUserRender("pathgy", "name_samptp");
            dt_out.Focus();

            xapFormControl1.SetEditable(!IsReadOnly);

            if (org_pathgy_old != null)
            {
                org_pathgy_old.Enabled = this.EmsHeadDO.Emsappathgy.Fg_outer == true;
                no_pathgy_old.Visible = this.EmsHeadDO.Emsappathgy.Fg_outer != true;
                ex_no_pathgy.ValueText = this.EmsHeadDO.Emsappathgy.No_pathgy_old;
                ex_no_pathgy.Visible = this.EmsHeadDO.Emsappathgy.Fg_outer == true;
                dt_pathgy_old.Enabled = this.EmsHeadDO.Emsappathgy.Fg_outer == true;
            }
        }

        protected new void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_diag"))
            {
                e.RefParams.AddParam("id_ent", this.EmsHeadDO.PatInfo.Id_ent);
            }
            else if (e.BindingFieldName.Equals("Name_mp_dep") && !string.IsNullOrWhiteSpace(idDepMps))
            {
                e.WherePart = string.Format("id_dep in ({0})", idDepMps);
            }
            else if (e.BindingFieldName.Equals("No_pathgy_old"))
            {
                e.WherePart = string.Format(" B.id_pat='{0}' and A.no_pathgy is not null", this.EmsHeadDO.PatInfo.Id_pat);
            }
        }

        protected new void OnRefResult(object sender, RefResultEventArgs e)
        {
            if (e.BindingFieldName.Equals("No_pathgy_old"))
            {
                this.EmsHeadDO.Emsappathgy.Name_di_pathgy_old = (e.DataObject as EmsPathgyItemDO).Str_name_di;
            }
        }

        protected void ex_no_pathgy_ValueTextChanged(object sender, EventArgs e)
        {
            this.EmsHeadDO.Emsappathgy.No_pathgy_old = (sender as XLabelBaseUserRender).ValueText;
        }
        #endregion


        public override Validate.IValidate GetOrdValidate()
        {
            return new Validate.OrderPathgyValidate();
        }
        #region 辅助处理函数
        public override void SaveBefore()
        {
            xapFormControl1.SaveForm();
        }

        protected virtual string getFormId()
        {
            return CiOrdBillFormTmplConst.CIORD_IP_OrderPathgyView;// "201511040456195728CV";
        }
        #endregion
    }
}

using System;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.utils;
using xap.cli.context;
using xap.rui.control.forms.control;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.control.forms.model;
using xap.rui.control.refcontrol.data;
using xap.rui.control.refcontrol.events;
using iih.ci.ord.ciorder.Validate;
using xap.rui.appfw;
using xap.cli.sdk.render;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciorder.cards
{
    public partial class OrderConsView : CiorderBaseControl
    {
        #region 变量定义区域
        private XapFormGridControl consItemGrid;//会诊项目
        private XapFormGridControl assistGrid;//协助方
        #endregion

        #region 构造函数区域

        public OrderConsView()
        {
            InitializeComponent();

            xapFormControl.Load += XapFormControl_Load;
            xapFormControl.FormCreated += XapFormControl_FormCreated;
            xapFormControl.ModelFilled += XapFormControl_ModelFilled;
            xapFormControl.RefFilter += OnRefFilter;

            xapFormControl.SetEditPolicy(true);
            SheetName = "会诊医疗单";
        }

        #endregion

        #region 公开属性区域

        #endregion

        #region 父类继承区域
        public override void OnRefreshData(EmsUIDTO headDo, object e)
        {
            if (headDo != null)
            {
                EmsHeadDO = headDo;
            }

            if (this.Created)
            {
                this.LoadData();
            }
        }

        protected override void OnLoadData()
        {
            //if (EmsHeadDO == null)
            //    return;

            //if (EmsHeadDO.Emsapcons != null && EmsHeadDO.Emsapcons.EmsConsItem.Count == 0)
            //{
            //    EmsItemInCons item = new EmsItemInCons();
            //    item.Name_srv = EmsHeadDO.MedSrvDO.Name;
            //    item.Id_srv = EmsHeadDO.MedSrvDO.Id_srv;

            //    //item.Name_constp = "科间普通会诊";
            //    EmsHeadDO.Emsapcons.EmsConsItem.Add(item);
            //}

            //if (MedSrvDO != null)
            //{
            //    orDataBing.AddCommonHeadDataBing(EmsHeadDO, MedSrvDO);
            //    orDataBing.AddConsDataBing(EmsHeadDO, MedSrvDO);
            //}

            //if (CiEmsDTO != null)
            //{
            //    OrCIEmsTOUIEms or = new OrCIEmsTOUIEms();
            //    or.EditCons(EmsHeadDO, CiEmsDTO);
            //}

        }
        
        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            if (EmsHeadDO != null)
            {
                file.ViewModel = EmsHeadDO.Emsapcons;
            }
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderConsView;// "20151110112303724TTN";
            file.FormStyle = FormStyle.Card;
            xapFormControl.ViewFile = file;
        }

        public override Validate.IValidate GetOrdValidate()
        {
            return new OrderConsValidate();
        }

        protected override void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_emp_doctor"))
            {
                if (assistGrid.DataTable.DataSource != null)
                {
                    XapDataList<EmsItemInCons> list = assistGrid.DataTable.DataSource as XapDataList<EmsItemInCons>;
                    string str_Id_dep_emp = list[0].Id_dep_emp;
                    if (str_Id_dep_emp != null)
                    {
                        e.WherePart = " id_dep='" + str_Id_dep_emp + "'";

                    }
                }
            }
        }
        #endregion

        #region 内部事件区域

        private void XapFormControl_Load(object sender, EventArgs e)
        {
            OnInit();
        }

        void XapFormControl_FormCreated(object sender, EventArgs e)
        {
            SetGridPolicy(true);
            xapFormControl.SetTopPanelHeight(340);

            consItemGrid = xapFormControl.GetGridView("consitem");
            consItemGrid.ReadOnly = true;
            
            assistGrid = xapFormControl.GetGridView("consorg");
            assistGrid.ReadOnly = false;
            assistGrid.DataTable.ReadOnly = false;
            assistGrid.DataTable.Columns["Name_emp_title"].ReadOnly = true;
            assistGrid.DataTable.Columns["Dt_response"].ReadOnly = true;
            assistGrid.Enabled = true;

            SetTabCommand();
        }

        private void XapFormControl_ModelFilled(object sender, EventArgs e)
        {
            SetGridDataSource();
            if (EmsHeadDO.Emsapcons.EmsConsItem.Count == 1)
                //consItemGrid.DataTable.Rows[0].SetMultiSelectStatus(true);
                consItemGrid.DataTable.Rows[0].Selected = true;

            UserRender dt_plan = xapFormControl.GetUserRender("cons", "dt_plan");
            dt_plan.Focus();
        }

        #endregion

        #region 辅助处理函数

        private void SetGridDataSource()
        {
            if (consItemGrid != null)
                consItemGrid.DataTable.DataSource = EmsHeadDO.Emsapcons.EmsConsItem;

            if (assistGrid != null)
            {
                assistGrid.DataTable.DataSource = EmsHeadDO.Emsapcons.EmsConsAssistItem;
            }
            
        }

        public void SetTabCommand()
        {
            //设置会诊受邀方
            xapFormControl.SetupCommands(new PageCommands[] 
            {
                new ctlEx.OrdPageCommand().pageCommands(
                    "consorg",
                    delegate
                    {
                        EmsItemInCons itemDO=new EmsItemInCons();
                        itemDO.Id_org = UserManager.getInstance().CurrentOrg.Id_org;
                        itemDO.Name_org = UserManager.getInstance().CurrentOrg.Name;
                        EmsHeadDO.Emsapcons.EmsConsAssistItem.Add(itemDO);
                    },
                    delegate
                    {
                        if (assistGrid.GetFocusedRow()!=null)
                            EmsHeadDO.Emsapcons.EmsConsAssistItem.Delete(assistGrid.GetFocusedRow().RowDataSource as EmsItemInCons,true);
                    },true)
            });
        }

        private void SetGridPolicy(bool flag)
        {
            DataPolicy policy = new DataPolicy
            {
                ClassName = "iih.ci.ord.ciordems.d.EmsItemInCons",
                FullEdit = flag
                //AllowEdit = flag
            };

            xapFormControl.SetEditPolicy(flag, new[] { policy });

        }

        public override void SaveBefore()
        {
            this.xapFormControl.SaveForm();
        }

        #endregion
    }
}

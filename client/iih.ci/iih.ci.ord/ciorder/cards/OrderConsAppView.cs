using System;
using System.Windows.Forms.VisualStyles;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.cards.drugext;
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
using xap.rui.control.commands;
using xap.cli.sdk.render;
using xap.mw.coreitf.d;
using xap.rui.bizcontrol.BillFormTmplConst;
/********************************************************************************

** 作者： 刘晓颖

** 创始时间：2016-6-30

** 修改人：刘晓颖

** 修改时间：2016-6-30

** 描述： 会诊申请单页面


*********************************************************************************/

namespace iih.ci.ord.ciorder.cards
{
    public partial class OrderConsAppView : CiorderBaseControl
    {
        #region 变量定义区域
        //private XapFormGridControl consItemGrid;//会诊项目
        private XapFormGridControl assistGrid;//协助方
        private  PageCommands[] pageCommands;
        //private string id_dep;
        private MedSrvConsDO consDo;
        #endregion

        #region 构造函数区域

        public OrderConsAppView()
        {
            InitializeComponent();

            xapFormControl.Load += XapFormControl_Load;
            xapFormControl.FormCreated += XapFormControl_FormCreated;
            xapFormControl.ModelFilled += XapFormControl_ModelFilled;
            xapFormControl.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl_DataChanged);
            xapFormControl.RefFilter += OnRefFilter;
            xapFormControl.RefResult += new EventHandler<RefResultEventArgs>(xapFormControl_RefResult);
            xapFormControl.DataInitNew += new EventHandler<DataInitNewEventArgs>(xapFormControl_DataInitNew);
            xapFormControl.SetEditPolicy(true);
            SheetName = "会诊医疗单";
        }

        private void xapFormControl_DataInitNew(object sender, DataInitNewEventArgs e)
        {
            EmsItemInCons itemDO = e.Object as EmsItemInCons;
            itemDO.Id_org = UserManager.getInstance().CurrentOrg.Id_org;
            itemDO.Name_org = UserManager.getInstance().CurrentOrg.Name;
            //XapFormGridControl gridView = xapFormControl.GetGridView("consorg");
           
            //xap.cli.sdk.controls.DataView.XDataRow row = gridView.DataTable.Rows.DataSourceRow[itemDO];
            //xap.cli.sdk.controls.DataView.XCellRender cell = row.ColumnCellDict["Name_dep_emp"];
            //gridView.ShowEditor(cell); 
           
             
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
            consDo = cof.GetCons(EmsHeadDO.Emsapcons.Id_srv);

            if (this.Created)
            {                
                if (consDo != null && this.pageCommands != null)
                {
                    foreach (XapCommand conmmands in this.pageCommands[0].Commands)
                    {
                        conmmands.Visible = consDo.Fg_deps.Value;
                        conmmands.Enabled = consDo.Fg_deps.Value;
                    }

                }
                if (EmsHeadDO.Emsapcons.EmsConsAssistItem == null || EmsHeadDO.Emsapcons.EmsConsAssistItem.Count ==0)
                {
                    EmsItemInCons itemDO = new EmsItemInCons();
                    itemDO.Id_org = UserManager.getInstance().CurrentOrg.Id_org;
                    itemDO.Name_org = UserManager.getInstance().CurrentOrg.Name;
                    EmsHeadDO.Emsapcons.EmsConsAssistItem.Add(itemDO);
                }
               
                this.LoadData();
            }
        }

        protected override void OnLoadData()
        {
        }
        
        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            if (EmsHeadDO != null)
            {
                file.ViewModel = EmsHeadDO.Emsapcons;
            }
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderConsAppView;// "201606030304310468RP";
            file.FormStyle = FormStyle.Card;
            xapFormControl.ViewFile = file;
        }

        public override IValidate GetOrdValidate()
        {
            return new OrderConsValidate();
        }

        void xapFormControl_RefResult(object sender, RefResultEventArgs e)
        {
            RefDataCollection data = e.RefResultSet;
            //if (e.BindingFieldName.Equals("Name_dep_emp"))
            //{
            //    this.id_dep = data.FirstData["Id_dep"] as string;//获取字段值
            //}
        }

        protected override void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_emp_doctor"))
            {
                string str="";
                // 获取当前行 受邀科室id
                string id_dep = this.assistGrid.GetFocusedRow<EmsItemInCons>().Id_dep_emp;
                if (id_dep != null)
                {
                    str += " bd_psndoc.id_dep='" + id_dep + "'";
                }
                // 受邀科室医生职称是否有限制
                if (this.consDo.Fg_emptitlelimit == true && !string.IsNullOrEmpty(this.consDo.Id_emptitle))
                {
                    string id_emptitles = "";
                    string[] ids = this.consDo.Id_emptitle.Split(',');
                    foreach (string id in ids)
                    {
                        id_emptitles+="'"+id+"',";
                    }
                    if (str != "")
                    {
                        str += " and ";
                    }
                    str += " bd_psndoc.id_emptitle in (" + id_emptitles.Substring(0, id_emptitles.Length - 1) + ")";
                }
                if(str=="")return;
                e.WherePart = str;
            }
            if (e.BindingFieldName.Equals("Name_dep_emp"))
            {
                string str="" ;
                str += string.Format("id_dep <> '{0}' and  SD_DEPTTP='01'",UserManager.getInstance().CurrentDept.Id_dep);
                if (str == "") return;
                e.WherePart = str;
            }
            if (e.BindingFieldName.Equals("Name_org"))
            {
                if (consDo != null && consDo.Fg_inorg == false)
                {
                    e.WherePart = string.Format("id_org <> '{0}'", UserManager.getInstance().CurrentOrg.Id_org);
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
            xapFormControl.SetTopPanelHeight(240); // 设置表单中头部高度            
            //xapFormControl.SetToilHeight 设置表单尾部高度

            //consItemGrid = xapFormControl.GetGridView("consitem");
            //consItemGrid.ReadOnly = true;
            SetTabCommand();
            assistGrid = xapFormControl.GetGridView("consorg");
            assistGrid.ReadOnly = false;
            assistGrid.DataTable.ReadOnly = false;
            assistGrid.DataTable.Columns["Name_emp_title"].ReadOnly = true;
            assistGrid.DataTable.Columns["Dt_response"].ReadOnly = true;
            //if (consDo != null && consDo.Fg_deps==true)
            //    assistGrid.DataTable.Columns["Name_org"].ReadOnly = true;
            assistGrid.Enabled = true;
            
            
            //}
            //else
            //{
                
            //}
               assistGrid.DataTable.RowAdded += new EventHandler(DataTable_RowAdded);
        }
        //焦点设置到某列上
        private void DataTable_RowAdded(object sender, EventArgs e)
        {
            xap.cli.sdk.controls.DataView.XDataRow row = sender as xap.cli.sdk.controls.DataView.XDataRow;
            if (assistGrid == null || row == null)
            {
                return;
            }
            xap.cli.sdk.controls.DataView.XCellRender cell = row.ColumnCellDict["Name_dep_emp"];
            assistGrid.ShowEditor(cell);
        }
        private void XapFormControl_ModelFilled(object sender, EventArgs e)
        {
            UserRender dt_plan = xapFormControl.GetUserRender("cons", "dt_plan");
            dt_plan.Focus();

            if (EmsHeadDO.IsNEW && EmsHeadDO.Emsapcons.EmsConsAssistItem != null && EmsHeadDO.Emsapcons.EmsConsAssistItem.Count ==0)
            {
                EmsItemInCons itemDO = new EmsItemInCons();
                if (consDo != null && consDo.Fg_inorg == true)
                {
                    itemDO.Id_org = UserManager.getInstance().CurrentOrg.Id_org;
                    itemDO.Name_org = UserManager.getInstance().CurrentOrg.Name;
                }
                EmsHeadDO.Emsapcons.EmsConsAssistItem.Add(itemDO);
            }

            SetGridDataSource();
            SetGridPolicy(!IsReadOnly);
            if (this.pageCommands != null && consDo != null) {
                foreach (XapCommand conmmands in this.pageCommands[0].Commands)
                {
                    // 当多科室会诊时，并且当前表单不是只读状态才显示添加按钮 consDo.Fg_deps 是否多科室会诊
                    conmmands.Visible = consDo.Fg_deps == FBoolean.True && !IsReadOnly;                    
                }   
            }
            
            //this.consDo = cof.GetCons(EmsHeadDO.MedSrvDO.Id_srv);
            if (consDo != null && consDo.Fg_inorg == true)
            {
                assistGrid.DataTable.Columns["Name_org"].ReadOnly = true;
                assistGrid.DataTable.Columns["Name_dep_emp"].ReadOnly = false;
                assistGrid.DataTable.Columns["Name_dep_emp"].NullFlag = false;
                assistGrid.DataTable.Columns["Name_emp_doctor"].ReadOnly = false;
            }
            else
            {
                assistGrid.DataTable.Columns["Name_org"].ReadOnly = true;
                assistGrid.DataTable.Columns["Name_org"].NullFlag = true;
                assistGrid.DataTable.Columns["Name_dep_emp"].ReadOnly = true;
                assistGrid.DataTable.Columns["Name_dep_emp"].NullFlag = true;
                assistGrid.DataTable.Columns["Name_emp_doctor"].ReadOnly = true;

            }
            //限制开始时间的时间范围，入院日期，最大提前日期
            TimerComboBoxMaxAndMin.GetInstance().setMaxMinTime(xapFormControl, this.Context, "cons", "dt_plan", EmsHeadDO.PatInfo.Id_ent);
            
        }

        void xapFormControl_DataChanged(object sender, DataChangedEventArgs e)
        {
            if (e.PropName == "Name_dep_emp" && e.Data is EmsItemInCons)
            {
                EmsItemInCons item = e.Data as EmsItemInCons;
                item.Id_emp_doctor = null;
                item.Name_emp_doctor = null;
                
            }
            if (e.PropName == "Name_emp_doctor" && e.Data is EmsItemInCons)
            {
                EmsItemInCons item = e.Data as EmsItemInCons;
                item.Id_emp_title = null;
                item.Name_emp_title = null;
            }
        }
        #endregion

        #region 辅助处理函数

        private void SetGridDataSource()
        {
            //if (consItemGrid != null)
            //    consItemGrid.DataTable.DataSource = EmsHeadDO.Emsapcons.EmsConsItem;

            if (assistGrid != null)
            {
                assistGrid.DataTable.DataSource = EmsHeadDO.Emsapcons.EmsConsAssistItem;
            }
            
        }

        public void SetTabCommand()
        {
            bool enable = false;
            this.consDo = cof.GetCons(EmsHeadDO.MedSrvDO.Id_srv);
            if (consDo != null && consDo.Fg_deps != null) enable = consDo.Fg_deps.Value;
            this.pageCommands = new PageCommands[]
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
                        },enable&&!IsReadOnly)
            };
            this.xapFormControl.SetupCommands(this.pageCommands);
        }

        private void SetGridPolicy(bool flag)
        {
            DataPolicy policy = new DataPolicy
            {
                ClassName = "iih.ci.ord.ciordems.d.EmsItemInCons",
                FullEdit = flag,
                AllowEdit = flag,
                InlineEdit = flag,
                AutoNewRow = flag,
                AllowNew = flag
        
            };
            DataPolicy policy1 = new DataPolicy
            {
                ClassName = "iih.ci.ord.ciordems.d.EmsConsItemDO",
                FullEdit = flag,
                AllowEdit = flag
            };
            xapFormControl.SetEditPolicy(flag, new[] { policy,policy1 });

        }

        public override void SaveBefore()
        {
            this.xapFormControl.SaveForm();
        }

        #endregion
    }
}

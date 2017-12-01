using System;
using System.Windows.Forms;
using xap.rui.control.basecontrol;
using xap.cli.sdk.controls;
using iih.ci.ord.opemergency.assi.entdi;
using xap.rui.engine;
using iih.ci.ord.opemergency.action.costant;

namespace iih.ci.ord.opemergency.orddi
{

    /// <summary>
    /// <para>描    述 : 诊断辅助录入列表                   </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.view       </para>    
    /// <para>类 名 称 : DiAssListView                     </para> 
    /// <para>版 本 号 : v1.0.0.0                          </para> 
    /// <para>作    者 : qzwang                            </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05                </para>
    /// <para>修 改 人 :                                   </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05                </para> 
    /// <para>说    明 :                                   </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class DiAssListView : XapListControl
    {
        private XLayoutPanel panel;

        public DiAssListView()
        {
            this.Load += new EventHandler(DiAssListView_Load);
        }

        private void DiAssListView_Load(object sender, EventArgs e)
        {
            EntDiAssiContainer diAssiForm = new EntDiAssiContainer(this.Context);
            diAssiForm.delegateHelper += getDOsFromHelp;

            panel = new XLayoutPanel();
            panel.Dock = DockStyle.Fill;
            panel.AddControl(diAssiForm, ControlPosition.Center);
            this.AddRender(panel);
        }

        private void getDOsFromHelp(object[] dos)
        {
            this.onFireEventSent(OpActionConstant.OP_DI_ASSI_ACTION, dos);
        }

        /// <summary>
        /// 发送事件
        /// </summary>
        /// <param name="strCommond"></param>
        /// <param name="sender"></param>
        private void onFireEventSent(string strCommond, object sender)
        {
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, strCommond);
            this.FireEventSent(sender, args);
        }
      
        //#region 变量定义区域
        //private DiAssListViewModel model;
        //private string id_dica = null;

        //private XLayoutPanel panel;
        //private xap.rui.control.forms.view.XapFormControl xapFormControl;
        //#endregion

        //#region 构造函数区域

        //public DiAssListView()
        //{
        //    InitializeComponent();

        //    this.xapFormControl.Load += new EventHandler(xapFormControl_Load);
        //    this.xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
        //    this.xapFormControl.BannerFocus += xapFormControl_BannerFocus;
        //}

        //private void InitializeComponent()
        //{
        //    this.xapFormControl = new xap.rui.control.forms.view.XapFormControl();
        //    panel = new XLayoutPanel();
        //    this.SuspendLayout();
        //    // 
        //    // xapFormControl1
        //    // 
        //    this.xapFormControl.AutoSize = true;

        //    panel.Dock = DockStyle.Fill;

        //    this.xapFormControl.Context = null;
        //    //this.xapFormControl1.Dock = DockStyle.Fill;
        //    this.xapFormControl.File = null;
        //    this.xapFormControl.Location = new System.Drawing.Point(0, 0);
        //    this.xapFormControl.Name = "xapFormControl1";
        //    this.xapFormControl.Size = new System.Drawing.Size(592, 365);
        //    this.xapFormControl.TabIndex = 0;
        //    this.xapFormControl.ViewFile = null;
        //    // 

        //    panel.AddControl(this.xapFormControl, ControlPosition.Center);
        //    this.AddRender(panel);
        //    this.Name = "assistinputView";
        //    this.ResumeLayout(false);
        //    this.PerformLayout();
        //}

        //void xapFormControl_BannerFocus(object sender, EventArgs e)
        //{
        //    //throw new NotImplementedException();
        //    XLabelBaseUserRender ctrl = (XLabelBaseUserRender)this.xapFormControl.GetUserRender("diagca", "deptdiagca");
        //    ctrl.IsFocus = false;
        //}

        
        //#endregion

        //#region 父类继承区域

        ///// <summary>
        ///// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        ///// </summary>
        //protected override void OnLoadData()
        //{
        //    if (this.model == null)
        //        this.model = new DiAssListViewModel();

        //    this.model.Reload(UserManager.getInstance().CurrentDept.Id_dep, id_dica);
        //}

        ///// <summary>
        ///// CreateView执行完毕后，用LoadData的数据填充界面
        ///// </summary>
        //protected override void OnFillData()
        //{

        //    FormFile file = new FormFile();
        //    file.FormId = "20160513025014984B7A";

        //    file.FormStyle = FormStyle.List; 

        //    if (this.model != null)
        //    {
        //        file.ViewModel = this.model;
        //    }

        //    xapFormControl.ViewFile = file;
        //}

        //#endregion

        //#region 内部事件区域
        //void xapFormControl_Load(object sender, EventArgs e)
        //{
        //    this.OnInit();

        //    this.xapFormControl.SetEditable(true);
            
        //}

        //void xapFormControl_FormCreated(object sender, EventArgs e)
        //{
        //    XLabelBaseUserRender ctrl = (XLabelBaseUserRender)this.xapFormControl.GetUserRender("diagca", "deptdiagca");

        //    XComboBox cmb = ctrl.UserRender as XComboBox;
            

        //    Dictionary<object, string> item = new Dictionary<object, string>();
        //    item.Add("~", "全部");
        //    foreach (DeptDiagCaDO caDO in this.model.DeptDiagCaArray)
        //    {
        //        item.Add(caDO.Id_deptdiagca, caDO.Name);
        //    }
        //    cmb.DataSource = item;
        //    cmb.SelectIndex = 0;
        //    cmb.SelectValueChanged += new EventHandler(cmb_SelectValueChanged);
        //    // 【科室常用诊断】- 增加 鼠标双击 事件
        //    XapFormGridControl formGridControl = this.xapFormControl.GetGridView("deptditable");
        //    formGridControl.MouseDoubleClick += new MouseEventHandler(formGridControl_MouseDoubleClick);

        //    // 设置分类选取控件占用的高度
        //    this.xapFormControl.SetTopPanelHeight(44);

        //    // 隐藏表格的列头信息 [5/17/2016 qzwang]
        //    formGridControl.DataTable.Columns.Visible = false;
        //    formGridControl.WithBorder = true;
        //}

        //void cmb_SelectValueChanged(object sender, EventArgs e)
        //{
        //    this.id_dica = (String)(sender as XComboBox).SelectedItem;
        //    // 调用模型查询，更新UI
           
        //     this.LoadData();
        //    //this.model.Reload(UserManager.getInstance().CurrentDept.Id_dep, id_dica);
        //}

        ///// <summary>
        ///// 双击选取科室常用诊断信息
        ///// </summary>
        ///// <param name="sender"></param>
        ///// <param name="e"></param>
        //void formGridControl_MouseDoubleClick(object sender, MouseEventArgs e)
        //{
        //    XDataRow row = (XDataRow)sender;

        //    if (row.ClickCell.FieldName == "Name")
        //    {
        //        this.FireSelected( sender);
        //    }
        //}

       
        //#endregion

        //#region 辅助处理函数

        //#endregion

        //#region 状态处理区域

        //public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        //{

        //}

        //#endregion
    }
}

using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;
using iih.ci.ord.cilab.viewmodel;
using iih.ci.ord.dto.orobsandlab.d;
using iih.en.pv.dto.d;
using xap.cli.sdk.controls;
using xap.cli.sdk.controls.explorerbar;
using xap.cli.sdk.controls.navbar;
using xap.cli.sdk.layout;
using xap.cli.sdk.models;
using xap.cli.sdk.render;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.view;
using xap.rui.control.tree.events;
using xap.rui.control.tree.otree;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;
using Orientation = xap.cli.sdk.layout.Orientation;

namespace iih.ci.ord.cilab.view
{
    public partial class CiRptLabTreeView : XapListControl, IWorkStationRegist
    {
        #region 变量定义区域

        //public PatientsDTO patDo = new PatientsDTO();
        private readonly NavBarControl menu;
        public Ent4BannerDTO ent4BannerDto;
        private CiRptLabTreeViewModel model;
        //private OTree oTree1;
        //private OTree oTree2;
        private XapFormControl xapFormControl;

        #endregion

        #region 构造函数区域

        public CiRptLabTreeView()
        {
            InitializeComponent();
            xapFormControl = new XapFormControl();
            xapFormControl.Dock = DockStyle.Fill;


            menu = new NavBarControl();

            menu.Size = new Size(30, 430);

            // this.xapFormControl.Controls.Add(menu);
            Controls.Add(menu);
            Load += CiRptLabTreeView_Load;
        }

        private void CiRptLabTreeView_Load(object sender, EventArgs e)
        {
            OnInit();
        }

        #endregion

        #region 公开属性区域

        #endregion

        #region 命令定义区域

        //[XapCommand(Name = "Open", Caption = "打开")]
        //public void OnOpen(object sender, EventArgs e)
        //{

        //}

        #endregion

        #region 事件发送区域

        //[XapEventSent(Name = "Say")]
        //public event EventHandler<XapEventArgs> Say;

        #endregion

        #region 事件接收区域

        //[XapEventRecv(Name = "Recv")]
        //public void OnRecv(object sender, XapEventArgs e)
        //{

        //}

        #endregion

        #region 父类继承区域

        /// <summary>
        ///     获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            model = new CiRptLabTreeViewModel();
        }

        /// <summary>
        ///     CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            var explorerBar = new ExplorerBar();
            var dataBar = new ExplorerBar();
            var contentPanel = new XBaseControl();
            int loaction = 20;
            OrObsAandLabDTO[] labs = model.getOrObsAandLabDTO(ent4BannerDto.Id_ent, "lab");
            if (labs != null && labs.Length > 0)
            {
                for (int i = 0; i < labs.Length; i++)
                {
                    var lab = new LabelRender();
                    lab.Text = labs[i].Name;
                    lab.ID = labs[i].Id;
                    lab.Location = new Point(0, loaction);
                    loaction = loaction + lab.Size.Height + 30;
                    lab.Size = new Size(100, 24);
                    contentPanel.AddRender(lab);
                    lab.MouseClick += lab_MouseDoubleClick;
                }
            }
            var layout = new LinearLayout(contentPanel);
            layout.Orientation = Orientation.Horizontal;
            layout.ApplyLayout();

            explorerBar.AddMenuItem(new MenuItemInfo("常规检验", contentPanel));

            dataBar.AddMenuItem(new MenuItemInfo("日期", contentPanel));

            menu.AddMenuItem(new MenuItemInfo("分类模式", explorerBar));
            menu.AddMenuItem(new MenuItemInfo("日期模式", dataBar));
        }

        #endregion

        #region 内部事件区域

        private void lab_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            //MessageBox.Show((sender as XLabel).ValueText);
            var lab = sender as LabelRender;
            FireSelected(lab.ID);
        }

        #endregion

        #region 辅助处理函数

        private void oTree1_TreeItemSelected(object sender, TreeItemEventArgs e)
        {
            //this.node = e.Node.PrevNode
            //var tree = oTree1.GetUserObject(e.Node) as OrObsAandLabDTO;
            //FireSelected(tree);
        }

        private void oTree2_TreeItemSelected(object sender, TreeItemEventArgs e)
        {
            //this.node = e.Node.PrevNode
            //var tree = oTree1.GetUserObject(e.Node) as OrObsAandLabDTO;
            //FireSelected(tree);
        }

        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            var uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            var newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.REFRESH:
                    LoadData();
                    break;
                case UIEvent.LOAD:
                    var dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    if (dic != null)
                    {
                        if (dic.Keys.Contains("PatientData"))
                        {
                            ent4BannerDto = (dic["PatientData"] as BannerData).Ent4BannerDTO;
                        }
                        //if (dic.Keys.Contains("IsInHospitalStation"))
                        //{
                        //    patDo.Id_ent = dic["EncounterID"].ToString();
                        //}

                        // this.OnLoadData();
                    }

                    break;
            }
        }

        #endregion

        #region 注册与反注册到工作站

        public void Regist(EventBroker eventBroker)
        {
            eventBroker.Register(this);
            if (Created)
                OnLoadData();
        }

        public void UnRegist(EventBroker eventBroker)
        {
            eventBroker.Unregister(this);
        }

        public void UpdatePatientInfo(object sender, DictionaryEventArgs eventArgs)
        {
            if (eventArgs.Data.Keys.Contains("PatientData"))
            {
                object obj = eventArgs.Data["PatientData"];
                ent4BannerDto = (obj as BannerData).Ent4BannerDTO;
                if (Created)
                    LoadData();
            }
        }

        #endregion
    }
}
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;
using iih.ci.ord.ciobs.viewmodel;
using iih.ci.ord.dto.orobsandlab.d;
using iih.en.pv.dto.d;
using iih.en.pv.inpatient.dto.d;
using xap.cli.sdk.controls;
using xap.cli.sdk.layout;
using xap.cli.sdk.models;
using xap.cli.sdk.render;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.view;
using xap.rui.control.tree.otree;
using xap.rui.control.tree.otree.loader;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;
using xap.cli.sdk.controls.explorerbar;
using xap.cli.sdk.controls.navbar;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.control.tree.events;

namespace iih.ci.ord.ciobs.view
{
    public partial class CiRptObsTreeView : XapListControl, IWorkStationRegist
    {




        #region 变量定义区域
        private XapFormControl xapFormControl1;
        private CiRptObsTreeViewModel model;
        //public PatientsDTO patDo = new PatientsDTO();
        public Ent4BannerDTO ent4BannerDto;
        private OTree oTree1;
        //private OTree oTree2;
        private NavBarControl menu = null;
        #endregion

        #region 构造函数区域
        public CiRptObsTreeView()
        {
            InitializeComponent();
            this.xapFormControl1 = new XapFormControl();
            this.xapFormControl1.Dock = DockStyle.Fill; this.oTree1 = new xap.rui.control.tree.otree.OTree();
            this.oTree1.Dock = DockStyle.Fill;
            menu = new NavBarControl();
            menu.Size = new Size(30,430);
            // this.xapFormControl1.Controls.Add(menu);
            this.Controls.Add(menu);
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
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            this.model = new CiRptObsTreeViewModel();
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            ExplorerBar explorerBar = new ExplorerBar();
            ExplorerBar dataBar = new ExplorerBar();
            XBaseControl contentPanel = new XBaseControl();
            int loaction = 20;
            OrObsAandLabDTO[] labs = this.model.getOrObsAandLabDTO(this.ent4BannerDto.Id_ent, "obs");
            if (labs != null && labs.Length > 0)
            {
                for (int i = 0; i < labs.Length; i++)
                {

                    LabelRender lab = new LabelRender();
                    lab.Text = labs[i].Name;
                    lab.ID = labs[i].Id;
                    lab.Location = new Point(0, loaction);
                    loaction = loaction + lab.Size.Height + 30;
                    lab.Size = new Size(100, 24);
                    contentPanel.AddRender(lab);
                    lab.MouseClick += new MouseEventHandler(lab_MouseClick);


                }
            }
            LinearLayout layout = new LinearLayout(contentPanel);
            layout.Orientation = xap.cli.sdk.layout.Orientation.Horizontal;
            layout.ApplyLayout();

            explorerBar.AddMenuItem(new MenuItemInfo("检查", contentPanel));

            dataBar.AddMenuItem(new MenuItemInfo("日期", contentPanel));

            menu.AddMenuItem(new MenuItemInfo("分类模式", explorerBar));
            menu.AddMenuItem(new MenuItemInfo("日期模式", dataBar));
        }

        void lab_MouseClick(object sender, MouseEventArgs e)
        {
            LabelRender lab = sender as LabelRender;
            this.FireSelected(lab.ID);
        }

        #endregion

        #region 内部事件区域
        private void oTree1_TreeItemSelected(object sender, TreeItemEventArgs e)
        {
            //this.node = e.Node.PrevNode
            OrObsAandLabDTO tree = oTree1.GetUserObject(e.Node) as OrObsAandLabDTO;
            this.FireSelected(tree);
        }
        private void oTree2_TreeItemSelected(object sender, TreeItemEventArgs e)
        {
            //this.node = e.Node.PrevNode
            //OrObsAandLabDTO tree = oTree2.GetUserObject(e.Node) as OrObsAandLabDTO;
            //this.FireSelected(tree);
        }
        #endregion

        #region 辅助处理函数
        public void CiRptObsTreeView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }
        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.LOAD:
                    Dictionary<string, object> dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    if (dic != null)
                    {
                        this.ent4BannerDto = (dic["PatientData"] as BannerData).Ent4BannerDTO;
                        //if (dic.Keys.Contains("PatientData"))
                        //{
                        //    this.ent4BannerDto = (dic["PatientData"] as BannerData);
                        //}
                        //if (dic.Keys.Contains("IsInHospitalStation"))
                        //{
                        //    patDo.Id_ent = dic["EncounterID"].ToString();
                        //}

                        // this.OnLoadData();
                    }

                    break;
                default:
                    break;
            }
        }

        #endregion

        #region 注册与反注册到工作站
        public void Regist(EventBroker eventBroker)
        {
            eventBroker.Register(this);
            if (Created)
                this.OnLoadData();
        }
        public void UnRegist(EventBroker eventBroker)
        {
            eventBroker.Unregister(this);
            if (Created)
                this.OnLoadData();
        }

        public void UpdatePatientInfo(object sender, DictionaryEventArgs eventArgs)
        {
            if (eventArgs.Data.Keys.Contains("PatientData"))
            {
                object obj = eventArgs.Data["PatientData"];
                //patDo = obj as PatiVisitDO;
                this.ent4BannerDto = (obj as BannerData).Ent4BannerDTO;
                if (Created)
                    this.LoadData();

            }
        }

        #endregion



    }
}

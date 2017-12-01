using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.control.basecontrol;
using iih.ci.ord.opemergency.view;
using xap.cli.sdk.controls;
using xap.cli.sdk.form;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.dialog
{
    public partial class AssMedSrvCatgForm : XForm
    {
        #region 变量定义
        private XapBaseControl ownerView;
        private XLayoutPanel rootView;
        private AssMedSrvCatgItemView itemView;
        //private AssMedSrvCatgTreeView treeView;
        #endregion

        #region 构造函数|初始化
        public AssMedSrvCatgForm(XapBaseControl owner)
        {
            InitializeComponent();
            this.ownerView = owner;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.DoReSize = false;
            this.init();
            owner.VisibleChanged += new EventHandler(owner_VisibleChanged);
            
        }

        void  owner_VisibleChanged(object sender, EventArgs e)
        {
            if (this.Created)
            {
                this.Visible = !this.Visible;
            }
        }
        protected virtual void init()
        {
             this.Load += new EventHandler(AssMedSrvCatgDialog_Load);
        }

        void AssMedSrvCatgDialog_Load(object sender, EventArgs e)
        {
            if (this.ownerView == null || this.ownerView.Context.Config == null)
                return;
            XapBaseControl emrView = this.ownerView.Context.Config.GetInstance("emrView") as XapBaseControl;

            this.Location = emrView.PointToScreen(emrView.Location);
            this.Size = emrView.Size;

            this.rootView = new XLayoutPanel();
            rootView.Dock = DockStyle.Fill;
            this.AddRender(rootView);

            XLayoutPanel centerPanel = new XLayoutPanel();

            XUserControl xUserControl = new XUserControl();
            xUserControl.Init(Application.StartupPath + "\\modules\\iihci\\ui\\assmedsrvcatg\\assmedsrvcatg_config.xml");

            // 此处不能设置为 Fill 方式，否则 xUserControl 会充满整个窗体，
            // 会将其他通过代码创建的控件全部遮挡
            xUserControl.Dock = DockStyle.Fill;
            xUserControl.Location = new Point(0,0);
            xUserControl.Size = this.Size;
            rootView.AddControl(xUserControl, ControlPosition.Center);
            itemView = xUserControl.GetConfig().GetInstance("AssMedSrvCatgItemView") as AssMedSrvCatgItemView;
            itemView.setOwnerView(this.ownerView);
            
//             treeView = this.ownerView.Context.Config.GetInstance("AssMedSrvCatgTreeView") as AssMedSrvCatgTreeView;
//             itemView = this.ownerView.Context.Config.GetInstance("AssMedSrvCatgItemView") as AssMedSrvCatgItemView;
//             itemView.setOwnerView(this.ownerView);
// 
//             centerPanel.AddControl(treeView, ControlPosition.Left, 220);
//             centerPanel.AddControl(itemView, ControlPosition.Center);
// 
//             rootView.AddControl(centerPanel, ControlPosition.Center);

            XLayoutPanel bottomPanel = new XLayoutPanel();
           
            bottomPanel.BackColor = Color.Gray;
            rootView.AddControl(bottomPanel, ControlPosition.Bottom, 44);

            xUserControl.LoadData();
        }
        #endregion

       
    }
}

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciordcons.view;
using xap.cli.sdk.form;
using xap.rui.engine;

namespace iih.ci.ord.ciordcons.dialog
{
    public partial class ConsMrCommonDialog : XSingleDialog
    {
        private Dictionary<string, object> treearg;
        public ConsMrCommonDialog(Dictionary<string,object> args)
        {
            InitializeComponent();
            this.Text = "病历文书记录";
            this.HasbtnBackRec = false;
            this.Formsize = FormSize.ExtraLarge;
            this.Height = 600;
            // 发送所要传送的数据包装    
            treearg = args;
 
            XUserControl userControl = new XUserControl();
            userControl.Init(Application.StartupPath + "\\modules\\iihci\\ui\\mrcommonoutp\\mrcommonoutp_config.xml");
            userControl.Dock = DockStyle.Fill;
            userControl.LoadData(treearg);

            userControl.Size = this.Panel.Size;
            userControl.Location = this.Panel.Location;
            this.Panel = userControl;
        }
    }
}

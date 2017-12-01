using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using System.Windows.Forms;
using xap.rui.control.forms.view;
using xap.cli.sdk.form;
using System.Drawing;

/********************************************************************************

** 作者： 杨敬本

** 创始时间：2016/10/21

** 修改人：杨敬本

** 修改时间：2016/10/21

** 描述：诊断证明预览界面

*********************************************************************************/

namespace iih.ci.ord.opemergency.proofofdiag.viewprint
{
    public partial class DiProvePrintDialog : XBaseDialog
    {
        private XapFormControl xapFormControl;

        private string id_ent;

        public DiProvePrintDialog(string id_ent)
        {
            InitializeComponent();

            this.id_ent = id_ent;

            this.Load += new EventHandler(DiProvePrintDialog_Load);
        }

        private void InitializeComponent()
        {
            

            //this.AutoScaleDimensions = new SizeF(6F, 12F);
            this.Name = "DiProvePrintDialog";
            this.Text = "打印预览";
            this.Formsize = FormSize.ExtraLarge;
            this.ResumeLayout(false);
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;

            xapFormControl = new XapFormControl
            {
                Location = Panel.Location,
                Width = Panel.Width,
                Height = Panel.Height
            };
            xapFormControl.SetEditPolicy(true);
            Panel = xapFormControl;
        }

        private void DiProvePrintDialog_Load(object sender, EventArgs e)
        {
            XUserControl userControl = new XUserControl();
            userControl.Init(Application.StartupPath + "\\modules\\iihci\\ui\\entdiprove\\diproveprint_config.xml");
            userControl.Dock = DockStyle.Fill;
            userControl.Size = this.Panel.Size;
            userControl.Location = this.Panel.Location;
            userControl.LoadData();
            Dictionary<string, string> dic = new Dictionary<string, string>();

            DiProvePrintPreView bottomView = userControl.GetConfig().GetInstance("bottomView") as DiProvePrintPreView;
            if (bottomView != null)
            {
                bottomView.id_ent = id_ent;
            }
            
            this.Panel = userControl;
        }

    }
}

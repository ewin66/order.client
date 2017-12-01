using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.dto.d;
using xap.cli.sdk.controls;
using xap.cli.sdk.form;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.view;
using xap.rui.engine;
using xap.rui.engine2.utils;

namespace iih.ci.ord.medicaresharing
{
    public partial class MedicalSharingInfoForm : XBaseDialog
    {
        public List<MedicalSharingDTO> medicalSharingDTOList;

        public MedicalSharingInfoForm(List<MedicalSharingDTO> list )
        {
            this.medicalSharingDTOList = list;
            InitializeComponent();
            this.Load += new EventHandler(MedicalSharingInfoForm_Load);
            this.confirmBtn.MouseClick += confirmBtn_MouseClick;
            this.cancelBtn.MouseClick += cancelBtn_MouseClick;
        }

        void MedicalSharingInfoForm_Load(object sender, EventArgs e)
        {


            Dictionary<string, object> param = new Dictionary<string, object>();
            param.Add("showinfo", this.medicalSharingDTOList);

            var x = FuncletCreater.GetLocalFunclet(string.Format("modules/iihci/ui/medicalsharing/{0}", "medicalsharing_config.xml"), param);
            XBaseControl xcon = new XBaseControl();
            xcon.AddRender(x);
            this.Panel = xcon;
        }

        void cancelBtn_MouseClick(object sender, MouseEventArgs e)
        {
            DialogResult = DialogResult.Cancel;
        }

        void confirmBtn_MouseClick(object sender, MouseEventArgs e)
        {
            DialogResult = DialogResult.OK;
        }
    }
}

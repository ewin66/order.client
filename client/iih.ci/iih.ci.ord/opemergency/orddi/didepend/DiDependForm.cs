using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.diag.dto.judgedideletedto.d;
using iih.ci.ord.dto.d;
using xap.cli.sdk.controls;
using xap.rui.control.basecontrol;
using xap.rui.engine2.utils;

namespace iih.ci.ord.opemergency.orddi.didepend
{
    public partial class DiDependForm : XBaseDialog
    {
        public List<Judgedideletedto> medicalSharingDTOList;

        public DiDependForm(List<Judgedideletedto> list)
        {
            this.medicalSharingDTOList = list;
            InitializeComponent();
            this.Load += new EventHandler(MedicalSharingInfoForm_Load);

            this.cancelBtn.MouseClick += cancelBtn_MouseClick;
        }

        void MedicalSharingInfoForm_Load(object sender, EventArgs e)
        {


            Dictionary<string, object> param = new Dictionary<string, object>();
            param.Add("showinfo", this.medicalSharingDTOList);

            var x = FuncletCreater.GetLocalFunclet(string.Format("modules/iihci/ui/judgedidelete/{0}", "judgedidelete_config.xml"), param);
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

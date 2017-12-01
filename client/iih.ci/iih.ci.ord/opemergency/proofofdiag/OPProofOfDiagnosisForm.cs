using System;
using System.Windows.Forms;
using iih.ci.ord.opemergency.viewmodel;
using iih.en.pv.dto.d;
using iih.en.pv.entdiprove.d;
using xap.cli.sdk.form;
using xap.cli.sdk.render;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using iih.ci.ord.opemergency.proofofdiag.viewprint;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.opemergency.proofofdiag
{
    public partial class OPProofOfDiagnosisForm : XDialog
    {
        #region 变量定义区域
        private XapFormControl xapFormControl = new XapFormControl();

        private EntDiProveDO entDiProveDo;
        private Ent4BannerDTO ent4BannerDTO;
        private OPProofOfDiagnosisViewModel model;

        private UserRender btnSave;
        private UserRender btnPrint;

        private bool isInit = true;
        #endregion

        #region 构造函数区域
        private OPProofOfDiagnosisForm()
        {
           
            //this.Load += new EventHandler(OPProofOfDiagnosisForm_Load);
            this.xapFormControl.Load += new EventHandler(xapFormControl_Load);
            this.xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
            this.xapFormControl.DataChanged += new EventHandler<xap.rui.control.forms.model.DataChangedEventArgs>(xapFormControl_DataChanged);
        }

        public OPProofOfDiagnosisForm(EntDiProveDO entDiProveDo, OPProofOfDiagnosisViewModel model, Ent4BannerDTO ent4BannerDTO)
            :this()
        {
            this.entDiProveDo = entDiProveDo;
            this.ent4BannerDTO = ent4BannerDTO;
            this.model = model;

            this.xapFormControl.Dock = DockStyle.Fill;
            this.Panel.Controls.Add(this.xapFormControl);
        }
        #endregion

        #region 父类继承区域
        private void OnLoadData()
        {
            if (!isInit)
            {
                model.LoadData(entDiProveDo.Id_ent);
                entDiProveDo = model.SetEntDiProveDO(ent4BannerDTO);
            }

            isInit = false;
            OnFillData();
        }

        private void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_OP_OPProofOfDiagnosisForm;// "20160617114459878FFP";
            file.FormStyle = FormStyle.List;
            file.ViewModel = this.entDiProveDo;
            this.xapFormControl.ViewFile = file;
            xapFormControl.Refresh();
            xapFormControl.SetEditable(true);
        }
        #endregion

        #region 内部事件区域
        //private void OPProofOfDiagnosisForm_Load(object sender, EventArgs e)
        //{
        //    this.OnLoadData();
        //}

        private void xapFormControl_Load(object sender, EventArgs e)
        {
            this.OnLoadData();
        }

        private void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            btnSave = xapFormControl.GetUserRender("entprove", "save");
            btnPrint = xapFormControl.GetUserRender("entprove", "print");
            
            btnSave.MouseClick += new MouseEventHandler(btnSave_MouseClick);
            btnPrint.MouseClick += new MouseEventHandler(btnPrint_MouseClick);

            btnPrint.Enabled = !String.IsNullOrWhiteSpace(entDiProveDo.Id_diprove);
        }

        private void xapFormControl_DataChanged(object sender, xap.rui.control.forms.model.DataChangedEventArgs e)
        {
            btnSave.Enabled = true;
        }

        private void btnPrint_MouseClick(object sender, MouseEventArgs e)
        {
            //诊断证明和休假证明
            DiProvePrintDialog printDialog = new DiProvePrintDialog(this.entDiProveDo.Id_ent);
            printDialog.ShowDialog();
        }

        private void btnSave_MouseClick(object sender, MouseEventArgs e)
        {
            this.xapFormControl.SaveForm();
            this.model.Save();
            this.OnLoadData();
            btnSave.Enabled = false;
            btnPrint.Enabled = true;
            this.SetStatusMsg("保存成功");
        }
        #endregion

    }
}

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.rui.control.basecontrol;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using iih.en.pv.entdiprove.d;
using xap.rui.engine;
using xap.cli.sdk.render;
using System.Windows.Forms;
using xap.cli.sdk.render.labelcontrol;
using System.Drawing;
using xap.rui.bizcontrol.BillFormTmplConst;

/********************************************************************************

** 作者： 杨敬本

** 创始时间：2016/10/21

** 修改人：杨敬本

** 修改时间：2016/10/21

** 描述：诊断证明of休假证明

*********************************************************************************/

namespace iih.ci.ord.opemergency.proofofdiag.viewprint
{
    public partial class DiProvePrinTypeView : XapCardControl
    {
        private XapFormControl xapFormControl;

        private EntDiProveDO datasource;

        #region 构造函数区域
        public DiProvePrinTypeView()
        {
            InitializeComponent();

            datasource = new EntDiProveDO();

            this.xapFormControl.Load += new EventHandler(xapFormControl_Load);
            this.xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
            this.xapFormControl.DataChanged += new EventHandler<xap.rui.control.forms.model.DataChangedEventArgs>(xapFormControl_DataChanged);
        }

        private void InitializeComponent()
        {
            this.xapFormControl = new XapFormControl();
            this.SuspendLayout();
            // 
            // xapFormControl
            // 
            this.xapFormControl.Context = null;
            this.xapFormControl.Dock = DockStyle.Fill;
            this.xapFormControl.IsXapGrid = true;
            this.xapFormControl.Location = new Point(0, 0);
            this.xapFormControl.Name = "xapFormControl";
            this.xapFormControl.Size = new Size(150, 150);
            this.xapFormControl.TabIndex = 0;
            // 
            // DiProvePrinTypeView
            // 
            //this.AutoScaleDimensions = new SizeF(6F, 12F);
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.xapFormControl);
            this.Margin = new System.Windows.Forms.Padding(3, 6, 3, 6);
            this.Name = "DiProvePrinTypeView";
            this.ResumeLayout(false);
       

            this.ResumeLayout(false);
        }
        #endregion

        #region 内部事件区域
        private void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            XLabelBaseUserRender userRender = this.xapFormControl.GetUserRender("tab_type", "def12") as XLabelBaseUserRender;
            userRender.Enabled = true;
        }

        private void xapFormControl_Load(object sender, EventArgs e)
        {
            this.OnInit();

            //初始加载诊断证明打印模板
            onFireEventSent("SelectType", "01");
        }

        private void xapFormControl_DataChanged(object sender, xap.rui.control.forms.model.DataChangedEventArgs e)
        {
            //切换诊断证明or休假证明
            onFireEventSent("SelectType", (sender as XLabelBaseUserRender).ValueCode);
        }

        #endregion

        #region 父类继承区域
        protected override void OnLoadData()
        {

        }

        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormStyle = FormStyle.Card;
            file.FormId = CiOrdBillFormTmplConst.CIORD_OP_DiProvePrinTypeView;// "20161021080251610000";
            file.ViewModel = this.datasource;

            this.xapFormControl.ViewFile = file;
        }
        #endregion

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

    }
}

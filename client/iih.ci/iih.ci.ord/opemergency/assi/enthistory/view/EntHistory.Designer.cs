using xap.rui.bizcontrol.Historyofrecords;
using System.Windows.Forms;
using xap.rui.bizcontrol.Historyofrecords.card;
using System.Drawing;

namespace iih.ci.ord.opemergency.assi.enthistory.view
{
    partial class EntHistory
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary> 
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region 组件设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            //this.entpHisotyList = new XListBox();

            //this.xapFormControl = new XapFormControl();
            this.recordView = new HistoricalRecords();
            this.SuspendLayout();

            //// 
            //// xapFormControl
            //// 
            //this.xapFormControl.Context = null;
            //this.xapFormControl.Dock = System.Windows.Forms.DockStyle.Fill;
            //this.xapFormControl.File = null;
            //this.xapFormControl.IsContainerRender = true;
            //this.xapFormControl.IsShowWarnForm = true;
            //this.xapFormControl.IsXapGrid = true;
            //this.xapFormControl.Location = new System.Drawing.Point(0, 0);
            //this.xapFormControl.Name = "xapFormControl";
            //this.xapFormControl.SingleBorderStyle = false;
            //this.xapFormControl.Size = new System.Drawing.Size(150, 150);
            //this.xapFormControl.TabIndex = 0;
            //this.xapFormControl.Text = "xapFormControl1";
            //this.xapFormControl.ViewFile = null;
            //this.xapFormControl.AfterFocused += new System.EventHandler<xap.rui.control.forms.model.DataFocusedEventArgs>(xapFormControl_AfterFocused);
            ///
            /// recordView
            ///
            this.recordView.Dock = DockStyle.Fill;
            this.recordView.CardClick += new System.EventHandler(recordView_CardClick);

            if (this.recordView.GetBottomGroup() != null)
            {
                this.recordView.GetBottomGroup().AddRender(new StateRender { ForeColor = Color.FromArgb(0, 153, 229), ExplainName = "门诊" });
                this.recordView.GetBottomGroup().AddRender(new StateRender { ForeColor = Color.FromArgb(36, 159, 131), ExplainName = "住院" });
                this.recordView.SateGrpOnTop = true;
            }
            this.AddRender(this.recordView);



            components = new System.ComponentModel.Container();

            //this.entpHisotyList.Location = new System.Drawing.Point(0, 0);
            //this.entpHisotyList.Size = this.Size;
            //this.entpHisotyList.TabIndex = 0;
            //this.entpHisotyList.MouseClick += new System.Windows.Forms.MouseEventHandler(entpHisotyList_MouseClick);

            //this.AddRender(this.entpHisotyList);
            this.Load += new System.EventHandler(EntpHistory_Load);

            this.ResumeLayout(false);
        }

        //private XListBox entpHisotyList;

        private HistoricalRecords recordView;
        //private XapFormControl xapFormControl;

        #endregion
    }
}

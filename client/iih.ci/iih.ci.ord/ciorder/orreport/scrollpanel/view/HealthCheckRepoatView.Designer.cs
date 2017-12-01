using xap.rui.control.forms.view;
using xap.cli.sdk.render.Items;
using xap.rui.control.basecontrol;
using xap.cli.sdk.controls;
using System.Drawing;
using System.Collections.Generic;
using System.Windows.Forms;
namespace iih.ci.ord.ciorder.orreport.scrollpanel.view
{
    partial class HealthCheckRepoatView
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
        protected override void InitializeComponent()
        {
            this.Dock = DockStyle.None;
            components = new System.ComponentModel.Container();
            this.xapFromControl = new XapFormControl();
            this.xapFromControl.Dock = DockStyle.None;
            XLabel title = new XLabel();
            title.ValueText = "医保审核";
            title.Height = 20;
            title.Width = 100;
            title.Font = new Font("微软雅黑", 14, GraphicsUnit.Pixel);
            title.ForeColor = Color.FromArgb(0, 153, 229);
            xapLayoutPanel = new XLayoutPanel();
            this.xapLayoutPanel.Dock = DockStyle.Fill;
            //xapLayoutPanel.Size = this.Size;
            this.AddRender(xapLayoutPanel);
            XBaseControl titleCtr = new XBaseControl();
            titleCtr.Dock = DockStyle.None;
            titleCtr.AddRender(title);
            this.radioGroup = new XRadioboxGroup(this.GetRadioList());
            this.radioGroup.IsDefaultSelected = false;
            radioGroup.Location = new Point(0,30);
            radioGroup.Size = new Size(300,25);
            titleCtr.AddRender(radioGroup);
            xapLayoutPanel.AddControl(titleCtr, ControlPosition.Top, 65);
            //xapFromControl.Location = new Point(0,title.Location.Y+title.Height + 10);
            xapLayoutPanel.AddControl(xapFromControl, ControlPosition.Center);

        }
        #region 组件设计器生成的代码
        private List<xap.cli.sdk.render.Items.XRadiobox> GetRadioList(){
            List<xap.cli.sdk.render.Items.XRadiobox> list = new List<xap.cli.sdk.render.Items.XRadiobox>();
            xap.cli.sdk.render.Items.XRadiobox uncheckRadio = new xap.cli.sdk.render.Items.XRadiobox();
            uncheckRadio.Text = ReportCodeDict.HP_TREAT_ALL_SELECT;

            xap.cli.sdk.render.Items.XRadiobox checkRadio = new xap.cli.sdk.render.Items.XRadiobox();
            checkRadio.Text = ReportCodeDict.HP_TREAT_ALL_BLANK;
            checkRadio.ForeColor = System.Drawing.Color.Blue;

            list.Add(uncheckRadio);
            list.Add(checkRadio);
            return list;
        }
        private xap.cli.sdk.render.Items.XRadioboxGroup radioGroup;
        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        #endregion
    }
}

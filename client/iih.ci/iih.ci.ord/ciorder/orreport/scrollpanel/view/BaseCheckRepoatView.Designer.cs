using xap.rui.control.forms.view;
using xap.cli.sdk.render.Items;
using xap.rui.control.basecontrol;
using xap.cli.sdk.controls;
using System.Drawing;
using System.Windows.Forms;
using System.Collections.Generic;
using iih.pi.common;
namespace iih.ci.ord.ciorder.orreport.scrollpanel.view
{
    partial class BaseCheckRepoatView
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
        protected virtual void InitializeComponent()
        {
            components = new System.ComponentModel.Container();
            this.Dock = DockStyle.None;
            this.xapFromControl = new XapFormControl();
            this.xapFromControl.Dock = DockStyle.Fill;
            XapBaseControl titleControl = new XapBaseControl();
            XLabel title = new XLabel();
            title.ValueText = this.title;
            title.Height = 20;
            title.Width = 100;
            title.Font = new Font("微软雅黑", 14, GraphicsUnit.Pixel);
            title.ForeColor = Color.FromArgb(0, 153, 229);
            xapLayoutPanel = new XLayoutPanel();
            //xapLayoutPanel.Size = this.Size;
            xapLayoutPanel.Dock = DockStyle.Fill;
            this.AddRender(xapLayoutPanel);
            XBaseControl titleCtr = new XBaseControl();
            titleCtr.AddRender(title);
            xapLayoutPanel.AddControl(titleCtr, ControlPosition.Top, 30);
            //xapFromControl.Location = new Point(0,title.Location.Y+title.Height + 10);
            xapLayoutPanel.AddControl(xapFromControl, ControlPosition.Center);
        }
       
        #endregion
        #region 变量
        protected XapFormControl xapFromControl;
        protected XLayoutPanel xapLayoutPanel;
        #endregion
    }
}

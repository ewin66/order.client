using iih.ci.ord.ciorder.cards;
using xap.cli.sdk.controls;
using System.Windows.Forms;
using System;

namespace iih.ci.ord.ciorder.takedrug4outhosp.view
{
    partial class TakeDrugOutCardView
    {
        /// <summary>
        /// 
        /// </summary>
        public XLayoutPanel splitContainer1;
        /// <summary>
        /// 医疗单的底部的区域（索引+按钮）
        /// </summary>
        private EmsIndexAndButtonArea emsIndexAndButtonArea;
        /// <summary> 
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        public EmsIndexAndButtonArea EmsIndexAndButtonArea
        {
            get
            {
                return emsIndexAndButtonArea;
            }
        }

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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(TakeDrugOutCardView));
            this.emsIndexAndButtonArea = new EmsIndexAndButtonArea();
            this.splitContainer1 = new XLayoutPanel();
            //((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).BeginInit();
            //this.splitContainer1.SuspendLayout();
            this.SuspendLayout();
            // 
            // orCom
            // 
            //this.orCom.AutoValidate = System.Windows.Forms.AutoValidate.EnableAllowFocusChange;
            //this.orCom.Bottmflag = false;
            this.emsIndexAndButtonArea.Context = null;
            //this.orCom.Dock = System.Windows.Forms.DockStyle.Fill;
            this.emsIndexAndButtonArea.File = null;
            this.emsIndexAndButtonArea.Location = new System.Drawing.Point(0, 0);
            this.emsIndexAndButtonArea.Name = "emsIndexAndButtonArea";
            this.emsIndexAndButtonArea.RenderVisable = false;
            this.emsIndexAndButtonArea.Size = new System.Drawing.Size(628, 56);
            this.emsIndexAndButtonArea.TabIndex = 0;
            this.emsIndexAndButtonArea.SaveClickEvent += new System.EventHandler(this.orCom_SaveClickEvent);
            this.emsIndexAndButtonArea.CancelClickEvent += new System.EventHandler(this.orCom_CancelClickEvent);
            this.emsIndexAndButtonArea.RounderClick += new MouseEventHandler(this.orCom_MouseClick);
            this.emsIndexAndButtonArea.DeleteEvent += new EventHandler(this.orCom_deleteevent);
            // 
            // splitContainer1
            // 
            this.splitContainer1.Dock = System.Windows.Forms.DockStyle.Fill;
            //this.splitContainer1.FixedPanel = System.Windows.Forms.FixedPanel.Panel2;
            //this.splitContainer1.Location = new System.Drawing.Point(0, 0);
            //this.splitContainer1.Name = "splitContainer1";
            //this.splitContainer1.Orientation = System.Windows.Forms.Orientation.Horizontal;
            //this.splitContainer1.Size = new System.Drawing.Size(507, 313);
            //this.splitContainer1.SplitterDistance = 223;
            //this.splitContainer1.SplitterWidth = 1;
            //this.splitContainer1.TabIndex = 3;
            // 
            // OrderCardView
            // 
            ////this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            ////this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.splitContainer1);

            this.Name = "OrderCardView";
            //((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).EndInit();
            //this.splitContainer1.ResumeLayout(false);
            this.ResumeLayout(false);

        }



        #endregion


    }
}

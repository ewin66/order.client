

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.form;
using xap.cli.sdk.render;
using xap.cli.sdk.controls.tabControl;
using xap.cli.sdk.Render.Items;
using xap.cli.sdk.controls.navbar;
using xap.cli.sdk.controls;
using xap.cli.sdk.common;
using xap.cli.sdk.render.Items;

namespace iih.ci.ord.opemergency.ems.stomatology
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ems.stomatology    </para>    
    /// <para>类 名 称 :  ToothBitmapDialog					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/9/27 14:19:40             </para>
    /// <para>更新时间 :  2016/9/27 14:19:40             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class ToothBitmapView : XForm
    {
        private XButton btSave;
        public Bitmap Toothmap;
        private XButton cancel;

        private PdEditorRender pdRender;
        private GrEditorRender grEditorRender;
        private SicknessTeethRender sicknessRender;
        private QuadrantEditorRender quadrantEditor;
        private XBaseTeethEditorRender tempRender;
        //private TeethBitmap teethBitmap;
        private string sickPositionStr;
        protected Dictionary<int, QuadrantRender> quadrantDic = new Dictionary<int, QuadrantRender>();
        public QuadrantRender SelectRender { get; set; }
        public string SickPositionStr
        {
            get
            {
                return this.sickPositionStr;
            }
            set
            {
                this.sickPositionStr = value;
                string[] sickstr = value.Split('|', '^');
                if (sickstr.Length > 0)
                {
                    this.SelectRender.Select = false;
                    this.quadrantDic[Convert.ToInt32(sickstr[0])].Select = true;
                    this.SelectRender = this.quadrantDic[Convert.ToInt32(sickstr[0])];
                    this.AddInput(this.quicklyInput, Convert.ToInt32(sickstr[0]));
                    this.tempRender.SickPositionStr = value;
                }
            }
        }

        public ToothBitmapView()
        {
            InitializeComponent();
            //map.Size = new System.Drawing.Size(300,100);
            Rectangle scr_rect = Screen.GetWorkingArea(this);
            Size sz = new Size();
            sz.Width = (int)(860); sz.Height = (int)(574);
            this.Size = sz;
            Init();
            this.StartPosition = FormStartPosition.CenterScreen;
        }
        protected void Init()
        {
            TitleControl leftControl = new TitleControl();
            leftControl.SetSizeFlag = true;
            leftControl.Size = new System.Drawing.Size(222,448);
            leftControl.Text = "分类列表";
            leftControl.SetBoder = true;
            XBaseControl dataControl = new XBaseControl();
            dataControl.MouseClick += new MouseEventHandler(dataControl_MouseClick);
            this.Additem(dataControl);
            dataControl.Size = new System.Drawing.Size(240, 385);
            leftControl.Pannel = dataControl;
            tab.XTabPages.Add(quicklyInput);
            tab.XTabPages.Add(photoInput);
            photoInput.Visible = false;
            controlCenter.AddRender(tab);
            this.btSave = new XButton();
            this.btSave.Text = "插 入";
            this.btSave.Enabled = false;
            this.btSave.MouseClick += new MouseEventHandler(btSave_MouseClick);
            this.btSave.Size = new System.Drawing.Size(90,24);
            controlCenter.AddRender(this.btSave);
            this.cancel = new XButton();
            this.cancel.Size = new System.Drawing.Size(90, 24);
            this.cancel.Text = "关 闭";
            this.cancel.MouseClick += new MouseEventHandler(cancel_MouseClick);
            controlCenter.AddRender(this.cancel);
            controlCenter.Paint += new PaintEventHandler(controlCenter_Paint);
            this.xLayoutPanel1.AddControl(controlCenter, ControlPosition.Center);
            this.xLayoutPanel1.AddControl(leftControl, ControlPosition.Left, 222);
            this.cancel.Location = new Point(320, controlCenter.Bounds.Bottom - 35);
            this.btSave.Location = new Point(220, controlCenter.Bounds.Bottom - 35);
            this.AddInput(this.quicklyInput, this.SelectRender.TeethType);
        }
        protected void btSave_MouseClick(object sender, MouseEventArgs e)
        {
            foreach (XTextBox render in this.tempRender.TextBoxDic.Values)
            {
                if (render.IsError)
                {
                   // MessageBoxEx.Show("录入不正确：" + render.ErrorText, "错误提示", MessageBoxButtons.OKCancel, MessageBoxIconEx.Error);
                    MessageBoxEx.Show("录入不正确：" + render.ErrorText, "错误提示");
                    render.Focus();
                    return;
                }
            }
            TeethBitmap teethRender = new TeethBitmap(tempRender);
            teethRender.Preview = false;
            teethRender.SickPositionStr = this.tempRender.TeethRender.SickPositionStr;
            teethRender.Location = new Point(0, 0);
            this.Toothmap = new Bitmap(teethRender.Size.Width+1, teethRender.Size.Height+1);
            Graphics grapPath = Graphics.FromImage(Toothmap);
            grapPath.Clear(Color.White);
            grapPath.TextRenderingHint = System.Drawing.Text.TextRenderingHint.AntiAliasGridFit;
            teethRender.Render(grapPath);

            BmpConvertMessage.BitmapInput(Toothmap, teethRender.SickPositionStr);
            this.DialogResult = DialogResult.OK;
        }
        void cancel_MouseClick(object sender, MouseEventArgs e)
        {
            this.DialogResult = DialogResult.Cancel;
        }
        protected  void controlCenter_Paint(object sender, PaintEventArgs e)
        {
            e.Graphics.DrawLine(new Pen(Color.FromArgb(137, 137, 137)), new Point(0, (sender as XBaseControl).Bounds.Bottom - 45), new Point((sender as XBaseControl).Bounds.Right - 1, (sender as XBaseControl).Bounds.Bottom - 45));
        }
        protected void dataControl_MouseClick(object sender, MouseEventArgs e)
        {
            foreach (KeyValuePair<int ,QuadrantRender> pair in this.quadrantDic)
            {
                if (pair.Value.Bound.Contains(e.Location))
                {
                    pair.Value.Select = true;
                    this.SelectRender = pair.Value;
                    this.AddInput(quicklyInput, pair.Value.TeethType);
                }
                else
                {
                    pair.Value.Select = false;
                }
            }
            if (this.SelectRender != null && !this.SelectRender.Select)
            {
                this.SelectRender.Select = true;
            }
        }
        protected void Additem(XBaseControl Control)
        {
            QuadrantRender render1 = new QuadrantRender();
            render1.Location = new Point(3,4);
            render1.TeethType = 1;
            Control.AddRender(render1);
            render1.Select = true;
            this.SelectRender = render1;
            this.quadrantDic.Add(render1.TeethType,render1);

            QuadrantRender render2 = new QuadrantRender();
            render2.Location = new Point(3, render1.Bound.Bottom+3);
            render2.TeethType = 2;
            Control.AddRender(render2);
            this.quadrantDic.Add(render2.TeethType, render2);

            QuadrantRender render3 = new QuadrantRender();
            render3.Location = new Point(3, render2.Bound.Bottom + 3);
            render3.Size = new System.Drawing.Size(215,90);
            render3.TeethType = 3;
            Control.AddRender(render3);
            this.quadrantDic.Add(render3.TeethType, render3);

            QuadrantRender render4 = new QuadrantRender();
            render4.Location = new Point(3, render3.Bound.Bottom + 3);
            render4.TeethType = 4;
            Control.AddRender(render4);
            this.quadrantDic.Add(render4.TeethType, render4);

            QuadrantRender render5 = new QuadrantRender();
            render5.Location = new Point(3, render4.Bound.Bottom + 3);
            render5.TeethType = 5;
            Control.AddRender(render5);
            this.quadrantDic.Add(render5.TeethType, render5);

            //QuadrantRender render6 = new QuadrantRender();
            //render6.Location = new Point(3, render5.Bound.Bottom + 3);
            //render6.TeethType = 6;
            //Control.AddRender(render6);
            this.quadrantDic.Add(render5.TeethType + 1, render5);

            QuadrantRender render7 = new QuadrantRender();
            render7.Location = new Point(3, render5.Bound.Bottom + 3);
            render7.TeethType = 7;
            Control.AddRender(render7);
            this.quadrantDic.Add(render7.TeethType, render7);
        }
        protected void AddInput(XBaseControl Control,int type)
        {
            Control.RemoveRenderAll();
            if (type <= 3)
            {
                quadrantEditor = new QuadrantEditorRender();
                quadrantEditor.Location = new Point(11, 10);
                quadrantEditor.TeethType = type;
                quadrantEditor.Text = this.SelectRender.Text;
                tempRender = quadrantEditor;
                Control.AddRender(quadrantEditor);
            }
            else if (type == 4)
            {
                pdRender = new PdEditorRender();
                pdRender.Location = new Point(10, 10);
                pdRender.TeethType = type;
                pdRender.Text = this.SelectRender.Text;
                tempRender = pdRender;
                Control.AddRender(pdRender);
            }
            else if (type == 5)
            {
                sicknessRender = new SicknessTeethRender();
                sicknessRender.Location = new Point(10, 10);
                sicknessRender.TeethType =type;
                sicknessRender.Text = this.SelectRender.Text;
                tempRender = sicknessRender;
                Control.AddRender(sicknessRender);
            }
            else 
            {
                grEditorRender = new GrEditorRender();
                grEditorRender.Location = new Point(10, 10);
                grEditorRender.TeethType = type;
                grEditorRender.Text = this.SelectRender.Text;
                tempRender = grEditorRender;
                Control.AddRender(grEditorRender);
            }
            tempRender.ValueTextChanged += new EventHandler(tempRender_ValueTextChanged);
            this.btSave.Enabled = false ;
            // 添加注释说明
            this.AddNote(Control,type);
        }
        /// <summary>
        /// 检验是否有病变牙位录入
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected void tempRender_ValueTextChanged(object sender, EventArgs e)
        {
            bool enableFlag = false;
            foreach (KeyValuePair<int, XTextBox> pair in this.tempRender.TextBoxDic)
            {
                if (!string.IsNullOrEmpty(pair.Value.ValueText) && !pair.Value.IsError)
                {
                    enableFlag = true;
                }
            }
            this.btSave.Enabled = enableFlag;
        }
        /// <summary>
        /// 添加注释
        /// </summary>
        private void AddNote(XBaseControl Control, int type)
        {
            int startX = 20;
            int startY = 310;
            foreach (XLabel item in this.noteList)
            {
                Control.RemoveRender(item);
                if (type <= 3)
                {
                    if (item.Tag != null && item.Tag.Equals(type))
                    {
                        item.Location = new Point(startX, startY);
                        startY += item.Size.Height;
                        Control.AddRender(item);
                    }
                    else if (item.Tag == null)
                    {
                        item.Location = new Point(startX, startY);
                        startY += item.Size.Height;
                        Control.AddRender(item);
                    }
                    else if (item.Tag != null && Convert.ToInt32(item.Tag) >= type && item.Equals(this.connectLabel))
                    {
                        item.Location = new Point(startX, startY);
                        startY += item.Size.Height;
                        Control.AddRender(item);
                    }
                }
            }
            Control.Invalidate();
        }
    }
}

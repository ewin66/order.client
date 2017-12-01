using System;
using System.Drawing;
using System.Windows.Forms;
using xap.cli.sdk.render;
using xap.cli.sdk.render.labelcontrol;
using iih.ci.ord.opemergency.ems.dp;
using xap.cli.sdk.common;
using iih.ci.ord.ciordems.d;
using xap.cli.sdk.Render.Items;
using iih.ci.ord.opemergency.view.basic;
using iih.ci.ord.opemergency.ems.stomatology;
using iih.ci.ord.ciorder.utils;
using xap.cli.sdk.render.Items;
using iih.ci.ord.opemergency.tool;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.opemergency.ems
{

    /// <summary>
    /// <para>描    述 : 口腔检查医疗单                     </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.ems  </para>    
    /// <para>类 名 称 : EmsRisViewCard               </para> 
    /// <para>版 本 号 : v1.0.0.0                        </para> 
    /// <para>作    者 : qzwang                           </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05              </para>
    /// <para>修 改 人 :                                  </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05             </para> 
    /// <para>说    明 :                     </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EmsStomatologyRisViewCard : EmsRisViewCard
    {
        //cof.adjustHeight(this.xapFormControl, "bt_card", adjustHeightIds, poor);
        #region 参数定义
        private string[] adjustHeightIds = new string[] { "checkPurpose", "def1", "def2", "def23", "def3", "def4", "def24", "def5", "def6", "def25", "def7", "def8", "def26", "def9", "def10", "def27", "def11", "def12", "def28", "def13", "def14", "def29", "def15", "def16", "def30", "clinicalzztz", "def17", "def18", "def19", "def20", "cm", "KG" };
        private XLabelBaseUserRender toothLabel1;
        private XLabelBaseUserRender toothLabel2;
        private XLabelBaseUserRender toothLabel3;
        private XLabelBaseUserRender toothLabel4;
        private XLabelBaseUserRender toothLabel5;
        private XLabelBaseUserRender toothLabel6;
        private XLabelBaseUserRender toothLabel7;
        private XLabelBaseUserRender toothLabel8;
        private XLabelBaseUserRender checkbox1;
        private XLabelBaseUserRender checkbox2;
        private XLabelBaseUserRender checkbox3;
        private XLabelBaseUserRender checkbox4;
        private XLabelBaseUserRender checkbox5;
        private XLabelBaseUserRender checkbox6;
        private XLabelBaseUserRender checkbox7;
        private XLabelBaseUserRender checkbox8;
        XLabelBaseUserRender heightRender;
        XLabelBaseUserRender weightRender;
        #endregion
        #region 构造函数区域
        public EmsStomatologyRisViewCard(IEventDelegate owner)
            : base(owner)
        {
        }
        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsStomatologyRisViewCard/*"20160912025135501000"*/);
        }

        #endregion
        #region 内部事件区域

        protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            if (this.GetViewModel() != null)
            {
                EmsStomatologyRisViewModel tmpModel = this.GetViewModel() as EmsStomatologyRisViewModel;
                //this.detailButton.Visible = tmpModel.isSet();
                //if (!this.detailButton.Visible)
                //{
                //    LogicEx.GetInstance().adjustHeight(this.GetXapFormControl(), "card", this.adjustHeightIds, -31);
                //    this.GetXapFormControl().Invalidate();
                //}
                string def2 = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def2;
                loadToothPicture(def2, this.toothLabel1);
                string def4 = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def4;
                loadToothPicture(def4, this.toothLabel2);
                string def6 = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def6;
                loadToothPicture(def6, this.toothLabel3);
                string def8 = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def8;
                loadToothPicture(def8, this.toothLabel4);
                string def10 = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def10;
                loadToothPicture(def10, this.toothLabel5);
                string def12 = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def12;
                loadToothPicture(def12, this.toothLabel6);
                string def14 = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def14;
                loadToothPicture(def14, this.toothLabel7);
                string def16 = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def16;
                loadToothPicture(def16, this.toothLabel8);

                heightRender.ValueText = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def17;
                weightRender.ValueText = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def18;
            }
        }
        protected override void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.OnXapFormControl_FormCreated(sender, e);
            checkbox1 = this.GetXapFormControl().GetUserRender("card", "def1") as XLabelBaseUserRender;
            checkbox1.MouseClick += new MouseEventHandler(checkbox1_MouseClick);
            checkbox2 = this.GetXapFormControl().GetUserRender("card", "def3") as XLabelBaseUserRender;
            checkbox2.MouseClick += new MouseEventHandler(checkbox1_MouseClick);
            checkbox3 = this.GetXapFormControl().GetUserRender("card", "def5") as XLabelBaseUserRender;
            checkbox3.MouseClick += new MouseEventHandler(checkbox1_MouseClick);
            checkbox4 = this.GetXapFormControl().GetUserRender("card", "def7") as XLabelBaseUserRender;
            checkbox4.MouseClick += new MouseEventHandler(checkbox1_MouseClick);
            checkbox5 = this.GetXapFormControl().GetUserRender("card", "def9") as XLabelBaseUserRender;
            checkbox5.MouseClick += new MouseEventHandler(checkbox1_MouseClick);
            checkbox6 = this.GetXapFormControl().GetUserRender("card", "def11") as XLabelBaseUserRender;
            checkbox6.MouseClick += new MouseEventHandler(checkbox1_MouseClick);
            checkbox7 = this.GetXapFormControl().GetUserRender("card", "def13") as XLabelBaseUserRender;
            checkbox7.MouseClick += new MouseEventHandler(checkbox1_MouseClick);
            checkbox8 = this.GetXapFormControl().GetUserRender("card", "def15") as XLabelBaseUserRender;
            checkbox8.MouseClick += new MouseEventHandler(checkbox1_MouseClick);
            toothLabel1 = this.GetXapFormControl().GetUserRender("card", "def2") as XLabelBaseUserRender;
            toothLabel1.UserRender.Name = "def2";
            (toothLabel1.UserRender as XPictureBox).BorderColor = Color.FromArgb(200, 200, 200);
            //(toothLabel1.UserRender as XPictureBox).BorderColor = Color.Red;
            //(toothLabel1.UserRender as XPictureBox).Invalidate();
            toothLabel1.UserRender.MouseDoubleClick += new MouseEventHandler(UserRender_MouseDoubleClick);

            toothLabel2 = this.GetXapFormControl().GetUserRender("card", "def4") as XLabelBaseUserRender;
            toothLabel2.UserRender.Name = "def4";
            (toothLabel2.UserRender as XPictureBox).BorderColor = Color.FromArgb(200, 200, 200);
            toothLabel2.UserRender.MouseDoubleClick += new MouseEventHandler(UserRender_MouseDoubleClick);

            toothLabel3 = (this.GetXapFormControl().GetUserRender("card", "def6") as XLabelBaseUserRender);
            toothLabel3.UserRender.Name = "def6";
            (toothLabel3.UserRender as XPictureBox).BorderColor = Color.FromArgb(200, 200, 200);
            toothLabel3.UserRender.MouseDoubleClick += new MouseEventHandler(UserRender_MouseDoubleClick);

            toothLabel4 = this.GetXapFormControl().GetUserRender("card", "def8") as XLabelBaseUserRender;
            toothLabel4.UserRender.Name = "def8";
            (toothLabel4.UserRender as XPictureBox).BorderColor = Color.FromArgb(200, 200, 200);
            toothLabel4.UserRender.MouseDoubleClick += new MouseEventHandler(UserRender_MouseDoubleClick);

            toothLabel5 = this.GetXapFormControl().GetUserRender("card", "def10") as XLabelBaseUserRender;
            toothLabel5.UserRender.Name = "def10";
            (toothLabel5.UserRender as XPictureBox).BorderColor = Color.FromArgb(200, 200, 200);
            toothLabel5.UserRender.MouseDoubleClick += new MouseEventHandler(UserRender_MouseDoubleClick);

            toothLabel6 = this.GetXapFormControl().GetUserRender("card", "def12") as XLabelBaseUserRender;
            toothLabel6.UserRender.Name = "def12";
            (toothLabel6.UserRender as XPictureBox).BorderColor = Color.FromArgb(200, 200, 200);
            toothLabel6.UserRender.MouseDoubleClick += new MouseEventHandler(UserRender_MouseDoubleClick);

            toothLabel7 = this.GetXapFormControl().GetUserRender("card", "def14") as XLabelBaseUserRender;
            toothLabel7.UserRender.Name = "def14";
            (toothLabel7.UserRender as XPictureBox).BorderColor = Color.FromArgb(200, 200, 200);
            toothLabel7.UserRender.MouseDoubleClick += new MouseEventHandler(UserRender_MouseDoubleClick);

            toothLabel8 = this.GetXapFormControl().GetUserRender("card", "def16") as XLabelBaseUserRender;
            toothLabel8.UserRender.Name = "def16";
            (toothLabel8.UserRender as XPictureBox).BorderColor = Color.FromArgb(200, 200, 200);
            toothLabel8.UserRender.MouseDoubleClick += new MouseEventHandler(UserRender_MouseDoubleClick);

            heightRender = this.GetXapFormControl().GetUserRender("card", "height") as XLabelBaseUserRender;
            heightRender.ValueTextChanged += new EventHandler(heightRender_ValueTextChanged);
            heightRender.MaxLength = 5;
            heightRender.MultilineNum = 1;
          
            (heightRender.UserRender as XUnitTextBoxMul).IsNumber = true;
            (heightRender.UserRender as XUnitTextBoxMul).MinValue = 0;
            (heightRender.UserRender as XUnitTextBoxMul).UnitText = "cm";
           

            weightRender = this.GetXapFormControl().GetUserRender("card", "weight") as XLabelBaseUserRender;
            weightRender.ValueTextChanged += new EventHandler(heightRender_ValueTextChanged);
           
            (weightRender.UserRender as XUnitTextBoxMul).IsNumber = true;
            (weightRender.UserRender as XUnitTextBoxMul).MinValue = 0;
            (weightRender.UserRender as XUnitTextBoxMul).UnitText = "KG";
            weightRender.MaxLength = 5;
            weightRender.MultilineNum = 1;
           
        }

        private void WHRender_ValueTextChanging(object sender, ChangingEventArgs e)
        {
            if (null != e.NewValue)
                e.Cancel = !AssToolEx.IsUnsign(e.NewValue.ToString());
            
        }

        void checkbox1_MouseClick(object sender, MouseEventArgs e)
        {
            XLabelBaseUserRender label = sender as XLabelBaseUserRender;
            if (!label.Checked)
            {
                if (label.Name.Equals("card_def1"))
                {
                    string def2 = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def2 = "";
                    loadToothPicture(def2, this.toothLabel1);
                    (toothLabel1.UserRender as XPictureBox).Image = null;
                    (toothLabel1.UserRender as XPictureBox).Invalidate();
                }
                else if (label.Name.Equals("card_def3"))
                {
                    string def4 = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def4 = "";
                    loadToothPicture(def4, this.toothLabel2);
                    (toothLabel2.UserRender as XPictureBox).Image = null;
                    (toothLabel2.UserRender as XPictureBox).Invalidate();
                }
                else if (label.Name.Equals("card_def5"))
                {
                    string def6 = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def6 = "";
                    loadToothPicture(def6, this.toothLabel3);
                    (toothLabel3.UserRender as XPictureBox).Image = null;
                    (toothLabel3.UserRender as XPictureBox).Invalidate();
                }
                else if (label.Name.Equals("card_def7"))
                {
                    string def8 = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def8 = "";
                    loadToothPicture(def8, this.toothLabel4);
                    (toothLabel4.UserRender as XPictureBox).Image = null;
                    (toothLabel4.UserRender as XPictureBox).Invalidate();
                }
                else if (label.Name.Equals("card_def9"))
                {
                    string def10 = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def10 = "";
                    loadToothPicture(def10, this.toothLabel5);
                    (toothLabel5.UserRender as XPictureBox).Image = null;
                    (toothLabel5.UserRender as XPictureBox).Invalidate();
                }
                else if (label.Name.Equals("card_def11"))
                {
                    string def12 = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def12 = "";
                    loadToothPicture(def12, this.toothLabel6);
                    (toothLabel6.UserRender as XPictureBox).Image = null;
                    (toothLabel6.UserRender as XPictureBox).Invalidate();
                }
                else if (label.Name.Equals("card_def13"))
                {
                    string def14 = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def14 = "";
                    loadToothPicture(def14, this.toothLabel7);
                    (toothLabel7.UserRender as XPictureBox).Image = null;
                    (toothLabel7.UserRender as XPictureBox).Invalidate();
                }
                else if (label.Name.Equals("card_def15"))
                {
                    string def16 = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def16 = "";
                    loadToothPicture(def16, this.toothLabel8);
                    (toothLabel8.UserRender as XPictureBox).Image = null;
                    (toothLabel8.UserRender as XPictureBox).Invalidate();
                }
            }


        }

        void heightRender_ValueTextChanged(object sender, EventArgs e)
        {
            XLabelBaseUserRender xLabel = sender as XLabelBaseUserRender;
            if (xLabel.Name.Equals("card_height"))
            {
                (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def17 = xLabel.ValueText;
            }
            else if (xLabel.Name.Equals("card_weight"))
            {
                (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def18 = xLabel.ValueText;
            }
        }
        #endregion
        #region 内部处理函数
        private void loadToothPicture(string toothstr, XLabelBaseUserRender toothLabel)
        {
            if (string.IsNullOrEmpty(toothstr)) return;
            TeethBitmap teethRender = new TeethBitmap(toothstr);
            teethRender.Preview = false;
            teethRender.Location = new Point(0, 0);
            Bitmap Toothmap2 = new Bitmap(teethRender.Size.Width + 1, teethRender.Size.Height + 1);
            Graphics grapPath = Graphics.FromImage(Toothmap2);
            grapPath.Clear(Color.White);
            grapPath.TextRenderingHint = System.Drawing.Text.TextRenderingHint.AntiAliasGridFit;
            teethRender.Render(grapPath);
            (toothLabel.UserRender as XPictureBox).Image = Toothmap2;
            BmpConvertMessage.BitmapInput(Toothmap2, toothstr);
            (toothLabel.UserRender as XPictureBox).Invalidate();
        }
        void UserRender_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            XPictureBox xapPictureBox = sender as XPictureBox;
            using (ToothBitmapView tooth = new ToothBitmapView())
            {
                if (xapPictureBox.Image != null && !string.IsNullOrEmpty(BmpConvertMessage.BitmapOutput((Bitmap)xapPictureBox.Image)))
                    tooth.SickPositionStr = BmpConvertMessage.BitmapOutput((Bitmap)xapPictureBox.Image);
                if (tooth.ShowDialog() == DialogResult.OK)
                {
                    xapPictureBox.Image = tooth.Toothmap;
                    if (xapPictureBox.Name.Equals("def2"))
                    {
                        (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def2 = BmpConvertMessage.BitmapOutput(tooth.Toothmap);
                        if (!string.IsNullOrEmpty((this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def2))
                        {
                            checkbox1.Checked = true;
                        }
                        xapPictureBox.Invalidate();
                    }
                    else if (xapPictureBox.Name.Equals("def4"))
                    {
                        (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def4 = BmpConvertMessage.BitmapOutput(tooth.Toothmap);
                        if (!string.IsNullOrEmpty((this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def4))
                        {
                            checkbox2.Checked = true;
                        }
                        xapPictureBox.Invalidate();
                    }
                    else if (xapPictureBox.Name.Equals("def6"))
                    {
                        (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def6 = BmpConvertMessage.BitmapOutput(tooth.Toothmap);
                        if (!string.IsNullOrEmpty((this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def6))
                        {
                            checkbox3.Checked = true;
                        }
                        xapPictureBox.Invalidate();
                    }
                    else if (xapPictureBox.Name.Equals("def8"))
                    {
                        (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def8 = BmpConvertMessage.BitmapOutput(tooth.Toothmap);
                        if (!string.IsNullOrEmpty((this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def8))
                        {
                            checkbox4.Checked = true;
                        }
                        xapPictureBox.Invalidate();
                    }
                    else if (xapPictureBox.Name.Equals("def10"))
                    {
                        (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def10 = BmpConvertMessage.BitmapOutput(tooth.Toothmap);
                        if (!string.IsNullOrEmpty((this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def10))
                        {
                            checkbox5.Checked = true;
                        }
                        xapPictureBox.Invalidate();
                    }
                    else if (xapPictureBox.Name.Equals("def12"))
                    {
                        (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def12 = BmpConvertMessage.BitmapOutput(tooth.Toothmap);
                        if (!string.IsNullOrEmpty((this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def12))
                        {
                            checkbox6.Checked = true;
                        }
                        xapPictureBox.Invalidate();
                    }
                    else if (xapPictureBox.Name.Equals("def14"))
                    {
                        (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def14 = BmpConvertMessage.BitmapOutput(tooth.Toothmap);
                        if (!string.IsNullOrEmpty((this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def14))
                        {
                            checkbox7.Checked = true;
                        }
                        xapPictureBox.Invalidate();
                    }
                    else if (xapPictureBox.Name.Equals("def16"))
                    {
                        (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def16 = BmpConvertMessage.BitmapOutput(tooth.Toothmap);
                        if (!string.IsNullOrEmpty((this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def16))
                        {
                            checkbox8.Checked = true;
                        }
                        xapPictureBox.Invalidate();
                    }
                }
            }
        }
        #endregion
    }
}

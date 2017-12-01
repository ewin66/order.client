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
    /// <para>描    述 : XRay数字化牙片【00010733】                   </para> 
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
    public partial class EmsStomatologyDigitizationToothViewCard : EmsRisViewCard
    {
        #region 参数定义
        private XLabelBaseUserRender toothLabel1;
        #endregion
        #region 构造函数区域
        public EmsStomatologyDigitizationToothViewCard(IEventDelegate owner)
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
            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsStomatologyDigitizationToothViewCard/*"20170629051333247000"*/);
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
            }
        }
        protected override void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.OnXapFormControl_FormCreated(sender, e);
            toothLabel1 = this.GetXapFormControl().GetUserRender("card", "def1") as XLabelBaseUserRender;
            toothLabel1.UserRender.Name = "def1";
            (toothLabel1.UserRender as XPictureBox).BorderColor = Color.FromArgb(200, 200, 200);
            toothLabel1.UserRender.MouseDoubleClick += new MouseEventHandler(UserRender_MouseDoubleClick);
           
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
                    string def1 = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def1 = "";
                    loadToothPicture(def1, this.toothLabel1);
                    (toothLabel1.UserRender as XPictureBox).Image = null;
                    (toothLabel1.UserRender as XPictureBox).Invalidate();
                }
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
                    if (xapPictureBox.Name.Equals("def1"))
                    {
                        (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapobs.Def2 = BmpConvertMessage.BitmapOutput(tooth.Toothmap);
                    }
                }
            }
        }
        #endregion
    }
}

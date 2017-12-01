using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.rui.control.basecontrol;
using xap.mw.core.data;
using System.Drawing;
using xap.cli.sdk.render.Items;
using System.Windows.Forms;
using xap.cli.sdk.common;
using iih.en.pv.dto.d;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using xap.mw.coreitf.d;
using iih.ci.ord.opemergency.tool;
using xap.cli.sdk.controls;
using xap.rui.engine;
using xap.cli.sdk.render;
using xap.cli.sdk.form;
using iih.ci.ord.opemergency.view;
using xap.rui.appfw;
using iih.ci.ord.ciordems.d;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.view.basic;
using xap.rui.control.forms.control;

namespace iih.ci.ord.opemergency.controls
{
    /// <summary>
    /// 费用合计显示条控件
    /// </summary>
    public partial class EmsFeesControl : XapBaseControl, IControlSizeChanged
    {
        public XapBaseControl ownerView;
        public FMap2 _dataSource = null;//费用显示集合
        public FMap2 moneyLabelMap = new FMap2();
        protected Ent4BannerDTO patDo;
        public event ControlSizeChangedHandler ControlSizeChanged;
        private void FireControlSizeChanged()
        {
            if (ControlSizeChanged != null)
            {
                ControlSizeChanged(this.Size);
            }
        }
        CiIconToolButton infoButton;
        public EmsFeesControl()
        {
            
            this.Dock = DockStyle.None;
            init();
          
            SkinFactory.Instance().SkinChanged += new SkinFactory.SkinChangedEventHandler(OrdListView_SkinChanged);
        }

    

        protected override void OnLoad(EventArgs e)
        {
            base.OnLoad(e);
            OnInit();
            this.BringToFront();
        }
        void OrdListView_SkinChanged()
        {
            //this.BackColor = SkinFactory.Instance().CurrentSkin.MenuViewMain_Back_Color;
            this.BackColor = ((SolidBrush)SkinFactory.Instance().CurrentSkin.TabPage_Back_Brush).Color;
            if(moneyLabelMap!=null){
                (moneyLabelMap["AllFees"] as XLabel).ForeColor = SkinFactory.Instance().CurrentSkin.MenuSelectedForeColor;
                (moneyLabelMap["HasPay"] as XLabel).ForeColor = SkinFactory.Instance().CurrentSkin.MenuSelectedForeColor;
                (moneyLabelMap["NoPay"] as XLabel).ForeColor = SkinFactory.Instance().CurrentSkin.MenuSelectedForeColor;
            }
            this.Invalidate();
        }
        protected override void DisposeManaged()
        {
            base.DisposeManaged();
            SkinFactory.Instance().SkinChanged -= new SkinFactory.SkinChangedEventHandler(OrdListView_SkinChanged);
        }
        protected override void OnLoadData()
        {
            if (this.patDo != null)
            {
                ICiOrdQryService ciOrderQryService = XapServiceMgr.find<ICiOrdQryService>();
                this._dataSource = ciOrderQryService.getPatEntFeesCensus(this.patDo.Id_ent, this.patDo.Code_entp, FBoolean.False);
            }
            else
            {
                init();
            }
        }
        protected override void OnFillData()
        {
            base.OnFillData();
            this.fillFees();
        }
        public override void OnSelected(object sender, TargetEventArgs e)
        {
            base.OnSelected(sender, e);
            if (e.Object is xap.rui.bizcontrol.bannercontrol.BannerData)
            {
                this.patDo = (e.Object as xap.rui.bizcontrol.bannercontrol.BannerData).Ent4BannerDTO;
                if (null != infoButton)
                {
                    infoButton.Enabled = true;
                }

            }
            else {
                this.patDo = null;
            }
            //OnLoadData();
            //OnFillData();

            LoadData();
        }
        void init() {
            FMap2 m = new FMap2();
            m.Add("AllFees", "0.00");
            m.Add("HasPay", "0.00");
            m.Add("NoPay", "0.00");
            m.Add("group", new FArrayList());
            this._dataSource = m;
           
        }
        public void fillFees()
        {
            if (_dataSource != null)
            {
               moneyLabelMap.Clear();
               this.RemoveRenderAll();
               XapBaseControl allControl = getFeeLabelControl("AllFees", "金额合计：", _dataSource["AllFees"].ToString(), "元", new Point(nOffsetX, 0));
               XapBaseControl payControl = getFeeLabelControl("HasPay", "已缴费：", _dataSource["HasPay"].ToString(), "元", new Point(allControl.Bounds.Right + nOffsetX, 0));
               XapBaseControl noControl = getFeeLabelControl("NoPay", "未缴费：", _dataSource["NoPay"].ToString(), "元", new Point(payControl.Bounds.Right + nOffsetX, 0));
               this.AddRender(allControl);
               this.AddRender(payControl);
               this.AddRender(noControl);
                ///if (null == infoButton)
                {
                    infoButton = new CiIconToolButton { Visible = this.patDo != null, Tag = 1000, Location = new Point(noControl.Bounds.Right + 2, 0), Size = new Size(24, 24), TipText = "查看缴费", LargeImageMode = true, ImageName = "缴费查询" };//

                    SkinFactory.Instance().SkinChanged += infoButton.OnSystemSkinChanged;
                    infoButton.MouseClick += InfoButton_MouseClick;
                }

                this.AddRender(infoButton);
                OrdListView_SkinChanged();
               if (RelativeUIParam.ScreenSize == ScreenSize.Large)
               {
                   this.Size = new Size(allControl.Bounds.Width + payControl.Bounds.Width + noControl.Bounds.Width + infoButton.Size.Width + 80, nTitleHeight);
                   this.Invalidate();
               }
            }
        }

        private void InfoButton_MouseClick(object sender, MouseEventArgs e)
        {
            var mmContainer = new XBaseControl() { Size = new Size(473, 200) };
          
            var ordFeeCollectInfoView = new OrdFeeCollectInfoView(mmContainer, _dataSource["group"] as FArrayList);
            ordFeeCollectInfoView.Dock = DockStyle.Fill;
            ordFeeCollectInfoView.SingleBorderStyle = true;
            mmContainer.AddRender(ordFeeCollectInfoView);
            var popWindow = new XContextForm(mmContainer);
            var pt = this.ownerView.Location;
            pt.Offset((ownerView.Size.Width- mmContainer.Size.Width) / 2,  (RelativeUIParam.ScreenSize != ScreenSize.Large)? -7:22);
            popWindow.Show(ownerView.PointToScreen(pt));
        }

        public int nTitleHeight = 24;
        public int nOffsetX = 20;
        private XapBaseControl getFeeLabelControl(string code,string title, string money, string meadoc, Point location)
        {
            XapBaseControl control = new XapBaseControl();
            control.Location = location;
            control.BringToFront();
            control.BackColor = Color.Transparent;
            XLabel titleL = new XLabel();
            Font font = new Font(titleL.Font.FontFamily, 15, titleL.Font.Style, GraphicsUnit.Pixel);
            titleL.Font = font;
            titleL.Size = new Size(TextRenderer.MeasureText(title, font).Width, nTitleHeight);
            titleL.Location = new Point(0, 0);
            titleL.ValueText = title;
            //titleL.BackColor = Color.Blue;
            XLabel moneyL = new XLabel();
            font = new Font(moneyL.Font.FontFamily, 15, moneyL.Font.Style, GraphicsUnit.Pixel);
            moneyL.Font = font;
            moneyL.Size = new Size(TextRenderer.MeasureText(money, font).Width, nTitleHeight);
            moneyL.Location = new Point(titleL.Bound.Right, 0);
            moneyL.ValueText = money;
            moneyL.Name = code;
            moneyLabelMap.Add(code,moneyL);
            //moneyL.BackColor = Color.Yellow;
            XLabel meadocL = new XLabel();
            font = new Font(meadocL.Font.FontFamily, 15, meadocL.Font.Style, GraphicsUnit.Pixel);
            meadocL.Font = font;
            meadocL.Size = new Size(TextRenderer.MeasureText(meadoc, font).Width, nTitleHeight);
            meadocL.Location = new Point(moneyL.Bound.Right, 0);
            meadocL.ValueText = meadoc;
            //meadocL.BackColor = Color.Green;
            control.Size = new Size(new Point(titleL.Bound.Width + moneyL.Bound.Width + meadocL.Bound.Width, nTitleHeight));
            control.AddRender(titleL);
            control.AddRender(moneyL);
            control.AddRender(meadocL);
            return control;

        }
        public override void HandleState(object sender, xap.rui.engine.DictionaryEventArgs e)
        {
            base.HandleState(sender, e);
            string newState = e.Data[UIConst.NEW_STATE] as string;
            var eventCode = AssToolEx.EventCodeOfEventArgs(e);
           
            if (eventCode != null && (eventCode.Equals("EmsFeesControl") || 
                eventCode.Equals("OpSupend")) && this.Created)
            {
                this.LoadData();
            }
        }
    }
   
    public class OrdFeeCollectInfoView : BaseFormBizView
    {
        XBaseControl parentView = null;
        XapDataList<EmsFeesDTO> datasource = new XapDataList<EmsFeesDTO>();
        public OrdFeeCollectInfoView(XBaseControl o,FArrayList ds):base(null)
        {
            parentView = o;
            if (null != ds && ds.Count > 0)
            {
                foreach (Object objFee in ds)
                {
                    datasource.Add(objFee as EmsFeesDTO);
                }
            }

        }
        protected override void InitializeBizView()
        {
            base.InitializeBizView();
            
            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_OrdFeeCollectInfoView); // "20170509021110856000"
            this.RegisteFormEventImpl();
            this.SetFormDataSource(datasource);
        }

        protected override void OnXapFormControl_Load(object sender, EventArgs e)
        {
            base.OnXapFormControl_Load(sender, e);
            this.OnInit();
        }

        protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            base.OnXapFormControl_ModelFilled(sender, e);
            var gridView = this.GetXapFormControl().GetGridView("feeslist");
            gridView.DataTable.DataSource = GetFormDataSource();
            this.GetXapFormControl().SetEditable(false);

            this.GetXapFormControl().Size = GetFixedSize(gridView);
            this.Size = this.GetXapFormControl().Size;
            parentView.Size = this.GetXapFormControl().Size;
            //
        }

        public virtual Size GetFixedSize(XapFormGridControl grid)
        {
            if (grid != null)
            {
                int height = grid.DataTable.Size.Height + (grid.HScroll.Visible ? 14 : 0);
                return new System.Drawing.Size(this.Size.Width, height);
            }
            return new Size(0, 0);

        }
    }
}

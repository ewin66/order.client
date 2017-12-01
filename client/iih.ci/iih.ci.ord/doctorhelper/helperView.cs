using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.en.pv.pativisit.d;
using xap.rui.control.basecontrol;
using xap.cli.sdk.render;
using xap.rui.engine;
using xap.rui.engine.registers;
using xap.cli.sdk.render.Items;
using iih.ci.ord.ciorder.view;
using xap.cli.sdk.controls.navbar;
using iih.ci.ord.ciorder.cards.extend;
using xap.rui.engine.eventbroker;
using iih.ci.ord.ciorder.d;
using iih.en.pv.dto.d;
using xap.rui.bizcontrol.bannercontrol;
using xap.cli.sdk.form;

namespace iih.ci.ord.doctorhelper
{
    public partial class helperView : XapListControl, IXEventPublication, IRegister, IXapBaseControl, IWorkStationRegist
    {
        //患者信息
        public Ent4BannerDTO patDo = new Ent4BannerDTO();
        public new event EventHandler<DictionaryEventArgs> EventSent;
        public OrScArgs Args { get; set; }
        protected helperForm OrderSevrice_Frm;
        //private TabNavigatorControl Tabcontrol;
        public helperView()
        {
            InitializeComponent();
            this.Load +=new EventHandler(helperView_Load);
            //createInstance();
            //this.Tabcontrol = new TabNavigatorControl();
        }

        public void createInstance()
        {
            XImageTextButton OrderSevricebutton = (XImageTextButton)this.Context.Config.GetInstance("Button");
            OrderSevricebutton.MouseClick -= new MouseEventHandler(OrderSevricebutton_MouseClick);
            OrderSevricebutton.MouseClick += new MouseEventHandler(OrderSevricebutton_MouseClick);
           // VoiceButton 
            XImageTextButton OrderVoiceButton = (XImageTextButton)this.Context.Config.GetInstance("VoiceButton");
            //OrderVoiceButton.Inputstatus += new XImageTextButton.RecordState(OrderVoiceButton_Inputstatus);
           // OrderCardView tt = (OrderCardView)this.Context.Config.GetInstance("emrordercard_view");
           // OrderSevricebutton.ba
        }
        //音频录入状态
        void OrderVoiceButton_Inputstatus(bool record)
        {
            //无音频录入
            if (!record)
            {
                MessageBoxEx.Show("未检测到任何音频录入", "系统提示", MessageBoxButtons.OKCancel, MessageBoxIconEx.Warning);
            }
        }

        void OrderSevricebutton_MouseClick(object sender, MouseEventArgs e)
        {
            OrderSevrice_Frm = new helperForm(this);
            OrderSevrice_Frm.StartPosition = FormStartPosition.CenterScreen;
            if (this.patDo != null)
            {
                OrderSevrice_Frm.Ent4BannerDTO = this.patDo;
               // OrderSevrice_Frm.context = this.Context;
            }
            //OrderSevrice_Frm.FormClosed += new FormClosedEventHandler(OrderSevrice_Frm_FormClosed);
            if (OrderSevrice_Frm.ShowDialog() == DialogResult.OK)
            {
                Dictionary<string, Object> dict = new Dictionary<string, Object>();
                dict.Add("newListSelected", this.Args);
                DictionaryEventArgs de = new DictionaryEventArgs();
                de.Data.Add(UIConst.UI_EVENT, "ListSelected");
                de.Data.Add(UIConst.DATA, dict);
                this.EventSent(this, de);
            }
        }

        //void OrderSevrice_Frm_FormClosed(object sender, FormClosedEventArgs e)
        //{
        //    Dictionary<string, string> dict = new Dictionary<string, string>();
        //    dict.Add("newListSelected", "newListSelected");
        //    DictionaryEventArgs de = new DictionaryEventArgs();
        //    de.Data.Add(UIConst.UI_EVENT, "ListSelected");
        //    de.Data.Add(UIConst.DATA, dict);
        //    this.EventSent((sender as helperForm).args, de);
        //    this.Tabcontrol.BackColor = Color.Red;

        //    this.Tabcontrol.Focus();
        //    this.Tabcontrol.NavTabControl.Focus();
        //}
        //public void SentOrder(CiOrderDO[] Orders)
        //{
        //    OrScArgs Args = new OrScArgs();
        //    Args.Obj = Orders;
        //    Dictionary<string, Object> dict = new Dictionary<string, Object>();
        //    dict.Add("newListSelected", Args);
        //    DictionaryEventArgs de = new DictionaryEventArgs();
        //    de.Data.Add(UIConst.UI_EVENT, "ListSelected");
        //    de.Data.Add(UIConst.DATA, dict);
        //    this.EventSent(this, de);
        //}
        private void helperView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.REFRESH:
                    if(this.Created)
                    this.LoadData();
                    break;
                case UIEvent.LOAD:
                    this.createInstance();
                        Dictionary<string, object> dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    if (dic != null)
                    {
                        if (dic.Keys.Contains("PatientData"))
                        {
                            patDo = (dic["PatientData"] as BannerData).Ent4BannerDTO;
                        }
                        if (dic.Keys.Contains("IsInHospitalStation"))
                        {
                            patDo = (dic["PatientData"] as BannerData).Ent4BannerDTO;
                        }

                    }
                    break;
                default :
                    break;
            }
        }

        #endregion
        #region 注册与反注册到工作站
        public void Regist(EventBroker eventBroker)
        {
            eventBroker.Register(this);
        }
        public void UnRegist(EventBroker eventBroker)
        {
            eventBroker.Unregister(this);
        }
        #endregion

        public override void OnDeptChanged()
        {
            patDo.Id_ent = "";
            this.LoadData();
        }

        public void UpdatePatientInfo(object sender, DictionaryEventArgs eventArgs)
        {

            if (eventArgs.Data.Keys.Contains("PatientData"))
            {
                object obj = eventArgs.Data["PatientData"];
                patDo = obj as Ent4BannerDTO;
                if (Created)
                    this.LoadData();

            }
        }
    }
}

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.doctorhelper.past.viewmodel;
using iih.en.pv.pativisit.d;
using xap.rui.control.basecontrol;
using xap.rui.control.tree.otree;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;
using iih.en.pv.dto.d;
using xap.cli.sdk.render;
using iih.ci.ord.ciorder.render;
using xap.cli.context;

namespace iih.ci.ord.doctorhelper.past.view
{
    /// <summary>
    /// 住院使用患者既往
    /// </summary>
    public partial class PastTreeView : BaseHelperView, IWorkStationRegist
    {
        #region 变量定义区域

        public Ent4BannerDTO patDo = new Ent4BannerDTO();
        private PastTreeViewModel model;
        private XListBox xListBox;
        #endregion

        #region 构造函数区域
        public PastTreeView()
        {
            InitializeComponent();
            this.xListBox = new XListBox(this);
            this.xListBox.FrameBrush = new SolidBrush(Color.FromArgb(232, 232, 232));
            this.xListBox.Size = new Size(248, 250);
            this.xListBox.Location = new Point(0, 0);
            this.AddRender(this.xListBox);

            this.xListBox.SelectedValueChanged += new EventHandler(xListBox_SelectedValueChanged);
            this.Load += new EventHandler(PastTreeView_Load);
            this.Resize += new EventHandler(PastTreeView_Resize);
        }
        #endregion

        #region 公开属性区域

        #endregion

        #region 命令定义区域

        //[XapCommand(Name = "Open", Caption = "打开")]
        //public void OnOpen(object sender, EventArgs e)
        //{

        //}

        #endregion

        #region 事件发送区域

        //[XapEventSent(Name = "Say")]
        //public event EventHandler<XapEventArgs> Say;

        #endregion

        #region 事件接收区域

        //[XapEventRecv(Name = "Recv")]
        //public void OnRecv(object sender, XapEventArgs e)
        //{

        //}
        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            Control control = this.Parent;
            while (control != null)
            {
                if (control.Text == "智能助手")
                {
                    break;
                }
                else
                {
                    control = control.Parent;
                }
            }
            if (control != null)
            {
                patDo = (control as helperForm).Ent4BannerDTO;
            }
      
           // UserManager user = (control as helperForm).userManager;
            if (patDo != null && patDo.Code_pat != null)
            {
                this.model = new PastTreeViewModel(patDo.Code_pat);
            }
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            if (this.model == null)
                return;
            this.xListBox.ClearItems();
            if (this.model.ListEntHisDiDTO != null)
            {
                EntHisDiDTO[] listEntHisDiDTO = this.model.ListEntHisDiDTO.ToArray();
                if (listEntHisDiDTO != null && listEntHisDiDTO.Length > 0)
                {
                    foreach (EntHisDiDTO enthisdto in listEntHisDiDTO)
                    {
                        XOrderImageListItem data = new XOrderImageListItem();
                        data.ItemHeight = 32;
                        data.Id = enthisdto.Id_ent;
                        if (enthisdto.Dt_acpt != null)
                        {
                            String dateTime = enthisdto.Dt_acpt.ToString();
                            dateTime = dateTime.Substring(0, 10);
                            data.Text = enthisdto.Name_didef_dis + "(" + dateTime + " " + enthisdto.Name_dep + ")";

                        }
                        else
                        {
                            data.Text = enthisdto.Name_didef_dis + "(" + enthisdto.Name_dep + ")";
                        }



                        //00门诊10住院
                        if (enthisdto.Code_entp != null)
                        {
                            if (enthisdto.Code_entp == "00")
                            {
                                data.FlagIcon =
                                    Bitmap.FromStream(
                                        System.Reflection.Assembly.GetExecutingAssembly()
                                            .GetManifestResourceStream("iih.ci.ord.Resources.门诊.png"));
                            }
                            else
                            {
                                data.FlagIcon =
                                    Bitmap.FromStream(
                                        System.Reflection.Assembly.GetExecutingAssembly()
                                            .GetManifestResourceStream("iih.ci.ord.Resources.住院.png"));
                            }
                        }

                        xListBox.Add(data);
                    }
            } else
            {
                XOrderImageListItem data = new XOrderImageListItem();
                data.ItemHeight = 32;
                data.Text = "没有数据";
                xListBox.Add(data);
            }
        }
            else
            {
                XOrderImageListItem data = new XOrderImageListItem();
                data.ItemHeight = 32;
                data.Text = "没有数据";
                xListBox.Add(data);
            }
        }

        #endregion

        #region 内部事件区域
        private void PastTreeView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

        /// <summary>
        /// 发送ListBox节点选中事件到卡上显示数据
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void xListBox_SelectedValueChanged(object sender, EventArgs e)
        {
            this.FireSelected(this.xListBox.SelectedItem);

            XOrderImageListItem Enthisdto = this.xListBox.SelectedItem as XOrderImageListItem;
            if (Enthisdto == null)
            {
                this.Context["Id_ent"] = "";
            }
            else
            {
                this.Context["Id_ent"] = Enthisdto.Id;
            }

            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, "SelectedItem");
            base.FireEventSent(this, args);
        }

        void PastTreeView_Resize(object sender, EventArgs e)
        {
            xListBox.Size = this.Size;
        }

        #endregion

        #region 辅助处理函数

        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.REFRESH:
                    this.LoadData();
                    break;
                case UIEvent.LOAD:

                    Dictionary<string, object> dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    if (dic != null)
                    {
                        if (dic.Keys.Contains("PatientData"))
                        {
                            patDo = dic["PatientData"] as Ent4BannerDTO;
                        }
                        if (dic.Keys.Contains("IsInHospitalStation"))
                        {
                            patDo.Id_ent = dic["EncounterID"].ToString();
                        }

                    }
                    break;
                default:
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

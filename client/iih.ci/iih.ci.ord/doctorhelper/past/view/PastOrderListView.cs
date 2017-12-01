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
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.engine;
using iih.en.pv.dto.d;
using xap.cli.sdk.render;
using xap.cli.sdk.controls;
using xap.cli.sdk.layouts;
using iih.ci.ord.ciorder.d;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.controls.DataView.Model;
using xap.rui.control.forms.control;
using xap.cli.sdk.render.DoctorOrderCard;
using iih.ci.ord.ciorder.cards.extend;
using xap.cli.sdk.controls.tabControl;
using iih.ci.ord.ciorder.render;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.doctorhelper.past.view
{
    /// <summary>
    /// 住院使用患者既往
    /// </summary>
    public partial class PastOrderListView : HelperListView
    {
        //患者既往
        #region 变量定义区域
        private XapFormControl xapFormControl1;
        private XapFormGridControl gv;//控件
        private OrScArgs Args;
        private PastOrderListViewModel model;
        private string id_ent = null;
        public PatiVisitDO patDo = new PatiVisitDO();
        #endregion

        #region 构造函数区域
        public PastOrderListView()
        {
            InitializeComponent();
            this.xapFormControl1 = new XapFormControl();
            this.xapFormControl1.Dock = DockStyle.Fill;
            this.AddRender(this.xapFormControl1);

            this.Load += new EventHandler(PastOrderListView_Load);
            this.xapFormControl1.FormCreated += new EventHandler(control_FormCreated);
        }

        void control_FormCreated(object sender, EventArgs e)
        {
            gv = this.xapFormControl1.GetGridView("content_or");
            gv.DataTable.DataDisplay += new EventHandler<XDataDisplayEventArgs>(tabControl_DataDisplay);
            gv.DataTable.Rows.DefaultHeight = 32;
        }

        void tabControl_DataDisplay(Object sender, XDataDisplayEventArgs e)
        {
            XDataRow row = sender as XDataRow;
            if (row != null)
            {
                foreach (UserRender render in row.UserRenderList)
                {
                    if (render is DoctorOrderCard)
                    {
                        DoctorOrderCard card = render as DoctorOrderCard;

                        card.ConfigPath = "\\modules\\iihci\\ui\\commoncontent\\OrderContent.xml";
                    }
                }

            }

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
        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if (e.Object is XOrderImageListItem)
            {
                this.id_ent = (e.Object as XOrderImageListItem).Id;
                LoadData();
            }
            ////base.OnSelected(sender, e);
            //Control control = this.Parent;
            //// 判断该页签是否是选中
            //while (control != null)
            //{
            //    if (control is XTabPage)
            //    {
            //        if ((control as XTabPage).IsSelected)
            //        {
            //            if (e.Object is XOrderImageListItem)
            //            {
            //                this.id_ent = (e.Object as XOrderImageListItem).Id;
            //                LoadData();
            //            }
            //        }
            //        break;
            //    }
            //    else
            //    {
            //        control = control.Parent;
            //    }
            //}
        }
        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            if (id_ent != null)
            {
                this.model = new PastOrderListViewModel(id_ent);
            }
            
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            if (model != null)
            {
                FormFile file = new FormFile();
                file.FormId = CiOrdBillFormTmplConst.CIORD_IP_PastOrderListView;// "20160225025246591KIE";
                file.FormStyle = FormStyle.Card;
                file.ViewModel = model.listCiOrderDo;
                // 20160225025246591KIE
                this.xapFormControl1.ViewFile = file;
            }
        }

        public override void SaveData()
        {
            CiOrderDO[] Oreders = this.xapFormControl1.GetSelected<CiOrderDO>();
            Args = new OrScArgs();
            Args.listObj = new List<object>();
            Args.Id_item = "past";
            Control control = this.Parent;
            // 向上寻找父窗体，并把数据主动的跑出去。
            while (control != null)
            {
                if (control.Text == "智能助手")
                {
                    break;
                }
                else if (control is XTabPage)
                {
                    Args.listObj.Add((control as XTabPage).Name);
                    control = control.Parent;
                }
                else
                {
                    control = control.Parent;
                }
            }
            foreach (CiOrderDO CiorderDo in Oreders)
            {
                Args.listObj.Add(CiorderDo);
            }
            (control as helperForm).Args = Args;
            (control as helperForm).DialogResult = DialogResult.OK;
        }

        #endregion

        #region 内部事件区域
        private void PastOrderListView_Load(object sender, EventArgs e)
        {
            this.OnInit();
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
                            patDo = dic["PatientData"] as PatiVisitDO;
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
    }
}

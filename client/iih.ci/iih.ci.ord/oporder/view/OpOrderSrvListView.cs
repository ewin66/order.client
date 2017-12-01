using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;
using iih.ci.ord.ciorder.viewmodel;
using xap.rui.engine;
using xap.rui.control.forms.model;
using xap.rui.control.formcontrol.model;
using xap.rui.appfw;
using iih.en.pv.pativisit.d;
using iih.ci.ord.ciorder.cards.extend;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder;
using iih.en.pv.dto.d;
using xap.cli.sdk.controls;
using xap.cli.sdk.render.Items;
using xap.cli.sdk.render.labelcontrol;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.oporder.view
{

    public partial class OpOrderSrvListView : CiorderBaseControl
    {

        public Ent4BannerDTO ent4BannerDto;//患者信息DTO
        #region 构造函数区域
        public OpOrderSrvListView()
        {
            InitializeComponent();
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            //xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
            //搜索框
            srvSearch = new XSearch(ctr);
            srvSearch.Size = new Size(350, 24);
            srvSearch.Location = new Point(0, 0);
            srvSearch.dipItemsCout = 10;
            ctr.Size = srvSearch.Size;
            ctr.AddRender(srvSearch);
            Dictionary<string, Control> controls = new Dictionary<string, Control>();
            controls.Add("search", ctr);
            this.xapFormControl1.RegisterControl(controls);
            

        }

       

        //void xapFormControl1_ModelFilled(object sender, EventArgs e)
        //{
        //    g.GridControl.DataSource = model.ScResultList;
        //}




     

       
        

        #endregion


        #region 变量定义区域
  OrSrvForm frm;
        //XLabelBaseUserRender txtSrvCa, txtSrv;
        string lastSrvCa="";//上次检索的服务类型
        XSearch srvSearch;
        XBaseControl ctr = new XAPScrollBarPanel();
        OrderSrvListViewModel model = new OrderSrvListViewModel("");
        #endregion


        #region 公开属性区域

        #endregion

        #region 命令定义区域



        #endregion

        #region 事件发送区域

        public void SendMgs()
        {
            DictionaryEventArgs dic = new DictionaryEventArgs();
            dic.Data[UIConst.UI_EVENT] = UIEvent.SAVE_SUCCESS;
            this.FireEventSent(this, dic);
        }
        #endregion

        #region 事件接收区域

        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            this.model = new OrderSrvListViewModel("");
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            FormFile f = new FormFile();
            f.FormId = CiOrdBillFormTmplConst.CIORD_IP_OpOrderSrvListView;// "20150916021649286T5R";// "20150818044216049LN4";
            f.FormStyle = xap.rui.control.forms.view.FormStyle.Card;
            xapFormControl1.ViewFile = f;
            xapFormControl1.SetEditPolicy(true);

        }

        public override void OnSelected(object sender, xap.rui.control.basecontrol.TargetEventArgs e)
        {
            if (e.Object is PatiVisitDO)//{iih.en.pv.pativisit.d
            {
                this.Enabled = true;
            }
        }


        #endregion

        #region 内部事件区域



        /// <summary>
        /// 加载事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void OrderSerListView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

        void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            srvSearch.DataSource = this.model.srvtps;

            List<ControlTab> tabs = xapFormControl1.FormModel.Tabs;

            srvSearch.ValueTextChanged += new EventHandler(txtSrv_ValueChanged);
            srvSearch.KeyClick += new KeyEventHandler(txtSrv_KeyDown);
            srvSearch.MouseClick += new MouseEventHandler(btnQuery_MouseClick);

        }


        void txtSrv_ValueChanged(object sender, EventArgs e)
        {
            if (frm != null)
            {
                if (Application.OpenForms["OrSrvForm"] != null)
                {
                    //frm.SCTextChanged(txtSrv.ValueText);
                }
            }
        }

        void txtSrv_KeyDown(object sender, KeyEventArgs e)
        {
            btnQuery_MouseClick(null, null);
        }

        void btnQuery_MouseClick(object sender, MouseEventArgs e)
        {
            if (Application.OpenForms["OrSrvForm"] == null)
            {
                XapDataList<EmsOrSrvSc> list = model.GetSrv(lastSrvCa == "" ? srvSearch.ValueText : lastSrvCa, srvSearch.ValueText, this.ent4BannerDto.Code_entp);
                frm = new OrSrvForm(list);
                frm.DbClickEvent += new OrSrvForm.DbClickHandle(frm_DbClickEvent);
                Point p = PointToScreen(new Point(srvSearch.Location.X + 356, srvSearch.Location.Y + 33));//控件的右下角位置
                frm.Local = p;
                frm.TopMost = true;
                frm.Show();
            }


        }
        /// <summary>
        /// 医嘱服务列表双击事件
        /// </summary>
        /// <param name="obj">The object.</param>
        /// Author:admin
        /// Date:2015-09-17
        void frm_DbClickEvent(OrScArgs obj)
        {
            this.FireSelected(obj.Obj);
        }

        #endregion

        #region 辅助处理函数
        private void AutoSrvCa(string srvTp)
        {
            switch (srvTp)
            {
                case "01": //药品属性

                    switch (srvTp.Substring(4))
                    {
                        case "02"://草药类
                        case "03"://注射类
                            lastSrvCa = srvTp;
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        #endregion


        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.SAVE_SUCCESS:
                    lastSrvCa = "";
                    break;
                case UIEvent.LOAD:
                     Dictionary<string, object> dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    if (dic != null)
                    {
                        if (dic.ContainsKey("PatientData") && dic["PatientData"] != null)
                        {
                            this.ent4BannerDto = (dic["PatientData"] as BannerData).Ent4BannerDTO;
                        }
                    }
                    break;
                case UIEvent.PREVIEW:

                    break;
                case UIEvent.PRINT:

                    break;
                case UIEvent.ADD:

                    break;
                case UIEvent.DELETE:

                    break;
                case UIEvent.DISABLE:

                    break;
                case UIEvent.ENABLE:

                    break;
                default:
                    break;
            }
        }
        #endregion


    }
}

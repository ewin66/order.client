using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;
using xap.rui.engine;
using xap.rui.control.forms.model;
using xap.rui.control.formcontrol.model;
using xap.rui.appfw;
using iih.en.pv.pativisit.d;
using iih.ci.ord.ciorder.cards.extend;
using iih.ci.ord.ciordems.d;
using xap.cli.sdk.controls;

using iih.ci.ord.ciorder.utils;
using iih.en.pv.dto.d;
using xap.cli.sdk.render.Items;
using xap.cli.sdk.render.labelcontrol;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.bizcontrol.BillFormTmplConst;


/********************************************************************************

** 作者： 李政

** 创始时间：2016-6-30

** 修改人：李政

** 修改时间：2016-6-30

** 描述： 医嘱服务查询

 不再使用
*********************************************************************************/
namespace iih.ci.ord.ciorder.view
{

    public partial class OrderSrvListView : CiorderBaseControl
    {

        #region 变量定义区域
        OrSrvForm frm;
        //XLabelBaseUserRender txtSrvCa, txtSrv;
        string lastSrvCa = "";//上次检索的服务类型
        XSearch srvSearch;
        XBaseControl ctr = new XAPScrollBarPanel();
        viewmodel.OrderSrvListViewModel model = new viewmodel.OrderSrvListViewModel("");
        public Ent4BannerDTO ent4BannerDto;//患者信息DTO
        #endregion

        #region 构造函数区域
        public OrderSrvListView()
        {
            InitializeComponent();
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
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
            this.model = new viewmodel.OrderSrvListViewModel("");
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            FormFile f = new FormFile();
            f.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderSrvListView;// "20150916021649286T5R";// "20150818044216049LN4";
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


            srvSearch.KeyClick += new KeyEventHandler(txtSrv_KeyDown);
            srvSearch.MouseClick += new MouseEventHandler(btnQuery_MouseClick);

            srvSearch.ValueTextChanging += new ChangingEventHandler(srvSearch_ValueTextChanging);
            //srvSearch.SelectValueChanged
        }

        void srvSearch_ValueTextChanging(object sender, ChangingEventArgs e)
        {
            SetSearchDataSouse(srvSearch.ValueText);
        }





        void txtSrv_KeyDown(object sender, KeyEventArgs e)
        {
            btnQuery_MouseClick(null, null);
        }

        void btnQuery_MouseClick(object sender, MouseEventArgs e)
        {
            if (Application.OpenForms["OrSrvForm"] == null)
            {
                frm = new OrSrvForm();
                frm.DbClickEvent += new OrSrvForm.DbClickHandle(frm_DbClickEvent);
                Point p = PointToScreen(new Point(srvSearch.Location.X + 356 - frm.Width, srvSearch.Location.Y + 30));//控件的右下角位置
                Point pc = System.Windows.Forms.Cursor.Position;
                pc = PointToScreen(srvSearch.Location);
                frm.Local = p;// AutoLocation.GetPopuLocation(pc,new Size(236,30),frm.Size);
                frm.Show();

                SetSearchDataSouse(srvSearch.ValueText);

                srvSearch.Focus();
            }
        }

        public void SetSearchDataSouse(string strWhere)
        {
            if (frm != null)
            {
                if (srvSearch.ValueText.Length > 0)
                {
                    XapDataList<EmsOrSrvSc> list = model.GetSrv(lastSrvCa == "" ? srvSearch.SelectKey.ToString() : lastSrvCa, srvSearch.ValueText, ent4BannerDto.Code_entp);
                    frm.SCTextChanged(list);
                }
                else
                {

                    frm.SCTextChanged( new XapDataList<EmsOrSrvSc>());

                }
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

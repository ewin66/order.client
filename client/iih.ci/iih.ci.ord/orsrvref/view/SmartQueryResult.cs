using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;
using xap.cli.context.token;
using xap.rui.engine;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using System.Windows.Forms;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.control;
using xap.rui.appfw;
using iih.ci.ord.ciorder.cards.extend;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.srvref.d;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.orsrvref.view
{
    public partial class SmartQueryResult : XapListControl
    {
        #region 变量定义区域

        XapDataList<CiSrvRefResultDTO> srvResultDtos { get; set; }
        XapDataList<EmsOrSrvSc> list { get; set; }
        public delegate void DbClickHandle(OrScArgs obj);
        public event DbClickHandle DbClickEvent;
        //GridView gv;
        public XapFormGridControl gv;

        #endregion

        #region 构造函数区域

        public SmartQueryResult()
        {
            this.xapFormControl = new xap.rui.control.forms.view.XapFormControl();
            InitializeComponent();
            xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
            xapFormControl.ModelFilled += new EventHandler(xapFormControl_ModelFilled);
        }


        

        public SmartQueryResult(object list)
            : this()
        {
            this.xapFormControl = new xap.rui.control.forms.view.XapFormControl();
            this.list = list as XapDataList<EmsOrSrvSc>;
        }


        #endregion

        #region 公开属性区域

        #endregion

        #region 命令定义区域

        #endregion

        #region 事件发送区域

        #endregion

        #region 事件接收区域

        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            //this.model = new viewmodel.DiagcateTreeViewModel(this.querystr);
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            FormFile f = new FormFile();
            f.FormId = CiOrdBillFormTmplConst.CIORD_IP_SmartQueryResult;// "20160507093349982BLX";// "20150916035248884P9F";// "20150818044216049LN4";
            f.FormStyle = FormStyle.List;

            f.ViewModel = this.srvResultDtos;
            xapFormControl.ViewFile = f;
            xapFormControl.SetEditPolicy(true);
        }

        #endregion

        #region 内部事件区域

        /// <summary>
        /// 加载事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void SmartQueryResult_Load(object sender, EventArgs e)
        {
            base.OnInit();

        }

        void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            gv = xapFormControl.GetGridView("srv1");
            gv.ReadOnly = true;
            //gv.DataTable.DataSource = list;
            gv.DoubleClick += new EventHandler(gv_DoubleClick);
        }

        void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            if (gv != null)
            {
                gv.DataTable.DataSource = list;
            }
            else
            {
                gv = xapFormControl.GetGridView("srv1");
                gv.DataTable.DataSource = list;
            }
            if (gv != null)
            {
                if (gv.DataTable.Rows.Count > 0)
                    gv.DataTable.Rows[0].Selected = true;
            }
        }

        public void gv_DoubleClick(object sender, EventArgs e)
        {

            EmsOrSrvSc[] sc = xapFormControl.GetSelected<EmsOrSrvSc>();
            if (sc.Length > 0)
            {
                if (DbClickEvent != null)
                {
                    OrScArgs args = new OrScArgs();
                    args.Name_item = "服务项目";
                    args.Obj = sc[0];
                    DbClickEvent(args);
                }
            }
        }

        #endregion

        #region 辅助处理函数

        /// <summary>
        /// 设置查询医嘱服务数据
        /// </summary>
        /// <param name="resultDtos">医嘱服务集合</param>
        /// Author:hums
        /// Date:2016-05-10
        public void setSrvRefData(XapDataList<CiSrvRefResultDTO> resultDtos)
        {
            this.srvResultDtos = resultDtos;
            this.OnFillData();
        }

        public void ScTextChanged(object obj)
        {
            list = obj as XapDataList<EmsOrSrvSc>;
            this.OnFillData();
            if (gv != null)
            {
                //gv.DataTable.DataSource = list;
                //if (list.Count > 0)
                //    gv.FocusedRowHandle = 0;

            }


        }
        #endregion

        #region 状态处理区域

        #endregion

    }
}

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.appfw;
using iih.ci.ord.ciordems.d;
using xap.rui.control.forms.control;
using iih.ci.ord.ciorder.utils;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciorder.cards.extend {

    /// <summary>
    /// 医嘱助手及 医嘱服务查询
    /// author:
    /// zhou_zhijian 7.3做阅读注释
    /// </summary>
    public partial class OrderScEx : CiorderBaseControl {

        #region 变量定义区域
        /// <summary>
        /// 
        /// </summary>
        XapDataList<EmsOrSrvSc> list { get; set; }
        /// <summary>
        /// 
        /// </summary>
        /// <param name="obj"></param>
        public delegate void DbClickHandle(OrScArgs obj);
        /// <summary>
        /// 
        /// </summary>
        public event DbClickHandle DbClickEvent;
        /// <summary>
        /// 
        /// </summary>
        public XapFormGridControl gv;
        /// <summary>
        /// 
        /// </summary>
        private bool isShowBorder;
        /// <summary>
        /// 
        /// </summary>
        private Pen borderPen;
        /// <summary>
        /// 数据填充完之后要控制外边容器的大小，需要一个触发事件
        /// </summary>
        public event EventHandler ModelFilled;

        /// <summary>
        /// 
        /// </summary>
        public bool IsShowBorder {
            get {
                return this.isShowBorder;
            }
            set {
                if (this.isShowBorder != value) {
                    this.isShowBorder = value;
                    this.xapFormControl1.Invalidate();
                }
            }
        }
        #endregion

        #region 构造函数区域
        public OrderScEx() {
            this.Padding = new Padding(1);
            this.BackColor = Color.White;
            this.borderPen = new Pen(Color.FromArgb(0, 153, 229));
            this.xapFormControl1 = new xap.rui.control.forms.view.XapFormControl();
            InitializeComponent();
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
            this.PreviewKeyDown += new PreviewKeyDownEventHandler(OrderScEx_PreviewKeyDown);
        }

        void OrderScEx_PreviewKeyDown(object sender, PreviewKeyDownEventArgs e)
        {
            switch (e.KeyCode)
            {
                case Keys.Left:
                case Keys.Right:
                    e.IsInputKey = true;
                    break;
            }
        }

        public OrderScEx(object list)
            : this() {
            this.xapFormControl1 = new xap.rui.control.forms.view.XapFormControl();
            this.list = list as XapDataList<EmsOrSrvSc>;
        }
        #endregion

        #region 事件处理函数
        /// <summary>
        /// 加载事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void OrderScEx_Load(object sender, EventArgs e) {
            base.OnInit();
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void xapFormControl1_FormCreated(object sender, EventArgs e) {
            gv = xapFormControl1.GetGridView("srv");
            gv.ReadOnly = true;
            gv.WithBorder = false;
            gv.DataTable.MouseDoubleClick += new MouseEventHandler(gv_DoubleClick);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void xapFormControl1_ModelFilled(object sender, EventArgs e) {
            if (gv != null) {
                gv.DataTable.DataSource = list;
            }
            else {
                gv = xapFormControl1.GetGridView("srv");
                gv.DataTable.DataSource = list;
            }
            if (gv != null) {
                if (ModelFilled != null) {
                    ModelFilled(gv.DataTable, e);
                }
                if (gv.DataTable.Rows.Count > 0)
                {
                    gv.DataTable.Rows[0].Selected = true;
                    gv.DataTable.Rows[0].Focused = true;
                }
            }
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public void gv_DoubleClick(object sender, EventArgs e) {
            EmsOrSrvSc[] sc = xapFormControl1.GetSelected<EmsOrSrvSc>();
            if (sc.Length > 0) {
                if (DbClickEvent != null) {
                    OrScArgs args = new OrScArgs();
                    args.Name_item = "服务项目";
                    args.Obj = sc[0];
                    DbClickEvent(args);
                }
            }
        } 

        #endregion

        #region 公开属性区域

        #endregion

        #region 父类覆写区域
        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData() {
            //this.model = new viewmodel.DiagcateTreeViewModel(this.querystr);
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData() {
            FormFile f = new FormFile();
            f.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderScEx;// "20150916035248884P9F";// "20150818044216049LN4";
            f.FormStyle = FormStyle.Card;

            f.ViewModel = list;
            xapFormControl1.ViewFile = f;
            xapFormControl1.SetEditPolicy(true);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="keyData"></param>
        /// <returns></returns>
        protected override bool ProcessDialogKey(Keys keyData) {
            switch (keyData) {
                case Keys.Enter: //回车选中
                    gv_DoubleClick(null, null);
                    break;
                case Keys.Up:
                    gv.DataTable.SelectPreRow();
                    break;
                case Keys.Down:
                    gv.DataTable.SelectNextRow();
                    break;
                //case Keys.Left:
                //case Keys.Right:
                    
                default:
                    break;
            }
            return base.ProcessDialogKey(keyData);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="e"></param>
        protected override void OnPaint(PaintEventArgs e) {
            Graphics g = e.Graphics;
            if (this.isShowBorder) {
                g.DrawRectangle(new Pen(Color.FromArgb(0, 153, 229)), new Rectangle(0, 0, this.Width - 1, this.Height - 1));
            }
            base.OnPaint(e);
        }

        #endregion

        #region 辅助处理函数
        /// <summary>
        /// 
        /// </summary>
        /// <param name="obj"></param>
        public void ScTextChanged(object obj) {
            list = obj as XapDataList<EmsOrSrvSc>;
            this.OnFillData();
            if (gv != null) {
                //gv.DataTable.DataSource = list;
                //if (list.Count > 0)
                //    gv.FocusedRowHandle = 0;
            }
        }
        #endregion
    
    }
}

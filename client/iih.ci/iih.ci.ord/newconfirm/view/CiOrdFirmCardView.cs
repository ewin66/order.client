using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;
using iih.bd.bc.udi;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder;
using iih.ci.ord.nsorderconfirm.viewmodel;
using xap.cli.context;
using xap.cli.sdk.common;
using xap.cli.sdk.render;
using xap.cli.sdk.render.Items;
using xap.mw.coreitf.d;
using xap.rui.control.basecontrol;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.control.refcontrol.events;
using xap.sys.xbd.udi.d;
using xap.rui.bizcontrol.BillFormTmplConst;

/*
********************************************************************************

** 作者： 李程

** 创始时间：2016-6-30

** 修改人：李程

** 修改时间：2016-6-30

** 描述： 医嘱确认查询页面

*********************************************************************************
*/

namespace iih.ci.ord.nsorderconfirm.view
{
    public partial class CiOrdFirmCardView : CiorderBaseControl
    {
        #region 变量定义区

        private readonly XapBaseControl bc = new XapBaseControl();
        private readonly XapFormControl xapFormControl;
        private UserRender dept;
        private OrderConfirmCardViewModel model;
        private XComBoxMulty selectMulty;

        #endregion

        #region 构造函数区

        public CiOrdFirmCardView()
        {
            InitializeComponent();
            xapFormControl = new XapFormControl();
            xapFormControl.Dock = DockStyle.Fill;
            Controls.Add(xapFormControl);
            xapFormControl.Load += xapFormControl_Load;
            xapFormControl.RefFilter += OnRefFilter;
            xapFormControl.FormCreated += xapFormControl_FormCreated;
            xapFormControl.IsShowWarnForm = false;
            
        }

        #endregion

        #region 父类继承区域

        /// <summary>
        ///     科室切换时，重新加载数据
        /// </summary>
        public override void OnDeptChanged()
        {
            model = new OrderConfirmCardViewModel();


            model.orConfirm.Fg_sign = FBoolean.True;
            model.orConfirm.Id_dep_nur = Context.Dept.Id_dep;
            FireSelected(model.orConfirm);
            model.orConfirm.Sd_su_or = CiDictCodeConst.SD_SU_SIGN;
            //          this.model.orConfirm.Id_dep_nur = UserManager.getInstance().CurrentDept.Id_dep;
            OnFillData();

            if (!model.checkDep(model.orConfirm.Id_dep_nur))
            {
                dept.Enabled = false;
            }
            else
            {
                dept.Enabled = true;
            }
        }

        /// <summary>
        ///     获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            model = new OrderConfirmCardViewModel();
        }

        /// <summary>
        ///     CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            var f = new FormFile();
            f.FormId = CiOrdBillFormTmplConst.CIORD_IP_CiOrdFirmCardView;// "20160307104716544UID";
            f.FormStyle = FormStyle.Card;
            f.ViewModel = model.orConfirm;
            xapFormControl.ViewFile = f;
            xapFormControl.SetEditPolicy(true);
        }


        #endregion

        #region 内部事件区域

        private void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            UserRender clearButton = xapFormControl.GetUserRender("cfmcard", "clear");
            clearButton.MouseClick += clearButton_MouseClick;

            UserRender qeuryButton = xapFormControl.GetUserRender("cfmcard", "ok");
            qeuryButton.MouseClick += qeuryButton_MouseClick;

            //初始化数据，加载医嘱列表
            model.orConfirm.Fg_sign = FBoolean.True;
            model.orConfirm.Id_dep_nur = Context.Dept.Id_dep;
            dept = xapFormControl.GetUserRender("cfmcard", "name_dep_phy");
            if (!model.checkDep(model.orConfirm.Id_dep_nur))
            {
                dept.Enabled = false;
            }

            FireSelected(model.orConfirm);
        }

        private void qeuryButton_MouseClick(object sender, MouseEventArgs e)
        {
            model.orConfirm.Id_orderchkca = null;
            model.GetSrvCa("CI.OR.0765");
            string rr = "";
            string texts = selectMulty.Text;
            string[] names = null;
            if (texts != null)
                names = texts.Split('，');
            if (names != null)
                foreach (string name in names)
                {
                    if (name == "")
                        continue;
                    foreach (UdidocDO udi in model.Udis)
                    {
                        if (udi.Name == name)
                        {
                            rr += "(" + udi.Ctrl1 + ") or ";
                        }
                    }
                }
            if (rr != null && rr != "")
                model.orConfirm.Id_orderchkca = rr.Substring(0, rr.Length - 3);
            FireSelected(model.orConfirm);
        }

        private void clearButton_MouseClick(object sender, MouseEventArgs e)
        {
            //throw new System.NotImplementedException();
            model.orConfirm = new OrConfirm();
            model.orConfirm.Id_orderchkca = null;
            selectMulty.ValueText = "";
            selectMulty.Text = "";
            selectMulty.ValueCode = "";
            model.orConfirm.Name_bed = "";
            model.orConfirm.Id_dep_nur = UserManager.getInstance().CurrentDept.Id_dep;

            model.orConfirm.Sd_su_or = CiDictCodeConst.SD_SU_SIGN;
            model.orConfirm.Id_dep_nur = UserManager.getInstance().CurrentDept.Id_dep;
            model.orConfirm.Fg_sign = FBoolean.True;
            model.orConfirm.Fg_stop = FBoolean.False;
            model.orConfirm.Fg_canc = FBoolean.False;
            dept.Enabled = false;
            OnFillData();
            if (!model.checkDep(model.orConfirm.Id_dep_nur))
            {
                dept.Enabled = false;
            }
            else
            {
                dept.Enabled = true;
            }
            //this.model.GetSrvCa("CI.OR.0765");
            FireSelected(model.orConfirm);


            //    
        }

        protected override void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            base.OnRefFilter(sender, e);
            if (e.BindingFieldName.Equals("Name_bed"))
            {
                e.RefParams.AddParam("iddepnur", model.orConfirm.Id_dep_nur);
            }
            else if (e.BindingFieldName.Equals("Name_dep_nur"))
            {
                e.RefParams.AddParam("sddepttp", model.orConfirm.Id_dep_nur);
            }
        }


        public override bool CanClose()
        {
            return true;
        }

        private void xapFormControl_Load(object sender, EventArgs e)
        {
            model = new OrderConfirmCardViewModel();
            model.GetSrvCa("CI.OR.0765");
            selectMulty = new XComBoxMulty(bc); //传个父窗体
            if (RelativeUIParam.ScreenSize == ScreenSize.Large)
            {
                selectMulty.Size = new Size(200, 28);
            }
            else
            {
                selectMulty.Size = new Size(200, 24);
            }
            
            //           selectMulty.SearchCondition += new XComBoxMulty.GetSearchCondition(selectMulty_SearchCondition);
            var data = new Dictionary<object, string>();
            if (model.Udis!=null)
            foreach (UdidocDO udi in model.Udis)
            {
                data.Add(udi.Id_udidoc, udi.Name);
            }

            selectMulty.DataSource = data;
            var controls = new Dictionary<string, Control>();

            bc.AddRender(selectMulty);
            controls.Add("xiala", bc);
            bc.SizeChanged += bc_SizeChanged;
            xapFormControl.RegisterControl(controls);

            OnFillData();
        }

        private void bc_SizeChanged(object sender, EventArgs e)
        {
          
            if (RelativeUIParam.ScreenSize == ScreenSize.Large)
            {
                bc.Size = new Size(205, 30);
            }
            else
            {
                bc.Size = new Size(205, 26);
            }
        }

        #endregion
    }
}
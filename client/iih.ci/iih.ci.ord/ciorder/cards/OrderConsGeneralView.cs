using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.cli.context;
using xap.rui.control.forms.model;
using xap.rui.control.forms.control;
using xap.rui.bizcontrol.IndicatorControl;
using xap.cli.sdk.render;
using xap.rui.control.refcontrol.events;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciorder.cards
{
    public partial class OrderConsGeneralView : CiorderBaseControl
    {
        public OrderConsGeneralView()
        {
            InitializeComponent();

            xapFormControl.Load += new EventHandler(xapFormControl_Load);
            xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
            xapFormControl.ModelFilled += new EventHandler(xapFormControl_ModelFilled);
            xapFormControl.RefFilter += OnRefFilter;

            xapFormControl.SetEditPolicy(true);
            SheetName = "会诊医疗单";
        }

        #region 父类继承区域
        public override void OnRefreshData(EmsUIDTO headDo, object e)
        {
            if (headDo != null)
            {
                EmsHeadDO = headDo;
            }

            if (this.Created)
            {
                this.LoadData();
            }
        }

        protected override void OnLoadData()
        {
            
        }

        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            if (EmsHeadDO != null)
            {
                file.ViewModel = EmsHeadDO.Emsapcons;
            }
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderConsGeneralView;// "20160507015354871EQU";
            file.FormStyle = FormStyle.Card;
            xapFormControl.ViewFile = file;
        }

        protected override void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            //UserRender userRender_emp = xapFormControl.GetUserRender("cons", "name_dep_emp");

            //string str = EmsHeadDO.Emsapcons.Id_dep_emp;
            if (e.BindingFieldName.Equals("Name_emp_doctor"))
            {
                if (EmsHeadDO.Emsapcons.Id_dep_emp != null)
                {
                    e.WherePart = " id_dep='" + EmsHeadDO.Emsapcons.Id_dep_emp + "'";
                }
            }
        }
        #endregion

        #region 内部事件区域
        void xapFormControl_Load(object sender, EventArgs e)
        {
            OnInit();
        }

        void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            SetGridPolicy(true);
        }

        void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            UserRender name_place = xapFormControl.GetUserRender("cons", "name_place");
            name_place.Focus();
        }

        #endregion

        public override void SaveBefore()
        {
            saveEmsapcons();
            this.xapFormControl.SaveForm();
        }

        private void saveEmsapcons()
        {
            EmsItemInCons itemDO = new EmsItemInCons();
            itemDO.Id_org = UserManager.getInstance().CurrentOrg.Id_org;
            itemDO.Name_org = UserManager.getInstance().CurrentOrg.Name;
            itemDO.Id_dep_emp = EmsHeadDO.Emsapcons.Id_dep_emp;
            itemDO.Name_dep_emp = EmsHeadDO.Emsapcons.Name_dep_emp;
            itemDO.Id_emp_doctor = EmsHeadDO.Emsapcons.Id_emp_doctor;
            itemDO.Name_emp_doctor = EmsHeadDO.Emsapcons.Name_emp_doctor;

            EmsHeadDO.Emsapcons.EmsConsAssistItem.Add(itemDO);
        }

        private void SetGridPolicy(bool flag)
        {
            DataPolicy policy = new DataPolicy
            {
                ClassName = "iih.ci.ord.ciordems.d.EmsItemInCons",
                FullEdit = flag
                //AllowEdit = flag
            };

            xapFormControl.SetEditPolicy(flag, new[] { policy });

        }

    }
}

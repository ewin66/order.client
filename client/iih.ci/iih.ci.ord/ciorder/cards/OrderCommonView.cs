using System;
using System.Collections.Generic;
using System.Linq;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.render;
using iih.en.pv.dto.d;
using iih.en.pv.pativisit.d;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.engine;
using iih.ci.ord.ciorder.Validate;
using xap.cli.sdk.render.labelcontrol;
using iih.ci.ord.emsdi.d;
using xap.cli.sdk.render;
using xap.rui.control.forms.model;
using xap.rui.control.refcontrol.events;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciorder.cards
{
    /********************************************************************************

** 作者： 刘晓颖

** 创始时间：2016-6-30

** 修改人：刘晓颖

** 修改时间：2016-6-30

** 描述： 简洁申请单页面


*********************************************************************************/
    public partial class OrderCommonView : CiorderBaseControl
    {
        #region 变量定义区域


        string idWfdeps = "";
        public Ent4BannerDTO patDo = new Ent4BannerDTO();
        #endregion

        #region 构造函数区域

        public OrderCommonView()
        {
            InitializeComponent();

            xapFormControl.Load += XapFormControl_Load;
            xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
            xapFormControl.ModelFilled += new EventHandler(xapFormControl_ModelFilled);
            xapFormControl.RefFilter += XapFormControl_RefFilter;
            xapFormControl.RefResult += new EventHandler<RefResultEventArgs>(xapFormControl_RefResult);
            xapFormControl.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl_DataChanged);
            this.SheetName = "简洁医疗单";

            xapFormControl.SetEditPolicy(true);
        }

        void xapFormControl_DataChanged(object sender, DataChangedEventArgs e)
        {
            switch(e.PropName){
                case "Dt_begin_ui":
                    if (EmsHeadDO.Emsdrugs.Fg_long != true)
                    {
                        EmsHeadDO.Emsdrugs.Dt_end_ui = EmsHeadDO.Emsdrugs.Dt_begin_ui;
                    }
                    EmsHeadDO.Dt_begin_ui = EmsHeadDO.Emsdrugs.Dt_begin_ui;//同步开始时间
                   
                    break;

            }
        }

        #endregion

        #region 公开属性区域

        #endregion

        #region 父类继承区域

        protected override void OnLoadData()
        {
            //if (EmsHeadDO == null)
            //    return;

            //if (MedSrvDO != null)
            //{
            //    //新增状态

            //    EmsHeadDO.Emsdrugs.Str_mp_dep_ids = new viewmodel.impext.GetDeptMpImp().GetDept_mp_ids(EmsHeadDO.Code_entp, EmsHeadDO.Id_entp,
            //    EmsHeadDO.MedSrvDO.Sd_srvtp, EmsHeadDO.MedSrvDO.Id_srvca, EmsHeadDO.MedSrvDO.Id_srv, EmsHeadDO.MedSrvDO.Id_route, "id_mm", orDataBing.patDo.Id_dep_nur, ref firstdep);

            //    orDataBing.AddCommonHeadDataBing(EmsHeadDO, MedSrvDO);
            //    orDataBing.AddDrugDataBing(EmsHeadDO, MedSrvDO);
            //    EmsHeadDO.Emsdrugs.Id_dep = firstdep[0];
            //    EmsHeadDO.Emsdrugs.Name_dep = firstdep[1];
            //}
            //if (CiEmsDTO != null)
            //{
            //    //编辑状态
            //    OrCIEmsTOUIEms or = new OrCIEmsTOUIEms();

            //}


        }

        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            if (EmsHeadDO != null)
            {
                file.ViewModel = EmsHeadDO.Emsdrugs;
            }
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderCommonView;// "20151109115430823NR6";
            file.FormStyle = FormStyle.Card;
            xapFormControl.ViewFile = file;
        }

        public override void OnRefreshData(EmsUIDTO ems, object e)
        {
            EmsHeadDO = ems;
            //获取执行科室筛选字符串
             OrWfDeptInfoDTO wf = new viewmodel.impext.GetDeptMpImp().GetDept_mp_ids(EmsHeadDO.PatInfo.Code_entp, EmsHeadDO.PatInfo.Id_entp,
                                  EmsHeadDO.MedSrvDO.Sd_srvtp, EmsHeadDO.MedSrvDO.Id_srvca, EmsHeadDO.MedSrvDO.Id_srv, EmsHeadDO.MedSrvDO.Id_route, "id_mm", EmsHeadDO.PatInfo.Id_dep_nur,EmsHeadDO.PatInfo.Id_dep_phy);
            EmsHeadDO.Emsdrugs.Str_mp_dep_ids = wf==null?"":wf.Id_mp_depts;
            idWfdeps = wf.Id_mp_depts;
            if (EmsHeadDO.IsNEW)
            {
                EmsHeadDO.Emsdrugs.Id_dep = wf == null ? "" : wf.Firstid_mp_dept;
                EmsHeadDO.Emsdrugs.Name_dep = wf == null ? "" : wf.Firstname_mp_dept;
            }
            if (Created)
            {
                this.LoadData();
            }
        }

        public override void SaveBefore()
        {
            xapFormControl.SaveForm();
            VerifyOk = !xapFormControl.HasErrors;
        }

        public override IValidate GetOrdValidate()
        {
            return new OrderCommonValidate();
        }
        #endregion

        #region 内部事件区域

        private void XapFormControl_Load(object sender, EventArgs e)
        {
            OnInit();
        }

        private void XapFormControl_RefFilter(object sender, xap.rui.control.refcontrol.events.RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_dep") && !string.IsNullOrWhiteSpace(idWfdeps))
            {
                e.WherePart = string.Format("id_dep in ({0})", idWfdeps);
            }
        }

        void xapFormControl_RefResult(object sender, xap.rui.control.refcontrol.events.RefResultEventArgs e)
        {
            if (e.RefResultSet.IsEmpty) return;
            if (e.BindingFieldName.Equals("Name_freq")) {
                this.setEndTimeRenderEnabled();
            }
        }
        void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            XLabelBaseUserRender xlabel = xapFormControl.GetUserRender("common", "fg_long") as XLabelBaseUserRender;
            xlabel.Enabled = false;
        }

        void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            UserRender quan_med = xapFormControl.GetUserRender("common", "quan_med");
            quan_med.Focus();
            SetGridPolicy(!IsReadOnly);
            setEndTimeRenderEnabled();
        }
        #endregion

        #region 辅助处理函数

        private void SetGridPolicy(bool flag)
        {
            DataPolicy policy = new DataPolicy();
            policy.ClassName = "iih.ci.ord.ciordems.d.EmsDrugItemDO";
            //policy.AllowNew = flag;
            policy.AllowEdit = flag;
            //policy.AllowRemove = flag;
            //policy.AllowSave = false;
            policy.FullEdit = flag;
            //policy.HideOther = true;
            //policy.MultiSelect = true;

            xapFormControl.SetEditPolicy(flag, new DataPolicy[1] { policy });

            //gv_change.ReadOnly = false;
            //gv.ReadOnly = true;
            //gv.DataTable.ReadOnly = true;
        }
        private void setEndTimeRenderEnabled() {

            // 如果当前医疗单是只读状态，不根据常临标识设置停止时间
            if (this.IsReadOnly)
            {
                return;
            }
            if (EmsHeadDO.Emsdrugs.Fg_long != true)
            {
                EmsHeadDO.Emsdrugs.Dt_end_ui = EmsHeadDO.Emsdrugs.Dt_begin_ui;
            }
            else
            {
                EmsHeadDO.Emsdrugs.Dt_end_ui = null;
            }
            this.xapFormControl.GetUserRender("common", "dt_end_ui").Enabled = EmsHeadDO.Emsdrugs.Fg_long == null ? true : (bool)EmsHeadDO.Emsdrugs.Fg_long;
            TimerComboBoxMaxAndMin.GetInstance().setMinTime(xapFormControl, this.Context, "common", "dt_end_ui", EmsHeadDO.Dt_begin_ui);
           
           
        }
        #endregion
    }
}

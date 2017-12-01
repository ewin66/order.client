using System;
using System.Windows.Forms;
using iih.ci.ord.opemergency.validate;
using xap.cli.sdk.render;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.view;
using xap.rui.control.basecontrol;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.view.basic;
using xap.rui.control.forms.control;
using xap.cli.sdk.controls.DataView;
using iih.ci.ord.dto.d;
using iih.ci.ord.ciordems.d;


/*
********************************************************************************

** 作者： 李程

** 创始时间：2016-6-30

** 修改人：李程

** 修改时间：2016-6-30

** 描述： 医嘱确认显示页面


*********************************************************************************
*/

namespace iih.ci.ord.opemergency.ems
{
    /// <summary>
    /// 用血医疗单
    /// </summary>
    public partial class EmsApbuViewCard : BaseEmsFormView
    {
        #region 构造函数
        public EmsApbuViewCard(IEventDelegate o )
            : base(o)
        {
           
            this.srvItemViewType = EmsViewType.EmsApbuViewType;
            this.iValidate = new EmsApbuValidate();
            this.GetXapFormControl().DataDisplay += new EventHandler<xap.cli.sdk.controls.DataView.Model.XDataDisplayEventArgs>(EmsApbuViewCard_DataDisplay);
        }

        #endregion

        #region 父类继承区
        protected override void InitializeBizView()
        {
            base.InitializeBizView();

            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsApbuViewCard/*"201606170739370417D1"*/);

            this.SetGridPageCode("ubapp");

            this.RegisteFormEventImpl();
        }
        protected override void OnXapFormControl_RefFilter(object sender, xap.rui.control.refcontrol.events.RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_route"))
            {
                e.WherePart = this.GetViewModel().OnRefFilterData(e.BindingFieldName);
            }
            else if (e.BindingFieldName.Equals("Name_mp_dep"))
            {
                e.WherePart = this.GetViewModel().OnRefFilterData(e.BindingFieldName);
            }
        }

        //         void UseBloodSrvItemView_FormCreated(object sender, EventArgs e)
        //         {
        //             gridControl = GetXapFormControl().GetGridView("ubapp");
        //             // 注册表格控件的LayoutChanged事件
        //             gridControl.DataTable.LayoutChanged += OnXapFormControl_LayoutChanged;
        // 
        //             this.GetXapFormControl().RefFilter += UseBloodSrvItemView_RefFilter;
        //             this.GetXapFormControl().ModelFilled += UseBloodSrvItemView_ModelFilled;
        //   
        //         }


        protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            this.ResetColumnsInfo(this.GetGridControl());
            this.GetGridControl().DataTable.DataSource = GetViewModel().GetTableDataSource();
            this.SetFocus();
        }

        void EmsApbuViewCard_DataDisplay(object sender, xap.cli.sdk.controls.DataView.Model.XDataDisplayEventArgs e)
        {
            updateCustomerControlInfo(GetGridControl().DataTable.GetFirstRow(), (GetViewModel().GetEmsUIDTO() as EmsUIDTO).CiordubDTO);
        }

        public override void SetFocus()
        {
            if (GetGridControl() != null && GetGridControl().DataTable.Rows.Count > 0)
            {
                GetGridControl().Focus();
                GetGridControl().DataTable.Rows[0].CellList[0].Focus();
                GetGridControl().DataTable.Rows[0].Selected = true;
            }
        }

        /// <summary>
        /// 更新用户自定义列单元格信息
        /// </summary>
        /// <param name="row"></param>
        /// <param name="drug"></param>
        void updateCustomerControlInfo(XDataRow row, CiordubDTO Emsapbu)
        {
            if (Emsapbu == null)
            {
                return;
            }
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_quan_bu"))
            {
                if (Emsapbu.Quan_medu == null)
                    Emsapbu.Quan_medu = 0;
                if (Emsapbu.Name_unit == null)
                    Emsapbu.Name_unit = "";
                string strMed_unit = Emsapbu.Quan_medu.ToString() + Emsapbu.Name_unit;
                row.ColumnCellDict["customercolumn_quan_bu"].SetValue(strMed_unit);
            }
        }
        #endregion
    }
}

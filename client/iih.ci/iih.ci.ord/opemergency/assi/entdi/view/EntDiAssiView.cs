
using System;
using System.Windows.Forms;
using System.Collections.Generic;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.view;
using xap.cli.sdk.controls.tabPanel;
using iih.ci.ord.opemergency.assi.entdi.viewmodel;
using xap.rui.control.formcontrol.model;
using xap.cli.sdk.controls.tabControl;
using xap.cli.sdk.render.labelcontrol;
using xap.rui.control.forms.control;
using iih.bd.srv.diagdef.d;
using xap.cli.sdk.controls.DataView;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.opemergency.assi.entdi.view
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.entdi    </para>    
    /// <para>类 名 称 :  EntDiAssiView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/4/10 20:33:14             </para>
    /// <para>更新时间 :  2017/4/10 20:33:14             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class EntDiAssiView : XapBaseControl
    {
        public delegate void DelegateMouseClick(object[] dos);
        public event DelegateMouseClick delegateMouseClick;

        protected XapFormControl xapFormControl;

        protected XapFormGridControl diGrid;
        protected XLabelBaseUserRender urDeptDica;
        protected XLabelBaseUserRender urDiQuery;

        public EntDiAssiViewModel viewModel;

        public EntDiAssiView()
        {
            this.Load += new EventHandler(EntDiAssiView_Load);
        }

        private void EntDiAssiView_Load(object sender, EventArgs e)
        {
            this.xapFormControl = new XapFormControl();
            this.xapFormControl.Dock = DockStyle.Fill;
            this.xapFormControl.Padding = new Padding(4, 4, 4, 4);
            this.xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);

            this.Controls.Add(this.xapFormControl);

            this.OnInit();
        }

        protected virtual void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            urDeptDica = this.xapFormControl.GetUserRender("diquery", "urDeptDica") as XLabelBaseUserRender;
            urDiQuery = this.xapFormControl.GetUserRender("diquery", "urDiQuery") as XLabelBaseUserRender;
            urDiQuery.ValueTextChanged += new EventHandler(urDiQuery_ValueTextChanged);
            urDiQuery.Enabled = true;

            diGrid = this.xapFormControl.GetGridView("dilist");
            diGrid.DataTable.Columns.Visible = false;
            diGrid.WithBorder = true;
            diGrid.DataTable.MouseDoubleClick += new MouseEventHandler(diGrid_MouseDoubleClick);
        }

        private void urDiQuery_ValueTextChanged(object sender, EventArgs e)
        {
            this.viewModel.TxtQuery = (sender as XLabelBaseUserRender).ValueText.Trim().ToUpper();

            this.LoadData();
        }

        private void diGrid_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            var diagDefDO = (sender as XDataRow).DataSource as DiagDefDO;

            delegateMouseClick(new DiagDefDO[] { diagDefDO });
        }

        protected override void OnLoadData()
        {
            viewModel.LoadData();
        }

        protected override void OnFillData()
        {
            FormFile f = new FormFile();
            f.FormId = CiOrdBillFormTmplConst.CIORD_OP_EntDiAssiView;// "20170410084546887000";
            f.FormStyle = FormStyle.List;
            f.ViewModel = viewModel.diagDefDOs;
            this.xapFormControl.ViewFile = f;
        }

        public DiagDefDO[] GetDiagDefDOsSelected()
        {
            List<DiagDefDO> lst = new List<DiagDefDO>();
            if (diGrid == null)
                return null;
            foreach (var dataRow in diGrid.DataTable.SelectedRows)
            {
                lst.Add(dataRow.RowDataSource as DiagDefDO);
            }
            return lst.ToArray();
        }

        public void CancelSelectedRows()
        {
            if (diGrid != null && diGrid.DataTable != null)
            {
                for (int i = diGrid.DataTable.SelectedRows.Count - 1; i >= 0; i--)
                {
                    diGrid.DataTable.SelectedRows[i].Selected = false;
                }
                diGrid.Refresh();
            }
        }
    }
}

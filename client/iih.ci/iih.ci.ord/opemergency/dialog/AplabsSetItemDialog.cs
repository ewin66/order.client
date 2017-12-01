using System;
using System.Linq;
using System.Windows.Forms;
using xap.cli.sdk.controls.DataView.Model;
using xap.rui.control.basecontrol;
using xap.rui.control.formcontrol.model;
using xap.rui.appfw;
using iih.ci.ord.ciordems.d;
using xap.rui.control.forms.view;
using xap.rui.control.forms.control;
using iih.ci.ord.opemergency.view;
using xap.cli.sdk.controls.DataView;
using xap.rui.control.extentions;
using iih.ci.ord.opemergency.declare;
using xap.mw.coreitf.d;
using System.Drawing;
using iih.ci.ord.opemergency.view.basic;

namespace iih.ci.ord.opemergency.dialog
{
    public partial class AplabsSetItemDialog : XBaseDialog
    {
        private XapDataList<EmsObsLap> itemlist ;
        private BaseFormBizView ownerView;
        private XapFormGridControl gv;
        private bool bAllowEdit = true;
        private bool setRadio = true;
        public AplabsSetItemDialog(BaseFormBizView o,XapDataList<EmsObsLap> emsObsLaps,bool allow,bool setRadioCheck)
        {
            this.ownerView = o;
            bAllowEdit = allow;
            setRadio = setRadioCheck;
            InitializeComponent();

            this.itemlist = emsObsLaps;

            this.saveButton.MouseClick += new MouseEventHandler(saveButton_MouseClick);
            this.cancelButton.MouseClick += new MouseEventHandler(cancelButton_MouseClick);

            saveButton.Enabled = bAllowEdit;

            this.xapFormControl.Load += new EventHandler(xapFormControl_Load);
            this.xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
         
        }

        void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            gv = this.xapFormControl.GetGridView("table");
            gv.DataTable.MultiSelectEnable = (bAllowEdit);
            //this.xapFormControl.DataDisplay += OnXapFormControl_DataDisplay;
            gv.DataTable.SelectedRowChanged += OnGridViewControl_SelectRowChanged;
            this.xapFormControl.ModelFilled += OnXapFormControl_ModelFilled;
            gv.AllowSelectAll(!this.setRadio);
            gv.KeyPress += new KeyPressEventHandler(gv_KeyPress);
            this.xapFormControl.EnterKeyDown += new EventHandler<KeyEventArgs>(xapFormControl_EnterKeyDown);
        }

        void xapFormControl_EnterKeyDown(object sender, KeyEventArgs e)
        {
            saveButton_MouseClick(null, null);
            e.Handled = true;
        }

        void gv_KeyPress(object sender, KeyPressEventArgs e)
        {

            if (e.KeyChar.Equals((char)Keys.Space))
            {
                gv.DataTable.SelectedRowChanged -= OnGridViewControl_SelectRowChanged;
                gv.FocusedRow.Selected = !gv.FocusedRow.Selected;
                if (gv.FocusedRow.Selected && setRadio)
                {
                    for (int i = gv.DataTable.SelectedRows.Count - 1; i >= 0; i--)
                    {
                        if (gv.DataTable.SelectedRows[i] != gv.FocusedRow)
                        {
                            gv.DataTable.SelectedRows[i].Selected = false;
                        }
                    }
                    gv.Refresh();
                }
                gv.DataTable.SelectedRowChanged += OnGridViewControl_SelectRowChanged;

            }
        }

        void OnGridViewControl_SelectRowChanged(object sender, XSelectedRowChangedEventArgs e)
        {
            XDataRow selectrow = sender as XDataRow;
            if (selectrow == null) return;
            if (setRadio == false) return;
                gv.DataTable.SelectedRowChanged -= OnGridViewControl_SelectRowChanged;

            selectrow.Selected = true;
                for (int i = gv.DataTable.SelectedRows.Count - 1; i >= 0; i--)
                {
                    if (gv.DataTable.SelectedRows[i] != selectrow) gv.DataTable.SelectedRows[i].Selected = false;
                }

            gv.DataTable.SelectedRowChanged += OnGridViewControl_SelectRowChanged;

        }

        void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            gv.Focus();
            gv.DataTable.Rows[0].Focused = true;
            gv.DataTable.SelectedRowChanged -= OnGridViewControl_SelectRowChanged;

            for (int i = 0; i < gv.DataTable.Rows.Count; i++)
            {
                    EmsObsLap data = gv.DataTable.Rows[i].RowDataSource as EmsObsLap;
                    if (null == data)
                    {
                        return;
                    }

                    gv.DataTable.Rows[i].Selected = (data.Fg_chk == FBoolean.True);
                    gv.DataTable.Rows[i].Enabled = (data.Fg_edit == FBoolean.True);
            }
            gv.DataTable.SelectedRowChanged += OnGridViewControl_SelectRowChanged;

        }


      
        void cancelButton_MouseClick(object sender, MouseEventArgs e)
        {
            DialogResult = DialogResult.Cancel;
            this.Close();
        }

        void saveButton_MouseClick(object sender, MouseEventArgs e)
        {
            bool hasSelected = false;
            for (int i = 0; i < gv.DataTable.Rows.Count; i++) {
                XDataRow row = gv.DataTable.Rows[i];
                if (row.GetMultiSelectStatus()) {
                    hasSelected = true;
                    break;
                }
            }
            if (!hasSelected) {
                this.ShowInfo("请至少选择一个服务项目！");
                return;
            }
            bool bChanged = false;
            for (int i = 0; i < gv.DataTable.Rows.Count; i++)
            {
                XDataRow row = gv.DataTable.Rows[i];

                EmsObsLap ds = row.RowDataSource as EmsObsLap;

                if (row.GetMultiSelectStatus())
                {
                    if (ds.Fg_chk != true)
                    {
                        bChanged = true;
                        ds.Fg_chk = true;
                    }
                   
                }
                else
                {
                    if (ds.Fg_chk != false)
                    {
                        bChanged = true;
                        ds.Fg_chk = false;
                    }
                    
                }
            }

            if (this.itemlist.ToList().Count(p => p.Fg_chk != null && p.Fg_chk.Value) == 0)
            {
                this.ShowInfo("请至少选择一个服务项目！");
                return;
            }

            DialogResult = DialogResult.OK;
            
            if (bChanged && this.ownerView != null)
            {

                this.ownerView.SentNotify(EventCodeType.NM_EMS_ORSRV_DATACHANGED);

            }
        }

      
        void xapFormControl_Load(object sender, EventArgs e)
        {
            FormFile file = new FormFile
            {
                FormId = "2016060601291382475C",
                FormStyle = FormStyle.List,
                ViewModel = itemlist
            };
            xapFormControl.ViewFile = file;
        }

        // 2016060601291382475C

    }
}

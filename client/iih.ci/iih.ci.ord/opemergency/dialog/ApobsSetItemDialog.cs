using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using xap.cli.sdk.render;
using xap.rui.appfw;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.control;
using xap.rui.control.forms.model;
using xap.rui.control.forms.view;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.controls.DataView.Model;
using xap.cli.sdk.controls.DataView.Renders;
using iih.ci.ord.opemergency.view;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.opemergency.view.basic;
using xap.mw.coreitf.d;
using xap.mw.core.data;

namespace iih.ci.ord.opemergency.dialog
{
    /// <summary>
    /// 检查医疗单--套明细
    /// </summary>
    public partial class ApobsSetItemDialog : XBaseDialog
    {
        #region 私有变量定义
        private XapDataList<EmsObsLap> itemlist ;
        private XapFormGridControl gv;
        private BaseFormBizView ownerView;
        private bool bAllowEdit = true;
        private bool setRadio = true;
        #endregion

        #region 构造函数
        public ApobsSetItemDialog(BaseFormBizView o, XapDataList<EmsObsLap> emsObsLaps, bool allow , bool setRadioCheck)
        {
            this.ownerView = o;
            bAllowEdit = allow;
            setRadio = setRadioCheck;
            this.itemlist = emsObsLaps;
            InitializeComponent();
            initXapFormControl();
         
            this.Load += OnXapFormControl_Load;
            this.xapFormControl.FormCreated += OnXapFormControl_FormCreated;
            
        }

        void cancelButton_MouseClick(object sender, MouseEventArgs e)
        {
            this.Close();
        }

        void saveButton_MouseClick(object sender, MouseEventArgs e)
        {
            bool hasSelected = false;
            for (int i = 0; i < gv.DataTable.Rows.Count; i++)
            {
                XDataRow row = gv.DataTable.Rows[i];
                if (row.GetMultiSelectStatus())
                {
                    hasSelected = true;
                    break;
                }
            }
            if (!hasSelected)
            {
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

            if (bChanged && this.ownerView != null)
            {

                this.ownerView.SentNotify(EventCodeType.NM_EMS_ORSRV_DATACHANGED);

            }

            DialogResult = DialogResult.OK;
        }

        
        #endregion 

        #region 事件方法
       

        /// <summary>
        /// 处理加载消息
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void OnXapFormControl_Load(object sender, EventArgs e)
        {
            FormFile file = new FormFile
            {
                FormId = "20160527033308223PQR",
                FormStyle = FormStyle.Card,
                ViewModel = itemlist
            };
            xapFormControl.ViewFile = file;

        }

        void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            gv = this.xapFormControl.GetGridView("setitem");
            gv.DataTable.MultiSelectEnable = bAllowEdit;
            this.xapFormControl.ModelFilled += OnXapFormControl_ModelFilled;
            //this.xapFormControl.DataDisplay += OnXapFormControl_DataDisplay;
            gv.DataTable.SelectedRowChanged += OnGridViewControl_SelectRowChanged;
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

        void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            if (gv.DataTable.Rows.Count == 0) return;
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


        #endregion

        #region 辅助方法
        /// <summary>
        /// 初始化表单控件
        /// </summary>
        private void initXapFormControl()
        {
            //窗体中控件布局
            xapFormControl = new XapFormControl
            {
                Location = Panel.Location,
                Width = Panel.Width,
                Height = Panel.Height
            };
            xapFormControl.SetEditPolicy(true);
            Panel = xapFormControl;

            saveButton = new XButton { Size = new Size(75, 25), Text = "确定" };
            cancelButton = new XButton { Size = new Size(75, 25), Text = "取消" };

            this.saveButton.MouseClick += saveButton_MouseClick;
            this.cancelButton.MouseClick += cancelButton_MouseClick;

            saveButton.Enabled = bAllowEdit;
           // cancelButton.Enabled = bAllowEdit;

            Text = @"处置明细";
            AddRender_Btn(saveButton, cancelButton);
        }

      



        #endregion

    }
}

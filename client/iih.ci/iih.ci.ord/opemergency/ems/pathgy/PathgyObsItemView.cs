using System;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using iih.ci.ord.ciordems.d;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.model;
using xap.rui.control.forms.control;
using System.Windows.Forms;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.ciorder.ctlEx;
using xap.cli.sdk.controls.DataView;
using System.Collections.Generic;
using iih.ci.ord.opemergency.tool;
using iih.en.pv.dto.d;
using xap.rui.bizcontrol.bannercontrol;
using iih.ci.ord.opemergency.ems.dp;

namespace iih.ci.ord.opemergency.ems
{
    public partial class PathgyObsItemView : XapListControl
    {
        public bool bEdit = true;

        private EmsPathgyItemDO emsPathgyItemDO;
        private XapFormGridControl gv;
        private OrdPageCommand ordPageCommand;
        private BaseEmsViewModel model;
        private xap.rui.control.forms.view.XapFormControl xapFormControl1;
        #region 构造函数区域
        public PathgyObsItemView(EmsPathgyItemDO pathgyItemDO, BaseEmsViewModel model)
        {
            InitializeComponent();
            this.model = model;
            this.emsPathgyItemDO = pathgyItemDO;

            this.xapFormControl1.Load += new EventHandler(EmsItemInPathgyView_Load);
            this.xapFormControl1.FormCreated += new EventHandler(EmsItemInPathgyView_FormCreated);
        }

        public override bool HasErrors
        {
            get
            {
                return this.xapFormControl1.HasErrors;
            }
            set
            {
                base.HasErrors = value;
            }
        }
        private void InitializeComponent()
        {
            this.xapFormControl1 = new xap.rui.control.forms.view.XapFormControl();

         
            this.SuspendLayout();
            // 
            // xapFormControl1
            // 
            this.xapFormControl1.Context = null;
            this.xapFormControl1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.xapFormControl1.File = null;
            this.xapFormControl1.IsXapGrid = true;
            this.xapFormControl1.Location = new System.Drawing.Point(0, 0);
            this.xapFormControl1.Name = "xapFormControl1";
            this.xapFormControl1.Size = new System.Drawing.Size(488, 397);
            this.xapFormControl1.TabIndex = 0;
            this.xapFormControl1.ViewFile = null;
            // 
            // PathgyObsItemView
            // 
            //this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.xapFormControl1);
            this.Name = "PathgyObsItemView";
            this.Size = new System.Drawing.Size(488, 397);
            this.Dock = DockStyle.Top;
            this.Height = 130;
            this.ResumeLayout(false);
        }
        #endregion

        #region 父类继承区域
        /// <summary>
        /// 状态监测
        /// </summary>
        public override void OnStatus()
        {
            //设置表格编辑按钮可用性
            if (this.ordPageCommand != null)
            {
                bool enableEdi = (null != this.gv.DataTable.FocusedRow);
                this.ordPageCommand.delCommand.Enabled = enableEdi;
                this.ordPageCommand.printCommand.Enabled = enableEdi;
            }
        }

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {

        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_OP_PathgyObsItemView;// "20160608101903327EPN";
            file.FormStyle = FormStyle.List;
            file.ViewModel = this.emsPathgyItemDO.EmsItemInpathgy;

            this.xapFormControl1.ViewFile = file;
            this.SetGridPolicy(bEdit);
        }
        #endregion

        #region 内部事件区域
        private void EmsItemInPathgyView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

        private void EmsItemInPathgyView_FormCreated(object sender, EventArgs e)
        {
            SetTabCommand();

            this.xapFormControl1.SetToilHeight(40);

            gv = this.xapFormControl1.GetGridView("sortno");
        }
        #endregion

        #region 辅助处理区域
        /// <summary>
        /// 发送树节点选中事件到卡上显示数据
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void SetGridPolicy(bool flag)
        {
            DataPolicy policy = new DataPolicy();
            policy.AllowNew = false;
            policy.AllowEdit = flag;
            policy.AllowRemove = false;
            policy.AllowSave = false;
            policy.FullEdit = flag;

            xapFormControl1.SetEditPolicy(flag, new DataPolicy[1] { policy });
        }

        /// <summary>
        /// 表格新增/编辑/删除按钮事件
        /// </summary>
        public void SetTabCommand()
        {
            ordPageCommand = new OrdPageCommand();
            this.xapFormControl1.SetupCommands(new PageCommands[] 
            {
                ordPageCommand.pageCommands1(
                    "sortno",
                    delegate
                    {
                        AddPathgyItem();
                    },
                    delegate
                    {
                        DeletePathgyItem();
                    },
                    delegate
                    {
                        PrintPathgyItem();
                    },
                    true)
            });
        }

        private void setSortNO()
        {
            for (int i = 0; i < this.emsPathgyItemDO.EmsItemInpathgy.Count; i++)
            {
                this.emsPathgyItemDO.EmsItemInpathgy[i].Sortno = i + 1;
            }
        }

        /// <summary>
        /// 设置表格数据源，单元格编辑状态
        /// </summary>
        /// <param name="gridControl"></param>
        /// <param name="data"></param>
        /// <param name="isXy"></param>
        private void resetGridCellFocus()
        {
            if (gv != null && gv.DataTable.Rows.Count > 0)
            {
                gv.DataTable.Rows[gv.DataTable.Rows.Count - 1].Selected = true;
                List<XCellRender> lstCell = gv.DataTable.Rows[gv.DataTable.Rows.Count - 1].CellList;
                foreach (var cell in lstCell)
                {
                    if (cell.FieldName.Equals("Name_labsamp"))
                    {
                        gv.ShowEditor(cell);
                    }
                }
            }
        }

        public void AddPathgyItem()
        {
            this.emsPathgyItemDO.EmsItemInpathgy.AddNew();
            setSortNO();
        }

        public void DeletePathgyItem()
        {
            if (gv.DataTable.Rows.Count > 0) {
                this.emsPathgyItemDO.EmsItemInpathgy.Delete(gv.GetFocusedRow<EmsItemInPathgy>());
                setSortNO();
                this.emsPathgyItemDO.EmsItemInpathgy.Save();
            }
            else {
                //this.ShowInfo("");
            }
        }
        public void PrintPathgyItem()
        {
            if (gv.DataTable.Rows.Count > 0)
            {

                string id_ent = this.model.GetEnt4BannerDTO().Id_ent;
                string data = "";
                if (gv.DataTable.Rows.Count > 0)
                {
                    List<XDataRow> select = gv.DataTable.Rows.GetSelectedRows();
                    foreach (XDataRow sel in select)
                    {
                        EmsItemInPathgy itemDTO = sel.DataSource as EmsItemInPathgy;
                        data += DataHandle(itemDTO);
                    }
                }
                else
                {
                    List<XDataRow> allData = gv.DataTable.Rows.DataRowList;
                    foreach (XDataRow sel in allData)
                    {
                        EmsItemInPathgy itemDTO = sel.DataSource as EmsItemInPathgy;
                        data += DataHandle(itemDTO);
                    }
                }

                PrintTool.PrintCard(id_ent, data, 1, true, null);
            }

        }
        private string DataHandle(EmsItemInPathgy item)
        {
            string result = "";
            int? sortno = item.Sortno;
            int? quan = item.Quan_coll;
            string name_labsamp = item.Name_labsamp;
            string body_coll = item.Body_coll;
            result += sortno + "," + quan + "," + name_labsamp + "," + body_coll + "|";
            return result;
        }
        public void RefreshData(EmsPathgyItemDO pathgyItemDO)
        {
            this.emsPathgyItemDO = pathgyItemDO;
            this.LoadData();
        }
        #endregion
    }
}

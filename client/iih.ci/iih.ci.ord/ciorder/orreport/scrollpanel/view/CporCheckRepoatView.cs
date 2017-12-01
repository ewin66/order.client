
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.rui.control.basecontrol;
using xap.rui.appfw;
using iih.ci.ord.ems.d;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.mw.core.data;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.orreport.scrollpanel.model;
using System.Drawing;
using xap.rui.control.forms.model;
using xap.cli.sdk.controls.DataView.Model;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.controls.DataView.Renders;
using xap.cli.sdk.common;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciorder.orreport.scrollpanel.view
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.donot    </para>    
    /// <para>类 名 称 :  HealthCheckRepoat					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/10/27 14:55:34             </para>
    /// <para>更新时间 :  2016/10/27 14:55:34             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class CporCheckRepoatView : BaseCheckRepoatView
    {
        #region 变量区
        CporCheckReportModel reportModel = new CporCheckReportModel();
        XapDataList<CiOrderDO> dataSource;
        #endregion
        public CporCheckRepoatView(object dataList,string[] id_ors, string title,int key)
            : base(dataList,id_ors, title,key)
        {
            Size s = this.Size;
            s.Width = viewWide;
            dataSource = datalist as XapDataList<CiOrderDO>;
            if (RelativeUIParam.ScreenSize == ScreenSize.Large)
            {
                s.Height = dataSource.Count * 29 + 60;
            }
            else
            {
                s.Height = dataSource.Count * 25 + 56;
            }
            this.Size = s;
            this.SizeChanged += new EventHandler(CporCheckRepoatView_SizeChanged);
        }

        void CporCheckRepoatView_SizeChanged(object sender, EventArgs e)
        {
            Size s = this.Size;
        }

        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_CporCheckRepoatView;// "20161102092619243000";
            file.FormStyle = FormStyle.List;
            file.ViewModel = dataSource;
            this.xapFromControl.ViewFile = file;
        }
        void xapFromControl_ModelFilled(object sender, EventArgs e)
        {
            
        }
        protected override void xapFromControl_FormCreated(object sender, EventArgs e)
        {
            base.xapFromControl_FormCreated(sender,e);
            gridView = this.xapFromControl.GetGridView("grid");
            gridView.DataTable.DataDisplay += new EventHandler<XDataDisplayEventArgs>(tabControl_DataDisplay);
            gridView.DataTable.CustomerCellMouseClick += new EventHandler(OnXapFromGrid_CellClick);
        }
        /// <summary>
        /// 单元格点击事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void OnXapFromGrid_CellClick(object sender, EventArgs e)
        {
            if ((sender as XCheckboxGroup).checFirst.Checked)
            {
                ((sender as XCheckboxGroup).Row.ColumnCellDict["Reason_uncporuse"] as XCellRender).NullFlag = false;
            }
            else
            {
                ((sender as XCheckboxGroup).Row.ColumnCellDict["Reason_uncporuse"] as XCellRender).NullFlag = true;
            }
           
        }
        void tabControl_DataDisplay(Object sender, XDataDisplayEventArgs e)
        {
            XDataRow row = sender as XDataRow;
            //0两个都不选，1：first选择,2:second选择
            if (row != null && row.ColumnCellDict.ContainsKey("Eu_uncpordoctorjudge"))
            {
                XCheckboxGroup cell = row.ColumnCellDict["Eu_uncpordoctorjudge"] as XCheckboxGroup;
                cell.Enabled = this.getCanEdit();
                cell.checFirst.Text = "确认";
                cell.checSecond.Text = "取消";
                CiOrderDO ciOrderDO = row.RowDataSource as CiOrderDO;
                ciOrderDO.Eu_uncpordoctorjudge = 0;
                if (ciOrderDO.Eu_uncporjudge != null && ciOrderDO.Eu_uncporjudge == (int)HpIndicJudgeEnum.JUDGED)
                {
                    cell.checFirst.Checked = true;
                    ciOrderDO.Eu_uncpordoctorjudge = 1;
                }
                else {
                    ciOrderDO.Eu_uncpordoctorjudge = 0;
                }
            }
        }
        public override void save()
        {
            reportModel.save(dataSource,this.id_ors);
        }
    }
}

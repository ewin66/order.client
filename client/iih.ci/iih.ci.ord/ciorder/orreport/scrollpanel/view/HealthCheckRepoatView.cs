
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
using xap.cli.sdk.controls.DataView.Base;
using xap.cli.sdk.render.Items;
using iih.bd.iih.bd.bc.udi;
using iih.ci.ord.ciordsysparam;
using iih.ci.ord.opemergency.tool;
using xap.mw.coreitf.d;

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
    public partial class HealthCheckRepoatView : BaseCheckRepoatView
    {
        #region 变量区
        public HealthCheckReportModel reportModel = new HealthCheckReportModel();
        public XapDataList<OrdSrvDO> _dataSource;
        public bool _sg_selfpay = false;
        public string orderType { get; set; }

        public Boolean fg_selfpay 
        {
            get
            {
                return _sg_selfpay;
            }
            set { _sg_selfpay = value; }
        }

        public XapDataList<OrdSrvDO> dataSource {
            get { return _dataSource;}
            set {
                this._dataSource = value;
            }
        }
        #endregion
        public HealthCheckRepoatView(object dataList, string[] id_ors,String orderType)
        {
            InitializeComponent();
            this.datalist = dataList;
            this.id_ors = id_ors;
            this.orderType = orderType;
            this.xapFromControl.FormCreated += new EventHandler(xapFromControl_FormCreated);
            this.xapFromControl.ModelFilled += new EventHandler(xapFromControl_ModelFilled);
            this.Load += new EventHandler(HealthCheckRepoat_Load);
        }
        public HealthCheckRepoatView(string[] id_ors)
        {
            this.id_ors = id_ors;
            InitializeComponent();
            this.Load += new EventHandler(HealthCheckRepoat_Load);
        }
        public HealthCheckRepoatView(object dataList, string[] id_ors, string title, int key, CiOrderDO ciOrderDO)
            : base(dataList, id_ors, title, key)
        {
            Size s = this.Size;
            s.Width = viewWide;
            this.orderType = ciOrderDO.Sd_srvtp;
            dataSource = datalist as XapDataList<OrdSrvDO>;
            if (RelativeUIParam.ScreenSize == ScreenSize.Large)
            {
                s.Height = dataSource.Count * 29 + 105;
            }
            else
            {
                s.Height = dataSource.Count * 25 + 101;
            }
            this.Size = s;
        }
        protected override void OnLoadData()
        {
            base.OnLoadData();
            if (id_ors != null && dataSource==null)
            {
                this.dataSource = this.reportModel.getDataSource(id_ors);
            }
        }
        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_HealthCheckRepoatView;// "20161101023449230000";
            file.FormStyle = FormStyle.List;
            file.ViewModel = dataSource;
            this.xapFromControl.ViewFile = file;
        }
        void xapFromControl_ModelFilled(object sender, EventArgs e)
        {
            
        }
        protected override void xapFromControl_FormCreated(object sender, EventArgs e)
        {
            this.radioGroup.Enabled = this.getCanEdit();
            base.xapFromControl_FormCreated(sender,e);
            this.radioGroup.ValueTextChanged += new EventHandler(radioGroup_ValueTextChanged);

            gridView = this.xapFromControl.GetGridView("grid");
            gridView.DataTable.DataDisplay += new EventHandler<XDataDisplayEventArgs>(tabControl_DataDisplay);
        }

        void radioGroup_ValueTextChanged(object sender, EventArgs e)
        {
            XRadioboxGroup radioBox = (sender as XRadioboxGroup);
            bool hpTreatAllSelect = true;
            if (radioBox.ValueText == ReportCodeDict.HP_TREAT_ALL_SELECT)
            {
                hpTreatAllSelect = true;
            }
            else {
                hpTreatAllSelect = false;
            }
            RowCollectionBase rows = gridView.DataTable.Rows;
            if (rows != null)
            {
                List<XDataRow> rowsList = rows.DataRowList;
                foreach (XDataRow row in rowsList)
                {
                    OrdSrvDO orSrvDO = row.RowDataSource as OrdSrvDO;
                    // 丙类的服务项目自费，非自费单选按钮状态设置为不可操作
                    if (orSrvDO.Sd_hpsrvtp == HpDicCodeConst.SD_HPSRVTP_CLASS_C)
                    {
                        continue;
                    }
                    XCheckboxGroup cell = row.ColumnCellDict["Eu_hpdoctorjudge"] as XCheckboxGroup;
                    cell.checFirst.Checked = hpTreatAllSelect;
                    cell.checSecond.Checked = !hpTreatAllSelect;
                    
                    orSrvDO.Eu_hpdoctorjudge = hpTreatAllSelect == true ? 1 : 2;
                }
            }
        }
        void tabControl_DataDisplay(Object sender, XDataDisplayEventArgs e)
        {
            XDataRow row = sender as XDataRow;
            OrdSrvDO orSrvDO = row.RowDataSource as OrdSrvDO;
            orSrvDO.Eu_hpdoctorjudge = 0;
            if (orSrvDO.Indicitemid==null)
            {
                orSrvDO.Indicitemid = orSrvDO.Sd_srvtp;
            }
            GetSysParamDTO sysParamDto = SysParamUtils.getSysParam().SYS_PARAM_IsAdmintHpIndicJudgeFeeItemUnDrugOR;
            //0两个都不选，1：first选择,2:second选择
            if (row != null && row.ColumnCellDict.ContainsKey("Eu_hpdoctorjudge"))
            {
                XCheckboxGroup cell = row.ColumnCellDict["Eu_hpdoctorjudge"] as XCheckboxGroup;
                // 如果医保目录为丙类的不允许编辑
                cell.Enabled = orSrvDO.Sd_hpsrvtp != HpDicCodeConst.SD_HPSRVTP_CLASS_C;
                
                
                if (cell.Enabled)
                {
                    if (sysParamDto.OrgParam != null && sysParamDto.OrgParam.Equals("true"))
                    {
                       
                            cell.Enabled = this.getCanEdit();
                    }
                    else
                    {
                        if (this.orderType != null &&
                            (this.orderType.StartsWith("02") || this.orderType.StartsWith("03")))
                        {
                            cell.Enabled = false;
                        }
                        else
                        {
                            cell.Enabled = this.getCanEdit();
                        }
                        
                    }
                   
                }
                
                //cell.checFirst.Text = "符合-医保 全选";
                //cell.checSecond.Text = "不符合-自费 全选";
                cell.checFirst.Text = "符合-医保";
                cell.checSecond.Text = "不符合-自费";
                //待判断
                if (orSrvDO.Fg_hpindicjudged == (int)HpIndicJudgeEnum.WAITINGJUDGE) {
                    if (orSrvDO.Fg_indic != null) {
                        //if (orSrvDO.Fg_indic == true)
                        //{
                        //    cell.checFirst.ForeColor = Color.Red;
                        //}
                        //else {
                        //    cell.checSecond.ForeColor = Color.Red;
                        //}
                    }
                    orSrvDO.Eu_hpdoctorjudge = 0;
                }//已判断
                else
                {
                    if (orSrvDO.Fg_indic == null)
                    {
                        // 两个都不选中,该值会设置适应，非适应都不选中
                        orSrvDO.Eu_hpdoctorjudge = 0;                        
                        //cell.checFirst.Checked = false;
                        //cell.checSecond.Checked = false;
                    }
                    else
                    {                        
                        bool firChecked = FBoolean.True == orSrvDO.Fg_indic && FBoolean.False == orSrvDO.Fg_selfpay;
                        //bool secChecked = FBoolean.False == orSrvDO.Fg_indic || FBoolean.True == orSrvDO.Fg_selfpay;
                        if (firChecked)
                        {
                            // 两个都不选中,该值会设置适应症选中
                            orSrvDO.Eu_hpdoctorjudge = 1;
                        }
                        else
                        {
                            // 两个都不选中,该值会设置非适应症选中
                            orSrvDO.Eu_hpdoctorjudge = 2;
                        }                        
                    }
                }                
            }
        }
        public override void save()
        {
            reportModel.save(dataSource,this.id_ors);
        }

       public string isDocJudgedOver()
        {
           foreach(OrdSrvDO srvdo in this.dataSource){
                if(srvdo.Eu_hpdoctorjudge==0){
                    return "医保适应症判断尚未完成!";
                    //return "服务"+srvdo.Name+"未进行医保判断！";
                }
                if (srvdo.Eu_hpdoctorjudge ==2)
               {
                   _sg_selfpay =true;
               }
           }
            return null;
        }
    }
}

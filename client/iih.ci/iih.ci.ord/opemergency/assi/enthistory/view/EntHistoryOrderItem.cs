
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.ciorder.viewmodel;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.control;
using xap.rui.control.forms.view;
using xap.cli.sdk.controls.DataView;
using iih.ci.ord.ciorder.d;
using xap.cli.sdk.controls.DataView.Model;
using xap.cli.sdk.render;
using xap.cli.sdk.render.DoctorOrderCard;
using System.Windows.Forms;
using System.IO;
using System.Xml.Serialization;
using xap.cli.sdk.controls.DataView.Extension.XOrderResult;
using xap.cli.sdk.controls.DataView.Extension;
using iih.ci.ord.ciorder.orreport;
using iih.ci.ord.cilab.view;
using xap.rui.bizcontrol.ClinicalTimeline.reportTypeInfo;
using System.Drawing;
using iih.ci.ord.opemergency.assi.enthistory.viewmodel;
using xap.mw.coreitf.d;
using iih.bd.bc.udi;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.opemergency.assi.enthistory.view
{
    /// <summary>
    /// <para>描    述 :  就诊历史中医嘱列表</para>
    /// <para>说    明 :  通过不同的就诊类型获取不同的医嘱列表</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.entphistory.view    </para>    
    /// <para>类 名 称 :  EntpHistoryOrderItem					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  hums         				</para> 
    /// <para>修 改 人 :  hums         				</para> 
    /// <para>创建时间 :  2016/7/18 19:34:47             </para>
    /// <para>更新时间 :  2016/7/18 19:34:47             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EntHistoryOrderItem : EntHistoryContentBase
    {


        #region 变量定义区域
        /// <summary>
        /// 表单id
        /// </summary>
        private const string FORM_ID = "20160719103146395ZJI";
        /// <summary>
        /// 逻辑处理接口
        /// </summary>
        [Display(Name = "算法，接口调用集合", Description = "各种算法的汇集")]
        public LogicEx cof = LogicEx.GetInstance();

        /// <summary>
        /// 医嘱项目服务
        /// </summary>        
        private CiOrdViewModel ciOrdViewModel;

        /// <summary>
        /// 表单模板输入文件
        /// </summary>
        private FormFile file = new FormFile();

        /// <summary>
        /// 医嘱表格控件
        /// </summary>
        private XapFormGridControl gridCtrl;

        /// <summary>
        /// 医嘱组件
        /// </summary>
        private DoctorOrderConfig doctorOrderConfig;

        /// <summary>
        /// 自定义列内容
        /// </summary>
        private Dictionary<string, string> cusotmCellDic = new Dictionary<string, string>{
            {"02","CiRptLabView"},{"03","CIRptObsView"}
        };


        #endregion

        #region 构造函数区域

        public EntHistoryOrderItem()
        {
            InitializeComponent();

        }

        public EntHistoryOrderItem(IContainer container)
        {
            container.Add(this);

            InitializeComponent();
        }

        #endregion

        #region 公开属性区域

        #endregion

        #region 命令定义区域

        #endregion

        #region 事件发送区域

        #endregion

        #region 事件接收区域

        #endregion

        #region 父类继承区域

        protected override void OnLoadData()
        {
            // 就诊id ，就诊类型为空时清空model
            if (!string.IsNullOrEmpty(this.Id_ent) && !string.IsNullOrEmpty(this.Code_entp))
            {
                if (ciOrdViewModel == null)
                {
                    ciOrdViewModel = new CiOrdViewModel(this.Ent4BannerDTO, this.Context);
                }

                ciOrdViewModel.loadOderItems(this.Id_ent, this.Code_entp);
            }
            else
            {
                ciOrdViewModel.xapList = null;
                ciOrdViewModel.PriMap = null;
            }
        }

        protected override void OnFillData()
        {
            //填充数据
            file.ViewModel = ciOrdViewModel.xapList;
            xapFormControl.ViewFile = file;
        }

        #endregion

        #region 内部事件区域

        private void EntpHistoryOrderItem_Load(object sender, System.EventArgs e)
        {
            this.file.FormId = CiOrdBillFormTmplConst.CIORD_OP_EntHistoryOrderItem;// FORM_ID;
            this.file.FormStyle = FormStyle.Card;
        }


        private void xapFormControl_FormCreated(object sender, System.EventArgs e)
        {
            // 初始化医嘱组件
            string path = Application.StartupPath + "\\modules\\iihci\\ui\\commoncontent\\OrderContent.xml";
            doctorOrderConfig = this.Deserialize(path);

            gridCtrl = xapFormControl.GetGridView("ciorder");

            if (BdFcDictCodeConst.SD_CODE_ENTP_IP.Equals(this.Code_entp))// 住院
            {                
                // 调整门诊、医嘱列表显示内容
                gridCtrl.DataTable.Columns["customercolumn_price"].Visible = false;
                gridCtrl.DataTable.Columns["Dt_end"].Visible = true;
            }
            else if (BdFcDictCodeConst.SD_CODE_ENTP_OP.Equals(this.Code_entp) || BdFcDictCodeConst.SD_CODE_ENTP_ET.Equals(this.Code_entp)) // 门急诊
            {
                // 调整门诊、医嘱列表显示内容
                gridCtrl.DataTable.Columns["customercolumn_price"].Visible = true;
                gridCtrl.DataTable.Columns["Dt_end"].Visible = false;
            }

            // 渲染医嘱内容列
            gridCtrl.DataTable.DataDisplay += tabControl_DataDisplay;
        }

        private void cell_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            XOrderResultCell cell = sender as XOrderResultCell;
            if (cell != null)
            {
                CiOrderDO ciOrderDO = cell.DataSource as CiOrderDO;
                if (string.IsNullOrEmpty(((sender as XOrderResultCell).ActiveObject as XOrderResultRender).Value) || ((sender as XOrderResultCell).ActiveObject as XOrderResultRender).Value.Equals("0"))
                {
                    return;
                }
                int type = Convert.ToInt32(((sender as XOrderResultCell).ActiveObject as XOrderResultRender).Type);
                if (ciOrderDO.Sd_srvtp.Substring(0, 2).Equals("02") || ciOrderDO.Sd_srvtp.Substring(0, 2).Equals("03"))
                {
                    string dia = "";
                    string title = "";
                    if (ciOrderDO.Sd_srvtp.Substring(0, 2).Equals("02"))
                    {
                        dia = "ris";
                        title = "检查报告";
                    }
                    else if (ciOrderDO.Sd_srvtp.Substring(0, 2).Equals("03"))
                    {
                        dia = "lis";
                        title = "检验报告";
                    }
                    CliTestView TestView = new CliTestView();
                    var lab = new CiRptLabView();
                    lab.setlabdto(ciOrderDO.Id_or, dia, TestView);

                    TestView.DataView = lab;
                    TestView.Text = title;
                    TestView.Size = new Size(800, 675);
                    TestView.cliTestControl.AddRender(TestView.DataView);
                    TestView.ShowDialog();
                }
                else
                {
                    OrReport orReport = new OrReport(sender as XOrderResultCell, ciOrderDO, 1);
                    orReport.ShowDialog();
                }
            }
        }
        #endregion

        #region 辅助处理函数

        /// <summary>
        /// 医嘱表格数据显示时的处理事件，这里主要用于处理医嘱显示内容
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void tabControl_DataDisplay(Object sender, XDataDisplayEventArgs e)
        {
            CiOrderDO ciorder = e.Object as CiOrderDO;
            string id_or = ciorder.Id_or;

            var row = sender as XDataRow;
            if (row != null)
            {

                foreach (UserRender render in row.UserRenderList)
                {
                    if (render is DoctorOrderCard)
                    {
                        var card = render as DoctorOrderCard;
                        card.DoctorOrderConfig = this.doctorOrderConfig;
                    }
                }
            }
                        
            // 设置最后一列显示价格
            XCellRender priceCell = (row.ColumnCellDict["customercolumn_price"] as XCellRender);
            if (priceCell.Visible == true) // 住院不可见
            {
                FDouble pri = ciOrdViewModel.PriMap[id_or] as FDouble;
                priceCell.Value = pri;
            }

            XCellRender cell = row.ColumnCellDict["customercolumn_报告查看"] as XCellRender;


            if (ciOrdViewModel.OrdStatusMap.Keys.Contains(id_or)) {
                DoctorOrderCard contentOrCell = row.ColumnCellDict["Content_or"] as DoctorOrderCard;
                row.Enabled = false;
                row.TooltipText = ciOrdViewModel.OrdStatusMap[id_or] as string;
                contentOrCell.ForeColor = Color.Red;
                row.UserForeColor = Color.Red;
            }


            this.setCellContent(cell, ciorder);
        }

        /// <summary>
        /// 设置单元格属性
        /// <para>设置单元格显示内容，绑定事件</para>
        /// </summary>
        /// <param name="cell"></param>
        /// <param name="ciorder"></param>
        private void setCellContent(XCellRender cell, CiOrderDO ciorder)
        {
            if (ciorder.Sd_srvtp == null)
            {
                cell.ValueText = "加载失败，缺少服务分类！";
                return;
            }

            string sd_srvtp = ciorder.Sd_srvtp.Substring(0, 2);

            List<XOrderResultData> resultList = OrReportPictureButton.GetInstance().buildOrderResultData(ciorder);
            cell.Value = resultList;
            cell.MouseClick += new MouseEventHandler(cell_MouseClick);

            //if (cusotmCellDic.ContainsKey(sd_srvtp))
            //{
            //    cell.ValueObj = ciorder;
            //    cell.ValueText = "报告出具";
            //    cell.MouseClick += new MouseEventHandler(cell_MouseClick);
            //}
        }


        /// <summary>
        /// 获取当前页面选中医嘱记录
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="data">null</param>
        /// <returns>Dictionary<string,object> </returns>
        protected override Dictionary<string, object> GetEntContentSel(object sender, Dictionary<string, string> data)
        {
            Dictionary<string, object> orderItemDic = new Dictionary<string, object>();

            // 获取选中的医嘱
            CiOrderDO[] ciOrders = this.xapFormControl.GetSelected<CiOrderDO>();

            if (ciOrders == null || ciOrders.Length == 0)
            {
                orderItemDic.Add(ORDER_ITEM, null);
            }
            else
            {
                orderItemDic.Add(ORDER_ITEM, ciOrders);
            }

            return orderItemDic;
        }


        /// <summary>
        /// 解析医嘱控件的xml配置
        /// </summary>
        /// <param name="path">医嘱控件对应的配置文件路径</param>
        /// <returns></returns>
        private DoctorOrderConfig Deserialize(string path)
        {
            DoctorOrderConfig doctorCfg = null;
            using (FileStream fs = new FileStream(path, FileMode.Open, FileAccess.Read))
            {
                XmlSerializer xml = new XmlSerializer(typeof(DoctorOrderConfig));
                doctorCfg = (DoctorOrderConfig)xml.Deserialize(fs);
            }
            return doctorCfg;
        }


        #endregion

        #region 状态处理区域

        #endregion
    }
}

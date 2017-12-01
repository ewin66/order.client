using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.control.basecontrol;
using xap.dp.optdesigner.UI.UICsCtrl;
using xap.mw.core.data;
using iih.ci.ord.ordprn.d;
using xap.rui.engine;
using xap.rui.control.extentions;
using iih.ci.ord.ciorder.ciorderprn.viewmodel;
using xap.dp.optdesigner.UI;
using xap.dp.optdesigner.Print.BatPrtContent;
using System.Collections;
using xap.rui.control.engine.attributes;
using xap.cli.sdk.form;

/********************************************************************************

** 作者： 杨敬本

** 创始时间：2016/8/10

** 修改人：杨敬本

** 修改时间：2016/8/10

** 描述：医嘱单打印工作区域

*********************************************************************************/

namespace iih.ci.ord.ciorder.ciorderprn.view
{
    public partial class OrdPrintWorkspaceView : XapBaseControl
    {
        #region 变量定义区域
        private OrdPrintViewModel viewModel;//数据处理模型

        private OrdPrintDO ordPrintDO_Pat = new OrdPrintDO();//接收控制面板患者就诊信息，包括打印场景标识

        private QiPanel_DataRender qiPanel_DataRender;//打印模板展示对象

        private bool bClear;
        #endregion

        #region 构造函数区域
        public OrdPrintWorkspaceView()
        {
            InitializeComponent();
            xapFormControl1.Load += new EventHandler(xapFormControl1_Load);
            loadPrintModel();
        }
        #endregion

        #region 命令定义区域
        [XapCommand(Name = UIEvent.PRINT)]
        public void OnPrintAction()
        { }

        [XapCommand(Name = UIEvent.REFRESH)]
        public void OnAdjustAction()
        { }

        [XapCommand(Name = UIEvent.DELETE)]
        public void OnClearAction()
        { }
        #endregion

        #region 内部事件区域
        private void xapFormControl1_Load(object sender, EventArgs e)
        {
            viewModel = new OrdPrintViewModel();

            this.Padding = new System.Windows.Forms.Padding(4, 0, 4, 4);
            this.xapFormControl1.Padding = new System.Windows.Forms.Padding(4, 0, 4, 4);
            this.xapFormControl1.SingleBorderStyle = true;

            this.OnInit();
        }
        #endregion

        #region 父类继承区域
        /// <summary>
        /// 状态监测
        /// </summary>
        public override void OnStatus()
        {
            bool enable = true;
            bool enableAdj = true;
            bool enableDel = true;

            enable = (ordPrintDO_Pat.Id_orprn != null && !ordPrintDO_Pat.Id_orprn.Equals(OrdPrintConst.PRINT_MODE_ALLBROWSE) && this.viewModel.ArryOrdPrintDOsPreview != null && this.viewModel.ArryOrdPrintDOsPreview.Length > 0);
            enableAdj = (ordPrintDO_Pat.Id_orprn != null && ordPrintDO_Pat.Id_orprn.Equals(OrdPrintConst.PRINT_MODE_CONTINUE) && enable);
            enableDel = (ordPrintDO_Pat.Id_orprn != null && ordPrintDO_Pat.Id_orprn.Equals(OrdPrintConst.PRINT_MODE_ALLBROWSE) && this.viewModel.ArryOrdPrintDOsPreview != null && this.viewModel.ArryOrdPrintDOsPreview.Length > 0);
            this.SetEnable(UIEvent.PRINT, enable);//打印
            this.SetEnable(UIEvent.REFRESH, enableAdj);//调整

            this.SetEnable(UIEvent.DELETE, enableDel);//清空
        }

        /// <summary>
        /// 获取控件相关的数据
        /// </summary>
        protected override void OnLoadData()
        {
            //加载数据
            if (ordPrintDO_Pat != null && ordPrintDO_Pat.Id_en != null)
            {
                if (ordPrintDO_Pat.Id_orprn.Equals(OrdPrintConst.PRINT_MODE_SINGLE) && ordPrintDO_Pat.Page_num == null)
                {
                    this.ShowInfo("请选择补打页号！");
                    return;
                }

                //加载医嘱信息
                viewModel.LoadOrdPrintData(ordPrintDO_Pat.Id_en, ordPrintDO_Pat.Fg_long, ordPrintDO_Pat.Page_num - 1, ordPrintDO_Pat.Id_orprn);
            }
            //数据为空，也要绑定数据源
            toPreview();
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            //刷新模板
            qiPanel_DataRender.getViewPanel().Refresh();
        }
        #endregion

        #region 私有方法区域
        /// <summary>
        /// 加载打印模板（未加载数据）
        /// </summary>
        private void loadPrintModel()
        {
            if (qiPanel_DataRender == null)
                qiPanel_DataRender = new QiPanel_DataRender(QiPanel_DataRender.ENum_Rend_Type.Rend_As_Canvas);
            qiPanel_DataRender.clear();
            qiPanel_DataRender.setPanelDocStyle(DockStyle.Fill);
            qiPanel_DataRender.openViewTempl("46106015",
                (ordPrintDO_Pat.Fg_long == null || ordPrintDO_Pat.Fg_long == true) ? "医嘱单打印长期" : "医嘱单打印临时");//加载模板
            this.xapFormControl1.AddRender(qiPanel_DataRender.getViewPanel());
        }

        /// <summary>
        /// 执行预览
        /// </summary>
        private void toPreview()
        {
            Loading _loading = new Loading();
            _loading.TopMost = true;
            Form owerForm = this.FindForm().ParentForm;
            _loading.Owner = owerForm;
            _loading.Show();

            if (!bClear && viewModel.ArryOrdPrintDOsPreview != null && viewModel.ArryOrdPrintDOsPreview.Length == 0)
            {
                string strInfo="";
                if (ordPrintDO_Pat.Id_orprn.Equals(OrdPrintConst.PRINT_MODE_ALLBROWSE))
                    strInfo = "没有查询到已打印的医嘱信息！";
                else
                    strInfo = "没有需要打印的医嘱信息！";
                this.ShowAlert(strInfo);
            }
            bClear = false;

            //预览加载数据，数据为空时只显示背景
            qiPanel_DataRender.loadViewDataAsAgg(new BaseDO[] { null }, viewModel.ArryOrdPrintDOsPreview, viewModel.PrtDORowsAssistPreview, true);

            _loading.End();
        }

        /// <summary>
        /// 执行打印
        /// </summary>
        /// <returns></returns>
        private bool toPrint()
        {
            string strInfo = viewModel.GetPrintTipInfo(ordPrintDO_Pat.Id_orprn);

            if (this.IsContinue("提示", strInfo))
            {
                //获取打印数据,添加页号、行号、行数、打印日期、打印部门、打印人员
                viewModel.GetPrintDOsFromPreviewDOs(this.Context.Dept.Id_dep, this.Context.PsnInfo.Id_psndoc, ordPrintDO_Pat.Id_orprn);

                TemplAndDataLogicAssist prtLogic = new TemplAndDataLogicAssist();
                prtLogic.loadPrtTempl("46106015", (ordPrintDO_Pat.Fg_long == null || ordPrintDO_Pat.Fg_long == true) ? "医嘱单打印长期" : "医嘱单打印临时");
                //prtLogic.loadPrtDataAsAgg(new BaseDO[] { null }, viewModel.ArryOrdPrintDOsPrint, viewModel.PrtDORowsAssistPrint, true);
                prtLogic.loadPrtDataAsAgg(new BaseDO[] { null }, viewModel.ArryOrdPrintDOsPreview, viewModel.PrtDORowsAssistPreview, true);
                if (prtLogic.doPrint(true))
                {
                    viewModel.SavePrintData(ordPrintDO_Pat.Id_orprn);
                    return true;
                }
            }
            return false;
        }

        /// <summary>
        /// 执行调序
        /// </summary>
        private void toSort()
        {
            viewModel.GetDataListForSort();
            using (OrdPrintSortView sortView = new OrdPrintSortView(viewModel, ordPrintDO_Pat.Fg_long))
            {
                if (sortView.ShowDialog() == DialogResult.OK)
                {
                    viewModel.UpdateOrdPrintDOsOrder();
                    toPreview();
                    OnFillData();
                }
            }
        }

        /// <summary>
        /// 执行清空
        /// </summary>
        private void toClear()
        {
            using (OrdPrintClearView clearView = new OrdPrintClearView(ordPrintDO_Pat.Id_en, ordPrintDO_Pat.Fg_long))
            {
                if (clearView.ShowDialog() == DialogResult.OK)
                {
                    bClear = true;
                    int? pagenum = clearView.GetPageNum();
                    viewModel.ClearDataPrtedByPage(pagenum - 1);
                    this.LoadData();
                    this.ShowInfo("删除成功！");
                }
            }
        }

        /// <summary>
        /// 清空预览数据源
        /// </summary>
        private void clearData()
        {
            this.viewModel.ArryOrdPrintDOsPreview = null;
            this.viewModel.PrtDORowsAssistPreview = null;
            toPreview();
            OnFillData();
        }
        #endregion

        #region 状态处理区域
        public override void HandleState(object sender, xap.rui.engine.DictionaryEventArgs e)
        {
            string uiEvent = e.Data[UIConst.UI_EVENT] as string;
            switch (uiEvent)
            {
                case OrdPrintConst.DOPREVIEW:
                    this.ordPrintDO_Pat = sender as OrdPrintDO;
                    this.LoadData();
                    break;
                case OrdPrintConst.DOPRINT:
                    this.ordPrintDO_Pat = sender as OrdPrintDO;
                    if (this.toPrint())
                    {
                        this.viewModel.ArryOrdPrintDOsPreview = null;
                        this.viewModel.PrtDORowsAssistPreview = null;
                    }
                    break;
                case OrdPrintConst.ONLONGTEMPCHANGE:
                    this.ordPrintDO_Pat = sender as OrdPrintDO;
                    loadPrintModel();
                    clearData();
                    break;
                case OrdPrintConst.DOSORT:
                    toSort();
                    break;
                case OrdPrintConst.DOCLEAR:
                    toClear();
                    break;
                case OrdPrintConst.CLEARDATAPREVIEW:
                    clearData();
                    break;
                default:
                    break;
            }
        }
        #endregion
    }
}

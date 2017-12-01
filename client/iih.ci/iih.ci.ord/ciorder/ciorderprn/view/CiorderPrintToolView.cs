using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.rui.control.basecontrol;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using iih.ci.ord.ciorder.ciorderprn.viewmodel;
using xap.cli.sdk.render.Items;
using System.Drawing;
using System.Windows.Forms;
using iih.en.pv.dto.d;
using xap.rui.engine;
using xap.cli.sdk.render;
using iih.ci.ord.ordprn.d;
using xap.dp.optdesigner.UI.UICsCtrl;
using xap.cli.sdk.controls.tabControl;
using xap.mw.core.data;
using xap.rui.control.refcontrol.data;
using xap.cli.context;
using xap.sys.permfw.user.d;
using xap.rui.control.engine.attributes;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.control.extentions;
using xap.rui.bizcontrol.BillFormTmplConst;
//using iih.ci.ord.dto.ordprintparamdto.d;

/********************************************************************************

** 作者： 杨敬本

** 创始时间：2016/8/10

** 修改人：杨敬本

** 修改时间：2016/8/10

** 描述：医嘱单打印控制

*********************************************************************************/

namespace iih.ci.ord.ciorder.ciorderprn.view
{
    public partial class OrdPrintToolView : XapBaseControl
    {
        #region 变量定义区域
        private XTabPage xTabPage;//表单页签

        private XRadioboxGroup radioGroup;//复选框容器
        private XRadiobox radioContinue;//续打
        private XRadiobox radioSetup;//重整
        private XRadiobox radioCancel;//撤销
        private XRadiobox radioStop;//停止
        private XRadiobox radioSingle;//单页补打

        private UserRender userRenderPat;//患者（床号）下拉框
        private UserRender userRenderPage;//页号下拉框

        private OrdPrintDO dataSource = new OrdPrintDO();//打印控制表单数据源，作用是获取参照返回的患者信息，以及选中页码信息，此时的OrdPrintDO.Id_orprn用来传递打印模式标识
        //private OrdPrintParamDTO dataSource = new OrdPrintParamDTO();//数据源应该用这个，待改

        private bool isChangePage;
        #endregion

        #region 构造函数区域
        public OrdPrintToolView()
        {
            InitializeComponent();

            xapFormControl1.Load += new EventHandler(xapFormControl1_Load);
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            xapFormControl1.RefFilter += new EventHandler<xap.rui.control.refcontrol.events.RefActivatingEventArgs>(xapFormControl1_RefFilter);
            xapFormControl1.RefResult += new EventHandler<xap.rui.control.refcontrol.events.RefResultEventArgs>(xapFormControl1_RefResult);
            xapFormControl1.DataChanged += new EventHandler<xap.rui.control.forms.model.DataChangedEventArgs>(xapFormControl1_DataChanged);
        }
        #endregion

        #region 命令定义区域
        [XapCommand(Name = UIEvent.PREVIEW)]
        public void OnPreviewAction()
        { }

        [XapCommand(Name = UIEvent.QUERY)]
        public void OnBrowseAction()
        { }

        [XapCommand(Name = UIEvent.EDIT)]
        public void OnSetupAction()
        { }

        [XapCommand(Name = OrdPrintConst.ORDERACTION)]
        public void OnOrderAction()
        { }

        [XapCommand(Name = OrdPrintConst.LONGACTION)]
        public void OnLongAction()
        { }

        [XapCommand(Name = OrdPrintConst.TEMPACTION)]
        public void OnTempAction()
        { }
        #endregion

        #region 内部事件区域
        /// <summary>
        /// 初始化控件，设置控件属性
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            this.xapFormControl1.Padding = new System.Windows.Forms.Padding(4, 4, 4, 0);
            xTabPage = xapFormControl1.GetTabPageByTabCode("ordprnlong");

            radioGroup = xapFormControl1.GetUserRender("ordprnlong", "radioGroup") as XRadioboxGroup;
            radioGroup.Enabled = true;
            radioGroup.ValueTextChanged += new EventHandler(radioGroup_ValueTextChanged);
            radioContinue = radioGroup.Renders[0] as XRadiobox;
            radioSetup = radioGroup.Renders[1] as XRadiobox;
            radioCancel = radioGroup.Renders[2] as XRadiobox;
            radioStop = radioGroup.Renders[3] as XRadiobox;
            radioSingle = radioGroup.Renders[4] as XRadiobox;

            userRenderPat = xapFormControl1.GetUserRender("ordprnlong", "id_en.name_pat");
            userRenderPage = xapFormControl1.GetUserRender("ordprnlong", "page_num");
            //userRenderPat.Enabled = true;
            userRenderPat.Visible = this.Context["PatientData"] == null;
            userRenderPat.Enabled = this.Context["PatientData"] == null;
            userRenderPage.Enabled = false;
        }

        /// <summary>
        /// 打印场景更换事件（可以有更好的方法吧）
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void radioGroup_ValueTextChanged(object sender, EventArgs e)
        {
            switch ((sender as XRadioboxGroup).ValueText)
            {
                case "单页打印":
                    onRadioCheckChanged(true);
                    break;
                default:
                    onRadioCheckChanged(false);
                    break;
            }
        }

        /// <summary>
        /// 加载控件，初始化场景
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapFormControl1_Load(object sender, EventArgs e)
        {
            this.dataSource.Id_orprn = OrdPrintConst.PRINT_MODE_CONTINUE;//默认一般续打
            this.dataSource.Fg_long = true;//默认长期医嘱单
            this.OnInit();
        }

        /// <summary>
        /// 患者、页码参照条件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapFormControl1_RefFilter(object sender, xap.rui.control.refcontrol.events.RefActivatingEventArgs e)
        {
            if (e.BindingFieldName == "Name_pat_en")
            {
                //科室/病区都在bd_dep表，根据类型Sd_depttp区分
                if (this.Context.Dept.Sd_depttp.Equals("02"))
                {
                    e.WherePart = " t1.id_dep_nur='" + this.Context.Dept.Id_dep + "'";//指定当前病区
                }
                else
                {
                    e.WherePart = " t1.id_dep_phy='" + this.Context.Dept.Id_dep + "'";//指定当前科室
                }
            }
            else if (e.BindingFieldName == "Page_num")
            {
                //根据患者就诊信息获取页码
                //e.WherePart = " id_en='" + this.dataSource.Id_en + "'";
                e.WherePart = String.Format(" id_en='{0}' and fg_long='{1}'", this.dataSource.Id_en, 
                    (this.dataSource.Fg_long == null || this.dataSource.Fg_long == true) ? 'Y' : 'N');
            }
        }

        /// <summary>
        /// 患者、页码参照结果
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapFormControl1_RefResult(object sender, xap.rui.control.refcontrol.events.RefResultEventArgs e)
        {
            switch (e.BindingFieldName)
            {
                case "Name_pat_en":
                    RefData data1 = e.RefResultSet.FirstData;
                    break;
                case "Page_num":
                    RefData data2 = e.RefResultSet.FirstData;
                    if (isChangePage)
                    {
                        dataSource.Id_orprn = OrdPrintConst.PRINT_MODE_SINGLE;
                        onFireEventSent(OrdPrintConst.DOPREVIEW, dataSource);//预览，传递参数
                        isChangePage = false;
                    }
                    break;
            }
        }

        private void xapFormControl1_DataChanged(object sender, xap.rui.control.forms.model.DataChangedEventArgs e)
        {
            //dataSource.Id_orprn = null;
            //dataSource.Page_num = null;
            if (sender != null)
                onFireEventSent(OrdPrintConst.CLEARDATAPREVIEW, null);
            if (e.PropName != null)
            {
                if (e.PropName.Equals("Page_num"))
                    isChangePage = true;
            }
        }
        #endregion

        #region 父类继承区域
        /// <summary>
        /// 状态监测
        /// </summary>
        public override void OnStatus()
        {
            bool enable = true;

            enable = this.dataSource.Id_en != null;
            this.SetEnable(UIEvent.PREVIEW, enable);//预览
            this.SetEnable(UIEvent.QUERY, enable);//查询
            //this.GetEnable(UIEvent.QUERY);


            this.SetEnable(UIEvent.EDIT, false);//设置
            this.SetEnable(OrdPrintConst.ORDERACTION, true);//医嘱单
            this.SetEnable(OrdPrintConst.LONGACTION, true);//长期医嘱单
            this.SetEnable(OrdPrintConst.TEMPACTION, true);//临时医嘱单
            
        }

        /// <summary>
        /// 获取控件相关的数据
        /// </summary>
        protected override void OnLoadData()
        {
            if (this.Context["PatientData"] != null)
            {
                BannerData bannerData = this.Context["PatientData"] as BannerData;
                if (bannerData.Ent4BannerDTO != null)
                {
                    dataSource.Id_en = bannerData.Ent4BannerDTO.Id_ent;
                    dataSource.Code_pat_en = bannerData.Ent4BannerDTO.Code_ent;
                    dataSource.Name_pat_en = bannerData.Ent4BannerDTO.Name_pat;
                    dataSource.Id_pat = bannerData.Ent4BannerDTO.Id_pat;
                    dataSource.Id_entp = bannerData.Ent4BannerDTO.Id_entp;
                    dataSource.Code_entp = bannerData.Ent4BannerDTO.Code_entp;
                    dataSource.Id_dep_phy = bannerData.Ent4BannerDTO.Id_dep_phy;
                    dataSource.Name_dep_phy = bannerData.Ent4BannerDTO.Name_dep_phy;
                    dataSource.Id_dep_nur = bannerData.Ent4BannerDTO.Id_dep_nur;
                    dataSource.Name_dep_nur = bannerData.Ent4BannerDTO.Name_dep_nur;
                    dataSource.Code_amr_ip = bannerData.Ent4BannerDTO.Code_amr_ip;
                }
                else
                {
                    this.ShowInfo("未接收到患者信息！");
                }
            }
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = this.Context["PatientData"] != null ? CiOrdBillFormTmplConst.CIORD_IP_OrdPrintToolView_1/*"20160808020419088MQ3"*/ : CiOrdBillFormTmplConst.CIORD_IP_OrdPrintToolView_2/*"20170410103155861000"*/;
            
            file.FormStyle = FormStyle.Card;
            file.ViewModel = dataSource;
            this.xapFormControl1.ViewFile = file;
            this.xapFormControl1.Refresh();
        }
        #endregion

        #region 辅助处理区域
        /// <summary>
        /// 长临状态改变响应事件
        /// </summary>
        /// <param name="isLong"></param>
        private void onOrderChanged(bool isLong)
        {
            xTabPage.Text = isLong ? "长期医嘱单" : "临时医嘱单";
            radioStop.Enabled = isLong;//置灰停止打印
            radioSetup.Enabled = isLong;//置灰重整打印
            //默认选中一般续打场景
            radioCancel.Checked = false;
            radioSetup.Checked = false;
            radioSingle.Checked = false;
            radioStop.Checked = false;
            radioContinue.Checked = true;

            dataSource.Id_orprn = OrdPrintConst.PRINT_MODE_CONTINUE;
            this.userRenderPage.Enabled = false;//页码下拉框置灰
            //置空患者、页号
            if (this.Context["PatientData"] == null)
            {
                //dataSource.Id_en = null;
                //dataSource.Code_pat_en = null;
                //dataSource.Name_pat_en = null;
                //dataSource.Id_pat = null;
                //dataSource.Id_entp = null;
                //dataSource.Code_entp = null;
                //dataSource.Id_dep_phy = null;
                //dataSource.Id_dep_nur = null;
                //dataSource.Code_amr_ip = null;
                //dataSource.Name_dep_phy = null;
                //dataSource.Name_dep_nur = null;
                //dataSource.Code_amr_ip = null;
                //dataSource.Code_pat = null;
                //dataSource.Name_pat = null;
            }
            dataSource.Page_num = null;
            //更换长临状态
            dataSource.Fg_long = isLong;

            onFireEventSent(OrdPrintConst.ONLONGTEMPCHANGE, dataSource);
        }

        /// <summary>
        /// 打印场景变换响应，页码
        /// </summary>
        /// <param name="bShow"></param>
        private void onRadioCheckChanged(bool bShow)
        {
            this.userRenderPage.Enabled = bShow;//页码下拉框是否可用
        }

        /// <summary>
        /// 发送事件
        /// </summary>
        /// <param name="strCommond"></param>
        /// <param name="sender"></param>
        private void onFireEventSent(string strCommond, object sender)
        {
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, strCommond);
            this.FireEventSent(sender, args);
        }

        /// <summary>
        /// 获取当前打印场景
        /// </summary>
        private void getPrintMode()
        {
            for (int i = 0; i < radioGroup.Renders.Count; i++)
            {
                if ((radioGroup.Renders[i] as XRadiobox).Checked)
                    dataSource.Id_orprn = (i + 1).ToString();
            }
        }
        #endregion

        #region 状态处理区域
        /// <summary>
        /// 接收响应事件发送
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="eventArgs"></param>
        public override void HandleState(object sender, xap.rui.engine.DictionaryEventArgs e)
        {
            string uiEvent = e.Data[UIConst.UI_EVENT] as string;
            switch (uiEvent)
            {
                case OrdPrintConst.LONGACTION:
                    onOrderChanged(true);//长期医嘱
                    break;
                case OrdPrintConst.TEMPACTION:
                    onOrderChanged(false);//临时医嘱
                    break;
                case UIEvent.PREVIEW:
                    getPrintMode();
                    onFireEventSent(OrdPrintConst.DOPREVIEW, dataSource);//预览，传递参数
                    break;
                case UIEvent.PRINT:
                    onFireEventSent(OrdPrintConst.DOPRINT, dataSource);//打印，传递参数
                    break;
                case UIEvent.EDIT:
                    break;
                case UIEvent.REFRESH:
                    onFireEventSent(OrdPrintConst.DOSORT, dataSource);//调整
                    break;
                case UIEvent.QUERY:
                    dataSource.Id_orprn = OrdPrintConst.PRINT_MODE_ALLBROWSE;
                    onFireEventSent(OrdPrintConst.DOPREVIEW, dataSource);//查询
                    break;
                case UIEvent.DELETE:
                    onFireEventSent(OrdPrintConst.DOCLEAR, dataSource);//清空
                    break;
                default:
                    break;
            }
        }
        #endregion

    }
}

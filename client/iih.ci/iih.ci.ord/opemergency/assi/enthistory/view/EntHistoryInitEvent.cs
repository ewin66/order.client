
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using xap.cli.sdk.controls;
using iih.ci.ord.opemergency.assi.enthistory.viewmodel;
using xap.rui.engine.eventbroker;
using xap.rui.engine;
using iih.ci.diag.cidiag.d;
using xap.rui.control.basecontrol;
using xap.rui.bizcontrol.bannercontrol;
using xap.cli.sdk.form;
using System.Windows.Forms;
using System.Drawing;
using iih.ci.diag.dto.d;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.moreemsdto.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.opemergency.assi.asscommon.viewmodel;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.rui.bizcontrol.bannerview;
using iih.ci.ord.common.utils.msg;
using iih.ci.ord.opemergency.declare;

namespace iih.ci.ord.opemergency.assi.enthistory.view
{
    /// <summary>
    /// <para>描    述 : 就诊历史初始化类 </para>
    /// <para>说    明 :  初始化就诊历史界面，以及就诊历史与病历门诊的交互类</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.entphistory    </para>    
    /// <para>类 名 称 :  EntpHistoryInit </para> 
    /// <para>版 本 号 :  v1.0.0.0 </para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/7/14 11:00:39 </para>
    /// <para>更新时间 :  2016/7/14 11:00:39 </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EntHistoryInitEvent : EntHistoryBase
    {

        #region 变量定义区域



        /// <summary>
        /// 辅助录入显示相对应的父控件
        /// </summary>
        private XBaseControl xBaseCtrl = null;

        /// <summary>
        /// 辅助录入助手中返回的数据来源于发送事件的对应关系
        /// </summary>
        private Dictionary<string, string> eventDic = new Dictionary<string, string> {
            {"OutpMr","lsPhase"},// 门诊病历
            {"OpCiDiag","OpCiDiag"}, // 门诊诊断        
            {"IpCidiag","IpCidiag"}, // 住院诊断
            {"OpOrderItem","OpOrderItem"}, // 门诊医嘱
            {"IpOrderItem","IpOrderItem"}  // 住院医嘱
        };

        /// <summary>
        /// 诊断接口
        /// </summary>
        private CiDiagViewModel model;

        /// <summary>
        /// 诊断保存成功事件
        /// </summary>
        private const String EVENT_ORDI_SAVESUCCE = "event_ordi_save_successful";





        #endregion

        #region 构造函数区域

        public EntHistoryInitEvent()
        {
            InitializeComponent();
        }

        public EntHistoryInitEvent(IContainer container)
        {
            container.Add(this);

            InitializeComponent();
        }

        #endregion

        #region 公开属性区域

        /// <summary>
        /// 就诊历史展现窗口
        /// </summary>
        private EntHistoryFrame entpHistoryFrame;
        public EntHistoryFrame EntpHistoryFrame
        {
            set
            {
                entpHistoryFrame = value;
            }
        }

        /// <summary>
        /// 缓存就诊历史页面是否打开
        /// </summary>
        private bool isEntHistoryFrameOpen;
        public bool IsEntHistoryFrameOpen
        {
            set
            {
                isEntHistoryFrameOpen = value;
            }
        }

        #endregion

        #region 命令定义区域

        #endregion

        #region 事件发送区域

        /// <summary>
        /// 发送回写病历事件 到EmrEditorInitEvent 
        /// </summary>
        /// <param name="obj">事件发出者</param>
        /// <param name="dataObj">发送给病历的数据</param>
        protected void FireMrWriteBackBizEvent(object dataObj)
        {
            if (dataObj == null)
            {
                return;
            }
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, AssistantConstant.CI_EMR_WRITE_BACK_EVENT);

            Dictionary<string, object> dataDic = new Dictionary<string, object>();
            // 病历的段落回写返回数据key值固定是lsPhase
            dataDic.Add(AssistantConstant.CI_EMR_WRITE_BACK_DATA, dataObj);

            args.Data.Add(UIConst.DATA, dataDic);
            this.FireEventSent(this, args);
        }
        /// <summary>
        /// 诊断保存事件
        /// </summary>
        [EventPublication("FireCiDISaveEvent")]
        public event EventHandler<DataEventArgs<List<CiDiagItemDO>>> FireCiDISaveEvent;
        private void fireCiDISaveEvent(object obj)
        {
            List<CiDiagItemDO> cidiItemList = (List<CiDiagItemDO>)obj;

            DataEventArgs<List<CiDiagItemDO>> eventArgs = new DataEventArgs<List<CiDiagItemDO>>(cidiItemList);

            if (FireCiDISaveEvent != null)
                this.FireCiDISaveEvent(this, eventArgs);
        }

        /// <summary>
        /// 发送数处理选中数据事件
        /// </summary>
        /// <param name="args"></param>
        public void SaveSelResultEvent(Dictionary<string, object> result)
        {
            // 诊断保存的记录数，用于判断诊断是否保存成功
            int cidiSavedCnt = 0;
            // 诊断Agg对象，用于判断数据库中是否存在诊断
            CidiagAggDO cidiAgg = null;

            // 获取当前选择的历史就诊中是否包含诊断，如果不包含诊断查询数据库中是否存在诊断，如果不存在不允许保存病历、医嘱
            List<CiDiagItemDO> cidiItemList = null;
            Dictionary<string, object>.KeyCollection selItemKeys = result.Keys;

            if (selItemKeys.Contains(OP_CIDIAG))
            {
                cidiItemList = result[OP_CIDIAG] as List<CiDiagItemDO>;
            }
            else if (selItemKeys.Contains(IP_CIDIAG))
            {
                cidiItemList = result[IP_CIDIAG] as List<CiDiagItemDO>;
            }

            if (cidiItemList == null || cidiItemList.Count == 0)
            {// 就诊历史中未选择诊断，查询是否已经保存过诊断
                cidiAgg = model.GetCidiagAggDO(this.Ent4BannerDTO.Id_ent);
            }
            else
            {
                cidiSavedCnt = this.SaveCiDiag(cidiItemList);
                if (cidiSavedCnt == 0)
                {
                    MessageBoxEx.Show("调用就诊历史保存诊断失败，请联系信息中心！", "就诊历史", MessageBoxButtons.OK, MessageBoxIconEx.Error, MessageBoxDefaultButton.Button1);
                    return;
                }
            }

            // 诊断不为空时可以进行医嘱保存
            if (cidiSavedCnt == 0 && cidiAgg == null && selItemKeys.Contains(ORDER_ITEM) && result[ORDER_ITEM] != null)
            {
                BizAssMessageBoxUtil.ShowCidiIsNullMsg("就诊历史");
                return;
            }

            if (selItemKeys.Contains(ORDER_ITEM) && result[ORDER_ITEM] != null)
            {
                this.LoadCiEms(result[ORDER_ITEM]);
            }

            if (selItemKeys.Contains(OUTP_MR))
            {
                this.FireMrWriteBackBizEvent(result[OUTP_MR]);
            }

            if (entpHistoryFrame != null)
            {
                entpHistoryFrame.Close();
            }
        }

        #endregion

        #region 事件接收区域

        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取banner信息患者
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public override void OnSelected(object sender, TargetEventArgs e)
        {
            bannerOpdocstation banner = sender as bannerOpdocstation;
            if (banner != null)
            {
                BannerData bannerData = e.Object as BannerData;
                if (bannerData != null && bannerData.Ent4BannerDTO != null)
                {
                    this.Ent4BannerDTO = bannerData.Ent4BannerDTO;

                    if (model == null)
                    {
                        model = new CiDiagViewModel(this.Context);
                    }
                }
                else
                {
                    this.Ent4BannerDTO = null;
                }

            }


        }

        #endregion

        #region 子类继承区

        /// <summary>
        /// 设置辅助录入显示相对应的父窗体
        /// </summary>
        /// <returns></returns>
        protected virtual XBaseControl getParentCtrl()
        {
            string classId = "OrdListView";

            try
            {
                XapBaseControl xapListCtrl = this.Context.Config.GetInstance(classId) as XapBaseControl;

                if (xapListCtrl != null)
                {
                    this.xBaseCtrl = xapListCtrl.Parent as XBaseControl;
                }
            }
            catch (Exception)
            {
                MessageBoxEx.Show("在路径[\\modules\\iihci\\ui\\optrdocstation]的配置文件中未能找到id为[" + classId + "]的类！", "就诊历史", MessageBoxButtons.OK, MessageBoxIconEx.Error, MessageBoxDefaultButton.Button1);
            }
            return xBaseCtrl;
        }


        /// <summary>
        /// 获取当前显示窗口的位置
        /// <para>子类根据实际需求设定显示的位置</para>
        /// </summary>
        /// <returns></returns>
        protected virtual Point getLocation()
        {
            if (xBaseCtrl != null)
            {
                return xBaseCtrl.PointToScreen(new Point(0, 0));
            }
            else
            {
                int width = SystemInformation.WorkingArea.Width;
                int height = SystemInformation.WorkingArea.Height;
                return new Point(width / 2, 80);
            }
        }

        /// <summary>
        /// 获取辅助录入显示的尺寸
        /// <para>子类根据实际需求设定显示的尺寸</para>
        /// </summary>
        /// <returns></returns>
        protected virtual Size getSize()
        {
            if (xBaseCtrl != null)
            {
                return xBaseCtrl.Size;
            }
            else
            {
                int width = SystemInformation.WorkingArea.Width;
                int height = SystemInformation.WorkingArea.Height;
                return new System.Drawing.Size(width / 2, height - 80);
            }
        }

        #endregion

        #region 内部事件区域

        #endregion

        #region 辅助处理函数

        private void loadEntpHistory()
        {
            if (BizAssMessageBoxUtil.ShowPatIsNullMsg(this.Ent4BannerDTO, "就诊历史"))
            {
                return;
            }
            if (isEntHistoryFrameOpen)
            {
                return;
            }
            entpHistoryFrame = new EntHistoryFrame();
            entpHistoryFrame.BannerDTO = this.Ent4BannerDTO;
            entpHistoryFrame.BaseContext = this.Context;


            this.getParentCtrl();
            entpHistoryFrame.StartPosition = FormStartPosition.Manual;

            entpHistoryFrame.Location = this.getLocation();
            entpHistoryFrame.Size = this.getSize();
            entpHistoryFrame.BannerDTO = this.Ent4BannerDTO;
            entpHistoryFrame.EntHistoryInitEvent = this;
            isEntHistoryFrameOpen = true; // 记录窗口打开状态
            entpHistoryFrame.Show(this.xBaseCtrl);
        }

        /// <summary>
        /// 保存诊断
        /// </summary>
        /// <param name="obj"></param>
        private int SaveCiDiag(List<CiDiagItemDO> cidiItemList)
        {
            DIDTO[] didtos = null;

            if (cidiItemList != null && cidiItemList.Count > 0)
            {
                didtos = this.model.SaveCiDiagItemDOs(this.Ent4BannerDTO, cidiItemList);
                if (didtos != null && didtos.Length > 0)
                {
                    //发送诊断保存成功事件
                    AssToolEx.SentMessage(this, EventCodeType.EVENT_ORDI_SAVESUCCE, "DIDTOLIST", new List<DIDTO>(didtos));
                    return didtos.Length;
                }
            }

            return 0;
        }

        /// <summary>
        /// 保存医嘱，保存失败的医嘱转发给医疗单处理
        /// </summary>
        /// <param name="obj"></param>
        private void LoadCiEms(object obj)
        {

            CiOrderDO[] ciorders = (CiOrderDO[])obj;
            if (ciorders != null && ciorders.Length > 0)
            {
                string[] idOrs = new string[ciorders.Length];

                for (int i = 0; i < ciorders.Length; i++)
                {
                    idOrs[i] = ciorders[i].Id_or;
                }

                CiOrdViewModel ciordModel = new CiOrdViewModel(this.Ent4BannerDTO, this.Context);
                MoreEmsParamDTO moreEmsDto = ciordModel.GetMoreEmsParam(idOrs);

                AssToolEx.SentMessage(this, EventCodeType.EVENT_EMS_TMPL_EDIT, EventCodeType.ARGKEY_EMS_TMPL_EDIT, moreEmsDto);
            }
        }

        #endregion

        #region 状态处理区域

        /// <summary>
        /// 事件状态处理方法
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public override void HandleState(object sender, DictionaryEventArgs e)
        {
            // 获取时间烈性
            string uiEvent = e.Data[UIConst.UI_EVENT] as string;
            string newState = e.Data[UIConst.NEW_STATE] as string;

            // 获取事件参数列表
            Dictionary<string, Object> dict = e.Data[UIConst.DATA] as Dictionary<string, Object>;

            switch (uiEvent)
            {
                case "BannerSiteClickEvent": // bannner中按钮点击事件
                    if (dict.ContainsKey("obj"))
                    {
                        if ("entp_history".Equals(dict["obj"]))
                        {
                            loadEntpHistory();
                        }
                    }
                    break;               
                default:
                    break;

            }
        }
        #endregion
    }
}

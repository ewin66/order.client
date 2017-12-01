
using iih.bd.bc.udi;
using iih.bd.srv.ems.d;
using iih.ci.diag.cidiag.d;
using iih.ci.ord.common.utils;
using iih.ci.ord.ems.d;
using iih.ci.ord.opemergency.assi.asscommon.dto;
using iih.ci.ord.opemergency.assi.asscommon.view;
using iih.ci.ord.opemergency.assi.enthistory.view;
using iih.ci.ord.opemergency.assi.enthistory.viewmodel;
using System;
using System.Collections.Generic;
using iih.ci.ord.moreemsdto.d;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.tool;
using xap.cli.sdk.controls;
using xap.rui.engine;
using xap.rui.engine.xactions;
using iih.ci.ord.common.utils.msg;
using xap.cli.sdk.common;
using xap.rui.engine.container;
using xap.rui.control.basecontrol;
using iih.ci.ord.opemergency.declare;
using xap.rui.control.extentions;
using iih.ci.ord.opemergency.ems.common;
using xap.rui.bizcontrol.bannerview;
using iih.ci.ord.opemergency.orddi;
using iih.ci.ord.opemergency.view;

namespace iih.ci.ord.opemergency.assi.assistantinit
{
    /// <summary>
    /// <para>描    述 :  </para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.assistantinit</para>    
    /// <para>类 名 称 :  AssButtonOpView</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/12/15 11:30:05</para>
    /// <para>更新时间 :  2016/12/15 11:30:05</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class AssButtonOpView : AssistantBtnBaseView
    {
        /// <summary>
        /// 点击快捷键触发对应的按钮点击事件
        /// </summary>
        private Dictionary<string, AssiBtnDTO> shortCutKeyDic = new Dictionary<string, AssiBtnDTO>();

        /// <summary>
        /// 弹出窗口位置，与父页面中显示对应位置的
        /// </summary>
        private Dictionary<AssiFrameLocation, string> parentXBaseCtrlIdDic = new Dictionary<AssiFrameLocation, string>() {
            { AssiFrameLocation.LEFT,"layoutPanelLeft"},//EntDiStatusView
            { AssiFrameLocation.RIGHT,"layoutPanelRight"},//OrdListView
            { AssiFrameLocation.RIGHT_DIALOG,"layoutPanelRight"}
        };

        /// <summary>
        /// 初始化助手窗口中需要的个性化参数（门诊住院加入各自特定的参数）
        /// </summary>
        private Dictionary<string, object> CustomParamDic = null;

        // 诊断相关接口
        private CiDiagViewModel cidiViewModel;

        public AssButtonOpView()
        {
            // cidiViewModel构造函数是传当前环境，BaseContext,由于获取诊断不需要当前环境，可以设置为空
            this.cidiViewModel = new CiDiagViewModel(null);
        }

        /// <summary>
        /// 医嘱模板 医技常规 服务分类 的事件
        /// </summary>
        /// <param name="moreEmsDto"></param>
        public void FireEventSent(MoreEmsParamDTO moreEmsDto)
        {
            AssToolEx.SentMessage(this, EventCodeType.EVENT_EMS_TMPL_EDIT, EventCodeType.ARGKEY_EMS_TMPL_EDIT, moreEmsDto);
        }

        /// <summary>
        /// 获取显示的按钮组
        /// </summary>
        /// <returns>显示的按钮组集合，Dictionary 内容 key：btn名称</returns>
        protected override List<Dictionary<string, AssiBtnDTO>> GetDispalyBtnGroup()
        {

            List<Dictionary<string, AssiBtnDTO>> btnGrpList = new List<Dictionary<string, AssiBtnDTO>>();

            Dictionary<string, AssiBtnDTO> leftBtnDic = new Dictionary<string, AssiBtnDTO>();
            Dictionary<string, AssiBtnDTO> rightBtnDic = new Dictionary<string, AssiBtnDTO>();
            Dictionary<string, AssiBtnDTO> rightDialogBtnDic = new Dictionary<string, AssiBtnDTO>();
            Dictionary<string, AssiBtnDTO> rightBtnDiDic = new Dictionary<string, AssiBtnDTO>();

            btnGrpList.Add(rightDialogBtnDic);
            btnGrpList.Add(rightBtnDic);
            btnGrpList.Add(leftBtnDic);
            btnGrpList.Add(rightBtnDiDic);

            // PanelManger的id，显示不同PanelManger下的XTabPage需要指定id属性
            // 右侧弹出对话框的的PanelMangerId属性值
            string rightDialogPanelManger = "rightDialogPanelManger";
            // 右侧弹出Form形式的的PanelMangerId属性值
            string rightPanelManger = "rightPanelManger";
            string rightPanelMangerDi = "rightPanelMangerDi";
            // 左侧弹出Form形式的的PanelMangerId属性值
            string leftPanelManger = "leftPanelManger";


            // 就诊历史门诊组套
            AssiBtnDTO btn10 = new AssiBtnDTO();
            btn10.ButtonId = "btnEntHistoryTabFrame";
            btn10.Text = "历史";
            btn10.ViewClassId = "EntHistoryTabFrame";
            btn10.PanelManagerId = rightDialogPanelManger;
            btn10.XTabPageId = "EntHistoryTabFrame";
            btn10.FrameLocation = AssiFrameLocation.RIGHT;
            btn10.OpenFrameModel = AssiFrameOpenModel.SHOW_DIALOG;
            rightDialogBtnDic.Add(btn10.ButtonId, btn10);
            shortCutKeyDic.Add("ShortcutOpEntpHistory", btn10);//快捷键


            AssiBtnDTO btn11 = new AssiBtnDTO();
            btn11.ButtonId = "btnMkrMsAppView";
            btn11.Text = "门诊组套";
            btn11.ViewClassId = "MkrMsAppView";
            btn11.PanelManagerId = rightDialogPanelManger;
            btn11.XTabPageId = "MkrMsAppView";
            btn11.FrameLocation = AssiFrameLocation.RIGHT;
            btn11.OpenFrameModel = AssiFrameOpenModel.SHOW_DIALOG;
            rightDialogBtnDic.Add(btn11.ButtonId, btn11);
            shortCutKeyDic.Add("ShortcutOpMedclingrpApp", btn11);//快捷键


            // 病历模板、个人知识库
            AssiBtnDTO btn30 = new AssiBtnDTO();
            btn30.ButtonId = "btnTplView";
            btn30.Text = "病历模板";
            btn30.ViewClassId = "TplView";
            btn30.PanelManagerId = rightPanelManger;
            btn30.XTabPageId = "TplView";
            btn30.FrameLocation = AssiFrameLocation.RIGHT;
            btn30.OpenFrameModel = AssiFrameOpenModel.SHOW;
            rightBtnDic.Add(btn30.ButtonId, btn30);
            shortCutKeyDic.Add("ShortcutOpTplcommand", btn30);//快捷键


            AssiBtnDTO btn31 = new AssiBtnDTO();
            btn31.ButtonId = "btnKnowledgeFormView";
            btn31.Text = "个人知识库";
            btn31.TipText = "个人知识库";
            btn31.ViewClassId = "KnowledgeFormView";
            btn31.PanelManagerId = rightPanelManger;
            btn31.XTabPageId = "KnowledgeFormView";
            btn31.FrameLocation = AssiFrameLocation.RIGHT;
            btn31.OpenFrameModel = AssiFrameOpenModel.SHOW;
            rightBtnDic.Add(btn31.ButtonId, btn31);
            shortCutKeyDic.Add("ShortcutKnowledgeFormView", btn31);//快捷键



            // 医嘱模板、以及常规、服务分类
            AssiBtnDTO btn50 = new AssiBtnDTO();
            btn50.ButtonId = "btnOpTemplateFrame";
            btn50.Text = "医嘱模板";
            btn50.ViewClassId = "OpTemplateFrame";
            btn50.PanelManagerId = leftPanelManger;
            btn50.XTabPageId = "OpTemplateFrame";
            btn50.FrameLocation = AssiFrameLocation.LEFT;
            btn50.OpenFrameModel = AssiFrameOpenModel.SHOW;
            leftBtnDic.Add(btn50.ButtonId, btn50);
            shortCutKeyDic.Add("ShortcutOpOrdTemplat", btn50);//快捷键


            AssiBtnDTO btn51 = new AssiBtnDTO();
            btn51.ButtonId = "btnOpMedicalTechnology";
            btn51.Text = "医技常规";
            btn51.ViewClassId = "OpMedicalTechnology";
            btn51.PanelManagerId = leftPanelManger;
            btn51.XTabPageId = "OpMedicalTechnology";
            btn51.FrameLocation = AssiFrameLocation.LEFT;
            btn51.OpenFrameModel = AssiFrameOpenModel.SHOW;
            leftBtnDic.Add(btn51.ButtonId, btn51);
            shortCutKeyDic.Add("ShortcutOpMedicalTechmology", btn51);//快捷键

            AssiBtnDTO btn52 = new AssiBtnDTO();
            btn52.ButtonId = "btnMedSrv";
            btn52.Text = "服务分类";
            btn52.ViewClassId = "MedSrv";
            btn52.PanelManagerId = leftPanelManger;
            btn52.XTabPageId = "MedSrv";
            btn52.FrameLocation = AssiFrameLocation.LEFT;
            btn52.OpenFrameModel = AssiFrameOpenModel.SHOW;
            leftBtnDic.Add(btn52.ButtonId, btn52);
            shortCutKeyDic.Add("ShortcutOpMedSrvCatg", btn52);//快捷键

            AssiBtnDTO btn60 = new AssiBtnDTO();
            btn60.ButtonId = "btnDiagDef";
            btn60.Text = "接诊";
            btn60.ViewClassId = "DiagDef";
            btn60.PanelManagerId = rightPanelMangerDi;
            btn60.XTabPageId = "DiagDef";
            btn60.FrameLocation = AssiFrameLocation.RIGHT;
            btn60.OpenFrameModel = AssiFrameOpenModel.SHOW;
            if (RelativeUIParam.RELATIVERATIO > RelativeUIParam.TEMPLETECHANGEDRATIO)
                rightBtnDiDic.Add(btn60.ButtonId, btn60);
            //shortCutKeyDic.Add("ShortcutDiagDef", btn60);//快捷键

            return btnGrpList;
        }

        /// <summary>
        /// 获取父窗口对象
        /// </summary>
        /// <param name="frameLocation"></param>
        /// <returns></returns>
        protected override XBaseControl getParentCtrl(AssiFrameLocation frameLocation)
        {
            string classId = null;
            if (parentXBaseCtrlIdDic.ContainsKey(frameLocation))
            {
                classId = parentXBaseCtrlIdDic[frameLocation];
            }

            if (classId == null)
            {
                BizAssMessageBoxUtil.ShowWarningMsg("不存在与对象AssiFrameLocation[" + frameLocation + "]匹配的值");
                return null;
            }

            return this.getXapBaseCtrl(classId);
        }

        private XBaseControl getXapBaseCtrl(string classId) {

            if (classId == null)
            {
                BizAssMessageBoxUtil.ShowWarningMsg("不存在classId为["+ classId + "]的对象");
                return null;
            }

            try
            {
                XBaseControl xbaseControl = this.Context.Config.GetInstance(classId) as XBaseControl;

                if (xbaseControl != null)
                {
                    return xbaseControl;
                }
            }
            catch (Exception)
            {
                BizAssMessageBoxUtil.ShowWarningMsg("在路径[\\modules\\iihci\\ui\\optrdocstation]的配置文件中未能找到id为[" + classId + "]的类！");
            }

            return null;
        }

        /// <summary>
        /// 指定鼠标点击范围，确定是否需要关闭辅助录入组件
        /// </summary>
        /// <returns>鼠标点击不关闭辅助录入的区域view</returns>
        protected override List<XBaseControl> getMouseInXBaseCtrlList(AssiBtnDTO btnDTO)
        {
            //emrView 为门诊左侧病历区域在配置文件optrdocstation_config.xml中配置的classId
            // <Clazz id="emrView" classname="iih.ci.mr_pub.view.PubMrWriteableCardView" dllname="iih.ci.mr_pub"/>

            if (btnDTO.OpenFrameModel == AssiFrameOpenModel.SHOW_DIALOG) {
                return null;
            }

            List<XBaseControl> xapBaseCtrlList = new List<XBaseControl>();
            
            foreach(AssiFrameLocation assiFramLocation in parentXBaseCtrlIdDic.Keys) {
                string s = parentXBaseCtrlIdDic[assiFramLocation];
                XBaseControl xbaseCtrl = this.getParentCtrl(assiFramLocation);
                
                if (xbaseCtrl != null && !xapBaseCtrlList.Contains(xbaseCtrl)) {
                    xapBaseCtrlList.Add(xbaseCtrl);
                }                
            }

            XBaseControl assBttonView = this.getXapBaseCtrl("AssButtonOpView");
            xapBaseCtrlList.Add(assBttonView);

            return xapBaseCtrlList;
        }

        /// <summary>
        /// 获取显示位置
        /// </summary>
        /// <returns></returns>
        //protected override Point GetFrameLocation()
        //{
        //    return new Point();
        //}

        /// <summary>
        /// 获取弹出窗口的尺寸
        /// </summary>
        /// <returns></returns>
        //protected override Size GetFrameSize()
        //{
        //    return new Size();
        //}

        /// <summary>
        /// 获取调弹出窗口对应的配置文件
        /// </summary>
        /// <returns>配置文件集合，key </returns>
        protected override Dictionary<AssiFrameLocation, string> GetDisplayCfgXmlDic()
        {
            Dictionary<AssiFrameLocation, string> configPathDic = new Dictionary<AssiFrameLocation, string>() {

                { AssiFrameLocation.LEFT,"modules\\iihci\\ui\\optrdocstation\\assi\\assi_left_config.xml"},
                { AssiFrameLocation.RIGHT,"modules\\iihci\\ui\\optrdocstation\\assi\\assi_right_config.xml"},
                 { AssiFrameLocation.RIGHT_DIALOG,"modules\\iihci\\ui\\optrdocstation\\assi\\assi_right_diag_config.xml"}
            };

            return configPathDic;
        }

        /// <summary>
        /// 获取个性化参数
        /// </summary>
        /// <returns></returns>
        protected override Dictionary<string, object> GetCustomParmDic()
        {
            if (CustomParamDic == null)
            {
                CustomParamDic = new Dictionary<string, object>();
                // 就诊历史使用的事件发送对象
                ConfigFactory config = this.Context.Config;
                EntHistoryInitEvent entHistoryInitEvent = config.GetInstance("EntHistoryInitEvent") as EntHistoryInitEvent;
                CustomParamDic.Add("entHistoryInitEvent", entHistoryInitEvent);
                // 术语辅助录入使用的事件发送对象
                XapBaseControl emrTermEvent = config.GetInstance("ciorderEmrTermEvent") as XapBaseControl;
                CustomParamDic.Add("emrTermEvent", emrTermEvent);

                CustomParamDic.Add("AssButtonOpView", this);

                // 就诊上下文环境
                CiEnContextDTO ciEnContextDTO = CiEnContextUtil.GetCiEnContext(this.ent4BannerDTO, EmsAppModeEnum.SVEMSAPPMODE, this.Context);
                CustomParamDic.Add("ciEnContextDTO", ciEnContextDTO);
            }

            return CustomParamDic;
        }

        /// <summary>
        /// 设置当前环境属性
        /// </summary>
        /// <param name="envinfo"></param>
        protected override void SetCustomCiEnContext(CiEnContextDTO ciEnContext)
        {
            // 门诊使用简洁医疗单
            ciEnContext.Emsappmode = (int)EmsAppModeEnum.SVEMSAPPMODE;
        }

        /// <summary>
        /// 弹出助手窗口前的判断，确定是否弹出窗口
        /// </summary>
        /// <returns></returns>
        protected override bool IsAllowOpenAssiFrameValidate(AssiBtnDTO btnDTO)
        {
            // 1.患者信息为空 
            if (BizAssMessageBoxUtil.ShowPatIsNullMsg(this.ent4BannerDTO, btnDTO.Text) == true)
            {
                return false;
            }
            // 就诊历史、组套不做校验
            if (btnDTO.ButtonId == "btnEntHistoryTabFrame" || btnDTO.ButtonId == "btnMkrMsAppView"){
                return true;
            }
            // 2.诊毕状态不允许操作
            if (IsEntCompleted())
            {
                return false;
            }

            // 病历模板、个人知识库不校验是否下诊断
            if (btnDTO.ButtonId == "btnTplView" || btnDTO.ButtonId == "btnKnowledgeFormView" || btnDTO.ButtonId == "btnDiagDef")
            {
                return true;
            }

            //  3.未下诊断 以上三种情况不允许点击助手按钮
            if (!IsWriteCiDi()) {
                return false;
            }

            return true;
        }

        /// <summary>
        /// 是否为诊毕状态，诊毕撤销模式时，诊毕状态不可操作
        /// </summary>
        /// <returns>true 诊毕，false 未诊毕 </returns>
        private bool IsEntCompleted()
        {
            // 如果患者本次就诊已诊毕，不能使用按钮中对应的功能
            if (EnDictCodeConst.SD_ENSTATUS_OP_FINISH.Equals(ent4BannerDTO.Sd_status))
            {
                BizAssMessageBoxUtil.ShowEnCompleteMsg();
                return true;
            }
            return false;

        }

        /// <summary>
        /// 检验是否填写诊断
        /// </summary>
        /// <param name="title">提示框标题</param>
        /// <returns></returns>
        private bool IsWriteCiDi(string title)
        {
            if (this.ent4BannerDTO == null || this.ent4BannerDTO.Id_ent == null)
            {
                BizAssMessageBoxUtil.ShowCidiIsNullMsg("患者信息为空");
                return false;
            }
            CidiagAggDO cidiAgg = cidiViewModel.GetCidiagAggDO(this.ent4BannerDTO.Id_ent);
            if (cidiAgg == null)
            {
                BizAssMessageBoxUtil.ShowCidiIsNullMsg(title);
                return false;
            }
            return true;
        }

        private bool IsWriteCiDi()
        {
            bool rst = true;
            //点击处置开立列表，判断诊断是否为空，诊断是否更改
            if (RelativeUIParam.RELATIVERATIO > RelativeUIParam.TEMPLETECHANGEDRATIO)
            {
                var DiListView = this.Context.Config.GetInstance("DiListView") as DiListView;
                if (null != DiListView)
                {
                    rst = DiListView.CheckDiEditable(true);
                }
            }
            else
            {
                var DiBannerView = this.Context.Config.GetInstance("DiBannerView") as DiBannerView;
                if (null != DiBannerView)
                {
                    rst = DiBannerView.CheckDiEditable();
                }
            }

            return rst;
        }


        /// <summary>
        /// 通过快捷方式打开助手页面
        /// </summary>
        /// <param name="shortCutUiEvent"></param>
        private void LoadAssiFrameByShortCut(string shortCutUiEvent)
        {
            // 确定当前触发的快捷键是否在当前助手快捷键集合中
            if (shortCutKeyDic.ContainsKey(shortCutUiEvent))
            {
                this.LoadAssiFrame(shortCutKeyDic[shortCutUiEvent]);
            }
        }

        public override void HandleState(object sender, DictionaryEventArgs e)
        {

            if (sender is XBroadcastAction)
            {
                XBroadcastAction xBroadCastAction = sender as XBroadcastAction;
                LoadAssiFrameByShortCut(xBroadCastAction.UiEvent);
            }
            string eventCode = AssToolEx.EventCodeOfEventArgs(e);
            switch (eventCode)
            {
                case EventCodeType.EVENT_ASSI_SHOW_ORDERTEMPLATE_OR_EDIT:
                    bool isShow = (bool)BaseEmsView.BaseEmsInfoContext["IsShowOphelperWhenOrOpen"];
                    if (isShow)
                    this.switchToPithy();
                    break;
            }
        }
    }
}

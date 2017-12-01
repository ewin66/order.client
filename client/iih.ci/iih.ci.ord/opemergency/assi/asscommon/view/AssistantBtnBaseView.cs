
using iih.bd.srv.ems.d;
using iih.ci.ord.common.utils;
using iih.ci.ord.ems.d;
using iih.ci.ord.opemergency.assi.asscommon.dto;
using iih.ci.ord.opemergency.assi.asscommon.util;
using iih.en.pv.dto.d;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.common;
using xap.cli.sdk.controls;
using xap.cli.sdk.form;
using xap.cli.sdk.render;
using xap.mw.log;
using xap.mw.serviceframework.ex;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.bizcontrol.bannerview;
using xap.rui.control.basecontrol;
using iih.ci.ord.opemergency.assi.entdi;
using xap.rui.engine;
using iih.ci.ord.opemergency.action.costant;
using iih.ci.ord.common.utils.msg;

namespace iih.ci.ord.opemergency.assi.asscommon.view
{
    /// <summary>
    /// <para>描    述 :  </para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.asscommon.view</para>    
    /// <para>类 名 称 :  AssistantBtnBaseView</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/12/15 11:15:19</para>
    /// <para>更新时间 :  2016/12/15 11:15:19</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class AssistantBtnBaseView : AssistantBase
    {

        #region 变量定义区域

        /// <summary>
        /// 助手弹出的外出窗口
        /// </summary>
        public AssiViewFrame assiViewFrame;

        protected Ent4BannerDTO ent4BannerDTO;

        private string imgBasePath = SkinFactory.Instance().CurrentSkin.SkinPath;// "D:\\xap\\门诊医生站ICON\\";

        /// <summary>
        /// 缓存已初始化的助手对象
        /// </summary>
        private Dictionary<AssiFrameLocation, XUserControl> cacheXUserControlDic = new Dictionary<AssiFrameLocation, XUserControl>();

        /// <summary>
        ///  XIconToolButton按钮集合，用于切换样式
        /// </summary>
        private List<XIconToolButton> xIconToolButtonsList = new List<XIconToolButton>();
        #endregion

        #region 构造函数区域

        public AssistantBtnBaseView()
        {
            this.Load += AssistantBtnBaseView_Load;
        }
        #endregion

        #region 父类类继承区域

        /// <summary>
        /// 切换患者时触发
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
                    this.ent4BannerDTO = bannerData.Ent4BannerDTO;
                    cacheXUserControlDic.Clear();
                }
                else
                {
                    if (bannerData == null)
                    {
                        LogManager.GetLogger().DebugEx("*******************bannerData == null ");
                    }
                    else if (bannerData.Ent4BannerDTO == null)
                    {
                        LogManager.GetLogger().DebugEx("*******************bannerData.Ent4BannerDTO == null ");
                    }

                    this.ent4BannerDTO = null;
                }
                if (this.assiViewFrame != null) {
                    this.assiViewFrame.Close();
                }
                if (diAssiForm != null)
                {
                    diAssiForm.Close();
                    diAssiForm = null;
                    isDiOpen = false;
                }
            }
        }

        #endregion

        #region 子类继承区域

        protected virtual void InitBtnGroup()
        {

            XVerticalToolBar xToolBar = new XVerticalToolBar(this);//父容器

            //xToolBar.ButtonsNumInGroup = 3;
            xToolBar.PaddingTop = 20;
            xToolBar.BackColor = Color.White;

            this.BackColor = Color.White;

            int tabIndex = 0;

            List<Dictionary<string, AssiBtnDTO>> btnGrpList = this.GetDispalyBtnGroup();
            int[] btnGrp = new int[btnGrpList.Count];
            for (int i = 0; i < btnGrpList.Count; i++)
            {
                Dictionary<string, AssiBtnDTO> btnDic = btnGrpList[i];
                btnGrp[i] = btnDic.Count;
                foreach (string key in btnDic.Keys)
                {
                    AssiBtnDTO btnDTO = btnDic[key];
                    XIconToolButton button = new XIconToolButton();
                    button.TabIndex = tabIndex++;
                    button.Text = btnDTO.Text;
                    button.ButtonId = btnDTO.ButtonId;
                    button.TipText = string.IsNullOrEmpty(btnDTO.TipText) ? btnDTO.Text : btnDTO.TipText;
                    if (btnDTO.ButtonId.Equals("btnDiagDef"))
                    {
                        button.TipText = "诊断";
                        button.MouseClick += btnDi_MouseClick;
                    }
                    else
                    {
                        button.MouseClick += Button_MouseClick;
                    }
                    button.ValueObj = btnDTO;
                    SetToolbarButtonImage(button, button.Text);
                    xToolBar.AddRender(button);
                    xIconToolButtonsList.Add(button);
                }
            }

            xToolBar.BtnsInGroupAry = btnGrp;
            xToolBar.Layout();
            this.AddRender(xToolBar);

            // 切换按钮样式事件
            SkinFactory.Instance().SkinChanged += AssistantBtnBaseView_SkinChanged;
        }

        /// <summary>
        /// 获取显示的按钮组
        /// </summary>
        /// <returns>显示的按钮组集合，Dictionary 内容 key：btn名称</returns>
        protected virtual List<Dictionary<string, AssiBtnDTO>> GetDispalyBtnGroup()
        {
            return null;
        }

        /// <summary>
        /// 弹出窗口的父页面
        /// </summary>
        /// <returns></returns>
        protected virtual XBaseControl getParentCtrl(AssiFrameLocation frameLocation)
        {
            return null;
        }

        /// <summary>
        /// 指定鼠标点击范围，确定是否需要关闭辅助录入组件
        /// </summary>
        /// <returns>组件id数组</returns>
        protected virtual List<XBaseControl> getMouseInXBaseCtrlList(AssiBtnDTO btnDTO)
        {
            return null;
        }

        /// <summary>
        /// 获取显示位置
        /// </summary>
        /// <returns></returns>
        protected virtual Point GetFrameLocation(XBaseControl xBaseCtrl)
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
        /// 获取弹出窗口的尺寸
        /// </summary>
        /// <returns></returns>
        protected virtual Size GetFrameSize(XBaseControl xBaseCtrl)
        {
            if (xBaseCtrl != null)
            {
                return xBaseCtrl.Size;
            }
            else
            {
                int width = SystemInformation.WorkingArea.Width;
                int height = SystemInformation.WorkingArea.Height;
                return new Size(width / 2, height - 80);
            }
        }

        /// <summary>
        /// 获取调弹出窗口对应的配置文件
        /// </summary>
        /// <returns>配置文件集合，key </returns>
        protected virtual Dictionary<AssiFrameLocation, string> GetDisplayCfgXmlDic()
        {
            return null;
        }

        /// <summary>
        /// 获取个性化参数
        /// </summary>
        /// <returns></returns>
        protected virtual Dictionary<string, object> GetCustomParmDic()
        {
            return null;
        }

        /// <summary>
        /// 设置当前环境属性
        /// </summary>
        /// <param name="envinfo"></param>
        protected virtual void SetCustomCiEnContext(CiEnContextDTO ciEnContext)
        {

        }

        /// <summary>
        /// 设置按钮图片
        /// </summary>
        /// <param name="path"></param>
        /// <param name="button"></param>
        /// <param name="imageName"></param>
        protected virtual void SetToolbarButtonImage(XIconToolButton button, String imageName)
        {

            if (this.imgBasePath == null) return;

            string imgPath = this.imgBasePath + "\\" + imageName;
            try
            {
                button.NormalImage = Image.FromFile(imgPath + "-1.png");
                button.HoverImage = Image.FromFile(imgPath + "-2.png");
                button.DownImage = Image.FromFile(imgPath + "-3.png");
                button.DisableImage = Image.FromFile(imgPath + "-4.png");
            }
            catch (Exception)
            {
                ErrorMsg msg = new ErrorMsg();
                msg.Message = "未获取到[" + imageName + "]对应的图片";
                throw new XapServiceException(msg);
            }
        }


        /// <summary>
        /// 是否允许打开弹出窗口
        /// </summary>
        /// <returns></returns>
        protected virtual bool IsAllowOpenAssiFrameValidate(AssiBtnDTO btnDTO)
        {
            return true;
        }

        /// <summary>
        /// 弹出窗口关闭触发
        /// </summary>
        public void AssiViewFrameClosed()
        {
            this.assiViewFrame = null;
        }

        #endregion

        #region 内部事件区域
        /// <summary>
        /// 按钮辅助区加载事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void AssistantBtnBaseView_Load(object sender, EventArgs e)
        {
            this.InitBtnGroup();
        }

        /// <summary>
        /// 点击助手按钮事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void Button_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            XIconToolButton btn = sender as XIconToolButton;
            AssiBtnDTO btnDTO = btn.ValueObj as AssiBtnDTO;
            this.LoadAssiFrame(btnDTO);
        }

        private EntDiAssiForm diAssiForm;
        private bool isDiOpen;
        private void btnDi_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            XIconToolButton btn = sender as XIconToolButton;
            AssiBtnDTO btnDTO = btn.ValueObj as AssiBtnDTO;
            if (!IsAllowOpenAssiFrameValidate(btnDTO))
            {
                if (assiViewFrame != null)
                {
                    assiViewFrame.Close();
                }
                return;
            }

            if (assiViewFrame != null)
            {
                assiViewFrame.Close();
            }
            XBaseControl xBaseCtrl = this.getParentCtrl(btnDTO.FrameLocation);
            if (!isDiOpen)
            {
                diAssiForm = new EntDiAssiForm(this.Context);
                diAssiForm.Size = GetFrameSize(xBaseCtrl);
                diAssiForm.Location = GetFrameLocation(xBaseCtrl);
                diAssiForm.delegateHelper += getDOsFromHelp;
                diAssiForm.FormClosed += new FormClosedEventHandler(diAssiForm_FormClosed);
                isDiOpen = true;
                diAssiForm.Show(xBaseCtrl);
            }
        }

        private void diAssiForm_FormClosed(object sender, FormClosedEventArgs e)
        {
            isDiOpen = false;
        }

        /// <summary>
        /// 按钮样式切换事件
        /// </summary>
        private void AssistantBtnBaseView_SkinChanged()
        {
            imgBasePath = SkinFactory.Instance().CurrentSkin.SkinPath;
            foreach (XIconToolButton xIconToolButton in xIconToolButtonsList)
            {
                SetToolbarButtonImage(xIconToolButton, xIconToolButton.Text);
            }
        }
        #endregion

        #region 辅助处理函数

        /// <summary>
        ///调用打开助手窗口
        /// </summary>
        /// <param name="btnDTO">按钮参数</param>
        protected void LoadAssiFrame(AssiBtnDTO btnDTO)
        {

            if (!IsAllowOpenAssiFrameValidate(btnDTO))
            {
                if (assiViewFrame != null)
                {
                    assiViewFrame.Close();
                }
                return;
            }

            XBaseControl xBaseCtrl = this.getParentCtrl(btnDTO.FrameLocation);

            if (diAssiForm != null)
            {
                diAssiForm.Close();
                diAssiForm = null;
                isDiOpen = false;
            }

            // 如果窗口已经打开，点击按钮时只进行tab页签间的切换
            if (assiViewFrame == null || (assiViewFrame.FrameLocation != btnDTO.FrameLocation || assiViewFrame.FrameOpenModel != btnDTO.OpenFrameModel) && assiViewFrame.IsFrameOpened)
            {
                if (assiViewFrame != null)
                {
                    assiViewFrame.Close();
                }

                assiViewFrame = new AssiViewFrame();
                assiViewFrame.assistantBtnBaseView = this;
                assiViewFrame.FrameLocation = btnDTO.FrameLocation;
                assiViewFrame.FrameOpenModel = btnDTO.OpenFrameModel;
                // 设置鼠标点击时，不需要关闭辅助录入的组件，除此之外都关闭辅助录入
                assiViewFrame.MouseInXBaseCtrlList = this.getMouseInXBaseCtrlList(btnDTO);

                //// 设置窗体的起始位置
                assiViewFrame.StartPosition = FormStartPosition.Manual;
                assiViewFrame.FormBorderStyle = FormBorderStyle.None;

                assiViewFrame.Location = this.GetFrameLocation(xBaseCtrl);
                assiViewFrame.Size = this.GetFrameSize(xBaseCtrl);

            }
            // 参数中增加事件处理对象
            Dictionary<string, object> paramDic  = this.getParamDic(btnDTO);
            paramDic.Add("assiViewFrame", assiViewFrame);
            // 获取加载对象
            XUserControl xUserCtrl = this.LoadConfigUserControl(paramDic, btnDTO);
            if (xUserCtrl != null)
            {
                assiViewFrame.loadFrame(xBaseCtrl, xUserCtrl, btnDTO);
            }            
        }

        public override void OnDeActiveForm()
        {
            base.OnDeActiveForm();

            if (diAssiForm != null)
            {
                diAssiForm.Close();
                diAssiForm = null;
                isDiOpen = false;
            }

            if(assiViewFrame!=null)
            {
                assiViewFrame.Close();
            }
        }

        /// <summary>
        /// 加载配置文件是否成功
        /// </summary>
        /// <returns></returns>
        private XUserControl LoadConfigUserControl(Dictionary<string, object> paramDic,AssiBtnDTO btnDTO)
        {
            XUserControl xUserControl = null;
            Dictionary <AssiFrameLocation, string> ConfigPathDic = this.GetDisplayCfgXmlDic();

            // 待加载的配置文件路径不存在
            if (ConfigPathDic == null || !ConfigPathDic.ContainsKey(btnDTO.FrameLocation))
            {
                BizAssMessageBoxUtil.ShowInforMsg("加载助手窗口失败,请配置加载助手的配置文件！");
                return xUserControl;
            }

            //if (cacheXUserControlDic.ContainsKey(btnDTO.FrameLocation))
            //{
            //    xUserControl = cacheXUserControlDic[btnDTO.FrameLocation];
            //    xUserControl.LoadData(paramDic);
            //}
            //else
            //{
                xUserControl = new XUserControl();
                string xmlpath = ConfigPathDic[btnDTO.FrameLocation];
                xUserControl.Init(xmlpath, paramDic);              

                xUserControl.Dock = DockStyle.Fill;

            //    cacheXUserControlDic.Add(btnDTO.FrameLocation, xUserControl);
            //}

            return xUserControl;
        }

        /// <summary>
        /// 获取初始化助手需要的参数
        /// </summary>
        /// <returns>初始化助手使用的参数</returns>
        private Dictionary<string, object> getParamDic(AssiBtnDTO btnDTO)
        {
            Dictionary<string, object> paramDic = new Dictionary<string, object>();

            paramDic.Add("sender", this);
            paramDic.Add("ent4BannerDTO", this.ent4BannerDTO);
            paramDic.Add("context", this.Context);
            paramDic.Add("assiBtnDTO", btnDTO);
            if (btnDTO.OpenFrameModel == AssiFrameOpenModel.SHOW)
            {
                paramDic.Add("closeBtnText", "取消");
                paramDic.Add("isConfirmCloseAssiFrame", false);
            }
            else
            {
                paramDic.Add("closeBtnText", "关闭");
                paramDic.Add("isConfirmCloseAssiFrame", true);
            }

            // 获取当前的业务环境变量，用于助手传递到后台，医疗单类型在AssistantBtnBaseView的实现类中设置，医嘱来源属性Eu_orsrcmdtp， 在各个助手（使用处）设置            
            paramDic.Add("ciEnContext", this.GetCiEnContextParam());

            // 获取自定义参数
            Dictionary<string, object> customParamDic = this.GetCustomParmDic();
            if (customParamDic != null && customParamDic.Count > 0)
            {
                foreach (string key in customParamDic.Keys)
                {
                    if (paramDic.ContainsKey(key))
                    {
                        paramDic[key] = customParamDic[key];
                    }
                    else
                    {
                        paramDic.Add(key, customParamDic[key]);
                    }

                }
            }

            return paramDic;
        }

        /// <summary>
        /// 获取当前就诊环境
        /// </summary>
        /// <returns></returns>
        protected virtual CiEnContextDTO GetCiEnContextParam()
        {

            // 获取当前的业务环境变量，用于助手传递到后台，医疗单类型在AssistantBtnBaseView的实现类中设置，医嘱来源属性Eu_orsrcmdtp， 在各个助手（使用处）设置
            CiEnContextDTO ciEnContext = CiEnContextUtil.GetCiEnContext(this.ent4BannerDTO, this.Context);
            this.SetCustomCiEnContext(ciEnContext);

            return ciEnContext;
        }

        private void getDOsFromHelp(object[] dos)
        {
            onFireEventSent(OpActionConstant.OP_DI_ASSI_ACTION, dos);
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
        #endregion

        #region 状态处理区域

        #endregion
        public void switchToComplex()
        {
            AssiBtnDTO btn50 = new AssiBtnDTO();
            btn50.ButtonId = "btnOpTemplateFrame";
            btn50.Text = "医嘱模板";
            btn50.ViewClassId = "OpTemplateFrame";
            btn50.PanelManagerId = "rightPanelManger";
            btn50.XTabPageId = "OpTemplateFrame";
            btn50.FrameLocation = AssiFrameLocation.RIGHT;
            btn50.OpenFrameModel = AssiFrameOpenModel.SHOW;
            btn50.modelType = "complex";
            this.LoadAssiFrame(btn50);
        }
        public void switchToPithy()
        {
            AssiBtnDTO btn50 = new AssiBtnDTO();
            btn50.ButtonId = "btnOpTemplateFrame";
            btn50.Text = "医嘱模板";
            btn50.ViewClassId = "OpTemplateFrame";
            btn50.PanelManagerId = "rightPanelManger";
            btn50.XTabPageId = "OpTemplateFrame";
            btn50.FrameLocation = AssiFrameLocation.LEFT;
            btn50.OpenFrameModel = AssiFrameOpenModel.SHOW;
            btn50.modelType = "pithy";
            this.LoadAssiFrame(btn50);
        }
    }
}

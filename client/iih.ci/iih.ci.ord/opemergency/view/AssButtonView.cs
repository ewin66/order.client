using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;
using iih.bd.srv.ems.d;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.ortpl.d;
using iih.ci.ord.ciorder.cards.extend;
using iih.ci.ord.ems.d;
using iih.ci.ord.opemergency.assi.OrderTemplate;
using xap.cli.sdk.common;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using xap.cli.sdk.render;
using iih.ci.iih.ci.ord.opemergency.i.command;
using xap.rui.bizcontrol.bannerview;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.viewmodel;
using iih.en.pv.dto.d;
using iih.ci.ord.opemergency.assi.enthistory.viewmodel;
using iih.ci.diag.cidiag.d;
using xap.cli.sdk.form;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.rui.bizcontrol.bannercontrol;
using iih.bd.bc.udi;
using xap.rui.control.extentions;
using iih.ci.iih.ci.ord.i;
using iih.ci.ord.opemergency.action;
using xap.cli.sdk.controls;
using iih.ci.ord.common.utils.msg;
using iih.ci.ord.opemergency.declare;

namespace iih.ci.ord.opemergency.view
{
    /// <summary>
    /// <para>描    述 : 服务录入按钮视图                  </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.view       </para>    
    /// <para>类 名 称 : AssButtonView                     </para> 
    /// <para>版 本 号 : v1.0.0.0                          </para> 
    /// <para>作    者 : qzwang                            </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05                </para>
    /// <para>修 改 人 :                                   </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05                </para> 
    /// <para>说    明 :                                   </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class AssButtonView : XapBaseControl
    {

        #region 变量定义区域


        /// <summary>
        /// 左侧显示区域
        /// </summary>
        private const string LEFT_REGION_CLASS_ID = "EntDiStatusView";

        /// <summary>
        /// 右侧显示区域
        /// </summary>
        private const string RIGHT_REGION_CLASS_ID = "OrdListView";

        /// <summary>
        /// 左侧计算位置控件
        /// </summary>
        private XBaseControl leftXBaseCtrl;

        /// <summary>
        /// 右侧计算位置控件
        /// </summary>
        private XBaseControl rightXBaseCtrl;

        /// <summary>
        /// 弹出窗口传递参数
        /// sender：当前对象，leftLocation左侧区域Location,leftSize：左侧病历区域Size，rightLocation：右侧坐标，取医嘱项目页签的Location,
        /// rightSize:右侧医嘱项目处置列表合计的size,ent4BannerDTO,banner数据对象
        /// {"setnder",this},{"leftLocation",leftLocation},{"leftSize",leftSize},{"rightLocation",rightLocation},{"rightSize",rightSize}，{"ent4BannerDTO",ent4BannerDTO}
        /// </summary>
        private Dictionary<string, object> paramDic = new Dictionary<string, object>();

        /// <summary>
        /// optrdocstation_config.xml中病历classId
        /// </summary>
        private const string TPL_COMMAND = "tplcommand";

        // 诊断相关接口
        private CiDiagViewModel cidiViewModel;
        private string tmpIamgePath = SkinFactory.Instance().CurrentSkin.SkinPath + "\\";// "D:\\xap\\门诊医生站ICON\\";
        private ICiCommand[] szCiCommand = null;
        public OrScArgs Args { get; set; }
        public AssButtonViewModel model;
        public Ent4BannerDTO ent4BannerDTO = null;
        private List<XIconToolButton> _xIconToolButtonsList = new List<XIconToolButton>();
        private Dictionary<string, string> xbuttoneventtype = new Dictionary<string, string>() { 
            {"门诊组套","ShortcutOpMedclingrpApp"},{"病历模板","ShortcutOpTplcommand"},{"医嘱模板","ShortcutOpOrdTemplat"}
            ,{"医技常规","ShortcutOpMedicalTechmology"},{"服务分类","ShortcutOpMedSrvCatg"}
        };

        // 诊毕状态 0 无诊毕 可以去掉诊毕按钮，任何业务部受限制
        // 1 仅诊毕 通过点击诊毕按钮，进行批量业务处理（是否处理按业务场景确定，比如是否修改诊毕状态，是否调用打印）
        // 2 诊毕撤回，严格控制诊毕后不允许做其他业务，只有进行撤回后才能继续
        private string finishMode;
        #endregion

        #region 构造函数区域
        public AssButtonView()
        {
            // cidiViewModel构造函数是传当前环境，BaseContext,由于获取诊断不需要当前环境，可以设置为空
            this.cidiViewModel = new CiDiagViewModel(null);
            this.model = new AssButtonViewModel();
            this.Load += new EventHandler(buttonView_Load);
        }
        #endregion

        #region 事件

        void buttonView_Load(object sender, EventArgs e)
        {
            // 
            // string[] titles = { "门诊组套", "", "医嘱模板", "医技常规", "患者常用", "服务分类", "临床指南" };

            szCiCommand = new ICiCommand[] {
                 (ICiCommand)this.Context.Config.GetInstance("MedclingrpAppCommand"),// 门诊组套
                 (ICiCommand)this.Context.Config.GetInstance(TPL_COMMAND),// 病历模板
                  (ICiCommand)this.Context.Config.GetInstance("OrderTemplateCommand"),//医嘱模板
                 (ICiCommand)this.Context.Config.GetInstance("OpMedicalTechmologyCommand"),//医技常规, 
                 //(ICiCommand)this.Context.Config.GetInstance("OpPatCommonUseCommand"), // 患者常用
                 (ICiCommand)this.Context.Config.GetInstance("OpMedSrvCatgCommand") // 服务分类
                 //(ICiCommand)this.Context.Config.GetInstance("OpClinicalGuideCommand") // 临床指南 暂时屏蔽
             };

            XVerticalToolBar xToolBar = new XVerticalToolBar(this);//父容器

            xToolBar.ButtonsNumInGroup = 4;
            xToolBar.PaddingTop = 20;
            xToolBar.BackColor = Color.White;

            this.BackColor = Color.White;

            int tabIndex = 0;
            foreach (ICiCommand cmd in szCiCommand)
            {
                XIconToolButton button = new XIconToolButton();
                button.TabIndex = tabIndex++;
                button.Text = cmd.GetTitle();
                button.ImageShow = false;
                button.ButtonId = "";
                button.TipText = cmd.GetTitle();
                button.MouseClick += new MouseEventHandler(button_MouseClick);
                button.ValueObj = cmd;
                //this.SetBindingAction(xbuttoneventtype[cmd.GetTitle()], button);
                setToolbarButtonImage(tmpIamgePath, button, cmd.GetTitle(), null); // SkinFactory.Instance().CurrentSkin.SkinPath
                xToolBar.AddRender(button);
                _xIconToolButtonsList.Add(button);
            }

            xToolBar.Layout();
            this.AddRender(xToolBar);

            //图标换肤 ganwh add 2016-9-13
            SkinFactory.Instance().SkinChanged += OnSkinChanged;
        }

        private void OnSkinChanged()
        {
            string imagePath = SkinFactory.Instance().CurrentSkin.SkinPath + "\\";
            foreach (XIconToolButton xIconToolButton in _xIconToolButtonsList)
            {
                setToolbarButtonImage(imagePath, xIconToolButton, xIconToolButton.Text, null);
            }
        }

        void button_MouseClick(object sender, MouseEventArgs e)
        {

            XIconToolButton btn = sender as XIconToolButton;
            // 如不是中间按钮区直接返回，或者banner为空，弹出提示信息并返回
            if (btn == null || BizAssMessageBoxUtil.ShowPatIsNullMsg(ent4BannerDTO, btn.Text) || IsEntCompleted())
            {
                return;
            }

            if (btn.TabIndex < szCiCommand.Length && szCiCommand[btn.TabIndex] != null)
            {
                // 获取助手弹出窗口的坐标
                this.GetICiCommandParamDic();

                if (btn.Text == "医嘱模板")
                {
                    // 判断是否已经诊毕，以及是否已经下诊断
                    if (!IsWriteCiDi("医嘱模板"))
                    {
                        return;
                    }

                    using (OpOrderTemplateForm OrderSevrice_Frm = new OpOrderTemplateForm(this, 1))
                    {
                        // helperForm OrderSevrice_Frm = new helperForm(this);
                        OrderSevrice_Frm.StartPosition = FormStartPosition.Manual;
                        OrderSevrice_Frm.Location = this.GetLeftLocation();
                        // OrderSevrice_Frm.LocationChanged += new EventHandler(OrderSevrice_Frm_LocationChanged);
                        OrderSevrice_Frm.SaveClick += new MouseEventHandler(OrderSevrice_Frm_SaveClick);
                        OrderSevrice_Frm.FormClosed += new FormClosedEventHandler(OrderSevrice_Frm_FormClosed);
                        OrderSevrice_Frm.ShowDialog();
                       
                    }

                }
                else if (btn.Text == "医技常规")
                {
                    // 判断是否已经诊毕，以及是否已经下诊断
                    if (!IsWriteCiDi("医技常规"))
                    {
                        return;
                    }
                    using (OpOrderTemplateForm OrderSevrice_Frm = new OpOrderTemplateForm(this, 2))
                    {
                        // helperForm OrderSevrice_Frm = new helperForm(this);
                        OrderSevrice_Frm.StartPosition = FormStartPosition.Manual;
                        OrderSevrice_Frm.Location = this.GetLeftLocation();
                        // OrderSevrice_Frm.LocationChanged += new EventHandler(OrderSevrice_Frm_LocationChanged);
                        OrderSevrice_Frm.SaveClick += new MouseEventHandler(OrderSevrice_Frm_SaveClick);
                        OrderSevrice_Frm.FormClosed += new FormClosedEventHandler(OrderSevrice_Frm_FormClosed);
                        OrderSevrice_Frm.ShowDialog();
                    }
                   
                }
                else if (btn.Text == "服务分类")
                {
                    // 判断是否已经诊毕，以及是否已经下诊断
                    if (!IsWriteCiDi("服务分类"))
                    {
                        return;
                    }

                    using (OpOrderTemplateForm OrderSevrice_Frm = new OpOrderTemplateForm(this, 0))
                    {
                        // helperForm OrderSevrice_Frm = new helperForm(this);
                        OrderSevrice_Frm.StartPosition = FormStartPosition.Manual;
                        OrderSevrice_Frm.Location = this.GetLeftLocation();
                        // OrderSevrice_Frm.LocationChanged += new EventHandler(OrderSevrice_Frm_LocationChanged);
                        OrderSevrice_Frm.SaveClick += new MouseEventHandler(OrderSevrice_Frm_SaveClick);
                        OrderSevrice_Frm.FormClosed += new FormClosedEventHandler(OrderSevrice_Frm_FormClosed);
                        OrderSevrice_Frm.ShowDialog();
                    }
                    
                }
                else if (btn.Text == "病历模板")
                {
                    Object result = szCiCommand[btn.TabIndex].exec(paramDic);
                }
                else if (btn.Text == "门诊组套")
                {
                    Object result = szCiCommand[btn.TabIndex].exec(paramDic);
                }
                else
                {
                    Object result = szCiCommand[btn.TabIndex].exec(this);
                }
            }

        }

        void OrderSevrice_Frm_FormClosed(object sender, FormClosedEventArgs e)
        {
            //throw new NotImplementedException();
        }

        protected void OrderSevrice_Frm_SaveClick(object sender, MouseEventArgs e)
        {
            var list = new List<OrTplNItmDO>();
            if (Args != null)
            {
                if (Args.Id_item == "technolog" || Args.Id_item == "ortmplate")
                {
                    foreach (var item in Args.listObj)
                    {
                        if ((item as OrTplNItmDO) != null)
                        {
                            list.Add(item as OrTplNItmDO);
                        }
                    }
                }
                else if (Args.Id_item == "medsrv")
                {
                    foreach (Object item in this.Args.listObj)
                    {
                        if ((item as MedSrvDO) != null)
                        {
                            MedSrvDO tempmedsrv = item as MedSrvDO;
                            if (tempmedsrv.Fg_set.Value)
                            {
                                MedSrvConvertSetItem(list, tempmedsrv);
                            }
                            else
                            {
                                OrTplNItmDO rtplItem = convertOrTplNItmDO(item as MedSrvDO);
                                list.Add(rtplItem);
                            }

                            // list.Add(new ems.common.EmsCreatedParameter(item as MedSrvDO, null));
                        }
                    }
                }

            }

            //保存数据库
            var envinfo = setCiEnContextDTO();
   
            var moreEmsDto = model.getMoreEmsParamDTO(envinfo, list.ToArray());

            AssToolEx.SentMessage(this, EventCodeType.EVENT_EMS_TMPL_EDIT, EventCodeType.ARGKEY_EMS_TMPL_EDIT, moreEmsDto);
        }


        /// <summary>
        /// 上下文信息
        /// </summary>
        /// <returns></returns>
        private CiEnContextDTO setCiEnContextDTO()
        {
            CiEnContextDTO envinfo = new CiEnContextDTO();
            envinfo.Code_entp = ent4BannerDTO.Code_entp;
            envinfo.Id_dep_or = this.Context.Dept.Id_dep;
            envinfo.Id_en = this.ent4BannerDTO.Id_ent;
            envinfo.Id_emp_or = this.Context.PsnInfo.Id_psndoc;
            envinfo.Id_entp = this.ent4BannerDTO.Id_entp;
            envinfo.Id_grp = this.Context.Group.Id_grp;
            envinfo.Id_hp = this.ent4BannerDTO.Id_hp;
            envinfo.Id_org = this.Context.Org.Id_org;
            envinfo.Id_pat = this.ent4BannerDTO.Id_pat;
            envinfo.Fg_bb = this.ent4BannerDTO.Fg_newborn;
            envinfo.Id_dep_en = this.ent4BannerDTO.Id_dep_phy;
            envinfo.Emsappmode = (int)EmsAppModeEnum.SVEMSAPPMODE;
            return envinfo;

        }



        private void MedSrvConvertSetItem(List<OrTplNItmDO> list, MedSrvDO medsrvDO)
        {
            MedSrvSetItemDO[] medsrvSetItem = this.model.getMedSrvSetItemDO(medsrvDO.Id_srv);
            if (medsrvSetItem != null)
            {
                foreach (MedSrvSetItemDO setItem in medsrvSetItem)
                {
                    OrTplNItmDO item = new OrTplNItmDO();
                    item.Id_srv = setItem.Id_srv_itm;
                    item.Ortplnitm_srv_name = setItem.Srv_name;
                    item.Id_ortmpl = setItem.Id_srv;
                    item.Id_boil = setItem.Id_boil;
                    item.Id_boildes = setItem.Id_boildes;
                    item.Quan_med = setItem.Quan_medu;
                    item.Id_freq = setItem.Id_freq;
                    //item.setId_mm(medSrv.getId_mm);
                    item.Id_ortmplitm = setItem.Id_srv_itm + setItem.Id_srv;
                    item.Id_route = setItem.Id_route;
                    item.Id_routedes = setItem.Id_routedes;
                    item.Id_srvtp = medsrvDO.Id_srvtp;
                    item.Sd_srvtp = medsrvDO.Sd_srvtp;
                    item.Id_unit_med = medsrvDO.Id_unit_med;
                    item.Ortplnitm_boildes_name = setItem.Boil_name;
                    item.Ortplnitm_freq_name = setItem.Freq_name;
                    item.Ortplnitm_route_name = setItem.Route_name;
                    item.Ortplnitm_routedes_name = setItem.Routedes_name;
                    item.Ortplnitm_unit_name = setItem.Medu_name;
                    item.Identical_ortmpl = setItem.Id_srv;
                    item.Fg_edit = setItem.Fg_edit;
                    item.Identical_ortmpl = medsrvDO.Id_srv;
                    if (medsrvDO.Fg_set.Value)
                    {
                        item.Id_srv_set = setItem.Id_srv;
                    }
                    list.Add(item);
                }
            }
        }

        /// <summary>
        /// MedSrvDO  convert to  OrTplNItmDO 
        /// </summary>
        /// <param name="medsrvDO"></param>
        /// <returns></returns>
        private OrTplNItmDO convertOrTplNItmDO(MedSrvDO medsrvDO)
        {
            OrTplNItmDO item = new OrTplNItmDO();
            item.Id_srv = medsrvDO.Id_srv;
            item.Ortplnitm_srv_name = medsrvDO.Name;
            item.Id_ortmpl = medsrvDO.Id_srv;
            item.Id_boil = medsrvDO.Id_boil;
            item.Id_boildes = medsrvDO.Id_boildes;
            item.Quan_med = medsrvDO.Quan_med;
            item.Id_freq = medsrvDO.Id_freq;
            //item.setId_mm(medSrv.getId_mm);
            item.Id_ortmplitm = medsrvDO.Id_srv;
            item.Id_route = medsrvDO.Id_route;
            item.Id_routedes = medsrvDO.Id_routedes;
            item.Id_srvtp = medsrvDO.Id_srvtp;
            item.Sd_srvtp = medsrvDO.Sd_srvtp;
            item.Id_unit_med = medsrvDO.Id_unit_med;
            item.Ortplnitm_boildes_name = medsrvDO.Boil_name;
            item.Ortplnitm_freq_name = medsrvDO.Freq_name;
            item.Ortplnitm_route_name = medsrvDO.Route_name;
            item.Ortplnitm_routedes_name = medsrvDO.Routedes_name;
            item.Ortplnitm_unit_name = medsrvDO.Med_name;
            item.Fg_edit = false;
            item.Identical_ortmpl = medsrvDO.Id_srv;
            if (medsrvDO.Fg_set.Value)
            {
                item.Id_srv_set = medsrvDO.Id_srv;
            }

            return item;
        }

        private void setToolbarButtonImage(String path, XIconToolButton button, String imageName, EventHandler evt)
        {
            if (this.tmpIamgePath == null) return;
            int index = 1;
            button.NormalImage = Image.FromFile(path + imageName + "-" + (index++).ToString() + ".png");
            button.HoverImage = Image.FromFile(path + imageName + "-" + (index++).ToString() + ".png");
            button.DownImage = Image.FromFile(path + imageName + "-" + (index++).ToString() + ".png");
            button.DisableImage = Image.FromFile(path + imageName + "-" + (index++).ToString() + ".png");
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

        /// <summary>
        /// 设置打开助手页面时传递的参数
        /// </summary>
        /// <param name="ent4BannerDTO"></param>
        private void GetICiCommandParamDic()
        {

            paramDic.Clear();
            paramDic.Add("sender", this);
            paramDic.Add("leftLocation", this.GetLeftLocation());
            paramDic.Add("leftSize", this.GetLeftSize());
            paramDic.Add("rightLocation", this.GetRightLocation());
            paramDic.Add("rightSize", this.GetRightSize());
            //paramDic.Add("rightLocation", this.GetLeftLocation());
            //paramDic.Add("rightSize", this.GetLeftSize());
            paramDic.Add("ent4BannerDTO", this.ent4BannerDTO);
        }

        #region 获取门急诊医生站左侧、右侧弹出窗口的位置、尺寸

        /// <summary>
        /// 获取左侧显示区域坐标
        /// </summary>
        /// <returns></returns>
        private Point GetLeftLocation()
        {

            if (leftXBaseCtrl == null)
            {
                leftXBaseCtrl = this.getParentCtrl(LEFT_REGION_CLASS_ID);
            }

            return getLocation(leftXBaseCtrl);
        }

        /// <summary>
        /// 获取左侧显示区域尺寸
        /// </summary>
        /// <returns></returns>
        private Size GetLeftSize()
        {

            if (leftXBaseCtrl == null)
            {
                leftXBaseCtrl = this.getParentCtrl(LEFT_REGION_CLASS_ID);
            }
            return this.getSize(leftXBaseCtrl);
        }

        /// <summary>
        /// 获取右侧显示区域坐标
        /// </summary>
        /// <returns></returns>
        private Point GetRightLocation()
        {

            if (rightXBaseCtrl == null)
            {
                rightXBaseCtrl = this.getParentCtrl(RIGHT_REGION_CLASS_ID);
            }

            return getLocation(rightXBaseCtrl);
        }

        /// <summary>
        /// 获取右侧显示区域尺寸
        /// </summary>
        /// <returns></returns>
        public Size GetRightSize()
        {

            if (rightXBaseCtrl == null)
            {
                rightXBaseCtrl = this.getParentCtrl(RIGHT_REGION_CLASS_ID);
            }
            return this.getSize(rightXBaseCtrl);
        }

        /// <summary>
        /// 设置辅助录入显示相对应的父窗体
        /// </summary>
        /// <returns></returns>
        private XBaseControl getParentCtrl(string classId)
        {
            try
            {
                XapBaseControl xapListCtrl = this.Context.Config.GetInstance(classId) as XapBaseControl;

                if (xapListCtrl != null)
                {
                    return xapListCtrl.Parent as XBaseControl;
                }
            }
            catch (Exception)
            {
                MessageBoxEx.Show("在路径[\\modules\\iihci\\ui\\optrdocstation]的配置文件中未能找到id为[" + classId + "]的类！", "就诊历史", MessageBoxButtons.OK, MessageBoxIconEx.Error, MessageBoxDefaultButton.Button1);
            }

            return null;
        }

        /// <summary>
        /// 获取当前显示窗口的位置
        /// <para>子类根据实际需求设定显示的位置</para>
        /// </summary>
        /// <returns></returns>
        private Point getLocation(XBaseControl xBaseCtrl)
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
        private Size getSize(XBaseControl xBaseCtrl)
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

        #endregion

        #region 父类重载
        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if (!(sender is bannerOpdocstation))
            {
                return;
            }

            BannerData bannerData = e.Object as BannerData;
            if (bannerData != null && bannerData.Ent4BannerDTO != null)
            {
                this.ent4BannerDTO = bannerData.Ent4BannerDTO;

                if (finishMode == null)
                {
                    string idDep = this.Context.Dept.Id_dep;
                    // 诊毕状态 0 无诊毕 可以去掉诊毕按钮，任何业务部受限制
                    // 1 仅诊毕 通过点击诊毕按钮，进行批量业务处理（是否处理按业务场景确定，比如是否修改诊毕状态，是否调用打印）
                    // 2 诊毕撤回，严格控制诊毕后不允许做其他业务，只有进行撤回后才能继续
                    finishMode = this.Context.GetParam<string>(idDep, ICiOrdNSysParamConst.SYS_PARAM_OpThisPatVisitFinishMode);
                }
            }
            else
            {
                this.ent4BannerDTO = null;
            }
        }
        public override void HandleState(object sender, DictionaryEventArgs e)
        {
            // 获取助手弹出窗口的坐标
            this.GetICiCommandParamDic();

            base.HandleState(sender, e);
            if (sender is ShortcutOpOrdTemplatAction)
            {
                if (sender == null || BizAssMessageBoxUtil.ShowPatIsNullMsg(ent4BannerDTO, null) || IsEntCompleted())
                {
                    return;
                }
                this.szCiCommand[2].exec(this.paramDic);
            }
            else if (sender is ShortcutOpMedclingrpAppAction)
            {
                if (sender == null || BizAssMessageBoxUtil.ShowPatIsNullMsg(ent4BannerDTO, null) || IsEntCompleted())
                {
                    return;
                }
                this.szCiCommand[0].exec(this.paramDic);
            }
            else if (sender is ShortcutOpTplcommandAction)
            {
                if (sender == null || BizAssMessageBoxUtil.ShowPatIsNullMsg(ent4BannerDTO, null) || IsEntCompleted())
                {
                    return;
                }
                this.szCiCommand[1].exec(this.paramDic);
            }
            else if (sender is ShortcutOpMedicalTechmologyAction)
            {
                XIconToolButton btn = new XIconToolButton();
                btn.Text = "医技常规";
                this.button_MouseClick(btn, null);
            }
            else if (sender is ShortcutOpMedSrvCatgAction)
            {
                XIconToolButton btn = new XIconToolButton();
                btn.Text = "服务分类";
                this.button_MouseClick(btn, null);
            }
        }
        #endregion

    }
}

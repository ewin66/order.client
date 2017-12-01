
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using iih.en.pv.i;
using iih.ci.mr.cimr.i;
using iih.ci.ord.ciorder.i;
using iih.ci.diag.cidiag.i;
using iih.en.pv.dto.d;
using xap.mw.serviceframework;
using xap.rui.engine.eventbroker;
using xap.rui.engine;
using xap.mw.log;
using xap.rui.engine.eventbroker.Handlers;
using iih.ci.ord.opemergency.emreditor.viewmodel;
using iih.ci.ord.ciorder.d;
using iih.ci.diag.dto.d;
using iih.ci.mr.cimr.d;
using xap.rui.control.exceptions;
using xap.sys.permfw.user.d;
using xap.rui.control.basecontrol;
using xap.rui.bizcontrol.bannercontrol;
using xap.mw.coreitf.d;
using iih.ci.iih.ci.ord.i;
using xap.rui.control.extentions;
using iih.bd.bc.udi;
using iih.ci.mr_stub.service.i;
using iih.ci.ord.dto.ordermr.d;
using xap.rui.appfw;
using iih.ci.ord.opemergency.assi.asscommon.viewmodel;
using xap.rui.bizcontrol.bannerview;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.action.costant;
using xap.cli.context.events;
using iih.ci.ord.i;
using iih.ci.ord.opemergency.declare;
using xap.mw.core.data;

namespace iih.ci.ord.opemergency.emreditor.view
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.emreditor.view    </para>    
    /// <para>类 名 称 :  EmrEditorInitEvent					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/8/8 16:25:02             </para>
    /// <para>更新时间 :  2016/8/8 16:25:02             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EmrEditorInitEvent : XapBaseControl
    {
        #region 变量定义区域

        /// <summary>
        /// 发送病历基本信息 和 默认模板，无患者信息（该常量由病历组提供）
        /// </summary>
        private const string SENTDEFAULTMODEL2PUBCIMR = "SentDefaultModel2PubCiMr";

        /// <summary>
        /// 发送病历文书数据，有患者信息（该常量由病历组提供）
        /// </summary>
        private const string SENTPUBCIMR = "SentPubCiMr";

        /// <summary>
        /// 发送加载初诊、复诊病历事件
        /// </summary>
        private const string SENT_LOAD_FIRST_VISIT_EMR = "SentLoadFirstVisitEmr";

        /// <summary>
        /// 保存病历事件
        /// </summary>
        private const string CI_EMR_SAVE_EVENT = "CiEmrSaveEvent";

        /// <summary>
        /// 处置手动刷新到病历事件
        /// </summary>
        private const string CI_ORDER_FLUSH_EVENT = "CiOrderFlush2MrEvent";

        /// <summary>
        /// 设置病历只读事件
        /// </summary>
        private const string SENT_MODEL2PUB_CIMR_READONLY = "SentModel2PubCiMrReadOnly";

        /// <summary>
        /// 传递到病历的处置数据标识
        /// </summary>
        private const string CI_ORDER_ITEM = "ciOrderItem";

        /// <summary>
        /// 传递到病历的诊断数据标识
        /// </summary>
        private const string CIDI_ITEM = "cidiItem";

        /// <summary>
        /// 解析处置配数据的置文件路径
        /// </summary>        
        private const string CI_ORDER_XML_CFG_PATH = "\\modules\\iihci\\ui\\optrdocstation\\config\\EmrEditorCiOrder2.xml";//yjb

        /// <summary>
        /// 解析诊断数据的配置文件路径
        /// </summary>
        private const string CIDI_XML_CFG_PATH = "\\modules\\iihci\\ui\\optrdocstation\\config\\EmrEditorCiDiagConfig.xml";

        /// <summary>
        /// banner数据
        /// </summary>
        private Ent4BannerDTO ent4BannerDTO;

        /// <summary>
        /// 发送病历加载的数据对象
        /// </summary>
        private DictionaryEventArgs ciMrArgsDic = new DictionaryEventArgs();

        #endregion

        #region 服务接口

        /// <summary>
        /// 患者信息服务接口
        /// </summary>
        private IEnOutQryService iEnOutQryService;

        /// <summary>
        /// 临床医疗记录
        /// </summary>
        private ICiemrCrudService iCiemrCrudService;

        /// <summary>
        /// 处置查询接口
        /// </summary>
        private ICiorderMDOCrudService orderItemMService;

        /// <summary>
        /// 诊断信息 Agg 查询服务，支持保存删除等操作 
        /// </summary>
        private ICidiagCrudService cidiagCrudService;

        /// <summary>
        /// 医嘱服务接口
        /// </summary>
        private ICiOrdQryService ciservice;

        /// <summary>
        /// 诊断、处置数据转换服务
        /// </summary>
        private EmrEditorCiViewModel emrCiViewModel;

        /// <summary>
        /// 影响病历相关方法
        /// </summary>
        private EmrEditorViewModel emrViewModel;

        #endregion

        #region 构造函数区域

        public EmrEditorInitEvent()
        {
            InitializeComponent();
            // 患者信息服务接口
            iEnOutQryService = XapServiceMgr.find<IEnOutQryService>();
            // 临床医疗记录
            iCiemrCrudService = XapServiceMgr.find<ICiemrCrudService>();
            // 处置查询接口
            orderItemMService = XapServiceMgr.find<ICiorderMDOCrudService>();
            // 诊断信息 Agg 查询服务，支持保存删除等操作
            cidiagCrudService = XapServiceMgr.find<ICidiagCrudService>();
            // 病历服务接口
            ciservice = XapServiceMgr.find<ICiOrdQryService>();
            // 影响病历相关方法
            emrViewModel = new EmrEditorViewModel();
            // 诊断、处置数据转换服务
            emrCiViewModel = new EmrEditorCiViewModel();
        }

        #endregion

        #region 公开属性区域

        #endregion

        #region 命令定义区域

        #endregion

        #region 事件发送区域

        /// <summary>
        /// 根据患者信息加载病历模板事件
        /// </summary>
        [EventPublication(SENTPUBCIMR)]
        public event EventHandler<DictionaryEventArgs> SentPubCiMr;
        private void SentPubCiMrEvent(DictionaryEventArgs args)
        {
            if (SentPubCiMr != null)
                SentPubCiMr(this, args);
        }

        /// <summary>
        /// 加载默认病历模板事件
        /// </summary>
        [EventPublication(SENTDEFAULTMODEL2PUBCIMR)]
        public event EventHandler<DictionaryEventArgs> SentDefaultModel2PubCiMr;
        private void SentDefaultModel2PubCiMrEvent(DictionaryEventArgs args)
        {
            if (SentDefaultModel2PubCiMr != null)
                SentDefaultModel2PubCiMr(this, args);
        }

        /// <summary>
        /// 加载初复诊病历事件
        /// </summary>
        [EventPublication(SENT_LOAD_FIRST_VISIT_EMR)]
        public event EventHandler<DictionaryEventArgs> SentLoadFirstVisitEmr;
        private void SentLoadFirstVisitEmrEvent(DictionaryEventArgs args)
        {
            if (SentLoadFirstVisitEmr != null)
                SentLoadFirstVisitEmr(this, args);
        }

        /// <summary>
        /// 设置病历是否为可编辑状态
        /// </summary>
        [EventPublication(SENT_MODEL2PUB_CIMR_READONLY)]
        public event EventHandler<DataEventArgs<bool>> SentModel2PubCiMrReadOnly;
        private void SentModel2PubCiMrReadOnlyEvent()
        {
            // 判断就诊状态是否已经诊毕，如果诊毕设置病历为只读状态，否则为可编辑状态
            bool isReadOnly = emrViewModel.IsEnFinish(this.ent4BannerDTO.Id_ent);
            DataEventArgs<bool> agrs = new DataEventArgs<bool>(false);

            if (SentModel2PubCiMrReadOnly != null)
                SentModel2PubCiMrReadOnly(this, agrs);
        }

        /// <summary>
        /// 保存病历模板事件
        /// </summary>
        [EventPublication(CI_EMR_SAVE_EVENT)]
        public event EventHandler<DataEventArgs<Dictionary<string, object>>> FireCiEmrSaveEvent;
        private void fireCiEmrSaveEvent(Dictionary<string, object> arg)
        {
            DataEventArgs<Dictionary<string, object>> de = new DataEventArgs<Dictionary<string, object>>(arg);
            if (FireCiEmrSaveEvent != null)
                FireCiEmrSaveEvent(this, de);
        }

        /// <summary>
        /// 病历段落回写到病历事件
        /// </summary>
        [EventPublication(AssistantConstant.CI_EMR_WRITE_BACK_EVENT)]
        public event EventHandler<DataEventArgs<Dictionary<string, object>>> CiEmrWriteBackEvent;
        private void fireCiEmrWriteBackEvent(Dictionary<string, object> args)
        {
            DataEventArgs<Dictionary<string, object>> eventArgs = new DataEventArgs<Dictionary<string, object>>(args);

            if (CiEmrWriteBackEvent != null)
                this.CiEmrWriteBackEvent(this, eventArgs);
        }

        /// <summary>
        /// 诊断保存到病历
        /// </summary>
        /// <param name="didtos"></param>
        private void fireCidiWriteToEmrEvent(DIDTO[] didtos)
        {
            string cidiDOXmlStr = emrCiViewModel.convertZdToXmlStr(didtos, CIDI_XML_CFG_PATH);

            Dictionary<string, object> cidiDic = new Dictionary<string, object>();
            cidiDic.Add(CIDI_ITEM, cidiDOXmlStr);
            this.fireCiEmrSaveEvent(cidiDic);
        }

        /// <summary>
        /// 诊断/处置同步到病历事件
        /// </summary>
        private void fireCidiCiordWriteToEmrEvent()
        {

            Dictionary<string, object> dataDic = new Dictionary<string, object>();
            // 诊断
            dataDic.Add(CIDI_ITEM, "");

        }

        #endregion

        #region 事件接收区域

        /// <summary>
        /// 接收加载病历事件，根据病历对象是否为空确定是加载指定病历还是加载病历模板
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="args"></param>
        //[EventSubscription(EmrEditorConst.LOAD_EMR_EDITOR_CIMR_EVENT, typeof(OnPublisher))]
        //public void fireLoadEmrEditorCimrEvent(object sender, DataEventArgs<Dictionary<string, object>> args)
        //{
        //    Dictionary<string, object> paramDic = args.Data as Dictionary<string, object>;
        //    object ciMrDoObj = paramDic[EmrEditorConst.PARAM_CIMRDO];
        //    CiMrDO ciMrDO = ciMrDoObj == null ? null : ciMrDoObj as CiMrDO;
        //    object ent4BannerDTOobj = paramDic[EmrEditorConst.PARAM_ENT4BANNERDTO];
        //    Ent4BannerDTO ent4BannerDTO = ent4BannerDTOobj == null ? null : ent4BannerDTOobj as Ent4BannerDTO;
        //    if (ciMrDO != null)
        //    {
        //        this.SendLoadPubCiMrEvent(paramDic, true);// 加载病历
        //    }
        //    else
        //    {
        //        paramDic[EmrEditorConst.PARAM_CIMRDO] = this.CreateCiMrDO(ent4BannerDTO);
        //        this.SendLoadPubCiMrEvent(paramDic, false);// 加载病历模板
        //    }
        //}


        /// <summary>
        /// 接收根据初复诊切换病历事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="args"></param>
        [EventSubscription(EmrEditorConst.LOAD_FIRST_VISIT_EMR_EVENT, typeof(OnPublisher))]
        public void LoadFirstVisitEmrEvent(object sender, DictionaryEventArgs eventArgs)
        {
            if (SentLoadFirstVisitEmr != null)
                    SentLoadFirstVisitEmr(this, eventArgs);
        }

        
        /// <summary>
        /// 处置同步到病历（手动/自动）
        /// OpOrSysncro2MrHandleMode（CIOR0140） ：0自动同步、1手动同步
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="args"></param>
        [EventSubscription(CI_ORDER_FLUSH_EVENT, typeof(OnPublisher))]
        public void CiOrderRefeshSignToEmrEvent(object sender, DataEventArgs<CiOrderDO[]> args)
        {
            sendCiOrdersToEmr(args.Data,false);            
        }

        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取banner信息患者
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if (!(sender is bannerOpdocstation))
            {
                return;
            }

            BannerData bannerData = e.Object as BannerData;
            if (bannerData != null && bannerData.Ent4BannerDTO != null)
            {
                if (this.ent4BannerDTO != null && !this.ent4BannerDTO.Id_ent.Equals(bannerData.Ent4BannerDTO.Id_ent))
                {
                    List<string> founCode = new List<string>();
                    founCode.Add(AssistantConstant.FUN_CODE_CONTAGION_REPORT_CARD);
                    XapEvents.CloseOtherFuncEvent(founCode);
                }

                this.ent4BannerDTO = bannerData.Ent4BannerDTO;
                this.SendOpRevokeEnActionStatus(this.ent4BannerDTO);
            }
            else
            {
                this.ent4BannerDTO = null;
            }
        }

        #endregion

        #region 内部事件区域

        #endregion

        #region 辅助处理函数

        /// <summary>
        /// 获取当前患者信息
        /// </summary>
        private Dictionary<string, object> GetEnEmrDic(Ent4BannerDTO ent4BannerDTO)
        {
            Dictionary<string, object> paramDic = new Dictionary<string, object>();
            if (this.ent4BannerDTO != null)
            {
                // 获取患者信息
                EnEmrDTO enEmrDTO = iEnOutQryService.GetEntInfo4Mr(ent4BannerDTO.Id_ent);
                paramDic.Add("enEmrDTO", enEmrDTO);

                // 如果是诊闭状态，设置病历为只读状态
                if (EnDictCodeConst.SD_ENSTATUS_OP_FINISH.Equals(ent4BannerDTO.Sd_status))
                {
                    paramDic.Add("readonly", true);
                }
                else
                {
                    paramDic.Add("readonly", false);
                }
            }
            return paramDic;
        }

        /// <summary>
        /// 获取加载病历的环境参数
        /// </summary>
        /// <returns></returns>
        private DictionaryEventArgs GetCiMrArgsDic(Dictionary<string, object> paramDic)
        {
            object bannerObj = paramDic[EmrEditorConst.PARAM_ENT4BANNERDTO];
            Ent4BannerDTO ent4BannerDTO = bannerObj == null ? null : bannerObj as Ent4BannerDTO;

            if (ent4BannerDTO != null)
            {
                // 获取患者信息
                EnEmrDTO enEmrDTO = iEnOutQryService.GetEntInfo4Mr(ent4BannerDTO.Id_ent);
                paramDic.Add("enEmrDTO", enEmrDTO);

                // 如果是诊闭状态，设置病历为只读状态
                if (EnDictCodeConst.SD_ENSTATUS_OP_FINISH.Equals(ent4BannerDTO.Sd_status))
                {
                    paramDic.Add("readonly", true);
                }
                else
                {
                    paramDic.Add("readonly", false);
                }
            }

            DictionaryEventArgs args = new DictionaryEventArgs();
            foreach (string key in paramDic.Keys)
            {
                args.Data.Add(key, paramDic[key]);
            }

            return args;
        }

        /// <summary>
        /// 根据病历对象加载病历
        /// </summary>
        /// <param name="ciMrDO">病历对象</param>
        /// <param name="isLoadCiMr">true 加载病历，false 加载病历模板</param>
        private void SendLoadPubCiMrEvent(Dictionary<string, object> paramDic, bool isLoadCiMr)
        {
            DictionaryEventArgs eventArgs = this.GetCiMrArgsDic(paramDic);

            if (isLoadCiMr)
            {
                SentPubCiMrEvent(eventArgs);//加载病历
            }
            else
            {
                SentDefaultModel2PubCiMrEvent(eventArgs);// 加载病历模板
            }
        }

        /// <summary>
        /// 根据当前环境创建CiMrDO对象
        /// ent4BannerDTO 通过传参方式，如果使用本地onSelected方法中获取Ent4BannerDTO，可能出现在本地onSelected方法执行前，已经执行到该方法
        /// </summary>
        /// <returns></returns>
        private CiMrDO CreateCiMrDO(Ent4BannerDTO ent4BannerDTO)
        {

            CiMrDO ciMrDO = new CiMrDO();

            // 当前已选患者，但未保存过病历时，通过当前环境参数构造病历对象
            if (ent4BannerDTO != null)
            {

                // 获取当前登录用户所在院区及科室，这个两个参数确定调用哪个模板
                UserDO user = this.Context.User;
                string idOrg = this.Context.Org.Id_org;
                string idDep = this.Context.Dept.Id_dep;

                ciMrDO.Createdby = user.Id_user;
                ciMrDO.Createdtime = DateTime.Now;
                ciMrDO.Id_emp = user.Id_user;

                // 患者当前科室
                ciMrDO.Id_dep_pat = ent4BannerDTO.Id_dep_phy;
                // 就诊号
                ciMrDO.Id_ent = ent4BannerDTO.Id_ent;
                // 就诊类型
                ciMrDO.Code_entp = ent4BannerDTO.Code_entp;
                // 患者号
                ciMrDO.Id_pat = ent4BannerDTO.Id_pat;
                // 经治医师	取当前登录人
                ciMrDO.Id_treat_doctor = user.Id_user;

                // 医疗记录科室 (当前登录人科室)
                ciMrDO.Id_dep = ent4BannerDTO.Id_dep_phy;

            }

            return ciMrDO;
        }

        /// <summary>
        /// 设置撤回按钮是否可操作
        /// </summary>
        /// <param name="ent4BannerDTO"></param>
        private void SendOpRevokeEnActionStatus(Ent4BannerDTO ent4BannerDTO)
        {
            DictionaryEventArgs de = new DictionaryEventArgs();
            string id_dep = this.Context.Dept.Id_dep;
            // 病历管理模式:医生打印=0,病案统一打印=1,无纸化模式=2,医生手写=3
            string omrMgmtMd = this.Context.GetParam<string>(id_dep, ICiOrdNSysParamConst.SYS_PARAM_OMRMgmtMd);
            // 如果是无纸化模式（客户接受电子病历），不允许对已经诊闭病历进行撤回
            if (EmrEditorConst.OMR_MGMT_MD_2.Equals(omrMgmtMd))
            {
                de.Data.Add(UIConst.UI_EVENT, EmrEditorConst.OPREVOKEEN_ACTION_HIDDEN);
            }
            else
            {
                // 判断是否允许撤回
                bool isAllowRevoke = emrViewModel.IsAllowRevoke(omrMgmtMd, ent4BannerDTO);

                //如果允许撤回将撤回按钮设置为可操作状态
                if (isAllowRevoke)
                {
                    de.Data.Add(UIConst.UI_EVENT, EmrEditorConst.OPREVOKEEN_ACTION_OPERABLE);
                }
                else
                {
                    de.Data.Add(UIConst.UI_EVENT, EmrEditorConst.OPREVOKEEN_ACTION_READONLY);
                }
            }

            this.FireEventSent(this, de);
        }
       
    
        private void sendCiOrdersToEmr(CiOrderDO[] ciOrderDOs,Boolean diag)
        {

            //lxy
            //OrderMrDto[] mrDtos = ciservice.GetOrderMrDtoFlushList(ent4BannerDTO.Id_ent, ent4BannerDTO.Code_entp, ciOrderDOs);
            //EmrEditorCiViewModel ciViewModel = new EmrEditorCiViewModel();
            //if (mrDtos == null)
            //    return;
            //string ciOrderXmlStr = ciViewModel.convertCZToXmlStr(mrDtos, CI_ORDER_XML_CFG_PATH);
            //Dictionary<string, object> cidiDic = new Dictionary<string, object>();
            //cidiDic.Add(CI_ORDER_ITEM, ciOrderXmlStr);

            if (ciOrderDOs == null) return;

            //判断手动/自动
            string idDep = this.Context.Dept.Id_dep;

            string idPsndoc = this.Context.PsnInfo.Id_psndoc;
            string refreshMode = this.Context.GetParam<string>(idDep, ICiOrdNSysParamConst.SYS_PARAM_OpOrSysncro2MrHandleMode);
            Dictionary<string, object> cidiDic = new Dictionary<string, object>();
            List<String> lstIdors = new List<string>();
            ciOrderDOs.ToList<CiOrderDO>().ForEach(order => { lstIdors.Add(order.Id_or); });
            if (diag)
            {
                string cidiDOXmlStr = emrCiViewModel.convertZdToXmlStr(emrViewModel.GetDIDTO(ent4BannerDTO.Id_ent), CIDI_XML_CFG_PATH);

                cidiDic.Add(CIDI_ITEM, cidiDOXmlStr);
                if (refreshMode == "0")
                {
                    //new 2017-05-09  by yzh
                    FMap2 mrDtos = ciservice.GetOrderMrDtoFlushList2(ent4BannerDTO.Id_ent, ent4BannerDTO.Code_entp, lstIdors.ToArray(), idPsndoc, refreshMode);

                    if (mrDtos == null)
                    {
                        cidiDic.Add(CI_ORDER_ITEM, "");
                    }
                    else
                    {
                        Dictionary<string, object> cidiDicTemp = new Dictionary<string, object>();
                        foreach (string key in mrDtos.Keys)
                        {
                            string val = mrDtos[key] as string;
                            if (val == null)
                            {
                                cidiDicTemp.Add(key, "");
                            }
                            else
                            {
                                cidiDicTemp.Add(key, val);
                            }
                        }

                        cidiDic.Add(CI_ORDER_ITEM, cidiDicTemp);
                    }
                }

            }
            else
            {
                //new 2017-05-09  by yzh
                FMap2 mrDtos = ciservice.GetOrderMrDtoFlushList2(ent4BannerDTO.Id_ent, ent4BannerDTO.Code_entp, lstIdors.ToArray(), idPsndoc, refreshMode);

                if (mrDtos == null)
                {
                    cidiDic.Add(CI_ORDER_ITEM, "");
                }
                else
                {
                    Dictionary<string, object> cidiDicTemp = new Dictionary<string, object>();
                    foreach (string key in mrDtos.Keys)
                    {
                        string val = mrDtos[key] as string;
                        if (val == null)
                        {
                            cidiDicTemp.Add(key, "");
                        }
                        else
                        {
                            cidiDicTemp.Add(key, val);
                        }
                    }

                    cidiDic.Add(CI_ORDER_ITEM, cidiDicTemp);
                }
            }

            


          
            this.fireCiEmrSaveEvent(cidiDic);
        }
        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            DictionaryEventArgs de = new DictionaryEventArgs();
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.LOAD:
                    break;

                //case UIEvent.SAVE:// 点击保存按钮      
                //	//case OpActionConstant.OP_SUSPEND_ACTION: // 点击待回诊按钮
                //    this.fireCiEmrSaveEvent(new Dictionary<string, object>());
                //    break;

                //case OpActionConstant.EMR_PRINT_ACTION:// 打印病历事件

                //    de.Data.Add(UIConst.UI_EVENT, AssistantConstant.CI_EMR_PRINT_EVENT);
                //    this.FireEventSent(this, de);
                //    break;

                //case OpActionConstant.EMR_PRINT_VIEW_ACTION:// 病历打印预览事件

                //    de.Data.Add(UIConst.UI_EVENT, AssistantConstant.CI_EMR_PRINT_PRIVEW_EVENT);
                //    this.FireEventSent(this, de);
                //    break;

                case EventCodeType.EVENT_ORDI_SAVESUCCE:// 诊断保存成功事件

                    Dictionary<string, Object> dict = eventArgs.Data[UIConst.DATA] as Dictionary<string, Object>;
                    object dataObj = dict["DIDTOLIST"];
                    DIDTO[] didtos = dataObj == null ? null : (dataObj as List<DIDTO>).ToArray();
                    this.fireCidiWriteToEmrEvent(didtos);
                    break;
                case OpActionConstant.EMR_SYNC_CIDI_CIORD_ACTION: // 诊断处置同步到病历
                    //this.fireCidiWriteToEmrEvent(emrViewModel.GetDIDTO(ent4BannerDTO.Id_ent));//诊断回写到病历
                    if (null != emrViewModel && null != ent4BannerDTO && !string.IsNullOrEmpty(ent4BannerDTO.Id_ent))
                    {
                        this.sendCiOrdersToEmr(emrViewModel.GetCiOrderDOs(ent4BannerDTO.Id_ent), true);
                    }
                      
                    
                    
                    break;
                case OpActionConstant.EMR_SYNC_CIDI_ACTION:
                    this.fireCidiWriteToEmrEvent(emrViewModel.GetDIDTO(ent4BannerDTO.Id_ent));//诊断回写到病历
                    break;
                case OpActionConstant.EMR_SYNC_CIORD_ACTION:
                    this.sendCiOrdersToEmr(emrViewModel.GetCiOrderDOs(ent4BannerDTO.Id_ent),false);//处置回写到病历
                    break;
                case AssistantConstant.CI_EMR_WRITE_BACK_EVENT:// 就诊历史、组套病历段落回写触发事件
                    Dictionary<string, object> dataIdc = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    this.fireCiEmrWriteBackEvent(dataIdc);
                    break;
                case EmrEditorConst.OP_REVOKEEN_ACTION:
                    // 点击撤回按钮，设置病历的可编辑状态
                    this.SentModel2PubCiMrReadOnlyEvent();
                    break;
            }
        }

        #endregion
    }
}

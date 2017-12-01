using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using iih.ci.diag.cidiag.d;
using iih.ci.diag.cidiag.i;
using iih.ci.ord.cior.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.i;
using xap.cli.sdk.form;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.idvproperty.d;
using iih.ci.ord_stub.i;
using iih.en.pv.entdi.i;
using xap.rui.appfw;
using xap.rui.control.extentions;
using xap.rui.control.query.i;
using System;
using iih.ci.ord.i;
using xap.rui.control.engine.factory;
using iih.bd.pp.com.i;
using xap.sys.xbd.udi.d;
using iih.bd.bc.udi;
using iih.bd.pp.hp.d;
using iih.bd.pp.hp.i;
using xap.mw.serviceframework.ex;
using iih.en.pv.dto.d;
using xap.rui.engine;
using iih.ci.ord.ems.d;
using iih.ci.ord.common.utils;
using iih.ci.ord.moreemsdto.d;
using iih.ci.ord.ciord.d;
using iih.ci.ord.ciorder.cards.drugext.dialogform;
using iih.ci.ord.ciorder.orreport;
using iih.ci.ord.medicaresharing.mdeicalrule;
using xap.sys.xbd.udi.i;
using iih.bd.srv.ems.d;
using iih.ci.ord.ciorder.cards.thread;
using xap.mw.log;
using xap.cli.context;

/********************************************************************************

** 作者： 李政

** 创始时间：2016-6-30

** 修改人：李政

** 修改时间：2016-6-30

** 描述： 医嘱列表数据类


*********************************************************************************/

namespace iih.ci.ord.ciorder.viewmodel
{
    /// <summary>
    /// 医嘱项目
    /// </summary>
    /// Author:admin
    /// Date:2015-08-31
    public partial class OrderItemViewModel
    {
        #region 变量定义区域
        private IUdidocCrudService udidocService;
        private ICiorderMDOCrudService orderItemMService;
        private ICiOrdMaintainService maintainService;
        private IBsQueryService bsservice;
        private IEntdiCrudService entdiCrudService;
        private ICidiagCrudService diagservice;
        private ICiOrdQryService ciOrderQryService;
        private ICiorderCrudService qryService;
        private IBdHpUnlimitDrugDOCrudService bdHpUnlimitDrugDoCrudService;

        public XapDataList<CiOrderDO> xapList;
        public FDateTime stoptime;
        public CiOrderDO[] opsignords;//门诊已签署的医嘱（处置刷新到病历用）
        /// <summary>
        /// 服务类型的dic，
        /// key:服务类型（药品、血液 取前4位,其余取前两位） value:对应服务类型的显示名称（bd_didoc=0001ZZ2000000000000T 中ctr2字段）
        /// </summary>
        public Dictionary<string, string> sdSrvtpDic = new Dictionary<string, string>();

        protected string id_en, code_entp;
        private LogicEx logic = LogicEx.GetInstance();
        // 上下文对象
        private BaseContext context;
        // 医疗单应用模式
        private EmsAppModeEnum emsAppModeEnum;
        private string OrderSequenceModel;
        #endregion

        #region 构造函数
        public OrderItemViewModel(Ent4BannerDTO ent4BannerDto, BaseContext context, bool isOutPress = false)
        {
            this.id_en = ent4BannerDto.Id_ent;
            this.code_entp = ent4BannerDto.Code_entp;
            this.context = context;
          
            if (isOutPress)
            {//出院带药
                emsAppModeEnum = EmsAppModeEnum.OUTHEMSAPPMODE;
            }
            else if (EnDictCodeConst.SD_ENTP_INPATIENT == this.code_entp)//住院
            {
                emsAppModeEnum = EmsAppModeEnum.IVEMSAPPMODE;
            }
            else
            {//门诊或其他
                emsAppModeEnum = EmsAppModeEnum.SVEMSAPPMODE;
            }

            this.udidocService = XapServiceMgr.find<IUdidocCrudService>();
            this.orderItemMService = XapServiceMgr.find<ICiorderMDOCrudService>();
            this.maintainService = XapServiceMgr.find<ICiOrdMaintainService>();
            this.entdiCrudService = XapServiceMgr.find<IEntdiCrudService>();
            this.diagservice = XapServiceMgr.find<ICidiagCrudService>();
            this.qryService = XapServiceMgr.find<ICiorderCrudService>();
            this.bsservice = XapServiceMgr.find<IBsQueryService>();
            this.ciOrderQryService = XapServiceMgr.find<ICiOrdQryService>();
            this.bdHpUnlimitDrugDoCrudService = XapServiceMgr.find<IBdHpUnlimitDrugDOCrudService>();

            OrderSequenceModel = this.ciOrderQryService.getOrderSequenceMode();
        }
        #endregion

        #region 公共方法

        #region 医嘱操作
        /// <summary>
        /// 查询就诊医嘱
        /// </summary>
        /// <param name="id_en"></param>
        /// <param name="code_entp"></param>
        public void Reload(string id_en, string code_entp)
        {
            this.id_en = id_en;
            this.code_entp = code_entp;

            Reload();
        }

        /// <summary>
        /// 查询就诊医嘱
        /// </summary>
        public void Reload()
        {
            if (string.IsNullOrEmpty(this.id_en) || string.IsNullOrEmpty(this.code_entp))
            {
                if (this.xapList != null)
                    this.xapList.Clear();
                return;
            }

            // 获取服务类型显示名称
            if (sdSrvtpDic.Count == 0)
            {
                sdSrvtpDic = this.GetSdSrvtpDic();
            }

            CiOrderDO[] ciOrders = this.orderItemMService.find(getSearchSql(), " a0.createdtime  " + OrderSequenceModel, FBoolean.False);

            ciOrders.ToList().ForEach(p =>
            {
               
                p.Str_long = p.Fg_long.Value == true ? "长期" : "临时";
                if (p.Emp_stop_name == null || p.Emp_stop_name == "")
                {
                    p.Dt_end = null;
                } //如果没有停止医生 则医嘱列表停止时间 不显示 王琦需求
                if (!p.Fg_long.Value)
                {
                    p.Emp_stop_name = null;
                }
                if (!string.IsNullOrEmpty(p.Id_emp_sign) && !p.Id_emp_sign.Equals(p.Id_emp_or))
                {
                    p.Emp_sign_name = p.Emp_sign_name + "/" + p.Emp_phy_name;
                }
                else
                {
                    p.Emp_sign_name = p.Emp_phy_name;
                }
            });
            xapList = new XapDataList<CiOrderDO>(orderItemMService, ciOrders);
            //设定医嘱状态
            bool isOp = this.code_entp.Equals("00") ? true : false;
            logic.setOrderDisplayStatus(xapList, isOp);
            this.stoptime = CommonExtentions.NowTime(this);
        }

        /// <summary>
        /// 住院
        /// </summary>
        /// <param name="orders"></param>
        /// <param name="code"></param>
        /// <param name="id"></param>
        public void OnUpdateSu(CiOrderDO[] orders, string code, string id)
        {

            List<IdVProperty> idVdoList = new List<IdVProperty>();
            foreach (CiOrderDO order in orders)
            {
                IdVProperty idVdo = new IdVProperty();
                idVdo.Id = order.Id_or;
                idVdo.Ver = order.Sv;
                idVdoList.Add(idVdo);
            }

            FDateTime fa = new FDateTime();
            fa = this.stoptime;
            if (fa == null)
            {
                fa = LogicEx.GetInstance().GetSystemDateTime();
            }
            this.maintainService.updateOrdStatusInfo(idVdoList.ToArray(), fa, code);

        }

        /// <summary>
        /// 门诊撤回
        /// </summary>
        /// <param name="orders"></param>
        /// <param name="code"></param>
        /// <param name="id"></param>
        public CiOrderDO[] OPOnUpdateSu(CiOrderDO[] orders, string code, string id)
        {

            String[] id_ors = new string[orders.Count()];
            int i = 0;
            foreach (CiOrderDO order in orders)
            {

                id_ors[i] = order.Id_or;
                i++;

            }

            FDateTime fa = new FDateTime();
            fa = this.stoptime;
            if (fa == null)
            {
                fa = LogicEx.GetInstance().GetSystemDateTime();
            }
            return this.maintainService.ciOrderSignBack(id_ors, id);

        }

        /// <summary>
        /// 签署
        /// </summary>
        /// <param name="orders"></param>
        /// <param name="ent4BannerDto"></param>
        /// <returns></returns>
        public bool SignCiOrder(CiOrderDO[] orders, Ent4BannerDTO ent4BannerDto)
        {
            if (orders.Count() == 0)
                return false;
            // 增加就诊上下文环境，用户医嘱签署时，在医嘱中保存保外诊断相关属性
            CiEnContextDTO contextDTO = CiEnContextUtil.GetCiEnContext(ent4BannerDto, this.emsAppModeEnum, this.context);
            List<string> idors = orders.Select(p => p.Id_or).ToList();
            // 签署，如果不满足签署条件返回提示信息
            ValidateRtnInfoDTO vlInfoDto = this.maintainService.ciOrderSign(idors.ToArray(), contextDTO);
            FMap2 fm1 = vlInfoDto.Scenedatum;
            if (fm1 != null && fm1["specilDrugs"] != null)
            {
                if (this.IsContinue("提示", fm1["specilDrugs"].ToString()))
                {
                    return false;
                }
            }
            if (fm1 != null && fm1["willCheckIdOrs"] != null)
            {
                //医保和临床路径未判断的话，就弹窗进行判断
                FArrayList willCheckIdOrs = (FArrayList)fm1["willCheckIdOrs"];
                string[] id_ors = willCheckIdOrs.Cast<string>().ToArray();
                OrReport report = new OrReport(id_ors);
                DialogResult result = report.ShowDialog(XFormManager.MainFrom);
                if (result == DialogResult.OK)
                {
                    return SignCiOrder(orders, ent4BannerDto);
                }
                else
                {
                    return false;
                }
            }
            //开立权限校验
            if (fm1 != null && fm1.Keys.Contains("UnCheckIdors"))
            {
                FArrayList uncheckidList = fm1["UnCheckIdors"] as FArrayList;
                List<string> uncheckids = uncheckidList.Cast<String>().ToList();// fm1["UnCheckIdors"].ToString().Substring(1, fm1["UnCheckIdors"].ToString().Length-2).Split(',').ToList();
                if (uncheckids.Count == orders.Length)
                {
                    this.ShowInfo(fm1["ErrMsg"].ToString());
                    return false;
                }
                if (!this.IsContinue("提示", fm1["ErrMsg"] + "是否继续？"))
                {
                    return false;
                }
                else
                {
                    if (uncheckids.Count > 0)
                    {
                        List<CiOrderDO> ciordlist = orders.ToList();
                        foreach (string idor in uncheckids)
                        {

                            ciordlist.Remove(ciordlist.Find(p => p.Id_or == idor.Trim()));
                        }
                        return SignCiOrder(ciordlist.ToArray(), ent4BannerDto);
                    }
                    else
                    {
                        if (!this.IsContinue("提示", fm1["ErrMsg"] + "是否继续？"))
                        {
                            return false;
                        }
                        else
                        {
                            if (uncheckids.Count > 0)
                            {
                                List<CiOrderDO> ciordlist = orders.ToList();
                                foreach (string idor in uncheckids)
                                {

                                    ciordlist.Remove(ciordlist.Find(p => p.Id_or == idor.Trim()));
                                }
                                return SignCiOrder(ciordlist.ToArray(), ent4BannerDto);
                            }
                        }
                    }
                }
            }
            FMap2 HpMesage = vlInfoDto.Rtnvalue;
            if (HpMesage != null)
            {
                String message = (String)HpMesage["HPMessage"];
                if (message != null)
                { 
                    this.ShowInfo(message);
                    vlInfoDto = this.maintainService.CiOrderSignMedicalInsurance(vlInfoDto.Scenedatum, code_entp);
                }
            }
            FMap2 fm = vlInfoDto.Rtnvalue;
            if (fm1 != null && fm1["checkPatInfoSrvs"] != null)
            {
                // 如果是毒麻药，需要保存代理人信息
                FArrayList checkPatInfoSrvs = (FArrayList)fm1["checkPatInfoSrvs"];
                OrSrvAgentInfoDO agentInfo = LogicEx.GetInstance().newOrSrvAgentInfoDOFromBanner(ent4BannerDto);
                CheckPatAgentInfoDialog dialog = new CheckPatAgentInfoDialog(agentInfo, checkPatInfoSrvs);
                if (dialog.ShowDialog() == DialogResult.OK)
                {
                    this.maintainService.saveCheckPatInfo(checkPatInfoSrvs, agentInfo);
                }
                else
                {
                    return false;
                }
            }
            this.InitMrSignCiOrderList(vlInfoDto);
            ReactExtOrsAndStopOrsDO redo = (ReactExtOrsAndStopOrsDO)fm["willstopors"];
            if (!(redo != null && redo.Reactextdos != null && redo.Stopordos != null))
            {
                if (fm1 != null)
                {
                    vlInfoDto = maintainService.ciOrderSignStep1(fm1, ent4BannerDto.Code_entp, contextDTO);
                    this.InitMrSignCiOrderList(vlInfoDto);
                }
                return true;
            }
            fm1.Add("willstopors", redo);
            FArrayList fa2 = new FArrayList();
            FArrayList extdo = redo.Reactextdos;
            FArrayList wildo = redo.Stopordos;
            if (extdo != null && wildo != null)
            {
                string strReactType = "";
                string modifyStopTimeSrvs = "";//修改停止时间的服务名称串
                string addStopTimeSrvs = "";//添加停止时间的服务名称串
                if (extdo.Count > 0) {
                    int? reacttype = (extdo[0] as CiorderAggExtDO).Reacttype;
                    string name_or = (extdo[0] as CiorderAggExtDO).Aggdo.getParentDO().Name_or;
                    if (reacttype != null) {
                        if ((int)reacttype == 1)
                        {
                            strReactType = "全排斥";
                        }
                        else if ((int)reacttype == 2)
                        {
                            strReactType = "组内排斥";
                        }
                    }
                    foreach (CiOrderDO stopordo in wildo)
                    {
                        if (stopordo.Fg_stop == null || stopordo.Fg_stop == false)
                        {
                            addStopTimeSrvs += stopordo.Name_or + ",";
                        }
                        else
                        {
                            modifyStopTimeSrvs += stopordo.Name_or + ",";
                        }
                    }
                    if (addStopTimeSrvs.Length > 0)
                    {
                        addStopTimeSrvs = addStopTimeSrvs.Substring(0, addStopTimeSrvs.Length - 1);
                    }
                    if (modifyStopTimeSrvs.Length > 0)
                    {
                        modifyStopTimeSrvs = modifyStopTimeSrvs.Substring(0, modifyStopTimeSrvs.Length - 1);
                    }
                    string msg = reactOrWarnInfo(name_or,strReactType,addStopTimeSrvs,modifyStopTimeSrvs);
                    var a = MessageBoxEx.Show(msg, "医嘱排斥", MessageBoxButtons.YesNo);
                    if (a == DialogResult.Yes)
                    {
                        maintainService.ciOrderSignStep1(fm1, ent4BannerDto.Code_entp, contextDTO);
                    }
                    else
                    {
                        return false;
                    }
                }
               
            }
            return true;
        }

        /// <summary>
        /// 重新分方
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="sd_entp"></param>
        /// <returns></returns>
        public String[] CiOPAgainPres(string id_ent, string id_dep_sign, string sd_entp, Ent4BannerDTO patDo, BaseContext Context)
        {
            string[] ids = null;
            CiEnContextDTO contextDTO = CiEnContextUtil.GetCiEnContext(patDo, Context);
            CiOrderDO[] orders = this.maintainService.CiOPAgainPres(id_ent, id_dep_sign, sd_entp, contextDTO);
            if (orders != null && orders.Length > 0)
            {
                int i = 0;
                ids = new string[orders.Length];
                foreach (CiOrderDO ord in orders)
                {
                    ids[i] = ord.Id_or;
                    i++;
                }
            }
            return ids;
        }

        /// <summary>
        /// 删除
        /// </summary>
        /// <param name="ciOrder"></param>
        public bool DelOrd(CiOrderDO[] ciOrder)
        {
            string[] id_orders = null;
            if (ciOrder != null)
            {
                id_orders = new string[ciOrder.Length];
                int i = 0;
                foreach (CiOrderDO orderdo in ciOrder)
                {
                    id_orders[i] = orderdo.Id_or;
                    i++;
                }
            }
            //记录删除信息日志
            log(ciOrder);
           return maintainService.relDeleteOrder(id_orders);
        }
        /// <summary>
        /// //记录删除信息日志
        /// </summary>
        /// <param name="ciOrder"></param>
        private void log(CiOrderDO[] ciOrder)
        {
            if (ciOrder == null) return;
            foreach (CiOrderDO orderdo in ciOrder)
            {
                LogManager.GetLogger().InfoEx("删除医嘱信息--时间 " + new FDateTime() + "患者：" + orderdo.Id_pat + "删除医生：" + UserManager.getInstance().CurrentPsnInfo.Name + "," + UserManager.getInstance().CurrentPsnInfo.Id_psndoc);
            }
        }
        #endregion

        /// <summary>
        ///  当前就诊信息
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        public bool getEntDiDOS(string id_ent)
        {
            CidiagAggDO[] diaglist = this.diagservice.find(" a0.fg_sign ='Y' and a0.id_en ='" + id_ent + "'", "", FBoolean.False);

            //EntDiDO[]  entdi =  this.entdiCrudService.find("a0.id_ent ='" + id_ent + "'", "", FBoolean.False);
            if (diaglist != null && diaglist.Length > 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        /// <summary>
        /// 医保共享数据 是否调用医保共享数据参数
        /// </summary>
        /// <param name="id_org"></param>
        /// <param name="id_dept"></param>
        /// <returns></returns>
        public FBoolean getIsDeptOrDatumshared(string id_org, string id_dept)
        {
            return this.ciOrderQryService.getIsDeptOrDatumshared(id_org, id_dept);
        }

        /// <summary>
        /// 医保共享排斥数据
        /// </summary>
        /// <param name="id_hp"></param>
        /// <returns></returns>
        public Dictionary<string, BdHpUnlimitDrugDO> getDictbdHpUnlimitDrug(string id_hp)
        {
            string WhereStr = "id_hp ='" + id_hp + "'";
            BdHpUnlimitDrugDO[] limitDrug = this.bdHpUnlimitDrugDoCrudService.find(WhereStr, "", new FBoolean());
            Dictionary<string, BdHpUnlimitDrugDO> dict = null;
            if (limitDrug != null && limitDrug.Length > 0)
            {
                dict = new Dictionary<string, BdHpUnlimitDrugDO>();
                foreach (BdHpUnlimitDrugDO drugDO in limitDrug)
                {
                    dict.Add(drugDO.Code_hp, drugDO);
                }
                MedicalSharingCache.setBdHpUnlimitDrugDO(dict);
            }
            return dict;
        }

        /// <summary>
        /// 医生站记账
        /// </summary>
        /// <param name="id_ent">就诊id</param>
        /// <param name="code_entp">就诊类型</param>
        /// <param name="accountType">记账类型 </param>
        ///  @DmEnumDesc(name="预交金记账",description="预交金记账")
        ///  public static final String CG_PREPAY="1"; //预交金记账
        ///  @DmEnumDesc(name= "高端商保记账", description= "高端商保记账")
        ///  public static final String CG_HPCG="2"; //高端商保记账
        /// <returns>记账结果</returns>
        public string OrderKeepAccounts(String id_ent, String code_entp, String accountType, string id_psndoc)
        {
            return this.maintainService.OrderKeepAccounts(id_ent, code_entp, accountType, id_psndoc);
        }

        /// <summary>
        /// 预交金销账
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="code_entp"></param>
        /// <param name="AcctountType"></param>
        /// <returns></returns>
        public string CancelOrderAccounting(String id_ent, String code_entp, string id_psndoc)
        {
            return this.maintainService.CancelOrderAccounting(id_ent, code_entp, id_psndoc);
        }

        public CiOrderDO[] getCiOrderDOArray(string[] ids)
        {
            return orderItemMService.findByBIds(ids, false);
        }

        public string getCiOrderAggDoArray(CiOrderDO[] orders, DateTime stopTime)
        {
            List<string> list = new List<string>();
            foreach (CiOrderDO ciorder in orders)
            {
                list.Add(ciorder.Id_or);
            }

            CiorderAggDO[] aggs = qryService.findByIds(list.ToArray(), false);
            foreach (CiorderAggDO aggdo in aggs)
            {
                CiOrderDO od = aggdo.getParentDO();
                if (od.Dt_effe > stopTime)
                {
                    //this.ShowInfo("“停止时间”不能小于医嘱生效时间！");
                    return "“停止时间”不能在医嘱生效时间之前！";
                }
                OrdSrvDO[] orsrvfo = aggdo.getOrdSrvDO();
                foreach (OrdSrvDO srvd in orsrvfo)
                {
                    if (srvd.Dt_last_mp > stopTime)
                    {
                        // this.ShowInfo("“停止时间”之后有医嘱已被执行！");
                        return "“停止时间”之后有医嘱已被执行！";
                    }
                }
            }

            return "";
        }

        public string getOrderSequenceModel()
        {
            return this.OrderSequenceModel;
        }

        public MoreEmsParamDTO copyAdd(string[] id_ors, CiEnContextDTO ciEnContext)
        {
            return ciOrderQryService.getCiEmsCopyByOrdIds(id_ors, ciEnContext);
        }

        /// <summary>
        /// 多用户操作下的医嘱状态校验
        /// </summary>
        /// <param name="orders"></param>
        /// <returns></returns>
        public FMap2 JudgeOrderStatusInMultiUser(CiOrderDO[] orders, string id_dep_phy,string id_dep_nur, string validateType)
        {
            return ciOrderQryService.JudgeOrderStatusInMultiUser(orders, id_dep_phy,id_dep_nur, validateType);
        }

        /// <summary>
        /// 获取当前登录人未签署的药品
        /// </summary>
        /// <param name="patDo"></param>
        /// <returns></returns>
        public CiOrderDO[] getCiOrders(Ent4BannerDTO patDo)
        {
            String whereStr = " ID_EN ='" + patDo.Id_ent + "' and "
                          + " CODE_ENTP ='" + patDo.Code_entp + "' and "
                          + " SD_SU_OR ='0' and id_emp_or = '" + this.context.PsnInfo.Id_psndoc + "' and "
                          + " SD_SRVTP like '0101%' ";
            return this.orderItemMService.find(whereStr, "", FBoolean.False);
        }

        /// <summary>
        /// 高端商保删除
        /// </summary>
        /// <param name="idOrs"></param>
        /// <param name="id_psndoc"></param>
        /// <param name="ciEnContextDTO"></param>
        /// <returns></returns>
        public String setOrderRefundBillCancelReserve(String[] idOrs, String id_psndoc, Ent4BannerDTO ent4BannerDto)
        {
            CiEnContextDTO contextDTO = CiEnContextUtil.GetCiEnContext(ent4BannerDto, this.emsAppModeEnum, this.context);
            return this.maintainService.setOrderRefundBillCancelReserve(idOrs, id_psndoc, contextDTO);
        }
        #endregion

        #region 私有方法
        /// <summary>
        /// 获取同步到病历中的处置数据（处置的签署和校验逻辑有待调整，调整后同步修改同步到病历逻辑）
        /// </summary>
        /// <param name="vlInfoDto"></param>
        private void InitMrSignCiOrderList(ValidateRtnInfoDTO vlInfoDto)
        {
            FMap2 fm = vlInfoDto.Rtnvalue;

            if (fm["ciors"] != null)
            {   // 换成当前签署的医嘱,用于同步到病历
                FArrayList ordlist = (FArrayList)fm["ciors"];
                List<CiOrderDO> signlist = new List<CiOrderDO>();
                if (ordlist == null) return;
                foreach (CiOrderDO ord in ordlist)
                {
                    signlist.Add(ord);
                }
                this.opsignords = signlist.ToArray();
            }
        }

        private string reactOrWarnInfo(string name_or, string reactType,string addStopTimeSrvs, string modifyStopTimeSrvs)
        {
            if (string.IsNullOrEmpty(addStopTimeSrvs) && string.IsNullOrEmpty(modifyStopTimeSrvs )) {
                return null;
            }
            if (!string.IsNullOrEmpty(addStopTimeSrvs) && !string.IsNullOrEmpty(modifyStopTimeSrvs)) {
                return "医嘱"+name_or + "和" + addStopTimeSrvs + "," + modifyStopTimeSrvs + "发生" + reactType + "，即将停止医嘱" + addStopTimeSrvs + ",修改医嘱" + modifyStopTimeSrvs + "的停止时间。\r\n是否继续？";
            }
            if(!string.IsNullOrEmpty(addStopTimeSrvs)){
                return "医嘱" + name_or + "和" + addStopTimeSrvs + "发生" + reactType + "，即将停止医嘱" + addStopTimeSrvs + "！\r\n是否继续。";
            }
            if (!string.IsNullOrEmpty(modifyStopTimeSrvs)) {
                return "医嘱" + name_or + "和" + modifyStopTimeSrvs + "发生" + reactType + "，即将修改医嘱" + modifyStopTimeSrvs + "的停止时间。\r\n是否继续？";
            }
            return null;
        }

        protected virtual string getSearchSql()
        {
            //不包含医技补费的医嘱和已销账医嘱
            return string.Format("a0.id_en='{0}' and a0.code_entp='{1}' and a0.fg_pres_outp='N' and a0.eu_orsrcmdtp!='{2}' and (a0.eu_feereversetp is null or a0.eu_feereversetp<>1)", this.id_en, this.code_entp, OrSourceFromEnum.IIHMEDTECHORDERS);
        }

        /// <summary>
        /// 获取服务类型的显示名称Dic
        /// key:服务类型（药品、血液 取前4位,其余取前两位） value:对应服务类型的显示名称（bd_didoc=0001ZZ2000000000000T 中ctr2字段）
        /// </summary>
        /// <returns>务类型的Dic对象</returns>
        private Dictionary<string, string> GetSdSrvtpDic()
        {
            Dictionary<string, string> sdSrvtpDic = new Dictionary<string, string>();

            string condition = "id_udidoclist = '" + CiDictCodeConst.SD_CI_UIDOC_SRVTP_ID +
                "' and (length(code)=2  or code = '" + BdSrvTpDictCodeConst.SD_SRVTP_WESTDRUG + "' or code = '" + BdSrvTpDictCodeConst.SD_SRVTP_HERBDRUG + "'  or code = '" + BdSrvTpDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE + "')";
            UdidocDO[] udidocs = udidocService.find(condition, null, FBoolean.False);
            foreach (UdidocDO udidoc in udidocs)
            {
                sdSrvtpDic.Add(udidoc.Code, udidoc.Ctrl2);

            }
            return sdSrvtpDic;
        }

        #endregion
    }
}

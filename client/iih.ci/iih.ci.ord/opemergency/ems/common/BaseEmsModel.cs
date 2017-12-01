using System;
using System.Collections.Generic;
using System.Linq;
using iih.en.pv.dto.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.i;
using iih.ci.ord_stub.i;
using xap.mw.serviceframework;
using iih.ci.ord.ciorder.d;
using xap.mw.core.data;
using xap.rui.control.extentions;
using xap.rui.appfw;
using iih.ci.ord.opemergency.ems.common;
using iih.bd.bc.udi;
using iih.bd.srv.freqdef.i;
using iih.bd.srv.medsrv.i;
using iih.ci.ord.opemergency.tool;
using iih.bd.srv.ems.d;
using iih.ci.ord.common.utils;
using xap.mw.coreitf.d;
using iih.ci.diag.cidiag.d;
using iih.ci.diag_stub.i;
using xap.rui.engine;
using iih.bd.srv.medsrv.d;
using iih.ci.iih.ci.ord.ems.d;
using iih.ci.ord.opemergency.declare;
using xap.cli.sdk.common.globalization;
using iih.ci.ord.dto.emsmain;
using iih.ci.iih.ci.ord.i;
using iih.ci.ord.dto.d;

namespace iih.ci.ord.opemergency.ems.dp
{
    /// <summary>
    /// <para>描    述 :  医疗单数据模型基类        	</para>
    /// <para>说    明 :                      			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ems.dp    </para>    
    /// <para>类 名 称 :  BaseEmsViewModel			</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/6/30 16:27:45             </para>
    /// <para>更新时间 :  2016/6/30 16:27:45             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class BaseEmsViewModel : BaseBizViewModel, IEmsModel
    {
        // 服务定义
        protected ICiOrdQryService ciOrdQryService;
        protected ICiOrdMaintainService ordMaintainService;
        protected ICidiagQryService cidiagQryService;
        protected ICiOrdMedicalInsuranceService ciOrdMedicalInsuranceService; // 医保相关接口


        // 检验检查工具类
        protected AppObsAndlabUtil obslabUtil = new AppObsAndlabUtil();
        protected OrCIEmsTOUIEms orCiEmsToUiEms = new OrCIEmsTOUIEms();
        protected OrDataBing orDataBing = new OrDataBing();
        protected OrDataConvert orDataConvert = new OrDataConvert();


        protected EmsUIDTO uiEmsDTO;
        protected CiEmsDTO ciEmsDTO;
        protected CiOrderDO ciOrder;
        protected SrvMatchEmsRstDTO emsMgrDTO;
        protected XapDataList<EmsOrDrug> _expenseList = new XapDataList<EmsOrDrug>();

        protected String strSd_srvtp = "";
        public XapDataList<EmsOrDrug> expenseList
        {
            get
            {
                return this._expenseList;
            }
            set
            {
                this._expenseList = value;
            }
        }


        public BaseEmsViewModel(Ent4BannerDTO ent)
            : base(ent)
        {

        }
        public BaseEmsViewModel setEmsMatchRstDTO(SrvMatchEmsRstDTO EmsMgrDTO)
        {
            this.emsMgrDTO = EmsMgrDTO;
            return this;
        }
        /// <summary>
        /// 初始化操作，做一些对象的实例化，以及常量赋值等操作
        /// </summary>
        public override void Init()
        {
            this.ordMaintainService = XapServiceMgr.find<ICiOrdMaintainService>();
            this.ciOrdQryService = XapServiceMgr.find<ICiOrdQryService>();
            this.cidiagQryService = XapServiceMgr.find<ICidiagQryService>();
            this.ciOrdMedicalInsuranceService = XapServiceMgr.find<ICiOrdMedicalInsuranceService>();

            this.uiEmsDTO = this.logicEx.CreatEmsIntance();
            this.ciEmsDTO = this.logicEx.CreatEmsDTO();

            // 初始化数据绑定对象上下文
            this.orDataBing.patDo = this.ent4BannerDTO;
            // 初始化UI数据模型集合中患者就诊信息对象
            this.uiEmsDTO.PatInfo = this.ent4BannerDTO;
            uiEmsDTO.EmsType = EmsType.COMMONDRUG;
        }



        /// <summary>
        /// 新增空行数据
        /// </summary>
        /// <returns></returns>
        public virtual object AddNew()
        {
            return null;
        }

        protected virtual void HandleExpenseItems(CiEmsDTO ciEmsDTO)
        {
            // 处理分拣费用项目
            this.expenseList.Clear();
            var szEmsOrDrug = this.PickupExpense(ciEmsDTO);
            if (null != szEmsOrDrug)
            {
                var itemList = szEmsOrDrug.ToList();
                // itemList.Sort((x, y) => x.Sortno > y.Sortno ? 1 : -1); // -- 后者在.net4.0报错
                itemList.OrderBy(p => p.Sortno).ToList().ForEach(p =>
                {
                    HandleUnitInfo(p);
                    HandleTotlePriceInfo(p);
                    this.expenseList.Add(p);
                });
            }
        }

        protected EmsRstDTO[] CreateRemote(String id_srv, String id_mm = null, Dictionary<String, Object> ctmInfo = null)
        {
            ICiEmsMainService emsMainService = XapServiceMgr.find<ICiEmsMainService>();
            if (null != emsMainService)
            {
                EmsCrtDTO[] emsCrts = new EmsCrtDTO[1];
                var emsCrt = new EmsCrtDTO();
                emsCrt.Id_srv = id_srv;
                emsCrt.Id_mm = id_mm;
                emsCrt.EmsMgrInfo = this.emsMgrDTO;
                emsCrt.EnContext = CiEnContextUtil.GetCiEnContext(this.GetEnt4BannerDTO(), this.GetContext());
                emsCrt.EmsDriver = ((int)this.uiEmsDTO.EmsType).ToString();
                emsCrt.OperateSourceFrom = IOprSourceFromConst.IOSF_EMS;
                if (null != ctmInfo)
                {
                    emsCrt.Extension = new FMap2();
                    foreach (String key in ctmInfo.Keys)
                    {
                        emsCrt.Extension.Add(key, ctmInfo[key]);
                    }
                }
                emsCrts[0] = emsCrt;
                return emsMainService.create(emsCrts);
            }
            return null;
        }

        protected EmsRstDTO SaveRemote(Object uiModel)
        {
            ICiEmsMainService emsMainService = XapServiceMgr.find<ICiEmsMainService>();
            var emsSave = new EmsSaveDTO();
            emsSave.Document = new FArrayList();
            emsSave.Document.Add(uiModel);
            emsSave.EnContext = CiEnContextUtil.GetCiEnContext(
                this.GetEnt4BannerDTO(), 
                EmsAppModeEnum.SVEMSAPPMODE, 
                OrSourceFromEnum.IIHSRVREF, 
                this.GetContext());
            emsSave.EmsDriver = ((int)this.uiEmsDTO.EmsType).ToString();
            emsSave.OperateSourceFrom = IOprSourceFromConst.IOSF_EMS;
            return emsMainService.save(emsSave);
           
        }



        protected EmsRstDTO[] LoadRemote(String id_or, Dictionary<String, Object> ctmInfo = null)
        {
            ICiEmsMainService emsMainService = XapServiceMgr.find<ICiEmsMainService>();
            if (null != emsMainService)
            {
                EmsLoadDTO[] emsloads = new EmsLoadDTO[1];
                var emsload = new EmsLoadDTO();
                emsload.Id_or = id_or;
                emsload.Extension = new FMap2();
                emsload.EnContext = CiEnContextUtil.GetCiEnContext(this.GetEnt4BannerDTO(), this.GetContext());
                emsload.EmsDriver = ((int)this.uiEmsDTO.EmsType).ToString();
                emsload.OperateSourceFrom = IOprSourceFromConst.IOSF_EMS;
                if (null != ctmInfo)
                {
                    emsload.Extension = new FMap2();
                    foreach (String key in ctmInfo.Keys)
                    {
                        emsload.Extension.Add(key, ctmInfo[key]);
                    }
                }
                emsloads[0] = emsload;
                return emsMainService.load(emsloads);
            }
            return null;
        }



        /// <summary>
        /// 编辑医嘱内容时候需要将 医嘱内容转化为医嘱项目
        /// </summary>
        public virtual void EditOrder(CiOrderDO ciOrderDO)
        {
            FMap fmap = this.ciOrdQryService.getCiEmsDTO(new string[] { ciOrderDO.Id_or });
            this.ciEmsDTO = fmap[ciOrderDO.Id_or] as CiEmsDTO;
            this.ciEmsDTO.SetUpdated();
            this.uiEmsDTO.Status = DOStatus.UPDATED;
            this.uiEmsDTO.MedSrvDO = XapServiceMgr.find<IMedsrvMDOCrudService>().findById(ciEmsDTO.Id_srv);
            // 处理分拣费用项目
            HandleExpenseItems(ciEmsDTO);
        }

        public virtual void EditEms(CiEmsDTO ems)
        {

            this.ciEmsDTO = ems;
            this.uiEmsDTO.MedSrvDO = XapServiceMgr.find<IMedsrvMDOCrudService>().findById(ems.Id_srv);

            // 处理分拣费用项目
            HandleExpenseItems(ems);
        }


        /// <summary>
        /// 从药品服务对象中加载医嘱服务项目
        /// </summary>
        /// <param name="med">药品服务对象</param>
        /// EmsCreateParameter
        public virtual bool LoadMedSrv(EmsCreatedParameter emsCreateParameter, int pos = -1)
        {
            if (pos == -1)
                this.expenseList.Clear();
            this.ciEmsDTO.Eu_orsrcmdtp = OrSourceFromEnum.IIHSRVREF;//医嘱来源方式
            if (this.emsMgrDTO != null)
            {
                this.uiEmsDTO.Id_srvof = this.emsMgrDTO.Id_ems;
                this.uiEmsDTO.Funcclassstr = this.emsMgrDTO.Funcclassstr;
                this.ciEmsDTO.Fg_quickwflow = this.emsMgrDTO.Fg_quickwflow;
                this.ciEmsDTO.Id_srvof = this.emsMgrDTO.Id_ems;
                this.ciEmsDTO.Funcclassstr = this.emsMgrDTO.Funcclassstr;
            }
            return true;
        }

        /// <summary>
        /// 创建医疗单
        /// </summary>
        /// <param name="id_srv"></param>
        /// <param name="id_mm"></param>
        /// <returns></returns>
        public virtual bool CreateEmsFrom(string id_srv, string id_mm)
        {
            return false;
        }

        /// <summary>
        /// 根据列表索引删除医嘱项目
        /// </summary>
        /// <param name="index">行号索引</param>
        public virtual void DeleteItemData(int index)
        {
            throw new NotImplementedException();
        }

        /// <summary>
        /// 根据医嘱服务项目对象删除列表数据
        /// </summary>
        /// <param name="value">行数据对象</param>
        public virtual void DeleteItemData(object value)
        {
            throw new NotImplementedException();
        }

        /// <summary>
        /// 医嘱保存到服务器端
        /// </summary>
        public virtual CiOrderDO Save2Order()
        {
            // 保存之前的存储模型的转化
            this.orDataConvert.SaveCiDTO(this.uiEmsDTO, this.ciEmsDTO, 0);

            // 个性化补充操作
            OnBeforeCallServiceSave(this.ciEmsDTO);

            // 远程调用服务器保存,并返回 CiOrder 
            CiOrderDO ciorder = ordMaintainService.SaveCiEmsDTO(this.ciEmsDTO, BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO);
            if (ciorder != null && ciorder.Mdicalinfo != null)
            {

                medicalInfoCache.setMedicalinfo("Id", ciorder.Mdicalinfo);
            }
            return ciorder;
            //return ordMaintainService.SaveCiEmsDTO(this.ciEmsDTO, BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO);
        }
        /// <summary>
        /// 新的医嘱保存返回集合
        /// </summary>
        /// <returns></returns>
        public virtual CiOrderTransMissionDTO SaveNew()
        {
            // 保存之前的存储模型的转化
            this.orDataConvert.SaveCiDTO(this.uiEmsDTO, this.ciEmsDTO, 0);

            // 个性化补充操作
            OnBeforeCallServiceSave(this.ciEmsDTO);

            // 远程调用服务器保存,并返回 CiOrder 
            CiOrderTransMissionDTO transMissionDto = ordMaintainService.SaveCiEmsDTONew(this.ciEmsDTO, BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO);
            //if (ciorder != null && ciorder.Mdicalinfo != null)
            //{

            //    medicalInfoCache.setMedicalinfo("Id", ciorder.Mdicalinfo);
            //}
            return transMissionDto;
        }


        protected virtual void OnBeforeCallServiceSave(CiEmsDTO ems)
        {
            // TODO: 费用数据 -> ciemsdto(合并)
            if (expenseList.Count > 0)
            {
                this.MergeExpenseSrv(this.expenseList.ToArray(), ems);
            }

            if (ems.Times_cur == null)
            {
                ems.Times_cur = CalQuantumUtil.GetInstance().getTotalTimes(ems.Id_freq, ems.Days_or);
            }

            //if (ems.Freqct != null && ems.Days_or != null&& ems.Times_mp_in == null && ems.Fg_mp_in != null && ems.Fg_mp_in.GetValueOrDefault(false)) {
            //    ems.Times_mp_in = ems.Freqct * ems.Days_or;
            //}

            //门诊中频次为once，使用天数设置为0；结束时间=开始时间+使用天数
            ciUseDayAndDtEnd(ems);

            // 添加基本医保判断结果属性
            // 第一位 医保就诊为1 非医保就诊为0
            // 第二位 黑白名单： 白名单为0 黑名单为 1 非医保就诊时为9 
            // 第三位 是否为保外诊断：保外诊断 0 保内诊断 1 非医保就诊时为 9
            CiEnContextDTO contextDTO = CiEnContextUtil.GetCiEnContext(this.ent4BannerDTO, EmsAppModeEnum.SVEMSAPPMODE);
            
            ems.Fg_vip = this.ent4BannerDTO.Fg_gcvip;//vip标识
            ems.Bhpjudgerst = contextDTO.Bhpjudgerst;
            ems.Des_bhpjudgerst = contextDTO.Des_bhpjudgerst;
            //医保保外诊断的处理，fg_selfpay=Y,fg_indic=false
            foreach (CiEmsSrvDTO ciemssrvdto in ems.Emssrvs)
            {
                HpJudgeUtil.HandleCiEmsSrvDTOHPInfo(ciemssrvdto);
            }
        }
        protected void ciUseDayAndDtEnd(CiEmsDTO ciemsdto)
        {
            //频次类型为once，使用天数设置为0,长临标识为false
            if ((string.IsNullOrEmpty(ciemsdto.Sd_frequnitct)) && ciemsdto.Id_freq != null)
            {
                var freqdef = XapServiceMgr.find<IFreqdefMDOCrudService>();
                var freq = freqdef.findById(ciemsdto.Id_freq);
                if (freq != null)
                {
                    if (freq.Sd_frequnitct == BdSrvDictCodeConst.SD_FREQUNIT_ONCE)
                    {
                        ciemsdto.Days_or = 0;
                        ciemsdto.Fg_long = false;
                    }
                }
            }
            else if (ciemsdto.Sd_frequnitct == BdSrvDictCodeConst.SD_FREQUNIT_ONCE)
            {
                ciemsdto.Days_or = 0;
                ciemsdto.Fg_long = false;
            }
            DateTime? dt_begin = ciemsdto.Dt_begin;
            if (dt_begin != null)
            {
                if (ciemsdto.Days_or != null)
                {
                    ciemsdto.Dt_end = ((DateTime)dt_begin).AddDays((int)ciemsdto.Days_or);
                }
            }
            ciemsdto.Days_or = (ciemsdto.Days_or == 0 || ciemsdto.Days_or == null ? 1 : ciemsdto.Days_or);
        }


        /// <summary>
        /// 将费用项目合并到医疗单的服务项目列表中
        /// </summary>
        /// <param name="szExpenseSrv"></param>
        /// <returns></returns>
        protected virtual bool MergeExpenseSrv(EmsOrDrug[] szExpenseSrv, CiEmsDTO ems)
        {
            FArrayList srvList = ems.Emssrvs;
            var addList = new List<CiEmsSrvDTO>();

            foreach (EmsOrDrug item in szExpenseSrv)
            {
                // 处理逻辑删除数据
                srvList.Cast<CiEmsSrvDTO>().ToList().ForEach(p =>
                {
                    if (!string.IsNullOrEmpty(p.Id_orsrv) && string.IsNullOrEmpty(p.Id_srv) && p.Status != DOStatus.DELETED)
                    {
                        p.Status = DOStatus.DELETED;
                    }
                });

                // 临床项目和相同的服务，处理医保信息和医保的医生是否已判断标识
                if (item.Fg_or.Value || srvList.Cast<CiEmsSrvDTO>().Count(p => p.Id_srv != null && p.Id_srv.Equals(item.Id_srv)) > 0)
                {
                    var emssrvdto = srvList.Cast<CiEmsSrvDTO>().FirstOrDefault(p => p.Status != DOStatus.DELETED && p.Id_srv != null && p.Id_srv.Equals(item.Id_srv));
                    if (emssrvdto != null)
                    {
                        if (emssrvdto.Fg_selfpay!=null && !emssrvdto.Fg_selfpay.Value)
                        {
                        //emssrvdto.Fg_hpindicjudged = item.Fg_hpindicjudged;
                        emssrvdto.Fg_indic = item.Fg_treat;
                            //emssrvdto.Fg_selfpay = item.Fg_selfpay;
                        }
                       
                    }
                    continue;
                }
                // 处理删除状态的费用项目
                if (item.IsDELETED && !string.IsNullOrEmpty(item.Id_orsrv))
                {
                    var delItem = srvList.Cast<CiEmsSrvDTO>().FirstOrDefault(p => p.Id_orsrv != null && p.Id_orsrv.Equals(item.Id_orsrv));
                    if (null != delItem)
                    {
                        delItem.Status = DOStatus.DELETED;
                    }
                }

                // 套内 非临床 不计费 设置为删除
                if ((ems.Fg_set != null && ems.Fg_set == true) && (item.Fg_or == null || !item.Fg_or.Value) && (item.Fg_bl == null || !item.Fg_bl.Value))
                {
                    item.Status = DOStatus.DELETED;
                }


                // 处理更新状态的费用项目

                // 处理新增状态的费用项目

                addList.Add(ConvertOf(item, ems.Fg_set != null && ems.Fg_set.Value));

            }
            // 如果有新追加的费用项目，则将其追加到医疗单费用列表的尾部
            if (addList.Count > 0)
            {
                srvList.AddRange(addList);

            }
            return true;
        }

        protected virtual EmsOrDrug[] PickupExpense(CiEmsDTO ciEms)
        {
            // 有效性检查
            if (ciEms == null || ciEms.Emssrvs == null)
                return null;

            // 定义临时存储过渡区
            var tmpExpenseList = new List<EmsOrDrug>();
            // 
            var srcEmsList = ciEms.Emssrvs.Cast<CiEmsSrvDTO>();

            // 分拣费用
            IEnumerable<EmsOrDrug> expenseIterator =
                from emsSrvItem in srcEmsList
                where NeedGenExpense(emsSrvItem)
                select ConvertOf(emsSrvItem);
            return expenseIterator.ToArray();
        }

        /// <summary>
        /// 处理费用数据相关信息（总量单位、总量、总价）
        /// </summary>
        /// <param name="drug"></param>
        protected virtual void HandleUnitInfo(EmsOrDrug drug)
        {
            if (drug.Fg_or != null && drug.Fg_or == false
                && drug.Fg_bl != null && drug.Fg_bl == true)
            {
                if (drug.Id_unit_sale == null)
                {
                    drug.Id_unit_sale = drug.Id_unit_med;
                    drug.Name_unit_sale = drug.Name_unit_med;
                }
                if (drug.Quan_cur == null || drug.Quan_cur == 0)
                {
                    if (drug.Fg_mm != null && drug.Fg_mm == true)
                    {
                        this.logicEx.GetDrugTotal(drug, null, this.GetEnt4BannerDTO().Code_entp, true);
                    }
                    else
                    {
                        drug.Quan_cur = logicEx.getNotDrugTotal(drug.Quan_med.ToDouble(), drug.Id_freq, drug.Freqct == null ? 1 : drug.Freqct.Value);
                    }
                }

            }
            if (drug.Price != null && drug.Quan_cur != null)
            {
                drug.Totalprice = drug.Price * drug.Quan_cur;
            }

        }
        public override string OnRefFilterData(string filedName, StringObjectMap sbm = null)
        {
            if (sbm != null)
            {
                switch (filedName)
                {
                    case "Name_srv":
                        if (!sbm.ContainsKey("code_entp"))
                        {
                            sbm.Add("code_entp", "00");
                        }
                        if (!sbm.ContainsKey("id_pripat"))
                        {
                            sbm.Add("id_pripat", this.ent4BannerDTO.Id_pripat);
                        }
                        CiEnContextDTO ciEnContextDTO = BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO;
                        string id_hp = ciEnContextDTO.Id_hp_default;
                        if (!string.IsNullOrEmpty(id_hp))
                        {
                            if (!sbm.ContainsKey("id_hp"))
                            {
                                sbm.Add("id_hp", id_hp);
                            }
                        }
                        sbm.Add("inputmethod", IndividualSettings.GetUserIndividualSetting(IndividualSettingConst.InputMethod));
                        sbm.Add("hpinfomode", SysParamUtils.getSysParam().SYS_PARAM_HPInfoMode.GroupParam);

                        string wherePart = "";
                        if (wherePart != "")
                        {
                            wherePart += string.Format(" and Sd_srvtp!='{0}'", BdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH);
                        }
                        else
                        {
                            wherePart += string.Format(" Sd_srvtp!='{0}'", BdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH);
                        }
                        return wherePart;
                    case "Name_freq":
                        wherePart = " Fg_use_op = 'Y' and bd_freq.FG_ACTIVE='Y'";
                        return wherePart;
                    case "Name_routedes":
                        wherePart = string.Format("FG_ENTP_OP='Y' or FG_ENTP_ER='Y'");
                        return wherePart;
                }

            }
            return "";
        }
        protected virtual void HandleTotlePriceInfo(EmsOrDrug drug)
        {
            if (drug.Fg_or != null && drug.Fg_or == false
                && drug.Fg_bl != null && drug.Fg_bl == true)
            {

                if (drug.Quan_cur == null || drug.Quan_cur == 0)
                {
                    if (drug.Fg_mm != null && drug.Fg_mm == true)
                    {
                        this.logicEx.GetDrugTotal(drug, null, this.GetEnt4BannerDTO().Code_entp, true);
                    }
                    else
                    {
                        drug.Quan_cur = this.logicEx.getNotDrugTotal(drug.Quan_med.ToDouble(), drug.Id_freq, drug.Freqct.Value);
                    }
                }

            }
            if (drug.Quan_cur == null && drug.Quan_med != null)
            {
                drug.Quan_cur = this.logicEx.getNotDrugTotal(drug.Quan_med.ToDouble(), drug.Id_freq, drug.Freqct.Value);
            }
            if (drug.Price != null)
            {
                drug.Totalprice = drug.Price * drug.Quan_cur;
            }
        }

        protected virtual bool NeedGenExpense(CiEmsSrvDTO emsSrv)
        {
            return emsSrv.Id_srv != null /*&& (emsSrv.Fg_bl != null && emsSrv.Fg_bl == true)*/;
        }

        public virtual CiEmsDTO Save2CiEmsDTO(bool forceUpdate)
        {
            if (this.GetCountWithOutDelete() == 0)
                return null;


            // 记录时间
            new AssCostTimeTool("查询费用时候，EmsUIDTO对象转化为CiEmsDTO对象耗时：", true);

            // 保存之前的存储模型的转化
            var ciEms = this.logicEx.CreatEmsDTO();

            // 同步医疗单模型数据
            //if (this.ciEmsDTO.Status == DOStatus.UPDATED && !forceUpdate) {
            //    //this.logicEx.CopyTo<CiEmsDTO>(this.ciEmsDTO, ciEms);
            //    var jsonCiemsdto = this.ciEmsDTO.serializeJson();
            //    if (!string.IsNullOrEmpty(jsonCiemsdto)) {
            //        ciEms.deSerializeJson(jsonCiemsdto);
            //    }
            //}
            // 取得最新医疗单数据
            int status = this.uiEmsDTO.Status;
            this.uiEmsDTO.Status = DOStatus.NEW;
            if (!string.IsNullOrEmpty(ciEmsDTO.Id_srv))
            {
                this.uiEmsDTO.MedSrvDO = XapServiceMgr.find<IMedsrvMDOCrudService>().findById(ciEmsDTO.Id_srv);
            }
            this.orDataConvert.SaveCiDTO(this.uiEmsDTO, ciEms, 0);
            this.uiEmsDTO.Status = status;
            //if (this.ciEmsDTO.Status == DOStatus.UPDATED && !forceUpdate)
            //{
            //    ciEms.Emssrvs.Cast<CiEmsSrvDTO>().ToList().ForEach(p => { if (p.Status != DOStatus.DELETED) p.Status = DOStatus.UPDATED; });
            //}
            // TODO: 费用数据 -> ciemsdto(合并)
            //if (expenseList.Count > 0)
            //{
            //    this.MergeExpenseSrv(this.expenseList.ToList().Where(p => !p.IsDELETED).ToArray(), ciEms);
            //}
            ciUseDayAndDtEnd(ciEms);

            // 返回医疗单数据
            return ciEms;
        }

        /// <summary>
        /// 将UI模型中的EmsOrDrug对象转化为CiEmsSrvDTO对象
        /// </summary>
        /// <param name="p"></param>
        /// <param name="fg_set"></param>
        /// <param name="srv"></param>
        /// <returns></returns>
        protected virtual CiEmsSrvDTO ConvertOf(EmsOrDrug p, bool fg_set = false, CiEmsSrvDTO srv = null)
        {
            CiEmsSrvDTO srvdto = (srv ?? new CiEmsSrvDTO());// 

            srvdto.Eu_sourcemd = p.Eu_sourcemd; //医疗单项目数据来源 
            srvdto.Id_orsrv = p.Id_orsrv;       //医疗单项目主键标识 
            //srvdto.Id_or	=                   //医疗单	SINGLE	F 
            srvdto.Sortno = p.Sortno;	         //序号	SINGLE	I 
            srvdto.Id_srv = p.Id_srv;	         //医疗服务	REF	 
            srvdto.Id_srv_src = (srv == null ? p.Id_srv_src : srv.Id_srv_src);    // 所属服务来源 bl
            //srvdto.Id_srv_set = (fg_set ? srvdto.Id_srv_src : null);
            srvdto.Id_unit_med = p.Id_unit_med;	     //医疗单位	REF	 
            srvdto.Name_unit_med = p.Name_unit_med;  //医疗单位编码	SINGL 
            srvdto.Quan_med = p.Quan_med;	     //剂量	SINGLE	F 
            srvdto.Price = p.Price;        //参考价格	SINGL 
            srvdto.Id_freq = p.Id_freq;	         //医嘱频次	REF	 
            srvdto.Name_freq = p.Name_freq;	     //医嘱频次名称	SINGL 
            srvdto.Freqct = p.Freqct;
            srvdto.Sd_frequnitct = p.Sd_frequnitct;
            srvdto.Id_route = p.Id_route;	      //用法标识	REF	  	
            srvdto.Name_route = p.Name_route;	      //用法	SINGLE	S 
            srvdto.Id_routedes = (srv == null ? p.Id_routedes : srv.Id_route);// p.Id_routedes;	      //用法要求标识	REF	  	 
            srvdto.Name_routedes = (srv == null ? p.Name_routedes : srv.Name_routedes);//p.Name_routedes;	  //用法要求	SINGL 
            srvdto.Id_boil = (srv == null ? p.Id_boil : srv.Id_boil);//p.Id_boil;	          //煎法标识	REF	  	 	 	
            srvdto.Name_boil = (srv == null ? p.Name_boil : srv.Name_boil);//p.Name_boil;	      //煎法	SINGLE	S 
            srvdto.Id_boildes = p.Id_boildes;	      //煎法要求标识	REF	  	
            srvdto.Name_boildes = p.Name_boildes;	  //煎法要求	SINGL 
            srvdto.Fg_dose_anoma = p.Fg_dose_anoma;	  //变动用药标识	SINGL  	
            srvdto.Des_srv = p.Des;          //备注	SINGLE	 
            // srvdto.Fg_outp = (srv == null ? null : srv.Fg_outp);//p.Fg_outp;	          //出院带药标识	SINGL  	---- 已经弃用！！！
            srvdto.Fg_bl = p.Fg_bl; // 
            //srvdto.Id_org_srv	      //开立机构	SINGL 
            //srvdto.Id_dep_srv	      //开立科室	SINGL 
            //srvdto.Id_ward_srv	      //开立病区	SINGL 
            //srvdto.Id_emp_srv	      //开立人员	SINGL 
            srvdto.Dt_create_srv = (srv == null ? CommonExtentions.NowTime(this) : srv.Dt_create_srv);//CommonExtentions.NowTime(this); //开立时间	SINGL 
            //srvdto.Dt_last_bl	      //最近生成日期	SINGL 
            //srvdto.Eu_blmd = p.Eu_blmd;          //划价方式	SINGL 
            //srvdto.Id_orsrvmm = p.Id_emsordrug;	      //服务项目物品	SINGL  	 	
            srvdto.Id_mm = p.Id_mm;	          //物品	SINGLE	 
            srvdto.Code_mm = p.Code_mm;	          //物品编码	SINGL 
            srvdto.Name_mm = p.Name_mm;	          //物品名称	SINGL 
            //srvdto.Spec_mm	          //规格	SINGLE	S 
            srvdto.Id_unit_sale = p.Id_unit_sale;	  //零售单位	REF	 
            srvdto.Name_unit_sale = p.Name_unit_sale;	  //零售单位名称	SINGL 
            srvdto.Id_unit_base = p.Id_unit_base;	  //基本单位	REF	 
            srvdto.Name_unit_base = p.Name_unit_base;	  //基本单位名称	SINGL 
            //srvdto.Quan_num_base = p.Quan_base;	  //单次数量_分子	S  	 	 	
            srvdto.Quan_den_base = 1;	  //单次数量_分母	S 
            srvdto.Price_cur = p.Price;	      //参考价当前	SINGL 
            srvdto.Quan_cur = p.Quan_cur;	      //总量_当前	SINGL 
            srvdto.Quan_base = p.Quan_base;      //总量_基本	SINGL 
            srvdto.Quan_bed_medu = 0;	  //床边量_医学	SINGL 
            srvdto.Quan_total_medu = p.Quan_cur;
            srvdto.Factor_cb = p.Factor_cb;	      //当前基本换算系数	S  	 	
            srvdto.Factor_mb = (p.Factor_mb == null || p.Factor_mb == 0) ? 1 : p.Factor_mb;	      //医疗基本换算系数	S  	 	
            srvdto.Id_dosage = p.Id_dosage;	      //药品剂型	SINGL 
            srvdto.Sd_dosage = p.Sd_dosage;	      //药品剂型编码	SINGL 
            srvdto.Id_pharm = p.Id_pharm;	      //药理分类	SINGL 
            srvdto.Sd_pharm = p.Sd_pharm;	      //药理分类编码	SINGL 
            srvdto.Id_pois = p.Id_pois;	          //毒麻分类	SINGL 
            srvdto.Sd_pois = p.Sd_pois;	          //毒麻分类编码	SINGL 
            srvdto.Id_anti = p.Id_anti;	          //抗菌药分类	SINGL 
            srvdto.Sd_anti = p.Sd_anti;	          //抗菌药分类编码	S 
            srvdto.Id_mmtp = p.Id_mmtp;	          //物品类型	SINGL 
            srvdto.Sd_mmtp = p.Sd_mmtp;	          //物品类型编码	SINGL 
            srvdto.Id_val = p.Id_val;	          //价值分类	SINGL 
            srvdto.Sd_val = p.Sd_val;	          //价值分类编码	SINGL 
            srvdto.Fg_self = p.Fg_self;//自备药标识	SINGL  	
            srvdto.Fg_propc = p.Fg_propc;//预防用药标识	SINGL
            srvdto.Fg_indic = p.Fg_treat;//治疗用药标识	SINGL  	
            srvdto.Id_dep = p.Id_mp_dep;//执行科室	REF	 
            srvdto.Name_dep = p.Name_mp_dep;//执行科室	REF	 
            srvdto.Des_srv = p.Note_or;
            //皮试内容
            srvdto.Fg_skintest = p.Fg_skintest;
            srvdto.Id_skintest_skip_reason = p.Id_skintest_skip_reason;
            srvdto.Sd_reltp = p.Sd_reltp;
            srvdto.Id_or_rel = p.Id_or_rel;
            srvdto.Fg_mm = p.Fg_mm;
            srvdto.Fg_selfsrv = p.Fg_ctm;
            srvdto.Fg_selfpay = p.Fg_selfpay; // 自费标志
            srvdto.Name_srv = p.Name_srv;
            srvdto.Id_dep_wh = p.Id_dep_wh;//库房id 2016-08-03 zwq
            srvdto.Id_srvtp = p.Id_srvtp;	     //服务类型	REF	 		 	 	 
            srvdto.Sd_srvtp = p.Sd_srvtp;     //服务类型编码	SINGL 
            srvdto.Code_srv = p.Code_srv;	     //医疗服务编码	SINGL 
            srvdto.Name_srv = p.Name_srv;	     //医疗服务名称	SINGL 
            srvdto.Id_srvca = p.Id_srvca;	     //服务项目基本分类	S 
            srvdto.Fg_mm = p.Fg_mm;	          //物品标识	SINGL 
            srvdto.Fg_set = (srv == null ? false : srv.Fg_set);	          //服务套标识	SINGL  	bl
            srvdto.Fg_or = (srv == null ? p.Fg_or : srv.Fg_or);	          //医嘱标识	SINGL 
            srvdto.Innercode_srvca = (srv == null ? p.Innercode_srvca : srvdto.Innercode_srvca);//服务分类内部编码 bl
            //srvdto.Id_srv_set	     //所属服务套	SINGL 
            srvdto.Id_hp = p.Id_hp;//医保计划id zwq 2016-07-12
            srvdto.Id_hpsrvtp = p.Id_hpsrvtp;//医保目录类型 zwq 2016-07-12
            srvdto.Sd_hpsrvtp = p.Sd_hpsrvtp;//医保目录类型编码 zwq 2016-07-12
            srvdto.Fg_hpindicjudged = p.Fg_hpindicjudged; //医生是否已判断过标识
            srvdto.Eu_blmd = (srv == null ? p.Eu_blmd : srvdto.Eu_blmd); //划价方式 bl
            srvdto.Emsagentinfo = p.Agentinfolist;//毒麻药品时核对的患者信息
            srvdto.Priby = p.Priby;
            srvdto.Id_primd = p.Id_pri;
            srvdto.Status = (srv == null ? p.Status : srv.Status);
            return srvdto;
        }
        /// <summary>
        /// 将CiEmsSrvDTO对象转化为UI模型EmsOrDrug对象
        /// </summary>
        /// <param name="p"></param>
        /// <param name="dto"></param>
        /// <returns></returns>
        protected virtual EmsOrDrug ConvertOf(CiEmsSrvDTO p, CiEmsDTO dto = null)
        {
            return new EmsOrDrug
            {
                Status = (p.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIANFEEADD ? DOStatus.UPDATED : DOStatus.UNCHANGED),
                Id_orsrv = p.Id_orsrv, //医疗单项目主键标识 
                Id_srv_src = p.Id_srv_src, // 所属服务来源
                //Id_or =         //医疗单	SINGLE	F 
                Sortno = p.Sortno, //序号	SINGLE	I 
                Id_srv = p.Id_srv, //医疗服务	REF	 
                Sd_srvtp = p.Sd_srvtp,//服务类型sd
                Id_srvtp = p.Id_srvtp,//服务类型id
                Id_srvca = p.Id_srvca,//服务分类
                Code_srv = p.Code_srv,
                //Id_srv_set	     //所属服务套	SINGL 
                Name_srv = p.Name_srv, //医疗服务名称	SINGL 
                Id_unit_med = p.Id_unit_med, //医疗单位	REF	 
                Name_unit_med = p.Name_unit_med, //医疗单位编码	SINGL 
                Quan_med = p.Quan_med, //剂量	SINGLE	F 
                Price = p.Price, //参考价格	SINGL 
                Id_freq = p.Id_freq, //医嘱频次	REF	 
                Name_freq = p.Name_freq, //医嘱频次名称	SINGL 
                Freqct = p.Freqct,

                //Des = p.Des_srv,          //备注	SINGLE	 
                Fg_or = p.Fg_or,	          //医嘱标识	SINGL 
                Fg_bl = p.Fg_bl,	          //费用标识	SINGL 
                //Id_org_srv	      //开立机构	SINGL 
                //Id_dep_srv	      //开立科室	SINGL 
                //Id_ward_srv	      //开立病区	SINGL 
                //Id_emp_srv	      //开立人员	SINGL 
                //Dt_last_bl	      //最近生成日期	SINGL 
                Eu_sourcemd = p.Eu_sourcemd, // 来源
                Eu_blmd = p.Eu_blmd,	          //划价方式	SINGL 
                Id_emsordrug = p.Id_orsrvmm, //服务项目物品	SINGL  	 	
                Id_mm = p.Id_mm, //物品	SINGLE	 
                Code_mm = p.Code_mm, //物品编码	SINGL 
                Name_mm = p.Name_mm, //物品名称	SINGL 
                Spec_mm = p.Spec_mm,          //规格	SINGLE	S 
                Id_pgku_cur = p.Id_unit_sale, //零售单位	REF	 
                Name_pgku_cur = p.Name_unit_sale, //零售单位名称	SINGL 
                Id_unit_base = p.Id_unit_base, //基本单位	REF	 
                Id_unit_sale = p.Id_unit_sale,//总量单位id
                Name_unit_base = p.Name_unit_base, //基本单位名称	SINGL 
                Name_unit_sale = p.Name_unit_sale,
                Quan_cur = (p.Fg_mm == false ? p.Quan_total_medu : p.Quan_cur),	      //总量_当前	SINGL 
                Quan_base = p.Quan_base, //总量_基本	SINGL 
                Factor_cb = p.Factor_cb, //当前基本换算系数	S  	 	
                Factor_mb = p.Factor_mb, //医疗基本换算系数	S  	 	
                Id_dosage = p.Id_dosage, //药品剂型	SINGL 
                Sd_dosage = p.Sd_dosage, //药品剂型编码	SINGL 
                Id_pharm = p.Id_pharm, //药理分类	SINGL 
                Sd_pharm = p.Sd_pharm, //药理分类编码	SINGL 
                Id_pois = p.Id_pois, //毒麻分类	SINGL 
                Sd_pois = p.Sd_pois, //毒麻分类编码	SINGL 
                Id_anti = p.Id_anti, //抗菌药分类	SINGL 
                Sd_anti = p.Sd_anti, //抗菌药分类编码	S 
                Id_mmtp = p.Id_mmtp, //物品类型	SINGL 
                Sd_mmtp = p.Sd_mmtp, //物品类型编码	SINGL 
                Id_val = p.Id_val, //价值分类	SINGL 
                Sd_val = p.Sd_val, //价值分类编码	SINGL 
                Id_boildes = p.Id_boildes,//煎法
                Name_boildes = p.Name_boildes,//煎法名称
                Fg_propc = p.Fg_propc,//预防用药标识
                Fg_treat = p.Fg_indic,//治疗用药标识
                Note_or = p.Des_srv,//备注
                Id_mp_dep = p.Id_dep,//执行科室id
                Name_mp_dep = p.Name_dep,//执行科室
                Fg_self = p.Fg_self,//自备药标识
                Fg_dose_anoma = p.Fg_dose_anoma,//变动用药标识
                Fg_ctm = p.Fg_selfsrv,//自定义服务标志
                Fg_selfpay = p.Fg_selfpay, // 自费标志
                //Indica = p.Indica,	          //适应症	SINGLE	S 
                //Constr	          //禁忌症	SINGLE	S 
                //React	          //不良反应	SINGL 
                //Guide	          //主要作用	SINGL 
                //Fg_otc	          //OTC标识	SINGL 
                //Emsfreqdose	      //变动用药安排	SINGL  	
                //Id_body	          //部位	SINGLE	  	 	
                //Sd_body	          //部位编码	SINGL 
                //Id_pos	          //体位	SINGLE	  	 	
                //Sd_pos	          //体位编码	SINGL 
                //Body_name	      //部位名称	SINGL 
                Id_route = p.Id_route,
                Name_route = p.Name_route,
                Id_routedes = p.Id_routedes,
                Id_boil = p.Id_boil,
                Name_boil = p.Name_boil,
                Priby = p.Priby,
                Id_pri = p.Id_primd,
                Use_days = (dto != null ? dto.Days_or : 1), //使用天数
                Id_hp = p.Id_hp,
                Id_hpsrvtp = p.Id_hpsrvtp,
                Sd_hpsrvtp = p.Sd_hpsrvtp,
                Name_hpsrvtp = p.Name_hpsrvtp,
                Limit = p.Limit,
                Fg_hpindicjudged = p.Fg_hpindicjudged,//医生是否已判断过标识
                Des = p.Des_bl
            };
        }
        public override void ClearTableDataSource()
        {
            base.ClearTableDataSource();

            if (this.GetExpenseDatasource() != null)
            {
                this.GetExpenseDatasource().Clear();
            }
        }
        public virtual void SetSelectedObject(object cursel)
        {
        }

        public virtual object GetSelectedObject()
        {
            return null;
        }


        public virtual object GetEmsUIDTO()
        {
            return this.uiEmsDTO;
        }
        public CiEmsDTO getCiEmsDTO()
        {
            return this.ciEmsDTO;
        }
        /// <summary>
        /// 设置是否已经计算过费用项标志
        /// </summary>
        /// <param name="fgPriSrvHandled"></param>
        public void setFgPriSrvHandled(bool? fgPriSrvHandled)
        {
            this.ciEmsDTO.Fg_prisrvhandled = fgPriSrvHandled;
        }
        public virtual int GetCountWithOutDelete()
        {
            var itemList = this.GetTableDataSource() as XapDataList<EmsOrDrug>;
            if (itemList == null || itemList.Count == 0)
                return 0;

            return itemList.ToList().Count(p => !p.IsDELETED);
        }

        public XapDataList<EmsOrDrug> GetExpenseDatasource()
        {
            return this.expenseList;
        }

        public bool IsNewStatus()
        {
            return null != this.ciEmsDTO && this.ciEmsDTO.IsNEW;
        }
        public CiOrderDO getCiOrderDO()
        {
            return this.ciOrder;
        }
        /// <summary>
        /// 获取费用项目备注信息保存后
        /// </summary>
        /// <param name="ciorder"></param>
        /// <returns></returns>
        public List<string> getBlSrvDesListAftSave(CiOrderDO ciorder)
        {
            List<string> ids = new List<string>();
            ids.Add(ciorder.Id_or);
            FMap srvFMap = ordMaintainService.getCiOrderBlSrvDesByIdors(ids.ToArray());
            List<string> msglist = new List<string>();
            int i = 1;
            foreach (string id_srv in srvFMap.Keys)
            {
                MedSrvDO medsrv = srvFMap[id_srv] as MedSrvDO;
                // PO:费用备注信息提示是对收费项目提示信息，药品不需提示。控制条件bd_srv，fg_bl = Y and fg_mm =N
                if (medsrv == null || medsrv.Fg_bl == FBoolean.False || medsrv.Fg_mm == FBoolean.True) continue;
                msglist.Add(i + "、" + medsrv.Name + "：" + medsrv.Des);
                i++;
            }
            return msglist;
        }


        /// <summary>
        /// 医嘱保存到服务器端
        /// </summary>
        public virtual CiOrderDO AgainSaveOrder()
        {
            // 远程调用服务器保存,并返回 CiOrder 
            CiOrderDO ciorder = ordMaintainService.AgainSaveOrder("", BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO);
            if (ciorder != null && ciorder.Mdicalinfo != null)
            {

                medicalInfoCache.setMedicalinfo("Id", ciorder.Mdicalinfo);
            }
            return ciorder;
            //return ordMaintainService.SaveCiEmsDTO(this.ciEmsDTO, BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="id_srv"></param>
        /// <param name="id_mm"></param>
        /// <param name="?"></param>
        /// <returns></returns>
        public EmsOrDrug getHPIndiccation(String id_srv, String id_mm, CiEnContextDTO ciEnContextDTO)
        {

            return ciOrdQryService.getHPIndiccation(id_srv, id_mm, ciEnContextDTO);
        }
        /// <summary>
        /// 
        /// </summary>
        /// <param name="id_or"></param>
        /// <param name="ciEnContextDTO"></param>
        /// <returns></returns>
        public MedicalSharingDTO[] getRepeatMessageOrder(string id_or, CiEnContextDTO ciEnContextDTO)
        {
            return ciOrdQryService.getRepeatMessageOrder(id_or, ciEnContextDTO);
        }
    }
}

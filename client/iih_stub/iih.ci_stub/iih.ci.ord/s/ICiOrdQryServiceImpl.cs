using System;
using System.Collections.Generic;
using System.Linq;
using iih.bd.fc.orwf.d;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.ortpl.d;
using iih.ci.ord.cior.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.cirptlab.d;
using iih.ci.ord.cirptobs.d;
using iih.ci.ord.dto.allergy.d;
using iih.ci.ord.dto.blexorder.d;
using iih.ci.ord.dto.d;
using iih.ci.ord.dto.opdispensecond.d;
using iih.ci.ord.dto.orderpandectemrdto.d;
using iih.ci.ord.dto.ordertemplatedto.d;
using iih.ci.ord.dto.ordertpltree.d;
using iih.ci.ord.dto.OrderPresSplitDTO.d;
using iih.ci.ord.dto.ordinput.d;
using iih.ci.ord.dto.ordpres.d;
using iih.ci.ord.dto.orobsandlab.d;
using iih.ci.ord.dto.pipvinfo.d;
using iih.ci.ord.dto.unchargeordinfo.d;
using iih.ci.ord.dto.vitalsignsdto.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.ordappathgy.d;
using iih.ci.ord.srvpri.d;
using iih.ci.ord_stub.dto.d;
using iih.en.pv.dto.d;
using iih.en.pv.entdi.d;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.sys.devcfg.func.d;
using PatUnDoOrderdto = iih.ci.ord.dto.patundoorderdto.d.PatUnDoOrderdto;
using iih.bd.srv.dto.d;
using iih.ci.ord.dto.consdto.d;
using iih.ci.ord.dto.patdetaildto.d;
using iih.bd.mm.meterial.d;
using iih.ci.iih.ci.ord.dto.d;
using iih.ci.ord.dto.medicalroutinetreedto.d;
using iih.ci.ord.emsdi.d;
using xap.sys.xbd.measdoc.d;
using iih.ci.ord.ordprn.d;
using iih.ci.ord.dto.ordprintdto.d;
using iih.ci.ord.moreemsdto.d;
using iih.ci.ord.dto.ordrationaldrugdto.d;
using iih.bd.pp.hpsrvorca.d;
using iih.ci.iih.ci.ord.ciordems.d.ext;
using iih.ci.ord.dto.newordertemplatedto.d;
using iih.ci.iih.ci.ord.dto.hp;
using iih.ci.ord.dto.ordermr.d;
using iih.ci.iih.ci.ord.dto.ordsrvchangeddto.d;
using iih.ci.iih.ci.ord.dto.newordertemplatedto.d;
using iih.ci.ord.ciordems.d.ext;


namespace iih.ci.ord.i
{
    public class ICiOrdQryServiceImpl : ICiOrdQryService
    {
        private readonly ServiceInvocation si;

        private readonly string url_r = XapSvrConfig.BaseUrl + "xap.ci.ord/iih.ci.ord.i.ICiOrdQryService";
        //ConfigUtil.getServiceUrl();

        private CacheHelper<CiorderAggDO> ch;

        /// <summary>
        ///     构造函数
        /// </summary>
        public ICiOrdQryServiceImpl()
        {
            ch = new CacheHelper<CiorderAggDO>();
            si = new ServiceInvocationImpl();
            si.url = url_r;
        }

        /**
         * 获取医嘱DTO
         */

        public EmsUIDTO getEmsUIDTO(String id_order, String orderType, string code_entp)
        {
            var param = new List<object> { id_order, orderType, code_entp };
            si.url = url_r;
            var EmsUIDTO = si.invoke<EmsUIDTO>("getEmsHeadDO", param.ToArray());
            return EmsUIDTO;
        }

        /// <summary>
        ///     Gets 服务关联的物品
        /// </summary>
        /// <param name="id_org">The id_org.</param>
        /// <param name="id_srv">The id_srv.</param>
        /// <param name="id_dept_mp">The 执行科室.</param>
        /// <param name="id_dept_phy">The 开立科室.</param>
        /// <param name="id_hp">The 社会保险号.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-09-28
        /// Author:admin
        /// Date:2015-09-23
        public EmsOrDrug[] getSrvVsMm(string id_org, string id_srv, string id_dept_mp, string id_dept_phy, string id_hp, string code_entp)
        {
            var param = new List<object> { id_org, id_srv, id_dept_mp, id_dept_phy, id_hp, code_entp };
            si.url = url_r;
            EmsOrDrug[] emsDo = si.invokeList<EmsOrDrug>("getSrvVsMm", param.ToArray());
            return emsDo;
        }

        //public EmsOrDrug[] baseMessage(string id_org, string id_srv, string id_dept_mp, string id_dept_phy, string id_hp)
        //{
        //    List<object> param = new List<object> { id_org, id_srv, id_dept_mp, id_dept_phy, id_hp };
        //    si.url = url_r;
        //    EmsOrDrug[] emsDo = si.invokeList<EmsOrDrug>("baseMessage", param.ToArray());
        //    return emsDo;
        //}

        /**
              * 根据门诊发药查询条件获得门诊未发药患者列表信息
              * @param cond  门诊发药查询条件DTO
              * @return 患者就诊信息DTO
              * @throws BizException
              */

        public PiPvInfoDTO[] getOpNoDrugPatiInfos(OpDispenseCondDTO cond)
        {
            var param = new List<object> { cond };
            si.url = url_r;
            PiPvInfoDTO[] rtn = si.invokeList<PiPvInfoDTO>("getOpNoDrugPatiInfos", param.ToArray());
            return rtn;
        }

        /**
         * 根据患者id获得门诊患者未发药处方
         * @param patiid   患者主键标识
         * @param isHerb   是否是草药 否则为西成药
         * @return
         * @throws BizException
         */

        //public DispenseDTO[] getOpPatiNoDrugPreses(String patiid, FBoolean isHerb)
        //{
        //    List<object> param = new List<object> { patiid, isHerb};
        //    si.url = url_r;
        //    DispenseDTO[] rtn = si.invokeList<DispenseDTO>("getOpPatiNoDrugPreses", param.ToArray());
        //    return rtn;

        //}

        /**
         * 根据门诊退药查询条件获得门诊退药处方头信息
         * @param cond  
         * @return
         * @throws BizException
         */

        //public DispenseDTO[] getOpDrugRtnPresHeadInfos(OpDrugRtnCondDTO cond)
        //{
        //    List<object> param = new List<object> { cond };
        //    si.url = url_r;
        //    DispenseDTO[] rtn = si.invokeList<DispenseDTO>("getOpDrugRtnPresHeadInfos", param.ToArray());
        //    return rtn;

        //}

        /**
         * 根据处方主键标识获得处方药品信息集合
         * @param presid  处方主键标识
         * @return
         * @throws BizException
         */

        //public OpeDgAppdtDTO[] getPresItemsByPresId(String presid,String statusMp)
        //{
        //    List<object> param = new List<object> { presid ,statusMp};
        //    si.url = url_r;
        //    OpeDgAppdtDTO[] rtn = si.invokeList<OpeDgAppdtDTO>("getPresItemsByPresId", param.ToArray());
        //    return rtn;

        //}

        /**
     * 未记费医嘱查询列表

     * @param patid
     * @param dtSignB
     * @param dtSignE
     * @param code_entp
     * @return
     */

        public UnchargeOrdDTO[] getUnchargeOrderList(String patid, FDateTime dtSignB, FDateTime dtSignE,
            String code_entp, string id_org)
        {
            var param = new List<object> { patid, dtSignB, dtSignE, code_entp, id_org };
            si.url = url_r;
            UnchargeOrdDTO[] rtn = si.invokeList<UnchargeOrdDTO>("getUnchargeOrderList", param.ToArray());
            return rtn;
        }


        public MedSrvDO[] GetSrvSetItemList(string id_srv)
        {
            object[] param = { id_srv };
            si.url = url_r;
            MedSrvDO[] rtn = si.invokeList<MedSrvDO>("getSrvSetItemList", param.ToArray());
            return rtn;
        }

        public HPSrvorcaDO GetHpSrvOrCaDo(String id_hp, String id_srv)
        {
            object[] param = { id_hp, id_srv };
            si.url = url_r;
            var rtn = si.invoke<HPSrvorcaDO>("GetHpSrvOrCaDo", param.ToArray());
            return rtn;
        }


        public PatUnDoOrderdto[] queryPatUnDoOrderdto(String entId)
        {
            var param = new List<object>();
            param.Add(entId);
            si.url = url_r;
            PatUnDoOrderdto[] sch = si.invokeList<PatUnDoOrderdto>("GetPatUnDoOrderdto", param.ToArray());
            return sch;
        }

        /// <summary>
        ///     服务项目列表
        /// </summary>
        /// <param name="sd_srvtp"></param>
        /// <param name="strWhere"></param>
        /// <param name="pa_Healthca"></param>
        /// <returns></returns>
        public EmsOrSrvSc[] getEmsOrSrvSc(string sd_srvtp, string strWhere, string pa_Healthca, string code_entp)
        {
            object[] param = { sd_srvtp, strWhere, pa_Healthca, code_entp };
            si.url = url_r;
            EmsOrSrvSc[] rtn = si.invokeList<EmsOrSrvSc>("getMedSrvSc", param.ToArray());
            return rtn;
        }
        public EmsOrSrvSc[] getOrtplEmsOrSrvSc(OrtplDTO dto)
        {
            object[] param = { dto };
            si.url = url_r;
            EmsOrSrvSc[] rtn = si.invokeList<EmsOrSrvSc>("getOrtplMedSrvSc", param.ToArray());
            return rtn;
        }
        public EmsOrSrvSc[] getMedSrvId(string id_srv)
        {
            object[] param = { id_srv };
            si.url = url_r;
            EmsOrSrvSc[] rtn = si.invokeList<EmsOrSrvSc>("getMedSrvId", param.ToArray());
            return rtn;
        }


        //检查项目
        public EmsObsItemDO[] getEmsObsItemDO(string id_srv, string type)
        {
            object[] param = { id_srv, type };
            si.url = url_r;
            EmsObsItemDO[] rtn = si.invokeList<EmsObsItemDO>("getEmsObsItemDO", param.ToArray());
            return rtn;
        }

        //修改取得 EmsUIDTO 数据
        public EmsUIDTO GetEmsUIDTO(string id_or, string type, string code_entp)
        {
            object[] param = { id_or, type, code_entp };
            si.url = url_r;
            var rtn = si.invoke<EmsUIDTO>("GetemsHeadDO", param.ToArray());
            return rtn;
        }

        /// <summary>
        ///     根据物品类型查询物品信息
        /// </summary>
        /// <param name="mmtp"></param>
        /// <returns></returns>
        public EmsOrDrug[] getMmByMmtp(string id_mmtp)
        {
            object[] param = { id_mmtp };
            si.url = url_r;
            EmsOrDrug[] rtn = si.invokeList<EmsOrDrug>("getMmByMmtp", param.ToArray());
            return rtn;
        }

        /// <summary>
        ///     获取检验检查的树的数据
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="type"></param>
        /// <returns></returns>
        public OrObsAandLabDTO[] getOrObsAandLabDTO(string id_ent, string type)
        {
            object[] param = { id_ent, type };
            si.url = url_r;
            OrObsAandLabDTO[] rtn = si.invokeList<OrObsAandLabDTO>("getObsAndLabList", param.ToArray());
            return rtn;
        }

        public OrObsAandLabDTO[] getObsAndLabDateList(string id_ent, string type)
        {
            object[] param = { id_ent, type };
            si.url = url_r;
            OrObsAandLabDTO[] rtn = si.invokeList<OrObsAandLabDTO>("getObsAndLabDateList", param.ToArray());
            return rtn;
        }

        public IpViewDiagDTO[] getCiDiagItemDOList(string id_ent, string type)
        {
            object[] param = { id_ent, type };
            si.url = url_r;
            IpViewDiagDTO[] rtn = si.invokeList<IpViewDiagDTO>("getCiDiagItemDOList", param.ToArray());
            return rtn;
        }

        public OrdConsDTO[] GetConsList(string id_dep, string su_cons)
        {
            object[] param = { id_dep, su_cons };
            si.url = url_r;
            OrdConsDTO[] rtn = si.invokeList<OrdConsDTO>("GetConsList", param.ToArray());
            return rtn;
        }

        //总览使用
        public CiRptObsDO[] getCiRptObsDO(string id_ent)
        {
            object[] param = { id_ent };
            si.url = url_r;
            CiRptObsDO[] rtn = si.invokeList<CiRptObsDO>("getCiRptObsDO", param.ToArray());
            return rtn;
        }

        //总览使用
        public CirptlabAggDO[] getCirptlabAggDO(string id_ent)
        {
            object[] param = { id_ent };
            si.url = url_r;
            CirptlabAggDO[] rtn = si.invokeList<CirptlabAggDO>("getCirptlabAggDO", param.ToArray());
            return rtn;
        }

        //医嘱录入B画面
        public OrdInputDto[] getOrdInputDto(string id_ent, string id_doctor)
        {
            object[] param = { id_ent, id_doctor };
            si.url = url_r;
            OrdInputDto[] rtn = si.invokeList<OrdInputDto>("getOrdInputDto", param.ToArray());
            return rtn;
        }

        public CiordubDTO getOrderUBDto(string id_or)
        {
            object[] param = { id_or };
            si.url = url_r;
            var rtn = si.invoke<CiordubDTO>("getOrderUBDto", param.ToArray());
            return rtn;
        }

        //编辑时 取得医嘱信息
        public FMap getCiEmsDTO(string[] id_ors)
        {
            object[] param = { id_ors };
            si.url = url_r;
            var rtn = si.invoke<FMap>("getCiEmsDTO", param.ToArray());
            return rtn;
        }

        public OrConfirm[] getCiOrdConfirm(OrConfirm confirm)
        {
            object[] param = { confirm };
            si.url = url_r;
            OrConfirm[] rtn = si.invokeList<OrConfirm>("getCiOrdConfirm", param.ToArray());
            return rtn;
        }

        public AddFeeDTO[] getCiOrdFee(OrConfirm confirm)
        {
            object[] param = { confirm };
            si.url = url_r;
            AddFeeDTO[] rtn = si.invokeList<AddFeeDTO>("getCiOrdFee", param.ToArray());
            return rtn;
        }

        public OrderPresSplitDTO[] getOrPresDTOs(string id_en)
        {
            object[] param = { id_en };
            si.url = url_r;
            OrderPresSplitDTO[] rtn = si.invokeList<OrderPresSplitDTO>("getOrPresDTOs", param.ToArray());
            return rtn;
        }


        public OrdSrvDO[] GetOrderSrvDOS(string id_or)
        {
            object[] param = { id_or };
            si.url = url_r;
            OrdSrvDO[] rtn = si.invokeList<OrdSrvDO>("GetOrderSrvDOS", param.ToArray());
            return rtn;
        }

        /// <summary>
        ///     检查申请单号
        /// </summary>
        /// <returns></returns>
        public string getOrdApObsNoapplyform()
        {
            si.url = url_r;
            string rtn = si.invokeString("getOrdApObsNoapplyform");
            return rtn;
        }

        /// <summary>
        ///     检验申请单号
        /// </summary>
        /// <returns></returns>
        public string getOrdApLabNoapplyform()
        {
            si.url = url_r;
            string rtn = si.invokeString("getOrdApLabNoapplyform");
            return rtn;
        }

        public LabDTO[] getLabItms(String idpat, int num, String[] srvlist)
        {
            object[] param = { idpat, num, srvlist };
            si.url = url_r;
            LabDTO[] rtn = si.invokeList<LabDTO>("getLabItms", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        public EntDiDO[] getEntDiDOList(String id_ent)
        {
            object[] param = { id_ent };
            si.url = url_r;
            EntDiDO[] rtn = si.invokeList<EntDiDO>("getEntDiDOList", param.ToArray());
            return rtn;
        }

        public CiordubDTO[] getOrderUBDtoList(string id_ent)
        {
            object[] param = { id_ent };
            si.url = url_r;
            CiordubDTO[] rtn = si.invokeList<CiordubDTO>("getOrderUBDtoList", param.ToArray());
            return rtn;
        }

        public string getNoapplyform(string fullclassname)
        {
            object[] param = { fullclassname };
            si.url = url_r;
            string rtn = si.invokeString("getNoapplyform", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 病历
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        public OrderPandectEmrDTO[] getOrderPandectEmrDTO(string code_entp, string id_ent)
        {
            object[] param = { code_entp, id_ent };
            si.url = url_r;
            OrderPandectEmrDTO[] rtn = si.invokeList<OrderPandectEmrDTO>("getOrderPandectEmrDTO", param.ToArray());
            return rtn;

        }
        /// <summary>
        /// 会诊树
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        public OrdApConsDO[] getTreeOrdApConsDO(String id_ent)
        {
            object[] param = { id_ent };
            si.url = url_r;
            OrdApConsDO[] rtn = si.invokeList<OrdApConsDO>("getTreeOrdApConsDO", param.ToArray());
            return rtn;
        }


        //费用
        public String[] getBlcgAmtVsDrugRation(String id_pat, String id_ent, String codeSrv)
        {
            object[] param = { id_pat, id_ent, codeSrv };
            si.url = url_r;
            String[] rtn = si.invokeStringList("getBlcgAmtVsDrugRation", param.ToArray());
            return rtn;
        }

        //生命体征
        public VitalSignsDto getCiorderPreviewDTOS(String id_ent, string Dt_birth)
        {
            object[] param = { id_ent, Dt_birth };
            si.url = url_r;
            VitalSignsDto rtn = si.invoke<VitalSignsDto>("getCiorderPreviewDTOS", param.ToArray());
            return rtn;
        }
        //过敏史
        public AllergyDto[] getAllergyDto(String id_pat)
        {
            object[] param = { id_pat };
            si.url = url_r;
            AllergyDto[] rtn = si.invokeList<AllergyDto>("getAllergyDto", param.ToArray());
            return rtn;
        }

        //患者既往就诊
        public EntHisDiDTO[] getEntHisDiDTO(String id_pat)
        {
            object[] param = { id_pat };
            si.url = url_r;
            EntHisDiDTO[] rtn = si.invokeList<EntHisDiDTO>("getEntHisDiDTO", param.ToArray());
            return rtn;
        }
        //医嘱页签列表
        public PageDO[] getPageDOList(string doctor_id, string dept_id, string biz_id)
        {
            object[] param = { doctor_id, dept_id, biz_id };
            si.url = url_r;
            PageDO[] rtn = si.invokeList<PageDO>("getPageDOList", param.ToArray());
            return rtn;
        }
        //医嘱助手常用医嘱项目
        public RegularOrCaDO[] getRegularOrCaDOs()
        {
            List<object> param = new List<object>();

            si.url = url_r;
            RegularOrCaDO[] rtn = si.invokeList<RegularOrCaDO>("getRegularOrCaDOs", param.ToArray());
            return rtn;
        }

        //医嘱助手常用医嘱项目
        public RegularOrRelSrvDO[] getRegularOrRelSrvDOs(String id_regularorca)
        {
            List<object> param = new List<object>();
            param.Add(id_regularorca);
            si.url = url_r;
            RegularOrRelSrvDO[] rtn = si.invokeList<RegularOrRelSrvDO>("getRegularOrRelSrvDOs", param.ToArray());
            return rtn;
        }

        //医嘱助手模板树
        public OrderTplTreeDto[] getOrderTplTreeDto(String id_ortpltp, Emp2Dep2GroupDTO edg)
        {
            List<object> param = new List<object>();
            param.Add(id_ortpltp);
            param.Add(edg);
            si.url = url_r;
            OrderTplTreeDto[] rtn = si.invokeList<OrderTplTreeDto>("getOrderTplTreeDto", param.ToArray());
            return rtn;
        }

        //医嘱助手模板项目
        public OrderTemplateDTO getSrvortplitemAggDOS(String id_srvortpl)
        {
            List<object> param = new List<object>();
            param.Add(id_srvortpl);
            si.url = url_r;
            OrderTemplateDTO rtn = si.invoke<OrderTemplateDTO>("getSrvortplitemAggDOS", param.ToArray());
            return rtn;
        }

        public String getDepsNum(string id_dep)
        {
            List<object> param = new List<object>();
            param.Add(id_dep);
            si.url = url_r;
            String rtn = si.invokeString("getDepsNum", param.ToArray());
            return rtn;
        }

        public string getCiSrvCondition(string id_dep, string code)
        {
            List<object> param = new List<object>() { id_dep, code };

            si.url = url_r;
            String rtn = si.invokeString("getCiSrvCondition", param.ToArray());
            return rtn;
        }
        /// <summary>
        /// 获得服务的执行科室
        /// </summary>
        /// <param name="pam"></param>
        /// <returns></returns>
        public OrWfExDeptDTO[] getMpDept(OrWfExDeptParamDTO pam)
        {
            List<object> param = new List<object>();
            param.Add(pam);
            si.url = url_r;
            OrWfExDeptDTO[] rtn = si.invokeList<OrWfExDeptDTO>("getMpDept", param.ToArray());
            return rtn;
        }

        public string getOrdApPathgyDONober(string nomber)
        {
            object[] param = { nomber };
            si.url = url_r;
            string rtn = si.invokeString("getOrdApPathgyDONober", param.ToArray());
            return rtn;
        }

        public String getNoappbtlyform()
        {
            List<object> param = new List<object>();
            param.Add("");
            si.url = url_r;
            string rtn = si.invokeString("getNoappbtlyform", param.ToArray());
            return rtn;
        }

        public AddFeeDTO getEmsfee(AddFeeDTO drug, OrWfExDeptParamDTO param)
        {
            // throw new NotImplementedException();
            List<object> param1 = new List<object>();
            param1.Add(drug);
            param1.Add(param);
            si.url = url_r;
            AddFeeDTO rtn = si.invoke<AddFeeDTO>("getEmsfee", param1.ToArray());
            return rtn;
        }

        public OrSplitOrderDTO[] splitOrSplitSqlRs(OrSrvSplitParamDTO param)
        {
            List<object> param1 = new List<object>();

            param1.Add(param);
            si.url = url_r;
            OrSplitOrderDTO[] rtn = si.invokeList<OrSplitOrderDTO>("splitOrSplitSqlRs", param1.ToArray());
            return rtn;
        }

        public SrvSplitOrderDTO[] splitSrvSplitSqlRs(OrSrvSplitParamDTO param)
        {
            List<object> param1 = new List<object>();

            param1.Add(param);
            si.url = url_r;
            SrvSplitOrderDTO[] rtn = si.invokeList<SrvSplitOrderDTO>("splitSrvSplitSqlRs", param1.ToArray());
            return rtn;
        }


        /// <summary>
        /// 医嘱助手医疗服务项目
        /// </summary>
        /// <param name="cindition"></param>
        /// <param name="ordercolumn"></param>
        /// <param name="islazy"></param>
        /// <returns></returns>
        public MedSrvDO[] getClassMedSrvDOS(String cindition, String ordercolumn, FBoolean islazy)
        {
            List<object> param1 = new List<object>();
            param1.Add(cindition);
            param1.Add(ordercolumn);
            param1.Add(islazy);
            si.url = url_r;
            MedSrvDO[] rtn = si.invokeList<MedSrvDO>("getClassMedSrvDOS", param1.ToArray());
            return rtn;
        }

        /// <summary>
        /// 医嘱助手(服务分类)获取医疗服务项目
        /// </summary>
        /// <param name="code_entp">就诊类型</param>
        /// <param name="cindition">查询医疗服务过滤条件</param>
        /// <param name="ordercolumn">排序列</param>        
        /// <returns>医疗服务map集合，key= medSrvList, value ： FArrayList 医疗服务集合，key=srvStatusMap，value：医疗服务不可用原因</returns>    
        public FMap2 getClassMedSrvMap(string code_entp, string cindition, string orderColumn) {

            List<object> param = new List<object>();
            param.Add(code_entp);
            param.Add(cindition);
            param.Add(orderColumn);
            
            si.url = url_r;            
            FMap2 map = si.invoke<FMap2>("getClassMedSrvMap", param.ToArray());
            return map;

        }

        /// <summary>
        /// 患者既往就诊信息（门诊 和住院）
        /// </summary>
        /// <param name="patId"></param>
        /// <param name="qrySchms"></param>
        /// <returns></returns>
        public EntHisDiDTO[] getEntHisDiBySchm(String patId, EnDiQrySchmDTO[] qrySchms)
        {
            List<object> param1 = new List<object>();
            param1.Add(patId);
            param1.Add(qrySchms);
            si.url = url_r;
            EntHisDiDTO[] rtn = si.invokeList<EntHisDiDTO>("getEntHisDiBySchm", param1.ToArray());
            return rtn;
        }

        /**
      * 当前时间之前的天数
      * @param days
      * @return
      * @throws BizException
      */

        public FDateTime getDateTomeBefore(int days)
        {
            List<object> param1 = new List<object>();
            param1.Add(days);
            si.url = url_r;
            FDateTime rtn = si.invoke<FDateTime>("getDateTomeBefore", param1.ToArray());
            return rtn;
        }

        /**
         *  当前时间之后的天数
         * @param days
         * @return
         * @throws BizException
         */

        public FDateTime getDateTomeAfter(int days)
        {
            List<object> param1 = new List<object>();
            param1.Add(days);
            si.url = url_r;
            FDateTime rtn = si.invoke<FDateTime>("getDateTomeAfter", param1.ToArray());
            return rtn;
        }

        public PatDetailDTO getConsPatDetail(string id_en)
        {
            List<object> param1 = new List<object>();
            param1.Add(id_en);
            si.url = url_r;
            PatDetailDTO rtn = si.invoke<PatDetailDTO>("getConsPatDetail", param1.ToArray());
            return rtn;
        }
        /// <summary>
        /// 皮试逻辑判断
        /// </summary>
        /// <param name="param"></param>
        /// <returns></returns>
        public SkinTestRstDTO skinTestLogicMainBP(SkinTestParamDTO param)
        {
            List<object> param1 = new List<object>();
            param1.Add(param);
            si.url = url_r;
            SkinTestRstDTO rtn = si.invoke<SkinTestRstDTO>("skinTestLogicMainBP", param1.ToArray());
            return rtn;
        }
        /// <summary>
        /// 临床医嘱选择服务，服务价格计算
        /// </summary>
        /// <param name="priParam"></param>
        /// <returns></returns>
        public FDouble ciOrBdSrvPriceCal(BdSrvPriCalParamDTO priParam)
        {
            List<object> param1 = new List<object>();
            param1.Add(priParam);
            si.url = url_r;
            FDouble rtn = si.invoke<FDouble>("ciOrBdSrvPriceCal", param1.ToArray());
            return rtn;
        }
        /// <summary>
        /// 临床医嘱选择服务，服务折扣价格计算
        /// </summary>
        /// <param name="param"></param>
        /// <param name="id_pripat">患者价格分类</param>
        /// <returns></returns>
        public MedSrvPriceDO ciOrBdSrvPriceCalByPriMode(BdSrvPriCalParamDTO param, String id_pripat)
        {
            List<object> p = new List<object>();
            p.Add(param);
            p.Add(id_pripat);
            si.url = url_r;
            MedSrvPriceDO rtn = si.invoke<MedSrvPriceDO>("ciOrBdSrvPriceCalByPriMode", p.ToArray());
            return rtn;
        }
        /// <summary>
        /// 获得string类型的系统参数
        /// </summary>
        /// <param name="id_org"></param>
        /// <param name="paramCode"></param>
        /// <returns></returns>
        public string getStringSystemParam(String id_org, String paramCode)
        {
            List<object> param1 = new List<object>();
            param1.Add(id_org);
            param1.Add(paramCode);
            si.url = url_r;
            string rtn = si.invoke<string>("getStringSystemParam", param1.ToArray());
            return rtn;
        }
        /// <summary>
        /// 获得int类型的系统参数
        /// </summary>
        /// <param name="id_org"></param>
        /// <param name="paramCode"></param>
        /// <returns></returns>
        public int getIntSystemParam(String id_org, String paramCode)
        {
            List<object> param1 = new List<object>();
            param1.Add(id_org);
            param1.Add(paramCode);
            si.url = url_r;
            int rtn = si.invoke<int>("getIntSystemParam", param1.ToArray());
            return rtn;
        }
        public MeterialDO[] getMeterialDOByWhereSql(String whereSql)
        {
            List<object> param1 = new List<object>();
            param1.Add(whereSql);
            si.url = url_r;
            MeterialDO[] rtn = si.invokeList<MeterialDO>("getMeterialDOByWhereSql", param1.ToArray());
            return rtn;
        }

        /// <summary>
        /// 获取分方信息
        /// </summary>
        /// <param name="id_en"></param>
        /// <returns></returns>
        public OrdPresDTO[] getOrdPresInfo(String id_en)
        {
            List<object> param1 = new List<object>();
            param1.Add(id_en);
            si.url = url_r;
            OrdPresDTO[] rtn = si.invokeList<OrdPresDTO>("getOrdPresInfo", param1.ToArray());
            return rtn;
        }
        /// <summary>
        /// 获得科室下的病区
        /// </summary>
        /// <param name="id_dep"></param>
        /// <returns></returns>
        public string getNurAreaOfDep(string id_dep)
        {
            List<object> param1 = new List<object>();
            param1.Add(id_dep);
            si.url = url_r;
            string rtn = si.invoke<string>("getNurAreaOfDep", param1.ToArray());
            return rtn;
        }

        /// <summary>
        /// 获取医疗单中医嘱关联项和医嘱Agg
        /// </summary>
        /// <param name="ems"></param>
        /// <returns></returns>
        public CiOrAggAndRelInfo getCiOrAggAndRelInfo8Ems(CiEmsDTO ems, CiEnContextDTO ciEnContextDTO)
        {
            object[] param = new object[] { ems, ciEnContextDTO };
            si.url = url_r;
            CiOrAggAndRelInfo rtn = si.invoke<CiOrAggAndRelInfo>("getCiOrAggAndRelInfo8Ems", param.ToArray());
            return rtn;
        }

        public string[] getSrvScope(string sql)
        {
            // throw new NotImplementedException();
            object[] param = new object[] { sql };
            si.url = url_r;
            string[] rtn = si.invokeStringList("getSrvScope", param.ToArray());

            return rtn;
        }


        /// <summary>
        /// 当服务选择时 界面数据初始化
        /// </summary>
        /// <param name="envinfo"></param>
        /// <param name="param"></param>
        /// <returns></returns>
        public CiEmsDTO getEmsDiDTO(UIEmsEnvDTO envinfo, BdSrv4EmsDiDTO paramDTO)
        {
            object[] param = new object[] { envinfo, paramDTO };
            si.url = url_r;
            CiEmsDTO rtn = si.invoke<CiEmsDTO>("getEmsDiDTO", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 医嘱的列表的排列顺序
        /// </summary>
        /// <returns></returns>
        public string getOrderSequenceMode()
        {
            List<object> param1 = new List<object>();
            si.url = url_r;
            string rtn = si.invoke<string>("getOrderSequenceMode", param1.ToArray());
            return rtn;
        }

        /// <summary>
        /// 新的执行科室（可包含医嘱流向、物资流向）
        /// </summary>
        /// <param name="param"></param>
        /// <returns></returns>
        public OrWfExDeptDTO[] GetExeDepts4CiOrSrv(OrWfExDeptParamDTO param)
        {
            List<object> param1 = new List<object>();
            param1.Add(param);
            si.url = url_r;
            OrWfExDeptDTO[] rtn = si.invokeList<OrWfExDeptDTO>("GetExeDepts4CiOrSrv", param1.ToArray());
            return rtn;
        }
        /// <summary>
        /// 新的执行科室（可包含医嘱流向、物资流向）
        /// </summary>
        /// <param name="param"></param>
        /// <returns></returns>
        public OrWfDeptInfoDTO getExeDepts4CiOrSrvN(OrWfExDeptParamDTO param)
        {
            List<object> param1 = new List<object>();
            param1.Add(param);
            si.url = url_r;
            OrWfDeptInfoDTO rtn = si.invoke<OrWfDeptInfoDTO>("getExeDepts4CiOrSrvN", param1.ToArray());
            return rtn;
        }
        /// <summary>
        /// 查询剂量单位
        /// </summary>
        /// <param name="id_measdoc"></param>
        /// <returns></returns>
        public MeasDocDO getMeasDocDOById(string id_measdoc)
        {
            List<object> param1 = new List<object>();
            param1.Add(id_measdoc);
            si.url = url_r;
            MeasDocDO rtn = si.invoke<MeasDocDO>("getMeasDocDOById", param1.ToArray());
            return rtn;
        }

        public OrObsAandLabDTO getObsAndLabDto(string id_or, string type)
        {
            object[] param = new object[] { id_or, type };
            si.url = url_r;
            OrObsAandLabDTO rtn = si.invoke<OrObsAandLabDTO>("getObsAndLabDto", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 医嘱单打印患者信息
        /// </summary>
        /// <param name="id_dep_nur"></param>
        /// <returns></returns>
        public Ent4BannerDTO[] getEnt4BannerDTOsForOrdprn(String id_dep_nur)
        {
            List<object> param1 = new List<object>();
            param1.Add(id_dep_nur);
            si.url = url_r;
            Ent4BannerDTO[] rtn = si.invokeList<Ent4BannerDTO>("getEnt4BannerDTOsForOrdprn", param1.ToArray());
            return rtn;
        }

        /// <summary>
        /// 病理申请分类数据
        /// </summary>
        /// <param name="id_ent">就诊id</param>
        /// <returns></returns>
        public OrdApPathgyDTO[] getPathgyList(string id_ent)
        {
            object[] param = new object[] { id_ent };
            si.url = url_r;
            OrdApPathgyDTO[] rtn = si.invokeList<OrdApPathgyDTO>("getPathgyList", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 获取医嘱打印对象
        /// </summary>
        /// <returns></returns>
        public OrdPrintDO[] getOrdPrintDOs(OrdPrintParamDTO printParam)
        {

            object[] param = new object[] { printParam };
            si.url = url_r;
            OrdPrintDO[] rtn = si.invokeList<OrdPrintDO>("getOrdPrintDOs", param.ToArray());
            return rtn;
        }

        public OrConfirm[] getCiOrdConfirmedQry(OrConfirm confirm)
        {
            object[] param = { confirm };
            si.url = url_r;
            OrConfirm[] rtn = si.invokeList<OrConfirm>("getCiOrdConfirmedQry", param.ToArray());
            return rtn;
        }
        public string[] getOIDs(int size)
        {
            object[] param = new object[] { size };
            si.url = url_r;
            string[] rtn = si.invokeStringList("getOIDs", param.ToArray());
            return rtn;
        }

        /**
          * 本次就诊的就诊数组 （诊断编码和诊断名称）
          * @param id_ent
          * @return String[] diag;diag[1] =K35.902&R50.901 
          *                       diag;diag[0] = 急性阑尾炎&发热
          * @throws BizException
       */

        public String[] getDiagArray(String id_ent)
        {
            object[] param = new object[] { id_ent };
            si.url = url_r;
            String[] rtn = si.invokeStringList("getDiagArray", param.ToArray());
            return rtn;
        }


        /// <summary>
        /// 医嘱助手多医疗单（医嘱模板保存）
        /// </summary>
        /// <param name="envinfo"></param>
        /// <param name="ortplItemDO"></param>
        /// <returns></returns>
        public MoreEmsParamDTO getMoreEmsParamDTO(CiEnContextDTO envinfo, OrTplNItmDO[] ortplItemDO)
        {
            object[] param = new object[] { envinfo, ortplItemDO };
            si.url = url_r;
            MoreEmsParamDTO rtn = si.invoke<MoreEmsParamDTO>("getMoreEmsParamDTO", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 根据就诊历史、医嘱模板中医嘱获取界面展现的CiEmsDTO
        /// </summary>
        /// <param name="ordIds">医嘱id集合</param>
        /// <param name="bannerDTO">当前就诊banner对象</param>
        /// <returns></returns>
        public MoreEmsParamDTO getHistoryMoreEmsParam(string[] ordIds, CiEnContextDTO ciEnContext)
        {

            List<object> param = new List<object>();
            param.Add(ordIds);
            param.Add(ciEnContext);
            si.url = url_r;
            MoreEmsParamDTO rtn = si.invoke<MoreEmsParamDTO>("getHistoryMoreEmsParam", param.ToArray());

            return rtn;
        }

        /// <summary>
        /// 获取就诊历史中医嘱转换的就Ciems模板
        /// </summary>
        /// <param name="ordIds">医嘱id集合</param>
        /// <param name="ciEnContext">上下文就诊环境属性</param>
        /// <returns></returns>
        public MoreEmsParamDTO getCiEmsCopyByOrdIds(string[] ordIds, CiEnContextDTO ciEnContext) {

            List<object> param = new List<object>();
            param.Add(ordIds);
            param.Add(ciEnContext);
            si.url = url_r;
            MoreEmsParamDTO rtn = si.invoke<MoreEmsParamDTO>("getCiEmsCopyByOrdIds", param.ToArray());

            return rtn;
        }

        /// <summary>
        /// 根据组套中的医疗服务、医嘱模板获取界面展现的CiEmsDTO
        /// </summary>
        /// <param name="mkrMsSrvDOList">医疗服务对象</param>
        /// <param name="mkrMsMrtplDOList">医嘱模板id集合</param>
        /// <param name="bannerDTO">banner对象</param>
        /// <returns></returns>
        public MoreEmsParamDTO getMkrMsMoreEmsParam(FArrayList mkrMsSrvDOList, FArrayList mkrMsMrtplDOList, Ent4BannerDTO bannerDTO)
        {

            List<object> param = new List<object>();
            param.Add(mkrMsSrvDOList);
            param.Add(mkrMsMrtplDOList);
            param.Add(bannerDTO);
            si.url = url_r;
            MoreEmsParamDTO rtn = si.invoke<MoreEmsParamDTO>("getMkrMsMoreEmsParam", param.ToArray());
            return rtn;
        }

        public LabDTO[] getLabItms8DateBP(string idpat, FDateTime start, FDateTime end, string[] srvlist)
        {
            object[] param = { idpat, start, end, srvlist };
            si.url = url_r;
            LabDTO[] rtn = si.invokeList<LabDTO>("getLabItms8DateBP", param.ToArray());
            return rtn;
        }

        public DiagTreatViewRntDataDTO getDiagTreatViewData(OrSrvSplitParamDTO orparam)
        {
            List<object> param = new List<object>();
            param.Add(orparam);

            si.url = url_r;
            DiagTreatViewRntDataDTO rtn = si.invoke<DiagTreatViewRntDataDTO>("getDiagTreatViewData", param.ToArray());
            return rtn;
        }

        /// <summary>
        ///  获取合理用药使用的CiEmsDTO对象
        /// </summary>
        /// <param name="ordIds">本次签署的医嘱id集合</param>
        /// <param name="bannerDTO"></param>
        /// <returns>本次就诊的已签署的药品医嘱以及ordIds 对应的医嘱</returns>
        public OrdRationalDrugDTO[] getRationalDrugDTOs(Ent4BannerDTO bannerDTO, String[] ordIds)
        {

            object[] param = new object[] { bannerDTO, ordIds };
            si.url = url_r;
            OrdRationalDrugDTO[] rtn = si.invokeList<OrdRationalDrugDTO>("getRationalDrugDTOs", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 医嘱助手   医技常规模板
        /// </summary>
        /// <returns></returns>
        public Medicalroutinetreedto[] getMedicalroutinetreedto(String _entp)
        {
            object[] param = new object[] { _entp };
            si.url = url_r;
            Medicalroutinetreedto[] rtn = si.invokeList<Medicalroutinetreedto>("getMedicalroutinetreedto", param.ToArray());
            return rtn;
        }

        public OrTplNItmDO[] getOrTplNItmDO(String id_ortmpl)
        {
            object[] param = new object[] { id_ortmpl };
            si.url = url_r;
            OrTplNItmDO[] rtn = si.invokeList<OrTplNItmDO>("getOrTplNItmDO", param.ToArray());
            return rtn;
        }

        public NewOrderTemplateDTO[] getNewOrderTemplateDTO(String id_ortmpl)
        {
            object[] param = new object[] { id_ortmpl };
            si.url = url_r;
            NewOrderTemplateDTO[] rtn = si.invokeList<NewOrderTemplateDTO>("getNewOrderTemplateDTO", param.ToArray());
            return rtn;
        }
        public BdHpIndicDTO getBdHpIndicationDTO(String id_srv, String id_mm, CiEnContextDTO ciEnContextDTO)
        {
            object[] param = new object[] { id_srv, id_mm, ciEnContextDTO };
            si.url = url_r;
            BdHpIndicDTO rtn = si.invoke<BdHpIndicDTO>("getBdHpIndicationDTO", param.ToArray());
            return rtn;
        }
        public BdHpIndicDTO[] getBdHpIndicationDTOs(String[] id_srvs, String[] id_mms, CiEnContextDTO ciEnContextDTO)
        {
            object[] param = new object[] { id_srvs, id_mms, ciEnContextDTO };
            si.url = url_r;
            BdHpIndicDTO[] rtn = si.invokeList<BdHpIndicDTO>("getBdHpIndicationDTOs", param.ToArray());
            return rtn;
        }
        public OrderMrDto[] GetOrderMrDtoFlushList(string idEnt, string codeEntp, CiOrderDO[] ciorders)
        {
            List<object> param = new List<object>();
            param.Add(idEnt);
            param.Add(codeEntp);
            param.Add(ciorders);
            si.url = url_r;
            OrderMrDto[] rtn = si.invokeList<OrderMrDto>("getOrderFlushMrDtoList", param.ToArray());
            
            return rtn;
           
        }
        public FMap2 GetOrderMrDtoFlushList2(string idEnt, string codeEntp, String[] idors,string idPsndoc,string refreshMode)
        {
            List<object> param = new List<object>();
            param.Add(idEnt);
            param.Add(codeEntp);
            param.Add(idors);
            param.Add(idPsndoc);
            param.Add(refreshMode);
            si.url = url_r;
            //OrderMrDto[] rtn = si.invokeList<OrderMrDto>("getOrderFlushMrDtoList", param.ToArray());
            FMap2 map = si.invoke<FMap2>("getOrderMrDtoFlushList", param.ToArray());
            //return rtn;
            return map;
        }
        public FMap2 getOrdFeebill(String id_ent, String code_entp)
        {
            List<object> param = new List<object>();
            param.Add(id_ent);
            param.Add(code_entp);
            si.url = url_r;
            return si.invoke<FMap2>("getOrdFeebill", param.ToArray());
        }
        
        /// <summary>
        /// 保存多医疗单
        /// </summary>
        /// <param name="szEmsDTO"></param>
        /// <returns></returns>
        public FMap2 saveMultiEmsDTO(CiEmsDTO[] szEmsDTO, CiEnContextDTO ctx)
        {
            List<object> param = new List<object>();
            param.Add(szEmsDTO);
            param.Add(ctx);
            si.url = url_r;
            return si.invoke<FMap2>("saveMultiEmsDTO", param.ToArray());
        }

        /// <summary>
        /// 根据多医嘱ID，获取多医疗单(实验验证)
        /// </summary>
        /// <param name="szId_ors">医嘱ID数组</param>
        /// <param name="ctx">就诊上下文</param>
        /// <returns></returns>
        public FMap2 getMultiEmsDTO(CiOrderDO[] szOrders,int[] szEmsType, CiEnContextDTO ctx)
        {
            List<object> param = new List<object>();
            param.Add(szOrders);
            param.Add(szEmsType);
            param.Add(ctx);
            si.url = url_r;
            return si.invoke<FMap2>("getMultiEmsDTO", param.ToArray());
        }

        /// <summary>
        /// 根据保外诊断的诊断定义id查询关联的医嘱
        /// </summary>
        /// <param name="id_en">本次就诊id</param>
        /// <param name="id_didef">诊断定义id</param>
        /// <returns></returns>
        public CiOrderDO[] getCiOrdersUsedHpCiDi(string id_en, string id_didef)
        {

            List<object> param = new List<object>();
            param.Add(id_en);
            param.Add(id_didef);
            si.url = url_r;
            CiOrderDO[] t=  si.invokeList<CiOrderDO>("getCiOrdersUsedHpCiDi", param.ToArray());
            return t;
        }
        /// <summary>
        /// 住院的助手协定处方
        /// </summary>
        /// <param name="id_temp"></param>
        /// <returns></returns>
        public Medicalroutinetreedto[] getPrescriptionTree(String id_temp)
        {
            List<object> param = new List<object>();
            param.Add(id_temp);
            si.url = url_r;
            Medicalroutinetreedto[] rtn = si.invokeList<Medicalroutinetreedto>("getPrescriptionTree", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 住院的助手协定处方
        /// </summary>
        /// <param name="id_temp"></param>
        /// <returns></returns>
        public Medicalroutinetreedto[] getPrescriptionTreeNew(String type)
        {
            List<object> param = new List<object>();
            param.Add(type);
            si.url = url_r;
            Medicalroutinetreedto[] rtn = si.invokeList<Medicalroutinetreedto>("getPrescriptionTreeNew", param.ToArray());
            return rtn;
        }
        /// <summary>
        /// 诊疗视图关键点数据
        /// </summary>
        /// <param name="id_en"></param>
        /// <param name="start"></param>
        /// <param name="end"></param>
        /// <returns></returns>
        public DiagTreatKeyPointRntDataDTO[] getDiagTreatKeyPointData(string id_en, FDateTime start, FDateTime end)
        {
            List<object> param = new List<object>();
            param.Add(id_en);
            param.Add(start);
            param.Add(end);
            si.url = url_r;
            DiagTreatKeyPointRntDataDTO[] rtn = si.invokeList<DiagTreatKeyPointRntDataDTO>("getDiagTreatKeyPointData", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 判断医嘱状态是否变化
        /// </summary>
        /// <param name="orders"></param>
        /// <returns></returns>
        public String JudgeOrderStatus(CiOrderDO[] orders){
            List<object> param1 = new List<object>();
            param1.Add(orders);
            si.url = url_r;
            string rtn = si.invoke<string>("JudgeOrderStatus", param1.ToArray());
            return rtn;
        }

        /// <summary>
        /// 撤回医嘱状态判断
        /// </summary>
        /// <param name="orders"></param>
        /// <returns></returns>
        public FMap2 JudgeOrderStatusInMultiUser(CiOrderDO[] orders,string id_dep_phy,string id_dep_nur,string validatType)
        {

            List<object> param = new List<object>();
            param.Add(orders);
            param.Add(id_dep_phy);
            param.Add(id_dep_nur);
            param.Add(validatType);
            si.url = url_r;
            FMap2 rtn = si.invoke<FMap2>("JudgeOrderStatusInMultiUser", param.ToArray());
            return rtn;
        }


        /// <summary>
        /// banner 临床路径
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        public String[] getHpcpBannerInfo(String id_ent)
        {
            object[] param = new object[] { id_ent,"" };
            si.url = url_r;
            String[] rtn = si.invokeStringList("getHpcpBannerInfo", param.ToArray());
            return rtn;
        }
        /// <summary>
        /// 判断开始和结束日期之间是否有有效执行顿数
        /// </summary>
        /// <param name="dts"></param>
        /// <param name="id_freq"></param>
        public void judgeBeginEndTimeHasMpTimes(FDateTime begin, FDateTime end, String id_freq)
        {
            object[] param = new object[] { begin,end, id_freq };
            si.url = url_r;
            si.invoke<String>("judgeBeginEndTimeHasMpTimes", param.ToArray());
        }

        /// <summary>
        /// 获取就诊历史医嘱列表数据集合
        /// </summary>
        /// <param name="id_en">就诊id</param>
        /// <param name="code_entp">就诊类型编码</param>
        /// <param name="orderStr">排序字段</param>
        /// <returns>医嘱map结构，包含两项，ciOrderList 医嘱list集合，ciOrderPriMap 医嘱id与价格的map集合</returns>
        public FMap2 getEnHistoryCiOrders(String id_en, String code_entp, String orderStr) {

            object[] param = new object[] { id_en, code_entp, orderStr };
            si.url = url_r;
            FMap2 map = si.invoke<FMap2>("getEnHistoryCiOrders", param.ToArray());
            return map;
        }
        /// <summary>
        /// 患者就诊费用统计
        /// </summary>
        /// <param name="id_en"></param>
        /// <param name="code_entp"></param>
        /// <param name="fg_pres_outp"></param>
        /// <returns></returns>
        public FMap2 getPatEntFeesCensus(string id_en, string code_entp, FBoolean fg_pres_outp)
        {
            object[] param = new object[] { id_en, code_entp, fg_pres_outp };
            si.url = url_r;
            FMap2 map = si.invoke<FMap2>("getPatEntFeesCensus", param.ToArray());
            return map;
        }
        public FBoolean JudgeEntStatusValidate(String code_entp, String id_ent, String id_dep_phy) {
            object[] param = new object[] { code_entp, id_ent, id_dep_phy };
            si.url = url_r;
            return si.invoke<FBoolean>("JudgeEntStatusValidate", param.ToArray());
        }

        /// <summary>
        /// 医保共享参数
        /// </summary>
        /// <param name="id_org"></param>
        /// <param name="id_dept"></param>
        /// <returns></returns>
        public FBoolean getIsDeptOrDatumshared(string id_org, string id_dept)
        {
            object[] param = new object[] { id_org, id_dept };
            si.url = url_r;
            return si.invoke<FBoolean>("getIsDeptOrDatumshared", param.ToArray());
        }

        /// <summary>
        /// 医嘱模板分类
        /// </summary>
        /// <param name="id_dept"></param>
        /// <param name="id_emp"></param>
        /// <param name="sd_tp"></param>
        /// <returns></returns>
        public FMap getTemplateClassIfication(string en_entp,String id_dept, String id_emp, String sd_tp)
        {
            object[] param = new object[] {en_entp, id_dept, id_emp, sd_tp };
            si.url = url_r;
            FMap map = si.invoke<FMap>("getTemplateClassIfication", param.ToArray());
            return map;
        }

        /// <summary>
        /// 医嘱模板项目显示（门诊医嘱助手改造 20170510）
        /// </summary>
        /// <param name="id_ortmpl"></param>
        /// <returns></returns>
        public FMap getNewOrderTemplateDTO2(String[] id_ortmpl, CiEnContextDTO ctx)
        {
            object[] param = new object[] { id_ortmpl, ctx};
            si.url = url_r;
            FMap map = si.invoke<FMap>("getNewOrderTemplateDTO2", param.ToArray());
            return map;
        }
        /// <summary>
        /// 判断服务是否可开立
        /// </summary>
        /// <param name="ordSrvChangedInfoDTOs"></param>
        /// <param name="code_entp">就诊类型</param>
        /// <returns>不可开立的服务集合（Key:"Id_srv,Id_mm",Value:服务不可开立原因提示String）</returns>
        public FMap2 JudgeOrdChangedSrv(OrdSrvChangedInfoDTO[] ordSrvChangedInfoDTOs, String code_entp)
        {
            object[] param = new object[] { ordSrvChangedInfoDTOs, code_entp };
            si.url = url_r;
            FMap2 map = si.invoke<FMap2>("JudgeOrdChangedSrv", param.ToArray());
            return map;
        }
        /// <summary>
        /// 判断服务是否可开立
        /// </summary>
        /// <param name="code_entp">就诊类型</param>
        /// <param name="medSrvDOs">待判断服务对象数组</param>
        /// <returns>不可开立的服务集合（Key:"Id_srv,Id_mm",Value:服务不可开立原因提示String）</returns>
        public FMap2 JudgeOrdChangedSrv1(String code_entp, MedSrvDO[] medSrvDOs)
        {
            object[] param = new object[] { code_entp, medSrvDOs };
            si.url = url_r;
            FMap2 map = si.invoke<FMap2>("JudgeOrdChangedSrv1", param.ToArray());
            return map;
        }
        /// <summary>
        /// 查询模板项目（已添加缓存）
        /// </summary>
        /// <param name="id_ortmpl"></param>
        /// <param name="ctx"></param>
        /// <returns></returns>
        public OrderTemplateRstDTO getOrTemplateCache(String[] id_ortmpl, CiEnContextDTO ctx)
        {
            object[] param = new object[] { id_ortmpl, ctx };
            si.url = url_r;
            OrderTemplateRstDTO dto = si.invoke<OrderTemplateRstDTO>("getOrTemplateCache", param.ToArray());
            return dto;
        }
		 /// <summary>
        /// 助手开立医嘱的个数限制设置
        /// </summary>
        /// <returns></returns>
        public int getOrHelperOpenOrCountLimitSet()
        {
            return si.invoke<int>("getOrHelperOpenOrCountLimitSet");
        }

        /// <summary>
        /// 医保共享查询本院数据
        /// </summary>
        /// <param name="id_pat"></param>
        /// <param name="id_hp"></param>
        /// <returns></returns>
        public MedicalSharingDTO[] getMedicalSharing(String id_pat, String id_hp)
        {
            List<object> param = new List<object>();
            param.Add(id_pat);
            param.Add(id_hp);
            si.url = url_r;
            MedicalSharingDTO[] rtn = si.invokeList<MedicalSharingDTO>("getMedicalSharing", param.ToArray());
            return rtn;
        }
        /// <summary>
        /// 签署时 验证医保功能
        /// </summary>
        /// <param name="id_or"></param>
        /// <param name="id_pat"></param>
        /// <param name="id_hp"></param>
        /// <returns></returns>
        public MedicalSharingDTO[] getOPenCiOrder(String[] id_or, String id_pat, String id_hp)
        {
            List<object> param = new List<object>();
            param.Add(id_or);
            param.Add(id_pat);
            param.Add(id_hp);
            si.url = url_r;
            MedicalSharingDTO[] rtn = si.invokeList<MedicalSharingDTO>("getOPenCiOrder", param.ToArray());
            return rtn;
        }

        public  FMap2 getMMName(String[] id_ors)
        {
            List<object> param = new List<object>();
            param.Add(id_ors);
            si.url = url_r;
            FMap2 rtn = si.invoke<FMap2>("getMMName", param.ToArray());
            return rtn;
        }
        /// <summary>
        /// 获得末次病程
        /// </summary>
        /// <param name="idEnt"></param>
        /// <returns></returns>
        public FMap2 getCiMrCourseOfLastDisease(String idEnt,FBoolean firstMr)
        {
            List<object> param = new List<object>();
            param.Add(idEnt);
            param.Add(firstMr);
            si.url = url_r;
            return si.invoke<FMap2>("getCiMrCourseOfLastDisease", param.ToArray());
        }
        /// <summary>
        /// 诊断删除判断是否结算
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        public String getUsedHpdiexpensese(string id_ent, string Id_didef)
        {
            List<object> param1 = new List<object>();
            param1.Add(id_ent);
            param1.Add(Id_didef);
            si.url = url_r;
            string rtn = si.invoke<string>("getUsedHpdiexpensese", param1.ToArray());
            return rtn;
        }

        /// <summary>
        /// 判定是否医保特殊病	 
        /// </summary>
        /// <param name="idhp"></param>
        /// <param name="idpat"></param>
        /// <param name="iddiDefs"></param>
        /// <returns></returns>
        public FMap isPatSpecDi(String idhp, String idpat, String[] iddiDefs)
        {
            List<object> param = new List<object>();
            param.Add(idhp);
            param.Add(idpat);
            param.Add(iddiDefs);
            si.url = url_r;
            FMap rtn = si.invoke<FMap>("isPatSpecDi", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 判定是否自费诊断
        /// </summary>
        /// <param name="idhp"></param>
        /// <param name="sdentp"></param>
        /// <param name="idDiDefs"></param>
        /// <returns></returns>
        public FMap isSelfPaidDi(String idhp, String sdentp, String[] idDiDefs)
        {
            List<object> param = new List<object>();
            param.Add(idhp);
            param.Add(sdentp);
            param.Add(idDiDefs);
            si.url = url_r;
            FMap rtn = si.invoke<FMap>("isSelfPaidDi", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 自费医嘱修改成医保时 调用医保适应症
        /// </summary>
        /// <param name="id_srv"></param>
        /// <param name="id_mm"></param>
        /// <param name="ciEnContextDTO"></param>
        /// <returns></returns>
        public EmsOrDrug getHPIndiccation(String id_srv, String id_mm, CiEnContextDTO ciEnContextDTO)
        {
            List<object> param = new List<object>();
            param.Add(id_srv);
            param.Add(id_mm);
            param.Add(ciEnContextDTO);
            si.url = url_r;
            EmsOrDrug rtn = si.invoke<EmsOrDrug>("getHPIndiccation", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 医保医嘱的和诊断的强制关系
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="id_hp"></param>
        /// <param name="id_srvs"></param>
        /// <returns></returns>
        public FMap ValidateOrderAndDiag(String id_ent, String id_hp, String[] id_srvs)
        {

            List<object> param = new List<object>();
            param.Add(id_ent);
            param.Add(id_hp);
            param.Add(id_srvs);
            si.url = url_r;
            FMap rtn = si.invoke<FMap>("ValidateOrderAndDiag", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="id_or"></param>
        /// <param name="ctx"></param>
        /// <returns></returns>
        public MedicalSharingDTO[] getRepeatMessageOrder(String id_or, CiEnContextDTO ctx)
        {
            List<object> param = new List<object>();
            param.Add(id_or);
            param.Add(ctx);
            si.url = url_r;
            MedicalSharingDTO[] rtn = si.invokeList<MedicalSharingDTO>("getRepeatMessageOrder", param.ToArray());
            return rtn;
        }
        /// <summary>
        /// 多医疗单的0  仅生成医疗单UI数据（非自动生成医嘱模式）  ,   1  后台自动生成医嘱模式
        /// </summary>
        /// <returns></returns>
        public String getCiOrAssMultiEmsHandleMode()
        {
            List<object> param = new List<object>();
            si.url = url_r;
            string rtn = si.invoke<String>("getCiOrAssMultiEmsHandleMode", param.ToArray());
            return rtn;
        }

        public CheckRstDTO checkEmsBeforSave(CheckParamDTO checkparam)
        {
            List<object> param = new List<object>();
            param.Add(checkparam);
            si.url = url_r;
            CheckRstDTO rtn = si.invoke<CheckRstDTO>("checkEmsBeforSave", param.ToArray());
            return rtn;
        }
    }
}
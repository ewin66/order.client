using System;
using System.Collections.Generic;
using iih.bd.fc.orwf.d;
using iih.bd.pp.hp.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.dto.blexorder.d;
using iih.ci.ord.dto.d;
using iih.ci.ord.dto.opdispensecond.d;
using iih.ci.ord.dto.OrderPresSplitDTO.d;
using iih.ci.ord.dto.ordpres.d;
using iih.ci.ord.dto.pipvinfo.d;
using iih.ci.ord.ordappathgy.d;
using xap.mw.coreitf.d;
using iih.ci.ord.dto.unchargeordinfo.d;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.ortpl.d;
using iih.ci.ord.cior.d;
using iih.ci.ord.cirptlab.d;
using iih.ci.ord.cirptobs.d;
using iih.ci.ord.dto.allergy.d;
using iih.ci.ord.dto.ordertpltree.d;
using iih.ci.ord.dto.orderpandectemrdto.d;
using iih.ci.ord.dto.ordertemplatedto.d;
using iih.ci.ord.dto.ordinput.d;
using iih.ci.ord.dto.orobsandlab.d;
using iih.ci.ord.dto.vitalsignsdto.d;
using iih.ci.ord.ems.d;
using iih.ci.ord_stub.dto.d;
using iih.en.pv.dto.d;
using iih.en.pv.entdi.d;
using xap.sys.devcfg.func.d;
using PatUnDoOrderdto = iih.ci.ord.dto.patundoorderdto.d.PatUnDoOrderdto;
using iih.bd.srv.dto.d;
using iih.ci.ord.dto.consdto.d;
using iih.ci.ord.dto.patdetaildto.d;
using iih.ci.ord.srvpri.d;
using iih.bd.mm.meterial.d;
using iih.ci.iih.ci.ord.dto.d;
using iih.ci.ord.dto.medicalroutinetreedto.d;
using iih.ci.ord.emsdi.d;
using xap.sys.xbd.measdoc.d;
using iih.ci.ord.ordprn.d;
using iih.ci.ord.dto.ordprintdto.d;
using iih.ci.ord.moreemsdto.d;
using iih.ci.ord.tmpl.d;
using iih.ci.ord.dto.ordrationaldrugdto.d;
using xap.mw.core.data;
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
    public interface ICiOrdQryService
    {
        /**
         * 获取医嘱DTO
         */
        EmsUIDTO getEmsUIDTO(String id_order, String id_hp, string code_entp);

        /// <summary>
        /// Gets the SRV vs mm.
        /// </summary>
        /// <param name="id_org">The id_org.</param>
        /// <param name="id_srv">The id_srv.</param>
        /// <param name="id_dept_mp">The 执行科室.</param>
        /// <param name="id_dept_phy">The 开立科室.</param>
        /// <param name="id_hp">The 社会保险号.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-09-23
        EmsOrDrug[] getSrvVsMm(String id_org, String id_srv, String id_dept_mp, String id_dept_phy, String id_hp, string code_entp);

        /**
         * 根据门诊发药查询条件获得门诊未发药患者列表信息
         * @param cond  门诊发药查询条件DTO
         * @return 患者就诊信息DTO
         * @throws BizException
         */
        PiPvInfoDTO[] getOpNoDrugPatiInfos(OpDispenseCondDTO cond);

        /**
         * 根据患者id获得门诊患者未发药处方
         * @param patiid   患者主键标识
         * @param isHerb   是否是草药 否则为西成药
         * @return
         * @throws BizException
         */
        // DispenseDTO[] getOpPatiNoDrugPreses(String patiid, FBoolean isHerb);	

        /**
         * 根据门诊退药查询条件获得门诊退药处方头信息
         * @param cond  
         * @return
         * @throws BizException
         */
        // DispenseDTO[] getOpDrugRtnPresHeadInfos(OpDrugRtnCondDTO cond);	

        /**
         * 根据处方主键标识获得处方药品信息集合
         * @param presid  处方主键标识
         * @return
         * @throws BizException
         */
        // OpeDgAppdtDTO[] getPresItemsByPresId(String presid,String statusMp);

        /**
 * 未记费医嘱查询列表

 * @param patid
 * @param dtSignB
 * @param dtSignE
 * @param code_entp
 * @return
 */
        UnchargeOrdDTO[] getUnchargeOrderList(String patid, FDateTime dtSignB, FDateTime dtSignE, String code_entp, string id_org);


        /// <summary>
        /// Gets 获取服务套内项目
        /// </summary>
        /// <param name="id_srv">The id_srv.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-09-28
        MedSrvDO[] GetSrvSetItemList(string id_srv);

        /// <summary>
        /// 获取医保计划
        /// </summary>
        /// <param name="id_hp"></param>
        /// <param name="id_srv"></param>
        /// <returns></returns>
        HPSrvorcaDO GetHpSrvOrCaDo(String id_hp, String id_srv);

        PatUnDoOrderdto[] queryPatUnDoOrderdto(String entId);
        //医疗服务 根据关键词检索
        EmsOrSrvSc[] getEmsOrSrvSc(string sd_srvtp, string strWhere, string pa_Healthca, string code_entp);
        //医疗模板 根据关键词检索
        EmsOrSrvSc[] getOrtplEmsOrSrvSc(OrtplDTO dto);
        //医疗服务根据bd_srv id检索
        EmsOrSrvSc[] getMedSrvId(string id_srv);

        //检查项目
        EmsObsItemDO[] getEmsObsItemDO(string id_srv, string type);

        //修改取得 EmsUIDTO 数据
        EmsUIDTO GetEmsUIDTO(string id_or, string type, string code_entp);
        //获取检验 检查的 类型 分类树  
        /// <summary>
        /// 根据物品类型获得物品信息
        /// </summary>
        /// <param name="mmtp"></param>
        /// <returns></returns>
        EmsOrDrug[] getMmByMmtp(String id_mmtp);

        //获取检验 检查的树

        OrObsAandLabDTO[] getOrObsAandLabDTO(string id_ent, string type);
        //获取检验 检查的 日期分类 树 
        OrObsAandLabDTO[] getObsAndLabDateList(string id_ent, string type);

        /// <summary>
        /// 会诊应答列表
        /// </summary>
        /// <param name="id_dep"></param>
        /// <param name="su_cons"></param>
        /// <returns></returns>
        OrdConsDTO[] GetConsList(String id_dep, String su_cons);

        //总览的诊断信息
        IpViewDiagDTO[] getCiDiagItemDOList(string id_ent, string type);
        //总览使用检查
        CiRptObsDO[] getCiRptObsDO(string id_ent);
        //总览使用 检验
        CirptlabAggDO[] getCirptlabAggDO(string id_ent);
        //费用
        String[] getBlcgAmtVsDrugRation(String id_pat, String id_ent, String codeSrv);
        //生命体征
        VitalSignsDto getCiorderPreviewDTOS(String id_ent, string Dt_birth);
        //医嘱（处置）

        //过敏史
        AllergyDto[] getAllergyDto(String id_pat);


        //医嘱录入B画面
        OrdInputDto[] getOrdInputDto(string id_ent, string id_doctor);
        //编辑时 取得医嘱信息
        FMap getCiEmsDTO(string[] id_ors);

        OrConfirm[] getCiOrdConfirm(OrConfirm confirm);
        AddFeeDTO[] getCiOrdFee(OrConfirm confirm);
        OrderPresSplitDTO[] getOrPresDTOs(string id_en);
        /// <summary>
        /// 查询医嘱关联的服务
        /// </summary>
        /// <param name="id_or"></param>
        /// <returns></returns>
        OrdSrvDO[] GetOrderSrvDOS(String id_or);

        /// <summary>
        /// 检查申请单号
        ///  </summary>
        /// <returns></returns>
        string getOrdApObsNoapplyform();
        /// <summary>
        /// 检验申请单号
        /// </summary>
        /// <returns></returns>
        string getOrdApLabNoapplyform();
        LabDTO[] getLabItms(String idpat, int num, String[] srvlist);


        /// <summary>
        /// 当前诊断
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        EntDiDO[] getEntDiDOList(String id_ent);

        /// <summary>
        /// 用血
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        CiordubDTO getOrderUBDto(String id_or);

        CiordubDTO[] getOrderUBDtoList(string id_ent);
        String getNoapplyform(String fullclassname);
        /// <summary>
        /// 病历
        /// </summary>
        /// <param name="code_entp"></param>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        OrderPandectEmrDTO[] getOrderPandectEmrDTO(string code_entp, string id_ent);

        /// <summary>
        /// 会诊树
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        OrdApConsDO[] getTreeOrdApConsDO(String id_ent);

        //医嘱助手患者既往就诊
        EntHisDiDTO[] getEntHisDiDTO(String id_pat);
        //医嘱页签列表
        PageDO[] getPageDOList(string doctor_id, string dept_id, string biz_id);

        RegularOrCaDO[] getRegularOrCaDOs();
        //医嘱助手常用医嘱项目
        RegularOrRelSrvDO[] getRegularOrRelSrvDOs(String id_regularorca);

        //医嘱助手模板树
        OrderTplTreeDto[] getOrderTplTreeDto(String id_ortpltp, Emp2Dep2GroupDTO edg);
        //医嘱助手模板项目
        OrderTemplateDTO getSrvortplitemAggDOS(String id_srvortpl);

        String getDepsNum(String id_dep);

        String getCiSrvCondition(String id_dep, String code);
        OrWfExDeptDTO[] getMpDept(OrWfExDeptParamDTO param);
        //病理主键生成规则
        string getOrdApPathgyDONober(string nomber);
        //生成备血医疗单的申请单号
        string getNoappbtlyform();

        AddFeeDTO getEmsfee(AddFeeDTO drug, OrWfExDeptParamDTO param);

        OrSplitOrderDTO[] splitOrSplitSqlRs(OrSrvSplitParamDTO param);

        SrvSplitOrderDTO[] splitSrvSplitSqlRs(OrSrvSplitParamDTO param);
        /// <summary>
        /// 医嘱助手医疗服务项目
        /// </summary>
        /// <param name="cindition"></param>
        /// <param name="ordercolumn"></param>
        /// <param name="islazy"></param>
        /// <returns></returns>
        MedSrvDO[] getClassMedSrvDOS(String cindition, String ordercolumn, FBoolean islazy);

        /// <summary>
        /// 医嘱助手医疗服务项目
        /// </summary>
        /// <param name="code_entp">就诊类型</param>
        /// <param name="cindition">查询医疗服务过滤条件</param>
        /// <param name="ordercolumn">排序列</param> 
        /// <returns>医疗服务map集合，key= medSrvList, value ： FArrayList 医疗服务集合，key=srvStatusMap，value：医疗服务不可用原因</returns>
        FMap2 getClassMedSrvMap(string code_entp , string cindition, string orderColumn);

        /// <summary>
        /// 患者既往就诊信息（门诊 和住院）
        /// </summary>
        /// <param name="patId"></param>
        /// <param name="qrySchms"></param>
        /// <returns></returns>
        EntHisDiDTO[] getEntHisDiBySchm(String patId, EnDiQrySchmDTO[] qrySchms);
        /**
      * 当前时间之前的天数
      * @param days
      * @return
      * @throws BizException
      */
        FDateTime getDateTomeBefore(int days);
        /**
         *  当前时间之后的天数
         * @param days
         * @return
         * @throws BizException
         */
        FDateTime getDateTomeAfter(int days);

        /**
       * 会诊患者详细信息接口
       * @param id_en
       * @return
       * @throws BizException
       */
        PatDetailDTO getConsPatDetail(String id_en);
        SkinTestRstDTO skinTestLogicMainBP(SkinTestParamDTO param);
        /// <summary>
        /// 临床医嘱选择服务，服务价格计算
        /// </summary>
        /// <param name="priParam"></param>
        /// <returns></returns>
        FDouble ciOrBdSrvPriceCal(BdSrvPriCalParamDTO priParam);
        /// <summary>
        /// 临床医嘱选择服务，服务折扣价格计算
        /// </summary>
        /// <param name="param"></param>
        /// <param name="id_pripat">患者价格分类</param>
        /// <returns></returns>
        MedSrvPriceDO ciOrBdSrvPriceCalByPriMode(BdSrvPriCalParamDTO param, String id_pripat);
        /// <summary>
        /// 获得string类型的系统参数
        /// </summary>
        /// <param name="id_org"></param>
        /// <param name="paramCode"></param>
        /// <returns></returns>
        string getStringSystemParam(String id_org, String paramCode);
        /// <summary>
        /// 获得int类型的系统参数
        /// </summary>
        /// <param name="id_org"></param>
        /// <param name="paramCode"></param>
        /// <returns></returns>
        int getIntSystemParam(String id_org, String paramCode);
        /// <summary>
        /// 根据传入的sql语句查询出物品
        /// </summary>
        /// <param name="whereSql"></param>
        /// <returns></returns>
        MeterialDO[] getMeterialDOByWhereSql(String whereSql);

        /// <summary>
        /// 获取分方信息
        /// </summary>
        /// <param name="id_en"></param>
        /// <returns></returns>
        OrdPresDTO[] getOrdPresInfo(String id_en);
        /// <summary>
        /// 获得科室下的病区
        /// </summary>
        /// <param name="id_dep"></param>
        /// <returns></returns>
        string getNurAreaOfDep(string id_dep);
        /// <summary>
        /// 获取医疗单中医嘱关联项和医嘱Agg
        /// </summary>
        /// <param name="ems"></param>
        /// <returns></returns>
        CiOrAggAndRelInfo getCiOrAggAndRelInfo8Ems(CiEmsDTO ems, CiEnContextDTO ciEnContextDTO);

        String[] getSrvScope(String sql);

        /// <summary>
        /// 当服务选择时 界面数据初始化
        /// </summary>
        /// <param name="envinfo"></param>
        /// <param name="param"></param>
        /// <returns></returns>
        CiEmsDTO getEmsDiDTO(UIEmsEnvDTO envinfo, BdSrv4EmsDiDTO param);
        /// <summary>
        /// 医嘱的列表的排列顺序
        /// </summary>
        /// <returns></returns>
        string getOrderSequenceMode();
        /// <summary>
        /// 新的执行科室（可包含医嘱流向、物资流向）
        /// </summary>
        /// <param name="param"></param>
        /// <returns></returns>
        OrWfExDeptDTO[] GetExeDepts4CiOrSrv(OrWfExDeptParamDTO param);
        /// <summary>
        /// 新的执行科室（可包含医嘱流向、物资流向）
        /// </summary>
        /// <param name="param"></param>
        /// <returns></returns>
        OrWfDeptInfoDTO getExeDepts4CiOrSrvN(OrWfExDeptParamDTO param);
        /// <summary>
        /// 查询剂量单位
        /// </summary>
        /// <param name="id_measdoc"></param>
        /// <returns></returns>
        MeasDocDO getMeasDocDOById(string id_measdoc);
        /// <summary>
        ///   获取检查检验DTO
        /// </summary>
        /// <param name="id_or"></param>
        /// <param name="type"></param>
        /// <returns></returns>
        OrObsAandLabDTO getObsAndLabDto(String id_or, String type);
        /// <summary>
        /// 医嘱单打印患者信息
        /// </summary>
        /// <param name="id_dep_nur"></param>
        /// <returns></returns>
        Ent4BannerDTO[] getEnt4BannerDTOsForOrdprn(String id_dep_nur);

        /// <summary>
        /// 病理申请分类数据
        /// </summary>
        /// <param name="id_ent">就诊id</param>
        /// <returns></returns>
        OrdApPathgyDTO[] getPathgyList(String id_ent);

        /// <summary>
        /// 获取医嘱打印对象
        /// </summary>
        /// <returns></returns>
        OrdPrintDO[] getOrdPrintDOs(OrdPrintParamDTO printParam);
        /// <summary>
        /// 医嘱确认查看
        /// </summary>
        /// <returns></returns>
        OrConfirm[] getCiOrdConfirmedQry(OrConfirm confirm);

        string[] getOIDs(int size);
        /**
	     * 本次就诊的就诊数组 （诊断编码和诊断名称）
	     * @param id_ent
	     * @return String[] diag;diag[1] =K35.902&R50.901 
	     *                       diag;diag[0] = 急性阑尾炎&发热
	     * @throws BizException
	 */
        String[] getDiagArray(String id_ent);

        /// <summary>
        /// 医嘱助手多医疗单（医嘱模板保存）
        /// </summary>
        /// <param name="envinfo"></param>
        /// <param name="ortplItemDO"></param>
        /// <returns></returns>
        MoreEmsParamDTO getMoreEmsParamDTO(CiEnContextDTO envinfo, OrTplNItmDO[] ortplItemDO);

        /// <summary>
        /// 获取就诊历史中医嘱转换的就Ciems模板
        /// </summary>
        /// <param name="ordIds">医嘱id集合</param>
        /// <param name="ciEnContext">上下文就诊环境属性</param>
        /// <returns></returns>
        MoreEmsParamDTO getHistoryMoreEmsParam(string[] ordIds, CiEnContextDTO ciEnContext);

        /// <summary>
        /// 获取就诊历史中医嘱转换的就Ciems模板
        /// </summary>
        /// <param name="ordIds">医嘱id集合</param>
        /// <param name="ciEnContext">上下文就诊环境属性</param>
        /// <returns></returns>
        MoreEmsParamDTO getCiEmsCopyByOrdIds(string[] ordIds, CiEnContextDTO ciEnContext);

        /// <summary>
        /// 门诊组套转中医嘱/医嘱模板转换为CiEms
        /// </summary>
        /// <param name="mkrMsSrvDOList">组套中医疗服务集合</param>
        /// <param name="mkrMsMrtplDOList">组套中医疗服务集合</param>
        /// <param name="bannerDTO">banner对象</param>
        /// <returns></returns>
        MoreEmsParamDTO getMkrMsMoreEmsParam(FArrayList mkrMsSrvDOList, FArrayList mkrMsMrtplDOList, Ent4BannerDTO bannerDTO);

        /// <summary>
        ///  获取合理用药使用的CiEmsDTO对象
        /// </summary>
        /// <param name="ordIds">本次签署的医嘱id集合</param>
        /// <param name="bannerDTO"></param>
        /// <returns>本次就诊的已签署的药品医嘱以及ordIds 对应的医嘱</returns>
        OrdRationalDrugDTO[] getRationalDrugDTOs(Ent4BannerDTO bannerDTO, String[] ordIds);


        LabDTO[] getLabItms8DateBP(String idpat, FDateTime start, FDateTime end, String[] srvlist);
        /// <summary>
        /// 获取诊疗视图数据   by li_cheng 
        /// </summary>
        /// <param name="id_en"></param>
        /// <param name="start"></param>
        /// <param name="end"></param>
        /// <returns></returns>
        DiagTreatViewRntDataDTO getDiagTreatViewData(OrSrvSplitParamDTO orparam);
        /// <summary>
        /// 医嘱助手   医技常规模板
        /// </summary>
        /// <returns></returns>
        Medicalroutinetreedto[] getMedicalroutinetreedto(String _entp);
        /// <summary>
        /// 医技模板项目
        /// </summary>
        /// <param name="id_ortmpl"></param>
        /// <returns></returns>
        OrTplNItmDO[] getOrTplNItmDO(String id_ortmpl);
        /// <summary>
        /// 医嘱模板项目显示
        /// </summary>
        /// <param name="id_ortmpl"></param>
        /// <returns></returns>
        NewOrderTemplateDTO[] getNewOrderTemplateDTO(String id_ortmpl);
        /// <summary>
        /// 查询医保适应症
        /// </summary>
        /// <param name="id_srv"></param>
        /// <param name="id_mm"></param>
        /// <param name="ciEnContextDTO"></param>
        /// <returns></returns>
        BdHpIndicDTO getBdHpIndicationDTO(String id_srv, String id_mm, CiEnContextDTO ciEnContextDTO);
        /// <summary>
        /// 查询医保适应症
        /// </summary>
        /// <param name="id_srvs"></param>
        /// <param name="id_mms"></param>
        /// <param name="ciEnContextDTO"></param>
        /// <returns></returns>
        BdHpIndicDTO[] getBdHpIndicationDTOs(String[] id_srvs, String[] id_mms, CiEnContextDTO ciEnContextDTO);

        /// <summary>
        /// 查询处置
        /// </summary>
        /// <param name="idEnt"></param>
        /// <param name="codeEntp"></param>
        /// <param name="ciorders"></param>
        /// <returns></returns>
        //OrderMrDto[] GetOrderMrDtoFlushList(string idEnt, string codeEntp, CiOrderDO[] ciorders);
        OrderMrDto[] GetOrderMrDtoFlushList(string idEnt, string codeEntp, CiOrderDO[] ciorders);
        /// <summary>
        /// 查询处置  处置回写病历 新接口 2017-05-09 by yzh
        /// </summary>
        /// <param name="idEnt"></param>
        /// <param name="codeEntp"></param>
        /// <param name="ciorders"></param>
        /// <returns></returns>
        FMap2 GetOrderMrDtoFlushList2(string idEnt, string codeEntp, String[] idors, string idPsndoc, string refreshMode);
        /// <summary>
        /// 获取医嘱费用清单
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="code_entp"></param>
        /// <returns></returns>
        FMap2 getOrdFeebill(String id_ent, String code_entp);


        /// <summary>
        /// 保存多医疗单
        /// </summary>
        /// <param name="szEmsDTO"></param>
        /// <returns></returns>
        FMap2 saveMultiEmsDTO(CiEmsDTO[] szEmsDTO, CiEnContextDTO ctx);

        /// <summary>
        /// 根据多医嘱ID，获取多医疗单
        /// </summary>
        /// <param name="szId_ors">医嘱ID数组</param>
        /// <param name="ctx">就诊上下文</param>
        /// <returns></returns>
        FMap2 getMultiEmsDTO(CiOrderDO[] szOrders, int[] szEmsType, CiEnContextDTO ctx);

        /// <summary>
        /// 根据保外诊断的诊断定义id查询关联的医嘱
        /// </summary>
        /// <param name="id_en">本次就诊id</param>
        /// <param name="id_didef">诊断定义id</param>
        /// <returns></returns>
        CiOrderDO[] getCiOrdersUsedHpCiDi(string id_en, string id_didef);
        /// <summary>
        /// 住院的助手的协定处方 Tree Dto 数据
        /// </summary>
        /// <param name="id_temp"></param>
        /// <returns></returns>
        Medicalroutinetreedto[] getPrescriptionTree(String id_temp);

        /// <summary>
        /// 诊疗视图关键点数据
        /// </summary>
        /// <param name="id_en"></param>
        /// <param name="start"></param>
        /// <param name="end"></param>
        /// <returns></returns>
        DiagTreatKeyPointRntDataDTO[] getDiagTreatKeyPointData(String id_en, FDateTime start, FDateTime end);
        /// <summary>
        /// 判断医嘱状态是否变化
        /// </summary>
        /// <param name="orders"></param>
        /// <returns></returns>
        String JudgeOrderStatus(CiOrderDO[] orders);
        /// <summary>
        /// 多用户操作下的医嘱状态校验
        /// </summary>
        /// <param name="orders"></param>
        /// <param name="id_dep_phy"></param>
        /// <param name="id_dep_or">开立病区</param>
        /// <param name="validateType"></param>
        /// <returns></returns>
        FMap2 JudgeOrderStatusInMultiUser(CiOrderDO[] orders, string id_dep_phy,string id_dep_nur, string validateType);

        /// <summary>
        /// banner 临床路径
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        String[] getHpcpBannerInfo(String id_ent);
        /// <summary>
        /// 判断开始和结束日期之间是否有有效执行顿数
        /// </summary>
        /// <param name="dts"></param>
        /// <param name="id_freq"></param>
        void judgeBeginEndTimeHasMpTimes(FDateTime begin, FDateTime end, String id_freq);

        /// <summary>
        /// 住院的助手协定处方
        /// </summary>
        /// <param name="id_temp"></param>
        /// <returns></returns>
        Medicalroutinetreedto[] getPrescriptionTreeNew(String type);

        /// <summary>
        /// 获取就诊历史医嘱列表数据集合
        /// </summary>
        /// <param name="id_en">就诊id</param>
        /// <param name="code_entp">就诊类型编码</param>
        /// <param name="orderStr">排序字段</param>
        /// <returns>医嘱map结构，包含两项，ciOrderList 医嘱list集合，ciOrderPriMap 医嘱id与价格的map集合</returns>
        FMap2 getEnHistoryCiOrders(String id_en, String code_entp, String orderStr);
        /// <summary>
        /// 患者就诊费用统计
        /// </summary>
        /// <param name="id_en"></param>
        /// <param name="code_entp"></param>
        /// <param name="fg_pres_outp"></param>
        /// <returns></returns>
        FMap2 getPatEntFeesCensus(string id_en, string code_entp, FBoolean fg_pres_outp);
        /// <summary>
        /// 判断患者的在院状态
        /// </summary>
        /// <param name="code_entp"></param>
        /// <param name="id_ent"></param>
        /// <param name="id_dep_phy"></param>
        /// <returns></returns>
        FBoolean JudgeEntStatusValidate(String code_entp, String id_ent, String id_dep_phy);
        /// <summary>
        /// 医保共享参数
        /// </summary>
        /// <param name="id_org"></param>
        /// <param name="id_dept"></param>
        /// <returns></returns>
        FBoolean getIsDeptOrDatumshared(string id_org,string id_dept);
        /// <summary>
        /// 医嘱模板分类显示
        /// </summary>
        /// <param name="id_dept"></param>
        /// <param name="id_emp"></param>
        /// <param name="sd_tp"></param>
        /// <returns></returns>
       FMap getTemplateClassIfication(string en_entp,String id_dept, String id_emp, String sd_tp);
       /// <summary>
       /// 医嘱模板项目显示（门诊医嘱助手改造 20170510）
       /// </summary>
       /// <param name="id_ortmpl"></param>
       /// <returns></returns>
       FMap getNewOrderTemplateDTO2(String[] id_ortmpl, CiEnContextDTO ctx);
        /// <summary>
        /// 判断服务是否可开立
        /// </summary>
        /// <param name="ordSrvChangedInfoDTOs"></param>
        /// <param name="code_entp">就诊类型</param>
        /// <returns>不可开立的服务集合（Key:"Id_srv,Id_mm",Value:服务不可开立原因提示String）</returns>
       FMap2 JudgeOrdChangedSrv(OrdSrvChangedInfoDTO[] ordSrvChangedInfoDTOs, String code_entp);
       /// <summary>
       /// 判断服务是否可开立
       /// </summary>
       /// <param name="code_entp">就诊类型</param>
       /// <param name="medSrvDOs">待判断服务对象数组</param>
       /// <returns>不可开立的服务集合（Key:"Id_srv,Id_mm",Value:服务不可开立原因提示String）</returns>
       FMap2 JudgeOrdChangedSrv1(String code_entp, MedSrvDO[] medSrvDOs);
       /// <summary>
       /// 查询模板项目（已添加缓存）
       /// </summary>
       /// <param name="id_ortmpl"></param>
       /// <param name="ctx"></param>
       /// <returns></returns>
       OrderTemplateRstDTO getOrTemplateCache(String[] id_ortmpl, CiEnContextDTO ctx);   
	     /// <summary>
       /// 助手医嘱开立限制设置
       /// </summary>
       /// <returns></returns>
        int getOrHelperOpenOrCountLimitSet();

        /// <summary>
        /// 医保共享查询本院数据
        /// </summary>
        /// <param name="id_pat"></param>
        /// <param name="id_hp"></param>
        /// <returns></returns>
        MedicalSharingDTO[] getMedicalSharing(String id_pat, String id_hp);
        /// <summary>
        /// 签署时 验证医保功能
        /// </summary>
        /// <param name="id_or"></param>
        /// <param name="id_pat"></param>
        /// <param name="id_hp"></param>
        /// <returns></returns>
        MedicalSharingDTO[] getOPenCiOrder(String[] id_or,String id_pat,String id_hp);
        /// <summary>
        /// 
        /// </summary>
        /// <param name="id_ors"></param>
        /// <returns></returns>
        FMap2 getMMName(String[] id_ors);
        /// <summary>
        /// 获得末次病程
        /// </summary>
        /// <param name="idEnt"></param>
        /// <returns></returns>
       FMap2 getCiMrCourseOfLastDisease(String idEnt,FBoolean firstMr);
        /// <summary>
        /// 诊断删除判断是否结算
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        String getUsedHpdiexpensese(string id_ent,string Id_didef);
        /// <summary>
        /// 判定是否医保特殊病	 
        /// </summary>
        /// <param name="idhp"></param>
        /// <param name="idpat"></param>
        /// <param name="iddiDefs"></param>
        /// <returns></returns>
        FMap isPatSpecDi(String idhp, String idpat, String[] iddiDefs);

        /// <summary>
        /// 判定是否自费诊断
        /// </summary>
        /// <param name="idhp"></param>
        /// <param name="sdentp"></param>
        /// <param name="idDiDefs"></param>
        /// <returns></returns>
        FMap isSelfPaidDi(String idhp, String sdentp, String[] idDiDefs);
        /// <summary>
        /// 自费医嘱修改成医保时 调用医保适应症
        /// </summary>
        /// <param name="id_srv"></param>
        /// <param name="id_mm"></param>
        /// <param name="ciEnContextDTO"></param>
        /// <returns></returns>
        EmsOrDrug getHPIndiccation(String id_srv, String id_mm, CiEnContextDTO ciEnContextDTO);
        /// <summary>
        /// 医保医嘱的和诊断的强制关系
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="id_hp"></param>
        /// <param name="id_srvs"></param>
        /// <returns></returns>
        FMap ValidateOrderAndDiag(String id_ent, String id_hp, String[] id_srvs);
        /// <summary>
        /// 
        /// </summary>
        /// <param name="id_or"></param>
        /// <param name="ctx"></param>
        /// <returns></returns>
        MedicalSharingDTO[] getRepeatMessageOrder(String id_or, CiEnContextDTO ctx);
        /// <summary>
        /// 住院多医疗单的0  仅生成医疗单UI数据（非自动生成医嘱模式）  ,   1  后台自动生成医嘱模式
        /// </summary>
        /// <returns></returns>
        String getCiOrAssMultiEmsHandleMode();
        /// <summary>
        /// 
        /// </summary>
        /// <param name="checkparam"></param>
        /// <returns></returns>
        CheckRstDTO checkEmsBeforSave(CheckParamDTO checkparam);
    }
}


using System;
using System.Collections.Generic;
using iih.ci.ord.cior.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.dto.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.idvproperty.d;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using iih.bd.srv.ortpl.d;
using iih.ci.iih.ci.ord.ems.d;
using iih.ci.ord.ciord.d;
using iih.ci.ord.cfg.dto.validatecondition.d;

namespace iih.ci.ord_stub.i
{
    public interface ICiOrdMaintainService
    {
        //void updateOrdMpInfo(DispenseDTO[] preses);
        CiorderAggDO[] SaveEmsUIDTO(EmsUIDTO EmsUIDTO, string type);
        /// <summary>
        /// 医嘱保存
        /// </summary>
        /// <param name="ems"></param>
        /// <returns></returns>
        CiOrderDO SaveCiEmsDTO(CiEmsDTO ems, CiEnContextDTO ciEnContextDTO);
        /// <summary>
        /// 保存费用清单
        /// </summary>
        /// <param name="szSrv"></param>
        /// <returns></returns>
        CiEmsSrvDTO[] saveOrdFeeBill(CiEmsSrvDTO[] szSrv, CiEnContextDTO ctx);
        /// <summary>
        /// 更新医嘱转态
        /// </summary>
        /// <param name="id_ors"></param>
        /// <param name="dt_end"></param>
        /// <param name="sd_su_or"></param>
        /// <returns></returns>
        OrSuModRtnInfoDTO[] updateOrdStatusInfo(IdVProperty[] id_ors, FDateTime dt_end, String sd_su_or);
        /// <summary>
        /// 删除医嘱和相关信息
        /// </summary>
        /// <param name="id_orders"></param>
        bool relDeleteOrder(string[] id_orders);

        /// <summary>
        /// 医嘱签署
        /// </summary>
        /// <param name="id_ors">当前医嘱id</param>
        /// <param name="ciEnContextDTO">上下文就诊环境</param>
        /// <returns></returns>
        ValidateRtnInfoDTO ciOrderSign(String[] id_ors, CiEnContextDTO ciEnContextDTO);

        /// 签署的上次场景 FMap2 map
        /// 就诊类型
        ValidateRtnInfoDTO ciOrderSignStep1(FMap2 map, string code_entp, CiEnContextDTO ciEnContextDTO);
        /// <summary>
        /// 签署时医保的提示信息
        /// </summary>
        /// <param name="map"></param>
        /// <param name="code_entp"></param>
        /// <returns></returns>
        ValidateRtnInfoDTO CiOrderSignMedicalInsurance(FMap2 map, string code_entp);
        /// <summary>
        /// 医嘱核对
        /// </summary>
        /// <param name="id_ors"></param>
        /// <returns></returns>
        CiOrderDO[] ciOrderCheck(String[] id_ors);
        /// <summary>
        /// 医嘱停止
        /// </summary>
        /// <param name="id_ors"></param>
        /// <param name="dt_end"></param>
        /// <returns></returns>
        CiOrderDO[] ciOrderStop(string[] id_ors, FDateTime dt_end);

        /// <summary>
        /// 撤销签署
        /// </summary>
        /// <param name="ids"></param>
        /// <param name="sd_entp"></param>
        /// <returns></returns>
        CiOrderDO[] ciOrderSignBack(string[] ids, string sd_entp);

        /// <summary>
        /// 撤回
        /// </summary>
        /// <param name="id_ors"></param>
        /// <returns></returns>
        CiOrderDO[] ciOrderCancel(string[] id_ors);


        CiOrderDO[] ciOrderCancChk(string[] id_ors);


        CiOrderDO[] ciOrderStopChk(string[] id_ors);

        CiOrderDO[] CiOrderSCSCheck(String[] id_sign_ors, String[] id_canc_ors, String[] id_stop_ors);
        /// <summary>
        /// 费用补录保存
        /// </summary>
        /// <param name="id_or"></param>
        /// <param name="drug"></param>
        /// <param name="sourcein"></param>
        /// <returns></returns>
        AddFeeDTO[] CiOrderFeeSave(String id_or, AddFeeDTO[] drug, int sourcein);

        /// <summary>
        /// 费用补录删除
        /// </summary>
        /// <param name="id_or"></param>
        /// <param name="drug"></param>
        /// <param name="sourcein"></param>
        /// <returns></returns>
        void CiOrderFeeDelete(AddFeeDTO fee);
        //保存医嘱模板
        void SaveOrTplItem(SrvortplitemAggDO[] aggdos);
        /**
       * 保存会诊信息和会诊状态
       * @param aggs  会诊的记录信息
       * @param consultType  类型  0 应答，1 科室审批，2 医务审批 
       * @return
       * @throws BizException
       */
        CiorappconsultAggDO[] SaveOrAppConsultAggDO(CiorappconsultAggDO[] aggdos, String consultType);

        /// <summary>
        /// 完成会诊
        /// </summary>
        /// <param name="aggdos"></param>
        /// <returns></returns>
        CiorappconsultAggDO SaveCompleteConsultAggDO(CiorappconsultAggDO[] aggdos);

        /// <summary>
        /// 备血信息查询
        /// </summary>
        /// <param name="no_applyForm"></param>
        /// <returns></returns>
        CiordrptbttestAggDO findApbt(String no_applyForm);

        /// <summary>
        ///  备血结果保存
        /// xuxing_2017-03-03
        /// </summary>
        /// <param name="Id_rptbttest"></param>
        /// <returns></returns>
        CiordrptbttestAggDO saveApbt(CiordrptbttestAggDO aggDO, FBoolean fg_submit);

        /// <summary>
        /// 医保审核保存
        /// </summary>
        /// <param name="orsrvdos"></param>
        /// <param name="id_ors"></param>
        CiOrderDO[] saveHealthCheckReport(OrdSrvDO[] orsrvdos, string[] id_ors);
        /// <summary>
        /// 临床路径报告保存
        /// </summary>
        /// <param name="ciOrderDOs"></param>
        /// <param name="id_deletes"></param>
        void saveCporCheckReport(CiOrderDO[] ciOrderDOs, string[] id_deletes);
        /// <summary>
        /// 保存核对的患者信息
        /// </summary>
        /// <param name="checkPatInfoSrvs"></param>
        /// <param name="agentInfo"></param>
        /// <returns></returns>
        void saveCheckPatInfo(FArrayList checkPatInfoSrvs, OrSrvAgentInfoDO agentInfo);
        /// <summary>
        /// 根据费用id_srv返回费用备注
        /// </summary>
        /// <param name="idsrvs"></param>
        /// <returns></returns>
        FMap getCiOrderBlSrvDesByIdsrvs(String[] idsrvs);
        /// <summary>
        /// 根据医嘱id_or返回费用备注
        /// </summary>
        /// <param name="idors"></param>
        /// <returns></returns>
        FMap getCiOrderBlSrvDesByIdors(String[] idors);
        /// <summary>
        /// 计算医嘱的总次数
        /// </summary>
        /// <param name="id_freq"></param>
        /// <param name="use_day"></param>
        /// <returns></returns>
        int getTotalTimes(string id_freq, int use_day);
        /// <summary>
        /// 计算物品的总量
        /// </summary>
        /// <param name="code_entp"></param>
        /// <param name="fg_pres_outp"></param>
        /// <param name="times"></param>
        /// <param name="id_mm"></param>
        /// <param name="id_unit_sale"></param>
        /// <param name="quan_medu"></param>
        /// <returns></returns>
        double? getMMQuantum(string code_entp, bool fg_pres_outp, int times, string id_mm, string id_unit_sale, FDouble quan_medu);
        /// <summary>
        /// 重新分方
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="sd_entp"></param>
        /// <returns></returns>
        CiOrderDO[] CiOPAgainPres(String id_en, String id_dep_sign, String sd_entp, CiEnContextDTO ciEnContextDTO);


        /**
      * 医生站记账
      * @param id_ent
      * @param code_entp
      * @param accountType  记账类型
      * @param id_psndoc  当前操作人
      
      *  @DmEnumDesc(name="预交金记账",description="预交金记账")
         public static final String CG_PREPAY="1"; //预交金记账
         @DmEnumDesc(name="高端商保记账",description="高端商保记账")
         public static final String CG_HPCG="2"; //高端商保记账

      * @return
      * @throws BizException
      */
        string OrderKeepAccounts(String id_ent, String code_entp, String accountType, string id_psndoc);

        /**
         * 医生站预交金账户销账
         * @param id_ent
         * @param code_entp
         * @param accountType  记账类型
         *  @DmEnumDesc(name="预交金记账",description="预交金记账")
            public static final String CG_PREPAY="1"; //预交金记账
            @DmEnumDesc(name="高端商保记账",description="高端商保记账")
            public static final String CG_HPCG="2"; //高端商保记账

         * @return
         * @throws BizException
         */
        string CancelOrderAccounting(String id_ent, String code_entp, string id_psndoc);

        /// <summary>
        /// 高端商保删除
        /// </summary>
        /// <param name="idOrs"></param>
        /// <param name="id_psndoc"></param>
        /// <param name="ciEnContextDTO"></param>
        /// <returns></returns>
        String setOrderRefundBillCancelReserve(String[] idOrs, String id_psndoc, CiEnContextDTO ciEnContextDTO);


        /// <summary>
        /// 基础数据校验
        /// </summary>
        /// <param name="args"></param>
        /// <returns></returns>
        FArrayList checkBdSrvInfo(MedSrvValidateConditionDTO args);
        /// <summary>
        /// 刷新结果
        /// </summary>
        /// <param name="args"></param>
        /// <returns></returns>
        String refreshCheckBdSrvInfo(MedSrvValidateConditionDTO args);
        /// <summary>
        /// 生命体征预置数据导入
        /// </summary>
        /// <param name="vt"></param>
        bool importVt(ImplVtDTO vt);
        /// <summary>
        /// 药品领量天数计算，只有药品非草药类才需要计算
        /// </summary>
        /// <param name="sd_mupakgu">取整模式</param>
        /// <param name="quan_cur">总量</param>
        /// <param name="quan_medu">剂量</param>
        /// <param name="id_freq">频次</param>
        /// <returns></returns>
        int? getDaysAvalidate(string sd_mupakgu, FDouble quan_cur, FDouble quan_medu,FDouble factor,FDouble factor_mb, String id_freq);
        /// <summary>
        /// 保存时提示信息 再次保存 TODO 
        /// </summary>
        /// <param name="emstype"></param>
        /// <param name="ciEnContextDTO"></param>
        /// <returns></returns>
        CiOrderDO AgainSaveOrder(String emstype, CiEnContextDTO ciEnContextDTO);
        /// <summary>
        /// 医嘱保存
        /// </summary>
        /// <param name="ciEmsDTO"></param>
        /// <param name="CiEnContext"></param>
        /// <returns></returns>
        CiOrderTransMissionDTO SaveCiEmsDTONew(CiEmsDTO ciEmsDTO, CiEnContextDTO CiEnContext);
    
    }
}

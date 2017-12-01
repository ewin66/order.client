using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.cior.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.dto.d;
using iih.ci.ord.dto.ordpres.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.idvproperty.d;
using iih.ci.ord_stub.i;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using iih.bd.srv.ortpl.d;
using iih.ci.iih.ci.ord.ems.d;
using iih.ci.ord.ciord.d;
using iih.ci.ord.cfg.dto.validatecondition.d;

namespace iih.ci.ord_stub.i
{
    class ICiOrdMaintainServiceImpl : ICiOrdMaintainService
    {
        private string url_r = XapSvrConfig.BaseUrl + "xap.ci.ord/iih.ci.ord.i.ICiOrdMaintainService";
        private ServiceInvocation si;
        private CacheHelper<CiorderAggDO> ch;
        /// <summary>
        /// 构造函数
        /// </summary>
        public ICiOrdMaintainServiceImpl()
        {
            ch = new CacheHelper<CiorderAggDO>();
            si = new ServiceInvocationImpl();
            si.url = url_r;
        }



        public CiorderAggDO[] SaveEmsUIDTO(EmsUIDTO EmsUIDTO, string type)
        {
            object[] param = new object[] { EmsUIDTO, type };
            si.url = url_r;
            CiorderAggDO[] rtn = si.invokeList<CiorderAggDO>("SaveEmsUIDTO", param.ToArray());
            return rtn;

        }

        /// <summary>
        /// 保存费用清单
        /// </summary>
        /// <param name="szSrv"></param>
        /// <returns></returns>
        public CiEmsSrvDTO[] saveOrdFeeBill(CiEmsSrvDTO[] szSrv, CiEnContextDTO ctx)
        {
            List<object> param = new List<object>();
            param.Add(szSrv);
            param.Add(ctx);
            si.url = url_r;
            return si.invokeList<CiEmsSrvDTO>("saveOrdFeeBill", param.ToArray());
        }

        public CiOrderDO SaveCiEmsDTO(CiEmsDTO ems, CiEnContextDTO ciEnContextDTO)
        {
            object[] param = new object[] { ems, ciEnContextDTO };
            si.url = url_r;
            CiOrderDO rtn = si.invoke<CiOrderDO>("SaveCiEmsDTO", param.ToArray());
            return rtn;
        }

        public OrSuModRtnInfoDTO[] updateOrdStatusInfo(IdVProperty[] id_ors, FDateTime dt_end, String sd_su_or)
        {

            object[] param = new object[] { id_ors, dt_end, sd_su_or };
            si.url = url_r;
            OrSuModRtnInfoDTO[] rtn = si.invokeList<OrSuModRtnInfoDTO>("updateOrdStatusInfo", param);
            return rtn;
        }

        public bool relDeleteOrder(string[] id_orders)
        {
            object[] param = new object[] { id_orders };
            si.url = url_r;
            bool rtn = si.invoke<bool>("relDeleteOrder", param);
            return rtn;

        }

        public ValidateRtnInfoDTO ciOrderSign(string[] id_ors, CiEnContextDTO ciEnContextDTO)
        {
            object[] param = new object[] { id_ors, ciEnContextDTO };
            si.url = url_r;
            ValidateRtnInfoDTO rtn = si.invoke<ValidateRtnInfoDTO>("ciOrderSign", param);
            return rtn;
        }



        public ValidateRtnInfoDTO ciOrderSignStep1(FMap2 map, string code_entp, CiEnContextDTO ciEnContextDTO)
        {
            //throw new NotImplementedException();
            object[] param = new object[] { map, code_entp,ciEnContextDTO };
            si.url = url_r;
            ValidateRtnInfoDTO rtn = si.invoke<ValidateRtnInfoDTO>("ciOrderSignStep1", param);
            return rtn;
        }

        /// <summary>
        /// 签署时医保的提示信息
        /// </summary>
        /// <param name="map"></param>
        /// <param name="code_entp"></param>
        /// <returns></returns>
        public ValidateRtnInfoDTO CiOrderSignMedicalInsurance(FMap2 map, string code_entp)
        {
            object[] param = new object[] { map, code_entp };
            si.url = url_r;
            ValidateRtnInfoDTO rtn = si.invoke<ValidateRtnInfoDTO>("CiOrderSignMedicalInsurance", param);
            return rtn;
        }

        public CiOrderDO[] ciOrderCheck(String[] id_ors)
        {
            object[] param = new object[] { id_ors };
            si.url = url_r;
            CiOrderDO[] rtn = si.invokeList<CiOrderDO>("ciOrderCheck", param);
            return rtn;
        }

        public CiOrderDO[] ciOrderStop(string[] id_ors, FDateTime dt_end)
        {
            object[] param = new object[] { id_ors, dt_end };
            si.url = url_r;
            CiOrderDO[] rtn = si.invokeList<CiOrderDO>("ciOrderStop", param);
            return rtn;
        }

        public CiOrderDO[] ciOrderSignBack(string[] ids, string sd_entp)
        {
            object[] param = new object[] { ids, sd_entp };
            si.url = url_r;
            CiOrderDO[] rtn = si.invokeList<CiOrderDO>("ciOrderSignBack", param);
            return rtn;
        }

        public CiOrderDO[] ciOrderCancel(string[] id_ors)
        {
            object[] param = new object[] { id_ors };
            si.url = url_r;
            CiOrderDO[] rtn = si.invokeList<CiOrderDO>("ciOrderCheck", param);
            return rtn;
        }

        public CiOrderDO[] ciOrderCancChk(string[] id_ors)
        {
            object[] param = new object[] { id_ors };
            si.url = url_r;
            CiOrderDO[] rtn = si.invokeList<CiOrderDO>("ciOrderCheck", param);
            return rtn;
        }

        public CiOrderDO[] ciOrderStopChk(string[] id_ors)
        {
            object[] param = new object[] { id_ors };
            si.url = url_r;
            CiOrderDO[] rtn = si.invokeList<CiOrderDO>("ciOrderCheck", param);
            return rtn;
        }

        public CiOrderDO[] CiOrderSCSCheck(String[] id_sign_ors, String[] id_canc_ors, String[] id_stop_ors)
        {
            object[] param = new object[] { id_sign_ors, id_canc_ors, id_stop_ors };
            si.url = url_r;
            CiOrderDO[] rtn = si.invokeList<CiOrderDO>("CiOrderSCSCheck", param);
            return rtn;
        }
        /// <summary>
        ///  医嘱确认 费用补录 保存
        /// </summary>
        /// <param name="id_or"></param>
        /// <param name="drug"></param>
        /// <param name="sourcein"></param>
        /// <returns></returns>
        public AddFeeDTO[] CiOrderFeeSave(String id_or, AddFeeDTO[] drug, int sourcein)
        {
            object[] param = new object[] { id_or, drug, sourcein };
            si.url = url_r;
            AddFeeDTO[] rtn = si.invokeList<AddFeeDTO>("CiOrderFeeSave", param);
            return rtn;
        }

        public void CiOrderFeeDelete(AddFeeDTO fee)
        {
            List<object> param = new List<object>();
            param.Add(fee);
            si.url = url_r;
            si.invokeList<AddFeeDTO>("CiOrderFeeDelete", param.ToArray());
        }

        public void SaveOrTplItem(SrvortplitemAggDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url_r;
            si.invokeList<EmsOrDrug>("SaveOrTplItem", param.ToArray());
        }

        /**
     * 保存会诊信息和会诊状态
     * @param aggs  会诊的记录信息
     * @param consultType  类型  0 应答，1 科室审批，2 医务审批 
     * @return
     * @throws BizException
     */

        public CiorappconsultAggDO[] SaveOrAppConsultAggDO(CiorappconsultAggDO[] aggdos, String consultType)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            param.Add(consultType);
            si.url = url_r;
            CiorappconsultAggDO[] rnt = si.invokeList<CiorappconsultAggDO>("SaveOrAppConsultAggDO", param.ToArray());
            return rnt;
        }
        /// <summary>
        /// 完成会诊
        /// </summary>
        /// <param name="aggdos"></param>
        /// <returns></returns>
        public CiorappconsultAggDO SaveCompleteConsultAggDO(CiorappconsultAggDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url_r;
            CiorappconsultAggDO rnt = si.invoke<CiorappconsultAggDO>("SaveCompleteConsultAggDO", param.ToArray());
            return rnt;
        }

        /// <summary>
        /// 备血信息查询
        /// </summary>
        /// <param name="no_applyForm"></param>
        /// <returns></returns>
        public CiordrptbttestAggDO findApbt(String no_applyForm)
        {
            List<object> param = new List<object>();
            param.Add(no_applyForm);
            si.url = url_r;
            CiordrptbttestAggDO rnt = si.invoke<CiordrptbttestAggDO>("findApbt", param.ToArray());
            return rnt;
        }

        /// <summary>
        ///  更新备血余量
        /// </summary>
        /// <param name="Id_rptbttest"></param>
        /// <returns></returns>
        public CiordrptbttestAggDO saveApbt(CiordrptbttestAggDO aggDO, FBoolean fg_submit)
        {
            List<object> param = new List<object>();
            param.Add(aggDO);
            param.Add(fg_submit);
            si.url = url_r;
            CiordrptbttestAggDO rnt = si.invoke<CiordrptbttestAggDO>("saveApbt", param.ToArray());
            return rnt;
        }
        /// <summary>
        /// 
        /// </summary>
        /// <param name="orsrvdos"></param>
        /// <param name="id_ors"></param>
        public CiOrderDO[] saveHealthCheckReport(OrdSrvDO[] orsrvdos, string[] id_ors)
        {
            List<object> param = new List<object>();
            param.Add(orsrvdos);
            param.Add(id_ors);
            si.url = url_r;
            return si.invokeList<CiOrderDO>("saveHealthCheckReport", param.ToArray());
        }
        /// <summary>
        /// 临床路径报告保存
        /// </summary>
        /// <param name="ciOrderDOs"></param>
        /// <param name="id_deletes"></param>
        public void saveCporCheckReport(CiOrderDO[] ciOrderDOs, string[] id_deletes)
        {
            List<object> param = new List<object>();
            param.Add(ciOrderDOs);
            param.Add(id_deletes);
            si.url = url_r;
            si.invokeList<CiOrderDO>("saveCporCheckReport", param.ToArray());
        }

        public void saveCheckPatInfo(FArrayList checkPatInfoSrvs, OrSrvAgentInfoDO agentInfo)
        {
            List<object> param = new List<object>();
            param.Add(checkPatInfoSrvs);
            param.Add(agentInfo);
            si.url = url_r;
            si.invoke<string>("saveCheckPatInfo", param.ToArray());
        }

        /// <summary>
        /// 计算医嘱的总次数
        /// </summary>
        /// <param name="id_freq"></param>
        /// <param name="use_day"></param>
        /// <returns></returns>
        public int getTotalTimes(string id_freq, int use_day)
        {
            List<object> param = new List<object>();
            param.Add(id_freq);
            param.Add(use_day);
            si.url = url_r;
            return si.invoke<int>("getTotalTimes", param.ToArray());
        }
        /// <summary>
        /// 计算物品的总量
        /// </summary>
        /// <param name="code_entp"></param>
        /// <param name="fg_pres_outp">默认为false</param>
        /// <param name="times"></param>
        /// <param name="id_mm"></param>
        /// <param name="id_unit_sale"></param>
        /// <param name="quan_medu"></param>
        /// <returns></returns>
        public double? getMMQuantum(string code_entp, bool fg_pres_outp, int times, string id_mm, string id_unit_sale, FDouble quan_medu)
        {
            List<object> param = new List<object>();
            param.Add(code_entp);
            param.Add(fg_pres_outp);
            param.Add(times);
            param.Add(id_mm);
            param.Add(id_unit_sale);
            param.Add(quan_medu);
            si.url = url_r;
            return si.invoke<int?>("getMMQuantum", param.ToArray());
        }


        public FMap getCiOrderBlSrvDesByIdsrvs(string[] idsrvs)
        {
            List<object> param = new List<object>();
            param.Add(idsrvs);
            si.url = url_r;
            return si.invoke<FMap>("getCiOrderBlSrvDesByIdsrvs", param.ToArray());
        }

        public FMap getCiOrderBlSrvDesByIdors(string[] idors)
        {
            List<object> param = new List<object>();
            param.Add(idors);
            si.url = url_r;
            return si.invoke<FMap>("getCiOrderBlSrvDesByIdors", param.ToArray());
        }
        /// <summary>
        /// 重新分方
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="sd_entp"></param>
        /// <returns></returns>
        public CiOrderDO[] CiOPAgainPres(String id_en, String id_dep_sign, String sd_entp, CiEnContextDTO ciEnContextDTO)
        {
            List<object> param = new List<object>();
            param.Add(id_en);
            param.Add(id_dep_sign);
            param.Add(sd_entp);
            param.Add(ciEnContextDTO);
            si.url = url_r;
            return si.invokeList<CiOrderDO>("CiOPAgainPres", param.ToArray());
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
        /// 
        /// <returns>记账结果</returns>
        public string OrderKeepAccounts(String id_ent, String code_entp, String accountType, string id_psndoc)
        {
            List<object> param = new List<object>();
            param.Add(id_ent);
            param.Add(code_entp);
            param.Add(accountType);
            param.Add(id_psndoc);
            si.url = url_r;
            return si.invoke<string>("orderKeepAccounts", param.ToArray());
        }

        /**
         * 医生站预交金账户销账
         * @param id_ent
         * @param code_entp
         * @param id_psndoc 当前登录人
         * @param accountType  记账类型
         *  @DmEnumDesc(name="预交金记账",description="预交金记账")
            public static final String CG_PREPAY="1"; //预交金记账
            @DmEnumDesc(name="高端商保记账",description="高端商保记账")
            public static final String CG_HPCG="2"; //高端商保记账

         * @return
         * @throws BizException
         */
        public string CancelOrderAccounting(String id_ent, String code_entp, string id_psndoc)
        {
            List<object> param = new List<object>();
            param.Add(id_ent);
            param.Add(code_entp);
            param.Add(id_psndoc);
            si.url = url_r;
            return si.invoke<string>("cancelOrderAccounting", param.ToArray());

        }

        /// <summary>
        /// 高端商保删除
        /// </summary>
        /// <param name="idOrs"></param>
        /// <param name="id_psndoc"></param>
        /// <param name="ciEnContextDTO"></param>
        /// <returns></returns>
        public String setOrderRefundBillCancelReserve(String[] idOrs, String id_psndoc, CiEnContextDTO ciEnContextDTO)
        {
            object[] param = new object[] { idOrs, id_psndoc, ciEnContextDTO };
            si.url = url_r;
            String str = si.invoke<String>("setOrderRefundBillCancelReserve", param.ToArray());
            return str;
        }


        public FArrayList checkBdSrvInfo(MedSrvValidateConditionDTO args)
        {
            object[] param = new object[] { args };
            si.url = url_r;
            FArrayList rst = si.invoke<FArrayList>("checkBdSrvInfo", param.ToArray());
            return rst;
        }
        public String refreshCheckBdSrvInfo(MedSrvValidateConditionDTO args)
        {
            object[] param = new object[] { args };
            si.url = url_r;
            String rst = si.invoke<String>("refreshCheckBdSrvInfo", param.ToArray());
            return rst;
        }
        /// <summary>
        /// 生命体征基础数据导入
        /// </summary>
        /// <param name="vt"></param>
        /// <returns></returns>
        public bool importVt(ImplVtDTO vt)
        {
            object[] param = new object[] { vt};
            si.url = url_r;
            bool flag = si.invoke<bool>("importVt", param.ToArray());
            return flag;
        }
        /// <summary>
        /// 药品领量天数计算，只有药品非草药类才需要计算
        /// </summary>
        /// <param name="sd_mupakgu">取整模式</param>
        /// <param name="quan_cur">总量</param>
        /// <param name="quan_medu">剂量</param>
        /// <param name="id_freq">频次</param>
        /// <returns></returns>
        public int? getDaysAvalidate(string sd_mupakgu, FDouble quan_cur, FDouble quan_medu, FDouble factor, FDouble factor_mb, String id_freq)
        {
            object[] param = new object[] { sd_mupakgu,quan_cur, quan_medu, factor, factor_mb, id_freq };
            si.url = url_r;
            int? days = si.invoke<int?>("getDaysAvalidate", param.ToArray());
            return days;
        }


        /// <summary>
        /// 保存时提示信息 再次保存 TODO 
        /// </summary>
        /// <param name="emstype"></param>
        /// <param name="ciEnContextDTO"></param>
        /// <returns></returns>
        public  CiOrderDO  AgainSaveOrder(String emstype, CiEnContextDTO ciEnContextDTO)
        {
            object[] param = new object[] { emstype, ciEnContextDTO };
            si.url = url_r;
            CiorderAggDO  rtn = si.invoke<CiorderAggDO>("AgainSaveOrder", param.ToArray());
            if( rtn != null ){
                return rtn.getParentDO();
            }
            return null;
        }


        /// <summary>
        /// 医嘱保存
        /// </summary>
        /// <param name="ciEmsDTO"></param>
        /// <param name="CiEnContext"></param>
        /// <returns></returns>
        public CiOrderTransMissionDTO SaveCiEmsDTONew(CiEmsDTO ciEmsDTO, CiEnContextDTO CiEnContext)
        {
            object[] param = new object[] { ciEmsDTO, CiEnContext };
            si.url = url_r;
            CiOrderTransMissionDTO rtn = si.invoke<CiOrderTransMissionDTO>("SaveCiEmsDTONew", param.ToArray());
            return rtn;
        }
    }


}

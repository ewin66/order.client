
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bl.hp.bdhpindicationdto.d;
using iih.bd.bc.udi;
using iih.bd.iih.bd.bc.udi;
using iih.en.pv.dto.d;
using iih.ci.ord.ems.d;
using xap.mw.serviceframework;
using iih.ci.ord.i;
using iih.ci.iih.ci.ord.dto.hp;
using iih.ci.ord.common.utils;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.ciorder.d;

namespace iih.ci.ord.ciorder.utils
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.utils    </para>    
    /// <para>类 名 称 :  HpJudgeUtil					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/12/1 17:03:50             </para>
    /// <para>更新时间 :  2016/12/1 17:03:50             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class HpJudgeUtil
    {
        private static HpJudgeUtil hpJudgeUtil =null;
        public static HpJudgeUtil getInstance() {
            if (hpJudgeUtil == null) {
                hpJudgeUtil = new HpJudgeUtil();
            }
            return hpJudgeUtil;
        }
        private HpJudgeUtil() { }
        /// <summary>
        /// 判断自费标识(保内、保外)
        /// </summary>
        /// <param name="hpdto"></param>
        /// <returns></returns>
        public bool? isSelfPay(BdHpIndicationDTO hpdto) {
            if (hpdto == null)
            {
                return true;
            }
            string sd_hpsrvtp = hpdto.Sd_hpsrvtp;//医保类型
            string code_hpindicjudged = hpdto.Code_hpindicjudged;//判断方式
            //丙类 
            if (string.IsNullOrEmpty(sd_hpsrvtp) || sd_hpsrvtp.Equals(HpDicCodeConst.SD_HPSRVTP_CLASS_C))
            {
                return true;
            }
            else
            {
                if (string.IsNullOrEmpty(code_hpindicjudged))
                {
                    return true;
                }
                else if (code_hpindicjudged.Equals(HpDicCodeConst.SD_HP_JUDGE_METHOD_NO_CONTROL))
                { //不控制
                    return false;
                }
                else if (code_hpindicjudged.Equals(HpDicCodeConst.SD_HP_JUDGE_METHOD_SYS_CONFIRM))
                {
                    if (hpdto.Fg_indic != null && (bool)hpdto.Fg_indic)
                    {
                        return false;
                    }
                    else
                    {
                        return true;
                    }
                }
                else if (code_hpindicjudged.Equals(HpDicCodeConst.SD_HP_JUDGE_METHOD_SYS_JUD_DOCCONFIRM))
                {
                    return true;//默认为自费
                }
                else if (code_hpindicjudged.Equals(HpDicCodeConst.SD_HP_JUDGE_METHOD_DOC_CONFIRM))
                {
                    return true;//默认为自费
                }
            }
            return true;
        }
        /// <summary>
        /// 判断控件是否能编辑
        /// </summary>
        /// <param name="hpdto"></param>
        /// <returns></returns>
        public bool isCanEdit(BdHpIndicationDTO hpdto)
        {
            if (hpdto == null)
            {
                return false;
            }
            string sd_hpsrvtp = hpdto.Sd_hpsrvtp;//医保类型
            //丙类 
            if (string.IsNullOrEmpty(sd_hpsrvtp) || sd_hpsrvtp.Equals(HpDicCodeConst.SD_HPSRVTP_CLASS_C))
            {
                return false;
            }
            string code_hpindicjudged = hpdto.Code_hpindicjudged;//判断方式
            if (string.IsNullOrEmpty(code_hpindicjudged))
            {
                return false;
            }
            else if (code_hpindicjudged.Equals(HpDicCodeConst.SD_HP_JUDGE_METHOD_NO_CONTROL))
            { //不控制
                return false;
            }
            else if (code_hpindicjudged.Equals(HpDicCodeConst.SD_HP_JUDGE_METHOD_SYS_CONFIRM))
            {
                return false;
            }
            else if (code_hpindicjudged.Equals(HpDicCodeConst.SD_HP_JUDGE_METHOD_SYS_JUD_DOCCONFIRM))
            {
                return true;
            }
            else if (code_hpindicjudged.Equals(HpDicCodeConst.SD_HP_JUDGE_METHOD_SYS_JUD_DOCCONFIRM))
            {
                return true;
            }
            return true;
        }
        /// <summary>
        /// 查询医保规则
        /// </summary>
        /// <param name="id_srv"></param>
        /// <param name="id_mm"></param>
        /// <param name="patinfo"></param>
        /// <returns></returns>
        public BdHpIndicationDTO getBdHpIndicationDTO(string id_srv, string id_mm, Ent4BannerDTO patinfo)
        {
            if (string.IsNullOrEmpty(id_srv) || patinfo == null || string.IsNullOrEmpty(patinfo.Id_hp) || true != patinfo.Fg_hpfundpay) {
                return null;
            }
            CiEnContextDTO contextdto = CiEnContextUtil.GetCiEnContext(patinfo);
            ICiOrdQryService service = XapServiceMgr.find<ICiOrdQryService>();
            BdHpIndicDTO bdhpindic = service.getBdHpIndicationDTO(id_srv, id_mm, contextdto);
            if (bdhpindic != null)
            {
                BdHpIndicationDTO bdHpIndication = new BdHpIndicationDTO();
                LogicEx.GetInstance().CopyTo(bdhpindic, bdHpIndication);
                return bdHpIndication;
            }
            else {
                return null;
            }
        }
        /// <summary>
        /// 查询医保规则
        /// </summary>
        /// <param name="id_srv"></param>
        /// <param name="id_mm"></param>
        /// <param name="patinfo"></param>
        /// <returns></returns>
        public BdHpIndicationDTO[] getBdHpIndicationDTO(string[] id_srvs, string[] id_mms, Ent4BannerDTO patinfo)
        {
            if (id_srvs==null || patinfo == null || string.IsNullOrEmpty(patinfo.Id_hp) || true != patinfo.Fg_hpfundpay)
            {
                return null;
            }
            CiEnContextDTO contextdto = CiEnContextUtil.GetCiEnContext(patinfo);
            ICiOrdQryService service = XapServiceMgr.find<ICiOrdQryService>();
            BdHpIndicDTO[] bdhpindic = service.getBdHpIndicationDTOs(id_srvs, id_mms, contextdto);
            if (bdhpindic != null)
            {
                BdHpIndicationDTO[] bdHpIndications = new BdHpIndicationDTO[bdhpindic.Length];
                for (int i = 0; i < bdhpindic.Length; i++) {
                    BdHpIndicationDTO bdHpIndication = new BdHpIndicationDTO();
                    LogicEx.GetInstance().CopyTo(bdhpindic[i], bdHpIndication);
                    bdHpIndications[i] = bdHpIndication;
                }
                return bdHpIndications;
            }
            else
            {
                return null;
            }
        }
        /// <summary>
        /// 根据医保适应症细则DTO，获得医生是否已经判断过标识,0 不需要判断，1已判断，2待判断
        /// </summary>
        /// <param name="hpdto"></param>
        /// <returns></returns>
        public int? getFg_hpindicjudged(BdHpIndicationDTO hpdto)
        {
            if (hpdto == null)
            {
                return null;
            }
            string sd_hpsrvtp = hpdto.Sd_hpsrvtp;//医保类型
            //丙类 
            if (string.IsNullOrEmpty(sd_hpsrvtp) || sd_hpsrvtp.Equals(HpDicCodeConst.SD_HPSRVTP_CLASS_C))
            {
                return (int)HpIndicJudgeEnum.NONEEDJUDGE;//0不需要判断，1待判断，2已判断;
            }
            string code_hpindicjudged = hpdto.Code_hpindicjudged;//判断方式
            if (string.IsNullOrEmpty(code_hpindicjudged))
            {
                return (int)HpIndicJudgeEnum.NONEEDJUDGE;//0不需要判断，1待判断，2已判断;
            }
            else if (code_hpindicjudged.Equals(HpDicCodeConst.SD_HP_JUDGE_METHOD_NO_CONTROL))
            { //不控制
                return (int)HpIndicJudgeEnum.NONEEDJUDGE;//0不需要判断，1待判断，2已判断;
            }
            else if (code_hpindicjudged.Equals(HpDicCodeConst.SD_HP_JUDGE_METHOD_SYS_CONFIRM))
            {
                return (int)HpIndicJudgeEnum.NONEEDJUDGE;//0不需要判断，1待判断，2已判断;
            }
            else if (code_hpindicjudged.Equals(HpDicCodeConst.SD_HP_JUDGE_METHOD_SYS_JUD_DOCCONFIRM))
            {
                return (int)HpIndicJudgeEnum.WAITINGJUDGE;//0不需要判断，1待判断，2已判断;
            }
            else if (code_hpindicjudged.Equals(HpDicCodeConst.SD_HP_JUDGE_METHOD_SYS_JUD_DOCCONFIRM))
            {
                return (int)HpIndicJudgeEnum.WAITINGJUDGE;//0不需要判断，1待判断，2已判断;
            }
            return (int)HpIndicJudgeEnum.WAITINGJUDGE;//0不需要判断，1待判断，2已判断;
        }
        /// <summary>
        /// 费用页签加载时，判断适应症和自费标识
        /// </summary>
        /// <param name="drug"></param>
        /// <param name="ordDrug"></param>
        /// <returns></returns>
        public static EmsOrDrug HandleEmsOrDrugHPInfo(EmsOrDrug drug)
        {
            //非医保或者保外诊断时
            CiEnContextDTO ciEnContextDTO = BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO;
            bool isHpEnable = false;
            //是否启用医保标志
            if (BaseEmsView.BaseEmsInfoContext.ContainsKey("isMedicalInsuranceEnable"))
            {
                isHpEnable = (bool)BaseEmsView.BaseEmsInfoContext["isMedicalInsuranceEnable"];
            }
            int opMedInsuranceAuditHandel = 99;
            if (BaseEmsView.BaseEmsInfoContext.ContainsKey("opMedInsuranceAuditHandel"))
            {
                opMedInsuranceAuditHandel = (int)BaseEmsView.BaseEmsInfoContext["opMedInsuranceAuditHandel"];
            }

            if (!string.IsNullOrEmpty(ciEnContextDTO.Id_hp)
                && true == ciEnContextDTO.Fg_hpfundpay && HpBeyondEnum.HPDIAG.Equals(ciEnContextDTO.Eu_hpbeyond)/*保内诊断*/ && isHpEnable && opMedInsuranceAuditHandel == 0)
            {

            }
            else
            {
                drug.Fg_selfpay = true;//自费
                drug.Fg_treat = false;//非医保适应症
            }
            return drug;
        }
        /// <summary>
        /// 费用页签加载时，判断适应症和自费标识
        /// </summary>
        /// <param name="drug"></param>
        /// <param name="ordDrug"></param>
        /// <returns></returns>
        public static CiEmsSrvDTO HandleCiEmsSrvDTOHPInfo(CiEmsSrvDTO ciemssrvdto)
        {
            //非医保或者保外诊断时
            CiEnContextDTO ciEnContextDTO = BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO;
            bool isHpEnable = false;
            //是否启用医保标志
            if (BaseEmsView.BaseEmsInfoContext.ContainsKey("isMedicalInsuranceEnable"))
            {
                isHpEnable = (bool)BaseEmsView.BaseEmsInfoContext["isMedicalInsuranceEnable"];
            }
            int opMedInsuranceAuditHandel = 99;
            if (BaseEmsView.BaseEmsInfoContext.ContainsKey("opMedInsuranceAuditHandel"))
            {
                opMedInsuranceAuditHandel = (int)BaseEmsView.BaseEmsInfoContext["opMedInsuranceAuditHandel"];
            }

            if (!string.IsNullOrEmpty(ciEnContextDTO.Id_hp)
                && true == ciEnContextDTO.Fg_hpfundpay && HpBeyondEnum.HPDIAG.Equals(ciEnContextDTO.Eu_hpbeyond)/*保内诊断*/ && isHpEnable && opMedInsuranceAuditHandel == 0)
            {

            }
            else
            {
                ciemssrvdto.Fg_selfpay = true;//自费
                ciemssrvdto.Fg_treat = false;//非医保适应症
            }
            return ciemssrvdto;
        }
        /**
	 * 根据医保服务类型SD获得ID
	 * @param sd_hpsrvtp
	 * @return
	 */
        public static String IdHpSrvtpFromSdHpSrvtp(String sd_hpsrvtp)
        {
            if (string.IsNullOrEmpty(sd_hpsrvtp)) return null;
            if (HpDicCodeConst.SD_HPSRVTP_CLASS_A.Equals(sd_hpsrvtp))
            {
                return HpDicCodeConst.ID_HPSRVTP_CLASS_A;
            }
            else if (HpDicCodeConst.SD_HPSRVTP_CLASS_B.Equals(sd_hpsrvtp))
            {
                return HpDicCodeConst.ID_HPSRVTP_CLASS_B;
            }
            else if (HpDicCodeConst.SD_HPSRVTP_CLASS_C.Equals(sd_hpsrvtp))
            {
                return HpDicCodeConst.ID_HPSRVTP_CLASS_C;
            }
            return null;
        }
        /**
         * 根据医保服务类型SD获得ID
         * @param sd_hpsrvtp
         * @return
         */
        public static String NameHpSrvtpFromSdHpSrvtp(String sd_hpsrvtp)
        {
            if (string.IsNullOrEmpty(sd_hpsrvtp)) return null;
            if (HpDicCodeConst.SD_HPSRVTP_CLASS_A.Equals(sd_hpsrvtp))
            {
                return HpDicCodeConst.NAME_HPSRVTP_CLASS_A;
            }
            else if (HpDicCodeConst.SD_HPSRVTP_CLASS_B.Equals(sd_hpsrvtp))
            {
                return HpDicCodeConst.NAME_HPSRVTP_CLASS_B;
            }
            else if (HpDicCodeConst.SD_HPSRVTP_CLASS_C.Equals(sd_hpsrvtp))
            {
                return HpDicCodeConst.NAME_HPSRVTP_CLASS_C;
            }
            return null;
        }
    }
}

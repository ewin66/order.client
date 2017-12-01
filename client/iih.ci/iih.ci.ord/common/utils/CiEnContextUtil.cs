
using iih.bd.srv.ems.d;
using iih.ci.diag.cidiag.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ems.d;
using iih.en.pv.dto.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.coreitf.d;
using xap.rui.engine;
using iih.ci.diag_stub.i;
using xap.mw.serviceframework;
using iih.bd.iih.bd.pp.primd.i;
using xap.mw.core.data;

namespace iih.ci.ord.common.utils
{
    /// <summary>
    /// <para>描    述 :  通过当前banner和当前环境Context 获取就诊的环境变量DTO</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.common.utils</para>    
    /// <para>类 名 称 :  CiEnContextUtil</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/12/27 17:18:26</para>
    /// <para>更新时间 :  2016/12/27 17:18:26</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class CiEnContextUtil
    {
        /// <summary>
        /// 缓存当前就诊对象，不包含诊断
        /// </summary>
        private static Dictionary<string, CiEnContextDTO> currentCtxDic = new Dictionary<string,CiEnContextDTO>();

        /// <summary>
        /// 构造临床就诊上下文信息
        /// </summary>
        /// <param name="ent4BannerDTO">当前患者的banner对象</param>        
        /// <param name="context">当前上下文环境</param>
        /// <returns>CiEnContextDTO 医疗单类型（Emsappmode）、医嘱数据来源（Eu_orsrcmdtp）属性需要单独设置</returns>
        public static CiEnContextDTO GetCiEnContext(Ent4BannerDTO ent4BannerDTO, BaseContext context = null)
        {

            CiEnContextDTO conetxtDTO = new CiEnContextDTO();
            // 修改缓存就诊环境的key值，context 可能为空，只使用id_en缓存不满足使用场景
            string cacheKey = ent4BannerDTO.Id_ent;
            if (context != null)
            {
                cacheKey += "context";
            }

            // 判断当前就诊患者信息是否存在，如果存在直接返回，否则重新获取患者就诊环境对象
            if (currentCtxDic.ContainsKey(cacheKey))
            {
                conetxtDTO = currentCtxDic[cacheKey];
                return conetxtDTO;
            }
            else
            {
                currentCtxDic.Clear();
            }

            conetxtDTO.Ent4BannerDTO = ent4BannerDTO;
            if (context != null)
            {
                conetxtDTO.Id_grp = context.Group.Id_grp; // 所属集团
                conetxtDTO.Id_org = context.Org.Id_org; // 所属组织
                conetxtDTO.Id_dep_or = context.Dept.Id_dep; // 开立科室
                conetxtDTO.Id_emp_or = context.PsnInfo.Id_psndoc; // 开立医生

                conetxtDTO.Group = context.Group; // 集团
                conetxtDTO.Org = context.Org; // 组织
                conetxtDTO.Dept = context.Dept; // 科室
                conetxtDTO.PsnInfo = context.PsnInfo; // 人员
                conetxtDTO.User = context.User; // 用户
            }

            //conetxtDTO.Emsappmode = (int)emsAppModeEnum; // 医疗单应用场景

            conetxtDTO.Id_entp = ent4BannerDTO.Id_entp; // 就诊类型id
            conetxtDTO.Code_entp = ent4BannerDTO.Code_entp; // 就诊类型编码
            conetxtDTO.Id_pat = ent4BannerDTO.Id_pat; // 患者
            conetxtDTO.Id_en = ent4BannerDTO.Id_ent; // 就诊
            conetxtDTO.Id_hp = ent4BannerDTO.Id_hp; // 主医保数据
            conetxtDTO.Id_dep_en = ent4BannerDTO.Id_dep_phy; // 当前就诊科室

            conetxtDTO.Id_dep_ns = ent4BannerDTO.Id_dep_nur; // 当前就诊病区

            conetxtDTO.Id_wg_or = ent4BannerDTO.Id_wg_phy; //TODO  开立医疗组 
            conetxtDTO.Fg_bb = ent4BannerDTO.Fg_newborn; // 婴儿标识
            conetxtDTO.No_bb = ent4BannerDTO.Num_newborn; // 婴儿序号
            // ent4BannerDTO.Cp_status临床路径标识，1 在径 0 不在径
            conetxtDTO.Fg_cp = ent4BannerDTO.Cp_status == "1" ? FBoolean.True : FBoolean.False; // 患者入径标识
            conetxtDTO.Fg_hpfundpay = ent4BannerDTO.Fg_hpfundpay;// 本次就诊是否为医保就诊

            if (ent4BannerDTO.Fg_hpfundpay == FBoolean.True)
            {
                // 如果本次是医保就诊
                if (ent4BannerDTO.Fg_inhpbbr == FBoolean.True)
                {
                    conetxtDTO.Eu_inhpbbr = InHpBbrEnum.BLACKLIST; // 黑名单
                }
                else
                {
                    conetxtDTO.Eu_inhpbbr = InHpBbrEnum.WHITELIST; // 白名单
                }
                // 如果本次就诊未医保就诊先将属性先设置为保内诊断，具体保内还是保外诊断，需要根据诊断的保外诊断属性判断
                conetxtDTO.Eu_hpbeyond = HpBeyondEnum.HPDIAG;
            }
            else
            {
                // 本次就诊为非医保就诊时，黑名单状态为9 ，如果医保就诊时 1 为黑名单，0 白名单
                conetxtDTO.Eu_inhpbbr = InHpBbrEnum.NONMEDICARE;
                conetxtDTO.Eu_hpbeyond = HpBeyondEnum.NONMEDICARE; // 本次就诊为非医保就诊时，保外诊断状态为9 ，如果医保就诊时 1 为保外诊断，0保内诊断

            }
            //conetxtDTO.Bhpjudgerst = ""; // 基本医保判断结果数据信息            
            // 基本医保判断结果数据信息
            conetxtDTO.Bhpjudgerst = (conetxtDTO.Fg_hpfundpay == FBoolean.True ? "1" : "0") + conetxtDTO.Eu_inhpbbr + conetxtDTO.Eu_hpbeyond;

            // 非社保就诊时获取患者默认医保，用于保存服务项目时保存默认的医保目录类型
            if (!IsHpPat(ent4BannerDTO))
            {
                //如果患者的医保计划为空或者患者是高端商保，查询默认医保计划
                IPpQueService ppQueService = XapServiceMgr.find<IPpQueService>();
                FMap hpIdMap = ppQueService.getHpIdForHpCatalog(new string[] { conetxtDTO.Id_en });
                if (hpIdMap != null && hpIdMap[conetxtDTO.Id_en] != null)
                {
                    conetxtDTO.Id_hp_default = (string)hpIdMap[conetxtDTO.Id_en];
                }
            }

            currentCtxDic.Add(cacheKey, conetxtDTO);
            return conetxtDTO;

        }

        /// <summary>
        /// 构造临床就诊上下文信息,包含保外诊断信息
        /// </summary>
        /// <param name="ent4BannerDTO">当前患者的banner对象</param>
        /// <param name="emsAppModeEnum">医疗单类型：简洁版、智慧版</param>
        /// <param name="context">当前上下文环境</param>
        /// <returns>CiEnContextDTO 不包含医嘱数据来源（Eu_orsrcmdtp）属性，需要单独设置</returns>
        public static CiEnContextDTO GetCiEnContext(Ent4BannerDTO ent4BannerDTO, EmsAppModeEnum emsAppModeEnum, BaseContext context = null)
        {
            CiEnContextDTO contextDTO = GetCiEnContext(ent4BannerDTO, context);
            contextDTO.Emsappmode = (int)emsAppModeEnum; // 医疗单应用场景
            if (contextDTO.Fg_hpfundpay == FBoolean.True)
            {
                ICidiagQryService cidiagQryService = XapServiceMgr.find<ICidiagQryService>();
                // 判断是否存在保外诊断
                CiDiagItemDO[] cidiagItems = cidiagQryService.getHpjudgetpCiDiagItems(ent4BannerDTO.Id_ent);
                CiEnContextUtil.SetHpCiDiagItem(contextDTO, cidiagItems);
            }
            return contextDTO;
        }

        /// <summary>
        /// 构造临床就诊上下文信息
        /// </summary>
        /// <param name="ent4BannerDTO">当前患者的banner对象</param>
        /// <param name="emsAppModeEnum">医疗单类型：简洁版、智慧版</param>
        /// <param name="eu_orsrcmdtp">医嘱数据来源</param>
        /// <param name="context">当前上下文环境</param>
        /// <returns>CiEnContextDTO 包含医疗单类型属性</returns>
        public static CiEnContextDTO GetCiEnContext(Ent4BannerDTO ent4BannerDTO, EmsAppModeEnum emsAppModeEnum, string eu_orsrcmdtp, BaseContext context = null)
        {
            // TODO 需要增加校验枚举类型是否在枚举对象属性中 OrSourceFromEnum

            CiEnContextDTO conetxtDTO = GetCiEnContext(ent4BannerDTO, emsAppModeEnum, context);
            conetxtDTO.Eu_orsrcmdtp = eu_orsrcmdtp; // 医疗单应用场景
            return conetxtDTO;
        }

        /// <summary>
        /// 设置环境参数的保外诊断相关属性
        /// </summary>
        /// <param name="conetxtDTO"></param>
        /// <param name="ciDiagItems"></param>
        public static void SetHpCiDiagItem(CiEnContextDTO conetxtDTO, CiDiagItemDO[] ciDiagItems)
        {            
            if (conetxtDTO.Fg_hpfundpay != FBoolean.True || ciDiagItems == null || ciDiagItems.Length == 0)
            {
                return;
            }            

            // 保外诊断集合
            StringBuilder builder = new StringBuilder();

            foreach (CiDiagItemDO ciDiagItem in ciDiagItems)
            {
                // 存在保外诊断时，将conetxtDTO保外诊断属性设置为1，并拼接保外诊断id
                if (ciDiagItem.Eu_hpbeyond == HpBeyondEnum.HPEXTERNALDIAG)
                {
                    conetxtDTO.Eu_hpbeyond = HpBeyondEnum.HPEXTERNALDIAG;
                    builder.Append("," + ciDiagItem.Id_didef);
                }
            }

            // 基本医保判断结果数据信息
            // 添加基本医保判断结果属性
            // 第一位 医保就诊为1 非医保就诊为0
            // 第二位 黑白名单： 白名单为0 黑名单为 1 非医保就诊时为9 
            // 第三位 是否为保外诊断：保外诊断 0 保内诊断 1 非医保就诊时为 9
            conetxtDTO.Bhpjudgerst = (conetxtDTO.Fg_hpfundpay == FBoolean.True ? "1" : "0") + conetxtDTO.Eu_inhpbbr + conetxtDTO.Eu_hpbeyond;
            // 设置保外诊断id_didef拼接串
            if (builder.Length > 0)
            {
                conetxtDTO.Des_bhpjudgerst = builder.Remove(0, 1).ToString();
            }

        }

        /// <summary>
        /// 判断当前患者是否为医保就诊患者
        /// </summary>
        /// <param name="ent4BannerDTO">当前患者就诊banner对象</param>
        /// <returns>true 医保就诊， false 非医保就诊</returns>
        public static bool IsHpPat(Ent4BannerDTO ent4BannerDTO)
        {

            // 有医保计划，并且医保类型为社保，并且是医保基金支付标识（持卡）才确认是社保
            if (ent4BannerDTO != null && !string.IsNullOrEmpty(ent4BannerDTO.Id_hp) &&
                !string.IsNullOrEmpty(ent4BannerDTO.Sd_hptp) && ent4BannerDTO.Sd_hptp.StartsWith("1") &&
                ent4BannerDTO.Fg_hpfundpay == FBoolean.True)
            {
                return true;
            }

            return false;
        }

        /// <summary>
        /// 是否为医保特殊病患者(医保就诊，并且特殊病标识为true)
        /// </summary>
        /// <param name="ent4BannerDTO">当前患者就诊banner对象</param>
        /// <returns></returns>
        public static bool IsHpSpecillPat(Ent4BannerDTO ent4BannerDTO)
        {
            if (IsHpPat(ent4BannerDTO) && ent4BannerDTO.Fg_hpspcl == FBoolean.True) {
                return true;
            }
            return false;
        }

        /// <summary>
        /// 商业保险用户<br>
        /// 有医保计划，并且医保类型为商业保险(Sd_hptp=20)
        /// High end commercial insurance 高端商业保险
        /// </summary>
        /// <param name="ent4BannerDTO"></param>
        /// <returns>true 高端商保 false 非高端商保</returns>
        public static bool IsHeComInsurPat(Ent4BannerDTO ent4BannerDTO)
        {

            // 有医保计划，并且医保类型为商业保险
            if (ent4BannerDTO != null && !string.IsNullOrEmpty(ent4BannerDTO.Id_hp) &&
                !string.IsNullOrEmpty(ent4BannerDTO.Sd_hptp) && ent4BannerDTO.Sd_hptp.StartsWith("2"))
            {
                return true;
            }

            return false;
        }

        /// <summary>
        /// 商保用户（可医保记账）
        /// </summary>
        /// <param name="ent4BannerDTO"></param>
        /// <returns></returns>
        public static bool IsHeComInsurAllowedAccountPat(Ent4BannerDTO ent4BannerDTO)
        {
            // 商保用户 并且 可医保记账
            if (IsHeComInsurPat(ent4BannerDTO) && ent4BannerDTO.Fg_hpcg == FBoolean.True)
            {
                return true;
            }
                       
            return false;
        }

        /// <summary>
        /// 商保用户（不允许医保记账，需要个人支付）
        /// </summary>
        /// <param name="ent4BannerDTO"></param>
        /// <returns></returns>
        public static bool IsHeComInsurRefuseAccountPat(Ent4BannerDTO ent4BannerDTO)
        {
            // 商保用户 并且 不允许医保记账
            if (IsHeComInsurPat(ent4BannerDTO) && ent4BannerDTO.Fg_hpcg != FBoolean.True)
            {
                return true;
            }

            return false;
        }
    }
}

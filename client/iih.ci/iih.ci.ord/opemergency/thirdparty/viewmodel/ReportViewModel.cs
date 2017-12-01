
using iih.bd.bc.udi;
using iih.ci.ord.opemergency.action.costant;
using iih.en.pv.dto.d;
using iih.en.pv.inpatient.d;
using iih.en.pv.inpatient.i;
using iih.en.pv.outpatient.d;
using iih.en.pv.outpatient.i;
using iih.pi.overview.overview.d;
using iih.pi.overview.overview.i;
using iih.pi.reg.pat.d;
using iih.pi.reg.pat.i;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.thirdparty.viewmodel
{
    /// <summary>
    /// <para>描    述 :  报告查看数据服务</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.thirdparty.viewmodel</para>    
    /// <para>类 名 称 :  ReportViewModel</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2017/4/7 17:22:13</para>
    /// <para>更新时间 :  2017/4/7 17:22:13</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class ReportViewModel
    {

        #region 变量定义区域

        private BaseContext context;

        /// <summary>
        /// 历次检验报告功能节点编码
        /// </summary>
        private const string LisHistoryFunCode = "46105565";

        /// <summary>
        /// 检验报告功能节点编码
        /// </summary>
        private const string LisFunCode = "46105570";

        /// <summary>
        /// 检查报告功能节点编码
        /// </summary>
        private const string RisFunCode = "46105590";

        /// <summary>
        /// 会诊功能节点编码
        /// </summary>
        private const string ConsFunCode = "46105580";

        /// <summary>
        /// 数据中心功能节点编码
        /// </summary>
        private const string DataCenterFunCode = "46105585";

        /// <summary>
        /// 患者查询服务接口
        /// </summary>        
        private IPatiMDOCrudService patiMDOCrudService;

        /// <summary>
        /// 门诊属性服务接口
        /// </summary>
        private IOutpatientCrudService outpatientCrudService;

        /// <summary>
        /// 住院属性服务接口
        /// </summary>
        private IInpatientCrudService inpatientCrudService;

        #endregion

        #region 构造函数区域

        public ReportViewModel(BaseContext context)
        {
            this.context = context;

            patiMDOCrudService = XapServiceMgr.find<IPatiMDOCrudService>();
            outpatientCrudService = XapServiceMgr.find<IOutpatientCrudService>();
            inpatientCrudService = XapServiceMgr.find<IInpatientCrudService>();
        }

        #endregion

        #region 公开属性区域

        #endregion

        #region 命令定义区域

        #endregion

        #region 事件发送区域

        #endregion

        #region 事件接收区域

        #endregion

        #region 父类继承区域

        #endregion

        #region 内部事件区域

        #endregion

        #region 辅助处理函数

        public Dictionary<String, object> GetParamDic(string uiEvent, Ent4BannerDTO ent4BannerDTO)
        {

            Dictionary<String, object> paramDic = new Dictionary<string, object>();
            if (OpActionConstant.CONS_REPORT_ACTION.Equals(uiEvent)) // 会诊
            {
                paramDic = GetConsParamDic(ent4BannerDTO);
            }
            else if (OpActionConstant.DATA_CENTER_ACTION.Equals(uiEvent)) // 数据中心
            {
                paramDic = GetCDRParamDic(ent4BannerDTO);
            }
            else if (OpActionConstant.RIS_HISTORY_REPORT_ACTION.Equals(uiEvent)) // 检查报告
            {
                paramDic = GetRisParamDic(ent4BannerDTO);
            }
            else if (OpActionConstant.LIS_HISTORY_REPORT_ACTION.Equals(uiEvent)) // 展现历次就诊检查报告
            {
                paramDic = GetLisParamDic(ent4BannerDTO);
            }

            return paramDic;
        }

        /// <summary>
        /// 获取打开会诊界面参数
        /// </summary>
        /// <param name="ent4BannerDTO"></param>
        /// <returns></returns>
        public Dictionary<String, object> GetConsParamDic(Ent4BannerDTO ent4BannerDTO)
        {

            Dictionary<String, object> paramDic = new Dictionary<string, object>();
            //paramDic.Add("funCode", ConsFunCode); // 会诊功能节点编码
            //paramDic.Add("pBarCode", "116594294"); // 门诊--条码号，患者基本信息PI_PAT .CHIS条码号barcode_chis ,住院-- 住院号，患者基本信息PI_PAT .住院病案编号code_amr_ip
            //paramDic.Add("patientId", "000145102700 "); // 患者id
            //paramDic.Add("applyDoctor", "01566"); // 登录用户对应的人员编码  
            //paramDic.Add("patientSource", "01"); // 所属域，门诊 01 ；住院 02
            //paramDic.Add("patientNumber", "9");
            //paramDic.Add("medicalAdviceId", null); // 医嘱流水号，门诊传空，住院后续处理
            //paramDic.Add("processType", null); // 医嘱编码，门诊传空，住院后续处理

            //if (paramDic != null) {
            //    return paramDic;
            //}

            // 正常代码
            paramDic.Add("funCode", ConsFunCode); // 会诊功能节点编码
           
            paramDic.Add("patientId", ent4BannerDTO.Code_pat); // 患者id
            paramDic.Add("applyDoctor", this.context.PsnInfo.Code); // 登录用户对应的人员编码            

            // 查询患者对象
            PatDO pat = patiMDOCrudService.findById(ent4BannerDTO.Id_pat);
            if (BdFcDictCodeConst.SD_CODE_ENTP_IP.Equals(ent4BannerDTO.Code_entp)) // 住院
            {
                // 就诊次数，住院 -- 患者就诊_住院属性EN_ENT_IP .住院次数times_ip
                InpatientDO inpatient = GetInpatient(ent4BannerDTO.Id_ent);// 住院属性                
                paramDic.Add("patientNumber", inpatient.Times_ip);

                paramDic.Add("pBarCode", pat.Code_amr_ip); // 住院-- 住院号，患者基本信息PI_PAT .住院病案编号code_amr_ip

                paramDic.Add("patientSource", "02"); // 所属域，门诊 01 ；住院 02
                paramDic.Add("medicalAdviceId", null); // 医嘱流水号，门诊传空，住院后续处理
                paramDic.Add("processType", null); // 医嘱编码，门诊传空，住院后续处理

            }
            else if (BdFcDictCodeConst.SD_CODE_ENTP_OP.Equals(ent4BannerDTO.Code_entp) || BdFcDictCodeConst.SD_CODE_ENTP_ET.Equals(ent4BannerDTO.Code_entp)) // 门诊、急诊
            {
                // 就诊次数，门诊 --患者就诊_门诊属性EN_ENT_OP . 门诊次数times_op 
                OutpatientDO outpatient = this.GetOutpatient(ent4BannerDTO.Id_ent); // 门诊属性
                paramDic.Add("patientNumber", outpatient.Times_op);

                paramDic.Add("pBarCode", pat.Barcode_chis); // 门诊--条码号，患者基本信息PI_PAT .CHIS条码号barcode_chis 

                paramDic.Add("patientSource", "01"); // 所属域，门诊 01 ；住院 02
                paramDic.Add("medicalAdviceId", null); // 医嘱流水号，门诊传空，住院后续处理
                paramDic.Add("processType", null); // 医嘱编码，门诊传空，住院后续处理
            }
            else
            {
                // 其他类型就诊
            }


            return paramDic;
        }

        /// <summary>
        /// 获取PACS报告查看参数 检查报告
        /// </summary>
        /// <param name="ent4BannerDTO"></param>
        /// <returns>查看list报告参数</returns>
        public Dictionary<String, object> GetRisParamDic(Ent4BannerDTO ent4BannerDTO)
        {

            Dictionary<String, object> paramDic = new Dictionary<string, object>();

            //paramDic.Add("funCode", RisFunCode); // 功能节点编码
            //paramDic.Add("cmd", "showlist"); // 固定写死
            //paramDic.Add("un", "web"); // 固定写死
            //paramDic.Add("pw", "webweb"); // 固定写死
            //paramDic.Add("domaincode", "outpatient"); // 固定写死 
            //paramDic.Add("domainid", "116594294"); // 固定写死 门诊--条码号，患者基本信息PI_PAT .CHIS条码号barcode_chis

            //if (paramDic != null)
            //{
            //    return paramDic;
            //}




            paramDic.Add("funCode", RisFunCode); // 功能节点编码
            paramDic.Add("cmd", "showlist"); // 固定写死
            paramDic.Add("un", "web"); // 固定写死
            paramDic.Add("pw", "webweb"); // 固定写死

            // 查询患者对象
            PatDO pat = patiMDOCrudService.findById(ent4BannerDTO.Id_pat);
            if (BdFcDictCodeConst.SD_CODE_ENTP_IP.Equals(ent4BannerDTO.Code_entp)) // 住院
            {
                paramDic.Add("domaincode", "inpatient"); // 固定写死
                paramDic.Add("domainid", pat.Code_amr_ip); // 固定写死 住院-- 住院号，患者基本信息PI_PAT .住院病案编号code_amr_ip
            }
            else if (BdFcDictCodeConst.SD_CODE_ENTP_OP.Equals(ent4BannerDTO.Code_entp) || BdFcDictCodeConst.SD_CODE_ENTP_ET.Equals(ent4BannerDTO.Code_entp)) // 门诊、急诊
            {
                paramDic.Add("domaincode", "outpatient"); // 固定写死 
                paramDic.Add("domainid", pat.Barcode_chis); // 固定写死 门诊--条码号，患者基本信息PI_PAT .CHIS条码号barcode_chis
            }
            else
            {
                // 其他类型就诊
            }


            return paramDic;
        }


        /// <summary>
        /// 获取lis报告查看参数
        /// </summary>
        /// <param name="ent4BannerDTO"></param>
        /// <returns>查看list报告参数</returns>
        public Dictionary<String, object> GetLisParamDic(Ent4BannerDTO ent4BannerDTO)
        {

            Dictionary<String, object> paramDic = new Dictionary<string, object>();

            //paramDic.Add("funCode", LisFunCode); // 功能节点编码
            //paramDic.Add("patientid", "000145102700"); // 患者ID            
            //paramDic.Add("healthchecktimes", "9"); // 就诊次数

            //if(paramDic != null)
            //return paramDic;


            paramDic.Add("funCode", LisFunCode); // 功能节点编码
            paramDic.Add("patientid", ent4BannerDTO.Code_pat); // 患者ID            

            if (BdFcDictCodeConst.SD_CODE_ENTP_IP.Equals(ent4BannerDTO.Code_entp)) // 住院
            {

                InpatientDO inpatient = GetInpatient(ent4BannerDTO.Id_ent);// 住院属性
                paramDic.Add("healthchecktimes", inpatient.Times_ip); // 就诊次数
            }
            else if (BdFcDictCodeConst.SD_CODE_ENTP_OP.Equals(ent4BannerDTO.Code_entp) || BdFcDictCodeConst.SD_CODE_ENTP_ET.Equals(ent4BannerDTO.Code_entp))
            {// 门诊、急诊

                OutpatientDO outpatient = this.GetOutpatient(ent4BannerDTO.Id_ent); // 门诊属性
                paramDic.Add("healthchecktimes", outpatient.Times_op); // 就诊次数
            }
            else
            {
                // 其他类型就诊
            }


            return paramDic;
        }

        /// <summary>
        /// 获取查看数据中心(CDR)参数
        /// </summary>
        /// <param name="ent4BannerDTO"></param>
        /// <returns></returns>
        public Dictionary<String, object> GetCDRParamDic(Ent4BannerDTO ent4BannerDTO)
        {

            Dictionary<String, object> paramDic = new Dictionary<string, object>();


            //paramDic.Add("funCode", DataCenterFunCode); // 功能节点编DataCenterFunCode码
            //paramDic.Add("patientId", "000145102700"); // 患者ID            
            //paramDic.Add("userId", "01566"); // 登录用户的人员编码
            //paramDic.Add("domainId", "01"); // 所属域，门诊 01 ；住院 02            

            //if (BdFcDictCodeConst.SD_CODE_ENTP_IP.Equals(ent4BannerDTO.Code_entp)) // 住院
            //{
            //    paramDic.Add("domaincode", "inpatient"); // 固定写死
            //    paramDic.Add("domainId", "02"); // 所属域，门诊 01 ；住院 02
            //}
            //else if (BdFcDictCodeConst.SD_CODE_ENTP_OP.Equals(ent4BannerDTO.Code_entp) || BdFcDictCodeConst.SD_CODE_ENTP_ET.Equals(ent4BannerDTO.Code_entp)) // 门诊、急诊
            //{


            //}


            //if (paramDic != null)
            //{
            //    return paramDic;
            //}


            paramDic.Add("funCode", DataCenterFunCode); // 功能节点编DataCenterFunCode码
            paramDic.Add("patientId", ent4BannerDTO.Code_pat); // 患者ID  患者编码          
            paramDic.Add("userId", this.context.PsnInfo.Code); // 登录用户的人员编码

            if (BdFcDictCodeConst.SD_CODE_ENTP_IP.Equals(ent4BannerDTO.Code_entp)) // 住院
            {
                paramDic.Add("domainId", "02"); // 所属域，门诊 01 ；住院 02
            }
            else if (BdFcDictCodeConst.SD_CODE_ENTP_OP.Equals(ent4BannerDTO.Code_entp) || BdFcDictCodeConst.SD_CODE_ENTP_ET.Equals(ent4BannerDTO.Code_entp)) // 门诊、急诊
            {
                paramDic.Add("domainId", "01"); // 所属域，门诊 01 ；住院 02
            }
            else
            {
                // 其他类型就诊
            }

            return paramDic;
        }


        #endregion

        #region 私有方法

        /// <summary>
        /// 获取住院属性
        /// </summary>
        /// <param name="id_ent">本次就诊id</param>
        /// <returns></returns>
        private InpatientDO GetInpatient(string id_ent)
        {

            string whereStr = string.Format("id_ent = '{0}'", id_ent);
            InpatientDO[] inpatients = inpatientCrudService.find(whereStr, null, FBoolean.False);
            return inpatients[0];
        }

        /// <summary>
        /// 获取门诊属性
        /// </summary>
        /// <param name="id_ent">本次就诊id</param>
        /// <returns></returns>
        private OutpatientDO GetOutpatient(string id_ent)
        {

            string whereStr = string.Format("id_ent = '{0}'", id_ent);
            OutpatientDO[] outpatients = outpatientCrudService.find(whereStr, null, FBoolean.False);
            return outpatients[0];
        }


        #endregion

        #region 状态处理区域

        #endregion





    }
}

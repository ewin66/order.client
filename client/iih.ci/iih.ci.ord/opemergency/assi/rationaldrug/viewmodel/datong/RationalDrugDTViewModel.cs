
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine;
using iih.en.pv.dto.d;
using iih.common_stub.datong;
using iih.ci.ord.ordsrvmm.i;
using iih.ci.ord.ordsrvmm.d;
using iih.common_stub.datong.data;
using xap.rui.bizcontrol.bannercontrol;
using iih.ci.ord.ems.d;
using xap.mw.serviceframework;
using xap.sys.permfw.user.d;
using xap.sys.orgfw.dept.d;
using xap.mw.coreitf.d;
using iih.ci.ord.ciorder.d;
using xap.sys.xbd.udi.d;
using xap.sys.xbd.udi.i;
using iih.ci.ord.i;
using iih.ci.ord.dto.ordrationaldrugdto.d;
using iih.ci.diag.cidiag.d;
using iih.pi.overview.overview.d;
using xap.sys.securityfw.switchdept;
using System.Text.RegularExpressions;
using iih.bd.bc.udi;
using xap.mw.log;
//using iih.pi.overview.overview.d;

namespace iih.ci.ord.opemergency.assi.rationaldrug.viewmodel.datong
{
    /// <summary>
    /// <para>描    述 : </para>
    /// <para>说    明 : </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.rationaldrug.viewmodel.datong    </para>    
    /// <para>类 名 称 :  RationalDrugDTViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/9/27 10:33:16</para>
    /// <para>更新时间 :  2016/9/27 10:33:16</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class RationalDrugDTViewModel : RationalDrugViewModel
    {

        #region 变量定义区域

        // 最小记录数
        private const int MINIMUM_RECORD_NUM = 3;

        /// <summary>
        /// 药品分析
        /// </summary>
        private static Dictionary<string, string> msgDic = new Dictionary<string, string>();

        /// <summary>
        /// 药物咨询及用药安全监测系统（大通）调用类
        /// </summary>
        private DatongDrugMonitor drugMonitor;


        #endregion


        #region 构造函数区域

        public RationalDrugDTViewModel()
            : base()
        {
            drugMonitor = new DatongDrugMonitor();
        }

        #endregion

        #region 对外方法区域

        /// <summary>
        /// 初始化合理用药
        /// </summary>
        public override void InitRationStatus()
        {
            drugMonitor.BeginNewPres();
        }

        #region 要点提示

        /// <summary>
        /// 显示医嘱中对应物品
        /// </summary>
        /// <param name="idOr">医嘱id</param>
        public override void ShowOrderDrugInstruction(string idOrsrv)
        {
            string condition = "Id_orsrv = '" + idOrsrv + "'";
            OrdSrvMmDO[] ordSrvMms = orderSrvmmService.find(condition, null, FBoolean.False);
            this.ShowDrugInstruction(ordSrvMms[0]);
        }

        /// <summary>
        /// 显示指定物品id对应的药品说明书
        /// </summary>
        /// <param name="idMm">药品id</param>
        public override void ShowDrugInstruction(string idOrsrvmm)
        {
            OrdSrvMmDO ordSrvMm = orderSrvmmService.findById(idOrsrvmm);
            this.ShowDrugInstruction(ordSrvMm);
        }

        /// <summary>
        /// 根据物品对象显示药品说明书
        /// </summary>
        /// <param name="ordSrvMm">药品对象</param>
        public override void ShowDrugInstruction(OrdSrvMmDO ordSrvMm)
        {
            this.ShowDrugInstruction(ordSrvMm.Code_mm, ordSrvMm.Name_mm);

        }

        /// <summary>
        /// 显示要点提示信息
        /// </summary>
        /// <param name="codeMm">药品编码</param>
        /// <param name="nameMm">药品名称</param>
        public override void ShowDrugInstruction(string codeMm, string nameMm)
        {
            DrugInfo drug = new DrugInfo();
            drug.License_number = codeMm;
            drug.General_name = nameMm;

            string msg = drugMonitor.HintMainPoints(drug);
        }

        #endregion

        #region 处方分析


        /// <summary>
        /// 分析医嘱用药的合理情况
        /// </summary>
        /// <param name="ent4BannerDTO">banner数据</param>
        /// <param name="ciords">待校验用药合理性的医嘱</param>
        /// <param name="msg">验证结果的提示信息</param>
        /// <returns>验证状态 0 无问题，1 一般问题， 2 严重问题</returns>
        public override int AnalysisPresResult(CiEnContextDTO ctxDTO, CiOrderDO[] ciords, out string msg)
        {
            drugMonitor.BeginNewPres();
            msg = "";
            if (ciords == null || ciords.Length == 0)
            {
                return DaTongConstant.RS_NOT_VERIFIED;
            }

            List<CiOrderDO> ciordList = new List<CiOrderDO>();
            List<string> idOrList = new List<string>();

            // 遍历医嘱，只需要校验药品的医嘱
            foreach (CiOrderDO ciorder in ciords)
            {
                if (ciorder.Sd_srvtp.StartsWith(BdSrvDictCodeConst.SD_SRVTP_DRUG)) // 药品的进行检查
                {
                    ciordList.Add(ciorder);
                    idOrList.Add(ciorder.Id_or);
                }
            }

            // 如果不存在药品，返回不需要验证
            if (ciordList.Count == 0)
            {
                return DaTongConstant.RS_NOT_VERIFIED;
            }

            PresInfo presInfo = GetPresInfo(ctxDTO, idOrList);
            // 进行处方分析
            return drugMonitor.AnalysisPres(presInfo, out msg);
        }

        #endregion

        #endregion

        #region 私有方法区域

        #region 获取提示信息

        /// <summary>
        /// 根据返回提示编码获取提示信息
        /// </summary>
        /// <param name="msgCode"></param>
        /// <returns></returns>
        public override string GetSdMessage(string msgCodes)
        {
            if (msgDic.Count == 0)
            {
                string condition = "id_udidoclist='" + CiDictCodeConst.ID_RATIONAL_DRUG + "'";
                UdidocDO[] udidos = this.udidocService.find(condition, null, FBoolean.False);
                if (udidos != null && udidos.Length > 0)
                {
                    foreach (UdidocDO udidoc in udidos)
                    {
                        if (!msgDic.ContainsKey(udidoc.Code))
                        {
                            if (!msgDic.ContainsKey(udidoc.Code))
                            {
                                msgDic.Add(udidoc.Code, udidoc.Name);
                            }
                            else
                            {
                                LogManager.GetLogger().ErrorEx("合理用药编码【" + udidoc.Code + "】" + udidoc.Name + "重复！");
                            }
                        }
                    }
                }
            }

            string tempMsgCodeStr = null;
            //string str = "<XML><ALERT>;XHZYWT;</ALERT></XML>\r\n";
            MatchCollection matchCollection = this.GetMidValue("<ALERT>;", ";</ALERT>", msgCodes);
            if (matchCollection != null)
            {
                foreach (Match match in matchCollection)
                {
                    tempMsgCodeStr = match.ToString();
                }
            }

            // m没有异常时
            if (string.IsNullOrEmpty(tempMsgCodeStr))
            {
                return "";
            }

            StringBuilder builder = new StringBuilder();
            string[] msgCodeArr = tempMsgCodeStr.Split(';');
            foreach (string msgCode in msgCodeArr)
            {
                if (msgDic.ContainsKey(msgCode))
                {
                    builder.Append("," + msgDic[msgCode]);
                }
            }

            if (builder.Length > 0)
            {
                return builder.ToString().Substring(1);
            }

            return "";

            //if (msgDic.ContainsKey(msgCodes))
            //{
            //    return msgDic[msgCodes];
            //}
            //else
            //{
            //    string condition = "id_udidoclist='@@@@ZZ2000000000007E' and code = '" + msgCodes + "'";
            //    UdidocDO[] udidos = this.udidocService.find(condition, null, FBoolean.False);
            //    if (udidos != null && udidos.Length > 0)
            //    {
            //        msgDic.Add(msgCodes, udidos[0].Name);
            //    }
            //    else
            //    {
            //        msgDic.Add(msgCodes, "药品间存在使用冲突");
            //    }
            //}

            //return "";
        }

        #endregion

        #region 获取处方

        /// <summary>
        /// 获取处方
        /// </summary>
        /// <param name="ent4BannerDTO"></param>
        /// <param name="idOrs"></param>
        /// <returns></returns>
        private PresInfo GetPresInfo(CiEnContextDTO ctxDTO, List<string> idOrList)
        {
            Ent4BannerDTO ent4BannerDTO = ctxDTO.Ent4BannerDTO;
            // 获取本次就诊的已签署的药品医嘱以及ordIds 对应的医嘱
            OrdRationalDrugDTO[] rationalDrugs = iCiOrdQryService.getRationalDrugDTOs(ent4BannerDTO, idOrList.ToArray());

            PresInfo presInfo = new PresInfo();
            // 设置医生患者信息
            this.SetDoctorPresInfo(ctxDTO, ref presInfo);

            // 获取过敏史，生理状况
            OverviewAggDO overivewAgg = this.GetAllergicHistory(ctxDTO.Id_pat);

            // 设置过敏史
            this.SetAllergicHistory(ref presInfo, overivewAgg.getPiPatAlDO());

            // 设置诊断
            this.SetDiagnoses(ref presInfo, ctxDTO.Id_en);

            //设置生理状况
            this.SetPhysiological(ref presInfo, overivewAgg.getPiPatPhyDO());

            // 设置处方
            this.SetPrescription(ref presInfo, rationalDrugs, idOrList);

            return presInfo;
        }

        /// <summary>
        /// 获取过敏史集合
        /// </summary>
        /// <returns></returns>
        //private List<PresInfo.AllergicHistory> GetAllergicHistory()
        //{

        //    List<PresInfo.AllergicHistory> allergicHistory = new List<PresInfo.AllergicHistory>();
        //    PresInfo.AllergicHistory allergic = new PresInfo.AllergicHistory();

        //    allergicHistory.Add(allergic);
        //    return allergicHistory;
        //}

        /// <summary>
        /// 设置处方分析中医生、患者相关属性
        /// </summary>
        /// <param name="presInfo"></param>
        private void SetDoctorPresInfo(CiEnContextDTO ctxDTO, ref PresInfo presInfo)
        {
            Ent4BannerDTO ent4BannerDTO = ctxDTO.Ent4BannerDTO;
            //UserDO user = this.context.User;
            PsnInfo psnInfo = ctxDTO.PsnInfo;
            DeptDO dept = ctxDTO.Dept;

            presInfo.Doctor_job_number = psnInfo.Code; //医生工号 TODO 医生工号？
            presInfo.Pres_date = DateTime.Parse(DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss")); //处方日期 TODO 取当前日期是否可行
            presInfo.Doctor_name = psnInfo.Name; // 医生名
            //presInfo.Doctor_type =  医生级别
            presInfo.Department_code = ent4BannerDTO.Id_dep_phy;// 科室代码 ？ 开立科室 本次就诊科室
            presInfo.Department_name = ent4BannerDTO.Name_dep_phy; // 科室名称 
            // 患者基本信息PI_PAT .CHIS条码号barcode_chis ；住院-- 住院号，患者基本信息PI_PAT .住院病案编号code_amr_ip
            presInfo.Case_id = ent4BannerDTO.Code_amr_ip;//病历卡号 TODO 确定属性内后在设置
            presInfo.Inhos_code = ent4BannerDTO.Code_ent;//门诊就诊号
            presInfo.Bed_no = ent4BannerDTO.Name_bed;//床号 门诊床号可以为空，实际大通不支持空值
            presInfo.Patient_weight = "";//患者体重
            presInfo.Patient_height = "";//患者身高
            if (!string.IsNullOrEmpty(ent4BannerDTO.Dt_birth))
            {
                try
                {
                    presInfo.Patient_birth = DateTime.Parse(ent4BannerDTO.Dt_birth); //患者出生日期
                }
                catch (Exception e)
                {
                    LogManager.GetLogger().ErrorEx("合理用药获取患者生日失败，生日值【" + ent4BannerDTO.Dt_birth + "】");
                }
            }            
            presInfo.Patient_name = ent4BannerDTO.Name_pat; // 患者名称
            presInfo.Patient_sex = ent4BannerDTO.Name_sex; // 患者性别
            presInfo.Physiological_statms = "";//生理状况
            presInfo.Boacterioscopy_effect = "";// 菌检结果
            presInfo.Bloodpressure = ""; // 血压
            presInfo.Liver_clean = "";// 肌酐清除率
        }

        /// <summary>
        /// 设置过敏史
        /// </summary>
        /// <returns></returns>
        private void SetAllergicHistory(ref PresInfo presInfo, PiPatAlDO[] pipatAls)
        {

            List<PresInfo.AllergicHistory> allergicHistory = new List<PresInfo.AllergicHistory>();
            // 过敏史记录数
            int pipatAlLength = pipatAls == null ? 0 : pipatAls.Length;
            // 获取需要循环的次数，构造大通使用的过敏史数据时，保证最少三条记录，不足设置空值
            int resultCnt = pipatAlLength > MINIMUM_RECORD_NUM ? pipatAlLength : MINIMUM_RECORD_NUM;

            for (int i = 0; i < resultCnt; i++)
            {
                PresInfo.AllergicHistory allergic = new PresInfo.AllergicHistory();
                if (pipatAlLength > i)
                {
                    allergic.Case_code = pipatAls[i].Mm_code;
                    allergic.Case_name = pipatAls[i].Mm_name;
                }
                else
                {
                    allergic.Case_code = "";
                    allergic.Case_name = "";
                }
                allergicHistory.Add(allergic);

            }

            presInfo.AllergicHistories = allergicHistory;
        }

        /// <summary>
        /// 设置处方中诊断
        /// </summary>
        /// <returns></returns>
        private void SetDiagnoses(ref PresInfo presInfo, string idEn)
        {
            List<string> didefCodeList = new List<string>();
            CiDiagItemDO[] cidiagItems = getCiDiagItems(idEn, "1");
            int itemLength = cidiagItems.Length;
            // 保证诊断最少有三个,如果诊断数不足三个，加空诊断补足
            int resultCnt = itemLength > MINIMUM_RECORD_NUM ? itemLength : MINIMUM_RECORD_NUM;

            for (int i = 0; i < resultCnt; i++)
            {
                if (i < itemLength)
                {
                    didefCodeList.Add(cidiagItems[i].Id_didef_code);
                }
                else
                {
                    didefCodeList.Add("");
                }
            }
            presInfo.Diagnoses = didefCodeList;
        }

        /// <summary>
        ///  设置生理状况
        /// </summary>
        /// <param name="presInfo"></param>
        private void SetPhysiological(ref PresInfo presInfo, PiPatPhyDO[] piPatPys)
        {
            int piPatPysLength = piPatPys == null ? 0 : piPatPys.Length;
            List<string> didefCodeList = new List<string>();
            for (int i = 0; i < MINIMUM_RECORD_NUM; i++)
            {
                if (i < piPatPysLength)
                {
                    didefCodeList.Add(piPatPys[i].Name_phyind);
                }
                else
                {
                    didefCodeList.Add("");
                }
            }
            presInfo.Diagnoses.AddRange(didefCodeList);
        }

        /// <summary>
        /// 设置处方信息
        /// </summary>
        /// <param name="presInfo"></param>
        private void SetPrescription(ref PresInfo presInfo, OrdRationalDrugDTO[] rationalDrugs, List<string> idOrList)
        {

            List<PresInfo.Prescription> prescriptions = new List<PresInfo.Prescription>();

            foreach (OrdRationalDrugDTO rationalDto in rationalDrugs)
            {

                // 处方
                PresInfo.Prescription prescription = new PresInfo.Prescription();
                prescriptions.Add(prescription);

                prescription.Pres_ID = rationalDto.Id_or;
                prescription.Pres_type = PresTypeEnum.OUTPATIENT;
                // 如果是当期签署的医嘱，则设置为当前医嘱,已签署过的医嘱设置为非当前医嘱
                prescription.Current = rationalDto.Fg_sign == FBoolean.True ? false : true;

                // 药品
                PresInfo.Medicine medicine = new PresInfo.Medicine();

                medicine.Medicine_suspension = false; // 药物悬浮液 TODO 判断逻辑
                medicine.Medicine_judge = true; // 药品判断 TODO 判断逻辑

                medicine.Group_number = null; // 组号
                medicine.General_name = this.ReplaceStr(rationalDto.Name_srv);  // 通用名
                medicine.License_number = rationalDto.Code_mm;//医院药品代码
                medicine.Medicine_name = this.ReplaceStr(rationalDto.Name_mm); //商品名
                medicine.Single_dose = Double.Parse(rationalDto.Quan_medu); //  单次计量
                medicine.Times = rationalDto.Freq_code;//频次代码
                if (!string.IsNullOrEmpty(rationalDto.Days_or))
                {
                    medicine.Days = Int16.Parse(rationalDto.Days_or); //天数
                }

                medicine.Unit = rationalDto.Medu_name;//单位
                medicine.Administer_drugs = rationalDto.Route_code; //用药途径

                prescription.Medicine = medicine;
                //prescriptions.Add(prescription);

            }

            presInfo.Prescriptions = prescriptions;

        }

        /// <summary>
        /// 清空原有的状态，主要作用是刷新屏幕上的四个灯
        /// </summary>
        private void ClearState()
        {
            drugMonitor.BeginNewPres();
        }

        /// <summary>
        /// 过滤字符串中特殊字符，否则调用大通程序会导致错误
        /// </summary>
        /// <param name="sourceStr"></param>
        /// <returns></returns>
        private string ReplaceStr(string sourceStr)
        {
            Dictionary<string, string> dic = GetReplaceDic();
            foreach (string key in dic.Keys)
            {
                sourceStr = sourceStr.Replace(key, dic[key]);
            }
            return sourceStr;
        }

        /// <summary>
        /// 过滤掉特殊字符
        /// </summary>
        /// <returns></returns>
        private Dictionary<string, string> GetReplaceDic()
        {

            Dictionary<string, string> dic = new Dictionary<string, string>();

            dic.Add("<", "(");
            dic.Add(">", ")");
            dic.Add("◎", "");
            dic.Add("&", "_");
            return dic;
        }


        /// <summary>
        /// 获得字符串中开始和结束字符串中间得值
        /// </summary>
        /// <param name="begin">开始匹配标记</param>
        /// <param name="end">结束匹配标记</param>
        /// <param name="matchStr">待提取的字符串</param>
        /// <returns>返回中间字符串</returns>
        public MatchCollection GetMidValue(string begin, string end, string matchStr)
        {
            Regex reg = new Regex("(?<=(" + begin + "))[.\\s\\S]*?(?=(" + end + "))", RegexOptions.Multiline | RegexOptions.Singleline);
            return reg.Matches(matchStr);
        }

        #endregion


        #endregion

    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using iih.bd.bc.udi;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.dto.d;
using iih.ci.ord.i;
using iih.en.pv.dto.d;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.cli.sdk.controls.banner.renders;
using xap.mw.serviceframework;
using xap.rui.core.Insurance.eachcommunication;
using xap.rui.engine;

//医保共享的规则
namespace iih.ci.ord.medicaresharing.mdeicalrule
{
    public class MedicalSharingDateRule : IMedicalSharingDateRule
    {
        public static string Hospital_code = "跨院";
        //提示信息
        public static List<MedicalSharingDTO> infoMedicalSharingDto = null;
        private static  ICiOrdQryService ciOrderQryService;
        /// <summary>
        /// 药品的唯一编码
        /// </summary>
        /// <param name="icno">医保卡号</param>
        /// <returns></returns>
        public static List<MedicalSharingDTO> MedicalSharingValidate(BaseContext context, MedicalSharingDTO[] medicalSharingDto, Ent4BannerDTO ent4BannerDto)
        {
            ciOrderQryService = XapServiceMgr.find<ICiOrdQryService>();
            string errMsg = "";
            //当前时间
            DateTime systemDateTime = LogicEx.GetInstance().GetSystemDateTime();
      
           infoMedicalSharingDto =  new List<MedicalSharingDTO>();

            //本院数据 签署未交费的验证
            // LocalValiDate(context, medicalSharingDto, ent4BannerDto, systemDateTime); // -- 2017-1--16 Bug:0109210, 废弃不用 （费用负责）

            //医保中心的50天的数据
            //判断时间是否超出 10分钟
            //医保中心的数据
            ClincHistoryTradeInfo historyTradeInfo = MedicalSharingCache.getMedicalData(ent4BannerDto.No_hp);
            
            if (historyTradeInfo == null)
            {
                return infoMedicalSharingDto;
            }
            DateTime? serverDateTime = historyTradeInfo.SysInfo.ServerDateTime;
            DateTime serverDateTime2 =new DateTime();
            if (serverDateTime != null)
            {
                serverDateTime2 = (DateTime) serverDateTime;
            }
            System.TimeSpan timespan = systemDateTime.Subtract(serverDateTime2);
            if (timespan != null && timespan.TotalMinutes >10)
            {
                GetMedicalsharingData.Instance.getMedicalsharingData(ent4BannerDto, context, out errMsg, "");
            }
            //判断排斥有的药品
            //不限制药品
            //中草药，葡萄糖及氯化钠相关注射液。溶媒类

            //重复开药（同一天）
            //医嘱不可重复：在医保共享数据中若已存在某医嘱，本次开立的医嘱中，不能有保内的同样的医嘱。再确认一下。
            //若出现重复，提示信息【医嘱共享数据中已存在该药品，不可重复开立】，按钮【放弃开立】【自费开立】

            // 【医嘱共享数据中已存在该药品，不可重复开立】，按钮【放弃开立】【自费开立】";
            //天数是否超出
            //遍历医保共享数据，若（交易日期 + 药品开立天数）- 当前日期  > 5时，该医嘱不可开立
            OutValiDate(context, medicalSharingDto,historyTradeInfo, ent4BannerDto, systemDateTime);


  
          
            //return dict;
            return infoMedicalSharingDto;

        }

        /// <summary>
        /// 本院数据验证
        /// </summary>
        /// <param name="context"></param>
        /// <param name="medicalSharingDto"></param>
        /// <param name="ent4BannerDto"></param>
        /// <param name="systemDateTime"></param>
        private static void LocalValiDate(BaseContext context, MedicalSharingDTO[] medicalSharingDto, Ent4BannerDTO ent4BannerDto, DateTime systemDateTime)
        {
            //本院数据 （签署 未交费的）
            MedicalSharingDTO[] LocalmedicalSharingDTO = ciOrderQryService.getMedicalSharing(ent4BannerDto.Id_pat, ent4BannerDto.Id_hp);

            if (medicalSharingDto != null && LocalmedicalSharingDTO != null)
            {
                MedicalSharingDTO infoDto = new MedicalSharingDTO();
                foreach (MedicalSharingDTO medical in medicalSharingDto)
                {
                    if (NoLimitDrug(null, medical)) continue;

                    foreach (MedicalSharingDTO localmedical in LocalmedicalSharingDTO)
                    {
                        //1同日开药
                        if (medical.Code == localmedical.Code && !localmedical.Sd_srvtp.StartsWith("0103") &&
                            medical.Sd_srvtp != BdSrvDictCodeConst.SD_SRVTP_DRUG_WESTDRUG_DSY)
                        {
                            string[] times = systemDateTime.GetDateTimeFormats('D');
                            if (localmedical.Dt_effe != null &&
                                systemDateTime.GetDateTimeFormats('D')[0].ToString() ==
                                ((DateTime) localmedical.Dt_effe).GetDateTimeFormats('D')[0].ToString())
                            {
                                infoDto.Id_orsrv = medical.Id_orsrv;
                                infoDto.Code_or = medical.Code_or;
                                if (!localmedical.Sd_srvtp.StartsWith("0103"))
                                {
                                    infoDto.Name_srv = medical.Name_srv + "(" + localmedical.Mm_name + ")"; 
                                }
                                else
                                {
                                     infoDto.Name_srv = medical.Name_srv;
                                }

                                infoDto.Code_or = localmedical.Code_or;
                                infoDto.Reason = "该病人" + localmedical.Dt_effe + "在" + localmedical.Dept_name + "本院医生" + localmedical .Doctor_name+ "已经开过" +
                                                 medical.Name_srv + "按领量未服用完，按医保要求，今天不能再开";

                            }

                        
                        // 2 
                        if (sumDys(localmedical.Dt_entry, (short) localmedical.Days_or, systemDateTime) > 5 &&
                            localmedical.Sd_srvtp != BdSrvDictCodeConst.SD_SRVTP_DRUG_WESTDRUG_DSY)
                        {
                            infoDto.Id_orsrv = medical.Id_orsrv;
                            infoDto.Code_or = localmedical.Code_or;
                            if (!localmedical.Sd_srvtp.StartsWith("0103"))
                            {
                                infoDto.Name_srv = medical.Name_srv + "(" + localmedical.Mm_name + ")"; 
                            }
                            else
                            {
                                infoDto.Name_srv = medical.Name_srv;
                            }
                            infoDto.Code_or = localmedical.Code_or;
                            if (infoDto.Reason != null)
                            {
                                infoDto.Reason = "\n 该病人" + localmedical.Dt_effe + "在" + localmedical.Dept_name +
                                                 "本院医生" + localmedical .Doctor_name+ "已经开过" + localmedical.Name_srv + "药，\n 用药天数" + localmedical.Days_or +
                                                 "天，按领量未用完，按医保要求，今天不能再开";
                            }
                            else
                            {
                                infoDto.Reason = "该病人" + localmedical.Dt_effe + "在" + localmedical.Dept_name + "本院医生" + localmedical.Doctor_name + "已经开过" +
                                                 localmedical.Name_srv + "药，\n 用药天数" + localmedical.Days_or +
                                                 "天，按领量未用完，按医保要求，今天不能再开";
                            }

                        }
                    }
                  }  
                }
                if (infoDto.Reason != null)
                {
                    infoMedicalSharingDto.Add(infoDto);
                }
          
            }
        }

        /// <summary>
        /// 外院数据验证
        /// </summary>
        /// <param name="context"></param>
        /// <param name="medicalSharingDto"></param>
        /// <param name="ent4BannerDto"></param>
        /// <param name="systemDateTime"></param>
        private static void OutValiDate(BaseContext context, MedicalSharingDTO[] medicalSharingDto,ClincHistoryTradeInfo historyTradeInfo, Ent4BannerDTO ent4BannerDto, DateTime systemDateTime)
        {
            foreach (MedicalSharingDTO medical in medicalSharingDto)
            {
                //判断排斥有的药品
                //不限制药品
                //中草药，葡萄糖及氯化钠相关注射液。溶媒类
                if (excludeDrug(medical))continue;
                if (NoLimitDrug(historyTradeInfo, medical)) continue;
                MedicalSharingDTO infoDto = new MedicalSharingDTO();
                //1 同一天重复开药
                string message2 = repeatDrug(historyTradeInfo, medical, systemDateTime);
                if (message2 != "")
                {
                    infoDto.Id_or = medical.Id_or;
                    infoDto.Id_orsrv = medical.Id_orsrv;
                    if (!medical.Sd_srvtp.StartsWith("0103"))
                    {
                        infoDto.Name_srv = medical.Name_srv + "(" + medical.Name14 + ")";
                    }
                    else
                    {
                        infoDto.Name_srv = medical.Name_srv;
                    }
                    infoDto.Code_or = medical.Code_or;
                    infoDto.Reason =message2;
            
                }
                string message = Daysexceeding(historyTradeInfo, medical, systemDateTime, context.Org.Code);
                if(message != "")
                {
                    infoDto.Id_or = medical.Id_or;
                    infoDto.Id_orsrv = medical.Id_orsrv;
                    if (!medical.Sd_srvtp.StartsWith("0103"))
                    {
                        infoDto.Name_srv = medical.Name_srv + "(" + medical.Name14 + ")";
                    }
                    else
                    {
                        infoDto.Name_srv = medical.Name_srv;
                    }
                    infoDto.Code_or = medical.Code_or;
                    if (infoDto.Reason != null)
                    {
                        infoDto.Reason = "\n "+message;
                    }
                    else
                    {
                        infoDto.Reason = message;
                    }
                   
                }
                if (infoDto.Reason != null)
                {
                    infoMedicalSharingDto.Add(infoDto);
                }
            }
        }


        public static Boolean excludeDrug(MedicalSharingDTO medicalSharingDto)
        {
            return MedicalSharingCache.getBdHpUnlimitDrugDO(medicalSharingDto.Code);
        }


        /// <summary>
        ///  //不限制药品
        //中草药，葡萄糖及氯化钠相关注射液。溶媒类
        /// </summary>
        /// <param name="historyTradeInfo"></param>
        /// <param name="Itemcode"></param>
        /// <returns></returns>
        public static Boolean NoLimitDrug(ClincHistoryTradeInfo historyTradeInfo, MedicalSharingDTO medicalSharingDto)
        {

            if (medicalSharingDto != null && medicalSharingDto .Sd_srvtp != null&& (medicalSharingDto.Sd_srvtp.StartsWith(BdSrvDictCodeConst.SD_SRVTP_DRUG_WESTDRUG_DSY) ||
               medicalSharingDto.Sd_srvtp.StartsWith(BdSrvDictCodeConst.SD_SRVTP_HERBDRUG)))
            {
                return true;
            }
            return false;
        }
        /// <summary>
        /// 重复开药（同一天）
        ///医嘱不可重复：在医保共享数据中若已存在某医嘱，本次开立的医嘱中，不能有保内的同样的医嘱。再确认一下。
        //若出现重复，提示信息【医嘱共享数据中已存在该药品，不可重复开立】，按钮【放弃开立】【自费开立】
        /// <param name="historyTradeInfo"></param>
        /// <param name="Itemcode"></param>
        /// <returns></returns>
        public static string repeatDrug(ClincHistoryTradeInfo historyTradeInfo, MedicalSharingDTO medicalSharingDto, DateTime systemDateTime)
        {
            string info = "";
            List<TradeInfoEach> list = historyTradeInfo.TradeInfoEachs;
            if (list != null && list.Count > 0)
            {
                foreach (TradeInfoEach tradeInfo in list)
                {
                    List<FeeItemEach> FeeList = tradeInfo.FeeItemEaches;
                    if (FeeList != null && FeeList.Count > 0)
                    {
                        foreach (FeeItemEach feeItem in FeeList)
                        {
                            if (feeItem.ItemCode != null && feeItem.ItemCode.Equals(medicalSharingDto.Code))
                            {
                               // dt.GetDateTimeFormats('D')[0].ToString();//2005年11月5日
                                string[] times = systemDateTime.GetDateTimeFormats('D');
                               ///string tmp= systemDateTime.GetDateTimeFormats('D')[3].ToString();
                               //string tmp2 = ((DateTime) tradeInfo.TradeDate).GetDateTimeFormats('D')[3].ToString();
                                if (systemDateTime.GetDateTimeFormats('D')[0].ToString() == ((DateTime) tradeInfo.TradeDate).GetDateTimeFormats('D')[0].ToString())
                                {
                                    medicalSharingDto.Name14 = feeItem.ItemName;
                                    info = "该病人在" + tradeInfo.TradeDate + "在" + tradeInfo.TradeMiName + " 开过" +
                                           medicalSharingDto.Name_srv + "药 ,按医保要求，今天不能再开";
                                }
                            }
                        }
                    }

                }
            }

            return info;
        }
        /// <summary>
        /// 天数是否超出
        /// 遍历医保共享数据，若（交易日期 + 药品开立天数）- 当前日期  > 5时，该医嘱不可开立
        /// </summary>
        /// <param name="historyTradeInfo"></param>
        /// <param name="Itemcode"></param>
        /// <returns></returns>
        public static String Daysexceeding(ClincHistoryTradeInfo historyTradeInfo, MedicalSharingDTO medicalSharingDto, DateTime systemDateTime, string code)
        {
            String info = null;
            List<TradeInfoEach> list = historyTradeInfo.TradeInfoEachs;
            if (list != null && list.Count > 0)
            {   
                foreach (TradeInfoEach tradeInfo in list)
                {
                    List<FeeItemEach> FeeList = tradeInfo.FeeItemEaches;
                    string tradMicode = tradeInfo.TradeMiCode;
                    if (tradMicode != null && tradMicode== code )
                    {
                        Hospital_code = tradeInfo.TradeMiName;
                    }
                    if (FeeList != null && FeeList.Count >0)
                    {
                        foreach (FeeItemEach feeItem in FeeList)
                        {
                            if (feeItem.ItemCode != null && feeItem.ItemCode.Equals(medicalSharingDto.Code) && tradeInfo.TradeFundType != null && tradeInfo.TradeFundType.Equals(MedicalSharingCache.getcodeHpKind()))
                            {
                               int  num = sumDys(tradeInfo.TradeDate, feeItem.Days, systemDateTime);
                                if (num > 5)
                                {
                                    medicalSharingDto.Name14 = feeItem.ItemName;
                                    info = "该病人在" + tradeInfo.TradeDate + "在" + tradeInfo.TradeMiName + " 开过" +
                                           medicalSharingDto.Name_srv + "药 ,\n 用药" + feeItem.Days +
                                           "天，按领量未服用完，按医保要求，今天不能再开";
                                }
                            }
                        }
                    }
                }
            }
            return info;
        }

        /// <summary>
        /// 天数的计算
        /// </summary>
        /// <param name="TradeDate"></param>
        /// <param name="Days"></param>
        /// <param name="todayTime"></param>
        /// <returns></returns>
        public static int sumDys(DateTime? TradeDate, short Days, DateTime todayTime)
        {
            //Days = 30;//测试
            if (TradeDate != null )//&& Days != null
            {
                DateTime  TradeDate2 = (DateTime)TradeDate;
                DateTime TradeDate3 = TradeDate2.AddDays(Days);
                TimeSpan timespan = TradeDate3 - todayTime;
                return  timespan.Days;
            }
            return 0;
        }

        List<MedicalSharingDTO> IMedicalSharingDateRule.MedicalSharingValidate(BaseContext context, MedicalSharingDTO[] dto, Ent4BannerDTO ent4BannerDto)
        {
            return MedicalSharingValidate(context, dto,ent4BannerDto);
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using iih.bd.pp.hp.d;
using iih.ci.ord.ciorder.cards.thread;
using iih.ci.ord.dto.d;
using xap.rui.core.Insurance.eachcommunication;
using xap.rui.engine;
/**
 * 缓存医保共享数据
 * 
 **/
namespace iih.ci.ord.medicaresharing.mdeicalrule
{
    public class MedicalSharingCache
    {
        /// <summary>
        /// 50天的 医保信息
        /// </summary>
        public static Dictionary<String, ClincHistoryTradeInfo> medicalData;
        /// <summary>
        /// 医保不限制药品
        /// </summary>
        public static Dictionary<String, BdHpUnlimitDrugDO> DictbdHpUnlimitDrug;
        /// <summary>
        /// 本院的医保数据（未上传医保中心的数据）
        /// </summary>
        public static Dictionary<String, MedicalSharingDTO[]> DicMedicalSharing;
        /// <summary>
        /// 险种
        /// </summary>
        private static string code_hpkind = "";

        /// <summary>
        /// set 医保数据
        /// </summary>
        /// <param name="icno"></param>
        /// <param name="historyInfo"></param>
        /// <param name="errMeage"></param>
        public static void setMedicalSharingData(string icno, ClincHistoryTradeInfo historyInfo, string errMeage)
        {
            if (icno != null)
            {
                if (medicalData == null) medicalData = new Dictionary<string, ClincHistoryTradeInfo>();
                if (medicalData.ContainsKey(icno))
                {
                    medicalData.Remove(icno);
                    medicalData.Add(icno, historyInfo);
                }
                else
                {
                    medicalData.Add(icno, historyInfo);
                }
        }

    }
        /// <summary>
        /// 医保数据
        /// </summary>
        /// <param name="icno"></param>
        /// <returns></returns>
        public static ClincHistoryTradeInfo getMedicalData(string icno)
        {
            if (icno != null && medicalData != null && medicalData.ContainsKey(icno))
            {
                return medicalData[icno];
            }
            else
            {
                return null;
            }
        }

        /// <summary>
        /// 排斥的药品
        /// </summary>
        /// <param name="Code_hpsrvorca"></param>
        /// <returns></returns>
        public static Boolean getBdHpUnlimitDrugDO(string Code_hpsrvorca)
        {
            if (DictbdHpUnlimitDrug != null && Code_hpsrvorca  != null && DictbdHpUnlimitDrug.ContainsKey(Code_hpsrvorca))
            {
                return true;
            }
            return false;
        }
        /// <summary>
        /// 
        /// </summary>
        /// <param name="dict"></param>
        public static void setBdHpUnlimitDrugDO(Dictionary<string, BdHpUnlimitDrugDO> dict)
        {
            DictbdHpUnlimitDrug = dict;
        }

        /// <summary>
        /// 本院的医保数据，未上传医保的数据
        /// </summary>
        /// <param name="icno"></param>
        /// <returns></returns>
        //public static MedicalSharingDTO[] getDicMedicalSharingDTO(string icno)
        //{
        //    if (DicMedicalSharing != null)
        //    {
        //        return DicMedicalSharing[icno];
        //    }
        //    else
        //    {
        //        return null;
        //    }
        //}

        public static void setDicMedicalSharing( Dictionary<string, MedicalSharingDTO[]> dict)
        {
            DicMedicalSharing = dict;
        }


        public static void setCode_hpkind(string code_hphind)
        {
            code_hpkind = code_hphind;
        }

        public static string  getcodeHpKind()
        {
            return code_hpkind;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;

namespace iih.ci.ord.opemergency.tool
{  
    /// <summary>
    /// 草药的提示 TODO
    /// </summary>
   public class medicalInfoCache
    {

         public static Dictionary<String, String> medicalInfo;

        public static Dictionary<string, bool> repeatMessageDic;
       /// <summary>
       /// 
       /// </summary>
       /// <param name="id"></param>
       /// <returns></returns>
        public static bool getRepeatMessageDic(string id)
        {
            if (repeatMessageDic != null && repeatMessageDic.ContainsKey(id))
            {
                return repeatMessageDic[id];
            }
            return false;
        }
       /// <summary>
       /// 
       /// </summary>
       /// <param name="id"></param>
       /// <param name="info"></param>
        public static void setRepeatMessageDic(String id, bool info)
        {
            if (repeatMessageDic == null)
            {
                repeatMessageDic = new Dictionary<string, bool>();
                repeatMessageDic.Add(id, info);
            }
            else
            {
                if (repeatMessageDic.ContainsKey(id))
                {
                    repeatMessageDic.Remove(id);
                    repeatMessageDic.Add(id, info);
                }
                else
                {
                    repeatMessageDic.Add(id, info);
                }

            }


        }




        public static void setMedicalinfo(String id,String info)
        {
            if (medicalInfo == null)
            {
                medicalInfo = new Dictionary<string, string>();
                medicalInfo.Add(id, info);
            }
            else
            {
                if (medicalInfo.ContainsKey(id))
                {
                    medicalInfo.Remove(id);
                    medicalInfo.Add(id, info);
                }
       
            }

            
        }

        public static String getMedicalInfo(string id)
        {
            if (medicalInfo != null && medicalInfo.ContainsKey("Id"))
            {
                return medicalInfo[id];
            }
            return null;
        }

        public static void ReMoveRepeatMessageDic(String id_or)
        {
            if (repeatMessageDic != null && repeatMessageDic.ContainsKey(id_or))
            {
                repeatMessageDic.Remove(id_or);
            }
        }

        public static void Remove(string id)
        {
            
            medicalInfo.Remove(id);
        }
    }
}

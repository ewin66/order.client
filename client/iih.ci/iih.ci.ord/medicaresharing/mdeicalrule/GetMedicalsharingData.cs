using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bl.common.Insure;
using iih.bl.hp.bj.dto.d;
using iih.ci.ord.ciorder.utils;
using iih.en.pv.dto.d;
using xap.mw.serviceframework;
using xap.rui.core.Insurance.eachcommunication;
using xap.rui.engine;

/***
 * 医保共享的验证
 * 读取医保信息
 * 
 ***/
namespace iih.ci.ord.medicaresharing.mdeicalrule
{
   public class GetMedicalsharingData
   {
       private EachCommunicationBizService service;

       public GetMedicalsharingData()
       {
           service = new EachCommunicationBizService();
       }

        static GetMedicalsharingData instance = null;
        private static readonly object padlock = new object();

        public static GetMedicalsharingData Instance
        {
            get
            {
                lock (padlock)
                {
                    if (instance == null)
                    {
                        instance = new GetMedicalsharingData();
                    }
                }

                return instance;
            }
        }

      
       //接诊时调用医保的共享数据 缓存在客户端
       public String getMedicalsharingData(Ent4BannerDTO ent4Banner,  BaseContext context, out string errMessage, string str)
       {
                ClincHistoryTradeInfo historyInfo = null;
                EachCommDTO eachCommDTO = new EachCommDTO();
               eachCommDTO.Code_hp = ent4Banner.No_hp;
               eachCommDTO.Id_grp = context.Group.Id_grp;
               eachCommDTO.Id_org = context.Org.Id_org;
               eachCommDTO.Id_pat = ent4Banner.Id_pat;
           historyInfo = MedicalSharingCache.getMedicalData(ent4Banner.No_hp);
           if (historyInfo != null && historyInfo.SysInfo != null && historyInfo.SysInfo.ServerDateTime != null)
           {
               DateTime systemDateTime = LogicEx.GetInstance().GetSystemDateTime();
               DateTime serverDateTime2 = (DateTime)historyInfo.SysInfo.ServerDateTime;
               System.TimeSpan timespan = systemDateTime.Subtract(serverDateTime2);
               if (timespan != null && timespan.TotalMinutes > 10)
               {
                   historyInfo = service.GetClincHistoryInfo(eachCommDTO, out errMessage, str);
                   //historyInfo = service.GetClincHistoryInfoByTest();
               }

           }
           else
           {
                 //historyInfo = service.GetClincHistoryInfoByTest();
               // historyInfo = service.GetClincHistoryInfo(icno, out errMessage, str);
             
               historyInfo =   service.GetClincHistoryInfo(eachCommDTO, out errMessage, str);
           }
          // ClincHistoryTradeInfo historyInfo = service.GetClincHistoryInfo(icno, out errMessage, str);
         // ClincHistoryTradeInfo historyInfo =  service.GetClincHistoryInfoByTest();//测试数据 
           errMessage = "";
           MedicalSharingCache.setMedicalSharingData(ent4Banner.No_hp, historyInfo, errMessage);
           return "";
       }

   }
}

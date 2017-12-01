using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.bc.udi;
using iih.bd.srv.ems.d;
using iih.bd.srv.ems.i;
using iih.ci.ord.app.d;
using iih.ci.ord.app.i;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.i;
using iih.ci.ord.pres.d;
using iih.ci.ord.pres.i;
using iih.ci.ord_stub.i;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw.extentions;
using iih.ci.ord.ciprn.i;
using iih.ci.ord.ciprn.d;

namespace iih.ci.ord.opemergency.viewmodel
{
   public  class PrintManageViewModel
   {
       private ICiprintExtService service = XapServiceMgr.find<ICiprintExtService>();

       private EmsprntmplAggDO[] emsprntmplAggDOs;//当前机构所有打印模板

       public Dictionary<string, List<string>> dicUrlIDs;//key:模板路径  value:模板参数ID集合（id_or或id_pres）
       
       #region 构造函数区域
       public PrintManageViewModel(string id_psn, string id_dep, string id_org, string id_grp, string paramUsageScope,
           int selectedIndex, List<String> lstIdor, List<String> lstIdpres, String id_hp, String sd_hptp, bool bShowTools)
       {
           this.dicUrlIDs = new Dictionary<string, List<string>>();

           this.emsprntmplAggDOs = service.GetEmsprntmpl(id_psn, id_dep, id_grp, id_org);
           MatchResultDTO[] dtos = service.MatchEmsprntmpl(this.emsprntmplAggDOs, id_hp, sd_hptp, paramUsageScope, selectedIndex, lstIdor == null ? new String[] { } : lstIdor.ToArray(), lstIdpres == null ? new String[] { } : lstIdpres.ToArray());
           if (dtos != null)
           {
               foreach (var dto in dtos)
               {
                   List<string> lstids=new List<string>();
                   foreach(var id in dto.Ids)
                   {
                       lstids.Add(id.ToString());
                   }
                   this.dicUrlIDs.Add(dto.Tmplurl, lstids);
               }
           }
       }
       #endregion

       #region 公共方法区域

       /// <summary>
       /// 根据choose页面选中的单据类型获得所有模板路径
       /// </summary>
       /// <param name="lstSdSheettps"></param>
       /// <returns></returns>
       public List<String> GetPrntmplPathByPrntp(List<string> lstSdSheettps)
       {
           List<string> lstUrl=new List<string>();
           List<string> lstSDDel = new List<string>();
           foreach (string sd in lstSdSheettps)
           {
               foreach (EmsprntmplAggDO aggDo in emsprntmplAggDOs)
               {
                   if (aggDo == null || aggDo.getParentDO() == null) continue;
                   if (aggDo.getParentDO().Sd_ciprintsheettp == sd)
                   {
                       string path = aggDo.getParentDO().Tmplurl;
                       if (this.dicUrlIDs.ContainsKey(path))
                       {
                           if (!lstUrl.Contains(path)) lstUrl.Add(path);
                       }
                       else
                       {
                           if (!lstSDDel.Contains(sd)) lstSDDel.Add(sd);
                       }
                   }
               }
           }
           foreach (string sd in lstSDDel)
           {
               lstSdSheettps.Remove(sd);
           }
           return lstUrl;
       }
       
       /// <summary>
       /// 根据单据类型修改打印标识
       /// </summary>
       /// <param name="sdsheetpys"></param>
       public void UpdateFgprn(string[] sdsheettps)
       {
           FMap2 updatedataMap = new FMap2();
           foreach (string sd in sdsheettps)
           {
               EmsprntmplAggDO[] aggdo = emsprntmplAggDOs.Where(p => p.getParentDO().Sd_ciprintsheettp == sd).ToArray();
               foreach (EmsprntmplAggDO agg in aggdo)
               {
                   if (this.dicUrlIDs.ContainsKey(agg.getParentDO().Tmplurl))
                   {
                       string ids = "";
                       foreach (string id in this.dicUrlIDs[agg.getParentDO().Tmplurl])
                       {
                           ids += string.Format(",{0}", id);
                       }
                       updatedataMap.Add(sd, ids.Substring(1));
                   }
               }
           }

           service.UpdatePrintFgprn(updatedataMap);
       }

       /// <summary>
       /// 根据已加载的报表返回打印单据类型
       /// </summary>
       /// <param name="lstUrls"></param>
       /// <returns></returns>
       public List<string> FindPrntpByUrl(List<string> lstUrls )
       {
           List<string> lstPrntp = new List<string>();
           if (lstUrls != null && lstUrls.Count > 0)
           {
               foreach (string url in lstUrls)
               {
                   foreach (EmsprntmplAggDO aggDo in emsprntmplAggDOs)
                   {
                       if (aggDo == null || aggDo.getParentDO() == null) continue;
                       if (aggDo.getParentDO().Tmplurl == url)
                       {
                           if (!lstPrntp.Contains(aggDo.getParentDO().Sd_ciprintsheettp))
                               lstPrntp.Add(aggDo.getParentDO().Sd_ciprintsheettp);
                       }
                   }
               }
           }
           return lstPrntp;
       }
       
       /// <summary>
       /// 获取配置的报表打印机
       /// </summary>
       /// <returns></returns>
       public String GetPrinterName()
       {
           return service.GetReportPrinter();
       }
       #endregion
   }
}

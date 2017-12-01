
using System;
using System.Collections.Generic;
using System.Linq;
using iih.ci.ord.ciprn.i;
using xap.mw.serviceframework;
using xap.mw.coreitf.d;
using xap.mw.core.data;
using iih.ci.ord.ciorder.d;
using iih.en.pv.dto.d;
using iih.ci.ord.ciprn.d;
using iih.bd.srv.ems.d;

namespace iih.ci.ord.ciprn.i
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.iih.ci.ord.ciprn.s    </para>    
    /// <para>类 名 称 :  ICiprintExtServiceImpl					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/6/9 10:28:31             </para>
    /// <para>更新时间 :  2017/6/9 10:28:31             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class ICiprintExtServiceImpl : ICiprintExtService
    {
        private readonly ServiceInvocation si;

        private readonly string url_r = XapSvrConfig.BaseUrl + "xap.ci.ord/iih.ci.ord.ciprn.i.ICiprintExtService";

        public ICiprintExtServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url_r;
        }

        /// <summary>
        /// 获取医嘱打印对象集合
        /// </summary>
        /// <param name="idors">医嘱ID集合</param>
        /// <returns></returns>
        public FBoolean SaveFeeBillsData(String[] idors, String Id_hp, String Sd_hptp)
        {
            object[] param = new object[] { idors, Id_hp, Sd_hptp };
            si.url = url_r;
            return si.invoke<FBoolean>("SaveFeeBillsData", param.ToArray());
        }

        /// <summary>
        /// 更新打印标识和打印次数
        /// </summary>
        /// <param name="idors">医嘱ID集合</param>
        /// <returns></returns>
        public FBoolean UpadateFeeBillsPrtCnt(String[] idors)
        {
            object[] param = new object[] { idors };
            si.url = url_r;
            return si.invoke<FBoolean>("UpadateFeeBillsPrtCnt", param.ToArray());
        }

        /// <summary>
        /// 删除费用清单数据
        /// </summary>
        /// <param name="idors"></param>
        /// <returns></returns>
        public FBoolean DeleteFeeBillsData(String[] idors)
        {
            object[] param = new object[] { idors };
            si.url = url_r;
            return si.invoke<FBoolean>("DeleteFeeBillsData", param.ToArray()); 
        }

        /// <summary>
        /// 保存诊疗执行单打印对象集合
        /// </summary>
        /// <param name="idors"></param>
        /// <returns></returns>
        public FBoolean SaveTreatexecData(String[] idors, String Id_hp, String Sd_hptp)
        {
            object[] param = new object[] { idors, Id_hp, Sd_hptp };
            si.url = url_r;
            return si.invoke<FBoolean>("SaveTreatexecData", param.ToArray()); 
        }

        /// <summary>
        /// 更新保存诊疗执行单打印标识和打印次数
        /// </summary>
        /// <param name="idors"></param>
        /// <returns></returns>
        public FBoolean UpdateTreateExecPrtCnt(String[] idors)
        {
            object[] param = new object[] { idors };
            si.url = url_r;
            return si.invoke<FBoolean>("UpdateTreateExecPrtCnt", param.ToArray()); 
        }

        /// <summary>
        /// 删除诊疗执行单打印对象集合
        /// </summary>
        /// <param name="idors"></param>
        /// <returns></returns>
        public FBoolean DeleteTreateExecData(String[] idors)
        {
            object[] param = new object[] { idors };
            si.url = url_r;
            return si.invoke<FBoolean>("DeleteTreateExecData", param.ToArray()); 
        }

        /// <summary>
        /// 医嘱打印标识修改和次数累加
        /// </summary>
        /// <param name="mapprnids"></param>
        /// <param name="fg_prn"></param>
        public void UpdatePrintFgprn(FMap2 mapprnids)
        {
            List<object> param = new List<object>();
            param.Add(mapprnids);
            si.url = url_r;
            si.invokeList<CiOrderDO>("UpdatePrintFgprn", param.ToArray());
        }

        /// <summary>
        /// 获得本机设置的报表打印机名称
        /// </summary>
        /// <returns></returns>
        public String GetReportPrinter()
        {
            object[] param = new object[] { };
            si.url = url_r;
            String str = si.invoke<String>("GetReportPrinter", param.ToArray());
            return str;
        }

        /// <summary>
        /// 保存小票打印机设置
        /// </summary>
        /// <param name="printerName"></param>
        /// <returns></returns>
        public FBoolean SaveReportPrinter(String printerName)
        {
            object[] param = new object[] { printerName };
            si.url = url_r;
            FBoolean b = si.invoke<FBoolean>("SaveReportPrinter", param.ToArray());
            return b;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="id_psn"></param>
        /// <param name="id_dep"></param>
        /// <param name="id_grp"></param>
        /// <param name="id_org"></param>
        /// <returns></returns>
        public EmsprntmplAggDO[] GetEmsprntmpl(String id_psn, String id_dep, String id_grp, String id_org)
        {
            List<object> param = new List<object>();
            param.Add(id_psn);
            param.Add(id_dep);
            param.Add(id_grp);
            param.Add(id_org);
            si.url = url_r;
            return si.invokeList<EmsprntmplAggDO>("GetEmsprntmpl", param.ToArray());
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="aggDOs"></param>
        /// <param name="Id_hp"></param>
        /// <param name="Sd_hptp"></param>
        /// <param name="paramUsageScope"></param>
        /// <param name="selectedIndex"></param>
        /// <param name="idors"></param>
        /// <param name="idpres"></param>
        /// <returns></returns>
        public MatchResultDTO[] MatchEmsprntmpl(EmsprntmplAggDO[] aggDOs, String Id_hp, String Sd_hptp, String paramUsageScope, int selectedIndex, String[] idors, String[] idpres)
        {
            List<object> param = new List<object>();
            param.Add(aggDOs);
            param.Add(Id_hp);
            param.Add(Sd_hptp);
            param.Add(paramUsageScope);
            param.Add(selectedIndex);
            param.Add(idors);
            param.Add(idpres);
            si.url = url_r;
            return si.invokeList<MatchResultDTO>("MatchEmsprntmpl", param.ToArray());
        }

        /// <summary>
        /// 校验是否全部退费医嘱
        /// </summary>
        /// <param name="idors"></param>
        /// <returns></returns>
        public FBoolean CheckAllOrsBlRefound(String[] idors)
        {
            List<object> param = new List<object>();
            param.Add(idors);
            si.url = url_r;
            return si.invoke<FBoolean>("CheckAllOrsBlRefound", param.ToArray());
        }
    }
}

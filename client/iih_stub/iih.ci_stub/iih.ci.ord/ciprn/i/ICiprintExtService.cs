
using System;
using xap.mw.coreitf.d;
using xap.mw.core.data;
using iih.en.pv.dto.d;
using iih.ci.ord.ciprn.d;
using iih.bd.srv.ems.d;

namespace iih.ci.ord.ciprn.i
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.iih.ci.ord.ciprn.i    </para>    
    /// <para>类 名 称 :  ICiprintExtService					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/6/9 10:25:06             </para>
    /// <para>更新时间 :  2017/6/9 10:25:06             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public interface ICiprintExtService
    {
        /// <summary>
        /// 保存费用清单打印对象集合
        /// </summary>
        /// <param name="idors"></param>
        /// <param name="Id_hp"></param>
        /// <param name="Sd_hptp"></param>
        /// <returns></returns>
        FBoolean SaveFeeBillsData(String[] idors, String Id_hp, String Sd_hptp);

        /// <summary>
        /// 更新打印标识和打印次数
        /// </summary>
        /// <param name="idors">医嘱ID集合</param>
        /// <returns></returns>
        FBoolean UpadateFeeBillsPrtCnt(String[] idors);

        /// <summary>
        /// 删除费用清单数据
        /// </summary>
        /// <param name="idors"></param>
        /// <returns></returns>
        FBoolean DeleteFeeBillsData(String[] idors);

        /// <summary>
        /// 保存诊疗执行单打印对象集合
        /// </summary>
        /// <param name="idors"></param>
        /// <param name="Id_hp"></param>
        /// <param name="Sd_hptp"></param>
        /// <returns></returns>
        FBoolean SaveTreatexecData(String[] idors, String Id_hp, String Sd_hptp);

        /// <summary>
        /// 更新保存诊疗执行单打印标识和打印次数
        /// </summary>
        /// <param name="idors"></param>
        /// <returns></returns>
        FBoolean UpdateTreateExecPrtCnt(String[] idors);

        /// <summary>
        /// 删除诊疗执行单打印对象集合
        /// </summary>
        /// <param name="idors"></param>
        /// <returns></returns>
        FBoolean DeleteTreateExecData(String[] idors);

        /// <summary>
        /// 医嘱打印标识修改和次数累加
        /// </summary>
        /// <param name="mapprnids"></param>
        /// <param name="fg_prn"></param>
        void UpdatePrintFgprn(FMap2 mapprnids);

        /// <summary>
        /// 获得本机设置的报表打印机名称
        /// </summary>
        /// <returns></returns>
        String GetReportPrinter();

        /// <summary>
        /// 保存小票打印机设置
        /// </summary>
        /// <param name="printerName"></param>
        /// <returns></returns>
        FBoolean SaveReportPrinter(String printerName);

        /// <summary>
        /// 
        /// </summary>
        /// <param name="id_psn"></param>
        /// <param name="id_dep"></param>
        /// <param name="id_grp"></param>
        /// <param name="id_org"></param>
        /// <returns></returns>
        EmsprntmplAggDO[] GetEmsprntmpl(String id_psn, String id_dep, String id_grp, String id_org);

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
        MatchResultDTO[] MatchEmsprntmpl(EmsprntmplAggDO[] aggDOs, String Id_hp, String Sd_hptp, String paramUsageScope, int selectedIndex, String[] idors, String[] idpres);

        /// <summary>
        /// 校验是否全部退费医嘱
        /// </summary>
        /// <param name="idors"></param>
        /// <returns></returns>
        FBoolean CheckAllOrsBlRefound(String[] idors);
    }
}

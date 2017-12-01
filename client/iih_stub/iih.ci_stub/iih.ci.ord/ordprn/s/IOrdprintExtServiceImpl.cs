
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.iih.ci.ord.ordprn.i;
using xap.mw.serviceframework;
using xap.rui.appfw;
using iih.ci.ord.ordprn.d;
using iih.ci.ord.dto.ordprintdto.d;
using iih.ci.iih.ci.ord.dto.ordprintdto.d;
using xap.mw.coreitf.d;

namespace iih.ci.iih.ci.ord.ordprn.i
{
    /// <summary>
    /// <para>描    述 : </para>
    /// <para>说    明 : </para>
    /// <para>项目名称 :  iih.ci.iih.ci.ord.ordprn.s    </para>    
    /// <para>类 名 称 :  IOrdprintExtServiceImpl					</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/8/19 17:52:41</para>
    /// <para>更新时间 :  2016/8/19 17:52:41</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class IOrdprintExtServiceImpl : IOrdprintExtService
    {
        private string url = XapSvrConfig.BaseUrl + "iihci.ord/iih.ci.ord.ordprn.i.IOrdprintExtService";//ConfigUtil.getServiceUrl();


        private ServiceInvocation si;
        private CacheHelper<OrdPrintDO> ch;
        /// <summary>
        /// 构造函数
        /// </summary>
        public IOrdprintExtServiceImpl()
        {
            ch = new CacheHelper<OrdPrintDO>();
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 获取医嘱打印对象
        /// </summary>
        /// <returns></returns>
        public OrdPrintDataDTO[] GetOrdPrintDataDTOs(OrdPrintParamDTO paramDTO)
        {

            object[] param = new object[] { paramDTO };
            si.url = url;
            OrdPrintDataDTO[] rtn = si.invokeList<OrdPrintDataDTO>("getOrdPrintDataDTOs", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 获取已经打印的医嘱页码
        /// </summary>
        /// <param name="aggdos"></param>
        /// <returns></returns>
        public int[] GetPageNums(OrdPrintParamDTO paramDTO)
        {
            List<object> param = new List<object>();
            param.Add(paramDTO);
            si.url = url;
            int[] rtn = si.invokeList<int>("getPageNums", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 根据待打印作废医嘱，获取在已打印医嘱中所在页的数据
        /// </summary>
        /// <param name="paramDTO"></param>
        /// <param name="pageNums"></param>
        /// <returns></returns>
        public OrdPrintDO[] GetOrdPrintDOs(OrdPrintParamDTO paramDTO, OrdPrintDataDTO[] printDataDTOs)
        {
            List<object> param = new List<object>();
            param.Add(paramDTO);
            param.Add(printDataDTOs);
            si.url = url;
            OrdPrintDO[] rtn = si.invokeList<OrdPrintDO>("GetOrdPrintDOs", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 重整医嘱打印保存
        /// </summary>
        /// <param name="paramDTO"></param>
        /// <param name="ordPrintDOs">重整后保存的医嘱</param>
        /// <returns></returns>
        public OrdPrintDO[] SaveResetOrdPrintDOs(OrdPrintParamDTO paramDTO, OrdPrintDO[] ordPrintDOs)
        {
            List<object> param = new List<object>();
            param.Add(paramDTO);
            param.Add(ordPrintDOs);

            si.url = url;
            OrdPrintDO[] rtn = si.invokeList<OrdPrintDO>("SaveResetOrdPrintDOs", param.ToArray());
            return rtn;
        }

        public void DeleteOrdPrintDOs(OrdPrintDO[] ordPrintDOs)
        {
            List<object> param = new List<object>();
            param.Add(ordPrintDOs);
            si.url = url;
            si.invokeList<OrdPrintDO>("DeleteOrdPrintDOs", param.ToArray());  
        }
    }
}

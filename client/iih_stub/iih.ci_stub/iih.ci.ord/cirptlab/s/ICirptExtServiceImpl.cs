/* 文件头注释
======================================================================
* Filename: PaintToolKit
* Date: 2016-11-18 20:26:33
* Compiler: Visual Studio 2010
* Author: huang_junhao
* Company: Copyright 2016 by PKU healthcare IT Co.,Ltd.
* Description: 
======================================================================
*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.iih.ci.ord.cirptlab.i;
using iih.ci.ord.cirptlab.d;
using iih.ci.ord.cirptobs.d;
using iih.ci.ord.cirptpathgy.d;
using xap.mw.serviceframework;
using xap.rui.appfw;

namespace iih.ci.iih.ci.ord.cirptlab.i
{
    public class ICirptExtServiceImpl:ICirptExtService
    {
        private string url = XapSvrConfig.BaseUrl + "iihci.ord/iih.ci.ord.cirptlab.i.ICirptExtService";//ConfigUtil.getServiceUrl();

        
        private ServiceInvocation si;
        /// <summary>
        /// 构造函数
        /// </summary>
        public ICirptExtServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 检查报告结果录入
        /// </summary>
        /// <param name="ciRptObsDOs"></param>
        /// <returns></returns>
        public CiRptObsDO[] saveCiRptObsDO(CiRptObsDO[] ciRptObsDOs)
        {
            List<object> param = new List<object>();
            param.Add(ciRptObsDOs);
            si.url = url;
            CiRptObsDO[] rtn = si.invokeList<CiRptObsDO>("saveCiRptObsDO", param.ToArray());
         
            return rtn;
        }

        /// <summary>
        /// 检验报告结果录入
        /// </summary>
        /// <param name="cirptlabAggDOs"></param>
        /// <returns></returns>
        public CirptlabAggDO saveCirptlabAggDO(CirptlabAggDO cirptlabAggDOs)
        {
            List<object> param = new List<object>();
            param.Add(cirptlabAggDOs);
            si.url = url;
            CirptlabAggDO rtn = si.invoke<CirptlabAggDO>("saveCirptlabAggDO", param.ToArray());

            return rtn;
        }

        public CiRptPathgyDO[] saveCiRptPathgyDO(CiRptPathgyDO[] pathgyDOs)
        {
            List<object> param = new List<object>();
            param.Add(pathgyDOs);
            si.url = url;
            CiRptPathgyDO[] rtn = si.invokeList<CiRptPathgyDO>("saveCiRptPathgyDO", param.ToArray());

            return rtn;
        }
    }
}

/* 文件头注释
======================================================================
* Filename: PaintToolKit
* Date: 2016-11-18 20:22:34
* Compiler: Visual Studio 2010
* Author: huang_junhao
* Company: Copyright 2016 by PKU healthcare IT Co.,Ltd.
* Description: 检查、检验报告结果录入保存
======================================================================
*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.cirptlab.d;
using iih.ci.ord.cirptobs.d;
using iih.ci.ord.cirptpathgy.d;

namespace iih.ci.iih.ci.ord.cirptlab.i
{
    public interface ICirptExtService
    {
    
        CiRptObsDO[] saveCiRptObsDO(CiRptObsDO[] ciRptObsDOs);

        CirptlabAggDO saveCirptlabAggDO(CirptlabAggDO cirptlabAggDOs);

        CiRptPathgyDO[] saveCiRptPathgyDO(CiRptPathgyDO[] pathgyDOs);
    }
}

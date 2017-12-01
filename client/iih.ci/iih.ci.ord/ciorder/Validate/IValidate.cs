using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;

namespace iih.ci.ord.ciorder.Validate
{
    /// <summary>
    /// 业务验证累公共接口
    /// </summary>
    /// Author:admin
    /// Date:2015-12-23
   public interface IValidate
    {

       bool OrdValivate(EmsUIDTO uiDto,CiorderBaseControl ci);

    }
}


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.coreitf.d;

namespace iih.ci.ord.i
{
    /// <summary>
    /// <para>描    述 :  人员权限判断 			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.iih.ci.ord.i    </para>    
    /// <para>类 名 称 :  IPsnAuthorityCertifyService					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  YANG         				</para> 
    /// <para>修 改 人 :  YANG         				</para> 
    /// <para>创建时间 :  2017/5/22 14:33:36             </para>
    /// <para>更新时间 :  2017/5/22 14:33:36             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public interface IPsnAuthorityCertifyService
    {
        /// <summary>
        /// 人员处方权判断
        /// </summary>
        /// <param name="id_psn">人员ID</param>
        /// <returns></returns>
        FBoolean CertifyPsnPresAuthority(String id_psn);
    }
}

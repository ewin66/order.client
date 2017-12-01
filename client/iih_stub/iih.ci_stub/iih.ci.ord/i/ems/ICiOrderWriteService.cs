
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.dto.emsmain;

namespace iih.ci.ord.i.ems
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.iih.ci.ord.i.ems    </para>    
    /// <para>类 名 称 :  ICiOrderWriteService					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/7/3 16:21:08             </para>
    /// <para>更新时间 :  2017/7/3 16:21:08             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public interface ICiOrderWriteService
    {
        /// <summary>
        /// 删除医嘱
        /// </summary>
        /// <param name="arg"></param>
        /// <returns></returns>
        OrderRstDTO delete(OrderOperateDTO arg);
        /// <summary>
        /// 签署医嘱
        /// </summary>
        /// <param name="arg"></param>
        /// <returns></returns>
        OrderRstDTO sign(OrderOperateDTO arg);
        /// <summary>
        /// 撤回医嘱
        /// </summary>
        /// <param name="arg"></param>
        /// <returns></returns>
        OrderRstDTO revert(OrderOperateDTO arg);
        /// <summary>
        /// 作废医嘱
        /// </summary>
        /// <param name="arg"></param>
        /// <returns></returns>
        OrderRstDTO cancel(OrderOperateDTO arg);
        /// <summary>
        /// 拷贝医嘱
        /// </summary>
        /// <param name="arg"></param>
        /// <returns></returns>
        OrderRstDTO copy(OrderOperateDTO arg);
        /// <summary>
        /// 另存为医嘱
        /// </summary>
        /// <param name="arg"></param>
        /// <returns></returns>
        OrderRstDTO saveAs(OrderOperateDTO arg);
    }
}

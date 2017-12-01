
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;
using iih.ci.ord.i.ems;
using iih.ci.ord.dto.emsmain;

namespace iih.ci.ord.i.ems
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.iih.ci.ord.s.ems    </para>    
    /// <para>类 名 称 :  ICiOrderMainServiceImpl					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/7/3 16:28:48             </para>
    /// <para>更新时间 :  2017/7/3 16:28:48             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class ICiOrderMainServiceImpl : ICiOrderMainService
    {
        private readonly ServiceInvocation si;
        private readonly string url_r = XapSvrConfig.BaseUrl + "xap.ci.ord/iih.ci.ord.i.ems.ICiOrderMainService";

        /// <summary>
        /// 构造函数
        /// </summary>
        public ICiOrderMainServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url_r;
        }

        /// <summary>
        /// 加载医嘱
        /// </summary>
        /// <param name="ctx"></param>
        /// <returns></returns>
        public OrderRstDTO load(OrderOperateDTO arg)
        {
            return si.invoke<OrderRstDTO>("load", new object[] { arg });
        }
        /// <summary>
        /// 删除医嘱
        /// </summary>
        /// <param name="arg"></param>
        /// <returns></returns>
        public OrderRstDTO delete(OrderOperateDTO arg)
        {
            return si.invoke<OrderRstDTO>("delete", new object[] { arg });
        }
        /// <summary>
        /// 签署医嘱
        /// </summary>
        /// <param name="arg"></param>
        /// <returns></returns>
        public OrderRstDTO sign(OrderOperateDTO arg)
        {
            return si.invoke<OrderRstDTO>("sign", new object[] { arg });
        }
        /// <summary>
        /// 撤回医嘱
        /// </summary>
        /// <param name="arg"></param>
        /// <returns></returns>
        public OrderRstDTO revert(OrderOperateDTO arg)
        {
            return si.invoke<OrderRstDTO>("revert", new object[] { arg });
        }
        /// <summary>
        /// 作废医嘱
        /// </summary>
        /// <param name="arg"></param>
        /// <returns></returns>
        public OrderRstDTO cancel(OrderOperateDTO arg)
        {
            return si.invoke<OrderRstDTO>("cancel", new object[] { arg });
        }
        /// <summary>
        /// 拷贝医嘱
        /// </summary>
        /// <param name="arg"></param>
        /// <returns></returns>
        public OrderRstDTO copy(OrderOperateDTO arg)
        {
            return si.invoke<OrderRstDTO>("copy", new object[] { arg });
        }
        /// <summary>
        /// 另存为医嘱
        /// </summary>
        /// <param name="arg"></param>
        /// <returns></returns>
        public OrderRstDTO saveAs(OrderOperateDTO arg)
        {
            return si.invoke<OrderRstDTO>("saveAs", new object[] { arg });
        }
    }
}

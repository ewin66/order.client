
using System;
using System.Collections.Generic;
using iih.ci.ord.i.external;
using xap.mw.serviceframework;
using xap.mw.coreitf.d;

namespace iih.ci.ord.i.external
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.iih.ci.ord.s.external    </para>    
    /// <para>类 名 称 :  ICiOrdEnServiceImpl					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/10/26 17:13:28             </para>
    /// <para>更新时间 :  2017/10/26 17:13:28             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class ICiOrdEnServiceImpl : ICiOrdEnService
    {
        private readonly ServiceInvocation si;
        private readonly string url_r = XapSvrConfig.BaseUrl + "xap.ci.ord/iih.ci.ord.i.external.ICiOrdEnService";

        /// <summary>
        /// 构造函数
        /// </summary>
        public ICiOrdEnServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url_r;
        }

        /// <summary>
        /// 取消接诊校验是否存在有效医嘱
        /// </summary>
        /// <param name="id_en"></param>
        /// <param name="mode"></param>
        /// <returns></returns>
        public FBoolean IsExistValidOrders(String id_en, String mode)
        {
            object[] param = new object[] { id_en, mode };
            si.url = url_r;
            return si.invoke<FBoolean>("IsExistValidOrders", param);
        }

        /// <summary>
        /// 诊毕校验是否存在开立医嘱
        /// </summary>
        /// <param name="id_en"></param>
        /// <param name="mode"></param>
        /// <returns></returns>
        public FBoolean IsExistOpenOrders(String id_en)
        {
            object[] param = new object[] { id_en };
            si.url = url_r;
            return si.invoke<FBoolean>("IsExistOpenOrders", param);
        }
    }
}

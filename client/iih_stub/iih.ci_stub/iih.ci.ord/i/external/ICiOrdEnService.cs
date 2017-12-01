
using System;
using xap.mw.coreitf.d;

namespace iih.ci.ord.i.external
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.iih.ci.ord.i.external    </para>    
    /// <para>类 名 称 :  ICiOrdEnService					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/10/26 17:12:36             </para>
    /// <para>更新时间 :  2017/10/26 17:12:36             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public interface ICiOrdEnService
    {
        FBoolean IsExistValidOrders(String id_en, String mode);

        FBoolean IsExistOpenOrders(String id_en);
    }
}

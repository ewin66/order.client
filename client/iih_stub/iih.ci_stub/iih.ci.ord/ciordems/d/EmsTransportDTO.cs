
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.iih.ci.ord.ciordems.d
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.iih.ci.ord.ciordems.d    </para>    
    /// <para>类 名 称 :  EmsTransportDTO					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  vivi         				</para> 
    /// <para>修 改 人 :  vivi         				</para> 
    /// <para>创建时间 :  1/3/2017 8:30:28 PM             </para>
    /// <para>更新时间 :  1/3/2017 8:30:28 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class EmsTransportDTO : FMap2
    {
        public T GetData<T>(String pk, T def )
        {
            if (Keys.Contains(pk) && this[pk] is T)
                return (T)this[pk] ;
            return def;
        }
    }
}


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ems.d;
using System.Collections;

namespace iih.ci.ord.ciorder.utils
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.utils    </para>    
    /// <para>类 名 称 :  CiEmsSrvDTOComparer					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/10/25 11:51:15             </para>
    /// <para>更新时间 :  2016/10/25 11:51:15             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class CiEmsSrvDTOComparer :IComparer
    {
        public int Compare(object x, object y)
        {
            if (x is CiEmsSrvDTO && y is CiEmsSrvDTO)
            {
                return Comparer.Default.Compare((x as CiEmsSrvDTO).Sortno, (y as CiEmsSrvDTO).Sortno);  
            }
            else {
                throw new Exception(""); 
            }
        }
    }
}

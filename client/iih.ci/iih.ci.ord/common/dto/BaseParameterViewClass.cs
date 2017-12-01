
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine;

namespace iih.ci.ord.dto
{
	/// <summary>
	/// <para>描    述 :                     			</para>
	/// <para>说    明 :                     			</para>
	/// <para>项目名称 :  iih.ci.ord.base.dto    </para>    
	/// <para>类 名 称 :  BaseParameterViewClass					</para> 
	/// <para>版 本 号 :  v1.0.0.0           			</para> 
	/// <para>作    者 :  zhangwq         				</para> 
    /// <para>修 改 人 :  zhangwq         				</para> 
	/// <para>创建时间 :  2016/7/18 14:07:35             </para>
	/// <para>更新时间 :  2016/7/18 14:07:35             </para> 
	/// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
	/// </summary>
	public class BaseParameterViewClass
	{
        public BaseContext Context;

        public void setBaseContext(BaseContext Context) {
            this.Context = Context;
        }
	}
}

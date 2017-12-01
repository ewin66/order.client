using iih.ci.iih.ci.ord.opemergency.i.command;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.command
{
    /// <summary>
    /// <para>描    述 : 临床指南                    			</para>
    /// <para>说    明 :  助手                   			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.command    </para>    
    /// <para>类 名 称 :  OpClinicalGuideCommand					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  9/20/2016 2:27:11 PM             </para>
    /// <para>更新时间 :  9/20/2016 2:27:11 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OpClinicalGuideCommand : ICiCommand
    {
        public object exec(object param)
        {
            return null;
        }

        public string GetTitle()
        {
            return "临床指南";
        }
    }
}

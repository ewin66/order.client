
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.cli.sdk.render;
using xap.rui.control.forms.view;

namespace iih.ci.ord.opemergency.tool
{
    /// <summary>
    /// <para>描    述 :  表单工具类                   			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.tool    </para>    
    /// <para>类 名 称 :  AssXapFormUtils					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  wangqzh         				</para> 
    /// <para>修 改 人 :  wangqzh         				</para> 
    /// <para>创建时间 :  12/28/2016 5:09:29 PM             </para>
    /// <para>更新时间 :  12/28/2016 5:09:29 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class AssXapFormUtils
    {
        public static UserRender GetUserRender(XapFormControl formCtrl, String path)
        {
            if (String.IsNullOrEmpty(path)) {
                return null;
            }

            String [] szPath = path.Split('.');
            if (szPath.Length != 2) {
                return null;
            }

            return formCtrl.GetUserRender(szPath[0], szPath[1]);
        }
    }
}

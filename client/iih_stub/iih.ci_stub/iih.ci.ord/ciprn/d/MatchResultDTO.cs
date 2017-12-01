
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.ord.ciprn.d
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.iih.ci.ord.ciprn.d    </para>    
    /// <para>类 名 称 :  MatchResultDTO					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/10/10 10:43:33             </para>
    /// <para>更新时间 :  2017/10/10 10:43:33             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class MatchResultDTO : BaseDTO 
    {
        public MatchResultDTO()
        { }

        public string Tmplurl
        {
            get { return getAttrVal<string>("Tmplurl", null); }
            set { setAttrVal<string>("Tmplurl", value); }
        }

        public FArrayList Ids
        {
            get { return getAttrVal<FArrayList>("Ids", null); }
            set { setAttrVal<FArrayList>("Ids", value); }
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Tmplurl", "Ids"};
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciprn.d.MatchResultDTO";
        }
    }
}

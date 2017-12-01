using iih.bd.srv.medsrv.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.ems.common
{
    /// <summary>
    /// <para>描    述 :  医疗单创建参数定义                   			</para>
    /// <para>说    明 :  创建医疗单必要的参数设置                   			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ems.common    </para>    
    /// <para>类 名 称 :  EmsCreatedParameter					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  9/7/2016 2:29:31 PM             </para>
    /// <para>更新时间 :  9/7/2016 2:29:31 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmsCreatedParameter
    {
        // 参数名称标记
        public const String TAGKEY = "EmsCreatedParameter";
        public const String TAGKEYLIST = "EmsCreatedParameterList";
        // 参照服务
        private MedSrvDO medSrvDO;
        // 具体物品id
        private String mmID;

        private object parameter;
        public EmsCreatedParameter(MedSrvDO medSrvDO, String mmID, object param = null)
        {
            this.medSrvDO = medSrvDO;
            this.mmID = mmID;
            this.parameter = param;
        }
        public MedSrvDO getMedSrvDO() {
            return this.medSrvDO;
        }
        public String getMmID()
        {
            return this.mmID;
        }

        public Object GetParameter()
        {
            return this.parameter;
        }
    }
}

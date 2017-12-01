using iih.ci.ord.opemergency.view.basic;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.resource
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.view    </para>    
    /// <para>类 名 称 :  EmsFromResource					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  8/30/2016 8:40:40 PM             </para>
    /// <para>更新时间 :  8/30/2016 8:40:40 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmsFromResource : IEmsFormResource
    {
        public String FormIDs { get; set; }

        public String GFID { get; set; } // 通用服务列表
        public String WFID { get; set; } // 西成药选项卡 
        public String HFID { get; set; } // 草药选项卡
        public String LFID { get; set; } // 检验选项卡
        public String RFID { get; set; } // 检查选项卡
        public String TFID { get; set; } // 治疗选项卡
        public String BFID { get; set; } // 备血医疗单
        public String UFID { get; set; } // 用血医疗单
        public String OFID { get; set; } // 手术医疗单
        public String PFID { get; set; } // 病理-病情-既往-标本
        public String CFID { get; set; } // 会诊医疗单
        public String EFID { get; set; } // 费用视图
        

        public Dictionary<int, String> formIDMap = new Dictionary<int, string>();

        public EmsFromResource()
        {
            formIDMap.Clear();
        }

        public virtual String GetFromID(int emsType, object param = null)
        {
            return formIDMap.ContainsKey(emsType)?formIDMap[emsType]:null;
        }

        // 西药, 草药, 检查, 检验, 治疗, 备血, 用血, 手术, 病理, 会诊, 费用页签
        protected void HandleFormIDsInfo(String ids)
        {
            if (String.IsNullOrEmpty(ids))
                return;
            ids = ids.Trim(' ');
            if(ids.Length >0)
            {
                String[] szID = ids.Split(',');

                for(int i = 0; i <szID.Length; ++i)
                {
                    formIDMap.Add(i + 1, szID[i]);
                }
            }
            
        }
    }
}

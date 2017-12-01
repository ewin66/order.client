
using System;

namespace iih.ci.ord.opemergency.assi.entdi.viewmodel
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.entdi.viewmodel    </para>    
    /// <para>类 名 称 :  EntDiChronAssiViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/4/11 13:33:43             </para>
    /// <para>更新时间 :  2017/4/11 13:33:43             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class EntDiChronAssiViewModel : EntDiAssiViewModel
    {
        private string id_grp;
        private string id_org;

        public EntDiChronAssiViewModel(string id_grp, string id_org)
            : base()
        {
            this.id_grp = id_grp;
            this.id_org = id_org;
        }

        protected override string getSqlWhere()
        {
            string strSql = String.Format(" id_grp='{0}' and id_org='{1}' and fg_active='Y' and (fg_chronic='Y' or name like '%行动不便%')", this.id_grp, this.id_org);
            
            return strSql;
        }
    }
}


using System;
using System.Text;
using iih.bd.srv.diagdef.i;
using xap.mw.serviceframework;
using xap.rui.appfw;
using iih.bd.srv.diagdef.d;

namespace iih.ci.ord.opemergency.assi.entdi.viewmodel
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.entdi.viewmodel    </para>    
    /// <para>类 名 称 :  EntDiSpeciAssiViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/4/11 13:35:05             </para>
    /// <para>更新时间 :  2017/4/11 13:35:05             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class EntDiSpeciAssiViewModel : EntDiAssiViewModel
    {
        private string id_grp;
        private string id_org;

        public EntDiSpeciAssiViewModel(string id_grp, string id_org)
            : base()
        {
            this.id_grp = id_grp;
            this.id_org = id_org;
        }

        public override void LoadData()
        {
            string strFilter = "";
            foreach (var str in strParams)
                strFilter += String.Format("'{0}',", str);

            string strQuery = "";
            if (TxtQuery.Length > 0)
            {
                TxtQuery = TxtQuery.Replace("'", "@");
                strQuery += String.Format(" and (DI.code like '%{4}%' or DI.name like '%{0}%' or DI.wbcode like '%{1}%' or DI.pycode like '%{2}%' or DI.mnecode like '%{3}%')", TxtQuery, TxtQuery, TxtQuery, TxtQuery, TxtQuery);
            }

            IDiagdefExtService service = XapServiceMgr.find<IDiagdefExtService>();
            DiagDefDO[] dos = service.findDiagdefSpec(this.id_org, String.Format(" and DI.sd_cdsystp in ({0})", strFilter.Substring(0, strFilter.Length - 1)) + strQuery);
            diagDefDOs = new XapDataList<DiagDefDO>(diagdefMDOCrudService, dos);
        }
    }
}

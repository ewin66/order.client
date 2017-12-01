
using System;
using System.Collections.Generic;
using System.Linq;
using xap.mw.coreitf.d;
using iih.bd.srv.deptstd2diag.d;
using iih.bd.srv.deptstd2diag.i;
using xap.mw.serviceframework;
using iih.bd.srv.diagdef.d;
using xap.rui.appfw;

namespace iih.ci.ord.opemergency.assi.entdi.viewmodel
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.entdi.viewmodel    </para>    
    /// <para>类 名 称 :  EntDiDeptAssiViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/4/11 13:31:21             </para>
    /// <para>更新时间 :  2017/4/11 13:31:21             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class EntDiDeptAssiViewModel : EntDiAssiViewModel
    {
        private static IDeptstddiagCrudService deptstddiagCrudService = XapServiceMgr.find<IDeptstddiagCrudService>();
        private static IDepdiagcaCrudService depdiagcaCrudService = XapServiceMgr.find<IDepdiagcaCrudService>();

        private string id_grp;
        private string id_org;
        private string id_dep;

        public string Id_dicadep { get; set; }

        public DeptDiagCaDO[] DeptDiagCaDOs { get; set; }

        public EntDiDeptAssiViewModel(string id_grp, string id_org, string id_dep)
            : base()
        {
            this.id_grp = id_grp;
            this.id_org = id_org;
            this.id_dep = id_dep;

            loadDicadep();
        }
        
        public override void LoadData()
        {
            DiagDefDO[] dos;
            List<string> ids = getIds();
            if (TxtQuery.Length > 0 && ids.Count > 0)
            {
                TxtQuery = TxtQuery.Replace("'","@"); 
                string strIds = "";
                ids.ForEach(p => { strIds += "'" + p + "',"; });

                dos = diagdefMDOCrudService.find(String.Format(" id_didef in ({0}) and (code like '%{1}%' or name like '%{2}%' or wbcode like '%{3}%' or pycode like '%{4}%' or mnecode like '%{5}%')", 
                    strIds.Substring(0, strIds.Length - 1), TxtQuery, TxtQuery, TxtQuery, TxtQuery, TxtQuery), "", FBoolean.False);
            }
            else
                dos = diagdefMDOCrudService.findByBIds(ids.ToArray(), FBoolean.False);

            diagDefDOs = new XapDataList<DiagDefDO>(diagdefMDOCrudService, dos);
        }

        protected override string getSqlWhere()
        {
            string strSql = String.Format(" id_grp='{0}' and id_org='{1}' and id_dep='{2}'", this.id_grp, this.id_org, this.id_dep);
            if (Id_dicadep != null && Id_dicadep.Length > 0 && !Id_dicadep.Equals("~"))
                strSql += String.Format(" and id_dicadep='{0}'", this.Id_dicadep);

            return strSql;
        }

        private List<string> getIds()
        {
            DeptStdDiagDO[] deptStdDiagDOs = deptstddiagCrudService.find(getSqlWhere(), "", FBoolean.False);
            List<string> lstIds = new List<string>();
            if (deptStdDiagDOs != null && deptStdDiagDOs.Length > 0)
            {
                deptStdDiagDOs.ToList<DeptStdDiagDO>().ForEach(p =>
                {
                    if (p.Id_didef != null)
                    {
                        lstIds.Add(p.Id_didef);
                    }
                });
            }
            return lstIds;
        }

        private void loadDicadep()
        {
            DeptDiagCaDOs = depdiagcaCrudService.find(String.Format(" id_grp='{0}' and id_org='{1}' and id_dep='{2}'", 
                this.id_grp, this.id_org, this.id_dep), "code", FBoolean.False);
        }
    }
}

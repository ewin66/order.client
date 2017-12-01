using System.Linq;
using iih.bd.srv.deptstd2diag.i;
using iih.bd.srv.deptstd2diag.d;
using xap.rui.appfw;
using xap.mw.serviceframework;
using xap.mw.core.data;
using xap.rui.appfw.attributes;
using System.Collections.Generic;

namespace iih.ci.ord.opemergency.orddi.model
{
    /************************************************************************
     科室常用诊断数据模型
    ************************************************************************/
    class DiAssListViewModel
    {

         private IDeptstddiagCrudService deptDiagDOService;
         private IDepdiagcaCrudService deptDiagCaDOService;

         private DeptDiagCaDO[] szDeptDiagCaDO = new DeptDiagCaDO[]{};

         [FormData(TabCode = "diagca")]
         public DeptDiagCaDO deptDiagCaDO{get;set;}

         [FormData(TabCode ="deptditable")]
         public XapPageList<DeptStdDiagDO> deptStdDiagDOList { get; set; }

         public DeptDiagCaDO[] DeptDiagCaArray { get { return szDeptDiagCaDO; } }

        

        public DiAssListViewModel()
         {
                 // 建立诊断分类卡 模型
                 this.deptDiagCaDO = new DeptDiagCaDO();

                 // 查询表单数据
                 this.deptDiagCaDOService = XapServiceMgr.find<IDepdiagcaCrudService>();
                 this.deptDiagDOService = XapServiceMgr.find<IDeptstddiagCrudService>();
         }

        public void Reload(string id_dep,string id_dica)
        {
            if (!string.IsNullOrEmpty(id_dep))
            {
                this.szDeptDiagCaDO = this.deptDiagCaDOService.find(string.Format("id_dep='{0}'",id_dep), "", false);

                this.execQueryWith(id_dep,id_dica);
            }
        }

        public void execQueryWith(string id_dep, string id_dica)
        {
            XapPageList<DeptStdDiagDO> ds = null;
            // ~ 表示查询所有数据
            if (id_dica == null||id_dica == "~")
            {
                string filter = string.Format("id_dep = '{0}'", id_dep);
                PageInfo<DeptStdDiagDO> info = new PageInfo<DeptStdDiagDO>(filter, "id_didep", 20, true);
                ds = new XapPageList<DeptStdDiagDO>(info, this.deptDiagDOService);
            }
            else
            {
                string filter = string.Format("id_dep = '{0}' and id_dicadep = '{1}'", id_dep, id_dica);
                PageInfo<DeptStdDiagDO> info = new PageInfo<DeptStdDiagDO>(filter, "id_didep", 20, true);
                ds = new XapPageList<DeptStdDiagDO>(info, this.deptDiagDOService);
            }

            // 如果模型存储为空，则直接复制
            //if (this.deptStdDiagDOList == null)
            {
                this.deptStdDiagDOList = ds;
            }
            //else
            //{
            //    this.deptStdDiagDOList.Clear();
            //    ds.ToList().ForEach(p => {
            //        this.deptStdDiagDOList.Add(p);
            //    });
            //}
            
        }

    }
}

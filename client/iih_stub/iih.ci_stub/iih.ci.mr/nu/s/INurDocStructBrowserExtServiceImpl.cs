using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mr.nu.dto.d;
using xap.mw.core.data;
using xap.mw.serviceframework;

namespace iih.ci.iih.ci.mr.nu.i
{
    public class INurDocStructBrowserExtServiceImpl : INurDocStructBrowserExtService
    {
        private string url = XapSvrConfig.BaseUrl + "iihci.mr/iih.ci.mr.nu.i.INurDocStructBrowserExtService";//ConfigUtil.getServiceUrl();
        private ServiceInvocation si;

        /// <summary>
        /// 构造函数
        /// </summary>
        public INurDocStructBrowserExtServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 查询医疗记录类型自定义分类和医疗记录类型组成的树
        /// </summary>
        /// <returns></returns>
        public NurDocStructTreeDTO[] getNurDocStructTreeDTOs()
        {
            List<object> param = new List<object>();
            si.url = url;
            return si.invokeList<NurDocStructTreeDTO>("getNurDocStructTreeDTOs",param);
        }

        /// <summary>
        /// 查询结构化浏览器医疗记录列表数据
        /// </summary>
        /// <param name="id">医疗记录类型自定义分类ID 或者医疗记录类型ID</param>
        /// <param name="id_dep_nur">住院病区ID</param>
        /// <param name="id_bed">住院床号ID</param>
        /// <returns></returns>
        public PagingRtnData<NurDocStructGridDTO> getNurDocStructGridDTOs(PaginationInfo pg, String id, String id_dep_nur, String id_bed)
        {
            List<object> param = new List<object>();
            param.Add(pg);
            param.Add(id);
            param.Add(id_dep_nur);
            param.Add(id_bed);
            si.url = url;
            return si.invokePaging<NurDocStructGridDTO>("getNurDocStructGridDTOs", param.ToArray());

        }

        /// <summary>
        /// 查询数据组相关属性
        /// </summary>
        /// <param name="id_mrdg">数据组id</param>
        /// <returns></returns>
        public NurDocStructDGDTO getNurDocStructDGDTO(String id_mrdg)
        {
            List<object> param = new List<object>();
            param.Add(id_mrdg);
            si.url = url;
            return si.invoke<NurDocStructDGDTO>("getNurDocStructDGDTO", param);

        }

        /// <summary>
        ///查询数据元相关属性以及父数据组属性
        /// </summary>
        /// <param name="id_mrde">数据元ID</param>
        /// <returns></returns>
        public NurDocStructDEDTO getNurDocStructDEDTO(String id_mrde)
        {
            List<object> param = new List<object>();
            param.Add(id_mrde);
            si.url = url;
            return si.invoke<NurDocStructDEDTO>("getNurDocStructDEDTO", param);

        }

        /// <summary>
        ///查询数据生成结构化树
        /// </summary>
        /// <param name="id_mr">ID</param>
        /// <returns></returns>
        public StructTreeDTO[] getStructTreeDTO(String id_mr)
        {
            List<object> param = new List<object>();
            param.Add(id_mr);
            si.url = url;
            return si.invokeList<StructTreeDTO>("getStructTreeDTO", param);

        }


    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mr.nu.dto.d;
using xap.mw.core.data;

namespace iih.ci.iih.ci.mr.nu.i
{
    public interface INurDocStructBrowserExtService
    {
        /// <summary>
        /// 查询医疗记录类型自定义分类和医疗记录类型组成的树
        /// </summary>
        /// <returns></returns>
        NurDocStructTreeDTO[] getNurDocStructTreeDTOs();

        /// <summary>
        /// 查询结构化浏览器医疗记录列表数据
        /// </summary>
        /// <param name="id">医疗记录类型自定义分类ID 或者医疗记录类型ID</param>
        /// <param name="id_dep_nur">住院病区ID</param>
        /// <param name="id_bed">住院床号ID</param>
        /// <returns></returns>
        PagingRtnData<NurDocStructGridDTO> getNurDocStructGridDTOs(PaginationInfo pg,String id, String id_dep_nur, String id_bed);

        /// <summary>
        /// 查询数据组相关属性
        /// </summary>
        /// <param name="id_mrdg">数据组id</param>
        /// <returns></returns>
        NurDocStructDGDTO getNurDocStructDGDTO(String id_mrdg);

        /// <summary>
        ///查询数据元相关属性以及父数据组属性
        /// </summary>
        /// <param name="id_mrde">数据元ID</param>
        /// <returns></returns>
        NurDocStructDEDTO getNurDocStructDEDTO(String id_mrde);

        /// <summary>
        ///查询数据生成结构化树
        /// </summary>
        /// <param name="id_mr">ID</param>
        /// <returns></returns>
        StructTreeDTO[] getStructTreeDTO(String id_mr);
    }
}

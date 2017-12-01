
using System;
using iih.bd.srv.ortpl.d;
using iih.bd.srv.ortpl.dto;
using iih.ci.iih.ci.ord.dto.newordertemplatedto.d;
using iih.ci.ord.ems.d;

namespace iih.ci.ord.i.ortmpl
{
    /// <summary>
    /// <para>描    述 :  医嘱模板加载服务接口			</para>
    /// <para>说    明 :  医嘱模板加载服务接口   			</para>
    /// <para>项目名称 :  iih.ci.ord.i.ortmpl    </para>    
    /// <para>类 名 称 :  IOrTmplApplyService					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Young         				</para> 
    /// <para>修 改 人 :  Young         				</para> 
    /// <para>创建时间 :  2017/10/19 15:16:39             </para>
    /// <para>更新时间 :  2017/10/19 15:16:39             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public interface IOrTmplApplyService
    {
        /// <summary>
        /// 查询医嘱模板分类
        /// </summary>
        /// <param name="id_grp"></param>
        /// <param name="id_org"></param>
        /// <param name="id_dep"></param>
        /// <param name="id_emp"></param>
        /// <param name="sd_ortmpltp"></param>
        /// <returns></returns>
        OrTmplCaDO[] getOrTmplCaDOs(String id_grp, String id_org, String id_dep, String id_emp, String sd_ortmpltp);
	
        /// <summary>
        /// 查询医嘱模板
        /// </summary>
        /// <param name="id_ortmplca"></param>
        /// <param name="sd_ortmpltp"></param>
        /// <returns></returns>
        OrTmplDTO[] getOrTmplDTOs(String id_ortmplca,String sd_ortmpltp);

        /// <summary>
        /// 查询模板明细
        /// </summary>
        /// <param name="id_ortmpl"></param>
        /// <returns></returns>
        OrTplNItmDO[] getOrTplNItmDOs(String id_ortmpl);

        /// <summary>
        /// 查询模板明细
        /// </summary>
        /// <param name="id_ortmpl"></param>
        /// <param name="ctx"></param>
        /// <returns></returns>
        OrderTemplateRstDTO getOrTemplateCache(String[] id_ortmpl, CiEnContextDTO ctx);
    }
}

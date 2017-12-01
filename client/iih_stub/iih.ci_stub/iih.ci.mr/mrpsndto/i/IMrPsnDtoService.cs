using iih.ci.mr.mrpsndto.d;

namespace iih.ci.mr.mrpsndto.i
{
    public interface IMrPsnDtoService
    {
        /// <summary>
        /// 根据当前科室 查询上级查房医师 的 DTO数据
        /// </summary>
        /// <param name="idDep">当前科室</param>
        /// <returns></returns>
        MrPsnDTO[] GetMrPsnDtos(string idDep);

        /// <summary>
        /// 获取当前患者主治及主任医师
        /// </summary>
        /// <param name="strWhere"></param>
        /// <returns></returns>
        MrPsnDTO[] getMrPsnDtosWhere(string strWhere);
    }
}

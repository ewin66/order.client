using System.Collections.Generic;
using iih.ci.mr.mrpsndto.d;
using iih.ci.mr.mrpsndto.i;
using xap.mw.serviceframework;

namespace iih.ci.mr.mrpsndto.i
{
    public class IMrPsnDtoServiceImpl : IMrPsnDtoService
    {
        /// <summary>
        /// 接口地址
        /// </summary>
        private string url = XapSvrConfig.BaseUrl + "iihci.mr/iih.ci.mr.mrpsndto.i.IMrPsnDtoService";
        /// <summary>
        /// 调接口服务
        /// </summary>
        private ServiceInvocation si;

        /// <summary>
        /// 构造函数 
        /// 初始化数据
        /// </summary>
        public IMrPsnDtoServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 根据当前科室 选择上级查房医师 人员 
        /// </summary>
        /// <param name="idDep">当前登录科室</param>
        /// <returns></returns>
        public MrPsnDTO[] GetMrPsnDtos(string idDep)
        {
            List<object> ps = new List<object>();
            ps.Add(idDep);
            MrPsnDTO[] rt = si.invokeList<MrPsnDTO>("getMrPsnDtos", ps.ToArray());
            return rt;
        }

        /// <summary>
        /// 根据当前科室 选择上级查房医师 人员 
        /// </summary>
        /// <param name="idDep">当前登录科室</param>
        /// <returns></returns>
        public MrPsnDTO[] getMrPsnDtosWhere(string strWhere)
        {
            List<object> ps = new List<object>();
            ps.Add(strWhere);
            MrPsnDTO[] rt = si.invokeList<MrPsnDTO>("getMrPsnDtosWhere", ps.ToArray());
            return rt;
        }
    }
}

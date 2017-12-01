using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;
using iih.ci.pre.dto.d;
using iih.en.pv.dto.d;

namespace iih.ci.pre.stub.obspre.i
{
    /// <summary>
    /// 预检扩展服务
    /// </summary>
    public class IObsPreExtServiceImpl : IObsPreExtService
    {
        private string url = XapSvrConfig.BaseUrl + "iih.ci.pre/iih.ci.pre.obspre.i.IObsPreExtService";
        private ServiceInvocation si;
        public IObsPreExtServiceImpl() 
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }
        /// <summary>
        /// 获取预检模板
        /// </summary>
        /// <param name="entpCode">就诊类型</param>
        /// <param name="depId">科室id	</param>
        /// <returns></returns>
        public EmergPreDTO GetPreTpl(String entpCode, String depId) 
        {
            List<object> param = new List<object>();
            param.Add(entpCode);
            param.Add(depId);

            EmergPreDTO rtn = si.invoke<EmergPreDTO>("getPreTpl", param.ToArray());
            return rtn;
        }
        /// <summary>
        /// 加载预检数据
        /// </summary>
        /// <param name="preDTO">预检模板</param>
        /// <returns></returns>
        public EmergPreDTO LoadData(EmergPreDTO preDTO) 
        {
            List<object> param = new List<object>();
            param.Add(preDTO);

            EmergPreDTO rtn = si.invoke<EmergPreDTO>("loadData", param.ToArray());
            return rtn;
        }
        /// <summary>
        /// 获取预检信息
        /// </summary>
        /// <param name="entId">就诊登记DTO</param>
        /// <param name="entpCode">就诊类型</param>
        /// <returns></returns>
        public EmergPreDTO GetPreDTO(OpRegDTO opRegDTO, String entpCode) 
        {
            List<object> param = new List<object>();param.Add(opRegDTO);
            param.Add(entpCode);
            EmergPreDTO rtn = si.invoke<EmergPreDTO>("getPreDTO", param.ToArray());
            return rtn;
        }
        /// <summary>
        /// 保存预检信息
        /// </summary>
        /// <param name="preDTO"></param>
        /// <returns></returns>
        public EmergPreDTO SavePre(EmergPreDTO preDTO, String entpCode)
        {
            List<object> param = new List<object>();
            param.Add(preDTO);
            param.Add(entpCode);

            EmergPreDTO rtn = si.invoke<EmergPreDTO>("savePre", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 打开门诊预检Dialog
        /// <param name="parentForm">父窗口</param>
        /// </summary>
        public void ShowOpPreDialog(Object parentForm = null)
        {

        }
    }
}

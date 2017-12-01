using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.pre.dto.d;
using iih.en.pv.dto.d;

namespace iih.ci.pre.stub.obspre.i
{
    /// <summary>
    /// 预检扩展服务
    /// </summary>
    public interface IObsPreExtService
    {
        /// <summary>
        /// 获取预检模板
        /// </summary>
        /// <param name="entpCode">就诊类型</param>
        /// <param name="depId">科室id	</param>
        /// <returns></returns>
        EmergPreDTO GetPreTpl(String entpCode, String depId);
        /// <summary>
        /// 加载预检数据
        /// </summary>
        /// <param name="preDTO">预检模板</param>
        /// <returns></returns>
        EmergPreDTO LoadData(EmergPreDTO preDTO);
        /// <summary>
        /// 获取预检信息
        /// </summary>
        /// <param name="entId">就诊登记DTO</param>
        /// <param name="entpCode">就诊类型</param>
        /// <returns></returns>
        EmergPreDTO GetPreDTO(OpRegDTO opRegDTO, String entpCode);
        /// <summary>
        /// 保存预检信息
        /// </summary>
        /// <param name="preDTO"></param>
        /// <param name="entpCode">就诊类型</param>
        /// <returns></returns>
        EmergPreDTO SavePre(EmergPreDTO preDTO, String entpCode);
        /// <summary>
        /// 打开门诊预检Dialog
        /// <param name="parentForm">父窗口</param>
        /// </summary>
        void ShowOpPreDialog(Object parentForm=null);
    }
}

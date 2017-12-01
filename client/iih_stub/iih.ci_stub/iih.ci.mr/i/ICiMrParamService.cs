using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.mr.i
{
    public interface ICiMrParamService
    {
        /// <summary>
        /// 获取编辑器配置参数
        /// </summary>
        /// <returns></returns>
        string GetEditorConfig(string id_org);

        /// <summary>
        /// 获取门诊病历保存时是否判断必填项标识
        /// </summary>
        /// <param name="id_org"></param>
        /// <returns></returns>
        bool GetCiMrRequiredField(String id_org);

       /// <summary>
         /// 获取门诊病历保存时是否判断互斥项标识
       /// </summary>
       /// <param name="id_org"></param>
       /// <returns></returns>
         bool GetCiMrMutexField(String id_org);

        /// <summary>
        /// 获取门诊病历打印时是否预览
        /// </summary>
        /// <param name="id_org"></param>
        /// <returns></returns>
         bool GetSysParamCiMrPrintPreView(String id_org);
    }
}

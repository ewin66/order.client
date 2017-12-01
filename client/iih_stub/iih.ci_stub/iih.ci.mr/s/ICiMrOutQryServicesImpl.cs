using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.iih.ci.mr.i;
using xap.mw.serviceframework;
using xap.mw.core.data;

namespace iih.ci.mr.i
{
    public class ICiMrOutQryServicesImpl : ICiMrOutQryServices
    {
        /// <summary>
        /// 接口地址
        /// </summary>
        private string url = XapSvrConfig.BaseUrl + "iihci.mr/iih.ci.mr.i.ICiMrOutQryServices";
        /// <summary>
        /// 调接口服务
        /// </summary>
        private ServiceInvocation si;

        /// <summary>
        /// 构造函数 
        /// 初始化数据
        /// </summary>
        public ICiMrOutQryServicesImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 根据就诊号获取现病史，如果没有数据则返回""
        /// </summary>
        /// <param name="idEnt"></param>
        /// <returns></returns>
        public string GetCiMrHistoryOfPresentIllness(string idEnt)
        {
            List<object> param = new List<object>();
            si.url = url;
            param.Add(idEnt);
            string result = si.invoke<string>("getCiMrHistoryOfPresentIllness", param.ToArray());

            return result;
        }

        /// <summary>
        /// 根据就诊号获取最后一次病程FMap，如果没有数据则返回new FMap()
        /// </summary>
        /// <param name="idEnt"></param>
        /// <param name="isFirst"></param>
        /// <returns></returns>
        public xap.mw.core.data.FMap2 GetCiMrCourseOfLastDisease(string idEnt, xap.mw.coreitf.d.FBoolean isFirst)
        {
            List<object> param = new List<object>();
            si.url = url;
            param.Add(idEnt);
            param.Add(isFirst);
            FMap2 result = si.invoke<FMap2>("getCiMrCourseOfLastDisease", param.ToArray());

            return result;
        }

        /// <summary>
        /// 根据就诊号获取所有门诊病历
        /// </summary>
        /// <param name="strIdEnts"></param>
        /// <returns></returns>
        public xap.mw.core.data.FMap2 GetOPCiMrByIdEnts(string[] strIdEnts)
        {
            List<object> param = new List<object>();
            si.url = url;
            param.Add(strIdEnts);
            FMap2 result = si.invoke<FMap2>("getOPCiMrByIdEnts", param.ToArray());

            return result;
        }
    }
}

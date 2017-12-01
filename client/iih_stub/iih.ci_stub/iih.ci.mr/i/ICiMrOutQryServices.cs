using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.coreitf.d;
using xap.mw.core.data;

namespace iih.ci.mr.i
{
    public interface ICiMrOutQryServices
    {
        /// <summary>
        /// 根据就诊号获取现病史，如果没有数据则返回""
        /// </summary>
        /// <param name="idEnt"></param>
        /// <returns></returns>
        String GetCiMrHistoryOfPresentIllness(String idEnt);

        /// <summary>
        /// 根据就诊号获取最后一次病程FMap，如果没有数据则返回new FMap()
        /// </summary>
        /// <param name="idEnt"></param>
        /// <param name="isFirst"></param>
        /// <returns></returns>
        FMap2 GetCiMrCourseOfLastDisease(String idEnt, FBoolean isFirst);

        /// <summary>
        /// 根据就诊号获取所有门诊病历
        /// </summary>
        /// <param name="strIdEnts"></param>
        /// <returns></returns>
        FMap2 GetOPCiMrByIdEnts(String[] strIdEnts);
    }
}

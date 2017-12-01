
using iih.ci.ord.ciorder.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;
using xap.rui.appfw;
using iih.ci.ord.ems.d;
using xap.mw.core.data;

namespace iih.ci.iih.ci.ord.i
{
    /// <summary>
    /// <para>描    述 :  </para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.iih.ci.ord.s</para>    
    /// <para>类 名 称 :  ICiOrdMedicalInsuranceServiceImpl</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2017/10/17 19:36:38</para>
    /// <para>更新时间 :  2017/10/17 19:36:38</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class ICiOrdMedicalInsuranceServiceImpl : ICiOrdMedicalInsuranceService
    {
        private readonly ServiceInvocation si;

        private readonly string url_r = XapSvrConfig.BaseUrl + "xap.ci.ord/iih.ci.ord.i.ICiOrdMedicalInsuranceService";
        

        private CacheHelper<CiorderAggDO> ch;

        public ICiOrdMedicalInsuranceServiceImpl()
        {
            ch = new CacheHelper<CiorderAggDO>();
            si = new ServiceInvocationImpl();
            si.url = url_r;
        }

        /// <summary>
        /// 获取特殊病判断结果
        /// </summary>
        /// <param name="ctx">就诊环境</param>
        /// <param name="id_mms">物品id数组</param>
        /// <returns></returns>
        public FMap GetSpecialDiseaseJudgeRstMap(CiEnContextDTO ctx, string[] id_mms)
        {
            object[] param = { ctx, id_mms};
            si.url = url_r;
            FMap rtn = si.invoke<FMap>("getSpecialDiseaseJudgeRstMap", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 获取特殊病判断结果
        /// </summary>
        /// <param name="ctx">就诊环境</param>
        /// <param name="mmMap">物品对象集合key 物品id ，value 物品名称</param>
        /// <returns>医保特殊病判断结果信息</returns>
        public string GetSpecialDiseaseJudgeRst(CiEnContextDTO ctx, FMap mmMap)
        {
            object[] param = { ctx, mmMap };
            si.url = url_r;
            string rtn = si.invoke<string>("getSpecialDiseaseJudgeRst", param.ToArray());
            return rtn;
        }
    }
}

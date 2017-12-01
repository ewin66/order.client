
using iih.ci.ord.ems.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.iih.ci.ord.i
{
    /// <summary>
    /// <para>描    述 :  医保相关服务接口</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.iih.ci.ord.i</para>    
    /// <para>类 名 称 :  ICiOrdMedicalInsuranceService</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2017/10/17 19:34:54</para>
    /// <para>更新时间 :  2017/10/17 19:34:54</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public interface ICiOrdMedicalInsuranceService
    {
        /// <summary>
        /// 获取特殊病判断结果
        /// </summary>
        /// <param name="ctx">就诊环境</param>
        /// <param name="id_mms">物品id数组</param>
        /// <returns>key: 物品id，value：特殊病物品对应的诊断集合</returns>
        FMap GetSpecialDiseaseJudgeRstMap(CiEnContextDTO ctx,string[] id_mms);

        /// <summary>
        /// 获取特殊病判断结果
        /// </summary>
        /// <param name="ctx">就诊环境</param>
        /// <param name="mmMap">物品对象集合key 物品id ，value 物品名称</param>
        /// <returns>医保特殊病判断结果信息</returns>
        string GetSpecialDiseaseJudgeRst(CiEnContextDTO ctx, FMap mmMap);

    }
}

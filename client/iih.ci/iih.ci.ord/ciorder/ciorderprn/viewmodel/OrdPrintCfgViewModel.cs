
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.coreitf.d;
using iih.ci.ord.ordprn.d;

namespace iih.ci.ord.ciorder.ciorderprn.viewmodel
{
    /// <summary>
    /// <para>描    述 : 医嘱打印配置服务</para>
    /// <para>说    明 : </para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.ciorderprn.viewmodel    </para>    
    /// <para>类 名 称 :  OrdPrintCfgViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/8/18 17:13:40</para>
    /// <para>更新时间 :  2016/8/18 17:13:40</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OrdPrintCfgViewModel
    {

        /// <summary>
        /// 跨科室、病区是否使用新页面
        /// </summary>
        /// <returns></returns>
        public bool IsUseNewDeptPage() {

            // 跨科室、病区是否使用新页面
            return false;
        }

        /// <summary>
        /// 获取每页打印的记录数
        /// </summary>
        /// <returns></returns>
        public int GetPageRowCnt()
        {

            return 25;
        }

        /// <summary>
        /// 是否打印签字人信息
        /// </summary>
        /// <returns></returns>
        public bool IsPrintSignatory()
        {
            return true;
        }

        /// <summary>
        /// 获取重整行内容
        /// </summary>
        /// <param name="fgLong">长临标识</param>
        /// <param name="codeEntp">就诊类型</param>
        /// <returns></returns>
        public string GetResetRowContent(FBoolean fgLong)
        {
            return "以下为重整内容" + DateTime.Now.ToString();
        }

        /// <summary>
        /// 格式化医嘱打印内容字符串
        /// </summary>
        /// <param name="fgLong">长临标识</param>
        /// <param name="srvtp">服务类型</param>
        /// <returns></returns>
        public string GetRenderStr(FBoolean fgLong, string srvtp) 
        {
            string renderStr = null;
            String subSrvtp = srvtp.Substring(0, 2);
            string key = subSrvtp + fgLong.ToString();
            if ("01".Equals(subSrvtp))
            {
                switch (fgLong.Value)
                {
                    case true:
                        renderStr = "{{:Name_srv}}（{{:Name_mm}}）（{{:Quan_medu}}{{:Medu_name}}） {{:Route_name}} {{:Freq_name}}";
                        break;
                    default:
                        renderStr = "{{:Name_srv}}（{{:Name_mm}}）（{{:Quan_medu}}{{:Medu_name}}） {{:Route_name}}";
                        break;
                }
            }
            else {
                switch (fgLong.Value)
                {
                    case true:
                        renderStr = "{{:Name_srv}} {{:freq_name}}";
                        break;
                    default:
                        renderStr = "{{:Name_srv}}";
                        break;
                }
            }

            return renderStr;
        }

        /// <summary>
        /// 获取打印机偏移量X/Y(mm)
        /// </summary>
        /// <returns></returns>
        public float[] GetPrtOffset()
        {
            return new float[] { 6.0F, 6.0F };
        }
    }
}

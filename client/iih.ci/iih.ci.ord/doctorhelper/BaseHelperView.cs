
using iih.bd.bc.udi;
using iih.ci.ord.ems.d;
using iih.en.pv.dto.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.control.basecontrol;

namespace iih.ci.ord.doctorhelper
{
    /// <summary>
    /// <para>描    述 :  医嘱模板、以及常规、服务分类基类</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.doctorhelper</para>    
    /// <para>类 名 称 :  BaseHelperView</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2017/2/20 17:34:25</para>
    /// <para>更新时间 :  2017/2/20 17:34:25</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class BaseHelperView : XapListControl
    {
        /// <summary>
        /// 就诊类型与可使用标识对应关系
        /// </summary>
        private Dictionary<string, string> FgUseDic = new Dictionary<string, string>
        {
            {BdFcDictCodeConst.SD_CODE_ENTP_OP,"Fg_use_op"}, //门诊
            { BdFcDictCodeConst.SD_CODE_ENTP_IP,"Fg_use_ip"},//住院
            { BdFcDictCodeConst.SD_CODE_ENTP_ET,"Fg_use_er"},//急诊
            { BdFcDictCodeConst.SD_CODE_ENTP_PE,"Fg_use_pe"},//体检
            { BdFcDictCodeConst.SD_CODE_ENTP_FA,"Fg_use_fm"}//家庭病床
        };

        /// <summary>
        /// 当前患者接诊信息
        /// </summary>
        public Ent4BannerDTO Ent4BannerDTO { get; set; }

        /// <summary>
        /// 当前上下文就诊环境，ciEnContext包含Ent4BannerDTO对象
        /// </summary>
        public CiEnContextDTO ciEnContext { get; set; }


        /// <summary>
        /// 获取就诊类型对应的可使用标识字段
        /// </summary>
        /// <returns></returns>        
        protected string FgUse
        {
            get
            {
                string code_entp = Ent4BannerDTO.Code_entp;
                return FgUseDic[code_entp];
            }
        }       

    }
}

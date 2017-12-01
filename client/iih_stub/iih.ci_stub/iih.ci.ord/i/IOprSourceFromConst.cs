using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.iih.ci.ord.i
{
    public static class IOprSourceFromConst
    {

        /// <summary>
        /// 标识当前接口发送的操作数据为基于医疗单的信息
        /// </summary>
        public const  String IOSF_EMS="01"; // 医疗单

        /// <summary>
        /// 助手操作
        /// </summary>
        public const String IOSF_HLP="10"; //助手

        /// <summary>
        /// 模板操作
        /// </summary>
        public const String IOSF_HLP_TMPL="11"; //模板助手

        /// <summary>
        /// 医技操作
        /// </summary>
        public const String IOSF_HLP_MEDTECTH="12"; //医技助手

        /// <summary>
        /// 服务分类操作
        /// </summary>
        public const String IOSF_HLP_SRVCA="13"; //服务分类助手

        /// <summary>
        /// 就诊历史操作
        /// </summary>
        public const String IOSF_HLP_HIS="14"; //就诊历史助手

        /// <summary>
        /// 门诊组套操作
        /// </summary>
        public const String IOSF_HLP_GRP="15"; //门诊组套操作
	
}
}

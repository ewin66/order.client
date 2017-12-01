using System;

namespace iih.ci.mrqc.i
{
    public interface ICiMrQcParamService
    {
        /// <summary>
        /// 获取门诊病历召回最大申请天数
        /// </summary>
        /// <param name="id_org"></param>
        /// <returns></returns>
        string GetSysParamOpRcMaxDays(String id_org);

     /**
	 * 
	 * @param id_org
	 * @return 门诊病历召回默认时间
	 * @throws BizException
	 */
	string GetSysParamOpRcDefaultDays(String id_org) ;
    }
}

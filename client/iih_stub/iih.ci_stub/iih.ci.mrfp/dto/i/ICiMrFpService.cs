
using System;
using iih.en.pv.dto.d;
using iih.pi.reg.dto.d;

namespace iih.ci.mrfp.dto.i
{
    public interface ICiMrFpService
    {
        /// <summary>
        /// 刘羽处查询的相关信息数据 查询患者信息
        /// </summary>
        /// <param name="idPat"></param>
        /// <returns></returns>
        PatiInfoForMrDTO GetPatiInfoForMrDto(String idPat);

        /// <summary>
        /// 颜刊处提供dto数据  查询当此就诊信息
        /// </summary>
        /// <param name="idEnt"></param>
        /// <returns></returns>
        IpDetailDTO GetIpDetailInfo(String idEnt);
    }
}

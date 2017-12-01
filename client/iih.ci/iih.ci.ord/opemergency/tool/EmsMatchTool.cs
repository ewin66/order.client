
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.emsqry.d;
using iih.bd.srv.ems.d;
using iih.ci.ord.ciorder.utils;

namespace iih.ci.ord.opemergency.tool
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.tool    </para>    
    /// <para>类 名 称 :  EmsMatchTool					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/9/8 9:55:13             </para>
    /// <para>更新时间 :  2017/9/8 9:55:13             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class EmsMatchTool
    {
        private static LogicEx logic = LogicEx.GetInstance();

        public static EmsFunclassKVDTO GetEmsFunclassKVDTO(String funcStr)
        {
            String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(funcStr));
            EmsFunclassKVDTO funclassDTO = new EmsFunclassKVDTO();
            funclassDTO.deSerializeJson(utf8Str);
            return funclassDTO;
        }

        public static SrvMatchEmsParamDTO GetSrvMatchEmsParamDTO(String id_org, String id_grp, String id_dept, String id_emp, String code_entp, String sd_srvtp, String id_srv, EmsAppModeEnum emsAppMode)
        {
            SrvMatchEmsParamDTO dto = new SrvMatchEmsParamDTO();
            dto.Id_org = id_org;
            dto.Id_grp = id_grp;
            dto.Id_dept = id_dept;
            dto.Id_emp = id_emp;
            dto.Code_entp = code_entp;
            dto.Sd_srvtp = sd_srvtp;
            dto.Id_srv = id_srv;
            dto.Dt_or = logic.GetServerDataTime();
            dto.Emsappmode = (int)emsAppMode;

            return dto;
        }
    }
}

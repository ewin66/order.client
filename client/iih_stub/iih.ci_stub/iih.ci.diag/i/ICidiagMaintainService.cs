using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.diag.cidiag.d;
using iih.ci.diag.dto.d;
using iih.ci.ord.ems.d;
using iih.en.pv.entdi.d;

namespace iih.ci.diag_stub.i
{
    public interface ICidiagMaintainService
    {

        string saveEntDiag(EntDiDO[] list, CiDiagDO ciDiagDo,string type);
        /// <summary>
        /// 医嘱诊断保存
        /// </summary>
        /// <param name="diDTO"></param>
        /// <returns></returns>
        DIDTO[] SaveCiDiDto(DIDTO[] diDTO,string id,string sd,string tp);
        // 保存诊断
        DIDTO[] SaveCiDiDtos(DIDTO[] diDTO,string des,CiEnContextDTO ciEnContextDto);
        //删除诊断
        CidiagAggDO DeleteCiDiag(CiDiagDO ciDiagDo);
    }
}

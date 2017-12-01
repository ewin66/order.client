using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.diagdef.d;
using iih.bd.srv.ortpl.d;
using iih.ci.diag.cidiag.d;
using iih.ci.diag.dto.d;
using xap.sys.xbd.udi.d;

namespace iih.ci.diag_stub.i
{
    public interface ICidiagQryService
    {
        /// <summary>
        /// 
        /// </summary>
        /// <param name="id"></param>
        /// <param name="type"></param>
        /// <returns></returns>
        DIDTO[] QueryCiDiagDTO(string id, string type);
        DIDTO[] QuerRef(string id, string type);
        /// <summary>
        /// 基础诊断
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        DiagDefDO[] getDiagDefDOS(String value);
        /// <summary>
        ///  诊断类型
        /// type  门诊  0 ，住院 1
        /// </summary>
        /// <param name="id_en"></param>
        /// <returns></returns>
        UdidocDO[] getDiType(string id_en, string type);
        /// <summary>string
        /// 参数  控制 科室是中医还是西医诊断
        /// </summary>
        /// <returns></returns>
        string getParamType();
        // 最新诊断
        CidiagAggDO[] getLastCiDiags(string id_en);
        //医嘱助手常用医嘱 分类
        /// <summary>
        /// 本次就诊的所有诊断
        /// </summary>
        /// <param name="id_en"></param>
        /// <returns></returns>
        CidiagAggDO[] getIdEntCiDiS(String id_en);

        /// <summary>
        /// 获取当前就诊对应的诊断明细
        /// </summary>
        /// <param name="id_en">就诊id</param>
        /// <param name="sd_ditp">诊断类型编码</param>
        /// <returns>本次就诊指定类型的诊断明细</returns>
        CiDiagItemDO[] getCiDiagItems(String id_en, String sd_ditp);
        /// <summary>
        /// 当前诊断
        /// </summary>
        /// <param name="id_en"></param>
        /// <param name="entp_code"></param>
        /// <returns></returns>
        CiDiagItemDO getCiDiagItemDO(String id_en, String entp_code);

        /// <summary>
        /// 获取本次就诊的保外诊断
        /// </summary>
        /// <param name="id_en"></param>
        /// <returns></returns>
        CiDiagItemDO[] getHpjudgetpCiDiagItems(String id_en);
    }
}

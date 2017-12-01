using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.mm.itf_stub.pkgunit.i;
using iih.mm.itf.pkgunit.d;
using xap.mw.serviceframework;

namespace iih.ci.ord.ciorder.viewmodel.impext
{
    /// <summary>
    /// 获取总量单位
    /// </summary>
    /// Author:admin
    /// Date:2015-09-24
    class GetCoutUnitImp
    {
        IMaterialUnitService service;
        public GetCoutUnitImp()
        {
            service = XapServiceMgr.find<IMaterialUnitService>();
        }

 

/**
 * 物品数量或者金额从原包装单位换算为新的包装单位.
 * @param inputDTO
 * @return
 * @throws BizException
 */
     


        /// <summary>
        /// Gets the 药品总量
        /// 传入参数：（5.7药品总量单位获取接口）中返回的‘换算系数_医学单位’、药品使用总次数、取整模式（5.2.	根据服务获取药品信息接口）中返回、单次数量值
        /// 传回参数：总量值
        /// </summary>
        /// <param name="factor_mb">基本换算系数</param>
        /// <param name="useCount">药品使用总次数.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-09-19
        public double GetDrugTotal(string  factor_mb, double useCount)
        {
            UnitConvInputDTO inputDTO = new UnitConvInputDTO();
            return service.unitConversion(inputDTO);
        }

        //传入参数：药品的执行科室、药品id、就诊类型
        //传回参数：换算系数_医学单位、总量单位id、总量单位名称
        //药品的执行科室：

        /// <summary>
        /// Gets the drug total unit.
        /// </summary>
        /// <param name="id_mp">The id_mp.</param>
        /// <param name="id_mm">The id_mm.</param>
        /// <param name="id_entp">The id_entp.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-09-19
        public string GetDrugTotalUnit(string id_mp, string id_mm, string id_entp)
        {
            
            return "";
        }

    }
}

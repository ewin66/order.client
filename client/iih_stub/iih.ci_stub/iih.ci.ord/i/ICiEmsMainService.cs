using iih.ci.ord.dto.emsmain;
using iih.ci.ord.ciorder.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.i
{
    public interface ICiEmsMainService
    {
        /**
	 * 创建医疗单UI对象
	 * @param ems
	 * @return
	 */
        EmsRstDTO[] create(EmsCrtDTO[] ems)  ;

        /**
         * 加载医疗单
         * @param ems
         * @return
         */
        EmsRstDTO[] load(EmsLoadDTO[] ems);



        /**
         * 保存医疗单
         * @param ems
         * @return
         */
        EmsRstDTO save(EmsSaveDTO ems);
    }
}

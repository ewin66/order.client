using System;
using iih.ci.ord.ems.d;


namespace iih.ci.ord.i
{
    public interface ICiFeeListMainService
    {
        /**
         * 加载费用清单数据
         * @param ld
         * @return
         * @throws BizException
         */
        FeeListRstDTO load(FeeListLoadDTO ld);
    }
}

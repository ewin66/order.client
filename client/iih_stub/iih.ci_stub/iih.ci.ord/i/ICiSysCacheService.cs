using iih.ci.ord.ems.d;
using xap.mw.coreitf.d;

namespace iih.ci.ord.i
{
    public interface ICiSysCacheService
    {
        /**
	 * 二级缓存
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
        FBoolean prepareL2Cache(CiEnContextDTO ctx);

        /**
         * 三级缓存
         * @param ctx
         * @return
         * @throws BizException
         */
        FBoolean prepareL3Cache(CiEnContextDTO ctx);

        /**
         * 清除一级缓存
         * @param ctx
         * @return
         * @throws BizException
         */
         FBoolean clearL1Cache(CiEnContextDTO ctx);
        /**
         * 清除二级缓存
         * @param ctx
         * @return
         * @throws BizException
         */
         FBoolean clearL2Cache(CiEnContextDTO ctx);
        /**
         * 清除三级缓存
         * @param ctx
         * @return
         * @throws BizException
         */
         FBoolean clearL3Cache(CiEnContextDTO ctx) ;
    }
}

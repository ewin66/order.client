package iih.ci.ord.s.bp.orsrvsplit;

import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/***
 * 医嘱或服务拆分入口参数校验操作BP
 */
public class OrSrvSplitParamValidateBP {
	/***
	 * 医嘱或服务拆分入口参数校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	public void exec(OrSrvSplitParamDTO param) throws BizException {
		if (param == null) {
			throw new BizException("医嘱与服务拆分时，入口参数为空错误！");
		}

		FDateTime dt_split_start = param.getDt_split_start();
		FDateTime dt_split_end = param.getDt_split_end();
		if ((dt_split_start == null && dt_split_end == null)) {
			throw new BizException("医嘱与服务拆分时，拆分开始时间与拆分截止时间同时为空错误！");
		}

		if (dt_split_end == null) {
			throw new BizException("医嘱与服务拆分时，拆分截止时间不能为空！");
		}
		DtSplitEndValidate(dt_split_end);

		if (dt_split_start == null) {
			// 医嘱中已经增加了 dt_last_bl 所以这个判断 同 服务处理一致了不用做这个判断了
			// if(OrSrvSplitUtil.isOrSplitType(param.getEu_orgensplittp())){
			// throw new BizException("医嘱与服务拆分时，医嘱拆分开始时间不能为空错误！");
			// }
		} else {
			//2017-02-14 拆分开始时间可以等于截止时间
			// if(dt_split_end.compareTo(dt_split_start) <= 0){
			if (dt_split_end.compareTo(dt_split_start) < 0) {
				throw new BizException("医嘱与服务拆分时，拆分截止时间不能小于开始时间！");
			}
		}

	}

	/***
	 * 医嘱或服务拆分截止时间有效性校验
	 * 
	 * @param dt_split_end
	 * @throws BizException
	 */
	private void DtSplitEndValidate(FDateTime dt_split_end) throws BizException {
		DtSplitEndValidateBP bp = new DtSplitEndValidateBP();
		bp.exec(dt_split_end);
	}
}

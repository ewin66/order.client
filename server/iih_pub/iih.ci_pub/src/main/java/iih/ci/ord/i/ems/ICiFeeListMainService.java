package iih.ci.ord.i.ems;

import iih.ci.ord.d.ems.fee.FeeListCrtDTO;
import iih.ci.ord.d.ems.fee.FeeListLoadDTO;
import iih.ci.ord.d.ems.fee.FeeListRstDTO;
import iih.ci.ord.d.ems.fee.FeeListSaveDTO;
import xap.mw.core.data.BizException;

/**
 * 费用清单操作服务
 * @author wangqingzhu
 *
 */
public interface ICiFeeListMainService {

	/**
	 * 创建费用项目
	 * @param crt
	 * @return
	 * @throws BizException
	 */
	public abstract FeeListRstDTO create(FeeListCrtDTO crt) throws BizException ;
	
	/**
	 * 加载费用清单数据
	 * @param ld
	 * @return
	 * @throws BizException
	 */
	public abstract FeeListRstDTO load(FeeListLoadDTO ld) throws BizException ;
	
	/**
	 * 保存费用清单数据修改
	 * @param sv
	 * @return
	 * @throws BizException
	 */
	public abstract FeeListRstDTO save(FeeListSaveDTO sv) throws BizException ;
}

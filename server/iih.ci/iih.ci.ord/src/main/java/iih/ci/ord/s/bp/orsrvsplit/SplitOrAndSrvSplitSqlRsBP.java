package iih.ci.ord.s.bp.orsrvsplit;

import iih.ci.ord.dto.blexorder.d.OrSplitOrderDTO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/***
 * 对有效医嘱sql对应的结果集进行拆分操作BP
 */
public class SplitOrAndSrvSplitSqlRsBP {
	/***
	 * 对有效医嘱sql对应的结果集进行拆分
	 * @param splitRsDTO
	 * @param s
	 * @param e
	 * @param orgensplittp
	 * @return
	 * @throws BizException
	 */
	public  BaseDTO[] exec(BaseDTO[] splitRsDTOs,FDateTime s,FDateTime e,Integer orgensplittp)  throws BizException{
		if(splitRsDTOs==null || splitRsDTOs.length==0)return null;
		
		if(OrSrvSplitUtil.isOrSplitType(orgensplittp)){
			return orSplitHandle((OrSplitOrderDTO[])splitRsDTOs,s,e);
			
		}else{
			return orSrvSplitHandle((SrvSplitOrderDTO[])splitRsDTOs,s,e,orgensplittp);
		}
	}

	/***
	 * 对有效医嘱结果进行医嘱拆分
	 * @param orsplitorder
	 * @param s
	 * @param e
	 * @return
	 * @throws BizException
	 */
	private OrSplitOrderDTO[] orSplitHandle(OrSplitOrderDTO[] orsplitorder,FDateTime s,FDateTime e) throws BizException{
		OrSplitBP bp=new OrSplitBP();
		return bp.exec(orsplitorder, s, e);
	}
	
	/***
	 * 对有效医嘱结果进行医嘱拆分
	 * @param orsplitorder
	 * @param s
	 * @param e
	 * @return
	 * @throws BizException
	 */
	private SrvSplitOrderDTO[] orSrvSplitHandle(SrvSplitOrderDTO[] srvsplitorder,FDateTime s,FDateTime e,Integer orgensplittp) throws BizException{
		OrSrvSplitBP bp=new OrSrvSplitBP();
		return bp.exec(srvsplitorder, s, e,orgensplittp);
	}
}

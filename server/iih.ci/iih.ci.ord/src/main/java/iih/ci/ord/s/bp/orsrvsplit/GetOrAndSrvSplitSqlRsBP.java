package iih.ci.ord.s.bp.orsrvsplit;

import iih.ci.ord.dto.blexorder.d.OrSplitOrderDTO;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;

/***
 * 获得执行与记费的医嘱或服务拆分时的有效医嘱sql对应的结果值操作BP
 */
public class GetOrAndSrvSplitSqlRsBP {
	/***
	 * 获得执行与记费的医嘱或服务拆分时的有效医嘱sql对应的结果值
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public  BaseDTO[] exec(OrSrvSplitParamDTO param)  throws BizException{
		//获得查询sql串
		String sql=getQrySql(param);

		//医嘱拆分类型
		if(OrSrvSplitUtil.isOrSplitType(param.getEu_orgensplittp())){
			OrSplitOrderDTO[] rtn = (OrSplitOrderDTO[])OrSrvSplitUtil.getDORstWithDao(sql, OrSplitOrderDTO.class);
			if(rtn!=null && rtn.length!=0){
				FMap attachinfo=getOrSplitRsAttachInfo(rtn,param.getAttachfields(),param.getEu_orgensplittp());
				rtn[0].setOrattachinfos(attachinfo);
			}
			return rtn; 
		}else{//服务拆分类型
			SrvSplitOrderDTO[] rtn = (SrvSplitOrderDTO[])OrSrvSplitUtil.getDORstWithDao(sql, SrvSplitOrderDTO.class);
			if(rtn!=null && rtn.length!=0){
				FMap attachinfo=getOrSplitRsAttachInfo(rtn,param.getAttachfields(),param.getEu_orgensplittp());
				rtn[0].setOrattachinfos(attachinfo);
			}
			return rtn; 
		}
		
		//return null;
	}
	
	/**
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private String getQrySql(OrSrvSplitParamDTO param) throws BizException{
		GetOrAndSrvSplitSqlBP bp=new GetOrAndSrvSplitSqlBP();
		return bp.exec(param);
	}
	
	/**
	 * 设置附加信息
	 * @param splitrs
	 * @param qrymap
	 * @param orgensplittp
	 * @throws BizException
	 */
	private FMap getOrSplitRsAttachInfo(BaseDTO[] splitrs,FMap qrymap,Integer orgensplittp) throws BizException{
		GetOrSplitRsAttachInfoBP bp=new GetOrSplitRsAttachInfoBP();
		FMap attachinfo=bp.exec(splitrs, qrymap, orgensplittp);
		return attachinfo;
	}

}

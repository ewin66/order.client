package iih.ci.ord.s.bp;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;

/**
 * 皮试结果 写会医嘱内容里
 * @author li_zheng
 *
 */
public class setOrcontentSkinTestBP {
	
	public CiOrderDO exec(String id_or,String skinTest)throws BizException{
		CiOrderDO ciorder = CiOrdAppUtils.getOrQryService().findById(id_or);
		String Content_or = getNewContent(ciorder,skinTest);
		ciorder.setContent_or(Content_or);
		CiOrdAppUtils.getOrService().save(new CiOrderDO[]{ciorder});
		return ciorder;
	}

	
	private String getNewContent(CiOrderDO ciorder,String skinTest)throws BizException{
		String content_or = ciorder.getContent_or();
		if(content_or == null)throw new BizException("医嘱内容为空");
		String[] contentor = content_or.split("&");
		if(contentor == null) throw new BizException("医嘱内容为空");
		String str = "";
		for(int i=0;i<contentor.length;i++){
			if(i==0){
				str += contentor[0]+"("+skinTest+")&";
			}else{
				str += contentor[i]+"&";	
			}			
		}
		str = str.substring(0, str.lastIndexOf("&"));
		return str;
	}
}

package iih.ci.ord.s.bp;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.blexorder.d.OrSplitOrderDTO;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.orsrvsplit.GetOrAndSrvSplitSqlRsBP;
import iih.ci.ord.s.bp.orsrvsplit.SplitOrAndSrvSplitSqlRsBP;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

public class splitOrSplitSqlRsBP {
	
	public OrSplitOrderDTO[] exec(OrSrvSplitParamDTO param)throws BizException{
		
//		IUdidocServiceExt udiext=ServiceFinder.find(IUdidocServiceExt.class);
//		 UdidocDO[] Udis=udiext.findByUdidoclistCode("BD.SRV.0505");
//		 String str="";
//		 for (UdidocDO udidocDO : Udis) {
//			 String code=udidocDO.getCode();
//			if((code.startsWith("0101")||code.startsWith("0102"))&&!code.equals("010104")&&!code.equals("010105")){
//				str+=udidocDO.getCode()+",";
//			}
//		}
//		 param.setSd_srvtps(str.substring(0, str.length()-1));
		GetOrAndSrvSplitSqlRsBP getsrvbp=new GetOrAndSrvSplitSqlRsBP();
	
        BaseDTO[] splitDTO=getsrvbp.exec(param);
        SplitOrAndSrvSplitSqlRsBP bp=new SplitOrAndSrvSplitSqlRsBP();
        BaseDTO[] srvsplitDTO=bp.exec(splitDTO, param.getDt_split_start(), param.getDt_split_end(), param.getEu_orgensplittp());
        return (OrSplitOrderDTO[])srvsplitDTO;
		
	}

}

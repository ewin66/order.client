package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.cior.i.ICiorapptransdeptCudService;
import iih.ci.ord.cior.i.ICiorapptransdeptRService;
import iih.ci.ord.s.bp.qry.TransferStatusUpdatesQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class TransferStatusUpdatesBP {
  
	
	public boolean  exec(String id_ortrans,String status)throws BizException{
		boolean  isSuccess = false;
		TransferStatusUpdatesQry qry = new TransferStatusUpdatesQry(id_ortrans,status);
		ICiorapptransdeptCudService CudService = ServiceFinder.find(ICiorapptransdeptCudService.class);
		
		ICiorapptransdeptRService QryService = ServiceFinder.find(ICiorapptransdeptRService.class);
		OrdApTransDO[] orderAptrans = QryService.find("id_ortrans ='"+id_ortrans+"'", "id_ortrans", FBoolean.FALSE);
		 if(orderAptrans != null && orderAptrans.length > 0){
			
			 OrdApTransDO orderAptran = orderAptrans[0];
			 orderAptran.setStatus(DOStatus.UPDATED);
			 orderAptran.setDt_trans_apply(new FDateTime());
			 orderAptran.setSd_su_trans(status);

			 CudService.update(new OrdApTransDO[]{orderAptran});
			 isSuccess = true;
		 }
		
//		 String sql = "update CI_AP_TRANS   set sd_su_trans  =  "+status+"   where id_or =  '"+id_ord+"'";
//		 DAFacade cade = new DAFacade();
//		 int i =  cade.execUpdate(sql);
//		 if(i>0) isSuccess = true;
		 return  isSuccess;
	}
}

package iih.ci.ord.s.bp;

import iih.ci.ord.ciordems.d.AddFeeDTO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderSrvDOCudService;
import iih.ci.ord.ciorder.i.ICiorderSrvDORService;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmCudService;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class CiOrderFeeDeleteBP {

	
	public void exe( AddFeeDTO fee)throws BizException{

		IOrdsrvmmCudService mmService=ServiceFinder.find(IOrdsrvmmCudService.class);
		IOrdsrvmmRService mmRService=ServiceFinder.find(IOrdsrvmmRService.class);
		ICiorderSrvDOCudService srvService=ServiceFinder.find(ICiorderSrvDOCudService.class);
		ICiorderSrvDORService srvRService=ServiceFinder.find(ICiorderSrvDORService.class);
		
		  if (fee.getId_orsrvmm() != null)
          {
              OrdSrvMmDO srvmm = mmRService.findById(fee.getId_orsrvmm());
              if (srvmm != null)
              {
                  mmService.delete(new OrdSrvMmDO[] {srvmm});
              }
          }
          if (fee.getId_orsrv() != null)
          {
              OrdSrvDO srvdo = srvRService.findById(fee.getId_orsrv());
              if (srvdo != null)
              {
            	  srvService.delete(new OrdSrvDO[] {srvdo});
              }
          }
	}
}

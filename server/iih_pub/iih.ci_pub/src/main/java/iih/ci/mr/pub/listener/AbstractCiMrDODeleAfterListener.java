package iih.ci.mr.pub.listener;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueCudService;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public class AbstractCiMrDODeleAfterListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent arg0) throws BizException {
		// TODO Auto-generated method stub
		CiMrDO[] ciMrDOsNew = (CiMrDO[])((BDCommonEvent)arg0).getNewObjs();
		
		
		CiMrDO newCiMr = ciMrDOsNew[0];
	
			IMrdocrefvalueCudService docRefCudService = ServiceFinder.find(IMrdocrefvalueCudService.class);
			IMrdocrefvalueRService docRefRService = ServiceFinder.find(IMrdocrefvalueRService.class);
			
			//所有需要删除的引用
			MrDocRefValueDO[] MrDocRefValueDOs = docRefRService.find("id_mr = '"+newCiMr.getId_mr()+"'", null, FBoolean.FALSE);
			
			docRefCudService.delete(MrDocRefValueDOs);//删除
	}

}

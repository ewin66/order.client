package iih.ci.ord.s.ems.biz.base;

import iih.bd.base.cache.CacheContext;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsLoadDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.d.ems.ems.EmsSaveDTO;
import iih.ci.ord.s.ems.biz.itf.IEmsAction;
import iih.ci.ord.s.ems.biz.itf.IEmsValidate;
import iih.ci.ord.s.ems.biz.itf.bp.IEmsCreateBP;
import iih.ci.ord.s.ems.biz.itf.bp.IEmsLoadBP;
import iih.ci.ord.s.ems.biz.itf.bp.IEmsSaveBP;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsBaseAction extends CacheContext implements IEmsAction{
	
	private IEmsValidate emsValidate;
	
	private IEmsCreateBP emsCreateBP;
	
	private IEmsLoadBP emsLoadBP ;
	
	private IEmsSaveBP emsSaveBP ;
	
	

	public EmsBaseAction() {
		super();
		// TODO Auto-generated constructor stub
		
	}

	/**
	 * 创建医疗单
	 */
	@Override
	public EmsRstDTO[] create(EmsCrtDTO[] emsarray)  throws BizException{
		// TODO Auto-generated method stub
		
		return emsCreateBP.create(emsarray);
	}
	
	@Override
	public EmsRstDTO[] load(EmsLoadDTO[] args) throws BizException {
		// TODO Auto-generated method stub
		return  emsLoadBP.load(args);
	}

	/**
	 * 保存医疗单
	 */
	@Override
	public EmsRstDTO save(EmsSaveDTO ems) throws BizException {
		// TODO Auto-generated method stub
		return emsSaveBP.save(ems);
	}
	
	
	
	
	/**
	 * 获取主服务对象
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	protected MedsrvAggDO getMedSrvInfo(String id_srv) throws BizException {
		return ServiceFinder.find(IMedsrvRService.class).findById(id_srv);
	}

	public IEmsCreateBP getEmsCreateBP() {
		return emsCreateBP;
	}

	public void setEmsCreateBP(IEmsCreateBP emsCreateBP) {
		this.emsCreateBP = emsCreateBP;
	}

	public IEmsLoadBP getEmsLoadBP() {
		return emsLoadBP;
	}

	public void setEmsLoadBP(IEmsLoadBP emsLoadBP) {
		this.emsLoadBP = emsLoadBP;
	}

	public IEmsSaveBP getEmsSaveBP() {
		return emsSaveBP;
	}

	public void setEmsSaveBP(IEmsSaveBP emsSaveBP) {
		this.emsSaveBP = emsSaveBP;
	}

	public IEmsValidate getEmsValidate() {
		return emsValidate;
	}

	public void setEmsValidate(IEmsValidate emsValidate) {
		this.emsValidate = emsValidate;
	}
	
}

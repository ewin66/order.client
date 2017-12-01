package iih.ci.ord.s.ems;

import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsLoadDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.d.ems.ems.EmsSaveDTO;
import iih.ci.ord.d.ems.tmpl.TmplRstDTO;
import iih.ci.ord.d.ems.tmpl.TmplSaveDTO;
import iih.ci.ord.i.ems.ICiEmsMainService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.op.tmpl.gj.ortmpl.TmplSaveAction;
import iih.ci.ord.s.ems.define.IOprSourceFromConst;
import iih.ci.ord.s.ems.driver.EmsDriverFactory;
import iih.ci.ord.s.ems.driver.base.IOrderEmsDriver;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { ICiEmsMainService.class }, binding = Binding.JSONRPC)
public class CiEmsMainServiceImpl implements ICiEmsMainService {

	@Override
	public EmsRstDTO[] create(EmsCrtDTO[] emsarray) throws BizException {
		if (IOprSourceFromConst.IOSF_EMS.equals(emsarray[0].getOperateSourceFrom())){
			return doCreateEmsInfo(emsarray);
		}
		else if (IOprSourceFromConst.IOSF_HLP.equals(emsarray[0].getOperateSourceFrom())){
			return doCreateTmplInfo(emsarray);
		}
		
		return null;
	}

	@Override
	public EmsRstDTO[] load(EmsLoadDTO[] emsarray)  throws BizException {
		if (IOprSourceFromConst.IOSF_EMS.equals(emsarray[0].getOperateSourceFrom())){
			return doLoadEmsInfo(emsarray);
		}
		else if (IOprSourceFromConst.IOSF_HLP.equals(emsarray[0].getOperateSourceFrom())){
			return doLoadTmplInfo(emsarray);
		}
		return null;
	}

	@Override
	public EmsRstDTO save(EmsSaveDTO ems)  throws BizException {
		if (IOprSourceFromConst.IOSF_EMS.equals(ems.getOperateSourceFrom())){
			return doSaveEmsInfo(ems);
		}
		else if (IOprSourceFromConst.IOSF_HLP.equals(ems.getOperateSourceFrom())){
			return doSaveTmplInfo(ems);
		}
		
		return null;
	}
	
	/**
	 * 处理服务参照发送过来的医疗单保存请求
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	private EmsRstDTO doSaveEmsInfo(EmsSaveDTO ems) throws BizException{
		IOrderEmsDriver drv = EmsDriverFactory.GetInstance().find(ems.getEmsDriver());
		if (null != drv){
			return drv.save(ems);
		}
		return null;
	}

	/**
	 * 处理辅助录入助手发送过来的模板保存医疗单请求
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	private EmsRstDTO doSaveTmplInfo(EmsSaveDTO ems) throws BizException{
		// 按照医疗单类型分组
		
		if (CiOrdUtils.isEmpty(ems.getDocument())){
			throw new BizException("模板保存医疗单时，发送请求参数为空");
		}
		TmplSaveAction tmplAction = new TmplSaveAction();
		TmplSaveDTO tmplSaveDTO = new TmplSaveDTO();
		tmplSaveDTO.deSerializeJson(ems.serializeJson());
		TmplRstDTO rst = tmplAction.save(tmplSaveDTO);
		EmsRstDTO emsRstDTO = new EmsRstDTO();
		emsRstDTO.deSerializeJson(rst.serializeJson());
		return emsRstDTO;
	
	}
	
	private EmsRstDTO[] doLoadEmsInfo(EmsLoadDTO[] emsarray) throws BizException{
		IOrderEmsDriver drv = EmsDriverFactory.GetInstance().find(emsarray[0].getEmsDriver());
		if (null != drv){
			return drv.load(emsarray);
		}
		return null;
	}

	private EmsRstDTO[] doLoadTmplInfo(EmsLoadDTO[] emsarray) throws BizException{
		
		return null;
	}
	
	private EmsRstDTO[] doCreateEmsInfo(EmsCrtDTO[] emsarray) throws BizException{
		IOrderEmsDriver drv = EmsDriverFactory.GetInstance().find(emsarray[0].getEmsDriver());
		if (null != drv){
			return drv.create(emsarray);
		}
		return null;
	}

	private EmsRstDTO[] doCreateTmplInfo(EmsCrtDTO[] emsarray) throws BizException{
		
		return null;
	}
}

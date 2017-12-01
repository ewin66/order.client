/**  
 * Project Name:iih.ci.ord  
 * File Name:CiDiagMaintainServiceImpl.java  
 * Package Name:iih.ci.ord.s.ems  
 * Date:2017年8月11日下午1:59:25  
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
/**  
 * Project Name:iih.ci.ord  
 * File Name:CiDiagMaintainServiceImpl.java  
 * Package Name:iih.ci.ord.s.ems  
 * Date:2017年8月11日下午1:59:25  
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.  
 *  
 */  
  
package iih.ci.ord.s.ems;

import iih.ci.ord.d.ems.di.DiagCrtDTO;
import iih.ci.ord.d.ems.di.DiagLoadDTO;
import iih.ci.ord.d.ems.di.DiagRstDTO;
import iih.ci.ord.d.ems.di.DiagSaveDTO;
import iih.ci.ord.i.ems.ICiDiagMaintainService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;


/**  
 * ClassName: CiDiagMaintainServiceImpl <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO ADD REASON(可选). <br/>  
 * date: 2017年8月11日 下午1:59:25 <br/>  
 *  
 * @author wangqingzhu  
 * @version   
 * @since JDK 1.8  
 */
@Service(serviceInterfaces = { ICiDiagMaintainService.class }, binding = Binding.JSONRPC)
public class CiDiagMaintainServiceImpl implements ICiDiagMaintainService {

	/**  
	 * TODO 简单描述该方法的实现功能（可选）.  
	 * @see iih.ci.ord.i.ems.ICiDiagMaintainService#create(iih.ci.ord.d.ems.di.DiagCrtDTO)  
	 */
	@Override
	public DiagRstDTO create(DiagCrtDTO diCreateInfo) {

		// TODO Auto-generated method stub  
		return null;
	}

	/**  
	 * TODO 简单描述该方法的实现功能（可选）.  
	 * @see iih.ci.ord.i.ems.ICiDiagMaintainService#load(iih.ci.ord.d.ems.di.DiagLoadDTO)  
	 */
	@Override
	public DiagRstDTO load(DiagLoadDTO diLoadInfo) {

		// TODO Auto-generated method stub  
		return null;
	}

	/**  
	 * TODO 简单描述该方法的实现功能（可选）.  
	 * @see iih.ci.ord.i.ems.ICiDiagMaintainService#save(iih.ci.ord.d.ems.di.DiagSaveDTO)  
	 */
	@Override
	public DiagRstDTO save(DiagSaveDTO diSaveInfo) {

		// TODO Auto-generated method stub  
		return null;
	}

	/**  
	 * TODO 简单描述该方法的实现功能（可选）.  
	 * @see iih.ci.ord.i.ems.ICiDiagMaintainService#sign(iih.ci.ord.d.ems.di.DiagSaveDTO)  
	 */
	@Override
	public DiagRstDTO sign(DiagSaveDTO diSaveInfo) {

		// TODO Auto-generated method stub  
		return null;
	}

}
  

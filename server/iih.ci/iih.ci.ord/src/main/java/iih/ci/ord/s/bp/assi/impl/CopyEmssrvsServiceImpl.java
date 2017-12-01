package iih.ci.ord.s.bp.assi.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.s.bp.assi.service.AbstractAssiCopy;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;
import iih.ci.ord.tmpl.d.CiOrTmplSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 拷贝服务项目
 * 
 * @author HUMS
 *
 */
public class CopyEmssrvsServiceImpl extends AbstractAssiCopy<CiOrTmplDTO, CiEmsDTO> {

	// 套定义集合
	private Map<String,MedSrvSetItemDO> setItemMap = new HashMap<String,MedSrvSetItemDO>();
	
	@Override
	protected void copyPropertys(CiOrTmplDTO ciOrTmpl, CiEmsDTO ciEms) throws BizException {

		MedSrvDO tempMedSrv = null;
		FArrayList ciEmsSrvList = new FArrayList();
		FArrayList srvlist = ciOrTmpl.getOrtmplsrvs();
		
		//TODO 构造套定义集合
		List<MedSrvSetItemDO> medSrvSetList = srvSetItemsMap.get(ciEms.getId_srv());
		if(medSrvSetList != null && medSrvSetList.size() >0){
			for(MedSrvSetItemDO setItem : medSrvSetList){
				setItemMap.put(setItem.getId_srv(), setItem);
			}
		}

		// 取服务套对应的服务
		MedSrvDO medSrv = medSrvMap.get(ciOrTmpl.getId_srv());
		// 套的处理
		if (ciOrTmpl.getFg_set() == FBoolean.TRUE) {
			CiEmsSrvDTO srvdto = new CiEmsSrvDTO();

			this.setCiEmSrvPropertys(srvdto, null, medSrv);

			this.setCiEmsSrvMeduPropertys(srvdto, ciOrTmpl.getDays_or(), ciOrTmpl.getOrders());
			ciEmsSrvList.add(srvdto);
		}

		for (int i = 0; i < srvlist.size(); i++) {
			
			CiOrTmplSrvDTO tmplSrv = (CiOrTmplSrvDTO) srvlist.get(i);
			CiEmsSrvDTO srvdto = new CiEmsSrvDTO();
			srvdto.setId_hp(envinfo.getId_hp());
			// tempMedSrv =
			// CiOrdAppUtils.getIMedsrvMDORService().findById(tmplSrv.getId_srv());//
			// 获取每个项目
			tempMedSrv = medSrvMap.get(tmplSrv.getId_srv());
			// 设置CiEmsSrvDTO相关属性，环境、模板、服务、物品
			this.setCiEmSrvPropertys(srvdto, tmplSrv, tempMedSrv);
			// 设置量信息
			this.setCiEmsSrvMeduPropertys(srvdto, ciOrTmpl.getDays_or(), ciOrTmpl.getOrders());
			
			srvdto.setSortno(i + 1);// 设置排序
			// 是套服务时才设置id_srv_set属性 2016-11-28
			if (ciOrTmpl.getFg_set() == FBoolean.TRUE) {
				srvdto.setId_srv_set(ciOrTmpl.getId_srv());
			}
			
			// TODO
			srvdto.setCode_srv(tempMedSrv.getCode());
			ciEmsSrvList.add(srvdto);
		}
		ciEms.setEmssrvs(ciEmsSrvList);
	}

	/**
	 * 设置CiEmsSrvDTO对象属性
	 * 
	 * @param srvdto
	 * @param envinfo
	 * @param tmplSrv 医嘱模板（组套数据转换该值为null）
	 * @param medSrv
	 * @throws BizException
	 */
	private void setCiEmSrvPropertys(CiEmsSrvDTO srvdto, CiOrTmplSrvDTO tmplSrv,
			MedSrvDO medSrv) throws BizException {

		// 设置环境相关属性
		//this.setCiEmsSrvEnvinfoPropertys(envinfo, srvdto);

		// 拷贝当前就诊环境
		AbstractAssiCopy<CiEnContextDTO, CiEmsSrvDTO> copyContextService = new CopyContextCiEmsSrvServiceImpl();
		copyContextService.setAssiParam(paramDTO);
		copyContextService.startCopy(envinfo, srvdto);
		
		if (tmplSrv != null) { // 套进来的为空
			// 设置模板中的属性
			this.setCiEmSrvTmplPropertys(srvdto, tmplSrv);
		}
		
		// 拷贝服务相关属性
		AbstractAssiCopy<MedSrvDO, CiEmsSrvDTO> copyMedSrvService = new CopyMedSrvToCiEmsSrvServiceImpl();
		copyMedSrvService.setAssiParam(paramDTO);
		copyMedSrvService.startCopy(medSrv, srvdto);

		// 设置物品相关属性
		AbstractAssiCopy<MedSrvDO, CiEmsSrvDTO> copySrvMmService = new CopySrvMmServiceImpl();
		copySrvMmService.setAssiParam(this.paramDTO);
		copySrvMmService.startCopy(medSrv, srvdto);

		// 设置执行科室相关属性
		OrWfDeptInfoDTO deptMpDTo = this.getMpDeptID(envinfo, medSrv);
		srvdto.setId_dep(deptMpDTo.getFirstid_mp_dept());// 执行科室
		srvdto.setName_dep(deptMpDTo.getFirstname_mp_dept());// 执行科室名称
		srvdto.setId_dep_wh(deptMpDTo.getId_dept_wh());// 仓库
		srvdto.setName_dep_wh(deptMpDTo.getFirstid_mp_dept()); // 仓库的名称
	}

	/**
	 * 设置模板中相关属性<br>
	 * 当不是服务套时会调用
	 * @param srvdto
	 * @param envinfo
	 * @param medSrv
	 * @throws BizException
	 */
	private void setCiEmSrvTmplPropertys(CiEmsSrvDTO srvdto, CiOrTmplSrvDTO tmplSrv) throws BizException {

		//TODO 废弃字段，现在不赋值会导致错误
		srvdto.setFg_outp(FBoolean.FALSE);
		// srvdto.setId_orsrv(tmplSrv.getId_orsrv());//医疗单项目主键标识
		// srvdto.setId_or(tmplSrv.getId_or());//医疗单
		// srvdto.setSortno(tmplSrv.getSortno());// 序号 循环时统一设置
		srvdto.setId_srv(tmplSrv.getId_srv());// 医疗服务
		srvdto.setFg_self(tmplSrv.getFg_selfsrv()); // 自定义服务标识
		if (srvdto.getFg_self() == FBoolean.TRUE) { // 自定义服务名，只有就诊历史会出现自定义服务
			srvdto.setName_srv(tmplSrv.getName_selfsrv());
		}

		// 套标识 套内项目，基本服务，套属性都应该是false,自定义服务有套概念没？
		srvdto.setFg_set(tmplSrv.getFg_set()); // TODO 套属标识
		MedSrvSetItemDO setItem = setItemMap.get(srvdto.getId_srv());
		if(setItem != null){
			srvdto.setFg_or(setItem.getFg_clinical());	
		}else{
			srvdto.setFg_or(medSrvMap.get(srvdto.getId_srv()).getFg_or());
		}
		
		srvdto.setId_srvtp(tmplSrv.getId_srvtp());// 服务类型
		srvdto.setSd_srvtp(tmplSrv.getSd_srvtp());// 服务类型编码
		srvdto.setId_freq(tmplSrv.getId_freq());// 频次
		srvdto.setId_route(tmplSrv.getId_route());// 用法
		srvdto.setId_routedes(tmplSrv.getId_routedes());// 用法要求
		srvdto.setId_boil(tmplSrv.getId_boil());// 煎法
		srvdto.setId_boildes(tmplSrv.getId_boildes());// 煎法要求
		srvdto.setQuan_med(tmplSrv.getQuan_med());// 医学单位数值（剂量）
		srvdto.setId_unit_med(tmplSrv.getId_unit_med());// 医学单位（计量单位）
		srvdto.setName_unit_med(tmplSrv.getAttrVal("Name_unit_med") == null ? "" : tmplSrv.getAttrVal("Name_unit_med").toString());

		// 对于服务套来说，缺少总量单位
		srvdto.setQuan_total_medu(tmplSrv.getQuan_total_medu()); // 总量 TODO

		srvdto.setId_dep(tmplSrv.getId_dep_mp()); // 执行科室
		srvdto.setId_mm(tmplSrv.getId_mm());// 物品
	}

}

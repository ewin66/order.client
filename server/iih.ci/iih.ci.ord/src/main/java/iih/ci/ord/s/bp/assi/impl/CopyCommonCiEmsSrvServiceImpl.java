package iih.ci.ord.s.bp.assi.impl;

import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.s.bp.assi.service.AbstractAssiCopy;
import iih.ci.ord.tmpl.d.CiOrTmplSrvDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 拷贝公共的srv属性
 * 
 * @author HUMS
 *
 */
public class CopyCommonCiEmsSrvServiceImpl extends AbstractAssiCopy<CiOrTmplSrvDTO, CiEmsSrvDTO> {

	@Override
	public void copyPropertys(CiOrTmplSrvDTO tmplSrv, CiEmsSrvDTO srvdto) {

		// srvdto.setId_orsrv(tmplSrv.getId_orsrv());//医疗单项目主键标识
		// srvdto.setId_or(tmplSrv.getId_or());//医疗单
		// srvdto.setSortno(tmplSrv.getSortno());// 序号 循环时统一设置
		srvdto.setId_srv(tmplSrv.getId_srv());// 医疗服务
		srvdto.setFg_self(tmplSrv.getFg_selfsrv()); // 自定义服务标识
		if (srvdto.getFg_self() == FBoolean.TRUE) { // 自定义服务名，只有就诊历史会出现自定义服务
			srvdto.setName_srv(tmplSrv.getName_selfsrv());
		}
		
		// 套属性套内项目，基本服务，套属性都应该是false,自定义服务有套概念没？
		srvdto.setFg_set(tmplSrv.getFg_set()); // TODO
		
		/*MedSrvSetItemDO medSrvSetItem = setItemSrvMap.get(srvdto.getId_srv());
		if(medSrvSetItem != null){			
			srvdto.setFg_or(medSrvSetItem.getFg_clinical());// 医嘱标识	
		}else{
			srvdto.setFg_or(medSrv.getFg_or());// 医嘱标识
		}*/
		srvdto.setFg_or(FBoolean.FALSE);
		srvdto.setId_srvtp(tmplSrv.getId_srvtp());// 服务类型
		srvdto.setSd_srvtp(tmplSrv.getSd_srvtp());// 服务类型编码
		srvdto.setId_freq(tmplSrv.getId_freq());// 频次
		srvdto.setId_route(tmplSrv.getId_route());// 用法
		srvdto.setId_routedes(tmplSrv.getId_routedes());// 用法要求
		srvdto.setId_boil(tmplSrv.getId_boil());// 煎法
		srvdto.setId_boildes(tmplSrv.getId_boildes());// 煎法要求
		srvdto.setQuan_med(tmplSrv.getQuan_med());// 医学单位数值（剂量）
		srvdto.setId_unit_med(tmplSrv.getId_unit_med());// 医学单位（计量单位）
		srvdto.setQuan_total_medu(tmplSrv.getQuan_total_medu()); //TODO 总量,对于服务套来说，缺少总量单位

		srvdto.setId_dep(tmplSrv.getId_dep_mp()); // 执行科室
		srvdto.setId_mm(tmplSrv.getId_mm());// 物品

	}
}

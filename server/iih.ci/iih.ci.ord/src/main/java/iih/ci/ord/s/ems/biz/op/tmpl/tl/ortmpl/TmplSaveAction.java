package iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl;

import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.d.ems.ems.EmsSaveDTO;
import iih.ci.ord.d.ems.tmpl.TmplRstDTO;
import iih.ci.ord.d.ems.tmpl.TmplSaveDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.itf.IEmsAction;
import iih.ci.ord.s.ems.biz.itf.bp.IEmsSaveBP;
import iih.ci.ord.s.ems.biz.itf.bp.ITmplSaveBP;
import iih.ci.ord.s.ems.biz.op.tmpl.meta.OrderTmplDetailList;
import iih.ci.ord.s.ems.biz.op.tmpl.meta.OrderTmplDetailListMap;
import iih.ci.ord.s.ems.biz.op.tmpl.meta.OrderTmplGroupList;
import iih.ci.ord.s.ems.biz.op.tmpl.meta.OrderTmplGroupListMap;
import iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.apbt.TmplApBtAction;
import iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.cons.TmplConsAction;
import iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.drugs.TmplDrugsAction;
import iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.herbs.TmplHerbsAction;
import iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.lis.TmplLisAction;
import iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.opr.TmplOprAction;
import iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.pathgy.TmplPathgyAction;
import iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.ris.TmplRisAction;
import iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.treat.TmplTreatAction;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 模板保存
 * @author wangqingzhu
 *
 */
public class TmplSaveAction implements ITmplSaveBP, EmsType {


	@Override
	public TmplRstDTO save(TmplSaveDTO arg) throws BizException {
		FArrayList listTmplItem = arg.getDocument();
		OrderTmplGroupList listGroupTplItems = handleSrvGroupInfo(listTmplItem);
		if (CiOrdUtils.isEmpty(listTmplItem)) {
			throw new BizException("服务器接收到空的模板保存数据");
		}

		// 分组表，key: 医疗单驱动字符串；value：模板组列表
		OrderTmplGroupListMap stringOrTplNItmGroupListMap = handleDriverTmplGroupInfo(arg.getEnContext(),
				listGroupTplItems);

		// 构建模板返回数据对象
		TmplRstDTO tmplRstInfo = new TmplRstDTO();
		tmplRstInfo.setDocument(new FArrayList());
		tmplRstInfo.setErrorEmsList(new FArrayList());
		
		// 遍历 分组表
		for (OrderTmplGroupList groupList : stringOrTplNItmGroupListMap.values()){
			// 获取医疗单业务逻辑处理接口
			IEmsSaveBP saveBP = handleSaveTmplInfo(arg.getEnContext(), groupList);
			if (null != saveBP){
				// 构建医疗单保存参数
				EmsSaveDTO saveEmsInfo = new EmsSaveDTO();
				
				// 从模板参数对象中拷贝相关上下文信息
				saveEmsInfo.deSerializeJson(arg.serializeJson());
				
				// 将模板顺序保存为医嘱，若存在异常，则添加到错误列表中，并在前端打开
				for (OrderTmplDetailList info : groupList){
					try{
						// 清除保存数据对象实体
						saveEmsInfo.getDocument().clear();
					
						// 添加新保存数据实体对象
					saveEmsInfo.getDocument().add(info);
				
						// 保存模板
						EmsRstDTO rst = saveBP.save(saveEmsInfo);
						
						// 处理返回值
						tmplRstInfo.getDocument().addAll(rst.getDocument());
					}
					catch(Exception e){
						// 组织错误信息
						//tmplRstInfo.getErrorEmsList().add(e)
					}
					
					
				}
			}
		}
		tmplRstInfo.setOperateSourceFrom(arg.getOperateSourceFrom());

		return tmplRstInfo;
	}

	/**
	 * 分析成组医嘱数据
	 * 
	 * @param listTmplItem
	 * @return
	 */
	protected OrderTmplGroupList handleSrvGroupInfo(FArrayList listTmplItem) {
		//
		if (CiOrdUtils.isEmpty(listTmplItem))
			return null;
		OrderTmplDetailListMap tmpGroupCache = new OrderTmplDetailListMap();
		for (Object objInfo : listTmplItem) {
			assert objInfo instanceof OrTplNItmDO : "模板数据条目中存在非 OrTplNItmDO 类型数据，请检查！";
			OrTplNItmDO orTplNItmDO = (OrTplNItmDO) objInfo;
			String tmpKey = String.format("%s-%s", orTplNItmDO.getId_ortmpl(), orTplNItmDO.getIdentical_ortmpl());
			if (!tmpGroupCache.containsKey(tmpKey)) {
				tmpGroupCache.put(tmpKey, new OrderTmplDetailList());
			}
			tmpGroupCache.get(tmpKey).add(orTplNItmDO);
		}
		return new OrderTmplGroupList(tmpGroupCache.values());
	}

	protected OrderTmplGroupListMap handleDriverTmplGroupInfo(CiEnContextDTO ctx, OrderTmplGroupList groupList)
			throws BizException {
		OrderTmplGroupListMap rstMap = new OrderTmplGroupListMap();
		for (OrderTmplDetailList item : groupList) {
			SrvMatchEmsRstDTO srvMatchEmsRstInfo = CiOrdUtils.getFuncClassStr(ctx, item.get(0).getId_srv(),
					item.get(0).getSd_srvtp());

			if (!rstMap.containsKey(srvMatchEmsRstInfo.getFuncclassstr())) {
				OrderTmplGroupList orTplNItmGroupList = new OrderTmplGroupList();
				orTplNItmGroupList.setSrvMatchEmsRstInfo(srvMatchEmsRstInfo);
				rstMap.put(srvMatchEmsRstInfo.getFuncclassstr(), orTplNItmGroupList);
			}
			rstMap.get(srvMatchEmsRstInfo.getFuncclassstr()).add(item);
		}
		return rstMap;
	}

	protected IEmsSaveBP handleSaveTmplInfo(CiEnContextDTO ctx, OrderTmplGroupList groupList) throws BizException {
		String funclassStr = groupList.getSrvMatchEmsRstInfo().getFuncclassstr();
		int nType = Integer.parseInt(CiOrdUtils.getEmsFunclassKVDTO(funclassStr).getEmstype());
	
		IEmsAction iTmplSaveBP = null;
		if (nType == COMMONDRUG) // 通用药品
		{
			iTmplSaveBP = new TmplDrugsAction();
		} else if (nType == RIS) // 检查
		{
			iTmplSaveBP = new TmplRisAction();
		} else if (nType == LIS) // 检验
		{
			iTmplSaveBP = new TmplLisAction();
		} else if (nType == IV) // Iv药
		{
			iTmplSaveBP = new TmplDrugsAction();
		} else if (nType == HERB) // 草药
		{
			iTmplSaveBP = new TmplHerbsAction();
		} else if (nType == OPER) // 手术
		{
			iTmplSaveBP = new TmplOprAction();
		} else if (nType == PATHGY) // 病理
		{
			iTmplSaveBP = new TmplPathgyAction();
		} else if (nType == BT) // 备血
		{
			iTmplSaveBP = new TmplDrugsAction();
		} else if (nType == COMMON) // 简洁
		{
			iTmplSaveBP = new TmplTreatAction();
		} else if (nType == CONS) // 会诊
		{
			iTmplSaveBP = new TmplConsAction();
		}
//		else if (nType == SKINTEST) // 皮试医疗单
//		{
//			
//		} 
		else if (nType == BTUSE) // 用血
		{
			iTmplSaveBP = new TmplApBtAction();
		} 
//		else if (nType == TRANSDEPT) // 转科
//		{
//
//		} else if (nType == OUTHOSP) // 出院
//		{
//
//		} else if (nType == TRANSWARD) // 转病区
//		{
//
//		}
		else{
			throw new BizException("没有匹配到医疗单");
		}
		
		return iTmplSaveBP;
	}
}

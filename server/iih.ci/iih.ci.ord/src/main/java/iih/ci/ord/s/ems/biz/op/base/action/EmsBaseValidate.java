package iih.ci.ord.s.ems.biz.op.base.action;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.itf.IEmsValidate;
import iih.ci.ord.s.ems.biz.meta.ErrorEmsList;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStatus;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsBaseValidate implements IEmsValidate{

	
	@Override
	public ErrorEmsList beforeSaveValidate(Object[] szOrderPackage) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms, CiEnContextDTO ctx)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 剂量和总量信息检查
	 * @param srvList
	 * @param errors
	 */
	protected void checkDrugQuanInfo(FArrayList srvList,List<String> errors){
		for(Object obj : srvList){
			EmsOrDrug srvItem = (EmsOrDrug)obj;
			if (srvItem.getFg_or()!= null && srvItem.getFg_or().booleanValue()){
				if (srvItem.getQuan_med()!= null && srvItem.getQuan_med().doubleValue() <= 0)
					errors.add(String.format("%s([%s]) 剂量必须大于 0", srvItem.getName_srv(),srvItem.getId_srv()));
				if(StringUtil.isEmpty(srvItem.getId_unit_med())||
						StringUtil.isEmpty(srvItem.getName_unit_med())){
					errors.add(String.format("%s([%s]) 计量单位不完整", srvItem.getName_srv(),srvItem.getId_srv()));
				}
				if (srvItem.getQuan_cur()!= null && srvItem.getQuan_cur().doubleValue() <= 0){
					errors.add(String.format("%s([%s]) 总量必须大于 0", srvItem.getName_srv(),srvItem.getId_srv()));
				}
				if(StringUtil.isEmpty(srvItem.getId_unit_sale())||
						StringUtil.isEmpty(srvItem.getName_unit_sale())){
					errors.add(String.format("%s([%s]) 总量单位不完整", srvItem.getName_srv(),srvItem.getId_srv()));
				}
			}
		}
	}
	/**
	 * 药品库存判断
	 * @param srvList
	 * @param errors
	 * @throws BizException
	 */
	protected void checkMmStockInfo(FArrayList srvList,List<String> errors) throws BizException{
		List<GetStockReqDTO> reqDtos = new ArrayList<GetStockReqDTO>();

		for(Object obj : srvList){
			EmsOrDrug emsDTO = (EmsOrDrug)obj;
			if(FBoolean.TRUE.equals(emsDTO.getFg_mm())&& emsDTO.getStatus()!=DOStatus.DELETED && emsDTO.getFg_self()!=FBoolean.TRUE){
				GetStockReqDTO reqDTO = new GetStockReqDTO();
				reqDTO.setId_mm(emsDTO.getId_mm());
				reqDTO.setId_dep(emsDTO.getId_dep_wh()) ;
				reqDTO.setReq_unit_id(emsDTO.getId_unit_sale());
				reqDtos.add(reqDTO);
			}
		}
		if(reqDtos.size()>0){
			IMaterialStockService stoctService = ServiceFinder.find(IMaterialStockService.class);
			MaterialStockDTO[] stockdto=stoctService.getMaterialStocks(reqDtos.toArray(new GetStockReqDTO[reqDtos.size()]));
			for(Object obj : srvList){
				EmsOrDrug emsDTO = (EmsOrDrug)obj;
				for(MaterialStockDTO materialDo : stockdto){
					if(!materialDo.getId_mm().equals(emsDTO.getId_mm()))continue;
					if (materialDo.getMmstatus() == (int)MaterialStatus.NORELATION)
					{
						errors.add(String.format("服务：%s,药房无此药！",emsDTO.getName_srv() ));
					}
					else if (materialDo.getMmstatus() == (int)MaterialStatus.STOP)
					{
						errors.add(String.format("服务：%s,已停发！",emsDTO.getName_srv() ));
					}
					else if (emsDTO.getQuan_cur()!=null && materialDo.getQuan_usable().toDouble() < emsDTO.getQuan_cur().toDouble())
					{
						errors.add(String.format("服务：%s,库存不足！",emsDTO.getName_srv() ));
					}
				}
			}
		}
	}
	
	/**
	 * 空药品项目检查
	 * @param srvList
	 * @param errors
	 */
	protected void checkEmptyDrugInfo(EmsOrDrug srvItem,List<String> errors){

		if (srvItem.getFg_or()!= null && srvItem.getFg_or().booleanValue()){
			if (StringUtil.isEmpty(srvItem.getId_srv())||
					StringUtil.isEmpty(srvItem.getName_srv())||
					StringUtil.isEmpty(srvItem.getSd_srvtp())||
					StringUtil.isEmpty(srvItem.getInnercode_srvca()))
				errors.add("医疗单中存在空服务信息");
			else if (FBoolean.TRUE.equals(srvItem.getFg_mm()) && ( StringUtil.isEmpty(srvItem.getId_mm())||
					StringUtil.isEmpty(srvItem.getName_mm()))){
				errors.add(String.format("%s([%s]) 没有物品信息", srvItem.getName_srv(),srvItem.getId_srv()));
			}
		}
	}
	/**
	 * 就诊信息校验
	 * @param ctx
	 * @param errorList
	 */
	protected void checkPatDiInfo(CiEnContextDTO ctx, List<String> errorList){
		if (StringUtil.isEmpty(ctx.getId_en())||
				StringUtil.isEmpty(ctx.getId_entp())||
				StringUtil.isEmpty(ctx.getId_pat()))
		{
			errorList.add("医疗单就诊相关信息不完整，请重新检查");
		}
	}
}

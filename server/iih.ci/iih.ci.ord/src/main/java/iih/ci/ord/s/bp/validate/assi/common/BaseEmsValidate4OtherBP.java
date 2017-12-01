package iih.ci.ord.s.bp.validate.assi.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医疗单基础检查
 * @author qzwang
 *
 */
public class BaseEmsValidate4OtherBP implements IEmsValidate4OtherBP {

	@Override
	public boolean exec(CiEmsDTO emsDTO,List<String> errorList) throws BizException {
		// TODO Auto-generated method stub
		return true;
	}
	
	protected void checkQuanMed(CiEmsDTO emsDTO,List<String> errorList){
		
	}
	/**
	 * 成组药品检查
	 * @param emsDTO
	 */
	protected void checkCombDurgInfo(CiEmsDTO emsDTO,List<String> errorList){
		if (emsDTO.getEmssrvs().size() > 1)
		{
			CanCombDrugValidateBP bp = new CanCombDrugValidateBP();
			
			bp.exec(emsDTO,errorList);
		}
		
	}
	
	/**
	 * 服务频次检查
	 * @param emsDTO
	 * @param errors
	 */
	protected void checkSrvFreqInfo(CiEmsDTO emsDTO,List<String> errors){
		if (StringUtil.isEmpty(emsDTO.getId_freq()) ||
				StringUtil.isEmpty(emsDTO.getName_freq())||
				StringUtil.isEmpty(emsDTO.getSd_frequnitct())){
			errors.add("频次信息不完整");
		}
	}
	
	protected void checkSrvRouteInfo(CiEmsDTO emsDTO,List<String> errors){
		// TODO: 
	}
	
	/**
	 * 相同药品检查
	 * @param srvList
	 * @param errors
	 */
	protected void checkSameDrugInfo(FArrayList srvList,List<String> errors){
		Map<String,Object> filterMap = new HashMap<String,Object>();
		for(Object obj : srvList){
			CiEmsSrvDTO srvItem = (CiEmsSrvDTO)obj;
			if (srvItem.getFg_or() == FBoolean.TRUE){
				if (filterMap.containsKey(srvItem.getId_mm())){
					errors.add(String.format("%s([%s]) 已经存在", srvItem.getName_mm(),srvItem.getId_mm()));
				}
				else{
					filterMap.put(srvItem.getId_mm(), srvItem);
				}
			}
		}
		
	}

	/**
	 * 空药品项目检查
	 * @param srvList
	 * @param errors
	 */
	protected void checkEmptyDrugInfo(FArrayList srvList,List<String> errors){
		
		for(Object obj : srvList){
			CiEmsSrvDTO srvItem = (CiEmsSrvDTO)obj;
			if (srvItem.getFg_or()!= null && srvItem.getFg_or().booleanValue()){
				if (StringUtil.isEmpty(srvItem.getId_srv())||
						StringUtil.isEmpty(srvItem.getName_srv())||
						StringUtil.isEmpty(srvItem.getSd_srvtp())||
						StringUtil.isEmpty(srvItem.getInnercode_srvca()))
					errors.add("医疗单中存在空服务信息");
				else if (srvItem.getFg_mm() == FBoolean.TRUE && ( StringUtil.isEmpty(srvItem.getId_mm())||
						StringUtil.isEmpty(srvItem.getName_mm()))){
					errors.add(String.format("%s([%s]) 没有物品信息", srvItem.getName_srv(),srvItem.getId_srv()));
				}
			}
		}
	}
	
	/**
	 * 剂量和总量信息检查
	 * @param srvList
	 * @param errors
	 */
	protected void checkDrugQuanInfo(FArrayList srvList,List<String> errors){
		for(Object obj : srvList){
			CiEmsSrvDTO srvItem = (CiEmsSrvDTO)obj;
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
	 * 用药医嘱天数检查
	 * @param emsDTO
	 * @param errors
	 */
	protected void checkUseDayInfo(CiEmsDTO emsDTO,List<String> errors){
		if (!emsDTO.getCode_entp().equals(iih.bd.bc.udi.pub.IBdFcDictCodeConst.SD_CODE_ENTP_IP) && emsDTO.getDays_or()==null && emsDTO.getDays_or().intValue()<= 0){
			 
			errors.add(String.format("%s([%s]) 使用天数必须大于0", emsDTO.getName(),emsDTO.getId_srv()));
		}
	}
	/**
	 * 草药煎法不能为空
	 * @param ems
	 * @param errorList
	 */
    protected void checkBoilInfo(CiEmsDTO ems, List<String>errorList){
		if (StringUtil.isEmpty(ems.getId_boil())){
			errorList.add(ems.getName()+" 草药煎法不能为空");
		}
	}
	/**
	 * 草药的剂数不能为空
	 * @param ems
	 * @param errorList
	 */
    protected void checkOrdersInfo(CiEmsDTO ems, List<String>errorList){
		if (ems.getOrders() > 0){
			errorList.add(ems.getName()+" 草药剂数");
		}
	}
}

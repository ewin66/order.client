package iih.ci.ord.s.bp.splitlis.pku.rule;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.i.splitpres.ICiOrPresSplitRule;
import iih.ci.ord.s.bp.splitlis.pku.PKUSplitConst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
/**
 * 8.	数量：单张医保最多为四个，自费为五个，当前是5个
 * @author li_zheng
 *
 */
public class PKUNumberSplitRule implements ICiOrPresSplitRule {
	 
//	Map<String, List> ciorderMap = new HashMap<String, List>();
//	Map<Integer, List> sizeMap = new HashMap<Integer, List>();
//	public List<List<CiOrPresSplitList>> orsplit = new ArrayList<List<CiOrPresSplitList>>();
	List<CiOrPresSplitList> outList;
	// 金额 配置文件 srvtype ,srvOrname issrvTporNama count ant
	/**
	 * 
	 * (non-Javadoc)
	 * 
	 * @see iih.ci.ord.s.bp.splitpres.PresSplitBaseRule#exec(java.util.List)
	 */
	@Override
	public List<CiOrPresSplitList> exec(List<CiOrPresSplitList> list)
			throws BizException {
		// TODO Auto-generated method stub
		if (list == null || list.size() == 0) return list;
		outList = new ArrayList();
		// 按数量
		for (CiOrPresSplitList orderPreslist : list) {
			if (orderPreslist != null && orderPreslist.isAppRule) {
				List<OrderPresSplitDTO> orderList = orderPreslist
						.getOrderList();
				if (orderList != null && orderList.size() > 0) {
					// 判断是否是草药，草药不参数与个数分方
					// 判断 list 个数 和 类型 医保和非医保 医保 4个，非医保 5
					if(!JudgeHerbalDrug(orderList)){
						if(orderPreslist.getFg_hp_pres() ==FBoolean.TRUE){
							SplitOrderList(orderPreslist,PKUSplitConst.MedicalNum);
						}else{
							SplitOrderList(orderPreslist,PKUSplitConst.NUM);
						}
					 }else{
						 if(orderPreslist.getFg_hp_pres() != null
									&&orderPreslist.getFg_hp_pres().equals("1")){
									SplitOrderList(orderPreslist,PKUSplitConst.herbsNum);//草药没有限制
								}else{
									SplitOrderList(orderPreslist,PKUSplitConst.herbsNum);//草药没有限制
								}
					 }
				}
			}else{
				outList.add(orderPreslist);
			}
		}
		return outList;
	}

	/**
	 * 按数量分组
	 * @param orderPreslist
	 * @param num
	 */
	private void  SplitOrderList(CiOrPresSplitList ps,int num){
		List<OrderPresSplitDTO> orderList = ps.getOrderList();
		 int size = orderList.size();
		 int cycleTimes = size%num==0?size/num:size/num+1;
		 int i= 0;
		 for(int j=0;j<cycleTimes;j++){
			    CiOrPresSplitList newOrderPresSplit = new CiOrPresSplitList();
				newOrderPresSplit.setName(ps.getName());
				newOrderPresSplit.setCode(ps.getCode());
				newOrderPresSplit.setSd_pres(ps.getSd_pres());
				newOrderPresSplit.setId_prestp(ps.getId_prestp());
				newOrderPresSplit.setSd_prestpword(ps.getSd_prestpword());
				newOrderPresSplit.setId_prestpword(ps.getId_prestpword());
				List<OrderPresSplitDTO> tempList = new ArrayList();
				newOrderPresSplit.setOrderList(tempList);
				outList.add(newOrderPresSplit);
				 for(;i<size;i++){
					 tempList.add(orderList.get(i));
	                 if(i >0 && i%(num-1)==0){
	                	i=i+1; 
	                	break;
	                 }
				 }
		 }
	}
	
	
	/**
	 * 判断是否全是草药
	 * @param orderList
	 * @return
	 */
	private boolean JudgeHerbalDrug(List<OrderPresSplitDTO> orderList){
		Boolean isHerbalDrug = false;
		 for(OrderPresSplitDTO dto:orderList){
			if(dto.getSd_srvtp() != null && dto.getSd_srvtp().startsWith("0103")){
				isHerbalDrug = true;
			}else{
				return false;
			}
		 }
		return isHerbalDrug;
	}
	
	
	/**
	 * 
	 * @param sum
	 * @param ant
	 * @return
	 */
	private Boolean isDoule(FDouble sum, Double ant) {
        
		if(sum == null ) return false;
		int retval = Double.compare(sum.doubleValue(), ant);

		if (retval > 0) {
			return true;
		} else if (retval < 0) {
			return false;
		}
		return false;
	}

	/**
	 * 按金额和数量分方后的数据
	 * 
	 * @param outlist
	 * @param AntAndNumList
	 * @param orderPreslist
	 */
	private void GetOutList(List<CiOrPresSplitList> outlist,
			CiOrPresSplitList orderPreslist) {
			CiOrPresSplitList newOrderPresSplit = new CiOrPresSplitList();
			newOrderPresSplit.setName(orderPreslist.getName());
			newOrderPresSplit.setCode(orderPreslist.getCode());
			newOrderPresSplit.setSd_pres(orderPreslist.getSd_pres());
			newOrderPresSplit.setId_pres(orderPreslist.getId_pres());
			//newOrderPresSplit.setOrderList(antAndNumlist);
			outlist.add(newOrderPresSplit);
	}

	// 每张处方的药品不得超过5个（每条药物医嘱不能超过5个服务），中草药除外
	// 某一类药品的种类控制数量可以配置。（如：类型【抗生素】 每张处方最大数量【2】；
	// 类型【麻醉药品】 每张处方最大数量【2】
	// ；类型【毒性药品】 每张处方最大数量【1】；类型【中草药】 每张处方最大数量【30】）
	// 某一类药品的种类控制数量可以配置。（如：类型【抗生素】 每张处方最大数量【2】；
	// 类型【麻醉药品】 每张处方最大数量【2】；类型【毒性药品】 每张处方最大数量【1】；
	// 类型【中草药】 每张处方最大数量【30】）

	// 根据医院或者医保要求，处方金额不得超过【500.00】元，超过部分需要分方

	/**
	 * 临时 以后读取配置文件 TODO
	 * 
	 * @return
	 */
	private Map GetMapAntAndNum() {
		Map<String, String[]> map = new HashMap<String, String[]>();
		// 服务类型 数量 金额 名称
		map.put("010101", new String[] { "5", "500", "注射类药品" });
		map.put("010102", new String[] { "5", "500", "大输液（配液、溶媒）" });
		map.put("010103", new String[] { "5", "500", "皮试液" });
		map.put("010104", new String[] { "5", "500", "注射类抗生素（为了展现用药目的和皮试相关）" });
		map.put("010201", new String[] { "30", "500", "中药" });
		map.put("010202", new String[] { "30", "500", "蒙药" });
		map.put("010301", new String[] { "5", "500", "口服药品" });
		map.put("010302", new String[] { "5", "500", "外用药品" });

		return map;

	}
}

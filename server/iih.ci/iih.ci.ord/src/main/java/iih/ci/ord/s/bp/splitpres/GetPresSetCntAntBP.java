package iih.ci.ord.s.bp.splitpres;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
/**
 *  按金额和数量分方
  * @ClassName: GetPresSetCntAntBP
  * @Description: TODO
  * @author Comsys-li_zheng
  * @date 2016年10月9日 下午3:17:22
  * @Package iih.ci.ord.s.bp.splitpres
  * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class GetPresSetCntAntBP implements PresSplitBaseRule {

	Map<String, List> ciorderMap = new HashMap<String, List>();
	Map<Integer, List> sizeMap = new HashMap<Integer, List>();
	List<List<OrderPresSplitDTO>> orsplit = new ArrayList<List<OrderPresSplitDTO>>();

	// 金额 配置文件 srvtype ,srvOrname issrvTporNama count ant
	/**
	 * 
	 * (non-Javadoc)
	 * 
	 * @see iih.ci.ord.s.bp.splitpres.PresSplitBaseRule#exec(java.util.List)
	 */
	@Override
	public List<OrderPresSplitList> exec(List<OrderPresSplitList> list)
			throws BizException {
		// TODO Auto-generated method stub
		if (list == null || list.size() == 0)
			return null;

		List<OrderPresSplitList> outlist = new ArrayList<OrderPresSplitList>();
		// 金额排序
		SortOrderPresSplitList(list);
		// 按数量和金额分方

		for (OrderPresSplitList orderPreslist : list) {
			if (orderPreslist != null) {

				Double ant = new Double(Double.MAX_VALUE);

				List<OrderPresSplitDTO> orderList = orderPreslist
						.getOrderList();
				if (orderList != null && orderList.size() > 0) {
					orsplit.clear();
					List<List<OrderPresSplitDTO>> AntAndNumList = null;
					if(JudgeHerbalDrug(orderList)){
						 AntAndNumList = AntAndNumberSplit(
								orderList, PresConstant.HERBAL_DRUG, PresConstant.HERBAL_DRUGANT);
					}else{
						 AntAndNumList = AntAndNumberSplit(
								orderList, PresConstant.NUM, PresConstant.ant);
					}
					this.GetOutList(outlist, AntAndNumList, orderPreslist);
				}
			}
		}
		return outlist;
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
	 * 分方之前排序
	 * 
	 * @param list
	 */
	private void SortOrderPresSplitList(List<OrderPresSplitList> list) {

		for (OrderPresSplitList orderPreslist : list) {
			if (orderPreslist != null) {
				List<OrderPresSplitDTO> orderPresDTOList = orderPreslist
						.getOrderList();
				if (orderPresDTOList != null && orderPresDTOList.size() > 0) {
					Sort(orderPresDTOList);
				}
			}
		}
	}

	/**
	 * 分方之前排序
	 * 
	 * @param orderPresDTOList
	 */
	private void Sort(List<OrderPresSplitDTO> orderPresDTOList) {
		for (int i = 0; i < orderPresDTOList.size() - 1; i++) {
			for (int j = 1; j < orderPresDTOList.size() - i; j++) {
				OrderPresSplitDTO a;
				if((orderPresDTOList.get(j - 1)).getPri()==null||(orderPresDTOList.get(j)).getPri()==null)
					continue;
				if ((orderPresDTOList.get(j - 1)).getPri().compareTo(
						orderPresDTOList.get(j).getPri()) > 0) { // 比较两个整数的大小
					a = orderPresDTOList.get(j - 1);
					orderPresDTOList.set((j - 1), orderPresDTOList.get(j));
					orderPresDTOList.set(j, a);
				}
			}
		}
	}

	/**
	 * 按数量 和金额 分方
	 * 
	 * @param orderPresDTOList
	 * @param num
	 * @param ant
	 * @return
	 */
	private List<List<OrderPresSplitDTO>> AntAndNumberSplit(
			List<OrderPresSplitDTO> orderPresDTOList, int num, Double ant) throws BizException{
		if (orderPresDTOList != null && orderPresDTOList.size() > 0) {
			FDouble sum = new FDouble(0f);
			int i = 0;
			List<List<OrderPresSplitDTO>> list = new ArrayList<List<OrderPresSplitDTO>>();
			List<OrderPresSplitDTO> newList = new ArrayList<OrderPresSplitDTO>();
			this.ciorderMap.clear();
			List<OrderPresSplitDTO> countnewList = new ArrayList<OrderPresSplitDTO>();

			boolean flag = false;
			for (OrderPresSplitDTO dto : orderPresDTOList) {
				if(dto.getPri() == null || dto.getQuan_cur() == null){
					//throw new BizException("物品的参考价格 为空");
					 // todo  待完善
				}else{
				 sum = sum.add(dto.getPri().multiply(dto.getQuan_cur()==null?new FDouble(1):dto.getQuan_cur()));
				}
				
				if (this.isDoule(dto.getPri(), ant)) {
					List<OrderPresSplitDTO> antnewList = new ArrayList<OrderPresSplitDTO>();
					list.add(antnewList);
					continue;
				}
				if (this.isDoule(sum, ant) || newList.size() == num) {
					// list.add(newList);
					// newList=new ArrayList<OrderPresSplitDTO>();
					// sum = new FDouble(1f) ;
					// // list.add(countnewList);
					// newList.add(dto);
					flag = true;
					splitByor(orderPresDTOList, num,ant);
					break;
				} else {
					newList.add(dto);
					// if(orderPresDTOList.size()==1)
					// list.add(newList);
					
				}

			}

			if (flag == false) {
				list.add(newList);
			} else {
				
               list=this.orsplit;
				
			}
			return list;
		}
		return null;
	}

	private void splitByor(List<OrderPresSplitDTO> orderPresDTOList,int num, Double ant) {
		Map<String, FDouble> priMap = new HashMap<String, FDouble>();
		List<OrderPresSplitDTO> ciorlist = new ArrayList<OrderPresSplitDTO>();
		for (OrderPresSplitDTO dto : orderPresDTOList) {

			if (this.ciorderMap.containsKey(dto.getId_or())) {
				
				//单价大于总金额 单独分一个方子
				if (this.isDoule(dto.getPri(), ant)) {
					List<OrderPresSplitDTO> newcilist = new ArrayList<OrderPresSplitDTO>();
					newcilist.add(dto);
					orsplit.add(newcilist);
					continue;
				}
                //取出同一个or下的方子
				List<OrderPresSplitDTO> cilist = this.ciorderMap.get(dto
						.getId_or());

				FDouble sum = priMap.get(dto.getId_or());
				if(dto.getPri() != null && dto.getQuan_cur() != null){
					sum = sum.add(dto.getPri().multiply(dto.getQuan_cur()==null?new FDouble(1):dto.getQuan_cur()));	
				}else{
					sum = sum.add(0.0);	
				}
				
				if (this.isDoule(sum, ant)) {
					orsplit.add(cilist);
					this.ciorderMap.remove(dto.getId_or());

				} else {
					if (cilist.size() == (num-1)) {
						cilist.add(dto);
						orsplit.add(cilist);
						this.ciorderMap.remove(dto.getId_or());
					} else {
						cilist.add(dto);
						priMap.put(dto.getId_or(), sum);
					}
				}

			} else {
				if (this.isDoule(dto.getPri(), ant)) {
					List<OrderPresSplitDTO> newcilist = new ArrayList<OrderPresSplitDTO>();
					newcilist.add(dto);
					orsplit.add(newcilist);
					continue;
				} else {
					List<OrderPresSplitDTO> cilist = new ArrayList<OrderPresSplitDTO>();
					cilist.add(dto);

					this.ciorderMap.put(dto.getId_or(), cilist);
					FDouble sum = new FDouble(0.0);
					if(dto.getPri() != null && dto.getQuan_cur() != null){
						 sum = dto.getPri().multiply(dto.getQuan_cur()==null?new FDouble(1):dto.getQuan_cur());
						
					}else{
						sum  = new FDouble(0.0);
					}
					
					priMap.put(dto.getId_or(), sum);
				}

			}

		}

		Iterator entrys = this.ciorderMap.entrySet().iterator();
		while (entrys.hasNext()) {
			Map.Entry entry = (Map.Entry) entrys.next();
			String key = (String) entry.getKey();
			List<OrderPresSplitDTO> cilist = this.ciorderMap.get(key);
			ciorlist.addAll(cilist);
		}

		List<List<OrderPresSplitDTO>> list = new ArrayList<List<OrderPresSplitDTO>>();
		List<OrderPresSplitDTO> newList = new ArrayList<OrderPresSplitDTO>();
		this.ciorderMap.clear();
		List<OrderPresSplitDTO> countnewList = new ArrayList<OrderPresSplitDTO>();
		FDouble sum = new FDouble(0f);
		boolean flag = false;
		for (OrderPresSplitDTO dto : ciorlist) {

			if(dto.getPri() != null && dto.getQuan_cur() != null){
				 sum = dto.getPri().multiply(dto.getQuan_cur()==null?new FDouble(1):dto.getQuan_cur());
				
			}else{
				sum  = new FDouble(0.0);
			}
			if (this.isDoule(sum, ant) || newList.size() == num) {
				orsplit.add(newList);
				 newList=new ArrayList<OrderPresSplitDTO>();
				 sum = new FDouble(1f) ;
				 // list.add(countnewList);
				 newList.add(dto);
//				flag = true;
//				splitByor(orderPresDTOList, ant);
			} else {
				newList.add(dto);
				// if(orderPresDTOList.size()==1)
				// list.add(newList);
				
				
			}

		}
		orsplit.add(newList);

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
	private void GetOutList(List<OrderPresSplitList> outlist,
			List<List<OrderPresSplitDTO>> AntAndNumList,
			OrderPresSplitList orderPreslist) {

		if (AntAndNumList != null && AntAndNumList.size() > 0) {
			for (List<OrderPresSplitDTO> antAndNumlist : AntAndNumList) {
				OrderPresSplitList newOrderPresSplit = new OrderPresSplitList();
				newOrderPresSplit.setName(orderPreslist.getName());
				newOrderPresSplit.setCode(orderPreslist.getCode());
				newOrderPresSplit.setSd_pres(orderPreslist.getSd_pres());
				newOrderPresSplit.setId_pres(orderPreslist.getId_pres());
				newOrderPresSplit.setOrderList(antAndNumlist);
				outlist.add(newOrderPresSplit);
			}

		}

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

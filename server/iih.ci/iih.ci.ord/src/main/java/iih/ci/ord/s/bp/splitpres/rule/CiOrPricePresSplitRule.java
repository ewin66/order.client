package iih.ci.ord.s.bp.splitpres.rule;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.i.splitpres.ICiOrPresSplitRule;
import iih.ci.ord.s.bp.splitpres.PresConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;

/**
 * 
 * @author li_cheng 临床医嘱分方规则：金额和数量分方规则
 */
public class CiOrPricePresSplitRule implements ICiOrPresSplitRule {

	List<CiOrPresSplitList> outList;

	@Override
	public List<CiOrPresSplitList> exec(List<CiOrPresSplitList> list) throws BizException {
		// TODO Auto-generated method stub
		// 根据药品的属性 TODO

		outList = new ArrayList<CiOrPresSplitList>();
		if (list != null) {
			AnalyzeOrderPresSplitList(list);
		}
		return outList;
	}

	/**
	 * 
	 * @param orderpresSplitList
	 */
	private void AnalyzeOrderPresSplitList(List<CiOrPresSplitList> orderpresSplitList) {
		for (CiOrPresSplitList orderPresSplit : orderpresSplitList) {
			double pri_total = PresConstant.ant;
			int num = PresConstant.NUM;
			List<OrderPresSplitDTO> orderList = orderPresSplit.getOrderList();

			if (isMental(orderPresSplit)) {

				pri_total = PresConstant.Mental_DRUGANT;
				num = PresConstant.Mentalant;
			} else if (isHerb(orderPresSplit)) {

				pri_total = PresConstant.HERBAL_DRUGANT;
				num = PresConstant.HERBAL_DRUG;
			}
			List<CiOrPresSplitList> cipreslist = AnalyzeOrderPresSplitDTO(orderList, pri_total, num);
			this.getOrderPresSplitList(orderPresSplit, cipreslist);

		}
	}

	/**
	 * 按价格分类
	 * 
	 * @param orderList
	 * @return
	 */
	private List<CiOrPresSplitList> AnalyzeOrderPresSplitDTO(List<OrderPresSplitDTO> orderListp, double pri_total, int num) {

		double sum = 0;
		List<OrderPresSplitDTO> orderList = sort8pri(orderListp);
		List<CiOrPresSplitList> cipreslist = new ArrayList<CiOrPresSplitList>();
		for (OrderPresSplitDTO orderPresSplitDTO : orderList) {

			sum = sum + (orderPresSplitDTO.getPri() == null ? 0 : (orderPresSplitDTO.getPri().getDouble() * orderPresSplitDTO.getQuan_cur().getDouble()));

			if (sum > pri_total ||(cipreslist.size() != 0 &&cipreslist.get(cipreslist.size() - 1).getOrderList().size() == num)) {

				CiOrPresSplitList ciOrPresSplit = new CiOrPresSplitList();
				ciOrPresSplit.setOrderList(new ArrayList<OrderPresSplitDTO>());
				cipreslist.add(ciOrPresSplit);
				ciOrPresSplit.getOrderList().add(orderPresSplitDTO);
				sum = orderPresSplitDTO.getPri() == null ? 0 : orderPresSplitDTO.getPri().getDouble() * orderPresSplitDTO.getQuan_cur().getDouble();


			} else {
				if(cipreslist.size()==0){
					CiOrPresSplitList ciOrPresSplit = new CiOrPresSplitList();
					ciOrPresSplit.setOrderList(new ArrayList<OrderPresSplitDTO>());
					cipreslist.add(ciOrPresSplit);
				}
					cipreslist.get(cipreslist.size() - 1).getOrderList().add(orderPresSplitDTO);				
			   }
		}

		return cipreslist;
	}

	/**
	 * 返回的集合
	 * 
	 * @return
	 */
	private List<CiOrPresSplitList> getOrderPresSplitList(CiOrPresSplitList ps, List<CiOrPresSplitList> cipreslist) {

		for (CiOrPresSplitList ciOrPresSplitList : cipreslist) {

			ciOrPresSplitList.setName(ps.getName());
			ciOrPresSplitList.setCode(ps.getCode());
			ciOrPresSplitList.setSd_pres(ps.getSd_pres());
			ciOrPresSplitList.setId_pres(ps.getId_pres());
			outList.add(ciOrPresSplitList);
		}

		return outList;
	}

	private boolean isHerb(CiOrPresSplitList ciOrPresSplitList) {
		boolean flag = false;
		if (!ciOrPresSplitList.getSd_pres().equals(PresConstant.SD_MENTAL1) && !ciOrPresSplitList.getSd_pres().equals(PresConstant.SD_MENTAL2)) {
			if (ciOrPresSplitList.getOrderList().get(0).getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG))
				flag = true;
		}

		return flag;
	}

	private boolean isMental(CiOrPresSplitList ciOrPresSplitList) {
		boolean flag = false;
		if (ciOrPresSplitList.getSd_pres().equals(PresConstant.SD_MENTAL1) || ciOrPresSplitList.getSd_pres().equals(PresConstant.SD_MENTAL2)) {
			flag = true;
		}

		return flag;
	}
/**
 * 按医嘱和总价排序
 * @param orderList
 * @return
 */
	private List<OrderPresSplitDTO> sort8pri(List<OrderPresSplitDTO> orderList) {

		List<OrderPresSplitDTO> orderListrnt = new ArrayList<OrderPresSplitDTO>();
        Map<String, List<OrderPresSplitDTO>> orderListnewmap=new HashMap<String, List<OrderPresSplitDTO>>();
        List<String> orlist=new ArrayList<>();
		for (OrderPresSplitDTO orderPresSplitDTO : orderList) {

			Boolean flag = false;
            if(orderListnewmap.containsKey(orderPresSplitDTO.getId_or())){
            	List<OrderPresSplitDTO> orderListnew = orderListnewmap.get(orderPresSplitDTO.getId_or());
            	for (int j = 0; j < orderListnew.size(); j++) {
    				Double odpri=(orderPresSplitDTO.getPri()==null?0:orderPresSplitDTO.getPri().doubleValue()* orderPresSplitDTO.getQuan_cur().doubleValue()); 
    				Double odnewpri=(orderListnew.get(j).getPri()==null?0:orderListnew.get(j).getPri().doubleValue()* orderListnew.get(j).getQuan_cur().doubleValue()); 
    				if (odpri <= odnewpri) {

    					orderListnew.add(j, orderPresSplitDTO);
    					flag = true;
    					break;
    				}
    			}
    			if (!flag)
    				orderListnew.add(orderPresSplitDTO);
            }else{
            	List<OrderPresSplitDTO> orderListnew = new ArrayList<OrderPresSplitDTO>();
            	orderListnew.add(orderPresSplitDTO);
            	orderListnewmap.put(orderPresSplitDTO.getId_or(), orderListnew);
            	orlist.add(orderPresSplitDTO.getId_or());
            }
			
		}
		for (String o : orlist) {
			 Collections.addAll(orderListrnt, orderListnewmap.get(o).toArray(new OrderPresSplitDTO[0]));
		}

		return orderListrnt;
	}

}

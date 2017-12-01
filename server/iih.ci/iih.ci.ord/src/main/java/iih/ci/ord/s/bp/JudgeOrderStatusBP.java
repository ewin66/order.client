package iih.ci.ord.s.bp;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 判断医嘱的状态是否有变化
 * @author li_zheng
 *
 */
public class JudgeOrderStatusBP {
    /**
     * 判断医嘱状态是否变化
     * @param orders
     * @return  true  有变化，fasle 没有变化
     * @throws BizException
     */
	public String exe(CiOrderDO[] orders)throws BizException{
		if(orders != null  && orders.length >0){
		   CiOrderDO[] newCiorders = CiOrdAppUtils.getOrQryService().findByIds(getOrdIds(orders), FBoolean.FALSE);
		   return JudgeOrderStatus(orders,newCiorders);
		}
		return  "";
	}
	/**
	 * 医嘱的 id 集合
	 * @return
	 */
	private String[] getOrdIds(CiOrderDO[] orders){
		String[] ids = new String[orders.length];
		 int i = 0;
		 for(CiOrderDO order:orders){
			ids[i]= order.getId_or();
			i++;
		 }
		return ids;
	}
	
	/**
	 * 
	 * @param orders
	 * @param newCiorders
	 * @return
	 */
	private String JudgeOrderStatus(CiOrderDO[] orders, CiOrderDO[] newCiorders) {

		StringBuffer bufferMsg = new StringBuffer();
		String lineSeparator = System.getProperty("line.separator", "\n");

		if (newCiorders == null || newCiorders.length == 0 || orders.length != newCiorders.length)
			return "数据异常，请刷新界面";
		
		for (int i = 0; i < orders.length; i++) {
			for (int j = 0; j < newCiorders.length; j++) {
				if (orders[i].getId_or().equals(newCiorders[j].getId_or())) {
					if (!orders[i].getSv().equals(newCiorders[j].getSv())) {
						bufferMsg.append(orders[i].getName_or()).append(lineSeparator);
					}
				}
			}
		}
		if (bufferMsg.length() > 0) {
			bufferMsg.append("数据已被修改，请刷新医嘱列表");
		}
		return bufferMsg.toString();
	}
}

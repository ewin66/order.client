package iih.ci.ord.s.bp.orsms.lis.cfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.srv.notice.d.MedNoticeDO;
import iih.bd.srv.notice.i.IMednoticeRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.s.bp.orsms.lis.getOrdPriceBP;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsMergeUtils {
	
	/**
	 * 计算医嘱价格
	 * @param ciors
	 * @return
	 * @throws BizException
	 */
	public static Map<String, FDouble> GetOrdPriceMap(CiOrderDO[] ors) throws BizException {

		if (ors == null || ors.length == 0)
			return null;
		String[] ids = new String[ors.length];
		int i = 0;
		for (CiOrderDO ci : ors) {
			ids[i++] = ci.getId_or();
		}
		Map<String, FDouble> map = new HashMap<String, FDouble>();
		
		ICiorderRService service = ServiceFinder.find(ICiorderRService.class);
		CiorderAggDO[] aggs = service.findByIds(ids, FBoolean.FALSE);
//		CiorderAggDO[] aggs =getCiOrdAgg( ors);//li_cheng 封装查询ciorderagg的方法
		for (CiorderAggDO ordAggDO : aggs){
			BaseDO[] childrenDO = ordAggDO.getChildrenDO();
			FDouble totalPrice = FDouble.ZERO_DBL;
			for (BaseDO o : childrenDO){
				OrdSrvDO srvDO = (OrdSrvDO)o;
				// 条件：费用标志fg_bl = 'Y' && eu_sourcemd in (开立、派生（套)、派生（组合）)
				if (srvDO.getFg_bl()!= null && 
						srvDO.getFg_bl().booleanValue() && 
						srvDO.getEu_sourcemd() != null && 
						(srvDO.getEu_sourcemd().intValue()==OrSrvSourceFromEnum.PHYSIAN||
						srvDO.getEu_sourcemd().intValue()==OrSrvSourceFromEnum.AGENTFROMPRIMD||
						srvDO.getEu_sourcemd().intValue()==OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD)){
					if (srvDO.getFg_mm() != null && srvDO.getFg_mm().booleanValue()){
						// 物品价格处理 -- 暂时没有这种场景--后续扩展
						//totalPrice = totalPrice.add(srvDO.getPri().multiply(srvDO.getQuan_total_medu()));
					}
					else{
						if (srvDO.getPri() != null && srvDO.getQuan_total_medu() != null)
							totalPrice = totalPrice.add(srvDO.getPri().multiply(srvDO.getQuan_total_medu()));
					}
				}
			}
			map.put(ordAggDO.getParentDO().getId_or(), totalPrice);
		}
		return map;
	}
	
	/**
	 * 获取注意事项描述
	 * @param id_notices
	 * @return
	 * @throws BizException
	 */
	public static String GetNoticeDescByIds(String id_notices) throws BizException{
		
		IMednoticeRService serviceImp = ServiceFinder.find(IMednoticeRService.class);
		
		if (serviceImp == null || StringUtils.isEmpty(id_notices)){
			return "";
		}
		
		MedNoticeDO[] mns = serviceImp.findByBIds(id_notices.replace(" ", "").split(","), FBoolean.FALSE);
		if (mns == null || mns.length == 0){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int index = 1;
		for(MedNoticeDO item : mns){
			sb.append(index++).append(".").append(item.getName()).append("&");
		}
		return sb.substring(0, sb.length() -1);
	}
	
	/**
	 * 罗马数字转十进制数 
	 * @param number
	 * @return
	 */
	public static int ConvertRomanToDecimal(String number)  
	{  
	    Map<String, Integer> dic = new HashMap<String, Integer>();  
	    dic.put("M", 1000);  
	    dic.put("CM", 900);  
	    dic.put("D", 500);  
	    dic.put("CD", 400);  
	    dic.put("C", 100);  
	    dic.put("XC", 90);  
	    dic.put("L", 50);  
	    dic.put("XL", 40);  
	    dic.put("X", 10);  
	    dic.put("IX", 9);  
	    dic.put("V", 5);  
	    dic.put("IV", 4);  
	    dic.put("I", 1);  
	  
	    int len = number.length();  
	    if (len == 1)  
	    {  
	        return dic.get(number);  
	    }  
	  
	    if (len > 1)  
	    {  
	        int i = 0;  
	        int sum = 0;  
	        while (i < len)  
	        {  
	            int step = 1;  
	            if (len - i > 1)  
	            {  
	                step = 2;  
	            }  
	  
	            String cnum = number.substring(i, i+step);  
	            if (dic.containsKey(cnum))  
	            {  
	                sum += dic.get(cnum);  
	                i = i + step;  
	            }  
	            else  
	            {  
	                sum += dic.get(number.substring(i, i+1));  
	                i = i + 1;  
	            }  
	        }  
	  
	        return sum;  
	    }  
	  
	    return -1;  
	}  
	
	/**
	 * 十进制转罗马数字 
	 * @param number
	 * @return
	 */
	public static String ConvertDecimalToRoman(int number)  
	{  
	    int[] decArray = {1000,900,500,400,100,90,50,40,10,9,5,4,1};  
	    String[] romAarry = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };  
	    int i = 0;  
	    String output = "";  
	  
	    while (number > 0)  
	    {  
	        while (number >= decArray[i])  
	        {  
	            number = number - decArray[i];  
	            output = output + romAarry[i];  
	        }  
	        i++;  
	    }  
	    return output;  
	}
	
	private static  CiorderAggDO[] getCiOrdAgg(CiOrderDO[] ors) throws BizException{
		Map<String, CiorderAggDO> map = new HashMap<String, CiorderAggDO>();
		StringBuilder sb=new StringBuilder();
		for (CiOrderDO ci : ors) {
			
			if(sb.length()==0){
				sb.append("'"+ci.getId_or()+"'");
			}else{
			sb.append(",'"+ci.getId_or()+"'");
			}
			CiorderAggDO agg=new CiorderAggDO();
			agg.setParentDO(ci);
			agg.setOrdSrvDO(new OrdSrvDO[0]);
			map.put(ci.getId_or(), agg);
		}
		
//		IOrdSrvDORService service=ServiceFinder.find(IOrdSrvDORService.class);
//		
//		OrdSrvDO[] srvs=service.find(" id_or in ("+sb.toString()+")", null, FBoolean.FALSE);
		getOrdPriceBP bp=new getOrdPriceBP();
		OrdSrvDO[] srvs=bp.exec(sb.toString());
		for (OrdSrvDO ordSrvDO : srvs) {
			if(map.containsKey(ordSrvDO.getId_or())){
				
				CiorderAggDO agg=map.get(ordSrvDO.getId_or());
				List<OrdSrvDO> srvlist=new ArrayList<>();
				srvlist.add(ordSrvDO);
				if(agg.getOrdSrvDO()!=null){
					Collections.addAll(srvlist,agg.getOrdSrvDO());
					agg.setOrdSrvDO(srvlist.toArray(new OrdSrvDO[0]));
				}else{
					
					agg.setOrdSrvDO(srvlist.toArray(new OrdSrvDO[0]));
				}
			}
		}
		
		return map.values().toArray(new CiorderAggDO[0]);
		
	}
}

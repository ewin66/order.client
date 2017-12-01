package iih.ci.ord.s.bp;

import org.nutz.lang.Strings;

import iih.hp.cp.app.i.IHpcpAppExtService;
import iih.hp.cp.bannerinfo.d.HpcpBannerInfo;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 临床路径的信息
 * @author li_zheng
 *
 */
public class HpcpBannerInfoBP {
	/**
	 * banner的 临床路径信息
	 * @param ID_ENT
	 * @param id_cpapp
	 * @return
	 * @throws BizException
	 */
	public String[] exec(String ID_ENT, String id_cpapp)throws BizException{
	     IHpcpAppExtService  hpcpService =  ServiceFinder.find(IHpcpAppExtService.class);
	     HpcpBannerInfo info = hpcpService.getHpcpBannerInfo(ID_ENT, id_cpapp);
	     if(info != null){
	       String [] str = new String[6];
	        if(info.getCp_standarddays() != null){
	        	 str[0] = info.getCp_standarddays();//目标天数
	        }else{
	        	 str[0] = "";//目标天数
	        }
	       if(info.getCp_in_days() != null){
	    	   str[1] = info.getCp_in_days()+"";//当前在径天数
	       }else{
	    	   str[1] =  "";//当前在径天数
	       }
	       
	       if(info.getCp_cost_now() != null){
	    	   str[2] = info.getCp_cost_now()+"";//当前费用
	       }else{
	    	   str[2] = "";//当前费用
	       }
	       if(info.getCp_avgcost() != null){
	    	   str[3] = info.getCp_avgcost()+"";//平均费用
	       }else{
	    	   str[3] = "";//平均费用
	       }
	      
	       str[4] = info.getCp_name();//路径名称
	       if( info.getCp_dt_enter() != null){
	    	   str[5] = info.getCp_dt_enter()+"";//入经时间
	       }else{
	    	   str[5] =  "";//入经时间
	       }
	       
	       return str;
	     }
		return  null;
	}

}

package iih.ci.ord.s.bp.orsrvsplit;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import iih.ci.ord.s.bp.orsrvsplit.help.OrSrvSplitHandleByFrepBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/***
 * 服务拆分结果请领量计算操作BP
 *
 */
public class SrvSplitRsApplyQuanNBP {
	/***
	 * 服务拆分结果请领量计算操作
	 * @param srvsplitorders
	 * @return
	 * @throws BizException
	 */
	public  ArrayList<ArrayList<SrvSplitOrderDTO>> exec(SrvSplitOrderDTO[] srvsplitorders)  throws BizException{
		//有效性判断
		if(srvsplitorders==null || srvsplitorders.length==0)return null;
		
		//按申请类型对服务拆分结果进行分组
		Hashtable ht=getSrvSplitRsGrp(srvsplitorders);
		

		//服务拆分时申请数量计算
		ArrayList<ArrayList<SrvSplitOrderDTO>> rtnlist=ApplyQuanHandle(ht);
		
		
		if(rtnlist==null || rtnlist.size()==0)return null;
		return rtnlist;//(SrvSplitOrderDTO[]) rtnlist.toArray((SrvSplitOrderDTO[]) Array.newInstance(SrvSplitOrderDTO.class, 0));

	}
	
	/***
	 * 服务拆分时申请数量计算的处理逻辑
	 * @param ht
	 * @return
	 */
	private ArrayList<ArrayList<SrvSplitOrderDTO>> ApplyQuanHandle(Hashtable ht){
		if(ht==null || ht.size()==0)return null;
		//ArrayList<SrvSplitOrderDTO> rtnlist=new ArrayList<SrvSplitOrderDTO>();
		ArrayList<ArrayList<SrvSplitOrderDTO>> rtnlist=new ArrayList<ArrayList<SrvSplitOrderDTO>>();
		
		ArrayList<SrvSplitOrderDTO> tmlist=null;
		Hashtable tmht=null;
		
		//出院带药类型
		tmlist=(ArrayList<SrvSplitOrderDTO>)ht.get(IOrAndSrvSplitConst.SPLITRS_GRPTP_OUTP);
		outPApplyQuanHandle(rtnlist,tmlist);
		
		//草药
		tmlist=(ArrayList<SrvSplitOrderDTO>)ht.get(IOrAndSrvSplitConst.SPLITRS_GRPTP_HERB);
		herbApplyQuanHandle(rtnlist,tmlist);
		
		//按次取整
		tmlist=(ArrayList<SrvSplitOrderDTO>)ht.get(IOrAndSrvSplitConst.SPLITRS_GRPTP_NBYT);
		roundByTimesApplyQuanHandle(rtnlist,tmlist);
		
		//按批取整
		tmht=(Hashtable)ht.get(IOrAndSrvSplitConst.SPLITRS_GRPTP_NBYB);
		roundByBatchApplyQuanHandle(rtnlist,tmht);
		
		//余量法
		tmht=(Hashtable)ht.get(IOrAndSrvSplitConst.SPLITRS_GRPTP_REMAINS);
		remiansApplyQuanHandle(rtnlist,tmht);
		
		//病区合用法
		tmht=(Hashtable)ht.get(IOrAndSrvSplitConst.SPLITRS_GRPTP_WDSUM);
		wardSumApplyQuanHandle(rtnlist,tmht);
		
		//只按服务
		tmht=(Hashtable)ht.get(IOrAndSrvSplitConst.SPLITRS_GRPTP_SRV);
		srvApplyQuanHandle(rtnlist,tmht);
		

		return rtnlist;
	}
	

	
	/***
	 * 出院带药申请量计算
	 * @param rtn
	 * @param tmlist
	 */
	private void outPApplyQuanHandle(ArrayList<ArrayList<SrvSplitOrderDTO>> rtn,ArrayList<SrvSplitOrderDTO> tmlist){
		//有效性校验
		if(tmlist==null || tmlist.size()==0)return;
		
		SrvSplitOrderDTO splitorder=null;
		FDouble quan=null;
		//遍历
		for(int i=0;i<tmlist.size();i++){
			splitorder=tmlist.get(i);
			if(splitorder==null)continue;
			quan=getOutPQuan(splitorder.getQuan_cur(),splitorder.getFactor());
			splitorder.setQuan_mp_ap(quan);
			splitorder.setId_pkgu_ap(splitorder.getId_pkgu_base());
			rtn.add(getArrayList(splitorder));
		}
	}
	private FDouble getOutPQuan(FDouble quan,FDouble factor){
		return quan.multiply(factor);
	}
	
	
	/***
	 * 草药申请量计算
	 * @param rtn
	 * @param tmlist
	 */
	private void herbApplyQuanHandle(ArrayList<ArrayList<SrvSplitOrderDTO>> rtn,ArrayList<SrvSplitOrderDTO> tmlist){
		//有效性校验
		if(tmlist==null || tmlist.size()==0)return;
		
		SrvSplitOrderDTO splitorder=null;
		FDouble quan=null;
		//遍历
		for(int i=0;i<tmlist.size();i++){
			splitorder=tmlist.get(i);
			if(splitorder==null)continue;
			quan=getHerbQuan(splitorder.getQuan_medu(),splitorder.getFactor_mb(),splitorder.getQuan_or()-splitorder.getOrders_boil());
			splitorder.setQuan_mp_ap(quan);
			splitorder.setId_pkgu_ap(splitorder.getId_pkgu_base());			
			rtn.add(getArrayList(splitorder));
		}
	}
	private FDouble getHerbQuan(FDouble quan_med,FDouble factor_mb,Integer orders){
		return quan_med.multiply(new FDouble(orders)).div(factor_mb);
	}
	
	/***
	 * 按次取整申请量计算
	 * @param rtn
	 * @param tmlist
	 */
	private void roundByTimesApplyQuanHandle(ArrayList<ArrayList<SrvSplitOrderDTO>> rtn,ArrayList<SrvSplitOrderDTO> tmlist){
		//有效性校验
		if(tmlist==null || tmlist.size()==0)return;
		
		SrvSplitOrderDTO splitorder=null;
		FDouble quan=null;
		//遍历
		for(int i=0;i<tmlist.size();i++){
			splitorder=tmlist.get(i);
			if(splitorder==null)continue;
			quan=getRoundByTimesQuan(splitorder.getQuan_medu(),splitorder.getFactor_mb());
			splitorder.setQuan_mp_ap(quan);
			splitorder.setId_pkgu_ap(splitorder.getId_pkgu_base());	
			rtn.add(getArrayList(splitorder));
		}
	}
	private FDouble getRoundByTimesQuan(FDouble quan_med,FDouble factor_mb){
		return OrSrvSplitUtil.CeilingRoundAfterDiv(quan_med,factor_mb);
	}
	
	/***
	 * 按批取整申请量计算
	 * @param rtn
	 * @param tmht
	 */
	private void roundByBatchApplyQuanHandle(ArrayList<ArrayList<SrvSplitOrderDTO>> rtn,Hashtable tmht){
		//有效性校验
		if(tmht==null || tmht.size()==0)return;
		
		String key="";
		FDouble quan=null;
		SrvSplitOrderDTO first=null;
		ArrayList<SrvSplitOrderDTO> tmlist=null;
        Enumeration<String> keys = tmht.keys();
        
		//遍历
        while(keys.hasMoreElements()) {
        	tmlist=(ArrayList<SrvSplitOrderDTO>)tmht.get(keys.nextElement());
        	if(tmlist==null || tmlist.size()==0){}else{
        		quan=sum(tmlist);
        		first=tmlist.get(0);
        		quan=OrSrvSplitUtil.CeilingRoundAfterDiv(quan,first.getFactor_mb());
        		first.setQuan_mp_ap(quan);
        		first.setId_pkgu_ap(first.getId_pkgu_base());	
        		rtn.add(tmlist);
        	}
       }

	}
	private FDouble sum(ArrayList<SrvSplitOrderDTO> srvsplitdtos){
		FDouble rtn=new FDouble(0);
		if(srvsplitdtos==null || srvsplitdtos.size()==0)return rtn;
		
		for(int i=0;i<srvsplitdtos.size();i++){
			rtn.add(srvsplitdtos.get(i).getQuan_medu());
		}
		return rtn;//OrSrvSplitUtil.CeilingRound(rtn);
	}
	
	/***
	 * 按余量法申请量计算
	 * @param rtn
	 * @param tmht
	 */
	private void remiansApplyQuanHandle(ArrayList<ArrayList<SrvSplitOrderDTO>> rtn,Hashtable tmht){
		//有效性校验
		if(tmht==null || tmht.size()==0)return;
		
		String key="";
		FDouble[] quans=null;
		SrvSplitOrderDTO first=null;
		ArrayList<SrvSplitOrderDTO> tmlist=null;
        Enumeration<String> keys = tmht.keys();
        
		//遍历
        while(keys.hasMoreElements()) {
        	tmlist=(ArrayList<SrvSplitOrderDTO>)tmht.get(keys.nextElement());
        	if(tmlist==null || tmlist.size()==0){}else{
        		quans=getSumAndQuanBedMedu(tmlist);
        		
        		//不是总量小于余量
        		if(quans[0].compareTo(quans[1])>=0){
            		first=tmlist.get(0);
            		//first.setQuan_mp_ap(OrSrvSplitUtil.CeilingRoundAfterDiv(quans[0].sub(quans[0]),first.getFactor_mb()));
            		//ly修改
            		first.setQuan_mp_ap(OrSrvSplitUtil.CeilingRoundAfterDiv(quans[0].sub(quans[1]),first.getFactor_mb()));
            		first.setId_pkgu_ap(first.getId_pkgu_base());	
            		rtn.add(tmlist);        			
        		}

        	}        	
        	
        	//rtn.addAll(tmlist);
       }

	}
	private FDouble[] getSumAndQuanBedMedu(ArrayList<SrvSplitOrderDTO> srvsplitdtos){
		FDouble[] rtn=new FDouble[]{new FDouble(0),new FDouble(0)};
		if(srvsplitdtos==null || srvsplitdtos.size()==0)return null;
		
		for(int i=0;i<srvsplitdtos.size();i++){
			rtn[0].add(srvsplitdtos.get(i).getQuan_medu());
		    //床边量记法是有问题的   ????????   
			//rtn[1]=srvsplitdtos.get(i).getQuan_bed_medu();
		}
		
		//取得未执行用量 ly添加
		OrSrvSplitHandleByFrepBP frepBp = new OrSrvSplitHandleByFrepBP();
		ArrayList<SrvSplitOrderDTO> list=new ArrayList<SrvSplitOrderDTO>();
		try {
			frepBp.exec(list, srvsplitdtos.get(0), new FDateTime[]{} , new Hashtable());
		} catch (BizException e) {
			e.printStackTrace();
		}
		
		
		//ly修改，床旁余量取一条数据
		rtn[1]=srvsplitdtos.get(0).getQuan_bed_medu();
		return rtn;
	}
	
	/***
	 * 按合用法申请量计算
	 * @param rtn
	 * @param tmht
	 */
	private void wardSumApplyQuanHandle(ArrayList<ArrayList<SrvSplitOrderDTO>> rtn,Hashtable tmht){
		//有效性校验
		if(tmht==null || tmht.size()==0)return;
		
		String key="";
		FDouble quan=null;
		SrvSplitOrderDTO first=null;
		ArrayList<SrvSplitOrderDTO> tmlist=null;
        Enumeration<String> keys = tmht.keys();
        
		//遍历
        while(keys.hasMoreElements()) {
        	tmlist=(ArrayList<SrvSplitOrderDTO>)tmht.get(keys.nextElement());
        	if(tmlist==null || tmlist.size()==0){}else{
        		quan=sum(tmlist);
        		first=tmlist.get(0);
        		quan=OrSrvSplitUtil.CeilingRoundAfterDiv(quan,first.getFactor_mb());
        		first.setQuan_mp_ap(quan);
        		first.setId_pkgu_ap(first.getId_pkgu_base());	
        		rtn.add(tmlist);
        	}        	
        	
        	//rtn.addAll(tmlist);
       }

	}
	
	/***
	 * 仅按服务申请量计算
	 * @param rtn
	 * @param tmht
	 */
	private void srvApplyQuanHandle(ArrayList<ArrayList<SrvSplitOrderDTO>> rtn,Hashtable tmht){
		//有效性校验
		if(tmht==null || tmht.size()==0)return;
		
		String key="";
		FDouble quan=null;
		SrvSplitOrderDTO first=null;
		ArrayList<SrvSplitOrderDTO> tmlist=null;
        Enumeration<String> keys = tmht.keys();
        
		//遍历
        while(keys.hasMoreElements()) {
        	tmlist=(ArrayList<SrvSplitOrderDTO>)tmht.get(keys.nextElement());
        	if(tmlist==null || tmlist.size()==0){}else{
        		quan=sum(tmlist);
        		first=tmlist.get(0);
        		first.setQuan_mp_ap(quan);
        		first.setId_pkgu_ap(first.getId_medu());	
        		rtn.add(tmlist);
        	}        	
        	
        	//rtn.addAll(tmlist);
       }

	}
	
	
	
	/***
	 * 按申请类型对服务拆分结果进行分组
	 * @param srvsplitorders
	 * @return
	 * @throws BizException 
	 */
	private Hashtable getSrvSplitRsGrp(SrvSplitOrderDTO[] srvsplitorders) throws BizException{
		SrvSplitRsGrpByAppTypeBP bp=new SrvSplitRsGrpByAppTypeBP();
		return bp.exec(srvsplitorders);
	}
	
	/***
	 * 获得列表
	 * @param splitorder
	 * @return
	 */
	private ArrayList<SrvSplitOrderDTO> getArrayList(SrvSplitOrderDTO splitorder){
		ArrayList<SrvSplitOrderDTO> rtn=new ArrayList<SrvSplitOrderDTO>();
		rtn.add(splitorder);
		return rtn;
	}
}

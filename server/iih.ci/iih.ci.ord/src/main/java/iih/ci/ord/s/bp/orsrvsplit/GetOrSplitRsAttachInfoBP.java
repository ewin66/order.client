package iih.ci.ord.s.bp.orsrvsplit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.dto.blexorder.d.OrSplitOrderDTO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.sys.jdbc.facade.DAException;

/**
 * 获得拆分结果对应的附属信息操作BP
 */
public class GetOrSplitRsAttachInfoBP {
	/***
	 * 获得拆分结果对应的附属信息
	 * @param splitrs
	 * @param qrymap
	 * @param orgensplittp
	 * @return
	 * @throws BizException
	 */
	public  FMap exec(BaseDTO[] splitrs,FMap qrymap,Integer orgensplittp)  throws BizException{
		if(splitrs==null || qrymap==null)return null;
		
		Iterator it=qrymap.keySet().iterator();   
	     String key,value; 
	     FMap rstmap=new FMap();
		 ArrayList<String> ids=new ArrayList<String>();//OrSplitOrderDTO  SrvSplitOrderDTO
		while(it.hasNext()){   
		     key=it.next().toString();   
		     value=(String)qrymap.get(key);  
			 if(qrymap.containsKey(IOrAndSrvSplitConst.ATTACHINFO_TABLE_LIS)){
				 ids=getIdArrayList(splitrs,IBdSrvDictCodeConst.SD_SRVTP_LIS,orgensplittp);
				 rstmap.put(key, getQryResult(key,value,ids));
			 }else if(qrymap.containsKey(IOrAndSrvSplitConst.ATTACHINFO_TABLE_RIS)){
				 ids=getIdArrayList(splitrs,IBdSrvDictCodeConst.SD_SRVTP_RIS,orgensplittp);
				 rstmap.put(key, getQryResult(key,value,ids));
			 }else{
				 ids=getIdArrayList(splitrs,orgensplittp);
				 rstmap.put(key, getQryResult(key,value,ids));
			 }
		}

		
		return rstmap;
	}
	
	/**
	 * 获得查询结果集
	 * @param tblname
	 * @param fieldstr
	 * @param ids
	 * @throws DAException 
	 */
	private FMap getQryResult(String tblname,String fieldstr,ArrayList<String> ids) throws DAException{
		if(ids==null || ids.size()==0)return null;
		 String sql=getSql(tblname,fieldstr);
		 ArrayList<String> idsdtr=CiOrdUtils.getSqlInStrs(ids);
		 ArrayList<Map<String, Object>> rs=CiOrdUtils.getQryResultByIDs(sql,ids);
		 FMap rtn=new FMap();
		 rsMergeHandle(rtn,rs,tblname);
		 return rtn;
	}
	
	/**
	 * 查询结果合并转换处理逻辑
	 * @param rtn
	 * @param rs
	 */
	private void rsMergeHandle(FMap rtn,ArrayList<Map<String, Object>> rs,String key){
		if(rs==null || rs.size()==0)return;
		FMap list=new FMap();
		Map map=null;
		for(int i=0;i<rs.size();i++){
			map=rs.get(i);
			rtn.put((String)map.get("id_or"), CiOrdUtils.map2FMap(map));
		}
	}
	
	
	/**
	 * 获得查询sql
	 * @param tblname
	 * @param fieldstr
	 * @return
	 */
	private String getSql(String tblname,String fieldstr){
		return CiOrdUtils.SELECT_STR+CiOrdUtils.ID_OR+CiOrdUtils.COMMA_STR+fieldstr+CiOrdUtils.FROM_STR+tblname+CiOrdUtils.WHERE_STR +CiOrdUtils.ID_OR;
	}
	
	/**
	 * 获得满足条件的id集合
	 * @param splitrs
	 * @param srvtp
	 * @param orgensplittp
	 * @return
	 */
	private ArrayList<String> getIdArrayList(BaseDTO[] splitrs,String stdsrvtp,Integer orgensplittp){
		 ArrayList<String> list=new ArrayList<String>();
		if(OrSrvSplitUtil.isOrSplitType(orgensplittp)){
			OrSplitOrderDTO[] rtns=(OrSplitOrderDTO[])splitrs;
			for(int i=0;i<rtns.length;i++){
				if(OrSrvSplitUtil.isDtSrvTypeSame(stdsrvtp, rtns[i].getSd_srvtp(), true)){
					list.add(rtns[i].getId_or());
				}
			}
		}else{
			SrvSplitOrderDTO[] rtns=(SrvSplitOrderDTO[])splitrs;
			for(int i=0;i<rtns.length;i++){
				if(OrSrvSplitUtil.isDtSrvTypeSame(stdsrvtp, rtns[i].getSd_srvtp(), true)){
					list.add(rtns[i].getId_or());
				}
			}
		}
		
		return list;
	}
	
	/**
	 * 获得满足条件的id集合
	 * @param splitrs
	 * @param orgensplittp
	 * @return
	 */
	private ArrayList<String> getIdArrayList(BaseDTO[] splitrs,Integer orgensplittp){
		 ArrayList<String> list=new ArrayList<String>();
		if(OrSrvSplitUtil.isOrSplitType(orgensplittp)){
			OrSplitOrderDTO[] rtns=(OrSplitOrderDTO[])splitrs;
			for(int i=0;i<rtns.length;i++){
					list.add(rtns[i].getId_or());
			}
		}else{
			SrvSplitOrderDTO[] rtns=(SrvSplitOrderDTO[])splitrs;
			for(int i=0;i<rtns.length;i++){
					list.add(rtns[i].getId_or());
			}
		}
		
		return list;
	}
	
}

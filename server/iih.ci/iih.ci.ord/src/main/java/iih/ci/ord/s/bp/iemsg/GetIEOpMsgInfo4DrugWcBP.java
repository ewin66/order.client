package iih.ci.ord.s.bp.iemsg;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

import iih.ci.ord.iemsg.d.IEOpPharmWcOrDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiPharmOpPresItmQry;
import iih.ci.ord.s.bp.iemsg.qry.CiPharmOpRefundPresItmQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 生成集成平台西成药医嘱服务数据信息操作BP
 * （门诊）
 */
public class GetIEOpMsgInfo4DrugWcBP {
	/**
	 * 生成集成平台西成医嘱服务数据信息
	 * （门诊）
	 * @param id_preses  处方id串
	 * @return
	 * @throws BizException
	 */
	public Hashtable<String,FArrayList2> exec(String id_preses) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_preses))return null;
		
		// 获得西成药处方明细信息
		CiPharmOpPresItmQry qry = new CiPharmOpPresItmQry(id_preses);
		IEOpPharmWcOrDTO[] predtos=(IEOpPharmWcOrDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpPharmWcOrDTO.class);
		
		if(CiOrdUtils.isEmpty(predtos))return null;
		HashMap<String, IEOpPharmWcOrDTO> map = new HashMap<String, IEOpPharmWcOrDTO>();
		for (IEOpPharmWcOrDTO ieOpPharmWcOrDTO : predtos) {
			String key = ieOpPharmWcOrDTO.getYzno()+ieOpPharmWcOrDTO.getId_iepharmpres();
			if (!map.containsKey(key)) {
				map.put(key, ieOpPharmWcOrDTO);
			}
		}
		IEOpPharmWcOrDTO[] results = new IEOpPharmWcOrDTO[map.size()];
		int index = 0;
		Iterator<Entry<String, IEOpPharmWcOrDTO>> iterator=map.entrySet().iterator();  
	    while(iterator.hasNext()){//使用迭代器迭代  
	        Entry< String, IEOpPharmWcOrDTO> entry=iterator.next();  
	        results[index] = entry.getValue();
	        index ++;
	    } 
		//返回分组的西成药明细信息
		return getHtInfoByIdpres(results);
	}
	
	/**
	 * 生成集成平台西成医嘱服务数据信息
	 * （门诊）
	 * @param id_preses  处方id串
	 * @return
	 * @throws BizException
	 */
	public Hashtable<String,FArrayList2> exec(String id_preses,String id_orsrvs) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_preses))return null;
		
		// 获得西成药处方明细信息
		CiPharmOpRefundPresItmQry qry = new CiPharmOpRefundPresItmQry(id_preses,id_orsrvs);
		IEOpPharmWcOrDTO[] predtos=(IEOpPharmWcOrDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpPharmWcOrDTO.class);
		if(CiOrdUtils.isEmpty(predtos))return null;

		//返回分组的西成药明细信息
		return getHtInfoByIdpres(predtos);
	}
	/**
	 * 对西成药处方明细信息按id_pres分组
	 * @param predtos
	 * @return
	 */
	private Hashtable<String,FArrayList2> getHtInfoByIdpres(IEOpPharmWcOrDTO[] predtos){
		//参数
		Hashtable<String,FArrayList2> ht=new Hashtable<String,FArrayList2>();
		String key=null;
		
		//遍历
		for(IEOpPharmWcOrDTO o:predtos){
			key=o.getId_iepharmpres();
			if(ht.containsKey(key)){
				(ht.get(key)).add(o);
			}else{
				FArrayList2 list=new FArrayList2();
				list.add(o);
				ht.put(key, list);
			}
			
		}
		
		return ht;
	}

}

package iih.ci.ord.s.bp.iemsg;

import java.util.List;
import java.util.Map;

import iih.ci.ord.iemsg.d.IEOpOrCancStpEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/**
 * 生成集成平台会诊服务数据信息操作BP
 * （门诊）
 */
public class GetIEOpMsgInfo4CancStpBP {
	/**
	 * 生成集成平台会诊服务数据信息
	 * （门诊）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpOrCancStpEnDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//sql串
		String sql=getSQlStr(id_ors);
		
		//获得门诊作废医嘱数据信息  含主子两部分部分
		List<Map<String, Object>> listmap=CiOrdUtils.getRsMapList(sql);
		if(CiOrdUtils.isEmpty(listmap))return null;
		
		//获得获得门诊作废医嘱数据信息数组 并返回
		return getIEOpOrCancStpEnDTOs(listmap);
	}
	
	/**
	 * 获得获得门诊作废医嘱数据信息数组
	 * @param listmap
	 * @return
	 */
	private IEOpOrCancStpEnDTO[] getIEOpOrCancStpEnDTOs(List<Map<String, Object>> listmap){
		int iN=listmap.size();
		IEOpOrCancStpEnDTO[] rtndtos=new IEOpOrCancStpEnDTO[iN];
		
		//遍历
		for(int i=0;i<iN;i++){
			rtndtos[i]=getIEOpOrCancStpEnDTO(listmap.get(i));
			
			rtndtos[i].setDomain_id("01");
		}
		
		//返回
		return rtndtos;
	}
	
	/**
	 * 获得获得门诊作废医嘱数据信息数组
	 * @param listmap
	 * @return
	 */
	private IEOpOrCancStpEnDTO getIEOpOrCancStpEnDTO(Map<String, Object> map){
		//需要映射生成主子结构DTO数据
		return null;
	}
	
	/**
	 * 获得 SQL串 
	 * @param id_or
	 * @return
	 */
	private String getSQlStr(String id_ors){
		String formatsql=ICiIEMsgRelSqlConst.CI_IE_ORCANCEL_OP_SQL;
		String id_or4sql=CiOrdUtils.getSqlInOrEqualStrs(id_ors);
		return String.format(formatsql, "A.id_or"+id_or4sql);
	}
}

package iih.ci.ord.s.bp.assi.bp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.founder.xap.core.utils.Assert;

import xap.mw.core.data.BizRuntimeException;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 获取服务价格
 * 
 * @author HUMS
 *
 */
public class GetSrvPriceBP {

	/**
	 * 获取非物品价格
	 * 
	 * @param idPriPat 患者价格分类id
	 * @param idSrvList 服务id集合
	 * @return map key “服务id” , value 价格
	 */
	public Map<String, FDouble> getSrvPrice(String idPriPat, List<String> idSrvList) {

		return getSrvAndMMPrice(idPriPat, idSrvList, null);
	}

	/**
	 * 获取物品价格
	 * 
	 * @param idPriPat 患者价格分类id
	 * @param idMMList 物品id
	 * @return map key “服务id，物品id” , value 价格
	 */
	public static Map<String, FDouble> getMMPrice(List<String> idMMList) {

		return getSrvAndMMPrice(null, null, idMMList);
	}

	/**
	 * 获取服务价格
	 * 
	 * @param idPriPat 患者价格分类id
	 * @param idSrvList 服务id集合
	 * @param idMMList 物品id集合
	 * @return map 非物品 ：key “服务id” , value 价格。 物品：key “服务id,物品id” , value 价格，
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, FDouble> getSrvAndMMPrice(String idPriPat, List<String> idSrvList,
			List<String> idMMList) {
		long  startTime = System.currentTimeMillis();
		Map<String, FDouble> priMap = new HashMap<String, FDouble>();
		StringBuffer sqlBuffer = new StringBuffer();
 
		// 根据服务id获取查询服务价格查询语句（非物品）
		if (idSrvList != null && idSrvList.size() > 0) {
			sqlBuffer.append(getSrvPriceQrySql(idPriPat, idSrvList));
		}

		// 获取物品价格查询语句
		if (idMMList != null && idMMList.size() > 0) {

			if (sqlBuffer.length() > 0) {
				sqlBuffer.append(" union ");
			}

			sqlBuffer.append(getMMPriceQrySql(idMMList));
		}
		
		if(sqlBuffer.length() == 0 ){
			return null;
		}

		List<Map<String, Object>> priMapList = null;
		try {
			// 查询服务（物品价格），在重新构造价格map key值为服务id,物品id value : 价格
			priMapList = (List<Map<String, Object>>) new DAFacade().execQuery(sqlBuffer.toString(),
					new MapListHandler());
			
			for (Map<String, Object> priObjMap : priMapList) {

				String key = (String) priObjMap.get("id_srv");
				Object idMmObj = priObjMap.get("id_mm");

				if (idMmObj != null) {
					key = key + "," + idMmObj.toString();
				}

				FDouble price = new FDouble(0.00);
				Object priObj = priObjMap.get("price");
				if (priObj != null) {
					price = new FDouble(((BigDecimal)priObj).doubleValue());
				}

				priMap.put(key, price);
			}
		} catch (DAException e) {
			throw new BizRuntimeException(e.getMessage());
		}
          iih.ci.ord.pub.CiOrdUtils.LogerOutInfo("getSrvAndMMPrice 耗时：" +(System.currentTimeMillis()-startTime));
		return priMap;
	}

	/**
	 * 获取查询物品sql语句
	 * 
	 * @param idSrvList 服务集合
	 * @return
	 */
	private static String getSrvPriceQrySql(String idPriPat, List<String> idSrvList) {

		Assert.notNull(idPriPat, "获取服务价格失败，患者就诊类型不能为空!");
		Assert.notNull(idSrvList, "获取服务价格失败，服务id集合不能为空!");

		StringBuffer buffer = new StringBuffer();

		if (idSrvList != null && idSrvList.size() > 0) {

			buffer.append("select A.Id_srv,'' as Id_mm,CAST (b.price_ratio AS DECIMAL(18,2)) as Price from bd_srv A ")
					.append("left join view_price_rp B on A.id_srv = B.id_srv where B.id_pripat='"+idPriPat+"' and A.Fg_Mm = 'N' and A.id_srv in (")
					.append(getInStr(idSrvList)).append(")");
		}

		return buffer.toString();
	}

	/**
	 * 获取物品服务价格查询语句
	 * 
	 * @param idMMList 物品id集合
	 * @return
	 */
	private static String getMMPriceQrySql(List<String> idMMList) {

		Assert.notNull(idMMList, "获取物品价格失败，物品id集合不能为空!");

		StringBuffer buffer = new StringBuffer();

		buffer.append("select A.Id_srv,c.Id_mm,CAST (c.Price AS DECIMAL(18,2)) as Price from bd_srv A left join bd_mm C ")
				.append(" on A.id_srv = C.id_srv  where A.fg_mm= 'Y' and C.id_mm in ( ").append(getInStr(idMMList))
				.append(")");

		return buffer.toString();
	}

	/**
	 * 拼接In字符串
	 * 
	 * @param idList
	 * @return
	 */
	private static String getInStr(List<String> idList) {

		StringBuffer buffer = new StringBuffer();
		for (String id : idList) {
			buffer.append(",'" + id + "'");
		}

		return buffer.substring(1);
	}
}

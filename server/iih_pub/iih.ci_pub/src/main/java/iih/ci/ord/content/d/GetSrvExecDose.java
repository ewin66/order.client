package iih.ci.ord.content.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

public class GetSrvExecDose {

	@SuppressWarnings("unchecked")
	public static List<String> exec(String idsrv) throws DAException{
		String sql = "select ismuldose,ismulexec from bd_srv where id_srv='" + idsrv + "'";
		List<Map<String, Object>> mapList = null;
		mapList = (List<Map<String, Object>>) new DAFacade().execQuery(sql, new MapListHandler());
		List<String> lstRst = new ArrayList<String>();
		if (mapList != null && mapList.size() > 0) {
			for (Map<String, Object> objMap : mapList) {
				lstRst.add(objMap.get("ismuldose").toString());
				lstRst.add(objMap.get("ismulexec").toString());
			}
		}
		return lstRst;
	}
}

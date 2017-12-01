package iih.ci.ord.s.bp.srvref;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import iih.bd.srv.oth.d.SrvDescCfgDO;
import iih.bd.srv.oth.i.ISrvdesccfgdoRService;
import iih.ci.ord.srvref.d.CiSrvRefParamDTO;
import iih.ci.ord.srvref.d.SrvRefRelInfoType;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.desc.ent.dataobject.EnumDescUtil;
import xap.sys.appfw.orm.desc.ent.dataobject.EnumDescription;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 获得医嘱开立时，服务参照Sql串操作BP
 * 获得基本的格式化的服务参照sql串
 * （基本）
 */
public class GetBasicSrvRefSqlStrBP {

	// 医嘱服务参照中描述配置接口
	private ISrvdesccfgdoRService descCrgService;

	// 医嘱服务参照查询参数
	private CiSrvRefParamDTO paramDto;

	// 临床医嘱服务参照查询结果DTO classId
	private final static String CI_SRV_REF_RESULT_DTO_ID = "C709B2DE-68D0-0001-E1AB-3ECB1510DEC0";

	@SuppressWarnings("unused")
	private GetBasicSrvRefSqlStrBP() {
	}

	public GetBasicSrvRefSqlStrBP(CiSrvRefParamDTO paramDto) {
		this.descCrgService = ServiceFinder.find(ISrvdesccfgdoRService.class);
		this.paramDto = paramDto;
	}

	/**
	 * 获得医嘱开立时，服务参照Sql串 （基本）
	 * 
	 * @throws BizException
	 */
	public String exec() throws BizException {

		ISrvRefModel serRefModel = new GetSrvRefConfigInfo(paramDto);

		List<String> colNameList  = this.getDescCloumn(paramDto.getId_billform());
		serRefModel.setSrvDescFields(colNameList.toArray(new String[0]));

		// 设置参照中配置的列属性
		String[] selectFields = this.getFormColumn(paramDto.getId_billform());
		serRefModel.setSelectFields(selectFields);
		String sqlStr = serRefModel.getSQLStr(); 
		return sqlStr;
	}

	/**
	 * 获取表单配置的列所在分组
	 * 
	 * @param classId
	 *            临床医嘱服务参照查询结果DTO 类定义Id
	 * @param idBillForm
	 *            参照查询表单Id
	 * @return 表单配置的列属性所在的分组集合
	 * @throws DAException
	 */
	private List<String> getFormCloumnGrp(String formId) throws DAException {

		// 由于目前在类属性定义中没有分组概念，使用dm_property中描述列作为属性的分组标识
		String sql = "select  distinct description from dm_property  p left join dp_billform_b f on p.name = f.itemkey "
				+ " where p.classId = '" + CI_SRV_REF_RESULT_DTO_ID + "' and f.id_billform = '" + formId + "'";

		Object obj = new DAFacade().execQuery(sql, new ColumnListHandler());
		return (List<String>) obj;
	}

	/**
	 * 获取服务查询参照中配置的列属性
	 * @param formId 参照表单id
	 * @return 服务参照的列属性
	 * @throws DAException 
	 */
	private String[] getFormColumn(String formId) throws DAException{
		
		String sql = "select itemkey from dp_billform_b where id_billform = '"+formId+"' order by showorder ";
		Object obj = new DAFacade().execQuery(sql, new ColumnListHandler());
		List<String> columnList = (List<String>) obj;
		return columnList.toArray(new String[0]);
	}
	
	/**
	 * 获取枚举对象的的索引值
	 * 
	 * @param typeNameList
	 * @return
	 * @throws DAException
	 */
	private List<Integer> getRelInfoTypeList(CiSrvRefParamDTO paramDto) throws DAException {

		// 获取表单绑定属性对应CiSrvRefResultDTO中的分组信息（描述字段作为分组信息）
		List<String> typeNameList = this.getFormCloumnGrp(paramDto.getId_billform());
		// 获取服务参照关联数据类型中的枚举值，其中EnumDescription中name对应的是分组信息，Object为索引
		Map<Object, EnumDescription> relInfoEnum = EnumDescUtil.getValue_EnumDescriptionMap(SrvRefRelInfoType.class);

		List<Integer> indexList = new ArrayList<Integer>();

		for (String name : typeNameList) {
			for (Entry<Object, EnumDescription> entry : relInfoEnum.entrySet()) {
				if (entry.getValue().getName().equals(name)) {
					indexList.add(Integer.parseInt(entry.getKey().toString()));
					break;
				}
			}
		}

		return indexList;
	}

	/**
	 * 获取描述列
	 * 
	 * @param formId
	 *            医疗服务主表单id
	 * @author hums Date:2016-05-10
	 * @throws BizException
	 */
	private List<String> getDescCloumn(String formId) throws BizException {
		
		Map<String,StringBuffer> map = new LinkedHashMap<String,StringBuffer>();
		List<String> colNameList = new LinkedList<String>(); 

		String whereStr = "srvrefformid = '"+formId+"'";
		String orderStr = "srvcacode,seq";
		SrvDescCfgDO[] descCfgDOs = descCrgService.find(whereStr, orderStr, FBoolean.FALSE);
		
		for(SrvDescCfgDO descCfgDO : descCfgDOs){
			StringBuffer buffer = null;
			if(!map.keySet().contains(descCfgDO.getSrvcacode())){
				buffer = new StringBuffer();
				map.put(descCfgDO.getSrvcacode(), buffer);
				buffer.append(descCfgDO.getSrvcacode());
			}else{
				buffer = map.get(descCfgDO.getSrvcacode());
			}
			buffer.append(","+descCfgDO.getColname());
		}
		
		for(StringBuffer buffer : map.values()){
			colNameList.add(buffer.toString());
		}
		return colNameList;
	}
}

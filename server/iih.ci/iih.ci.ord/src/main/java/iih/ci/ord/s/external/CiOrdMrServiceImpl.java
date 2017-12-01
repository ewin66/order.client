package iih.ci.ord.s.external;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.cidiag.i.ICidiagCudService;
import iih.ci.diag.cidiag.i.ICidiagRService;
import iih.ci.diag.dto.d.DIDTO;
import iih.ci.ord.i.external.ICiOrdMrService;
import iih.ci.ord.s.bp.getOrderFlush2MrDtoListBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;

/**
 * 临床提供给病历的对外接口
 * 
 * @author HUMS
 *
 */
@Service(serviceInterfaces = { ICiOrdMrService.class }, binding = Binding.JSONRPC)
public class CiOrdMrServiceImpl implements ICiOrdMrService {
	

	private static final String ZDTX = "zdtx";
	/// digType节点
	private static final String DIGTYPE_NODE = "digType";
	/// xml 中dig节点
	private static final String DIG_NODE = "dig";
	/// xml中cdig节点
	private static final String CDIG_NODE = "cdig";
	private static final String ID_OPDI = "0001AA1000000004A7P6";
	private static final String SD_OPDI = "1";
	private static final String SPACE_STR = " ";

	@Override
	public FMap2 getOrderMrDtoFlushList(String id_ent, String code_entp) throws BizException {
		getOrderFlush2MrDtoListBP bp = new getOrderFlush2MrDtoListBP();
		if (id_ent == null || code_entp == null)
			return null;
		return bp.getOrderFlushList(id_ent, code_entp,"",true);
	}

	@Override
	public String getDiagList(String id_ent) throws BizException {
		String condition = String.format("dt_di=(select max(DI.dt_di) from ci_di DI where DI.id_en='%s')", id_ent);
		ICidiagCudService iCidiagCudService = ServiceFinder.find(ICidiagCudService.class);
		ICidiagRService iCidiagRService = ServiceFinder.find(ICidiagRService.class);
		if (iCidiagRService == null)
			return null;
		CidiagAggDO[] diagAggDO = iCidiagRService.find(condition, "", FBoolean.FALSE);
		DIDTO[] diDTOs = GetDIDTO(diagAggDO);
		String filePath = this.getClass().getResource("").getPath()+"xmltemplet/EmrEditorCiDiagConfig.xml";
		String result = convertDiagToXmlStr(diDTOs, filePath);
		return result;
	}

	private DIDTO[] GetDIDTO(CidiagAggDO[] diagAggDO) {
		List<DIDTO> didtoList = new ArrayList<DIDTO>();
		if (diagAggDO.length <= 0) {
			return (DIDTO[]) didtoList.toArray(new DIDTO[didtoList.size()]);
		}
		CiDiagDO cidiagDO = diagAggDO[0].getParentDO();
		CiDiagItemDO[] ciDiagItemDOs = diagAggDO[0].getCiDiagItemDO();

		for (CiDiagItemDO itemDO : ciDiagItemDOs) {
			DIDTO didto = new DIDTO();

			this.setCiDiagItemProperty(itemDO, didto);
			this.setCiDiagDOProperty(cidiagDO, didto);

			// 子表主键
			didto.setId_diitm(itemDO.getId_diitm());
			// 主诊断标识
			didto.setFg_majdi(itemDO.getFg_majdi());
			// didto.Sortno = (Convert.ToInt32(itemDO.Sortno) + 1).ToString();
			// 通过记录数，设置诊断的排序号
			didto.setSortno(String.valueOf((Integer.parseInt(itemDO.getSortno()) + 1)));
			didtoList.add(didto);
		}
		return (DIDTO[]) didtoList.toArray(new DIDTO[didtoList.size()]);

	}

	/**
	 * 将诊断属性赋值给DIDTO
	 * 不区分itemDO是来源于数据库还是界面选择的历史诊断
	 * @param itemDO
	 * @param didto
	 */
	private void setCiDiagItemProperty(CiDiagItemDO itemDO, DIDTO didto) {
		// 上级 父子诊断用 ？
		didto.setId_par(itemDO.getId_parent());
		// 诊断定义主键
		didto.setId_didef(itemDO.getId_didef());
		// 诊断编码 同 id_didef_code
		didto.setDidef_code(itemDO.getDidef_code());
		// 诊断名称 同 id_didef_name
		didto.setDidef_name(itemDO.getDidef_name());
		// 诊断类型 诊断过程状态 门诊、初步、入院、补充、修正、出院、死亡
		didto.setId_ditp(ID_OPDI);
		// 诊断类型编码
		didto.setSd_ditp(SD_OPDI);
		// 证候诊断
		didto.setId_didef_syn(itemDO.getId_didef_syn());
		// 证候诊断编码
		didto.setId_didef_syn_code(itemDO.getId_didef_syn_code());
		// 证候诊断名称
		didto.setId_didef_syn_name(itemDO.getId_didef_syn_name());
		// 疑似诊断标识
		didto.setFg_suspdi(itemDO.getFg_suspdi());
		// 补充说明
		didto.setSupplement(itemDO.getSupplement());
		// 诊断描述
		didto.setDes_di(itemDO.getDes());

		// 西医标志
		didto.setFg_med(FBoolean.FALSE);
		// 传染病标志
		didto.setFg_infedi(itemDO.getFg_infedi());
		// 诊断体系
		didto.setId_disys(itemDO.getId_disys());
		// 诊断体系编码
		didto.setSd_disys(itemDO.getSd_disys());
		// 诊断体系名称
		didto.setId_disys_name(itemDO.getId_disys_name());

		// 诊断标准
		didto.setDi_standard(itemDO.getDi_standard());
		// 诊断标准编码
		didto.setDi_standard_code(itemDO.getDi_standard_code());
		// 诊断标准名称
		didto.setDi_standard_name(itemDO.getDi_standard_name());

		// 疾病诊断id
		didto.setDi_disease(itemDO.getId_didef());
		// 疾病诊断名称
		didto.setId_disease_name(itemDO.getDidef_code());
		// 疾病诊断编码
		didto.setId_disease_code(itemDO.getDidef_name());
	}
	/**
	 * 通过已保存的诊断主表设置DIDTO中主表属性
	 * @param cidiagDO
	 * @param didto
	 */
	private void setCiDiagDOProperty(CiDiagDO cidiagDO, DIDTO didto) {

		// 诊断主表id
		didto.setId_di(cidiagDO.getId_di());
		// 开立医生 诊断医生 取当前登录人
		didto.setId_emp_create(cidiagDO.getId_emp_create());
		// 开立医生姓名 医生姓名 取当前登录人
		didto.setId_emp_create_name(cidiagDO.getEmpname());
		// 诊断时间 当前时间
		didto.setDt_di(new FDateTime());
		// 开立科室
		didto.setId_dep_create(cidiagDO.getId_dep_create());
		// 开立科室名称
		didto.setId_dep_create_name(cidiagDO.getName_dep_create());
		// 开立时间
		didto.setDt_create(cidiagDO.getDt_create());

		// 就诊id
		didto.setId_en(cidiagDO.getId_en());
		// 患者id
		didto.setId_pat(cidiagDO.getId_pat());
		// 就诊类型
		didto.setId_entp(cidiagDO.getId_entp());
		// 就诊类型编码
		didto.setCode_entp(cidiagDO.getCode_entp());

		// 签署人
		didto.setId_emp_sign(cidiagDO.getId_emp_sign());
		// 签署人名称
		didto.setName_emp_sign(cidiagDO.getSignname());
		// 签署科室
		didto.setId_dep_sign(cidiagDO.getId_dep_sign());
		// 签署时间
		didto.setDt_sign(cidiagDO.getDt_sign());
		// 签署标志
		didto.setFg_sign(FBoolean.TRUE);
	}
	/**
	 * 诊断信息转为xml
	 * @param diDTOs
	 * @param xmlPath
	 * @return
	 * @throws BizException
	 */
	private String convertDiagToXmlStr(/* CidiagAggDO[] diagAggDO */DIDTO[] diDTOs, String xmlPath)
			throws BizException {
		boolean showDigTypeName = false;

//		String xmlPath = System.getProperty("user.dir") + xmlCfgPath;
		StringBuilder builder = new StringBuilder();
		builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		builder.append("<root>");
		builder.append("<dig signName=\"\" signTime=\"\">");
		if (diDTOs != null && diDTOs.length > 0) {
			// 获取诊断体系常量
			List<String> zdtxList = new ArrayList<String>();
			Map<String, Map<String, Map<String, String>>> propertyDic = getXmlDic(xmlPath,zdtxList);

			Map<String, List<DIDTO>> diDTODic = this.reOrderDIDTO(diDTOs, zdtxList);
			if (diDTODic != null) {
				if (diDTODic.size() > 1) {
					showDigTypeName = true;
				}

				for (String zdtx : zdtxList) {
					if (!diDTODic.containsKey(zdtx)) {
						continue;
					}

					Map<String, Map<String, String>> dic = propertyDic.get(zdtx);
					Map<String, String> digTypeProeprty = dic.get(DIGTYPE_NODE);
					// 追加digType节点
					appendDigTypeProperty(builder, digTypeProeprty, showDigTypeName);

					// 追加dig、cdig节点
					appendDigProperty(builder, dic, diDTODic.get(zdtx));

					builder.append("</digType>");
				}
			}
		}
		builder.append("</dig>");
		builder.append("</root>");
		return builder.toString();
	}

	/**
	 * 追加digType节点
	 * @param builder
	 * @param digTypeProeprty
	 * @param dispalyName
	 */
	private void appendDigTypeProperty(StringBuilder builder, Map<String, String> digTypeProeprty,
			boolean dispalyName) {

		builder.append("<" + DIGTYPE_NODE);
		Iterator it = digTypeProeprty.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			builder.append(SPACE_STR);
			if (key == "name") {
				if (dispalyName) {
					builder.append(key + "=\"" + digTypeProeprty.get(key) + "\"");
				} else {
					builder.append(key + "=\"\"");
				}
			} else {
				builder.append(key + "=\"" + digTypeProeprty.get(key) + "\"");
			}
		}

		builder.append(">");
	}

	
	/**
	 * 追加dig节点
	 * @param builder
	 * @param proeprtyDic
	 * @param diDTOList
	 * @throws BizException
	 */
	private void appendDigProperty(StringBuilder builder, Map<String, Map<String, String>> proeprtyDic,
			List<DIDTO> diDTOList) throws BizException {
		// Type type = null;

		// dig节点属性
		Map<String, String> digProperty = proeprtyDic.get("dig");
		// cdig节点属性
		Map<String, String> cdigProperty = proeprtyDic.get("cdig");

		for (DIDTO diDTO : diDTOList) {
			/*
			 * if (type == null) { type = diDTO.GetType(); }
			 */
			builder.append("<" + DIG_NODE).append(SPACE_STR);
			appendNameStr(builder, diDTO, diDTO, digProperty.get("name"), digProperty.get("displayColumn"));
			builder.append(">");

			// 追加cdig节点内容
			appendCDigProperty(builder, diDTO, cdigProperty, diDTO);

			builder.append("</" + DIG_NODE + ">");
		}
	}

	
	/**
	 * 追加cdig节点属性
	 * @param builder
	 * @param type
	 * @param cdigProperty
	 * @param diDTO
	 * @throws BizException
	 */
	private void appendCDigProperty(StringBuilder builder, Object type, Map<String, String> cdigProperty, DIDTO diDTO)
			throws BizException {
		builder.append("<" + CDIG_NODE).append(SPACE_STR);
		;
		appendNameStr(builder, type, diDTO, cdigProperty.get("name"), cdigProperty.get("displayColumn"));
		builder.append("></" + CDIG_NODE + ">");
	}
	
	/**
	 * 追加循环的节点
	 * @param builder
	 * @param type
	 * @param diDTO
	 * @param nameStr
	 * @param displayColumn
	 * @throws BizException
	 */
	private void appendNameStr(StringBuilder builder, Object type, DIDTO diDTO, String nameStr, String displayColumn)
			throws BizException {
		String tempColName = null;
		String tempVal = null;

		if (nameStr == null || nameStr.equals("") || displayColumn == null || displayColumn.equals("")) {
			return;
		}

		// 属性分组 displayColumn="Id_disys_name;Fg_suspdi|Y:?,N:'',default:''"
		String[] columnArr = displayColumn.split(";");

		// 遍历所有displayColumn中配置的属性，并将属性值赋值给name中匹配的属性
		for (int i = 0; i < columnArr.length; i++) {
			tempColName = columnArr[i];

			// 用于判断属性中是否有需要将值进行转译
			String[] colValOptional = columnArr[i].split("\\|");

			if (colValOptional.length > 1) {
				tempColName = colValOptional[0];
			}
			tempVal = getPropertyVal(diDTO, tempColName);
			// 把结果替换成配置中对应的符号
			// displayColumn="Id_disys_name;Fg_suspdi|Y:?,N:'',default:''"
			if (!(tempVal == null || tempVal.equals("")) && colValOptional.length > 1) {
				String[] colValOptionalArr = colValOptional[1].split(",");
				for (String valOptional : colValOptionalArr) {
					String[] valDic = valOptional.split(":");
					if (valDic[0].equals(tempVal)) {
						if (valDic[1].equals("''")) {
							tempVal = "";
						} else {
							tempVal = valDic[1];
						}

						break;
					}
				}
			}

			// 将name字符串中指定的属性替换成对应的值
			nameStr = nameStr.replace("{" + tempColName + "}", tempVal);

		}
		builder.append("name=\"" + nameStr + "\"");
	}

	
	/**
	 * 根据属性名称获取属性值
	 * @param obj 获取值得数据对象
	 * @param propertyName 属性名称
	 * @return
	 * @throws BizException
	 */
	private String getPropertyVal(DIDTO obj, String propertyName) throws BizException {
		String[] obj_names = obj.getAttrNames();
		boolean isNaN = true;
		for (String name : obj_names) {
			if (name != null && name.equals(propertyName.toLowerCase())) {
				isNaN = false;
				obj.getAttrVal("");
			}
		}

		if (isNaN) {
			throw new BizException("对象中不包含属性[" + propertyName + "]");
		} else {
			Object valueObj = obj.getAttrVal(propertyName);
			String valStr = null;
			if (valueObj instanceof String || valueObj instanceof FDateTime) {// 字符串类型
				valStr = valueObj.toString();
			} else if (valueObj instanceof FBoolean) {
				valStr = (FBoolean) valueObj == FBoolean.TRUE ? "Y" : "N";
			} else {
				valStr = "";
			}
			return valStr;
		}

	}

	
	/**
	 * 将诊断数据按诊断体系进行分组
	 * @param diDTOs 诊断数据集合
	 * @param zdtxList 诊断体系集合
	 * @return
	 */
	private Map<String, List<DIDTO>> reOrderDIDTO(DIDTO[] diDTOs, List<String> zdtxList) {

		Map<String, List<DIDTO>> didtoList = null;

		if (zdtxList != null && zdtxList.size() > 0 && diDTOs != null && diDTOs.length > 0) {

			didtoList = new HashMap<String, List<DIDTO>>();

			Map<String, List<DIDTO>> diDTODic = new HashMap<String, List<DIDTO>>();

			for (DIDTO diDTO : diDTOs) {
				// 排除未在配置文件中指定的诊断体系
				if (!diDTODic.containsKey(diDTO.getId_disys())) {
					diDTODic.put(diDTO.getId_disys(), new ArrayList<DIDTO>());
				}
				// 是否为主诊断，主诊断放第一位
				if (diDTO.getFg_majdi() == FBoolean.TRUE) {
					diDTODic.get(diDTO.getId_disys()).add(0, diDTO);
				} else {
					diDTODic.get(diDTO.getId_disys()).add(diDTO);
				}
			}

			for (String zdtx : zdtxList) {
				if (diDTODic.containsKey(zdtx)) {
					didtoList.put(zdtx, diDTODic.get(zdtx));
				}
			}
		}
		return didtoList;
	}
	/**
	 * 获取诊断常量集合
	 * @param xmlPath
	 * @return
	 */
	private static List<String> getZdtxList(String xmlPath) {
		List<String> zdtxList = new ArrayList<String>();
		if (zdtxList != null || zdtxList.size() >0) {
			zdtxList = new ArrayList<>();
		}
		getXmlDic(xmlPath,zdtxList);
		return zdtxList;
	}
	/**
	 * 获取模板节点集合
	 * @param xmlPath
	 * @param zdtxList
	 * @return
	 */
	private static Map<String, Map<String, Map<String, String>>> getXmlDic(String xmlPath,List<String> zdtxList) {
		
		Map<String, Map<String, Map<String, String>>> dic = new HashMap<String,Map<String, Map<String, String>>>();
		dic = getXmlProperty(xmlPath,zdtxList);
		return dic;
	}
	/**
	 * 获取模板节点集合
	 * @param xmlPath
	 * @param zdtxList
	 * @return
	 */
	private static Map<String, Map<String, Map<String, String>>> getXmlProperty(String xmlPath,List<String> zdtxList) {

		Map<String, Map<String, Map<String, String>>> propertyDic = null;
		Element rootElement = loadXml(xmlPath);
		if (rootElement == null) {
			return propertyDic;
		}

		// 获取所有的digType节点
		List<Element> nodeList = rootElement.elements();
		if (nodeList != null && nodeList.size() > 0) {
//			zdtxList = new ArrayList<String>();
			propertyDic = new HashMap<String, Map<String, Map<String, String>>>();
			for (Element element : nodeList) {
				
				List<Element> els = element.elements();
				for (Element element2 : els) {
					// digType、 dig、cdig节点属性集合
					Map<String, Map<String, String>> nodeProperty = new HashMap<String, Map<String, String>>();

					// digType节点属性
					Map<String, String> digTypeNodeDic = getPropertyDic(element2);
					nodeProperty.put(DIGTYPE_NODE, digTypeNodeDic);
					// 获取诊断体系常量
					Attribute att = element2.attribute(ZDTX);
					zdtxList.add(att.getValue());

					// dig节点
					Element digNode = element2.element(DIG_NODE);
					Map<String, String> digNodePropertyDic = getPropertyDic(digNode);
					nodeProperty.put(DIG_NODE, digNodePropertyDic);

					// cdig节点
					Element cdigNode = digNode.element(CDIG_NODE);
					Map<String, String> cdigNodePropertyDic = getPropertyDic(cdigNode);
					nodeProperty.put(CDIG_NODE, cdigNodePropertyDic);

					// digType节点与子节点属性集合
					propertyDic.put(att.getValue(), nodeProperty);
				}
			}
		}

		return propertyDic;
	}
	/**
	 * 获取节点属性集合
	 * @param node
	 * @return
	 */
	private static Map<String, String> getPropertyDic(Element node) {

		Map<String, String> nodeDic = new HashMap<String, String>();

		List<Attribute> xmlAttrCollection = node.attributes();

		if (xmlAttrCollection != null && xmlAttrCollection.size() > 0) {
			for (Attribute attr : xmlAttrCollection) {
				nodeDic.put(attr.getName(), attr.getValue());
			}
		}
		return nodeDic;
	}
	/**
	 * 加载xml模板
	 * @param xmlPath
	 * @return
	 */
	private static Element loadXml(String xmlPath) {
		SAXReader reader = new SAXReader();
		Element root = null;
		try {
			Document doc = reader.read(new FileInputStream(new File(xmlPath)));
			root = doc.getRootElement();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return root;
	}
}

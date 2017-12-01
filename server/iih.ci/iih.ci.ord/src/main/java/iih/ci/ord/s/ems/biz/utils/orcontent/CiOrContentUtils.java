package iih.ci.ord.s.ems.biz.utils.orcontent;

import java.util.ArrayList;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.d.ICiOrContentConst;
import iih.ci.ord.content.d.NullOrContentFactory;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.utils.orcontent.dto.DrugOrContentParam;
import iih.ci.ord.s.ems.biz.utils.orcontent.dto.LisOrContentParam;
import iih.ci.ord.s.ems.biz.utils.orcontent.dto.OprOrContentParam;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public class CiOrContentUtils {
	/**
	 * 治疗类医嘱内容拼接
	 * 
	 * @param sd_srvtp
	 * @param fg_urgent
	 * @param name_srv
	 * @param name_route
	 * @return
	 */
	public static CiOrContentDO create(String sd_srvtp, String name_srv, String name_route, FBoolean fg_urgent) {
		CiOrContentDO contentdo = new CiOrContentDO();
		if (sd_srvtp != null && sd_srvtp != "") {
			contentdo.setTypeId(sd_srvtp);
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}

		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add(name_srv);
		list.add(arrList);

		ArrayList<String> routelist = new ArrayList<String>();
		// 拼接加急标识
		if (FBoolean.TRUE.equals(fg_urgent)) {
			routelist.add("加急！");
		}
		// 拼接用法标识
		if(!CiOrdUtils.isEmpty(name_route)){
			routelist.add(name_route);
		}

		contentdo.setTitle("");
		contentdo.setItemInfos(list);
		contentdo.setTailInfo(routelist);
		return contentdo;
	}

	/**
	 * 西成药类获得医嘱拼接内容
	 * 
	 * @param drugContentDTO
	 * @return
	 */
	public static CiOrContentDO create(DrugOrContentParam drugContentDTO) {
		CiOrContentDO contentdo = new CiOrContentDO();
		String sd_srvtp = drugContentDTO.getSd_srvtp();
		if (sd_srvtp != null && sd_srvtp != "") {
			contentdo.setTypeId(getSrvtpl(sd_srvtp));
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		contentdo.setTitle("");
		contentdo.setItemInfos(getItemInfos(drugContentDTO));

		ArrayList<String> list = new ArrayList<String>();
		list.add(drugContentDTO.getName_route());
		list.add(drugContentDTO.getName_freq());
		if (drugContentDTO.getNote() != null) {
			list.add(drugContentDTO.getNote());
		} else {
			list.add("");
		}
		list.add(drugContentDTO.getUse_days()+"天");
		contentdo.setTailInfo(list);
		return contentdo;
	}

	/**
	 * 检验类医嘱内容拼接
	 * 
	 * @param lisOrContentParam
	 * @return
	 * @throws BizException
	 */
	public static CiOrContentDO create(LisOrContentParam lisOrContentParam) throws BizException {
		CiOrContentDO contentdo = new CiOrContentDO();
		String sd_srvtp = lisOrContentParam.getSd_srvtp();
		if (sd_srvtp != null && sd_srvtp != "") {
			contentdo.setTypeId(sd_srvtp);
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		contentdo.setTitle("");
		contentdo.setItemInfos(getItemInfos(lisOrContentParam));

		ArrayList<String> list = new ArrayList<String>();
		String str = "";
		FBoolean Fg_urgent = lisOrContentParam.getFg_urgent();
		if (Fg_urgent != null && Fg_urgent.booleanValue()) {
			str += "加急！";
		}
		String note_or = lisOrContentParam.getNote();
		if (!CiOrdUtils.isEmpty(note_or)) {
			str += note_or;
		}
		if (str != "") {
			list.add(str);
		}
		contentdo.setTailInfo(list);
		return null;
	}

	/**
	 * 检查类医嘱内容拼接
	 * @param sd_srvtp
	 * @param fg_urgent
	 * @param note
	 * @param name_srv
	 *            服务名称
	 * @param body_names
	 *            部位拼接的字符串
	 * @return
	 * @throws BizException
	 */
	public static CiOrContentDO create(String sd_srvtp, FBoolean fg_urgent, String note, String name_srv,
			String body_names) throws BizException {
		CiOrContentDO contentdo = new CiOrContentDO();
		if (sd_srvtp != null && sd_srvtp != "") {
			contentdo.setTypeId(sd_srvtp);
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		contentdo.setTitle("");
		contentdo.setItemInfos(getItemInfos(name_srv, body_names));

		ArrayList<String> list = new ArrayList<String>();
		String str = "";
		if (fg_urgent != null && fg_urgent.booleanValue()) {
			str += "加急！";
		}
		if (!CiOrdUtils.isEmpty(note)) {
			str += note;
		}
		if (str != "") {
			list.add(str);
		}
		contentdo.setTailInfo(list);
		return null;
	}
	/**
	 * 用血类 获得医嘱拼接内容
	 * @param name_srv
	 * @param name_routedes
	 * @param quan_med
	 * @param name_unit_med
	 * @return
	 * @throws BizException
	 */
	public static CiOrContentDO create(String name_srv,String name_routedes,FDouble quan_med,String name_unit_med) throws BizException {
		CiOrContentDO contentdo=new CiOrContentDO();
		contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		contentdo.setTitle("");
		contentdo.setItemInfos(getBtUseItemInfos(name_srv,quan_med,name_unit_med));
		
		ArrayList<String> list = new ArrayList<String>();
		list.add(name_routedes);
		contentdo.setTailInfo(list);
		return contentdo;
	}
	
	/**
	 * 备血类 获得医嘱拼接内容
	 * @param sd_srvtp
	 * @param Sd_demandsu_bt
	 * @param name_srv
	 * @param quan_med
	 * @param name_unit_med
	 * @return
	 * @throws BizException
	 */
	public static CiOrContentDO create(String sd_srvtp, String Sd_demandsu_bt, String name_srv,FDouble quan_med,String name_unit_med) throws BizException {
		CiOrContentDO contentdo=new CiOrContentDO();
		contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_RISBINGLI);
		contentdo.setTitle("");
		contentdo.setItemInfos(getItemInfos(name_srv,quan_med,name_unit_med));
		
		ArrayList<String> list = new ArrayList<String>();
		if(Sd_demandsu_bt != null &&Sd_demandsu_bt.equals("0")){
			list.add("紧急");
		}
		contentdo.setTailInfo(list);
		return contentdo;
	}
	/**
	 * 用血类医嘱获得表体内容
	 * @param name_srv
	 * @param quan_med
	 * @param name_unit_med
	 * @return
	 */
	private static ArrayList<ArrayList<String>> getBtUseItemInfos(String name_srv,FDouble quan_med,String name_unit_med){
		ArrayList<ArrayList<String>> list = new	ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("输"+name_srv+quan_med.toDouble()+name_unit_med);
		arrList.add(quan_med.toDouble()+""); 
		arrList.add(name_unit_med);
		list.add(arrList);
		return list;
	}
	/**
	 * 备血类获得表体内容
	 * @param name_srv
	 * @param quan_med
	 * @param name_unit_med
	 * @return
	 */
	private static ArrayList<ArrayList<String>> getItemInfos(String name_srv,FDouble quan_med,String name_unit_med){
		ArrayList<ArrayList<String>> list = new	ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		String str="";
		str += name_srv+quan_med+ name_unit_med;
		arrList.add(str);
		list.add(arrList);
		return list;
	}
	/**
	 * 检查类 获得表体数据
	 * 
	 * @param ems
	 * @return
	 */
	private static ArrayList<ArrayList<String>> getItemInfos(String name_srv, String body_names) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		if (!StringUtils.isNullOrEmpty(body_names)) {
			arrList.add(name_srv + "(" + body_names + ")");
		} else {
			arrList.add(name_srv);
		}
		list.add(arrList);
		return list;
	}

	/**
	 * 检验获得表体内容
	 * 
	 * @param lisOrContentParam
	 * @return
	 * @throws BizException
	 */
	private static ArrayList<ArrayList<String>> getItemInfos(LisOrContentParam lisOrContentParam) throws BizException {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		String[] name_srvs = lisOrContentParam.getName_srvs();
		String name_samptp = lisOrContentParam.getName_samptp();
		for (int i = 0; i < name_srvs.length; i++) {
			// 如果有标本就拼接
			if (CiOrdUtils.isEmpty(name_samptp)) {
				arrList.add(name_srvs[i] + "(" + name_samptp + ")");
			} else {
				arrList.add(name_srvs[i]);
			}
		}
		list.add(arrList);
		return list;
	}

	/**
	 * 药品获得表体数据
	 * 
	 * @param drugContentDTO
	 * @return
	 */
	private static ArrayList<ArrayList<String>> getItemInfos(DrugOrContentParam drugContentDTO) {

		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

		String[] name_srvs = drugContentDTO.getName_srvs();
		FDouble[] quan_meds = drugContentDTO.getQuan_meds();
		String[] name_unit_meds = drugContentDTO.getName_unit_meds();
		boolean[] fg_selfs = drugContentDTO.getFg_selfs();
		for (int i = 0; i < name_srvs.length; i++) {
			ArrayList<String> arrList = new ArrayList<String>();
			if (fg_selfs[i]) {
				arrList.add(name_srvs[i] + "(自备)");
			} else {
				arrList.add(name_srvs[i]);
			}
			if (!CiOrdUtils.isEmpty(quan_meds[i])) {
				arrList.add(quan_meds[i].toString());
			} else {
				arrList.add("0");
			}
			arrList.add(name_unit_meds[i]);
			list.add(arrList);
		}

		return list;
	}
	/**
	 * 获得手术类拼接医嘱
	 * @param uiModel
	 * @return
	 */
	public static CiOrContentDO create(OprOrContentParam oprOrContentParam) {
		if(oprOrContentParam==null || oprOrContentParam.getName_srvs()==null || oprOrContentParam.getName_srvs().length==0){
			return getNullContent();
		}
		CiOrContentDO contentdo=new CiOrContentDO();
		String sd_srvtp = oprOrContentParam.getSd_srvtp();
		if(sd_srvtp != null && sd_srvtp !=""){
			contentdo.setTypeId(sd_srvtp);
		}else{
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		contentdo.setTitle("");
		contentdo.setItemInfos(getItemInfos(oprOrContentParam));
		contentdo.setTailInfo(getTailInfos(oprOrContentParam));
		return contentdo;
	}
	/**
	 * 获得空医嘱内容
	 * @param ems
	 */
	private static CiOrContentDO getNullContent(){
		CiOrContentDO contentdo=new CiOrContentDO();
		contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		contentdo.setTitle("");
		contentdo.setItemInfos(null);
		contentdo.setTailInfo(null);
		return contentdo;
	}
	/**
	 * 获得表体数据
	 * @param ems
	 * @return
	 */
	private static ArrayList<ArrayList<String>> getItemInfos(OprOrContentParam oprOrContentParam) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		String[] name_srvs = oprOrContentParam.getName_srvs()[0].split(CiOrdUtils.COMMA_STR);
		String str = "拟";
		if (oprOrContentParam.getDt_begin() != null) {
			str += "于";
			str += oprOrContentParam.getDt_begin().toStdString().substring(0, 10);
		}
		for (int i = 0; i < name_srvs.length; i++) {
			if (i == 0) {
				str += "行";
				str += name_srvs[i] + "+ ";
			} else {
				str += name_srvs[i] + "+ ";
			}
		}
		arrList.add(str.substring(0, str.lastIndexOf("+")));

		list.add(arrList);
		return list;
	}
	/**
	 * 获得表尾数据
	 * @param ems
	 * @return
	 */
	private static ArrayList<String>  getTailInfos(OprOrContentParam oprOrContentParam){
		ArrayList<String> list = new ArrayList<String>();
		list.add(ICiOrContentConst.ChangeToEscapeCharacter(oprOrContentParam.getName_routedes()));
		return list;
	}
	/**
	 * 药品类获得服务类型
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	private static String getSrvtpl(String sd_srvtp) {
		/*
		 * 0101普药： 010101 普通药品 010102 外用药 010199 其它 010201 中成药 010202 蒙成药
		 */
		if (sd_srvtp.equals("010101") || sd_srvtp.equals("010102") || sd_srvtp.equals("010199")
				|| sd_srvtp.equals("010201") || sd_srvtp.equals("010202")) {
			return ICiOrContentConst.ORContent_TYPE_DRUGDEFAULT;
		}

		/*
		 * 0102注射： 010103 注射类药品 010104 溶媒 010105 皮试液
		 */

		if (sd_srvtp.equals("010103") || sd_srvtp.equals("010104") || sd_srvtp.equals("010105")) {
			return ICiOrContentConst.ORContent_TYPE_DRUGDEFAULT2;
		}
		if(sd_srvtp.startsWith("0103")){
			return sd_srvtp;
		}
		return "0101";
	}
}

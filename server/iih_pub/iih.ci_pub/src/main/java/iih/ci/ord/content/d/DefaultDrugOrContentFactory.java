package iih.ci.ord.content.d;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;

/**
 * 医嘱内容生成西成药、中成药工厂（非草药）
 */
public class DefaultDrugOrContentFactory implements CiOrContentObjFactory {

	@Override
	public CiOrContentDO create(CiEmsDTO ems) {
		if(ems==null || ems.getEmssrvs()==null || ems.getEmssrvs().size()==0){
			return getNullContent(ems);
		}
		CiOrContentDO contentdo=new CiOrContentDO();
		String sd_srvtp = ((CiEmsSrvDTO)ems.getEmssrvs().get(0)).getSd_srvtp();
		if(sd_srvtp != null && sd_srvtp !=""){
			contentdo.setTypeId(getSrvtpl(sd_srvtp));
		}else{
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		contentdo.setTitle(getTitle(ems));
		contentdo.setItemInfos(getItemInfos(ems));
		contentdo.setTailInfo(getTailInfos(ems));
		return contentdo;
	}
	
	/**
	 * 获得标题数据
	 * @param ems
	 * @return
	 */
	private String getTitle(CiEmsDTO ems){
		return "";
	}
	
	/**
	 * 获得表体数据
	 * @param ems
	 * @return
	 */
	private ArrayList<ArrayList<String>>  getItemInfos(CiEmsDTO ems){
		
		if(ems == null || ems.getEmssrvs() == null) return null;
		ArrayList<ArrayList<String>> list = new	ArrayList<ArrayList<String>>();
		
		FArrayList emssrvs = ems.getEmssrvs();
		
	
		for(int i=0;i <emssrvs.size();i++){
			ArrayList<String> arrList = new ArrayList<String>();
			CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
			if(item.getStatus() == DOStatus.DELETED)continue;
			//删除的  用的不做医嘱内容拼接
			if(item != null && item.getStatus() != DOStatus.DELETED && item.getFg_or() != null &&  item.getFg_or().booleanValue()){
				if (item.getFg_self() == FBoolean.TRUE || item.getFg_selfsrv() == FBoolean.TRUE) {
					arrList.add(item.getName_srv() +"("+item.getName_mm()+")"+ "(自备)");
				} else {
					arrList.add(item.getName_srv()+"("+item.getName_mm()+")");
				}
				if(item.getQuan_med() != null){
					arrList.add(item.getQuan_med().toString());
				}else{
					arrList.add("0");
				}
				arrList.add(getName_unit_med(item.getName_unit_med()));
				list.add(arrList);
			}
		}
		
		return list;
	}
	
	/**
	 * 获得表尾数据
	 * @param ems
	 * @return
	 */
	private ArrayList<String> getTailInfos(CiEmsDTO ems) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(ems.getName_route());
		list.add(ems.getName_freq());
		String note = "", days = "", propcStr = "";
		note = ICiOrContentConst.ChangeToEscapeCharacter(ems.getNote());
		// 非住院的情况下要拼接天数
		if (!(StringUtils.isEmpty(ems.getCode_entp())
				|| ems.getCode_entp().equals(IEnDictCodeConst.SD_ENTP_INPATIENT))) {
			days = ems.getDays_or() + "天 ";
			;
		}
		// 治疗和预防用药的拼接；适用场景（治疗和预防只存在一个）
		FArrayList emssrvs = ems.getEmssrvs();
		for (int i = 0; i < emssrvs.size(); i++) {
			CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
			if (item.getFg_propc() != null && item.getFg_propc().booleanValue()) {
				propcStr = "抗生素预防使用";
				break;
			} else if (item.getFg_propc() != null && !item.getFg_propc().booleanValue()) {
				propcStr = "抗生素治疗使用";
				break;
				}
			}
		StringBuffer sb = new StringBuffer();
		sb.append(days);
		if(sb.length()==0){
			sb.append(propcStr);
		}else if(!StringUtils.isEmpty(propcStr)){
			sb.append(","+propcStr);
		}
		if(sb.length()==0){
			sb.append(note);
		}else if(!StringUtils.isEmpty(note)){
			sb.append(","+note);
		}
		list.add(sb.toString());
		return list;
	}
	
	/**
	 * 获得空医嘱内容
	 * @param ems
	 */
	private CiOrContentDO getNullContent(CiEmsDTO ems){
		NullOrContentFactory nullfact=new NullOrContentFactory();
		return nullfact.create(ems);
	}
	
     private String getSrvtpl(String sd_srvtp){
    	String srvtpl = "0101"; 
    	/*0101普药：   010101  普通药品
                   010102  外用药
                   010199  其它
                   010201  中成药
                   010202  蒙成药
        */
    	if(sd_srvtp.equals("010101") || sd_srvtp.equals("010102") ||sd_srvtp.equals("010199")
    			||sd_srvtp.equals("010201") ||sd_srvtp.equals("010202")){
    		return ICiOrContentConst.ORContent_TYPE_DRUGDEFAULT;
    	}
    	
    	/*0102注射：  010103  注射类药品
                 010104  溶媒
                 010105  皮试液*/

         if(sd_srvtp.equals("010103") || sd_srvtp.equals("010104") ||sd_srvtp.equals("010105")){
     		return ICiOrContentConst.ORContent_TYPE_DRUGDEFAULT2;
     	}
     	return  srvtpl = "0101"; 
     }
     /**
 	 * 
 	 * @param Name_unit_med
 	 * @return
 	 */
 	private   String getName_unit_med(String Name_unit_med){
 		if(Name_unit_med != null && Name_unit_med != ""){
 			Pattern pattern = Pattern.compile("^(\\d+)(.*)");
 			Matcher matcher = pattern.matcher(Name_unit_med);
 			if (matcher.matches()) { 
 				return "*"+Name_unit_med;
 			}else{
 				return Name_unit_med;
 			}
 			
 		}
 		return  "";
 	}
}

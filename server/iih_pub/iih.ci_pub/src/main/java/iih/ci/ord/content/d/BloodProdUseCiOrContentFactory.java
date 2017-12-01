package iih.ci.ord.content.d;

import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;

public class BloodProdUseCiOrContentFactory implements CiOrContentObjFactory {

	@Override
	public CiOrContentDO create(CiEmsDTO ems) {
		if(ems==null || ems.getEmssrvs()==null || ems.getEmssrvs().size()==0){
			return getNullContent(ems);
		}
		CiOrContentDO contentdo=new CiOrContentDO();
		contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
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
		ArrayList<String> arrList = new ArrayList<String>();
		FArrayList emssrvs = ems.getEmssrvs();
		FMap  map = ems.getOrapplysheet();
		OrdAppBtUseDO userDO =  (OrdAppBtUseDO)map.get(EmsType.BTUSE+"");
		for(int i=0;i <emssrvs.size();i++){
			CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
			if(item.getStatus() == DOStatus.DELETED || !item.getFg_or().booleanValue())continue;
			arrList.add("输"+item.getName_srv()+item.getQuan_med().toDouble()+getName_unit_med(item.getName_unit_med()));
			//arrList.add(item.getQuan_med().toDouble()+""); //todo 
			//arrList.add(item.getName_unit_med());
		}
		list.add(arrList);
		return list;
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
	
	/**
	 * 获得表尾数据
	 * @param ems
	 * @return
	 */
	private ArrayList<String>  getTailInfos(CiEmsDTO ems){
		ArrayList<String> list = new ArrayList<String>();
		list.add(ICiOrContentConst.ChangeToEscapeCharacter(ems.getName_routedes()));
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
}


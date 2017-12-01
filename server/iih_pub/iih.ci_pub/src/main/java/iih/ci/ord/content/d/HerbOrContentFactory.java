package iih.ci.ord.content.d;

import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;

import java.util.ArrayList;

import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;

/**
 * 医嘱内容生成草药生成工厂
 */
public class HerbOrContentFactory implements CiOrContentObjFactory {

	@Override
	public CiOrContentDO create(CiEmsDTO ems) {
		if(ems==null || ems.getEmssrvs()==null || ems.getEmssrvs().size()==0){
			return getNullContent(ems);
		}
		CiOrContentDO contentdo=new CiOrContentDO();
		String sd_srvtp = ((CiEmsSrvDTO)ems.getEmssrvs().get(0)).getSd_srvtp();
		if(sd_srvtp != null && sd_srvtp !=""){
			//contentdo.setTypeId(sd_srvtp);
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_HERB);
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
		return Integer2String(ems.getOrders());
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
		String str = "";
		String Note = "";
		ArrayList<String> arrList = new ArrayList<String>();
		for(int i=0;i <emssrvs.size();i++){
			if(i >3) break;
			CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
			//删除的不拼接内容, 非临床项目不拼接
			if(item != null && item.getStatus() != DOStatus.DELETED && 
					item.getFg_or()!=null && item.getFg_or().booleanValue()){
				//arrList.add(item.getName_srv());
				str +=item.getName_srv()+"，";
				
				/*if(item.getQuan_med() != null){
					arrList.add(item.getQuan_med().toString());
				}else{
					arrList.add("0");
				}
				arrList.add(item.getName_unit_med());
				arrList.add(item.getName_boil());*/
				
			}
		}
		if(str != ""){
			if(emssrvs.size()  >4){
				str = str.substring(0, str.length()-1)+" 等";
			}else{
				str = str.substring(0, str.length()-1);
			}
			
		}
		if(ems.getNote() != null && !"".equals(ems.getNote())){
			Note = ICiOrContentConst.ChangeToEscapeCharacter(ems.getNote());
		}
		arrList.add(str+"  "+Note);
		list.add(arrList);
		return list;
	}
	
	/**
	 * 获得表尾数据
	 * @param ems
	 * @return
	 */
	private ArrayList<String>  getTailInfos(CiEmsDTO ems){
		ArrayList<String> list = new ArrayList<String>();
		/*list.add(ems.getName_route());
		list.add(ems.getName_freq());
		list.add(ems.getName_routedes());*/
		return list;
	}
	
	/**
	 * Integer转换为字符串
	 * @param input
	 * @return
	 */
	private String Integer2String(Integer input){
		if(input==null)return "";
		return input.toString();
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

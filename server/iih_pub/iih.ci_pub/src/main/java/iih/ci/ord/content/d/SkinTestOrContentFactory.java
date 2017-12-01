package iih.ci.ord.content.d;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;

/**
 * 医嘱内容生成皮试类生成工厂
 */
public class SkinTestOrContentFactory implements CiOrContentObjFactory {

	private String ismuldose;
	private String ismulexec;
	
	@Override
	public CiOrContentDO create(CiEmsDTO ems) throws DAException {
		if(ems==null || ems.getEmssrvs()==null || ems.getEmssrvs().size()==0){
			return getNullContent(ems);
		}
		CiOrContentDO contentdo=new CiOrContentDO();
		String sd_srvtp = ((CiEmsSrvDTO)ems.getEmssrvs().get(0)).getSd_srvtp();
		if(sd_srvtp != null && sd_srvtp !=""){
			contentdo.setTypeId(sd_srvtp);
		}else{
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		
		List<String> lst = GetSrvExecDose.exec(ems.getId_srv());
		ismuldose = lst.get(0);
		ismulexec = lst.get(1);
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
	 * @throws DAException 
	 */
	private ArrayList<ArrayList<String>>  getItemInfos(CiEmsDTO ems) throws DAException{
		if(ems == null || ems.getEmssrvs() == null) return null;
		ArrayList<ArrayList<String>> list = new	ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		FArrayList emssrvs = ems.getEmssrvs();
		
		if(ems.getSd_srvtp().equals("0506")){
			CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(0);
			arrList.add(item.getName_srv());
			list.add(arrList);
			return list;
		}
		
		for(int i=0;i <emssrvs.size();i++){
			CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
			if (item.getStatus() == DOStatus.DELETED)
				continue;
			
			arrList.add((item.getName_srv() == null) ? "" : item.getName_srv());
		}
		
		if (ismuldose != null && ismuldose.equals("Y")) {
			arrList.add((ems.getQuan_medu() == null) ? "" : ems.getQuan_medu().toString());
			arrList.add((ems.getName_unit_med() == null) ? "" : ems.getName_unit_med());
		}
		
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
//		list.add(ems.getName_routedes() == null ? "" : ems.getName_routedes());
		if (ismulexec != null && ismulexec.equals("Y")) {
			list.add(((ems.getName_freq() == null) ? "" : ems.getName_freq().toString())
					+ ((ems.getDays_or() == null) ? "" : "   " + ems.getDays_or().toString() + "天"));
		}
		FBoolean fg_urgent = ems.getFg_urgent();
		if(fg_urgent != null && fg_urgent.booleanValue()){
			list.add("加急！");//li_cheng  将“加急” 改成  “加急！”   
		}
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

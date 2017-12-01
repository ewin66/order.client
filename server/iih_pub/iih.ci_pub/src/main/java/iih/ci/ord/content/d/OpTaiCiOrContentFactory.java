package iih.ci.ord.content.d;

import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;

import java.util.ArrayList;

import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;

public class OpTaiCiOrContentFactory implements CiOrContentObjFactory {

	@Override
	public CiOrContentDO create(CiEmsDTO ems) {
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
		
		 FMap map= ems.getOrapplysheet();
		 
		 String str = "拟";
		 CiorappsurgeryAggDO consDO = (CiorappsurgeryAggDO)map.get(EmsType.OPER+"");
		if(consDO != null  ){
			if(ems.getDt_begin() != null  ){
				str += "于";
				str += ems.getDt_begin().toStdString().substring(0, 10);
			}
			for(int i =0;i<emssrvs.size();i++){
				CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
				if(item.getStatus() == DOStatus.DELETED || !item.getFg_or().booleanValue())continue;
				if(i==0){
				   str += "行";
				   str +=item.getName_srv() +"+ ";
				}else{
				   str +=item.getName_srv() +"+ ";
				}
			}
			 arrList.add(str.substring(0, str.lastIndexOf("+")));
			 
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

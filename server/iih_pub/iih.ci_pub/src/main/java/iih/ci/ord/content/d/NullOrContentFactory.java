package iih.ci.ord.content.d;

import java.util.ArrayList;

import iih.ci.ord.ems.d.CiEmsDTO;
/**
 * 医嘱内容生成空生成工厂
 */
public class NullOrContentFactory  implements CiOrContentObjFactory {

	@Override
	public CiOrContentDO create(CiEmsDTO ems) {
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
		return null;
	}
	
	/**
	 * 获得表尾数据
	 * @param ems
	 * @return
	 */
	private ArrayList<String>  getTailInfos(CiEmsDTO ems){
		return null;
	}

}

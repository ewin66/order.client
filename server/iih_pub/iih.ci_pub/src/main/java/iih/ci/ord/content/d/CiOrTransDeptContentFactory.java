package iih.ci.ord.content.d;

import java.util.ArrayList;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;

public class CiOrTransDeptContentFactory implements CiOrContentObjFactory {
    
	 public String name = "";
	@Override
	public CiOrContentDO create(CiEmsDTO ems) throws BizException {
		if(ems.getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CROSSDEPT)){
			this.name = "跨科到：";
		}else if(ems.getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSDEPT)||
				ems.getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSWARD)){
			this.name = "转到：";
		}
	
		
		// TODO Auto-generated method stub
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
	 * @throws BizException 
	 */
	private String getTitle(CiEmsDTO ems) throws BizException{
		FMap  map = (FMap)ems.getOrapplysheet();
		if(map == null){
			throw new BizException("未获取服务【"+ems.getName()+"】对应的申请单，请在申请单维护中进行配置！");
		}
		OrdApTransDO trando = (OrdApTransDO)map.get(EmsType.TRANSDEPT.toString());
		return  this.name+trando.getName_dep_to() +""+ trando.getName_dep_nur_to();
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
		FMap  map = (FMap)ems.getOrapplysheet();
		OrdApTransDO trando = (OrdApTransDO)map.get(EmsType.TRANSDEPT.toString());
		arrList.add( this.name+trando.getName_dep_to() +""+ trando.getName_dep_nur_to());
	/*	for(int i=0;i <emssrvs.size();i++){
			CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
			arrList.add(item.getName_srv());
		}*/
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

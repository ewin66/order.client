package iih.ci.ord.content.d;

import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;

import java.util.ArrayList;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
/**
 * 会诊
 * @author li_zheng
 *
 */
public class OPNormOrContentFactory implements CiOrContentObjFactory {
      private String  Fg_urgent = null;
	@Override
	public CiOrContentDO create(CiEmsDTO ems)throws BizException {
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
	 * @throws BizException 
	 */
	private ArrayList<ArrayList<String>>  getItemInfos(CiEmsDTO ems) throws BizException{
		if(ems == null || ems.getEmssrvs() == null) return null;
		ArrayList<ArrayList<String>> list = new	ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		FArrayList emssrvs = ems.getEmssrvs();
		 FMap map= ems.getOrapplysheet();
		 if(map== null){
			throw  new BizException("邀请科室为空"); 
		 }
		 String str = "请";
		 String fg_unget ="";
		 CiorappconsultAggDO consDO = (CiorappconsultAggDO)map.get(EmsType.CONS+"");
		if(consDO != null && consDO.getCiordInviteConsDO() !=null){
			for(int i =0;i<consDO.getCiordInviteConsDO().length;i++){
				if(consDO.getCiordInviteConsDO()[i].getStatus() == DOStatus.DELETED)continue;
				str +=consDO.getCiordInviteConsDO()[i].getName_dep();
				if(consDO.getParentDO().getFg_urgent()==FBoolean.TRUE){
					Fg_urgent = "加急！";
				}
				if(consDO.getCiordInviteConsDO()[i].getName_emp() != null){
					str += consDO.getCiordInviteConsDO()[i].getName_emp()+",";	
				}else{
					str +=",";
				}
			
			}
			 arrList.add(str.substring(0, str.lastIndexOf(","))+"会诊");
			 
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
		if(Fg_urgent != null){
			list.add(Fg_urgent);
		}
		Fg_urgent = null;
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

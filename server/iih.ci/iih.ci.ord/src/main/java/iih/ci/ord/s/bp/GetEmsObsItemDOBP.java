package iih.ci.ord.s.bp;

import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.d.desc.MedSrvRisDODesc;
import iih.bd.srv.medsrv.i.IMedSrvRisDORService;
import iih.ci.ord.ciordems.d.EmsObsItemDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class GetEmsObsItemDOBP {

	/**
	 *检查的项目(新增时 bd_)
	 * @param id_srv
	 * @param type
	 * @return
	 * @throws BizException
	 */
	public EmsObsItemDO[] exce(String id_srv,String type)throws BizException{
		
		EmsObsItemDO[] emdObsItemDo = null;
		
		IMedSrvRisDORService  service = ServiceFinder.find(IMedSrvRisDORService.class);
		String whereStr = "";
		if(id_srv != null && id_srv != null){
			whereStr = MedSrvRisDODesc.TABLE_ALIAS_NAME+".id_srv ='"+id_srv+"'";
		}
		MedSrvRisDO[]  medsrvRis = service.find(whereStr, MedSrvRisDODesc.TABLE_ALIAS_NAME+".id_srv", FBoolean.FALSE);
		 if(medsrvRis != null && medsrvRis.length >0){
			 emdObsItemDo  = new EmsObsItemDO[ medsrvRis.length];
			  int i =0;
			 for(MedSrvRisDO item :medsrvRis){
				 EmsObsItemDO emsobsDO = new EmsObsItemDO();
				 //emsobsDO.setId_srvobs(item.getId_srvobs());
			
				 emsobsDO.setId_obstp(item.getId_obstp());
				
				 emsobsDO.setId_body(item.getId_body());
				 emsobsDO.setSd_body(item.getSd_body());
				 emsobsDO.setId_pos(item.getId_pos());
				 emsobsDO.setSd_pos(item.getSd_pos());
				 emsobsDO.setId_srv(item.getId_srv());
				 emsobsDO.setSv(item.getSv());
				 emsobsDO.setName_body(item.getName_body());
		 
				 
		          emdObsItemDo[i] = emsobsDO;
		          i++;
			 }
		 }		
		return emdObsItemDo;
	}
	
	
	
}

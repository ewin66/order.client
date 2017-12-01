package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.IMpDictCodeTypeConst;
import iih.ci.ord.dto.vitalsignsdto.d.VitalSignsDto;
import iih.ci.ord.pub.CiOrdAppUtils;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FDateTime;

/**
 * 取得生命体征信息
 * @author li_zheng
 *
 */
public class getCiorderPreviewDTOSBP {
	/*体温   36-37.2正常
	 血压   高压90-139.9、低压60-90  正常
	  脉搏   60-100正常
	 呼吸   16-20正常 */
	/*public static final String SD_TEMPERATURE_SRVVT = "SMTZ0001";// 体温
	public static final String SD_PLUS_SRVVT = "SMTZ0002";// 脉搏
	public static final String SD_HEART_SRVVT = "SMTZ0003";// 心率
	public static final String SD_BREATH_SRVVT = "SMTZ0004";// 呼吸
	public static final String SD_PRESSURE_SRVVT = "SMTZ0005";// 血压
	public static final String SD_WEIGTH_SRVVT = "SMTZ0006";// 体重*/
	public VitalSignsDto getCiorderPreviewDTOS(String id_ent,String age) throws BizException{
		
		iih.mp.nr.foreign.d.CiorderPreviewDTO[]  PreviewDTOS = CiOrdAppUtils.getIForeignService().getCiorderPreviewDTOS(id_ent);
	    if(PreviewDTOS == null) return null;
	    VitalSignsDto vitalsigns = new VitalSignsDto();
		//iih.ci.ord.dto.foreign.d.CiorderPreviewDTO[] ciorderPreview = new iih.ci.ord.dto.foreign.d.CiorderPreviewDTO[PreviewDTOS.length];
		FMap2 Infomap = new FMap2();
		vitalsigns.setInfomap(Infomap);
	    //数据对象转换成Map结构
	    Map<String,iih.mp.nr.foreign.d.CiorderPreviewDTO>  MapCode = new HashMap();
	    for(iih.mp.nr.foreign.d.CiorderPreviewDTO preview :PreviewDTOS){
	    	MapCode.put(preview.getCode(), preview);
	    }
	     //
	    if(MapCode != null && MapCode.size() >0){
	    	iih.mp.nr.foreign.d.CiorderPreviewDTO preview;
	    	// 心率	
	    	if(MapCode.containsKey(IMpDictCodeTypeConst.SD_HEART_SRVVT)){
	    		vitalsigns.setHeart_rate(MapCode.get(IMpDictCodeTypeConst.SD_HEART_SRVVT).getValue());
				Infomap.put("Heart_rate", true);
	    	 }else{
	    		Infomap.put("Heart_rate", false);
	    	}
	    	  //体重
			if(MapCode.containsKey(IMpDictCodeTypeConst.SD_WEIGTH_SRVVT)){
				vitalsigns.setWeight(MapCode.get(IMpDictCodeTypeConst.SD_WEIGTH_SRVVT).getValue());
				Infomap.put("Weight", false);
			}
	    	
			//血压
			if(MapCode.containsKey(IMpDictCodeTypeConst.SD_PRESSURE_SRVVT)){
				preview = MapCode.get(IMpDictCodeTypeConst.SD_PRESSURE_SRVVT);
				if(preview.getValue() != null && preview.getValue().indexOf("/")>=0){
					String[] PRESSURE = preview.getValue().split("/");
					if(PRESSURE != null && PRESSURE.length==2){
						vitalsigns.setBpmin(PRESSURE[1]);
						vitalsigns.setBpmax(PRESSURE[0]);
						 Infomap.put("Bpmin", CompareParaMeter(vitalsigns.getBpmin(),"90","60"));
						 Infomap.put("Bpmin1", compareDate(preview.getDt_vt()));
						 Infomap.put("Bpmax", CompareParaMeter(vitalsigns.getBpmax(),"140","90"));
						 Infomap.put("Bpmax1", compareDate(preview.getDt_vt()));
					}
				}else{
					vitalsigns.setBpmin(preview.getValue());
					 Infomap.put("Bpmin", CompareParaMeter(vitalsigns.getBpmin(),"90","60"));
					 Infomap.put("Bpmin1", compareDate(preview.getDt_vt()));
					 Infomap.put("Bpmax", CompareParaMeter(vitalsigns.getBpmax(),"140","90"));
					 Infomap.put("Bpmax1", compareDate(preview.getDt_vt()));
				}
			}else{
				 Infomap.put("Bpmin", CompareParaMeter(null,"90","60"));
				 Infomap.put("Bpmin1", compareDate(null));
				 Infomap.put("Bpmax", CompareParaMeter(null,"140","90"));
				 Infomap.put("Bpmax1", compareDate(null));
			} 
			// 脉搏
			preview = MapCode.get(IMpDictCodeTypeConst.SD_PLUS_SRVVT);
			if(MapCode.containsKey(IMpDictCodeTypeConst.SD_PLUS_SRVVT)){
				 vitalsigns.setPulse(preview.getValue());
					 Infomap.put("Pulse", CompareParaMeter(preview.getValue(),"100","60"));
	 				 Infomap.put("Pulse1", compareDate(preview.getDt_vt()));
		  	}else{
				 Infomap.put("Pulse", CompareParaMeter(null,"100","60"));
				 Infomap.put("Pulse1", compareDate(null));
			 }
			//呼吸
			preview = MapCode.get(IMpDictCodeTypeConst.SD_BREATH_SRVVT);
			if(MapCode.containsKey(IMpDictCodeTypeConst.SD_BREATH_SRVVT)){
				 vitalsigns.setBreath(preview.getValue());
				 Infomap.put("Breath", CompareParaMeter(preview.getValue(),"20","16"));
 				 Infomap.put("Breath1", compareDate(preview.getDt_vt()));
					 
			}else{
				 Infomap.put("Breath", CompareParaMeter(null,"20","16"));
 				 Infomap.put("Breath1", compareDate(null));
			}
			//体温
			preview = MapCode.get(IMpDictCodeTypeConst.SD_TEMPERATURE_SRVVT);
			if(MapCode.containsKey(IMpDictCodeTypeConst.SD_TEMPERATURE_SRVVT)){
				    vitalsigns.setTemperature(preview.getValue());
				    Infomap.put("Temperature", CompareParaMeter(preview.getValue(),"37.2","36"));
				    Infomap.put("Temperature1", compareDate(preview.getDt_vt()));
				 
			}else{
				Infomap.put("Temperature", CompareParaMeter(null,"37.2","36"));
			    Infomap.put("Temperature1", compareDate(null));
			}
	    	
	    }else{
	      //异常数据	
	    }
		 
		return vitalsigns;
	}
     //比较大小在页面显示 正常 
	 private Boolean CompareParaMeter(String value,String parameterValueMax,String parammeterMin){
	   Boolean isFalse = true;
	   if(value != null && value.length()>0){
		   Double dv = Double.parseDouble(value);
		   Double paramMax = Double.parseDouble(parameterValueMax);
		   Double paramMin = Double.parseDouble(parammeterMin);
		   if( paramMin > dv || dv > paramMax){
			   isFalse = false;
		   }
	   }
	   return isFalse;
	 }
	 //和当前时间比较
	 private Boolean compareDate(FDateTime dateTime){
		 Boolean isFalse = true;
		 if( dateTime != null && dateTime.after(CiOrdAppUtils.getServerDateTime())){
			 isFalse = false;
		 }
		 return isFalse;
	 }
}

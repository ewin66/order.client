package iih.ci.ord.s.bp.iemsg.reissue.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.i.ICiorapplisRService;
import iih.ci.ord.cior.i.ICiorapprisRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.ip.reissue.BS023Param;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;

public class GetCiOrderBP {
	
    public  CiOrderDO[] exe(BS023Param param) throws BizException{
    	ICiorderMDORService service = ServiceFinder.find(ICiorderMDORService.class);
    	CiOrderDO[] ciords =null;
		if(!StringUtils.isEmpty(param.getOrderNo())||!StringUtils.isEmpty(param.getApplyId())){			
			ciords = service.find(getorid8AppNo(param), "", FBoolean.FALSE);			
		}else{				
			ciords = service.find(getQrySql(param), "", FBoolean.FALSE);			
		}
		
		return ordFilter(ciords, param);
		
	}
    

    /**
     * 已知患者，无医嘱号或申请单号信息时，查询患者已记账、未退费、未执行的申请单
     * @param param
     * @return
     * @throws BizException
     */

	private String getQrySql(BS023Param param) throws BizException{
		
		StringBuilder sb=new StringBuilder();
		sb.append(" 1=1 ");
		//就诊域
		sb.append(getDomainIdSql(param.getDomainId()));
		//患者就诊卡号
		sb.append(getPatIdSql(param));
		//服务id
		sb.append( getServiceIdSql( param));
		//已记账、未退费、未执行的申请单
		sb.append(getMPAndBLSql(param));

		return sb.toString();
	}
	/**
	 * 已知患者及申请单号
	 * @param param
	 * @return
	 * @throws BizException
	 */
    private String getorid8AppNo(BS023Param param) throws BizException{
    	
    	String noapp=param.getApplyId();
    	if(StringUtils.isEmpty(noapp))
    		noapp=param.getOrderNo();
    	StringBuilder sb=new StringBuilder();
    	if(param.getServiceId().equals("BS002")){
    		ICiorapprisRService risservice=ServiceFinder.find(ICiorapprisRService.class);
    		OrdApObsDO[] obs=risservice.find(" NO_APPLYFORM='"+noapp+"'", "", FBoolean.FALSE);
    		
    		for (OrdApObsDO obj : obs) {
    			if(sb.length()==0){
    				sb.append(" '"+obj.getId_or()+"'");
    			}else{
    				sb.append(", '"+obj.getId_or()+"'");
    			}
				
			}
			
		}else if(param.getServiceId().equals("BS006")){
			ICiorapplisRService lisservice=ServiceFinder.find(ICiorapplisRService.class);
			OrdApLabDO[] obs=lisservice.find("NO_APPLYFORM='"+noapp+"'", "", FBoolean.FALSE);
			for (OrdApLabDO obj : obs) {
    			if(sb.length()==0){
    				sb.append(" '"+obj.getId_or()+"'");
    			}else{
    				sb.append(", '"+obj.getId_or()+"'");
    			}
			}
			
		}
    	if(sb.length() == 0){
    		return  CiOrderDODesc.TABLE_ALIAS_NAME+".id_or in  ('')";
    	}else{
    		return CiOrderDODesc.TABLE_ALIAS_NAME+".id_or in  (" +sb.toString()+ ") and "+CiOrderDODesc.TABLE_ALIAS_NAME+".id_su_bl !='"+ICiDictCodeTypeConst.ID_SU_BL_2+"' and "+CiOrderDODesc.TABLE_ALIAS_NAME+".fg_canc='N'";
    	}
    	
    	
    }
	private String getDomainIdSql(String domainid){
		if(domainid.equals("01")){
			return " And " +CiOrderDODesc.TABLE_ALIAS_NAME + ".code_entp='"+IBdFcDictCodeConst.SD_CODE_ENTP_OP+"'";
		}else if(domainid.equals("02")){
			return " And " +CiOrderDODesc.TABLE_ALIAS_NAME + ".code_entp='"+IBdFcDictCodeConst.SD_CODE_ENTP_IP+"'";
		}
		return null;
	}
	private String getServiceIdSql(BS023Param param) throws BizException{
		if(param.getServiceId().equals("BS002")){
			return " And " +CiOrderDODesc.TABLE_ALIAS_NAME + ".sd_srvtp like '"+ IBdSrvDictCodeConst.SD_SRVTP_RIS +"%'";
		}else if(param.getServiceId().equals("BS006")){
			return " And " +CiOrderDODesc.TABLE_ALIAS_NAME + ".sd_srvtp like '"+ IBdSrvDictCodeConst.SD_SRVTP_LIS +"%'";
		}
		return null;
	}
	
	private String getMPAndBLSql(BS023Param param) throws BizException{

			return " And " +CiOrderDODesc.TABLE_ALIAS_NAME + ".Sd_su_mp = '"+ICiDictCodeConst.SD_SU_MP_NONE +"' and "
						+CiOrderDODesc.TABLE_ALIAS_NAME + ".Sd_su_bl = '"+ICiDictCodeConst.SD_SU_BL_ACCOUNT +"'";
	
	}
	private String getPatIdSql(BS023Param param) throws BizException{
		String idpat= getPatid(param);
		
		return " And " +CiOrderDODesc.TABLE_ALIAS_NAME + ".id_pat='"+idpat+"'";
	}
	private String getPatid(BS023Param param) throws BizException{
		IPatiMDORService patservice=ServiceFinder.find(IPatiMDORService.class);
		StringBuilder sb=new StringBuilder();
		if(param.getDomainId().equals("01")){
			sb.append(" barcode_chis='"+param.getEncounterCardNo()+"'");
		}else if(param.getDomainId().equals("02")){
			sb.append(" code_amr_ip='"+param.getEncounterCardNo()+"'");
		}
		PatDO[] p=patservice.find(sb.toString(), "",  FBoolean.FALSE);
		return p[0].getId_pat();
	}
	
	private CiOrderDO[] ordFilter(CiOrderDO[] ciors,BS023Param param) throws BizException{
		if(ciors==null)return null;
		//机构过滤
		CiOrderDO[] ordnew=OrgFilter(ciors, param);
		
		return ordnew;
	}
	
	
	private  CiOrderDO[] OrgFilter(CiOrderDO[] ciors,BS023Param param) throws BizException{
		
		Map<String,List<CiOrderDO>> orgmaplist=new HashMap<String, List<CiOrderDO>>();
		List<String> orgids=new ArrayList<String>();
		for (CiOrderDO obj : ciors) {
			orgids.add(obj.getId_org());
			if(orgmaplist.containsKey(obj.getId_org())){
				List<CiOrderDO> ordlist=orgmaplist.get(obj.getId_org());
				ordlist.add(obj);
			}else{
				List<CiOrderDO> ordlist=new ArrayList<CiOrderDO>();
				ordlist.add(obj);
				orgmaplist.put(obj.getId_org(), ordlist);
			}
			
		}
		IOrgRService orgservice=ServiceFinder.find(IOrgRService.class);
		if (orgids.size() > 0) {
			OrgDO[] orgs=orgservice.findByBIds( orgids.toArray(new String[0]), FBoolean.FALSE);
			List<CiOrderDO> ciorlist=new ArrayList<CiOrderDO>();
			for (OrgDO orgDO : orgs) {
				if(orgDO.getOrgcode()!=null&&orgDO.getOrgcode().equals(param.getHospitalCode())){
					ciorlist.addAll(orgmaplist.get(orgDO.getId_org()));
				}
			}
			return ciorlist.toArray(new CiOrderDO[0]);
		}else{
			return null;
		}
		
	}
	
	

}

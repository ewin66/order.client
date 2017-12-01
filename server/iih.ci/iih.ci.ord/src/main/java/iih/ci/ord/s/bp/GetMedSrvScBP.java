package iih.ci.ord.s.bp;

import iih.bd.pp.hp.i.IHpExtService;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaRService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.desc.MedSrvDODesc;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.ortpl.d.OrTplDO;
import iih.ci.ord.ciordems.d.EmsOrSrvSc;
import iih.ci.ord.dto.d.OrtplDTO;
import iih.ci.ord.pub.CiOrdAppUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetMedSrvScBP {

	
	// medSrv 服务
	IMedsrvMDORService  medSrv = ServiceFinder.find(IMedsrvMDORService.class);
	
	/**
	 * 根据 id 检索医疗服务
	 * @param srvca
	 * @param srvName
	 * @param Healthca
	 * @return
	 * @throws BizException
	 */
	public  EmsOrSrvSc[] getBdSrv_id(String id_srv)throws BizException{
		EmsOrSrvSc[] emsOrScSrv = null;
		if(id_srv != null && id_srv != ""){
			MedSrvDO medsrvs  =  medSrv.findById(id_srv);
			if(medsrvs != null ){
				emsOrScSrv = new EmsOrSrvSc[1];
				EmsOrSrvSc emsSrv = new EmsOrSrvSc();
				emsSrv.setCode_srv(medsrvs.getCode());
				emsSrv.setDes(medsrvs.getDes());
				emsSrv.setId_srv(medsrvs.getId_srv());
				emsSrv.setName_srv(medsrvs.getName());
				emsSrv.setMedSrvDO(medsrvs);
				//emsSrv.setHealthca(hpsrvca.getHpsrvtp_name());
				emsSrv.setMnecode(medsrvs.getMnecode());
//				emsSrv.setName_srvca(medsrvs.getName_srvreact());
				emsOrScSrv[0] = emsSrv;
			}	
		}
		return emsOrScSrv;
	 }
	
	/**
	 * 根据 医疗服务名 ，拼音码 五笔码
	 * @param srvca
	 * @param srvName
	 * @param Healthca
	 * @return
	 * @throws BizException
	 */
	public EmsOrSrvSc[] exec(String srvca,String srvName,String Healthca,String code_entp)throws BizException{
		
 
	     //String sql  = " select  distinct a0.*    from bd_srv a0 left outer  join   bd_srvoth_wordfreq wordfreq   on  a0.id_srv = wordfreq.id_biz   where   ";
		String whereStr = MedSrvDODesc.TABLE_ALIAS_NAME+"."+MedSrvDO.FG_OR+ "='Y'  and "
				+MedSrvDODesc.TABLE_ALIAS_NAME+"."+MedSrvDO.FG_ACTIVE+ "='Y'  and "
		        +MedSrvDODesc.TABLE_ALIAS_NAME+"."+MedSrvDO.DS+ "='0'   and  "
		        +"      rownum  < 300   ";
		  if(this.getFgUsertype(code_entp) != null){
			  whereStr += " and  fg_use_" +this.getFgUsertype(code_entp) +" = 'Y'  ";
		  }        
		EmsOrSrvSc[] emsOrScSrv = null;
		if(srvca != null && srvca != ""){
			whereStr += "  and "+ MedSrvDODesc.TABLE_ALIAS_NAME+".sd_srvtp like '" +srvca+"%'   ";
		
		}
		if(srvName != null && srvName != ""){
			srvName = srvName.replaceAll("[ ]+","%").toUpperCase();
			srvName = srvName=="%"?"":srvName;
			whereStr += " and  (Upper( "+ MedSrvDODesc.TABLE_ALIAS_NAME+".name) like '" +srvName+"%'";
			whereStr +=  " or Upper("+ MedSrvDODesc.TABLE_ALIAS_NAME+".PYCODE) like '" +srvName+"%'";
			whereStr +=  " or Upper("+ MedSrvDODesc.TABLE_ALIAS_NAME+".wbcode) like '" +srvName+"%' ";
			whereStr +=  " or Upper("+ MedSrvDODesc.TABLE_ALIAS_NAME+".wbcode) like '" +srvName+"%')";
		}
		//whereStr +="  order by    a0.id_srv  ";
		String OrderBY= "   (Case When  a0.PYCODE ='"+srvName+".'   Then 1 Else 0 End)+(Case When  instr(a0.name,'"+srvName+"'  ) >0 Then 1 Else 0 End)+(case when instr( a0.PYCODE,'"+srvName+"')>0 then 1 else 0 end)  desc ";
		DAFacade  dafacade = new DAFacade();
		//List<MedSrvDO> list = (List<MedSrvDO>)dafacade.execQuery(whereStr, new BeanListHandler(MedSrvDO.class));
		MedSrvDO[] medsrvs =  medSrv.find(whereStr,  OrderBY, FBoolean.FALSE);
		//医保计划
		if(Healthca != null && !Healthca.equals("")){
			if(medsrvs != null && medsrvs.length>0){
				emsOrScSrv = new EmsOrSrvSc[medsrvs.length];
				int i =0;
				for(MedSrvDO item :medsrvs){
					EmsOrSrvSc emsSrv = new EmsOrSrvSc();
					HPSrvorcaDO hpsrvca =  findHp(item.ID_SRV,Healthca);
					emsSrv.setCode_srv(item.getCode());
					emsSrv.setDes(item.getDes());
					emsSrv.setId_srv(item.getId_srv());
					emsSrv.setName_srv(item.getName());
					emsSrv.setMedSrvDO(item);
					emsSrv.setHealthca(hpsrvca.getHpsrvtp_name());
					emsSrv.setMnecode(item.getMnecode());
					emsSrv.setDes_pri(item.getDes_pri());
//					emsSrv.setName_srvca(item.getName_srvreact());
					emsOrScSrv[i] = emsSrv;
					i++;
				}
			}
		}else{
			
			if(medsrvs != null && medsrvs.length >0){
				emsOrScSrv = new EmsOrSrvSc[medsrvs.length];
				int i =0;
				for(MedSrvDO item :medsrvs){
					EmsOrSrvSc emsSrv = new EmsOrSrvSc();
					//HpSrvOrCaDO hpsrvca =  findHp(item.ID_SRV,Healthca);
					emsSrv.setCode_srv(item.getCode());
					emsSrv.setDes(item.getDes());
					emsSrv.setId_srv(item.getId_srv());
					emsSrv.setName_srv(item.getName());
					emsSrv.setMedSrvDO(item);
					emsSrv.setMnecode(item.getMnecode());
					emsSrv.setDes_pri(item.getDes_pri());
					//emsSrv.setHealthca(hpsrvca.getHpsrvtp_name());
//					emsSrv.setName_srvca(item.getName_srvreact());
					emsOrScSrv[i] = emsSrv;
					i++;
				}
			}
		}
		return emsOrScSrv;
	}
	
	private String getFgUsertype(String code_entp){
		if(code_entp == null) return null;
		if("10".equals(code_entp)) return "IP";
		if("00".equals(code_entp))  return "OP";
		return null;
	}
	
	/**
	 * 根据服务id和医保类型查找医保DO
	 * @param hpCode
	 * @param idSrv
	 * @return HpSrvOrCaDO
	 * @throws BizException
	 */
	private HPSrvorcaDO findHp(String id_hp, String id_Srv) throws BizException{
		IHpsrvorcaRService hpService=(IHpsrvorcaRService)ServiceFinder.find(IHpsrvorcaRService.class.getName());
		//return hpService.getHpSrvTpByCode(hpCode,id_Srv)
		String whereStr = HPSrvorcaDO.ID_HP +"='"+id_hp+"' and  "+ HPSrvorcaDO.ID_SRV +" ='"+id_Srv+"'";
		HPSrvorcaDO[] orca =  hpService.find(whereStr,HPSrvorcaDO.ID_HPSRVTP,FBoolean.FALSE);
		if(orca != null && orca.length >0){
			return orca[0];
		}else{
			throw new BizException("没有找医保信息");
		}
	}
	/**
	 * 医嘱模板中获得服务列表
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public EmsOrSrvSc[] exec(OrtplDTO dto)throws BizException{
		StringBuffer whereStr = new StringBuffer(MedSrvDODesc.TABLE_ALIAS_NAME+"."+MedSrvDO.FG_OR+ "='Y'  and "
		        +MedSrvDODesc.TABLE_ALIAS_NAME+"."+MedSrvDO.DS+ "='0'   ");
		EmsOrSrvSc[] emsOrScSrv = null;
		String sd_srvtpStr = dto.getSd_srvtp();
		String excludeSd_srvtpStr = dto.getExcludeSd_srvtp();
		String srvName = dto.getStrWhere();
		String Healthca = dto.getHealthca();
		OrTplDO tplDo = dto.getModel();
		//包含和不包含只取一种，sd_srvtpStr不为空时为包含，sd_srvtpStr为空，excludeSd_srvtpStr不为空时为不包含
		//包换的服务类型
		if(!StringUtil.isEmpty(sd_srvtpStr)){
			String[] sd_srvtpArray = sd_srvtpStr.split(",");
			whereStr.append(" and "+MedSrvDODesc.TABLE_ALIAS_NAME+".sd_srvtp in ( ");
			for(int i=0;i<sd_srvtpArray.length;i++){
				if(i==sd_srvtpArray.length-1){
					whereStr.append("'"+sd_srvtpArray[i]+"'");
				}else{
					whereStr.append("'"+sd_srvtpArray[i]+"',");
				}
			}
			whereStr.append(")");
		}else if(!StringUtil.isEmpty(excludeSd_srvtpStr)){//不包含的服务类型
			String[] excludeSd_srvtpStrArray = excludeSd_srvtpStr.split(",");
			whereStr.append(" and "+MedSrvDODesc.TABLE_ALIAS_NAME+".sd_srvtp not in ( ");
			for(int i=0;i<excludeSd_srvtpStrArray.length;i++){
				if(i==excludeSd_srvtpStrArray.length-1){
					whereStr.append("'"+excludeSd_srvtpStrArray[i]+"'");
				}else{
					whereStr.append("'"+excludeSd_srvtpStrArray[i]+"',");
				}
			}
			whereStr.append(")");
		}
		whereStr.append(" and "+MedSrvDODesc.TABLE_ALIAS_NAME+".fg_use_op='"+tplDo.getFg_entp_op()+"' and "+MedSrvDODesc.TABLE_ALIAS_NAME +".fg_use_ip='"+tplDo.getFg_entp_ip()+"'" );
		whereStr.append(" and "+MedSrvDODesc.TABLE_ALIAS_NAME+".fg_use_er='"+tplDo.getFg_entp_er()+"' and "+MedSrvDODesc.TABLE_ALIAS_NAME +".fg_use_pe='"+tplDo.getFg_entp_pe()+"'");
		whereStr.append(" and "+MedSrvDODesc.TABLE_ALIAS_NAME+".fg_use_fm='"+tplDo.getFg_entp_fm()+"'");
		if(srvName != null && srvName != ""){
			whereStr.append(" and  ( "+ MedSrvDODesc.TABLE_ALIAS_NAME+".name like '%" +srvName+"%'");
			whereStr.append(" or "+ MedSrvDODesc.TABLE_ALIAS_NAME+".PYCODE like '%" +srvName+"%'");
			whereStr.append(" or "+ MedSrvDODesc.TABLE_ALIAS_NAME+".wbcode like '%" +srvName+"%' ");
			whereStr.append(" or Upper("+ MedSrvDODesc.TABLE_ALIAS_NAME+".PYCODE) like '%" +srvName.toUpperCase()+"%'");
			whereStr.append(" or Upper("+ MedSrvDODesc.TABLE_ALIAS_NAME+".wbcode) like '%" +srvName.toUpperCase()+"%' )");
		}
		 
		MedSrvDO[] medsrvs =  medSrv.find(whereStr.toString(),  MedSrvDODesc.TABLE_ALIAS_NAME+".id_srv", FBoolean.FALSE);
		//医保计划
		if(Healthca != null && !Healthca.equals("")){
			if(medsrvs != null && medsrvs.length>0){
				emsOrScSrv = new EmsOrSrvSc[medsrvs.length];
				int i =0;
				for(MedSrvDO item :medsrvs){
					EmsOrSrvSc emsSrv = new EmsOrSrvSc();
					HPSrvorcaDO hpsrvca =  findHp(item.ID_SRV,Healthca);
					emsSrv.setCode_srv(item.getCode());
					emsSrv.setDes(item.getDes());
					emsSrv.setId_srv(item.getId_srv());
					emsSrv.setName_srv(item.getName());
					emsSrv.setMedSrvDO(item);
					emsSrv.setHealthca(hpsrvca.getHpsrvtp_name());
					emsSrv.setMnecode(item.getMnecode());
//					emsSrv.setName_srvca(item.getName_srvreact());
					emsOrScSrv[i] = emsSrv;
					i++;
				}
			}
		}else{
			
			if(medsrvs != null && medsrvs.length>0){
				emsOrScSrv = new EmsOrSrvSc[medsrvs.length];
				int i =0;
				for(MedSrvDO item :medsrvs){
					EmsOrSrvSc emsSrv = new EmsOrSrvSc();
					//HpSrvOrCaDO hpsrvca =  findHp(item.ID_SRV,Healthca);
					emsSrv.setCode_srv(item.getCode());
					emsSrv.setDes(item.getDes());
					emsSrv.setId_srv(item.getId_srv());
					emsSrv.setName_srv(item.getName());
					emsSrv.setMedSrvDO(item);
					emsSrv.setMnecode(item.getMnecode());
					//emsSrv.setHealthca(hpsrvca.getHpsrvtp_name());
//					emsSrv.setName_srvca(item.getName_srvreact());
					emsOrScSrv[i] = emsSrv;
					i++;
				}
			}
		}
		return emsOrScSrv;
	}
}

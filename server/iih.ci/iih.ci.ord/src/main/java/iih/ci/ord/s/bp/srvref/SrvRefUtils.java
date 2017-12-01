package iih.ci.ord.s.bp.srvref;

import iih.bd.srv.deptsrvlimit.d.DeptSrvLimitItemDO;
import iih.bd.srv.deptsrvlimit.d.LimitItmRelTpEnum;
import iih.bd.srv.ems.d.EmsRelSrvDO;
import iih.bd.srv.ems.d.eu_srvcatpenum;
import iih.bd.srv.srvselfcaitm.d.eudirect;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.srvref.d.CiSrvRefParamDTO;
import xap.mw.coreitf.d.FBoolean;

public class SrvRefUtils {
	
	/**
	 * 获得个性化（部分）条件串
	 * @param isMmDef
	 * @param fg_blurred
	 * @param fg_code
	 * @param fg_name
	 * @param fg_shortname
	 * @param fg_pycode
	 * @param fg_wbcode
	 * @param fg_mnemonic
	 * @return
	 */
	public static String getIndividualWhereStr(CiSrvRefParamDTO param,boolean isMmDef) {
		String[] partStrs=new String[]{"","",""}; //srv mm alias
		String likeStr="like '%s%%' ";
		String inputStr=param.getInputstr()+"";
		if(CiOrdUtils.isTrue(param.getFg_blurred()))likeStr="like '%%%s%%' ";
		if(CiOrdUtils.isEmpty(param)) param=getCiSrvRefParam();
		
		//编码
		partStrs=getIndWhereStr(param.getFg_code(),partStrs,inputStr,likeStr,new String[]{"A.Code","C.Code",""},isMmDef);
	
		//名称
		partStrs=getIndWhereStr(param.getFg_name(),partStrs,inputStr,likeStr,new String[]{"A.Name","C.Name","E.Alias"},isMmDef);

		//拼音
		partStrs=getIndWhereStr(param.getFg_pycode(),partStrs,inputStr,likeStr,new String[]{"A.Pycode","C.Pycode","E.Pycode"},isMmDef);
		
		//五笔
		partStrs=getIndWhereStr(param.getFg_wbcode(),partStrs,inputStr,likeStr,new String[]{"A.Wbcode","C.Wbcode","E.Wbcode"},isMmDef);

		//助记
		partStrs=getIndWhereStr(param.getFg_mnemonic(),partStrs,inputStr,likeStr,new String[]{"A.Mnecode","C.Mnecode","E.Mnecode"},isMmDef);

		//简称
		partStrs=getIndWhereStr(param.getFg_shortname(),partStrs,inputStr,likeStr,new String[]{"A.Shortname","",""},isMmDef);

		param=null;
		return getPartStr(partStrs);
	}
	
	/**
	 * 获得条件片段串
	 * @param fg_fld
	 * @param srvStr
	 * @param aliasStr
	 * @param mmStr
	 * @param inputStr
	 * @param likeStr
	 * @param fields
	 * @return
	 */
	private static String[] getIndWhereStr(FBoolean fg_fld,String[] partStrs,String inputStr,String likeStr,String[] fields,boolean isMmDef){
		String srvStr=partStrs[0],mmStr=partStrs[1],aliasStr=partStrs[2];
		//TODO 临时注释
//		if(!isMmDef)fields[1]="";
		if(CiOrdUtils.isTrue(fg_fld)){
			//服务部分
			srvStr=getStr(fields[0],srvStr,likeStr,inputStr);
			
			//物品部分
			mmStr=getStr(fields[1],mmStr,likeStr,inputStr);

			//别名部分
			//TODO 别名错误
			aliasStr=getStr(fields[2],aliasStr,likeStr,inputStr);

		}
		return new String[]{srvStr,mmStr,aliasStr};
	}
	/**
	 * 获得条件片段串
	 * @param fld
	 * @param srvStr
	 * @param likeStr
	 * @param inputStr
	 * @return
	 */
	private static String getStr(String fld,String srvStr,String likeStr,String inputStr){
		if(!fld.equals("")){
			if(!CiOrdUtils.isEmpty(srvStr))srvStr+=" or ";
			srvStr+=fld+" "+String.format(likeStr, inputStr);
		}
		return srvStr;
	}
	/**
	 * 设置默认参数
	 * @return
	 */
	private static CiSrvRefParamDTO getCiSrvRefParam(){
		CiSrvRefParamDTO param=new CiSrvRefParamDTO();
		param.setFg_pycode(FBoolean.TRUE);
		param.setFg_name(FBoolean.TRUE);
		return param;
	}
	private static String getPartStr(String[] partStrs){
		String rtn="",orStr="";
		if(!CiOrdUtils.isEmpty(partStrs[0])){
			rtn+="("+partStrs[0]+")";
		}
		if(!CiOrdUtils.isEmpty(partStrs[1])){
			if(!rtn.equals("")){orStr=" or ";}else{orStr="";}
			rtn+=orStr+ "("+partStrs[1]+")";
		}
		if(!CiOrdUtils.isEmpty(partStrs[2])){
			if(!rtn.equals("")){orStr=" or ";}else{orStr="";}
			rtn+=orStr+"("+partStrs[2]+")";
		}
		
		return rtn;
	}
	
	/**
	 * 获得部门服务限制sql串片段
	 * 含最终的关联 操作符号
	 * @param limititems
	 * @param isBlack
	 * @return
	 */
	public static String getDeptSrvLimitSQLStr(DeptSrvLimitItemDO[] limititems,FBoolean isBlack){
		String rtn="";
		if(CiOrdUtils.isTrue(isBlack)){
			rtn=getDeptBlackSrvLimitSQLStr(limititems);
		}else{
			rtn=getDeptWhiteSrvLimitSQLStr(limititems);
		}
		if(!CiOrdUtils.isEmpty(rtn))return " and "+rtn;
		return "";
	}
	/**
	 * 获得部门服务限制sql串片段（黑名单）
	 * @param limititems
	 * @return
	 */
	private static String getDeptBlackSrvLimitSQLStr(DeptSrvLimitItemDO[] limititems){
		String rtn=getDeptWhiteSrvLimitSQLStr(limititems);
		if(!CiOrdUtils.isEmpty(rtn))return " not "+rtn;
		return "";
	}
	
	/**
	 * 获得部门服务限制sql串片段（白名单）
	 * @param limititems
	 * @return
	 */
	private static String getDeptWhiteSrvLimitSQLStr(DeptSrvLimitItemDO[] limititems){
		String rtn1="",rtn2="",idsrv="";
		for(int i=0;i<limititems.length;i++){
			if(LimitItmRelTpEnum.MEDSRVTYPE.equals(limititems[i].getEu_limtitmreltp())){
				if(CiOrdUtils.isEmpty(limititems[i].getSd_srvtp())) continue;
				if(eudirect.ADDI.equals(limititems[i].getEu_direct())){
					rtn1+=getSqlStr(rtn1,"Sd_Srvtp",limititems[i].getSd_srvtp(),true);
				}else if(eudirect.REDUCEI.equals(limititems[i].getEu_direct())){
					rtn2+=getNotSqlStr(rtn2,"Sd_Srvtp",limititems[i].getSd_srvtp(),true);
				}
			}else if(LimitItmRelTpEnum.MEDSRVCATE.equals(limititems[i].getEu_limtitmreltp())){
				if(CiOrdUtils.isEmpty(limititems[i].getInnercode()))continue;
				if(eudirect.ADDI.equals(limititems[i].getEu_direct())){
					rtn1+=getSqlStr(rtn1,"Innercode",limititems[i].getInnercode(),true);
				}else if(eudirect.REDUCEI.equals(limititems[i].getEu_direct())){
					rtn2+=getNotSqlStr(rtn2,"Innercode",limititems[i].getInnercode(),true);
				}				
			}else if(LimitItmRelTpEnum.MEDSRV.equals(limititems[i].getEu_limtitmreltp())){
				if(CiOrdUtils.isEmpty(limititems[i].getId_srv()))continue;
				if(eudirect.ADDI.equals(limititems[i].getEu_direct())){
					rtn1+=getSqlStr(rtn1,"Id_srv",limititems[i].getId_srv(),true);
				}else if(eudirect.REDUCEI.equals(limititems[i].getEu_direct())){
					idsrv+=",'"+limititems[i].getId_srv()+"'";
				}				
			}else{
				
			}
		}
		if(!CiOrdUtils.isEmpty(idsrv)){rtn2=getNotSqlStr("","Id_srv",idsrv.substring(1),false)+" and "+rtn2;}
		if(!CiOrdUtils.isEmpty(rtn1)){rtn1="("+rtn1+")";}
		if(!CiOrdUtils.isEmpty(rtn2) && !CiOrdUtils.isEmpty(rtn1)){return " (("+rtn1+") and ("+rtn2+"))";}
		else if(!CiOrdUtils.isEmpty(rtn1)){return " ("+rtn1+")";}
		else if(!CiOrdUtils.isEmpty(rtn2)){return " ("+rtn2+")";}
		return "";
	}
	/**
	 * 获得白名单增项对应SQL串片段
	 * @param rtn
	 * @param fldname
	 * @param fldv
	 * @param isLike
	 * @return
	 */
	private static String getSqlStr(String rtn,String fldname,String fldv,boolean isLike){
		String orstr=" or ";
		if(CiOrdUtils.isEmpty(rtn))orstr=" ";
		if(isLike){
			return orstr+"A."+fldname+" like '"+fldv+"%' ";
		}else{
			return orstr+"A."+fldname+"='"+fldv+"' ";
		}
	}
	/**
	 * 获得白名单减项对应SQL串片段
	 * @param rtn
	 * @param fldname
	 * @param fldv
	 * @param isLike
	 * @return
	 */
	private static String getNotSqlStr(String rtn,String fldname,String fldv,boolean isLike){
		String andstr=" and ";
		if(CiOrdUtils.isEmpty(rtn))andstr=" ";
		if(isLike){
			return andstr+"(not (A."+fldname+" like '"+fldv+"%' ))";
		}else{
			if(fldv.indexOf(",")>0){
				return andstr+"(A.id_srv not in ("+fldv+"))";
			}else{
				return andstr+"(A.id_srv!='"+fldv+"')";
			}
		}
	}
	
	/**
	 * 获得医疗单关联的服务Sql字符串数据信息
	 * @param emsrelsrvdos
	 * @return
	 */
	public static String getEmsrelSrvSqlStr(EmsRelSrvDO[] emsrelsrvdos){
		String rtn="";
		
		//有效性判断
		if(CiOrdUtils.isEmpty(emsrelsrvdos))return rtn;
		
		//获得医疗单关联服务Sql串片段
		rtn=getEmsRelSrvSQLStr(emsrelsrvdos);
		
		//返回值返回
		return rtn;
	}
	
	/**
	 * 获得医疗单关联服务sql串片段
	 * @param emsrelsrvdos
	 * @return
	 */
	private static String getEmsRelSrvSQLStr(EmsRelSrvDO[] emsrelsrvdos){
		String rtn1="",rtn2="",idsrv="";
		for(int i=0;i<emsrelsrvdos.length;i++){
			if(eu_srvcatpenum.CA.equals(emsrelsrvdos[i].getEu_ofreftp())){//服务类型业务逻辑
				if(CiOrdUtils.isEmpty(emsrelsrvdos[i].getSd_srvtp())) continue;
				if(eudirect.ADDI.equals(emsrelsrvdos[i].getEu_direct())){
					rtn1+=getSqlStr(rtn1,"Sd_Srvtp",emsrelsrvdos[i].getSd_srvtp(),true);
				}else if(eudirect.REDUCEI.equals(emsrelsrvdos[i].getEu_direct())){
					rtn2+=getNotSqlStr(rtn2,"Sd_Srvtp",emsrelsrvdos[i].getSd_srvtp(),true);
				}
			}else if(eu_srvcatpenum.SRV.equals(emsrelsrvdos[i].getEu_ofreftp())){
				if(CiOrdUtils.isEmpty(emsrelsrvdos[i].getId_srv()))continue;
				if(eudirect.ADDI.equals(emsrelsrvdos[i].getEu_direct())){
					rtn1+=getSqlStr(rtn1,"Id_srv",emsrelsrvdos[i].getId_srv(),true);
				}else if(eudirect.REDUCEI.equals(emsrelsrvdos[i].getEu_direct())){
					idsrv+=",'"+emsrelsrvdos[i].getId_srv()+"'";
				}				
			}else{
				
			}
		}
		if(!CiOrdUtils.isEmpty(idsrv)){rtn2=getNotSqlStr("","Id_srv",idsrv.substring(1),false)+" and "+rtn2;}
		if(!CiOrdUtils.isEmpty(rtn1)){rtn1="("+rtn1+")";}
		if(!CiOrdUtils.isEmpty(rtn2) && !CiOrdUtils.isEmpty(rtn1)){return " (("+rtn1+") and ("+rtn2+"))";}
		else if(!CiOrdUtils.isEmpty(rtn1)){return " ("+rtn1+")";}
		else if(!CiOrdUtils.isEmpty(rtn2)){return " ("+rtn2+")";}
		return "";
	}

}

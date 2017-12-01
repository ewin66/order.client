package iih.ci.ord.s.bp.iemsg;

import java.util.Map;

import xap.mw.core.data.BizException;
import iih.ci.ord.pub.CiOrdUtils;

/**
 * 生成集成平台确认数据信息操作BP
 * 患者、就诊、确认相关公共数据信息确认数据信息
 */
public class GetIEMsgNsConfirmBP {
	/**
	 * 生成集成平台检验申请服务数据信息
	 * @param id_or  医嘱
	 * @return
	 * @throws BizException
	 */
	public Map<String,Object> exec(String id_or) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_or))return null;
		
		//sql串
		String sql=getSQlStr(id_or);
		
		//返回
		return CiOrdUtils.getRsMap(sql);
	}
	
	/**
	 * 获得 SQL串 
	 * @param id_or
	 * @return
	 */
	private String getSQlStr(String id_or){
		String formatsql=ICiIEMsgRelSqlConst.CI_IE_ORCONFIRM_SQL;
		String[] fldnames=getChkFlds(id_or);
		return String.format(formatsql,fldnames[0],fldnames[1],id_or.substring(1));
	}
	
	/**
	 * 获得字段名
	 * @param id_or
	 * @return
	 */
	private String[] getChkFlds(String id_or){
		String[] rtns=new String[2];
		String type=id_or.substring(0, 1);
		if(type.equals("0")){
			rtns[0]="A.Dt_Chk";
			rtns[1]="A.Id_Emp_Chk";
		}else if(type.equals("1")){  
			rtns[0]="A.Dt_Chk_Canc";
			rtns[1]="A.Id_Emp_Chk_Canc";
		}else if(type.equals("2")){
			rtns[0]="A.Dt_Chk_Stop";
			rtns[1]="A.Id_Emp_Chk_Stop";		
		}
		return rtns;
	}
	
}

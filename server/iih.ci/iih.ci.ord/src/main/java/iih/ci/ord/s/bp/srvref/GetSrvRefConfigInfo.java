package iih.ci.ord.s.bp.srvref;

import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.srvref.d.CiSrvRefParamDTO;
import iih.ci.ord.srvref.d.SrvRefRelInfoType;

/**
 * 服务参照模型接口
 */
public class GetSrvRefConfigInfo implements ISrvRefModel {
	
	private CiSrvRefParamDTO _param;
	
	/**
	 * 服务查询参照中表单中配置的全部字段
	 */
	private String[] selectFields;
	
	/**
	 * 描述配置字段数组<br>
	 * 数据格式为：服务分类1，字段a1，字段a2...   服务分类2,字段b1，字段b2...<br>
	 * 描述配置结果为按服务类型进行分组，每个服务类型中包含的字段与服务类型放到同一个字符串中，逗号分隔
	 */
	private String[] descFields;
	
	/**
	 * 判断是否存在物品相关配置<br>
	 * 当服务查询的参照表单或描述中涉及物品字段时改值为true，否则为false
	 */
	private boolean existsMmDefField=false;
	/**
	 * 服务名与物品名是否合并显示<br>
	 * 该值有外部传入，当selectFields与descFields中不包含物品字段时，指定了fg_srvMmNameMerge=true，显示时需要合并显示物品名称
	 */
	private boolean fg_srvMmNameMerge=false;
	
	/**
	 * 设置可使用标识对应Code_entp <br>
	 * 门诊:00 ; 急诊:01 ; 体检:02 ; 住院:10 ; 家庭病床:20
	 */
	private final static Map<String, String> FG_USE_MAP = new HashMap<String, String>() {
		private static final long serialVersionUID = -4394998798058239192L;
		{
			put("00", "A.Fg_use_op = 'Y'");// 门诊
			put("01", "A.Fg_use_er = 'Y'");// 急诊
			put("02", "A.Fg_use_pe = 'Y'");// 体检
			put("10", "A.Fg_use_ip = 'Y'");// 住院
			put("20", "A.Fg_use_fm = 'Y'");// 家庭病床
		}
	};
    
	/**
	 * 无参构造函数
	 */
	public GetSrvRefConfigInfo(){
		_param=null;
	}
	
	/**
	 * 有参构造函数
	 * @param param
	 */
	public GetSrvRefConfigInfo(CiSrvRefParamDTO param){
		_param=param;
	}
	
	/**
	 * 参照全部字段数组<br>
	 * 第一行：对应CiSrvRefResultDTO中描述列为服务基本信息全部字段<br>
	 * 第二行：对应CiSrvRefResultDTO中描述列为医保计划全部字段<br>
	 * 第三行：对应CiSrvRefResultDTO中描述列为药品定义全部字段<br>
	 * 第四行：对应CiSrvRefResultDTO中描述列为药品属性全部字段<br>
	 * 第五行：对应CiSrvRefResultDTO中描述列为手术属性全部字段<br>
	 * 第六行：对应CiSrvRefResultDTO中描述列为检验属性全部字段<br>
	 * 第七行：对应CiSrvRefResultDTO中描述列为检查属性全部字段<br>
	 * 第七行：对应CiSrvRefResultDTO中描述列为参照描述字段
	 */
	@Override
	public String[] getAllFields() {
		return new String[]{"id_srv,srvname,srvcode,id_srvca,srvcaname,id_srvtp,sd_srvtp,name_srvtp,pycode,wbcode,mnecode,shortname,fg_set,srvdes",
							"id_hp,hpname,id_hpsrvtp,sd_hpsrvtp,name_hpsrvtp,limitreimbursecond,reimburserate",
							"id_mm,mmname,spec,salesprice,salesunitname,id_val,sd_val,name_val,name_sup,importtp,madeplace,fg_otc",
							"id_dosage,sd_dosage,name_dosage,id_pharm,sd_pharm,name_pharm,fg_pois,id_pois,sd_pois,name_pois,fg_anti,id_anti,sd_anti,name_anti",
							"id_samptp,sd_samptp,name_samptp",
							"id_body,sd_body,name_body,id_pos,sd_pos,name_pos",
							"id_opclass,sd_opclass,name_opclass,id_incitp,sd_incitp,name_incitp,fg_new_sug",
							"srvrefdes"
							};
	}

	@Override
	public String[] getSelectFields() {
		return this.selectFields;
	}

	@Override
	public String[] getSrvDescFields() {
		return this.descFields;
	}

	/**
	 * 获得服务参照数据信息
	 */
	@Override
	public SrvRefTypeInfo[] getSrvRefInfo() {
		SrvRefTypeInfo[] rtn=new SrvRefTypeInfo[8];
		rtn[0]=getMedSrvDatumInfo();//医疗服务数据信息0
		rtn[1]=getHpPlanDatumInfo();//医保计划数据信息1		
		rtn[2]=getMmDefDatumInfo();//物品定义数据信息2
		rtn[3]=getSrvMmDatumInfo();//物品属性数据信息3
		rtn[4]=getSrvLisDatumInfo();//检验属性数据信息4		
		rtn[5]=getSrvRisDatumInfo();//检查属性数据信息5
		rtn[6]=getSrvOpDatumInfo();//手术属性数据信息6
		rtn[7]=getRefDescDatumInfo();//服务描述数据信息7

		return rtn;
	}

	@Override
	public void setSelectFields(String[] selectFields) {
		this.selectFields=selectFields;
		
	}

	@Override
	public void setSrvDescFields(String[] descFields) {
		this.descFields=descFields;
		
	}

	/**
	 * 获得条件串中 固定条件部分
	 */
	@Override
	public String getFixedWhereStr() {
//		return " where A.FG_ACTIVE='Y' and A.FG_USE_OP='Y' ";
		StringBuffer bufferWhere = new StringBuffer();
		bufferWhere.append(" where A.FG_ACTIVE='Y' ");
		return bufferWhere.toString();
	}

	/**
	 * 获得条件串中 动态条件部分
	 */
	@Override
	public String getDynamicWhereStr() {
		String rtn="";
		if(!CiOrdUtils.isEmpty(this._param)){
			
			// 医生场景标识
			if(CiOrdUtils.isTrue(_param.getFg_doctor())){
				rtn+="  and  A.Fg_Or='Y' ";
			}
			// 服务类型
			if(!CiOrdUtils.isEmpty(_param.getSd_srvtp())){
				rtn+=" and A.Sd_Srvtp like '"+_param.getSd_srvtp()+"%' ";
			}
			// 就诊类型
			if(StringUtils.isNotBlank(_param.getCode_entp())){
				rtn+= " and " + FG_USE_MAP.get(_param.getCode_entp());
			}
		}
		return rtn;
	}

	/**
	 * 获得条件串中 个性化条件部分
	 */
	@Override
	public String getIndividualWhereStr() {
		boolean isMmDef=existsMMDefField();
		return SrvRefUtils.getIndividualWhereStr(this._param, isMmDef);
	}

	/**
	 * 获得条件串中  科室服务限制条件部分
	 */
	@Override
	public String getDepSrvLimitWhereStr() throws BizException {
		if(CiOrdUtils.isEmpty(this._param))return "";
		if(!CiOrdUtils.isEmpty(this._param.getId_dep())){
			return getDepSrvLimitSqlStr(this._param.getId_dep());
		}
		return "";
	}

	@Override
	public String getEmsSpecWhereStr() throws BizException {
		if(CiOrdUtils.isEmpty(this._param))return "";
		if(CiOrdUtils.isEmpty(this._param.getId_ems()))return "";
		String rtn=getEmsRelSrvSqlStr(this._param.getId_ems());
		return null;
	}
	
	@Override
	public String getSrvDescSelectStr() {
		//按类型获得服务描述字段  同一类型只能存在一次 空类型也可出现一次
		String[] srvdescflds=getSrvDescFields();
		
		//有效性校验
		if(CiOrdUtils.isEmpty(srvdescflds))return "";
		int iL=srvdescflds.length,iN=0;
		String rtn="",rtn1="";
		
		//长度为1时的特殊处理逻辑
		if(iL==1){return getSrvDescSqlStr1(srvdescflds[0]);}
		String[] srvdescfldinfo;
		//遍历
		for(int i=0;i<iL;i++){
			srvdescfldinfo=srvdescflds[i].split(",");
			if(!CiOrdUtils.isEmpty(srvdescfldinfo[0])){
				if(iN==0){
					rtn+=getSrvDescSqlPart(srvdescfldinfo,FBoolean.TRUE);
				}else{
					rtn+=getSrvDescSqlPart(srvdescfldinfo,FBoolean.FALSE);
				}
				iN+=1;
			}
			else{
				rtn1=getSrvDescSqlPart(srvdescfldinfo,null);
			}
		}
		if(rtn1.equals("")){rtn1=" else '' end ";}else{rtn1+=" end ";}
		return rtn+rtn1;
	}
	
	/**
	 * 获得医疗服务数据信息
	 * @return
	 */
	private SrvRefTypeInfo getMedSrvDatumInfo(){
		SrvRefTypeInfo reftypeinfo=new SrvRefTypeInfo();
		reftypeinfo.setTp(SrvRefRelInfoType.MEDSRVDATUMINFO);
		reftypeinfo.setTpFields(new String[]{"id_srv","srvname","srvcode","id_srvca","srvcaname","id_srvtp","sd_srvtp","name_srvtp","pycode","wbcode","mnecode","shortname","fg_set","srvdes"});
		reftypeinfo.setTpRelFields(new String[]{"A.Id_Srv","A.Name","A.code","A.Id_Srvca","G.Name","A.id_srvtp","A.Sd_Srvtp","F.Name","A.Pycode","A.WBCODE","A.MNECODE","A.Shortname","A.Fg_Set","A.Des"});
//		reftypeinfo.setTpRelFields(new String[]{"A.Id_Srv","A.Name as srvname","A.code as srvcode","A.Id_Srvca","G.Name as srvcaname","A.id_srvtp","A.Sd_Srvtp","F.Name as name_srvtp","A.Pycode","A.WBCODE","A.MNECODE","A.Shortname","A.Fg_Set","A.Des as srvdes"});
		reftypeinfo.setTpTableBasic(" from bd_srv A left outer join bd_srv_als E on A.id_srv = E.id_srv ");
		reftypeinfo.setTpTblFeatures(new String[]{"G.","F."});
		reftypeinfo.setTpTableRel(new String[]{" left outer join bd_srvca G on A.Id_Srvca=G.Id_Srvca "," left outer join bd_udidoc F on A.Id_Srvtp=F.Id_Udidoc "});
		//(case when C.NAME is null then A.Name else A.Name || '（' || C.Name || '）' end)
		
        if(existsMMDefField() && getFg_srvMmNameMerge()){
        	String[] tpRelFields=reftypeinfo.getTpRelFields();
        	tpRelFields[1]="(case when ((C.NAME is null) or (C.Name=A.Name)) then A.Name else A.Name || '（' || C.Name || '）' end) as srvname";
        }
		return reftypeinfo;
	}
	
	/**
	 * 获得医疗保险数据信息
	 * @return
	 */
	private SrvRefTypeInfo getHpPlanDatumInfo(){
		SrvRefTypeInfo reftypeinfo=new SrvRefTypeInfo();
		reftypeinfo.setTp(SrvRefRelInfoType.HPPLANDATUMINFO);
		reftypeinfo.setTpFields(new String[]{"id_hp","hpname","id_hpsrvtp","sd_hpsrvtp","name_hpsrvtp","limitreimbursecond","reimburserate"});
		reftypeinfo.setTpRelFields(new String[]{"B.Id_Hp","I.Name","B.ID_HPSRVTP","B.Sd_Hpsrvtp","H.Name","B.des","B.Rate"});
//		reftypeinfo.setTpRelFields(new String[]{"B.Id_Hp","I.Name as hpname","B.ID_HPSRVTP","B.Sd_Hpsrvtp","H.Name as name_hpsrvtp","B.des as limitreimbursecond","B.Rate as reimburserate"});
		reftypeinfo.setTpTableBasic(" left outer join bd_hp_srvorca B on A.id_srv = B.id_srv and  B.id_hp='%s' ");
		reftypeinfo.setTpTblFeatures(new String[]{"I.","H."});
		reftypeinfo.setTpTableRel(new String[]{" left outer join bd_hp I on B.Id_Hp=I.Id_Hp "," left outer join bd_udidoc H on B.Id_Hpsrvtp=H.Id_Udidoc "});
		
		return reftypeinfo;
	}
	
	/**
	 * 获得物品定义数据信息
	 * @return
	 */
	private SrvRefTypeInfo getMmDefDatumInfo(){
		SrvRefTypeInfo reftypeinfo=new SrvRefTypeInfo();
		reftypeinfo.setTp(SrvRefRelInfoType.MMDEFDATUMINFO);
		reftypeinfo.setTpFields(new String[]{"id_mm","mmname","spec","salesprice","salesunitname","id_val","sd_val","name_val","name_sup","importtp","madeplace","fg_otc"});
		reftypeinfo.setTpRelFields(new String[]{"(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.Id_Mm else '' end)","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.Name else '' end)","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.Spec else '' end)","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.PRICE else 0 end)","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.Name_Unit_Pkgsp else '' end)","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.Id_Val else '' end)","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.Sd_Val else '' end)","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then L.Name else '' end)","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.Sup_Name else '' end)","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then J.Name else '' end)","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.PLACE else '' end)","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.fg_otc else '' end)"});
//		reftypeinfo.setTpRelFields(new String[]{"(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.Id_Mm else '' end) as id_mm","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.Name else '' end) as mmname","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.Spec else '' end) as spec","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.PRICE else 0 end) as salesprice","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.Name_Unit_Pkgsp else '' end) as salesunitname","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.Id_Val else '' end) as Id_Val","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.Sd_Val else '' end) as Sd_Val","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then L.Name else '' end) as name_val","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.Sup_Name else '' end) as name_sup","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then J.Name else '' end) as importtp","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.PLACE else '' end) as madeplace","(case when (A.Fg_Mm='Y' and A.SD_MMBIND_OP='0') then C.fg_otc else '' end) as fg_otc"});
		reftypeinfo.setTpTableBasic(" left outer join bd_srv_rel_mm D on A.Id_Srv=D.id_srv and (D.sd_owtp='0' or (D.sd_owtp='1' and D.id_dep='')) left outer join  bd_mm C on  D.Id_mm = C.Id_mm ");
		reftypeinfo.setTpTblFeatures(new String[]{"L.","J."});
		reftypeinfo.setTpTableRel(new String[]{" left outer join bd_udidoc L on C.Id_Val=L.Id_Udidoc "," left outer join bd_udidoc J on C.Id_Abrd=J.Id_Udidoc "});
		
		return reftypeinfo;
	}
	
	/**
	 * 获得物品属性数据信息
	 * @return
	 */
	private SrvRefTypeInfo getSrvMmDatumInfo(){
		SrvRefTypeInfo reftypeinfo=new SrvRefTypeInfo();
		reftypeinfo.setTp(SrvRefRelInfoType.SRVMMDATUMINFO);
		reftypeinfo.setTpFields(new String[]{"id_dosage","sd_dosage","name_dosage","id_pharm","sd_pharm","name_pharm","fg_pois","id_pois","sd_pois","name_pois","fg_anti","id_anti","sd_anti","name_anti"});
//		reftypeinfo.setTpRelFields(new String[]{"M.id_dosage","M.sd_dosage","N.Name as name_dosage","M.id_pharm","M.sd_pharm","O.Name as name_pharm","M.fg_pois","M.id_pois","M.sd_pois","P.Name as name_pois","M.fg_anti","M.id_anti","M.sd_anti","Q.Name as name_anti"});
		reftypeinfo.setTpRelFields(new String[]{"M.id_dosage","M.sd_dosage","N.Name","M.id_pharm","M.sd_pharm","O.Name","M.fg_pois","M.id_pois","M.sd_pois","P.Name","M.fg_anti","M.id_anti","M.sd_anti","Q.Name"});
		reftypeinfo.setTpTableBasic(" left outer join bd_srv_drug M on A.Id_Srv=M.Id_Srv ");
		reftypeinfo.setTpTblFeatures(new String[]{"N.","O.","P.","Q."});
		reftypeinfo.setTpTableRel(new String[]{" left outer join bd_udidoc N on M.id_dosage=N.Id_Udidoc "," left outer join bd_udidoc O on M.id_pharm=O.Id_Udidoc "," left outer join bd_udidoc P on M.id_pois=P.Id_Udidoc "," left outer join bd_udidoc Q on M.id_anti=Q.Id_Udidoc "});
				
		return reftypeinfo;
	}
	
	/**
	 * 获得检查属性数据信息
	 * @return
	 */
	private SrvRefTypeInfo getSrvRisDatumInfo(){
		SrvRefTypeInfo reftypeinfo=new SrvRefTypeInfo();
		reftypeinfo.setTp(SrvRefRelInfoType.SRVRISDATUMINFO);
		reftypeinfo.setTpFields(new String[]{"id_body","sd_body","name_body","id_pos","sd_pos","name_pos"});
//		reftypeinfo.setTpRelFields(new String[]{"R.id_body","R.sd_body","S.name as name_body","R.id_pos","R.sd_pos","T.name as name_pos"});
		reftypeinfo.setTpRelFields(new String[]{"R.id_body","R.sd_body","S.name","R.id_pos","R.sd_pos","T.name"});
		reftypeinfo.setTpTableBasic(" left outer join bd_srv_obs R on A.id_srv=R.Id_srv ");		
		reftypeinfo.setTpTblFeatures(new String[]{"S.","T."});
		reftypeinfo.setTpTableRel(new String[]{" left outer join bd_udidoc S on R.Id_Body=S.Id_Udidoc "," left outer join bd_udidoc T on R.Id_Pos=T.Id_Udidoc "});
		
		return reftypeinfo;
	}
	
	/**
	 * 获得检验属性数据信息
	 * @return
	 */
	private SrvRefTypeInfo getSrvLisDatumInfo(){
		SrvRefTypeInfo reftypeinfo=new SrvRefTypeInfo();
		reftypeinfo.setTp(SrvRefRelInfoType.SRVRISDATUMINFO);
		reftypeinfo.setTpFields(new String[]{"id_samptp","sd_samptp","name_samptp"});
//		reftypeinfo.setTpRelFields(new String[]{"U.id_samptp","U.sd_samptp","V.Name as name_samptp"});
		reftypeinfo.setTpRelFields(new String[]{"U.id_samptp","U.sd_samptp","V.Name"});
		reftypeinfo.setTpTableBasic(" left outer join bd_srv_lab U on A.id_srv=U.Id_srv ");
		reftypeinfo.setTpTblFeatures(new String[]{"V."});
		reftypeinfo.setTpTableRel(new String[]{" left outer join bd_udidoc V on U.Id_Samptp=V.Id_Udidoc "});
		
		return reftypeinfo;
	}
	
	/**
	 * 获得手术属性数据信息
	 * @return
	 */
	private SrvRefTypeInfo getSrvOpDatumInfo(){
		SrvRefTypeInfo reftypeinfo=new SrvRefTypeInfo();
		reftypeinfo.setTp(SrvRefRelInfoType.SRVOPDATUMINFO);
		reftypeinfo.setTpFields(new String[]{"id_opclass","sd_opclass","name_opclass","id_incitp","sd_incitp","name_incitp","fg_new_sug"});
//		reftypeinfo.setTpRelFields(new String[]{"W.id_opclass","W.sd_opclass","X.name as name_opclass","W.id_incitp","W.sd_incitp","Y.Name as name_incitp","W.fg_new_sug"});
		reftypeinfo.setTpRelFields(new String[]{"W.id_opclass","W.sd_opclass","X.name","W.id_incitp","W.sd_incitp","Y.Name","W.fg_new_sug"});
		reftypeinfo.setTpTableBasic(" left outer join bd_srv_sug W on A.Id_Srv=W.Id_Srv ");		
		reftypeinfo.setTpTblFeatures(new String[]{"X.","Y."});
		reftypeinfo.setTpTableRel(new String[]{" left outer join bd_udidoc X on W.Id_opclass=X.Id_Udidoc "," left outer join bd_udidoc Y on W.Id_incitp=Y.Id_Udidoc "});
		
		return reftypeinfo;
	}
	
	/**
	 * 获得参照描述数据信息
	 * @return
	 */
	private SrvRefTypeInfo getRefDescDatumInfo(){
		SrvRefTypeInfo reftypeinfo=new SrvRefTypeInfo();
		reftypeinfo.setTp(SrvRefRelInfoType.REFDESCDATUMINFO);
		reftypeinfo.setTpFields(new String[]{"srvrefdes"});
//		reftypeinfo.setTpRelFields(new String[]{"%s as srvrefdes"});
		reftypeinfo.setTpRelFields(new String[]{"%s"});
		reftypeinfo.setTpTableBasic("");
		reftypeinfo.setTpTblFeatures(null);
		reftypeinfo.setTpTableRel(null);
		
		return reftypeinfo;
	}

	@Override
	public String getSQLStr() throws BizException {

		String tempStr = "";
		StringBuffer querySql = new StringBuffer(); 
		// 查询字段
		StringBuffer fldBuffer = new StringBuffer();
		// 基本表
		StringBuffer tableBasicBuffer = new StringBuffer();
		// 关联表
		StringBuffer tableRelBuffer = new StringBuffer();

		SrvRefTypeInfo[] refTypeInfo = this.getSrvRefInfo();

		// 参照表单中配置的字段
		for (String fldName : this.selectFields) {
			fldBuffer.append("," + this.getRelFldSqlStr(fldName, refTypeInfo,true));
		}

		List<Integer> indexList = getSrvRefInfoIndex();
		for (int index : indexList) {
			
			SrvRefTypeInfo srvRef = refTypeInfo[index];

			// 拼接基础表
			tableBasicBuffer.append(" " + srvRef.getTpTableBasic());

			// 拼接关联表
			if(srvRef.getTpTableRel() != null){
				for (String relFiled : srvRef.getTpTableRel()) {
					tableRelBuffer.append(" " + relFiled);
				}
			}
		}
		
		querySql.append(" select ");
		// 将描述字段替换为实际拼接内容
		if(indexList.contains(SrvRefRelInfoType.REFDESCDATUMINFO)){
			tempStr= String.format(fldBuffer.toString(), this.getSrvDescSelectStr());
			querySql.append(tempStr.substring(1));
		}
		
		querySql.append(tableBasicBuffer.toString());
		
		tempStr = tableRelBuffer.toString();
		// 替换医保中的主医保计划 id_hp
		if(indexList.contains(SrvRefRelInfoType.HPPLANDATUMINFO)){
			tempStr = String.format(tempStr, _param.getId_hp());
		}
		querySql.append(tempStr);
		
		querySql.append(this.getFixedWhereStr()); // 固定条件
		querySql.append(this.getDynamicWhereStr()); // 动态条件
		querySql.append(" and " + this.getIndividualWhereStr()); // 个性化条件
//		querySql.append(this.getDepSrvLimitWhereStr()); // 黑白名单限制

		return querySql.toString();
	}
	
	/**
	 * 获取参照中配置的字段在整体字段全集中的索引集合
	 */
	private List<Integer> getSrvRefInfoIndex(){
		
		List<String> fldNameList = new ArrayList<String>();
		
		List<Integer> indexList = new ArrayList<Integer>();
		fldNameList.addAll(Arrays.asList(this.selectFields));
		fldNameList.addAll(Arrays.asList(this.descFields));
		
		String[] allFlds = this.getAllFields();
		
		for (String fldName : fldNameList) {
			for (int i = 0; i < allFlds.length; i++) {
				if (CiOrdUtils.isInStr(fldName, allFlds[i])) {
					if(!indexList.contains(i)){
						indexList.add(i);
					}
					break;
				}
			}
		}
		
		return indexList;
	}

	/**
	 * 存在物品定义字段
	 */
	@Override
	public boolean existsMMDefField() {
		return false;
	}
	
	/**
	 * 是否服务与物品名称合并显示
	 */
	@Override
	public boolean getFg_srvMmNameMerge() {
		return this.fg_srvMmNameMerge;
	}

	/**
	 * 设置服务与物品名称合并显示标识
	 */
	@Override
	public void setFg_srvMmNameMerge(boolean fg_srvMmNameMerge) {
		this.fg_srvMmNameMerge=fg_srvMmNameMerge;
	}
	
	/**
	 * 获得科室服务限制sql串片段
	 * 
	 * @param id_dept
	 * @return
	 * @throws BizException
	 */
	private String getDepSrvLimitSqlStr(String id_dept) throws BizException{
		GetDeptSrvLimitSQLStrBP bp=new GetDeptSrvLimitSQLStrBP();
		return bp.exec(id_dept);
	}
	
	/**
	 * 获得医疗单关联服务Sql串片段
	 * @param id_ems
	 * @return
	 * @throws BizException
	 */
	private String getEmsRelSrvSqlStr(String id_ems) throws BizException{
		GetEmsRelSrvSqlStrBP bp=new GetEmsRelSrvSqlStrBP();
		return bp.exec(id_ems);
	}
	
	/**
	 * 获得服务描述Sql字符串
	 * 数据格式：srttp,fldn1,fldn2,....
	 * @param srvdescflds
	 * @param isCaseWhen
	 * @return
	 */
	private String getSrvDescSqlPart(String[] srvdescfldinfo,FBoolean iscasewhen){
		String rtn="",rtn1="";
		if(!CiOrdUtils.isEmpty(srvdescfldinfo[0])){
			if(iscasewhen.booleanValue()){
				rtn=" case when A.Sd_Srvtp like '"+srvdescfldinfo[0]+"%' then ";
			}else{
				rtn=" when A.Sd_Srvtp like '"+srvdescfldinfo[0]+"%' then ";
			}
		}else{
			if(iscasewhen==null){
				rtn=" else ";
			}
		}
		SrvRefTypeInfo[] srvreftpinfos=getSrvRefInfo();
		for(int i=1;i<srvdescfldinfo.length;i++){
			if(CiOrdUtils.isEmpty(srvdescfldinfo[i]))continue;
			if(CiOrdUtils.isEmpty(rtn1)){
				rtn1=getRelFldSqlStr(srvdescfldinfo[i],srvreftpinfos,false);
			}else{
				rtn1+=" || ',' || "+getRelFldSqlStr(srvdescfldinfo[i],srvreftpinfos,false);
			}
		}
		return rtn+rtn1;
	}
	
	/**
	 * 获得服务描述Sql字符串
	 * 数据格式：srttp,fldn1,fldn2,....
	 * @param srvdescflds
	 * @return
	 */
	private String getSrvDescSqlStr1(String srvdescflds){
		String[] srvdescfldinfo=srvdescflds.split(",");
		String rtn="",rtn1="";
		if(!CiOrdUtils.isEmpty(srvdescfldinfo[0])){
			rtn=" case when A.Sd_Srvtp like '"+srvdescfldinfo[0]+"%' then ";
		}
		
		SrvRefTypeInfo[] srvreftpinfos=getSrvRefInfo();
		for(int i=1;i<srvdescfldinfo.length;i++){
			if(CiOrdUtils.isEmpty(srvdescfldinfo[i]))continue;
			if(CiOrdUtils.isEmpty(rtn1)){
				rtn1=getRelFldSqlStr(srvdescfldinfo[i],srvreftpinfos,false);
			}else{
				rtn1+=" || ',' || "+getRelFldSqlStr(srvdescfldinfo[i],srvreftpinfos,false);
			}
		}
		if(rtn.equals(""))return rtn1;
		return rtn+rtn1+" else '' end ";
	}
	
	/**
	 * 获得服务描述字段对应的sql对应物
	 * @param fldname
	 * @param srvreftpinfos
	 * @param isasfldname
	 * @return
	 */
	private String getRelFldSqlStr(String fldname,SrvRefTypeInfo[] srvreftpinfos,boolean isasfldname){
		String[] allflds=getAllFields();
		int index=-1;
		for(int i=0;i<allflds.length;i++){
			if(CiOrdUtils.isInStr(fldname, allflds[i])){
				index=i;
				break;
			}
		}
		if(index!=-1){
			SrvRefTypeInfo srvreftpinfo=srvreftpinfos[index];
			String[] flds=srvreftpinfo.getTpFields();
			for(int i=0;i<flds.length;i++){
				if(fldname.equals(flds[i])){
					if(isasfldname){
						return (srvreftpinfo.getTpRelFields())[i] +" as " + fldname ;
					}else{
						return (srvreftpinfo.getTpRelFields())[i];
					}
				}
			}
		}
		return "";
	}

}

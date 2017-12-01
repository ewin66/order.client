/**
 * 
 */
package iih.ci.ord.s.bp.qry;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.dto.d.Emp2Dep2GroupDTO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: getOrderTplTreeDtoQry
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年3月5日 上午11:40:17
 * @Package iih.ci.ord.s.bp.qry
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getOrderTplTreeDtoQry implements ITransQry {

	public String _id_srvorrt;// 全院  科室  个人
	public String _id_ortpltp;// 模板类型   医嘱模板  ，协定处方（草药方剂）
	private Emp2Dep2GroupDTO edg;
	
	public getOrderTplTreeDtoQry( String id_ortpltp,Emp2Dep2GroupDTO edg){
		//this._id_srvorrt = id_srvorrt;
		this._id_ortpltp = id_ortpltp;
		this.edg = edg;
	}
	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQryParameter(java.lang.StringBuffer)
	 */
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		//sqlparam.addParam(this._id_srvorrt);
		sqlparam.addParam(this._id_ortpltp);
		sqlparam.addParam(this._id_ortpltp);
		sqlparam.addParam(this._id_ortpltp);
		
		sqlparam.addParam(this._id_ortpltp);
		sqlparam.addParam(this._id_ortpltp);
		sqlparam.addParam(this._id_ortpltp);
		return sqlparam;
	}

	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQrySQLStr()
	 */
	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getsql();
	}
	//就诊类型 10 住院 ， 00 门诊
	private String getentp(Emp2Dep2GroupDTO  edg){
		String entp = "";
		if(edg != null && edg.getCode_entp() != null){
    	   if("10".equals(edg.getCode_entp())) entp = "  and tpl.fg_entp_ip ='Y' ";
           if("00".equals(edg.getCode_entp())) entp = "  and tpl.fg_entp_op ='Y' ";
       }
		return entp;
    }
	
	private String getsql(){
		String sql ="";
		sql += "   ( "
				+" select '"+IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID+"' id, '~' parent, '个人（"+this.edg.getName_emp()+"）' nm from dual"
				+" union "
				+" ("
				+" select ca.id_srvortplca id,ca.id_parent parent, ca.name nm "
				+ " from bd_srv_ortpl_ca ca  where id_srvorrt ='"+IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID+"'"
				+" and ca.id_ortpltp =? and (ca.sd_srvorrt='"+IBdSrvDictCodeConst.SD_OWTP_PERSONAL+"' and ca.id_emp ='"+edg.getId_emp()+"')"
				+" union "
				+" select tpl.id_srvortpl id,tpl.id_srvortplca parent,tpl.name nm from  "
				+ " bd_srv_ortpl tpl ,bd_srv_ortpl_ca tplca  where tpl.id_srvortplca = tplca.id_srvortplca"
				+" and  tpl.fg_active ='Y'  ";
				 if(this.getentp(edg) != ""){
					 sql +=	 this.getentp(edg);
					 }
				sql +=" and tplca.id_srvorrt ='"+IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID+"'"
				+" and tplca.id_ortpltp =? and (tplca.sd_srvorrt='"+IBdSrvDictCodeConst.SD_OWTP_PERSONAL+"' and tplca.id_emp ='"+edg.getId_emp()+"')"
				+" )"
				+" )"
				+" union "
				+" ("
				 
				+" select '"+IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID+"' id, '~' parent, '科室（"+edg.getName_dep()+"）' nm  from dual "
				+" union "
				+" ("
				+" select ca.id_srvortplca id,ca.id_parent parent, ca.name nm "
				+ "  from bd_srv_ortpl_ca ca  where id_srvorrt ='"+IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID+"'"
				+" and ca.id_ortpltp = ? and (ca.sd_srvorrt='"+IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT+"' and ca.id_dep='"+edg.getId_dep()+"')"
				+" union "
				+"  select tpl.id_srvortpl id,tpl.id_srvortplca parent,tpl.name nm from "
				+ " bd_srv_ortpl tpl ,bd_srv_ortpl_ca tplca "
				+ "  where tpl.id_srvortplca = tplca.id_srvortplca "
				+"  and  tpl.fg_active ='Y' ";
				 if(this.getentp(edg) != ""){
					 sql +=	 this.getentp(edg);
					 }
			   sql +="  and tplca.id_srvorrt ='"+IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID+"'"
				+"  and tplca.id_ortpltp =? and (tplca.sd_srvorrt='"+IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT+"' and tplca.id_dep='"+edg.getId_dep()+"')"
				+"  )"
				+" )"
				+" union"
				+" ("
				 
				+" select '"+IBdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID+"' id, '~' parent, '全院（"+edg.getName_org()+"）' nm from dual"
				+" union "
				+" ("
				+"  select ca.id_srvortplca id,ca.id_parent parent, ca.name nm  "
				+ " from bd_srv_ortpl_ca ca  where id_srvorrt ='"+IBdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID+"'"
				+"  and ca.id_ortpltp =? and (ca.sd_srvorrt='"+IBdSrvDictCodeConst.SD_OWTP_HOSPIAL+"' and ca.id_org='"+edg.getId_org()+"')"
				+"  union "
				+"  select tpl.id_srvortpl id,tpl.id_srvortplca parent,tpl.name nm from "
				+ "  bd_srv_ortpl tpl ,bd_srv_ortpl_ca tplca  where tpl.id_srvortplca = tplca.id_srvortplca"
				+"  and  tpl.fg_active ='Y' ";
				 if(this.getentp(edg) != ""){
				 sql +=	 this.getentp(edg);
				 }
				sql += "  and tplca.id_srvorrt ='"+IBdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID+"'"
				+"  and tplca.id_ortpltp =? and  (tplca.sd_srvorrt='"+IBdSrvDictCodeConst.SD_OWTP_HOSPIAL+"' and tplca.id_org='"+edg.getId_org()+"')"
				+" ) "
				+" )";
			
		return sql;
	}
	
	
}

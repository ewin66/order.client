package iih.ci.ord.s.bp.base.relsrv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.RelSrvTacticDO;
import iih.bd.srv.medsrv.d.desc.RelSrvTacticDODesc;
import iih.bd.srv.oth.d.BdRelSrvParamDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/*
 * 获得医疗单关联服务策略DO列表数据信息操作BP
 * 通过关联服务策略因素项匹配获得关联服务策略DO列表 
 */
public class GetRelSrvTacticDOsBP {
	/**
	 * 获得医疗单关联服务策略DO列表数据信息
	 * 通过关联服务策略因素项匹配获得关联服务策略DO列表
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public RelSrvTacticDO[] exec(BdRelSrvParamDTO param)  throws BizException{
		//有效性校验 
		if(!isValidateCheck(param))return null;
		
		//参数定义
		String tbaliasname=RelSrvTacticDODesc.TABLE_ALIAS_NAME;
		String whereStr=getWhereStr(tbaliasname,param);//0全院1科室2个人
		
		//数据结果查询
		RelSrvTacticDO[] relsrvdos=CiOrdAppUtils.getRelsrvtacticsRService().find(whereStr, "id_biz,id_bizitm,sd_srvorrt desc", FBoolean.FALSE);
		if(CiOrdUtils.isEmpty(relsrvdos))return null;
		
		//数据结果匹配处理并返回
		return datumHandle(relsrvdos,param);
	}
	
	/**
	 * 数据过滤处理
	 * @param relsrvdos
	 * @param param
	 * @return
	 */
	private RelSrvTacticDO[] datumHandle(RelSrvTacticDO[] relsrvdos,BdRelSrvParamDTO param){
		//参数定义
		HashMap<String,ArrayList<RelSrvTacticDO>> ht=new HashMap<String,ArrayList<RelSrvTacticDO>>();
		String key="";
		ArrayList<RelSrvTacticDO> tmlist=null;
		
		//遍历  按匹配因子组织数据
		for(RelSrvTacticDO relsrvdo:relsrvdos){
			key=getKey(relsrvdo,param);
			if(CiOrdUtils.isEmpty(key))continue;
			
			//存在性判断
			if(ht.containsKey(key)){
				((ArrayList<RelSrvTacticDO>)ht.get(key)).add(relsrvdo);
			}else{
				tmlist=new ArrayList<RelSrvTacticDO>();
				tmlist.add(relsrvdo);
				ht.put(key, tmlist);
			}
		}
		
		//空判断
		if(CiOrdUtils.isEmpty(ht))return null;
		
		//返回处理
		return datumHandle0(ht,param);
	}
	
	/**
	 * 数据过滤处理
	 * 按适用范围过滤
	 * @param ht
	 * @param param
	 * @return
	 */
	private RelSrvTacticDO[] datumHandle0(HashMap<String,ArrayList<RelSrvTacticDO>> ht,BdRelSrvParamDTO param){
		//参数
		ArrayList<RelSrvTacticDO> rtnlist=new ArrayList<RelSrvTacticDO>();
		ArrayList<RelSrvTacticDO> tmlist=null;
		RelSrvTacticDO do1=null;
		String key;
		Iterator it = ht.keySet().iterator();  
		
		//循环
		while (it.hasNext()){  
		  key=(String)it.next();  
		  tmlist=(ArrayList<RelSrvTacticDO>)ht.get(key);
		  do1=getMatchDO(tmlist,param);
		  if(!CiOrdUtils.isEmpty(do1))rtnlist.add(do1);
		}
		
		//有效性判断
		if(CiOrdUtils.isEmpty(rtnlist))return null;
		
		//返回
		return (RelSrvTacticDO[]) CiOrdUtils.list2Array(rtnlist, RelSrvTacticDO.class);
	}
	
	/**
	 * 获得匹配关联服务DO数据
	 * @param list
	 * @param param
	 * @return
	 */
	private RelSrvTacticDO getMatchDO(ArrayList<RelSrvTacticDO> list,BdRelSrvParamDTO param){
		RelSrvTacticDO tmp=null;
		int indexOrg=-1;
		
		//遍历
		for(int i=0;i<list.size();i++){
			tmp=list.get(i);
			if(IBdSrvDictCodeConst.SD_OWTP_HOSPIAL.equals(tmp.getSd_srvorrt())){
				indexOrg=i;
			}else if(IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT.equals(tmp.getSd_srvorrt()))
			{
				//空  则逃过
				if(CiOrdUtils.isEmpty(tmp.getId_dep()))continue;
				
				if(IBdSrvDictCodeConst.SD_DEPTP_EN.equals(tmp.getSd_deptp())){
					if(tmp.getId_dep().equals(param.getId_dep_en()))return tmp;
				}else if(IBdSrvDictCodeConst.SD_DEPTP_OR.equals(tmp.getSd_deptp())){
					if(tmp.getId_dep().equals(param.getId_dep_or()))return tmp;
				}else if(IBdSrvDictCodeConst.SD_DEPTP_WARD.equals(tmp.getSd_deptp())){
					if(tmp.getId_dep().equals(param.getId_dep_ns()))return tmp;
				}else{
					if(tmp.getId_dep().equals(param.getId_dep_or()))return tmp;
				}
			}
		}
		//返回 全院情形
		if(indexOrg>=0)return list.get(indexOrg);
		
		//返回空
		return null;
	}
	
	/**
	 * 获得key值
	 * @param relsrvdo
	 * @param param
	 * @return
	 */
	private String getKey(RelSrvTacticDO relsrvdo,BdRelSrvParamDTO param){
		//次因子为空
		if(CiOrdUtils.isEmpty(relsrvdo.getId_bizitm())){
			return relsrvdo.getId_biz()+CiOrdUtils.COMMA_STR+relsrvdo.getGroupno();
		}else{
			//匹配次因子为空 则返回
			if(CiOrdUtils.isEmpty(param.getId_bizs2()))return null;
			
			//不在匹配次因子中  则返回
			if(!CiOrdUtils.isInStr(relsrvdo.getId_bizitm(), param.getId_bizs2()))return null;
			
			//返回
			return relsrvdo.getId_biz()+CiOrdUtils.COMMA_STR+relsrvdo.getId_bizitm()+CiOrdUtils.COMMA_STR+relsrvdo.getGroupno();
		}
	}
	
	/**
	 * 有效性校验
	 * @param param
	 * @return
	 */
	private boolean isValidateCheck(BdRelSrvParamDTO param){
		if(CiOrdUtils.isEmpty(param)) return false;
		if(CiOrdUtils.isEmpty(param.getId_org()) || 
				CiOrdUtils.isEmpty(param.getCode_entp()) ||
				CiOrdUtils.isEmpty(param.getId_bizs1()))return false;
		return true;
	}
	
	/**
	 * 获得基本SQL语句片段
	 * @param tbaliasname
	 * @param param
	 * @return
	 */
	private String getWhereStr(String tbaliasname,BdRelSrvParamDTO param){
		String orgid=tbaliasname+".id_org='"+param.getId_org()+"'";
		String rtnstr=orgid+CiOrdUtils.AND_STR
				+tbaliasname+".fg_use_"+CiOrdUtils.getEntpFldNameStr(param.getCode_entp())+"='Y'"+CiOrdUtils.AND_STR
				+tbaliasname+".id_biz "+CiOrdUtils.getSqlInOrEqualStrs(param.getId_bizs1())+" "+CiOrdUtils.AND_STR
				+tbaliasname+".fg_active='Y' ";
		return rtnstr;
	}

}

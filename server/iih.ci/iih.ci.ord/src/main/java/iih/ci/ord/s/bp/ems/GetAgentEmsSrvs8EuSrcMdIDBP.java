package iih.ci.ord.s.bp.ems;

import java.util.ArrayList;

import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/**
 * 根据来源方式及来源服务ID获得派生的医疗单项目集合数据操作BP
 */
public class GetAgentEmsSrvs8EuSrcMdIDBP {
	/**
	 * 根据来源方式及来源服务ID获得派生的医疗单项目集合数据
	 * @param ems
	 * @param id_srv_src
	 * @param eu_sourcemds
	 * @param priby 专为套个数计价与加收用
	 * @return
	 * @throws BizException
	 */
	public  ArrayList<CiEmsSrvDTO> exec(CiEmsDTO ems,String id_srv_src,Integer[] eu_sourcemds,String priby)  throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(ems) || CiOrdUtils.isEmpty(ems.getEmssrvs()) || CiOrdUtils.isEmpty(id_srv_src) || CiOrdUtils.isEmpty(eu_sourcemds))return null;
		
		//参数设置
		ArrayList<CiEmsSrvDTO> rtnlist=new ArrayList<CiEmsSrvDTO>();
		String eusrcstr=getEu_sourcemdStr(eu_sourcemds);
		CiEmsSrvDTO emssrvdto=null;


		//遍历
		for(int i=0;i<ems.getEmssrvs().size();i++){
			emssrvdto=(CiEmsSrvDTO)ems.getEmssrvs().get(i);
			if(id_srv_src.equals(emssrvdto.getId_srv_src()) 
					&& CiOrdUtils.isInStr(formatStr(emssrvdto.getEu_sourcemd()), eusrcstr)
					&& isEq(emssrvdto.getPriby(),priby)&&emssrvdto.getStatus()!=DOStatus.DELETED)
				{rtnlist.add(emssrvdto);}
		}
		
		//返回
		return rtnlist;
	}
	/**
	 * 获得来源方式连接串
	 * @param eu_sourcemds
	 * @return
	 */
	private String getEu_sourcemdStr(Integer[] eu_sourcemds){
		String rtnstr="";
		for(int i=0;i<eu_sourcemds.length;i++){
			rtnstr+=CiOrdUtils.COMMA_STR+eu_sourcemds[i].toString();
		}
		return rtnstr+CiOrdUtils.COMMA_STR;
	}
	
	private String formatStr(Integer input){
		String tm="";
		if(!CiOrdUtils.isEmpty(input))tm=input.toString();
		return CiOrdUtils.COMMA_STR+tm+CiOrdUtils.COMMA_STR;//
	}
	/**
	 * 计价依据比较
	 * @param v
	 * @param priby
	 * @return
	 */
	private boolean isEq(String v,String priby){
		if(CiOrdUtils.isEmpty(priby))return true;  //为空 则不需进行比较
		if(priby.equals(v))return true;            //不为空  比较相等时返回 true 依据相同
		return false;
	}
}

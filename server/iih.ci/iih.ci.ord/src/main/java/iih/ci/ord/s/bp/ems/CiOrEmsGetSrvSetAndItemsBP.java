package iih.ci.ord.s.bp.ems;

import java.lang.reflect.Array;
import java.util.ArrayList;

import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 获得ems医疗单中套及套内项目集合索引信息操作BP
 */
public class CiOrEmsGetSrvSetAndItemsBP {
	/**
	 *  获得ems医疗单中套及套内项目集合索引信息操作
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public  Integer[] exec(CiEmsDTO ems)  throws BizException{
		
		//有效性校验
		if(ems==null || ems.getEmssrvs()==null || ems.getEmssrvs().size()==0)return null; 
		
		//参数设置
		String id_srv_set="";
		FArrayList list=ems.getEmssrvs();
		CiEmsSrvDTO srvdto=null;
		int iN=0;
		ArrayList<Integer> rtnlist=new ArrayList<Integer>();
		
		//遍历
		for(int i=0;i<list.size();i++){
			srvdto=(CiEmsSrvDTO)list.get(i);
			if(OrSrvSplitUtil.isTrue(srvdto.getFg_set())){
				iN+=1;
				rtnlist.add(0, i);
				id_srv_set=srvdto.getId_srv();
				if(OrSrvSplitUtil.isEmpty(id_srv_set)){
					throw new BizException("ems医疗单中项目是服务套，但套所对应的服务ID为空错误！");
				}
			}else{
				if(rtnlist.size()==0 && !OrSrvSplitUtil.isEmpty(srvdto.getId_srv_set())){
					throw new BizException("ems医疗单中服务套套内项目应置于服务套项目之后！");
				}
				if(id_srv_set.equals(srvdto.getId_srv_set())){
					rtnlist.add(i);
				}
			}
		}
		if(iN==0)return null;
		if(iN>1){
			throw new BizException("ems医疗单中服务套个数为多个错误！");
		}
		return (Integer[]) rtnlist.toArray((Integer[]) Array.newInstance(Integer.class, 0));
	}
}

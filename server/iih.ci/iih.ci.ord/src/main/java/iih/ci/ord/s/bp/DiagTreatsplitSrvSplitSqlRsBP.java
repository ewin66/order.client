package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.GetOrAndSrvSplitSqlRsBP;
import iih.ci.ord.s.bp.orsrvsplit.SplitOrAndSrvSplitSqlRsBP;
import iih.mp.nr.mporplan.d.MpOrPlanDO;
import iih.mp.nr.mporplan.d.desc.MpOrPlanDODesc;
import iih.mp.nr.mporplan.i.IMporplanRService;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class DiagTreatsplitSrvSplitSqlRsBP {
	
	public SrvSplitOrderDTO[] exec(BaseDTO[] splitDTO,OrSrvSplitParamDTO param)throws BizException{
		

//		GetOrAndSrvSplitSqlRsBP getsrvbp=new GetOrAndSrvSplitSqlRsBP();	
//        BaseDTO[] splitDTO=getsrvbp.exec(param);
        SplitOrAndSrvSplitSqlRsBP bp=new SplitOrAndSrvSplitSqlRsBP();
        BaseDTO[] srvsplitDTO=bp.exec(splitDTO, param.getDt_split_start(), param.getDt_split_end(), param.getEu_orgensplittp());
        setExecuteStatus(srvsplitDTO);
        return (SrvSplitOrderDTO[])srvsplitDTO;
		
	}
	
	//设置执行状态
	
	private void setExecuteStatus(BaseDTO[] srvsplitDTO) throws BizException{
		if(CiOrdUtils.isEmpty(srvsplitDTO))return;
		String sql=getIdOrs((SrvSplitOrderDTO[]) srvsplitDTO);
		Map<String,MpOrPlanDO> map=getMpOrPlans(sql);
		
		for (SrvSplitOrderDTO ssDTO : (SrvSplitOrderDTO[])srvsplitDTO) {
			String key=ssDTO.getId_or()+","+ssDTO.getDt_mp_plan();
			MpOrPlanDO mp=map.get(key);
			if(mp!=null&&mp.getEu_su()!=null)
			ssDTO.setOrsrv_su_mp(mp.getEu_su().toString());
			else{
				ssDTO.setOrsrv_su_mp("0");

			}
		}
		
	}
	//获取医嘱id
	
	private String getIdOrs(SrvSplitOrderDTO[] srvsplitDTO){
		StringBuilder sb=new StringBuilder();
		List<String> list=new ArrayList<String>();
		sb.append("(");
		for (SrvSplitOrderDTO srvSplitOrderDTO : srvsplitDTO) {
			
			if(!list.contains(srvSplitOrderDTO.getId_or())){				
				list.add(srvSplitOrderDTO.getId_or());
				if(!(sb.length()==1))
					sb.append(",");
				sb.append("'"+srvSplitOrderDTO.getId_or()+"'");
			}
		}
		sb.append(")");
		return sb.toString();
	}
	
	//获取执行计划明细
	private Map<String,MpOrPlanDO> getMpOrPlans(String sql) throws BizException{
		
		Map<String,MpOrPlanDO> map=new HashMap<String,MpOrPlanDO>();
		IMporplanRService rservice=ServiceFinder.find(IMporplanRService.class);
		MpOrPlanDO[] mps=rservice.find(MpOrPlanDODesc.TABLE_ALIAS_NAME+".id_or in "+sql, null, FBoolean.FALSE);
		for (MpOrPlanDO mpOrPlanDO : mps) {
			String key=mpOrPlanDO.getId_or()+","+mpOrPlanDO.getDt_mp_plan();
			if(!map.containsKey(key))
				map.put(key, mpOrPlanDO);
		}
		return map;
	}

}

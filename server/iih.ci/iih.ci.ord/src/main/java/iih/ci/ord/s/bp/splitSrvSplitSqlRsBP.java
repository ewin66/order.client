package iih.ci.ord.s.bp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import iih.ci.ord.dto.blexorder.d.TransSrvSplitOrderDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.GetOrAndSrvSplitSqlRsBP;
import iih.ci.ord.s.bp.orsrvsplit.SplitOrAndSrvSplitSqlRsBP;
import iih.mp.nr.mporplan.d.MpOrPlanDO;
import iih.mp.nr.mporplan.d.desc.MpOrPlanDODesc;
import iih.mp.nr.mporplan.i.IMporplanRService;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class splitSrvSplitSqlRsBP {
	
	public TransSrvSplitOrderDTO[] exec(OrSrvSplitParamDTO param)throws BizException{		

		GetOrAndSrvSplitSqlRsBP getsrvbp=new GetOrAndSrvSplitSqlRsBP();	
        BaseDTO[] splitDTO=getsrvbp.exec(param);
        FArrayList fa=getIdOrs(splitDTO);
		String idors=(String)fa.get(1);
        SplitOrAndSrvSplitSqlRsBP bp=new SplitOrAndSrvSplitSqlRsBP();
        BaseDTO[] srvsplitDTO=bp.exec((BaseDTO[]) fa.get(0), param.getDt_split_start(), param.getDt_split_end(), param.getEu_orgensplittp());
        TransSrvSplitOrderDTO[] srvsplits=setExecuteStatus(srvsplitDTO,idors,param);
        return srvsplits;
		
	}
	
	//设置执行状态
	
	private TransSrvSplitOrderDTO[] setExecuteStatus(BaseDTO[] srvsplitDTO,String idors,OrSrvSplitParamDTO param) throws BizException{
		if(CiOrdUtils.isEmpty(srvsplitDTO))return null;
        List<TransSrvSplitOrderDTO> tsrvlist=new ArrayList<>();
		Map<String,MpOrPlanDO> map=getMpOrPlans(idors,param);
		
		for (SrvSplitOrderDTO ssDTO : (SrvSplitOrderDTO[])srvsplitDTO) {
			TransSrvSplitOrderDTO tsrv=new TransSrvSplitOrderDTO();
			String key=ssDTO.getId_or()+","+ssDTO.getDt_mp_plan();
			MpOrPlanDO mp=map.get(key);
			if(mp!=null&&mp.getEu_su()!=null)
			ssDTO.setOrsrv_su_mp(mp.getEu_su().toString());
			else{
				ssDTO.setOrsrv_su_mp("0");

			}
			
			copytanssrv( tsrv,ssDTO);
			tsrvlist.add(tsrv);
		}
		
		return tsrvlist.toArray(new TransSrvSplitOrderDTO[0]);
		
	}
	//获取医嘱id
	
	private FArrayList getIdOrs(BaseDTO[] srvsplitDTO){
		StringBuilder sb=new StringBuilder();
		List<String> list=new ArrayList<String>();
		List<SrvSplitOrderDTO> splist=new ArrayList<SrvSplitOrderDTO>();
		FArrayList fa=new FArrayList();
		sb.append("(");
		for (BaseDTO o : srvsplitDTO) {
			SrvSplitOrderDTO srvSplitOrderDTO=(SrvSplitOrderDTO)o;
			if(!islegal(srvSplitOrderDTO))continue;
			splist.add(srvSplitOrderDTO);
			if(!list.contains(srvSplitOrderDTO.getId_or())){				
				list.add(srvSplitOrderDTO.getId_or());
				if(!(sb.length()==1))
					sb.append(",");
				sb.append("'"+srvSplitOrderDTO.getId_or()+"'");
			}
		}
		sb.append(")");
	
		fa.add(0,splist.toArray(new SrvSplitOrderDTO[0]));
		fa.add(1,sb.toString());
		return fa;
	}
	
	 private Boolean islegal(SrvSplitOrderDTO dto){
	    	
	    	Boolean flag=false;
	    	 if(dto.getFg_or()!=null&&dto.getFg_or()==FBoolean.TRUE)
	    		 flag=true;
	    	return flag;
	    }
	
	//获取执行计划明细
	private Map<String,MpOrPlanDO> getMpOrPlans(String sql,OrSrvSplitParamDTO param) throws BizException{
		
		Map<String,MpOrPlanDO> map=new HashMap<String,MpOrPlanDO>();
		IMporplanRService rservice=ServiceFinder.find(IMporplanRService.class);
		MpOrPlanDO[] mps=rservice.find(MpOrPlanDODesc.TABLE_ALIAS_NAME+".id_or in "+sql
				+" and "+MpOrPlanDODesc.TABLE_ALIAS_NAME+".dt_mp_plan>='"+param.getDt_split_start()+
				"' and "+MpOrPlanDODesc.TABLE_ALIAS_NAME+".dt_mp_plan<='"+param.getDt_split_end()+"'", null, FBoolean.FALSE);
		for (MpOrPlanDO mpOrPlanDO : mps) {
			String key=mpOrPlanDO.getId_or()+","+mpOrPlanDO.getDt_mp_plan();
			if(!map.containsKey(key))
				map.put(key, mpOrPlanDO);
		}
		return map;
	}
	
	
	private void copytanssrv(TransSrvSplitOrderDTO tsrv,SrvSplitOrderDTO srvsplit){
		
		tsrv.setId_or(srvsplit.getId_or());
		tsrv.setDt_effe(srvsplit.getDt_effe());
		tsrv.setDt_mp_plan(srvsplit.getDt_mp_plan());
		tsrv.setFg_long(srvsplit.getFg_long());
		tsrv.setDt_stop(srvsplit.getDt_stop());
		tsrv.setFreqcnt(srvsplit.getFreqcnt());
		tsrv.setId_orsrv(srvsplit.getId_orsrv());
		tsrv.setId_srv(srvsplit.getId_srv());
		
		tsrv.setId_srvtp(srvsplit.getId_srvtp());
		tsrv.setSd_srvtp(srvsplit.getSd_srvtp());
		tsrv.setCode_srv(srvsplit.getCode_srv());
		tsrv.setOrsrv_su_mp(srvsplit.getOrsrv_su_mp());
		tsrv.setName_srv(srvsplit.getName_srv());

		
	}

}

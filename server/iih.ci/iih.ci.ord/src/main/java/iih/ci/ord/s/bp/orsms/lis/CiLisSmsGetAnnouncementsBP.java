package iih.ci.ord.s.bp.orsms.lis;

import iih.bd.srv.notice.d.MedNoticeDO;
import iih.bd.srv.notice.i.IMednoticeRService;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import iih.ci.ord.s.bp.orsms.lis.cfg.EmsMergeRulesCfg;
import iih.ci.ord.s.bp.orsms.lis.cfg.NoticeConfigure;
import iih.ci.ord.s.bp.orsms.lis.cfg.NoticeDetailConfigure;
import iih.ci.ord.s.bp.orsms.lis.rule.CiLisOrSmsUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class CiLisSmsGetAnnouncementsBP {
	
    Map<String,MedNoticeDO> notices=new HashMap<>();
	public List<CiLisOrSmsIoDTO> exec(List<CiLisOrSmsIoDTO> lisorlist) throws BizException {
		notices.clear();
		List<NoticeConfigure> szNotices = EmsMergeRulesCfg.getInstance().getNotices(); 
		for (NoticeConfigure noticeConfigure : szNotices) {
			
			handlesampandsrv(lisorlist, noticeConfigure);
			
		}
		return lisorlist;
		
	}
	
	
	private void handlesampandsrv(List<CiLisOrSmsIoDTO> lisorlist,NoticeConfigure noticeConfigure) throws BizException{
		
		if(!noticeConfigure.getId().equals(CiLisOrSmsUtils.CILISOR_SMS_SAMPTPANDSRVCA_RULE_ID))return;
		
		List<NoticeDetailConfigure> details=noticeConfigure.getDetails();
		Map<String,NoticeDetailConfigure> map=mapNoticeDetailConfigure(details);

			for (CiLisOrSmsIoDTO sms : lisorlist) {
				if(sms.getId_samptp()==null||sms.getId_srvca()==null)continue;		
							
					String tmprule=sms.getId_samptp()+"|"+sms.getId_srvca();
					if(map.containsKey(tmprule)){
						String announce=getNotices(map.get(tmprule).getValues());
						sms.setAnnouncements(announce);
						
					}
				
			}	
		
	}
	
	private Map<String,NoticeDetailConfigure> mapNoticeDetailConfigure(List<NoticeDetailConfigure> details) throws BizException{
		
		Map<String,NoticeDetailConfigure> map=new HashMap<String,NoticeDetailConfigure>();
		StringBuilder sb=new StringBuilder();
		for (NoticeDetailConfigure noticeDetailConfigure : details) {
			String id=noticeDetailConfigure.getId();
			
			map.put(id, noticeDetailConfigure);
			if(sb.length()==0){
				sb.append(noticeDetailConfigure.getValues());
			}else{
				String tmp=noticeDetailConfigure.getValues();
				String[] tmps=tmp.split(CiLisOrSmsUtils.CILISOR_SMS_NOTICE_SPLITOR);
				String a="";
				for (String o : tmps) {
					if(!(sb.toString().contains(o))&&!(notices.containsKey(o)))
						a=a+","+o;
				}
				sb.append(a);
			}
		}
		if(sb.length()>0){
			
			IMednoticeRService serviceImp = ServiceFinder.find(IMednoticeRService.class);
			MedNoticeDO[] mns = serviceImp.findByBIds((sb.toString()).split(","), FBoolean.FALSE);
			if(mns==null)return map;
			for (MedNoticeDO medNoticeDO : mns) {
				notices.put(medNoticeDO.getId_notice(), medNoticeDO);
			}
		}
		return map;
		
	}
	
	
	private String getNotices(String ids) throws BizException{
		
		String NoticeIndexSymbol=EmsMergeRulesCfg.getInstance().getNoticeIndexSymbol();
		String NoticeIndexSuffixSymbol=EmsMergeRulesCfg.getInstance().getNoticeIndexSuffixSymbol();
		String splitor=EmsMergeRulesCfg.getInstance().getNoticeWrapSymbol();
		String[] idarr=ids.split(CiLisOrSmsUtils.CILISOR_SMS_NOTICE_SPLITOR);
//		List<String> idqrys=new ArrayList<>();
//		Map<Integer,String> map=new HashMap<Integer,String>();
		
		StringBuilder sb=new StringBuilder();
		String index= getindex(NoticeIndexSymbol);
		for(int j=0;j<idarr.length;j++){
			if(sb.length()==0){
				sb.append(index+NoticeIndexSuffixSymbol+notices.get(idarr[j]).getName());
			}else{
				sb.append(splitor+index+NoticeIndexSuffixSymbol+notices.get(idarr[j]).getName());
			}
			
			index=addindex(NoticeIndexSymbol,index);
			
		}
//		int i=1;	
//		for (String o : idarr) {
//			map.put(i,o);
//			if(!notices.containsKey(o))
//				idqrys.add(o);
//			i++;
//		}
//		if(!idqrys.isEmpty()){
//			IMednoticeRService serviceImp = ServiceFinder.find(IMednoticeRService.class);
//			MedNoticeDO[] mns = serviceImp.findByBIds(idqrys.toArray(new String[0]), FBoolean.FALSE);
//			for (MedNoticeDO medNoticeDO : mns) {
//				notices.put(medNoticeDO.getId_notice(), medNoticeDO);
//			}
//		}
//		StringBuilder sb=new StringBuilder();
//		String index= getindex(NoticeIndexSymbol);
//		for(int j=1;j<=idarr.length;j++){
//			if(sb.length()==0){
//				sb.append(index+NoticeIndexSuffixSymbol+notices.get(map.get(j)).getName());
//			}else{
//				sb.append(splitor+index+NoticeIndexSuffixSymbol+notices.get(map.get(j)).getName());
//			}
//			
//			index=addindex(NoticeIndexSymbol,index);
//			
//		}
		return sb.toString();
	}
	
	
	private  String getindex(String index1){

		if(index1==null)return "";
		switch (index1) {
		case EmsMergeRulesCfg.SYMBOL_ALPHABET_INDEX_FORMAT:
			return "a";

		case EmsMergeRulesCfg.SYMBOL_ARABIC_INDEX_FORMAT:
			return "1";
		case EmsMergeRulesCfg.SYMBOL_ROMANNO_INDEX_FORMAT:
			
			break;

		default:
			break;
		}
		
		return "";
	}
	
	private  String addindex(String index1,String val){

		if(index1==null)return "";
		switch (index1) {
		case EmsMergeRulesCfg.SYMBOL_ALPHABET_INDEX_FORMAT:
			return (val.charAt(0)+1)+"";

		case EmsMergeRulesCfg.SYMBOL_ARABIC_INDEX_FORMAT:
			return (Integer.parseInt(val)+1)+"";
		case EmsMergeRulesCfg.SYMBOL_ROMANNO_INDEX_FORMAT:
			
			break;

		default:
			break;
		}
		
		return "";
	}
	
	
}

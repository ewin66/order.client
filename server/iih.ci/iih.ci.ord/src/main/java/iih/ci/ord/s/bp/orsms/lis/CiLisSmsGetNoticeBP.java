package iih.ci.ord.s.bp.orsms.lis;

import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import iih.ci.ord.s.bp.orsms.lis.cfg.EmsMergeRulesCfg;
import iih.ci.ord.s.bp.orsms.lis.cfg.NoticeConfigure;
import iih.ci.ord.s.bp.orsms.lis.cfg.NoticeDetailConfigure;
import iih.ci.ord.s.bp.orsms.lis.rule.CiLisOrSmsUtils;

import java.util.List;

import xap.mw.core.data.BizException;

public class CiLisSmsGetNoticeBP {

	public List<CiLisOrSmsIoDTO> exec(List<CiLisOrSmsIoDTO> lisorlist) throws BizException {
		
		List<NoticeConfigure> szNotices = EmsMergeRulesCfg.getInstance().getNotices(); 
		for (NoticeConfigure noticeConfigure : szNotices) {
			
			handlesampandsrv(lisorlist, noticeConfigure);
			
		}
		return lisorlist;
		
	}
	
	
	private void handlesampandsrv(List<CiLisOrSmsIoDTO> lisorlist,NoticeConfigure noticeConfigure){
		
		if(!noticeConfigure.getId().equals(CiLisOrSmsUtils.CILISOR_SMS_SAMPTPANDSRVCA_RULE_ID))return;
		
		List<NoticeDetailConfigure> details=noticeConfigure.getDetails();
		
		for (NoticeDetailConfigure noticeDetailConfigure : details) {
			String id=noticeDetailConfigure.getId();
			String[] tmp=id.split(CiLisOrSmsUtils.CILISOR_SMS_RULEGRP_SPLITCA);
			for (CiLisOrSmsIoDTO sms : lisorlist) {
				if(sms.getId_samptp().equals(tmp[0])&&sms.getId_srvca().equals(tmp[1])){
					
					sms.setAnnouncements(noticeDetailConfigure.getValues());
				}
			}
		}
		
	}
	
	
}

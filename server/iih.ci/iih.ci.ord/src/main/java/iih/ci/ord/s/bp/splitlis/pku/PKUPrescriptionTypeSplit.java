package iih.ci.ord.s.bp.splitlis.pku;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.s.bp.splitlis.pku.prestype.rule.PKUETPrescriptionTypeRule;
import iih.ci.ord.s.bp.splitlis.pku.prestype.rule.PKUEmploymentInjuryInsurancePrescriptionTypeRule;
import iih.ci.ord.s.bp.splitlis.pku.prestype.rule.PKUFreeMedicalPrescriptionTypeRule;
import iih.ci.ord.s.bp.splitlis.pku.prestype.rule.PKUMedicalInsurancePrescirptionRule;
import iih.ci.ord.s.bp.splitlis.pku.prestype.rule.PKUMental2PrescriptionTypeRule;
import iih.ci.ord.s.bp.splitlis.pku.prestype.rule.PKUNarcosisAndSingleMindedPrescriptionRule;
import iih.ci.ord.s.bp.splitlis.pku.prestype.rule.PKUOutpatientPrescriptionTypeRule;
import iih.ci.ord.s.bp.splitlis.pku.prestype.rule.PKUToxicityPrescriptionTypeRule;
import iih.en.pv.dto.d.Ent4BannerDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;

/**
 * 国际医院按处方类型分方
 *  门诊处方笺
	急诊处方笺
	医疗保险处方笺
	公费医疗处方笺
	工伤保险处方笺
	门（急）诊麻醉、精一药品处方笺
	门诊二类精神药品处方笺
	门诊医疗用毒性药品处方笺
 * @author li_zheng
 *
 */
public class PKUPrescriptionTypeSplit  {

	
	public List<CiOrPresSplitList> exec(List<CiOrPresSplitList> list)throws BizException{
		List<CiOrPresSplitList> outList;
		
		//门诊医疗用毒性药品处方笺
		 PKUToxicityPrescriptionTypeRule tRule = new PKUToxicityPrescriptionTypeRule(); 
		 outList = tRule.exec(list);
		 //门（急）诊麻醉、精一药品处方笺
		 PKUNarcosisAndSingleMindedPrescriptionRule nsRule =new PKUNarcosisAndSingleMindedPrescriptionRule();
		 outList = nsRule.exec(outList);
		//门诊二类精神药品处方笺
		 PKUMental2PrescriptionTypeRule m2Rule = new PKUMental2PrescriptionTypeRule();
		 outList = m2Rule.exec(outList);
		
			//公费医疗处方笺
		 PKUFreeMedicalPrescriptionTypeRule fmRule = new PKUFreeMedicalPrescriptionTypeRule();
		 outList = fmRule.exec(outList);
		 //高端商保不使用医保的分方规则
		/* CiEnContextDTO context = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		 Ent4BannerDTO banner = context.getEnt4BannerDTO();
		 if( banner != null && banner.getSd_hptp() != null && banner.getSd_hptp().startsWith("2")){
			
		 }else{*/
			 //医疗保险处方笺
			 PKUMedicalInsurancePrescirptionRule miRule = new PKUMedicalInsurancePrescirptionRule();
			 outList = miRule.exec(outList); 
//		 }
	
		 
		//门诊处方笺   急诊处方笺
		 PKUOutpatientPrescriptionTypeRule outPatientRule= new PKUOutpatientPrescriptionTypeRule();
		 outList = 	outPatientRule.exec(outList);
		 //急诊处方笺
		 //PKUETPrescriptionTypeRule etRule =new PKUETPrescriptionTypeRule();
		 //outList = etRule.exec(outList);
	   
		//工伤保险处方笺 暂时 不做
		// PKUEmploymentInjuryInsurancePrescriptionTypeRule eiiRule = new PKUEmploymentInjuryInsurancePrescriptionTypeRule();
		// outList = eiiRule.exec(outList);	
		 return outList;
	}
	
 
}

package iih.ci.ord.s.bp;

import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.validate.DrugUseQuanCalInvalidateBP;
import iih.ci.ord.s.bp.validate.HpAdpValidateBP;
import iih.ci.ord.s.bp.validate.LisItmBillSplitBP;
import iih.ci.ord.s.bp.validate.PathgySampValidateBP;
import iih.ci.ord.s.bp.validate.RationalDrugUseValidateBP;
import iih.ci.ord.s.bp.validate.SkinTestOrSignBP;
import iih.ci.ord.s.bp.validate.SrvMutexValidateBP;
import xap.mw.core.data.BizException;

/*
 * 医嘱保存校验操作BP
 */
public class CiOrderSaveInvalidateBP {
	/**
	 * 医嘱保存校验
	 * @param aggors
	 * @throws BizException
	 */
	public void exec(CiorderAggDO[] aggors) throws BizException{
		
		//医嘱中服务互斥检查与处理
		SrvMutexValidateBP bpmutex=new SrvMutexValidateBP();
		bpmutex.exec(aggors);
		
		//医保适应症检查  待完成
//		HpAdpValidateBP bphp=new HpAdpValidateBP();
//		bphp.exec(aggors);
		
		//合理用药检查  待完成
//		RationalDrugUseValidateBP bprdrug=new RationalDrugUseValidateBP();
//		bprdrug.exec();
		
		//检验项目分单检查  待完成   ？？？
//		LisItmBillSplitBP bplis=new LisItmBillSplitBP();
//		bplis.exec();
		
		//药品用量校验检查    待完成
//		DrugUseQuanCalInvalidateBP bpusequan=new DrugUseQuanCalInvalidateBP();
//		bpusequan.exec();
		
		//皮试医嘱保存校验
		SkinTestOrSignBP skintest = new SkinTestOrSignBP();
		skintest.exec(aggors);
		
		//病理标本项目非空检查
		PathgySampValidateBP pathgysamptest=new PathgySampValidateBP();
		pathgysamptest.exec(aggors);
		
	}
}

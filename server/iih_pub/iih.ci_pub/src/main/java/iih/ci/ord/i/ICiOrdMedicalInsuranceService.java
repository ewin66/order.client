package iih.ci.ord.i;

import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;

/**
 * 医保相关处理接口
 * 
 * @author HUMS
 *
 */
public interface ICiOrdMedicalInsuranceService {

	/**
	 * 获取特殊病判断结果
	 * @param ctx 当前就诊环境
	 * @param id_mms 物品id集合
	 * @return 特殊病判断结果FMap 其中 key：物品id，value：特殊病诊断名称[诊断编码]
	 * @throws BizException 
	 */
	public FMap getSpecialDiseaseJudgeRstMap(CiEnContextDTO ctx, String[] id_mms) throws BizException;
	
	/**
	 * 获取特殊病判断结果
	 * @param ctx 当前就诊环境
	 * @param mmMap 物品对象EmsOrDrug集合(用于构造返回信息时添加物品名称 )
	 * @return
	 * @throws BizException
	 */
	public String getSpecialDiseaseJudgeRst(CiEnContextDTO ctx, FMap mmMap) throws BizException;
}

package iih.ci.ord.s.bp.assi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.ci.ord.dto.ordsrvchangeddto.d.OrdSrvChangedInfoDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.moreemsdto.d.MoreEmsParamDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ordsrvchangedval.OrdChangedSrvValidateBP;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;

/**
 * 将医嘱模板转换为MoreEmsParamDTO，避免各个类中都写
 * 
 * @author HUMS
 *
 */
public class CovertTmplToMoreEmsParamBP {

	public MoreEmsParamDTO exec(String resonInfo,CiEnContextDTO envinfo, CiEmsDTO[] ciEmsDTOs) throws BizException {
         long startTime = System.currentTimeMillis();
		// 校验服务是否允许开立，不允许开立抛出业务异常
		this.validateCiEmsDTO(envinfo, ciEmsDTOs);
		
	    long endTime = System.currentTimeMillis();
        
		//是否有申请表
		JudgeOrderTemplateApplicationTable apptable = new JudgeOrderTemplateApplicationTable();
		apptable.JudgeOrederTemplateAppTabel(ciEmsDTOs, envinfo);
		
		long endTime2 = System.currentTimeMillis();
		
		//系统参数判断 保存数据库还是进入医疗单
		//0  仅生成医疗单UI数据（非自动生成医嘱模式）
		//1  后台自动生成医嘱模式
		MoreEmsParamDTO param = null;
		if (isSaveEmsDTO()) {
			//医疗服务不直接保存 陈妍妍 2017-11-29 需求文档没有写
			if(envinfo.getAssistant_type() != null && "medsrv".equals(envinfo.getAssistant_type())){
				param = new MoreEmsParamDTO();
				//保存医嘱
				FMap2 Errormap2 = new FMap2();
				if(ciEmsDTOs.length >0){
					Errormap2.put("0", ciEmsDTOs[0]);
				}else{
					Errormap2.put(resonInfo, null);
				}
				
				param.setErrormap2(Errormap2);
			}else{
				//保存医嘱
				param= SaveCiEmsDTOBP.SaveCiEmsDTO(envinfo, ciEmsDTOs);
			}
			
		} else {
			param = new MoreEmsParamDTO();
			//保存医嘱
			FMap2 Errormap2 = new FMap2();
			Errormap2.put("0", ciEmsDTOs);
			param.setErrormap2(Errormap2);
		}
		long endTime3 = System.currentTimeMillis();
		StringBuffer logBuffer = new StringBuffer();
		logBuffer.append("执行CovertTmplToMoreEmsParamBP 方法：总耗时："+(endTime3-startTime)+"；validateCiEmsDTO耗时："+(endTime-startTime));
		logBuffer.append("；JudgeOrederTemplateAppTabel方法耗时："+(endTime2-endTime));
		logBuffer.append("；SaveCiEmsDTO耗时："+(endTime3 - endTime2));
		
		OrdBizLogger.info(envinfo, logBuffer.toString());
		return param;
		
	}

	/**
	 * 0 仅生成医疗单UI数据（非自动生成医嘱模式） 1 后台自动生成医嘱模式
	 * 
	 * @return
	 * @throws BizException
	 */
	private Boolean isSaveEmsDTO() throws BizException {

		String isSave = CiOrdAppUtils.getCiOrdQryService().getCiOrAssMultiEmsHandleMode();
		if ("1".equals(isSave)) {
			return true;
		}
		return false;
	}

	/**
	 * 校验服务是否允许开立, 如果存在不允许开立的服务抛出异常
	 * 
	 * @param envinfo 当前就诊环境
	 * @param ciEmsDTOs 医疗单对象
	 * @throws BizException
	 */
	private void validateCiEmsDTO(CiEnContextDTO envinfo, CiEmsDTO[] ciEmsDTOs) throws BizException {

		StringBuffer msgBuffer = null;
		List<OrdSrvChangedInfoDTO> ordSrvStatusInfoList = new ArrayList<OrdSrvChangedInfoDTO>();

		for (CiEmsDTO ciEms : ciEmsDTOs) {

			if (ciEms.getFg_set() == FBoolean.TRUE) {
				OrdSrvChangedInfoDTO dto = new OrdSrvChangedInfoDTO();
				dto.setId_srv(ciEms.getId_srv());
				ordSrvStatusInfoList.add(dto);
			} else {

				// 遍历临床服务项目 
				FArrayList emsSrvList = ciEms.getEmssrvs();
				for (Object obj : emsSrvList) {

					CiEmsSrvDTO ciEmsSrv = (CiEmsSrvDTO) obj;
					OrdSrvChangedInfoDTO dto = new OrdSrvChangedInfoDTO();
					dto.setId_srv(ciEmsSrv.getId_srv());

					if (ciEmsSrv.getFg_mm() == FBoolean.TRUE) {
						dto.setId_mm(ciEmsSrv.getId_mm());
					}
					ordSrvStatusInfoList.add(dto);
				}
			}
		}

		OrdChangedSrvValidateBP bp = new OrdChangedSrvValidateBP();

		// 获取不可用服务集合，key：id_srv; value：不可用提示信息
		Map<String, String> ordSrvStatusMap = bp.exec(envinfo.getCode_entp(), ordSrvStatusInfoList);
		if (ordSrvStatusMap != null && ordSrvStatusMap.size() > 0) {

			msgBuffer = new StringBuffer();
			for (String value : ordSrvStatusMap.values()) {
				msgBuffer.append(value).append(System.lineSeparator());
			}
			throw new BizRuntimeException(msgBuffer.toString());
		}
	}
}

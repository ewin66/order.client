package iih.ci.ord.s.bp.assi.impl.cimes.base;

import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.assi.service.ciems.CalcuateCiEmsProperty;
import iih.ci.ord.s.bp.emscalculate.total.CalTimesCurBP;
import iih.ci.ord.s.bp.srvpri.CiOrBdSrvPriceCalBP;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

public class BaseCalCiEmsProperty extends CalcuateCiEmsProperty {
	
	/**
	 * 在执行计算开始时复制相关属性
	 * 
	 * @param t
	 * @throws BizException
	 */
	protected void beforeCalcuateCustomProperty(CiEmsDTO ciEms) throws BizException {
		// TODO Auto-generated method stub
		// CiEmsSrvDTO 中的出院带药标识作废
		ciEms.setFg_pres_outp(FBoolean.FALSE);	
	}

	/**
	 * 在执行计算结束后处理相关属性
	 * 
	 * @param t
	 * @throws BizException
	 */
	protected void afterCalcuateCustomProperty(CiEmsDTO ciEms) throws BizException {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 设置执行科室
	 * 
	 * @param ciEms
	 * @throws BizException
	 */
	protected void setMpDeptID(CiEmsDTO ciEms) throws BizException {

		MedSrvDO medSrv = medSrvMap.get(ciEms.getId_srv());
		OrWfDeptInfoDTO orWfDept = this.getMpDeptID(envinfo, medSrv);

		ciEms.setId_dep_mp(orWfDept.getFirstid_mp_dept());// 执行科室Id
		ciEms.setName_dep_mp(orWfDept.getFirstname_mp_dept());// 执行科室名称
	}

	/**
	 * 设置总次数
	 * 
	 * @param ciEms
	 * @throws BizException
	 */
	@Override
	protected void setCalTimesCur(CiEmsDTO ciEms) throws BizException {

		ciEms.setTimes_cur(1);
	}

	/**
	 * 设置在院执行状态
	 * 
	 * @param ciEms
	 * @return 是否在院执行
	 * @throws BizException
	 */
	@Override
	protected void setFgMpIn(CiEmsDTO ciEms) throws BizException {

		ciEms.setFg_mp_in(FBoolean.FALSE);
	}

	/**
	 * 设置在院执行次数
	 * 
	 * @param ciEms
	 * @throws BizException
	 */
	protected void setTimesMpIn(CiEmsDTO ciEms) throws BizException {

		if (ciEms.getFg_mp_in() == FBoolean.TRUE) {
			ciEms.setTimes_mp_in(ciEms.getTimes_cur());
		} else {
			ciEms.setTimes_cur(0);
		}
	}

	/**
	 * 设置服务价格
	 * 
	 * @param ciEms
	 * @throws BizException
	 */
	@Override
	protected void setCiEmsPrice(CiEmsDTO ciEms) throws BizException {

		MedSrvDO medSrv = medSrvMap.get(ciEms.getId_srv());
		FArrayList emssrvList = ciEms.getEmssrvs();
		CiEmsSrvDTO srvdto = (CiEmsSrvDTO) emssrvList.get(0);
		// 如果价格不为空，或者套内项目不进行价格计算
		if (srvdto.getPrice() != null) {
			return;
		}

		// 构造查询价格参数
		BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();
		param.setId_srv(medSrv.getId_srv());
		param.setName_srv(medSrv.getName());
		param.setId_primd(medSrv.getId_primd());
		// 如果是套，根据套内项目计算价格
		if (ciEms.getFg_set() == FBoolean.TRUE) {
			

			List<MedSrvSetItemDO> srvsetitmList = srvSetItemsMap.get(ciEms.getId_srv());
			FArrayList list = new FArrayList();
			
			// 获取计算几个的套内项目个数
			int clinicalBlCnt = 0;
			for (MedSrvSetItemDO medSrvSetItem : srvsetitmList) {
				
				// 非临床项目部调用价格计算是不传给费用接口
				if(medSrvSetItem.getFg_clinical() != FBoolean.TRUE){
					continue;
				}
				
				BdSrvPriCalParamDTO srvParamDTO = new BdSrvPriCalParamDTO();
				srvParamDTO.setId_primd(medSrv.getId_primd());
				srvParamDTO.setNum(1);
				srvParamDTO.setId_srv(medSrvSetItem.getId_srv_itm());
				
				// 诊疗项目中勾选临床价格计算标识的才计算个数
				if(medSrvSetItem.getFg_clinical_bl() == FBoolean.TRUE){
					clinicalBlCnt++;
				}
				
				list.add(srvParamDTO);
			}
			param.setNum(clinicalBlCnt);
			param.setSrvsetitms(list);
		}

		CiOrBdSrvPriceCalBP bp = new CiOrBdSrvPriceCalBP();
		FDouble price = bp.exec(param);
		srvdto.setPrice(price);

	}

	/**
	 * 设置备注
	 * 
	 * @param ciEms
	 */
	@Override
	protected void setCiEmsNote(CiEmsDTO ciEms) throws BizException {
	}

	/**
	 * 设置医疗单匹配结果
	 * 
	 * @param ciEms
	 * @throws BizException
	 */
	@Override
	protected void setEmsMatchRst(CiEmsDTO ciEms) throws BizException {

	}

	

	

}

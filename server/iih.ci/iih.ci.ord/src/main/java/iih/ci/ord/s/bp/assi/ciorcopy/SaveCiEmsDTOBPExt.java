package iih.ci.ord.s.bp.assi.ciorcopy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.moreemsdto.d.MoreEmsParamDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.validate.assi.CiEmsValidate;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class SaveCiEmsDTOBPExt {

	public static MoreEmsParamDTO SaveCiEmsDTO(CiEnContextDTO envinfo, CiEmsDTO[] ciEms) throws BizException {
		MoreEmsParamDTO param = new MoreEmsParamDTO();
		// 保存医嘱
		FMap2 Errormap2 = new FMap2();
		// 保存成功的医嘱
		FArrayList2 orderList = new FArrayList2();
		String Errorinfo = "";
		int num = 1;
		if (ciEms != null && ciEms.length > 0) {
			ICiOrdMaintainService orderMainService = ServiceFinder.find(ICiOrdMaintainService.class);
			for (CiEmsDTO EmsDTO : ciEms) {
				try {
					// TODO: 医疗单的校验：校验不通过的医疗单放入错误队列中
					List<String> errorList = new ArrayList<String>();
					CiEmsValidate bp = new CiEmsValidate();
					if (!bp.exec(EmsDTO, errorList)) {
						Errormap2.put(num + EmsDTO.getName() + new Date().getTime(), EmsDTO); // !!!暂时添加
						num++;
					} else {
						// 校验通过，则可以保存，保存不成功，或者保存存在异常，将其添加到错误队列中
						/*CiOrderDO ciOrder = orderMainService.SaveCiEmsDTO(EmsDTO);
						orderList.add(ciOrder);*/
						Errormap2.put(num + EmsDTO.getName() + new Date().getTime(), EmsDTO); // !
						num++;
					}

				} catch (Exception e) {
					num++;
					e.getMessage();
					Errorinfo += e.getMessage();
					Errormap2.put(num + e.getMessage(), EmsDTO); // 注意这行代码有错误：当两个医疗单发生相同的错误时候，最后一个发生错误的医疗单得到保存，前者会被覆盖
					continue;
				} finally {
					// Errormap2.put(EmsDTO.getName() + new Date().toString(),
					// EmsDTO); // !!!暂时添加
				}
			}
		}
		// 医嘱列表
		FMap2 Ordermap2 = new FMap2();
		/*String whereStr = " id_en ='" + envinfo.getId_en() + "'";
		CiOrderDO[] orders = CiOrdAppUtils.getOrQryService().find(whereStr, "id_en", FBoolean.FALSE);		
		FArrayList2 orderList = new FArrayList2();
		orderList.addAll(Arrays.asList(orders));*/
		Ordermap2.put("orders", orderList);
		param.setOrdermap2(Ordermap2);
		// 错误信息
		param.setErrormap2(Errormap2);
		param.setErrorinfo(Errorinfo);
		// 返回 成功的和本次就诊的医嘱和错误的信息

		return param;
	}

}

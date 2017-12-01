package iih.ci.ord.diag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.cidiag.i.ICidiagRService;
import iih.ci.mr.diainfodto.d.DiaInfoDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;
/**
 * 给电子病历接口，临床就诊诊断信息查询
 * @author wangqingzhu
 *
 */
@Service(serviceInterfaces = { ICiEnDiagInfoService.class }, binding = Binding.JSONRPC)
public class CiEnDiagInfoServiceImpl implements ICiEnDiagInfoService {

	@Override
	public DiaInfoDTO[] getCiEnDiagInfos(String id_en) throws BizException {
		// 1. 构建返回值变量
		List<DiaInfoDTO> rstDiaInfoList = new ArrayList<DiaInfoDTO>();
		// 2. 有效性判断
		if(CiOrdUtils.isEmpty(id_en)){
			return null;
		}
		// 诊断类型 
		// 3. 查询诊断数据
		CidiagAggDO[] szCidiagAggInfo = ServiceFinder.find(ICidiagRService.class).find(String.format(" id_en = '%s'", id_en), "sv desc", FBoolean.FALSE);
		// 4. 有效性判断
		if(szCidiagAggInfo == null || szCidiagAggInfo.length == 0){
			return null;
		}
		// 5. 取值当前最新诊断
		CidiagAggDO curDiagInfo = szCidiagAggInfo[0];
		if (curDiagInfo.getCiDiagItemDO() == null ||curDiagInfo.getCiDiagItemDO().length == 0){
			return null;
		}
		// 6. 组织数据
		UdidocDO[] szUdidocDO = ServiceFinder.find(IUdidocRService.class).find(String.format(" id_udidoclist = '%s'", ICiDictCodeConst.ID_process_udidoclist), "code desc", FBoolean.FALSE);
		Map<String,String> tmpUdidocCache = new HashMap<String,String>();
		if (null != szUdidocDO){
			for (UdidocDO o : szUdidocDO){
				tmpUdidocCache.put(o.getCode(), o.getName());
			}
		}
		for (CiDiagItemDO itemDiag : curDiagInfo.getCiDiagItemDO()){
			DiaInfoDTO diaInfo = new DiaInfoDTO();
			
			/**
			 * 诊断类别编码
			 * @param Code_dia_tp
			 */
			diaInfo.setCode_dia_tp(curDiagInfo.getParentDO().getSd_ditp());
			
			/**
			 * 诊断类别名称
			 * @param Dia_tp
			 */
			diaInfo.setDia_tp(tmpUdidocCache.containsKey(diaInfo.getCode_dia_tp())?tmpUdidocCache.get(diaInfo.getCode_dia_tp()):null);
			
			/**
			 * 诊断编码
			 * @param Code_dia
			 */
			diaInfo.setCode_dia(itemDiag.getId_didef_code());
			
			/**
			 * 诊断名称
			 * @param Dia
			 */
			diaInfo.setDia(itemDiag.getId_didef_name()) ;
			
			/**
			 * 诊断日期
			 * @param Dt_dia
			 */
			diaInfo.setDt_dia(curDiagInfo.getParentDO().getDt_di().getDate());
			
			/**
			 * 诊断描述
			 * @param Des
			 */
			diaInfo.setDes(itemDiag.getSupplement());
			
			/**
			 * 治疗结果编码
			 * @param Code_trre
			 */
			diaInfo.setCode_trre(null);
			
			/**
			 * 治疗结果名称
			 * @param Trre
			 */
			diaInfo.setTrre(null);
			
			// 加入数组中
			rstDiaInfoList.add(diaInfo);
		}
		
		// 返回值数组
		return rstDiaInfoList.toArray(new DiaInfoDTO[rstDiaInfoList.size()]);
	}

}

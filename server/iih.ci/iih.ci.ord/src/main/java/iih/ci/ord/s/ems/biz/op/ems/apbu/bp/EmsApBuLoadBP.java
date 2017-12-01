package iih.ci.ord.s.ems.biz.op.ems.apbu.bp;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.cior.i.ICiorappbtRService;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.d.ems.ems.EmsLoadDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.dto.d.CiordubDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsBaseLoadBP;
import iih.ci.ord.s.ems.biz.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.biz.utils.StringCodingUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 用血医疗单加载逻辑
 * @author wangqingzhu
 *
 */
public class EmsApBuLoadBP extends EmsBaseLoadBP {

	@Override
	public EmsRstDTO[] load(EmsLoadDTO[] args) throws BizException {
		EmsLoadDTO arg = args[0];
		EmsRstDTO[] rsts = super.load(args);
		EmsRstDTO rst = rsts[0];
		// 获取医疗单 DTO对象结构
		CiEmsDTO ciEmsInfo = ciEmsInfoFrom(arg.getId_or());
		if (null == ciEmsInfo){
			throw new BizException ("获取医疗单信息失败", CiOrdemsErrorCodeEnum.ERRORCODE_ORDER_ISNULL);
		}
		
		MedSrvDO med = ServiceFinder.find(IMedsrvRService.class).findById(ciEmsInfo.getId_srv()).getParentDO();
		CiordubDTO ems = ciOrdBuInfoFrom(arg.getEnContext(),ciEmsInfo);
        // 医疗单对象
        OrderEmsExtInfoUtils.SetCustomInfo(rst, ciEmsInfo);
        // 主服务对象
        OrderEmsExtInfoUtils.SetCustomInfo(rst, med);
        
        // 医疗单模型文档
       
        rst.setDocument(this.handleReturnDocument(ems));
//        rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(ems.serializeJson()));
        // 医疗单类型
        rst.setEmsDriver(EmsType.BTUSE.toString());
        return rsts;
	}

	
	protected CiordubDTO ciOrdBuInfoFrom(CiEnContextDTO ctx, CiEmsDTO dto) throws BizException {
		Object objOrdAppBtUseInfo = dto.getOrapplysheet().get((EmsType.BTUSE).toString());
		if (null == objOrdAppBtUseInfo){
			throw new BizException("获取用血申请单信息失败", CiOrdemsErrorCodeEnum.ERRORCODE_EMS_APPSHEET_NULL);
		}
        OrdAppBtUseDO odp = (OrdAppBtUseDO)objOrdAppBtUseInfo ;
        CiorappbtAggDO [] szBtInfo = ServiceFinder.find(ICiorappbtRService.class).find("a0.id_or='" + dto.getId_or_rel() + "'", null, FBoolean.FALSE);
        if (szBtInfo == null || szBtInfo.length == 0){
        	throw new BizException("获取备血申请单信息失败", CiOrdemsErrorCodeEnum.ERRORCODE_EMS_APPSHEET_NULL);
        }
        OrdApBtDO btInfo = szBtInfo[0].getParentDO();
        
        CiEmsSrvDTO mainSrvInfo = this.mainSrvInfoFrom(ctx,dto);
        CiordubDTO model = null;
        if (odp != null) {
        	model = new CiordubDTO();
            model.setNo_applyform_ub ( odp.getNo_applyform());
            model.setDt_bu_pl_ub (odp.getDt_bu_plan());
            model.setOrsrvname ( dto.getName());
            model.setId_srv ( dto.getId_srv());
            model.setName_unit ( mainSrvInfo.getName_unit_med());
            model.setQuan_medu_ub ( mainSrvInfo.getQuan_med());
            model.setId_unit ( mainSrvInfo.getId_unit_med());
            model.setId_route ( dto.getId_route());
            model.setName_route ( dto.getName_route());
            model.setStatus ( DOStatus.UPDATED);
            model.setId_apbu ( odp.getId_apbu());
            model.setName_emp_create ( dto.getName_emp_phy());
            model.setId_emp_create ( dto.getId_emp_phy());
            model.setId_or_rel ( dto.getId_or_rel());
            model.setId_mp_dep(mainSrvInfo.getId_dep());
            model.setName_mp_dep(mainSrvInfo.getName_dep());
            model.setDt_bt_pl(new FDate(btInfo.getDt_bt_pl()));
            model.setNum_margin_bu(btInfo.getNum_margin_bu());
            model.setQuan_medu(btInfo.getNum_margin_bu());
            model.setDes_or(dto.getNote());
            model.setApplyform(btInfo.getNo_applyform());
        }
        
        return model;

    }
	
}

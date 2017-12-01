package iih.ci.ord.s.ems.biz.op.emsv1.ris.bp;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.i.IMedSrvRisDORService;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.d.ems.ems.EmsLoadDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.dto.ems.uiemsdto.d.EmsRisViewDTO;
import iih.ci.ord.dto.ems.uiemsdto.d.EmsRisViewItemDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.meta.BdSrvRisPropMap;
import iih.ci.ord.s.ems.biz.meta.BdSrvSetItemMap;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvSetMap;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsBaseLoadBP;
import iih.ci.ord.s.ems.biz.utils.BdSrvInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检查医疗单加载逻辑
 * @author wangqingzhu
 *
 */
public class EmsRisLoadBP extends EmsBaseLoadBP {

	@Override
	public EmsRstDTO[] load(EmsLoadDTO[] args) throws BizException {
		EmsLoadDTO arg = args[0];
		EmsRstDTO[] rsts = super.load(args);
		EmsRstDTO rst = rsts[0];
		
		// 获取医疗单 DTO对象结构
		OrderPackageInfo[] szOrderPackageInfo = this.orderPakageInfoArrayFrom(new String[]{arg.getId_or()});
		if (CiOrdUtils.isEmpty(szOrderPackageInfo)){
			throw new BizException ("获取医疗单信息失败", CiOrdemsErrorCodeEnum.ERRORCODE_ORDER_ISNULL);
		}
		OrderPackageInfo opInfo = szOrderPackageInfo[0];
		
		EmsRisViewDTO ems = emsModelFrom(arg.getEnContext(),opInfo);
        
        // 主服务对象
        OrderEmsExtInfoUtils.SetCustomInfo(rst,opInfo.getBdSrvList().get(0));

        // 医疗单模型文档
        rst.setDocument(handleReturnDocument(ems));
         // 医疗单类型
        rst.setEmsDriver(EmsType.RIS.toString());
        return rsts;
	}

    protected  EmsRisViewDTO emsModelFrom(CiEnContextDTO ctx,OrderPackageInfo opInfo) throws BizException {
    	EmsRisViewDTO ems = new EmsRisViewDTO();
    	ems.setStatus(DOStatus.UPDATED);
        if (CiOrdUtils.isEmpty(opInfo.getOrderAppSheetList())){
        	throw new BizException("获取申请单信息失败", CiOrdemsErrorCodeEnum.ERRORCODE_EMS_APPSHEET_NULL);
        }
        
        OrdApObsDO apobs = (OrdApObsDO)opInfo.getOrderAppSheetList().get(0);
        ems.setId_or(opInfo.getOrderInfo().getId_or());
        ems.setId_srv ( opInfo.getOrderInfo().getId_srv());	                //服务id	SING  	
        ems.setName_srv ( opInfo.getBdSrvList().get(0).getName());//服务名称	SING 
        ems.setNo_applyform ( apobs.getNo_applyform());           //检查申请单号
        ems.setFg_urgent ( apobs.getFg_urgent());	            //加急标识	 	
        ems.setDt_plan ( apobs.getDt_plan());                //计划检查时间
        ems.setId_di ( apobs.getId_di());	                //诊断主项目id	  	 	
        ems.setName_di ( apobs.getName_diag());             //医疗单选择诊断的名称 
        ems.setSd_pps ( apobs.getSd_pps());	                //检查目的编码	
        ems.setId_pps ( apobs.getId_pps());	                //检查目的	
        ems.setDes_pps ( apobs.getDes_pps());                //检查目的描述	
        ems.setName_pps ( apobs.getName_pps());
        ems.setClinicalzztz ( apobs.getClinicalzztz());
        ems.setId_dep_mp ( opInfo.getOrderInfo().getId_dep_mp());
        ems.setName_dep_mp ( opInfo.getOrderInfo().getName_dep_mp());
        ems.setFg_set(opInfo.getOrderInfo().getFg_set()); 
        
        FArrayList emsRisViewItemList = new FArrayList();
        // 医疗服务套项目定义,用于展现检查申请单中的检查部位
        if (CiOrdUtils.isTrue(ems.getFg_set())) 
        {	
        	// 查询套内项目
        	MedSrvSetItemDO[] szMedSrvSetItem = BdSrvInfoUtils.QueryMedSrvSetItemBy(opInfo.getOrderInfo().getId_srv(), true) ;
            if (CiOrdUtils.isEmpty(szMedSrvSetItem)){
            	throw new BizException(String.format("服务套【%s】的套内项目为空，请到【诊疗项目】节点维护正确", opInfo.getBdSrvList().get(0).getName()),CiOrdemsErrorCodeEnum.ERRORCODE_ORDER_SETITEMS_NULL);
            }
            BdSrvSetItemMap bdSrvSetItemMap = new BdSrvSetItemMap(szMedSrvSetItem);
			// 获取套内项目的基础服务定义信息
            MedSrvDO[] szBdSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(bdSrvSetItemMap.asKeyString());
            // 字典化-套内项目
            OrderSrvSetMap tmpOrdSrvSetMap = opInfo.getOrderSrvSetList().asMap();
            
            MedSrvRisDO[] szMedSrvRisDO = ServiceFinder.find(IMedSrvRisDORService.class).findByAttrValStrings(MedSrvRisDO.ID_SRV, bdSrvSetItemMap.asKeyString());
            BdSrvRisPropMap bdSrvRisPropMap = new BdSrvRisPropMap(szMedSrvRisDO);
            // 构建检查套内项目列表数据源模型
            
            for (MedSrvDO bdSrvInfo : szBdSrvInfo)//检查部位
            {
      
            	emsRisViewItemList.add(emsRisViewItemInfoFrom(ctx,
            			bdSrvInfo,
            			bdSrvRisPropMap.get(bdSrvInfo.getId_srv()),
            			bdSrvSetItemMap.get(bdSrvInfo.getId_srv()),
            			tmpOrdSrvSetMap.get(bdSrvInfo.getId_srv()))
            			);
            }
              
            
        }
        else 
        {
        	MedSrvDO bdSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(opInfo.getOrderInfo().getId_srv());
        	MedSrvRisDO[] szMedSrvRisDO = ServiceFinder.find(IMedSrvRisDORService.class).findByAttrValString(MedSrvRisDO.ID_SRV, opInfo.getOrderInfo().getId_srv());
        	if (CiOrdUtils.isEmpty(szMedSrvRisDO)){
        		throw new BizException(String.format("服务【%s】检查属性内容为空", bdSrvInfo.getName()));
        	}
        	emsRisViewItemList.add(emsRisViewItemInfoFrom(ctx,bdSrvInfo,szMedSrvRisDO[0]));
        }
        ems.setEmsrisviewitems(emsRisViewItemList);
        // 计算价格
        ems.setPrice(this.calculatePrice(opInfo.getOrderSrvList()));
        
        return ems;
    }
    
    /**
	 * 非套项目时候，明细对象中的信息
	 * @param ctx
	 * @param bdSrvInfo
	 * @return
	 * @throws BizException
	 */
	protected EmsRisViewItemDTO emsRisViewItemInfoFrom(CiEnContextDTO ctx, MedSrvDO bdSrvInfo, MedSrvRisDO bdSrvRisInfo) throws BizException{
		
		EmsRisViewItemDTO emsRisViewItemInfo = new EmsRisViewItemDTO();
		emsRisViewItemInfo.setStatus(DOStatus.UPDATED);
		emsRisViewItemInfo.setFg_edit(FBoolean.FALSE);
		emsRisViewItemInfo.setFg_check(FBoolean.TRUE);
		emsRisViewItemInfo.setId_srv(bdSrvInfo.getId_srv());
		emsRisViewItemInfo.setName_srv(bdSrvInfo.getName());
		emsRisViewItemInfo.setId_primd(bdSrvInfo.getId_primd());
		emsRisViewItemInfo.setId_body(bdSrvRisInfo.getId_body());
		emsRisViewItemInfo.setName_body(bdSrvRisInfo.getName_body());
		emsRisViewItemInfo.setSd_body(bdSrvRisInfo.getSd_body());
		emsRisViewItemInfo.setId_pos(bdSrvRisInfo.getId_pos());
		emsRisViewItemInfo.setName_pos(bdSrvRisInfo.getName_pos());
		emsRisViewItemInfo.setSd_pos(bdSrvRisInfo.getSd_pos());
		
		return emsRisViewItemInfo;
	}
	
	/**
	 * 服务套时候，构建明细项目中的信息
	 * @param ctx
	 * @param bdSrvInfo
	 * @param medSrvSetItemDO
	 * @return
	 * @throws BizException
	 */
	protected EmsRisViewItemDTO emsRisViewItemInfoFrom(
			CiEnContextDTO ctx, 
			MedSrvDO bdSrvInfo,
			MedSrvRisDO bdSrvRisInfo, 
			MedSrvSetItemDO medSrvSetItemDO,
			OrdSrvSetDO ordSrvSetDO) throws BizException{
		EmsRisViewItemDTO emsRisViewItemInfo = new EmsRisViewItemDTO() ;
        
        // 部位id、编码、名称
		emsRisViewItemInfo.setId_body ( bdSrvRisInfo.getId_body());
		emsRisViewItemInfo.setSd_body ( bdSrvRisInfo.getSd_body());
		emsRisViewItemInfo.setName_body ( bdSrvRisInfo.getName_body());

        // 体位 Id、编码、名称
		emsRisViewItemInfo.setId_pos ( bdSrvRisInfo.getId_pos());
		emsRisViewItemInfo.setSd_pos ( bdSrvRisInfo.getSd_pos());
		emsRisViewItemInfo.setName_pos ( bdSrvRisInfo.getName_pos());   
        
		emsRisViewItemInfo.setId_srv ( bdSrvInfo.getId_srv());
		emsRisViewItemInfo.setName_srv ( bdSrvInfo.getName());
		emsRisViewItemInfo.setId_primd ( bdSrvInfo.getId_primd());
        
		emsRisViewItemInfo.setFg_check ( FBoolean.FALSE);
		emsRisViewItemInfo.setFg_edit (FBoolean.TRUE);
		emsRisViewItemInfo.setStatus(DOStatus.NEW);
        if (!CiOrdUtils.isEmpty(ordSrvSetDO)){
        	emsRisViewItemInfo.setId_or_srv(ordSrvSetDO.getId_orsrv());
        	emsRisViewItemInfo.setFg_check ( FBoolean.TRUE );
        	emsRisViewItemInfo.setFg_edit ( medSrvSetItemDO.getFg_edit());
        	emsRisViewItemInfo.setStatus(DOStatus.UPDATED);
        }
      
		return emsRisViewItemInfo;
	}
    
  
    /**
     * 计算医嘱临床价格
     * @param szOrdSrvInfo
     * @return
     * @throws BizException
     */
    protected FDouble calculatePrice(OrdSrvDO[] szOrdSrvInfo) throws BizException {
    	FDouble price = new FDouble(0);
  		for (OrdSrvDO ordSrvInfo : szOrdSrvInfo){
  			if (ordSrvInfo.getEu_sourcemd().equals(OrSrvSourceFromEnum.PHYSIAN)||
  					ordSrvInfo.getEu_sourcemd().equals(OrSrvSourceFromEnum.AGENTFROMPRIMD)||
  					ordSrvInfo.getEu_sourcemd().equals(OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD)) {
  				price = price.add(ordSrvInfo.getPri());
  			}
  		}
		return price;
  	}
    
}

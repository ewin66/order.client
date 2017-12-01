using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.medsrv.i;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.ciordems.d;
using iih.ci.ord_stub.i;
using xap.mw.serviceframework;
using iih.ci.ord.ems.d;
using iih.ci.ord.ciorder.d;
using iih.bd.srv.freqdef.i;
using iih.bd.srv.freqdef.d;
using iih.bd.bc.udi;
using iih.ci.ord.i;
using xap.rui.control.extentions;
using xap.sys.xbd.measdoc.d;
using xap.mw.core.data;
using iih.en.pv.dto.d;
using iih.ci.ord.common.utils;
using iih.bd.srv.ems.d;

namespace iih.ci.ord.ciorder.viewmodel {
    /// <summary>
    /// 
    /// zhou_zhijian 7.3做阅读注释
    /// </summary>
    class OrderSaveCommonViewModel {
        /// <summary>
        /// 
        /// </summary>
        private ICiOrdMaintainService ordMaintainService;
        /// <summary>
        /// 
        /// </summary>
        private IMedsrvMDOCrudService medSrvCrudService;
        /// <summary>
        /// 
        /// </summary>
        private ICiOrdQryService ciOrderQryService;
        /// <summary>
        /// 
        /// </summary>
        OrDataConvert model = new OrDataConvert();
        /// <summary>
        /// 
        /// </summary>
        CiEmsDTO dtoci = new CiEmsDTO();

        #region 构造
        public OrderSaveCommonViewModel() {
            ordMaintainService = XapServiceMgr.find<ICiOrdMaintainService>();
            this.medSrvCrudService = XapServiceMgr.find<IMedsrvMDOCrudService>();
            this.ciOrderQryService = XapServiceMgr.find<ICiOrdQryService>();
        } 
        #endregion

        public delegate void delegateBeforeSave(CiEmsDTO ems);

        public CiOrderDO SaveDTO(EmsUIDTO emsHeadDO, CiEmsDTO dto, int Eu_sourcemd,delegateBeforeSave OnBeforeSaveEms = null) {

            //保存前进行患者状态校验
            judgePatEntStatus(emsHeadDO.PatInfo);
            model.SaveCiDTO(emsHeadDO, dto, Eu_sourcemd);
            dto.Id_dept_ns = emsHeadDO.PatInfo.Id_dep_nur;
            //校验频次、剂量、剂量单位
            if (!LogicEx.GetInstance().validateBeforeSaveCiEmsDto(emsHeadDO, dto)) return null;
            //设置医保信息 后台获取医保目录类型的方法已经被注释掉了，前台在调用浪费时间 
            // LogicEx.GetInstance().setHpInfo(dto, emsHeadDO.PatInfo.Id_hp);
            //if (emsHeadDO.IsNEW && LogicEx.GetInstance().validateEmsUIDTO(dto))
            //{
            //    List<string> errorList = LogicEx.GetInstance().validateFreqAndUnitmed(dto);
            //    if (errorList.Count > 0)
            //    {
            //        string strErr = "";
            //        errorList.ForEach(
            //            p => { strErr += string.Format("{0}.{1}\n", errorList.IndexOf(p) + 1, p); });
            //        string errInfo = " 验证失败，操作取消！\n" + strErr;
            //        this.ShowInfo(errInfo, "提示:");
            //        return null;
            //    }
            //}
            if (OnBeforeSaveEms != null){
                OnBeforeSaveEms(dto);
            }
            return ordMaintainService.SaveCiEmsDTO(dto, CiEnContextUtil.GetCiEnContext(emsHeadDO.PatInfo, EmsAppModeEnum.IVEMSAPPMODE));
        }
       
        public MedSrvDO getMedSrvDO(String id_srv) {
            return this.medSrvCrudService.findById(id_srv);
        }

        private void judgePatEntStatus(Ent4BannerDTO PatInfo)
        {
            CiOrderDO ciorder = new CiOrderDO();
            ciorder.Code_entp = PatInfo.Code_entp;
            ciorder.Id_en = PatInfo.Id_ent;
            ciOrderQryService.JudgeOrderStatusInMultiUser(new CiOrderDO[] { ciorder }, PatInfo.Id_dep_phy,PatInfo.Id_dep_nur, CiDictCodeConst.ORD_VALIDATE_TYPE_OPEN);
        }
    }
}

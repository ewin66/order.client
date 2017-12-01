using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using iih.bd.fc.portallet.i;
using iih.ci.diag.cidiag.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.i;
using iih.ci.ord.cirptlab.d;
using iih.ci.ord.cirptlab.i;
using iih.ci.ord.cirptobs.d;
using iih.ci.ord.cirptobs.i;
using iih.ci.ord.dto.allergy.d;
using iih.ci.ord.dto.orderpandectemrdto.d;
using iih.ci.ord.dto.vitalsignsdto.d;
using iih.ci.ord.i;
using iih.ci.ord_stub.dto.d;
using Microsoft.SqlServer.Server;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.sys.custcfg.portallet.d;
using xap.sys.custcfg.portallet.i;
using xap.mw.core.data;

namespace iih.ci.ord.ciorder.viewmodel
{
    public class IpOverViewModel
    {
        private ICiorderMDOCrudService ciOrderService;
        private ICiOrdQryService qryService;
        private ICirptobsCrudService obsService;
        private ICiRptLabItmDOCrudService labItemService;
        public XapDataList<CiOrderDO> list = null;
        private IMatchscopeCrudService ImatchscopeCrudService;
        private IPortalletCrudService portalletCrudService;
 
        public IpOverViewModel()
        {
            ciOrderService = XapServiceMgr.find<ICiorderMDOCrudService>();
            qryService = XapServiceMgr.find<ICiOrdQryService>();
            obsService = XapServiceMgr.find<ICirptobsCrudService>();
            labItemService = XapServiceMgr.find<ICiRptLabItmDOCrudService>();
            this.ImatchscopeCrudService = XapServiceMgr.find<IMatchscopeCrudService>();
            this.portalletCrudService = XapServiceMgr.find<IPortalletCrudService>();
        }
        //医嘱
        public IpOverViewModel(string id_ent):this()
        {

             list = new XapDataList<CiOrderDO>();
            CiOrderDO[] ciorders = ciOrderService.find("a0.id_en = '" + id_ent + "'", "", FBoolean.False);
            if (ciorders != null && ciorders.Count() > 0)
            {
                int i = 1;
                foreach (CiOrderDO item in ciorders)
                {
                    item.Days_or = i;
                    list.Add(item);
                    i++;
                }
            }
        }

        /// <summary>
        /// 根据就诊 取得医嘱信息
        /// </summary>
        /// <param name="id_en"></param>
        /// <returns></returns>
        public XapDataList<CiOrderDO> GetCiOrderDataList(string id_ent)
        {

            list = new XapDataList<CiOrderDO>();
            CiOrderDO[] ciorders = ciOrderService.find("a0.id_en = '" + id_ent + "' and  a0.sd_su_or in ('10','20') ", " a0.dt_effe  ", FBoolean.False);
            if (ciorders != null && ciorders.Count() > 0)
            {
                int i = 1;
                foreach (CiOrderDO item in ciorders)
                {
                    item.Days_or = i;
                    list.Add(item);
                    i++;
                }
            }
            return list;
        }
        /// <summary>
        /// 临床路径信息
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        public String[] getHpcpBannerInfo(String id_ent)
        {
            return this.qryService.getHpcpBannerInfo(id_ent);
        }


        /// <summary>
        ///诊断信息
        /// </summary>
        /// <returns></returns>
        public XapDataList<IpViewDiagDTO> GetDiagDataList(string id_ent)
        {
            XapDataList<IpViewDiagDTO> list = new XapDataList<IpViewDiagDTO>();

            IpViewDiagDTO[] diagItem = qryService.getCiDiagItemDOList(id_ent, "");
           if (diagItem != null && diagItem.Count() > 0)
            {
                foreach (IpViewDiagDTO item in diagItem)
                {
                    list.Add(item);
                }
            }
            return list;
        }
        /// <summary>
        /// 检查数据
        /// </summary>
        /// <returns></returns>
        public IBindingList GetCiRptObsList(string id_ent)
        {


            IBindingList list = new BindingList<CiRptObsDO>();
            //CiRptObsDO[] cirptobs = obsService.find("a0.id_or = '" + id_or + "'", id_or, FBoolean.False);
            CiRptObsDO[] cirptobs =  qryService.getCiRptObsDO(id_ent);
            if (cirptobs != null && cirptobs.Count()>0)
            {
                foreach (CiRptObsDO obs in cirptobs)
                {
                    list.Add(obs);
                }
            }
            return list;

        }
        /// <summary>
        /// 检验数据
        /// </summary>
        /// <param name="Id_rptlab"></param>
        /// <returns></returns>
        public IBindingList getCiRptItemList(string id_ent)
        {
            IBindingList list = new BindingList<CiRptLabItmDO>();
            //CiRptLabItmDO[] labitems =  labItemService.find("a1.Id_rptlab = '" + Id_rptlab + "'", Id_rptlab,FBoolean.False);
            CirptlabAggDO[] aggs = qryService.getCirptlabAggDO(id_ent);
            if (aggs != null && aggs.Count() > 0)
            {
                
                foreach (CirptlabAggDO agg in aggs)
                {
                    foreach (CiRptLabItmDO item in agg.getCiRptLabItmDO())
                    {
                        list.Add(item);
                    }
                }

            }
            return list;
        }

        // 费用数据
        public String[] getBlcgAmtVsDrugRation(String id_pat, String id_ent, String codeSrv)
        {
             string[] amt  = null;
              amt =   this.qryService.getBlcgAmtVsDrugRation(id_pat, id_ent, codeSrv);
            return amt;
        }

        // 生命体征数据
        public VitalSignsDto getCiorderPreviewDTOS(String id_ent, string Dt_birth)
        {
            return this.qryService.getCiorderPreviewDTOS(id_ent, Dt_birth);
        }

        // 过敏史数据
        public BindingList<Object> getAllergyDto(String id_pat)
        {
            BindingList<Object> bingingList = new BindingList<Object>();
             AllergyDto[] allergy = this.qryService.getAllergyDto(id_pat);
            if (allergy != null && allergy.Count() > 0)
            {
                foreach (AllergyDto dto in allergy)
                {
                    bingingList.Add(dto);
                }
            }
            return bingingList;
        }



        public OrderPandectEmrDTO getOrderPandectEmrDTO(string code_entp, string id_ent)
        {
             
                OrderPandectEmrDTO[] oderPandectEmr =qryService.getOrderPandectEmrDTO(code_entp, id_ent);
                if (oderPandectEmr != null && oderPandectEmr.Count()>0)
                {
                    return oderPandectEmr[0];
                }
                return  null;

        }

        public PortalletDO getportXml(String id_port)
        {
            this.ImatchscopeCrudService.find("", "", FBoolean.False);
           return  this.portalletCrudService.findById("0001AA1000000008TQDI"); // ##????
        }

        /// <summary>
        /// 获得首末次病程数据
        /// </summary>
        /// <param name="idEnt"></param>
        /// <returns></returns>
        public FMap2 getEndEmrData(string idEnt,FBoolean firstMr)
        {
            return this.qryService.getCiMrCourseOfLastDisease(idEnt, firstMr);
        }
    }
}

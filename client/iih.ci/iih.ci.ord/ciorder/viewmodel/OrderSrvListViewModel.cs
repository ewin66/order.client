using System;
using System.Collections.Generic;
using System.Linq;
using iih.bd.srv.medsrv.d;
using xap.rui.appfw;
using iih.bd.srv.medsrv.i;
using xap.mw.serviceframework;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.i;
using iih.ci.ord.ordsrvmm.d;
using iih.ci.ord.ordsrvmm.i;
using xap.mw.coreitf.d;
using xap.sys.xbd.udi.d;
using xap.sys.xbd.udi.i;
using iih.ci.ord.ciorder.utils;
using xap.cli.context;
using iih.bd.bc.udi;

namespace iih.ci.ord.ciorder.viewmodel {
    /// <summary>
    /// 医嘱服务项目查询
    /// zhou_zhijian 7.3做阅读注释
    /// </summary>
    public class OrderSrvListViewModel {
        private IMedsrvMDOCrudService service;
        private IUdidocCrudService udidocService;
        private IOrdsrvmmCrudService serviceMm;
        private ICiOrdQryService qryService;
        public XapDataList<EmsOrSrvSc> ScResultList { get; set; }
        public Dictionary<object, string> srvtps = new Dictionary<object, string>();

        public OrderSrvListViewModel(string strWhere) {
            service = XapServiceMgr.find<IMedsrvMDOCrudService>();
            udidocService = XapServiceMgr.find<IUdidocCrudService>();
            serviceMm = XapServiceMgr.find<IOrdsrvmmCrudService>();

            qryService = XapServiceMgr.find<ICiOrdQryService>();

            this.GetSrvtp();

        }

        public MedSrvDO GetSrvById(string id_srv) {
            return service.findById(id_srv);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sd_srvtp"></param>
        /// <param name="strWhere"></param>
        /// <param name="isHos">数据来源</param>
        /// <returns></returns>
        public XapDataList<EmsOrSrvSc> GetSrv(string sd_srvtp, string strWhere, string code_entp) {
            if (service == null) {
                service = XapServiceMgr.find<IMedsrvMDOCrudService>();
            }
            ScResultList = new XapDataList<EmsOrSrvSc>();

            ScResultList = qryService.getEmsOrSrvSc(sd_srvtp, strWhere.ToUpper(), "", code_entp);

            return ScResultList;

            //if (EnDictCodeConst.SD_ENTP_OUTPATIENT.Equals(code_entp))
            //{
            //    return (XapDataList<EmsOrSrvSc>)(ScResultList.Where(p => p.MedSrvDO.Fg_use_op.Value).ToArray());
            //}
            //return (XapDataList<EmsOrSrvSc>)(ScResultList.Where(p => p.MedSrvDO.Fg_use_ip.Value).ToArray());
        }

        //获得所有服务分类
        public void GetSrvtp() {
            UdidocDO[] udidos = this.udidocService.find("id_udidoclist='" + CiDictCodeConst.SD_CI_UIDOC_SRVTP_ID + "' and id_parent='~'", "code", FBoolean.False);
            srvtps.Add("", "全部");
            foreach (UdidocDO udido in udidos) {
                srvtps.Add(udido.Code, udido.Name);
            }
        }


        public XapDataList<EmsOrDrug> GetBdSrvMM(string id_srv) {
            XapDataList<EmsOrDrug> list = new XapDataList<EmsOrDrug>();
            OrdSrvMmDO[] srvmms = serviceMm.find("a0.id_orsrv = '" + id_srv + "'", "", false);

            if (srvmms != null && srvmms.Count() > 0) {
                foreach (OrdSrvMmDO srvmm in srvmms) {

                    EmsOrDrug drug = new EmsOrDrug();

                    drug.Id_mm = srvmm.Id_mm;
                    drug.Id_mmtp = srvmm.Id_mmtp;
                    drug.Name_mm = srvmm.Name_mm;
                    drug.Spec_mm = "";
                    drug.Des = srvmm.Ds_name;
                    //todo
                    list.Add(drug);
                }

            }

            return list;

        }


    }
}

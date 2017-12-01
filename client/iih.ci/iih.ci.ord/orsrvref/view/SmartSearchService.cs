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
using iih.ci.ord.srvref.d;

namespace iih.ci.ord.orsrvref.view
{
    class SmartSearchService
    {

        private ICiSrvRefResultService srvRefService;
        private IUdidocCrudService udidocService;

        //private IMedsrvMDOCrudService service;
        //private IOrdsrvmmCrudService serviceMm;
        //private ICiOrdQryService qryService;
       
        public XapDataList<EmsOrSrvSc> ScResultList { get; set; }
        public Dictionary<object, string> srvtps = new Dictionary<object, string>();

        public SmartSearchService()
        {
            // 医嘱服务查询接口
            srvRefService = XapServiceMgr.find<ICiSrvRefResultService>();
            //数据字典服务
            udidocService = XapServiceMgr.find<IUdidocCrudService>();

            //service = XapServiceMgr.find<IMedsrvMDOCrudService>();
            //serviceMm = XapServiceMgr.find<IOrdsrvmmCrudService>();
            //qryService = XapServiceMgr.find<ICiOrdQryService>();

            this.GetSrvtp();

        }

        //获得所有服务类型
        public void GetSrvtp()
        {
            UdidocDO[] udidos = this.udidocService.find("id_udidoclist='0001ZZ2000000000000T' and id_parent='~'", "code", FBoolean.False);

            srvtps.Add("", "全部");
            foreach (UdidocDO udido in udidos)
            {
                srvtps.Add(udido.Code, udido.Name);
            }
        }

        /// <summary>
        /// 获取医嘱服务查询结果
        /// </summary>
        /// <param name="srvCa">医嘱服务分类</param>
        /// <param name="inputStr">界面输入的查询条件</param>
        /// Author:hums
        /// Date:2016-05-10
        public XapDataList<CiSrvRefResultDTO> getSrvRefData(CiSrvRefParamDTO paramDto)
        {

            //paramDto.setAttrVal("Sd_srvtp", srvCa);
            //paramDto.setAttrVal("Inputstr", inputStr);
            //paramDto.setAttrVal("Id_billform", this.formId);

            CiSrvRefResultDTO[] resultDtos = srvRefService.getSrvRefResult(paramDto);
            return (XapDataList<CiSrvRefResultDTO>)resultDtos;
        }



        //public MedSrvDO GetSrvById(string id_srv)
        //{
        //    return service.findById(id_srv);
        //    return null;
        //}

      /// <summary>
      /// 
      /// </summary>
      /// <param name="sd_srvtp"></param>
      /// <param name="strWhere"></param>
      /// <param name="isHos">数据来源</param>
      /// <returns></returns>
        public XapDataList<EmsOrSrvSc> GetSrv(string sd_srvtp, string strWhere)
        {
            XapDataList<EmsOrSrvSc> list = new XapDataList<EmsOrSrvSc>();
            return list;

            //if (service == null)
            //{
            //    service = XapServiceMgr.find<IMedsrvMDOCrudService>();
            //}
            //ScResultList = new XapDataList<EmsOrSrvSc>();

            //ScResultList = qryService.getEmsOrSrvSc(sd_srvtp, strWhere.ToUpper(), "");
            //if (!OrdParam.GetOrdParam.isHos)
            //{
            //    return (XapDataList<EmsOrSrvSc>)(ScResultList.Where(p => p.MedSrvDO.Fg_use_op.Value).ToArray());
            //}
            //return (XapDataList<EmsOrSrvSc>)(ScResultList.Where(p => p.MedSrvDO.Fg_use_ip.Value).ToArray());
        }

       


        public XapDataList<EmsOrDrug>  GetBdSrvMM(string id_srv)
        {
            XapDataList<EmsOrDrug> list = new XapDataList<EmsOrDrug>();
            //OrdSrvMmDO[] srvmms = serviceMm.find("a0.id_orsrv = '" + id_srv + "'", "", false);

            //if (srvmms != null && srvmms.Count() > 0)
            //{
            //    foreach (OrdSrvMmDO srvmm in srvmms)
            //    {

            //        EmsOrDrug drug = new EmsOrDrug();

            //        drug.Id_mm = srvmm.Id_mm;
            //        drug.Id_mmtp = srvmm.Id_mmtp;
            //        drug.Name_mm = srvmm.Name_mm;
            //        drug.Spec_mm = "";
            //        drug.Des = srvmm.Ds_name;
            //        //todo
            //        list.Add(drug);
            //    }

            //}

            return list;

        }

    }
    
}

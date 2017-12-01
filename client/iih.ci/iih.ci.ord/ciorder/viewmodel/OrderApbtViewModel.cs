using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.medsrv.i;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.i;
using iih.ci.ord_stub.service.i;
using xap.mw.serviceframework;
using xap.mw.core.data;
using xap.rui.appfw;
using iih.bd.srv.service.i;
using iih.bd.srv.ems.d;
using iih.bd.srv.ems.i;
using iih.bd.srv.dto.d;

namespace iih.ci.ord.ciorder.viewmodel
{

    /// <summary>
    /// 备血单获取数据DTO
    /// </summary>
    /// Author:admin
    /// Date:2015-08-31
    public class OrderApbtViewModel
    {

        private IBdSrvQryService qryservice;

        private IEmsregistryMDOCrudService MDORService;

        private IEmsRelSrvDOCrudService registryCrudService;

        public OrderApbtViewModel()
        {
            qryservice = XapServiceMgr.find<IBdSrvQryService>();
            MDORService = XapServiceMgr.find<IEmsregistryMDOCrudService>();
            registryCrudService = XapServiceMgr.find<IEmsRelSrvDOCrudService>();
        }
        public EmsDynamicIndexDTO[] getEmsDynamicIndexInfos(EmsUIDTO emsUIDTO,string id_srvof)
        {
                    EmsDO emsDo = MDORService.findById(id_srvof);

                    bool? fg_dyncitm_en = emsDo.Fg_dyncitm_crossentp;

                    int? eu_dyncitmunit = emsDo.Eu_dyncitmunit;

                    int? dyncitmunitct = emsDo.Cnt_dyncitmunit;

                    string id_ent = emsUIDTO.PatInfo.Id_ent;

                    string id_pat = emsUIDTO.PatInfo.Id_pat;

                    EmsDynamicParamDTO paramDto = new EmsDynamicParamDTO();
                    paramDto.Id_ems = id_srvof;
                    paramDto.Fg_dyncitm_en = fg_dyncitm_en;
                    paramDto.Eu_dyncitmunit = eu_dyncitmunit;
                    paramDto.Id_ent = id_ent;
                    paramDto.Id_pat = id_pat;
                    paramDto.Dyncitmunitct = dyncitmunitct;
                    return qryservice.getEmsDynamicIndexInfos(paramDto);

        }
        public EmsDynamicIndexDTO[] getEmsDynamicIndexInfos1(EmsUIDTO emsUIDTO)
        {
            string sql = string.Format("(a1.id_srv='{0}' or a1.id_srvtp='{1}')", emsUIDTO.MedSrvDO.Id_srv, emsUIDTO.MedSrvDO.Id_srvtp);
            EmsRelSrvDO[] relsrv = registryCrudService.find(sql, "", false);
            if (relsrv != null && relsrv.Length > 0)
            {
                if (relsrv != null && relsrv.Length > 0)
                {
                    EmsDO emsDo = MDORService.findById(relsrv[0].Id_srvof);

                    bool? fg_dyncitm_en = emsDo.Fg_dyncitm_crossentp;

                    int? eu_dyncitmunit = emsDo.Eu_dyncitmunit;

                    int? dyncitmunitct = emsDo.Cnt_dyncitmunit;

                    string id_ent = emsUIDTO.PatInfo.Id_ent;

                    string id_pat = emsUIDTO.PatInfo.Id_pat;

                    EmsDynamicParamDTO paramDto = new EmsDynamicParamDTO();
                    paramDto.Id_ems = relsrv[0].Id_srvof;
                    paramDto.Fg_dyncitm_en = fg_dyncitm_en;
                    paramDto.Eu_dyncitmunit = eu_dyncitmunit;
                    paramDto.Id_ent = id_ent;
                    paramDto.Id_pat = id_pat;
                    paramDto.Dyncitmunitct = dyncitmunitct;
                    return qryservice.getEmsDynamicIndexInfos(paramDto);
                }
                else
                {
                    return null;
                }
            }
            else {
                return null;
            }
            

            
        }
    }
}

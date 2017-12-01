
using iih.bd.srv.dto.d;
using iih.bd.srv.ems.d;
using iih.bd.srv.ems.i;
using iih.bd.srv.service.i;
using iih.ci.ord.ciordems.d;
using xap.mw.serviceframework;

namespace iih.ci.ord.opemergency.viewmodel
{
    public class PreBloodCardViewModel
    {

        private IBdSrvQryService qryservice;

        private IEmsregistryMDOCrudService MDORService;

        private IEmsRelSrvDOCrudService registryCrudService;

        public PreBloodCardViewModel()
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
            else
            {
                return null;
            }
        }
    }
}

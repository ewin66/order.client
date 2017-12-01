using System;
using iih.bd.srv.ortpl.d;
using iih.bd.srv.ortpl.i;
using xap.mw.serviceframework;
using System.Collections.Generic;
using iih.ci.ord.dto.newordertemplatedto.d;
using iih.ci.ord.i;
using xap.mw.coreitf.d;

namespace iih.ci.ord.doctorhelper.newtemplate.viewmodel
{
    public  class NewOrderTemplateListViewModel
    {
        private IOrTplNItmDOCrudService itemSservice;
        private IOrtmplMDOCrudService mDOCrudService;
        public OrTplNItmDO[] ortplitems;

        public NewOrderTemplateDTO[] newOrderTemplate;

        private ICiOrdQryService ordQryService;
        public NewOrderTemplateListViewModel(String id_ortmpl)
        {
            this.itemSservice = XapServiceMgr.find<IOrTplNItmDOCrudService>();
            this.mDOCrudService = XapServiceMgr.find<IOrtmplMDOCrudService>();
            this.ordQryService = XapServiceMgr.find<ICiOrdQryService>();
            if (!string.IsNullOrWhiteSpace(id_ortmpl))
            {
                this.ortplitems = getOrTplNItmDOs(id_ortmpl);
                this.newOrderTemplate = ordQryService.getNewOrderTemplateDTO(id_ortmpl);
            }
            else
            {
                this.ortplitems = null;
            }
        }

        private OrTplNItmDO[] getOrTplNItmDOs(string id_ortmpl)
        {
            OrTplNItmDO[] itemDOs = this.itemSservice.find("id_ortmpl ='" + id_ortmpl + "'", "", false);

            //针对医嘱模板明细的服务项目是参照bd_srv表，如果明细引用的是基础模板，从bd_srv得不到相关数据，这里查询基础模板信息并赋值
            OrTmplDO[] dos = null;
            Dictionary<string, OrTmplDO> dic = new Dictionary<string, OrTmplDO>();
            List<string> lstItemIDs = new List<string>();
            if (itemDOs != null && itemDOs.Length > 0)
            {
                for (int i = 0; i < itemDOs.Length; i++)
                {
                    if (itemDOs[i].Eu_ortplitmtp == (int)OrTplItmTypeEnum.ORTMPL)
                    {
                        lstItemIDs.Add(itemDOs[i].Id_srv);
                    }
                }
            }

            if (lstItemIDs.Count > 0)
            {
                dos = mDOCrudService.findByIds(lstItemIDs.ToArray(), FBoolean.False);

                foreach (var itm in dos)
                {
                    dic.Add(itm.Id_ortmpl, itm);
                }

                for (int i = 0; i < itemDOs.Length; i++)
                {
                    if (itemDOs[i].Eu_ortplitmtp != (int)OrTplItmTypeEnum.ORTMPL)
                        continue;
                    OrTmplDO mplDO = dic[itemDOs[i].Id_srv];
                    itemDOs[i].Ortplnitm_srv_code = mplDO.Code;
                    itemDOs[i].Ortplnitm_srv_name = mplDO.Name;

                    itemDOs[i].Id_route = mplDO.Id_route;
                    itemDOs[i].Ortplnitm_route_code = mplDO.Ortmpl_route_code;
                    itemDOs[i].Ortplnitm_route_name = mplDO.Ortmpl_route_name;

                    itemDOs[i].Id_routedes = mplDO.Id_routedes;
                    itemDOs[i].Ortplnitm_routedes_code = mplDO.Ortmpl_routedes_code;
                    itemDOs[i].Ortplnitm_routedes_name = mplDO.Ortmpl_routedes_name;

                    itemDOs[i].Id_boil = mplDO.Id_boil;
                    itemDOs[i].Ortplnitm_boil_code = mplDO.Ortmpl_boil_code;
                    itemDOs[i].Ortplnitm_boil_name = mplDO.Ortmpl_boil_name;

                    itemDOs[i].Id_boildes = mplDO.Id_boildes;
                    itemDOs[i].Ortplnitm_boildes_code = mplDO.Ortmpl_boildes_code;
                    itemDOs[i].Ortplnitm_boildes_name = mplDO.Ortmpl_boildes_name;

                    itemDOs[i].Id_freq = mplDO.Id_freq;
                    itemDOs[i].Ortplnitm_freq_code = mplDO.Ortmpl_freq_code;
                    itemDOs[i].Ortplnitm_freq_name = mplDO.Ortmpl_freq_name;
                }
            }

            return itemDOs;
        }

    }
}
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.dto.d;
using iih.bd.srv.mrcamctmserviceext.i;
using iih.bd.srv.mrctmca.d;
using iih.ci.mr.cimr.d;
using iih.ci.mr.cimr.i;
using iih.ci.mr.mrserviceext.i;
using xap.mw.serviceframework;
using xap.rui.control.tree.otree.data;
using xap.rui.control.tree.otree.loader;
using xap.rui.control.tree.otree.model;

namespace iih.ci.ord.ciordcons.viewmodel
{
    public class ConsMrTreeViewModel
    {
        #region 变量定义区域

        private IMrcamctmServiceExt service;
        private IMrServiceExt _mrService;
        private MrCaCtmMrDTO[] _mrCaCtmMrArr;
        private MrDTO[] _mrDtoArr;
        private ICiemrCrudService ciemrCrudService;
        public TreeKeyModel<MrCaCtmMrDTO> TreeModel1;
        public TreeKeyModel<MrDTO> TreeModel2;

        #endregion

        #region 变量定义区域

        public ConsMrTreeViewModel(string id_ent)
        {
            this.service = XapServiceMgr.find<IMrcamctmServiceExt>();
            _mrCaCtmMrArr = service.getMrcactm(id_ent, "10", 0, "10");

            this._mrService = XapServiceMgr.find<IMrServiceExt>();
            _mrDtoArr = _mrService.GetMrDtoForTree(id_ent, "%", "10", "0", ((int)(docornur.DOCTOR)).ToString());
            KeyNodeDataAdapterFactory<MrCaCtmMrDTO> adapter1 =
                new KeyNodeDataAdapterFactory<MrCaCtmMrDTO>("Id_mrcactm") { CustomCaptionFunc = dataobj => string.Format("{0}", dataobj.Name + "(" + dataobj.Mr_count + ")") };
            KeyNodeDataAdapterFactory<MrDTO> adapter2 =
                new KeyNodeDataAdapterFactory<MrDTO>("Id_mr", "", "Id_mrcactm") { CustomCaptionFunc = dataobj => string.Format("{0}", dataobj.Name) };

            TreeModel1 = new TreeKeyModel<MrCaCtmMrDTO>(adapter1);
            this.TreeModel1.Loader = new OTreeKeyLoader();
            TreeModel2 = new TreeKeyModel<MrDTO>(adapter2);
            this.TreeModel2.Loader = this.TreeModel1.Loader;
            TreeModel1.AddRange(_mrCaCtmMrArr);
            TreeModel2.AddRange(_mrDtoArr);
        }

        #endregion

        #region 变量定义区域

        public CiMrDO GetCiMrDo(string id_mr)
        {
            ciemrCrudService = XapServiceMgr.find<ICiemrCrudService>();
            CiMrDO mrDo = ciemrCrudService.findById(id_mr);
            return mrDo;
        }

        #endregion
    }
}

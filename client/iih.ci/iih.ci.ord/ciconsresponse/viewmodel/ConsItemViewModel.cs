using System;
using System.Linq;
using xap.rui.appfw;
using xap.rui.control.tree.otree.data;
using xap.rui.control.tree.otree.loader;
using xap.rui.control.tree.otree.model;
using iih.ci.ord.cior.d;
using iih.ci.ord.cior.i;
using iih.ci.ord.consrpt.d;
using iih.ci.ord.consrpt.i;
using iih.ci.ord.i;
using iih.ci.ord_stub.i;
using xap.mw.serviceframework;
using xap.rui.appfw.collections;

namespace iih.ci.ord.ciconsresponse.viewmodel
{
    internal class ConsItemViewModel
    {
        private ApConsViewModel apvm = new ApConsViewModel();
        public XapDataList<OrdApConsDO> consItems { get; set; }
        public TreeKeyModel<OrdApConsDO> TreeModel;
        public ICiOrdQryService QryService;
        private ICiorappconsultCrudService consAggService;
        private ICiOrdMaintainService saveService;
        private IConsrptCrudService rptService;

        public ConsItemViewModel(String id_ent)
        {
            QryService = XapServiceMgr.find<ICiOrdQryService>();
            consAggService = XapServiceMgr.find<ICiorappconsultCrudService>();
            saveService = XapServiceMgr.find<ICiOrdMaintainService>();
            this.rptService = XapServiceMgr.find<IConsrptCrudService>();
            OrdApConsDO[] ordappcons = QryService.getTreeOrdApConsDO(id_ent);
            //consItems = new XapDataList<OrdApConsDO>();
            XapDataList<OrdApConsDO> list = new XapDataList<OrdApConsDO>();
            ordappcons.ToList().ForEach(p => { list.Add(p); });
            //consItems= apvm.GetApConsItem();

            KeyNodeDataAdapterFactory<OrdApConsDO> moduleAdapter =
                new KeyNodeDataAdapterFactory<OrdApConsDO>("Id_apcons");
            moduleAdapter.CustomCaptionFunc =
                (dataobj => dataobj.Name_constp + "(" + dataobj.Dt_plan.Value.ToString("yy-MM-dd HH:mm") + ")");

            this.TreeModel = new TreeKeyModel<OrdApConsDO>(moduleAdapter);
            this.TreeModel.Loader = new OTreeKeyLoader();
            this.TreeModel.AddRange(list);
        }

        public XapAggDO<CiorappconsultAggDO> GetAggDo(string id)
        {
            CiorappconsultAggDO aggdo = consAggService.findById(id);
            if (aggdo == null) return null;
            return new XapAggDO<CiorappconsultAggDO>(consAggService, aggdo);
        }

        public void CompleteCons(CiorappconsultAggDO aggDo)
        {
            aggDo.SetUpdated();
            aggDo.ParentDO.SetUpdated();
            CiorappconsultAggDO result=saveService.SaveCompleteConsultAggDO(new CiorappconsultAggDO[] {aggDo});
        }

        public CiOrdConsRptDO findRpt(string id_apcons)
        {
            CiOrdConsRptDO[] rptDo = this.rptService.find(" id_apcons='" + id_apcons + "'", null, null);
            if (rptDo.Length==0) return null;
            else return rptDo[0];
        }
    }
}


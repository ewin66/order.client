using System.Collections.Generic;
using System.Linq;
using iih.bd.srv.srvcate.d;
using iih.bd.srv.srvcate.i;
using iih.ci.ord.dto.orobsandlab.d;
using iih.ci.ord.i;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.control.tree.otree.data;

namespace iih.ci.ord.cilab.viewmodel
{
    public class LabTreeModel
    {
        private readonly ICiOrdQryService service;
        private readonly ISrvcateCrudService srvcateMservice;

        public LabTreeModel(string ent, string type)
        {
            srvcateMservice = XapServiceMgr.find<ISrvcateCrudService>();
            service = XapServiceMgr.find<ICiOrdQryService>();
            loadObsDate(ent, type);
        }

        public OrObsAandLabDTO[] OrObsAandLab { get; set; }
        public KeyNodeDataCollection ObsDateCollection { get; set; }
        public KeyNodeDataCollection SrvCaCollection { get; set; }

        private void loadObsDate(string ent, string type)
        {
            OrObsAandLab = service.getOrObsAandLabDTO(ent, type);
            if (OrObsAandLab == null || OrObsAandLab.Length == 0)
                return;
            List<string> pids = OrObsAandLab.Select(p => p.Parent).ToList();
            if (pids == null || pids.Count == 0)
                return;
            string filter = "";
            foreach (string s in pids)
            {
                filter += ("'" + s + "',");
            }

            SrvCateDO[] srvcados = srvcateMservice.find(
                "a0.id_srvca in (" + filter.Substring(0, filter.Count() - 1) + ")", "", FBoolean.False);


            var myModuleAdapter = new KeyNodeDataAdapterFactory<OrObsAandLabDTO>("Id", "Parent");
            myModuleAdapter.CustomCaptionFunc = x => x.Name + "(" + x.Dtor.ToString() + ")";
            ObsDateCollection = myModuleAdapter.ToKeyNodeDataCollection(OrObsAandLab);

            var srvcaAdapter = new KeyNodeDataAdapterFactory<SrvCateDO>("Id_srvca", "Id_srvca");
            srvcaAdapter.CustomCaptionFunc = x => x.Name;
            SrvCaCollection = srvcaAdapter.ToKeyNodeDataCollection(srvcados);
        }
    }
}
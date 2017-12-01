using System.Collections.Generic;
using System.Linq;
using iih.bd.srv.srvcate.d;
using iih.bd.srv.srvcate.i;
using iih.ci.ord.i;
using iih.ci.ord.ordappathgy.d;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.control.tree.otree.data;

namespace iih.ci.ord.opippathgy.viewmodel
{
    public class OpippathgyTreeModel
    {
        private readonly ICiOrdQryService service;
        private readonly ISrvcateCrudService srvcateMservice;

        public OpippathgyTreeModel(string ent)
        {
            srvcateMservice = XapServiceMgr.find<ISrvcateCrudService>();
            service = XapServiceMgr.find<ICiOrdQryService>();
            LoadData(ent);
        }

        public KeyNodeDataCollection ObsDateCollection { get; set; }
        public KeyNodeDataCollection SrvCaCollection { get; set; }


        public void LoadData(string ent)
        {
            if (ent != null)
            {
                OrdApPathgyDTO[] apPathgyDtos = this.service.getPathgyList(ent);
                SrvCateDO[] srvcados = getCateDos(apPathgyDtos);

                var myModuleAdapter = new KeyNodeDataAdapterFactory<OrdApPathgyDTO>("Id_appathgy", "Id_srvca");
                myModuleAdapter.CustomCaptionFunc = x => x.Name + "(" + x.Dt_effe.ToString().Split(' ')[0] + ")";
                ObsDateCollection = myModuleAdapter.ToKeyNodeDataCollection(apPathgyDtos);

                var srvcaAdapter = new KeyNodeDataAdapterFactory<SrvCateDO>("Id_srvca", "Id_srvca");
                srvcaAdapter.CustomCaptionFunc = x => x.Name;
                SrvCaCollection = srvcaAdapter.ToKeyNodeDataCollection(srvcados);
            }
        }

        private SrvCateDO[] getCateDos(OrdApPathgyDTO[] apPathgyDtos)
        {
           string[] pids = apPathgyDtos.Select(p => p.Id_srvca).ToArray();
            if (pids == null || pids.Length == 0)
                return null;
            //string filter = "";
            //foreach (string s in pids)
            //{
            //    filter += ("'" + s + "',");
            //}

            SrvCateDO[] srvcados = srvcateMservice.findByIds(pids, FBoolean.False);
            return srvcados;
        }
     
    }
}
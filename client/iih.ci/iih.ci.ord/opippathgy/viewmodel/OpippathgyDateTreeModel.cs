using System.Collections.Generic;
using iih.ci.ord.dto.orobsandlab.d;
using iih.ci.ord.i;
using iih.ci.ord.ordappathgy.d;
using xap.mw.serviceframework;
using xap.rui.control.tree.otree.data;

namespace iih.ci.ord.opippathgy.viewmodel
{
    public class OpippathgyDateTreeModel
    {
        private readonly ICiOrdQryService service;
        public Dictionary<string, KeyNodeDataCollection> treedict = new Dictionary<string, KeyNodeDataCollection>();

        public OpippathgyDateTreeModel(string ent)
        {
            service = XapServiceMgr.find<ICiOrdQryService>();
            loadObsDate(ent);
        }

        public OrdApPathgyDTO[] OrApPathgyDate { get; set; }

        private void loadObsDate(string ent)
        {
            var dict = new Dictionary<string, List<OrdApPathgyDTO>>();
            OrApPathgyDate = this.service.getPathgyList(ent);

            foreach (OrdApPathgyDTO pathgyDto in OrApPathgyDate)
            {
                if (dict.ContainsKey(pathgyDto.Dt_effe.Value.ToString().Substring(0, 10)))
                {
                    List<OrdApPathgyDTO> list = dict[pathgyDto.Dt_effe.Value.ToString().Substring(0, 10)];
                    list.Add(pathgyDto);
                }
                else
                {
                    var list = new List<OrdApPathgyDTO>();
                    list.Add(pathgyDto);
                    dict.Add(pathgyDto.Dt_effe.Value.ToString().Substring(0, 10), list);
                }
            }
           
            var listkey = new List<string>();
            listkey.AddRange(dict.Keys);
            foreach (string s in listkey)
            {
                List<OrdApPathgyDTO> list = dict[s];
                var myModuleAdapter = new KeyNodeDataAdapterFactory<OrdApPathgyDTO>("Id_appathgy", "Id_srvca");
                myModuleAdapter.CustomCaptionFunc = x => x.Name + "(" + x.Dt_effe.ToString().Split(' ')[0] + ")";
                KeyNodeDataCollection ObsDateCollection = myModuleAdapter.ToKeyNodeDataCollection(list);
                treedict.Add(s, ObsDateCollection);
            }
        }
    }
}
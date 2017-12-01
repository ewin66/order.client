using System.Collections.Generic;
using iih.ci.ord.dto.orobsandlab.d;
using iih.ci.ord.i;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.control.tree.otree.data;

namespace iih.ci.ord.cilab.viewmodel
{
    public class LabDateTreeModel
    {
        private readonly ICiOrdQryService service;
        public Dictionary<string, KeyNodeDataCollection> treedict = new Dictionary<string, KeyNodeDataCollection>();

        public LabDateTreeModel(string ent, string type)
        {
            service = XapServiceMgr.find<ICiOrdQryService>();
            loadObsDate(ent, type);
        }

        public OrObsAandLabDTO[] OrObsAandLabDate { get; set; }

        private void loadObsDate(string ent, string type)
        {
            var dict = new Dictionary<string, List<OrObsAandLabDTO>>();
            OrObsAandLabDate = service.getObsAndLabDateList(ent, type);

            foreach (OrObsAandLabDTO labDto in OrObsAandLabDate)
            {
                if (dict.ContainsKey(getdate(labDto.Dtor)))
                {
                 //   List<OrObsAandLabDTO> list = dict[labDto.Dtor.Value.ToString().Substring(0, 10)];
                    List<OrObsAandLabDTO> list = dict[getdate(labDto.Dtor)];
                    list.Add(labDto);
                }
                else
                {
                    var list = new List<OrObsAandLabDTO>();
                    list.Add(labDto);
                    dict.Add(getdate(labDto.Dtor), list);
                }
            }
            var listkey = new List<string>();
            listkey.AddRange(dict.Keys);
            foreach (string s in listkey)
            {
                List<OrObsAandLabDTO> list = dict[s];
                var myModuleAdapter = new KeyNodeDataAdapterFactory<OrObsAandLabDTO>("Id", "Parent");
             //   myModuleAdapter.CustomCaptionFunc = x => x.Name + "(" + x.Dtor.ToString().Substring(10, 5) + ")";
                myModuleAdapter.CustomCaptionFunc = x => x.Name + "(" + x.Dtor.Value.Hour + ":" + x.Dtor.Value.Minute+ ")";
                KeyNodeDataCollection ObsDateCollection = myModuleAdapter.ToKeyNodeDataCollection(list);
                treedict.Add(s, ObsDateCollection);
            }
        }

        private string getdate(FDateTime f)
        {
            return f.ToTarget.Year+"/"+f.ToTarget.Month+"/"+f.ToTarget.Day;
        }
    }
}
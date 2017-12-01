using System.Collections.Generic;
using iih.ci.ord.i;
using iih.ci.ord.ordappathgy.d;
using iih.en.pv.dto.d;
using xap.mw.serviceframework;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.control.tree.otree.data;
using xap.rui.engine;
using xap.rui.uipattern2.basemodel;
using xap.rui.uipattern2.basemodel.treenew;

namespace iih.ci.ord.opippathgy.pathgy2.model
{
    /// <summary>
    /// 物品基本分类表格视图数据模型
    /// <para>author: hao_wu</para>
    /// </summary>
    class OpippathgyDateTreeModel2: NNaviTreeModel<OrdApPathgyDTO,NVtDO>
    {
        private ICiOrdQryService ciservice;
        public Ent4BannerDTO ent4BannerDto;
        public Dictionary<string, KeyNodeDataCollection> treedict = new Dictionary<string, KeyNodeDataCollection>();
        public OpippathgyDateTreeModel2(BaseContext ctx)
            : base(ctx)
        {
            ciservice= XapServiceMgr.find<ICiOrdQryService>();
            loadObsDate();
        }

        public override void LoadData(object cond = null)
        {
           
        }

        private void loadObsDate()
        {

            if ((this.Context["PatientData"] as BannerData) != null)
            {
                ent4BannerDto = (this.Context["PatientData"] as BannerData).Ent4BannerDTO;
           
            OrdApPathgyDTO[] apPathgyDtos = this.ciservice.getPathgyList(ent4BannerDto.Id_ent);
            var dict = new Dictionary<string, List<OrdApPathgyDTO>>();


            foreach (OrdApPathgyDTO pathgyDto in apPathgyDtos)
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
                myModuleAdapter.CustomCaptionFunc = x => x.Name + "(" + x.Dt_effe.ToString().Substring(10, 5) + ")";
                KeyNodeDataCollection ObsDateCollection = myModuleAdapter.ToKeyNodeDataCollection(list);
                treedict.Add(s, ObsDateCollection);
            }
            }
        }

      
    }
}

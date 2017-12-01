using System.Collections.Generic;
using System.Linq;
using iih.bd.srv.srvcate.d;
using iih.bd.srv.srvcate.i;
using iih.ci.ord.i;
using iih.ci.ord.ordappathgy.d;
using iih.en.pv.dto.d;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.control.tree.otree.data;
using xap.rui.control.tree.otree.loader;
using xap.rui.control.tree.otree.model;
using xap.rui.engine;
using xap.rui.uipattern2.basemodel.treenew;
using xap.rui.uipattern2.basemodelassist;

namespace iih.ci.ord.opippathgy.pathgy2.model
{
    /// <summary>
    /// 基本分类导航树视图数据模型
    /// <para>author: hao_wu</para>
    /// </summary>
    class OpippathgyTreeModel2 : NNaviTreeModel<SrvCateDO,OrdApPathgyDTO>
    {
        private ICiOrdQryService ciservice;
        public Ent4BannerDTO ent4BannerDto;
        private readonly ISrvcateCrudService srvcateMservice;
        public OpippathgyTreeModel2(BaseContext ctx)
            : base(ctx)
        {
            ciservice= XapServiceMgr.find<ICiOrdQryService>();
            srvcateMservice = XapServiceMgr.find<ISrvcateCrudService>();
        }

        public override void LoadData(object cond = null)
        {
            if ((this.Context["PatientData"] as BannerData) != null)
            {
                ent4BannerDto = (this.Context["PatientData"] as BannerData).Ent4BannerDTO;
           
            OrdApPathgyDTO[] apPathgyDtos = this.ciservice.getPathgyList(ent4BannerDto.Id_ent);
            this.dataListM2 = new NBindingList<OrdApPathgyDTO>(apPathgyDtos.ToArray());

            KeyNodeDataAdapterFactory<OrdApPathgyDTO> adapter2 = new KeyNodeDataAdapterFactory<OrdApPathgyDTO>("Id_appathgy", "Id_srvca", "", "Name");
            this.tkeyModel2 = new TreeKeyModel<OrdApPathgyDTO>(adapter2, this.dataListM2);
            this.tkeyModel2.Loader = new OTreeKeyLoader();

            SrvCateDO[] srvcados = getCateDos(apPathgyDtos);
            KeyNodeDataAdapterFactory<SrvCateDO> adapter1 = new KeyNodeDataAdapterFactory<SrvCateDO>("Id_srvca", "Id_srvca", "", "Name");
            this.dataListM1 = new NBindingList<SrvCateDO>(srvcados);
            this.tkeyModel1 = new TreeKeyModel<SrvCateDO>(adapter1, this.dataListM1);
            this.tkeyModel1.Loader = this.tkeyModel2.Loader;
            }
        }

        private SrvCateDO[] getCateDos(OrdApPathgyDTO[] apPathgyDtos)
        {
            List<string> pids = apPathgyDtos.Select(p => p.Id_srvca).ToList();
            if (pids == null || pids.Count == 0)
                return null;
            string filter = "";
            foreach (string s in pids)
            {
                filter += ("'" + s + "',");
            }

            SrvCateDO[] srvcados = srvcateMservice.find(
                "a0.id_srvca in (" + filter.Substring(0, filter.Count() - 1) + ")", "", FBoolean.False);
            return srvcados;
        }
    }
}

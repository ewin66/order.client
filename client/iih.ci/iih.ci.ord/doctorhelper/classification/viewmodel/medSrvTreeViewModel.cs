using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.srvcate.d;
using iih.bd.srv.srvcate.i;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.rui.control.tree.otree.data;
using xap.rui.control.tree.otree.loader;
using xap.rui.control.tree.otree.model;
/********************************************************************************

** 作者： 李政

** 创始时间：2016-6-30

** 修改人：李政

** 修改时间：2016-6-30

** 描述： 分类树数据


*********************************************************************************/
namespace iih.ci.ord.doctorhelper.classification.viewmodel
{
    class medSrvTreeViewModel
    {
    private ISrvcateCrudService service;
       // SrvCateDO[] medsrvs;
        public XapDataList<SrvCateDO> srvcas;
        public TreeKeyModel<SrvCateDO> TreeModel;

        public medSrvTreeViewModel(string typeparameter)
        {
            service = XapServiceMgr.find<ISrvcateCrudService>();
            if (typeparameter==null)return;
            //string str = " a0.ds=0";
            //if (typeparameter == BdSrvDictCodeTypeConst.MEDSRV_DRUG)
            //{
            //    str += " and (a0.code like '01%' or a0.code like '14%')";
            //}
            //if (typeparameter == BdSrvDictCodeTypeConst.MEDSRV_DIAGTREAT)
            //{
            //    str += " and (a0.code not like '01%' and a0.code not like '14%' and a0.code not like '07%')";
            //}
            SrvCateDO[] srvca = service.find(typeparameter, "code", false);
            srvcas = new XapDataList<SrvCateDO>(service, srvca);

            //List<SrvCateDO>  srvs = agg.Select(p => p.getParentDO() as SrvCateDO).ToList();
       
            //srvs.ForEach(p => { if (p.Id_parent == null)p.Id_parent = "A"; });
            //srvs.Add(new SrvCateDO() { Id_srvca = "A", Id_parent = null, Name = "基本服务分类" });
            //medsrvs = srvs.ToArray();

            KeyNodeDataAdapterFactory<SrvCateDO> moduleAdapter = new KeyNodeDataAdapterFactory<SrvCateDO>("Id_srvca", "Id_parent");
            moduleAdapter.CustomCaptionFunc = (dataobj => dataobj.Code + " " + dataobj.Name);

            this.TreeModel = new TreeKeyModel<SrvCateDO>(moduleAdapter);
            this.TreeModel.Loader = new OTreeKeyLoader();
            this.TreeModel.AddRange(srvcas); 
        }

        public KeyNodeDataCollection TreeCollection
        {
            get
            {
                var moduleAdapter = new KeyNodeDataAdapterFactory<SrvCateDO>("Id_srvca", "Id_parent");
                moduleAdapter.CustomCaptionFunc = (dataobj =>  dataobj.Name);
                return moduleAdapter.ToKeyNodeDataCollection(null);//(medsrvs);
            }
        }

    }
}


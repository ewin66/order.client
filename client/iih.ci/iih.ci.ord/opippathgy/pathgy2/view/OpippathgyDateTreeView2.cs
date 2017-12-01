using System.Collections.Generic;
using iih.ci.ord.opippathgy.pathgy2.model;
using iih.ci.ord.ordappathgy.d;
using xap.rui.control.tree.otree.loader;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;
using xap.rui.engine2;
using xap.rui.uipattern2.basemodel;
using xap.rui.uipattern2.baseview.treenew;

namespace iih.ci.ord.opippathgy.pathgy2.view
{
    /// <summary>
    /// 物品基本分类表格视图
    /// <para>author: hao_wu</para>
    /// </summary>
    sealed class OpippathgyDateTreeView2 : NNaviTreeView<OrdApPathgyDTO, NVtDO>, IWorkStationRegist
    {
        public OpippathgyDateTreeView2(IFunclet root)
            : base(root)
        {
            this.SetTreeModel(new OpippathgyDateTreeModel2(this.Context));
        }

       
        protected override void OnFillData()
        {
            this.oTree.ClearTree();
            var listkey = new List<string>();
         if(this.model!=null)
         {
             var dataModel = this.model as OpippathgyDateTreeModel2;
             listkey.AddRange(dataModel.treedict.Keys);
                var loader = new OTreeKeyLoader();
                foreach (string s in listkey)
                {
                    loader.Root = this.oTree.GetRoot(s);
                    this.oTree.LoadData(dataModel.treedict[s], loader);
                }

         }
        }


        #region 注册与反注册到工作站

        public void Regist(EventBroker eventBroker)
        {
            eventBroker.Register(this);
            if (Created)
                OnLoadData();
        }

        public void UnRegist(EventBroker eventBroker)
        {
            eventBroker.Unregister(this);
        }

        public void UpdatePatientInfo(object sender, DictionaryEventArgs eventArgs)
        {

        }

        #endregion
    }
}

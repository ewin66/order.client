using iih.bd.srv.srvcate.d;
using iih.ci.ord.opippathgy.pathgy2.model;
using iih.ci.ord.ordappathgy.d;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;
using xap.rui.engine2;
using xap.rui.uipattern2.baseview.treenew;

namespace iih.ci.ord.opippathgy.pathgy2.view
{
    /// <summary>
    /// 物品基本分类导航树视图
    /// <para>author: hao_wu</para>
    /// </summary>
    sealed class OpippathgyTreeView2 : NNaviTreeView<SrvCateDO, OrdApPathgyDTO>, IWorkStationRegist
    {
        public OpippathgyTreeView2(IFunclet root)
            : base(root)
        {
            this.SetTreeModel(new OpippathgyTreeModel2(this.Context));
        }

        protected override object SendMsg_TNodeSelected()
        {
            
            object sel_obj = base.SendMsg_TNodeSelected();

          

            return sel_obj;
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

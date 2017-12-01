using iih.ci.ord.cirptpathgy.d;
using iih.ci.ord.opippathgy.pathgy2.viewinit;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;
using xap.rui.engine2;
using xap.rui.uipattern2.basemodel.card;
using xap.rui.uipattern2.baseview.card;
using System;

namespace iih.ci.ord.opippathgy.pathgy2.view
{
    /// <summary>
    /// 物品基本分类卡片视图
    /// <para>author: hao_wu</para>
    /// </summary>
    sealed class OpippathgyCardView2 : NManageCardView<CiRptPathgy>, IWorkStationRegist
    {
        public OpippathgyCardView2(IFunclet root)
            : base(root, null)
        {
            this.SetCardModel(new NCardModel<CiRptPathgy>(this.Context));
                  this.xapFormIniter = new OpippathgyCardFormInit(root);
        
        }
        [Obsolete("新方案挪到消息处理子模块")]
        protected override string GetFormTplIdManul()
        {
            return "20160811042546838D7Z";
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

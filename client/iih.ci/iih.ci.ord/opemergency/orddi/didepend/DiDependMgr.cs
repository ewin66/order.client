using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.diag.dto.judgedideletedto.d;
using iih.ci.ord.dto.d;
using iih.ci.ord.medicaresharing.medicareshar;
using xap.rui.engine2;
using xap.rui.engine2.baseview;
using xap.rui.engine2.baseview.micromodule;
using xap.rui.uipattern2.baseview.gridnew;
using xap.rui.uipattern2.baseviewmodule.datavalidater.grid;
using xap.rui.uipattern2.baseviewmodule.msghandler.grid;
using xap.rui.uipattern2.baseviewmodule.statehandler.grid;
using xap.rui.uipattern2.baseviewmodule.viewinit.grid;

namespace iih.ci.ord.opemergency.orddi.didepend
{
    public class DiDependMgr : AbstractMicroModulesMgr
    {

        #region 构造函数区域
        /// <summary>
        /// 构造方法
        /// </summary>
        /// <param name="root"></param>
        public DiDependMgr(IFunclet root)
            : base(root)
        {
        }
        #endregion

        #region 父类继承区域

        /// <summary>
        /// 创建试图类型
        /// </summary>
        /// <param name="root"></param>
        /// <returns></returns>
        protected override NViewBase CrtViewObj(IFunclet root)
        {
            //针对BaseDO的索引表视图控件，用于管理类型的节点的第一页的导航表格
            return new NNaviGridView<Judgedideletedto>(root);
        }

        /// <summary>
        ///  创建子模块对象
        /// </summary>
        protected override void InitSubModules()
        {
            //数据模型子模块   根据视图继承框架中提供的DataModel 
            //Card：[NCardModel,NCardModel4Agg] 
            //GridView:[NBaseEditableGridModel,NBaseEditableGridModel4Agg,NEditGridModel,NIndexGridModel,NIndexGridModel4Agg,NNaviGridModel]
            //Tree:[NBaseEditableTreeModel,NBaseTreeModel,NNaviTreeModel]
            this.SubModuleDataModel = new DiDependModel(this);
            //数据校验子模块
            this.SubModuleDataValidator = new NaviGridDataValidator<Judgedideletedto>(this);
            //消息处理子模块
            this.SubModuleMsgHandler = new NaviGridMsgHandler<Judgedideletedto>(this);
            //View初始化子模块与View 
            this.SubModuleViewInit = new NaviGridViewInit<Judgedideletedto>(this);
            //View状态处理子模块
            this.SubModuleViewState = new NaviGridStateHandler<Judgedideletedto>(this);
        }

        #endregion

        #region 辅助处理函数

        #endregion
    }
}

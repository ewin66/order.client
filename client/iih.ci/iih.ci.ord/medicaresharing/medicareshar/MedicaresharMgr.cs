/* =======================================================
 * Filename: MedicaresharMgr
 * Date: $DateTime.Now.ToString()$
 * Compiler: Microsoft Visual Studio 2013
 * Author: 
 * Company: Copyright 2017 by PKU heaithcare IT Co.,Ltd
 * Description: 
 * =======================================================
 */

using iih.ci.ord.dto.d;
using xap.mw.core.data;
using xap.rui.engine;
using xap.rui.engine2;
using xap.rui.uipattern2.viewevt;
using xap.rui.core2.engine2.attr;
using xap.rui.core2.engine2.messagebus;
using xap.rui.engine2.baseview;
using xap.rui.engine2.baseview.micromodule;
using xap.rui.uipattern2.basemodel;
using xap.rui.uipattern2.baseview.card;
using xap.rui.uipattern2.baseview.gridnew;
using xap.rui.uipattern2.baseview.treemixnew;
using xap.rui.uipattern2.baseview.treenew;
using xap.rui.uipattern2.baseviewmodule.datavalidater.grid;
using xap.rui.uipattern2.baseviewmodule.msghandler.grid;
using xap.rui.uipattern2.baseviewmodule.statehandler.grid;
using xap.rui.uipattern2.baseviewmodule.viewinit.card;
using xap.rui.uipattern2.baseviewmodule.viewinit.grid;


namespace iih.ci.ord.medicaresharing.medicareshar
{
    public class MedicaresharMgr : AbstractMicroModulesMgr
    {

        #region 构造函数区域
        /// <summary>
        /// 构造方法
        /// </summary>
        /// <param name="root"></param>
        public MedicaresharMgr(IFunclet root)
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
            return new NNaviGridView<MedicalSharingDTO>(root);
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
            this.SubModuleDataModel = new MedicaresharModel(this);
            //数据校验子模块
            this.SubModuleDataValidator = new NaviGridDataValidator<MedicalSharingDTO>(this);
            //消息处理子模块
            this.SubModuleMsgHandler = new NaviGridMsgHandler<MedicalSharingDTO>(this);
            //View初始化子模块与View 
            this.SubModuleViewInit = new NaviGridViewInit<MedicalSharingDTO>(this);
            //View状态处理子模块
            this.SubModuleViewState = new NaviGridStateHandler<MedicalSharingDTO>(this);
        }

        #endregion

        #region 辅助处理函数

        #endregion
    }
}

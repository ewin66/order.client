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

        #region ���캯������
        /// <summary>
        /// ���췽��
        /// </summary>
        /// <param name="root"></param>
        public MedicaresharMgr(IFunclet root)
            : base(root)
        {
        }
        #endregion

        #region ����̳�����

        /// <summary>
        /// ������ͼ����
        /// </summary>
        /// <param name="root"></param>
        /// <returns></returns>
        protected override NViewBase CrtViewObj(IFunclet root)
        {
            //���BaseDO����������ͼ�ؼ������ڹ������͵Ľڵ�ĵ�һҳ�ĵ������
            return new NNaviGridView<MedicalSharingDTO>(root);
        }

        /// <summary>
        ///  ������ģ�����
        /// </summary>
        protected override void InitSubModules()
        {
            //����ģ����ģ��   ������ͼ�̳п�����ṩ��DataModel 
            //Card��[NCardModel,NCardModel4Agg] 
            //GridView:[NBaseEditableGridModel,NBaseEditableGridModel4Agg,NEditGridModel,NIndexGridModel,NIndexGridModel4Agg,NNaviGridModel]
            //Tree:[NBaseEditableTreeModel,NBaseTreeModel,NNaviTreeModel]
            this.SubModuleDataModel = new MedicaresharModel(this);
            //����У����ģ��
            this.SubModuleDataValidator = new NaviGridDataValidator<MedicalSharingDTO>(this);
            //��Ϣ������ģ��
            this.SubModuleMsgHandler = new NaviGridMsgHandler<MedicalSharingDTO>(this);
            //View��ʼ����ģ����View 
            this.SubModuleViewInit = new NaviGridViewInit<MedicalSharingDTO>(this);
            //View״̬������ģ��
            this.SubModuleViewState = new NaviGridStateHandler<MedicalSharingDTO>(this);
        }

        #endregion

        #region ����������

        #endregion
    }
}

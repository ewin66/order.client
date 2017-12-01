
using iih.ci.diag.dto.d;
using iih.ci.ord.common.utils.msg;
using iih.ci.ord.moreemsdto.d;
using iih.ci.ord.opemergency.assi.asscommon.view;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.tool;
using iih.mkr.ms.d;
using iih.mkr.ms.mkrms.d;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.cli.sdk.form;
using xap.mw.core.data;
using xap.rui.engine;
using iih.ci.ord.opemergency.declare;

namespace iih.ci.ord.opemergency.assi.mkrms.view
{
    /// <summary>
    /// <para>描    述 :  门诊组套业务逻辑处理类</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.mkrms.view</para>
    /// <para>类 名 称 :  MkrMsAssiView</para>
    /// <para>版 本 号 :  v1.0.0.0</para>
    /// <para>作    者 :  HUMS</para>
    /// <para>修 改 人 :  HUMS</para>
    /// <para>创建时间 :  2016/10/20 17:47:46</para>
    /// <para>更新时间 :  2016/10/20 17:47:46</para>
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class MkrMsAssiEventView : AssistantBaseEvent
    {

        #region 变量定义区域

        #endregion

        #region 构造函数区域

        public MkrMsAssiEventView()
        {
            InitializeComponent();
        }

        public MkrMsAssiEventView(IContainer container)
        {
            container.Add(this);

            InitializeComponent();
        }

        #endregion

        #region 公开属性区域

        #endregion

        #region 命令定义区域

        #endregion

        #region 事件发送区域

        #endregion

        #region 事件接收区域

        #endregion

        #region 父类继承区域

        #endregion

        #region 内部事件区域

        #endregion

        #region 辅助处理函数

        /// <summary>
        /// 保存组套选择的结果（诊断、病历、医嘱模板、医疗服务）
        /// </summary>
        /// <param name="msDTO">组套对象</param>
        private void SaveMkrmsSelectedResult(MsDTO msDTO)
        {
            // 有效性判断
            if (null == msDTO)
            {
                return;
            }

            // 诊断 MkrMsDiDO
            FArrayList mkrMsDiDOList = msDTO.Dis;
            //医疗服务 MkrMsSrvDO
            FArrayList mkrMsSrvDOList = msDTO.Srvs;
            // 医嘱模板 MkrMsOrtpl
            FArrayList mkrMsOrtplList = msDTO.Ortpls;
            // 病历模板 MkrMsMrtplDO
            FArrayList mkrMsMrtplDOList = msDTO.Mrtpls;

            //病历不为空时发送保存病历段落事件
            if (mkrMsMrtplDOList != null && mkrMsMrtplDOList.Count > 0)
            {
                this.FireMrWriteBackBizEvent(this, mkrMsMrtplDOList[0]);
            }

            // 是否保存新增的诊断，如果本次未选择诊断，该值返回false， 如果选了诊断返回为true
            bool isProcessSaveCIDI = false;
            // 保存诊断
            List<DIDTO> didtList = this.assiCidiViewModel.SaveMkrMsDIDTOList(mkrMsDiDOList, ref isProcessSaveCIDI);

            // 如果不存在已保存的诊断，也未勾选诊断，不允许保存医嘱
            if ((didtList == null || didtList.Count == 0))
            {
                if (mkrMsSrvDOList != null || mkrMsOrtplList != null)
                {
                    BizAssMessageBoxUtil.ShowCidiIsNullMsg("门诊组套");
                    return;
                }
            }
            else if (isProcessSaveCIDI)// 有新增诊断时进行保存
            {
                //发送诊断保存成功事件 TODO 修改
                AssToolEx.SentMessage(this, declare.EventCodeType.EVENT_ORDI_SAVESUCCE, "DIDTOLIST", didtList);
            }

            // 医疗服务、医嘱模板转换医疗单
            if (mkrMsSrvDOList != null || mkrMsOrtplList != null)
            {

                MoreEmsParamDTO moreEmsDto = this.assiCiorderViewModel.SaveOrderAndOrtmpl(mkrMsSrvDOList, mkrMsOrtplList);
                AssToolEx.SentMessage(this, EventCodeType.EVENT_EMS_TMPL_EDIT, EventCodeType.ARGKEY_EMS_TMPL_EDIT, moreEmsDto);
            }
        }

        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs e)
        {
            // 获取事件类型
            string uiEvent = e.Data[UIConst.UI_EVENT] as string;
            string newState = e.Data[UIConst.NEW_STATE] as string;

            // 获取事件参数列表
            Dictionary<string, Object> dict = e.Data[UIConst.DATA] as Dictionary<string, Object>;

            switch (uiEvent)
            {
                case EventCodeType.THIRD_EVENT_MKRMS_ADD:
                    SaveMkrmsSelectedResult(AssToolEx.ObjectOfEventArgs(e, "MsDTO") as MsDTO);
                    break;
                default:
                    break;

            }
        }

        #endregion
    }
}

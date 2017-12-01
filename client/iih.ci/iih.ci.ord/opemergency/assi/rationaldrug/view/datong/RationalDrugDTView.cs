
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.rui.engine;
using iih.en.pv.dto.d;
using iih.ci.ord.ordsrvmm.d;
using iih.ci.ord.opemergency.assi.rationaldrug.viewmodel;
using iih.ci.ord.opemergency.assi.rationaldrug.viewmodel.datong;
using iih.common_stub.datong;
using xap.cli.sdk.form;
using System.Windows.Forms;
using iih.ci.ord.ciorder.d;
using xap.rui.control.extentions;

using iih.pi.reg.pat.d;
using iih.ci.ord.ems.d;
using xap.mw.log;

namespace iih.ci.ord.opemergency.assi.rationaldrug.view.datong
{
    /// <summary>
    /// <para>描    述 :  大通合理用药实现</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.rationaldrug.view.datong    </para>    
    /// <para>类 名 称 :  RationalDrugDTView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  hums         				</para> 
    /// <para>修 改 人 :  hums         				</para> 
    /// <para>创建时间 :  2016/9/27 10:03:09             </para>
    /// <para>更新时间 :  2016/9/27 10:03:09             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class RationalDrugDTView : RationalDrugView
    {

        #region 变量定义区域

        #endregion

        #region 构造函数区域

        public RationalDrugDTView()
        {
            viewModel = new RationalDrugDTViewModel();
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

        #region

        public override void InitRationStatus()
        {

        }

        #endregion


        #region 要点提示

        /// <summary>
        /// 根据物品信息显示
        /// </summary>
        /// <param name="idOrsrv">根据医嘱服务显示物品提示信息</param>
        /// <returns></returns>
        public override string ShowDrugInstruction(string idOrsrv)
        {

            return "";
        }

        /// <summary>
        /// 根据物品信息显示
        /// </summary>
        /// <param name="ordSrvMm"></param>
        /// <returns></returns>
        public override string ShowDrugInstruction(OrdSrvMmDO ordSrvMm)
        {

            return "";
        }

        /// <summary>
        /// 根据物品编码、名称显示提示
        /// </summary>
        /// <param name="codeMm">药品编码</param>
        /// <param name="nameMm">药品名称</param>
        public override void ShowDrugInstruction(string codeMm, string nameMm)
        {
            viewModel.ShowDrugInstruction(codeMm, nameMm);
        }

        #endregion

        #region 药品分析

        /// <summary>
        /// 对医嘱中药品进行分析进行分析
        /// </summary>
        /// <param name="idOrs">医嘱id集合</param>
        /// <returns>返回的操作状态0，直接执行，1弹出提示框，仅有确定按钮，确定后继续执行，2弹出提示框，包含确定取消按钮，确定继续执行，取消不执行</returns>
        public override bool AnalysisPresResult(CiOrderDO[] ciords)
        {
            string msgCode = "";
            string msg = "用药存在[{0}]问题，是否继续执行？";
            MessageBoxButtons msgBtns = MessageBoxButtons.YesNo;


            if (this.ctxDTO == null)
            {
                string msgStr = "";
                if (base.ctxDTO == null)
                {
                    msgStr = "base.ctxDTO 为空；";
                }
                if (this.ctxDTO != null && base.ctxDTO != null && this.ctxDTO.Id_pat != base.ctxDTO.Id_pat)
                {
                    msgStr += " 当前 患者于基类患者不一致 ；";

                }

                LogManager.GetLogger().ErrorEx("合理用药未获取到当前就诊环境属性！" + msgStr);
                this.SetStatusMsg("合理用药未获取到当前就诊环境属性！" + msgStr);
                return true;
            }
            // 返回状态，0 没有问题，1 一般问题， 2 严重问题
            int result = viewModel.AnalysisPresResult(base.ctxDTO, ciords, out msgCode);

            // 验证没有问题直接返回 
            if (DaTongConstant.RS_NO_PROBLEM == result || DaTongConstant.RS_NOT_VERIFIED == result)
            {
                return true;
            }
            else if (!string.IsNullOrEmpty(msgCode))
            {
                // 当未获取到提示信息时，返回true
                string outMsg = ((RationalDrugDTViewModel)viewModel).GetSdMessage(msgCode);
                if (string.IsNullOrEmpty(outMsg))
                {
                    return true;
                }
                msg = string.Format(msg, outMsg);

                if (DaTongConstant.RS_GENERAL_PROBLEM == result) // 一般问题
                {
                    if (MessageBoxEx.Show(msg, "大通安全用药提示", msgBtns, MessageBoxIconEx.Information) == DialogResult.Yes)
                    {
                        return true;
                    }
                }
                else
                {
                    if (MessageBoxEx.Show(msg, "大通安全用药提示", msgBtns, MessageBoxIconEx.Warning) == DialogResult.Yes)
                    {
                        return true;
                    }
                }

            }
            return false;
        }

        #endregion


        #endregion

        #region 内部事件区域

        #endregion

        #region 辅助处理函数

        #endregion

        #region 状态处理区域

        #endregion

    }
}

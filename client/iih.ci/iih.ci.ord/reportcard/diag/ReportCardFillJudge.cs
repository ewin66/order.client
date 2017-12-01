using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.bd.bc.udi;
using iih.ci.diag.dto.d;
using iih.ci.ord.ciordcons.viewmodel;
using iih.ci.rcm.contagion.d;
using iih.ci.rcm.contagion.i;
using iih.en.pv.dto.d;
using xap.cli.context;
using xap.cli.context.events;
using xap.cli.sdk.form;
using xap.cli.sdk.render;
using xap.cli.sdk.render.Items;
using xap.cli.sdk.render.labelcontrol;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.control;
using xap.rui.control.forms.view;
using xap.rui.engine;
using iih.ci.diag_stub.i;
using iih.ci.diag.cidiag.d;
using iih.ci.ord.opemergency.assi.asscommon.viewmodel;

namespace iih.ci.ord.reportcard
{
    public partial class ReportCardFillJudge
    {
        private Ent4BannerDTO ent4BannerDto;

        /// <summary>
        /// 传染病上报卡服务接口
        /// </summary>
        private IContagionMDOCrudService contagionMDOCrudService;

        /// <summary>
        /// 诊断服务接口
        /// </summary>
        private ICidiagQryService cidiagQryService;

        /// <summary>
        ///  传染病上报卡
        /// </summary>        
        /// <param name="ent4BannerDto">banner</param>
        public ReportCardFillJudge(Ent4BannerDTO ent4BannerDto)
        {
            this.ent4BannerDto = ent4BannerDto;
            cidiagQryService = XapServiceMgr.find<ICidiagQryService>();
            contagionMDOCrudService = XapServiceMgr.find<IContagionMDOCrudService>();

        }

        /// <summary>
        /// 根据诊断集合（DIDTO）确定是否打开传染病上报卡
        /// </summary>
        /// <param name="fgFirst">是否为初诊标识，true 初诊， false 复诊 </param>
        /// <param name="didtos">诊断集合</param>
        /// <returns></returns>
        public bool IsInfectionReport(List<DIDTO> listDiDTO)
        {
            // 仅有初诊时才根据是否有传染病诊断判断是否需要打开传染病上报卡
            if (ent4BannerDto.Fg_first == null || !ent4BannerDto.Fg_first.Value)
                return false;

            // 传染病记录数
            int infectiousRecordsCnt = 0;
            // 遍历DIDTO集合，获取传染表表示为true的诊断记录数
            foreach (DIDTO didto in listDiDTO)
            {
                if (didto.Fg_ur != null && didto.Fg_ur.Value)
                    infectiousRecordsCnt++;
            }

            // 确定是否打开传染病上报卡
            return IsOpenReportView(infectiousRecordsCnt, this.ent4BannerDto);

        }

        /// <summary>
        /// 判断是否打开传染病上报卡页面
        /// </summary>
        /// <param name="fgFirst">是否为初诊标识， true 初诊</param>
        /// <returns></returns>
        public bool IsInfectionReport()
        {
            if (ent4BannerDto.Fg_first == null || !ent4BannerDto.Fg_first.Value)
                return false;

            int infectiousRecordsCnt = 0;
            // 获取门诊最新的诊断，遍历诊断明细获取有传染病标识的诊断数量
            CidiagAggDO[] CidiagAggs = cidiagQryService.getLastCiDiags(this.ent4BannerDto.Id_ent);
            if (CidiagAggs != null && CidiagAggs.Length > 0)
            {
                // 门诊诊断中，一次就诊中最新一条诊断主表记录为当前有效诊断
                CiDiagItemDO[] ciDiagItems = CidiagAggs[0].getCiDiagItemDO();
                if (ciDiagItems != null)
                {
                    // 遍历诊断明细集合，获取传染表表示为true的诊断记录数
                    foreach (CiDiagItemDO cidiagItem in ciDiagItems)
                    {
                        if (cidiagItem.Fg_ur != null && cidiagItem.Fg_ur.Value)
                        {
                            infectiousRecordsCnt++;
                        }
                    }
                }

                // 确定是否打开传染病上报卡
                return IsOpenReportView(infectiousRecordsCnt, this.ent4BannerDto);
            }
            return false;
        }


        /// <summary>
        /// 是否打开传染病上报卡
        /// </summary>
        /// <param name="infectiousRecordsCnt">传染病诊断记录数</param>
        /// <param name="ent4BannerDto">banner对象</param>
        /// <returns>是否打开了传染病上报卡，true ：已打开，false： 未打开</returns>
        private bool IsOpenReportView(int infectiousRecordsCnt, Ent4BannerDTO ent4BannerDto)
        {
            if (infectiousRecordsCnt == 0) return false;

            // 查询已经上报的传染病上报卡
            //string condition = string.Format("id_ent='{0}' and id_con_cardsu='{1}'", ent4BannerDto.Id_ent, ID_CON_CARDSU);

            // 查询本次就诊全部的上报卡
            string condition = string.Format("id_ent='{0}'", ent4BannerDto.Id_ent);
            ContagionDO[] contagions = contagionMDOCrudService.find(condition, null, FBoolean.False);

            // 获取提交和审核通过的上报卡记录数
            int tjCnt = contagions.Count(p => p.Id_con_cardsu == MrDictCodeConst.ID_CONTAGION_STATUS_SUBMIT || p.Id_con_cardsu == MrDictCodeConst.ID_CONTAGION_STATUS_PASS);

            // 当诊断明细中传染病标识数与已上报的个数相同，证明全部已上报，不主动弹出上报窗口
            if (tjCnt >= infectiousRecordsCnt) return false;

            string msg = null;
            if (contagions.Length > tjCnt)
            {
                msg = "存在未提交的传染病报告卡，是否打开传染病上报卡？";
            }
            else
            {
                msg = "是否填报传染病报告卡？";
            }
            return this.OpenFun(msg, ent4BannerDto);
        }

        /// <summary>
        /// 打开功能节点
        /// </summary>
        /// <param name="msg">操作提示信息</param>
        /// <param name="ent4BannerDto">患者就诊信息</param>
        /// <returns></returns>
        private bool OpenFun(string msg, Ent4BannerDTO ent4BannerDto)
        {
            DialogResult result = MessageBoxEx.Show(msg, "操作提示", MessageBoxButtons.YesNo, MessageBoxIconEx.Question, MessageBoxDefaultButton.Button1);
            if (DialogResult.Yes == result)
            {
                var param = new Dictionary<string, object> { { "OPatientData", ent4BannerDto } };
                // 打开传染病上报卡功能节点
                XapEvents.OpenFuncEvent(this, new OpenFuncEventArgs(AssistantConstant.FUN_CODE_CONTAGION_REPORT_CARD, param));
                return true;
            }
            return false;
        }
    }
}

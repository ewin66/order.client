using System;
using xap.mw.serviceframework;
using xap.rui.engine;
using xap.rui.control.extentions;
using xap.rui.control.basecontrol;
using xap.cli.sdk.form;
using iih.ci.ord.opemergency.medreferral.model;
using iih.ci.ord.opemergency.tool;
using iih.en.pv.ci.i;
using iih.en.pv.ci.d;
using System.Collections.Generic;
using xap.dp.rptview.viewer;
using iih.ci.ord.ciorder.utils;
using xap.mw.core.data;
using xap.rui.control.engine.attributes;

namespace iih.ci.ord.opemergency.medreferral.controller
{
    /// <summary>
    /// <para>描    述 :  医疗转诊单控制器                   			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.medreferral.controller    </para>    
    /// <para>类 名 称 :  CiMedReferralController					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  vivi         				</para> 
    /// <para>修 改 人 :  vivi         				</para> 
    /// <para>创建时间 :  10/21/2016 9:35:43 AM             </para>
    /// <para>更新时间 :  10/21/2016 9:35:43 AM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class CiMedReferralController : XapBaseControl
    {
        #region 消息中心代理
        public XapBaseControl EventDelegate { get; set; }

        public CiMedReferralViewModel ViewModel { get; set; }

        public event EventHandler eventPrint;

        //打印模板视图
        private ReportViewer rpt_viewer = new ReportViewer(true);

        private MedReferralDO dataSource;
        #endregion

        public override void HandleState(object sender, DictionaryEventArgs e)
        {
            IMedreferralCrudService service = XapServiceMgr.find<IMedreferralCrudService>();
            String eventCode = AssToolEx.EventCodeOfEventArgs(e);

            if (eventCode.Equals("MedReferralSaveAction")) {

                if (ViewModel.MedReferralDO.Dt_referralperiodbegin > ViewModel.MedReferralDO.Dt_referralperiodend)
                {
                    EventDelegate.ShowInfo(OrdParam.MESSAGE_TIEMCHECK);
                    return;
                }

                if ((ViewModel.MedReferralDO.Str_name_di!=null&&ViewModel.MedReferralDO.Str_name_di.Length > 300)
                    || (ViewModel.MedReferralDO.Reason_referral != null && ViewModel.MedReferralDO.Reason_referral.Length > 300 )
                    || (ViewModel.MedReferralDO.Des_initialdiag != null && ViewModel.MedReferralDO.Des_initialdiag.Length > 300 )
                    || (ViewModel.MedReferralDO.Des_question != null && ViewModel.MedReferralDO.Des_question.Length > 300 )
                    || (ViewModel.MedReferralDO.Diagtreatment != null && ViewModel.MedReferralDO.Diagtreatment.Length > 300))
                {
                    EventDelegate.ShowInfo("填写内容超长！");
                    return;
                }

                if (String.IsNullOrWhiteSpace(ViewModel.MedReferralDO.Str_name_di) 
                    || String.IsNullOrWhiteSpace(ViewModel.MedReferralDO.Reason_referral)
                    || String.IsNullOrWhiteSpace(ViewModel.MedReferralDO.Name_org_referral2))
                {
                    EventDelegate.ShowInfo("请填写必填项！");
                    return;
                }

                dataSource = service.save(new MedReferralDO[] { ViewModel.GetFormDataSource() as MedReferralDO })[0];
                if (null != dataSource)
                {
                    LogicEx.GetInstance().CopyTo<MedReferralDO>(dataSource, ViewModel.MedReferralDO);
                    EventDelegate.SetStatusMsg("医保转诊单保存成功。");
                }
                else
                {
                    EventDelegate.ShowInfo("医保转诊单保存失败。");
                }
            }
            else if (eventCode.Equals("MedReferralPrintAction")) {

                if (ViewModel.MedReferralDO == null || ViewModel.MedReferralDO.Id_medreferral == null)
                    return;
                bool res = false;
                string strFile = "iih_report/461010_menzhenyishengzhan/YBZZD.xml";

                Dictionary<string, string> qryParams = new Dictionary<string, string>();
                qryParams.Add("$id_medreferral", ViewModel.MedReferralDO.Id_medreferral);

                res = this.rpt_viewer.PrintRptFile(strFile, qryParams, true);

                if (res)
                {
                    ViewModel.MedReferralDO.Times_print += 1;
                    ViewModel.MedReferralDO.Status = DOStatus.UPDATED;
                    dataSource = service.save(new MedReferralDO[] { ViewModel.MedReferralDO })[0];
                    eventPrint(null, null);
                }
            }
        }
    }
}

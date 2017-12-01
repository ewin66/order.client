
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.i;
using xap.mw.serviceframework;
using xap.rui.appfw;
using iih.ci.ord.ciorder.d;
using iih.ci.ord_stub.i;
using xap.mw.core.data;
using xap.mw.core.utils;
using xap.cli.sdk.controls.DataView;
using xap.mw.coreitf.d;
using iih.bd.bc.udi;

namespace iih.ci.ord.ciorder.orreport.scrollpanel.model
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.orreport.scrollpanel.model    </para>    
    /// <para>类 名 称 :  HealthCheckReportModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/10/31 10:53:45             </para>
    /// <para>更新时间 :  2016/10/31 10:53:45             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class HealthCheckReportModel : BaseCheckReportModel
    {
        internal void save(XapDataList<OrdSrvDO> dataSource,string[] id_ors)
        {
            try
            {
                ICiOrdMaintainService service = XapServiceMgr.find<ICiOrdMaintainService>();
                foreach (OrdSrvDO ordSrvDO in dataSource)
                {
                    ordSrvDO.Status = DOStatus.UPDATED;
                    if (ordSrvDO.Eu_hpdoctorjudge == 0)
                    {
                        ordSrvDO.Fg_hpindicjudged = (int)HpIndicJudgeEnum.WAITINGJUDGE;
                    }
                    else if (ordSrvDO.Eu_hpdoctorjudge == 1)
                    {
                        ordSrvDO.Fg_indic = true;
                        ordSrvDO.Fg_selfpay = false;
                        ordSrvDO.Fg_hpindicjudged = (int)HpIndicJudgeEnum.JUDGED;
                    }
                    else if (ordSrvDO.Eu_hpdoctorjudge == 2)
                    {
                        ordSrvDO.Fg_indic = false;
                        ordSrvDO.Fg_selfpay = true;
                        ordSrvDO.Fg_hpindicjudged = (int)HpIndicJudgeEnum.JUDGED;
                    }
                }
                service.saveHealthCheckReport(dataSource, id_ors);
            }
            catch (Exception ex) {
                ex.Publish();
            }
            
        }
        public XapDataList<OrdSrvDO> getDataSource(string[] id_ors) {
            ICiorderCrudService ciorderService = XapServiceMgr.find<ICiorderCrudService>();
            CiorderAggDO[] ciordAggDOs = ciorderService.findByBIds(id_ors, FBoolean.False);
            //医保审核数据
            XapDataList<OrdSrvDO> hpData = new XapDataList<OrdSrvDO>();
            foreach (CiorderAggDO aggDO in ciordAggDOs)
            {
                CiOrderDO ciOrderDO = aggDO.getParentDO();
                if (ciOrderDO.Eu_hpindicjudge == (int)HpIndicJudgeEnum.NONEEDJUDGE) continue;
                OrdSrvDO[] ordSrvDOs = aggDO.getOrdSrvDO();

                foreach (OrdSrvDO ordSrvDO in ordSrvDOs)
                {
                    // 如果是药品 并且是待判断的，才显示，非药品的不显示
                    if (ciOrderDO.Sd_srvtp.StartsWith(BdSrvTpDictCodeConst.SD_SRVTP_DRUG))
                    {
                        if (ordSrvDO.Fg_hpindicjudged == (int)HpIndicJudgeEnum.WAITINGJUDGE)
                        {
                            hpData.Add(ordSrvDO);
                        }
                    }
                    else if(ordSrvDO.Fg_bl == FBoolean.True)
                    {
                        hpData.Add(ordSrvDO);
                    }
                }                
            }
            return hpData;
        }
        protected virtual void freshOrderResultData(object obj, XCellRender cell) { 
            
        }
    }
}

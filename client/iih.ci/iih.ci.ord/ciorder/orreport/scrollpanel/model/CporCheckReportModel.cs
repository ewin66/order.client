
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.d;
using xap.rui.appfw;
using xap.mw.serviceframework;
using iih.ci.ord_stub.i;
using iih.ci.ord.ciorder.i;
using xap.mw.core.data;
using xap.mw.core.utils;

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
    public class CporCheckReportModel : BaseCheckReportModel
    {
        internal void save(XapDataList<CiOrderDO> dataSource, string[] id_ors)
        {
            try
            {
                List<string> id_deletes = new List<string>();
                for (int i = dataSource.Count - 1; i >= 0; i--)
                {
                    CiOrderDO ciOrderDO = dataSource[i];
                    if (ciOrderDO.Eu_uncpordoctorjudge == 0)
                    {
                        ciOrderDO.Eu_uncporjudge = (int)HpIndicJudgeEnum.WAITINGJUDGE;
                    }
                    else if (ciOrderDO.Eu_uncpordoctorjudge == 1)
                    {
                        ciOrderDO.Eu_uncporjudge = (int)HpIndicJudgeEnum.JUDGED;
                    }
                    else if (ciOrderDO.Eu_uncpordoctorjudge == 2)
                    {
                        id_deletes.Add(ciOrderDO.Id_or);
                        dataSource.Remove(ciOrderDO);
                    }
                }
                ICiOrdMaintainService mainService = XapServiceMgr.find<ICiOrdMaintainService>();
                mainService.saveCporCheckReport(dataSource,id_deletes.ToArray());
                //if (id_deletes.Count > 0)
                //{
                //    mainService.relDeleteOrder(id_deletes.ToArray());
                //}
                //if (dataSource.Count > 0)
                //{
                //    ICiorderMDOCrudService orderService = XapServiceMgr.find<ICiorderMDOCrudService>();
                //    orderService.save(dataSource);
                //}
            }
            catch (Exception ex) {
                ex.Publish();
            }
            
        }
    }
}

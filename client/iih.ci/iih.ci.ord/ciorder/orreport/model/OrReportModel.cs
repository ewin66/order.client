
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.i;
using xap.mw.serviceframework;
using xap.mw.coreitf.d;
using iih.ci.ord.ciorder.d;
using xap.rui.appfw;
using xap.cli.sdk.controls.DataView;
using iih.ci.ord.ciorder.utils;
using xap.cli.sdk.controls.DataView.Extension.XOrderResult;
using iih.ci.ord.skintest.d;
using iih.bd.bc.udi;
using iih.ci.ord.i;
using xap.mw.core.data;

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
    public class OrReportModel
    {
        private ICiorderCrudService ciorderService;
        private ICiOrdQryService icOrdQryService;
        public OrReportModel() {
            ciorderService = XapServiceMgr.find<ICiorderCrudService>();
            icOrdQryService = XapServiceMgr.find<ICiOrdQryService>();
        }

        /// <summary>
        /// 获取医保审核，临床路径审核数据
        /// </summary>
        /// <param name="id_ors"></param>
        /// <returns></returns>
        public Dictionary<int, object> getReportData(string[] id_ors)
        {
            Dictionary<int, object> dataDic = new Dictionary<int, object>();
            CiorderAggDO[] ciordAggDOs = ciorderService.findByBIds(id_ors, FBoolean.False);
            FMap2 map2 = icOrdQryService.getMMName(id_ors);
            //医保审核数据
            // 医嘱列表中的适应症提示按钮弹出信息
            //1、显示需要医生干预的适应症条目。
            //2、医生干预后的也需要显示。
            //3、显示内容为费用项目
            XapDataList<OrdSrvDO> hpData = new XapDataList<OrdSrvDO>();
            foreach (CiorderAggDO aggDO in ciordAggDOs)
            {

                CiOrderDO ciOrderDO = aggDO.getParentDO();
                // 如果医保校验结果为不需要判断，不在医保审核列表显示
                if (ciOrderDO.Eu_hpindicjudge == (int)HpIndicJudgeEnum.NONEEDJUDGE) continue;

                OrdSrvDO[] ordSrvDOs = aggDO.getOrdSrvDO();
                // 遍历服务项目获取医生判断的费用项目
                foreach (OrdSrvDO ordSrvDO in ordSrvDOs)
                {
                    // 如果是药品 并且是待判断的，才显示，非药品的不显示
                    if (ciOrderDO.Sd_srvtp.StartsWith(BdSrvTpDictCodeConst.SD_SRVTP_DRUG))
                    {
                        if (ordSrvDO.Fg_hpindicjudged != (int)HpIndicJudgeEnum.NONEEDJUDGE)
                        {
                            if (map2 != null)
                            {
                                if (map2[ordSrvDO.Id_orsrv] != null)
                                {
                                    string name = (string)map2[ordSrvDO.Id_orsrv];
                                    string name_srv = ordSrvDO.Name;
                                    ordSrvDO.Name = name_srv + "(" + name + ")";
                                    hpData.Add(ordSrvDO);
                                }
                                else
                                {
                                    hpData.Add(ordSrvDO);
                                }

                            }
                            else
                            {
                                hpData.Add(ordSrvDO);
                            }
                        }
                    }
                    else if (ordSrvDO.Fg_bl == FBoolean.True)
                    {
                        hpData.Add(ordSrvDO);
                    }

                    // if (ordSrvDO.Fg_hpindicjudged == (int)HpIndicJudgeEnum.NONEEDJUDGE || ordSrvDO.Fg_bl == FBoolean.False) continue;
                    //if (ordSrvDO.Fg_bl != FBoolean.True) continue;
                    //hpData.Add(ordSrvDO);
                }
            }
            if (hpData.Count > 0)
            {
                dataDic.Add(ReportCodeDict.HP_REPORT_CODE, hpData);
            }
            //临床路径审核数据
            XapDataList<CiOrderDO> uncporData = new XapDataList<CiOrderDO>();
            foreach (CiorderAggDO aggDO in ciordAggDOs)
            {
                CiOrderDO ciOrderDO = aggDO.getParentDO();
                //门诊不含有临床路径
                if (BdFcDictCodeConst.SD_CODE_ENTP_OP.Equals(ciOrderDO.Code_entp))
                {
                    continue;
                }
                //临床路径的:0不判断,1待判断，2已判断
                if (ciOrderDO.Eu_uncporjudge == (int)HpIndicJudgeEnum.NONEEDJUDGE) continue;
                uncporData.Add(ciOrderDO);
            }
            if (uncporData.Count > 0)
            {
                dataDic.Add(ReportCodeDict.UNCPOR_REPORT_CODE, uncporData);
            }
            return dataDic;
        }

        public void buildOrderResultData(CiOrderDO ciorderdo, XCellRender cell)
        {
            ICiorderMDOCrudService orderService = XapServiceMgr.find<ICiorderMDOCrudService>();
            CiOrderDO dborderdo = orderService.findById(ciorderdo.Id_or);
            if (dborderdo == null)
            {
                ciorderdo.SetDeleted();
                return;
            }
            ciorderdo.Eu_hpindicjudge = dborderdo.Eu_hpindicjudge;
            ciorderdo.Eu_uncporjudge = dborderdo.Eu_uncporjudge;
            List<XOrderResultData> resultList = cell.Value as List<XOrderResultData>;
            //LogicEx.GetInstance().getHpXOrderResultData(ciorderdo, resultList[0]);
            //LogicEx.GetInstance().getCporHpXOrderResultData(ciorderdo, resultList[1]);
            cell.Value = OrReportPictureButton.GetInstance().buildOrderResultData(dborderdo);
        }
    }
}

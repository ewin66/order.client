
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.d;
using xap.cli.sdk.controls.DataView.Extension.XOrderResult;
using iih.bd.bc.udi;
using iih.ci.ord.skintest.i;
using xap.mw.serviceframework;
using iih.ci.ord.skintest.d;
using xap.sys.xbd.udi.d;
using iih.bd.pp.com.i;
using xap.rui.uipattern2.basemodel.sysinfo;

namespace iih.ci.ord.ciorder.utils
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.utils    </para>    
    /// <para>类 名 称 :  OrReportPictureButton					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/11/23 19:01:52             </para>
    /// <para>更新时间 :  2016/11/23 19:01:52             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OrReportPictureButton
    {
        private static OrReportPictureButton orpb = null;
        private OrReportPictureButton()
        {
            IUdidocHelperService udidocService = XapServiceMgr.find<IUdidocHelperService>();
            // 获取医嘱审核类型及结果类型
            UdidocDO[] udidocs = UdiDocCache.GetInstance().GetUdidocList(CiDictCodeTypeConst.SD_ORAUDITSTATUS);
            if (udidocs == null)
            {
                return;
            }
            IEnumerable<UdidocDO> expenseIterator =
               from emsSrvItem in udidocs
               where emsSrvItem.Ctrl1 == "Y" && emsSrvItem.Code != "02" && emsSrvItem.Code != "01"
               select emsSrvItem;
            map.Add(EnDictCodeConst.SD_ENTP_OUTPATIENT, expenseIterator.ToArray().OrderBy(p => p.Ctrl3).ToArray());
            expenseIterator =
            from emsSrvItem in udidocs
            where emsSrvItem.Ctrl2 == "Y" && emsSrvItem.Code != "02" && emsSrvItem.Code != "01"
            select emsSrvItem;
            map.Add(EnDictCodeConst.SD_ENTP_INPATIENT, expenseIterator.ToArray().OrderBy(p => p.Ctrl4).ToArray());
        }
        public static OrReportPictureButton GetInstance()
        {
            if (orpb == null) {
                orpb = new OrReportPictureButton();
            }
            return orpb;
        }
        private Dictionary<string,UdidocDO[]> map = new Dictionary<string,UdidocDO[]>();
        
        /// <summary>
        /// 医嘱报告列组装数据
        /// </summary>
        /// <param name="ciorderdo"></param>
        /// <returns></returns>
        public List<XOrderResultData> buildOrderResultData(CiOrderDO ciorderdo)
        {
            List<XOrderResultData> resultList = new List<XOrderResultData>();
            UdidocDO[] udidocs=null;
            if (ciorderdo.Code_entp.Equals(EnDictCodeConst.SD_ENTP_OUTPATIENT) || ciorderdo.Code_entp.Equals(EnDictCodeConst.SD_ENTP_EMERGENCY))
            {
                udidocs = map[EnDictCodeConst.SD_ENTP_OUTPATIENT];
            }
            else if (ciorderdo.Code_entp.Equals(EnDictCodeConst.SD_ENTP_INPATIENT))
            {
                udidocs = map[EnDictCodeConst.SD_ENTP_INPATIENT];
            }
            if (udidocs == null || udidocs.Length == 0)
            {
                return buildOrderResultData_old(ciorderdo);
            }
            
            foreach (UdidocDO udidoc in udidocs)
            {
                string code = udidoc.Code;
                if (string.IsNullOrEmpty(code)) continue;
                switch (code)
                {
                    case CiDictCodeConst.SD_ORAUDITRSTSHOWADM_AUDIT_CP:// 临床路径审核
                        resultList.Add(this.getCporHpXOrderResultData(ciorderdo));
                        break;
                    case CiDictCodeConst.SD_ORAUDITRSTSHOWADM_AUDIT_HP: // 医保审核
                        resultList.Add(this.getHpXOrderResultData(ciorderdo));
                        break;
                    case CiDictCodeConst.SD_ORAUDITRSTSHOWADM_AUDIT_PHARM: // 药品审核
                        resultList.Add(this.getDrugXOrderResultData(ciorderdo));
                        break;
                    case CiDictCodeConst.SD_ORAUDITRSTSHOWADM_RST_MT: // 检查结果
                        resultList.Add(this.getCheckXOrderResultData(ciorderdo));
                        break;
                    case CiDictCodeConst.SD_ORAUDITRSTSHOWADM_RST_SKINTEST: // 皮试结果
                        resultList.Add(this.getSkinXOrderResultData(ciorderdo));
                        break;
                    case CiDictCodeConst.SD_ORAUDITRSTSHOWADM_RST_BL: // 费用结果
                        resultList.Add(this.getBLResultData(ciorderdo));
                        break;
                }
            }
            return resultList;
        }
        /// <summary>
        /// 医嘱报告列组装数据
        /// </summary>
        /// <param name="ciorderdo"></param>
        /// <returns></returns>
        public List<XOrderResultData> buildOrderResultData_old(CiOrderDO ciorderdo)
        {
            List<XOrderResultData> resultList = new List<XOrderResultData>();
            //医保的
            XOrderResultData resultData = getHpXOrderResultData(ciorderdo);
            resultList.Add(resultData);

            //临床路径的:0不判断,1待判断，2已判断
            resultData = getCporHpXOrderResultData(ciorderdo);
            resultList.Add(resultData);

            //检查或检验
            resultData = getCheckXOrderResultData(ciorderdo);
            resultList.Add(resultData);


            //皮试
            resultData = getSkinXOrderResultData(ciorderdo);
            resultList.Add(resultData);

            //药品
            resultData = getDrugXOrderResultData(ciorderdo);
            resultList.Add(resultData);

            return resultList;
        }
        public XOrderResultData getDrugXOrderResultData(CiOrderDO ciorderdo, XOrderResultData resultData = null)
        {
            resultData = resultData == null ? new XOrderResultData() : resultData;
            resultData.Value = "0";
            resultData.Type = "5";
            if (ciorderdo.Eu_verify_pharm != null)
            {
                if (ciorderdo.Eu_verify_pharm == 0)
                {
                    resultData.ImagePath = "\\res\\image\\checkresult\\药品未审核.png";
                    resultData.ValueText = "药品-未审核";
                }
                else if (ciorderdo.Eu_verify_pharm == 1)
                {
                    resultData.ImagePath = "\\res\\image\\checkresult\\药品已审核.png";
                    resultData.ValueText = "药品-审核通过";
                }
                else if (ciorderdo.Eu_verify_pharm == 2)
                {
                    resultData.ImagePath = "\\res\\image\\checkresult\\药品审核驳回.png";
                    resultData.ValueText = "药品-审核驳回";
                }
                else if (ciorderdo.Eu_verify_pharm == 3)
                {
                    resultData.ImagePath = "\\res\\image\\checkresult\\药品强制执行.png";
                    resultData.ValueText = "强制执行";
                }
            }
            return resultData;
        }
        public XOrderResultData getSkinXOrderResultData(CiOrderDO ciorderdo, XOrderResultData resultData = null)
        {
            resultData = resultData == null ? new XOrderResultData() : resultData;
            resultData.Value = "0";
            resultData.Type = "4";
            if (BdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST.Equals(ciorderdo.Sd_srvtp))
            {
                ISkintestCrudService skinService = XapServiceMgr.find<ISkintestCrudService>();
                CiSkinTestRstDO[] rstDos = skinService.find(string.Format("id_or='{0}'", ciorderdo.Id_or), "", false);
                if (rstDos != null && rstDos.Length > 0)
                {
                    string rstSkin = rstDos[0].Sd_rst_skintest;
                    if (string.IsNullOrEmpty(rstSkin))
                    {
                        resultData.ImagePath = "\\res\\image\\checkresult\\皮试-未出.png";
                        resultData.ValueText = "皮试-结果未出";
                    }
                    else
                    {
                        //阴性
                        if (rstSkin.Substring(0, 1).Equals("0"))
                        {
                            resultData.ImagePath = "\\res\\image\\checkresult\\皮试-阴性.png";
                            resultData.ValueText = "皮试-阴性";
                        }//阳性
                        else if (rstSkin.Substring(0, 1).Equals("1"))
                        {
                            resultData.ImagePath = "\\res\\image\\checkresult\\皮试-阳性.png";
                            resultData.ValueText = "皮试-阳性";
                        }

                    }
                }
            }
            return resultData;
        }
        public XOrderResultData getCheckXOrderResultData(CiOrderDO ciorderdo, XOrderResultData resultData = null)
        {
            resultData = resultData == null ? new XOrderResultData() : resultData;
            resultData.Value = "0";
            resultData.Type = "3";
            if (ciorderdo.Sd_srvtp==null||(!ciorderdo.Sd_srvtp.Substring(0, 2).Equals("02") && !ciorderdo.Sd_srvtp.Substring(0, 2).Equals("03")))
            {
                return resultData;
            }
            string str = "";
            if (!string.IsNullOrEmpty(ciorderdo.Sd_srvtp))
            {
                if (ciorderdo.Sd_srvtp.Substring(0, 2).Equals("02"))
                {
                    str = "检查-";
                }
                else if (ciorderdo.Sd_srvtp.Substring(0, 2).Equals("03"))
                {
                    str = "检验-";

                }

                if (string.IsNullOrEmpty(ciorderdo.Sd_orrsttp) || ciorderdo.Sd_orrsttp.Equals("4"))
                {
                    resultData.ImagePath = "\\res\\image\\checkresult\\检查-未出.png";
                    resultData.ValueText = str + "未出";
                    resultData.Value = "0";
                }
                else if (ciorderdo.Sd_orrsttp.Equals("0") || ciorderdo.Sd_orrsttp.Equals("1") || ciorderdo.Sd_orrsttp.Equals("3"))
                {
                    resultData.ImagePath = "\\res\\image\\checkresult\\检查-初出.png";
                    resultData.ValueText = str + "初出";
                    resultData.Value = "1";
                }
                else if (ciorderdo.Sd_orrsttp.Equals("2"))
                {
                    resultData.ImagePath = "\\res\\image\\checkresult\\检查-已出.png";
                    resultData.ValueText = str + "已出";
                    resultData.Value = "1";
                }
            }

            return resultData;
        }
        public XOrderResultData getHpXOrderResultData(CiOrderDO ciorderdo, XOrderResultData resultData = null)
        {
            resultData = resultData == null ? new XOrderResultData() : resultData;
            resultData.Type = "1";
            if (ciorderdo.Eu_hpindicjudge != null)
            {
                resultData.ID_or = ciorderdo.Id_or;
                switch (ciorderdo.Eu_hpindicjudge)
                {
                    case (int)HpIndicJudgeEnum.NONEEDJUDGE:
                        resultData.Value = "0";
                        resultData.ImagePath = "";
                        resultData.ValueText = "医保-不需要判断";
                        break;
                    case (int)HpIndicJudgeEnum.JUDGED:
                        resultData.ImagePath = "\\res\\image\\checkresult\\医保-已判断.png";
                        resultData.Value = "1";
                        resultData.ValueText = "医保-已判断";
                        break;
                    case (int)HpIndicJudgeEnum.WAITINGJUDGE:
                        resultData.ImagePath = "\\res\\image\\checkresult\\医保-待判断.png";
                        resultData.Value = "1";
                        resultData.ValueText = "医保-待判断";
                        break;
                    case (int)HpIndicJudgeEnum.SELFPAY:
                       resultData.ImagePath = "\\res\\image\\checkresult\\自费.png";
                    resultData.Value = "";
                    resultData.ValueText = "自费";
                        break;

                    } 
               
                
            }
            return resultData;
        }
        /// <summary>
        /// 临床路径的判断
        /// </summary>
        /// <param name="ciorderdo"></param>
        /// <param name="resultData"></param>
        /// <returns></returns>
        public XOrderResultData getCporHpXOrderResultData(CiOrderDO ciorderdo, XOrderResultData resultData = null)
        {
            resultData = resultData == null ? new XOrderResultData() : resultData;
            resultData.Type = "2";
            if (ciorderdo.Eu_uncporjudge != null)
            {
                resultData.ID_or = ciorderdo.Id_or;
                switch (ciorderdo.Eu_uncporjudge)
                {
                    case (int)HpIndicJudgeEnum.WAITINGJUDGE:
                        resultData.ImagePath = "\\res\\image\\checkresult\\临床路径待判断.png";
                        resultData.Value = "1";
                        resultData.ValueText = "临床-待判断";
                        break;
                    case (int)HpIndicJudgeEnum.JUDGED:
                        resultData.ImagePath = "\\res\\image\\checkresult\\临床路径已判断.png";
                        resultData.Value = "1";
                        resultData.ValueText = "临床-已判断";
                        break;
                    case (int)HpIndicJudgeEnum.NONEEDJUDGE:
                        resultData.Value = "0";
                        resultData.ImagePath = "";
                        resultData.ValueText = "临床-不需要判断";
                        break;

                }
            }
            return resultData;
        }
        /// <summary>
        /// 费用标识
        /// </summary>
        /// <param name="ciorderdo"></param>
        /// <param name="resultData"></param>
        /// <returns></returns>
        public XOrderResultData getBLResultData(CiOrderDO ciorderdo, XOrderResultData resultData = null)
        {
            resultData = resultData == null ? new XOrderResultData() : resultData;
            resultData.Type = "6";
            if (ciorderdo.Sd_su_bl != null)
            {
                resultData.ID_or = ciorderdo.Id_or;
                switch (ciorderdo.Sd_su_bl)
                {
                    case "0":
                        resultData.ImagePath = "\\res\\image\\checkresult\\未记账.png";
                        resultData.Value = "0";
                        resultData.ValueText = "未记账";
                        break;
                    case "1":
                        resultData.ImagePath = "\\res\\image\\checkresult\\已记账.png";
                        resultData.Value = "0";
                        resultData.ValueText = "已记账";
                        break;
                    case "2":
                        resultData.ImagePath = "\\res\\image\\checkresult\\退费.png";
                        resultData.Value = "0";
                        resultData.ValueText = "已退费";
                        break;
                    default:
                        resultData.ImagePath = "\\res\\image\\checkresult\\收费异常.png";
                        resultData.Value = "0";
                        resultData.ValueText = "收费异常";
                        break;

                }
            }
            return resultData;
        }
        public Dictionary<string, UdidocDO[]> getMap()
        {
            return this.map;
        }
    }
}

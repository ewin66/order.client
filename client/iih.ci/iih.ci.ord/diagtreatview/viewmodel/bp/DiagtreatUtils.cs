using System;
using System.Collections.Generic;
using System.Linq;
using iih.ci.ord.cilab.view;
using iih.ci.ord.ciobs.view;
using iih.ci.ord.dto.blexorder.d;
using iih.ci.ord.opippathgy.view;
using iih.en.pv.dto.d;
using iih.mp.nr.temperaturechart.d;
using xap.cli.sdk.chart;
using xap.mw.core.data;
using xap.rui.bizcontrol.ClinicalTimeline.enums;
using xap.rui.bizcontrol.ClinicalTimeline.reportTypeInfo;
using xap.rui.bizcontrol.vitalsign.model;

namespace iih.ci.ord.diagtreatview.viewmodel.bp
{
    public class DiagtreatUtils
    {
        public static List<SrvSplitOrderDTO> filterSrvs(FArrayList2 srvs)
        {
            if (srvs == null)
                return null;
            var rntsrvs = new List<SrvSplitOrderDTO>();
            foreach (SrvSplitOrderDTO splitOrderDto in srvs)
            {
                if (splitOrderDto.Dt_mp_plan != null)
                    rntsrvs.Add(splitOrderDto);
            }
            return rntsrvs;
        }

        public static List<ItemInfo> setVidata2(FArrayList2 fa)
        {
            List<ItemInfo> items1 = convertData(fa.Cast<Temcharitemdto>().ToArray());
            return items1;
        }

        /// <summary>
        ///     数据转换至体温单适配的数据
        /// </summary>
        private static List<ItemInfo> convertData(object[] List)
        {
            var reList = new List<ItemInfo>();
            foreach (Temcharitemdto data in List)
            {
                var item = new ItemInfo();
                item.Id = data.Id_item;
                item.Code = data.Name;
                item.Name = data.Name;
                item.Value = data.Value;
                item.Unit = data.Unit;
                item.LogTime = (DateTime) data.Logtime;
                item.Marker = data.Id_aux;
                item.BodyPart = data.Id_pos;
                reList.Add(item);
            }
            return reList;
        }


        public static void showTrendView(CliTestView cliiew, Ent4BannerDTO ent4BannerDto)
        {
            String buttonText = cliiew.ShowReportButton.Text;
            if (!String.IsNullOrEmpty(buttonText) && buttonText.Equals("趋势图"))
            {
                if (ent4BannerDto == null || ent4BannerDto.Id_ent == null)
                    return;
                CliTestView TestView = cliiew;
                var lisView = (CiRptLabView) TestView.DataView;
                string[] title = lisView.getHeader();
                List<Reportlab> rpts = lisView.getlisRptList(ent4BannerDto.Id_pat, title[2]);
                if (rpts == null || rpts.Count == 0)
                    return;
                TestView.ShowReportButton.Enabled = true;
                TestView.TestHeadRender.Name = title[0];
                TestView.TestHeadRender.ApplyReportId = title[1];
                TestView.TestHeadRender.ReportTime = title[2];
                TestView.TestHeadRender.ReportStatus = title[3];
                TestView.LineChart.DataSource = rpts;

                TestView.ShowReportButton.Text = "返回";
                TestView.cliTestControl.Visible = false;

                TestView.TestHeadRender.Visible = true;
                TestView.LineChartBaseControl.Visible = true;

                TestView.LineChartBaseControl.Invalidate();
                TestView.Invalidate();
            }
            else
            {
                cliiew.ShowReportButton.Text = "趋势图";
                cliiew.TestHeadRender.Visible = false;
                cliiew.LineChartBaseControl.Visible = false;
                cliiew.cliTestControl.Visible = true;

                cliiew.Invalidate();
            }
        }

        public static void showreport(CliTestView TestView, ClinicalExeEventStatus ReportType, String Id)
        {
            if (ReportType.ToString().ToLower() == "lis")
            {
                var lab = new CiRptLabView();
                lab.setlabdto(Id, ReportType.ToString().ToLower(), TestView);
                TestView.DataView = lab;
                TestView.ShowReportButton.Text = "趋势图";
                TestView.Text = "检验报告";
                TestView.ShowReportButton.Enabled = false;
            }
            else if (ReportType.ToString().ToLower() == "ris")
            {
                var obs = new CIRptObsView();
                obs.setlabdto(Id, ReportType.ToString().ToLower());
                TestView.DataView = obs;
                TestView.ShowReportButton.Text = "影像";
                TestView.ReportStatus = ClinicalExeEventStatus.RIS;
                //         TestView.ShowReportButton.Text = "趋势图";
                TestView.Text = "检查报告";
            }
            else if (ReportType == ClinicalExeEventStatus.Pathol)
            {
                var pathol = new OpippathgyCardView();
                pathol.setPatholdto(Id, ReportType.ToString().ToLower());
                TestView.DataView = pathol;
                TestView.ReportStatus = ClinicalExeEventStatus.Pathol;
                TestView.ShowReportButton.Text = "影像";
                TestView.Text = "病理报告";
            }
        }

        /// <summary>
        ///     对检查数据进行分类
        /// </summary>
        /// <param name="labbasedtos"></param>
        /// <returns></returns>
        public static Dictionary<ClinicalExeEventStatus, List<OrSplitOrderDTO>> mergeRisDTO(
            OrSplitOrderDTO[] labbasedtos)
        {
            var dic = new Dictionary<ClinicalExeEventStatus, List<OrSplitOrderDTO>>();
            foreach (OrSplitOrderDTO orSplitOrderDto in labbasedtos)
            {
                if (orSplitOrderDto.Sd_orsrvtp.StartsWith("0207"))
                {
                    if (dic.ContainsKey(ClinicalExeEventStatus.Pathol))
                    {
                        List<OrSplitOrderDTO> list = dic[ClinicalExeEventStatus.Pathol];
                        list.Add(orSplitOrderDto);
                    }
                    else
                    {
                        var list = new List<OrSplitOrderDTO>();
                        list.Add(orSplitOrderDto);
                        dic.Add(ClinicalExeEventStatus.Pathol, list);
                    }
                }
                else
                {
                    if (dic.ContainsKey(ClinicalExeEventStatus.RIS))
                    {
                        List<OrSplitOrderDTO> list = dic[ClinicalExeEventStatus.RIS];
                        list.Add(orSplitOrderDto);
                    }
                    else
                    {
                        var list = new List<OrSplitOrderDTO>();
                        list.Add(orSplitOrderDto);
                        dic.Add(ClinicalExeEventStatus.RIS, list);
                    }
                }
            }
            return dic;
        }
    }
}
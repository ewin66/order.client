using System;
using System.Collections.Generic;
using System.Linq;
using iih.ci.ord.dto.blexorder.d;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.rui.bizcontrol.ClinicalTimeline;
using xap.rui.bizcontrol.ClinicalTimeline.common;
using xap.rui.bizcontrol.ClinicalTimeline.enums;
using xap.rui.bizcontrol.ClinicalTimeline.info;

namespace iih.ci.ord.diagtreatview.adapter
{
    public class DrugAdapter
    {
        public ExeRouteGroupModel GetGroupModelN(string name,
            FArrayList fa, FDateTime dt)
        {
            var exeRouteGroup = new ExeRouteGroupModel();
            exeRouteGroup.Name = name;
            if (fa.Count == 0) return exeRouteGroup;
            var dict = (Dictionary<string, Dictionary<string, List<TransSrvSplitOrderDTO>>>) fa[0];
            var tranlist = (List<TransSrvSplitOrderDTO>) fa[1];
            foreach (TransSrvSplitOrderDTO transSrvSplitOrderDto in tranlist)
            {
                var routeMap = new RouteMap();
                routeMap.StartDay = dt;
                Dictionary<string, List<TransSrvSplitOrderDTO>> dic = dict[transSrvSplitOrderDto.Id_srv];
                List<TransSrvSplitOrderDTO> a = dic[dic.Keys.First()];
                routeMap.Name = a[0].Name_srv;
                var listperiod = new List<List<DateTime>>();
                foreach (string keys in dic.Keys)
                {
                    List<TransSrvSplitOrderDTO> list = dic[keys];
                    if (!list[0].Fg_long.Value) //list.Count == 1
                    {
                        if (list[0].Dt_mp_plan == null) continue;

                        var mark = new RouteMark();
                        mark.StartTime = dt;
                        mark.Time = (DateTime) list[0].Dt_mp_plan;
                        mark.IdOr = list[0].Id_or;
                        mark.Id = list[0].Id_or + "_" + list[0].Dt_mp_plan;
                        if (list[0].Orsrv_su_mp == "0")
                        {
                            mark.ExeStatus = ExeStatuses.Pending;
                        }
                        else if (list[0].Orsrv_su_mp == "1")
                        {
                            mark.ExeStatus = ExeStatuses.Executing;
                        }
                        if (list[0].Orsrv_su_mp == "2")
                        {
                            mark.ExeStatus = ExeStatuses.NoEecution;
                        }
                        if (list[0].Orsrv_su_mp == "4")
                        {
                            mark.ExeStatus = ExeStatuses.Executed;
                        }
                        mark.IsLongTerm = false;
                        routeMap.Marks.Add(mark);
                    }
                    else if (list[0].Fg_long.Value) //list.Count > 1
                    {
                        var listd = new List<DateTime>();
                        IOrderedEnumerable<TransSrvSplitOrderDTO> ff = list.OrderBy(item => item.Dt_mp_plan);
                        TransSrvSplitOrderDTO[] srv = ff.ToArray();
                        if (srv.Count() > 1)
                        {
                            DateTime? ps = getbounddt((DateTime) srv[0].Dt_mp_plan, true);
                            DateTime? pe = getbounddt((DateTime) srv[srv.Count() - 1].Dt_mp_plan, false);
                            if (ps != null && pe != null)
                            {
                                listd.Add((DateTime) ps);
                                listd.Add((DateTime) pe);
                                convetdatePeriod(listperiod, listd);
                            }
                        }

                        var RouteAssistMarks = new List<MarkAssist>();
                        foreach (TransSrvSplitOrderDTO splitsrvDto in srv)
                        {
                            var mark = new MarkAssist();
                            if (splitsrvDto.Orsrv_su_mp == "0")
                            {
                                mark.ExeStatus = ExeStatuses.Pending;
                            }
                            else if (splitsrvDto.Orsrv_su_mp == "1")
                            {
                                mark.ExeStatus = ExeStatuses.Executing;
                            }
                            if (splitsrvDto.Orsrv_su_mp == "2")
                            {
                                mark.ExeStatus = ExeStatuses.NoEecution;
                            }
                            if (splitsrvDto.Orsrv_su_mp == "4")
                            {
                                mark.ExeStatus = ExeStatuses.Executed;
                            }
                            mark.IdOr = splitsrvDto.Id_or;
                            mark.Id = splitsrvDto.Id_or + "_" + splitsrvDto.Dt_mp_plan;
                            mark.Time = (DateTime) splitsrvDto.Dt_mp_plan;
                            mark.IsLongTerm = true;
                            if (splitsrvDto.Dt_mp_plan.ToString().Equals(srv[srv.Count() - 1].Dt_mp_plan.ToString()))
                            {
                                //mark.
                                mark.IsEndRourkMark = true;
                            }
                            else
                            {
                                mark.IsEndRourkMark = false;
                            }
                            RouteAssistMarks.Add(mark);
                        }
                        var num = (int) srv[0].Freqcnt;
                        var route = new Route
                        {
                            DailySlot = 6,
                            DailyTimes = num,
                            StartTime = (DateTime) srv[0].Dt_mp_plan,
                            EndTime = (DateTime) srv[srv.Count() - 1].Dt_mp_plan
                        };
                        route.AcStartDateTime = (DateTime) srv[0].Dt_mp_plan;
                        route.RouteAssistMarks = RouteAssistMarks;
                        routeMap.Routes.Add(route);
                    }
                }
                if (routeMap.Marks.Count() == 0 && routeMap.Routes.Count() == 0)
                    continue;
                routeMap.Listperiod = listperiod;
                exeRouteGroup.RouteMaps.Add(routeMap);
            }

            return exeRouteGroup;
        }


        public ExeEventGroupModel getEventGroup(ExeEventGroupModel eventLabelGroupModel,
            List<OrSplitOrderDTO> labbasedtos, ClinicalExeEventStatus type)
        {
            if (labbasedtos != null && labbasedtos.Count() > 0)
            {
                foreach (OrSplitOrderDTO orSplitOrderDto in labbasedtos)
                {
                    var eventLabel = new EventLabelModel(orSplitOrderDto.Name_or, (DateTime) orSplitOrderDto.Dt_mp_plan);
                    eventLabel.Id = orSplitOrderDto.Id_or;
                    eventLabel.NowStates = ExeStatuses.Executed;
                    eventLabel.NowType = type; //

                    if (orSplitOrderDto.Or_mp_status == "0")
                    {
                        eventLabel.NowStates = ExeStatuses.Pending;
                    }
                    if (orSplitOrderDto.Or_mp_status == "1")
                    {
                        eventLabel.NowStates = ExeStatuses.Executing;
                    }
                    if (orSplitOrderDto.Or_mp_status == "2")
                    {
                        eventLabel.NowStates = ExeStatuses.NoEecution;
                    }
                    if (orSplitOrderDto.Or_mp_status == "4")
                    {
                        eventLabel.NowStates = ExeStatuses.Executed;
                    }

                    eventLabelGroupModel.EventLabels.Add(eventLabel);
                }
            }
            return eventLabelGroupModel;
        }


        private DateTime? getbounddt(DateTime dt, bool isbegin)
        {
            //var firstStart = new DateTime(dt.Year, dt.Month, dt.Day, 0, 0, 0);
            //var firstEnd = new DateTime(dt.Year, dt.Month, dt.Day, 5, 59, 59);
            //var secondStart = new DateTime(dt.Year, dt.Month, dt.Day, 6, 0, 0);
            //var secondEnd = new DateTime(dt.Year, dt.Month, dt.Day, 9, 59, 59);
            //var ThirdStart = new DateTime(dt.Year, dt.Month, dt.Day, 10, 0, 0);
            //var ThirdEnd = new DateTime(dt.Year, dt.Month, dt.Day, 13, 59, 59);
            //var FourthStart = new DateTime(dt.Year, dt.Month, dt.Day, 14, 0, 0);
            //var FourthEnd = new DateTime(dt.Year, dt.Month, dt.Day, 17, 59, 59);
            //var FifthStart = new DateTime(dt.Year, dt.Month, dt.Day, 18, 0, 0);
            //var FifthEnd = new DateTime(dt.Year, dt.Month, dt.Day, 21, 59, 59);
            //var SixthStart = new DateTime(dt.Year, dt.Month, dt.Day, 22, 0, 0);
            //var SixthEnd = new DateTime(dt.Year, dt.Month, dt.Day, 23, 59, 59);

            CliTimerScaleInfo cliTimerScaleInfo = CliTimeScale.GetTimerScale(MarkIntervalSegment.First);
            DateTime firstStart = new DateTime(dt.Year, dt.Month, dt.Day, cliTimerScaleInfo.StartPoint.Hour, cliTimerScaleInfo.StartPoint.Minute, cliTimerScaleInfo.StartPoint.Second);
            DateTime firstEnd = new DateTime(dt.Year, dt.Month, dt.Day, cliTimerScaleInfo.EndPoint.Hour, cliTimerScaleInfo.EndPoint.Minute, cliTimerScaleInfo.EndPoint.Second);
            cliTimerScaleInfo = CliTimeScale.GetTimerScale(MarkIntervalSegment.Second);
            DateTime secondStart = new DateTime(dt.Year, dt.Month, dt.Day, cliTimerScaleInfo.StartPoint.Hour, cliTimerScaleInfo.StartPoint.Minute, cliTimerScaleInfo.StartPoint.Second);
            DateTime secondEnd = new DateTime(dt.Year, dt.Month, dt.Day, cliTimerScaleInfo.EndPoint.Hour, cliTimerScaleInfo.EndPoint.Minute, cliTimerScaleInfo.EndPoint.Second);
            cliTimerScaleInfo = CliTimeScale.GetTimerScale(MarkIntervalSegment.Third);
            DateTime ThirdStart = new DateTime(dt.Year, dt.Month, dt.Day, cliTimerScaleInfo.StartPoint.Hour, cliTimerScaleInfo.StartPoint.Minute, cliTimerScaleInfo.StartPoint.Second);
            DateTime ThirdEnd = new DateTime(dt.Year, dt.Month, dt.Day, cliTimerScaleInfo.EndPoint.Hour, cliTimerScaleInfo.EndPoint.Minute, cliTimerScaleInfo.EndPoint.Second);
            cliTimerScaleInfo = CliTimeScale.GetTimerScale(MarkIntervalSegment.Fourth);
            DateTime FourthStart = new DateTime(dt.Year, dt.Month, dt.Day, cliTimerScaleInfo.StartPoint.Hour, cliTimerScaleInfo.StartPoint.Minute, cliTimerScaleInfo.StartPoint.Second);
            DateTime FourthEnd = new DateTime(dt.Year, dt.Month, dt.Day, cliTimerScaleInfo.EndPoint.Hour, cliTimerScaleInfo.EndPoint.Minute, cliTimerScaleInfo.EndPoint.Second);
            cliTimerScaleInfo = CliTimeScale.GetTimerScale(MarkIntervalSegment.Fifth);
            DateTime FifthStart = new DateTime(dt.Year, dt.Month, dt.Day, cliTimerScaleInfo.StartPoint.Hour, cliTimerScaleInfo.StartPoint.Minute, cliTimerScaleInfo.StartPoint.Second);
            DateTime FifthEnd = new DateTime(dt.Year, dt.Month, dt.Day, cliTimerScaleInfo.EndPoint.Hour, cliTimerScaleInfo.EndPoint.Minute, cliTimerScaleInfo.EndPoint.Second);
            cliTimerScaleInfo = CliTimeScale.GetTimerScale(MarkIntervalSegment.Sixth);
            DateTime SixthStart = new DateTime(dt.Year, dt.Month, dt.Day, cliTimerScaleInfo.StartPoint.Hour, cliTimerScaleInfo.StartPoint.Minute, cliTimerScaleInfo.StartPoint.Second);
            DateTime SixthEnd = new DateTime(dt.Year, dt.Month, dt.Day, cliTimerScaleInfo.EndPoint.Hour, cliTimerScaleInfo.EndPoint.Minute, cliTimerScaleInfo.EndPoint.Second);
            

            if (DateTime.Compare(dt, firstStart) >= 0 && DateTime.Compare(dt, secondStart) < 0)
            {
                if (isbegin)
                {
                    return firstStart;
                }
                return firstEnd;
            }
            if (DateTime.Compare(dt, secondStart) >= 0 && DateTime.Compare(dt, ThirdStart) < 0)
            {
                if (isbegin)
                {
                    return secondStart;
                }
                return secondEnd;
            }
            if (DateTime.Compare(dt, ThirdStart) >= 0 && DateTime.Compare(dt, FourthStart) < 0)
            {
                if (isbegin)
                {
                    return ThirdStart;
                }
                return ThirdEnd;
            }
            if (DateTime.Compare(dt, FourthStart) >= 0 && DateTime.Compare(dt, FifthStart) < 0)
            {
                if (isbegin)
                {
                    return FourthStart;
                }
                return FourthEnd;
            }
            if (DateTime.Compare(dt, FifthStart) >= 0 && DateTime.Compare(dt, SixthStart) < 0)
            {
                if (isbegin)
                {
                    return FifthStart;
                }
                return FifthEnd;
            }
            if (DateTime.Compare(dt, SixthStart) >= 0 && DateTime.Compare(dt, SixthEnd) <= 0)
            {
                if (isbegin)
                {
                    return SixthStart;
                }
                return SixthEnd;
            }

            return null;
        }

        private void convetdatePeriod(List<List<DateTime>> listperiod, List<DateTime> listd)
        {
            var listperiodtmp = new List<List<DateTime>>();

            foreach (var times in listperiod)
            {
                if (isdtcontain(times, listd))
                    listperiodtmp.Add(times);
            }

            if (listperiodtmp.Count > 0)
            {
                List<DateTime> cmbdt = cmbdatetime(listperiodtmp, listd);
                foreach (var list in listperiodtmp)
                {
                    listperiod.Remove(list);
                }
                listperiod.Add(cmbdt);
            }
            else
            {
                listperiod.Add(listd);
            }
        }


        private bool isdtcontain(List<DateTime> times, List<DateTime> listd)
        {
            if (DateTime.Compare(times[0], listd[0]) >= 0 && DateTime.Compare(times[0], listd[1]) <= 0)
                return true;
            if (DateTime.Compare(times[1], listd[0]) >= 0 && DateTime.Compare(times[1], listd[1]) <= 0)
                return true;
            if (DateTime.Compare(listd[0], times[0]) >= 0 && DateTime.Compare(listd[0], times[1]) <= 0)
                return true;
            if (DateTime.Compare(listd[1], times[0]) >= 0 && DateTime.Compare(listd[1], times[1]) <= 0)
                return true;
            return false;
        }

        private List<DateTime> cmbdatetime(List<List<DateTime>> listperiodtmp, List<DateTime> listd)
        {
            var times = new List<DateTime>();
            DateTime s = listd[0];
            DateTime e = listd[1];
            foreach (var dateTimes in listperiodtmp)
            {
                if (DateTime.Compare(dateTimes[0], s) <= 0)
                {
                    s = dateTimes[0];
                }
                if (DateTime.Compare(dateTimes[1], e) >= 0)
                {
                    e = dateTimes[1];
                }
            }
            times.Add(s);
            times.Add(e);
            return times;
        }

        /*
         
           public ExeRouteGroupModel GetGroupModel(string name,
            Dictionary<string, Dictionary<string, List<TransSrvSplitOrderDTO>>> dict, FDateTime dt)
        {
            var exeRouteGroup = new ExeRouteGroupModel();
            exeRouteGroup.Name = name;
            if (dict != null && dict.Count > 0)
            {
                foreach (string key in dict.Keys)
                {
                    var routeMap = new RouteMap();
                    routeMap.StartDay = dt;
                    Dictionary<string, List<TransSrvSplitOrderDTO>> dic = dict[key];
                    List<TransSrvSplitOrderDTO> a = dic[dic.Keys.First()];
                    routeMap.Name = a[0].Name_srv;
                    List<List<DateTime>> listperiod=new List<List<DateTime>>();
                    foreach (string keys in dic.Keys)
                    {
                        List<TransSrvSplitOrderDTO> list = dic[keys];
                        if (!list[0].Fg_long.Value)//list.Count == 1
                        {
                            if (list[0].Dt_mp_plan == null) continue;
                            
                            var mark = new RouteMark();
                            mark.StartTime = dt;
                            mark.Time = (DateTime) list[0].Dt_mp_plan;
                            mark.IdOr = list[0].Id_or;
                            mark.Id = list[0].Id_or + "_" + list[0].Dt_mp_plan;
                            if (list[0].Orsrv_su_mp == "0")
                            {
                                mark.ExeStatus = ExeStatuses.Pending;
                            }
                            else if (list[0].Orsrv_su_mp == "1")
                            {
                                mark.ExeStatus = ExeStatuses.Executing;
                            }
                            if (list[0].Orsrv_su_mp == "2")
                            {
                                mark.ExeStatus = ExeStatuses.NoEecution;
                            }
                            if (list[0].Orsrv_su_mp == "4")
                            {
                                mark.ExeStatus = ExeStatuses.Executed;
                            }
                            mark.IsLongTerm = false;
                            routeMap.Marks.Add(mark);
                        }
                        else if (list[0].Fg_long.Value)//list.Count > 1
                        {
                            List<DateTime> listd=new List<DateTime>();
                            IOrderedEnumerable<TransSrvSplitOrderDTO> ff = list.OrderBy(item => item.Dt_mp_plan);
                            TransSrvSplitOrderDTO[] srv = ff.ToArray();
                            if (srv.Count() > 1)
                            {
                                DateTime? ps = this.getbounddt((DateTime)srv[0].Dt_mp_plan, true);
                                DateTime? pe = this.getbounddt((DateTime)srv[srv.Count()-1].Dt_mp_plan, false);
                                if (ps != null && pe != null)
                                {
                                    listd.Add((DateTime) ps);
                                    listd.Add((DateTime)pe);
                                    convetdatePeriod(listperiod, listd);

                                }
                            }
                           
                            var RouteAssistMarks = new List<MarkAssist>();
                            foreach (TransSrvSplitOrderDTO splitsrvDto in srv)
                            {
                                var mark = new MarkAssist();
                                if (splitsrvDto.Orsrv_su_mp == "0")
                                {
                                    mark.ExeStatus = ExeStatuses.Pending;
                                }
                                else if (splitsrvDto.Orsrv_su_mp == "1")
                                {
                                    mark.ExeStatus = ExeStatuses.Executing;
                                }
                                if (splitsrvDto.Orsrv_su_mp == "2")
                                {
                                    mark.ExeStatus = ExeStatuses.NoEecution;
                                }
                                if (splitsrvDto.Orsrv_su_mp == "4")
                                {
                                    mark.ExeStatus = ExeStatuses.Executed;
                                }
                                mark.IdOr = splitsrvDto.Id_or;
                                mark.Id = splitsrvDto.Id_or + "_" + splitsrvDto.Dt_mp_plan;
                                mark.Time = (DateTime) splitsrvDto.Dt_mp_plan;
                                mark.IsLongTerm = true;
                                if (splitsrvDto.Dt_mp_plan.ToString().Equals(srv[srv.Count() - 1].Dt_mp_plan.ToString()))
                                {
                                    //mark.
                                    mark.IsEndRourkMark = true;
                                }
                                else
                                {
                                    mark.IsEndRourkMark = false;
                                }
                                RouteAssistMarks.Add(mark);
                            }
                            var num = (int) srv[0].Freqcnt;
                            var route = new Route
                            {
                                DailySlot = 6,
                                DailyTimes = num,
                                StartTime = (DateTime) srv[0].Dt_mp_plan,
                                EndTime = (DateTime) srv[srv.Count() - 1].Dt_mp_plan
                            };
                            route.AcStartDateTime = (DateTime) srv[0].Dt_mp_plan;
                            route.RouteAssistMarks = RouteAssistMarks;
                            routeMap.Routes.Add(route);
                        }
                    }
                    if (routeMap.Marks.Count() == 0 && routeMap.Routes.Count() == 0)
                        continue;
                    routeMap.Listperiod = listperiod;
                    exeRouteGroup.RouteMaps.Add(routeMap);
                }
            }
            return exeRouteGroup;
        }
         */
    }
}
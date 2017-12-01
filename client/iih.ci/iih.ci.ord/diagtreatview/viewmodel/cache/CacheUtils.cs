using System;
using System.Collections.Generic;
using System.Diagnostics;
using iih.ci.ord.dto.blexorder.d;
using xap.rui.bizcontrol.vitalsign.model;

namespace iih.ci.ord.diagtreatview.viewmodel
{
    public class CacheUtils : IDisposable
    {
        private readonly CacheIndex cachindex = new CacheIndex();
        public CacheTotal Cache;

        public void Dispose()
        {
            Debug.WriteLine("Dispose called!");
        }

        /// <summary>
        ///     获取用药缓存数据
        /// </summary>
        public List<CashData> queryDrugData(DateTime start, DateTime end)
        {
            //    var st = new DateTime(start.Year, start.Month, start.Day);
            var cashDatas = new List<CashData>();
            List<DateTime> period = getCashperoid();
            if (period != null)
            {
                if (start >= period[0] && end <= period[1])
                {
                    var st = new DateTime(start.Year, start.Month, start.Day);
                    cashDatas = getDrugData(st, end);
                }
            }

            return cashDatas;
        }


        private void SetCachePeriod(DateTime start, DateTime end)
        {
            Cache = cachindex.validatePeriod(start, end);
        }

        /// <summary>
        ///     获取检查检验缓存数据
        /// </summary>
        public List<CashData> queryLabAndObsData(DateTime start, DateTime end)
        {
            var cashDatas = new List<CashData>();
            List<DateTime> period = getCashperoid();
            if (period != null)
            {
                if (start >= period[0] && end <= period[1])
                {
                    var st = new DateTime(start.Year, start.Month, start.Day);
                    cashDatas = getLabAndObsData(st, end);
                }
            }

            return cashDatas;
        }

        /// <summary>
        ///     获取生命体征缓存数据
        /// </summary>
        public List<CashData> queryViTempData(DateTime start, DateTime end)
        {
            var cashDatas = new List<CashData>();
            List<DateTime> period = getCashperoid();
            if (period != null)
            {
                if (start >= period[0] && end <= period[1])
                {
                    var st = new DateTime(start.Year, start.Month, start.Day);
                    cashDatas = getViTempData(st, end);
                }
            }

            return cashDatas;
        }


        /// <summary>
        ///     写srv缓存数据
        /// </summary>
        /// <param name="start"></param>
        /// <param name="end"></param>
        /// <param name="basedtos"></param>
        public void setSrvdatecash(DateTime start, DateTime end, List<SrvSplitOrderDTO> basedtos)
        {
            //   setPeriod(start, end);
            SetCachePeriod(start, end);

            writedatasrv(basedtos, start, end);
        }

        /// <summary>
        ///     写order缓存数据
        /// </summary>
        /// <param name="start"></param>
        /// <param name="end"></param>
        /// <param name="basedtos"></param>
        public void setOrderdatecash(OrSplitOrderDTO[] basedtos, string type, DateTime start, DateTime end)
        {
            //  setPeriod(start, end);
            SetCachePeriod(start, end);
            writedataOrder(basedtos, type, start, end);
        }

        public void setViDataCash(List<ItemInfo> Vidata, DateTime start, DateTime end)
        {
            // setPeriod(start, end);

            SetCachePeriod(start, end);
            writeViData(Vidata, start, end);
        }

        /// <summary>
        ///     校验是否取缓存
        /// </summary>
        /// <param name="start"></param>
        /// <param name="end"></param>
        /// <returns></returns>
        public bool isPeriodContain(DateTime start, DateTime end)
        {
            CacheTotal ca = cachindex.getCachePeriod(start, end);
            if (ca == null)
                return false;
            Cache = ca;
            return true;
        }


        /// <summary>
        ///     获取缓存区间
        /// </summary>
        /// <returns></returns>
        private List<DateTime> getCashperoid()
        {
            if (Cache == null || Cache.HasCache == -1) return null;
            var list = new List<DateTime>();

            list.Add(Cache.StartTime);
            list.Add(Cache.EndTime);
            return list;
        }

        /// <summary>
        ///     获取缓存数据
        /// </summary>
        private List<CashData> getDrugData(DateTime start, DateTime end)
        {
            var cashDatas = new List<CashData>();
            foreach (CashData cashData in Cache.CacheDrugList)
            {
                if (cashData.Dt >= start && cashData.Dt <= end)
                    cashDatas.Add(cashData);
            }

            return cashDatas;
        }

        /// <summary>
        ///     获取检查检验缓存数据
        /// </summary>
        private List<CashData> getLabAndObsData(DateTime start, DateTime end)
        {
            var cashDatas = new List<CashData>();
            foreach (CashData cashData in Cache.CacheLabAndObsList)
            {
                if (cashData.Dt >= start && cashData.Dt <= end)
                    cashDatas.Add(cashData);
            }

            return cashDatas;
        }

        /// <summary>
        ///     获取生命体征缓存数据
        /// </summary>
        private List<CashData> getViTempData(DateTime start, DateTime end)
        {
            var cashDatas = new List<CashData>();
            foreach (CashData cashData in Cache.CacheTempList)
            {
                if (cashData.Dt >= start && cashData.Dt <= end)
                    cashDatas.Add(cashData);
            }

            return cashDatas;
        }

        private void writedatasrv(List<SrvSplitOrderDTO> basedtos, DateTime start, DateTime end)
        {
            if (Cache.CacheDrugList == null)
                Cache.CacheDrugList = new List<CashData>();
            List<DateTime> dtlist = getDatePeriod(start, end);

            //获取所有的用药数据，按天分类 
            Dictionary<DateTime, List<SrvSplitOrderDTO>> diclist = getSrvlistPerDay(basedtos);
            //获取该区间内的所有缓存数据
            Dictionary<DateTime, CashData> calist = getSrvCathePerDay(start, end);
            //组合所有的数据
            comby(diclist, calist, dtlist);
        }

        private void comby(Dictionary<DateTime, List<SrvSplitOrderDTO>> dicsrv,
            Dictionary<DateTime, CashData> diccacheDatas, List<DateTime> dtlist)
        {
            var removelist = new List<CashData>();
            foreach (DateTime dt in dtlist)
            {
                if (dicsrv.ContainsKey(dt))
                {
                    if (diccacheDatas.ContainsKey(dt))
                    {
                        CashData cd = diccacheDatas[dt];
                        cd.DrugSrv = dicsrv[dt];
                    }
                    else
                    {
                        var cd = new CashData();
                        cd.Dt = dt;
                        cd.DrugSrv = dicsrv[dt];
                        Cache.CacheDrugList.Add(cd);
                    }
                }
                else
                {
                    if (diccacheDatas.ContainsKey(dt))
                    {
                        CashData cd = diccacheDatas[dt];
                        removelist.Add(cd);
                    }
                }
            }

            foreach (CashData cashData in removelist)
            {
                Cache.CacheDrugList.Remove(cashData);
            }
        }


        private Dictionary<DateTime, List<SrvSplitOrderDTO>> getSrvlistPerDay(List<SrvSplitOrderDTO> basedtos)
        {
            var rsmap = new Dictionary<DateTime, List<SrvSplitOrderDTO>>();
            if (basedtos == null) return rsmap;
            foreach (SrvSplitOrderDTO splitOrderDto in basedtos)
            {
                var tdt = (DateTime) splitOrderDto.Dt_mp_plan;
                var dt = new DateTime(tdt.Year, tdt.Month, tdt.Day);
                if (rsmap.ContainsKey(dt))
                {
                    List<SrvSplitOrderDTO> srvlist = rsmap[dt];
                    srvlist.Add(splitOrderDto);
                }
                else
                {
                    var srvlist = new List<SrvSplitOrderDTO>();
                    srvlist.Add(splitOrderDto);
                    rsmap[dt] = srvlist;
                }
            }

            return rsmap;
        }

        private Dictionary<DateTime, CashData> getCathePerDay(DateTime start, DateTime end)
        {
            var st = new DateTime(start.Year, start.Month, start.Day);
            var rsmap = new Dictionary<DateTime, CashData>();
            if (Cache.CacheLabAndObsList == null) return rsmap;
            foreach (CashData cd in Cache.CacheLabAndObsList)
            {
                if (cd.Dt >= st && cd.Dt <= end)
                {
                    DateTime dt = cd.Dt;
                    rsmap[dt] = cd;
                }
            }

            return rsmap;
        }

        private Dictionary<DateTime, CashData> getSrvCathePerDay(DateTime start, DateTime end)
        {
            var st = new DateTime(start.Year, start.Month, start.Day);
            var rsmap = new Dictionary<DateTime, CashData>();
            if (Cache.CacheDrugList == null) return rsmap;
            foreach (CashData cd in Cache.CacheDrugList)
            {
                if (cd.Dt >= st && cd.Dt <= end)
                {
                    DateTime dt = cd.Dt;
                    rsmap[dt] = cd;
                }
            }

            return rsmap;
        }

        private void writedataOrder(OrSplitOrderDTO[] basedtos, string type, DateTime start, DateTime end)
        {
            if (Cache.CacheLabAndObsList == null)
                Cache.CacheLabAndObsList = new List<CashData>();
            List<DateTime> dtlist = getDatePeriod(start, end);

            //获取所有的用药数据，按天分类 
            Dictionary<DateTime, List<OrSplitOrderDTO>> diclist = getOrderlistPerDay(basedtos);
            //获取该区间内的所有缓存数据
            Dictionary<DateTime, CashData> calist = getCathePerDay(start, end);
            //组合所有的数据
            combyOrAndCache(diclist, calist, dtlist, type);
        }

        private void combyOrAndCache(Dictionary<DateTime, List<OrSplitOrderDTO>> dicsrv,
            Dictionary<DateTime, CashData> diccacheDatas, List<DateTime> dtlist, string type)
        {
            foreach (DateTime dt in dtlist)
            {
                if (dicsrv.ContainsKey(dt))
                {
                    if (diccacheDatas.ContainsKey(dt))
                    {
                        CashData cd = diccacheDatas[dt];
                        if (type == "lab")
                        {
                            cd.LabOrder = dicsrv[dt];
                        }
                        else if (type == "obs")
                        {
                            cd.ObsOrder1 = dicsrv[dt];
                        }
                    }
                    else
                    {
                        var cd = new CashData();
                        cd.Dt = dt;
                        if (type == "lab")
                        {
                            cd.LabOrder = dicsrv[dt];
                            Cache.CacheLabAndObsList.Add(cd);
                        }
                        else if (type == "obs")
                        {
                            cd.ObsOrder1 = dicsrv[dt];
                            Cache.CacheLabAndObsList.Add(cd);
                        }
                    }
                }
                else
                {
                    if (diccacheDatas.ContainsKey(dt))
                    {
                        CashData cd = diccacheDatas[dt];
                        if (type == "lab")
                        {
                            cd.LabOrder = null;
                        }
                        else if (type == "obs")
                        {
                            cd.ObsOrder1 = null;
                        }
                    }
                }
            }
        }


        private Dictionary<DateTime, List<OrSplitOrderDTO>> getOrderlistPerDay(OrSplitOrderDTO[] basedtos)
        {
            var rsmap = new Dictionary<DateTime, List<OrSplitOrderDTO>>();
            if (basedtos == null) return rsmap;
            foreach (OrSplitOrderDTO splitOrderDto in basedtos)
            {
                var tdt = (DateTime) splitOrderDto.Dt_mp_plan;
                var dt = new DateTime(tdt.Year, tdt.Month, tdt.Day);
                if (rsmap.ContainsKey(dt))
                {
                    List<OrSplitOrderDTO> srvlist = rsmap[dt];
                    srvlist.Add(splitOrderDto);
                }
                else
                {
                    var srvlist = new List<OrSplitOrderDTO>();
                    srvlist.Add(splitOrderDto);
                    rsmap[dt] = srvlist;
                }
            }

            return rsmap;
        }


        private void writeViData(List<ItemInfo> Vidata, DateTime start, DateTime end)
        {
            if (Cache.CacheTempList == null)
                Cache.CacheTempList = new List<CashData>();
            List<DateTime> dtlist = getDatePeriod(start, end);

            //获取所有的用药数据，按天分类 
            Dictionary<DateTime, List<ItemInfo>> diclist = getVilistPerDay(Vidata);
            //获取该区间内的所有缓存数据
            Dictionary<DateTime, CashData> calist = getViCathePerDay(start, end);
            //组合所有的数据
            combyViData(diclist, calist, dtlist);
        }

        private Dictionary<DateTime, List<ItemInfo>> getVilistPerDay(List<ItemInfo> Vidata)
        {
            var rsmap = new Dictionary<DateTime, List<ItemInfo>>();
            if (Vidata == null) return rsmap;
            foreach (ItemInfo itemInfo in Vidata)
            {
                DateTime tdt = itemInfo.LogTime;
                var dt = new DateTime(tdt.Year, tdt.Month, tdt.Day);
                if (rsmap.ContainsKey(dt))
                {
                    List<ItemInfo> srvlist = rsmap[dt];
                    srvlist.Add(itemInfo);
                }
                else
                {
                    var srvlist = new List<ItemInfo>();
                    srvlist.Add(itemInfo);
                    rsmap[dt] = srvlist;
                }
            }

            return rsmap;
        }

        private Dictionary<DateTime, CashData> getViCathePerDay(DateTime start, DateTime end)
        {
            var st = new DateTime(start.Year, start.Month, start.Day);
            var rsmap = new Dictionary<DateTime, CashData>();
            if (Cache.CacheTempList == null) return rsmap;
            foreach (CashData cd in Cache.CacheTempList)
            {
                if (cd.Dt >= st && cd.Dt <= end)
                {
                    DateTime dt = cd.Dt;
                    rsmap[dt] = cd;
                }
            }

            return rsmap;
        }

        private void combyViData(Dictionary<DateTime, List<ItemInfo>> dicvi,
            Dictionary<DateTime, CashData> diccacheDatas, List<DateTime> dtlist)
        {
            var removelist = new List<CashData>();
            foreach (DateTime dt in dtlist)
            {
                if (dicvi.ContainsKey(dt))
                {
                    if (diccacheDatas.ContainsKey(dt))
                    {
                        CashData cd = diccacheDatas[dt];
                        cd.ItemInfos = dicvi[dt];
                    }
                    else
                    {
                        var cd = new CashData();
                        cd.Dt = dt;
                        cd.ItemInfos = dicvi[dt];
                        Cache.CacheTempList.Add(cd);
                    }
                }
                else
                {
                    if (diccacheDatas.ContainsKey(dt))
                    {
                        CashData cd = diccacheDatas[dt];
                        removelist.Add(cd);
                    }
                }
            }

            foreach (CashData cashData in removelist)
            {
                Cache.CacheTempList.Remove(cashData);
            }
        }


        private List<DateTime> getDatePeriod(DateTime start, DateTime end)
        {
            var dateTimeList = new List<DateTime>();
            var estart = new DateTime(start.Year, start.Month, start.Day);
            var eend = new DateTime(end.Year, end.Month, end.Day);
            DateTime temp = estart;
            while (temp < eend)
            {
                dateTimeList.Add(temp);
                temp = temp.AddDays(1);
            }

            return dateTimeList;
        }
    }
}
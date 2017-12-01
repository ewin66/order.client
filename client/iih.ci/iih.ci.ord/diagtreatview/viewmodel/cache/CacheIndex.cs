using System;
using System.Collections.Generic;
using System.Linq;

/**
 * @ by li_cheng
 * 缓存索引
 */

namespace iih.ci.ord.diagtreatview.viewmodel
{
    public class CacheIndex
    {
        public List<CacheTotal> CacheTotallist = new List<CacheTotal>();

        public CacheTotal getCachePeriod(DateTime start, DateTime end)
        {
            CacheTotal ca = null;
            foreach (CacheTotal cacheTotal in CacheTotallist)
            {
                if (start >= cacheTotal.StartTime && end <= cacheTotal.EndTime)
                {
                    ca = cacheTotal;
                    break;
                }
            }
            return ca;
        }

        public CacheTotal validatePeriod(DateTime start, DateTime end)
        {
            int startcatotal = 0;
            int endcatotal = 0;
            string flagstart = "0";
            string flagend = "0";
            if (CacheTotallist == null)
                return null;

            List<CacheTotal> calist = CacheTotallist.OrderBy(x => x.StartTime).ToList();
            if (calist.Count > 0)
            {
                for (int i = 0; i < calist.Count; i++)
                {
                    if (start >= calist[i].StartTime && start <= calist[i].EndTime)
                    {
                        startcatotal = i;
                        flagstart = "1";
                    }
                    else if (start < calist[i].StartTime)
                    {
                        if (i > 0 && start > calist[i - 1].EndTime)
                        {
                            startcatotal = i;
                            flagstart = "2";
                        }
                        else if (i == 0)
                        {
                            startcatotal = i;
                            flagstart = "2";
                        }
                    }

                    if (end >= calist[i].StartTime && end <= calist[i].EndTime)
                    {
                        endcatotal = i;
                        flagend = "1";
                    }
                    else if (end < calist[i].StartTime)
                    {
                        if (i > 0 && end > calist[i - 1].EndTime)
                        {
                            endcatotal = i;
                            flagend = "2";
                        }
                        else if (i == 0)
                        {
                            endcatotal = i;
                            flagend = "2";
                        }
                    }
                }
            }
            //string sttype = "";
            DateTime fst = start;
            DateTime fend = end;
            int starindex = -1, endindex = -1;


            if (flagend == "2")
            {
                fend = end;
                if (endcatotal == 0)
                {
                    endindex = -1;
                }
                else
                {
                    endindex = endcatotal - 1;
                }
            }
            else if (flagend == "0")
            {
                fend = end;
                endindex = calist.Count - 1;
            }
            else if (flagend == "1")
            {
                fend = calist[endcatotal].EndTime;
                endindex = endcatotal;
            }


            if (flagstart == "2")
            {
                fst = start;
                if (startcatotal == 0)
                {
                    starindex = -1;
                }
                else
                {
                    starindex = endcatotal - 1;
                }
            }
            else if (flagstart == "0")
            {
                fst = start;
                starindex = calist.Count;
            }
            else if (flagstart == "1")
            {
                fst = calist[startcatotal].StartTime;
                starindex = startcatotal;
            }

            var ct = new CacheTotal();
            ct.StartTime = fst;
            ct.EndTime = fend;
            ct.HasCache = 1;
            var removeli = new List<CacheTotal>();
            for (int j = starindex; j <= endindex; j++)
            {
                if (j >= 0)
                {
                    ct.CacheDrugList.AddRange(calist[j].CacheDrugList);
                    ct.CacheLabAndObsList.AddRange(calist[j].CacheLabAndObsList);
                    ct.CacheMrList.AddRange(calist[j].CacheMrList);
                    ct.CacheTempList.AddRange(calist[j].CacheTempList);
                    removeli.Add(calist[j]);
                }
            }

            foreach (CacheTotal cacheTotal in removeli)
            {
                CacheTotallist.Remove(cacheTotal);
            }

            CacheTotallist.Add(ct);
            return ct;

            //return null;
        }
    }
}
using System;
using System.Collections.Generic;
using System.Linq;
using iih.bd.srv.mrctmca.d;
using iih.ci.mr.cimr.d;
using iih.ci.ord.diagtreatview.viewmodel.bp;
using iih.ci.ord.dto.blexorder.d;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.rui.bizcontrol.vitalsign.model;

namespace iih.ci.ord.diagtreatview.viewmodel.cache
{
    public class KeyPointCacheDataUtils
    {
        public KeyPointCacheTotal Cache = new KeyPointCacheTotal();

        /// <summary>
        ///     获取缓存数据
        /// </summary>
        public KeyPointViewData queryViewData(DateTime start, DateTime end)
        {
            //    var st = new DateTime(start.Year, start.Month, start.Day);
            var viewdata = new KeyPointViewData();
            var st = new DateTime(start.Year, start.Month, start.Day);
            var CacheDrugList = new FArrayList2();
            var CacheLabList = new FArrayList2();
            var CacheObsList = new FArrayList2();
            var CacheTempList = new FArrayList2();

            var CimrsListList = new FArrayList2();
            var MrcasListList = new FArrayList2();
            MrcasListList.AddRange(Cache.MrcaList);
            foreach (DiagTreatKeyPointRntDataDTO dataDto in Cache.CacheList)
            {
                // if(start.)
                var f = new DateTime(dataDto.Dt_keypoint.ToTarget.Year, dataDto.Dt_keypoint.ToTarget.Month,
                    dataDto.Dt_keypoint.ToTarget.Day);

                if (f >= st && f <= end)
                {
                    if (dataDto.Drugdata != null)
                        CacheDrugList.AddRange(dataDto.Drugdata);
                    if (dataDto.Labdata != null)
                        CacheLabList.AddRange(dataDto.Labdata);
                    if (dataDto.Obsdata != null)
                        CacheObsList.AddRange(dataDto.Obsdata);
                    if (dataDto.Bodysignsdata != null)
                        CacheTempList.AddRange(DiagtreatUtils.setVidata2(dataDto.Bodysignsdata));
                    if (dataDto.Cimrs != null)
                        CimrsListList.AddRange(dataDto.Cimrs);
                }
            }
            viewdata.CacheDrugList = CacheDrugList.Cast<TransSrvSplitOrderDTO>().ToArray();
            viewdata.CacheLabList = CacheLabList.Cast<OrSplitOrderDTO>().ToArray();
            viewdata.CacheObsList = CacheObsList.Cast<OrSplitOrderDTO>().ToArray();
            viewdata.CacheTempList = CacheTempList.Cast<ItemInfo>().ToList();
            viewdata.CimrsList = CimrsListList.Cast<CiMrDO>().ToArray();
            viewdata.MrcasList = MrcasListList.Cast<MrCtmCaDO>().ToArray();
            return viewdata;
        }

        /// <summary>
        ///     获取缓存数据
        /// </summary>
        public void writeViewData(DiagTreatKeyPointRntDataDTO[] keylist, bool flag)
        {
            //    var st = new DateTime(start.Year, start.Month, start.Day);
            if (flag)
            {
                var f = new List<FDate>();
                if (Cache == null)
                    Cache = new KeyPointCacheTotal();
                Cache.CacheList.Clear();
                Cache.CacheList.Add(keylist[0]);
                f.Add(keylist[0].Dt_keypoint);
                FDateTime dt = DateTime.Now;
                FDate dd = dt.ToTarget.Date;
                foreach (DiagTreatKeyPointRntDataDTO dataDto in keylist)
                {
                    if (!Cache.CacheList.Contains(dataDto))
                    {
                        if (dd.ToString() == dataDto.Dt_keypoint.ToString())
                        {
                            Cache.CacheList.Add(dataDto);
                            f.Add(dataDto.Dt_keypoint);
                        }
                        else
                        {
                            if ((dataDto.Obsdata != null && dataDto.Obsdata.Count > 0) ||
                                (dataDto.Labdata != null && dataDto.Labdata.Count > 0))
                            {
                                Cache.CacheList.Add(dataDto);
                                f.Add(dataDto.Dt_keypoint);
                            }
                        }
                    }
                }
                //        this.Cache.KeyPointList = f.OrderBy(x => x).ToList();
                Cache.KeyPointList = f;
            }
        }
    }
}
using System;
using System.Collections.Generic;
using System.Linq;
using iih.bd.srv.mrctmca.d;
using iih.ci.mr.cimr.d;
using iih.ci.ord.diagtreatview.viewmodel.bp;
using iih.ci.ord.dto.blexorder.d;
using iih.mp.nr.temperaturechart.d;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.rui.bizcontrol.vitalsign.model;

namespace iih.ci.ord.diagtreatview.viewmodel.cache
{
    public class NewCacheDataUtils
    {
        private readonly Dictionary<String, DiagTreatKeyPointRntDataDTO> dmap =
            new Dictionary<string, DiagTreatKeyPointRntDataDTO>();

        public NewCacheTotal Cache;

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
        public void writeViewData(DiagTreatViewRntDataDTO diagTreatViewRntData, bool flag)
        {
            //    var st = new DateTime(start.Year, start.Month, start.Day);
            if (flag)
            {
                var f = new List<FDate>();
                if (Cache == null)
                    Cache = new NewCacheTotal();
                if (diagTreatViewRntData.Cimrs != null)
                {
                    foreach (object dataDto in diagTreatViewRntData.Cimrs)
                    {
                        var tmp = (CiMrDO) dataDto;
                        if (tmp.Dt_rd == null) continue;
                        var ftmp = new FDate(tmp.Dt_rd.Value.Date.ToString());
                        DiagTreatKeyPointRntDataDTO dto = dmap[ftmp.ToString()];
                        FArrayList2 labfa = dto.Cimrs;
                        if (labfa == null)
                        {
                            labfa = new FArrayList2();
                            dto.Cimrs = labfa;
                        }
                        labfa.Add(dataDto);
                        //this.Cache.CacheList.Add(dataDto);
                        //f.Add(dataDto.Dt_keypoint);
                    }
                }


                //按日期分类

                if (diagTreatViewRntData.Bodysignsdata != null)
                {
                    foreach (object dataDto in diagTreatViewRntData.Bodysignsdata)
                    {
                        var tmp = (Temcharitemdto) dataDto;
                        var ftmp = new FDate(tmp.Logtime.Value.Date.ToString());
                        DiagTreatKeyPointRntDataDTO dto = dmap[ftmp.ToString()];
                        FArrayList2 labfa = dto.Bodysignsdata;
                        if (labfa == null)
                        {
                            labfa = new FArrayList2();
                            dto.Bodysignsdata = labfa;
                        }
                        labfa.Add(dataDto);
                        //this.Cache.CacheList.Add(dataDto);
                        //f.Add(dataDto.Dt_keypoint);
                    }
                }

                if (diagTreatViewRntData.Drugdata != null)
                {
                    foreach (object dataDto in diagTreatViewRntData.Drugdata)
                    {
                        var tmp = (TransSrvSplitOrderDTO) dataDto;
                        if (tmp.Dt_mp_plan == null) continue;
                        var ftmp = new FDate(tmp.Dt_mp_plan.Value.Date.ToString());
                        DiagTreatKeyPointRntDataDTO dto = dmap[ftmp.ToString()];
                        FArrayList2 labfa = dto.Drugdata;
                        if (labfa == null)
                        {
                            labfa = new FArrayList2();
                            dto.Drugdata = labfa;
                        }
                        labfa.Add(dataDto);
                        //this.Cache.CacheList.Add(dataDto);
                        //f.Add(dataDto.Dt_keypoint);
                    }
                }

                if (diagTreatViewRntData.Labdata != null)
                {
                    foreach (object dataDto in diagTreatViewRntData.Labdata)
                    {
                        var tmp = (OrSplitOrderDTO) dataDto;
                        var ftmp = new FDate(tmp.Dt_mp_plan.Value.Date.ToString());
                        DiagTreatKeyPointRntDataDTO dto = dmap[ftmp.ToString()];
                        FArrayList2 labfa = dto.Labdata;
                        if (labfa == null)
                        {
                            labfa = new FArrayList2();
                            dto.Labdata = labfa;
                        }
                        labfa.Add(dataDto);
                        //this.Cache.CacheList.Add(dataDto);
                        //f.Add(dataDto.Dt_keypoint);
                    }
                }

                if (diagTreatViewRntData.Obsdata != null)
                {
                    foreach (object dataDto in diagTreatViewRntData.Obsdata)
                    {
                        var tmp = (OrSplitOrderDTO) dataDto;
                        var ftmp = new FDate(tmp.Dt_mp_plan.Value.Date.ToString());
                        DiagTreatKeyPointRntDataDTO dto = dmap[ftmp.ToString()];
                        FArrayList2 labfa = dto.Obsdata;
                        if (labfa == null)
                        {
                            labfa = new FArrayList2();
                            dto.Obsdata = labfa;
                        }
                        labfa.Add(dataDto);
                        //this.Cache.CacheList.Add(dataDto);
                        //f.Add(dataDto.Dt_keypoint);
                    }
                }
                //        this.Cache.KeyPointList = f.OrderBy(x => x).ToList();
            }
        }

        public void setDate4Dic(DateTime start, DateTime end, FArrayList2 mrca)
        {
            //	start.getDate().getDateAfter(1);
            FDate dd = start.Date;
            int len = (end.Date - start.Date).Days;
            if (Cache == null) Cache = new NewCacheTotal();
            if (Cache.KeyPointList == null) Cache.KeyPointList = new List<FDate>();
            if (Cache.CacheList == null) Cache.CacheList = new List<DiagTreatKeyPointRntDataDTO>();
            //.getDaysBetween(start.getDate(), end.getDate());
            Cache.CacheList.Clear();
            Cache.KeyPointList.Clear();
            dmap.Clear();
            int i = 0;
            Cache.MrcaList = mrca;
            for (i = 0; i <= len; i++)
            {
                FDate f = start.Date.AddDays(i);
                var dto = new DiagTreatKeyPointRntDataDTO();
                dto.Dt_keypoint = f;
                if (!dmap.ContainsKey(f.ToString()))
                    dmap.Add(f.ToString(), dto);
                if (!Cache.KeyPointList.Contains(f))
                    Cache.KeyPointList.Add(f);
                if (!Cache.CacheList.Contains(dto))
                    Cache.CacheList.Add(dto);
            }
        }
    }
}
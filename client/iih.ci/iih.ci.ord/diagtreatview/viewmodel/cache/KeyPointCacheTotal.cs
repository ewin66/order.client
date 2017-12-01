using System;
using System.Collections.Generic;
using iih.ci.ord.dto.blexorder.d;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.diagtreatview.viewmodel
{
    public class KeyPointCacheTotal
    {
        public FArrayList2 MrcaList;
        private DateTime endTime;
        private int hasCache = -1;
        private DateTime startTime;

        public KeyPointCacheTotal()
        {
            CacheList = new List<DiagTreatKeyPointRntDataDTO>();
            KeyPointList = new List<FDate>();
            MrcaList = new FArrayList2();
        }

        public List<DiagTreatKeyPointRntDataDTO> CacheList { get; set; }

        public List<FDate> KeyPointList { get; set; }

        public DateTime StartTime
        {
            get { return startTime; }
            set { startTime = value; }
        }

        public DateTime EndTime
        {
            get { return endTime; }
            set { endTime = value; }
        }

        public int HasCache
        {
            get { return hasCache; }
            set { hasCache = value; }
        }
    }
}
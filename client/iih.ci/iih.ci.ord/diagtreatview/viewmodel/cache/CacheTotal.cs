using System;
using System.Collections.Generic;

namespace iih.ci.ord.diagtreatview.viewmodel
{
    public class CacheTotal
    {
        private DateTime endTime;
        private int hasCache = -1;
        private DateTime startTime;

        public CacheTotal()
        {
            CacheDrugList = new List<CashData>();
            CacheLabAndObsList = new List<CashData>();
            CacheMrList = new List<CashData>();
            CacheTempList = new List<CashData>();
        }

        public List<CashData> CacheDrugList { get; set; }
        public List<CashData> CacheLabAndObsList { get; set; }
        public List<CashData> CacheTempList { get; set; }
        public List<CashData> CacheMrList { get; set; }

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
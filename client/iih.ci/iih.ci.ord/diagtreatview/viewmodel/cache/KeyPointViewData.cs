using System.Collections.Generic;
using iih.bd.srv.mrctmca.d;
using iih.ci.mr.cimr.d;
using iih.ci.ord.dto.blexorder.d;
using xap.rui.bizcontrol.vitalsign.model;

namespace iih.ci.ord.diagtreatview.viewmodel.cache
{
    public class KeyPointViewData
    {
        public TransSrvSplitOrderDTO[] CacheDrugList { get; set; }
        public OrSplitOrderDTO[] CacheLabList { get; set; }
        public OrSplitOrderDTO[] CacheObsList { get; set; }
        public List<ItemInfo> CacheTempList { get; set; }
        public CiMrDO[] CimrsList { get; set; }
        public MrCtmCaDO[] MrcasList { get; set; }
    }
}
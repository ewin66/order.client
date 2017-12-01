using System;
using System.Collections.Generic;
using iih.ci.ord.dto.blexorder.d;
using xap.rui.bizcontrol.vitalsign.model;

namespace iih.ci.ord.diagtreatview.viewmodel
{
    public class CashData
    {
        private DateTime dt;

        //用药
        //检查
        //检验

        public DateTime Dt
        {
            get { return dt; }
            set { dt = value; }
        }

        public List<SrvSplitOrderDTO> DrugSrv { get; set; }

        public List<OrSplitOrderDTO> LabOrder { get; set; }

        public List<OrSplitOrderDTO> ObsOrder1 { get; set; }

        public List<ItemInfo> ItemInfos { get; set; }
    }
}
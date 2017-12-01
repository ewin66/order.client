using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;

namespace iih.ci.ord.ciorder.viewmodel
{
    class MmRefViewModel
    {
        public EmsOrDrug[] mms;// { get; set; }

        public MmRefViewModel()
        {
            EmsOrDrug mm = new EmsOrDrug();
            mm.Name_mm = "阿莫西林";
            mm.Spec_mm = "12片/盒";
            mm.Price =12;
            mm.Name_hp = "医保";
            mm.Fact_count=100;
            mm.Vender="哈药六厂";
            mm.Limit = "";
            mms = new EmsOrDrug[] { mm };
        }
    }
}

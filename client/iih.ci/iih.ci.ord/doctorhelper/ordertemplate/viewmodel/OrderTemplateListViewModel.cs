using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.ortpl.d;
using iih.ci.ord.dto.ordertemplatedto.d;
using iih.ci.ord.i;
using xap.mw.core.data;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.rui.core.data;

namespace iih.ci.ord.doctorhelper.ordertemplate.viewmodel
{
    public class OrderTemplateListViewModel
    {
        private ICiOrdQryService qryService;

        public XapDataList<SrvortplitemAggDO> SrvortplitemAggDOList { get; set; }

        public OrderTemplateListViewModel(string id_srvtpl)
        {
            this.qryService = XapServiceMgr.find<ICiOrdQryService>();
            OrderTemplateDTO orderTemplateDto = this.qryService.getSrvortplitemAggDOS(id_srvtpl);
            FMap aggMap = orderTemplateDto.Srvortplitemaggdo;
            FArrayList srvagg = aggMap["SrvortplitemAggDO"] as FArrayList;

             FMap freqmap = orderTemplateDto.Freqdefdo;
             FArrayList freqList = freqmap["FreqDefDO"] as FArrayList;


             FMap measMap = orderTemplateDto.Measdocdo;
             FArrayList measList = measMap["MeasDocDO"] as FArrayList;

             XapDataList<SrvortplitemAggDO> xaplist = new XapDataList<SrvortplitemAggDO>();
             if (srvagg != null)
             {
                foreach (SrvortplitemAggDO agg in srvagg)
                {
                    agg.setFreqdefdo(freqList);
                    agg.setmeasList(measList);
                    xaplist.Add(agg);
                 
                }
            }
             SrvortplitemAggDOList = xaplist;
        }

    }
}

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
using xap.rui.appfw.collections;

namespace iih.ci.ord.doctorhelper.prescription.viewmodel
{
     
    public class prescriptionListViewModel
    {
        private ICiOrdQryService qryService;
        public XapAggDO<SrvortplitemAggDO> SrvortplitemAggDOList { get; set; }
        public prescriptionListViewModel(string id_tpl)
        {
            this.qryService = XapServiceMgr.find<ICiOrdQryService>();
            //SrvortplitemAggDO[] agg = this.qryService.getSrvortplitemAggDOS(id_tpl);
            //if (agg != null && agg.Length>0)
            //{
            //    this.SrvortplitemAggDOList = new XapAggDO<SrvortplitemAggDO>(this.qryService, agg[0]);
            //}


            OrderTemplateDTO orderTemplateDto = this.qryService.getSrvortplitemAggDOS(id_tpl);
            FMap fmap = orderTemplateDto.Srvortplitemaggdo;
            FArrayList srvagg = fmap["SrvortplitemAggDO"] as FArrayList;
            FMap freqmap = orderTemplateDto.Freqdefdo;
            FArrayList freqList = freqmap["FreqDefDO"] as FArrayList;


            FMap measMap = orderTemplateDto.Measdocdo;
            FArrayList measList = measMap["MeasDocDO"] as FArrayList;
            if (srvagg != null)
            {
                SrvortplitemAggDOList = new XapAggDO<SrvortplitemAggDO>(this.qryService, (SrvortplitemAggDO)srvagg[0]);
                SrvortplitemAggDOList.AggDO.setFreqdefdo(freqList);
                SrvortplitemAggDOList.AggDO.setmeasList(measList);
                 
            }
           

            
        }
    }
}

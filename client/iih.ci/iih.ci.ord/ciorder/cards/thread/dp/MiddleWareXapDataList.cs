
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using xap.rui.appfw;
using iih.mm.itf.material.i;
using xap.mw.serviceframework;
using iih.mm.itf.material.d;
using System.Threading;
using xap.mw.core.utils;
using xap.mw.log;
using xap.rui.control.extentions;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciorder.cards.thread.dp
{
    /// <summary>
    /// <para>描    述 :          中间件线程处理DataList           			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.cards.thread.dp    </para>    
    /// <para>类 名 称 :  MiddleWareXapDataList					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/8/1 16:50:18             </para>
    /// <para>更新时间 :  2016/8/1 16:50:18             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class MiddleWareXapDataList
    {
        private XapDataList<EmsOrDrug> emsOrDrugList;
        public XapDataList<EmsOrDrug> getEmsOrDrugList()
        {
            lock (this) {
                return this.emsOrDrugList;
            }
        }
        public void setEmsOrDrugList(XapDataList<EmsOrDrug> list)
        {
            lock (this) {
                IMaterialStockService stoctService = XapServiceMgr.find<IMaterialStockService>();
                List<GetStockReqDTO> reqDtos = new List<GetStockReqDTO>();
                if (emsOrDrugList == null) emsOrDrugList = new XapDataList<EmsOrDrug>();
                for (int i = 0; i < list.Count; i++)
                {
                    if (list[i].Fg_mm == true)
                    {
                        GetStockReqDTO reqDTO = new GetStockReqDTO();
                        reqDTO.Id_mm = list[i].Id_mm;
                        reqDTO.Id_dep = list[i].Id_dep_wh;
                        reqDTO.Req_unit_id = list[i].Id_unit_sale;
                        reqDtos.Add(reqDTO);
                    }
                }
                if (reqDtos.Count > 0)
                {
                    MaterialStockDTO[] stockdto=null;
                    try
                    {
                        stockdto = stoctService.getMaterialStocks(reqDtos.ToArray());
                    }
                    catch (Exception ex)
                    {
                        ex.Publish();
                        //this.ShowInfo(ex.Message);
                    }
                    if (stockdto == null) return;
                    for (int i = list.Count - 1; i >= 0; i--)
                    {

                        MaterialStockDTO materialDo = stockdto.FirstOrDefault(p => p.Id_mm == list[i].Id_mm);
                        if (materialDo != null)
                        {
                            FDouble mmcount = materialDo.Quan_stock;
                            int? mmStatus = materialDo.Mmstatus;
                            //药房无此药的移除
                            if (mmStatus != null && mmStatus == (int)MaterialStatus.NORELATION)
                            {
                                list.RemoveAt(i);
                            }
                            else
                            {
                                list[i].Fact_count = mmcount;
                                list[i].Price = materialDo.Price_act;
                                list[i].Mmstatus = materialDo.Mmstatus;
                                
                                 EmsOrDrug ems = emsOrDrugList.FirstOrDefault(p=>p.Id_mm==list[i].Id_mm);
                                if (ems != null) {
                                    emsOrDrugList.Remove(ems);
                                }
                                emsOrDrugList.Add(list[i]);
                            }
                        }
                    }
                    List<EmsOrDrug> sortList = null;
                    try
                    {
                         sortList = emsOrDrugList.OrderByDescending(p => p.Fact_count).OrderBy(p => p.Mmstatus).ToList();
                    }
                    catch //(Exception e)
                    {
                       // e.Message;
                    }
                  
                    if (emsOrDrugList == null)
                    {
                        emsOrDrugList = new XapDataList<EmsOrDrug>();
                    }
                    else {
                        emsOrDrugList.Clear();
                    }
                    sortList.ForEach(p=>emsOrDrugList.Add(p));
                }
            }
        }
    }
}

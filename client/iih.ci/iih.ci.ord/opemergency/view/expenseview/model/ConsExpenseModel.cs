
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.appfw;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciordems.d;
using xap.mw.core.data;

namespace iih.ci.ord.opemergency.view.expenseview.model
{
    /// <summary>
    /// <para>描    述 :  会诊费用模型      			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.view.expenseview.model    </para>    
    /// <para>类 名 称 :  ConsExpenseModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/7/12 13:32:56             </para>
    /// <para>更新时间 :  2016/7/12 13:32:56             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class ConsExpenseModel : ExpenseModel
    {
        public ConsExpenseModel(XapDataList<EmsOrDrug> ds)
            : base(ds)
        {

        }
        protected override ciordems.d.EmsOrDrug[] Convert2Drugs(iih.ci.ord.dto.d.CiOrAggAndRelInfo info, object viewModel)
        {
            if (viewModel == null || !(viewModel is XapDataList<EmsConsItemDO>))
            {
                return null;
            }
            CiOrderDO ord = info.OrAggDO.getParentDO();


            XapDataList<EmsConsItemDO> drugList = viewModel as XapDataList<EmsConsItemDO>;

            List<EmsOrDrug> szDrugs = new List<EmsOrDrug>();
            Dictionary<String, object> tmpCacheSrv = new Dictionary<string, object>();

            // 处理医嘱带过来的信息
            foreach (EmsConsItemDO item in drugList)
            {

                tmpCacheSrv.Add(item.Id_srv, item);
                /* szDrugs.Add(item);*/
            }

            // 处理附加项
            szDrugs.AddRange(ToEmsOrDrugs(info.OrAggDO, tmpCacheSrv, info.OrSrvMmMap, info.BlSrvMap));

            return szDrugs.ToArray();

        }

        protected override EmsOrDrug EmsOrDrugWithOrdSrvDO( OrdSrvDO ordSrv, int useDays = 1, ordsrvmm.d.OrdSrvMmDO srvMm = null)
        {
            EmsOrDrug tmpDrug = base.EmsOrDrugWithOrdSrvDO(ordSrv, useDays, srvMm);
            tmpDrug.Quan_cur = 1;
            tmpDrug.Totalprice = tmpDrug.Quan_cur * tmpDrug.Price;
            return tmpDrug;
        }
    }
}

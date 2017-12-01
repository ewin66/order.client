
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using xap.rui.appfw;
using iih.ci.ord.ciorder.d;
using xap.mw.core.data;

namespace iih.ci.ord.opemergency.view.expenseview.model
{
    /// <summary>
    /// <para>描    述 :  检验检查费用模型         			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.view.expenseview.model    </para>    
    /// <para>类 名 称 :  ApobLabExpenseModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/7/12 13:29:58             </para>
    /// <para>更新时间 :  2016/7/12 13:29:58             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class LabObsExpenseModel : ExpenseModel
    {
        public LabObsExpenseModel(XapDataList<EmsOrDrug> ds)
            : base(ds)
        {

        }
        protected override ciordems.d.EmsOrDrug[] Convert2Drugs(iih.ci.ord.dto.d.CiOrAggAndRelInfo info, object viewModel)
        {
            if (viewModel == null || !(viewModel is XapDataList<EmsOrDrug>))
            {
                return null;
            }
            CiOrderDO ord = info.OrAggDO.getParentDO();


            XapDataList<EmsOrDrug> drugList = viewModel as XapDataList<EmsOrDrug>;

            List<EmsOrDrug> szDrugs = new List<EmsOrDrug>();
            Dictionary<String, object> tmpCacheSrv = new Dictionary<string, object>();

            // 处理医嘱带过来的信息
            foreach (EmsOrDrug item in drugList)
            {

                tmpCacheSrv.Add(item.Id_srv, item);
                /* szDrugs.Add(item);*/
            }

            // 处理附加项
            szDrugs.AddRange(ToEmsOrDrugs(info.OrAggDO, tmpCacheSrv, info.OrSrvMmMap, info.BlSrvMap));

            return szDrugs.ToArray();
        }

        protected override EmsOrDrug HandleEmsOrDrug(EmsOrDrug drug, object ordDrug = null)
        {
            base.HandleEmsOrDrug(drug, ordDrug);
            if (ordDrug != null && ordDrug is EmsOrDrug)
            {
                EmsOrDrug viewDrug = ordDrug as EmsOrDrug;
                drug.Quan_cur = viewDrug.Quan_cur;
                drug.Price = viewDrug.Price;
                // drug.Totalprice = drug.Price * drug.Quan_cur;
                drug.Totalprice = drug.Price * viewDrug.Freqct * viewDrug.Use_days;
            }
           
            return drug;
        }

        protected override String GetOrdDeptMp()
        {
            XapDataList<EmsOrDrug> viewDatasource = this.GetEmsViewModel() as XapDataList<EmsOrDrug>;
            string id_dep_flow = "";
            if (viewDatasource != null && viewDatasource.Count > 0) {
                id_dep_flow = viewDatasource[0].Id_mp_dep;
            }
            return id_dep_flow;
        }
    }
}

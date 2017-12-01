
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.dto.emsmain;

namespace iih.ci.ord.opemergency.orderaction
{
    /// <summary>
    /// <para>描    述 :  医嘱操作-组合操作  			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.orderaction    </para>    
    /// <para>类 名 称 :  OrderComplexAction					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Young         				</para> 
    /// <para>修 改 人 :  Young         				</para> 
    /// <para>创建时间 :  2017/8/11 17:47:06             </para>
    /// <para>更新时间 :  2017/8/11 17:47:06             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class OrderComplexAction : OrderAction
    {
        private List<OrderAction> lstOrderActions = new List<OrderAction>();

        public override OrderRstDTO[] exec(OrderOperateDTO[] args, bool isSeries = false)
        {
            List<OrderRstDTO> lstRstDTOs = new List<OrderRstDTO>();
            for (int i = 0; i < lstOrderActions.Count; i++)
            {
                OrderRstDTO[] rstDTOS = lstOrderActions[i].exec(new OrderOperateDTO[] { args[i] });
                lstRstDTOs.Add(rstDTOS[0]);
                if (!rstDTOS[0].IsSuccess.Value && isSeries)
                {
                    return lstRstDTOs.ToArray();
                }
            }

            return lstRstDTOs.ToArray();
        }

        public void Add(OrderAction orderAction)
        {
            lstOrderActions.Add(orderAction);
        }

        public void Remove(OrderAction orderAction)
        {
            lstOrderActions.Remove(orderAction);
        }

        public void Clear()
        {
            lstOrderActions.Clear();
        }
    }
}

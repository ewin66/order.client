using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.opemergency.ems;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.ciorder.utils;

namespace iih.ci.ord.opemergency.validate
{
    /// <summary>
    /// <para>描    述 :  草药医疗单有效性检查    			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.validate    </para>    
    /// <para>类 名 称 :  EmsHerbsValidate					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/7/12 13:31:48             </para>
    /// <para>更新时间 :  2016/7/12 13:31:48             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    class EmsHerbsValidate : BaseEmsValidate
    {
        public override bool OrdValivate(object model, BaseEmsView sender)
        {
            sender.OrdErrorList.Clear();

            if (!(sender is  EmsHerbsViewGrid))
            {
                base.OrdValivate(model, sender);
            }
            

            var Emsdrugs = (model as EmsHerbsViewModel).GetFormDataSource() as EmsDrugItemDO;
            #region 检查空数据
            {
                var drug = Emsdrugs.EmsOrDrugList.ToList().FirstOrDefault(p => p.Id_srv == null);
                if (drug != null) {
                sender.OrdErrorList.Add("草药列表中存在空数据，请删除后保存");
                }
            }
            #endregion

            #region 检查草药总量为 0
            {
                var resultList = Emsdrugs.EmsOrDrugList.Where(p => !p.IsDELETED).ToList().Where(p => p.Quan_cur == null || p.Quan_cur == 0);
                if (resultList.Count() > 0) {
                    sender.OrdErrorList.Add(String.Join(",",resultList.Select(p=>p.Name_mm)) + " 总量为 0");
                }
            }
            #endregion

            #region 药品库存的判断
            string mmcounterror = LogicEx.GetInstance().validateDrugCount(Emsdrugs.EmsOrDrugList.Where(p => !p.IsDELETED).ToList());
            if (!string.IsNullOrEmpty(mmcounterror))
            {
                sender.OrdErrorList.Add(mmcounterror);
            }
            #endregion

            return sender.OrdErrorList.Count == 0;
        }
    }
}

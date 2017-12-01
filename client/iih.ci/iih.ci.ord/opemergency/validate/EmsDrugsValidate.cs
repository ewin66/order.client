using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.opemergency.ems.common;
using iih.bd.srv.routedosage.i;
using xap.mw.serviceframework;
using iih.bd.srv.routedosage.d;
using iih.ci.ord.ciorder.utils;
using xap.sys.xbd.udi.d;
using xap.mw.core.data;
using iih.mm.itf.material.d;
using xap.mw.core.utils;
using iih.mm.itf.material.i;


namespace iih.ci.ord.opemergency.validate
{
    /// <summary>
    /// <para>描    述 :  西成药医疗单有效性检查    			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.validate    </para>    
    /// <para>类 名 称 :  EmsDrugsValidate					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/7/12 13:31:48             </para>
    /// <para>更新时间 :  2016/7/12 13:31:48             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    class EmsDrugsValidate : BaseEmsValidate
    {
        public override bool OrdValivate(object model, BaseEmsView sender)
        {
            EmsDrugItemDO Emsdrugs = (model as EmsDrugsViewModel).GetFormDataSource() as EmsDrugItemDO;
            if (base.OrdValivate(model, sender) && Emsdrugs != null)
            {
                
                #region 药品重复检查
                IEnumerable<IGrouping<string,EmsOrDrug>> enuma = Emsdrugs.EmsOrDrugList.Where(p => !p.IsDELETED).GroupBy(i => i.Id_mm).Where(g => g.Count() > 1);
                bool bcf = enuma.Count() >= 1;
                if (bcf)
                {
                    foreach (IGrouping<string, EmsOrDrug> group in enuma)
                    {
                       EmsOrDrug ems =  group.First();
                       sender.OrdErrorList.Add("药品【"+ems.Name_mm+"】有重复！");
                    }
                }
                #endregion

                #region 空药品
                if (Emsdrugs.EmsOrDrugList.Count(p => !p.IsDELETED && string.IsNullOrEmpty(p.Id_srv)) > 0)
                {
                    sender.OrdErrorList.Add("药品有空数据！");

                }

                #endregion

                #region 剂|总量大于0
                foreach (EmsOrDrug item in Emsdrugs.EmsOrDrugList.Where(p => !p.IsDELETED).ToList())
                {
                    if (item.Quan_med == null || item.Quan_med.ToDouble() <= 0)
                    {
                        sender.OrdErrorList.Add(item.Name_mm + "剂量必须大于0！");
                    }
                    if (item.Quan_cur == null || item.Quan_cur.ToDouble() <= 0)
                    {
                        sender.OrdErrorList.Add(item.Name_mm + "总量必须大于0！");
                    }
                }
                #endregion
                List<string> depMps = new List<string>();
                foreach (EmsOrDrug item in Emsdrugs.EmsOrDrugList.Where(p => !p.IsDELETED).ToList())
                {
                    if (!depMps.Contains(item.Id_mp_dep)) {
                        depMps.Add(item.Id_mp_dep);
                    }
                }
                if (depMps.Count() > 1) {
                    sender.OrdErrorList.Add("药品的执行科室不一致，不能保存！");
                }
                #region 执行科室校验
                #endregion
                #region 在院执行为true时，在院执行次数必须大于0
                if (Emsdrugs.Fg_mp_in == true && (Emsdrugs.Times_mp_in == null || Emsdrugs.Times_mp_in <= 0)) {
                    sender.OrdErrorList.Add("在院执行时，在院执行次数必须大于0！");
                }
                #endregion
                #region 药品不能为空
                if (Emsdrugs.EmsOrDrugList.Count(p => !p.IsDELETED) == 0)
                {
                    sender.OrdErrorList.Add("药品不能为空！");
                }
                #endregion

            
                #region 用药天数必须大于0
                if (Emsdrugs.Use_days < 0)
                {
                    sender.OrdErrorList.Add("用药天数小于0！");
                }
                #endregion
                #region 药品的单价不能为空
                string priceError = "";
                foreach (EmsOrDrug drug in Emsdrugs.EmsOrDrugList.Where(p => !p.IsDELETED))
                {

                    if (drug.Price == null) {
                        priceError += "药品【" + drug.Name_srv + "】的价格为空，请与信息科联系！";
                    }
                }
                if (priceError != "")
                {
                    sender.OrdErrorList.Add(priceError);
                }
                #endregion
                #region 校验每个服务的药品用法是否在剂型关联的用法集合里
                List<string> id_dosages = new List<string>();
                foreach (EmsOrDrug drug in Emsdrugs.EmsOrDrugList.Where(p => !p.IsDELETED))
                {
                    id_dosages.Add(drug.Id_dosage);
                }
                RouteDosageRefDO[] rdros = LogicEx.GetInstance().getRouteDoSageRefDOById_dosages(id_dosages);
                string error = "";
                foreach (EmsOrDrug drug in Emsdrugs.EmsOrDrugList.Where(p => !p.IsDELETED))
                {
                   RouteDosageRefDO item =  rdros.FirstOrDefault(p=>p.Id_dosage==drug.Id_dosage && p.Id_route==drug.Id_route);
                   if (item == null) {
                       UdidocDO udidoc = LogicEx.GetInstance().getUdidocDOById(drug.Id_dosage);
                       if (udidoc!=null)
                           error += drug.Name_srv + "剂型为" + udidoc.Name + ",不能使用" + drug.Name_route + "用法；";
                   }
                }
                if (error != "") {
                    sender.OrdErrorList.Add(error);
                }
                #endregion
                #region 药品库存的判断
                string mmcounterror = LogicEx.GetInstance().validateDrugCount(Emsdrugs.EmsOrDrugList.ToList());
                if (!string.IsNullOrEmpty(mmcounterror)) {
                    sender.OrdErrorList.Add(mmcounterror);
                }
                #endregion
                #region 空数据记录提示
                EmsOrDrug drugitem = Emsdrugs.EmsOrDrugList.Where(p => !p.IsDELETED).ToList().FirstOrDefault(p => p.Id_srv == null);
                if (drugitem != null)
                {
                    sender.OrdErrorList.Add("医疗单列表中存在空数据，请删除后保存");
                }
                #endregion
                #region 用法数据完整性校验
                if (String.IsNullOrEmpty(Emsdrugs.Id_route)) {
                    sender.OrdErrorList.Add("药品的用法ID为空，请重新选择用法");
                }
                #endregion
            }

            return (sender.OrdErrorList.Count == 0);

        }
    }
}

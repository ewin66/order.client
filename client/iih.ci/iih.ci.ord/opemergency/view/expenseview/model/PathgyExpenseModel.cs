
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
    /// <para>描    述 :  病历费用模型          			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.view.expenseview.model    </para>    
    /// <para>类 名 称 :  PathgyExpenseModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/7/12 15:08:12             </para>
    /// <para>更新时间 :  2016/7/12 15:08:12             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class PathgyExpenseModel : ExpenseModel
    {
        public PathgyExpenseModel(XapDataList<EmsOrDrug> ds)
            : base(ds)
        {

        }
        protected override ciordems.d.EmsOrDrug[] Convert2Drugs(iih.ci.ord.dto.d.CiOrAggAndRelInfo info, object viewModel)
        {
            if (viewModel == null || !(viewModel is XapDataList<EmsPathgyItemDO>))
            {
                return null;
            }
            XapDataList<EmsPathgyItemDO> drugList = viewModel as XapDataList<EmsPathgyItemDO>;

            CiOrderDO ord = info.OrAggDO.getParentDO();

            FMap orSrvMmMap = info.OrSrvMmMap;


            List<EmsOrDrug> szDrugs = new List<EmsOrDrug>();
            Dictionary<String, object> tmpCacheSrv = new Dictionary<string, object>();

            // 处理医嘱带过来的信息
            EmsPathgyItemDO consItemDO = null;
            if (drugList.Count > 0)
            {
                consItemDO = drugList[0];
                tmpCacheSrv.Add(consItemDO.Id_srv, consItemDO);
               // szDrugs.Add(EmsOrDrugFromEmsPathgyItemDO(consItemDO));
            }
            // 处理附加项
            szDrugs.AddRange(ToEmsOrDrugs(info.OrAggDO, tmpCacheSrv, info.OrSrvMmMap, info.BlSrvMap));
            return szDrugs.ToArray();
        }

        protected override EmsOrDrug HandleEmsOrDrug(EmsOrDrug drug, object ordDrug = null)
        {
            base.HandleEmsOrDrug(drug, ordDrug);
            if (ordDrug != null && ordDrug is EmsPathgyItemDO)
            {
                EmsPathgyItemDO itemDo = ordDrug as EmsPathgyItemDO;
                drug.Price = itemDo.Price;
                drug.Totalprice = drug.Price * drug.Quan_cur;

//                
//                 if ((ordDrug as EmsPathgyItemDO).Id_srv.Equals(drug.Id_srv))
//                 {
//                     this.disableEditList.Add(drug);
//                 }
                
            }
            return drug;
        }

        protected virtual EmsOrDrug EmsOrDrugFromEmsPathgyItemDO(EmsPathgyItemDO item)
        {
            return new EmsOrDrug()
            {
                //Code_mm = item
                //             Code_srv = item,
                //             Des = item,
                //         Fact_count = item
                //         Factor_cb = item
                //         Factor_mb = item
                //         Fg_anti = item
                //            Fg_bl = item.Fg_bl,
                //         Fg_chk = item
                //         Fg_ctm = item
                //        Fg_dose_anoma = item
                //            Fg_mm = item.Fg_mm,
                //         Fg_otc = item
                //         Fg_pois = item
                //             Fg_propc = item.Fg_propc,
                //             Fg_self = item.Fg_self,
                //             Fg_selfpay = item.Fg_selfpay,
                //             Fg_skintest = item.Fg_skintest,
                //             Fg_treat = item.Fg_indic,
                //        Fg_urgent = item
                //            Freqct = item.Freqct,
                //         Hpdes = item
                //         Id_anti = item
                //         Id_antipsy = item
                //            Id_boildes = item.Id_boildes,
                //         Id_dosage = item
                //         Id_emsordrug = item
                //            Id_freq = item.Id_freq,
                //        Id_freqtime = item
                //             Id_hp = item.Id_hp,
                //             Id_hpsrvtp = item.Id_hpsrvtp,
                //         Id_mm = item
                //         Id_mmtp = item
                Id_mp_dep = item.Id_dep_coll,
                //Id_or_rel = item.Id_or_rel,
                Id_orsrv = item.Id_orsrv,
                //         Id_pgku_cur = item
                //         Id_pharm = item
                //         Id_pois = item
                //            Id_pri = item,
                //             Id_reltp = item.Id_reltp,
                //             Id_route = item.Id_route,
                //            Id_skintest_skip_reason = item.Id_skintest_skip_reason,
                Id_srv = item.Id_srv,
                //            Id_srvca = item.Id_srvca,
                //         Id_srvmm = item
                //         Id_srvskin = item
                //            Id_srvtp = item.Id_srvtp,
                //        Id_unit_base = item
                //             Id_unit_med = item.Id_medu,
                //             Id_unit_sale = item.Id_medu, // 总量单位 = 计量单位
                //         Id_val = item
                //         Limit = item
                //             Name_boildes = item.Boil_name,
                //             Name_freq = item.Freq_name,
                //         Name_freqtime = item
                //         Name_hp = item.n
                //            Name_hpsrvtp = item.Name_hpsrvtp,

                //           Name_mm = item.Name,
                //         Name_mmtp = item
                Name_mp_dep = item.Name_dep_coll,
                //             Name_pgku_cur = item.Medu_name, // 总量单位 = 计量单位
                //             Name_unit_sale = item.Medu_name,
                //             Name_route = item.Route_name,
                Name_srv = item.Name_srv,
                //        Name_unit_base = item
                //            Name_unit_med = item.Medu_name,
                //         Name_unit_sale = item
                //         Note_ext = item
                //           Note_or = item,
                Price = item.Price,
                //         Pycode = item
                //         Quan_base = item
                Quan_cur = 1,//item.Quan_total_medu,
                //            Quan_med = item.Quan_medu,
                //         Sd_anti = item
                //         Sd_antipsy = item
                //         Sd_dosage = item
                //         Sd_freq = item
                //            Sd_hpsrvtp = item.Sd_hpsrvtp,
                //         Sd_mmbind_ip = item
                //         Sd_mmtp = item
                //         Sd_mupkgutp = item
                //         Sd_pharm = item
                //         Sd_pois = item
                //             Sd_reltp = item.Sd_reltp,
                //             Sd_skintest_skip_reason = item.Sd_skintest_skip_reason,
                //             Sd_srvtp = item.Sd_srvtp,
                //        Sd_val = item
                //            Sortno = item.Sortno,
                //         Spec_mm = item
                //         Str_unit_pkg_ids = item
                            Sv = item.Sv,
                //         Totalprice = item
                //         Use_days = item
                //         Vender = item
            };
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.i;
using iih.ci.ord_stub.service.i;
using xap.mw.serviceframework;
using xap.rui.appfw;

namespace iih.ci.ord.ciorder.viewmodel.impext
{
    /// <summary>
    /// 获取物品接口
    /// </summary>
    /// Author:admin
    /// Date:2015-09-19
    class GetMmImp
    {//机构id，物品id集合、仓库集合、开立科室。
        private ICiOrdQryService crudService;
        public GetMmImp()
        {
            this.crudService = XapServiceMgr.find<ICiOrdQryService>();
        }
        string id_hp = "0001AA1000000000TUUV";//TODO:id_hp 需要读配置带来 // ##????
        /// <summary>
        /// Gets the mm.
        /// </summary>
        /// <param name="id_org">The id_org.</param>
        /// <param name="id_srv">The id_srv.</param>
        /// <param name="id_dept_mp">The id_dept_mp.</param>
        /// <param name="id_dept_phy">The id_dept_phy.</param>
        /// <param name="id_hp">The id_hp. 社会医保类型 读配置</param>
        /// <returns></returns>
        public XapDataList<EmsOrDrug> GetMm(string id_org, string id_srv, string id_dept_mp, string id_dept_phy,string code_entp)
        {
            XapDataList<EmsOrDrug> list = new XapDataList<EmsOrDrug>();
            EmsOrDrug[] drugs = this.crudService.getSrvVsMm(id_org, id_srv, id_dept_mp, id_dept_phy, id_hp, code_entp);
            drugs.ToList().ForEach(p => list.Add(p));
            //this.headDo = this.crudService.findById(id_srv, ((int)type).ToString());
            //foreach (EmsDrugItemDO item in headDo.Emsdrugitems)
            //{

            //    list.Add(new EmsOrDrug
            //    {
            //        Name_srv = item.Name_srv,//通用物品(即服务项目名称)
            //        Name_mm = item.Name_mm,//物品
            //        Id_mm = item.Id_mm,
            //        Spec_mm = item.Spec_mm,//规格
            //        Quan_med = item.Quan_med,//剂量
            //        Name_unit_med = item.Name_unit_med,//剂量单位
            //        Id_unit_med = item.Id_unit_med,
            //        Quan_base = item.Quan_base,//单次数量
            //        Id_unit_base = item.Id_unit_base,//数量单位
            //        Name_unit_base = item.Name_unit_base,
            //        Vender = item.Name_sup, //厂商
            //        Price = item.Price,//参考价格
            //        Des = item.Des_mm,  //描述
            //        Limit = item.Limit,//限制条件//TODO:临时数据
            //        Name_heath = item.Name_heath,//医保类型
            //        Fact_count = 0,// ran.Next(2, 30),//现有存量
            //        Sortno = headDo.Emsdrugitems.IndexOf(item) + 1



            //    });
            //}
            return list;
        }

        /// <summary>
        ///根据服务id 获取关联物品（针对 不需要 库存，医保什么的 如输血的物品）
        /// </summary>
        /// <param name="id_srv">The id_srv.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-10-29
        public XapDataList<EmsOrDrug> GetMmBySrvId(string id_srv)
        {
            return GetMm("", id_srv, "", "","");
        }

    }
}

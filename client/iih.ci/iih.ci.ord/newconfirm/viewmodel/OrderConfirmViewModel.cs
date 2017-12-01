using System;
using System.Collections.Generic;
using System.Linq;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.i;
using iih.ci.ord.i;
using iih.ci.ord_stub.i;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.rui.control.extentions;
using xap.rui.control.forms.view;

/*
********************************************************************************

** 作者： 李程

** 创始时间：2016-6-30

** 修改人：李程

** 修改时间：2016-6-30

** 描述： 医嘱确认显示页面


*********************************************************************************
*/

namespace iih.ci.ord.ciorder.viewmodel
{
    internal class OrderConfirmViewModel
    {
        //**************************************************变量*************************************************************

        private readonly ICiOrdMaintainService maintainService;
        //private readonly int num;
        private readonly ICiorderMDOCrudService ordService;
        private readonly ICiOrdQryService qryservice;

        private readonly XapFormControl xapFormControl;
        //private DateTime nowtime;
        //**************************************************构造函数*************************************************************
        public OrderConfirmViewModel(string idorg, XapFormControl xapFormControl)
        {
            ordService = XapServiceMgr.find<ICiorderMDOCrudService>();
            maintainService = XapServiceMgr.find<ICiOrdMaintainService>();
            qryservice = XapServiceMgr.find<ICiOrdQryService>();
            OrderList = new XapDataList<OrConfirm>();
            this.xapFormControl = xapFormControl;
         //   num = qryservice.getIntSystemParam(idorg, ICiOrdNSysParamConst.SYS_PARAM_OrStopChkMaxLeadTime);
        }

        public OrConfirm dto { get; set; }


        public XapDataList<OrConfirm> OrderList { get; set; }

        public void Conform(String[] id_sign_ors, String[] id_canc_ors, String[] id_stop_ors)
        {
            maintainService.CiOrderSCSCheck(id_sign_ors, id_canc_ors, id_stop_ors);
        }

        public void GetOrConfirmList(OrConfirm orfirm)
        {
            OrderList.Clear();
            OrConfirm[] orfirms = qryservice.getCiOrdConfirm(orfirm);
            if (orfirms == null || orfirms.Count() == 0)
                return;
            //var notshowList = new List<OrConfirm>();
            //nowtime = LogicEx.GetInstance().GetSystemDateTime();
            //foreach (OrConfirm confirm in orfirms)
            //{
            //    if (OrderConfirmUtils.SetSorNameValue(confirm, num, nowtime))
            //        notshowList.Add(confirm);
            //}
            IOrderedEnumerable<OrConfirm> gg = orfirms.OrderBy(item => item.Name_su_or);
            IOrderedEnumerable<OrConfirm> ff = gg.OrderBy(item => item.Name_bed);
            OrderList = ff.ToArray();
            //foreach (OrConfirm confirm in notshowList)
            //{
            //    OrderList.Remove(confirm);
            //}
        }

        /// <summary> Gets 获取选中的医嘱 </summary>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-10-21
        public CiOrderDO[] GetOrChecked(OrConfirm[] ors)
        {

            List<string> id_ors = ors.Select(p => p.Id_confirm).ToList();
            CiOrderDO[] Orders = ordService.findByIds(id_ors.ToArray(), FBoolean.False); //TODO: 加条件
            return Orders;
        }



        /// <summary>
        ///     医嘱确认
        /// </summary>
        public void orderConfirm()
        {
            OrConfirm[] ors = xapFormControl.GetSelected<OrConfirm>("ordlist");
            if (ors == null || ors.Count() == 0)
                return;
            CiOrderDO[] orders = GetOrChecked(ors);

            var a = new List<string>();
            var b = new List<string>();
            var c = new List<string>();
            foreach (CiOrderDO ciOrderDo in orders)
            {
                if (ciOrderDo.Fg_sign == FBoolean.True && ciOrderDo.Fg_chk == FBoolean.False)
                {
                    a.Add(ciOrderDo.Id_or);
                }
                else if (ciOrderDo.Fg_chk == FBoolean.True&& ciOrderDo.Fg_stop == FBoolean.True && ciOrderDo.Fg_chk_stop == FBoolean.False &&
                         ciOrderDo.Fg_canc == FBoolean.False)
                {
                    c.Add(ciOrderDo.Id_or);
                }
                else if (ciOrderDo.Fg_canc == FBoolean.True && ciOrderDo.Fg_chk_canc == FBoolean.False)
                {
                    b.Add(ciOrderDo.Id_or);
                }
            }

            if (a.Count == 0 && b.Count == 0 && c.Count == 0) { this.ShowAlert("选中数据无效，请刷新界面！"); return; }

            Conform(a.ToArray(), b.ToArray(), c.ToArray());
            GetOrConfirmList(dto);

            this.SetStatusMsg("确认成功");
        }
    }
}

///// <summary> Gets 获取选中的医嘱 </summary>
///// <returns></returns>
///// Author:admi
///// Date:2015-10-21
//public CiOrderDO[] GetOrconfirmChecked()
//{
//    var list = new XapDataList<OrConfirm>();
//    foreach (OrConfirm confirm in OrderList)
//    {
//        if (confirm.Fg_chk == true)
//        {
//            list.Add(confirm);
//        }
//    }
//    List<string> id_ors = list.Select(p => p.Id_confirm).ToList();
//    CiOrderDO[] Orders = ordService.findByIds(id_ors.ToArray(), FBoolean.False); //TODO: 加条件
//    return Orders;
//}
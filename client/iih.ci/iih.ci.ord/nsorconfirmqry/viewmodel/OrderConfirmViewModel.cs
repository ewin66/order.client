using System;
using System.Collections.Generic;
using System.Linq;
using iih.bd.fc.orwf.d;
using iih.bd.fc.wf.d;
using iih.bd.srv.freqdef.d;
using iih.bd.srv.freqdef.i;
using iih.ci.iih.ci.ord.i;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.i;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.i;
using iih.ci.ord_stub.i;
using xap.cli.context;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.rui.appfw.attributes;

/*
********************************************************************************

** 作者： 李程

** 创始时间：2016-6-30

** 修改人：李程

** 修改时间：2016-6-30

** 描述： 医嘱确认显示页面


*********************************************************************************
*/

namespace iih.ci.ord.nsorconfirmqry.viewmodel
{
    internal class OrderConfirmViewModel
    {
        //**************************************************变量*************************************************************
        private readonly IFreqdefMDOCrudService freqservice;
        private readonly ICiOrdMaintainService maintainService;
        private readonly int num;
        private readonly ICiorderMDOCrudService ordService;
        private readonly ICiOrdQryService qryservice;
        private DateTime nowtime;
        public CiOrderDO[] orders;
        public String[] srvScope;
        public String srvScopeSql;
        //**************************************************构造函数*************************************************************
        public OrderConfirmViewModel(string idorg)
        {
            ordService = XapServiceMgr.find<ICiorderMDOCrudService>();
            maintainService = XapServiceMgr.find<ICiOrdMaintainService>();
            freqservice = XapServiceMgr.find<IFreqdefMDOCrudService>();
            qryservice = XapServiceMgr.find<ICiOrdQryService>();
            OrderList = new XapDataList<OrConfirm>();
            AddFeeDTOList = new XapDataList<AddFeeDTO>();
            num = qryservice.getIntSystemParam(idorg, ICiOrdNSysParamConst.SYS_PARAM_OrStopChkMaxLeadTime);
        }

        [FormData(TabCode = "ordlist")]
        public XapDataList<OrConfirm> OrderList { get; set; }

        [FormData(TabCode = "cost")]
        public XapDataList<AddFeeDTO> AddFeeDTOList { get; set; }

      

        /// <summary>
        ///     删除补费项目
        /// </summary>
        /// <param name="fee"></param>
        public void deletefee(AddFeeDTO fee)
        {
            maintainService.CiOrderFeeDelete(fee);


            AddFeeDTOList.Delete(fee, true);
        }

        public void clearFeeList()
        {
            if (AddFeeDTOList.Count == 0)
                return;
            for (int i = 0; i < AddFeeDTOList.Count; i++)
            {
                AddFeeDTOList.RemoveAt(0);
            }
        }

        public void Conform(String[] id_sign_ors, String[] id_canc_ors, String[] id_stop_ors)
        {
            maintainService.CiOrderSCSCheck(id_sign_ors, id_canc_ors, id_stop_ors);
        }

        public void GetFeeList(OrConfirm orfirm)
        {
            AddFeeDTOList.Clear();
            if (orfirm != null)
            {
                AddFeeDTO[] orfirms = qryservice.getCiOrdFee(orfirm);
                editFeeVal(orfirms);
                AddFeeDTOList = orfirms;
            }
        }

        private void editFeeVal(AddFeeDTO[] orfirms)
        {
            foreach (AddFeeDTO feeDto in orfirms)
            {
                feeDto.Amt_cur = feeDto.Price * feeDto.Quan_med;
            }
        }

        public void GetOrConfirmList(OrConfirm orfirm)
        {
            OrderList.Clear();
            OrConfirm[] orfirms = qryservice.getCiOrdConfirmedQry(orfirm);
            if (orfirms == null || orfirms.Count() == 0)
                return;
            var notshowList = new List<OrConfirm>();
            nowtime = LogicEx.GetInstance().GetSystemDateTime();
            foreach (OrConfirm confirm in orfirms)
            {
                if (SetSorNameValue(confirm))
                    notshowList.Add(confirm);
            }
            IOrderedEnumerable<OrConfirm> gg = orfirms.OrderBy(item => item.Name_su_or);
            IOrderedEnumerable<OrConfirm> ff = gg.OrderBy(item => item.Name_bed);
            OrderList = ff.ToArray();
            foreach (OrConfirm confirm in notshowList)
            {
                OrderList.Remove(confirm);
            }
        }

        public AddFeeDTO getEmsdrug(AddFeeDTO fee, OrConfirm or)
        {
            var dto = new OrWfExDeptParamDTO();
            dto.Eu_wftp = Convert.ToInt32(EnumFlow.NULL); //    0执行与物资   1执行科室 2物资流向
            dto.Code_entp = or.Code_entp; //     就诊类型                  
            dto.Id_dept_ns = or.Id_dep_nur; //就诊护理病区
            dto.Id_dept_or = or.Id_dep_phy; //开单科室
            // dto.Id_dept_en = or.id; //id_dept_en;//就诊科室
            dto.Id_srv = fee.Id_srv; //服务
            dto.Sd_srvtp = fee.Sd_srvtp; //服务类型sd
            dto.Id_srvca = fee.Id_srvca; //服务分类
            dto.Recurstr = or.Fg_long.ToString(); //长临标志
            //dto.Innercode_srvca =;//服务分类内码
            //  dto.Id_mm = id_mm;          // 服务选取的关联物品
            //  dto.Id_usage = ;   //用法
            //dto.Weekno = "2";//生效日期时间相关的 周#与时间
            dto.Timestr = new DateTime();
            //dto.Reserv1 = "";  //暂时无用途   //预留项
            //dto.Reserv2 = "";  //暂时无用途
            //dto.Reserv3 = "";  //套内项目时： BD套内项目的科室计算方式sd值,BD套内项目的固定执行科室ID值,所属套的执行科室ID值
            AddFeeDTO dgs = qryservice.getEmsfee(fee, dto);

            copydrug(fee, dgs);
            fee.Amt_cur = fee.Price*fee.Quan_med;
            return fee;
        }


        /// <summary>
        ///     获取执行科室
        /// </summary>
        /// <param name="drug"></param>
        /// <param name="or"></param>
        /// <returns></returns>
        public OrWfExDeptDTO[] getMpDept(EmsOrDrug drug, OrConfirm or)
        {
            var orWf = new OrWfExDeptParamDTO();
            orWf.Id_dept_ns = UserManager.getInstance().CurrentDept.Id_dep;
            orWf.Id_srv = drug.Id_srv;
            orWf.Id_srvca = drug.Id_srvca;
            orWf.Code_entp = or.Code_entp;
            orWf.Sd_srvtp = drug.Sd_srvtp;
            return qryservice.getMpDept(orWf);
        }

        private bool SetSorNameValue(OrConfirm confirm)
        {
            if (confirm.Fg_stop == FBoolean.True && confirm.Fg_chk_stop == FBoolean.False &&
                confirm.Fg_canc == FBoolean.False)
            {
                if (num != 0)
                {
                    DateTime? end1 = confirm.Dt_end;
                    TimeSpan span = end1.Value - nowtime;
                    int a = span.Days*24*60 + span.Hours*60 + span.Minutes;
                    if (a > num)

                        return true;
                }
            }

            //else if (confirm.Fg_stop == FBoolean.False)
            //{
            //    confirm.Dt_end = null;
            //    confirm.Name_emp_stop = null;
            //}


            //if (confirm.Fg_sign == FBoolean.True && confirm.Fg_chk == FBoolean.False)
            //{
            //    confirm.Name_su_or = "签署";
            //}
            //else if (confirm.Fg_canc == FBoolean.True && confirm.Fg_chk_canc == FBoolean.False)
            //{
            //    confirm.Name_su_or = "医生废除";
            //}
            //else
            //{
            //    confirm.Name_su_or = "核对通过";
            //}


            //if (confirm.Sd_sex != null && confirm.Sd_sex.Equals("1"))
            //{
            //    confirm.Name_sex_pat = "男";
            //}
            //else if (confirm.Sd_sex != null && confirm.Sd_sex.Equals("2"))
            //{
            //    confirm.Name_sex_pat = "女";
            //}
            //else
            //{
            //    confirm.Name_sex_pat = "未知性别";
            //}
            //if (confirm.Fg_long != null && confirm.Fg_long == FBoolean.True)
            //{
            //    confirm.Str_long = "长期";
            //}
            //else
            //{
            //    confirm.Str_long = "临时";
            //}
            //string agestr = null;
            //if (confirm.Age_pat != null)
            //{
            //    if (confirm.Age_pat.Length != 0)
            //    {
            //        DateTime dt;
            //        if (DateTime.TryParse(confirm.Age_pat, out dt))
            //        {
            //            agestr = XapFunc.GetAge(dt);
            //        }
            //    }
            //}
            //confirm.Name_pat = confirm.Name_pat + "|" + confirm.Name_sex_pat + "|" + agestr;
            return false;
        }

        /// <summary> Gets 获取选中的医嘱 </summary>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-10-21
        public CiOrderDO[] GetOrChecked(OrConfirm[] ors)
        {
            var list = new XapDataList<CiOrderDO>();
            List<string> id_ors = ors.Select(p => p.Id_confirm).ToList();
            orders = ordService.findByIds(id_ors.ToArray(), FBoolean.False); //TODO: 加条件
            return orders;
        }

        /// <summary> Gets 获取选中的医嘱 </summary>
        /// <returns></returns>
        /// Author:admi
        /// Date:2015-10-21
        public CiOrderDO[] GetOrconfirmChecked()
        {
            var list = new XapDataList<OrConfirm>();
            foreach (OrConfirm confirm in OrderList)
            {
                if (confirm.Fg_chk == true)
                {
                    list.Add(confirm);
                }
            }
            List<string> id_ors = list.Select(p => p.Id_confirm).ToList();
            orders = ordService.findByIds(id_ors.ToArray(), FBoolean.False); //TODO: 加条件
            return orders;
        }

        /// <summary>
        ///     费用保存
        /// </summary>
        /// <param name="orid"></param>
        public void savedrug(string orid)
        {
            AddFeeDTO[] fees = maintainService.CiOrderFeeSave(orid, AddFeeDTOList,
                (int) OrSrvSourceFromEnum.NURSECHECKADD);
            AddFeeDTOList = fees;
        }

        /// <summary>
        ///     服务可录入范围
        /// </summary>
        /// <param name="idorg"></param>
        /// <param name="iddep"></param>
        /// <returns></returns>
        public void getdepSrvInfo(string idorg, string iddep)
        {
            srvScopeSql = qryservice.getCiSrvCondition(iddep, ICiOrdNSysParamConst.SYS_PARAM_OrChkSrvScope4MakeupFee);
            if (srvScopeSql == null)
                srvScopeSql = qryservice.getCiSrvCondition(idorg, ICiOrdNSysParamConst.SYS_PARAM_OrChkSrvScope4MakeupFee);
            string srvsql = "select id_srv from bd_srv where bd_srv.id_org='" + idorg +
                            "'and  BD_SRV.Fg_Use_Ip='Y' and BD_SRV . fg_active ='Y'  and BD_SRV .fg_set ='N' and BD_SRV.fg_bl='Y'  and " +
                            srvScopeSql;
            srvScope = qryservice.getSrvScope(srvsql);
        }

        public FreqDefDO GetDefDo(string id_freq)
        {
            return freqservice.findById(id_freq);
        }

        public bool IsDrugEdit()
        {
            bool flag = false;
            foreach (AddFeeDTO feeDto in AddFeeDTOList)
            {
                if (feeDto.Status != DOStatus.UNCHANGED)
                {
                    flag = true;
                    break;
                }
            }
            return flag;
        }

        private void copydrug(AddFeeDTO fee1, AddFeeDTO fee2)
        {
          //  fee1.Id_emsordrug = fee2.Id_emsordrug;
            fee1.Id_srv = fee2.Id_srv;
            fee1.Id_orsrv = fee2.Id_orsrv;
            fee1.Name_srv = fee2.Name_srv;
            fee1.Id_mm = fee2.Id_mm;
            fee1.Name_mm = fee2.Name_mm;
            fee1.Spec_mm = fee2.Spec_mm;
            fee1.Quan_med = fee2.Quan_med;
            fee1.Id_unit_med = fee2.Id_unit_med;
            fee1.Name_unit_med = fee2.Name_unit_med;
            fee1.Quan_base = fee2.Quan_base;
            fee1.Quan_cur = fee2.Quan_base;
            fee1.Id_unit_sale = fee2.Id_unit_sale;
            fee1.Name_unit_sale = fee2.Name_unit_sale;
            fee1.Id_unit_base = fee2.Id_unit_base;
            fee1.Name_unit_base = fee2.Name_unit_base;
            fee1.Id_hp = fee2.Id_hp;
           // fee1.Name_hp = fee2.Name_hp;
            fee1.Price = fee2.Price;
           // fee1.Vender = fee2.Vender;
            fee1.Limit = fee2.Limit;
          //  fee1.Fact_count = fee2.Fact_count;
          //  fee1.Des = fee2.Des;
           // fee1.Id_freqtime = fee2.Id_freqtime;
          //  fee1.Name_freqtime = fee2.Name_freqtime;
            fee1.Sortno = fee2.Sortno;
         //   fee1.Sv = fee2.Sv;
            fee1.Factor_cb = fee2.Factor_cb;
            fee1.Factor_mb = fee2.Factor_mb;
            fee1.Id_boildes = fee2.Id_boildes;
            fee1.Name_boildes = fee2.Name_boildes;
            fee1.Id_dosage = fee2.Id_dosage;
            fee1.Sd_dosage = fee2.Sd_dosage;
            fee1.Id_pharm = fee2.Id_pharm;
            fee1.Sd_pharm = fee2.Sd_pharm;
            fee1.Id_pois = fee2.Id_pois;
            fee1.Sd_pois = fee2.Sd_pois;
            fee1.Id_anti = fee2.Id_anti;
            fee1.Sd_anti = fee2.Sd_anti;
            fee1.Id_mmtp = fee2.Id_mmtp;
            fee1.Sd_mmtp = fee2.Sd_mmtp;
            fee1.Name_mmtp = fee2.Name_mmtp;
          //  fee1.Pycode = fee2.Pycode;
          //  fee1.Fg_chk = fee2.Fg_chk;
            fee1.Id_freq = fee2.Id_freq;
            fee1.Name_freq = fee2.Name_freq;
            fee1.Amt_cur = fee2.Amt_cur;
            fee1.Id_dep = fee2.Id_dep;
            fee1.Name_dep = fee2.Name_dep;
            fee1.Id_unit_sale = fee2.Id_unit_sale;
            fee1.Name_unit_sale = fee2.Name_unit_sale;
            fee1.Code_mm = fee2.Code_mm;
            fee1.Id_val = fee2.Id_val;
            fee1.Sd_val = fee2.Sd_val;
          //  fee1.Id_antipsy = fee2.Id_antipsy;
          //  fee1.Sd_antipsy = fee2.Sd_antipsy;
            fee1.Fg_otc = fee2.Fg_otc;
         //   fee1.Sd_mupkgutp = fee2.Sd_mupkgutp;
         //   fee1.Str_unit_pkg_ids = fee2.Str_unit_pkg_ids;
            fee1.Fg_mm = fee2.Fg_mm;
            fee1.Sd_srvtp = fee2.Sd_srvtp;
            fee1.Code_srv = fee2.Code_srv;
            fee1.Id_srvtp = fee2.Id_srvtp;
            fee1.Id_srvca = fee2.Id_srvca;
        //    fee1.Sd_mmbind_ip = fee2.Sd_mmbind_ip;
            fee1.Id_primd = fee2.Id_primd;
           // fee1.Hpdes = fee2.Hpdes;
            fee1.Id_orsrvmm = fee2.Id_orsrvmm;
        }
    }
}
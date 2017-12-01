using System;
using System.Linq;
using iih.bd.fc.orwf.d;
using iih.bd.fc.wf.d;
using iih.bd.srv.freqdef.d;
using iih.bd.srv.freqdef.i;
using iih.ci.iih.ci.ord.i;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.i;
using iih.ci.ord.i;
using iih.ci.ord.newconfirm.viewmodel.bp;
using iih.ci.ord_stub.i;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.control.refcontrol.events;

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
    internal class OrderConfirmFeeViewModel
    {
        //**************************************************变量*************************************************************
        private readonly IFreqdefMDOCrudService freqservice;
        private readonly ICiOrdMaintainService maintainService;
        private readonly ICiOrdQryService qryservice;
        private readonly ICiorderMDOCrudService ordservice;
        private String[] srvScope;
        private String srvScopeSql;
        private XapFormControl xapFormControl;
        //**************************************************构造函数*************************************************************
        public OrderConfirmFeeViewModel(OrConfirm orfirm, XapFormControl xapFormControl)
        {
            this.xapFormControl = xapFormControl;
            maintainService = XapServiceMgr.find<ICiOrdMaintainService>();
            freqservice = XapServiceMgr.find<IFreqdefMDOCrudService>();
            qryservice = XapServiceMgr.find<ICiOrdQryService>();
            ordservice = XapServiceMgr.find<ICiorderMDOCrudService>();
            AddFeeDTOList = new XapDataList<AddFeeDTO>();
            GetFeeList(orfirm);
        }


        public XapDataList<AddFeeDTO> AddFeeDTOList { get; set; }


        /// <summary>
        ///     删除补费项目
        /// </summary>
        /// <param name="fee"></param>
        /// 1
        public void deletefee(AddFeeDTO fee)
        {
            maintainService.CiOrderFeeDelete(fee);
            AddFeeDTOList.Delete(fee, true);
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
                feeDto.Amt_cur = feeDto.Price*feeDto.Quan_med;
            }
        }


        public AddFeeDTO getEmsdrug(AddFeeDTO fee, OrConfirm or)
        {
           var dto=getwfparam( fee,  or);
           AddFeeDTO dgs = qryservice.getEmsfee(fee, dto);
           OrderConfirmUtils.copydrug(fee, dgs);
            //fee = qryservice.getEmsfee(fee, dto);
            //fee.SetUpdated();
            fee.Amt_cur = fee.Price*fee.Quan_med;
            return fee;
        }

        private OrWfExDeptParamDTO getwfparam(AddFeeDTO fee, OrConfirm or)
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
            dto.Id_dept_ex = or.Id_dep_mp;
            //dto.Innercode_srvca =;//服务分类内码
            //  dto.Id_mm = id_mm;          // 服务选取的关联物品
            //  dto.Id_usage = ;   //用法
            //dto.Weekno = "2";//生效日期时间相关的 周#与时间
            dto.Timestr = new DateTime();
            //dto.Reserv1 = "";  //暂时无用途   //预留项
            //dto.Reserv2 = "";  //暂时无用途
            //dto.Reserv3 = "";  //套内项目时： BD套内项目的科室计算方式sd值,BD套内项目的固定执行科室ID值,所属套的执行科室ID值
            return dto;
        }

        /// <summary>
        ///     获取执行科室
        /// </summary>
        /// <param name="drug"></param>
        /// <param name="or"></param>
        /// <returns></returns>
        public FArrayList getMpDept(AddFeeDTO drug, OrConfirm or)
        {
            
            var dto = getwfparam(drug, or);
            dto.Id_mm = drug.Id_mm;
            var wf = new ICiOrdQryServiceImpl().getExeDepts4CiOrSrvN(dto);
            return wf.Orwfexedepts;
        }

        /// <summary>
        ///     费用保存
        /// </summary>
        /// <param name="orid"></param>
        public void savedrug()
        {
            if (AddFeeDTOList == null || AddFeeDTOList.Count == 0)
                return;

            maintainService.CiOrderFeeSave(AddFeeDTOList[0].Id_or, AddFeeDTOList,
                (int) OrSrvSourceFromEnum.NURSECHECKADD);
       //     AddFeeDTOList = fees;
        }

        /// <summary>
        ///     服务可录入范围
        /// </summary>
        /// <param name="idorg"></param>
        /// <param name="iddep"></param>
        /// <returns></returns>
        public void getdepSrvInfo(string idorg, string iddep)
        {
            string srvScopeSql = qryservice.getCiSrvCondition(iddep,
                ICiOrdNSysParamConst.SYS_PARAM_OrChkSrvScope4MakeupFee);
            string srvsql = "select id_srv from bd_srv where bd_srv.id_org='" + idorg +
                            "'and  BD_SRV.Fg_Use_Ip='Y' and BD_SRV . fg_active ='Y'  and BD_SRV .fg_set ='N' and BD_SRV.fg_bl='Y'";
            if (srvScopeSql == null)
                srvScopeSql = qryservice.getCiSrvCondition(idorg, ICiOrdNSysParamConst.SYS_PARAM_OrChkSrvScope4MakeupFee);
            this.srvScopeSql = srvScopeSql;
            if (srvScopeSql != null)
                srvsql = srvsql + " and " + srvScopeSql;

            srvScope = qryservice.getSrvScope(srvsql);
        }

        public FreqDefDO GetDefDo(string id_freq)
        {
            return freqservice.findById(id_freq);
        }



        public void HandleRefFilter(object sender, RefActivatingEventArgs e, OrConfirm or, FreqDefDO freq)
        {
            var drug = e.DataObject as AddFeeDTO;
            if (e.BindingFieldName.Equals("Name_mm"))
            {
                e.WherePart = " bd_mm.id_srv  = '" + drug.Id_srv + "'";
            }

            if (e.BindingFieldName.Equals("Name_srv"))
            {
                //  this.FireSelected(this.model.orConfirm);
                if (or != null && or.Id_hp != null)
                    e.RefParams.AddParam("hp", or.Id_hp);
                string sql = " BD_SRV.Fg_Use_Ip='Y'  ";
                if (srvScopeSql != null)
                {
                    e.WherePart = sql + " and " + srvScopeSql;
                }
                //如果医嘱的频次为持续，该医嘱只能补时间量纲的服务
                if (or.Id_freq == "0001AA1000000006AEHV")//##???? 持续
                {
                    e.WherePart = sql + " and " + srvScopeSql + " and " + " bd_measdoc.sd_oppdimen='07' ";
                }

            }
            if (e.BindingFieldName.Equals("Name_dep"))
            {
                var drugs = e.DataObject as AddFeeDTO;
                FArrayList ow = null;
                string depis = "";
                if (drugs != null)
                {
                    ow = getMpDept(drugs, or);
                }
                if (ow != null)
                {
                    foreach (OrWfExDeptDTO o in ow)
                    {
                        depis += "'" + o.Id_dept + "',";
                    }

                    e.WherePart = " bd_dep.id_dep in (" + depis.Substring(0, depis.Count() - 1) + ")";
                }
            }
            if (e.BindingFieldName.Equals("Name_freq"))
            {
           
                    e.Cancel = false;
                    e.WherePart = " bd_freq.fg_active ='Y'";
                
            }
        }

        public void HandleRefResult(object sender, RefResultEventArgs e, OrConfirm or, FreqDefDO freq)
        {
            //throw new NotImplementedException();
            if (e.BindingFieldName.Equals("Name_bed"))
            {
                //  this.FireSelected(this.model.orConfirm);
            }
            else if (e.BindingFieldName.Equals("Name_dep_nur"))
            {
                //    this.FireSelected(this.model.orConfirm);
            }
            if (e.BindingFieldName.Equals("Name_srv"))
            {
                //  this.FireSelected(this.model.orConfirm);

                var drugs = e.DataObject as AddFeeDTO;
                if (drugs == null || drugs.Id_srv == null)
                    return;

                //如果频次为临时 则不修改频次
                //if (freq != null && freq.Id_frequnitct == "0001AA1000000000ELM4")
                //{
                //    drugs.Id_freq = freq.Id_freq;
                //    drugs.Name_freq = freq.Name;
                //}
                if (drugs != null)
                {
                    //or.Id_dep_nur = or.Id_dep_nur;  //??????
                    //or.Id_dep_phy = or.Id_dep_phy;
                    getEmsdrug(drugs, or);
                }
            }
        }

        public void HandleAllowEditing(object sender, AllowEditingEventArgs e)
        {
            var drug = e.Object as AddFeeDTO;
            // ************查询服务是否在可录入范围内*****************
            if (drug != null)
            {
                if (!iscontainSrv(drug.Id_srv))
                {
                    e.Cancel = true;
                }
                else
                {
                    e.Cancel = false;

                    if (e.PropName.Equals("Name_mm"))
                    {
                        if (drug.Fg_mm == false)
                            // ************设置物品为不可录入*****************
                            e.Cancel = true;
                    }
                }

                if (e.PropName.Equals("Name_mm"))
                {
                    if (drug.Id_srv == null)
                        // ************设置物品为不可录入*****************
                        e.Cancel = true;
                }
            }
        }

        public bool save()
        {
            bool isvalidate = true;
            if (validate())
            {
                isvalidate = false;
                return isvalidate;
            }
            savedrug();

            return isvalidate;
        }

        /// <summary>
        ///     *******************************************************************保存校验
        /// </summary>
        /// <returns></returns>
        private bool validate()
        {
            bool flag2 = false;
            if (AddFeeDTOList.Count > 0)
            {
                CiOrderDO ciord = this.ordservice.findById(AddFeeDTOList[0].Id_or);
                if (ciord == null || (!(ciord.Fg_chk == FBoolean.False && ciord.Fg_sign == FBoolean.True)))
                {
                    this.ShowAlert("该医嘱已不是签署医嘱");
                    flag2 = true;
                    return flag2;
                    
            }
        }
            foreach (AddFeeDTO feeDto in AddFeeDTOList)
            {
                if (feeDto.Id_srv == null)
                {
                    flag2 = true;
                    this.ShowAlert("服务项目不能为空");
                    return flag2;
                }
                if ((feeDto.Quan_med == null || feeDto.Quan_med == 0) && feeDto.Fg_mm == FBoolean.True)
                {
                    this.ShowAlert("单次数量不能为空");
                    flag2 = true;
                    return flag2;
                    //break;
                }
                if (feeDto.Id_dep == null)
                {
                    this.ShowAlert("执行科室不能为空");
                    flag2 = true;
                    return flag2;
                    //break;
                }
            }
            return flag2;
        }

        public bool iscontainSrv(string idsrv)
        {
            bool flag2 = false;
            if (idsrv == null) return true;
            if (srvScope != null)
            {
                foreach (string s in srvScope)
                {
                    if (s == idsrv)
                    {
                        flag2 = true;
                        break;
                    }
                }
            }
            return flag2;
        }

        public void HandleRefCanSelect(object sender, RefCanSelectEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_srv"))
            {
                var name = (string)e.SelectingData["Name"];

                int i = 0;
                foreach (AddFeeDTO routeDo in AddFeeDTOList)
                {
                    if (routeDo.Name_srv == name)
                    {
                        i++;
                        if (i == 1)
                        {
                            e.Cancel = true;
                            e.Message = string.Format("因为重复，您选中的数据'{0}'禁止选中！",
                                (e.SelectingData == null) ? "Null" : e.SelectingData.DisplayText);
                            break;
                        }
                    }
                }
            }
            else if (e.BindingFieldName.Equals("Name_mm"))
            {
                var name = (string)e.SelectingData["Name"];

                int i = 0;
                foreach (AddFeeDTO routeDo in AddFeeDTOList)
                {
                    if (routeDo.Name_mm == name)
                    {
                        i++;
                        if (i == 1)
                        {
                            e.Cancel = true;
                            e.Message = string.Format("因为重复，您选中的数据'{0}'禁止选中！",
                                (e.SelectingData == null) ? "Null" : e.SelectingData.DisplayText);
                            break;
                        }
                    }
                }
            }
        }
    }
}




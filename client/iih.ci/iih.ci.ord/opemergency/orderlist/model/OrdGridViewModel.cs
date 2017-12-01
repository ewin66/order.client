
using iih.bd.bc.udi;
using iih.ci.ord.cior.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.i;
using iih.ci.ord.ciorder.viewmodel;
using iih.ci.ord.i;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord_stub.i;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.form;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.mw.serviceframework.ex;
using xap.rui.appfw;
using xap.rui.control.extentions;
using xap.rui.control.query.i;
using iih.en.pv.dto.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.i.ems;
using iih.ci.ord.dto.emsmain;
using xap.sys.xbd.udi.d;
using xap.sys.xbd.udi.i;
using iih.ci.ord.ciorder.orreport;
using iih.ci.ord.ciord.d;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.ciorder.cards.drugext.dialogform;
using iih.ci.ord.common.utils;
using iih.bd.srv.ems.d;
using iih.bd.pp.hp.d;
using iih.ci.ord.medicaresharing.mdeicalrule;
using iih.bd.pp.hp.i;
using iih.ci.ord.dto.d;
using iih.ci.ord.medicaresharing;
using iih.en.pv.entplan.d;
using iih.en.pv.entplan.i;
using iih.ci.ord.opemergency.orderaction;
using iih.ci.ord.i.external;
using iih.ci.ord.ciprn.i;

namespace iih.ci.ord.opemergency.orderlist.model
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.orderlist.model    </para>    
    /// <para>类 名 称 :  OrdGridViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  vivi         				</para> 
    /// <para>修 改 人 :  vivi         				</para> 
    /// <para>创建时间 :  12/21/2016 3:10:44 PM             </para>
    /// <para>更新时间 :  12/21/2016 3:10:44 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OrdGridViewModel : BaseBizViewModel
    {
        #region 私有变量
        private ICiOrdMaintainService maintainService;
        private IUdidocCrudService udidocCrudService;
        private ICiorderMDOCrudService orderItemMService;
        private ICiOrdQryService ciOrderQryService;
        private IBdHpUnlimitDrugDOCrudService bdHpUnlimitDrugDoCrudService;
        private IEnthpCrudService iEnthpCrudService;
        private ICiOrdEnService enService;

        private XapDataList<CiOrderDO> tableDataSource;

        private OrderAction orderActionLoad = new OrderLoadAction();
        private OrderAction orderActionDelete = new OrderDeleteAction();
        private OrderAction orderActionSign = new OrderSignAction();
        private OrderAction orderActionRevert = new OrderRevertAction();
        private OrderAction orderActionCancel = new OrderCancelAction();
        private OrderAction orderActionCopy = new OrderCopyAction();
        private OrderComplexAction orderActionComplex = new OrderComplexAction();

        #endregion

        #region 公共属性
        public String Id_ent { get; set; }
        public String Code_entp { get; set; }
        #endregion

        public CiOrderDO[] ordersSign;//门诊已签署的医嘱（处置刷新到病历用）

        /// <summary>
        /// 服务类型的dic，
        /// key:服务类型（药品、血液 取前4位,其余取前两位） value:对应服务类型的显示名称（bd_didoc=0001ZZ2000000000000T 中ctr2字段）
        /// </summary>
        public Dictionary<string, string> DicSrvtp = new Dictionary<string, string>();

        #region 构造方法
        public OrdGridViewModel()
        {
            maintainService = XapServiceMgr.find<ICiOrdMaintainService>();
            udidocCrudService = XapServiceMgr.find<IUdidocCrudService>();
            orderItemMService = XapServiceMgr.find<ICiorderMDOCrudService>();
            ciOrderQryService = XapServiceMgr.find<ICiOrdQryService>();
            bdHpUnlimitDrugDoCrudService = XapServiceMgr.find<IBdHpUnlimitDrugDOCrudService>();
            iEnthpCrudService = XapServiceMgr.find<IEnthpCrudService>();
            enService = XapServiceMgr.find<ICiOrdEnService>();
            tableDataSource = new XapDataList<CiOrderDO>();
        }
        #endregion

        #region 公共方法
        /// <summary>
        /// 加载数据
        /// </summary>
        public void Reload()
        {
            if (string.IsNullOrEmpty(Id_ent) || string.IsNullOrEmpty(Code_entp))
            {
                tableDataSource.Clear();
                return;
            }

            OrderOperateDTO operateDTO = new OrderOperateDTO();
            operateDTO.EnContext = new CiEnContextDTO() { Id_en = this.Id_ent, Code_entp = this.Code_entp };
            OrderRstDTO orderRstDTO = orderActionLoad.exec(new OrderOperateDTO[] { operateDTO })[0];
            List<CiOrderDO> lstCiOrderDOs=new List<CiOrderDO>();
            if (orderRstDTO.Document != null && orderRstDTO.Document.Count > 0)
            {
                //FArrayList tmpOrderList = new FArrayList();
                //tmpOrderList.deSerializeJson(System.Text.Encoding.UTF8.GetString(Convert.FromBase64String((orderRstDTO.DocumentString))));
                foreach (Object order in orderRstDTO.Document)
                {
                    lstCiOrderDOs.Add(order as CiOrderDO);
                }
            }
            tableDataSource = new XapDataList<CiOrderDO>(orderItemMService, lstCiOrderDOs.ToArray());
            // 获取服务类型显示名称
            if (DicSrvtp.Count <= 0)
            {
                FMap mapSrvtp = new FMap();
                mapSrvtp = orderRstDTO.Extension["SrvTpNameMap"] as FMap;
                if (mapSrvtp != null)
                {
                    foreach (KeyValuePair<string, object> kv in mapSrvtp.ToDictionary())
                    {
                        DicSrvtp.Add(kv.Key, kv.Value.ToString());
                    }
                }
            }
        }

        /// <summary>
        /// 获取表格数据源
        /// </summary>
        /// <returns></returns>
        public override object GetTableDataSource()
        {
            return tableDataSource;
        }

        /// <summary>
        /// 清空数据源
        /// </summary>
        public override void ClearTableDataSource()
        {
            base.ClearTableDataSource();
            this.Id_ent = null;
            this.Code_entp = null;

            tableDataSource.Clear();
        }

        /// <summary>
        /// 获取签署的医嘱集合（同步病历）
        /// </summary>
        /// <returns></returns>
        public CiOrderDO[] GetSignedOrders()
        {
            return ordersSign;
        }

        /// <summary>
        /// 医嘱删除
        /// </summary>
        /// <param name="ciOrder"></param>
        /// <returns></returns>
        public bool DeleteOrders(CiOrderDO[] orders)
        {
            // TODO: 填写医嘱删除逻辑
            OrderOperateDTO operateDTO = getOrderOperateDTO(orders);
            OrderRstDTO orderRstDTO = orderActionDelete.exec(new OrderOperateDTO[] { operateDTO })[0];
            return orderRstDTO.IsSuccess.Value;
        }

        /// <summary>
        /// 高端商保删除
        /// </summary>
        /// <param name="idOrs"></param>
        /// <param name="id_psndoc"></param>
        /// <param name="ciEnContextDTO"></param>
        /// <returns></returns>
        public String SetOrderRefundBillCancelReserve(String[] idors, String id_psndoc, Ent4BannerDTO ent4BannerDto)
        {
            CiEnContextDTO contextDTO = CiEnContextUtil.GetCiEnContext(ent4BannerDto, EmsAppModeEnum.SVEMSAPPMODE, this.context);
            return this.maintainService.setOrderRefundBillCancelReserve(idors, id_psndoc, contextDTO);
        }

        /// <summary>
        /// 医嘱签署
        /// </summary>
        /// <param name="orders"></param>
        /// <param name="patInfo"></param>
        /// <returns></returns>
        public bool SignOrders(CiOrderDO[] orders, Ent4BannerDTO ent4BannerDto,FMap2 map2)
        {
            // TODO:填写医嘱签署逻辑
            if (orders == null || orders.Length == 0)
                return false;

            OrderOperateDTO operateDTO = new OrderOperateDTO();
            // 增加就诊上下文环境，用户医嘱签署时，在医嘱中保存保外诊断相关属性
            CiEnContextDTO contextDTO = CiEnContextUtil.GetCiEnContext(ent4BannerDto, EmsAppModeEnum.SVEMSAPPMODE, this.context);
            operateDTO.Document = new FArrayList();
            orders.ToList<CiOrderDO>().ForEach(ord => { operateDTO.Document.append(ord.Id_or); });
            
             
            operateDTO.EnContext = contextDTO;
            operateDTO.Extension = map2;
            OrderRstDTO orderRstDTO = orderActionSign.exec(new OrderOperateDTO[] { operateDTO })[0];
            if (orderRstDTO == null) 
                return false;
            FMap2 emsExtension = orderRstDTO.Extension;
            if (emsExtension != null)
            {
                if (emsExtension["specilDrugs"] != null)
                {
                    //特殊药判断提示
                    if (!this.IsContinue("提示", emsExtension["specilDrugs"].ToString()))
                    {
                        return SignOrders(orders, ent4BannerDto, emsExtension);
                    }
                    else
                    {
                        return false;
                    }
                }
                //医保规则
                if (emsExtension["hprule"] != null)
                {
                    FArrayList2 hplist = (FArrayList2)emsExtension["hprule"];
                    bool information = false; // fasle  提示， true 终止

                    if (hplist != null && hplist.Count > 0)
                    {
                        List<MedicalSharingDTO> medicalSharinglist = new List<MedicalSharingDTO>();

                        foreach (MedicalSharingDTO  dto in hplist)
                        {
                            if (dto != null && dto.Code == "Stop")
                            {
                                information = true;
                            }
                            medicalSharinglist.Add(dto);
                        }
                        using (MedicalSharingInfoForm from = new MedicalSharingInfoForm(medicalSharinglist))
                        {
                            from.Text = "医保规则验证";
                            if (information)
                            {
                                from.confirmBtn.Visible = false;
                                from.cancelBtn.Text = "确定";
                            }
                            else
                            {
                                from.cancelBtn.Visible = false;
                                from.confirmBtn.Text = "确定";
                            }
                            if (from.ShowDialog() == DialogResult.OK)
                            {
                                return SignOrders(orders, ent4BannerDto, emsExtension);
                            }
                            else
                            {
                                return false;
                            }
                        }
                    }
                }
                if (emsExtension["willCheckIdOrs"] != null)
                {
                    //医保和临床路径未判断的话，就弹窗进行判断
                    FArrayList willCheckIdOrs = (FArrayList)emsExtension["willCheckIdOrs"];
                    string[] id_ors = willCheckIdOrs.Cast<string>().ToArray();
                    OrReport report = new OrReport(id_ors);
                    DialogResult result = report.ShowDialog(XFormManager.MainFrom);
                    if (result == DialogResult.OK)
                    {   
                        FMap2 map = map2;
                        return SignOrders(orders, ent4BannerDto, map);
                    }
                    else
                    {
                        return false;
                    }
                }
                
                if (emsExtension.Keys.Contains("UnCheckIdors"))
                {
                    //开立权限校验
                    FArrayList uncheckidList = emsExtension["UnCheckIdors"] as FArrayList;
                    List<string> uncheckids = uncheckidList.Cast<String>().ToList();
                    if (uncheckids.Count == orders.Length)
                    {
                        this.ShowInfo(emsExtension["ErrMsg"].ToString());
                        return false;
                    }
                    if (!this.IsContinue("提示", emsExtension["ErrMsg"] + "是否继续？"))
                    {
                        return false;
                    }
                    else
                    {
                        if (uncheckids.Count > 0)
                        {
                            List<CiOrderDO> ciordlist = orders.ToList();
                            foreach (string idor in uncheckids)
                            {
                                ciordlist.Remove(ciordlist.Find(p => p.Id_or == idor.Trim()));
                            }
                            FMap2 map = new FMap2();
                            return SignOrders(ciordlist.ToArray(), ent4BannerDto, map);
                        }
                    }
                }

                if (emsExtension["checkPatInfoSrvs"] != null)
                {
                    // 如果是毒麻药，需要保存代理人信息
                    FArrayList checkPatInfoSrvs = (FArrayList)emsExtension["checkPatInfoSrvs"];
                    OrSrvAgentInfoDO agentInfo = LogicEx.GetInstance().newOrSrvAgentInfoDOFromBanner(ent4BannerDto);
                    CheckPatAgentInfoDialog dialog = new CheckPatAgentInfoDialog(agentInfo, checkPatInfoSrvs);
                    if (dialog.ShowDialog() == DialogResult.OK)
                    {
                        this.maintainService.saveCheckPatInfo(checkPatInfoSrvs, agentInfo);
                        FMap2 map = new FMap2();
                        return SignOrders(orders, ent4BannerDto, map);
                    }
                    else
                    {
                        return false;
                    }
                }

                this.initMrSignCiOrderList(emsExtension);
            }
            
            return true;
        }

        /// <summary>
        /// 获取同步到病历中的处置数据（处置的签署和校验逻辑有待调整，调整后同步修改同步到病历逻辑）
        /// </summary>
        /// <param name="vlInfoDto"></param>
        private void initMrSignCiOrderList(FMap2 emsExtension)
        {
            if (emsExtension["ciors"] != null)
            {   // 换成当前签署的医嘱,用于同步到病历
                FArrayList ordlist = (FArrayList)emsExtension["ciors"];
                List<CiOrderDO> signlist = new List<CiOrderDO>();
                if (ordlist == null) return;
                foreach (CiOrderDO ord in ordlist)
                {
                    signlist.Add(ord);
                }
                this.ordersSign = signlist.ToArray();
            }
        }

        /// <summary>
        /// 重新分方
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="sd_entp"></param>
        /// <returns></returns>
        public void RepeatPres(string id_ent, string id_dep_sign, string sd_entp, Ent4BannerDTO ent4BannerDTO)
        {
            CiEnContextDTO contextDTO = CiEnContextUtil.GetCiEnContext(ent4BannerDTO, this.context);
            CiOrderDO[] orders = this.maintainService.CiOPAgainPres(id_ent, id_dep_sign, sd_entp, contextDTO);
        }

        /// <summary>
        /// 医嘱撤回
        /// </summary>
        /// <param name="orders"></param>
        /// <param name="isResreshFunc"></param>
        /// <returns></returns>
        public bool RevertOrders(CiOrderDO[] orders)
        {
            // TODO:填写医嘱撤回逻辑
            OrderOperateDTO operateDTO = getOrderOperateDTO(orders);;
            OrderRstDTO orderRstDTO = orderActionRevert.exec(new OrderOperateDTO[] { operateDTO })[0];
            return orderRstDTO.IsSuccess.Value;
        }

        /// <summary>
        /// 医嘱作废
        /// </summary>
        /// <param name="orders"></param>
        /// <returns></returns>
        public bool CancelOrders(CiOrderDO[] orders)
        {
            OrderOperateDTO operateDTO = getOrderOperateDTO(orders);
            OrderRstDTO orderRstDTO = orderActionCancel.exec(new OrderOperateDTO[] { operateDTO })[0];
            return orderRstDTO.IsSuccess.Value;
        }

        /// <summary>
        /// 医嘱删除撤回
        /// </summary>
        /// <param name="deleteOrders"></param>
        /// <param name="revertOrders"></param>
        /// <returns></returns>
        public bool DeleteRevertOrders(CiOrderDO[] deleteOrders, CiOrderDO[] revertOrders)
        {
            orderActionComplex.Clear();
            orderActionComplex.Add(orderActionDelete);
            orderActionComplex.Add(orderActionRevert);

            OrderOperateDTO deleteOperateDTO = getOrderOperateDTO(deleteOrders);
            OrderOperateDTO revertOperateDTO = getOrderOperateDTO(revertOrders);

            OrderOperateDTO[] orderOperateDTOs = new OrderOperateDTO[] { deleteOperateDTO, revertOperateDTO };
            OrderRstDTO[] orderRstDTOs = orderActionComplex.exec(orderOperateDTOs);

            bool isSucc = false;
            foreach (var orderRstDTO in orderRstDTOs)
            {
                if (orderRstDTO.IsSuccess.Value)
                    isSucc = true;
            }

            return isSucc;
        }

        /// <summary>
        /// 医嘱删除作废
        /// </summary>
        /// <param name="deleteOrders"></param>
        /// <param name="cancelOrders"></param>
        /// <returns></returns>
        public bool DeleteCancelOrders(CiOrderDO[] deleteOrders, CiOrderDO[] cancelOrders)
        {
            orderActionComplex.Clear();
            orderActionComplex.Add(orderActionDelete);
            orderActionComplex.Add(orderActionCancel);

            OrderOperateDTO deleteOperateDTO = getOrderOperateDTO(deleteOrders);
            OrderOperateDTO cancelOperateDTO = getOrderOperateDTO(cancelOrders);

            OrderOperateDTO[] orderOperateDTOs = new OrderOperateDTO[] { deleteOperateDTO, cancelOperateDTO };
            OrderRstDTO[] orderRstDTOs = orderActionComplex.exec(orderOperateDTOs);

            bool isSucc = false;
            foreach (var orderRstDTO in orderRstDTOs)
            {
                if (orderRstDTO.IsSuccess.Value)
                    isSucc = true;
            }

            return isSucc;
        }

        /// <summary>
        /// 构造参数DTO
        /// </summary>
        /// <param name="orders"></param>
        /// <returns></returns>
        private OrderOperateDTO getOrderOperateDTO(CiOrderDO[] orders)
        {
            OrderOperateDTO operateDTO = new OrderOperateDTO();
            operateDTO.Document = new FArrayList();
            operateDTO.Extension = new FMap2();
            orders.ToList<CiOrderDO>().ForEach(ord =>
            {
                operateDTO.Document.append(ord.Id_or);
                operateDTO.Extension.Add(ord.Id_or, ord.Sd_su_or);
            });
            
            return operateDTO;
        }

        /// <summary>
        /// 复制医嘱
        /// </summary>
        /// <param name="orders"></param>
        /// <returns></returns>
        public bool CopyOrders(CiOrderDO[] orders)
        {
            OrderOperateDTO operateDTO = getOrderOperateDTO(orders);
            OrderRstDTO orderRstDTO = orderActionCopy.exec(new OrderOperateDTO[] { operateDTO })[0];
            return orderRstDTO.IsSuccess.Value;
        }

        /// <summary>
        /// 作废复制医嘱
        /// </summary>
        /// <param name="orders"></param>
        /// <returns></returns>
        public bool CancelCopyOrders(CiOrderDO[] orders)
        {
            orderActionComplex.Clear();
            orderActionComplex.Add(orderActionCancel);
            orderActionComplex.Add(orderActionCopy);

            OrderOperateDTO operateDTO = getOrderOperateDTO(orders);

            OrderOperateDTO[] orderOperateDTOs = new OrderOperateDTO[] { operateDTO, operateDTO };
            OrderRstDTO[] orderRstDTOs = orderActionComplex.exec(orderOperateDTOs, true);

            bool isSucc = true;
            foreach (var orderRstDTO in orderRstDTOs)
            {
                if (!orderRstDTO.IsSuccess.Value)
                    isSucc = false;
            }

            return isSucc;
        }

        /// <summary>
        /// 医保共享数据 是否调用医保共享数据参数
        /// </summary>
        /// <param name="id_org"></param>
        /// <param name="id_dept"></param>
        /// <returns></returns>
        public FBoolean GetIsDeptOrDatumshared(string id_org, string id_dept)
        {
            return this.ciOrderQryService.getIsDeptOrDatumshared(id_org, id_dept);
        }

        /// <summary>
        /// 医保共享排斥数据
        /// </summary>
        /// <param name="id_hp"></param>
        /// <returns></returns>
        public Dictionary<string, BdHpUnlimitDrugDO> GetDictbdHpUnlimitDrug(string id_hp)
        {
            string WhereStr = "id_hp ='" + id_hp + "'";
            BdHpUnlimitDrugDO[] limitDrug = this.bdHpUnlimitDrugDoCrudService.find(WhereStr, "", new FBoolean());
            Dictionary<string, BdHpUnlimitDrugDO> dict = null;
            if (limitDrug != null && limitDrug.Length > 0)
            {
                dict = new Dictionary<string, BdHpUnlimitDrugDO>();
                foreach (BdHpUnlimitDrugDO drugDO in limitDrug)
                {
                    dict.Add(drugDO.Code_hp, drugDO);
                }
                MedicalSharingCache.setBdHpUnlimitDrugDO(dict);
            }
            return dict;
        }
        /// <summary>
        /// 本院医保数据，（未上传医保中心的数据）
        /// </summary>
        /// <param name="ent4BannerDTO"></param>
        public void getMedicalSharingDTO(Ent4BannerDTO ent4BannerDTO)
        {
            Dictionary<string, MedicalSharingDTO[]> dict = null;
           MedicalSharingDTO[] medicalSharingDto =  ciOrderQryService.getMedicalSharing(ent4BannerDTO.Id_pat,ent4BannerDTO.Id_hp);
           if (medicalSharingDto != null)
           {
               dict = new Dictionary<string, MedicalSharingDTO[]>();
               dict.Add(ent4BannerDTO.No_hp, medicalSharingDto);
               MedicalSharingCache.setDicMedicalSharing(dict);
            }
        }
        /// <summary>
        /// 险种类型
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        public string getcodeHpkind(String id_ent)
        {
            String wherestr = "id_ent = '" + id_ent + "' and  fg_maj='Y'";
            EntHpDO[] entHpdp = iEnthpCrudService.find(wherestr, "", false);
             if (entHpdp != null && entHpdp.Length >0)
             {
                 MedicalSharingCache.setCode_hpkind(entHpdp[0].Code_hpkind);
                 return entHpdp[0].Code_hpkind;
             }
            return null;
        }

        /// <summary>
        /// 医生站记账
        /// </summary>
        /// <param name="id_ent">就诊id</param>
        /// <param name="code_entp">就诊类型</param>
        /// <param name="accountType">记账类型 </param>
        ///  @DmEnumDesc(name="预交金记账",description="预交金记账")
        ///  public static final String CG_PREPAY="1"; //预交金记账
        ///  @DmEnumDesc(name= "高端商保记账", description= "高端商保记账")
        ///  public static final String CG_HPCG="2"; //高端商保记账
        /// <returns>记账结果</returns>
        public string OrderKeepAccounts(String id_ent, String code_entp, String accountType, string id_psndoc)
        {
            return this.maintainService.OrderKeepAccounts(id_ent, code_entp, accountType, id_psndoc);
        }

        /// <summary>
        /// 预交金销账
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="code_entp"></param>
        /// <param name="AcctountType"></param>
        /// <returns></returns>
        public string CancelOrderAccounting(String id_ent, String code_entp, string id_psndoc)
        {
            return this.maintainService.CancelOrderAccounting(id_ent, code_entp, id_psndoc);
        }

        /// <summary>
        /// 获取当前登录人未签署的药品
        /// </summary>
        /// <param name="patDo"></param>
        /// <returns></returns>
        public CiOrderDO[] GetCiOrderDOsDrug(Ent4BannerDTO ent4BannerDTO)
        {
            String whereStr = String.Format(" ID_EN ='{0}' and CODE_ENTP ='{1}' and SD_SU_OR ='0' and ID_EMP_OR = '{2}' and SD_SRVTP like '0101%' ",
                ent4BannerDTO.Id_ent, ent4BannerDTO.Code_entp, this.context.PsnInfo.Id_psndoc);
            return this.orderItemMService.find(whereStr, "", FBoolean.False);
        }

        /// <summary>
        /// 签署时，判断医保共享
        /// </summary>
        /// <param name="ent4BannerDTO"></param>
        public MedicalSharingDTO[] getOPenOrdder(CiOrderDO[] orders, Ent4BannerDTO ent4BannerDTO)
        {
            if (orders != null)
            {
                string[] id_or = new string[orders.Length];
                int i = 0;
                foreach (CiOrderDO orderdo in orders)
                {
                    id_or[i] = orderdo.Id_or;
                    i++;
                }
                MedicalSharingDTO[] medicalSharingDto = ciOrderQryService.getOPenCiOrder(id_or, ent4BannerDTO.Id_pat, ent4BannerDTO.Id_hp);
                return medicalSharingDto;
            }

            return null;
        }

        /// <summary>
        /// 是否存在有效医嘱
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        public bool IsExistValidOrders(String id_ent)
        {
            return enService.IsExistValidOrders(id_ent, "0");
        }

        /// <summary>
        /// 是否存在开立医嘱
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        public bool IsExistOpenOrders(String id_ent)
        {
            return enService.IsExistOpenOrders(id_ent);
        }

        public bool IsAllOrsBlRefound(String[] idors)
        {
            ICiprintExtService service = XapServiceMgr.find<ICiprintExtService>();
            return service.CheckAllOrsBlRefound(idors).Value;
        }
        #endregion
    }
}

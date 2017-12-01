
using iih.bd.iih.bd.bc.udi;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.i;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.ems.d;
using iih.ci.ord.emsdi.d;
using iih.ci.ord.i;
using iih.ci.ord.opemergency.ems.dp;
using System;
using System.Collections.Generic;
using System.Linq;
using iih.bd.srv.medsrv.d;
using iih.ci.ord_stub.i;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.mw.serviceframework.ex;
using xap.rui.appfw;
using xap.rui.appfw.extentions;
using xap.rui.control.extentions;
using iih.ci.ord.opemergency.ems.common;
using iih.bl.hp.bdhpindicationdto.d;
using iih.ci.ord.common.utils;
using iih.bd.bc.udi;

namespace iih.ci.ord.opemergency.ordfeebill.model
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ordfeebill.model    </para>    
    /// <para>类 名 称 :  OrdFeeBillViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  vivi         				</para> 
    /// <para>修 改 人 :  vivi         				</para> 
    /// <para>创建时间 :  12/13/2016 7:41:53 PM             </para>
    /// <para>更新时间 :  12/13/2016 7:41:53 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OrdFeeBillViewModel : BaseBizViewModel
    {
        #region 变量定义
        /// <summary>
        /// 表格模型对象
        /// </summary>
        private XapDataList<CiOrdFeeSrvDTO> tableDatasource = new XapDataList<CiOrdFeeSrvDTO>();
        /// <summary>
        /// 医嘱查询接口
        /// </summary>
        private ICiorderMDOCrudService iCiorderMDOCrudService;
        /// <summary>
        /// 医疗单查询接口
        /// </summary>
        private ICiOrdQryService iCiOrdQryService;
        /// <summary>
        /// 医疗单操作接口
        /// </summary>
        private ICiOrdMaintainService iCiOrdMaintainService;
        /// <summary>
        /// 医嘱映射表，辅助视图列表显示
        /// </summary>
        private Dictionary<String, CiOrderDO> idor2OrderDOMap = new Dictionary<string, CiOrderDO>();
        private Dictionary<String, CiEmsDTO> idor2EmsDTOMap = new Dictionary<string, CiEmsDTO>();
        /// <summary>
        ///医嘱费用清单接口
        /// </summary>
        private ICiFeeListMainService iCiFeeListMainService;
        #endregion

        #region 构造方法
        public OrdFeeBillViewModel()
        {
            iCiorderMDOCrudService = XapServiceMgr.find<ICiorderMDOCrudService>();
            iCiOrdQryService = XapServiceMgr.find<ICiOrdQryService>();
            iCiOrdMaintainService = XapServiceMgr.find<ICiOrdMaintainService>();
            iCiFeeListMainService = XapServiceMgr.find<ICiFeeListMainService>();
        }

        #endregion

        #region 覆盖方法
        public override object GetTableDataSource()
        {
            return tableDatasource;
        }

        public override void ClearTableDataSource()
        {
            base.ClearTableDataSource();
            tableDatasource.Clear();
            idor2OrderDOMap.Clear();
            idor2EmsDTOMap.Clear();
        }
        #endregion

        #region 公共接口

        /// <summary>
        /// 根据就诊信息重查医嘱信息，并生成费用清单数据
        /// </summary>
        /// <returns></returns>
        public bool Reload()
        {
            //return oldLoad();
            return newLoad();
        }
        public bool oldLoad()
        {
            if (this.GetEnt4BannerDTO() == null)
            {
                return false;
            }
            this.errorMsgString = "";
            try
            {
                idor2EmsDTOMap.Clear();
                idor2OrderDOMap.Clear();
                {
                    FMap2 rtnMap = iCiOrdQryService.getOrdFeebill(GetEnt4BannerDTO().Id_ent, GetEnt4BannerDTO().Code_entp);
                    if (rtnMap != null && rtnMap.Keys.Count > 0 && rtnMap.Keys.Contains("orders") && rtnMap.Keys.Contains("emses"))
                    {
                        FArrayList ordList = rtnMap["orders"] as FArrayList;
                        FArrayList emsList = rtnMap["emses"] as FArrayList;
                        FMap blsrvmap = rtnMap["blsrvdes"] as FMap;

                        CiOrderDO[] szOrders = ordList.Cast<CiOrderDO>().ToArray();
                        CiEmsDTO[] szEmses = emsList.Cast<CiEmsDTO>().ToArray();

                        // 装配UI数据
                        List<CiOrdFeeSrvDTO> list = OrdFeeBillListFrom(szOrders, szEmses, blsrvmap);
                        if (null != list && list.Count > 0)
                        {

                            this.tableDatasource = list.ToArray(); // 控件不支持，不应该直接改写对象
                        }
                        else
                        {
                            tableDatasource.Clear();
                        }
                    }
                    else
                    {
                        this.errorMsgString = "获取费用清单数据失败";
                        return false;
                    }
                }
            }
            catch (XapServiceException e)
            {
                this.errorMsgString = e.ErrorMsg.Message;
            }
            catch (Exception e)
            {
                this.errorMsgString = e.Message;
            }


            return false;
        }
        /// <summary>
        /// 根据就诊信息费用清单数据
        /// </summary>
        /// <returns></returns>
        public bool newLoad()
        {
            if (this.GetEnt4BannerDTO() == null)
            {
                return false;
            }
            FeeListLoadDTO feeListLoadDTO = new FeeListLoadDTO();
            CiEnContextDTO ciEnContextDTO = BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO;
            if (ciEnContextDTO == null)
            {
                return false;
            }
            feeListLoadDTO.EnContext = ciEnContextDTO;
            FeeListRstDTO feeListRstDTO = iCiFeeListMainService.load(feeListLoadDTO);
            FArrayList feeList = feeListRstDTO.Document as FArrayList;
            if (null != feeList && feeList.Count > 0)
            {
                this.tableDatasource = feeList.Cast<CiOrdFeeSrvDTO>().ToArray(); // 控件不支持，不应该直接改写对象
            }
            else
            {
                //this.errorMsgString = "获取费用清单数据失败";
                tableDatasource.Clear();
            }
            return false;
        }
        public bool HasOrder(String id_or)
        {
            if (String.IsNullOrEmpty(id_or)) {
                return false;
            }
            return this.idor2OrderDOMap.ContainsKey(id_or);
        }

        public virtual bool LoadFeeSrv(CiOrdFeeSrvDTO newDrug)
        {
            #region 有效性检查
            if (CheckRepeatFeeSrv(newDrug))
            {
                this.errorMsgString = String.Format("【{0}】 在该医嘱中存在，请选择其它服务",newDrug.Name_srv);
                return false;
            }
            #endregion

            #region 填充默认值
            int nUseDays = GetOrderDO(newDrug.Id_or).Days_or??1;
            newDrug.Id_unit_sale = newDrug.Id_unit_med;
            newDrug.Name_unit_sale = newDrug.Name_unit_med;
            newDrug.Fg_or = false;
            newDrug.Fg_bl = true;
            newDrug.Eu_sourcemd = (int)OrSrvSourceFromEnum.PHYSIANFEEADD;
            #endregion

            #region 计算总量和价格
            newDrug.Price = this.GetLogicEx().getSrvNotMMPri(newDrug.Id_srv, newDrug.Id_primd);
            
            #endregion

            #region 计算总量
            this.CalculateAmtCur(newDrug);
            #endregion

            #region 总价
            if (newDrug.Fg_mm != null && newDrug.Fg_mm.Value) {
                newDrug.Amt_total = newDrug.Price * newDrug.Quan_cur;
            }
            else {
                newDrug.Amt_total = newDrug.Price * newDrug.Quan_total_medu;
            }
            #endregion
            FArrayList list = new FArrayList();
            //判断是否是保外诊断
            CiEnContextDTO ciEnContextDTO = BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO;
            //保外诊断标识
            string eu_hpbeyond = ciEnContextDTO.Eu_hpbeyond;

            if (ent4BannerDTO != null && true == ent4BannerDTO.Fg_hpfundpay && HpBeyondEnum.HPDIAG.Equals(ciEnContextDTO.Eu_hpbeyond)/*保内诊断*/)
            {
                BdHpIndicationDTO bdhpindication = HpJudgeUtil.getInstance().getBdHpIndicationDTO(newDrug.Id_srv, newDrug.Id_mm, this.ent4BannerDTO);
                if (bdhpindication != null)
                {
                    newDrug.Fg_treat = bdhpindication.Fg_indic;
                    newDrug.Fg_indic = bdhpindication.Fg_indic;
                    newDrug.Id_hp = bdhpindication.Id_hp;
                    newDrug.Sd_hpsrvtp = bdhpindication.Sd_hpsrvtp;
                    newDrug.Id_hpsrvtp = bdhpindication.Id_hpsrvtp;
                    if (string.IsNullOrEmpty(bdhpindication.Id_hpsrvtp))
                    {
                        newDrug.Id_hpsrvtp = HpJudgeUtil.IdHpSrvtpFromSdHpSrvtp(bdhpindication.Sd_hpsrvtp);
                    }
                    newDrug.Name_hpsrvtp = HpJudgeUtil.NameHpSrvtpFromSdHpSrvtp(bdhpindication.Sd_hpsrvtp);
                    newDrug.Name_hp = HpJudgeUtil.NameHpSrvtpFromSdHpSrvtp(bdhpindication.Sd_hpsrvtp); 
                    newDrug.Fg_selfpay = HpJudgeUtil.getInstance().isSelfPay(bdhpindication);
                    newDrug.Fg_hpindicjudged = HpJudgeUtil.getInstance().getFg_hpindicjudged(bdhpindication);
                    list.Add(bdhpindication);
                }
            }
            else if (ciEnContextDTO.Fg_hpfundpay == null || !(bool)ciEnContextDTO.Fg_hpfundpay || (ciEnContextDTO.Eu_hpbeyond != null && !ciEnContextDTO.Eu_hpbeyond.Equals(HpBeyondEnum.HPDIAG)))
            {
                newDrug.Fg_treat = false;
                newDrug.Fg_selfpay = true;
            }
            newDrug.setAttrVal<FArrayList>("BdHpIndicationDTO", list);
            #region 计算执行科室
            CalculateFeeDeptMp(newDrug);
            #endregion

            return true;
        }

        protected bool CheckRepeatFeeSrv(CiOrdFeeSrvDTO feeSrv)
        {
            return tableDatasource.Count(p =>!p.IsDELETED && p.Id_or.Equals(feeSrv.Id_or) && p.Id_srv.Equals(feeSrv.Id_srv)) > 1;
            
        }
        /// <summary>
        /// 根据给定的医嘱ID，获取医嘱对象
        /// </summary>
        /// <param name="id_or"></param>
        /// <returns></returns>
        public CiOrderDO GetOrderDO(String id_or)
        {
            if (HasOrder(id_or)) {
                return idor2OrderDOMap[id_or];
            }
            return null;

        }


        public Boolean AllowEdit(CiOrdFeeSrvDTO o)
        {
            CiOrderDO ord = GetOrderDO(o.Id_or);
            if (null != ord)
                return (String.IsNullOrEmpty(ord.Sd_su_or) || ord.Sd_su_or.Equals("0")) &&
                    (!(o.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN ||
                    o.Eu_sourcemd == (int)OrSrvSourceFromEnum.AGENTFROMPRIMD ||
                    o.Eu_sourcemd == (int)OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD));
            else
                return false;
        }

        /// <summary>
        /// 新增一个空行数据
        /// </summary>
        /// <returns></returns>
        public CiOrdFeeSrvDTO AddNew()
        {
            return this.tableDatasource.AddNew();
        }

        /// <summary>
        /// 删除给定的费用清单数据
        /// </summary>
        /// <param name="o"></param>
        public void Delete(CiOrdFeeSrvDTO o)
        {
            this.tableDatasource.Delete(o, o.IsNEW);
        }

        public bool HasEmptyFeeSrv(String id_or)
        {
            return tableDatasource.Count(p=>!p.IsDELETED&&p.Id_or.Equals(id_or) && string.IsNullOrEmpty(p.Id_srv)) > 0;
        }

        public CiOrdFeeSrvDTO GetLastOfFeeSrv(string id_or)
        {
            var groupFeeSrv = tableDatasource.Where(p => !p.IsDELETED&&p.Id_or.Equals(id_or));
            return groupFeeSrv != null ? groupFeeSrv.LastOrDefault() : tableDatasource.Where(p => !p.IsDELETED).FirstOrDefault();
        }

        /// <summary>
        /// 获取医嘱状态
        /// </summary>
        /// <param name="id_or"></param>
        /// <returns></returns>
        public String GetOrdState(String id_or)
        {
            CiOrderDO ord = GetOrderDO(id_or);

            return ord.Ord_colligate;
        } 

        /// <summary>
        /// 保存费用清单数据
        /// </summary>
        /// <returns></returns>

        public bool Save()
        {
            bool rtn = true;
            this.errorMsgString = "";
            // 从表格数据源获取
            List<CiEmsSrvDTO> updateSrvList = new List<CiEmsSrvDTO>();
            this.tableDatasource.ToList().ForEach(srv =>
            {
                if (srv.IsNEW && idor2EmsDTOMap.ContainsKey(srv.Id_or)) {
                    /**
                     * 新增场景：通过 Id_or 找到对应的医疗单，然后，拿到医疗单的服务列表对象，将表格中补录的费用对象。转化为医疗单服务对象，追加到医疗单列表中；
                     * 并设置医疗单为更新状态
                     **/
                    CiEmsDTO ems = idor2EmsDTOMap[srv.Id_or];
                    CiEmsSrvDTO addSrv = new CiEmsSrvDTO();
                    addSrv.deSerializeJson(srv.serializeJson());
                    addSrv.Id_srv_src = ems.Id_srv;
                    //addSrv.Id_or = null;
                    addSrv.Fg_set = false;
                    addSrv.Dt_create_srv = CommonExtentions.NowTime(this);
                    addSrv.Price_cur = addSrv.Amt_total;
                    addSrv.Amt_total = null;
                    addSrv.Sortno = ems.Emssrvs.Cast<CiEmsSrvDTO>().Count(p => !p.IsDELETED)+1;
                    updateSrvList.Add(addSrv);
                }
                else if (srv.IsDELETED && idor2EmsDTOMap.ContainsKey(srv.Id_or)) {
                    /**
                     * 删除场景：找到医疗单中需要删除的 服务项目 ，然后设置 status 状态为 Deleted；
                     * 如果在医疗单的服务项目中没有找到，列表选择的 服务项目 ，则应该是出现了异常情况，不应该发生；
                     **/
                    CiEmsDTO ems = idor2EmsDTOMap[srv.Id_or];
                    // id_orsrv 不为空，则进行数据库数据删除
                    if (!string.IsNullOrEmpty(srv.Id_orsrv))
                    {
                        CiEmsSrvDTO delSrv = ems.Emssrvs.Cast<CiEmsSrvDTO>().FirstOrDefault(p => p.Id_orsrv.Equals(srv.Id_orsrv));
                        if (delSrv != null)
                        {
                            delSrv.Status = DOStatus.DELETED;
                            updateSrvList.Add(delSrv);
                        }
                    }
                    // 非数据库中记录数据，则直接从列表中删除
                    else {
                        this.tableDatasource.Remove(srv);
                    }
                }
                else if (srv.IsUPDATED && idor2EmsDTOMap.ContainsKey(srv.Id_or)) {
                    /**
                     * 更新场景：找到医疗单中需要更新的 服务项目 ，然后设置 status 状态为 Update；
                     * 如果在医疗单的服务项目中没有找到，列表选择的 服务项目 ，则应该是出现了异常情况，不应该发生；
                     **/
                    CiEmsDTO ems = idor2EmsDTOMap[srv.Id_or];
                    CiEmsSrvDTO updateSrv = ems.Emssrvs.Cast<CiEmsSrvDTO>().FirstOrDefault(p => srv.Id_orsrv.Equals(p.Id_orsrv));
                    if (updateSrv != null) {
                        ems.Status = DOStatus.UPDATED;
                        updateSrv.deSerializeJson(srv.serializeJson());
                        updateSrvList.Add(updateSrv);
                    }
                    else {
                        this.errorMsgString = "需要更新的费用项目，并没有在后台查到相关记录";
                        rtn = false;
                    }
                }
                //else if (srv.IsUNCHANGED && idor2EmsDTOMap.ContainsKey(srv.Id_or))
                //{
                //    // 将没有改变的
                //    CiEmsDTO ems = idor2EmsDTOMap[srv.Id_or];
                //    CiEmsSrvDTO unChangedSrv = ems.Emssrvs.Cast<CiEmsSrvDTO>().FirstOrDefault(p => srv.Id_orsrv.Equals(p.Id_orsrv));
                //    unChangedSrv.Status = DOStatus.UNCHANGED;
                //    updateSrvList.Add(unChangedSrv);
                //}
            });

            if (updateSrvList.Count > 0) {
                try {
                    CiEnContextDTO ctx = CiEnContextUtil.GetCiEnContext(this.GetEnt4BannerDTO(), this.context);
                    CiEmsSrvDTO[] rtSrvs = XapServiceMgr.find<ICiOrdMaintainService>().saveOrdFeeBill(updateSrvList.ToArray(), ctx);
                }
                catch(XapServiceException e) {
                    this.errorMsgString = e.ErrorMsg != null?e.ErrorMsg.Message:e.Message;
                    rtn = false;
                }
                catch(Exception e) {
                    this.errorMsgString = e.Message;
                    rtn = false;
                }
                
                
            }
            return rtn;
        }
        #endregion

        #region 私有方法

        /// <summary>
        /// 将所有的医嘱以及医嘱关联的医疗单整合成费用清单数据集合
        /// </summary>
        /// <param name="szOrders"></param>
        /// <param name="szEmses"></param>
        /// <returns></returns>
        private List<CiOrdFeeSrvDTO> OrdFeeBillListFrom(CiOrderDO[] szOrders, CiEmsDTO[] szEmses, FMap blsrvFMap)
        {
            List<CiOrdFeeSrvDTO> OrdFeeBillList = new List<CiOrdFeeSrvDTO>();
            foreach (CiOrderDO ord in szOrders) {
                CiEmsDTO ems = szEmses.ToList().FirstOrDefault(e => e.Id_or.Equals(ord.Id_or));
                if (null != ems) {
                    OrdFeeBillList.AddRange(OrdFeeBillListFrom(ord, ems, blsrvFMap));
                    idor2EmsDTOMap.Add(ord.Id_or, ems);
                    idor2OrderDOMap.Add(ord.Id_or, ord);
                }
            }
            return OrdFeeBillList;
        }

        /// <summary>
        /// 将医嘱数据和医疗单数据整合成一组费用清单数据
        /// </summary>
        /// <param name="ord"></param>
        /// <param name="ems"></param>
        /// <returns></returns>
        private CiOrdFeeSrvDTO[] OrdFeeBillListFrom(CiOrderDO ord, CiEmsDTO ems, FMap blsrvFMap)
        {
            List<CiOrdFeeSrvDTO> OrdFeeBillList = new List<CiOrdFeeSrvDTO>();

            ems.Emssrvs.Cast<CiEmsSrvDTO>().OrderBy(p=>p.Sortno).Where(srvdto => (!String.IsNullOrEmpty(srvdto.Code_srv) && !String.IsNullOrEmpty(srvdto.Name_srv)) && srvdto.Fg_bl != null && srvdto.Fg_bl.Value).ToList().ForEach(srvdto =>
            {
                CiOrdFeeSrvDTO ordFeeBill = new CiOrdFeeSrvDTO();
                ordFeeBill.deSerializeJson(srvdto.serializeJson());

                ordFeeBill.Content_or = ord.Content_or;
                ordFeeBill.Dt_effe = ord.Dt_effe;
                ordFeeBill.setAttrVal("Ord_colligate", ord.Ord_colligate);
                ordFeeBill.Code_or =  ord.Code_or;


                if (String.IsNullOrEmpty(ordFeeBill.Id_unit_sale)) {
                    ordFeeBill.Id_unit_sale = ordFeeBill.Id_unit_med;
                    ordFeeBill.Name_unit_sale = ordFeeBill.Name_unit_med;
                }

                if (ordFeeBill.Price == null) {
                    ordFeeBill.Price = FDouble.ZERO_DBL;
                }

                // 物品标志
                if (ordFeeBill.Fg_mm != null && ordFeeBill.Fg_mm.Value) {
                    ordFeeBill.Amt_total = ordFeeBill.Price * (ordFeeBill.Quan_cur == null ? 0 : ordFeeBill.Quan_cur);
                    //且非草药时
                    if (ordFeeBill.Sd_srvtp != null && !ordFeeBill.Sd_srvtp.StartsWith(BdSrvDictCodeConst.SD_SRVTP_HERBDRUG) && ordFeeBill.Name_mm!=null)
                    {
                        ordFeeBill.Name_srv=ordFeeBill.Name_srv+"("+ordFeeBill.Name_mm+")";
                    }
                }
                else {
                    ordFeeBill.Amt_total = ordFeeBill.Price * (ordFeeBill.Quan_total_medu == null ? 0 : ordFeeBill.Quan_total_medu);
                }

                {
                    //执行科室
                    OrWfDeptInfoDTO wf = new ciorder.viewmodel.impext.GetDeptMpImp().GetDept_mp_ids(
                       this.ent4BannerDTO.Code_entp,
                       this.ent4BannerDTO.Id_entp,
                       ordFeeBill.Sd_srvtp,
                       ordFeeBill.Id_srvca,
                       ordFeeBill.Id_srv,
                       ordFeeBill.Id_route,
                       "",
                       this.ent4BannerDTO.Id_dep_nur,
                       this.ent4BannerDTO.Id_dep_phy,
                       GetOrdDeptMp(ordFeeBill.Id_or));
                    if (wf != null) {
                        ordFeeBill.setAttrVal("str_id_mp_deps", wf.Id_mp_depts);
                    }
                    if (blsrvFMap.Keys.Contains(ordFeeBill.Id_srv))
                    {
                        ordFeeBill.Des_srv = (blsrvFMap[ordFeeBill.Id_srv] as MedSrvDO).Des;
                    }
                }
                ordFeeBill.Name_hp = ordFeeBill.Name_hpsrvtp;
                OrdFeeBillList.Add(ordFeeBill);
            });

            // 处理医保类型
            String[] szId_srv = OrdFeeBillList.Select(p => p.Id_srv).ToArray();
            String[] szId_mm  = OrdFeeBillList.Select(p => p.Id_mm).ToArray();

            bl.hp.bdhpindicationdto.d.BdHpIndicationDTO[] szHpIndication = HpJudgeUtil.getInstance().getBdHpIndicationDTO(szId_srv, szId_mm, this.ent4BannerDTO);
            if (null != szHpIndication) {
                OrdFeeBillList.ForEach(p => {
                    bl.hp.bdhpindicationdto.d.BdHpIndicationDTO dto = null;
                    if (p.Fg_mm != null && p.Fg_mm == true)
                    {
                        if ((dto = szHpIndication.FirstOrDefault(item =>item.Id_mm.Equals(p.Id_mm)&& item.Id_srv.Equals(p.Id_srv))) != null)
                        {
                            p.Name_hp = idHpSrvtpFromSdHpSrvtp(dto.Sd_hpsrvtp);
                        }
                    }
                    else { 
                       if ((dto = szHpIndication.FirstOrDefault(item => item.Id_srv.Equals(p.Id_srv))) != null) {
                            p.Name_hp = idHpSrvtpFromSdHpSrvtp(dto.Sd_hpsrvtp);
                        }    
                    }
                    
                });
            }

            return OrdFeeBillList.ToArray();
        }

        public String idHpSrvtpFromSdHpSrvtp(String sd_hpsrvtp)
        {
            if (String.IsNullOrEmpty(sd_hpsrvtp)) return null;
            if (HpDicCodeConst.SD_HPSRVTP_CLASS_A.Equals(sd_hpsrvtp))
            {
                return "甲类";
            }
            else if (HpDicCodeConst.SD_HPSRVTP_CLASS_B.Equals(sd_hpsrvtp))
            {
                return "乙类";
            }
            else if (HpDicCodeConst.SD_HPSRVTP_CLASS_C.Equals(sd_hpsrvtp))
            {
                return "丙类";
            }
            return null;
        }

        /// <summary>
        /// 计算费用总量
        /// </summary>
        /// <param name="newDrug"></param>
        protected void CalculateAmtCur(CiOrdFeeSrvDTO newDrug){
            CiOrderDO ord = GetOrderDO(newDrug.Id_or);
            if (ord != null) {
                logicEx.GetMmTotal(newDrug, GetEnt4BannerDTO().Code_entp, ord.Days_or??1);
            }
        }

        /// <summary>
        /// 计算费用项目执行科室
        /// </summary>
        /// <param name="newDrug"></param>
        protected void CalculateFeeDeptMp(CiOrdFeeSrvDTO newDrug)
        {
            #region 计算执行科室

            {
                //执行科室
                OrWfDeptInfoDTO wf = new ciorder.viewmodel.impext.GetDeptMpImp().GetDept_mp_ids(
                   this.ent4BannerDTO.Code_entp,
                   this.ent4BannerDTO.Id_entp,
                   newDrug.Sd_srvtp,
                   newDrug.Id_srvca,
                   newDrug.Id_srv,
                   newDrug.Id_route,
                   "",
                   this.ent4BannerDTO.Id_dep_nur,
                   this.ent4BannerDTO.Id_dep_phy,
                   GetOrdDeptMp(newDrug.Id_or));
                if (wf != null) {
                    newDrug.Id_dep = wf.Firstid_mp_dept;
                    newDrug.Name_dep = wf.Firstname_mp_dept;
                    newDrug.setAttrVal("str_id_mp_deps", wf.Id_mp_depts);
                }
            }

            #endregion
        }

        /// <summary>
        /// 获取主服务的执行科室
        /// </summary>
        /// <returns></returns>
        protected String GetOrdDeptMp(String id_or)
        {
            string id_dep_flow = "";
            if (idor2EmsDTOMap.ContainsKey(id_or)) {
                id_dep_flow = idor2EmsDTOMap[id_or].Id_dep_mp;
            }
            return id_dep_flow;
        }
        #endregion
    }
}

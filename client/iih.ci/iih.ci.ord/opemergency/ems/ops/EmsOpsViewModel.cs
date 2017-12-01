using System;
using System.Collections.Generic;
using System.Linq;
using iih.en.pv.dto.d;
using iih.bd.bc.udi;
using xap.rui.appfw;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.bd.srv.service.i;
using xap.mw.serviceframework;
using iih.bd.srv.ems.i;
using iih.bd.srv.ems.d;
using iih.bd.srv.dto.d;
using iih.ci.ord.cior.d;
using iih.ci.ord.emsdi.d;
using iih.ci.ord.opemergency.ems.common;
using iih.bd.srv.medsrv.d;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.ems.d;
using xap.mw.core.data;
using iih.ci.iih.ci.ord.i;
using iih.ci.ord.i;
using iih.ci.ord.dto.emsmain;
using iih.ci.ord.common.utils;
using iih.ci.ord.ciorder.utils;
using xap.rui.control.extentions;
using iih.bd.srv.medsrv.i;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.ciorder.d;

namespace iih.ci.ord.opemergency.ems.dp
{
    /// <summary>
    /// <para>描    述 :  手术医疗单数据处理模型        	</para>
    /// <para>说    明 :                      			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ems.dp    </para>    
    /// <para>类 名 称 :  EmsOpsViewModel        			</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/6/30 16:27:45             </para>
    /// <para>更新时间 :  2016/6/30 16:27:45             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    class EmsOpsViewModel : BaseEmsViewModel
    {
        private string idDepMps;
        private XapDataList<EmsOpitemDO> tableDatasource = new XapDataList<EmsOpitemDO>();
        private Dictionary<string, string> opexDictionary = new Dictionary<string, string>();

        public EmsOpsViewModel(Ent4BannerDTO ent) : base(ent) { }

        public override void Init()
        {
            base.Init();
            this.uiEmsDTO.EmsType = ciordems.d.EmsType.OPER;

        }

        public override bool IsEmpty()
        {
            return tableDatasource == null || tableDatasource.Count == 0 ||
                (tableDatasource.Count == 1 && String.IsNullOrEmpty(tableDatasource[0].Id_srv));
        }

        public override object GetTableDataSource()
        {
            return this.tableDatasource;
        }

        public override object GetFormDataSource()
        {
            return uiEmsDTO.Emsapop;
        }

        /// <summary>
        /// 新建医疗单
        /// </summary>
        /// <param name="emsCreatedParameter"></param>
        /// <param name="pos"></param>
        /// <returns></returns>
        public override bool LoadMedSrv(EmsCreatedParameter emsCreatedParameter, int pos) //EmsCreateParameter
        {
            
            base.LoadMedSrv(emsCreatedParameter, pos);
            MedSrvDO med = emsCreatedParameter.getMedSrvDO();
            this.uiEmsDTO.MedSrvDO = med;
            EmsRstDTO[] rsts = CreateRemote(med.Id_srv);
            EmsRstDTO rst = rsts[0];
                if (rst != null)
                {

                    uiEmsDTO.Emsapop.deSerializeJson((rst.Document[0] as EmsOpitemDO).serializeJson());
                    //String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(rst.DocumentString));
                    //uiEmsDTO.Emsapop.deSerializeJson(utf8Str);

                    if (rst.Extension != null && rst.Extension.Keys.Contains("MedSrvDO"))
                    {
                        this.uiEmsDTO.MedSrvDO = rst.Extension["MedSrvDO"] as MedSrvDO;
                        strSd_srvtp = this.uiEmsDTO.MedSrvDO.Sd_srvtp;
                    }
                    tableDatasource.Clear();
                    tableDatasource.Add(uiEmsDTO.Emsapop);
                    //this.LoadIndicatorData();
                    // 动态指标
                    if (null != uiEmsDTO.Emsapop.OpCheckIndicatorList)
                    {
                    uiEmsDTO.Emsapop.OpCheckIndicatorList.Cast<OrdApSugViewItemDO>().ToList().ForEach(item =>
                    {
                            uiEmsDTO.Emsapop.OpLabItem.Add(item);
                        });
                    }
                  
                }
            return true;
        }

        /// <summary>
        /// 编辑医疗单
        /// </summary>
        /// <param name="ciOrderDO"></param>
        public override void EditOrder(ciorder.d.CiOrderDO ciOrderDO)
        {
            
            EmsRstDTO[] rsts = LoadRemote(ciOrderDO.Id_or);
            EmsRstDTO rst = rsts[0];
            if (rst != null)
                {
                uiEmsDTO.Emsapop.deSerializeJson((rst.Document[0] as EmsOpitemDO).serializeJson());
                //String utf8Str = System.Text.Encoding.UTF8.GetString(Convert.FromBase64String(rst.DocumentString));
                //uiEmsDTO.Emsapop.deSerializeJson(utf8Str);


                    if (rst.Extension != null && rst.Extension.Keys.Contains("CiEmsDTO"))
                    {
                        this.ciEmsDTO = rst.Extension["CiEmsDTO"] as CiEmsDTO;
                    }
                    if (rst.Extension != null && rst.Extension.Keys.Contains("MedSrvDO"))
                    {
                        this.uiEmsDTO.MedSrvDO = rst.Extension["MedSrvDO"] as MedSrvDO;
                        strSd_srvtp = this.uiEmsDTO.MedSrvDO.Sd_srvtp;
                    }
                    if (rst.Extension != null && rst.Extension.Keys.Contains("MpDepFilter"))
                    {
                        idDepMps = rst.Extension["MpDepFilter"] as String;
                    }
                    // 附加手术项目
                    if (uiEmsDTO.Emsapop.OpAppendList != null)
                    {
                    uiEmsDTO.Emsapop.OpAppendList.Cast<EmsItemInOp>().ToList().ForEach(p =>
                    {
                            uiEmsDTO.Emsapop.OpAppendOpItem.Add(p);
                        });
                        
                    }
                    // 手术人员
                    if (uiEmsDTO.Emsapop.OpPersonList != null)
                    {
                    uiEmsDTO.Emsapop.OpPersonList.Cast<EmsItemInOp>().ToList().ForEach(p =>
                    {
                            uiEmsDTO.Emsapop.OpEmpItem.Add(p);
                        });

                    }
                    // 手术物品
                    if (uiEmsDTO.Emsapop.OpDrugList != null)
                    {
                    uiEmsDTO.Emsapop.OpDrugList.Cast<EmsItemInOp>().ToList().ForEach(p =>
                    {
                            uiEmsDTO.Emsapop.OpMmItem.Add(p);
                        });

                    }
                    // 手术动态检查指标
                    if (uiEmsDTO.Emsapop.OpCheckIndicatorList != null)
                    {
                    uiEmsDTO.Emsapop.OpCheckIndicatorList.Cast<OrdApSugViewItemDO>().ToList().ForEach(p =>
                    {
                            uiEmsDTO.Emsapop.OpLabItem.Add(p);
                        });

                    }
                    // 附加手术信息转换
                    this.OpAppendItem2OpexInfo();

                    tableDatasource.Add(uiEmsDTO.Emsapop);

                    this.ciEmsDTO.Status = DOStatus.UPDATED;
                    this.uiEmsDTO.Status = DOStatus.UPDATED;

                    // 处理分拣费用项目
                    HandleExpenseItems(ciEmsDTO);
                }

        }


        public override void EditEms(CiEmsDTO ems)
        {
            base.EditEms(ems);

            OrWfDeptInfoDTO wf = new GetDeptMpImp().GetDept_mp_ids(this.uiEmsDTO.PatInfo.Code_entp,
                this.uiEmsDTO.PatInfo.Id_entp,
                this.uiEmsDTO.MedSrvDO.Sd_srvtp,
                this.uiEmsDTO.MedSrvDO.Id_srvca,
                this.uiEmsDTO.MedSrvDO.Id_srv,
                this.uiEmsDTO.MedSrvDO.Id_route,
                "id_mm", this.uiEmsDTO.PatInfo.Id_dep_nur, this.uiEmsDTO.PatInfo.Id_dep_phy);
            idDepMps = wf.Id_mp_depts;

            orCiEmsToUiEms.EditApop(uiEmsDTO, ems);

            this.uiEmsDTO.Status = DOStatus.NEW;
            this.uiEmsDTO.Emsapop.Status = DOStatus.NEW;
            this.uiEmsDTO.Emsapop.Dt_creat = ems.Dt_begin;

            // 附加手术信息转换
            this.OpAppendItem2OpexInfo();

            tableDatasource.Add(uiEmsDTO.Emsapop);
        }

        public override int GetCountWithOutDelete()
        {
            XapDataList<EmsOpitemDO> itemList = this.GetTableDataSource() as XapDataList<EmsOpitemDO>;
            if (itemList.Count == 0)
                return 0;

            return itemList.ToList().Count(p => !p.IsDELETED);
        }

        public override void ClearTableDataSource()
        {
            // base.ClearTableDataSource();
            this.tableDatasource.Clear();
            //this.logicEx.Clear<EmsOpitemDO>(this.uiEmsDTO.Emsapop);
        }




        public override string OnRefFilterData(string filedName, StringObjectMap sbm)
        {
            
            if (filedName.Equals("Name_srv"))
            {
                if (!sbm.ContainsKey("code_entp"))
                {
                    sbm.Add("code_entp", "00");
                }
                if (!sbm.ContainsKey("id_pripat"))
                {
                    sbm.Add("id_pripat", this.ent4BannerDTO.Id_pripat);
                }
                CiEnContextDTO ciEnContextDTO = BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO;
                string id_hp = ciEnContextDTO.Id_hp_default;
                if (!string.IsNullOrEmpty(id_hp))
                {
                    if (!sbm.ContainsKey("id_hp"))
                    {
                        sbm.Add("id_hp", id_hp);
                    }
                }
                return string.Format(" Sd_srvtp ='{0}' and quan_med is not null", strSd_srvtp);
            }

            // 
            string whereString = base.OnRefFilterData(filedName, sbm);
            if (whereString != "") return whereString;
            if (filedName.Equals("Name_mp_dep") && !string.IsNullOrWhiteSpace(idDepMps))
            {
                whereString = string.Format("id_dep in ({0})", idDepMps);
            }
            //其他人员-角色
            else if (filedName.Equals("Name_role"))
            {
                string[] whereparts = new[] { CiDictCodeConst.SD_OP_ROLE_ZDYS, CiDictCodeConst.SD_OP_ROLE_DYZS };
                whereString = string.Format("bd_udidoc.code not in ('{0}')", string.Join("','", whereparts));
            }

            //附加手术-手术名称
            else if (filedName.Equals("Name_opex_srvs"))
            {

                XapDataList<EmsItemInOp> MMlist = this.uiEmsDTO.Emsapop.OpAppendOpItem;
                string ids = "";
                foreach (EmsItemInOp item in MMlist)
                {
                    if (item.Id_srv != null)
                    {
                        ids += "'" + item.Id_srv + "',";
                    }
                }
                if (ids.Length != 0)
                {
                    ids = ids.Substring(0, ids.Length - 1);
                    whereString = string.Format("sd_srvtp like '{0}%' and id_srv <> '{1}' and fg_active='{2}' and id_srv not in ({3})", "0401", this.uiEmsDTO.MedSrvDO.Id_srv, "Y", ids);
                }
                else
                {
                    whereString = string.Format("sd_srvtp like '{0}%' and id_srv <> '{1}' and fg_active='{2}'", "0401", this.uiEmsDTO.MedSrvDO.Id_srv, "Y");
                }

            }
            else if (filedName.Equals("Name_di"))
            {
                //whereString = " id_ent ='" + this.uiEmsDTO.PatInfo.Id_ent + "'";
            }
            else if (filedName.Equals("Name_emp_operator") || filedName.Equals("Name_emp_help1") || filedName.Equals("Name_emp_op"))
            {
                string ids = "";
                List<EmsItemInOp> itemList = this.uiEmsDTO.Emsapop.OpEmpItem.ToList<EmsItemInOp>();
                if (!string.IsNullOrEmpty(this.uiEmsDTO.Emsapop.Id_emp_operator))
                {
                    ids += "'" + this.uiEmsDTO.Emsapop.Id_emp_operator + "',";
                }
                if (!string.IsNullOrEmpty(this.uiEmsDTO.Emsapop.Id_emp_help1))
                {
                    ids += "'" + this.uiEmsDTO.Emsapop.Id_emp_help1+"',";
                }
                whereString = string.Format(" bd_psndoc.activestate = '2' and bd_psndoc.id_group = '{0}' and bd_psndoc.sd_empwktp = '{1}'", this.GetContext().Group.Id_grp, BdResDictCodeConst.SD_EMPWKTP_DOC);
                if (ids.Length > 0)
                {
                    ids = ids.Substring(0, ids.Length - 1);
                    whereString += string.Format(" and bd_psndoc.id_psndoc not in ({0})", ids);
                }
            }

            return whereString;
        }

        public override void OnDataChanged(Object ds, string fieldName, string value)
        {
            base.OnDataChanged(ds, fieldName, value);

            if (fieldName.Equals("customercolumn_optime_limit"))
            {


                if (value == "1")
                {
                    tableDatasource[0].Fg_xq_sug = true;
                    tableDatasource[0].Fg_er_sug = false;
                    tableDatasource[0].Fg_zq_sug = false;
                    //opItemDO.Fg_xq_sug = "";// "限期";
                }
                else if (value == "2")
                {
                    tableDatasource[0].Fg_xq_sug = false;
                    tableDatasource[0].Fg_er_sug = true;
                    tableDatasource[0].Fg_zq_sug = false;
                    //opItemDO.Fg_er_sug = null;// "急症";
                }
                else
                {
                    tableDatasource[0].Fg_xq_sug = false;
                    tableDatasource[0].Fg_er_sug = false;
                    tableDatasource[0].Fg_zq_sug = true;
                    //opItemDO.Fg_zq_sug = true;

                }
            }
        }

        protected override void OnBeforeCallServiceSave(CiEmsDTO ems)
        {
            base.OnBeforeCallServiceSave(ems);

            ems.Fg_mp_in = true;
            ems.Times_mp_in = ems.Times_cur;

            //ems.Dt_begin = this.uiEmsDTO.Emsapop.Dt_plan;
            //ems.Dt_end = this.uiEmsDTO.Emsapop.Dt_plan;

            if (ems.Emssrvs != null)
                ems.Emssrvs.Cast<CiEmsSrvDTO>().Where(srv => srv.Eu_sourcemd == (int)ciorder.d.OrSrvSourceFromEnum.PHYSIAN).ToList().ForEach(srv =>
                {
                srv.Quan_total_medu = ems.Times_mp_in * srv.Quan_med;
            });

        }

        /// <summary>
        /// 保存
        /// </summary>
        /// <returns></returns>
        public override ciorder.d.CiOrderDO Save2Order()
        {
            this.OpexInfo2OpAppendItem();
            return base.Save2Order();
        }

        public CiOrderDO New_Save()
        {
            ICiEmsMainService emsMainService = XapServiceMgr.find<ICiEmsMainService>();
            if (null != emsMainService)
            {
                var emsSave = new EmsSaveDTO();
                this.uiEmsDTO.Emsapop.Id_srvof = emsMgrDTO.Id_ems;
                this.OpexInfo2OpAppendItem();
                //emsSave.Document = new FArrayList();
                //emsSave.Document.Add(this.uiEmsDTO.Emsapop);
                //emsSave.EnContext = CiEnContextUtil.GetCiEnContext(this.GetEnt4BannerDTO(), EmsAppModeEnum.SVEMSAPPMODE, OrSourceFromEnum.IIHSRVREF, this.GetContext());
                //emsSave.EmsDriver = ((int)this.uiEmsDTO.EmsType).ToString();
                //EmsRstDTO rst = emsMainService.save(emsSave);
                EmsRstDTO rst = SaveRemote(this.uiEmsDTO.Emsapop);
                if (rst != null)
                {

                    return (rst.Document[0] as CiorderAggDO).getParentDO();

                }
            }

            return null;
        }


        public override CiEmsDTO Save2CiEmsDTO(bool forceUpdate)
        {
            this.OpexInfo2OpAppendItem();
            ciEmsDTO.Id_srv = uiEmsDTO.Emsapop.Id_srv;
            return base.Save2CiEmsDTO(forceUpdate);
        }
        /// <summary>
        /// 加载动态项目数据
        /// </summary>
        public void LoadIndicatorData()
        {
            if (this.uiEmsDTO == null || uiEmsDTO.Emsapop == null || uiEmsDTO.Emsapop.OpLabItem == null)
                return;

            //  uiEmsDTO.Emsapop.OpLabItem.Clear(); // -- 切换服务时候，动态指标项，已经存在的要设置为deleted
            if (uiEmsDTO.IsNEW)
            {
                uiEmsDTO.Emsapop.OpLabItem.Clear();
            }
            else
            {
                uiEmsDTO.Emsapop.OpLabItem.ToList().ForEach(p => { p.Status = DOStatus.DELETED; });
            }

            IBdSrvQryService qryservice = XapServiceMgr.find<IBdSrvQryService>();

            IEmsregistryMDOCrudService MDORService = XapServiceMgr.find<IEmsregistryMDOCrudService>();

            EmsDO emsDo = MDORService.findById(this.ciEmsDTO.Id_srvof);

            if (emsDo == null) return;

            bool? fg_dyncitm_en = emsDo.Fg_dyncitm_crossentp;

            int? eu_dyncitmunit = emsDo.Eu_dyncitmunit;//指标周期类型

            int? dyncitmunitct = emsDo.Cnt_dyncitmunit;

            string id_ent = uiEmsDTO.PatInfo.Id_ent;

            string id_pat = uiEmsDTO.PatInfo.Id_pat;

            EmsDynamicParamDTO paramDto = new EmsDynamicParamDTO();
            paramDto.Id_ems = this.ciEmsDTO.Id_srvof;
            paramDto.Fg_dyncitm_en = fg_dyncitm_en;
            paramDto.Eu_dyncitmunit = eu_dyncitmunit;
            paramDto.Id_ent = id_ent;
            paramDto.Id_pat = id_pat;
            paramDto.Dyncitmunitct = dyncitmunitct;

            EmsDynamicIndexDTO[] dtos = qryservice.getEmsDynamicIndexInfos(paramDto);
            //Datatype为编辑类型，0：输入框，其他为：下拉框
            foreach (EmsDynamicIndexDTO dto in dtos)
            {
                uiEmsDTO.Emsapop.OpLabItem.Add(new OrdApSugViewItemDO()
                {
                    Val_rstrptla = dto.Indexval == null ? "" : dto.Indexval,
                    Val_restrptlab = dto.Enumvalues == null ? "" : "|" + dto.Enumvalues.Replace(',', '|'),
                    Sd_restrptlabtp = dto.Datatype,
                    Name_srv = dto.Showname,
                    Name_unit = dto.Unitname,
                    Id_unit = dto.Id_unit,
                    Id_srv = dto.Id_srv
                });
            }
        }

        /// <summary>
        /// 读取附加术信息
        /// </summary>
        private void OpexInfo2OpAppendItem()
        {
            // {{ 精简代码逻辑 -- 2016-11-30 -- wangqzh
            EmsOpitemDO opItemDO = uiEmsDTO.Emsapop;

            if (opItemDO.Code_opex_srvs != null)
            {
                string[] code_srvs = opItemDO.Code_opex_srvs.Split(',');
                string[] id_srvs = opItemDO.Id_opex_srvs.Split(',');
                string[] name_srvs = opItemDO.Name_opex_srvs.Split(',');

                // 0.设置附加时候的初始状态，如果含有附加手术，保存前先设置deleted逻辑删除状态
                opItemDO.OpAppendOpItem.ToList().ForEach(p => { p.Status = DOStatus.DELETED; });

                // 1. 循环参照选出的附加手术服务id
                for (int index = 0; index < code_srvs.Length; ++index)
                {
                    // 2. 找到附加手术参照列表中的一项服务与附加手术列表中的相同项目，如果找到，则设置状态为 updated 状态
                    EmsItemInOp iteminop = opItemDO.OpAppendOpItem.FirstOrDefault(p => p.Id_srv.Equals(id_srvs[index]));
                    if (null != iteminop)
                    {
                        iteminop.Status = DOStatus.UPDATED;
                        // iteminop.Id_orsrv = ciEmsDTO.Id_or;
                    }
                    // 3. 没有找到，则认为是新增
                    else
                    {
                        iteminop = new EmsItemInOp() { Code_srv = code_srvs[index], Id_srv = id_srvs[index], Name_srv = name_srvs[index], Status = DOStatus.NEW };
                        opItemDO.OpAppendOpItem.Add(iteminop);
                    }
                }
            }
            else
            {
                opItemDO.OpAppendOpItem.ToList().ForEach(p => { p.Status = DOStatus.DELETED; });
            }
            // }}
        }

        private void OpAppendItem2OpexInfo()
        {
            uiEmsDTO.Emsapop.Code_opex_srvs = "";
            uiEmsDTO.Emsapop.Id_opex_srvs = "";
            uiEmsDTO.Emsapop.Name_opex_srvs = "";
            List<String> tmpFilterSameItem = new List<string>();
            foreach (EmsItemInOp item in uiEmsDTO.Emsapop.OpAppendOpItem)
            {
                if (item.Id_srv != null && item.Code_srv != null && item.Name_srv != null)
                {
                    if (tmpFilterSameItem.Contains(item.Id_srv))
                        continue;
                    tmpFilterSameItem.Add(item.Id_srv);
                    uiEmsDTO.Emsapop.Code_opex_srvs += item.Code_srv + ",";
                    uiEmsDTO.Emsapop.Id_opex_srvs += item.Id_srv + ",";
                    uiEmsDTO.Emsapop.Name_opex_srvs += item.Name_srv + ",";
                }
            }
            if (uiEmsDTO.Emsapop.Code_opex_srvs.Length > 0)
                uiEmsDTO.Emsapop.Code_opex_srvs = uiEmsDTO.Emsapop.Code_opex_srvs.Remove(uiEmsDTO.Emsapop.Code_opex_srvs.Length - 1);
            if (uiEmsDTO.Emsapop.Id_opex_srvs.Length > 0)
                uiEmsDTO.Emsapop.Id_opex_srvs = uiEmsDTO.Emsapop.Id_opex_srvs.Remove(uiEmsDTO.Emsapop.Id_opex_srvs.Length - 1);
            if (uiEmsDTO.Emsapop.Name_opex_srvs.Length > 0)
                uiEmsDTO.Emsapop.Name_opex_srvs = uiEmsDTO.Emsapop.Name_opex_srvs.Remove(uiEmsDTO.Emsapop.Name_opex_srvs.Length - 1);
        }

        public override string[] GetReadonlyFields()
        {
            return new string[] { };// "Price", "Totalprice", "Name_srv"
        }

        protected override void HandleTotlePriceInfo(EmsOrDrug drug)
        {
            if (drug.Quan_cur == null || drug.Quan_cur == 0)
            {
                drug.Quan_cur = this.logicEx.getNotDrugTotal(drug.Quan_med.ToDouble(), drug.Id_freq, drug.Freqct.Value);
            }

            if (drug.Price != null && drug.Quan_cur != null)
            {
                drug.Totalprice = drug.Price * drug.Quan_cur;
            }
        }

    }
}

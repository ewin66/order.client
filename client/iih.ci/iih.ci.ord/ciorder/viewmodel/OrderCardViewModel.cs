using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.medsrv.i;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.i;
using iih.ci.ord_stub.service.i;
using xap.mw.serviceframework;
using xap.mw.core.data;
using xap.rui.appfw;
using iih.ci.ord.dto.d;
using iih.ci.ord.ciorder.i;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.emsdi.d;
using iih.ci.ord.ciorder.utils;
using iih.bl.hp.bdhpindicationdto.d;

namespace iih.ci.ord.ciorder.viewmodel {

    /// <summary>
    /// 医嘱单获取数据DTO
    /// </summary>
    public class OrderCardViewModel {

        #region 成员变量
        private ICiOrdCrudService crudService;
        private ICiOrdQryService qryService;
        private IMedsrvMDOCrudService medsrvMdoCrudService;
        private ICiorderMDOCrudService mdService;
        public EmsUIDTO headDo { get; set; }
        Random ran = new Random();
        #endregion

        #region 构造
        public OrderCardViewModel() {
            this.crudService = XapServiceMgr.find<ICiOrdCrudService>();
            this.qryService = XapServiceMgr.find<ICiOrdQryService>();
            this.medsrvMdoCrudService = XapServiceMgr.find<IMedsrvMDOCrudService>();
            mdService = XapServiceMgr.find<ICiorderMDOCrudService>();
        } 
        #endregion
      
        /// <summary>
        /// Gets the or drugs.
        /// </summary>
        /// <param name="id">The 服务项目id.</param>
        /// <param name="type">The type.</param>
        /// <returns></returns>
        public XapDataList<EmsOrDrug> GetOrDrugs(string id_srv, string id_hp, string code_entp, CiEnContextDTO contextdto = null)
        {
            XapDataList<EmsOrDrug> list = new XapDataList<EmsOrDrug>();
            this.headDo = this.crudService.findById(id_srv, id_hp, code_entp,contextdto);

            foreach (EmsOrDrug item in headDo.Emsdrugitems) {
                if (item.BdHpIndicationDTO != null && item.BdHpIndicationDTO.Count>0)
                {
                    item.Fg_selfpay = HpJudgeUtil.getInstance().isSelfPay(item.BdHpIndicationDTO[0] as BdHpIndicationDTO);
                    item.Fg_hpindicjudged = HpJudgeUtil.getInstance().getFg_hpindicjudged(item.BdHpIndicationDTO[0] as BdHpIndicationDTO);
                }
                if (contextdto.Fg_hpfundpay == null || !(bool)contextdto.Fg_hpfundpay || (contextdto.Eu_hpbeyond != null && !contextdto.Eu_hpbeyond.Equals(HpBeyondEnum.HPDIAG)))
                {
                    item.Fg_treat = false;
                    item.Fg_selfpay = true;
                }
                //单次剂量录入
                item.Quan_medu_virtual = item.Quan_med;
                item.Name_unit_medu_virtual = item.Name_unit_med;
                list.Add(item);
                //xap.cli.context.UserManager.getInstance().CurrentDept.
                //list.Add(new EmsOrDrug
                //{ 
                //    //Status=DOStatus.UPDATED,//初始化状态
                //    Id_srv=id_srv,
                //    Name_srv = item.Name_srv,//通用物品(即服务项目名称)
                //    Name_mm = item.Name_mm,//物品
                //    Id_mm = item.Id_mm,
                //    Spec_mm = item.Spec_mm,//规格
                //    Quan_med = item.Quan_med,//剂量
                //    Name_unit_med ="mg",// item.Name_unit_med,//剂量单位
                //    Id_unit_med = item.Id_unit_med,
                //    Quan_base = item.Quan_base,//单次数量
                //    Id_unit_base = item.Id_unit_base,//数量单位
                //    Name_unit_base = item.Name_unit_base,
                //    Name_boildes=(string.IsNullOrEmpty(item.Name_boildes)? "文火3刻钟":item.Name_boildes),
                //    Id_boildes=item.Id_boildes,
                //    Vender = item.Name_sup, //厂商
                //    Price = item.Price,//参考价格
                //    Des = item.Des_mm,  //描述
                //    Limit = item.Limit,//限制条件//TODO:临时数据
                //    Name_heath = item.Name_heath,//医保类型
                //    Fact_count =0,// ran.Next(2, 30),//现有存量
                //    Fg_skintest=false,

                //    Sortno=headDo.Emsdrugitems.IndexOf(item)+1



                //});
            }
            return list;

        }

        /// <summary>
        /// 检查申请单号
        /// </summary>
        /// <returns></returns>
        public string getOrdApObsNoapplyform() {
            return this.qryService.getOrdApObsNoapplyform();
        }

        /// <summary>
        /// 检验申请单号
        /// </summary>
        /// <returns></returns>
        public string getOrdApLabNoapplyform() {
            return this.qryService.getOrdApLabNoapplyform();
        }

        public MedSrvDO getMedSrvDO(string id_srv) {
            return this.medsrvMdoCrudService.findById(id_srv);
        }

        public CiordubDTO[] getOrderUBDto(string ident) {
            return this.qryService.getOrderUBDtoList(ident);
        }

        //根据就诊判断当前就诊下是否存在出院医嘱
        public bool isExitOutOrder(string id_en, string sd_srvtp) {
            CiOrderDO[] ciorderDo = mdService.find(string.Format("a0.id_en='{0}' and a0.sd_srvtp='{1}'", id_en, sd_srvtp), "", false);
            if (ciorderDo != null && ciorderDo.Length > 0) {
                return true;
            }
            else {
                return false;
            }
        }

        /// <summary>
        /// 皮试逻辑判断
        /// </summary>
        /// <param name="param"></param>
        /// <returns></returns>
        public SkinTestRstDTO skinTestLogic(SkinTestParamDTO param) {
            return qryService.skinTestLogicMainBP(param);
        }
        /// <summary>
        /// 医疗单初始化
        /// </summary>
        /// <param name="envinfo"></param>
        /// <param name="param"></param>
        /// <returns></returns>
        public CiEmsDTO getEmsDiDTO(UIEmsEnvDTO envinfo, BdSrv4EmsDiDTO param)
        {
            return qryService.getEmsDiDTO(envinfo, param);
        }
        /// <summary>
        /// 本次就诊的诊断名称和编码的拼接的字符串
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        public String[] getDiagArray(String id_ent)
        {
           return this.qryService.getDiagArray(id_ent);
        }

        #region 无用的
        //
        //public EmsUIDTO refeshData(string id, EmsType type)
        //{
        //    if (crudService == null)
        //    {
        //        this.crudService = XapServiceMgr.find<ICiOrdCrudService>();
        //    }
        //    this.headDo = this.crudService.findById(id, ((int)type).ToString());
        //    return headDo;
        //} 
        #endregion

    }
}

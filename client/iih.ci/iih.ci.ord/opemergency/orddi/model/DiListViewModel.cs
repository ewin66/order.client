using System;
using System.Collections.Generic;
using System.Linq;
using iih.bd.bc.udi;
using iih.bd.srv.diagdef.d;
using iih.ci.diag.cidiag.d;
using iih.ci.diag.cidiag.i;
using iih.ci.diag.dto.d;
using iih.ci.diag.dto.didefdto.d;
using iih.ci.diag_stub.i;
using iih.en.pv.dto.d;
using iih.en.pv.pativisit.d;
using iih.hp.cp.enterpathapi.d;
using iih.hp.cp.enterpathapi.i;
using xap.cli.context;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.rui.appfw.collections;
using xap.sys.xbd.udi.d;
using xap.rui.control.extentions;
using xap.rui.appfw.attributes;
using iih.bd.bc.cdsys.d;
using iih.bd.bc.cdsys.i;
using iih.bl.hp.dto.d;
using iih.bl.hp.i;
using iih.ci.diag.dto.judgedideletedto.d;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.common.log;
using iih.ci.ord.ems.d;
using xap.mw.serviceframework.ex;
using iih.ci.ord.common.utils;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.i;
using xap.mw.core.data;

namespace iih.ci.ord.opemergency.orddi.model
{
    /// <summary>
    /// 诊断管理列表 数据模型
    /// </summary>
    public class DiListViewModel
    {
        #region 常量定义
        const String mDiPrefix = "★";
        const String sDiPrefix = "?";
        const int nDefaultRowCount = 4;
        #endregion

        #region 私有变量
        // 医嘱查询服务
        private ICiOrdQryService ciOrdQryService;
        // 诊断查询服务
        private ICidiagQryService qrySerice;
        private ICidiagMaintainService mainService;
        // 诊断信息 Agg 查询服务，支持保存删除等操作 
        private ICidiagCrudService cidiagCrud;
        private ICdsysCrudService icdsysCrud;

        /// <summary>
        /// 检查诊断依赖
        /// </summary>
        private readonly IBlHpOutQryService blHpOutQryService;
        #endregion

        #region 模型对象

        //西医诊断
        public XapDataList<Cidixy> xyCidiList { get; set; }
        //中医诊断
        public XapDataList<Cididtozy> zyCidiList { get; set; }
        //诊断集合
        public List<string> AllList { get; set; }
        #endregion

        #region 公有属性
        public string SysParam { get { return GetSysParam(); } }
        /// <summary>
        /// 是否显示西医诊断页签
        /// </summary>
        /// <returns></returns>
        public bool IsShowXYPage() { return GetSysParam().Contains("11"); }
        /// <summary>
        /// 是否显示中医诊断页签
        /// </summary>
        /// <returns></returns>
        public bool IsShowZYPage() { return GetSysParam().Contains("12"); }
        /// <summary>
        /// 是否显示蒙医诊断页签
        /// </summary>
        /// <returns></returns>
        public bool IsShowMYPage() { return GetSysParam().Contains("13"); }

        public CiDiagDO HeadDiDiagDO { get; set; }

        public DIDTO[] SaveResult { set; get; }
        #endregion

        #region 构造方法
        public DiListViewModel()
        {
            qrySerice = XapServiceMgr.find<ICidiagQryService>();
            mainService = XapServiceMgr.find<ICidiagMaintainService>();
            cidiagCrud = XapServiceMgr.find<ICidiagCrudService>();
            icdsysCrud = XapServiceMgr.find<ICdsysCrudService>();
            ciOrdQryService = XapServiceMgr.find<ICiOrdQryService>();
            blHpOutQryService = XapServiceMgr.find<IBlHpOutQryService>();
            this.xyCidiList = new XapDataList<Cidixy>();
            this.zyCidiList = new XapDataList<Cididtozy>();
        }
        #endregion

        #region 内部私有方法

        /// <summary>
        /// 中西医诊断配置参数,页签显示 中医 西医
        /// </summary>
        /// <returns></returns>
        private string GetSysParam()
        {
            return this.qrySerice.getParamType();
        }

        /// <summary>
        /// 初始化中心诊断列表数据源
        /// </summary>
        /// <param name="cidiagAggDO"></param>
        private void initCiDiDtoModel(CidiagAggDO cidiagAggDO)
        {

            if (cidiagAggDO != null && cidiagAggDO.getCiDiagItemDO() != null)
            {
                HeadDiDiagDO = cidiagAggDO.getParentDO();

                List<Cidixy> listCidixy = new List<Cidixy>();
                List<Cididtozy> listCidizy = new List<Cididtozy>();
                AllList =  new List<string>();
                foreach (CiDiagItemDO item in cidiagAggDO.getCiDiagItemDO())
                {
                    AllList.Add(item.Didef_code);
                    if (item.Id_disys == CiDictCodeConst.ID_CI_DISYS_XYZDTX) //判断  西医
                    {
                        fillCidixyList(listCidixy, cidiagAggDO, item);
                    }
                    else if (item.Id_disys == CiDictCodeConst.ID_CI_DISYS_ZYZDTX) //判断中医 
                    {
                        fillCidizyList(listCidizy, cidiagAggDO, item);
                    }
                    else
                    {
                        //todo 暂时  其它体系
                    }

                }

                listCidixy.ForEach(xy=> { this.xyCidiList.Add(xy); });
                listCidizy.ForEach(zy => { this.zyCidiList.Add(zy); });

                // 中医和西医诊断条目默认4条
                int xyCidiListCount = this.xyCidiList.Count;
                for (int index = 0; index < nDefaultRowCount - xyCidiListCount; ++index)
                {
                    this.xyCidiList.Add(new Cidixy());
                }
                int zyCididtozyListCount = this.zyCidiList.Count;
                for (int index = 0; index < nDefaultRowCount - zyCididtozyListCount; ++index)
                {
                    this.zyCidiList.Add(new Cididtozy());
                }
            }
        }

        /// <summary>
        /// 用CidiagAggDO 对象数据填充西医诊断明细数据列表
        /// </summary>
        /// <param name="cidiListxy"></param>
        /// <param name="ciagg"></param>
        /// <param name="item"></param>
        private void fillCidixyList(List<Cidixy> cidiListxy, CidiagAggDO cidiagAggDO, CiDiagItemDO item)
        {

            Cidixy xy = new Cidixy();
            //xy.Id_diitm = item.Id_diitm;
            xy.Id_didef = item.Id_didef;
            xy.Id_didef_code = item.Didef_code;
            xy.Id_didef_name = item.Didef_name;
            xy.Id_ditp = cidiagAggDO.getParentDO().Id_ditp;
            xy.Id_ditp_code = cidiagAggDO.getParentDO().Code_ditp;
            xy.Id_ditp_name = cidiagAggDO.getParentDO().Name_ditp;
            xy.Id_disys = item.Id_disys;
            xy.Id_disys_name = item.Id_disys_name;
            xy.Di_standard = item.Di_standard;
            xy.Di_standard_code = item.Di_standard_code;
            xy.Di_standard_name = item.Di_standard_name;
            xy.Id_disys_name = item.Id_disys_name;
            xy.Fg_majdi = item.Fg_majdi;
            xy.Fg_suspdi = item.Fg_suspdi;
            xy.Supplement = item.Supplement;
            xy.Sd_disys = item.Sd_disys;
            xy.Fg_ur = item.Fg_ur;
            xy.Fg_chronic = item.Fg_chronic;
            xy.Fg_special = item.Fg_special;
            xy.Id_infectiontp = item.Id_infectiontp;
            xy.Sd_infectiontp = item.Sd_infectiontp;
            xy.Fg_hpbeyond = (item.Eu_hpbeyond == "1") ? true : false;
            cidiListxy.Add(xy);

        }

        /// <summary>
        /// 用CidiagAggDO 对象数据填充中医诊断明细数据列表
        /// </summary>
        /// <param name="cidiListxy"></param>
        /// <param name="ciagg"></param>
        /// <param name="item"></param>
        private void fillCidizyList(List<Cididtozy> cidiListzy, CidiagAggDO cidiagAggDO, CiDiagItemDO item)
        {
            Cididtozy xy = new Cididtozy();

            //xy.Id_diitm = item.Id_diitm;
            xy.Di_disease = item.Id_didef;
            xy.Id_disease_code = item.Didef_code;
            xy.Id_disease_name = item.Didef_name;
            xy.Id_ditp = cidiagAggDO.getParentDO().Id_ditp;
            xy.Sd_ditp = cidiagAggDO.getParentDO().Sd_ditp;
            xy.Id_syndrome = item.Id_didef_syn;
            xy.Id_syndrome_code = item.Id_didef_syn_code;
            xy.Id_syndrome_name = item.Id_didef_syn_name;
            xy.Id_ditp_name = cidiagAggDO.getParentDO().Name_ditp;
            xy.Id_disys = item.Id_disys;
            xy.Id_disys_name = item.Id_disys_name;
            xy.Di_standard = item.Di_standard;
            xy.Di_standard_code = item.Di_standard_code;
            xy.Di_standard_name = item.Di_standard_name;
            xy.Id_disys_name = item.Id_disys_name;
            xy.Fg_majdi = item.Fg_majdi;
            xy.Fg_suspdi = item.Fg_suspdi;
            xy.Sd_disys = item.Sd_disys;
            xy.Fg_ur = item.Fg_ur;
            xy.Fg_chronic = item.Fg_chronic;
            xy.Fg_special = item.Fg_special;
            xy.Id_infectiontp = item.Id_infectiontp;
            xy.Sd_infectiontp = item.Sd_infectiontp;
            xy.Fg_hpbeyond = (item.Eu_hpbeyond == "1") ? true : false;
            cidiListzy.Add(xy);
        }

        /// <summary>
        /// 西医 集合
        /// </summary>
        /// <param name="type"></param>
        /// <param name="patientsDTO"></param>
        /// <param name="listDto"></param>
        /// <param name="list"></param>
        private string collectDidtoListFromxyList(string ditp_code, Ent4BannerDTO patDTO, List<DIDTO> didtoList, XapDataList<Cidixy> cidixyList, string xy)
        {
            string str = xy;
            int i = 1;
            foreach (Cidixy item in cidixyList)
            {
                // 空模型对象
                if (this.IsEmpty(item))
                    continue;

                DIDTO didto = new DIDTO();

                FillDiInfo(didto, patDTO);
                FillDiItemInfo(didto, item, ditp_code);
                str += ToDescription(item, i);
                didtoList.Add(didto);
                i++;
            }
            return str;
        }

        /// <summary>
        /// DIDTO
        /// </summary>
        /// <param name="didto"></param>
        /// <param name="patientsDTO"></param>
        /// <param name="isSigned"></param>
        private void FillDiInfo(DIDTO didto, Ent4BannerDTO patientsDTO, bool isSigned = true)
        {
            didto.Id_di = null;
            didto.Id_pat = patientsDTO.Id_pat;
            didto.Id_en = patientsDTO.Id_ent;
            didto.Id_entp = patientsDTO.Id_entp;
            didto.Code_entp = patientsDTO.Code_entp;

            didto.Id_dep_create = UserManager.getInstance().CurrentDept.Id_dep;
            didto.Id_dep_create_name = UserManager.getInstance().CurrentDept.Name;
            didto.Id_emp_create = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;
            didto.Id_emp_create_name = UserManager.getInstance().CurrentPsnInfo.Name;
            didto.Dt_create = CommonExtentions.NowTime(this);
            didto.Fg_sign = isSigned;
            if (isSigned)
            {
                didto.Id_dep_sign = UserManager.getInstance().CurrentDept.Id_dep;
                didto.Id_emp_sign = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;
                didto.Dt_sign = CommonExtentions.NowTime(this);
            }
        }
		
        /// <summary>
        /// 
        /// </summary>
        /// <param name="didto"></param>
        /// <param name="item"></param>
        /// <param name="ditp_code"></param>
        private void FillDiItemInfo(DIDTO didto, Cidixy item, string ditp_code)
        {
            didto.Id_diitm = null;
            didto.Id_didef = item.Id_didef;
            didto.Didef_code = item.Id_didef_code;
            didto.Didef_name = item.Id_didef_name;
            didto.Id_ditp = this.HeadDiDiagDO.Id_ditp;
            didto.Sd_ditp = this.HeadDiDiagDO.Sd_ditp;
            didto.Id_ditp_name = item.Id_ditp_name;
            didto.Supplement = item.Supplement;
            didto.Id_disys = item.Id_disys;
            didto.Sd_disys = item.Sd_disys;
            didto.Id_disys_name = item.Id_disys_name;
            didto.Di_standard = item.Di_standard;
            didto.Di_standard_name = item.Di_standard_name;
            didto.Fg_suspdi = item.Fg_suspdi;
            didto.Fg_ur = item.Fg_ur;
            didto.Id_infectiontp = item.Id_infectiontp;
            didto.Sd_infectiontp = item.Sd_infectiontp;
            didto.Fg_majdi = (ditp_code == CiDictCodeConst.SD_SUPPLY ? false : item.Fg_majdi);

            didto.Dt_di = CommonExtentions.NowTime(this);
            didto.Supplement = item.Supplement;
            didto.Fg_chronic = item.Fg_chronic;
            didto.Fg_special = item.Fg_special;

            didto.Id_disys_name = "西医诊断";
        }

        private String ToDescription(Cidixy item, int index)
        {
            String str = "   " + index + "," + item.Id_didef_name;
            if (item.Supplement != null && item.Supplement != "")
            {
                str += "——" + item.Supplement + "";
            }
            if (str != "" && item.Fg_suspdi != null && (bool)item.Fg_suspdi)
            {
                str += " ?  \n";
            }
            else
            {
                str += "\n";
            }
            return str;
        }
        
        /// <summary>
        /// 中医 集合
        /// </summary>
        /// <param name="type"></param>
        /// <param name="patientsDTO"></param>
        /// <param name="listDto"></param>
        /// <param name="list"></param>
        private string collectDidtoListFromzyList(string ditp_code, Ent4BannerDTO patientsDTO, List<DIDTO> lstDIDTOs, XapDataList<Cididtozy> lstCididtozy, string zy)
        {
            string str = zy;

            foreach (Cididtozy item in lstCididtozy)
            {
                if (IsEmpty(item))
                    continue;
                // 判断是 新增 还是修改
                DIDTO didto = new DIDTO();
                didto.Id_diitm = null;
                didto.Id_di = null;

                didto.Id_didef = item.Di_disease;
                didto.Didef_code = item.Id_disease_code;
                didto.Didef_name = item.Id_disease_name;

                didto.Id_didef_syn = item.Id_syndrome;
                didto.Id_didef_syn_code = item.Id_syndrome_code;
                didto.Id_didef_syn_name = item.Id_syndrome_name;
                didto.Di_disease = item.Di_disease;
                didto.Id_disease_code = item.Id_disease_code;
                didto.Id_disease_name = item.Id_disease_name;
                didto.Id_disys = item.Id_disys;
                didto.Sd_disys = item.Sd_disys;
                didto.Id_disys_name = item.Id_disys_name;
                didto.Di_standard = item.Di_standard;
                didto.Di_standard_name = item.Di_standard_name;
                didto.Fg_suspdi = item.Fg_suspdi;
                didto.Fg_ur = item.Fg_ur;
                didto.Id_infectiontp = item.Id_infectiontp;
                didto.Sd_infectiontp = item.Sd_infectiontp;
                didto.Fg_chronic = item.Fg_chronic;
                didto.Fg_special = item.Fg_special;
                didto.Fg_majdi = (ditp_code == CiDictCodeConst.SD_SUPPLY ? false : item.Fg_majdi);

                didto.Dt_di = CommonExtentions.NowTime(this); //this.ciagg.getParentDO().Dt_di;

                didto.Id_disys_name = zy;//item.Id_disys_name;

                didto.Id_ditp = this.HeadDiDiagDO.Id_ditp;
                didto.Sd_ditp = this.HeadDiDiagDO.Sd_ditp;
                didto.Id_ditp_name = this.HeadDiDiagDO.Name_ditp;

                didto.Id_en = patientsDTO.Id_ent;
                didto.Id_pat = patientsDTO.Id_pat;

                didto.Id_dep_create = UserManager.getInstance().CurrentDept.Id_dep;
                didto.Id_dep_create_name = UserManager.getInstance().CurrentDept.Name;
                didto.Id_emp_create = UserManager.getInstance().CurrentUser.Id_user;
                didto.Id_emp_create_name = UserManager.getInstance().CurrentUser.Name;
                
                didto.Fg_sign = true;
                didto.Id_dep_sign = UserManager.getInstance().CurrentDept.Id_dep;
                didto.Id_emp_sign = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;
                didto.Dt_sign = CommonExtentions.NowTime(this);

                str += ((item.Fg_suspdi != null && (bool)item.Fg_suspdi) ? " ?  \n" : "   \n");

                lstDIDTOs.Add(didto);
            }
            return str;
        }

        #endregion

        #region 公有接口方法

        public void Reload(String id_en)
        {
            HeadDiDiagDO = null;
            this.xyCidiList.Clear();
            this.zyCidiList.Clear();

            if (id_en != null)
            {
                string sql = string.Format("a0.id_en='{0}'", id_en);
                CidiagAggDO[] szCidiagAggDO = cidiagCrud.find(sql, "a0.createdtime ", false);

                if (szCidiagAggDO.Length > 0)
                {
                    CidiagAggDO diAggDo = szCidiagAggDO.LastOrDefault();
                    
                    initCiDiDtoModel(diAggDo);
                }
            }
            else
            {
                CiLog4OpStation.WriteLog("错误：在加载诊断数据时候，患者就诊id为空");
            }

            if (this.HeadDiDiagDO == null) {

                HeadDiDiagDO = new CiDiagDO();
                HeadDiDiagDO.Id_ditp = CiDictCodeConst.ID_OPDI;
                HeadDiDiagDO.Sd_ditp = CiDictCodeConst.SD_OPDI;
                HeadDiDiagDO.Des_di = "";
                HeadDiDiagDO.Id_emp_create = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;

                HeadDiDiagDO.Dt_di = CommonExtentions.NowTime(this);
            }

            if (this.xyCidiList.Count == 0)
            {
                this.xyCidiList.Add(new Cidixy());
                this.xyCidiList.Add(new Cidixy());
                this.xyCidiList.Add(new Cidixy());
                this.xyCidiList.Add(new Cidixy());
            }
            if (this.zyCidiList.Count == 0)
            {
                this.zyCidiList.Add(new Cididtozy());
                this.zyCidiList.Add(new Cididtozy());
                this.zyCidiList.Add(new Cididtozy());
                this.zyCidiList.Add(new Cididtozy());
            }
        }

        public void DeleteCidixyAt(int itemIndex)
        {
            this.xyCidiList.RemoveAt(itemIndex);
            int count = this.xyCidiList.Count;
            for (int index = 0; index < nDefaultRowCount - count; ++index)
            {
                this.xyCidiList.Add(new Cidixy());
            }
        }

        public void DeleteCididtozyAt(int itemIndex)
        {
            this.zyCidiList.RemoveAt(itemIndex);
            int count = this.zyCidiList.Count;
            for (int index = 0; index < nDefaultRowCount - count; ++index)
            {
                this.zyCidiList.Add(new Cididtozy());
            }
        }

        public bool IsEmptyModel()
        {
            bool isEmpty = true;

            foreach (Cidixy item in this.xyCidiList)
            {
                isEmpty &= this.IsEmpty(item);
            }
            foreach (Cididtozy item in this.zyCidiList)
            {
                isEmpty &= this.IsEmpty(item);
            }
            return isEmpty;
        }

        public bool IsEmptyModel(string id_en)
        {
            bool isEmpty = true;
            if (id_en.Length > 0)
            {
                string sql = string.Format("a0.id_en='{0}'", id_en);
                CidiagAggDO[] szCidiagAggDO = cidiagCrud.find(sql, "a0.createdtime ", false);
                if (szCidiagAggDO.Length > 0)
                {
                    CidiagAggDO diAggDo = szCidiagAggDO.LastOrDefault();
                    CiDiagItemDO[] itemDOs = diAggDo.getCiDiagItemDO();
                    isEmpty = itemDOs == null || itemDOs.Length <= 0;
                }
            }
            return isEmpty;
        }

        //public String GetStr

        /// <summary>
        /// 保存诊断明细数据
        /// </summary>
        /// <param name="isSigned"></param>
        /// <param name="patientsDTO"></param>
        public void save(Ent4BannerDTO patientsDTO)
        {
            string des = "";
            string xy = "";
            string zy = "";
            this.SaveResult = null;

            List<DIDTO> listDto = new List<DIDTO>();
            string ditp_code = this.HeadDiDiagDO.Sd_ditp;

            if (this.xyCidiList != null && this.xyCidiList.Count > 0)
            {   // 西医集合
                xy = "西医诊断\n";
                des += collectDidtoListFromxyList(ditp_code, patientsDTO, listDto, this.xyCidiList, xy);
            }

            if (this.zyCidiList != null && this.zyCidiList.Count > 0)
            {    //中医集合
                zy = "\n中医诊断\n";
                des += collectDidtoListFromzyList(ditp_code, patientsDTO, listDto, this.zyCidiList, zy);
            }
            try
            {
                CiEnContextDTO ciEnContextDto = CiEnContextUtil.GetCiEnContext(patientsDTO);
                SaveResult = mainService.SaveCiDiDtos(listDto.ToArray(), des, ciEnContextDto);
            }
            catch (XapServiceException xapex)
            {
                if (xapex != null)
                    this.ShowMessage(xapex.Message);
                else
                    this.ShowMessage("后台服务异常！");
            }
            catch
            {
            }
        }

        public void saveEmptyDI(Ent4BannerDTO patientsDTO)
        {
            DIDTO diDTO = new DIDTO();
            FillDiInfo(diDTO, patientsDTO);
            try
            {
                CiEnContextDTO ciEnContextDto = CiEnContextUtil.GetCiEnContext(patientsDTO);
                SaveResult = mainService.SaveCiDiDtos(new DIDTO[] { diDTO }, "", ciEnContextDto);
            }
            catch (XapServiceException xapex)
            {
                if (xapex != null)
                    this.ShowMessage(xapex.Message);
                else
                    this.ShowMessage("后台服务异常！");
            }
            catch
            {
            }
        }

        /// <summary>
        /// 获取诊断类型明细数据
        /// </summary>
        /// <param name="id_cdsys"></param>
        /// <param name="type"></param>
        /// <returns></returns>
        public MedCdSystemDO[] GetMedCdSystemList(string id_cdsys, int type)
        {
            try
            {
                if (type == 1)
                    return icdsysCrud.find("a0.id_cdsystp ='" + CiDictCodeConst.ID_CI_DISYS_XYZDTX + "'   and a0.ds ='0'  and a0.activestate ='2' and a0.id_cdsys='" + id_cdsys + "'", null, false);
                else
                    return icdsysCrud.find("a0.id_cdsystp ='" + CiDictCodeConst.ID_CI_DISYS_ZYZDTX + "'   and a0.ds ='0'  and a0.activestate ='2' and a0.id_cdsys='" + id_cdsys + "'", null, false);
            }
            catch (XapServiceException xapex)
            {
                if (xapex != null)
                    this.ShowMessage(xapex.Message);
                else
                    this.ShowMessage("后台服务异常！");
            }
            return null;
        }

        /// <summary>
        /// 判断西医诊断是否为空
        /// </summary>
        /// <param name="xy"></param>
        /// <returns></returns>
        public bool IsEmpty(Cidixy xy)
        {
            return xy.Id_didef_code == null && xy.Id_didef_name == null;
        }

        /// <summary>
        /// 判断中医诊断是否为空
        /// </summary>
        /// <param name="zy"></param>
        /// <returns></returns>
        public bool IsEmpty(Cididtozy zy)
        {
            return string.IsNullOrEmpty(zy.Id_disease_code) && string.IsNullOrEmpty(zy.Id_disease_name);
        }

        public bool IsCidixyListEmpty()
        {
            foreach (var xy in xyCidiList)
            {
                if (xy.Id_didef_name != null)
                    return false;
            }
            return true;
        }

        public int DefaultLastXYDi()
        {
            int pos = xyCidiList.Count - 1;
            for (; pos >= 0; --pos)
            {
                if (xyCidiList[pos].Id_didef_name != null)
                {
                    return pos;
                }
            }

            return 0;
        }

        public bool IsCidizyListEmpty()
        {
            foreach (var zy in zyCidiList)
            {
                if (zy.Id_disease_name != null || zy.Id_syndrome_name != null)
                    return false;
            }
            return true;
        }

        public int DefaultLastZYDi()
        {
            int pos = zyCidiList.Count - 1;
            for (; pos >= 0; --pos)
            {
                if (zyCidiList[pos].Id_disease_name != null || zyCidiList[pos].Id_syndrome_name != null)
                {
                    return pos;
                }
            }

            return 0;
        }

        /// <summary>
        /// 组装诊断描述信息，格式：
        /// 1. 按照页面中西医顺序拼接
        /// 2. 主诊断前加 *
        /// 3. 疑似诊断后 ？
        /// 4. 描述：病症-诊断-补充说明
        /// </summary>
        /// <returns></returns>
        public string GetPatDiDescription()
        {


            // 定义临时诊断描述字符串对象
            string aggDescriptionString = "";

            // 第一标号索引
            int index = 1;
            // 拼接西医诊断描述信息
            if (this.xyCidiList != null && this.xyCidiList.Count > 0)
            {
                foreach (Cidixy xy in this.xyCidiList)
                {
                    if (this.IsEmpty(xy))
                        continue;
                    string itemDescString = "";
                    itemDescString += xy.Id_didef_name;
                   

                    if (xy.Supplement != null && xy.Supplement.Length > 0)
                    {
                        itemDescString += "——" + xy.Supplement;
                    }

                    if (xy.Fg_majdi == true) {
                        itemDescString += mDiPrefix;
                    }
                    if (xy.Fg_suspdi == true) {
                        itemDescString += sDiPrefix;
                    }
                    //
                    itemDescString = index + "、" + itemDescString + "\n";
                    ++index;

                    aggDescriptionString += itemDescString;
                }
            }

            // 拼接中医诊断描述信息
            if (this.zyCidiList != null && this.zyCidiList.Count > 0)
            {
                foreach (Cididtozy zy in this.zyCidiList)
                {
                    if (IsEmpty(zy))
                        continue;
                    string itemDescString = "";
                    itemDescString += zy.Id_disease_name;
                    if (!string.IsNullOrEmpty(zy.Id_syndrome_name))
                    {
                        itemDescString += "——" + zy.Id_syndrome_name;
                    }

                    if (zy.Fg_majdi == true) {
                        itemDescString += mDiPrefix ;
                    }
                    if (zy.Fg_suspdi == true) {
                        itemDescString += sDiPrefix;
                    }
                    // 
                    itemDescString = index + "、" + itemDescString + "\n";
                    ++index;
                    aggDescriptionString += itemDescString;
                }
            }

            if (aggDescriptionString.Length > 0)
            {
                aggDescriptionString = aggDescriptionString.Remove(aggDescriptionString.Length - 1);
            }

            return aggDescriptionString;
        }

        public Cidixy GetXYEmptyRow()
        {
            foreach (Cidixy item in this.xyCidiList)
            {
                if (this.IsEmpty(item))
                    return item;
            }
            return null;
        }

        public Cididtozy GetZYEmptyRow()
        {
            foreach (Cididtozy item in this.zyCidiList)
            {
                if (this.IsEmpty(item))
                    return item;
            }
            return null;
        }

        public void Clear(Cidixy xy)
        {
            LogicEx.GetInstance().Clear(xy);
            xy.Fg_majdi = false;
            xy.Fg_suspdi = false;
        }

        public void Clear(Cididtozy zy)
        {
            LogicEx.GetInstance().Clear(zy);
            zy.Fg_majdi = false;
            zy.Fg_suspdi = false;

        }

        public void ClearAll()
        {
            this.HeadDiDiagDO = null;
            this.xyCidiList.Clear();
            this.zyCidiList.Clear();
        }

        /// <summary>
        /// 当前操作的诊断是否已经关联了医嘱
        /// </summary>
        /// <param name="id_en">就诊id</param>
        /// <param name="id_didef">诊断定义id</param>
        /// <returns>是否有关联的医嘱，true:有关联，false : 没有关联</returns>
        public bool IsCiDiRelateCiOrders(Ent4BannerDTO ent4BannerDTO, string id_didef) {

            // 判断是否为医保就诊，当医保计划Id_hp为空，或者医保类型不匹配（1开头的是社保） 、医保基金支付标识 不等于 true 都是非医保
            if (!CiEnContextUtil.IsHpPat(ent4BannerDTO))
            {
                return false;
            }

            //CiOrderDO[] ciOrders = ciOrdQryService.getCiOrdersUsedHpCiDi(ent4BannerDTO.Id_ent, id_didef);
            String Hpdiexpensese = ciOrdQryService.getUsedHpdiexpensese(ent4BannerDTO.Id_ent, id_didef);


            if (Hpdiexpensese == null || Hpdiexpensese=="")
            {
                return false;
            }
            return true;
        }
        /// <summary>
        /// 诊断依赖
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="di_code"></param>
        /// <returns></returns>
        public List<Judgedideletedto> GetDiDependDtos(String id_ent, string[] di_code, string[] diIdsAll)
        {
       /*     List<Judgedideletedto> ceshi = new List<Judgedideletedto>();
            Judgedideletedto ceshidto = new Judgedideletedto();
            ceshidto.Code_or = "22";
            ceshidto.Name_srv = "ddasda";
            ceshidto.Desc_dpndrsn = "原因";
            ceshi.Add(ceshidto);
            return ceshi;*/
            DiDependDTO[] diDepend = blHpOutQryService.CheckDiDepend(id_ent, di_code, diIdsAll);
            if (diDepend != null && diDepend.Count() > 0)
            {
                List<Judgedideletedto> medicalSharing = new List<Judgedideletedto>();
                foreach (DiDependDTO diDependDto in diDepend)
                {
                    Judgedideletedto dto = new Judgedideletedto();//使用医嘱共享的dto
                    dto.Code_or = diDependDto.Code_or;
                    dto.Name_srv = diDependDto.Name_srv;
                    dto.Desc_dpndrsn = diDependDto.Desc_dpndrsn;
                    if (diDependDto.Fg_delete == FBoolean.True) continue;
                    dto.Fg_delete = diDependDto.Fg_delete;
                    medicalSharing.Add(dto);

                }
                return medicalSharing;
            }
            return null;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public FMap CheckSelfPaidDi(String idhp, String sdentp, String[] idDiDefs)
        {
            return ciOrdQryService.isSelfPaidDi(idhp, sdentp, idDiDefs);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="idhp"></param>
        /// <param name="idpat"></param>
        /// <param name="iddiDefs"></param>
        /// <returns></returns>
        public FMap CheckSpecdi(String idhp, String idpat, String[] iddiDefs)
        {
            return ciOrdQryService.isPatSpecDi(idhp, idpat, iddiDefs);
        }
        #endregion
    }
}

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
using iih.ci.ord.common.utils;
using iih.ci.ord.ems.d;
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

namespace iih.ci.ord.opemergency.viewmodel
{
    class OpDiModifyDialogModel
    {

        //入径服务(入径和手动入径,C#服务)
        private IEnterPathService enterPathService;

        private ICidiagQryService qrySerice;
        private ICidiagMaintainService mainService;

        private ICidiagCrudService cidiagCrud; //agg
        //西医诊断

        //CidiagAggDO
        public XapAggDO<DidtoAggDTO> CidixyAggDto { get; set; }
        //西医诊断
        public XapDataList<Cidixy> xyCidiList { get; set; }
        //中医诊断
        public XapDataList<Cididtozy> zyCidiList { get; set; }

        public OpDiModifyDialogModel()
        {
            qrySerice = XapServiceMgr.find<ICidiagQryService>();
            mainService = XapServiceMgr.find<ICidiagMaintainService>();
            cidiagCrud = XapServiceMgr.find<ICidiagCrudService>();
            enterPathService = XapServiceMgr.find<IEnterPathService>();

            xyCidiList = new XapDataList<Cidixy>();
            zyCidiList = new XapDataList<Cididtozy>();
            if (this.CidixyAggDto == null)
            {
                this.CidixyAggDto = new XapAggDO<DidtoAggDTO>(qrySerice, new DidtoAggDTO());
            }

        }

        public OpDiModifyDialogModel(string id_di)
            : this()
        {
            if (id_di != null)
            {
                CidiagAggDO ciagg = cidiagCrud.findById(id_di);
                getCiDiDtoList(ciagg);
            }
        }

        public OpDiModifyDialogModel(Ent4BannerDTO patientsDTO, string ciditype)
            : this()
        {
            this.setditp(patientsDTO, ciditype);

        }



        //参数 ，页签显示 中医 西医
        public string getSysParam()
        {
            return this.qrySerice.getParamType();
        }
        //诊断过程 类型
        public void setditp(Ent4BannerDTO patientsDTO, string ciditype)
        {
            if (patientsDTO != null)
            {
                this.xyCidiList.Clear();//清空集合
                this.zyCidiList.Clear();
                UdidocDO[] udidocs = qrySerice.getDiType(patientsDTO.Id_ent, ciditype);
                if (udidocs != null && udidocs.Count() > 0)
                {

                    DidtoAggDTO agg = new DidtoAggDTO();

                    this.CidixyAggDto.AggDO.getParentDO().Id_ditp = udidocs[0].Id_udidoc;
                    this.CidixyAggDto.AggDO.getParentDO().Id_ditp_code = udidocs[0].Code;
                     
                    this.CidixyAggDto.AggDO.getParentDO().Id_ditp_name = udidocs[0].Name;
                    this.CidixyAggDto.AggDO.getParentDO().Id_emp_create = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;
                    this.CidixyAggDto.AggDO.getParentDO().Id_emp_create_name =
                        UserManager.getInstance().CurrentPsnInfo.Name;
                    this.CidixyAggDto.AggDO.getParentDO().Dt_di = CommonExtentions.NowTime(this);
                    // this.cidixyList.AggDO.setCididtozy(new Cididtozy[]{new Cididtozy(), });
                    //this.cidixyList.AggDO.setCidixy(null);
                    // 补充诊断
                    if (udidocs[0].Code == CiDictCodeConst.SD_SUPPLY)
                    {
                        this.xyCidiList.Clear();//清空集合
                        this.zyCidiList.Clear();
                    }
                    else
                    {
                        CidiagAggDO[] ciagg = qrySerice.getLastCiDiags(patientsDTO.Id_ent);
                        if (ciagg != null)
                        {
                            ciagg[0].getParentDO().Id_ditp = udidocs[0].Id_udidoc;
                            ciagg[0].getParentDO().Sd_ditp = udidocs[0].Code;
                            ciagg[0].getParentDO().Name_ditp = udidocs[0].Name;
                            ciagg[0].getParentDO().Id_emp_create = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;
                            ciagg[0].getParentDO().Empname =
                                UserManager.getInstance().CurrentPsnInfo.Name;
                            ciagg[0].getParentDO().Dt_di = CommonExtentions.NowTime(this);
                            ciagg[0].getParentDO().Fg_sign = FBoolean.False;
                            getCiDiDtoList(ciagg[0]);

                        }
                        else
                        {
                            // this.CidixyAggDto.AggDO.setCidixy(new Cidixy[] {new Cidixy()});
                            //this.CidixyAggDto.AggDO.setCididtozy(new Cididtozy[] { new Cididtozy() });
                            this.CidixyAggDto.AggDO.ChildrenList.Clear();
                            // agg.setCidixy(new Cidixy[]{new Cidixy()});
                            // this.CidixyAggDto = new XapAggDO<DidtoAggDTO>(qrySerice, agg);
                        }
                    }

                }
            }
        }


        public void getCiDiagDataChanged(Ent4BannerDTO patientsDTO, Headdto headdto)
        {
            if (headdto.Id_ditp_code != "4")
            {
                CidiagAggDO[] ciagg = qrySerice.getLastCiDiags(patientsDTO.Id_ent);
                if (ciagg != null && ciagg.Count() > 0)
                {
                    ciagg[0].getParentDO().Id_ditp = headdto.Id_ditp;
                    ciagg[0].getParentDO().Sd_ditp = headdto.Id_ditp_code;
                    ciagg[0].getParentDO().Name_ditp = headdto.Id_ditp_name;
                    ciagg[0].getParentDO().Id_emp_create = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;
                    ciagg[0].getParentDO().Empname =
                        UserManager.getInstance().CurrentPsnInfo.Name;
                    //ciagg.getParentDO().Des_di = utils.GetServerDataTime();
                    getCiDiDtoList(ciagg[0]);
                }
            }
            else
            {
                this.xyCidiList.Clear();
                this.zyCidiList.Clear();
            }
        }

        public void getOnSelected(String id_di)
        {
            if (id_di != null)
            {
                CidiagAggDO ciagg = cidiagCrud.findById(id_di);
                getCiDiDtoList(ciagg);
            }
        }




        private void getCiDiDtoList(CidiagAggDO ciagg)
        {

            DidtoAggDTO agg = new DidtoAggDTO();
            Headdto headdto = new Headdto();
            if (ciagg != null && ciagg.getCiDiagItemDO() != null)
            {

                List<Cidixy> cidiListxy = new List<Cidixy>();
                List<Cididtozy> cidiListzy = new List<Cididtozy>();
                //int i = 0;

                headdto.Id_ditp = ciagg.getParentDO().Id_ditp;
                headdto.Id_ditp_code = ciagg.getParentDO().Sd_ditp;
                headdto.Id_ditp_name = ciagg.getParentDO().Name_ditp;
                headdto.Dt_di = ciagg.getParentDO().Dt_di;
                headdto.Id_emp_create = ciagg.getParentDO().Id_emp_create;
                headdto.Id_emp_create_name = ciagg.getParentDO().Empname;

                //this.CidixyAggDto.AggDO.getParentDO().Id_ditp = ciagg.getParentDO().Id_ditp;
                //this.CidixyAggDto.AggDO.getParentDO().Id_ditp_code = ciagg.getParentDO().Sd_ditp;
                //this.CidixyAggDto.AggDO.getParentDO().Id_ditp_name = ciagg.getParentDO().Name_ditp;
                //this.CidixyAggDto.AggDO.getParentDO().Dt_di = ciagg.getParentDO().Dt_di;
                //this.CidixyAggDto.AggDO.getParentDO().Id_emp_create = ciagg.getParentDO().Id_emp_create;
                //this.CidixyAggDto.AggDO.getParentDO().Id_emp_create_name = ciagg.getParentDO().Empname;

                agg.setParentDO(headdto);
                foreach (CiDiagItemDO item in ciagg.getCiDiagItemDO())
                {

                    if (item.Id_disys == CiDictCodeConst.ID_CI_DISYS_XYZDTX) //判断  西医
                    {
                        getCidixy(cidiListxy, ciagg, item);
                    }
                    else if (item.Id_disys == CiDictCodeConst.ID_CI_DISYS_ZYZDTX) //判断中医 
                    {
                        getCidizy(cidiListzy, ciagg, item);
                    }
                    else
                    {
                        //todo 暂时  其它体系
                        getCidixy(cidiListxy, ciagg, item);
                    }

                }

                agg.setCidixy(cidiListxy.ToArray());
                agg.setCididtozy(cidiListzy.ToArray());

                //  this.CidixyAggDto.AggDO.setCididtozy(cidiListzy.ToArray());
                //this.CidixyAggDto.AggDO.setCidixy(cidiListxy.ToArray());
                // this.CidixyAggDto.AggDO.setCidixy(cidiListxy.ToArray());
                // this.CidixyAggDto.AggDO.setCididtozy(cidiListzy.ToArray());
                this.CidixyAggDto = new XapAggDO<DidtoAggDTO>(qrySerice, agg);

            }

        }
        /// <summary>
        /// 西医
        /// </summary>
        /// <param name="cidiListxy"></param>
        /// <param name="ciagg"></param>
        /// <param name="item"></param>
        private void getCidixy(List<Cidixy> cidiListxy, CidiagAggDO ciagg, CiDiagItemDO item)
        {

            Cidixy xy = new Cidixy();
            xy.Id_diitm = item.Id_diitm;
            xy.Id_didef = item.Id_didef;
            xy.Id_didef_code = item.Didef_code;
            xy.Id_didef_name = item.Didef_name;
            xy.Id_ditp = ciagg.getParentDO().Id_ditp;
            xy.Id_ditp_code = ciagg.getParentDO().Code_ditp;
            xy.Id_ditp_name = ciagg.getParentDO().Name_ditp;
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
            cidiListxy.Add(xy);
            this.xyCidiList.Add(xy);
        }

        /// <summary>
        /// 中医
        /// </summary>
        /// <param name="cidiListxy"></param>
        /// <param name="ciagg"></param>
        /// <param name="item"></param>
        private void getCidizy(List<Cididtozy> cidiListzy, CidiagAggDO ciagg, CiDiagItemDO item)
        {
            Cididtozy xy = new Cididtozy();



            xy.Id_diitm = item.Id_diitm;
            xy.Di_disease = item.Id_didef;
            xy.Id_disease_code = item.Didef_code;
            xy.Id_disease_name = item.Didef_name;
            xy.Id_ditp = ciagg.getParentDO().Id_ditp;
            xy.Sd_ditp = ciagg.getParentDO().Sd_ditp;
            xy.Id_syndrome = item.Id_didef_syn;
            xy.Id_syndrome_code = item.Id_didef_syn_code;
            xy.Id_syndrome_name = item.Id_didef_syn_name;
            xy.Id_ditp_name = ciagg.getParentDO().Name_ditp;
            xy.Id_disys = item.Id_disys;
            xy.Id_disys_name = item.Id_disys_name;
            xy.Di_standard = item.Di_standard;
            xy.Di_standard_code = item.Di_standard_code;
            xy.Di_standard_name = item.Di_standard_name;
            xy.Id_disys_name = item.Id_disys_name;
            xy.Fg_majdi = item.Fg_majdi;
            xy.Fg_suspdi = item.Fg_suspdi;
            xy.Sd_disys = item.Sd_disys;
            cidiListzy.Add(xy);
            this.zyCidiList.Add(xy);

        }

        public void onSave(bool type, bool IsAdd, PatiVisitDO patientsDTO, string id_di)
        {
            if (this.CidixyAggDto != null)
            {
                XapDataList<Cidixy> xylist = this.CidixyAggDto.AggDO.getCidixy();
            }
        }

        // type :false 保存，true 是签署 
        //ditp_code  是 诊断类型 补充诊断没有主诊断
        //
        public void save(bool type,string ditp_code, bool IsAdd, Ent4BannerDTO patientsDTO, string id_di, XapDataList<Cidixy> list, XapDataList<Cididtozy> listzy)
        {
            // 判断新增 还是 修改
            string id_di_temp = null;
            string des = "";
            string xy = "";
            string zy = "";
            if (IsAdd)
            {
                id_di_temp = null;
            }
            else
            {
                id_di_temp = id_di;
            }
            List<DIDTO> listDto = new List<DIDTO>();

            if (list != null && list.Count > 0 && listzy != null && listzy.Count > 0)
            {
                xy = "西医诊断\n";
                zy = "\n中医诊断\n";
            }

            if (list != null && list.Count > 0)
            {   // 西医集合
                des += getxyList(type,ditp_code, patientsDTO, id_di_temp, listDto, list, xy);
            }

            if (listzy != null && listzy.Count > 0)
            {    //中医集合
                des += getzyList(type,ditp_code, patientsDTO, id_di_temp, listDto, listzy, zy);
            }
           // CiEnContextDTO ciEnContextDto = null;
            CiEnContextDTO ciEnContextDto = CiEnContextUtil.GetCiEnContext(patientsDTO);
            mainService.SaveCiDiDtos(listDto.ToArray(), des, ciEnContextDto);

        }
        /// <summary>
        /// 西医 集合
        /// </summary>
        /// <param name="type"></param>
        /// <param name="patientsDTO"></param>
        /// <param name="listDto"></param>
        /// <param name="list"></param>
        private string getxyList(bool type,string ditp_code, Ent4BannerDTO patientsDTO, string id_di, List<DIDTO> listDto, XapDataList<Cidixy> list, string xy)
        {
            string str = xy;
            int i = 1;
            foreach (Cidixy item in list)
            {
                DIDTO didto = new DIDTO();
                // 判断是 新增 还是修改
                if (id_di != null)
                {
                    didto.Id_diitm = item.Id_diitm;
                }
                else
                {
                    didto.Id_diitm = null;
                }

                didto.Id_di = id_di;
                didto.Id_didef = item.Id_didef;
                didto.Didef_code = item.Id_didef_code;
                didto.Didef_name = item.Id_didef_name;
                didto.Id_ditp = this.CidixyAggDto.AggDO.getParentDO().Id_ditp;
                didto.Sd_ditp = this.CidixyAggDto.AggDO.getParentDO().Id_ditp_code;
                didto.Id_ditp_name = item.Id_ditp_name;
                didto.Supplement = item.Supplement;
                didto.Id_disys = item.Id_disys;
                didto.Sd_disys = item.Sd_disys;
                didto.Id_disys_name = item.Id_disys_name;
                didto.Di_standard = item.Di_standard;
                didto.Di_standard_name = item.Di_standard_name;
                didto.Fg_suspdi = item.Fg_suspdi;
                if (ditp_code == CiDictCodeConst.SD_SUPPLY)
                {
                    didto.Fg_majdi = FBoolean.False;
                }
                else
                {
                    didto.Fg_majdi = item.Fg_majdi;
                }
                didto.Dt_di = CidixyAggDto.AggDO.getParentDO().Dt_di;
                didto.Supplement = item.Supplement;

                didto.Id_disys_name = xy;//item.Id_disys_name;

                str +="   "+ i + "," + item.Id_didef_name;
                if (item.Supplement != null && item.Supplement != "")
                {
                    str += "——" + item.Supplement + "";
                }
                if (item.Fg_suspdi != null && (bool)item.Fg_suspdi)
                {
                    str += " ?  \n";
                }
                else
                {
                    str += "\n";
                }
                didto.Id_en = patientsDTO.Id_ent;
                didto.Code_entp = patientsDTO.Code_entp;
                didto.Id_pat = patientsDTO.Id_pat;
                didto.Id_entp = patientsDTO.Id_entp;

                didto.Id_dep_create = item.Id_dep_create;
                didto.Id_dep_create_name = item.Id_dep_creat_name;
                didto.Id_emp_create = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;
                didto.Id_emp_create_name = UserManager.getInstance().CurrentPsnInfo.Name;
                if (type)
                {
                    didto.Id_dep_sign = UserManager.getInstance().CurrentDept.Id_dep;
                    didto.Id_emp_sign = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;
                    didto.Dt_sign = CommonExtentions.NowTime(this);
                }


                didto.Fg_sign = type;
                i++;
                listDto.Add(didto);
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
        private string getzyList(bool type, string ditp_code,Ent4BannerDTO patientsDTO, string id_di, List<DIDTO> listDto, XapDataList<Cididtozy> listzy, string zy)
        {
            string str = zy;
            int i = 1;
            foreach (Cididtozy item in listzy)
            {  // 判断是 新增 还是修改
                DIDTO didto = new DIDTO();
                if (id_di != null)
                {
                    didto.Id_diitm = item.Id_diitm;
                }
                else
                {
                    didto.Id_diitm = null;
                }
                didto.Id_di = id_di;
                didto.Id_didef = item.Di_disease;
                didto.Didef_code = item.Id_disease_code;
                didto.Didef_name = item.Id_disease_name;
                didto.Id_ditp = this.CidixyAggDto.AggDO.getParentDO().Id_ditp;
                didto.Sd_ditp = this.CidixyAggDto.AggDO.getParentDO().Id_ditp_code;
                didto.Id_ditp_name = item.Id_ditp_name;
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
                if (ditp_code == CiDictCodeConst.SD_SUPPLY)
                {
                    didto.Fg_majdi = FBoolean.False;
                }
                else
                {
                    didto.Fg_majdi = item.Fg_majdi;
                }
               
                didto.Dt_di = CidixyAggDto.AggDO.getParentDO().Dt_di;
                //didto.Id_disys = CiDictCodeConst.ID_CI_DISYS_ZYZDTX;//item.Id_disys;
                didto.Id_disys_name = zy;//item.Id_disys_name;
                //didto.Sd_disys = CiDictCodeConst.SD_CI_DISYS_ZYZDTX;
                didto.Id_en = patientsDTO.Id_ent;
                didto.Id_pat = patientsDTO.Id_pat;
                //didto.Id_entp = patientsDTO.Id_entp;
                //didto.Code_entp = patientsDTO.Code_entp;
                didto.Id_dep_create = item.Id_dep_create;
                didto.Id_dep_create_name = UserManager.getInstance().CurrentUser.Name;
                didto.Id_emp_create = UserManager.getInstance().CurrentUser.Id_user;
                didto.Id_emp_create_name = UserManager.getInstance().CurrentUser.Name;


                str += "   " + i + "," + item.Id_disease_name + "——" + item.Id_syndrome_name + "";
                if (item.Fg_suspdi != null && (bool) item.Fg_suspdi)
                {
                    str += " ?  \n";
                }
                else
                {
                    str += "   \n";
                }
                if (type)
                {
                    didto.Id_dep_sign = UserManager.getInstance().CurrentDept.Id_dep;
                    didto.Id_emp_sign = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;
                    didto.Dt_sign = CommonExtentions.NowTime(this);
                }

                didto.Fg_sign = type;
                listDto.Add(didto);
                i++;
            }
            return str;
        }


        public XapDataList<DidefDto> getDIInfo(string inputValue)
        {
            XapDataList<DidefDto> list = new XapDataList<DidefDto>();

            DiagDefDO[] diagDef = qrySerice.getDiagDefDOS(inputValue);

            if (diagDef != null)
            {
                foreach (DiagDefDO defDO in diagDef)
                {
                    DidefDto dto = new DidefDto();
                    dto.Code = defDO.Code;
                    dto.Id_di = defDO.Id_didef;
                    dto.Name = defDO.Name;
                    list.Add(dto);
                }

            }

            return list;
        }


        public void DleteCidiag(CiDiagDO ciDiagDo)
        {
            this.mainService.DeleteCiDiag(ciDiagDo);
        }


        ///// <summary>
        ///// HPCP 诊疗计划入径
        ///// </summary>
        ///// <param name="idEnt">就诊ID</param>
        ///// <param name="idPat">患者ID</param>
        ///// <returns></returns>
        //public EnterPathInfo EnterPath(string idEnt, string idPat)
        //{
        //    return null;// enterPathService.EnterPath(idEnt, idPat);
        //}
 

    }
}

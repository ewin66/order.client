
using iih.bd.bc.udi;
using iih.ci.diag.cidiag.d;
using iih.ci.diag.cidiag.i;
using iih.ci.diag.dto.d;
using iih.ci.diag_stub.i;
using iih.en.pv.dto.d;
using iih.mkr.ms.mkrms.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.common.utils;
using iih.ci.ord.ems.d;
using xap.cli.context;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.control.extentions;
using xap.rui.engine;
using xap.sys.orgfw.dept.d;
using xap.sys.permfw.user.d;
using xap.sys.securityfw.switchdept;

namespace iih.ci.ord.opemergency.assi.asscommon.viewmodel
{
    /// <summary>
    /// <para>描    述 :  助手中诊断操作</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.asscommon.viewmodel</para>    
    /// <para>类 名 称 :  AssistantCidiViewModel</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/10/20 19:48:17</para>
    /// <para>更新时间 :  2016/10/20 19:48:17</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class AssistantCidiViewModel
    {
        /// <summary>
        /// banner对象
        /// </summary>
        public Ent4BannerDTO ent4BannerDTO { get; set; }
        /// <summary>
        /// 当前环境
        /// </summary>
        public BaseContext context { get; set; }

        /// <summary>
        /// 诊断保存服务
        /// </summary>
        private ICidiagMaintainService mainService;

        /// <summary>
        /// 诊断明细
        /// </summary>
        private ICidiagCrudService cidiagService;

        public AssistantCidiViewModel()
        {

            cidiagService = XapServiceMgr.find<ICidiagCrudService>();
            //cidaigMdoCrudService = XapServiceMgr.find<ICidiagMDOCrudService>();
            mainService = XapServiceMgr.find<ICidiagMaintainService>();
        }

        /// <summary>
        /// 保存组套诊断
        /// </summary>
        /// <param name="mkrMsDiDOList">组套中选择的诊断集合</param>
        /// <param name="isProcessSaveCIDI">是否执行诊断保存，当组套选择的诊断为空时不进行保存，该值为false， 否则为true</param>
        /// <returns></returns>
        public List<DIDTO> SaveMkrMsDIDTOList(FArrayList mkrMsDiDOList, ref bool isProcessSaveCIDI)
        {

            List<DIDTO> didtoList = new List<DIDTO>();
            if (mkrMsDiDOList != null && mkrMsDiDOList.Count > 0)
            {
                isProcessSaveCIDI = true;
                foreach (object obj in mkrMsDiDOList)
                {
                    didtoList.Add(this.GetMkrMsDiDTO(obj as MkrMsDiDO));
                }
            }

            return this.SaveDIDTOs(didtoList);

        }

        /// <summary>
        /// 诊断保存
        /// </summary>
        /// <param name="didtos">新增的诊断</param>
        /// <returns>保存成功的DIDTO集合</returns>
        private List<DIDTO> SaveDIDTOs(List<DIDTO> didtoList)
        {
            // 疾病诊断id集合
            List<string> savedidefIdList = new List<string>();
            // 本次需要保存诊断集合（包含以保存的，和本次待保存的诊断）
            List<DIDTO> saveList = new List<DIDTO>();

            // 获取已保存的诊断集合
            List<DIDTO> savedDidtoList = this.GetSavedDIDTOs(this.ent4BannerDTO.Id_ent);

            // 添加已经保存的诊断集合
            if (savedDidtoList != null || savedDidtoList.Count > 0)
            {
                foreach (DIDTO didto in savedDidtoList)
                {
                    didto.Id_di = null;
                    didto.Id_diitm = null;
                    savedidefIdList.Add(didto.Id_didef);
                    // 添加已保存的DIDTO集合
                    saveList.Add(didto);
                }

            }



            // 如果当前不存在待保存的诊断，不需要对已有诊断在重新保存，直接返回已有的结果
            if (didtoList == null || didtoList.Count == 0)
            {
                return saveList;
            }

            // 如果待保存诊断中不存在主诊断，将待保存第一项做为主诊断
            bool Fg_majdi = FBoolean.False;
            foreach (DIDTO didto in didtoList)
            {
                didto.Id_di = null;
                didto.Id_diitm = null;
                if (saveList.Count == 0) // 如果不存在已经保存的诊断,将本次选择的诊断全部添加到待保存的诊断集合中，并且保证只有一条主诊断
                {
                    if (didto.Fg_majdi == FBoolean.True)
                    {
                        if (Fg_majdi)
                        {
                            didto.Fg_majdi = FBoolean.False;
                        }
                        else
                        {
                            Fg_majdi = FBoolean.True;
                        }
                    }
                    saveList.Add(didto);
                }
                else
                {
                    // 添加未保存过的诊断
                    if (!savedidefIdList.Contains(didto.Id_didef))
                    {
                        Fg_majdi = FBoolean.True;
                        didto.Fg_majdi = FBoolean.False;
                        saveList.Add(didto);
                    }
                }
            }

            if (Fg_majdi == FBoolean.False)
            {
                didtoList[0].Fg_majdi = FBoolean.True;
            }

            // 保存所有的诊断（已保存、待保存）
            //CiEnContextDTO ciEnContextDto = null;
            CiEnContextDTO ciEnContextDto = CiEnContextUtil.GetCiEnContext(this.ent4BannerDTO);
            DIDTO[] didtos = mainService.SaveCiDiDtos(saveList.ToArray(), "",ciEnContextDto);

            return new List<DIDTO>(didtos);
        }

        /// <summary>
        /// 将组套中的诊断（MkrMsDiDO）转换为医嘱诊断（DIDTO）
        /// </summary>
        /// <param name="mkrMsDIDO">组套诊断</param>
        /// <returns></returns>
        private DIDTO GetMkrMsDiDTO(MkrMsDiDO mkrMsDIDO)
        {

            DIDTO diDTO = new DIDTO();

            //diDTO.Id_di = mkrMsDIDO.Id_di; //诊断ID
            diDTO.Id_didef = mkrMsDIDO.Id_didef; //基础数据诊断id
            diDTO.Didef_code = mkrMsDIDO.Didef_code; //诊断编码
            diDTO.Didef_name = mkrMsDIDO.Didef_name; //诊断名称            

            //diDTO.Id_didef_syn = mkrmsdido.id_didef_syn; //证候诊断
            //diDTO.id_didef_syn_code = mkrmsdido.id_didef_syn_code; //证候诊断编码
            //diDTO.id_didef_syn_name = mkrMsDIDO.Id_didef_syn_name; //证候诊断名称

            diDTO.Fg_suspdi = FBoolean.False; //疑似 组套中设置为false

            diDTO.Supplement = mkrMsDIDO.Supplement; //补充说明

            //diDTO.Fg_infedi = null; //传染病标志 怎么来的？
            //diDTO.Id_par = mkrMsDIDO.Id_par; //上级诊断 门诊现在没有父子诊断，不设置该值
            diDTO.Fg_majdi = mkrMsDIDO.Fg_majdi; //主要诊断

            diDTO.Id_disys = mkrMsDIDO.Id_cdsystp; //诊断体系编码 中医诊断体系、西医诊断体系、（蒙医、手术）
            diDTO.Sd_disys = mkrMsDIDO.Sd_cdsystp; //诊断体系sd
            //diDTO.Id_disys_name = mkrMsDIDO.Id_disys_name; //诊断体系名称（组套中目前不能获取这个属性）

            diDTO.Di_disease = mkrMsDIDO.Id_didef; //疾病诊断id
            diDTO.Id_disease_name = mkrMsDIDO.Didef_name; //疾病诊断名称
            diDTO.Id_disease_code = mkrMsDIDO.Didef_code; //疾病诊断编码
            diDTO.Fg_self = FBoolean.False; //自定义诊断标识 (组套中诊断来源于诊断定义)

            ////diDTO.Innercode = null; //内部编码 诊断保存时生成

            diDTO.Fg_ur = FBoolean.False; //上报标识
            diDTO.Fg_chronic = mkrMsDIDO.Fg_chronic; //慢性病标志
            diDTO.Fg_special = mkrMsDIDO.Fg_special; //特种病标志   

            //diDTO.Des_di = mkrMsDIDO.Des_di; //诊断描述 后台保存时生成
            // diDTO.Sortno = mkrMsDIDO.Sortno; //序号 查询出整体的诊断在设置编码          

            diDTO.Di_standard_name = mkrMsDIDO.Cdsys_name; //诊断标准名称
            diDTO.Di_standard = mkrMsDIDO.Id_cdsys; //诊断标准
            diDTO.Di_standard_code = mkrMsDIDO.Cdsys_code; //标准编码

            //diDTO.Id_diitm = mkrMsDIDO.Id_diitm; //子表主键

            return SetEnvironmentVariable(diDTO);
        }

        /// <summary>
        /// 获取已保存的DIDTO集合
        /// </summary>
        /// <returns></returns>
        private List<DIDTO> GetSavedDIDTOs(string idEn)
        {

            List<DIDTO> didtoList = new List<DIDTO>();

            // 获取已经保存的诊断agg
            CidiagAggDO cidiagAgg = this.GetCidiagAggDO(idEn);

            if (cidiagAgg == null)
            {
                return didtoList;
            }
            CiDiagDO cidiagDO = cidiagAgg.getParentDO();
            CiDiagItemDO[] cidiItems = cidiagAgg.getCiDiagItemDO();

            // 将已保存的诊断agg转换成DIDTO集合
            foreach (CiDiagItemDO cidiItem in cidiItems)
            {
                DIDTO didto = GetDIDTOBySavedItem(cidiagDO, cidiItem);
                didtoList.Add(didto);
            }

            return didtoList;
        }

        private CidiagAggDO GetCidiagAggDO(string idEn)
        {

            string str = "a0.id_en = '" + idEn + "'";
            CidiagAggDO[] cidiAggdos = cidiagService.find(str, "a0.createdtime desc", false);
            if (cidiAggdos != null && cidiAggdos.Length > 0)
            {
                return cidiAggdos[0];
            }
            return null;
        }

        /// <summary>
        /// 根据已经保存的诊断明显获取诊断
        /// </summary>
        /// <param name="cidiagDO">临床诊断</param>
        /// <param name="item">诊断明细</param>
        /// <returns></returns>
        private DIDTO GetDIDTOBySavedItem(CiDiagDO cidiagDO, CiDiagItemDO item)
        {

            DIDTO diDTO = new DIDTO();

            //diDTO.Id_di = cidiagDO.Id_di; //诊断ID
            diDTO.Id_didef = item.Id_didef; //基础数据诊断id
            diDTO.Didef_code = item.Didef_code; //诊断编码
            diDTO.Didef_name = item.Didef_name; //诊断名称

            diDTO.Id_didef_syn = item.Id_didef_syn; //证候诊断
            diDTO.Id_didef_syn_code = item.Id_didef_syn_code; //证候诊断编码
            diDTO.Id_didef_syn_name = item.Id_didef_syn_name; //证候诊断名称
            diDTO.Fg_suspdi = item.Fg_suspdi; //疑似
            diDTO.Supplement = item.Supplement; //补充说明

            //diDTO.Fg_infedi = null; //传染病标志 怎么来的？
            //diDTO.Id_par = item.Id_parent; //上级 门诊没有父子诊断不设置

            diDTO.Fg_majdi = item.Fg_majdi; //主要诊断
            diDTO.Id_disys = item.Id_disys; //诊断体系编码 中医诊断体系、西医诊断体系、（蒙医、手术）
            diDTO.Sd_disys = item.Sd_disys; //诊断体系sd
            diDTO.Id_disys_name = item.Id_disys_name; //诊断体系名称

            diDTO.Di_disease = item.Id_didef; //疾病诊断id
            diDTO.Id_disease_name = item.Didef_name; //疾病诊断名称
            diDTO.Id_disease_code = item.Didef_code; //疾病诊断编码
            diDTO.Fg_self = item.Fg_self; //自定义诊断标识 
            //diDTO.Innercode = null; //内部编码 诊断保存时生成
            diDTO.Fg_ur = FBoolean.False; //上报标识
            diDTO.Fg_chronic = item.Fg_chronic; //慢性病标志
            diDTO.Fg_special = item.Fg_special; //特种病标志

            //diDTO.Des_di = mkrMsDIDO.Des_di; //诊断描述 后台保存时生成
            // diDTO.Sortno = mkrMsDIDO.Sortno; //序号 查询出整体的诊断在设置编码

            diDTO.Di_standard_name = item.Di_standard_name; //诊断标准名称
            diDTO.Di_standard = item.Di_standard_name; //诊断标准
            diDTO.Di_standard_code = item.Di_standard_name; //标准编码
            //diDTO.Id_diitm = item.Id_diitm; //子表主键

            return SetEnvironmentVariable(diDTO);
        }

        /// <summary>
        /// 设置诊断与当前环境相关的属性
        /// </summary>
        /// <returns></returns>
        private DIDTO SetEnvironmentVariable(DIDTO diDTO)
        {
            // @@ 诊断映射可以统一优化
            DeptDO dept = this.context.Dept;
            PsnInfo user = this.context.PsnInfo;
            PsnInfo psnInfo = UserManager.getInstance().CurrentPsnInfo;//.Id_psndoc;

            diDTO.Id_en = this.ent4BannerDTO.Id_ent; //就诊id
            diDTO.Id_pat = this.ent4BannerDTO.Id_pat; //患者id
            diDTO.Id_entp = this.ent4BannerDTO.Id_entp; //就诊类型
            diDTO.Code_entp = this.ent4BannerDTO.Code_entp; //就诊类型编码

            diDTO.Id_ditp = CiDictCodeConst.ID_OPDI; //诊断类型 诊断过程状态 门诊、初步、入院、补充、修正、出院、死亡
            diDTO.Sd_ditp = CiDictCodeConst.SD_OPDI; //诊断类型编码
            diDTO.Id_ditp_name = "门诊诊断"; //诊断类型名称

            diDTO.Id_emp_create = user.Id_psndoc; //诊断医生
            diDTO.Id_emp_create_name = user.Name; //医生姓名
            diDTO.Id_dep = dept.Id_dep; //诊断科室
            diDTO.Dt_di = CommonExtentions.NowTime(this); //诊断时间            

            diDTO.Id_emp_sign = user.Id_psndoc; //签署人
            diDTO.Name_emp_sign = user.Name; //签署人名称
            diDTO.Fg_sign = FBoolean.True; //签署标识
            diDTO.Id_dep_sign = dept.Id_dep; //签署科室
            diDTO.Dt_sign = CommonExtentions.NowTime(this); //签署时间            

            diDTO.Id_dep_create = dept.Id_dep; //开立科室
            diDTO.Id_dep_create_name = dept.Name; //开立科室名称
            diDTO.Dt_create = CommonExtentions.NowTime(this); //开立时间

            // 根据诊断体系确定是中医诊断还是西医诊断，目前不是西医诊断都认为是中医诊断，蒙医、手术后续有调整是在判断
            // 西医标志 根据诊断体系判断，如果是西医诊断，设置为true,否则设置为false 
            if (CiDictCodeConst.ID_CI_DISYS_XYZDTX.Equals(diDTO.Id_disys))
            {
                diDTO.Fg_med = FBoolean.True;
            }
            else
            {
                diDTO.Fg_med = FBoolean.False;
            }

            return diDTO;
        }

        public static DIDTO DIDTOWith(MkrMsDiDO o, Ent4BannerDTO e = null, BaseContext c = null)
        {
            return new DIDTO()
            {
                Code_entp = (e != null ? e.Code_entp : ""),
                Des_di = "",
                Di_disease = "",
                Di_standard = "",
                Di_standard_code = "",
                Di_standard_name = "",
                Didef_code = o.Didef_code,
                Didef_name = o.Didef_name,
                Dt_create = CommonExtentions.NowTime(o),
                Dt_di = CommonExtentions.NowTime(o),
                Dt_sign = CommonExtentions.NowTime(o),
                Fg_infedi = false,
                Fg_majdi = o.Fg_majdi,
                Fg_med = false,
                Fg_sign = true,
                Fg_suspdi = o.Fg_majdi != true,
                Id_dep = "",
                Id_dep_create = "",
                Id_dep_create_name = "",
                Id_dep_sign = (c != null ? c.Dept.Id_dep : ""),
                Id_di = null,
                Id_didef = o.Id_didef,
                //         Id_didef_syn { get; set; }
                //         Id_didef_syn_code { get; set; }
                //         Id_didef_syn_name { get; set; }
                //         Id_diitm = "",
                //         Id_disease_code { get; set; }
                //         Id_disease_name { get; set; }
                Id_disys = o.Id_cdsys,
                Id_disys_name = o.Cdsys_name,
                //         Id_ditp { get; set; }
                //         Id_ditp_name { get; set; }
                Id_emp_create = (c != null ? c.PsnInfo.Id_psndoc : ""),
                Id_emp_create_name = (c != null ? c.PsnInfo.Name : ""),
                Id_emp_sign = (c != null ? c.PsnInfo.Id_psndoc : ""),
                Id_en = (e != null ? e.Id_ent : ""),
                Id_entp = (e != null ? e.Id_entp : ""),
                Id_par = o.Id_par,
                Id_pat = (e != null ? e.Id_pat : ""),
                Name_emp_sign = (c != null ? c.PsnInfo.Name : ""),
                //         Sd_disys { get; set; }
                //         Sd_ditp { get; set; }
                Sortno = null,
                Supplement = o.Supplement

            };
        }

        public static string DescrStringWithDIDTOs(DIDTO[] szDI)
        {
            string xyDescString = "", zyDescString = "";
            int xyIndex = 1, zyIndex = 1;
            foreach (DIDTO di in szDI)
            {
                if (di.Didef_code == null && di.Didef_name == null)
                    continue;

                if (di.Id_disys == CiDictCodeConst.ID_CI_DISYS_XYZDTX)
                {
                    xyDescString += di.Didef_name;
                    if (di.Fg_majdi == true)
                    {
                        xyDescString = "★" + xyDescString;
                    }
                    if (di.Fg_suspdi == true)
                    {
                        xyDescString += "?";
                    }
                    xyDescString += di.Didef_name;
                    xyDescString = xyIndex + "、" + xyDescString + "\n";
                    ++xyIndex;
                }
                else
                {
                    zyDescString += di.Id_disease_name;
                    if (di.Fg_majdi == true)
                    {
                        zyDescString = "★" + zyDescString;
                    }
                    if (di.Fg_suspdi == true)
                    {
                        zyDescString += "?";
                    }
                    zyDescString += "——" + di.Id_didef_syn_name;
                    zyDescString = zyIndex + "、" + zyDescString + "\n";
                    ++zyIndex;
                }


            }

            return xyDescString + zyDescString;
        }
    }
}

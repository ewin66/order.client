
using System;
using System.Collections.Generic;
using iih.ci.diag.cidiag.i;
using xap.sys.xbd.udi.i;
using iih.ci.diag_stub.i;
using xap.sys.xbd.udi.d;
using xap.rui.engine;
using xap.mw.serviceframework;
using iih.ci.diag.cidiag.d;
using xap.mw.coreitf.d;
using iih.ci.diag.dto.d;
using iih.en.pv.dto.d;
using xap.sys.permfw.user.d;
using xap.sys.orgfw.dept.d;
using xap.rui.control.extentions;
using iih.bd.bc.udi;
using iih.ci.ord.ems.d;
using iih.ci.ord.common.utils;
using xap.sys.securityfw.switchdept;

namespace iih.ci.ord.opemergency.assi.enthistory.viewmodel
{
    /// <summary>
    /// <para>描    述 : 诊断相关处理类</para>
    /// <para>说    明 : </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.enthistory.viewmodel    </para>    
    /// <para>类 名 称 :  CiDiagViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/8/4 15:28:29</para>
    /// <para>更新时间 :  2016/8/4 15:28:29</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class CiDiagViewModel
    {

        #region 变量定义区域

        /// <summary>
        /// 诊断服务
        /// </summary>
        private ICidiagMDOCrudService cidaigMdoCrudService;

        /// <summary>
        /// 诊断保存服务
        /// </summary>
        private ICidiagMaintainService mainService;

        /// <summary>
        /// 诊断明细
        /// </summary>
        private ICidiagCrudService cidiagService;

        /// <summary>
        /// 字典项服务
        /// </summary>
        private IUdidocServiceExt usService;

        /// <summary>
        /// 诊断体系
        /// </summary>
        private UdidocDO[] disysArr;

        /// <summary>
        /// 当前用户Context ，用于获取当前用户、组织信息
        /// </summary>
        private BaseContext context;

        #endregion

        #region 构造函数区域

        /// <summary>
        /// 除就诊历史外使用
        /// </summary>
        public CiDiagViewModel(BaseContext context)
        {
            this.context = context;
            cidiagService = XapServiceMgr.find<ICidiagCrudService>();
            cidaigMdoCrudService = XapServiceMgr.find<ICidiagMDOCrudService>();
            mainService = XapServiceMgr.find<ICidiagMaintainService>();
            usService = XapServiceMgr.find<IUdidocServiceExt>();
        }

        #endregion


        #region 诊断相关方法

        /// <summary>
        /// 根据就诊获取本次就诊对应的诊断
        /// </summary>
        /// <param name="id_en"></param>
        /// <returns></returns>
        public List<CiDiagItemDO> GetCiDiagItemList(String id_en)
        {

            List<CiDiagItemDO> ciDiItemList = new List<CiDiagItemDO>();

            CidiagAggDO cidiAggDO = GetCidiagAggDO(id_en);
            if (cidiAggDO != null)
            {
                CiDiagItemDO[] items = cidiAggDO.getCiDiagItemDO();
                if (items != null)
                {
                    foreach (CiDiagItemDO item in items)
                    {
                        if (FBoolean.True == item.Fg_majdi)
                        {
                            ciDiItemList.Insert(0, item);
                        }
                        else
                        {
                            ciDiItemList.Add(item);
                        }
                    }
                }
            }

            return ciDiItemList;
        }

        /// <summary>
        /// 根据就诊id_en 获取本次就诊诊断（每次修改都会插入新的诊断数据，改为取时间最新的一条）
        /// </summary>
        /// <param name="id_en">就诊id</param>
        /// <returns></returns>
        public CidiagAggDO GetCidiagAggDO(string id_en)
        {

            string str = "a0.id_en = '" + id_en + "'";
            CidiagAggDO[] cidiAggdos = cidiagService.find(str, "a0.createdtime desc", false);
            if (cidiAggdos != null && cidiAggdos.Length > 0)
            {
                return cidiAggdos[0];
            }
            return null;
        }

        /// <summary>
        /// 根据就诊id_en 获取诊断CidiagAggDO集合
        /// </summary>
        /// <param name="id_en">就诊id</param>
        /// <returns></returns>
        public CidiagAggDO[] GetCidiagAggDOs(string id_en)
        {
            string str = "a0.id_en = '" + id_en + "'";
            CidiagAggDO[] cidiAggdos = cidiagService.find(str, "a0.createdtime ", false);
            return cidiAggdos;
        }

        /// <summary>
        /// 获取诊断体系
        /// </summary>
        /// <returns></returns>
        public UdidocDO[] GetIddisysArr()
        {

            string idUdidoclistCode = "BD.BC.1050";

            if (this.disysArr == null)
            {
                disysArr = usService.findByUdidoclistCode(idUdidoclistCode);
            }

            return disysArr;
        }

        /// <summary>
        /// 保存诊断信息
        /// </summary>
        /// <param name="id_ent">就诊id</param>
        /// <param name="itemDOList">界面选取的诊断集合</param>
        public DIDTO[] SaveCiDiagItemDOs(Ent4BannerDTO bannerDTO, List<CiDiagItemDO> itemDOList)
        {
            DIDTO[] didtos = null;
            List<DIDTO> listDto = this.GetDIDTOList(bannerDTO, itemDOList);
            if (listDto != null && listDto.Count > 0)
            {
                CiEnContextDTO ciEnContextDto = CiEnContextUtil.GetCiEnContext(bannerDTO, this.context);
                didtos = mainService.SaveCiDiDtos(listDto.ToArray(), "", ciEnContextDto);
            }
            return didtos;
        }

        /// <summary>
        /// 通过界面选择的诊断构造DIDTO对象集合
        /// </summary>
        /// <param name="bannerDTO"></param>
        /// <param name="itemDOList"></param>
        /// <returns></returns>
        private List<DIDTO> GetDIDTOList(Ent4BannerDTO bannerDTO, List<CiDiagItemDO> itemDOList)
        {
            // 疾病诊断id集合，用于过滤重复诊断
            List<string> idDidefList = new List<string>();

            List<DIDTO> didtoList = new List<DIDTO>();
            List<DIDTO> resultDidtoList = new List<DIDTO>();
            // 获取本次就诊的最新诊断
            CidiagAggDO cidiagAggDO = this.GetCidiagAggDO(bannerDTO.Id_ent);
            if (cidiagAggDO != null)
            {
                // 如果已经保存过诊断，获取保存过的诊断
                didtoList.AddRange(this.GetSavedDidtoList(cidiagAggDO, idDidefList));
            }

            // 获取界面选择的诊断
            didtoList.AddRange(this.GetSeledDidtoList(cidiagAggDO, bannerDTO, itemDOList, idDidefList));

            // 如果是首次保存，将界面选取的第一条诊断设置为主诊断
            if (cidiagAggDO == null)
            {
                didtoList[0].Fg_majdi = FBoolean.True;
            }

            return didtoList;
        }

        /// <summary>
        /// 通过以保存的CidiagAggDO 构造List<DIDTO>对象
        /// </summary>
        /// <param name="cidiagAggDO">已经保存的诊断对象</param>
        /// <param name="idDidefList">缓存诊断定义id，用于过滤重复诊断</param>
        /// <returns></returns>
        private List<DIDTO> GetSavedDidtoList(CidiagAggDO cidiagAggDO, List<string> idDidefList)
        {
            List<DIDTO> didtoList = new List<DIDTO>();

            CiDiagDO cidiagDO = cidiagAggDO.getParentDO();
            CiDiagItemDO[] cidiagItems = cidiagAggDO.getCiDiagItemDO();

            foreach (CiDiagItemDO itemDO in cidiagItems)
            {
                DIDTO didto = new DIDTO();

                // 从数据库中查询出的诊断不存在重复，用于过滤选取的历史诊断是否存在重复
                idDidefList.Add(itemDO.Id_didef);

                this.setCiDiagItemProperty(itemDO, didto);
                this.setCiDiagDOProperty(cidiagDO, didto);

                //didto.Id_diitm = itemDO.Id_diitm; // 子表主键
                didto.Fg_majdi = itemDO.Fg_majdi; // 主诊断标识
                didto.Sortno = (idDidefList.Count).ToString();// 通过记录数，设置诊断的排序号

                didtoList.Add(didto);
            }
            return didtoList;
        }

        /// <summary>
        /// 通过诊断列表选择的诊断 构造List<DIDTO>对象
        /// </summary>
        /// <param name="bannerDTO"></param>
        /// <param name="itemDOList"></param>
        /// <returns></returns>
        private List<DIDTO> GetSeledDidtoList(CidiagAggDO cidiagAggDO, Ent4BannerDTO bannerDTO, List<CiDiagItemDO> itemDOList, List<string> idDidefList)
        {
            string idDi = null;
            // 未保存过诊断情况，cidiagAggDO = null
            if (cidiagAggDO != null)
            {
                idDi = cidiagAggDO.getParentDO().Id_di;
            }

            List<DIDTO> didtoList = new List<DIDTO>();

            foreach (CiDiagItemDO itemDO in itemDOList)
            {
                // 列表中已有相同诊断，不重复添加
                if (idDidefList.Contains(itemDO.Id_didef))
                {
                    continue;
                }

                DIDTO didto = new DIDTO();
                idDidefList.Add(itemDO.Id_didef);

                this.setCiDiagItemProperty(itemDO, didto);
                this.setCiDiagDOProperty(bannerDTO, didto);
                didto.Sortno = (idDidefList.Count).ToString();
                didto.Id_di = idDi;
                didtoList.Add(didto);
            }
            return didtoList;
        }

        /// <summary>
        /// 将诊断属性赋值给DIDTO
        /// <para>不区分itemDO是来源于数据库还是界面选择的历史诊断</para>
        /// </summary>
        /// <param name="itemDO"></param>
        /// <param name="didto"></param>
        private void setCiDiagItemProperty(CiDiagItemDO itemDO, DIDTO didto)
        {
            //didto.Id_diitm = itemDO.Id_diitm; // 子表主键 当诊断明细来源于数据库时设置该值，放到GetSavedDidtoList方法中设置
            didto.Id_par = itemDO.Id_parent; // 上级 父子诊断用 ？
            //didto.Sortno = itemDO.Sortno; // 排序号 重新设置诊断的排序号

            didto.Id_didef = itemDO.Id_didef; // 诊断定义主键
            didto.Didef_code = itemDO.Didef_code; // 诊断编码 同 id_didef_code
            didto.Didef_name = itemDO.Didef_name; // 诊断名称 同 id_didef_name

            //didto.Id_ditp = item.Id_ditp; // 诊断类型 诊断过程状态_自定义档案
            //didto.Sd_ditp = item.Sd_ditp;// 诊断类型编码
            //didto.Id_ditp_name = item.Id_ditp_name; // 诊断类型名称
            didto.Id_ditp = CiDictCodeConst.ID_OPDI; //诊断类型 诊断过程状态 门诊、初步、入院、补充、修正、出院、死亡
            didto.Sd_ditp = CiDictCodeConst.SD_OPDI; //诊断类型编码

            didto.Id_didef_syn = itemDO.Id_didef_syn; // 证候诊断
            didto.Id_didef_syn_code = itemDO.Id_didef_syn_code; // 证候诊断编码
            didto.Id_didef_syn_name = itemDO.Id_didef_syn_name; // 证候诊断名称

            //didto.Fg_majdi = itemDO.Fg_majdi; // 主要诊断 如果是从数据库中查询的诊断，认为已经设置了主诊断，否则将选择的第一条记录设置为主诊断
            didto.Fg_suspdi = itemDO.Fg_suspdi; // 疑似诊断标识
            didto.Supplement = itemDO.Supplement; // 补充说明
            didto.Des_di = itemDO.Des; // 诊断描述

            //didto.Id_emp_create = itemDO.Id_emp_create; // 开立医生 诊断医生 取当前登录人
            //didto.Id_emp_create_name = itemDO.Id_emp_create_name; // 开立医生姓名 医生姓名 取当前登录人
            //didto.Dt_di = itemDO.Dt_di; // 诊断时间 当前时间
            //didto.Id_dep_create = ""; // 开立科室
            //didto.Id_dep_create_name = ""; // 开立科室名称
            //didto.Dt_create = null; // 开立时间

            //didto.Id_dep = ""; // 诊断科室 
            //didto.Id_en = ""; // 就诊id
            //didto.Id_pat = ""; // 患者id
            //didto.Id_entp = ""; // 就诊类型
            //didto.Code_entp = ""; // 就诊类型编码

            //didto.Id_emp_sign = ""; // 签署人
            //didto.Name_emp_sign = ""; // 签署人名称
            //didto.Id_dep_sign = ""; // 签署科室
            //didto.Dt_sign = null; // 签署时间
            //didto.Fg_sign = null; // 签署标志            

            didto.Fg_med = false;// 西医标志 
            didto.Fg_infedi = itemDO.Fg_infedi; // 传染病标志

            didto.Id_disys = itemDO.Id_disys; // 诊断体系
            didto.Sd_disys = itemDO.Sd_disys; // 诊断体系编码
            didto.Id_disys_name = itemDO.Id_disys_name; // 诊断体系名称

            didto.Di_standard = itemDO.Di_standard; // 诊断标准
            didto.Di_standard_code = itemDO.Di_standard_code; // 诊断标准编码
            didto.Di_standard_name = itemDO.Di_standard_name; // 诊断标准名称

            didto.Di_disease = itemDO.Id_didef;  // 疾病诊断id
            didto.Id_disease_name = itemDO.Didef_code; // 疾病诊断名称
            didto.Id_disease_code = itemDO.Didef_name; // 疾病诊断编码
        }

        /// <summary>
        /// 通过已保存的诊断主表设置DIDTO中主表属性
        /// </summary>
        /// <param name="item"></param>
        /// <param name="didto"></param>
        private void setCiDiagDOProperty(CiDiagDO cidiagDO, DIDTO didto)
        {
            //didto.Id_ditp = cidiagDO.Id_ditp; // 诊断类型 诊断过程状态_自定义档案
            //didto.Sd_ditp = cidiagDO.Sd_ditp;// 诊断类型编码
            //didto.Id_ditp_name = cidiagDO.Id_ditp_name; // 诊断类型名称

            //didto.Id_di = cidiagDO.Id_di; // 诊断主表id

            didto.Id_emp_create = cidiagDO.Id_emp_create; // 开立医生 诊断医生 取当前登录人
            didto.Id_emp_create_name = cidiagDO.Empname; // 开立医生姓名 医生姓名 取当前登录人
            didto.Dt_di = CommonExtentions.NowTime(this); // 诊断时间 当前时间
            didto.Id_dep_create = cidiagDO.Id_dep_create; // 开立科室
            didto.Id_dep_create_name = cidiagDO.Name_dep_create; // 开立科室名称
            didto.Dt_create = cidiagDO.Dt_create; // 开立时间

            //didto.Id_dep = ""; // 诊断科室 
            didto.Id_en = cidiagDO.Id_en; // 就诊id
            didto.Id_pat = cidiagDO.Id_pat; // 患者id
            didto.Id_entp = cidiagDO.Id_entp; // 就诊类型
            didto.Code_entp = cidiagDO.Code_entp; // 就诊类型编码

            didto.Id_emp_sign = cidiagDO.Id_emp_sign;  // 签署人
            didto.Name_emp_sign = cidiagDO.Signname; // 签署人名称
            didto.Id_dep_sign = cidiagDO.Id_dep_sign; // 签署科室
            didto.Dt_sign = CommonExtentions.NowTime(this); // 签署时间
            didto.Fg_sign = FBoolean.True; // 签署标志
        }

        /// <summary>
        /// 通过Ent4BannerDTO设置DIDTO中主表属性
        /// <para>该方法为未保存过诊断时调用</para>
        /// 
        /// </summary>
        /// <param name="bannerDTO">banner数据</param>
        /// <param name="didto"></param>
        private void setCiDiagDOProperty(Ent4BannerDTO bannerDTO, DIDTO didto)
        {
            DeptDO dept = context.Dept;
            PsnInfo psnInfo = context.PsnInfo;
            DateTime dataTime = CommonExtentions.NowTime(this);

            didto.Id_emp_create = psnInfo.Id_psndoc; // 开立医生 诊断医生 取当前登录人
            didto.Id_emp_create_name = psnInfo.Name; // 开立医生姓名 医生姓名 取当前登录人
            didto.Dt_di = dataTime;  // 诊断时间 (诊断时间与开立时间 Dt_create 重复，暂且都赋值)
            didto.Id_dep_create = dept.Id_dep; // 开立科室
            didto.Id_dep_create_name = dept.Name; // 开立科室名称
            didto.Dt_create = dataTime;  // 开立时间

            didto.Id_dep = dept.Id_dep; // 诊断科室  是否还有用？
            didto.Id_en = bannerDTO.Id_ent; // 就诊id
            didto.Id_pat = bannerDTO.Id_pat; // 患者id
            didto.Id_entp = bannerDTO.Id_entp; // 就诊类型
            didto.Code_entp = bannerDTO.Code_entp; // 就诊类型编码

            didto.Id_emp_sign = psnInfo.Id_psndoc;  // 签署人
            didto.Name_emp_sign = psnInfo.Name; // 签署人名称
            didto.Id_dep_sign = dept.Id_dep;  // 签署科室
            didto.Dt_sign = dataTime; // 签署时间

            didto.Fg_sign = FBoolean.True; // 签署标志
        }

        #endregion
    }
}

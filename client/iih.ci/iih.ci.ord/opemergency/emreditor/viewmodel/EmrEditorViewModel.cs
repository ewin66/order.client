
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.d;
using System.Windows.Forms;
using System.Xml;
using iih.ci.diag.dto.d;
using xap.mw.coreitf.d;
using xap.rui.control.exceptions;
using System.Reflection;
using iih.en.pv.dto.d;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using iih.en.pv.pativisit.i;
using iih.en.pv.pativisit.d;
using iih.bd.bc.udi;
using iih.ci.mr.cimr.i;
using iih.ci.mr.cimr.d;
using iih.ci.ord.ciorder.i;
using iih.ci.diag.cidiag.d;
using iih.ci.diag.cidiag.i;
using xap.rui.control.extentions;

namespace iih.ci.ord.opemergency.emreditor.viewmodel
{
    /// <summary>
    /// <para>描    述 : 病历相关处理接口</para>
    /// <para>说    明 : </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.emreditor.viewmodel    </para>    
    /// <para>类 名 称 :  EmrEditorViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/8/8 16:30:13</para>
    /// <para>更新时间 :  2016/8/8 16:30:13</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmrEditorViewModel
    {
        /// <summary>
        /// 医嘱服务
        /// </summary>
        ICiOrdQryService qryservice;
        /// <summary>
        /// 患者就诊服务
        /// </summary>
        IPativisitCrudService ipativisitCrudService;

        /// <summary>
        /// 临床医疗记录
        /// </summary>
        private ICiemrCrudService iCiemrCrudService;

        private ICiorderMDOCrudService iCiorderMDOCrudService;

        private ICidiagCrudService iCidiagCrudService;

        public EmrEditorViewModel()
        {
            qryservice = XapServiceMgr.find<ICiOrdQryService>();
            ipativisitCrudService = XapServiceMgr.find<IPativisitCrudService>();
            iCiemrCrudService = XapServiceMgr.find<ICiemrCrudService>();
            iCiorderMDOCrudService = XapServiceMgr.find<ICiorderMDOCrudService>();
            iCidiagCrudService = XapServiceMgr.find<ICidiagCrudService>();
        }

        /// <summary>
        /// 根据就诊状态和门诊病历管理模式确定撤回按钮是否可操作
        /// </summary>
        /// <param name="omrMgmtMd">门诊病历管理模式：医生打印=0,病案统一打印=1,无纸化模式=2,医生手写=3</param>
        /// <param name="ent4BannerDTO">banner数据</param>
        /// <returns></returns>
        public bool IsAllowRevoke(string omrMgmtMd, Ent4BannerDTO ent4BannerDTO)
        {
            //判断是否为诊闭状态，如果是未诊闭状态，不可撤回
            if (!EnDictCodeConst.SD_ENSTATUS_OP_FINISH.Equals(ent4BannerDTO.Sd_status))
            {
                return false;
            }

            // 诊闭后omrMgmtMd =0 可撤回，omrMgmtMd=1 如果病历已经打印不可撤回 
            // omrMgmtMd=2 病历不可撤回, 3 占时不考虑先按不可撤回
            switch (omrMgmtMd)
            {
                case "0":
                    return true;
                case "1":
                    // 如果病历已经打印，返回false,不允许撤回;
                    return !isMrPrinted(ent4BannerDTO.Id_ent);
                case "2":
                    return false;
                case "3":
                    break;
            }
            return true;

        }


        /// <summary>
        /// 判断病历是否打印，有一份病历打印就算已经打印
        /// </summary>
        /// <param name="idEn"></param>
        /// <returns></returns>
        private bool isMrPrinted(string idEn)
        {
            bool isPrinted = false;

            // 获取就诊病历
            CiMrDO[] ciMrDOs = this.GetCiMrs(idEn);
            foreach (CiMrDO ciMr in ciMrDOs)
            {
                if (FBoolean.True.Equals(ciMrDOs[0].Fg_prn))
                {
                    isPrinted = true;
                    break;
                }
            }
            return isPrinted;
        }

        public CiMrDO[] GetCiMrs(string idEn)
        {

            string condition = "Id_ent = '" + idEn + "'"; ;
            string orderBy = "Createdtime desc";
            // 病历
            CiMrDO[] ciMrDOs = iCiemrCrudService.find(condition, orderBy, FBoolean.False);
            return ciMrDOs;
        }

        /// <summary>
        /// 判断是否为诊闭状态
        /// </summary>
        /// <param name="ent4BannerDTO"></param>
        /// <returns>true 诊毕，false 未诊毕</returns>
        public bool IsEnFinish(string id_ent)
        {
            if (string.IsNullOrEmpty(id_ent))
            {
                return false;
            }

            // 获取患者就诊对象
            PatiVisitDO PatiVisitDO = ipativisitCrudService.findById(id_ent);

            // 非诊闭状态是，撤回按钮不可用
            if (PatiVisitDO.Sd_status == EnDictCodeConst.SD_ENSTATUS_OP_FINISH)
            {
                return true;
            }
            return false;
        }

        public CiOrderDO[] GetCiOrderDOs(string id_ent)
        {
            string condition = String.Format("id_en='{0}' and fg_sign='Y'", id_ent);
            return iCiorderMDOCrudService.find(condition, "", FBoolean.False);
        }

        public DIDTO[] GetDIDTO(string id_ent)
        {
            string condition = String.Format("dt_di=(select max(DI.dt_di) from ci_di DI where DI.id_en='{0}')", id_ent);
            CidiagAggDO[] diagAggDO = iCidiagCrudService.find(condition, "", FBoolean.False);
            List<DIDTO> didtoList = new List<DIDTO>();
            if (diagAggDO.Length <= 0)
            {
                return didtoList.ToArray();
            }
            CiDiagDO cidiagDO = diagAggDO[0].getParentDO();
            CiDiagItemDO[] ciDiagItemDOs = diagAggDO[0].getCiDiagItemDO();



            foreach (CiDiagItemDO itemDO in ciDiagItemDOs)
            {
                DIDTO didto = new DIDTO();

                this.setCiDiagItemProperty(itemDO, didto);
                this.setCiDiagDOProperty(cidiagDO, didto);

                didto.Id_diitm = itemDO.Id_diitm; // 子表主键
                didto.Fg_majdi = itemDO.Fg_majdi; // 主诊断标识
                didto.Sortno = (Convert.ToInt32(itemDO.Sortno) + 1).ToString();// 通过记录数，设置诊断的排序号

                didtoList.Add(didto);
            }
            return didtoList.ToArray();

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

            didto.Id_di = cidiagDO.Id_di; // 诊断主表id

            didto.Id_emp_create = cidiagDO.Id_emp_create; // 开立医生 诊断医生 取当前登录人
            didto.Id_emp_create_name = cidiagDO.Empname; // 开立医生姓名 医生姓名 取当前登录人
            didto.Dt_di = CommonExtentions.NowTime(this); ; // 诊断时间 当前时间
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
            didto.Dt_sign = cidiagDO.Dt_sign; // 签署时间
            didto.Fg_sign = FBoolean.True; // 签署标志
        }

    }
}

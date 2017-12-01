using System;
using System.Collections.Generic;
using iih.en.pv.dto.d;
using iih.en.pv.ci.d;
using iih.en.pv.ci.i;
using iih.en.pv.entdi.d;
using xap.mw.serviceframework;
using xap.mw.coreitf.d;
using iih.bd.bc.udi;
using xap.sys.bdfw.bbd.d;
using xap.rui.engine;
using xap.rui.control.extentions;
using iih.ci.ord.i;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.ems.dp;

namespace iih.ci.ord.opemergency.medreferral.model
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.medreferral.model    </para>    
    /// <para>类 名 称 :  CiMedReferralViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  vivi         				</para> 
    /// <para>修 改 人 :  vivi         				</para> 
    /// <para>创建时间 :  10/21/2016 10:35:40 AM             </para>
    /// <para>更新时间 :  10/21/2016 10:35:40 AM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class CiMedReferralViewModel : BaseBizViewModel
    {
        private new BaseContext context;
        private MedReferralDO medReferralDO;

        public MedReferralDO MedReferralDO
        {
            get
            {
                return medReferralDO;
            }
            set 
            {
                medReferralDO = value;
            }
        }

        #region 构造函数
        public CiMedReferralViewModel(BaseContext c, Ent4BannerDTO e)
        {
            this.context = c;
            this.SetEnt4BannerDTO(e);

            medReferralDO = new MedReferralDO();
        }
        #endregion

        public override object GetFormDataSource()
        {
            return medReferralDO;
        }

        public void Reload()
        {
            IMedreferralCrudService service = XapServiceMgr.find<IMedreferralCrudService>();
            if (service != null && this.GetEnt4BannerDTO() != null) {
                MedReferralDO[] szMedReferralDO = service.find(" id_ent='" + this.GetEnt4BannerDTO().Id_ent + "'", "sv desc", false);
                if (szMedReferralDO != null)  {
                    if (szMedReferralDO.Length > 0) {
                        this.logicEx.CopyTo<MedReferralDO>(szMedReferralDO[0], medReferralDO);
                    }
                    else {
                        FromEnt4BannerDTO(this.GetEnt4BannerDTO());
                    }
                }
            }
        }

        private void FromEnt4BannerDTO(Ent4BannerDTO e)
        {
            medReferralDO.Id_grp = context.Group.Id_grp;
            medReferralDO.Id_org = context.Org.Id_org;
            medReferralDO.Id_pat = e.Id_pat;
            medReferralDO.Name_pat = e.Name_pat;
            medReferralDO.Id_ent = e.Id_ent;
            medReferralDO.Code_ent = e.Code_ent;
            medReferralDO.Code_entp = e.Code_entp;
            //medReferralDO.Id_di
            //medReferralDO.Name_di
            //medReferralDO.Id_diitm
            //medReferralDO.Str_code_di
            medReferralDO.Str_name_di = getDiInfo(e.Id_ent);
            medReferralDO.Id_sex = e.Sd_sex.Equals(PiDictCodeConst.SD_SEX_MALE) ? PiDictCodeConst.ID_SEX_MALE : (e.Sd_sex.Equals(PiDictCodeConst.SD_SEX_FEMALE) ? PiDictCodeConst.ID_SEX_FEMALE : PiDictCodeConst.ID_SEX_UNEXPLAIN);
            medReferralDO.Sd_sex = e.Name_sex;
            //int nAge = FromAgeString(e.Age);
            //medReferralDO.Age = (-1 != nAge ? nAge : 0);
            medReferralDO.Age = e.Age;
            medReferralDO.Ido = e.Id_code;
            medReferralDO.Id_dep = e.Id_dep_phy;
            medReferralDO.Name_dep = e.Name_dep_phy;
            medReferralDO.Dt_acpt = e.Dt_acpt;
            medReferralDO.Dt_end = e.Dt_end;
            //medReferralDO.Code_org_referral2
            //medReferralDO.Name_org_referral2
            //medReferralDO.Reason_referral
            //medReferralDO.Des_initialdiag
            //medReferralDO.Des_question
            //medReferralDO.Diagtreatment
            //medReferralDO.Id_referraltp
            //medReferralDO.Sd_referraltp
            medReferralDO.Dt_referralperiodbegin = CommonExtentions.NowTime(this);
            medReferralDO.Dt_referralperiodend = CommonExtentions.NowTime(this).AddDays(1);
            medReferralDO.Id_emp = e.Id_emp_phy;
            medReferralDO.Name_emp = e.Name_emp_phy;
            medReferralDO.Dt_open = CommonExtentions.NowTime(this);
            medReferralDO.Times_print = 0;
            medReferralDO.Fg_seal = FBoolean.False;
            medReferralDO.Address = e.Address;
        }

        private string getDiInfo(string id_ent)
        {
            string str = "";
            ICiOrdQryService ciOrdQryService = XapServiceMgr.find<ICiOrdQryService>();
            EntDiDO[] entDiDOs = ciOrdQryService.getEntDiDOList(id_ent);
            if (entDiDOs != null && entDiDOs.Length > 0)
            {
                int i = 1;
                foreach (EntDiDO item in entDiDOs)
                {
                    str += i + "." + item.Name_didef_dis;
                    if (item.Fg_suspdi!=null && item.Fg_suspdi.Value)
                    {
                        str += "?";
                    }
                    if (item.Supplement != null && item.Supplement.Length > 0)
                    {
                        str += "——" + item.Supplement;
                    }
                    str += "；";
                    i++;
                }
                str = str.Substring(0, str.LastIndexOf('；'));
            }

            return str;
        }

        public int? GetPrintNum()
        {
            return medReferralDO.Times_print;
        }
    }
}

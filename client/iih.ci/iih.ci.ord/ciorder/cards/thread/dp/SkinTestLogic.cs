using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.appfw;
using xap.rui.control.forms.control;
using xap.cli.sdk.controls.DataView.Base;
using xap.rui.control.basecontrol;
using iih.ci.ord.ciordems.d;
using iih.en.pv.dto.d;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using iih.ci.ord.dto.d;
using xap.rui.control.extentions;
using iih.ci.ord.ciorder.cards.extend;
using System.Windows.Forms;
using iih.bd.bc.udi;
using xap.cli.context;
using xap.cli.sdk.controls.navbar;
using xap.mw.coreitf.d;
/********************************************************************************

** 作者： 张万青

** 创始时间：

** 修改人：张万青

** 修改时间：2016-6-30

** 描述：皮试逻辑判断控件


*********************************************************************************/
namespace iih.ci.ord.cards.thread.dp
{
    class SkinTestLogic
    {
        private Ent4BannerDTO PatInfo;
        private ICiOrdQryService qryService;
        public SkinTestLogic(Ent4BannerDTO PatInfo)
        {
            this.PatInfo = PatInfo;
            qryService = XapServiceMgr.find<ICiOrdQryService>();
        }
        public string skinTestLogic(EmsOrDrug drug, Control owner=null)
        {
            SkinTestParamDTO param = new SkinTestParamDTO();
            param.Id_mm = drug.Id_mm;
            param.Id_org = UserManager.getInstance().CurrentOrg.Id_org; 
            param.Id_pi = PatInfo.Id_pat;
            param.Dt_birth = DateTime.Parse(PatInfo.Dt_birth);
            param.Id_srv = drug.Id_srv;
            param.Id_skinsrv = drug.Id_srvskin;
            SkinTestRstDTO retDTO = qryService.skinTestLogicMainBP(param);

            return CheckSkinTestRst(drug, retDTO, owner);      
        }

        /// <summary>
        /// 根据皮试逻辑结果判断是否可进行皮试
        /// </summary>
        /// <param name="drug">物品对象</param>
        /// <param name="skinTestRst">皮试结果</param>
        /// <param name="owner"></param>
        /// <returns></returns>
        public string CheckSkinTestRst(EmsOrDrug drug, SkinTestRstDTO skinTestRst, Control owner = null)
        {           
            string code = skinTestRst.Allergicpharmhandlemode.ToString();
            //禁用
            if (code.Equals("0"))
            {
                this.ShowInfo("患者于" + (skinTestRst.Dt_act==null?"":skinTestRst.Dt_act.ToTarget.ToString("yyyy-MM-dd")) + "对" + drug.Name_mm + "过敏！");
                drug.Id_mm = null;
                drug.Name_mm = null;
            }//再皮试1;皮试逻辑，3
            else if (code.Equals("1") || code.Equals("3"))
            {
                drug.Sd_reltp = CiDictCodeConst.CODE_SKIN_SKIN;
                drug.Fg_skintest = true;
            }//强制使用2
            else if (code.Equals("2"))
            {
                SkinTestForm skinFrom = new SkinTestForm(drug, skinTestRst.Dt_act);
                if (owner != null)
                {
                    if (owner.FindForm() != null && owner.FindForm() is TabNavigatorForm)
                    {
                        (owner.FindForm() as TabNavigatorForm).OnFocused = true;
                    }
                    if (skinFrom.ShowDialog(owner) == DialogResult.OK)
                    {
                        drug.Sd_reltp = CiDictCodeConst.CODE_SKIN_FORCEUSE;
                        drug.Fg_skintest = false;
                    }
                    else
                    {
                        return "9";//禁用了
                    }
                }
                else
                {
                    if (skinFrom.ShowDialog() == DialogResult.OK)
                    {
                        drug.Sd_reltp = CiDictCodeConst.CODE_SKIN_FORCEUSE;
                        drug.Fg_skintest = false;
                    }
                    else
                    {
                        return "9";//禁用了
                    }
                }

            }//直接使用，不皮试4
            else if (code.Equals("4"))
            {
                drug.Sd_reltp = CiDictCodeConst.CODE_SKIN_FORCEUSE;
                drug.Fg_skintest = false;
            }//测试了，未出结果5
            else if (code.Equals("5"))
            {
                drug.Sd_reltp = CiDictCodeConst.CODE_SKIN_NORESULT;
                drug.Fg_skintest = true;
                drug.Id_or_rel = skinTestRst.Id_skinor;
            }
            return code;
        }

    }
}

using iih.ci.ord.opemergency.view.basic;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.ems.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.common.utils;
using iih.ci.ord.ems.d;
using iih.en.pv.dto.d;
using iih.en.pv.dto.d;
using xap.cli.sdk.render.labelcontrol;

namespace iih.ci.ord.opemergency.ems.common
{
    /// <summary>
    /// 医疗单选项卡基类
    /// </summary>
    public class BaseEmsFormView : BaseEmsView
    {
        public BaseEmsFormView()
        {

        }

        public BaseEmsFormView(IEventDelegate owner)
            : base(owner)
        {

        }

        protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            object emsObj = this.GetViewModel().GetEmsUIDTO();
            if (emsObj != null)
            {
                EmsUIDTO emsUiDto = emsObj as EmsUIDTO;
                if (emsUiDto.PatInfo != null)
                {
                    if (isHideSelfpay(emsUiDto.PatInfo))
                    {
                        if (this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_selfpay") != null)
                        {
                            (this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_selfpay") as
                                XLabelBaseUserRender).Visible = false;
                        }


                    }
                    else
                    {
                        //医保共享验证
                        CiEnContextDTO ciEnContextDto = CiEnContextUtil.GetCiEnContext(emsUiDto.PatInfo, EmsAppModeEnum.SVEMSAPPMODE, this.Context);//诊断是否保外的
                        if (ciEnContextDto.Eu_hpbeyond == HpBeyondEnum.HPEXTERNALDIAG)
                        {
                            if (this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_selfpay") != null)
                            {
                                (this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_selfpay") as
                                XLabelBaseUserRender).Checked = true;
                               (this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_selfpay") as
                                    XLabelBaseUserRender).Enabled = false;
                            }
                        }
                    }
                }
            }
        }
    }
}

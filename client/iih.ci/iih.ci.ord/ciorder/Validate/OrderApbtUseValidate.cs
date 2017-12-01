using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using xap.rui.control.extentions;

using iih.ci.ord.ciordems.d;


namespace iih.ci.ord.ciorder.Validate
{
    class OrderApbtUseValidate : IValidate
    {
        public bool OrdValivate(EmsUIDTO uiDto, CiorderBaseControl ci)
        {


            bool flag = true;
            #region 校验是否选择了备血申请
            if (uiDto.CiordubDTO == null)
            {
                ci.OrdErrorList.Add("备血申请不存在，请先开立备血申请！");

                flag = false;
            }
            #endregion
            #region 校验用血量
            if (uiDto.CiordubDTO!=null&&(uiDto.CiordubDTO.Quan_medu_ub <= 0 ||
                uiDto.CiordubDTO.Quan_medu_ub > uiDto.CiordubDTO.Num_margin_bu))
            {

                ci.OrdErrorList.Add("本次用血量的值无效！");

                flag = false;
            }
            #endregion

            return flag;
        }
    }
}

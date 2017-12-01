using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder;
using xap.rui.control.basecontrol;

namespace iih.ci.ord.newconfirm.view.baseview
{
    public class FeeInpputBaseView : CiorderBaseControl
    {
       //当前编辑的医嘱
       public OrConfirm orcofirmN;

       #region 公有方法接口
       
       // 判断该界面是否有修改
         
       public virtual bool IsCancel()
       {
           return false;
       }
      // 清空补费界面
       public virtual void CancelFee()
       {
          
       }
       #endregion
    }
}

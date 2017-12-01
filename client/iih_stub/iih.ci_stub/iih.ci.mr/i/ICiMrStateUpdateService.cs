using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.iih.ci.mr.i
{
    public interface ICiMrStateUpdateService
    {
        /**
	 * 根据id_ent更新病历的提交（ci_mr表）、归档(ci_amr表)状态
	 * @param id_ent
	 */
	   void UpdateSubmitAndPigeonholeStateByIdEnt(string id_ent) ;
    }
}

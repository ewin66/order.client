
using iih.ci.ord.dto.emsmain.tmpl;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.i
{
    public interface ICiTmplMainService
    {
        /**
	 * 加载模板
	 * @param ems
	 * @return
	 */
        TmplRstDTO load(TmplLoadDTO ems);



        /**
         * 保存模板
         * @param ems
         * @return
         */
        TmplRstDTO save(TmplSaveDTO ems);
    }
}

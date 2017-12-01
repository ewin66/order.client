using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.ord_stub.dto.d
{
    public class IpViewDiagDTO : BaseDTO
    {
        public IpViewDiagDTO()
        {
        }

        public string Sortno
        {
            get { return getAttrVal<string>("Sortno", null); }
            set { setAttrVal<string>("Sortno", value); }
        }

        /// <summary>
        /// 医嘱备注
        /// </summary>
        public string name
        {
            get { return getAttrVal<string>("name", null); }
            set { setAttrVal<string>("name", value); }
        }

            public override string[] getAttrNames()
        {
            return new string[] { "Sortno", "name" };
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.d.IpViewDiagDTO";
        }
    }
}

using xap.mw.core.data;
using iih.ci.iih.ci.ord.ciordems.d;

namespace iih.ci.ord.ciordems.d
{
    public partial class EmsOpitemDO :OrCommonFieldsDTO
    {
        public string Id_apop
        {
             get { return getAttrVal<string>("Id_orop", null); }
             set { setAttrVal<string>("Id_orop", value); }
        }
    }
}

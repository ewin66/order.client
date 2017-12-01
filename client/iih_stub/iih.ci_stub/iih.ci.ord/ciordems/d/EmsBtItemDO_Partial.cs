using xap.mw.core.data;
using xap.mw.coreitf.d;
using iih.ci.iih.ci.ord.ciordems.d;

namespace iih.ci.ord.ciordems.d
{
    public partial class EmsBtItemDO : OrCommonFieldsDTO
    {
        public bool? Fg_or
        {
            get { return getAttrVal<FBoolean>("Fg_or", null); }
            set { setAttrVal<FBoolean>("Fg_or", value); }
        }

        public bool? Fg_mm
        {
            get { return getAttrVal<FBoolean>("Fg_mm", null); }
            set { setAttrVal<FBoolean>("Fg_mm", value); }
        }

        public bool? Fg_bl
        {
            get { return getAttrVal<FBoolean>("Fg_bl", null); }
            set { setAttrVal<FBoolean>("Fg_bl", value); }
        }
    }
}

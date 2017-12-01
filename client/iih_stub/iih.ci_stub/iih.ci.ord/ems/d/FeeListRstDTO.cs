using iih.ci.ord.dto.emsmain;
using xap.mw.core.data;

namespace iih.ci.ord.ems.d
{
    public class FeeListRstDTO : BaseCiDTO
    {

        public FArrayList ErrorEmsList
        {
            get { return getAttrVal<FArrayList>("ErrorEmsList", null); }
            set { setAttrVal<FArrayList>("ErrorEmsList", value); }
        }

    }
}

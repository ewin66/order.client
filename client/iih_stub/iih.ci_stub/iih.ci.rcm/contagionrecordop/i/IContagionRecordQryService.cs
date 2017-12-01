using iih.ci.rcm.contagionrecordop.d;
using xap.mw.core.data;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.rcm.contagionrecordop.i
{
    public interface IContagionRecordQryService {
        PagingRtnData<ContagionRecordOpDTO> getOpContagionQryDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);

        ContagionRecordOpDTO[] GetAllPageData();
    }
}

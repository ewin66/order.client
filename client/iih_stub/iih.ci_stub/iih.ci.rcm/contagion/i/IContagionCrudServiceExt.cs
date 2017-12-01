using System;
using System.Data;

using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.rcm.contagion.d;
using iih.ci.rcm.contagion.dto;
using iih.ci.rcm.contagion.dto.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.rcm.contagion.i
{
    public interface IContagionCrudServiceExt
    {

        Contagiondto[] getCotagions(String id_ent);
        Contagiondto[] getCotagionlist(String id_ent);
        Contagiondto[] getChildCotagions(String p_id);
        EntDto[] getEnts(QryRootNodeDTO qryRootNodeDTO);
        EntDto[] getEnts2(QryRootNodeDTO qryRootNodeDTO);

        PagingRtnData<EntDto> getEntDTOList(
        QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
        EntDto[] GetAllPageData();

    }
}

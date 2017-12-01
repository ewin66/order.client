using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mrqc.outqapatlist.d;
using iih.ci.mrqc.qrydto.d;
using xap.mw.core.data;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.iih.ci.mrqc.outqapatlist.i
{
    public interface IOutQaPatListQryService
    {
        //获取门诊质控患者列表
        PagingRtnData<OutQaPatListDTO> getOutQaPatListDtos(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
        //获取门诊抽查患者列表
        PagingRtnData<OutQaPatListDTO> getOutQaToRandomPatListDtos(OutQaPatQryDTO qryDTO, PaginationInfo paginationInfo);
        //获取门诊已抽查患者列表
        PagingRtnData<OutQaPatListDTO> getOutQaHasRandomPatListDtos(OutQaPatQryDTO qryDTO, PaginationInfo paginationInfo);
        //获取门诊待审核患者列表
        PagingRtnData<OutQaPatListDTO> getOutQaTracePatListDtos(OutQaPatQryDTO qryDTO, PaginationInfo paginationInfo);
    }
}

using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.ciord.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.ciord.i
{
    public interface ICiorsrvagentCrudService
    {
        void delete(OrSrvAgentInfoDO[] dos);
        OrSrvAgentInfoDO[] insert(OrSrvAgentInfoDO[] dos);
        OrSrvAgentInfoDO[] save(OrSrvAgentInfoDO[] dos);
        OrSrvAgentInfoDO[] update(OrSrvAgentInfoDO[] dos);
        void logicDelete(OrSrvAgentInfoDO[] dos);
        OrSrvAgentInfoDO findById(String id);
        OrSrvAgentInfoDO[] findByIds(String[] ids, FBoolean isLazy);
        OrSrvAgentInfoDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrSrvAgentInfoDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrSrvAgentInfoDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrSrvAgentInfoDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrSrvAgentInfoDO[] enableWithoutFilter(OrSrvAgentInfoDO[] dos) ;
	    DOWithErrLog enableDO(OrSrvAgentInfoDO[] dos) ;
	    OrSrvAgentInfoDO[] disableVOWithoutFilter(OrSrvAgentInfoDO[] dos);
	    DOWithErrLog disableDO(OrSrvAgentInfoDO[] dos) ;
	    PagingRtnData<OrSrvAgentInfoDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    OrSrvAgentInfoDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrSrvAgentInfoDO[] findByAttrValString(String attr, String value);
	    OrSrvAgentInfoDO[] findByAttrValStrings(String attr, String[] values);
	    OrSrvAgentInfoDO[] findByAttrValList(String attr, FArrayList values);
    }
}

using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.pre.obspre.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.pre.obspre.i
{
    public interface IObspredoCrudService
    {
        void delete(ObspredoAggDO[] dos);
        ObspredoAggDO[] insert(ObspredoAggDO[] dos);
        ObspredoAggDO[] save(ObspredoAggDO[] dos);
        ObspredoAggDO[] update(ObspredoAggDO[] dos);
        void logicDelete(ObspredoAggDO[] dos);
        ObspredoAggDO findById(String id);
        ObspredoAggDO[] findByIds(String[] ids, FBoolean isLazy);
        ObspredoAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        ObspredoAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        ObspredoAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<ObspredoAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy); 
	    ObspredoAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
    }
}

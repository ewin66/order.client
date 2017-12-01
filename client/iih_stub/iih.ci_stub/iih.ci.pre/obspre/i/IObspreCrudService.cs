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
    public interface IObspreCrudService
    {
        void delete(ObspreAggDO[] dos);
        ObspreAggDO[] insert(ObspreAggDO[] dos);
        ObspreAggDO[] save(ObspreAggDO[] dos);
        ObspreAggDO[] update(ObspreAggDO[] dos);
        void logicDelete(ObspreAggDO[] dos);
        ObspreAggDO findById(String id);
        ObspreAggDO[] findByIds(String[] ids, FBoolean isLazy);
        ObspreAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        ObspreAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        ObspreAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<ObspreAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy); 
	    ObspreAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
    }
}

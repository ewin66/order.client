using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrqc.qaflt.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrqc.qaflt.i
{
    public interface IQafltCrudService
    {
        void delete(QaFltDO[] dos);
        QaFltDO[] insert(QaFltDO[] dos);
        QaFltDO[] save(QaFltDO[] dos);
        QaFltDO[] update(QaFltDO[] dos);
        void logicDelete(QaFltDO[] dos);
        QaFltDO findById(String id);
        QaFltDO[] findByIds(String[] ids, FBoolean isLazy);
        QaFltDO[] findByBIds(String[] ids, FBoolean isLazy);
        QaFltDO[] find(String condition, string orderStr, FBoolean isLazy);
        QaFltDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<QaFltDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    QaFltDO[] enableWithoutFilter(QaFltDO[] dos) ;
	    DOWithErrLog enableDO(QaFltDO[] dos) ;
	    QaFltDO[] disableVOWithoutFilter(QaFltDO[] dos);
	    DOWithErrLog disableDO(QaFltDO[] dos) ;
	    PagingRtnData<QaFltDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    QaFltDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    QaFltDO[] findByAttrValString(String attr, String value);
	    QaFltDO[] findByAttrValStrings(String attr, String[] values);
	    QaFltDO[] findByAttrValList(String attr, FArrayList values);
    }
}

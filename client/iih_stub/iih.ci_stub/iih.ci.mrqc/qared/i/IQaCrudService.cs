using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrqc.qared.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrqc.qared.i
{
    public interface IQaCrudService
    {
        void delete(QaRecordDO[] dos);
        QaRecordDO[] insert(QaRecordDO[] dos);
        QaRecordDO[] save(QaRecordDO[] dos);
        QaRecordDO[] update(QaRecordDO[] dos);
        void logicDelete(QaRecordDO[] dos);
        QaRecordDO findById(String id);
        QaRecordDO[] findByIds(String[] ids, FBoolean isLazy);
        QaRecordDO[] findByBIds(String[] ids, FBoolean isLazy);
        QaRecordDO[] find(String condition, string orderStr, FBoolean isLazy);
        QaRecordDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<QaRecordDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    QaRecordDO[] enableWithoutFilter(QaRecordDO[] dos) ;
	    DOWithErrLog enableDO(QaRecordDO[] dos) ;
	    QaRecordDO[] disableVOWithoutFilter(QaRecordDO[] dos);
	    DOWithErrLog disableDO(QaRecordDO[] dos) ;
	    PagingRtnData<QaRecordDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    QaRecordDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    QaRecordDO[] findByAttrValString(String attr, String value);
	    QaRecordDO[] findByAttrValStrings(String attr, String[] values);
	    QaRecordDO[] findByAttrValList(String attr, FArrayList values);
    }
}
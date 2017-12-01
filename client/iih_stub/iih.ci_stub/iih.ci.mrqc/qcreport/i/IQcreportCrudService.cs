using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrqc.qcreport.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrqc.qcreport.i
{
    public interface IQcreportCrudService
    {
        void delete(QcReportDO[] dos);
        QcReportDO[] insert(QcReportDO[] dos);
        QcReportDO[] save(QcReportDO[] dos);
        QcReportDO[] update(QcReportDO[] dos);
        void logicDelete(QcReportDO[] dos);
        QcReportDO findById(String id);
        QcReportDO[] findByIds(String[] ids, FBoolean isLazy);
        QcReportDO[] findByBIds(String[] ids, FBoolean isLazy);
        QcReportDO[] find(String condition, string orderStr, FBoolean isLazy);
        QcReportDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<QcReportDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    QcReportDO[] enableWithoutFilter(QcReportDO[] dos) ;
	    DOWithErrLog enableDO(QcReportDO[] dos) ;
	    QcReportDO[] disableVOWithoutFilter(QcReportDO[] dos);
	    DOWithErrLog disableDO(QcReportDO[] dos) ;
	    QcReportDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    QcReportDO[] findByAttrValString(String attr, String value);
	    QcReportDO[] findByAttrValStrings(String attr, String[] values);
	    QcReportDO[] findByAttrValList(String attr, FArrayList values);
    }
}

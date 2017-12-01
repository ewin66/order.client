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
    public interface IQcreportgrpCrudService
    {
        void delete(QcReportGrpDO[] dos);
        QcReportGrpDO[] insert(QcReportGrpDO[] dos);
        QcReportGrpDO[] save(QcReportGrpDO[] dos);
        QcReportGrpDO[] update(QcReportGrpDO[] dos);
        void logicDelete(QcReportGrpDO[] dos);
        QcReportGrpDO findById(String id);
        QcReportGrpDO[] findByIds(String[] ids, FBoolean isLazy);
        QcReportGrpDO[] findByBIds(String[] ids, FBoolean isLazy);
        QcReportGrpDO[] find(String condition, string orderStr, FBoolean isLazy);
        QcReportGrpDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<QcReportGrpDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    QcReportGrpDO[] enableWithoutFilter(QcReportGrpDO[] dos) ;
	    DOWithErrLog enableDO(QcReportGrpDO[] dos) ;
	    QcReportGrpDO[] disableVOWithoutFilter(QcReportGrpDO[] dos);
	    DOWithErrLog disableDO(QcReportGrpDO[] dos) ;
	    QcReportGrpDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    QcReportGrpDO[] findByAttrValString(String attr, String value);
	    QcReportGrpDO[] findByAttrValStrings(String attr, String[] values);
	    QcReportGrpDO[] findByAttrValList(String attr, FArrayList values);
    }
}

using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data;
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrqc.cimrrecall.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrqc.cimrrecall.i
{
    public interface ICimrrecallCrudService
    {
        void delete(CiMrRecallDO[] dos);
        CiMrRecallDO[] insert(CiMrRecallDO[] dos);
        CiMrRecallDO[] save(CiMrRecallDO[] dos);
        CiMrRecallDO[] update(CiMrRecallDO[] dos);
        void logicDelete(CiMrRecallDO[] dos);
        CiMrRecallDO findById(String id);
        CiMrRecallDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrRecallDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrRecallDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrRecallDO[] findByBDMode(String whereStr, string orderStr, FBoolean isLazy);
        CiMrRecallDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrRecallDO> findByPageInfo(PaginationInfo pg, String wherePart, String orderByPart);
        PagingRtnData<CiMrRecallDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr, String orderStr);
        CiMrRecallDO[] enableWithoutFilter(CiMrRecallDO[] dos);
        DOWithErrLog enableDO(CiMrRecallDO[] dos);
        CiMrRecallDO[] disableVOWithoutFilter(CiMrRecallDO[] dos);
        DOWithErrLog disableDO(CiMrRecallDO[] dos);
        PagingRtnData<CiMrRecallDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg);
        CiMrRecallDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO, String orderStr, FBoolean isLazy);
        CiMrRecallDO[] findByAttrValString(String attr, String value);
        CiMrRecallDO[] findByAttrValStrings(String attr, String[] values);
        CiMrRecallDO[] findByAttrValList(String attr, FArrayList values);
    }
}
using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrqc.mrborrowapply.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrqc.mrborrowapply.i
{
    public interface IMrborrowapplyCrudService
    {
        void delete(AmrBorrowApplyDO[] dos);
        AmrBorrowApplyDO[] insert(AmrBorrowApplyDO[] dos);
        AmrBorrowApplyDO[] save(AmrBorrowApplyDO[] dos);
        AmrBorrowApplyDO[] update(AmrBorrowApplyDO[] dos);
        void logicDelete(AmrBorrowApplyDO[] dos);
        AmrBorrowApplyDO findById(String id);
        AmrBorrowApplyDO[] findByIds(String[] ids, FBoolean isLazy);
        AmrBorrowApplyDO[] findByBIds(String[] ids, FBoolean isLazy);
        AmrBorrowApplyDO[] find(String condition, string orderStr, FBoolean isLazy);
        AmrBorrowApplyDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<AmrBorrowApplyDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    AmrBorrowApplyDO[] enableWithoutFilter(AmrBorrowApplyDO[] dos) ;
	    DOWithErrLog enableDO(AmrBorrowApplyDO[] dos) ;
	    AmrBorrowApplyDO[] disableVOWithoutFilter(AmrBorrowApplyDO[] dos);
	    DOWithErrLog disableDO(AmrBorrowApplyDO[] dos) ;
	    PagingRtnData<AmrBorrowApplyDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    AmrBorrowApplyDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    AmrBorrowApplyDO[] findByAttrValString(String attr, String value);
	    AmrBorrowApplyDO[] findByAttrValStrings(String attr, String[] values);
	    AmrBorrowApplyDO[] findByAttrValList(String attr, FArrayList values);
    }
}

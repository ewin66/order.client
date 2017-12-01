using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.birthrec.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.birthrec.i
{
    public interface IBirthrecCrudService
    {
        void delete(BirthrecAggDO[] dos);
        BirthrecAggDO[] insert(BirthrecAggDO[] dos);
        BirthrecAggDO[] save(BirthrecAggDO[] dos);
        BirthrecAggDO[] update(BirthrecAggDO[] dos);
        void logicDelete(BirthrecAggDO[] dos);
        BirthrecAggDO findById(String id);
        BirthrecAggDO[] findByIds(String[] ids, FBoolean isLazy);
        BirthrecAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        BirthrecAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        BirthrecAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        BirthrecAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<BirthrecAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<BirthrecAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<BirthrecAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(BirthrecInfoDO[] mainDos);
		void logicDeleteByParentDO(BirthrecInfoDO[] mainDos);
	    BirthrecAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    BirthrecAggDO[] findByAttrValString(String attr, String value);
	    BirthrecAggDO[] findByAttrValStrings(String attr, String[] values);
	    BirthrecAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}
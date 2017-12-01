using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.opernurecord.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.opernurecord.i
{
    public interface IOpernurecordCrudService
    {
        void delete(OpernurecordAggDO[] dos);
        OpernurecordAggDO[] insert(OpernurecordAggDO[] dos);
        OpernurecordAggDO[] save(OpernurecordAggDO[] dos);
        OpernurecordAggDO[] update(OpernurecordAggDO[] dos);
        void logicDelete(OpernurecordAggDO[] dos);
        OpernurecordAggDO findById(String id);
        OpernurecordAggDO[] findByIds(String[] ids, FBoolean isLazy);
        OpernurecordAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        OpernurecordAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        OpernurecordAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        OpernurecordAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<OpernurecordAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<OpernurecordAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<OpernurecordAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(OperNuRecordDO[] mainDos);
		void logicDeleteByParentDO(OperNuRecordDO[] mainDos);
	    OpernurecordAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OpernurecordAggDO[] findByAttrValString(String attr, String value);
	    OpernurecordAggDO[] findByAttrValStrings(String attr, String[] values);
	    OpernurecordAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}
using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.antenatalassess.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.antenatalassess.i
{
    public interface IAntenatalassessCrudService
    {
        void delete(AntenatalassessAggDO[] dos);
        AntenatalassessAggDO[] insert(AntenatalassessAggDO[] dos);
        AntenatalassessAggDO[] save(AntenatalassessAggDO[] dos);
        AntenatalassessAggDO[] update(AntenatalassessAggDO[] dos);
        void logicDelete(AntenatalassessAggDO[] dos);
        AntenatalassessAggDO findById(String id);
        AntenatalassessAggDO[] findByIds(String[] ids, FBoolean isLazy);
        AntenatalassessAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        AntenatalassessAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        AntenatalassessAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        AntenatalassessAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<AntenatalassessAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<AntenatalassessAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<AntenatalassessAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(AntenAssDO[] mainDos);
		void logicDeleteByParentDO(AntenAssDO[] mainDos);
	    AntenatalassessAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    AntenatalassessAggDO[] findByAttrValString(String attr, String value);
	    AntenatalassessAggDO[] findByAttrValStrings(String attr, String[] values);
	    AntenatalassessAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}
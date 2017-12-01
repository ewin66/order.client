using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.rcm.drugsinfo.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.rcm.drugsinfo.i
{
    public interface IDrugsensitiinfoCrudService
    {
        void delete(DrugSensitiInfoDO[] dos);
        DrugSensitiInfoDO[] insert(DrugSensitiInfoDO[] dos);
        DrugSensitiInfoDO[] save(DrugSensitiInfoDO[] dos);
        DrugSensitiInfoDO[] update(DrugSensitiInfoDO[] dos);
        void logicDelete(DrugSensitiInfoDO[] dos);
        DrugSensitiInfoDO findById(String id);
        DrugSensitiInfoDO[] findByIds(String[] ids, FBoolean isLazy);
        DrugSensitiInfoDO[] findByBIds(String[] ids, FBoolean isLazy);
        DrugSensitiInfoDO[] find(String condition, string orderStr, FBoolean isLazy);
        DrugSensitiInfoDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<DrugSensitiInfoDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    DrugSensitiInfoDO[] enableWithoutFilter(DrugSensitiInfoDO[] dos) ;
	    DOWithErrLog enableDO(DrugSensitiInfoDO[] dos) ;
	    DrugSensitiInfoDO[] disableVOWithoutFilter(DrugSensitiInfoDO[] dos);
	    DOWithErrLog disableDO(DrugSensitiInfoDO[] dos) ;
	    PagingRtnData<DrugSensitiInfoDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    DrugSensitiInfoDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    DrugSensitiInfoDO[] findByAttrValString(String attr, String value);
	    DrugSensitiInfoDO[] findByAttrValStrings(String attr, String[] values);
	    DrugSensitiInfoDO[] findByAttrValList(String attr, FArrayList values);
    }
}

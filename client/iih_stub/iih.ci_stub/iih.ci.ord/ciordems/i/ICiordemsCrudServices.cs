using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.coreitf.d;
using iih.ci.ord.ciordems.d;
using xap.mw.core.data;
using iih.ci.ord.ems.d;

namespace iih.ci.ord_stub.ciordems.i
{
   public interface ICiordemsCrudServices
    {
       void delete(EmsUIDTO[] dos,EmsType orderType);
       EmsUIDTO[] insert(EmsUIDTO[] dos, EmsType orderType);
       EmsUIDTO[] save(EmsUIDTO[] dos, EmsType orderType);
       EmsUIDTO[] update(EmsUIDTO[] dos, EmsType orderType);
       void logicDelete(EmsUIDTO[] dos, EmsType orderType);
       EmsUIDTO findById(String id, EmsType orderType);
       //EmsUIDTO[] findByIds(String[] ids, FBoolean isLazy);
       //EmsUIDTO[] findByBIds(String[] ids, FBoolean isLazy);
       EmsUIDTO[] find(String condition, string orderStr ,EmsType orderType);
        //T[] findByQScheme(IQryScheme qscheme);//暂不用
        //PagingRtnData<T> findByPageInfo(PaginationInfo pg, String wherePart, String orderByPart, FBoolean isLazy);
        //T[] findByQCond(QryRootNodeDTO qryRootNodeDTO, String orderStr, FBoolean isLazy);

        // 性能优化，增加创建医疗单接口
        FArrayList loadEms4Drug(CiEnContextDTO ctx, String id_srv, String id_mm);
        FArrayList loadEms4Ris(CiEnContextDTO ctx, String id_srv);
        FArrayList loadEms4Lis(CiEnContextDTO ctx, String id_srv);
        FArrayList loadEms4Ops(CiEnContextDTO ctx, String id_srv, String id_ems);
        FArrayList loadEms4Treat(CiEnContextDTO ctx, String id_srv);
        FArrayList loadEms4Cons(CiEnContextDTO ctx, String id_srv);
        FArrayList loadEms4Apbt(CiEnContextDTO ctx, String id_srv);
        FArrayList loadEms4Apbu(CiEnContextDTO ctx, String id_srv);
        FArrayList loadEms4Pathgy(CiEnContextDTO ctx, String id_srv);
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.pp.hp.d;
using iih.ci.ord.ciordems.d;
using xap.mw.coreitf.d;
using iih.ci.ord.ems.d;

namespace iih.ci.ord_stub.service.i
{
    public interface ICiOrdCrudService
    {
        void delete(EmsUIDTO[] dos, EmsType orderType);
        EmsUIDTO[] insert(EmsUIDTO[] dos, EmsType orderType);
        EmsUIDTO[] save(EmsUIDTO[] dos, EmsType orderType);
        EmsUIDTO[] update(EmsUIDTO[] dos, EmsType orderType);
        void logicDelete(EmsUIDTO[] dos, EmsType orderType);
        EmsUIDTO findById(String id, string orderType, string code_entp, CiEnContextDTO contextdto);
        //EmsUIDTO[] findByIds(String[] ids, FBoolean isLazy);
        //EmsUIDTO[] findByBIds(String[] ids, FBoolean isLazy);
        EmsUIDTO[] find(String condition, string orderStr, EmsType orderType);

       

    }
}

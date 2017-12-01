using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.d;
using iih.bd.srv.itm.d;
using iih.ci.mrqc.divide.d;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.autoqc.i {
    public interface IAutoQcService {  
        /// getAutoQcDefects 
        ItmDO[] getAutoQcDefects(string id_ent, String id_qc_type);
        //�Զ��ʿ����û�ȡ�۷���
        DivideDO[] getAutoQcDivideDos(string id_ent,string id_qc_type);
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.view.basic
{
    public delegate void fNo_Rtn_Param_One(Object p);
    public delegate void fNo_Rtn_Param_Two(Object p, Object p1);
    public delegate void fNo_Rtn_Param_Three(Object p, Object p1, Object p2);


    interface IRunnable
    {
        void DirectCall(fNo_Rtn_Param_One f, Object param);

        void DirectCall(fNo_Rtn_Param_Two f,Object[] szParam);

        void DirectCall(fNo_Rtn_Param_Three f, Object[] szParam);
    }
}

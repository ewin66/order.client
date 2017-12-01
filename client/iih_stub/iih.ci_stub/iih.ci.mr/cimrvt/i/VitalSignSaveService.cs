using iih.ci.mr.cimr.d;
using iih.ci.mr.cimrvt.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.mr.cimrvt.i
{
    public interface VitalSignSaveService
    {
        VitalSignSave[] VatilSignSave(VitalSignSave[] ListSaveDTOS);
    }
}

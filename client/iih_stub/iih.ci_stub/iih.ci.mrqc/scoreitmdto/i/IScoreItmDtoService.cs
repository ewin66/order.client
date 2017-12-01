using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mrqc.scoreitmdto.d;

namespace iih.ci.mrqc_stub.scoreitmdto.i
{
    public interface IScoreItmDtoService
    {
         ScoreItmDto[] getScoreItmDtos( String id_ent,String id_qc_type);
    }
}

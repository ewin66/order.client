using iih.ci.mr.cimrpatsigns.d;
namespace iih.ci.mr.cimrvt.i
{
    public interface ICiVitalSignsService
    {
        VitalSignsDTO[] GetVitalSignsDTOList(string Id_ent, string BeginDate, string EndDate); 
    }
}
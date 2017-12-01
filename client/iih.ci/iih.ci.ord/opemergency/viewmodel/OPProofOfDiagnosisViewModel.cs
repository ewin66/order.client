using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.i;
using iih.en.pv.dto.d;
using iih.en.pv.entdi.d;
using iih.en.pv.entdiprove.d;
using iih.en.pv.entdiprove.i;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;

namespace iih.ci.ord.opemergency.viewmodel
{
   public  class OPProofOfDiagnosisViewModel
    {
       private IEntdiproveCrudService service;
       private ICiOrdQryService ciOrdQryService;
       public EntDiProveDO entDiProveDo { get; set; }

       public OPProofOfDiagnosisViewModel(String id_ent)
       {
           service = XapServiceMgr.find<IEntdiproveCrudService>();
           ciOrdQryService = XapServiceMgr.find<ICiOrdQryService>();

           LoadData(id_ent);
       }

       public void LoadData(String id_ent)
       {
           EntDiProveDO[] entDiProve = service.find("a0.id_ent = '" + id_ent + "'", "id_ent", FBoolean.False);
           if (entDiProve != null && entDiProve.Length > 0)
           {
               entDiProveDo = entDiProve[0];
           }
           else
           {
               entDiProveDo = new EntDiProveDO();
           }
       }

       public EntDiProveDO SetEntDiProveDO(Ent4BannerDTO patDo)
       {
           entDiProveDo.Id_ent = patDo.Id_ent;
           entDiProveDo.Id_pat = patDo.Id_pat;
           entDiProveDo.Id_dep = patDo.Id_dep_phy;
           
           //TimeSpan tsm = DateTime.Now - patDo.Dt_birth_pat.Value;
           //int age = (int)tsm.TotalDays/365;

           entDiProveDo.Age = patDo.Age;
           entDiProveDo.Name_dept = patDo.Name_dep_phy;
           entDiProveDo.Name_pat = patDo.Name_pat;
           entDiProveDo.Sd_sex = patDo.Name_sex;
            
           //entDiProveDo.Name_user = patDo.N
           
           entDiProveDo.Code_dep = patDo.Code_entp;
           entDiProveDo.Str_name_di = getDiInfo(patDo.Id_ent); //诊断
           entDiProveDo.Dt_acpt = patDo.Dt_acpt;
           entDiProveDo.Dt_end = patDo.Dt_end;
           entDiProveDo.Name_emp = patDo.Name_emp_phy;
           entDiProveDo.Dt_diprove = DateTime.Now;
           entDiProveDo.Name_pat = patDo.Name_pat;
           entDiProveDo.Code_ent = patDo.Code_ent;
           return entDiProveDo;
       }

       public void Save()
       {
           entDiProveDo.Status = String.IsNullOrWhiteSpace(entDiProveDo.Id_diprove) ? DOStatus.NEW : DOStatus.UPDATED;
           
           service.save(new EntDiProveDO[] {entDiProveDo});
       }

       private string getDiInfo(string id_ent)
       {
           string str = "";
           EntDiDO[] entDiDOs = ciOrdQryService.getEntDiDOList(id_ent);
           if (entDiDOs != null && entDiDOs.Length > 0)
           {
               int i = 1;
               foreach (EntDiDO item in entDiDOs)
               {
                   str += i + "." + item.Name_didef_dis + "；";
                   i++;
               }
               str = str.Substring(0, str.LastIndexOf('；'));
           }

           return str;
       }
   }
}

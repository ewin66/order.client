using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.bc.udi;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.i;
using iih.en.pv.dto.d;
using xap.cli.context;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.rui.control.tree.otree.data;
using xap.rui.control.tree.otree.loader;
using xap.rui.control.tree.otree.model;

namespace iih.ci.ord.doctorhelper.past.viewmodel
{
   public   class PastTreeViewModel
   {
       private ICiOrdQryService qryService;
       public TreeKeyModel<EntHisDiDTO> TreeModel;
       public XapDataList<EntHisDiDTO> ListEntHisDiDTO { get; set; }
       LogicEx logic = LogicEx.GetInstance();
       public PastTreeViewModel(String id_pat)
       {
            //Code_entp — 就诊类型（必填）
            //Dt_begin — 查找记录的开始时间（可为null）
            //Dt_end — 查找记录的结束时间（可为null）
            //Id_dep — 就诊科室ID（可为null）
            //Id_emp — 主治医生ID（可为null）


           EnDiQrySchmDTO[] endiqrys = new EnDiQrySchmDTO[2];
           EnDiQrySchmDTO   ipEn = new EnDiQrySchmDTO();
           ipEn.Code_entp = EnDictCodeConst.SD_ENTP_INPATIENT;
           ipEn.Dt_begin = logic.GetAfterDateTime(365);
           ipEn.Dt_end = logic.GetServerDataTime();
           ipEn.Id_dep = UserManager.getInstance().CurrentDept.Id_dep;
           ipEn.Id_emp = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;
           EnDiQrySchmDTO   opEn = new EnDiQrySchmDTO();
           opEn.Code_entp = EnDictCodeConst.SD_ENTP_OUTPATIENT;
           opEn.Dt_begin = logic.GetAfterDateTime(180);
           opEn.Dt_end = logic.GetServerDataTime();
           opEn.Id_dep = UserManager.getInstance().CurrentDept.Id_dep;
           opEn.Id_emp = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;
           endiqrys[0] = ipEn;
           endiqrys[1] = opEn;

           this.qryService = XapServiceMgr.find<ICiOrdQryService>();
           this.ListEntHisDiDTO = this.qryService.getEntHisDiDTO(id_pat);
           this.ListEntHisDiDTO = this.qryService.getEntHisDiBySchm(id_pat, endiqrys);



           KeyNodeDataAdapterFactory<EntHisDiDTO> moduleAdapter = new KeyNodeDataAdapterFactory<EntHisDiDTO>("Id_entdi", "Id_entdi");
           moduleAdapter.CustomCaptionFunc = (dataobj => dataobj.Dt_acpt + " " + dataobj.Name_didef_dis +"("+dataobj.Name_dep+")");

           this.TreeModel = new TreeKeyModel<EntHisDiDTO>(moduleAdapter);
           this.TreeModel.Loader = new OTreeKeyLoader();
           this.TreeModel.AddRange(this.ListEntHisDiDTO); 
       }
    }
}

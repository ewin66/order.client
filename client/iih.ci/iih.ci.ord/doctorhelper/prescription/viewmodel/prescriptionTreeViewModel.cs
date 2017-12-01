using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.dto.ordertpltree.d;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.rui.control.tree.otree.data;
using xap.rui.control.tree.otree.loader;
using xap.rui.control.tree.otree.model;
using iih.bd.srv.dto.d;
using iih.ci.ord.dto.medicalroutinetreedto.d;
using xap.cli.context;

namespace iih.ci.ord.doctorhelper.prescription.viewmodel
{
    public  class prescriptionTreeViewModel
    {
        private ICiOrdQryService qryService;
        public TreeKeyModel<Medicalroutinetreedto> TreeModel;
        public XapDataList<OrderTplTreeDto> OrderTplTreeList { get; set; }
        public XapDataList<Medicalroutinetreedto> OrderPreslTreeList { get; set; }

        public prescriptionTreeViewModel(String type)
        {
            this.qryService = XapServiceMgr.find<ICiOrdQryService>();
            

            Emp2Dep2GroupDTO edg = new Emp2Dep2GroupDTO();
            edg.Id_dep = UserManager.getInstance().CurrentDept.Id_dep;
            edg.Name_dep = UserManager.getInstance().CurrentDept.Name;
            edg.Id_emp = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;
            edg.Name_emp = UserManager.getInstance().CurrentPsnInfo.Name;
            edg.Id_org = UserManager.getInstance().CurrentOrg.Id_org;
            edg.Name_org = UserManager.getInstance().CurrentOrg.Name;

             //  this.OrderTplTreeList = this.qryService.getOrderTplTreeDto(type, edg);
            this.OrderPreslTreeList = this.qryService.getPrescriptionTreeNew("1");
            KeyNodeDataAdapterFactory<Medicalroutinetreedto> moduleAdapter = new KeyNodeDataAdapterFactory<Medicalroutinetreedto>("Id_ortmplca", "Id_parent");
            moduleAdapter.CustomCaptionFunc = (dataobj => dataobj.Name);

            this.TreeModel = new TreeKeyModel<Medicalroutinetreedto>(moduleAdapter);
            this.TreeModel.Loader = new OTreeKeyLoader();
            this.TreeModel.AddRange(this.OrderPreslTreeList); 
        }

    }
}

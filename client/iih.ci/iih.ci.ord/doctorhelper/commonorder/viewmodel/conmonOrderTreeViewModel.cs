using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.ortpl.d;
using iih.ci.ord.dto.medicalroutinetreedto.d;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.rui.control.tree.otree.data;
using xap.rui.control.tree.otree.loader;
using xap.rui.control.tree.otree.model;
///
///常规医嘱树
/// 
namespace iih.ci.ord.doctorhelper.commonorder.viewmodel
{
    public class conmonOrderTreeViewModel
    {
        private ICiOrdQryService qryService;
        //public TreeKeyModel<RegularOrCaDO> TreeModel;
        //public XapDataList<RegularOrCaDO> regularOrCaDO { get; set; }


        public TreeKeyModel<Medicalroutinetreedto> TreeModel;
        public XapDataList<Medicalroutinetreedto> regularOrCaDO { get; set; }

        public conmonOrderTreeViewModel(string strIpOp)
        {
            this.qryService = XapServiceMgr.find<ICiOrdQryService>();
            //this.regularOrCaDO = this.qryService.getRegularOrCaDOs();
            //KeyNodeDataAdapterFactory<RegularOrCaDO> moduleAdapter = new KeyNodeDataAdapterFactory<RegularOrCaDO>("Id_regularorca", "Id_parent");
            //moduleAdapter.CustomCaptionFunc = (dataobj => dataobj.Name );

            //this.TreeModel = new TreeKeyModel<RegularOrCaDO>(moduleAdapter);
            //this.TreeModel.Loader = new OTreeKeyLoader();
            //this.TreeModel.Loader = new OTreeKeyLoader("常规模板");
            //this.TreeModel.AddRange(this.regularOrCaDO);


            this.regularOrCaDO = this.qryService.getMedicalroutinetreedto(strIpOp);
            KeyNodeDataAdapterFactory<Medicalroutinetreedto> moduleAdapter = new KeyNodeDataAdapterFactory<Medicalroutinetreedto>("Id_ortmplca", "Id_parent");
            moduleAdapter.CustomCaptionFunc = (dataobj => dataobj.Name);

            this.TreeModel = new TreeKeyModel<Medicalroutinetreedto>(moduleAdapter);
            this.TreeModel.Loader = new OTreeKeyLoader();
            this.TreeModel.Loader = new OTreeKeyLoader("常规模板");
            this.TreeModel.AddRange(this.regularOrCaDO);
        }
    }
}

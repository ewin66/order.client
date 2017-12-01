using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.bc.udi;
using iih.ci.ord.dto.ordertpltree.d;
using iih.ci.ord.i;
using iih.en.pv.dto.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.rui.control.tree.otree.data;
using xap.rui.control.tree.otree.loader;
using xap.rui.control.tree.otree.model;
using iih.bd.srv.dto.d;
using xap.cli.context;
using xap.rui.uipattern2.basemodel.sysinfo;
using xap.sys.xbd.udi.d;


namespace iih.ci.ord.doctorhelper.ordertemplate.viewmodel
{
   public  class OrderTemplateTreeViewModel
    {

        private ICiOrdQryService qryService;
        public TreeKeyModel<OrderTplTreeDto> TreeModel;
        public XapDataList<OrderTplTreeDto> OrderTplTreeList { get; set; }

       public OrderTemplateTreeViewModel(string tpltypeCode,string code_entp)
       {
           this.qryService = XapServiceMgr.find<ICiOrdQryService>();
           Emp2Dep2GroupDTO edg = new Emp2Dep2GroupDTO();
           edg.Id_dep = UserManager.getInstance().CurrentDept.Id_dep;
           edg.Name_dep = UserManager.getInstance().CurrentDept.Name;
           edg.Id_emp = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;
           edg.Name_emp = UserManager.getInstance().CurrentPsnInfo.Name;
           edg.Id_org = UserManager.getInstance().CurrentOrg.Id_org;
           edg.Name_org = UserManager.getInstance().CurrentOrg.Name;
           edg.Code_entp = code_entp;
          UdidocDO udidocDo= UdiDocCache.GetInstance()
               .GetUdidoc(BdSrvDictCodeTypeConst.SD_ORTPLTP, tpltypeCode);
          if (udidocDo!=null)
              this.OrderTplTreeList = this.qryService.getOrderTplTreeDto(udidocDo.Id_udidoc, edg);

           KeyNodeDataAdapterFactory<OrderTplTreeDto> moduleAdapter = new KeyNodeDataAdapterFactory<OrderTplTreeDto>("Id", "Parent");
           moduleAdapter.CustomCaptionFunc = (dataobj => dataobj.Nm);

           this.TreeModel = new TreeKeyModel<OrderTplTreeDto>(moduleAdapter);
           this.TreeModel.Loader = new OTreeKeyLoader();
           this.TreeModel.AddRange(this.OrderTplTreeList); 
       }
    }
}

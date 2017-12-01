using System;
using System.Collections.Generic;
using iih.bd.bc.udi;
using iih.bd.srv.ortpl.d;
using iih.bd.srv.ortpl.dto;
using iih.bd.srv.ortpl.i;
using iih.bd.srv.service.i;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.rui.control.tree.otree.data;
using xap.rui.engine;
using xap.sys.xbd.udi.d;
using xap.sys.xbd.udi.i;
using xap.cli.context;

namespace iih.ci.ord.doctorhelper.newtemplate.viewmodel
{
   public class NewOrderTemplateTreeViewModel
   {
       private IOrtmplcaCrudService caService;//医嘱模板分类数据服务
       private IBdSrvQryService bdService;//查询关系DO和模板DO组合成的DTO
       private IOrtmplcarelCrudService carelService;//分类模板关系数据服务
       private IUdidocServiceExt udidoc_service;

       private UdidocDO[] udidocDOs_SubOwnerType;//适用范围
       public Dictionary<string, string> DicScopetp;//适用范围数据源
       public UdidocDO CurrUdidocDO_SubOwnerType;//当前适用范围

       public OrTmplCaDO[] ArryOrTmplCaDOs { get; set; }//模板分类查询结果
       public XapDataList<OrTmplCaDO> LstOrTmplCaDOs { get; set; }
       public OrTmplDTO[] ArryOrTmplDTOs { get; set; }//模板查询结果
       public XapDataList<OrTmplDTO> LstOrTmplDTOs { get; set; }

       public LazyLoadTreeModel lazyLoadTreeModel;//Otree懒加载数据模型

       /// <summary>
       /// 上下文信息
       /// </summary>
       private BaseContext context;
       private string strIpOp = "";

       public NewOrderTemplateTreeViewModel(BaseContext context, string strIpOp)
           :this()
       {
           LstOrTmplCaDOs = new XapDataList<OrTmplCaDO>();
           LstOrTmplDTOs = new XapDataList<OrTmplDTO>();

           this.strIpOp = strIpOp;
           this.context = context;
           this.getUdidocDOs();
           this.LoadData();
       }

       public NewOrderTemplateTreeViewModel()
       {
           caService = XapServiceMgr.find<IOrtmplcaCrudService>();
           bdService = XapServiceMgr.find<IBdSrvQryService>();
           carelService = XapServiceMgr.find<IOrtmplcarelCrudService>();
           udidoc_service = XapServiceMgr.find<IUdidocServiceExt>();
       }

       /// <summary>
       /// 初始化适用范围（全院）
       /// </summary>
       protected void getUdidocDOs()
       {
           udidocDOs_SubOwnerType = udidoc_service.findByUdidoclistCode(BdSrvDictCodeTypeConst.SD_OWTP);
           DicScopetp = new Dictionary<string, string>();
           foreach (UdidocDO udidoc in udidocDOs_SubOwnerType)
           {
               DicScopetp.Add(udidoc.Name, udidoc.Id_udidoc);
               //适用范围：全院
               if (udidoc.Code == BdSrvDictCodeConst.SD_OWTP_HOSPITAL)
               {
                   CurrUdidocDO_SubOwnerType = udidoc;
               }
           }
       }

       /// <summary>
        /// 加载医嘱模板树数据
        /// </summary>
        public void LoadData()
        {
            string sql = string.Format(" id_grp='{0}' and id_org='{1}' and id_srvorrt='{2}'", UserManager.getInstance().CurrentGroup.Id_grp.Trim(), 
                UserManager.getInstance().CurrentOrg.Id_org.Trim(), this.CurrUdidocDO_SubOwnerType.Id_udidoc);
            switch (this.CurrUdidocDO_SubOwnerType.Code)
            {
                case BdSrvDictCodeConst.SD_OWTP_HOSPITAL:
                    sql += "  and fg_routine='N'";
                    break;
                case BdSrvDictCodeConst.SD_OWTP_DEPT:
                    sql += string.Format(" and id_dep='{0}'", UserManager.getInstance().CurrentDept.Id_dep.Trim());
                    break;
                case BdSrvDictCodeConst.SD_OWTP_PERSON:
                    sql += string.Format(" and id_dep='{0}' and id_emp='{1}'", UserManager.getInstance().CurrentDept.Id_dep.Trim(),
                        UserManager.getInstance().CurrentPsnInfo.Id_psndoc.Trim());
                    break;
            }

            ArryOrTmplCaDOs = caService.find(sql, "code", false);
        
            LstOrTmplCaDOs = new XapDataList<OrTmplCaDO>(caService, ArryOrTmplCaDOs);

            switch (this.CurrUdidocDO_SubOwnerType.Code)
            {
                case BdSrvDictCodeConst.SD_OWTP_HOSPITAL: // 全院
                    ArryOrTmplDTOs = bdService.getOrTmplCaDataTree(
                        UserManager.getInstance().CurrentGroup.Id_grp.Trim(), UserManager.getInstance().CurrentOrg.Id_org.Trim(),
                        this.CurrUdidocDO_SubOwnerType.Id_udidoc, null, null, null);
                    break;
                case BdSrvDictCodeConst.SD_OWTP_DEPT: // 科室
                    ArryOrTmplDTOs = bdService.getOrTmplCaDataTree(
                        UserManager.getInstance().CurrentGroup.Id_grp.Trim(), UserManager.getInstance().CurrentOrg.Id_org.Trim(),
                        this.CurrUdidocDO_SubOwnerType.Id_udidoc, UserManager.getInstance().CurrentDept.Id_dep.Trim(), null, null);
                    break;
                case BdSrvDictCodeConst.SD_OWTP_PERSON: // 个人
                    ArryOrTmplDTOs = bdService.getOrTmplCaDataTree(
                        UserManager.getInstance().CurrentGroup.Id_grp.Trim(), UserManager.getInstance().CurrentOrg.Id_org.Trim(),
                        this.CurrUdidocDO_SubOwnerType.Id_udidoc, null, 
                        UserManager.getInstance().CurrentPsnInfo.Id_psndoc.Trim(), null);
                    break;
            }

            LstOrTmplDTOs.Clear();
            foreach (OrTmplDTO dto in ArryOrTmplDTOs)
            {
                LstOrTmplDTOs.Add(dto);
            }
        }    

        /// <summary>
        /// 获取当前选中适用范围
        /// </summary>
        /// <param name="id">适用范围ID</param>
        public void GetCurrUdidocDO_SubOwnerType(string id)
        {
            foreach (UdidocDO u in udidocDOs_SubOwnerType)
            {
                if (u.Id_udidoc.Equals(id))
                {
                    this.CurrUdidocDO_SubOwnerType = u; 
                }
            }
        }

        /// <summary>
        /// 获取树节点数据
        /// </summary>
        public void GetTreeKeyModel()
        {
            var adapter1 = new KeyNodeDataAdapterFactory<OrTmplCaDO>("Id_ortmplca", "Id_parent") 
            { CustomCaptionFunc = x => x.Name };
            var adapter2 = new KeyNodeDataAdapterFactory<OrTmplDTO>("Id_ortmpl", null, "Id_ortmplca") 
            { CustomCaptionFunc = x => x.Name };

            lazyLoadTreeModel = new LazyLoadTreeModel(CurrUdidocDO_SubOwnerType.Name);
            lazyLoadTreeModel.LazyLoadChildren = (oTree, bizNode) =>
            {
                if (bizNode.IsRoot)
                {
                    foreach (var caDO in LstOrTmplCaDOs)
                    {
                        if (caDO.Id_parent == null)
                        {
                            var data = adapter1.Wrap(caDO);
                            oTree.AppendBizNode(bizNode, data);
                        }
                    }
                }
                else
                {
                    OrTmplCaDO moduleDo = bizNode.UserObject as OrTmplCaDO;
                    if (moduleDo != null)
                    {
                        foreach (var caDO in LstOrTmplCaDOs)
                        {
                            if (caDO.Id_parent != null && moduleDo.Id_ortmplca == caDO.Id_parent)
                            {
                                var data = adapter1.Wrap(caDO);
                                oTree.AppendBizNode(bizNode, data);
                            }
                        }

                        foreach (var dto in LstOrTmplDTOs)
                        {
                            if ((strIpOp=="1" && (bool)dto.Fg_entp_ip) || (strIpOp == "0" && ((bool)dto.Fg_entp_op || (bool)dto.Fg_entp_er)))
                            {
                                if (dto.Id_ortmplca == moduleDo.Id_ortmplca)
                                {
                                    var data = adapter2.Wrap(dto);
                                    oTree.AppendBizNode(bizNode, data);
                                }
                            }
                        }
                    }
                }
                return true;
            };

        }
    }
}

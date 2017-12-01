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
using iih.ci.ord.i;
using iih.en.pv.dto.d;
using xap.mw.core.data;
using xap.rui.control.tree.otree.model;
using xap.rui.control.tree.otree.loader;
using iih.ci.ord.dto.newordertemplatedto.d;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.iih.ci.ord.i;
using iih.ci.ord.common.utils;
using iih.bd.srv.ems.d;
using iih.ci.iih.ci.ord.dto.newordertemplatedto.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.ciorder.utils;

namespace iih.ci.ord.opemergency.assi.OrdertemplatePithy.model

{
   public class OrderTemplatePithyTreeViewModel
   {
       private ICiOrdQryService ciOrdQeryService;//查询简洁版的模板树

       private FMap mapTree;//树的数据源（模板分类和模板名称）
       public OrderTemplateRstDTO remplRes;
       public OrderTemplatePithyTreeViewModel()
       {
           ciOrdQeryService = XapServiceMgr.find<ICiOrdQryService>();
       }
       /// <summary>
       /// 树的数据源（模板分类和模板名称）
       /// </summary>
       public void getTemplateClassIfication(Ent4BannerDTO BannerDTO)
        {
            mapTree = ciOrdQeryService.getTemplateClassIfication(BannerDTO.Code_entp, UserManager.getInstance().CurrentDept.Id_dep.Trim(), UserManager.getInstance().CurrentPsnInfo.Id_psndoc.Trim(), "");
            //BaseEmsView.BaseEmsInfoContext.Add("TemplateClassIficationTreeModel", mapTree);
        }
       /// <summary>
       /// 查询模板明细
       /// </summary>
       /// <param name="BannerDTO"></param>
       /// <param name="id_ortmpls"></param>
       /// <returns></returns>
       public FMap getNewOrderTemplateDTO2(Ent4BannerDTO BannerDTO, string[] id_ortmpls)
       {
           remplRes = ciOrdQeryService.getOrTemplateCache(id_ortmpls, BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO);
           //string json = remplRes.serializeJson();
           FMap map2 = new FMap();
           if (remplRes != null) {
              map2 =  remplRes.TemplItm;
           }
           //诊疗医疗单的开单模式赋值
           if (map2 != null && BaseEmsView.BaseEmsInfoContext.ContainsKey(ICiOrdNSysParamConst.OPDiagTreatTmplOrOpenMode))
           {
               foreach (string keyId in map2.Keys)
               {
                   FArrayList list = map2[keyId] as FArrayList;
                   foreach (NewOrderTemplateDTO templateDTO in list)
                   {
                       if (templateDTO.Ui_flag == "6")//治疗医疗单
                       {
                           FArrayList itmdolist = templateDTO.Itemlist;
                           foreach (OrTplNItmDO itmdo in itmdolist)
                           {
                               itmdo.Opdiagtreattmploropenmode = (string)BaseEmsView.BaseEmsInfoContext[ICiOrdNSysParamConst.OPDiagTreatTmplOrOpenMode];
                           }
                       }
                   }
               }
           }
           return map2;
       }
       ///// <summary>
       ///// 查询模板明细
       ///// </summary>
       ///// <param name="BannerDTO"></param>
       ///// <param name="id_ortmpls"></param>
       ///// <returns></returns>
       // public FMap2 getNewOrderTemplateDTO2(Ent4BannerDTO BannerDTO,string[] id_ortmpls)
       // {
       //     FMap2 map2 = ciOrdQeryService.getNewOrderTemplateDTO2(id_ortmpls, BannerDTO.Id_patcret, BannerDTO.Id_hp,BannerDTO.Code_entp);
       //     //诊疗医疗单的开单模式赋值
       //     if (map2 != null && BaseEmsView.BaseEmsInfoContext.ContainsKey(ICiOrdNSysParamConst.OPDiagTreatTmplOrOpenMode)) {
       //         foreach (string keyId in map2.Keys)
       //         {
       //             FArrayList2 list = map2[keyId] as FArrayList2;
       //             foreach (NewOrderTemplateDTO templateDTO in list)
       //             {
       //                 if (templateDTO.Ui_flag == "6")//治疗医疗单
       //                 {
       //                     FArrayList itmdolist = templateDTO.Itemlist;
       //                     foreach (OrTplNItmDO itmdo in itmdolist)
       //                     {
       //                         itmdo.Opdiagtreattmploropenmode = (string)BaseEmsView.BaseEmsInfoContext[ICiOrdNSysParamConst.OPDiagTreatTmplOrOpenMode];
       //                     }
       //                 }
       //             }
       //         }
       //     }
       //     return map2;
       // }
       /// <summary>
       /// 加载不同模板类型下树的数据源
       /// </summary>
       /// <param name="sd_type"></param>
       /// <returns></returns>
        public TreeKeyModel<OrTmplDTO> loadTreeModel(string model_type) {
            KeyNodeDataAdapterFactory<OrTmplDTO> moduleAdapter = new KeyNodeDataAdapterFactory<OrTmplDTO>("Id_ortmpl", "Id_ortmplca");
            moduleAdapter.CustomCaptionFunc = (dataobj => dataobj.Name);
            TreeKeyModel<OrTmplDTO> TreeModel = new TreeKeyModel<OrTmplDTO>(moduleAdapter);
            if (mapTree != null) {
                    TreeModel.Loader = new OTreeKeyLoader();
                    FArrayList hospitalList = mapTree[BdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID] as FArrayList;
                    if (hospitalList != null) {
                        XapDataList<OrTmplDTO> dataTree = pickOrTmlBySdModelType(hospitalList, model_type);
                        TreeModel.AddRange(dataTree);
                    }
            }
            return TreeModel;
        }
        private XapDataList<OrTmplDTO> pickOrTmlBySdModelType(FArrayList hospitalList,string sd_type)
        {
            XapDataList<OrTmplDTO> dataTree = new XapDataList<OrTmplDTO>();
            //if (sd_type == BdSrvDictCodeConst.SD_ORTMPLTP_FHMBA)
            //{
            //    foreach (OrTmplDTO dto in hospitalList)
            //    {
            //        dataTree.Add(dto);
            //    }
            //}
            //else
            //{
                FArrayList modelItmlist = new FArrayList();//模板类型下的数据
                FArrayList modelClaslist = new FArrayList();//模板分类
                foreach (OrTmplDTO dto in hospitalList)
                {
                    if (string.IsNullOrWhiteSpace(dto.Sd_ortmpltp))
                    {
                        modelClaslist.Add(dto);
                        continue;
                    }
                    if (dto.Sd_ortmpltp.Equals(sd_type))
                    {
                        modelItmlist.Add(dto);
                    }
                }
                if (modelItmlist.Count > 0)
                {
                    FArrayList reModelClasList = new FArrayList();
                    foreach (OrTmplDTO dto in modelItmlist)
                    {
                        getParentOrTmplDTO(modelClaslist, reModelClasList,dto);
                    }
                    modelItmlist.AddRange(reModelClasList);
                    int i = 1;
                    foreach (OrTmplDTO dto in modelItmlist)
                    {
                        //Log.writelog(dto.Id_ortmpl + "," + dto.Name + ":" + (i++));
                        dataTree.Add(dto);
                    }
                }
            //}
            return dataTree;
        }
       /// <summary>
       /// 获得对应模板类型下的模板id
       /// </summary>
       /// <param name="sd_type"></param>
       /// <returns></returns>
        public FArrayList getModelIdByModelType(string sd_type) {
            FArrayList modelIds = new FArrayList();
            if (mapTree != null)
            {
                FArrayList hospitalList = mapTree[BdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID] as FArrayList;
                if (hospitalList != null)
                {
                    foreach (OrTmplDTO dto in hospitalList)
                    {
                        if (!string.IsNullOrWhiteSpace(dto.Sd_ortmpltp) && dto.Sd_ortmpltp.Equals(sd_type))
                        {
                            modelIds.Add(dto.Id_ortmpl.Substring(0, dto.Id_ortmpl.Length - 1));
                        }
                    }
                }
            }
            return modelIds;
        }
        private FArrayList getParentOrTmplDTO(FArrayList modelClaslist,FArrayList reModelClasList, OrTmplDTO tmpl)
        {
            if (tmpl != null && !string.IsNullOrWhiteSpace(tmpl.Id_ortmplca))
            { 
                foreach(OrTmplDTO dto in modelClaslist){
                    if (dto.Id_ortmpl == tmpl.Id_ortmplca)
                    {
                        if (!reModelClasList.Contains(dto)) {
                            reModelClasList.Add(dto);
                            this.getParentOrTmplDTO(modelClaslist, reModelClasList, dto);    
                        }
                    }
                }
            }
            return reModelClasList;
        }
       /// <summary>
       /// 获得所有的子节点中的医嘱模板的id
       /// </summary>
       /// <param name="tmpl"></param>
       /// <returns></returns>
        public FArrayList getAllChildOrTmplDTO(OrTmplDTO tmpl,string sd_ortmpltp)
        {
            FArrayList modelList = new FArrayList();
            if(tmpl.OrtmplType=="1"){
                modelList.Add(tmpl.Id_ortmpl.Substring(0,tmpl.Id_ortmpl.Length-1));
            }
            if (this.mapTree != null) {
                FArrayList hospitalList = mapTree[BdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID] as FArrayList;
                foreach(OrTmplDTO dto in hospitalList){
                    if (dto.Id_ortmplca == tmpl.Id_ortmpl && dto.Sd_ortmpltp == sd_ortmpltp)
                    {
                        if (dto.OrtmplType == "1")
                        {
                            modelList.Add(dto.Id_ortmpl.Substring(0, dto.Id_ortmpl.Length - 1));
                        }
                        modelList.AddRange(getAllChildOrTmplDTO(dto,sd_ortmpltp));
                    }
                }
            }
            return modelList;
        }
    }
}

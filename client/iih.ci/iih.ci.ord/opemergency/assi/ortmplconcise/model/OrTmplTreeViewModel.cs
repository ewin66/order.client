
using System;
using iih.ci.ord.i.ortmpl;
using iih.bd.srv.ortpl.d;
using iih.bd.srv.ortpl.dto;
using xap.mw.serviceframework;
using xap.cli.context;
using xap.rui.control.tree.otree.data;
using iih.bd.bc.udi;
using System.Collections.Generic;
using xap.mw.core.data;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.ems.d;
using iih.ci.iih.ci.ord.i;
using iih.ci.iih.ci.ord.dto.newordertemplatedto.d;
using iih.ci.ord.dto.newordertemplatedto.d;

namespace iih.ci.ord.opemergency.assi.ortmplconcise.model
{
    /// <summary>
    /// <para>描    述 :  医嘱模板加载模型    			</para>
    /// <para>说    明 :  医嘱模板加载模型   			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.ortmplconcise.model    </para>    
    /// <para>类 名 称 :  OrTmplTreeViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Young         				</para> 
    /// <para>修 改 人 :  Young         				</para> 
    /// <para>创建时间 :  2017/10/20 19:23:26             </para>
    /// <para>更新时间 :  2017/10/20 19:23:26             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class OrTmplTreeViewModel
    {
        /// <summary>
        /// 医嘱模板服务
        /// </summary>
        private IOrTmplApplyService orTmplApplyService;

        /// <summary>
        /// 医嘱模板分类对象集合
        /// </summary>
        private OrTmplCaDO[] arryOrTmplCaDOs;

        /// <summary>
        /// 医嘱模板对象集合
        /// </summary>
        private OrTmplDTO[] arrayOrTmplDTOs;

        /// <summary>
        /// 模板字典
        /// </summary>
        private Dictionary<String, List<String>> dicOrTmplDTOs;

        /// <summary>
        /// 模板明细字典
        /// </summary>
        public Dictionary<String, FArrayList> DicOrTplNItm;

        /// <summary>
        /// 构造函数
        /// </summary>
        public OrTmplTreeViewModel()
        {
            orTmplApplyService = XapServiceMgr.find<IOrTmplApplyService>();
            dicOrTmplDTOs = new Dictionary<string, List<String>>();
            DicOrTplNItm = new Dictionary<string, FArrayList>();
        }

        /// <summary>
        /// 查询医嘱模板分类和医嘱模板数据
        /// </summary>
        /// <param name="sd_ortmpltp"></param>
        public void LoadOrTmplCaAndTmplData(String sd_ortmpltp)
        {
            //查询医嘱模板分类
            OrTmplCaDO[] orTmplCaDOs = orTmplApplyService.getOrTmplCaDOs(UserManager.getInstance().CurrentGroup.Id_grp.Trim(), UserManager.getInstance().CurrentOrg.Id_org.Trim(),
                UserManager.getInstance().CurrentDept.Id_dep.Trim(), UserManager.getInstance().CurrentPsnInfo.Id_psndoc.Trim(), sd_ortmpltp);
            Dictionary<String, OrTmplCaDO> dicorTmplCaDOs = new Dictionary<string, OrTmplCaDO>();
            if (orTmplCaDOs != null && orTmplCaDOs.Length > 0)
            {
                String strid_ortmplca = "";
                foreach (var caDO in orTmplCaDOs)
                {
                    strid_ortmplca += ",'" + caDO.Id_ortmplca + "'";
                    dicorTmplCaDOs.Add(caDO.Id_ortmplca, caDO);
                }
                //查询医嘱模板数据
                arrayOrTmplDTOs = orTmplApplyService.getOrTmplDTOs(strid_ortmplca.Substring(1), sd_ortmpltp);
                if (arrayOrTmplDTOs != null && arrayOrTmplDTOs.Length > 0)
                {
                    List<String> lstIdOrTmplCas = new List<string>();
                    foreach (var tmplDTO in arrayOrTmplDTOs)
                    {
                        // 获取不为空的分类ID（分类下存在子分类或者模板）
                        // 从模板逐级向上
                        getIdOrTmplCas4NotEmpty(tmplDTO.Id_ortmplca, lstIdOrTmplCas, dicorTmplCaDOs);
                        if (dicOrTmplDTOs.ContainsKey(tmplDTO.Id_ortmplca))
                        {
                            dicOrTmplDTOs[tmplDTO.Id_ortmplca].Add(tmplDTO.Id_ortmpl);
                        }
                        else
                        {
                            List<String> lst = new List<String>();
                            lst.Add(tmplDTO.Id_ortmpl);
                            dicOrTmplDTOs.Add(tmplDTO.Id_ortmplca, lst);
                        }
                    }
                    // 获取不为空的分类集合
                    List<OrTmplCaDO> lstOrTmplCaDOs = new List<OrTmplCaDO>();
                    foreach (var caDO in orTmplCaDOs)
                    {
                        if (lstIdOrTmplCas.Contains(caDO.Id_ortmplca))
                        {
                            lstOrTmplCaDOs.Add(caDO);
                        }
                    }
                    arryOrTmplCaDOs = lstOrTmplCaDOs.ToArray();
                    
                }
            }
        }

        /// <summary>
        /// 获取不为空的分类（分类下存在子分类或者模板）
        /// </summary>
        /// <param name="idOrTmplCa"></param>
        /// <param name="lstIdOrTmplCas"></param>
        /// <param name="dicorTmplCaDOs"></param>
        private void getIdOrTmplCas4NotEmpty(String idOrTmplCa, List<String> lstIdOrTmplCas, Dictionary<String, OrTmplCaDO> dicorTmplCaDOs)
        {
            lstIdOrTmplCas.Add(idOrTmplCa);
            if (dicorTmplCaDOs.ContainsKey(idOrTmplCa))
            {
                String id_parent = dicorTmplCaDOs[idOrTmplCa].Id_parent;
                if (!String.IsNullOrEmpty(id_parent))
                {
                    getIdOrTmplCas4NotEmpty(id_parent, lstIdOrTmplCas, dicorTmplCaDOs);
                }
            }
        }

        /// <summary>
        /// 查询医嘱模板明细数据
        /// </summary>
        /// <param name="idortmpls"></param>
        public void LoadOrTplNItmDOs(List<String> idortmpls)
        {
            for (int i = idortmpls.Count - 1; i >= 0; i--)
            {
                if (this.DicOrTplNItm.ContainsKey(idortmpls[i]))
                    idortmpls.RemoveAt(i);
            }

            if (idortmpls != null && idortmpls.Count > 0)
            {
                OrderTemplateRstDTO remplRes = orTmplApplyService.getOrTemplateCache(idortmpls.ToArray(), BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO);
                FMap fMap = null;
                if (remplRes != null)
                {
                    fMap = remplRes.TemplItm;
                }
                //诊疗医疗单的开单模式赋值
                if (fMap != null)
                {
                    if (BaseEmsView.BaseEmsInfoContext.ContainsKey(ICiOrdNSysParamConst.OPDiagTreatTmplOrOpenMode))
                    {
                        foreach (string keyId in fMap.Keys)
                        {
                            FArrayList list = fMap[keyId] as FArrayList;
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
                    foreach (string keyId in fMap.Keys)
                    {
                        FArrayList list = fMap[keyId] as FArrayList;
                        if (!this.DicOrTplNItm.ContainsKey(keyId))
                        {
                            this.DicOrTplNItm.Add(keyId, list);
                        }
                    }
                }
            }
        }

        /// <summary>
        /// 获取树懒加载数据源（模板分类和医嘱模板）
        /// </summary>
        public LazyLoadTreeModel GetTreeKeyModel()
        {
            var adapter1 = new KeyNodeDataAdapterFactory<OrTmplCaDO>("Id_ortmplca", "Id_parent") { CustomCaptionFunc = x => x.Name };
            var adapter2 = new KeyNodeDataAdapterFactory<OrTmplDTO>("Id_ortmpl", null, "Id_ortmplca") { CustomCaptionFunc = x => x.Name };

            String[] nodesRoot = new String[] { "全院", "科室", "个人" };
            LazyLoadTreeModel lazyLoadTreeModel = new LazyLoadTreeModel(nodesRoot);
            lazyLoadTreeModel.LazyLoadChildren = (oTree, bizNode) =>
            {
                if (bizNode.IsRoot)
                {
                    //判断是否根节点，第一级的分类没有父节点，加载第一级分类
                    foreach (var caDO in arryOrTmplCaDOs)
                    {
                        if (caDO.Id_parent == null)
                        {
                            switch (bizNode.UserObject.ToString())
                            {
                                case "全院":
                                    if (caDO.Sd_srvorrt == BdSrvDictCodeConst.SD_OWTP_HOSPITAL)
                                    {
                                        var data = adapter1.Wrap(caDO);
                                        oTree.AppendBizNode(bizNode, data);
                                    }
                                    break;
                                case "科室":
                                    if (caDO.Sd_srvorrt == BdSrvDictCodeConst.SD_OWTP_DEPT)
                                    {
                                        var data = adapter1.Wrap(caDO);
                                        oTree.AppendBizNode(bizNode, data);
                                    }
                                    break;
                                case "个人":
                                    if (caDO.Sd_srvorrt == BdSrvDictCodeConst.SD_OWTP_PERSON)
                                    {
                                        var data = adapter1.Wrap(caDO);
                                        oTree.AppendBizNode(bizNode, data);
                                    }
                                    break;
                            }
                        }
                    }
                }
                else
                {
                    //在非根节点下加载节点
                    if (bizNode.UserObject is OrTmplCaDO)
                    {
                        OrTmplCaDO moduleDo = bizNode.UserObject as OrTmplCaDO;
                        if (moduleDo != null)
                        {
                            //非根节点下，加载分类节点
                            foreach (var caDO in arryOrTmplCaDOs)
                            {
                                if (caDO.Id_parent != null && moduleDo.Id_ortmplca == caDO.Id_parent)
                                {
                                    var data = adapter1.Wrap(caDO);
                                    oTree.AppendBizNode(bizNode, data);
                                }
                            }
                            //非根节点下，加载模板节点
                            foreach (var dto in arrayOrTmplDTOs)
                            {
                                if (dto.Id_ortmplca == moduleDo.Id_ortmplca)
                                {
                                    var data = adapter2.Wrap(dto);
                                    oTree.AppendBizNode(bizNode, data);
                                }
                            }
                        }
                    }
                    else if (bizNode.UserObject is OrTmplDTO)
                    {//模板节点先加载“加载中...”
                        oTree.AppendBizNode(bizNode, "加载中...");
                    }
                }
                return true;
            };
            return lazyLoadTreeModel;
        }

        /// <summary>
        /// 获取选节点下所有模板ID
        /// </summary>
        /// <param name="data"></param>
        /// <returns></returns>
        public List<String> GetAllChildIdOrTmpls(BaseDO data)
        {
            List<String> lstIDs = new List<String>();
            if (data != null)
            {
                if (data is OrTmplDTO)
                {
                    OrTmplDTO dto = data as OrTmplDTO;
                    lstIDs.Add(dto.Id_ortmpl);
                }
                else if (data is OrTmplCaDO)
                {
                    OrTmplCaDO caDO = data as OrTmplCaDO;
                    if (dicOrTmplDTOs.ContainsKey(caDO.Id_ortmplca))
                    {
                        lstIDs.AddRange(dicOrTmplDTOs[caDO.Id_ortmplca]);
                    }
                }
            }
            return lstIDs;
        }
    }
}

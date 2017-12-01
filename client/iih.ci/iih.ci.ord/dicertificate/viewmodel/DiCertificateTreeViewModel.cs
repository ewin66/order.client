using iih.bd.bc.udi;
using xap.sys.xbd.udi.d;
using xap.rui.control.tree.otree.data;
using iih.en.pv.entdiprove.d;
using xap.rui.appfw;
using iih.en.pv.entdiprove.i;
using xap.mw.serviceframework;
using System;
using iih.en.pv.entdi.d;
using iih.ci.ord.i;

/********************************************************************************

** 作者： 杨敬本

** 创始时间：2016/10/27

** 修改人：杨敬本

** 修改时间：2016/10/28

** 描述：诊断证明数据处理

*********************************************************************************/

namespace iih.ci.ord.dicertificate.viewmodel
{
    public class DiCertificateTreeViewModel
    {
        private IEntdiproveCrudService service;
        private ICiOrdQryService ciOrdQryService;

        public LazyLoadTreeModel lazyLoadTreeModel;

        private EntDiProveDO[] arryEntDiProveDOs;
        public XapDataList<EntDiProveDO> lstEntDiProveDOs;

        public static UdidocDO[] udidocDOs_DiceType;
        public UdidocDO CurrUdidocDO_DiceType;

        public DiCertificateTreeViewModel()
        {
            service = XapServiceMgr.find<IEntdiproveCrudService>();
            ciOrdQryService = XapServiceMgr.find<ICiOrdQryService>();
            lstEntDiProveDOs = new XapDataList<EntDiProveDO>();

            getUdidocDOs();
        }

        /// <summary>
        /// 查询诊断证明数据
        /// </summary>
        /// <param name="id_ent"></param>
        public void LoadData(string id_ent)
        {
            string sql = string.Format(" id_ent='{0}'", id_ent);

            arryEntDiProveDOs = service.find(sql, "dt_diprove", false);
            lstEntDiProveDOs = new XapDataList<EntDiProveDO>(service, arryEntDiProveDOs);
        }

        /// <summary>
        /// 初始化诊断证明类型
        /// </summary>
        private void getUdidocDOs()
        {
            udidocDOs_DiceType = Utils.GetUdidocDOList(EnDictCodeTypeConst.SD_DICETP);
            foreach (UdidocDO udidoc in udidocDOs_DiceType)
            {
                //诊断证明
                if (udidoc.Code == EnDictCodeConst.SD_DICETP_DI)
                {
                    CurrUdidocDO_DiceType = udidoc;
                }
            }
        }

        /// <summary>
        /// 获取诊断证明类型
        /// </summary>
        /// <param name="code"></param>
        /// <returns></returns>
        public static UdidocDO GetDiprovetTp(string code)
        {
            foreach (UdidocDO udidoc in udidocDOs_DiceType)
            {
                if (udidoc.Code == code)
                {
                    return udidoc;
                }
            }

            return null;
        }

        /// <summary>
        /// 获取树节点数据
        /// </summary>
        public void GetTreeKeyModel()
        {
            var adapter1 = new KeyNodeDataAdapterFactory<UdidocDO>("Id_udidoc", "Id_udidoc") { CustomCaptionFunc = x => x.Name };
            var adapter2 = new KeyNodeDataAdapterFactory<EntDiProveDO>("Id_diprove", null, "Id_diprovetp") {
                CustomCaptionFunc = x => x.Name_emp + string.Format("{0}-{1:D2}-{2:D2}",((DateTime)x.Dt_diprove).Date.Year, ((DateTime)x.Dt_diprove).Date.Month, ((DateTime)x.Dt_diprove).Date.Day)
            };

            lazyLoadTreeModel = new LazyLoadTreeModel("");
            lazyLoadTreeModel.LazyLoadChildren = (oTree, bizNode) =>
            {
                if (bizNode.IsRoot)
                {
                    //根节点下加载诊断证明分类
                    foreach (var udi in udidocDOs_DiceType)
                    {
                        var data = adapter1.Wrap(udi);
                        oTree.AppendBizNode(bizNode, data);
                    }
                }
                else
                {
                    //在非根节点下加载数据节点
                    UdidocDO moduleDo = bizNode.UserObject as UdidocDO;
                    if (moduleDo != null && "1" == moduleDo.Ctrl1)
                    {
                        //在分类节点下，加载数据节点（非数据独一模式，独一模式没必要显示数据节点）
                        foreach (var item in lstEntDiProveDOs)
                        {
                            if (item.Id_diprovetp != null && moduleDo.Id_udidoc == item.Id_diprovetp)
                            {
                                var data = adapter2.Wrap(item);
                                oTree.AppendBizNode(bizNode, data);
                            }
                        }
                    }
                }
                return true;
            };

        }

        /// <summary>
        /// 获取独一模式分类下的数据（唯一）
        /// </summary>
        /// <param name="sd_DiProveType"></param>
        /// <returns></returns>
        public EntDiProveDO[] GetEntDiProveDOByDiProveType(string id_ent, string sd_DiProveType)
        {
            string sql = string.Format(" id_ent='{0}' and sd_diprovetp='{1}'", id_ent, sd_DiProveType);
            EntDiProveDO[] entDiProveDOs = service.find(sql, "dt_diprove", false);

            return entDiProveDOs;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sd_DiProveType"></param>
        /// <returns></returns>
        public EntDiProveDO GetEntDiProveDOByID(string id_diprove)
        {
            return service.findById(id_diprove);
        }

        /// <summary>
        /// 获取诊断明细拼接字符串
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        public string GetDiInfo(string id_ent)
        {
            string str = "";
            EntDiDO[] entDiDOs = ciOrdQryService.getEntDiDOList(id_ent);
            if (entDiDOs != null && entDiDOs.Length > 0)
            {
                int i = 1;
                foreach (EntDiDO item in entDiDOs)
                {
                    str += i + "." + item.Name_didef_dis ;
                    if (item.Fg_suspdi != null && item.Fg_suspdi.Value)
                    {
                        str += "?";
                    }
                    if (item.Supplement != null && item.Supplement.Length > 0)
                    {
                        str += "——" + item.Supplement;
                    }

                    str += "；";
                    i++;
                }
                str = str.Substring(0, str.LastIndexOf('；'));
            }

            return str;
        }

        /// <summary>
        /// 保存
        /// </summary>
        /// <param name="diDO"></param>
        public EntDiProveDO Save(EntDiProveDO diDO)
        {
            EntDiProveDO[] entDiProveDOs = service.save(new EntDiProveDO[] { diDO });
            return entDiProveDOs[0];
        }

        /// <summary>
        /// 更新
        /// </summary>
        /// <param name="diDO"></param>
        public void Update(EntDiProveDO diDO)
        {
            service.update(new EntDiProveDO[] { diDO });
        }

        /// <summary>
        /// 删除
        /// </summary>
        /// <param name="diDO"></param>
        public void Delete(EntDiProveDO diDO)
        {
            service.delete(new EntDiProveDO[] { diDO });
        }

    }
}

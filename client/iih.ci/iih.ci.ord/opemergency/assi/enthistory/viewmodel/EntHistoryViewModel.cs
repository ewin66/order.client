using System.Collections.Generic;
using System.Text;
using iih.en.pv.i;
using iih.en.pv.dto.d;
using xap.rui.bizcontrol.Historyofrecords.card;
using iih.ci.diag.cidiag.i;
using iih.ci.diag_stub.i;
using xap.sys.xbd.udi.i;
using xap.sys.xbd.udi.d;
using xap.mw.serviceframework;
using xap.mw.coreitf.d;
using iih.bd.bc.udi;
using xap.mw.core.data;
using iih.en.pv.entdi.d;

namespace iih.ci.ord.opemergency.assi.enthistory.viewmodel
{
    /// <summary>
    /// <para>描    述 : 就诊历史</para>
    /// <para>说    明 : </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.entphistory.viewmodel    </para>    
    /// <para>类 名 称 :  EntpHistoryViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/7/18 8:44:13</para>
    /// <para>更新时间 :  2016/7/18 8:44:13</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EntHistoryViewModel
    {
        #region 变量定义区域

        /// <summary>
        /// 就诊查询服务
        /// </summary>
        private IEnOutQryService service;
        /// <summary>
        /// 历史就诊诊断DTO
        /// </summary>
        private EntHisDiDTO[] entHisDiDTOs { get; set; }
        /// <summary>
        /// 记录展现列表
        /// </summary>
        public List<RecordCardInfo> Recordinfolist = new List<RecordCardInfo>();

        /// <summary>
        /// 诊断服务
        /// </summary>
        private ICidiagMDOCrudService cidaigMdoCrudService;

        /// <summary>
        /// 诊断保存服务
        /// </summary>
        private ICidiagMaintainService mainService;

        /// <summary>
        /// 诊断明细
        /// </summary>
        private ICidiagCrudService cidiagService;

        /// <summary>
        /// 字典项服务
        /// </summary>
        private IUdidocServiceExt usService;

        /// <summary>
        /// 诊断体系
        /// </summary>
        //private UdidocDO[] disysArr;

        #endregion

        /// <summary>
        /// 除就诊历史外使用
        /// </summary>
        public EntHistoryViewModel()
        {
            cidiagService = XapServiceMgr.find<ICidiagCrudService>();
            cidaigMdoCrudService = XapServiceMgr.find<ICidiagMDOCrudService>();
            mainService = XapServiceMgr.find<ICidiagMaintainService>();
            usService = XapServiceMgr.find<IUdidocServiceExt>();
        }

        /// <summary>
        /// 展现就诊历史时使用
        /// </summary>
        /// <param name="padId"></param>
        public EntHistoryViewModel(Ent4BannerDTO ent4BannerDTO)
        {
            service = XapServiceMgr.find<IEnOutQryService>();
            string codePat = ent4BannerDTO.Code_pat;
            string[] idEns = { ent4BannerDTO.Id_ent };

            if (!string.IsNullOrWhiteSpace(codePat))
            {
                entHisDiDTOs = service.GetHisEntDiList(codePat, FBoolean.False, FBoolean.True, idEns);
            }

            GetRecordInfoList();
        }

        #region 就诊历史列表相关方法

        /// <summary>
        /// 获取就诊历史
        /// </summary>
        /// <param name="recordInfo">就诊历史列表节点</param>
        /// <returns>就诊历史列表选中的就诊历史</returns>
        public EntHisDiDTO getEntHisDiDTO(RecordCardInfo recordInfo)
        {
            if (entHisDiDTOs != null && recordInfo != null && entHisDiDTOs.Length > 0)
            {
                foreach (EntHisDiDTO diDTO in entHisDiDTOs)
                {
                    if (diDTO.Id_ent == recordInfo.CardId)
                    {
                        return diDTO;
                    }
                }
            }
            return null;
        }

        /// <summary>
        /// 构造就诊历史列表数据
        /// </summary>
        private void GetRecordInfoList()
        {
            if (entHisDiDTOs != null && entHisDiDTOs.Length > 0)
            {
                foreach (EntHisDiDTO his in entHisDiDTOs)
                {
                    RecordCardInfo recordInfo = new RecordCardInfo
                    {
                        CardId = his.Id_ent,
                        VisitingTime = his.Dt_acpt.Value,
                        DepartmentName = his.Name_dep,
                        DoctorName = his.Name_emp,
                        // 门诊、急诊显示门诊图例
                        CardState = his.Code_entp == BdFcDictCodeConst.SD_CODE_ENTP_OP || his.Code_entp == BdFcDictCodeConst.SD_CODE_ENTP_ET ? CardState.Outpatient : CardState.hospitalization
                    };
                    recordInfo.DiagnosticResult = getDiagnostic(his.Di_array);
                    Recordinfolist.Add(recordInfo);
                }
            }
        }

        /// <summary>
        /// 得到诊断
        /// </summary>
        /// <param name="fList"></param>
        /// <returns></returns>
        private string getDiagnostic(FArrayList fList)
        {
            string diagnostic = null;
            if (fList != null && fList.Count > 0)
            {
                // 西医诊断
                StringBuilder sbXY = new StringBuilder();
                // 中医诊断
                StringBuilder sbZY = new StringBuilder();
                int xy = 1;
                int zy = 1;
                foreach (EntDiDO di in fList)
                {
                    if (CiDictCodeConst.ID_CI_DISYS_XYZDTX == di.Id_cdsystp)
                    {
                        sbXY.Append(string.Format("{0}. {1}", xy, di.Name_didef_dis));
                        if (!string.IsNullOrWhiteSpace(di.Supplement))
                        {
                            sbXY.Append(string.Format("——{0}", di.Supplement));
                        }
                        sbXY.Append("\n");
                        xy++;
                        continue;
                    }
                    if (CiDictCodeConst.ID_CI_DISYS_ZYZDTX == di.Id_cdsystp)
                    {
                        sbZY.Append(string.Format("{0}. {1}", zy, di.Name_didef_dis));
                        if (!string.IsNullOrWhiteSpace(di.Supplement))
                        {
                            sbZY.Append(string.Format("——{0}", di.Supplement));
                        }
                        sbZY.Append("\n");
                        zy++;
                        continue;
                    }
                }
                if (sbXY.Length > 0)
                {
                    diagnostic = string.Format("西医诊断\n{0}", sbXY.ToString());
                }
                if (sbZY.Length > 0)
                {
                    diagnostic = string.Format("{0}中医诊断\n{1}", diagnostic, sbZY.ToString());
                }
            }
            return diagnostic;
        }

        #endregion



        #region 医嘱相关方法

        #endregion



    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.i;
using xap.mw.serviceframework;
using iih.ci.ord.i;
using iih.en.pv.dto.d;
using xap.rui.appfw;
using iih.ci.ord.ordprn.d;
using iih.ci.ord.ordprn.i;
using xap.mw.coreitf.d;
using iih.ci.ord.dto.ordprintdto.d;
using System.Collections;
using xap.dp.optdesigner.Print.BatPrtContent;
using iih.ci.iih.ci.ord.ordprn.i;
using iih.ci.iih.ci.ord.dto.ordprintdto.d;
using iih.ci.ord.common.utils;
using xap.mw.core.data;

/********************************************************************************

** 作者： 杨敬本

** 创始时间：2016/8/10

** 修改人：杨敬本

** 修改时间：2016/8/10

** 描述：医嘱单打印数据处理模型

*********************************************************************************/

namespace iih.ci.ord.ciorder.ciorderprn.viewmodel
{
    public class OrdPrintViewModel
    {
        #region 变量定义区域
        /// <summary>
        /// 医嘱打印数据处理模型
        /// </summary>
        private OrdPrintDataViewModel viewModel;

        /// <summary>
        /// 预览/打印数据（各个场景）
        /// 打印模板数据源
        /// </summary>
        private OrdPrintDO[] arryOrdPrintDOsPreview;
        public OrdPrintDO[] ArryOrdPrintDOsPreview
        {
            get { return arryOrdPrintDOsPreview; }
            set { arryOrdPrintDOsPreview = value; }
        }

        /// <summary>
        /// 排序数据源（只对一般打印，未打数据排序）
        /// </summary>
        public XapDataList<OrdPrintDO> LstOrdPrintDOsPreview { get; set; }

        private Dictionary<string, DORowPrtFlags> dicDORowPrtFlagsPreview { get; set; }

        /// <summary>
        /// 预览/打印数据辅助参数
        /// 打印模板数据源
        /// </summary>
        private PrtDORowsAssist prtDORowsAssistPreview;
        public PrtDORowsAssist PrtDORowsAssistPreview
        {
            get { return prtDORowsAssistPreview; }
            set { prtDORowsAssistPreview = value; }
        }

        /// <summary>
        /// 打印保存数据（各个场景）
        /// </summary>
        private OrdPrintDO[] arryOrdPrintDOsPrint;

        /// <summary>
        /// 打印数据辅助参数
        /// </summary>
        private PrtDORowsAssist prtDORowsAssistPrint;

        /// <summary>
        /// 打印数据集分页（作废、停止）
        /// </summary>
        private List<List<OrdPrintDO>> lstOrdPrintDOsPrint;

        /// <summary>
        /// 打印数据行参数集（作废、停止）
        /// </summary>
        private List<List<DORowPrtFlags>> lstDORowPrtFlagsPrint;

        /// <summary>
        /// 打印数据集（单页补打）
        /// </summary>
        private List<OrdPrintDO> lstOrdPrintDOsSingle;

        /// <summary>
        /// 打印数据行参数集（单页补打）
        /// </summary>
        private List<DORowPrtFlags> lstDORowPrtFlagsSingle;
        #endregion

        #region 构造函数区域
        /// <summary>
        /// 构造函数
        /// </summary>
        public OrdPrintViewModel()
        {
            viewModel = new OrdPrintDataViewModel();
            LstOrdPrintDOsPreview = new XapDataList<OrdPrintDO>();
            dicDORowPrtFlagsPreview = new Dictionary<string, DORowPrtFlags>();
        }
        #endregion

        #region 对外接口区域
        /// <summary>
        /// 查询各场景打印预览数据
        /// </summary>
        /// <param name="id_en">就诊ID</param>
        /// <param name="isLong">长临标识</param>
        /// <param name="pageNum">页码</param>
        /// <param name="printMode">打印场景</param>
        public void LoadOrdPrintData(string id_en, bool? isLong, int? pageNum, string printMode)
        {
            switch (printMode)
            {
                case OrdPrintConst.PRINT_MODE_CONTINUE:
                    arryOrdPrintDOsPreview = viewModel.GetPreviewContinueOrds(id_en, isLong, getMaxPageNum(id_en, isLong), out prtDORowsAssistPreview);//一般打印
                    break;
                case OrdPrintConst.PRINT_MODE_RESET:
                    arryOrdPrintDOsPreview = viewModel.GetPreviewResetOrds(id_en, isLong, getMaxPageNum(id_en, isLong), out prtDORowsAssistPreview);//重整打印
                    break;
                case OrdPrintConst.PRINT_MODE_CANCEL:
                    arryOrdPrintDOsPreview = viewModel.GetPreviewCancelOrds(id_en, isLong, out lstOrdPrintDOsPrint,out lstDORowPrtFlagsPrint, out prtDORowsAssistPreview);//撤销打印
                    break;
                case OrdPrintConst.PRINT_MODE_STOP:
                    arryOrdPrintDOsPreview = viewModel.GetPreviewStopOrds(id_en, isLong, out lstOrdPrintDOsPrint,out lstDORowPrtFlagsPrint, out prtDORowsAssistPreview);//停止打印
                    break;
                case OrdPrintConst.PRINT_MODE_SINGLE:
                    arryOrdPrintDOsPreview = viewModel.GetPreviewSignleOrds(id_en, isLong, (int)pageNum, out lstOrdPrintDOsSingle, out lstDORowPrtFlagsSingle, out prtDORowsAssistPreview);//单页补打
                    break;
                case OrdPrintConst.PRINT_MODE_ALLBROWSE:
                    arryOrdPrintDOsPreview = viewModel.GetPreviewAllPrtedOrds(id_en, isLong, out prtDORowsAssistPreview);//浏览全部已打数据
                    break;
                default:
                    prtDORowsAssistPreview = new PrtDORowsAssist(0);
                    break;
            }
        }

        /// <summary>
        /// 获取排序数据集
        /// 一般打印时，未打数据
        /// </summary>
        public void GetDataListForSort()
        {
            //获取排序数据集
            LstOrdPrintDOsPreview = new XapDataList<OrdPrintDO>();
            dicDORowPrtFlagsPreview.Clear();
            DORowPrtFlags[] doRowPrtFlags = prtDORowsAssistPreview.GetDoFlagsArr();
            for (int i = 0; i < ArryOrdPrintDOsPreview.Length; i++)
            {
                if (ArryOrdPrintDOsPreview[i] != null && ArryOrdPrintDOsPreview[i].Id_orprn == null)
                {
                    LstOrdPrintDOsPreview.Add(ArryOrdPrintDOsPreview[i]);
                    //以id_or为标记，暂存行标记参数
                    if (!dicDORowPrtFlagsPreview.ContainsKey(ArryOrdPrintDOsPreview[i].Id_or))
                        dicDORowPrtFlagsPreview.Add(ArryOrdPrintDOsPreview[i].Id_or, doRowPrtFlags[i]);
                }
            }
        }

        /// <summary>
        /// 更新预览数据源（排序）
        /// </summary>
        public void UpdateOrdPrintDOsOrder()
        {
            if (LstOrdPrintDOsPreview == null) return;
            arryOrdPrintDOsPreview = LstOrdPrintDOsPreview.ToArray();
            List<DORowPrtFlags> lstDORowPrtFlags = new List<DORowPrtFlags>();
            for (int i = 0; i < arryOrdPrintDOsPreview.Length; i++)
            {
                DORowPrtFlags rowFlag = new DORowPrtFlags();
                DORowPrtFlags rowFlagOrg = dicDORowPrtFlagsPreview[arryOrdPrintDOsPreview[i].Id_or];
                rowFlag.ForceAfterToNewPage = rowFlagOrg.ForceAfterToNewPage;
                rowFlag.ForceInOneGridRow = rowFlagOrg.ForceInOneGridRow;
                rowFlag.MarkType = rowFlagOrg.MarkType;
                rowFlag.InvalidPrtType = rowFlagOrg.InvalidPrtType;
                rowFlag.IsDataRemedy = rowFlagOrg.IsDataRemedy;
                lstDORowPrtFlags.Add(rowFlag);
            }
            prtDORowsAssistPreview = new PrtDORowsAssist(lstDORowPrtFlags);
        }

        /// <summary>
        /// 从预览数据中筛选出打印保存数据
        /// </summary>
        /// <param name="id_dep_prn"></param>
        /// <param name="id_emp_prn"></param>
        /// <param name="printMode"></param>
        public void GetPrintDOsFromPreviewDOs(string id_dep_prn, string id_emp_prn, string printMode)
        {
            List<OrdPrintDO> lstOrdPrintDOs = new List<OrdPrintDO>();//未打印数据
            List<DORowPrtFlags> lstDORowPrtFlags = new List<DORowPrtFlags>();//未打印数据的标记参数
            DORowPrtFlags[] rowFlagsPreview = prtDORowsAssistPreview.GetDoFlagsArr();//预览后返回的标记参数集
            switch (printMode)
            {
                case OrdPrintConst.PRINT_MODE_CONTINUE:
                case OrdPrintConst.PRINT_MODE_RESET:
                    getPrintDOsConAndRes(rowFlagsPreview, id_dep_prn, id_emp_prn, lstOrdPrintDOs, lstDORowPrtFlags, printMode);
                    break;
                case OrdPrintConst.PRINT_MODE_CANCEL:
                case OrdPrintConst.PRINT_MODE_STOP:
                    getPrintDOsStpAndCal(lstOrdPrintDOs, lstDORowPrtFlags);
                    break;
                case OrdPrintConst.PRINT_MODE_SINGLE:
                    getPrintDOsSingle(lstOrdPrintDOs, lstDORowPrtFlags);
                    break;
                
            }
            arryOrdPrintDOsPrint = lstOrdPrintDOs.ToArray();
            prtDORowsAssistPrint = new PrtDORowsAssist(lstDORowPrtFlags);
        }

        /// <summary>
        /// 保存打印数据
        /// </summary>
        public void SavePrintData(string printMode)
        {
            switch (printMode)
            {
                case OrdPrintConst.PRINT_MODE_CONTINUE:
                case OrdPrintConst.PRINT_MODE_CANCEL:
                case OrdPrintConst.PRINT_MODE_STOP:
                case OrdPrintConst.PRINT_MODE_SINGLE:
                    arryOrdPrintDOsPrint = viewModel.SaveOrdPrintDOs(arryOrdPrintDOsPrint);
                    break;
                case OrdPrintConst.PRINT_MODE_RESET:
                    arryOrdPrintDOsPrint = viewModel.SaveResretOrdPrintDO(arryOrdPrintDOsPrint);
                    break;
                default:
                    break;
            }
        }

        /// <summary>
        /// 获取打印提示信息
        /// </summary>
        /// <param name="printMode"></param>
        /// <returns></returns>
        public string GetPrintTipInfo(string printMode)
        {
            string strInfo = "";
            List<string> lstPageNums = new List<string>();
            int pageCount = 0;
            string strPageNums = "";
            string strPageCount = "";

            switch (printMode)
            {
                case OrdPrintConst.PRINT_MODE_CONTINUE:
                case OrdPrintConst.PRINT_MODE_RESET:
                    DORowPrtFlags[] rowFlagsPreview = prtDORowsAssistPreview.GetDoFlagsArr();
                    if (arryOrdPrintDOsPreview[0].Row_cnt != null && arryOrdPrintDOsPreview[0].Row_cnt > 0)
                    {
                        lstPageNums.Add((rowFlagsPreview[0].AtPageIx + 1).ToString());
                        pageCount = (rowFlagsPreview[arryOrdPrintDOsPreview.Length - 1].AtPageIx - rowFlagsPreview[0].AtPageIx);
                    }
                    else
                    {
                        pageCount = (rowFlagsPreview[arryOrdPrintDOsPreview.Length - 1].AtPageIx - rowFlagsPreview[0].AtPageIx + 1);
                    }
                    break;
                case OrdPrintConst.PRINT_MODE_CANCEL:
                case OrdPrintConst.PRINT_MODE_STOP:
                    for (int i = 0; i < lstDORowPrtFlagsPrint.Count; i++)
                    {
                        lstPageNums.Add((lstDORowPrtFlagsPrint[i][0].AtPageIx + 1).ToString());
                    }
                    break;
                case OrdPrintConst.PRINT_MODE_SINGLE:
                    pageCount = 1;
                    break;
            }

            lstPageNums.Sort();
            StringBuilder sb = new StringBuilder();
            if (lstPageNums.Count > 0)
            {
                for (int i = 0; i < lstPageNums.Count; i++)
                {
                    if (i > 0)
                        sb.Append('、');
                    sb.Append('{');
                    sb.Append(i.ToString());
                    sb.Append('}');
                }
                strPageNums = String.Format("第" + sb.ToString() + "页", lstPageNums.ToArray());
            }
            if (pageCount > 0)
            {
                strPageCount = pageCount.ToString() + "张空白页";
            }

            if (lstPageNums.Count > 0 && pageCount > 0)
            {
                strInfo = strPageNums + "和" + strPageCount;
            }
            else if (lstPageNums.Count > 0 && 0 == pageCount)
            {
                strInfo = strPageNums;
            }
            else if (lstPageNums.Count == 0 && pageCount > 0)
            {
                strInfo = strPageCount;
            }

            strInfo = "请把" + strInfo + "放入打印机！";
            return strInfo;
        }

        /// <summary>
        /// 清空指定页码之后的数据（包含此页）
        /// </summary>
        /// <param name="pageNum"></param>
        public void ClearDataPrtedByPage(int? pageNum)
        {
            List<OrdPrintDO> lstOrdPrintDOs = new List<OrdPrintDO>();
            for (int i = 0; i < arryOrdPrintDOsPreview.Length; i++)
            {
                if (arryOrdPrintDOsPreview[i].Page_num != null && arryOrdPrintDOsPreview[i].Page_num >= pageNum)
                {
                    lstOrdPrintDOs.Add(arryOrdPrintDOsPreview[i]);
                }
            }
            viewModel.DeleteOrdPrintDOs(lstOrdPrintDOs.ToArray());
        }
        #endregion

        #region 私有方法区域
        /// <summary>
        /// 取出需要保存的数据,赋给页号、行号、行数、打印日期、打印部门、打印人员（从打印辅助参数中）
        /// 一般续打/重整打印
        /// </summary>
        /// <param name="doRowPrtFlags"></param>
        /// <param name="id_dep_prn"></param>
        /// <param name="id_emp_prn"></param>
        /// <param name="lstOrdPrintDOs"></param>
        /// <param name="lstDORowPrtFlags"></param>
        private void getPrintDOsConAndRes(DORowPrtFlags[] doRowPrtFlags, string id_dep_prn, string id_emp_prn, List<OrdPrintDO> lstOrdPrintDOs, List<DORowPrtFlags> lstDORowPrtFlags, string printMode)
        {
            for (int i = 0; i < arryOrdPrintDOsPreview.Length; i++)
            {
                //未打印的数据Id_orprn为null，新增
                if (arryOrdPrintDOsPreview[i].Id_orprn == null)
                {
                    arryOrdPrintDOsPreview[i].Page_num = doRowPrtFlags[i].AtPageIx;
                    arryOrdPrintDOsPreview[i].Row_num = doRowPrtFlags[i].AtGridRowIx;
                    arryOrdPrintDOsPreview[i].Row_cnt = doRowPrtFlags[i].TakeGridRowCnt;
                    arryOrdPrintDOsPreview[i].Dt_prn = DateTime.Now;
                    arryOrdPrintDOsPreview[i].Id_dep_prn = id_dep_prn;
                    arryOrdPrintDOsPreview[i].Id_emp_prn = id_emp_prn;
                    arryOrdPrintDOsPreview[i].Fg_stop_prn = arryOrdPrintDOsPreview[i].Fg_chk_stop;
                    arryOrdPrintDOsPreview[i].Fg_canc_prn = arryOrdPrintDOsPreview[i].Fg_chk_canc;
                    arryOrdPrintDOsPreview[i].Fg_reformed = FBoolean.False;
                    arryOrdPrintDOsPreview[i].Fg_reformrow = arryOrdPrintDOsPreview[i].Fg_reformrow == true;
                    arryOrdPrintDOsPreview[i].Status = DOStatus.NEW;
                }
                else
                {
                    if (printMode == OrdPrintConst.PRINT_MODE_RESET)
                    {
                        arryOrdPrintDOsPreview[i].Fg_reformed = FBoolean.True;
                        arryOrdPrintDOsPreview[i].Dt_reform = DateTime.Now;
                    }
                    arryOrdPrintDOsPreview[i].Status = DOStatus.UPDATED;
                }
                lstOrdPrintDOs.Add(arryOrdPrintDOsPreview[i]);
                lstDORowPrtFlags.Add(doRowPrtFlags[i]);
            }
        }

        /// <summary>
        /// 获取作废or停止的打印数据
        /// </summary>
        /// <param name="lstOrdPrintDOs"></param>
        /// <param name="lstDORowPrtFlags"></param>
        private void getPrintDOsStpAndCal(List<OrdPrintDO> lstOrdPrintDOs, List<DORowPrtFlags> lstDORowPrtFlags)
        {
            for (int i = 0; i < lstOrdPrintDOsPrint.Count; i++)
            {
                for (int j = 0; j < lstOrdPrintDOsPrint[i].Count; j++)
                {
                    lstOrdPrintDOsPrint[i][j].Status = DOStatus.UPDATED;
                    lstOrdPrintDOs.Add(lstOrdPrintDOsPrint[i][j]);
                    lstDORowPrtFlags.Add(lstDORowPrtFlagsPrint[i][j]);
                }
            }
        }

        /// <summary>
        /// 获取单页补打的打印数据
        /// </summary>
        /// <param name="lstOrdPrintDOs"></param>
        /// <param name="lstDORowPrtFlags"></param>
        private void getPrintDOsSingle(List<OrdPrintDO> lstOrdPrintDOs, List<DORowPrtFlags> lstDORowPrtFlags)
        {
            for (int i = 0; i < lstOrdPrintDOsSingle.Count; i++)
            {
                lstOrdPrintDOsSingle[i].Status = DOStatus.UPDATED;
                lstOrdPrintDOs.Add(lstOrdPrintDOsSingle[i]);
                lstDORowPrtFlags.Add(lstDORowPrtFlagsSingle[i]);
            }
        }

        /// <summary>
        /// 获取已经打印的最后一页页码
        /// </summary>
        /// <param name="id_en"></param>
        /// <param name="isLong"></param>
        /// <returns></returns>
        private int getMaxPageNum(string id_en, bool? isLong)
        {
            //获取最大页码
            int[] pageNums = viewModel.GetPageNums(id_en, isLong);
            int maxPageNum = 0;
            if (pageNums != null && pageNums.Length > 0)
            {
                ArrayList lstPageNums = new ArrayList(pageNums);
                lstPageNums.Sort();
                maxPageNum = Convert.ToInt32(lstPageNums[lstPageNums.Count - 1]);
            }
            return maxPageNum;
        }
        #endregion
    }
}

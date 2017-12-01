
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ordprn.d;
using iih.ci.ord.dto.ordprintdto.d;
using xap.mw.coreitf.d;
using iih.ci.ord.ordprn.i;
using xap.mw.serviceframework;
using iih.ci.iih.ci.ord.dto.ordprintdto.d;
using iih.ci.iih.ci.ord.ordprn.i;
using iih.ci.ord.common.utils;
using xap.dp.optdesigner.Print.BatPrtContent;
using xap.mw.core.data;
using xap.rui.appfw;

namespace iih.ci.ord.ciorder.ciorderprn.viewmodel
{
    /// <summary>
    /// <para>描    述 : 医嘱打印数据构造类</para>
    /// <para>说    明 : </para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.ciorderprn.viewmodel</para>    
    /// <para>类 名 称 :  OrdPrintDataViewModel	</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/8/18 17:13:14</para>
    /// <para>更新时间 :  2016/8/18 17:13:14</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OrdPrintDataViewModel
    {

        #region 变量定义区域

        /// <summary>
        /// 医嘱打印数据服务接口
        /// </summary>
        private IOrdprintCrudService ordPrintService;

        /// <summary>
        /// 医嘱打印数据扩展服务接口
        /// </summary>
        private IOrdprintExtService ordPrintExtService;
        
        /// <summary>
        /// 配置信息
        /// </summary>
        private OrdPrintCfgViewModel cfgViewModel;

        /// <summary>
        /// 打印签署签字时进行拷贝的属性（签署医生、核对护士）
        /// </summary>
        private static string[] propertiesSign = new string[] { "Id_emp_sign", "Code_emp_sign", "Name_emp_sign", "Id_dep_sign", "Id_emp_chk", "Code_emp_chk", "Name_emp_chk", "Id_dep_chk" };

        /// <summary>
        /// 打印停止签字时进行拷贝的属性（停止医生、核对护士）
        /// </summary>
        private static string[] propertiesSignStop = new string[] { "Id_emp_stop", "Code_emp_stop", "Name_emp_stop", "Id_dep_stop", "Id_emp_chk_stop", "Code_emp_chk_stop", "Name_emp_chk_stop", "Id_dep_chk_stop" };

        /// <summary>
        /// 重整标记行对应的OrdPrintDO对象拷贝时排除的属性
        /// </summary>
        private static string[] propertiesReset = new string[] { "Id_or", "Id_srvtp", "Sd_srvtp", "Content_or_prn", "Dt_effe", "Dt_effe_m", "Dt_effe_d", "Dt_effe_t", 
            "Id_emp_sign","Code_emp_sign","Name_emp_sign","Id_dep_sign","Code_dep_sign","Name_dep_sign","Fg_chk","Id_emp_chk","Code_emp_chk","Name_emp_chk","Id_dep_chk","Code_dep_chk","Name_dep_chk","Dt_end","Dt_end_m","Dt_end_d","Dt_end_t","Id_emp_stop","Code_emp_stop","Name_emp_stop",
            "Id_dep_stop","Code_dep_stop","Name_dep_stop","Fg_stop_prn","Fg_chk_stop","Id_emp_chk_stop","Code_emp_chk_stop","Name_emp_chk_stop","Id_dep_chk_stop","Code_dep_chk_stop","Name_dep_chk_stop","Fg_canc_prn","Dt_mp"};
        #endregion

        #region 构造函数区域

        public OrdPrintDataViewModel()
        {

            ordPrintService = XapServiceMgr.find<IOrdprintCrudService>();
            ordPrintExtService = XapServiceMgr.find<IOrdprintExtService>();

            cfgViewModel = new OrdPrintCfgViewModel();

        }

        #endregion

        #region 对外服务接口
        /// <summary>
        /// 获取一般续打展现数据
        /// </summary>
        /// <param name="idEn">就诊id </param>
        /// <param name="fgLong">长临标识</param>
        /// <param name="pageNum">已打印最后一页的页码，第一页为0</param>
        /// <param name="rowAssist">返回一般打印数据集合标记参数</param>
        /// <returns>返回一般打印数据集合</returns>
        public OrdPrintDO[] GetPreviewContinueOrds(string idEn, FBoolean fgLong, int pageNum, out PrtDORowsAssist rowAssist)
        {
            // 构造请求参数
            OrdPrintParamDTO paramDTO = this.getOrdPrintParamDTO(idEn, fgLong, pageNum, OrdPrintConst.PRINT_MODE_CONTINUE);
            return getPreviewConAndResOrds(paramDTO, out rowAssist);
        }

        /// <summary>
        /// 获取重整打印展现数据
        /// </summary>
        /// <param name="idEn">就诊id</param>
        /// <param name="fgLong">长临标识</param>
        /// <param name="pageNum">最后一页页码，第一页为0</param>
        /// <param name="rowAssist">返回重整打印数据集合标记参数</param>
        /// <returns>返回重整打印对应的数据集合</returns>
        public OrdPrintDO[] GetPreviewResetOrds(string idEn, FBoolean fgLong, int pageNum, out PrtDORowsAssist rowAssist)
        {
            // 构造请求参数
            OrdPrintParamDTO paramDTO = this.getOrdPrintParamDTO(idEn, fgLong, pageNum, OrdPrintConst.PRINT_MODE_RESET);
            return getPreviewConAndResOrds(paramDTO, out rowAssist);
        }

        /// <summary>
        /// 获取撤销打印展现数据
        /// </summary>
        /// <param name="idEn">就诊id</param>
        /// <param name="fgLong">长临标识</param>
        /// <param name="ordPrintList">返回撤销打印实际打印数据,外出list的每个元素为一页中需要打印的数据</param>
        /// <param name="rowAssist">撤销打印预览的辅助参数</param>
        /// <returns>返回撤销打印预览数据</returns>
        public OrdPrintDO[] GetPreviewCancelOrds(string idEn, FBoolean fgLong, out List<List<OrdPrintDO>> ordPrintList, out List<List<DORowPrtFlags>> dORowPrtFlagsPrintList, out PrtDORowsAssist rowAssist)
        {
            // 构造请求参数
            OrdPrintParamDTO paramDTO = this.getOrdPrintParamDTO(idEn, fgLong, -1, OrdPrintConst.PRINT_MODE_CANCEL);
            return this.getPreviewCalAndStpOrds(paramDTO, out ordPrintList, out dORowPrtFlagsPrintList, out rowAssist);
        }

        /// <summary>
        /// 获取停止打印展现数据
        /// </summary>
        /// <param name="idEn">就诊id</param>
        /// <param name="fgLong">长临标识</param>
        /// <param name="ordPrintDos">返回停止打印数据</param>
        /// <param name="rowAssist">停止打印预览的辅助参数</param>
        /// <returns>返回停止打印预览数据</returns>
        public OrdPrintDO[] GetPreviewStopOrds(string idEn, FBoolean fgLong, out List<List<OrdPrintDO>> ordPrintList, out List<List<DORowPrtFlags>> dORowPrtFlagsPrintList, out PrtDORowsAssist rowAssist)
        {
            // 构造请求参数
            OrdPrintParamDTO paramDTO = this.getOrdPrintParamDTO(idEn, fgLong, -1, OrdPrintConst.PRINT_MODE_STOP);
            return this.getPreviewCalAndStpOrds(paramDTO, out ordPrintList, out dORowPrtFlagsPrintList, out rowAssist);
        }

        /// <summary>
        /// 单页补打
        /// </summary>
        /// <param name="idEn">就诊id</param>
        /// <param name="fgLong">长临标识</param>
        /// <param name="pageNum">页码</param>
        /// <param name="detailDOAssist">预览辅助参数</param>
        /// <returns></returns>
        public OrdPrintDO[] GetPreviewSignleOrds(string idEn, FBoolean fgLong, int pageNum, out List<OrdPrintDO> ordPrintList, out List<DORowPrtFlags> rowFlagsList, out PrtDORowsAssist detailDOAssist)
        {
            // 构造请求参数
            OrdPrintParamDTO paramDTO = this.getOrdPrintParamDTO(idEn, fgLong, pageNum, OrdPrintConst.PRINT_MODE_SINGLE);
            return this.getPreviewSingleOrds(paramDTO, out ordPrintList, out rowFlagsList, out detailDOAssist);
        }

        /// <summary>
        /// 根据就诊Id获取已经打印的全部医嘱数据
        /// <para>获取表ci_or_prn中数据</para>
        /// </summary>
        /// <param name="idEn">就诊id</param>
        /// <param name="fgLong">长期医嘱、临时医嘱标识</param>
        /// <returns>返回本次就诊全部已打印的数据</returns>
        public OrdPrintDO[] GetPreviewAllPrtedOrds(string idEn, FBoolean fgLong, out PrtDORowsAssist rowAssist)
        {
            List<object> args = new List<object>();
            args.Add(idEn);
            args.Add(fgLong);

            StringBuilder builder = new StringBuilder();
            builder.Append("Id_en = '{0}' and Fg_long = '{1}'");
           // builder.Append("Id_en = '{0}' and Fg_long = '{1}' and Id_orprn='0001Z7100000000E2YD6'");

            string condition = string.Format(builder.ToString(), args.ToArray());

            string orderBy = "Page_num,Row_num";

            OrdPrintDO[] printDOsAll = ordPrintService.find(condition, orderBy, FBoolean.False);

            // 所有展现数据的标记参数
            rowAssist = new PrtDORowsAssist(printDOsAll.Length);
            DORowPrtFlags[] doprtflags = rowAssist.GetDoFlagsArr();

            for (int i = 0; i < printDOsAll.Length; i++)
            {
                doprtflags[i].AtPageIx = (int)printDOsAll[i].Page_num; // 所在页码
                doprtflags[i].AtGridRowIx = (int)printDOsAll[i].Row_num; // 所在行号
                doprtflags[i].TakeGridRowCnt = 0;//
                if (printDOsAll[i].Fg_reformrow == FBoolean.True)
                {
                    doprtflags[i].ForceInOneGridRow = true;// 重整标识行不换行
                    doprtflags[i].MarkType = DORowPrtFlags.ENumMarkType.Text;//重整标记行内容标红
                }
                //根据作废打印标识Fg_canc_prn，判断是否打印过作废线，
                //打印过作废线的同时显示内容和作废线（置灰），否则只显示内容（置灰）
                doprtflags[i].InvalidPrtType = printDOsAll[i].Fg_canc_prn == true ? DORowPrtFlags.ENumInvalidPrtType.TextWithDelLine : DORowPrtFlags.ENumInvalidPrtType.NotInvalid;
                //
                doprtflags[i].IsDataRemedy = (bool)printDOsAll[i].Fg_stop_prn;
            }

            return printDOsAll;
        }

        /// <summary>
        /// 获取已打印的医嘱页码
        /// </summary>
        /// <param name="idEn">就诊id</param>
        /// <param name="fgLong">长临标识</param>
        /// <returns></returns>
        public int[] GetPageNums(string idEn, FBoolean fgLong)
        {
            OrdPrintParamDTO paramDTO = this.getOrdPrintParamDTO(idEn, fgLong, -1, null);
            return ordPrintExtService.GetPageNums(paramDTO);
        }

        /// <summary>
        /// 保存打印医嘱（续打、停止、作废、补打）
        /// </summary>
        /// <param name="ordPrintDOsPrint"></param>
        /// <returns></returns>
        public OrdPrintDO[] SaveOrdPrintDOs(OrdPrintDO[] ordPrintDOsPrint)
        {
            return ordPrintService.save(ordPrintDOsPrint);
        }

        /// <summary>
        /// 保存重整打印医嘱
        /// </summary>
        /// <param name="ordPrintDOs">重整后的医嘱OrdPrintDO集合</param>
        /// <returns></returns>
        public OrdPrintDO[] SaveResretOrdPrintDO(OrdPrintDO[] ordPrintDOs)
        {
            List<object> args = new List<object>();
            args.Add(ordPrintDOs[0].Id_en);
            args.Add((FBoolean)ordPrintDOs[0].Fg_long);
            args.Add(ordPrintDOs[0].Page_num);
            StringBuilder builder = new StringBuilder();
            builder.Append("Id_en = '{0}' and Fg_long = '{1}' and Page_num < {2} and Fg_reformed = 'N'");
            //builder.Append("Id_en = '{0}' and Fg_long = '{1}' and Fg_reformed = 'N'");

            string condition = string.Format(builder.ToString(), args.ToArray());

            string orderBy = "Page_num,Row_num";

            //查询重整第一页之前的已打印医嘱
            OrdPrintDO[] ordPrintDOsUpdate = ordPrintService.find(condition, orderBy, FBoolean.False);
            XapDataList<OrdPrintDO> lstPrintDOsUpdate = new XapDataList<OrdPrintDO>();

            for (int i = 0; i < ordPrintDOsUpdate.Length; i++)
            {
                ordPrintDOsUpdate[i].Fg_reformed = FBoolean.True;
                ordPrintDOsUpdate[i].Dt_reform = ordPrintDOs[0].Dt_reform != null ? ordPrintDOs[0].Dt_reform : DateTime.Now;
                ordPrintDOsUpdate[i].Status = DOStatus.UPDATED;
                lstPrintDOsUpdate.Add(ordPrintDOsUpdate[i]);
            }

            ordPrintService.update(lstPrintDOsUpdate.ToArray());

            return ordPrintService.save(ordPrintDOs);
        }

        /// <summary>
        /// 删除已打印数据
        /// </summary>
        /// <param name="ordPrintDOs"></param>
        public void DeleteOrdPrintDOs(OrdPrintDO[] ordPrintDOs)
        {
            ordPrintExtService.DeleteOrdPrintDOs(ordPrintDOs);
        }

        #endregion

        #region 私有方法区域
        /// <summary>
        /// 获取一般续打/重整打印展现数据
        /// </summary>
        /// <param name="paramDTO">打印参数</param>
        /// <param name="rowAssist">返回一般打印数据集合标记参数</param>
        /// <returns></returns>
        private OrdPrintDO[] getPreviewConAndResOrds(OrdPrintParamDTO paramDTO, out PrtDORowsAssist rowAssist)
        {
            // 获取待打印数据
            OrdPrintDataDTO[] ordPrintDataDTOsToPrt = ordPrintExtService.GetOrdPrintDataDTOs(paramDTO);

            //待打印数据为空,直接返回
            if (ordPrintDataDTOsToPrt.Length == 0)
            {
                rowAssist = new PrtDORowsAssist(0);
                return ordPrintDataDTOsToPrt;
            }

            // 获取已打印的最后一页数据
            OrdPrintDO[] ordPrintDOsPrted = this.getPrtedOrdsByPage(paramDTO.Id_en, paramDTO.Fg_long, new List<int>() { (int)paramDTO.Page_num });

            // 获取已打印的最后一页需要补打作废线或停止时间的数据
            OrdPrintDataDTO[] ordPrintDataDTOsPrted = this.getCancAndStopSingleOrds(paramDTO.Id_en, paramDTO.Fg_long, (int)paramDTO.Page_num);

            List<DORowPrtFlags> rowFlagList = new List<DORowPrtFlags>();

            //整合已打印数据、未打印数据，设置标记参数，返回展示数据
            OrdPrintDO[] ordPrintDOsConAndRes = this.mergeOrdPrintDOsConAndRes(ordPrintDOsPrted, ordPrintDataDTOsPrted, ordPrintDataDTOsToPrt, ref rowFlagList, paramDTO.Print_mode == OrdPrintConst.PRINT_MODE_RESET);

            rowAssist = new PrtDORowsAssist(rowFlagList);

            return ordPrintDOsConAndRes;
        }

        /// <summary>
        /// 整合需要显示的已打印数据、待打印数据（重整包括重整标记行），设置待打医嘱数据标志、以及待打印数据的打印参数
        /// </summary>
        /// <param name="ordPrintDOsPrted">已打印医嘱数据</param>
        /// <param name="ordPrintDataDTOsPrted">已打印医嘱数据中，需要补打作废线和停止时间的数据</param>
        /// <param name="ordPrintDataDTOsToPrt">待打印医嘱数据</param>
        /// <param name="rowFlagList">返回行标记参数</param>
        /// <param name="bReset">续打or重整</param>
        /// <returns></returns>
        private OrdPrintDO[] mergeOrdPrintDOsConAndRes(OrdPrintDO[] ordPrintDOsPrted, OrdPrintDataDTO[] ordPrintDataDTOsPrted, OrdPrintDataDTO[] ordPrintDataDTOsToPrt, ref List<DORowPrtFlags> rowFlagList, bool bReset)
        {
            //一般续打/重整整体数据集合
            List<OrdPrintDO> ordPrintDOsConAndResList = new List<OrdPrintDO>();

            #region 已打印数据
            // 已打印的最后一条数据
            OrdPrintDO ordPrintDOLast = null;
            // 科室/病区/床位更换前的最后一行医嘱的行标记参数
            DORowPrtFlags rowPrtFlagLast = null;
            // 如果已经存在打印数据，取最后一行，否则为空
            if (ordPrintDOsPrted != null && ordPrintDOsPrted.Length > 0)
            {
                ordPrintDOLast = ordPrintDOsPrted[ordPrintDOsPrted.Length - 1];
            }

            // 需要补打作废线or停止时间的医嘱字典（医嘱id_or为键）
            Dictionary<string, OrdPrintDataDTO> ordPrintDataDTOsPrtedDic = new Dictionary<string, OrdPrintDataDTO>();
            if (!bReset && ordPrintDataDTOsPrted != null && ordPrintDataDTOsPrted.Length > 0)
            {
                foreach (OrdPrintDataDTO dataDTO in ordPrintDataDTOsPrted)
                {
                    //排除重复id_or
                    if (!ordPrintDataDTOsPrtedDic.ContainsKey(dataDTO.Id_or))
                        ordPrintDataDTOsPrtedDic.Add(dataDTO.Id_or, dataDTO);
                }
            }

            //TODO 如果待打印树第一行不是换页标记，则显示已打印数据，否则不显示已打数据
            // 待打印数据第一条页码，如果已打数据不是打印到纸张最后一行（需要换纸），则待打印数据不设置该值
            int pageNum = 0;
            // 是否需要新启动一页打印
            // 如果是新起一页打印，rowAssist为待打印数据信息数组，否则为已打印、待打印页面、行号、所在行信息
            bool isNewPage = this.isUseNewPage(ordPrintDOLast, ref pageNum);
            //不是新起一页，则需要显示已打印数据最后一页的数据，置灰显示
            if (!isNewPage)
            {
                ordPrintDOsConAndResList.AddRange(ordPrintDOsPrted);

                // 对已打印数据设置标记参数的页码、行号、行数、打印作废标记
                for (int i = 0; i < ordPrintDOsConAndResList.Count; i++)
                {
                    DORowPrtFlags rowFlag = new DORowPrtFlags();
                    rowFlag.AtPageIx = (int)ordPrintDOsConAndResList[i].Page_num;
                    rowFlag.AtGridRowIx = (int)ordPrintDOsConAndResList[i].Row_num;
                    rowFlag.TakeGridRowCnt = (int)ordPrintDOsConAndResList[i].Row_cnt;
                    //根据作废打印标识Fg_canc_prn，判断是否打印过作废线，
                    //打印过作废线的同时显示内容和作废线（置灰），否则只显示内容（置灰）
                    rowFlag.InvalidPrtType = ordPrintDOsConAndResList[i].Fg_canc_prn == true ? DORowPrtFlags.ENumInvalidPrtType.HasPrted : DORowPrtFlags.ENumInvalidPrtType.NotInvalid;
                    //判断在已打印数据中，是否有需要补打作废线or停止时间
                    if (!bReset && ordPrintDataDTOsPrtedDic.ContainsKey(ordPrintDOsConAndResList[i].Id_or))
                    {
                        //需要补打停止时间的：停止时间、医生、护士
                        if (ordPrintDataDTOsPrtedDic[ordPrintDOsConAndResList[i].Id_or].Fg_chk_stop == true)
                        {
                            rowFlag.IsDataRemedy = true;
                            ordPrintDOsConAndResList[i].Fg_chk_stop = FBoolean.True;//停止标识
                            ordPrintDOsConAndResList[i].Fg_stop_prn = FBoolean.True;//停止打印标识
                            this.setOrdPrintDatetime(ordPrintDataDTOsPrtedDic[ordPrintDOsConAndResList[i].Id_or], ordPrintDOsConAndResList[i]);//设置停止时间
                        }
                        //需要补打作废线的：作废线（黑）、内容（置灰）
                        if (ordPrintDataDTOsPrtedDic[ordPrintDOsConAndResList[i].Id_or].Fg_chk_canc == true)
                        {
                            ordPrintDOsConAndResList[i].Fg_chk_canc = FBoolean.True;//作废标识
                            ordPrintDOsConAndResList[i].Fg_canc_prn = FBoolean.True;//作废打印标识
                            rowFlag.InvalidPrtType = DORowPrtFlags.ENumInvalidPrtType.DelLine;
                            //rowFlag.IsDataRemedy = true;
                        }
                    }
                    rowFlagList.Add(rowFlag);
                }

                //获取最后一条已打印数据的标记参数
                if (rowFlagList != null && rowFlagList.Count > 0)
                {
                    rowPrtFlagLast = rowFlagList[rowFlagList.Count - 1];
                }
            }
            #endregion

            #region 重整标记行
            // 如果是重整打印，则在已打印数据的后一行加重整标记行
            if (bReset)
            {
                //重整行标记参数
                DORowPrtFlags rowFlagReset = new DORowPrtFlags();
                rowFlagReset.ForceInOneGridRow = true; // 重整标记行，内容强制不换行
                rowFlagReset.MarkType = DORowPrtFlags.ENumMarkType.Text;//重整标记行内容标红
                
                if (isNewPage)
                {
                    rowFlagReset.AtPageIx = pageNum; ;//新起一页
                    isNewPage = false;
                }
                rowFlagList.Add(rowFlagReset);

                //重整行数据（取待打印第一条数据进行拷贝）
                ordPrintDOsConAndResList.Add(getOrdPrintDOReset(ordPrintDataDTOsToPrt[0]));
            }
            #endregion

            #region 待打印数据
            // 设置未打印的数据
            for (int i = 0; i < ordPrintDataDTOsToPrt.Length; i++)
            {
                // 对于直接打印的数据不需要设置页码、页号等信息
                DORowPrtFlags rowFlag = new DORowPrtFlags();
                // 如果上页正好打印到最后一行时，新页需要设置页码
                if (isNewPage)
                {
                    rowFlag.AtPageIx = pageNum;//新起一页
                    isNewPage = false;
                }

                //将医嘱待打印数据对象转换为医嘱打印的数据对象,设置格式化医嘱内容、生效时间、停止时间、医生、护士
                OrdPrintDO ordPrintData = this.convertOrdPrintData(ordPrintDataDTOsToPrt[i], i > 0 && ordPrintDataDTOsToPrt[i - 1].Id_or.Equals(ordPrintDataDTOsToPrt[i].Id_or));
                ordPrintDOsConAndResList.Add(ordPrintData);

                // 设置标记参数
                this.setRowPrtFlags(ordPrintDOLast, ordPrintData, ref rowPrtFlagLast, ref rowFlag);

                // 用于判断后一条医嘱与前一条医嘱打印时是否在同一页，以及记录页码等信息
                ordPrintDOLast = ordPrintData;
                rowPrtFlagLast = rowFlag;

                rowFlagList.Add(rowFlag);
            }
            #endregion

            return ordPrintDOsConAndResList.ToArray();
        }

        /// <summary>
        /// 获取作废/停止打印展现数据以及打印数据
        /// </summary>
        /// <param name="paramDTO">参数对象，idEn:就诊id，fgLong:长临标识，Print_mode:打印模式</param>
        /// <param name="ordPrintDOList"></param>
        /// <param name="dORowPrtFlagsPrtList"></param>
        /// <param name="rowAssist"></param>
        /// <returns>作废、停止打印预览数据</returns>
        private OrdPrintDO[] getPreviewCalAndStpOrds(OrdPrintParamDTO paramDTO, out List<List<OrdPrintDO>> ordPrintDOList, out List<List<DORowPrtFlags>> dORowPrtFlagsPrtList, out PrtDORowsAssist rowAssist)
        {
            // 获取待打印的作废、停止医嘱数据
            OrdPrintDataDTO[] ordPrintDataDTOsToPrt = ordPrintExtService.GetOrdPrintDataDTOs(paramDTO);

            // 获取需要作废、停止医嘱所在页的已打印全部医嘱数据
            OrdPrintDO[] ordPrintDOsPrted = ordPrintExtService.GetOrdPrintDOs(paramDTO, ordPrintDataDTOsToPrt);

            // 需要打印作废标记or停止时间的医嘱集合
            Dictionary<string, OrdPrintDataDTO> ordPrintDataDTOsPrtedDic = new Dictionary<string, OrdPrintDataDTO>();
            foreach (OrdPrintDataDTO dataDTO in ordPrintDataDTOsToPrt)
            {
                if (!ordPrintDataDTOsPrtedDic.ContainsKey(dataDTO.Id_or))
                    ordPrintDataDTOsPrtedDic.Add(dataDTO.Id_or, dataDTO);
            }

            // 所有展现数据的标记参数
            rowAssist = new PrtDORowsAssist(ordPrintDOsPrted.Length);
            DORowPrtFlags[] doprtflags = rowAssist.GetDoFlagsArr();

            // 用于判断待打印数据是否在一页
            int? pageNum = -1;
            ordPrintDOList = new List<List<OrdPrintDO>>();
            dORowPrtFlagsPrtList = new List<List<DORowPrtFlags>>();
            List<OrdPrintDO> prtDataList = new List<OrdPrintDO>();
            List<DORowPrtFlags> prtFlagsList = new List<DORowPrtFlags>();

            // 对已打印数据设置页码、行号、所在行数、是否已打印作废标记
            for (int i = 0; i < ordPrintDOsPrted.Length; i++)
            {
                doprtflags[i].AtPageIx = (int)ordPrintDOsPrted[i].Page_num; // 所在页码
                doprtflags[i].AtGridRowIx = (int)ordPrintDOsPrted[i].Row_num; // 所在行号
                doprtflags[i].TakeGridRowCnt = (int)ordPrintDOsPrted[i].Row_cnt; // 所占行数
                //根据作废打印标识Fg_canc_prn，判断是否打印过作废线，
                //打印过作废线的同时显示内容和作废线（置灰），否则只显示内容（置灰）
                doprtflags[i].InvalidPrtType = ordPrintDOsPrted[i].Fg_canc_prn == true ? DORowPrtFlags.ENumInvalidPrtType.HasPrted : DORowPrtFlags.ENumInvalidPrtType.NotInvalid;

                if (ordPrintDOsPrted[i].Id_or!=null && ordPrintDataDTOsPrtedDic.ContainsKey(ordPrintDOsPrted[i].Id_or))
                {
                    switch (paramDTO.Print_mode)
                    {
                        case OrdPrintConst.PRINT_MODE_CANCEL:
                            //需要补打作废线的，作废线（黑），内容（置灰）
                            if (ordPrintDataDTOsPrtedDic[ordPrintDOsPrted[i].Id_or].Fg_chk_canc == true)
                            {
                                doprtflags[i].InvalidPrtType = DORowPrtFlags.ENumInvalidPrtType.DelLine;
                                //doprtflags[i].IsDataRemedy = true;
                                ordPrintDOsPrted[i].Fg_chk_canc = FBoolean.True;//作废核对标识
                                ordPrintDOsPrted[i].Fg_canc_prn = FBoolean.True;//作废打印标识
                            }
                            break;
                        case OrdPrintConst.PRINT_MODE_STOP:
                            //需要打印停止时间的数据，将补打标识设置true
                            doprtflags[i].IsDataRemedy = FBoolean.True;
                            ordPrintDOsPrted[i].Fg_chk_stop = FBoolean.True;//停止核对标识
                            ordPrintDOsPrted[i].Fg_stop_prn = FBoolean.True;//停止打印标识
                            this.setOrdPrintDatetime(ordPrintDataDTOsPrtedDic[ordPrintDOsPrted[i].Id_or], ordPrintDOsPrted[i]);//设置停止时间
                            break;
                    }

                    if (pageNum != ordPrintDOsPrted[i].Page_num)
                    {
                        pageNum = ordPrintDOsPrted[i].Page_num;
                        prtDataList = new List<OrdPrintDO>();
                        prtFlagsList = new List<DORowPrtFlags>();
                        ordPrintDOList.Add(prtDataList);
                        dORowPrtFlagsPrtList.Add(prtFlagsList);
                    }
                    
                    prtDataList.Add(ordPrintDOsPrted[i]);
                    prtFlagsList.Add(doprtflags[i]);
                }
            }

            return ordPrintDOsPrted;
        }

        /// <summary>
        /// 获取单页补打展现数据以及打印数据
        /// </summary>
        /// <param name="paramDTO"></param>
        /// <param name="detailDOAssist"></param>
        /// <returns></returns>
        private OrdPrintDO[] getPreviewSingleOrds(OrdPrintParamDTO paramDTO, out List<OrdPrintDO> ordPrintList, out List<DORowPrtFlags> rowFlagsList, out PrtDORowsAssist detailDOAssist)
        {
            //获取指定页码所有已打印的数据
            OrdPrintDO[] ordPrintDOsPrted = this.getPrtedOrdsByPage(paramDTO.Id_en, paramDTO.Fg_long, new List<int> { (int)paramDTO.Page_num });

            //获取指定页码需要补打作废线or停止时间的数据
            OrdPrintDataDTO[] ordPrintDataDTOsToPrt = getCancAndStopSingleOrds(paramDTO);

            // 需要打印作废标记or停止时间的医嘱集合
            Dictionary<string, OrdPrintDataDTO> ordPrintDataDTOsPrtedDic = new Dictionary<string, OrdPrintDataDTO>();
            foreach (OrdPrintDataDTO dataDTO in ordPrintDataDTOsToPrt)
            {
                if (!ordPrintDataDTOsPrtedDic.ContainsKey(dataDTO.Id_or))
                    ordPrintDataDTOsPrtedDic.Add(dataDTO.Id_or, dataDTO);
            }

            ordPrintList = new List<OrdPrintDO>();
            rowFlagsList = new List<DORowPrtFlags>();
            //设置标记参数
            List<DORowPrtFlags> rowFlagList = new List<DORowPrtFlags>();
            foreach (OrdPrintDO ordPrintDO in ordPrintDOsPrted)
            {
                DORowPrtFlags rowFlag = new DORowPrtFlags();
                rowFlag.AtPageIx = (int)ordPrintDO.Page_num;
                rowFlag.AtGridRowIx = (int)ordPrintDO.Row_num;
                rowFlag.TakeGridRowCnt = 0;//单页补打，所有数据都需要打印，行数设为0
                //rowFlag.TakeGridRowCnt = (int)ordPrintDO.Row_cnt;
                //rowFlag.ForceInOneGridRow = ordPrintDO.Fg_reformrow == FBoolean.True;// 重整标识行不换行
                if (ordPrintDO.Fg_reformrow == FBoolean.True)
                {
                    rowFlag.ForceInOneGridRow = true;// 重整标识行不换行
                    rowFlag.MarkType = DORowPrtFlags.ENumMarkType.Text;//重整标记行内容标红
                }
                //根据作废打印标识Fg_canc_prn，判断是否打印过作废线，
                //打印过作废线的同时显示内容和作废线（黑）
                rowFlag.InvalidPrtType = ordPrintDO.Fg_canc_prn == true ? DORowPrtFlags.ENumInvalidPrtType.TextWithDelLine : DORowPrtFlags.ENumInvalidPrtType.NotInvalid;

                rowFlag.IsDataRemedy = (bool)ordPrintDO.Fg_stop_prn;
                //判断在已打印数据中，是否有需要补打作废线or停止时间
                if (ordPrintDO.Id_or!=null && ordPrintDataDTOsPrtedDic.ContainsKey(ordPrintDO.Id_or))
                {
                    //需要补打停止时间的：停止时间、医生、护士
                    if (ordPrintDataDTOsPrtedDic[ordPrintDO.Id_or].Fg_chk_stop == true)
                    {
                        rowFlag.IsDataRemedy = true;
                        ordPrintDO.Fg_chk_stop = FBoolean.True;//停止标识
                        ordPrintDO.Fg_stop_prn = FBoolean.True;//停止打印标识
                        this.setOrdPrintDatetime(ordPrintDataDTOsPrtedDic[ordPrintDO.Id_or], ordPrintDO);//设置停止时间
                    }
                    //需要补打作废线的：作废线（黑）、内容（黑）
                    if (ordPrintDataDTOsPrtedDic[ordPrintDO.Id_or].Fg_chk_canc == true)
                    {
                        ordPrintDO.Fg_chk_canc = FBoolean.True;//作废标识
                        ordPrintDO.Fg_canc_prn = FBoolean.True;//作废打印标识
                        rowFlag.InvalidPrtType = DORowPrtFlags.ENumInvalidPrtType.TextWithDelLine;
                    }

                    ordPrintList.Add(ordPrintDO);
                    rowFlagsList.Add(rowFlag);
                }

                rowFlagList.Add(rowFlag);
            }

            detailDOAssist = new PrtDORowsAssist(rowFlagList);

            return ordPrintDOsPrted;
        }

        /// <summary>
        /// 获取指定页码已打印的数据
        /// </summary>
        /// <param name="idEn">就诊id</param>
        /// <param name="fgLong">长临标识</param>
        /// <param name="pageNumList">页码集合</param>
        /// <returns></returns>
        private OrdPrintDO[] getPrtedOrdsByPage(string idEn, FBoolean fgLong, List<int> pageNumList)
        {
            List<object> args = new List<object>();
            args.Add(idEn);
            args.Add(fgLong);
            StringBuilder builder = new StringBuilder();
            builder.Append("Id_en = '{0}' and Fg_long = '{1}' and Page_num in (");
            for (int i = 0; i < pageNumList.Count; i++)
            {
                builder.Append("'{" + (i + 2) + "}'");
                args.Add(pageNumList[i]);
            }
            builder.Append(")");

            string condition = string.Format(builder.ToString(), args.ToArray());

            string orderBy = "Page_num,Row_num";

            OrdPrintDO[] ordPrintDOs = ordPrintService.find(condition, orderBy, FBoolean.False);
            return ordPrintDOs;
        }

        /// <summary>
        /// 获取指定页码需要补打作废线或停止时间的数据
        /// </summary>
        /// <param name="paramDTO"></param>
        /// <returns></returns>
        private OrdPrintDataDTO[] getCancAndStopSingleOrds(OrdPrintParamDTO paramDTO)
        {
            return ordPrintExtService.GetOrdPrintDataDTOs(paramDTO);
        }

        /// <summary>
        /// 获取指定页码需要补打作废线或停止时间的数据
        /// </summary>
        /// <param name="idEn"></param>
        /// <param name="fgLong"></param>
        /// <param name="pageNum"></param>
        /// <returns></returns>
        private OrdPrintDataDTO[] getCancAndStopSingleOrds(string idEn, FBoolean fgLong, int pageNum)
        {
            //生成新的参数，场景为单页打印
            OrdPrintParamDTO paramDTOCancAndStop = this.getOrdPrintParamDTO(idEn, fgLong, pageNum, OrdPrintConst.PRINT_MODE_SINGLE);
            return getCancAndStopSingleOrds(paramDTOCancAndStop);
        }

        /// <summary>
        /// 获取传递到服务端的参数
        /// </summary>
        /// <param name="idEn">就诊Id</param>
        /// <param name="fgLong">长临标识</param>
        /// <param name="pageNum">页码</param>
        /// <param name="printMode">打印模式</param>
        /// <returns></returns>
        private OrdPrintParamDTO getOrdPrintParamDTO(string idEn, FBoolean fgLong, int pageNum, string printMode)
        {
            OrdPrintParamDTO paramDTO = new OrdPrintParamDTO();
            paramDTO.Id_en = idEn;
            paramDTO.Fg_long = fgLong;
            paramDTO.Page_num = pageNum; ;
            paramDTO.Print_mode = printMode;

            return paramDTO;
        }

        /// <summary>
        /// 业务计算是否新起一页打印（已打印数据已经打印到最后一页的最后一行）
        /// </summary>
        /// <param name="lastOrdPrintDO">已打数据最后一条记录</param>
        /// <param name="pageNum">返回待打印数据所在页码</param>
        /// <returns></returns>
        private bool isUseNewPage(OrdPrintDO lastOrdPrintDO, ref int pageNum)
        {
            // 是否需要新起一页打印
            bool isNewPage = false;

            if (lastOrdPrintDO != null)
            {
                // 获取每页总行数
                int rowCnt = cfgViewModel.GetPageRowCnt();

                // 如果已印的医嘱已经打印到页面的最后一行，需要新起一页进行打印
                // 最后一条数据的行号+所占行数，是否正好是每页的总行数
                if (rowCnt == lastOrdPrintDO.Row_num + lastOrdPrintDO.Row_cnt)
                {
                    pageNum = (int)lastOrdPrintDO.Page_num + 1;//新起一页打印
                    isNewPage = true;
                }
            }

            return isNewPage;
        }

        /// <summary>
        /// 获取重整标记行对应的OrdPrintDO对象
        /// </summary>
        /// <param name="ordPrintDataDTO">第一条待打印数据，用来完善重整标记行数据</param>
        /// <returns></returns>
        private OrdPrintDO getOrdPrintDOReset(OrdPrintDataDTO ordPrintDataDTO)
        {
            OrdPrintDO ordPrintDO = new OrdPrintDO();

            BeanUtils.CopyProerties(ordPrintDataDTO, ordPrintDO, propertiesReset);

            ordPrintDO.Fg_reformrow = true;
            ordPrintDO.Content_or_prn = cfgViewModel.GetResetRowContent(true);
            return ordPrintDO;
        }

        /// <summary>
        /// 将医嘱待打印数据对象转换为医嘱打印的数据对象
        /// </summary>
        /// <param name="ordDataDTO">医嘱待打印数据对象</param>
        /// <returns>医嘱打印的数据对象</returns>
        private OrdPrintDO convertOrdPrintData(OrdPrintDataDTO ordDataDTO, bool isSubOr)
        {
            OrdPrintDO ordPrintDO = new OrdPrintDO();

            // 格式好医嘱内容
            this.setOrdPrintContent(ordDataDTO, isSubOr);

            // 属性复制是先排除医生、核对护士签字
            // 进行属性拷贝
            string[] properties = new string[propertiesSign.Length + propertiesSignStop.Length];
            propertiesSign.CopyTo(properties, 0);
            propertiesSignStop.CopyTo(properties, propertiesSign.Length);
            BeanUtils.CopyProerties(ordDataDTO, ordPrintDO, properties);

            // 设置生效日期，停止日期，医生护士签字
            this.setOrdPrintDatetime(ordDataDTO, ordPrintDO);

            return ordPrintDO;
        }

        /// <summary>
        /// 设置医嘱打印中医嘱内容 content_or_prn
        /// </summary>
        /// <param name="ordDataDTO">医嘱数据对象</param>
        private void setOrdPrintContent(OrdPrintDataDTO ordDataDTO, bool isSubOr)
        {
            // 获取当前打印数据对应的格式化字符串
            string format = cfgViewModel.GetRenderStr(ordDataDTO.Fg_long, ordDataDTO.Sd_srvtp);

            // 将OrdPrintDataDTO中属性按照格式化字符串进行数据转换
            string renderResult = RenderUtil.Render(format, ordDataDTO);
            ordDataDTO.Content_or_prn = (isSubOr ? "---" : "") + renderResult;
        }

        /// <summary>
        /// 设置医嘱生效时间、停止时间
        /// </summary>
        /// <param name="ordDataDTO"></param>
        /// <param name="ordPrintDO"></param>
        private void setOrdPrintDatetime(OrdPrintDataDTO ordDataDTO, OrdPrintDO ordPrintDO)
        {
            // 设置医嘱的生效时间
            FDateTime dtEffe = ordPrintDO.Dt_effe;
            if (dtEffe != null)
            {
                DateTime dateTime = dtEffe.ToTarget;
                ordPrintDO.Dt_effe_m = dateTime.Month.ToString();
                ordPrintDO.Dt_effe_d = dateTime.Day.ToString();
                ordPrintDO.Dt_effe_t = dateTime.TimeOfDay.ToString();
            }

            // 判断是否需要打印签字人(签署医生、核对护士)
            if (cfgViewModel.IsPrintSignatory())
            {
                BeanUtils.SetProerties(ordDataDTO, ordPrintDO, propertiesSign);
            }

            // 当停止核对结束后打印停止时间
            if (ordPrintDO.Fg_chk_stop == FBoolean.True)
            {
                // 设置医嘱的停止时间
                ordPrintDO.Dt_end = ordDataDTO.Dt_end;
                FDateTime dtEnd = ordPrintDO.Dt_end;
                DateTime dateTime = dtEnd.ToTarget;

                ordPrintDO.Dt_end_m = dateTime.Month.ToString();
                ordPrintDO.Dt_end_d = dateTime.Day.ToString();
                ordPrintDO.Dt_end_t = dateTime.TimeOfDay.ToString();

                // 判断是否需要打印签字人(停止医生、停止核对护士)
                if (cfgViewModel.IsPrintSignatory())
                {
                    BeanUtils.SetProerties(ordDataDTO, ordPrintDO, propertiesSignStop);
                }
            }
        }

        /// <summary>
        /// 设置打印行的辅助属性,根据lastPrintDO，ordPrintDO判断是否需要强制换页打印
        /// </summary>
        /// <param name="lastPrintDO">上一条数据</param>
        /// <param name="ordPrintDO">当前数据</param>
        /// <param name="lastRowPrtFlags">上一条标记</param>
        /// <param name="doRowPrtFlags">当前参数</param>
        private void setRowPrtFlags(OrdPrintDO lastPrintDO, OrdPrintDO ordPrintDO, ref DORowPrtFlags lastRowPrtFlags, ref DORowPrtFlags doRowPrtFlags)
        {
            if (ordPrintDO != null)
            {
                doRowPrtFlags.IsDataRemedy = (bool)ordPrintDO.Fg_chk_stop;
                doRowPrtFlags.InvalidPrtType = ordPrintDO.Fg_chk_canc == true ? DORowPrtFlags.ENumInvalidPrtType.TextWithDelLine : DORowPrtFlags.ENumInvalidPrtType.NotInvalid;
            }

            if (lastPrintDO != null)
            {
                // 如果跨科室需要重新打印
                if (cfgViewModel.IsUseNewDeptPage())
                {
                    // 科室不同，设置强制换页
                    if (lastPrintDO.Id_dep_nur != ordPrintDO.Id_dep_nur)
                    {
                        //强制下一条数据换页
                        lastRowPrtFlags.ForceAfterToNewPage = FBoolean.True;
                    }
                }
            }
        }
        
        #endregion

    }
}

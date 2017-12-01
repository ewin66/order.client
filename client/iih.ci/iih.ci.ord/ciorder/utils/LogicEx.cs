using System;
using System.Collections.Generic;
using System.Linq;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.viewmodel;
using iih.ci.ord.ciorder.viewmodel.impext;
using System.Collections;
using System.Reflection;
using iih.bd.srv.medsrv.d;
using xap.mw.core.data;
using xap.rui.appfw;
using iih.bd.bc.udi;
using iih.ci.ord.ciorder.d;
using xap.rui.control.extentions;
using iih.ci.ord.ems.d;
using iih.ci.ord.cior.d;
using iih.en.pv.dto.d;
using iih.bd.srv.freqdef.i;
using xap.mw.serviceframework;
using iih.bd.srv.freqdef.d;
using iih.bd.mm.meterial.i;
using iih.bd.mm.meterial.d;
using iih.ci.ord.i;
using xap.cli.sdk.render.labelcontrol;
using System.Drawing;
using xap.cli.sdk.render.Items;
using xap.rui.control.forms.view;
using System.Speech.Synthesis;
using xap.cli.sdk.render;
using iih.mm.itf.material.i;
using iih.mm.itf.material.d;
using xap.rui.control.forms.control;
using iih.bd.pp.hp.d;
using iih.bd.fc.orwf.d;
using iih.ci.ord.dto.d;
using iih.ci.ord.skintest.i;
using iih.ci.ord.skintest.d;
using xap.mw.coreitf.d;
using iih.ci.ord.srvpri.d;
using xap.sys.xbd.measdoc.d;
using xap.sys.xbd.measdoc.i;
using iih.ci.iih.ci.ord.i;
using System.Threading;
using iih.ci.ord.ciord.d;
using iih.ci.ord.ciorder.cards.thread.dp;
using iih.ci.ord.ciorder.cards.thread;
using xap.cli.context;
using iih.bd.fc.wf.d;
using iih.ci.ord.emsdi.d;
using iih.bd.srv.routedosage.i;
using iih.bd.srv.routedosage.d;
using xap.mw.serviceframework.ex;
using xap.sys.xbd.udi.d;
using iih.mm.comm_stub.i;
using xap.mw.core.utils;
using xap.mw.func;
using iih.ci.ord_stub.i;
using xap.rui.control.query.i;
using xap.cli.sdk.form;
using System.Windows.Forms;
using iih.bd.pp.hpsrvorca.d;
using iih.bd.srv.medsrv.i;
using xap.cli.sdk.controls.DataView.Extension.XOrderResult;
using iih.bl.hp.bdhpindicationdto.d;
using iih.ci.mr.mrdocrefvalue.i;
using iih.ci.mr.mrdocrefvalue.d;
using iih.ci.ord.common.utils;
using iih.bd.bc_stub.udi;
using System.Text;
using iih.ci.diag.cidiag.d;
using iih.ci.diag_stub.i;
using iih.bd.srv.ems.d;

namespace iih.ci.ord.ciorder.utils
{
    public class LogicEx
    {
        private static LogicEx _instance = new LogicEx();
        private ICiOrdQryService qryservice = XapServiceMgr.find<ICiOrdQryService>();
        public static LogicEx GetInstance()
        {
           
            return _instance;
        }
        private LogicEx() { }
        #region 配置 算法


        /// <summary>
        /// 开始时间大于入院时间的限定时间(天)
        /// </summary>
        /// <returns></returns>
        public int getLimitedHour()
        {
            return qryservice.getIntSystemParam("", CiDictCodeConst.SYS_PARAM_LIMITEDHOUR);
        }
        /// <summary>
        /// 临时备用医嘱有效时间（小时）
        /// </summary>
        /// <returns></returns>
        public int getSpareTime()
        {
            return qryservice.getIntSystemParam("", ICiOrdNSysParamConst.SYS_PARAM_TemporaryPrnOrValidTime);
        }
        /// <summary>
        /// 系统开始时间参数（时刻）
        /// </summary>
        //public string getCofOrdStartTime() { 
        //    return qryservice.getStringSystemParam("", CiDictCodeConst.SYS_PARAM_ORDSTARTTIME);
        //}
        /// <summary>
        /// 服务器时间
        /// </summary>
        /// <returns></returns>
        public DateTime GetSystemDateTime()
        {
            return CommonExtentions.NowTime(this);
        }
        public DateTime GetServerDataTime()
        {
            return CommonExtentions.NowTime(this);
        }

        public DateTime GetAfterDateTime(int num)
        {
            ICiOrdQryServiceImpl service = new ICiOrdQryServiceImpl();
            return service.getDateTomeBefore(num);

        }

        /// <summary>
        /// 计算开始时间(已使用)
        /// 读取医嘱录入默认时刻参数，如果当前时刻超过了参数时刻，则显示当前时刻
        /// </summary>
        /// <returns></returns>
        public DateTime GetStartTime()
        {
            return CommonExtentions.NowTime(this);
            //if (CommonExtentions.NowTime(this) > DateTime.Parse(getCofOrdStartTime())) {
            //    return CommonExtentions.NowTime(this);
            //}
            //return DateTime.Parse(getCofOrdStartTime());
        }

        /// <summary>
        /// 医生修改开始时间的判断（已经使用）
        /// 开始日期时间必须要大于入院日期时间，医生可录入的时间区间范围为系统参数配置
        /// </summary>
        /// <param name="statTime"></param>
        /// <param name="admTime"></param>
        /// <returns></returns>
        public string CompareWithAdmission(string id_en, DateTime? statTime)
        {
            DateTime? admTime = new GetInHosTime().GetPatInHosTime(id_en);
            if (statTime == null)
               //return "开始时间或入院时间错误！";
                return "开始时间错误！";
            if (admTime == null)
            {
                return "入院时间错误！";
            }
            if (statTime < admTime)
                return string.Format("开始时间不能在入院时间[{0}]之前！", admTime);
            TimeSpan mistake = statTime.Value.Subtract(CommonExtentions.NowTime(this));
            if (mistake.TotalHours > OrdParam.GetOrdParam.limitedHour)
            {
                //return "开始时间超出系统设置！";---需求待确认
            }
            return "";
        }
        /// <summary>
        /// 计算使用天数（已使用）
        /// </summary>
        /// <param name="statTime"></param>
        /// <param name="endTime"></param>
        /// <returns></returns>
        public int? GetUseDays(DateTime? statTime, DateTime? endTime)
        {
            if (statTime == null || endTime == null)
                return null;
            TimeSpan day = endTime.Value.Subtract(statTime.Value);
            if (day.TotalDays / (int)day.TotalDays != 0)
                return (int)day.TotalDays;
            return (int)day.TotalDays;
        }
        /// <summary>
        /// 计算停止时间（已使用）
        /// </summary>
        /// <param name="statTime"></param>
        /// <param name="usedays"></param>
        /// <returns></returns>
        public DateTime? GetEndTime(DateTime? statTime, int usedays)
        {
            if (statTime == null || usedays == 0)
                return null;
            DateTime endTime = DateTime.Now;
            try
            {
                endTime = DateTime.Parse(statTime.Value.AddDays(usedays).ToString("yyyy-MM-dd 23:59:59"));
            }
            catch //(ArgumentOutOfRangeException ex)
            {
                this.ShowInfo("使用天数录入错误！");
                return null;
            }
            return endTime;
        }
        /// <summary>
        /// 物品排序（已调用）
        /// </summary>
        /// <param name="mmlist">The mmlist.</param>
        /// <returns></returns>
        public XapDataList<EmsOrDrug> MmSortList(XapDataList<EmsOrDrug> mmlist)
        {
            int i = mmlist.Count + 1;
            foreach (EmsOrDrug mm in mmlist)
            {
                if (mm.Fact_count!=null && mm.Fact_count == 0)
                {
                    mm.Sortno = i;
                    i++;
                }
            }

            var v = mmlist.ToList().OrderBy(p => p.Sortno).ToList();
            XapDataList<EmsOrDrug> list = new XapDataList<EmsOrDrug>();
            v.ToList().ForEach(p => list.Add(p));
            return list;
        }
        /// <summary>
        /// 临时备用医嘱失效时间(已使用)
        /// </summary>
        /// <param name="statrTime"></param>
        /// <returns></returns>
        public DateTime GetSpareEndTime(DateTime statrTime)
        {
            return statrTime.AddHours(getSpareTime());
        }
        /// <summary>
        /// 执行时刻、首日执行、首日执行时刻（已使用）
        /// </summary>
        /// <param name="freqList">The freq list.</param>
        /// <param name="woketime">The woketime.</param>
        /// <param name="firstday">The firstday.</param>
        /// <param name="firstwoketime">The firstwoketime.</param>
        public string GetWorkTime(string id_freq)
        {
            IFreqdefCrudService freqService = XapServiceMgr.find<IFreqdefCrudService>();
            FreqdefAggDO freqAgg = freqService.findById(id_freq);
            if (freqAgg != null)
            {
                FreqTimeDO[] freqtimeArr = freqAgg.getFreqTimeDO();
                string time = "";
                if (freqtimeArr != null)
                {
                    XapDataList<FreqTimeDO> list = freqtimeArr;
                    IEnumerable<FreqTimeDO> query = from items in list orderby items.Sortno descending select items;
                    foreach (var item in query)
                    {
                        time += item.Time_mp.Value.ToString("HH:mm") + ";";
                    }
                    if (time.Length > 0)
                    {
                        time = time.Substring(0, time.Length - 1);
                    }
                    return time;
                }
            }
            return "";
        }

        /// <summary>
        /// 获取频次关联的时刻(已经使用)
        /// </summary>
        /// <param name="id_freq">The id_freq.</param>
        /// <param name="id_orsrv">The id_orsrv.</param>
        /// <param name="id_or">The id_or.</param>
        /// <returns></returns>
        public XapDataList<EmsOrDrug> GetFreqVsTimes(string id_freq, string id_orsrv, string id_or)
        {
            return new OrderSrvDoseViewModel().GetDrugDose(id_freq, id_orsrv, id_or);
        }
        /// <summary>
        /// 删除医嘱药品 
        /// </summary>
        /// <param name="headDo">The head do.</param>
        /// <param name="delDo">The delete do.</param>
        /// Author:admin
        /// Date:2015-10-13
        public void DeleteOrDrug(EmsUIDTO headDo, EmsOrDrug delDo)
        {
            if (delDo.Id_orsrv != null)//判断是 否在数据库存在的 如果 存在 则把删除的数据保留到删除集合里， 不存在 直接移除了
            {//2016-07-06zwq 判断条件： delDo.Id_emsordrug-->delDo.Id_orsrv
                EmsOrDrug delDobak = DoCopy(delDo);
                delDobak.Status = DOStatus.DELETED;
                headDo.Emsdrugs.EmsOrDeleteDrugList.Add(delDobak);


            }
            int index = headDo.Emsdrugs.EmsOrDrugList.IndexOf(delDo);
            headDo.Emsdrugs.EmsOrDrugList.Remove(delDo);
            if (headDo.Emsdrugs.EmsOrDrug != null && headDo.Emsdrugs.EmsOrDrug.Count > 0)
            {
                int length = headDo.Emsdrugs.EmsOrDrug.Count;
                for (int i = length - 1; i >= 0; i--)
                {
                    if (headDo.Emsdrugs.EmsOrDrug[i].Id_srv == delDo.Id_srv)
                    {
                        headDo.Emsdrugs.EmsOrDrug.RemoveAt(i);
                    }
                }
            }
            //headDo.Emsdrugs.EmsOrDrugList.Remove(delDo);
        }
        /// <summary>
        /// Gets the 医嘱的内容.（已使用）
        /// </summary>
        /// <param name="emsHeadDO">The ems head do.</param>
        /// <param name="emsType">Type of the ems.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-09-18

        #region 作废了

        [Obsolete("作废了")]
        public string GetOrDes(EmsUIDTO headDo)
        {
            string des = "测试内容";
            switch (headDo.EmsType)
            {
                case EmsType.COMMONDRUG:


                    des = BdSrvDictCodeConst.SD_SRVTP_DRUG_WESTDRUG + "||";
                    des += headDo.Emsdrugs.Name_srv + "&" + headDo.Emsdrugs.Quan_med + "&" + headDo.Emsdrugs.Name_unit_med + "|";
                    des += "&" + headDo.Emsdrugs.Name_route + "&" + headDo.Emsdrugs.Name_freq + "&";



                    break;
                case EmsType.IV:
                    XapDataList<EmsOrDrug> list = headDo.Emsdrugs.EmsOrDrugList;
                    des = BdSrvDictCodeConst.SD_SRVTP_CYDRUG + "||" + headDo.Emsdrugs.Name_srv + "&" + headDo.Emsdrugs.Quan_med + "&" + headDo.Emsdrugs.Name_unit_med + "^";

                    if (list != null)
                    {
                        foreach (EmsOrDrug item in list)
                        {

                            des += "&" + item.Name_srv + "&" + item.Quan_med + "&" + item.Name_unit_med + "^";
                        }
                        des += "|";
                    }

                    else
                    {
                        des += headDo.Emsdrugs.Name_srv + "&" + headDo.Emsdrugs.Quan_med + "&" + headDo.Emsdrugs.Name_unit_med;

                    }
                    des += "&" + headDo.Emsdrugs.Name_route + "&" + headDo.Emsdrugs.Name_freq + "";
                    break;
                case EmsType.HERB:
                    //des = BdSrvDictCodeConst.SD_SRVTP_HERBDRUG + "|" + "草药" + headDo.MedSrvDOOrders_boil + ":|" + headDo.Emsdrugs.Name_srv + "&&";

                    //des += "&" + headDo.Emsdrugs.Name_route + "&" + headDo.Emsdrugs.Name_freq + "&"  ;
                    break;
                case EmsType.RIS:
                    des = BdSrvDictCodeConst.SD_SRVTP_RIS_TOUSHI + "||" + headDo.Emsapobs.Name_srv + "|" + "&";
                    des += "&" + "&" + headDo.Emsapobs.Des_pps + "&" + headDo.Emsapobs.Des_sympsign + "|";
                    break;
                case EmsType.LIS:
                    des = BdSrvDictCodeConst.SD_SRVTP_LIS_NORMAL + "||" + headDo.Emsaplab.Name_srv + "| &";
                    des += "&" + "&" + headDo.Emsaplab.Des_pps + "&" + headDo.Emsaplab.Des_sympsign;
                    break;
                case EmsType.BT:
                    des = BdSrvDictCodeConst.SD_SRVTP_DRUG_WESTDRUG + "||" + headDo.Emsapbt.Name_srv + "| &";
                    des += "&" + "&" + headDo.Emsapbt.Name_mode + "&" + headDo.Emsapbt.Name_bttp + "|";
                    break;

                case EmsType.OPER:
                    des = BdSrvDictCodeConst.SD_SRVTP_DRUG_WESTDRUG + "||" + headDo.Emsapop.Name_srv + "| &";
                    des += "&" + "&" + headDo.Emsapop.Name_lvlsug + "&" + headDo.Emsapop.Name_anestp + "|";
                    break;
                case EmsType.PATHGY:
                    des = BdSrvDictCodeConst.SD_SRVTP_DRUG_WESTDRUG + "||" + headDo.Emsappathgy.Name_srv + "| &";
                    des += "&" + "&" + headDo.Emsappathgy.Name_samptp + "&" + headDo.Emsappathgy.Name_diag + "|";

                    break;

                case EmsType.CONS:
                    des = BdSrvDictCodeConst.SD_SRVTP_DRUG_WESTDRUG + "||" + headDo.Emsapcons.Name_srv + "| &";
                    des += "&" + "&" + headDo.Emsapcons.Name_dep_cons + "&" + headDo.Emsapcons.Name_place + "|";
                    break;
                case EmsType.COMMON:
                    des = BdSrvDictCodeConst.SD_SRVTP_DRUG_WESTDRUG + "||";
                    des += headDo.Emsdrugs.Name_srv + "&" + headDo.Emsdrugs.Name_route + "&" + headDo.Emsdrugs.Name_routedes + "|";


                    break;

                default:
                    break;
            }


            return des;
        }

        #endregion

        /// <summary>
        /// 取得药品的总次数
        /// </summary>
        /// <param name="emsordrug"></param>
        /// <returns></returns>
        public int GetDrugUseTotalCount(EmsOrDrug emsordrug)
        {
            int ucount = 0, ifirstdayadjust = 0;
            int freqct = emsordrug.Freqct == null ? 0 : emsordrug.Freqct.Value;
            if (emsordrug.Id_freq == null)
            {
                return 0;
            }
            //为空需要去取频次周期的单位，正常逻辑是headDo应该带的，但是需要bd_srv元数据重新生成，动静比较大，所以先临时查询下，等以后元数据生成后按正常逻辑
            if (emsordrug.Sd_frequnitct == null)
            {
                IFreqdefMDOCrudService freqdef = XapServiceMgr.find<IFreqdefMDOCrudService>();
                FreqDefDO fq = freqdef.findById(emsordrug.Id_freq);
                emsordrug.Sd_frequnitct = fq.Sd_frequnitct;
                emsordrug.Freqct = fq.Freqct;
                freqct = (int)emsordrug.Freqct;
            }
            switch (emsordrug.Sd_frequnitct)
            {
                case BdSrvDictCodeConst.SD_FREQUNIT_HOUR:// "小时":
                    //，药品使用总次数=[（@开始日期-@停止日期） 换算出小时时间]÷BD_FREQ. frequnitct频次周期数。
                    //说明：先取得总小时数，再除以频次周期数，取计算结果商数。
                    ucount = emsordrug.Use_days.Value * 24 / freqct;
                    break;
                case BdSrvDictCodeConst.SD_FREQUNIT_DAY:// "天"
                    //药品使用总次数= BD_FREQ. freqct频次周期下次数*@使用天数；
                    if (emsordrug.Use_days != null)
                    {
                        ucount = emsordrug.Use_days.Value * freqct;
                        #region "首日量调整"
                        ucount = ucount - ifirstdayadjust;
                        ucount = ucount < 0 ? 0 : ucount;
                        #endregion
                    }

                    break;
                case BdSrvDictCodeConst.SD_FREQUNIT_WEEK: //"星期"
                    //药品使用总次数= BD_FREQ. freqct频次周期下次数*@使用天数/7 
                    //  如果X÷7能整除，显示值=X；
                    //如果X÷7不能整除，显示值=商数+7
                    int Weekcount = 0;
                    if (freqct * emsordrug.Use_days.Value % 7 == 0)
                    {
                        Weekcount = emsordrug.Use_days.Value / 7;
                    }
                    else
                    {
                        Weekcount = emsordrug.Use_days.Value / 7 + 1;
                    }

                    ucount = Weekcount * freqct;

                    break;
                default:
                    ucount = 1;
                    break;
            }
            return ucount;
        }

        public int GetDrugUseTotalCount(String id_freq, int freqct, String sd_freq, int Use_days = 1)
        {
            int ucount = 0, ifirstdayadjust = 0;
           
            if (String.IsNullOrEmpty(id_freq)) {
                return 0;
            }
            //为空需要去取频次周期的单位，正常逻辑是headDo应该带的，但是需要bd_srv元数据重新生成，动静比较大，所以先临时查询下，等以后元数据生成后按正常逻辑
            if (sd_freq == null) {
                IFreqdefMDOCrudService freqdef = XapServiceMgr.find<IFreqdefMDOCrudService>();
                FreqDefDO fq = freqdef.findById(id_freq);
                sd_freq = fq.Sd_frequnitct;
                freqct = (int)fq.Freqct;
            }
            switch (sd_freq) {
                case BdSrvDictCodeConst.SD_FREQUNIT_HOUR:// "小时":
                    //，药品使用总次数=[（@开始日期-@停止日期） 换算出小时时间]÷BD_FREQ. frequnitct频次周期数。
                    //说明：先取得总小时数，再除以频次周期数，取计算结果商数。
                    ucount = Use_days * 24 / freqct;
                    break;
                case BdSrvDictCodeConst.SD_FREQUNIT_DAY:// "天"
                    //药品使用总次数= BD_FREQ. freqct频次周期下次数*@使用天数；
                    ucount = Use_days * freqct;
                    #region "首日量调整"
                    ucount = ucount - ifirstdayadjust;
                    ucount = ucount < 0 ? 0 : ucount;
                    #endregion
                    break;
                case BdSrvDictCodeConst.SD_FREQUNIT_WEEK: //"星期"
                    //药品使用总次数= BD_FREQ. freqct频次周期下次数*@使用天数/7 
                    //  如果X÷7能整除，显示值=X；
                    //如果X÷7不能整除，显示值=商数+7
                    int Weekcount = 0;
                    if (freqct * Use_days % 7 == 0) {
                        Weekcount = Use_days / 7;
                    }
                    else {
                        Weekcount = Use_days / 7 + 1;
                    }

                    ucount = Weekcount * freqct;

                    break;
                default:
                    ucount = 1;
                    break;
            }
            return ucount;
        }
        /// <summary>
        /// Gets药品使用总次数.
        /// </summary>
        /// <param name="frequnit">The frequnit. 频次单位</param>
        /// <param name="freqct">The freqct.频次数</param>
        /// <param name="or_days">The or_days.医嘱天数</param>
        /// <returns>DrugUseTotalCount</returns>
        /// Author:admin
        /// Date:2015-09-19
        public int GetDrugUseTotalCount(EmsUIDTO headDo)
        {
            if (headDo.EmsType == EmsType.HERB)
            {
                headDo.Emsdrugs.Total_count = headDo.Emsdrugs.Orders;
                return headDo.Emsdrugs.Orders==null?0:headDo.Emsdrugs.Orders.Value;
            }
            int ucount = 0, ifirstdayadjust = 0, freqct = 0;
            if (headDo.Emsdrugs.Id_freq == null)
            {
                headDo.Emsdrugs.Total_count = 0;
                return 0;
            }
            if (headDo.Emsdrugs.Freqct == null || headDo.Emsdrugs.Sd_frequnitct == null)
            {
                //为空需要去取频次周期的单位，正常逻辑是headDo应该带的，但是需要bd_srv元数据重新生成，动静比较大，所以先临时查询下，等以后元数据生成后按正常逻辑
                setDrugFreqInfo(headDo.Emsdrugs);
            }
            freqct = headDo.Emsdrugs.Freqct == null ? 0 : headDo.Emsdrugs.Freqct.Value;
            switch (headDo.Emsdrugs.Sd_frequnitct)
            {
                case BdSrvDictCodeConst.SD_FREQUNIT_HOUR:// "小时":

                    //，药品使用总次数=[（@开始日期-@停止日期） 换算出小时时间]÷BD_FREQ. frequnitct频次周期数。
                    //说明：先取得总小时数，再除以频次周期数，取计算结果商数。
                    //现在的住院和门诊中没有开始时间和结束时间
                    //if (headDo.Emsdrugs.Dt_end_ui.Value == null) {
                    //    this.ShowInfo(headDo.Emsdrugs.Name_srv + "的结束日期为空，不可参与总量计算！");
                    //    return 0;
                    //}
                    //if (headDo.Emsdrugs.Dt_begin_ui.Value == null) {
                    //    this.ShowInfo(headDo.Emsdrugs.Name_srv + "的开始日期为空，不可参与总量计算！");
                    //    return 0;
                    //}
                    //ucount = (int)(headDo.Emsdrugs.Dt_end_ui.Value.Subtract(headDo.Emsdrugs.Dt_begin_ui.Value)).TotalHours / freqct;
                    if (headDo.Emsdrugs.Use_days != null)
                    {
                        ucount = (int)headDo.Emsdrugs.Use_days * 24 / freqct;
                    }
                    break;
                case BdSrvDictCodeConst.SD_FREQUNIT_DAY:// "天"
                    //药品使用总次数= BD_FREQ. freqct频次周期下次数*@使用天数；
                    if (headDo.Emsdrugs.Use_days != null)
                    {
                        ucount = headDo.Emsdrugs.Use_days.Value * freqct;
                        #region "首日量调整"
                        if (headDo.Emsdrugs.Quan_firday_mp != null)
                        {
                            ifirstdayadjust = freqct - headDo.Emsdrugs.Quan_firday_mp.Value;
                        }
                        ucount = ucount - ifirstdayadjust;
                        ucount = ucount < 0 ? 0 : ucount;
                        #endregion
                    }

                    break;
                case BdSrvDictCodeConst.SD_FREQUNIT_WEEK: //"星期"
                    //药品使用总次数= BD_FREQ. freqct频次周期下次数*@使用天数/7 
                    //  如果X÷7能整除，显示值=X；
                    //如果X÷7不能整除，显示值=商数+7
                    int Weekcount = 0;
                    if (headDo.Emsdrugs.Use_days != null)
                    {
                        if (freqct * headDo.Emsdrugs.Use_days.Value % 7 == 0)
                        {
                            Weekcount = headDo.Emsdrugs.Use_days.Value / 7;
                        }
                        else
                        {
                            Weekcount = headDo.Emsdrugs.Use_days.Value / 7 + 1;
                        }

                        ucount = Weekcount * freqct;
                    }
                    break;
                default:
                    break;
            }
            if (ucount == 0)
            {
                ucount = 1;
            }
            headDo.Emsdrugs.Total_count = ucount;
            return ucount;
        }
        /// <summary>
        /// 设置服务项目的频次信息
        /// </summary>
        /// <param name="emsDrugItemDO"></param>
        public void setDrugFreqInfo(object obj)
        {
            IFreqdefMDOCrudService freqdef = XapServiceMgr.find<IFreqdefMDOCrudService>();
            if (obj is EmsDrugItemDO)
            {
                EmsDrugItemDO emsdrugitemdo = obj as EmsDrugItemDO;
                FreqDefDO fq = freqdef.findById(emsdrugitemdo.Id_freq);
                emsdrugitemdo.Sd_frequnitct = fq.Sd_frequnitct;
                emsdrugitemdo.Freqct = fq.Freqct;
            }
            else if (obj is EmsOrDrug)
            {
                EmsOrDrug emsordrug = obj as EmsOrDrug;
                FreqDefDO fq = freqdef.findById(emsordrug.Id_freq);
                emsordrug.Sd_frequnitct = fq.Sd_frequnitct;
                emsordrug.Freqct = fq.Freqct;
            }

        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="emsOrDrug"></param>
        /// <param name="emsOrDoseDrug"></param>
        /// <param name="code_entp">就诊类型编码</param>
        /// <param name="calPrice">是否计算总价</param>
        public void GetDrugTotal(EmsOrDrug emsOrDrug, EmsOrDrug[] emsOrDoseDrug, string code_entp, bool calPrice = false)
        {

            //取值总量单位的换算系数和物品的取整模式
            object[] mmArray = getDrugMMFactorMupkgutp(emsOrDrug.Id_mm, emsOrDrug.Id_unit_sale);

            double factor = mmArray[0] == null ? 0 : Convert.ToDouble(mmArray[0].ToString());

            //参数校验是否满足计算条件
            if (!isValidate(emsOrDrug, mmArray)) return;

            //设置取整模式
            setSd_mukgutp(emsOrDrug, code_entp, mmArray);

            //非变动用药
            if (emsOrDrug.Fg_dose_anoma == null || !emsOrDrug.Fg_dose_anoma.Value)
            {
                int times = GetDrugUseTotalCount(emsOrDrug);//总次数 

                if (emsOrDrug.Sd_mupkgutp == "0")//按次取整
                {
                    emsOrDrug.Quan_cur = Math.Ceiling((double)(Math.Ceiling((double)(emsOrDrug.Quan_med / emsOrDrug.Factor_mb)) / factor)) * times;
                }
                else if (emsOrDrug.Sd_mupkgutp == "1")//按批取整
                {
                    emsOrDrug.Quan_cur = Math.Ceiling((double)(emsOrDrug.Quan_med / emsOrDrug.Factor_mb * times / factor));
                }
                else if (emsOrDrug.Sd_mupkgutp == "4")//不取整
                {
                    emsOrDrug.Quan_cur = (double)(emsOrDrug.Quan_med / emsOrDrug.Factor_mb * times / factor);
                }
            }
            else
            {
                //按次取整
                if (emsOrDrug.Sd_mupkgutp == "0")
                {
                    //变动用药按次取整
                    kgutpDoseDrugTotal(emsOrDrug, emsOrDoseDrug, factor);
                }
                else
                {
                    //按批取整
                    opmutpDoseDrugTotal(emsOrDrug, emsOrDoseDrug, factor);

                }
            }
            // 计算总价
            if (calPrice)
            {
                emsOrDrug.Totalprice = emsOrDrug.Quan_cur * emsOrDrug.Price;
            }
            emsOrDrug.Factor_cb = factor;
        }
        /// <summary>
        /// 草药计算总量
        /// </summary>
        /// <param name="emsOrDrug"></param>
        /// <param name="emsOrDoseDrug"></param>
        /// <param name="code_entp">就诊类型编码</param>
        /// <param name="calPrice">是否计算总价</param>
        public void GetDrugTotal(EmsOrDrug emsOrDrug, int orders, string code_entp, bool calPrice = false)
        {
            if (String.IsNullOrEmpty(emsOrDrug.Id_mm) || String.IsNullOrEmpty(emsOrDrug.Id_unit_sale))
                return;
            //取值总量单位的换算系数和物品的取整模式
            object[] mmArray = getDrugMMFactorMupkgutp(emsOrDrug.Id_mm, emsOrDrug.Id_unit_sale);

            double factor = mmArray[0] == null ? 0 : Convert.ToDouble(mmArray[0].ToString());

            //参数校验是否满足计算条件
            if (!isValidate(emsOrDrug, mmArray)) return;

            //设置取整模式
            setSd_mukgutp(emsOrDrug, code_entp, mmArray);
            int times = orders;
            if (emsOrDrug.Sd_mupkgutp == "0")
            {
                emsOrDrug.Quan_cur = Math.Ceiling((double)(Math.Ceiling((double)(emsOrDrug.Quan_med / emsOrDrug.Factor_mb)) / factor)) * times;
            }
            else
            {
                emsOrDrug.Quan_cur = Math.Ceiling((double)(emsOrDrug.Quan_med / emsOrDrug.Factor_mb * times / factor));
            }
            emsOrDrug.Factor_cb = factor;
            // 计算总价
            if (calPrice)
            {
                emsOrDrug.Totalprice = emsOrDrug.Quan_cur * emsOrDrug.Price;
            }
        }

        /// <summary>
        /// 计算物品总量
        /// </summary>
        /// <param name="feeSrv"></param>
        /// <param name="code_entp"></param>
        /// <param name="Use_days"></param>
        /// <returns></returns>
        public double? GetMmTotal(CiOrdFeeSrvDTO feeSrv, string code_entp, int Use_days = 1)
        {
            double? quan_cur = null;
            if (feeSrv.Fg_mm != null && feeSrv.Fg_mm.Value) {
                #region 计算物品总量
                //取值总量单位的换算系数和物品的取整模式
                object[] mmArray = getDrugMMFactorMupkgutp(feeSrv.Id_mm, feeSrv.Id_unit_sale);
                double factor = mmArray[0] == null ? 0 : Convert.ToDouble(mmArray[0].ToString());
                // 取整模式
                String Sd_mupkgutp = "";
                {
                    if (EnDictCodeConst.SD_ENTP_INPATIENT.Equals(code_entp)) {//住院
                        if (mmArray[1] != null)
                            Sd_mupkgutp = mmArray[1].ToString();
                    }
                    else { //门诊
                        if (mmArray[2] != null)
                            Sd_mupkgutp = mmArray[2].ToString();
                    }
                }
                // 计算总量
                {
                    int times = GetDrugUseTotalCount(feeSrv.Id_freq, feeSrv.Freqct.Value, feeSrv.Sd_frequnitct, Use_days);//总次数 

                    if (Sd_mupkgutp == "0") {
                        feeSrv.Quan_cur = Math.Ceiling((double)(Math.Ceiling((double)(feeSrv.Quan_med / feeSrv.Factor_mb)) / factor)) * times;
                    }
                    else if (Sd_mupkgutp == "1") {
                        feeSrv.Quan_cur = Math.Ceiling((double)(feeSrv.Quan_med / feeSrv.Factor_mb * times / factor));
                    }
                    else if (Sd_mupkgutp == "4") {
                        feeSrv.Quan_cur = (double)(feeSrv.Quan_med / feeSrv.Factor_mb * times / factor);
                    }
                }
                quan_cur = feeSrv.Quan_cur;
                #endregion
            }
            else {
                #region 计算服务总量
                feeSrv.Quan_total_medu = getNotDrugTotal(feeSrv.Quan_med.DoubleValue(), feeSrv.Id_freq, feeSrv.Freqct.Value, Use_days);
                quan_cur = feeSrv.Quan_total_medu;
                #endregion
            }
            return quan_cur;
            
        }
        /// <summary>
        /// 设置取整模式
        /// </summary>
        /// <param name="emsOrDrug"></param>
        /// <param name="isOp"></param>
        /// <param name="mmArray"></param>
        /// <param name="isOutPress">出院带药标识</param>
        private void setSd_mukgutp(EmsOrDrug emsOrDrug, string code_entp, object[] mmArray,bool isOutPress=false)
        {
            if (EnDictCodeConst.SD_ENTP_INPATIENT.Equals(code_entp))
            {//住院
                if (isOutPress)//出院带药使用门诊的取整模式
                {
                    if (mmArray[2] != null)
                        emsOrDrug.Sd_mupkgutp = mmArray[2].ToString();
                }
                else {
                    if (mmArray[1] != null)
                        emsOrDrug.Sd_mupkgutp = mmArray[1].ToString();
                }
            }
            else
            { //门诊
                if (mmArray[2] != null)
                    emsOrDrug.Sd_mupkgutp = mmArray[2].ToString();
            }
        }

       
        /// <summary>
        /// 变动用药按批取整
        /// </summary>
        /// <param name="emsOrDrug"></param>
        /// <param name="emsOrDoseDrug"></param>
        /// <param name="factor"></param>
        private void opmutpDoseDrugTotal(EmsOrDrug emsOrDrug, EmsOrDrug[] emsOrDoseDrug, double factor)
        {
            if (emsOrDrug.Use_days == null || emsOrDrug.Use_days == 0) return;
            switch (emsOrDrug.Sd_frequnitct)
            {
                case BdSrvDictCodeConst.SD_FREQUNIT_DAY:// "天"
                    double? quanCount = 0;
                    foreach (EmsOrDrug item in emsOrDoseDrug)
                    {
                        quanCount += (item.Quan_med / emsOrDrug.Factor_mb) * emsOrDrug.Use_days;
                    }
                    emsOrDrug.Quan_cur = Math.Ceiling((double)quanCount / factor);
                    break;
                case BdSrvDictCodeConst.SD_FREQUNIT_WEEK: //"星期"
                    quanCount = 0;
                    foreach (EmsOrDrug item in emsOrDoseDrug)
                    {
                        quanCount += (item.Quan_med / emsOrDrug.Factor_mb) * emsOrDrug.Use_days / 7;
                    }
                    emsOrDrug.Quan_cur = Math.Ceiling((double)quanCount / factor);
                    break;
                default:
                    this.ShowInfo("只有按天或按周执行的频次可设置变动用药！");
                    break;
            }
        }
        /// <summary>
        /// 变动用药按次取整
        /// </summary>
        /// <param name="emsOrDrug"></param>
        /// <param name="emsOrDoseDrug"></param>
        /// <param name="factor"></param>
        private void kgutpDoseDrugTotal(EmsOrDrug emsOrDrug, EmsOrDrug[] emsOrDoseDrug, double factor)
        {
            if (emsOrDrug.Use_days == null || emsOrDrug.Use_days == 0) return;
            switch (emsOrDrug.Sd_frequnitct)
            {
                case BdSrvDictCodeConst.SD_FREQUNIT_DAY:// "天"
                    double? quanCount = 0;
                    foreach (EmsOrDrug emsdrug in emsOrDoseDrug)
                    {
                        quanCount += Math.Ceiling((double)(Math.Ceiling((double)(emsdrug.Quan_med / emsOrDrug.Factor_mb)) / factor)) * emsOrDrug.Use_days;
                    }
                    emsOrDrug.Quan_cur = quanCount;
                    break;
                case BdSrvDictCodeConst.SD_FREQUNIT_WEEK: //"星期"
                    quanCount = 0;
                    foreach (EmsOrDrug emsdrug in emsOrDoseDrug)
                    {
                        quanCount += Math.Ceiling((double)(Math.Ceiling((double)(emsdrug.Quan_med / emsOrDrug.Factor_mb)) / factor)) * emsOrDrug.Use_days / 7;
                    }
                    emsOrDrug.Quan_cur = quanCount;
                    break;
                default:
                    this.ShowInfo("只有按天或按周执行的频次可设置变动用药！");
                    break;
            }
        }
        /// <summary>
        /// 校验参数是否满足计算条件
        /// </summary>
        /// <param name="emsOrDrug"></param>
        /// <param name="mmArray"></param>
        /// <param name="isOp"></param>
        /// <returns></returns>
        private bool isValidate(EmsOrDrug emsOrDrug, object[] mmArray)
        {
            double factor = mmArray[0] == null ? 0 : Convert.ToDouble(mmArray[0].ToString());
            bool flag = true;
            if ( factor <= 0)
            {
                this.ShowInfo(emsOrDrug.Name_mm + " 总量系数取值错误！ ");
                flag = false;
            }
            else if (emsOrDrug.Quan_med == null)
            {
                this.ShowInfo(emsOrDrug.Name_srv + "的剂量为空，不可参与总量计算！");
                flag = false;
            }
            else if (emsOrDrug.Factor_mb == null || emsOrDrug.Factor_mb <= 0)
            {
                this.ShowInfo(emsOrDrug.Name_srv + "的换算系数为空，不可参与总量计算！");
                flag = false;
            }
            if (!flag)
            {
                clearEmsOrDrugPropety(emsOrDrug);
            }
            return flag;
        }
        /// <summary>
        /// 获取物品的总量单位对应的换算系数和物品的取整模式
        /// </summary>
        /// <param name="id_mm"></param>
        /// <param name="id_unit_sale"></param>
        public object[] getDrugMMFactorMupkgutp(MeterialAggDO[] aggdos,string id_mm, string id_unit_sale)
        {
            object[] mmArray = new object[] { null, null, null };
            MeterialAggDO aggDo = null;
            if (aggdos == null) return mmArray;
            foreach(MeterialAggDO aggdo in aggdos){
                if (aggdo.getParentDO().Id_mm == id_mm) {
                    aggDo = aggdo;
                    break;
                }
            }
            if (aggDo == null)
            {
                return mmArray;
            }
            MeterialDO mm = aggDo.getParentDO();
            if (mm != null)
            {
                mmArray[1] = mm.Sd_mupkgutp;
                mmArray[2] = mm.Sd_opmutp;
            }
            MMPackageUnitDO mmpackageUnitDO = aggDo.getMMPackageUnitDO().FirstOrDefault(p => p.Id_unit_pkg == id_unit_sale);
            double? factor = null;//总量单位对应你的换算系数
            if (mmpackageUnitDO != null)
            {
                factor = aggDo.getMMPackageUnitDO().FirstOrDefault(p => p.Id_unit_pkg == id_unit_sale).Factor;
                mmArray[0] = factor;
            }
            return mmArray;
        }
        /// <summary>
        /// 获取物品的总量单位对应的换算系数和物品的取整模式
        /// </summary>
        /// <param name="id_mm"></param>
        /// <param name="id_unit_sale"></param>
        public object[] getDrugMMFactorMupkgutp(string id_mm, string id_unit_sale)
        {
            object[] mmArray = new object[] { null, null, null };
            MeterialAggDO aggDo = XapServiceMgr.find<IMeterialCrudService>().findById(id_mm);
            if (aggDo == null)
            {
                return mmArray;
            }
            MeterialDO mm = aggDo.getParentDO();
            if (mm != null)
            {
                mmArray[1] = mm.Sd_mupkgutp;
                mmArray[2] = mm.Sd_opmutp;
            }
            MMPackageUnitDO mmpackageUnitDO = aggDo.getMMPackageUnitDO().FirstOrDefault(p => p.Id_unit_pkg == id_unit_sale);
            double? factor = null;//总量单位对应你的换算系数
            if (mmpackageUnitDO != null)
            {
                factor = aggDo.getMMPackageUnitDO().FirstOrDefault(p => p.Id_unit_pkg == id_unit_sale).Factor;
                mmArray[0] = factor;
            }
            return mmArray;
        }
        public string[] getMMIds(XapDataList<EmsOrDrug> emsordrugs) { 
            if(emsordrugs==null||emsordrugs.Count==0) return null;
            string[] ids = new string[emsordrugs.Count];
            for(int i=0;i<emsordrugs.Count;i++){
                if (!string.IsNullOrEmpty(emsordrugs[i].Id_mm))
                {
                    ids[i] = emsordrugs[i].Id_mm;
                }
                else {
                    ids[i] = "id_mm";
                }
            }
            return ids;
        }
        /// <summary>
        /// 非药品计算总量
        /// </summary>
        /// <param name="med">剂量</param>
        /// <param name="id_frect">频次id</param>
        /// <param name="frect">频次下的次数</param>
        /// <param name="useday">使用天数</param>
        /// <returns></returns>
        public double getNotDrugTotal(double med = 1, string id_frect = null, int frect = 1, int useday = 1)
        {
            frect = (frect == 0 ) ? 1 : frect;//|| frect == null
            med = (med == 0 ) ? 1 : med;//|| med == null
            useday = (useday == 0 ) ? 1 : useday;//|| useday == null
            return med * frect * useday;
        }

        /// <summary>
        /// Gets药品总量
        /// </summary>
        /// <param name="headDo">The head do.</param>
        /// Author:admin
        /// Date:2016-01-07
        public void GetDrugTotal(EmsUIDTO headDo)
        {
            if (headDo.Emsdrugs.Fg_dose_anoma == null || !headDo.Emsdrugs.Fg_dose_anoma.Value)//非变动用药
            {
                //改动：非变动用药使用总次数,变动用药使用总天数,因此将计算总次数的调用从方法开始处，移动到非变动用药的算法中
                int times = GetDrugUseTotalCount(headDo);//总次数 
                if (times == 0) return;
                string[] id_mms = getMMIds(headDo.Emsdrugs.EmsOrDrugList);
                if (id_mms == null) {
                    this.ShowInfo("医嘱中不存在物品！");
                    return;
                }
                MeterialAggDO[] aggDo = null;
                try {
                   aggDo = XapServiceMgr.find<IMeterialCrudService>().findByBIds(id_mms, false);
                }catch(Exception ex){
                    ex.Publish();
                }
                
                foreach (EmsOrDrug item in headDo.Emsdrugs.EmsOrDrugList)
                {
                    if (item.Id_mm == null || item.Id_mm == "")
                    {
                        continue;
                    }
                    object[] mmArr = getDrugMMFactorMupkgutp(aggDo, item.Id_mm, item.Id_unit_sale);
                    double factor = mmArr[0] == null ? 0 : Convert.ToDouble(mmArr[0]);//总量单位对应你的换算系数
                    //门诊的取门诊的取整模式，住院的取住院的取整模式，出院带药使用门诊的取整模式
                    setSd_mukgutp(item, headDo.PatInfo.Code_entp, mmArr, headDo.Emsdrugs.Fg_outp == null ? false : (bool)headDo.Emsdrugs.Fg_outp);
                    if (!isValidate(item, mmArr))
                    {
                        continue;
                    }
                    if (item.Sd_mupkgutp == "0")//按次取整
                    {
                        item.Quan_cur = Math.Ceiling((double)(Math.Ceiling((double)(item.Quan_med / item.Factor_mb)) / factor)) * times;

                    }
                    else if(item.Sd_mupkgutp =="1")//按批取整
                    {
                        item.Quan_cur = Math.Ceiling((double)(item.Quan_med / item.Factor_mb * times / factor));
                    }else if(item.Sd_mupkgutp == "4"){//不取整
                        item.Quan_cur = (double)(item.Quan_med / item.Factor_mb * times / factor);
                    }
                    item.Factor_cb = factor;
                }
            }
            else
            {
                //如果频次的值为空，去数据库查询一下，重新设置频次的sd值
                //setSd_frequnitct(headDo);
                //变动用药
                foreach (EmsOrDrug item in headDo.Emsdrugs.EmsOrDrugList)
                {
                    //设置频次
                    if (item.Sd_frequnitct == null)
                    {
                        setDrugFreqInfo(item);
                    }
                    object[] mmArr = getDrugMMFactorMupkgutp(item.Id_mm, item.Id_unit_sale);
                    double factor = mmArr[0] == null ? 0 : Convert.ToDouble(mmArr[0]);//总量单位对应你的换算系数
                    setSd_mukgutp(item, headDo.PatInfo.Code_entp, mmArr, headDo.Emsdrugs.Fg_outp == null ? false : (bool)headDo.Emsdrugs.Fg_outp);
                    isValidate(item, mmArr);
                    item.Use_days = headDo.Emsdrugs.Use_days;
                    if (item.Use_days == 0 || item.Use_days == null) return;
                    //按次取整
                    if (item.Sd_mupkgutp == "0")
                    {
                        //变动用药按次取整
                        kgutpDoseDrugTotal(item, headDo.Emsdrugs.EmsOrDoseDrug, factor);
                    }
                    else
                    {
                        //按批取整
                        opmutpDoseDrugTotal(item, headDo.Emsdrugs.EmsOrDoseDrug, factor);

                    }
                    item.Factor_cb = factor;
                }
            }

        }
        /// <summary>
        /// 处理频次
        /// </summary>
        /// <param name="emsUIDTO"></param>
        /// <returns></returns>
        public void setSd_frequnitct(EmsUIDTO ems)
        {
            if (ems.Emsdrugs.Sd_frequnitct == null)
            {
                //为空需要去取频次周期的单位，正常逻辑是headDo应该带的，但是需要bd_srv元数据重新生成，动静比较大，所以先临时查询下，等以后元数据生成后按正常逻辑
                IFreqdefMDOCrudService freqdef = XapServiceMgr.find<IFreqdefMDOCrudService>();
                FreqDefDO fq = freqdef.findById(ems.Emsdrugs.Id_freq);
                ems.Emsdrugs.Sd_frequnitct = fq.Sd_frequnitct;
            }
        }

        /// <summary>
        /// 判断服务是否为抗菌药
        /// </summary>
        /// <param name="id_srv"></param>
        /// <returns></returns>
        public bool IsAntDrug(string id_srv)
        {
            MedSrvDrugDO des = new GetSrvDrugPropImp().GetMedSrvDrupProp(id_srv);
            if (des != null)
            {
                if (des.Fg_anti.Value)
                {
                    return true;
                }
            }
            return false;
        }

        /// <summary>
        /// 生成医嘱嘱托
        /// </summary>
        /// <param name="ems"></param>
        public void SetNoteOr(EmsUIDTO ems)
        {
            int orders_day = ems.Emsdrugs.Use_days != null && ems.Emsdrugs.Use_days.Value > 0 && ems.Emsdrugs.Orders != null ?
                (int)(ems.Emsdrugs.Orders / ems.Emsdrugs.Use_days) : 1;
            orders_day = 1;
            if (!string.IsNullOrEmpty(ems.Emsdrugs.Sd_srvtp))
            {
                StringBuilder sb = new StringBuilder();
                if (ems.Emsdrugs.Sd_srvtp.StartsWith(BdSrvDictCodeConst.SD_SRVTP_HERBDRUG))
                {
                    //sb.Append(string.Format("每日{0}付", orders_day));//草药的值为1
                    sb.Append(string.Format("每日{0}付", 1));
                    sb.Append(String.IsNullOrWhiteSpace(ems.Emsdrugs.Name_boil) ? "" : string.Format(",{0}至400ml", ems.Emsdrugs.Name_boil));
                    sb.Append(String.IsNullOrWhiteSpace(ems.Emsdrugs.Name_freq) ? "" : string.Format(",{0}", ems.Emsdrugs.Name_freq));
                    sb.Append(String.IsNullOrWhiteSpace(ems.Emsdrugs.Name_routedes) ? "," : string.Format(",{0}", ems.Emsdrugs.Name_routedes));
                    sb.Append(String.IsNullOrWhiteSpace(ems.Emsdrugs.Name_route) ? "" : ems.Emsdrugs.Name_route);
                }
                else if (ems.Emsdrugs.Sd_srvtp.StartsWith(BdSrvDictCodeConst.SD_SRVTP_DRUG_WESTDRUG))
                {
                    sb.Append(String.IsNullOrWhiteSpace(ems.Emsdrugs.Name_routedes) ? "" : ems.Emsdrugs.Name_routedes);
                }
                ems.Emsdrugs.Note_or = sb.ToString();
            }
            else {
                this.SetStatusMsg("医疗单服务类型为空,拼接备注信息失败！");
            }
        }

        #endregion 配置 算法

        #region 接口调用
        /// <summary>
        /// 获取服务关联的物品id的字符串 格式为  '','',''
        /// </summary>
        /// <param name="headDo"></param>
        /// <returns></returns>
        public string GetSrvMmStr(EmsUIDTO headDo, string id_srv,bool isOutPress = false)
        {
            string str = "'";
            XapDataList<EmsOrDrug> drug = GetSrvMm(headDo, id_srv, headDo.PatInfo.Code_entp, isOutPress);

            drug.ToList().ForEach(p => str += p.Id_mm + "','");
            str = str.Remove(str.Length - 2);
            return str;// str.TrimEnd(",'".ToCharArray());
        }

        /// <summary>
        /// 获取服务关联的物品
        /// </summary>
        /// <param name="headDo">The head do.</param>
        /// <param name="id_srvs">服务di串.</param>
        /// <param name="isOutPres">出院带药标识</param>
        /// <returns></returns>
        public XapDataList<EmsOrDrug> GetSrvMm(EmsUIDTO headDo, string id_srvs, string code_entp,bool isOutPres=false)
        {
            GetDept_Mp(headDo);//获取执行科室
            //构建就诊上下文信息时的就诊模式
            EmsAppModeEnum emsAppModeEnum = EmsAppModeEnum.SVEMSAPPMODE;
            if(isOutPres){
                emsAppModeEnum = EmsAppModeEnum.OUTHEMSAPPMODE;//出院带药
            }else if (code_entp.Equals(EnDictCodeConst.SD_ENTP_OUTPATIENT)) {
                emsAppModeEnum = EmsAppModeEnum.SVEMSAPPMODE;//简洁版
            }
            else if (code_entp.Equals(EnDictCodeConst.SD_ENTP_INPATIENT))
            {
                emsAppModeEnum = EmsAppModeEnum.IVEMSAPPMODE;//智慧版
            }
            CiEnContextDTO contextdto = CiEnContextUtil.GetCiEnContext(headDo.PatInfo, emsAppModeEnum);
            
            //测试接口
            return new OrderCardViewModel().GetOrDrugs(id_srvs, headDo.PatInfo.Id_hp, isOutPres == true ? EnDictCodeConst.SD_ENTP_OUTPATIENT : code_entp, contextdto);

            //TODO: 调用接口正式版 测试时候不用，最后用
            //List<EmsDrugItemDO> deps = new GetDeptMpImp().GetDept_mp(headDo.Id_entp, headDo.Id_srvtp, headDo.Id_srvca, headDo.Id_srv, headDo.Id_route);
            //return new GetMmImp().GetMm(headDo.Emsdrugs.Id_org, id_srvs, string.Join(";", deps.Select(p => p.Id_dep)), headDo.Id_dep_phy);
        }
      
        ////获取
        //public List<EmsOrDrug> GetRefMms(EmsUIDTO headDo, string id_srv)
        //{
        //    EmsUIDTO head = new EmsUIDTO { Id_srv = id_srv, Id_entp = headDo.Id_entp, Id_srvca = headDo.Id_srvca, Id_route = headDo.Id_route, Emsdrugs = new EmsDrugItemDO { Id_org = headDo.Emsdrugs.Id_org } };
        //    return GetSrvMm(head);
        //}

        /// <summary>
        /// Gets 已存医嘱s关联的物品s
        /// </summary>
        /// <param name="headDo">The head do.</param>
        /// <param name="id_orsrvs">The id_orsrvs.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-10-13
        //public XapDataList<EmsOrDrug> GetOrdMm(EmsUIDTO headDo, string id_orsrvs)
        //{
        //    XapDataList<EmsOrDrug> list = new XapDataList<EmsOrDrug>();
        //    OrdSrvMmDO[] mms = new OrdermmViewModel().GetMm(id_orsrvs);

        //    mms.ToList().ForEach(p =>
        //    {
        //        //从所有物品中找到 医嘱物品 并把医嘱物品的特殊属性赋值上去
        //        EmsOrDrug drug = DoCopy<EmsOrDrug>(headDo.Emsdrugs.EmsOrDrug.FirstOrDefault(x => x.Id_mm == p.Id_mm));
        //        if (drug != null)
        //        {
        //            drug.Status = DOStatus.UPDATED;//存在的则为更新态
        //            drug.Id_orsrv = p.Id_orsrv;
        //            drug.Id_emsordrug = p.Id_orsrvmm;//主键
        //            drug.Sv = p.Sv;//版本号
        //            drug.Name_srv = headDo.Emsdrugs.Name_srv;//通用名
        //            drug.Quan_base = p.Quan_num_base;
        //            drug.Id_unit_base = p.Id_pgku_base;
        //            drug.Name_unit_base = p.Name_pgku_cur;
        //            drug.Quan_cur =p.Quan_cur==null? 0:(int) p.Quan_cur;
        //            drug.Id_pgku_cur = p.Id_pgku_base;
        //            drug.Name_pgku_cur = p.Name_pgku_cur;
        //            list.Add(drug);
        //        }
        //    });
        //    return list;
        //}

        public XapDataList<EmsOrDrug> GetOrdMm(EmsUIDTO headDo, string id_orsrvs)
        {
            XapDataList<EmsOrDrug> list = new XapDataList<EmsOrDrug>();

            headDo.Emsdrugs.EmsOrDrugList.ToList().ForEach(p =>
            {
                //从所有物品中找到 医嘱物品 并把医嘱物品的特殊属性赋值上去
                //EmsOrDrug drug = DoCopy<EmsOrDrug>(headDo.Emsdrugs.EmsOrDrug.FirstOrDefault(x => x.Id_mm == p.Id_mm));
                EmsOrDrug drug = new EmsOrDrug();
                if (p.Id_mm != null && p.Id_mm != "")
                {
                    CopyTo(headDo.Emsdrugs.EmsOrDrug.FirstOrDefault(x => x.Id_mm == p.Id_mm), drug);
                    if (drug != null)
                    {
                        drug.Status = DOStatus.UPDATED;//存在的则为更新态
                        drug.Id_orsrv = p.Id_orsrv;
                        drug.Id_emsordrug = p.Id_emsordrug;//主键
                        drug.Sv = p.Sv;//版本号
                        drug.Name_srv = p.Name_srv;//通用名
                        drug.Quan_base = p.Quan_base;
                        drug.Id_unit_base = p.Id_unit_base;
                        drug.Name_unit_base = p.Name_unit_base;
                        drug.Id_unit_sale = p.Id_unit_sale;
                        drug.Name_unit_sale = p.Name_unit_sale;
                        drug.Price = p.Price;
                        drug.Quan_cur = p.Quan_cur == null ? 0 : p.Quan_cur;
                        drug.Id_pgku_cur = p.Id_pgku_cur;
                        drug.Name_pgku_cur = p.Name_pgku_cur;
                        drug.Quan_med = p.Quan_med;
                        drug.Quan_medu_virtual = p.Quan_med;
                        drug.Name_unit_medu_virtual = p.Name_unit_med;
                        drug.Id_boildes = p.Id_boildes;
                        drug.Name_boildes = p.Name_boildes;
                        drug.Fg_propc = p.Fg_propc;
                        drug.Fg_treat = p.Fg_treat;
                        drug.Note_or = p.Note_or;
                        drug.Id_mp_dep = p.Id_mp_dep;
                        drug.Name_mp_dep = p.Name_mp_dep;
                        drug.Fg_self = p.Fg_self;
                        drug.Fg_selfpay = p.Fg_selfpay;
                        drug.Use_days = p.Use_days;
                        //皮试内容
                        drug.Fg_skintest = p.Fg_skintest;
                        drug.Id_or_rel = p.Id_or_rel;
                        drug.Id_reltp = p.Id_reltp;
                        drug.Sd_reltp = p.Sd_reltp;
                        drug.Factor_cb = p.Factor_cb;
                        drug.Factor_mb = p.Factor_mb;
                        drug.Fg_extdispense = p.Fg_extdispense;//外配药标识
                        list.Add(drug);
                    }
                }
                else
                {
                    list.Add(p);
                }

            });
            headDo.Emsdrugs.EmsOrDrugList.Clear();

            return list;
        }

        public XapDataList<EmsOrDrug> GetOrdMm(EmsDrugItemDO emsdrugs, string id_orsrvs)
        {
            XapDataList<EmsOrDrug> xapDataList = new XapDataList<EmsOrDrug>();

            emsdrugs.EmsOrDrugList.ToList().ForEach(p =>
            {
                //从所有物品中找到 医嘱物品 并把医嘱物品的特殊属性赋值上去

                EmsOrDrug drug = new EmsOrDrug();
                CopyTo(emsdrugs.EmsOrDrug.FirstOrDefault(x => x.Id_mm == p.Id_mm), drug);
                if (drug != null)
                {
                    drug.Status = DOStatus.UPDATED;//存在的则为更新态
                    drug.Id_orsrv = p.Id_orsrv;
                    drug.Id_emsordrug = p.Id_emsordrug;//主键
                    drug.Sv = p.Sv;//版本号
                    drug.Name_srv = p.Name_srv;//通用名
                    drug.Quan_base = p.Quan_base;
                    drug.Id_unit_base = p.Id_unit_base;
                    drug.Name_unit_base = p.Name_pgku_cur;
                    drug.Quan_cur = p.Quan_cur == null ? 0 : (int)p.Quan_cur;
                    drug.Id_pgku_cur = p.Id_pgku_cur;
                    drug.Name_pgku_cur = p.Name_pgku_cur;
                    drug.Quan_med = p.Quan_med;
                    drug.Id_boildes = p.Id_boildes;
                    drug.Name_boildes = p.Name_boildes;
                    xapDataList.Add(drug);
                }
            });
            emsdrugs.EmsOrDrugList.Clear();

            return xapDataList;
        }


        /// <summary>
        /// 获取总量的单位
        /// </summary>
        /// <param name="headDo">The head do.</param>
        /// Author:admin
        /// Date:2015-09-24
        public void GetDrugTotalUnit(EmsUIDTO headDo)
        {
            headDo.Emsdrugs.Total_count_unit = new GetCoutUnitImp().GetDrugTotalUnit(headDo.PatInfo.Id_dep_phy, headDo.Emsdrugs.Id_mm, headDo.PatInfo.Id_entp);
        }

        /// <summary>
        /// 获取执行科室
        /// </summary>
        /// <param name="headDo">The head do.</param>
        /// Author:admin
        /// Date:2015-09-24
        public List<string> GetDept_Mp(EmsUIDTO headDo)
        {
            List<string> list = new List<string>();
            OrWfDeptInfoDTO wf = new GetDeptMpImp().GetDept_mp_ids(headDo.PatInfo.Code_entp, headDo.PatInfo.Id_entp, headDo.MedSrvDO.Sd_srvtp, headDo.MedSrvDO.Id_srvca, headDo.MedSrvDO.Id_srv, headDo.MedSrvDO.Id_route, "id_mm", headDo.PatInfo.Id_dep_nur, headDo.PatInfo.Id_dep_phy);
            headDo.Emsdrugs.Str_mp_dep_ids = wf == null ? "" : wf.Id_mp_depts;
            if (headDo.Emsdrugs.Id_dep == null)
            {
                headDo.Emsdrugs.Id_dep = wf == null ? "" : wf.Firstid_mp_dept;
                headDo.Emsdrugs.Name_dep = wf == null ? "" : wf.Firstname_mp_dept;

            }
            if (wf != null)
            {
                //     headDo.Emsdrugs.Id_dep = wf==null?"":wf.Firstid_mp_dept;
                //     headDo.Emsdrugs.Name_dep = wf == null ? "" : wf.Firstname_mp_dept;
                if (wf.Id_dept_wh != null)
                {
                    foreach (EmsOrDrug ems in headDo.Emsdrugs.EmsOrDrugList)
                    {
                        ems.Id_dep_wh = wf.Id_dept_wh;
                    }
                }
            }
            return list;
        }

        

        /// <summary>
        /// Gets 获取服务的检查
        /// </summary>
        /// <param name="headDo">The head do.</param>
        /// <returns></returns>
        public XapDataList<EmsObsItemDO> GetObsList(EmsUIDTO headDo)
        {
            return new GetObsImp().GetObsList(headDo.MedSrvDO.Id_srv);
        }
        /// <summary>
        /// Gets 获取服务的检验项目
        /// </summary>
        /// <param name="headDo">The head do.</param>
        /// <returns></returns>
        public XapDataList<EmsObsLap> GetLabList(EmsUIDTO headDo, MedSrvDO med)
        {
            return new GetSrvLabImp().GetLabImpList(headDo, med);
        }
        /// <summary>
        /// Gets 获取服务的检验项目 服务套
        /// </summary>
        /// <param name="headDo">The head do.</param>
        /// <returns></returns>
        public XapDataList<EmsObsItemDO> GetLabFgSetList(EmsUIDTO headDO, MedsrvAggDO[] medsrvagg)
        {
            return new GetSrvLabImp().getLabImplList(headDO, medsrvagg);
        }

        /// <summary>
        /// 获取患者的诊断id拼接串
        /// </summary>
        /// <param name="id_en">The id_en.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-10-15
        public string GetPatDis(EmsUIDTO headDo, ref string[] mainDi)
        {

            return new GetPatDiagImp().getEntDiDOList(headDo.PatInfo.Id_ent,headDo.PatInfo.Code_entp, ref mainDi);
        }
        /// <summary>
        /// 获取患者的诊断id拼接串
        /// </summary>
        /// <param name="id_en">The id_en.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-10-15
        public string GetDiname(EmsUIDTO headDo, string id_didef, ref string[] mainDi)
        {

            return new GetPatDiagImp().getDiName(headDo.PatInfo.Id_ent, id_didef, ref mainDi);
        }

        /// <summary>
        /// Gets 输血前检查项目
        /// </summary>
        /// <param name="sd_srvtp">The SD_SRVTP.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-10-30
        public XapDataList<OrdApSugViewItemDO> GetBtLabItme(string id_srv)
        {
            return new GetSrvViewItemImp().GetSrvLabItemByIdSrv(id_srv);
        }
        /// <summary>
        /// Gets 会诊应邀科室列表
        /// </summary>
        /// <param name="id_Cons">The 会诊申请单id.</param>
        public XapDataList<EmsItemInCons> GetInviteCons(string id_Cons)
        {
            return new OrderInviteConsViewModel().GetInviteCons(id_Cons);
        }


        public XapDataList<EmsOrDrug> GetMmByMmtp(string id_mmtp)
        {
            return new GetMmByMmtpImp().GetMmByMmtp(id_mmtp);
        }

        public MedSrvConsDO GetCons(string id_srv)
        {
            return new GetSrvConstpImp().findByIdsrv(id_srv);
        }

        public MedSrvLisDO GetPathgyLab(string id_srv)
        {
            return new GetSrvLabImp().GetLabById(id_srv);
        }

        #endregion 接口调用

        #region 工具

        /// <summary>3
        /// 将普通集合转换为 表格控件需要的集合 曹振的表格
        /// 手工对数据源赋值时候 需要这样转化一下
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="list">The list.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-09-23
        public XapDataList<T> ConvertDataSouse<T>(IList<T> list) where T : BaseSO
        {
            XapDataList<T> bList = new XapDataList<T>();
            list.ToList().ForEach(p => bList.Add(p));
            return bList;
        }

        public void Clear<T>(T target,String[] notProps = null) where T : BaseSO
        {
            if (null == target)
                return;

            foreach (var property in target.GetType().GetProperties())
            {
                if (property.CanWrite)
                {
                    if (notProps != null && notProps.Contains(property.Name))
                        continue;

                    target.GetType().InvokeMember(property.Name, BindingFlags.SetProperty, null, target, new object[] { null });
                }
            }
        }

        /// <summary>
        /// 对象copy 方法一
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="t">The t.</param>
        /// <returns></returns>
        public T DoCopy<T>(T t) where T : new()
        {
            T tt = new T();
            Type type = t.GetType();
            System.Reflection.PropertyInfo[] ps = type.GetProperties();
            foreach (PropertyInfo i in ps)
            {
                object obj = i.GetValue(t, null);
                if (obj != null && i.CanWrite)
                {
                    PropertyInfo info = tt.GetType().GetProperties().FirstOrDefault(p => p.Name == i.Name);
                    info.SetValue(tt, obj, null);
                }
            }
            return tt;
        }

        /// <summary>
        /// 对象copy 方法二
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="t">The t.</param>
        /// /// <param name="t">是否复制空字段</param>
        /// <returns></returns>
        public void CopyTo<T>(object source, T target, bool copyNull = false)
         where T : class, new()
        {
            if (source == null)
                return;

            if (target == null)
            {
                target = new T();
            }

            // 构造目标对象的属性对象集合
            Dictionary<String, PropertyInfo> targetPropDic = new Dictionary<String, PropertyInfo>();
            PropertyInfo[] targetDicPropertys = target.GetType().GetProperties();
            foreach (PropertyInfo prop in targetDicPropertys)
            {                
                if (!targetPropDic.ContainsKey(prop.Name))
                {
                    targetPropDic.Add(prop.Name, prop);
                }
                else
                {
                    throw new Exception(string.Format("属性拷贝异常，存在相同的属性名【{0}】", prop.Name));
                }

            }

            // 遍历原对象，对目标对象进行属性赋值，如果目标对象中不含有原对象的属性，继续进行下一个属性赋值
            foreach (PropertyInfo sourceProp in source.GetType().GetProperties())
            {
                if (!targetPropDic.ContainsKey(sourceProp.Name))
                {
                    continue;
                }

                PropertyInfo targetProp = targetPropDic[sourceProp.Name];
                var propertyValue = sourceProp.GetValue(source, null);

                if (propertyValue != null || copyNull)
                {
                    if (targetProp.CanWrite)
                    {
                        target.GetType().InvokeMember(sourceProp.Name, BindingFlags.SetProperty, null, target, new object[] { propertyValue });
                    }
                }
            }
        }

        /// <summary>
        /// 对象值的拷贝
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="source"></param>
        /// <param name="target"></param>
        /// <param name="str">要排除赋值的字段</param>
        public void CopyTo<T>(object source, T target, params string[] str)
               where T : class,new()
        {
            if (source == null || target == null)
                return;
            foreach (var property in target.GetType().GetProperties())
            {
                if (str.FirstOrDefault(p => p == property.Name) != null)
                {
                    continue;
                }

                var propertyValue = source.GetType().GetProperty(property.Name).GetValue(source, null);
                if (propertyValue != null)
                {
                    if (property.CanWrite)
                    {
                        target.GetType().InvokeMember(property.Name, BindingFlags.SetProperty, null, target, new object[] { propertyValue });
                    }

                }

            }


        }
        public void OrVoice(string strtxt)
        {
            SpeechSynthesizer reader = new SpeechSynthesizer();
            reader.SpeakAsync(strtxt);
        }
        /// <summary>
        /// 改变控件布局调整控件Y轴绝对位置
        /// </summary>
        /// <param name="tableKey">页签编码</param>
        /// <param name="ah">要调整的控件ID数组</param>
        /// <param name="height">调整高度</param>
        public void adjustHeight(XapFormControl control, String tableKey, string[] ah, int height)
        {
            for (int i = 0; i < ah.Length; i++)
            {
                object tmpobj = control.GetUserRender(tableKey, ah[i]);
                if (tmpobj == null) continue;

                if (tmpobj is XLabelBaseUserRender)
                {
                    XLabelBaseUserRender tmp = control.GetUserRender(tableKey, ah[i]) as XLabelBaseUserRender;
                    if (tmp == null)
                    {
                        continue;
                    }
                    tmp.Location = new Point(tmp.Location.X, tmp.Location.Y + height);

                }
                else if (tmpobj is XGroupBox)
                {
                    XGroupBox tmp = control.GetUserRender(tableKey, ah[i]) as XGroupBox;
                    if (tmp == null)
                    {
                        continue;
                    }
                    tmp.Location = new Point(tmp.Location.X, tmp.Location.Y + height);
                }
                else
                {
                    XLabel lable = control.GetUserRender(tableKey, ah[i]) as XLabel;
                    if (lable == null)
                    {
                        continue;
                    }
                    lable.Location = new Point(lable.Location.X, lable.Location.Y + height);

                }
            }

        }

        public void setEnable(XapFormControl control, String tableKey, string[] ah, bool flag)
        {
            UserRender[] renders = control.GetPageUserRenders(tableKey);
            if (renders != null && renders.Length > 0)
            {
                foreach (UserRender render in renders)
                {
                    if (render is XLabelBaseUserRender)
                    {
                        XLabelBaseUserRender tmp = render as XLabelBaseUserRender;
                        tmp.Enabled = flag;

                    }
                    else if (render is XGroupBox)
                    {
                        XGroupBox tmp = render as XGroupBox;
                        tmp.Enabled = flag;
                    }
                    else
                    {
                        XLabel lable = render as XLabel;
                        lable.Enabled = flag;

                    }
                }
            }
            //for (int i = 0; i < ah.Length; i++)
            //{
            //    object tmpobj = control.GetUserRender(tableKey, ah[i]);
            //    if (tmpobj == null) continue;

            //    if (tmpobj is XLabelBaseUserRender)
            //    {
            //        XLabelBaseUserRender tmp = control.GetUserRender(tableKey, ah[i]) as XLabelBaseUserRender;
            //        tmp.Enabled = flag;

            //    }
            //    else if (tmpobj is XGroupBox)
            //    {
            //        XGroupBox tmp = control.GetUserRender(tableKey, ah[i]) as XGroupBox;
            //        tmp.Enabled = flag;
            //    }
            //    else
            //    {
            //        XLabel lable = control.GetUserRender(tableKey, ah[i]) as XLabel;
            //        lable.Enabled = flag;

            //    }
            //}
        }
        #endregion 工具

        #region 住院门诊公用数据

        /// <summary>
        /// Creats the UIems intance.
        /// </summary>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-12-15
        public EmsUIDTO CreatEmsIntance()
        {
            return new EmsUIDTO()
            {
                MedSrvDO = new MedSrvDO(),

                /*药品*/
                Emsdrugs = new EmsDrugItemDO { EmsOrDrug = new XapDataList<EmsOrDrug>(), EmsOrDrugList = new XapDataList<EmsOrDrug>(), EmsOrDoseDrug = new XapDataList<EmsOrDrug>(), EmsOrDeleteDrugList = new XapDataList<EmsOrDrug>() },
                /*检验*/
                Emsapobs = new EmsObsItemDO { EmsOrDrugList = new XapDataList<EmsOrDrug>(), EmsOrObsList = new XapDataList<EmsObsLap>(), EmsOrObsListDel = new XapDataList<EmsObsLap>() },
                /*检查*/
                Emsaplab = new EmsObsItemDO { EmsOrDrugList = new XapDataList<EmsOrDrug>(), EmsOrObsList = new XapDataList<EmsObsLap>(), EmsOrObsListDel = new XapDataList<EmsObsLap>() },
                /*输血*/
                Emsapbt = new EmsBtItemDO { BtLabItem = new XapDataList<OrdApSugViewItemDO>() },
                /*手术*/
                Emsapop = new EmsOpitemDO {/*术前检查*/OpLabItem = new XapDataList<OrdApSugViewItemDO>(),/*手术人员*/ OpEmpItem = new XapDataList<EmsItemInOp>(),/*手术卫材列表*/OpMmItemList = new XapDataList<EmsOrDrug>(), /*手术卫材*/OpMmItem = new XapDataList<EmsItemInOp>(),/*附加手术*/OpAppendOpItem = new XapDataList<EmsItemInOp>() },
                /*病理*/
                Emsappathgy = new EmsPathgyItemDO { EmsItemInpathgy = new XapDataList<EmsItemInPathgy>() },
                /*会诊*/
                Emsapcons = new EmsConsItemDO { /*会诊项目*/ EmsConsItem = new XapDataList<EmsItemInCons>(), /*协诊方*/ EmsConsAssistItem = new XapDataList<EmsItemInCons>() },
                /*转科*/
                Emsaptrans = new EmsTransItemDO(),
                /*出院*/
                Emsapout = new EmsOutItemDO()

            };

        }
        /// <summary>
        /// Creats the ems dto.
        /// </summary>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-12-15
        public CiEmsDTO CreatEmsDTO()
        {
            return new CiEmsDTO()
            {
                Orapplysheet = new FMap(),
                Emssrvs = new FArrayList(),
                Srvsetitms = new FMap(),
                Ciorfreqtimes = new FArrayList()
            };

        }

        public void AddMultiDrugLoadData(MedSrvDO med, ref EmsUIDTO emsDO, OrDataBing orDataBing, Ent4BannerDTO ent4BannerDto)
        {
            //★★★★★★草药不仅要开启大输液模式，而且所有草药都是服务套，这个后面重点关注一下
            //开启大输液模式
            if (med.Sd_srvtp.StartsWith(BdSrvDictCodeConst.SD_SRVTP_HERBDRUG) || med.Sd_srvtp.StartsWith(BdSrvDictCodeConst.SD_SRVTP_DRUG_WESTDRUG_DSY) || med.Sd_srvtp.StartsWith(BdSrvDictCodeConst.SD_SRVTP_DRUG_WESTDRUG_ZX))
            {

                //判断上一个药品 如果不是大输液则重新创建对象  //emsDO.Sd_srvtp!=med.Sd_srvtp  从大输液 直接切换到 草药呢  增加的判断逻辑
                if (emsDO == null || emsDO.MedSrvDO.Sd_srvtp != med.Sd_srvtp)//
                {//对于大输液模式  这些下面的数据 只需要首次加载 后续的不必再加载
                    emsDO = CreatEmsIntance();
                    emsDO.MedSrvDO = med;
                    //emsDO.PatInfo = patDo;
                    orDataBing.patDo = ent4BannerDto;
                    orDataBing.AddCommonHeadDataBing(emsDO, med);// 第一次需要 带过来的数据对照
                    //LoadOrderView(med.Sd_srvtp, null, med);//根据医嘱类型 加载对应的表单 
                }
                //大输液 不必每次都进行 数据对照了， 只需要将 服务关联的物品 插入到 药品集合即可
                //获取大输液关联的 药品（每次都要获取，可能服务变了）
                emsDO.Emsdrugs.EmsOrDrug = GetSrvMm(emsDO, med.Id_srv, emsDO.PatInfo.Code_entp);// 
                if (emsDO.Emsdrugs.EmsOrDrug.Count > 0)
                {//每次将关联药品的第一条插入到 药品列表
                    emsDO.Emsdrugs.EmsOrDrugList.Add(DoCopy(emsDO.Emsdrugs.EmsOrDrug.First()));
                }
            }
            else//如果不是大输液 则一直新建对象
            {
                //emsDO = CreatEmsIntance();

                orDataBing.AddCommonHeadDataBing(emsDO, med);// 带过来的数据对照
                //LoadOrderView(med.Sd_srvtp, null, med);//根据医嘱类型 加载对应的表单 
            }
        }


        #endregion 住院门诊公用数据

        /// <summary>
        /// 
        /// </summary>
        /// <returns></returns>
        public string getNo()
        {
            return CommonExtentions.NowTime(this).Year.ToString() + CommonExtentions.NowTime(this).Month + CommonExtentions.NowTime(this).Day + CommonExtentions.NowTime(this).Hour + CommonExtentions.NowTime(this).Minute + Environment.TickCount;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <returns></returns>
        internal string getNoappbtlyform()
        {
            return qryservice.getNoappbtlyform();

        }

        #region 判断库存量
        public MaterialStockDTO[] getMaterialStocksCount(GetStockReqDTO[] getReqInputs)
        {
            IMaterialStockService service = XapServiceMgr.find<IMaterialStockService>();
            if (getReqInputs != null)
            {
                getReqInputs[0].Id_dep = null;
            }
            return service.getMaterialStocks(getReqInputs);
        }
        #endregion
        /// <summary>
        /// 获得物品的单价
        /// </summary>
        /// <param name="id_mm"></param>
        /// <param name="Id_unit_sale"></param>
        /// <returns></returns>
        public double? getMaterialStocksCount(string id_mm, string Id_unit_sale)
        {
            GetStockReqDTO reqDto = new GetStockReqDTO();
            reqDto.Id_mm = id_mm;
            reqDto.Req_unit_id = Id_unit_sale;
            GetStockReqDTO[] reqDtoArr = new GetStockReqDTO[1];
            reqDtoArr[0] = reqDto;
            IMaterialStockService service = XapServiceMgr.find<IMaterialStockService>();
            MaterialStockDTO[] materials =  service.getMaterialStocks(reqDtoArr);
            if (materials != null && materials.Length > 0)
            {
                return materials[0].Price_act;
            }
            else {
                return null;
            }
        }
        #region 设置执行次数的最大值和最小值
        /// <summary>
        /// 药品医疗单中，设置频次的最大值和最小值
        /// </summary>
        /// <param name="CiHeadDo"></param>
        /// <param name="xapFormControl1"></param>
        public void setFreqctMaxMin(EmsUIDTO CiHeadDo, XapFormControl xapFormControl1)
        {
            //首日最大执行次数
            int? freqct = CiHeadDo.Emsdrugs.Freqct;
            int numgreqct = 0;
            if (freqct != null)
            {
                numgreqct = (int)freqct;
            }
            XLabelBaseUserRender tmpUserRender = xapFormControl1.GetUserRender("drugsUse", "quan_firday_mp") as XLabelBaseUserRender;
            XNumbericUpDown numRender = tmpUserRender.UserRender as XNumbericUpDown;
            numRender.MaxValue = (double)numgreqct;
            numRender.MinValue = 0;
        }
        #endregion

        /// <summary>
        /// 开立时设置执行时间
        /// </summary>
        /// <param name="exctimes"></param>
        public void getWorkTime(XapFormControl xapFormControl1, string[] exctimes)
        {
            //次数变更 具体时间也跟着变更
            XLabelBaseUserRender tmpUserRender = getControlByName(xapFormControl1, "drugsUse", "quan_firday_mp");
            XNumbericUpDown numRender = tmpUserRender.UserRender as XNumbericUpDown;
            string firday_mp = numRender.ValueText;
            if (firday_mp == "")
            {
                firday_mp = "0";
            }
            int num_firday_mp = int.Parse(firday_mp);

            if (exctimes == null) return;
            if (num_firday_mp > exctimes.Length)
            {
                this.ShowInfo("首日执行次数与事件不符！");
                return;
            }
            string worktime = "";
            Array.Sort(exctimes);
            Array.Reverse(exctimes);
            for (int i = 0; i < num_firday_mp; i++)
            {
                if (worktime != "")
                {
                    worktime = ";" + worktime;
                }
                worktime = exctimes[i] + worktime;
            }

            XLabelBaseUserRender worktimeLable = getControlByName(xapFormControl1, "drugsUse", "work_time") as XLabelBaseUserRender;
            if (worktimeLable != null)
            {
                worktimeLable.ValueText = worktime;
            }

        }

        /// <summary>
        /// Gets the name of the control by.
        /// </summary>
        /// <param name="table">The table.</param>
        /// <param name="name">The name.</param>
        /// <returns></returns>
        public XLabelBaseUserRender getControlByName(XapFormControl xapFormControl1, string table, string name)
        {
            //if (dic.Count == 0) return null;
            //return dic[table + '_' + name] as XLabelBaseUserRender;
            object o = xapFormControl1.GetUserRender(table, name);
            XLabelBaseUserRender tmpUserRender = xapFormControl1.GetUserRender(table, name) as XLabelBaseUserRender;
            return tmpUserRender;
        }

        /// <summary>
        /// 根据频次获取变动用药的 日期集合
        /// </summary>
        /// <param name="id_freq">The id_freq.</param>
        public void GetDoseDrugData(string id_freq, EmsUIDTO CiHeadDo)
        {
            CiHeadDo.Emsdrugs.EmsOrDoseDrug = GetFreqVsTimes(id_freq, CiHeadDo.Emsdrugs.Id_orsrv, CiHeadDo.Emsdrugs.Id_or);
        }

        /// <summary>
        /// 普药二次查看的时候，根据频次和首日使用次数算，首日执行时间
        /// </summary>
        /// <param name="CiHeadDo"></param>
        /// <param name="exctimes"></param>
        public void setMpWorkTimesOnEdit(EmsUIDTO CiHeadDo, string[] exctimes)
        {
            GetDoseDrugData(CiHeadDo.Emsdrugs.Id_freq, CiHeadDo);
            CiHeadDo.Emsdrugs.Work_time = GetWorkTime(CiHeadDo.Emsdrugs.Id_freq);
            string exctime = CiHeadDo.Emsdrugs.Work_time;
            string[] times;
            if (exctime != null && exctime != "")
            {
                times = exctime.Split(';');
                Array.Sort(times);
                Array.Reverse(times);

            }
            else
            {
                return;
            }
            string workTime = "";
            CiHeadDo.Emsdrugs.Quan_firday_mp = CiHeadDo.Emsdrugs.Quan_firday_mp == null ? 0 : CiHeadDo.Emsdrugs.Quan_firday_mp;
            for (int i = 0; i < (int)CiHeadDo.Emsdrugs.Quan_firday_mp; i++)
            {
                if (workTime != "")
                {
                    workTime = ";" + workTime;
                }
                workTime = times[i] + workTime;
            }
            exctimes = times;
            CiHeadDo.Emsdrugs.Work_time = workTime;
        }

        /// <summary>
        /// 通过患者的sd值判断界面的可编辑状态
        /// </summary>
        /// <param name="entSd">?</param>
        /// <returns></returns>
        public bool viewEditState8EntSd(string entSd)
        {
            //人员状态：0：我的患者,1:医疗组患者,2:会诊患者，3：全科患者，4：出院（死亡），5：跨科患者，6：转科患者 
            if (string.IsNullOrEmpty(entSd))
            {
                return true;
            }
            else if (entSd == "0" || entSd == "1" || entSd == "3" || entSd == "5")
            {
                return true;
            }
            else if (entSd == "4" || entSd == "6")
            {
                return false;
            }
            else
            {
                return false;
            }
        }

        /// <summary>
        /// 拼接物品的名称和规格：@规格（@名称）
        /// </summary>
        /// <param name="drug"></param>
        public void concateMMSpecAndName(EmsOrDrug drug)
        {
            if (drug.Fg_self == null || drug.Fg_self == false)
            {
                drug.Name_mm = drug.Spec_mm + "【" + drug.Name_mm + "】";
            }
        }

        /// <summary>
        /// 设置药品医疗单在加载完数据后，页面控件的状态
        /// </summary>
        /// <param name="idfreq"></param>
        /// <param name="xapFormControl1"></param>
        public void setDrugConStateAfterFilled(string id_freq, string[] adjustHeightIds, XapFormControl xapFormControl1)
        {
            IFreqdefMDOCrudService freqdef = XapServiceMgr.find<IFreqdefMDOCrudService>();
            FreqDefDO fq = freqdef.findById(id_freq);
            if (fq == null)
            {
                return;
            }
            XLabelBaseUserRender tmpRender = getControlByName(xapFormControl1, "drugsUse", "fg_long");
            Point pointDtFail = getControlByName(xapFormControl1, "drugsUse", "dt_fail").Location;
            Point pointBakDes = getControlByName(xapFormControl1, "drugsUse", "bak_des").Location;
            Point pointDtBegin = getControlByName(xapFormControl1, "drugsUse", "dt_begin_ui").Location;
            Point pointDtBeginVirtual = getControlByName(xapFormControl1, "drugsUse", "dt_begin_virtual").Location;
            int labelHeight = getControlByName(xapFormControl1, "drugsUse", "dt_fail").Bound.Height;
            int moveCount = 0;
            int h = 0;//高度变动值
            if (fq.Fg_prnor == true)
            {
                if (tmpRender.ValueCode == "False")
                {
                    if (getControlByName(xapFormControl1, "drugsUse", "dt_fail").Visible == false)
                    {
                        h += labelHeight;
                    }
                    getControlByName(xapFormControl1, "drugsUse", "dt_fail").Visible = true;
                }
                else
                {
                    if (getControlByName(xapFormControl1, "drugsUse", "dt_fail").Visible == true)
                    {
                        h += -labelHeight;
                    }
                    getControlByName(xapFormControl1, "drugsUse", "dt_fail").Visible = false;
                    moveCount++;
                }
                if (getControlByName(xapFormControl1, "drugsUse", "bak_des").Visible == false)
                {
                    h += labelHeight;
                }
                getControlByName(xapFormControl1, "drugsUse", "bak_des").Visible = true;
                //adjustHeight(xapFormControl1, "drugsUse", adjustHeightIds, h);
                //xapFormControl1.Refresh();
            }
            else
            {
                if (getControlByName(xapFormControl1, "drugsUse", "dt_fail").Visible == true)
                {
                    h += -labelHeight;
                }
                getControlByName(xapFormControl1, "drugsUse", "dt_fail").Visible = false;
                moveCount++;
                if (getControlByName(xapFormControl1, "drugsUse", "bak_des").Visible == true)
                {
                    h += -labelHeight;
                }
                getControlByName(xapFormControl1, "drugsUse", "bak_des").Visible = false;
                moveCount++;
                //adjustHeight(xapFormControl1, "drugsUse", adjustHeightIds, h);
                //xapFormControl1.Refresh();
            }
            if(moveCount == 1) {
                h = pointDtFail.Y-pointDtBegin.Y;
            }
            else if (moveCount == 2)
            {
                h = pointBakDes.Y - pointDtBegin.Y;
            }
            else {
                h = pointDtBeginVirtual.Y-pointDtBegin.Y;
            }
            adjustHeight(xapFormControl1, "drugsUse", adjustHeightIds, h);
            xapFormControl1.Refresh();
            string name_freq = fq.Name;
            string freqCode = fq.Sd_frequnitct;
            if (xapFormControl1.IsEditable) {
                if (freqCode.Equals("2"))
                {
                    getControlByName(xapFormControl1, "drugsUse", "quan_firday_mp").Enabled = true;//首日执行次数
                    getControlByName(xapFormControl1, "drugsUse", "work_time").Enabled = false;//首日执行时间
                }
                else
                {
                    getControlByName(xapFormControl1, "drugsUse", "quan_firday_mp").Enabled = false;//首日执行次数
                    getControlByName(xapFormControl1, "drugsUse", "work_time").Enabled = false;//首日执行时间
                    if (freqCode.Equals("0"))
                    {
                        getControlByName(xapFormControl1, "drugsUse", "dt_end_ui").Enabled = false;
                    }
                }
                if (fq.Fg_long_edit == true)
                {
                    getControlByName(xapFormControl1, "drugsUse", "fg_long").Enabled = true;
                }
                else
                {
                    getControlByName(xapFormControl1, "drugsUse", "fg_long").Enabled = false;
                }
                if (fq.Fg_long == false)
                { //如果是临时的 使用天数和结束日期置灰
                    if (getControlByName(xapFormControl1, "drugsUse", "Use_days") != null)
                    {
                        getControlByName(xapFormControl1, "drugsUse", "Use_days").Enabled = false;
                        getControlByName(xapFormControl1, "drugsUse", "dt_end_ui").Enabled = false;
                    }
                }
                else
                {
                    if (getControlByName(xapFormControl1, "drugsUse", "Use_days") != null)
                    {
                        getControlByName(xapFormControl1, "drugsUse", "Use_days").Enabled = true;
                        getControlByName(xapFormControl1, "drugsUse", "dt_end_ui").Enabled = true;
                    }
                }
            }
        }

        public void setGridColumnEdit(XapFormGridControl gv, EmsUIDTO CiHeadDo)
        {
            if (CiHeadDo.Emsdrugs.Fg_outp == true)
            {
                gv.DataTable.Columns["Quan_cur"].ReadOnly = false;
                gv.DataTable.Columns["Name_unit_sale"].ReadOnly = false;
            }
            else
            {
                gv.DataTable.Columns["Quan_cur"].ReadOnly = true;
                gv.DataTable.Columns["Name_unit_sale"].ReadOnly = true;
            }
        }

        /// <summary>
        /// 维生素E片在修改时，加载数据后拼接拓展说明
        /// </summary>
        /// <param name="emsDO"></param>
        public void concateExtNote(XapDataList<EmsOrDrug> druglist, Ent4BannerDTO patDo, EmsUIDTO uidto)
        {
            foreach (EmsOrDrug emsordrug in druglist)
            {
                emsordrug.Id_hp = patDo.Id_hp;
                HPSrvorcaDO hp = XapServiceMgr.find<ICiOrdQryService>().GetHpSrvOrCaDo(patDo.Id_hp, emsordrug.Id_srv);                
               
                string tempStr = "";
                StringBuilder noteBuilder = new StringBuilder();                
                emsordrug.Id_hp = patDo.Id_hp;
                //抗生素
                if (emsordrug.Fg_anti == FBoolean.True)
                {
                    if (emsordrug.Fg_propc == FBoolean.True)
                    {
                        noteBuilder.Append(",抗生素预防使用");
                    }
                    else
                    {
                        noteBuilder.Append(",抗生素治疗使用");
                        emsordrug.Fg_propc = false; // emsordrug.Fg_propc 可能存在空值
                    }                   
                }
                                
                if (hp != null)
                {
                    emsordrug.Id_hpsrvtp = hp.Id_hpsrvtp;
                    emsordrug.Sd_hpsrvtp = hp.Sd_hpsrvtp;
                    //存在医保
                    if (emsordrug.Fg_treat != null)
                    {
                        tempStr = emsordrug.Fg_treat == true ? "适应医保限制" : "非适应医保限制";
                        noteBuilder.Append(","+ tempStr);
                    }
                    else
                    {                        
                        noteBuilder.Append(",适应医保限制");
                        emsordrug.Fg_treat = true;                       
                    }
                }

                if (string.IsNullOrEmpty(emsordrug.Name_mp_dep))
                {
                    OrWfExDeptParamDTO param = new OrWfExDeptParamDTO();

                    param.Eu_wftp = Convert.ToInt32(EnumFlow.NULL);            //    0执行与物资   1执行科室 2物资流向
                    param.Code_entp = uidto.PatInfo.Code_entp;                             //     就诊类型

                    param.Id_dept_ns = patDo.Id_dep_nur; //就诊护理病区
                    param.Id_dept_or = UserManager.getInstance().CurrentDept.Id_dep;//开单科室
                    param.Id_dept_en = patDo.Id_dep_phy; //id_dept_en;//就诊科室

                    //dto.Recurstr = "";   //长临需要的   不知道 就为空

                    param.Id_srv = emsordrug.Id_srv;    //服务
                    param.Sd_srvtp = emsordrug.Sd_srvtp; //服务类型sd
                    param.Id_srvca = emsordrug.Id_srvca;//服务分类
                    //dto.Innercode_srvca = "";//服务分类内码
                    param.Id_mm = emsordrug.Id_mm;          // 服务选取的关联物品
                    param.Id_usage = uidto.Emsdrugs.Id_route;   //用法
                    OrWfDeptInfoDTO deps = new ICiOrdQryServiceImpl().getExeDepts4CiOrSrvN(param);
                    if (deps != null && deps.Orwfexedepts != null)
                    {
                        emsordrug.Id_mp_dep = (deps.Orwfexedepts[0] as OrWfExDeptDTO).Id_dept;
                        emsordrug.Name_mp_dep = (deps.Orwfexedepts[0] as OrWfExDeptDTO).Name_dept;
                    }
                    if (deps != null && deps.Pharmwfwhdepts != null && deps.Pharmwfwhdepts.Count > 0)
                    {
                        emsordrug.Id_dep_wh = (deps.Pharmwfwhdepts[0] as OrWfExDeptDTO).Id_dept;
                        emsordrug.Name_dep_wh = (deps.Pharmwfwhdepts[0] as OrWfExDeptDTO).Name_dept;
                    }
                }
                // 拼接执行科室名称
                noteBuilder.Append("," + emsordrug.Name_mp_dep);

                // 拼接备注
                if (!string.IsNullOrEmpty(emsordrug.Note_or))
                {
                    noteBuilder.Append("," + emsordrug.Note_or);
                }

                if (noteBuilder.Length > 0) {
                    emsordrug.Note_ext = noteBuilder.Remove(0,1).ToString();
                }
                
                if (emsordrug.Fg_self == true)
                {
                    emsordrug.Name_mm = emsordrug.Name_srv;
                }
                //草药和门诊不需要拼接名称和规格
                if (emsordrug.Sd_srvtp != null && !"03".Equals(emsordrug.Sd_srvtp.Substring(2, 2)) && EnDictCodeConst.SD_ENTP_INPATIENT.Equals(uidto.PatInfo.Code_entp))
                {
                    concateMMSpecAndName(emsordrug);
                }
            }
        }

        /// <summary>
        /// 获得物品的总金额
        /// </summary>
        /// <param name="id_mm"></param>
        /// <param name="id_dep_mp"></param>
        /// <param name="id_unit_sale"></param>
        /// <returns></returns>
        public void setTotalPrice(XapDataList<EmsOrDrug> emsOrDrugList)
        {
            foreach (EmsOrDrug emsOrDrug in emsOrDrugList)
            {
                GetStockReqDTO reqDto = new GetStockReqDTO();
                reqDto.Id_dep = emsOrDrug.Id_mp_dep;
                reqDto.Id_mm = emsOrDrug.Id_mm;
                reqDto.Req_unit_id = emsOrDrug.Id_unit_sale;
                GetStockReqDTO[] reqDtoArr = new GetStockReqDTO[1];
                reqDtoArr[0] = reqDto;
                MaterialStockDTO[] materialArr = getMaterialStocksCount(reqDtoArr);
                if (emsOrDrug.Quan_cur == null || materialArr == null || materialArr[0].Price_act == null)
                {
                    return;
                }
                emsOrDrug.Totalprice = emsOrDrug.Quan_cur * materialArr[0].Price_act;
            }
        }

        /// <summary>
        /// 医嘱服务计算价格（非物品计价）
        /// </summary>
        /// <param name="medsrv"></param>
        /// <param name="EmsOrObsList"></param>
        public FDouble getSrvNotMMPri(MedSrvDO medsrv, XapDataList<EmsObsLap> EmsOrObsList, String id_pripat = null)
        {
            BdSrvPriCalParamDTO priParam = new BdSrvPriCalParamDTO();
            GetMedSrvImpl medSrvImpl = new GetMedSrvImpl();
            priParam.Id_srv = medsrv.Id_srv;
            priParam.Id_primd = medsrv.Id_primd;
            priParam.Num = EmsOrObsList == null ? 0 : EmsOrObsList.Count(p=>p.Fg_chk!=null&&p.Fg_chk.Value);
            if (EmsOrObsList != null)
            {
                FArrayList SetSrvs = new FArrayList();
                foreach (EmsObsLap lap in EmsOrObsList.Where(p=>p.Fg_chk != null && p.Fg_chk.Value))
                {
                    BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();
                    param.Id_srv = lap.Id_srv;
                    param.Id_primd = lap.Id_primd;
                    param.Num = 1;
                    SetSrvs.Add(param);
                }
                priParam.Srvsetitms = SetSrvs;
            }
            try
            {

                FDouble price = String.IsNullOrEmpty(id_pripat )? qryservice.ciOrBdSrvPriceCal(priParam): qryservice.ciOrBdSrvPriceCalByPriMode(priParam,id_pripat).Price_ratio;
                if (price != null)
                    return price.DoubleValue();
                
            }
            catch (XapServiceException ex)
            {
                String errMsg = ex.ErrorMsg.Message;
                if (null == errMsg)
                {
                    errMsg = "远程调用失败\r\n"+ex.ErrorMsg.data;
                }

                this.SetStatusMsg(errMsg);
                
            }
            catch (System.Exception ex)
            {
                this.SetStatusMsg(ex.Message);
              
            }
            return 0;
        }

        /// <summary>
        /// 根据服务ID和定价模式获取计费价格
        /// </summary>
        /// <param name="id_srv"></param>
        /// <param name="id_primd"></param>
        /// <param name="EmsOrObsList"></param>
        /// <returns></returns>
        public FDouble getSrvNotMMPri(String id_srv, String id_primd, XapDataList<EmsObsLap> EmsOrObsList = null,string id_pripat = null)
        {
            BdSrvPriCalParamDTO priParam = new BdSrvPriCalParamDTO();
            GetMedSrvImpl medSrvImpl = new GetMedSrvImpl();
            priParam.Id_srv = id_srv;
            priParam.Id_primd = id_primd;
            priParam.Num = EmsOrObsList == null ? 0 : EmsOrObsList.Count;
            if (EmsOrObsList != null)
            {
                FArrayList SetSrvs = new FArrayList();
                foreach (EmsObsLap lap in EmsOrObsList)
                {
                    BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();
                    param.Id_srv = lap.Id_srv;
                    param.Id_primd = lap.Id_primd;
                    param.Num = 1;
                    SetSrvs.Add(param);
                }
                priParam.Srvsetitms = SetSrvs;
            }
            FDouble price = qryservice.ciOrBdSrvPriceCal(priParam);
            //FDouble price = qryservice.ciOrBdSrvPriceCalByPriMode(priParam, id_pripat);
            if (price != null)
            {
                return price.DoubleValue();
            }
           MedSrvPriceDO mspd = qryservice.ciOrBdSrvPriceCalByPriMode(priParam, id_pripat);
            if (null != mspd)
            {
                return mspd.Price_ratio;
            }
            return 0;
        }

        /// <summary>
        /// 依据sd_su_or、sd_su_mp状态决定医嘱的显示状态
        /// </summary>
        /// <param name="xaplist"></param>
         
        public void setOrderDisplayStatus(XapDataList<CiOrderDO> xaplist, bool isOpOrder)
        {
            foreach (CiOrderDO ci in xaplist)
            {

                if (ci.Sd_su_or == CiDictCodeConst.SD_SU_OPEN)
                {
                    ci.Su_or_name = "开立";
                    ci.Ord_colligate = ((int)OrdPicStatusIndex.OPEN).ToString();
                }
                else if (ci.Sd_su_or == CiDictCodeConst.SD_SU_SIGN)
                {
                    ci.Su_or_name = "签署";
                    ci.Ord_colligate = ((int)OrdPicStatusIndex.SIGN).ToString();
                    if (BdFcDictCodeConst.SD_CODE_ENTP_OP.Equals(ci.Code_entp))
                    {

                        if (ci.Sd_su_mp == CiDictCodeConst.SD_SU_MP_PERFORMED)
                        {
                            if (ci.Fg_stop != null && ci.Fg_stop == false)
                            {
                                ci.Su_or_name = "执行中";
                                ci.Ord_colligate = ((int)OrdPicStatusIndex.EXEC).ToString();
                            }
                            else if (ci.Fg_stop != null && ci.Fg_stop == true)
                            {
                                ci.Su_or_name = "执行中+预停";
                                ci.Ord_colligate = ((int)OrdPicStatusIndex.EXEC_PRESTOP).ToString();
                            }
                            else
                            {
                                ci.Su_or_name = "未知";
                                ci.Ord_colligate = ((int)OrdPicStatusIndex.UNKNOW).ToString();
                            }
                        }
                    }
                }
                else if (ci.Sd_su_or == CiDictCodeConst.SD_SU_CHECKTHROUGH)
                {
                    if (ci.Sd_su_mp == CiDictCodeConst.SD_SU_MP_NONE)
                    {
                        if ((ci.Fg_stop != null && ci.Fg_stop == false) || ci.Fg_pres_outp == true)
                        {//出院带药不需要预停操作
                            ci.Su_or_name = "确认";
                            ci.Ord_colligate = ((int)OrdPicStatusIndex.CONFIRM).ToString();
                        }
                        else if (ci.Fg_stop != null && ci.Fg_stop == true)
                        {
                            ci.Su_or_name = "确认+预停";
                            ci.Ord_colligate = ((int)OrdPicStatusIndex.CONFRIM_PRESTOP).ToString();
                        }
                        else
                        {
                            ci.Su_or_name = "未知";
                            ci.Ord_colligate = ((int)OrdPicStatusIndex.UNKNOW).ToString();
                        }
                        
                    }
                    else if (ci.Sd_su_mp == CiDictCodeConst.SD_SU_MP_PERFORMED)
                    {
                        if (ci.Fg_stop != null && ci.Fg_stop == false)
                        {
                            ci.Su_or_name = "执行中";
                            ci.Ord_colligate = ((int)OrdPicStatusIndex.EXEC).ToString();
                        }
                        else if (ci.Fg_stop != null && ci.Fg_stop == true)
                        {
                            ci.Su_or_name = "执行中+预停";
                            ci.Ord_colligate = ((int)OrdPicStatusIndex.EXEC_PRESTOP).ToString();
                        }
                        else
                        {
                            ci.Su_or_name = "未知";
                            ci.Ord_colligate = ((int)OrdPicStatusIndex.UNKNOW).ToString();
                        }
                    }
                    else
                    {
                        ci.Su_or_name = "未知";
                        ci.Ord_colligate = ((int)OrdPicStatusIndex.UNKNOW).ToString();
                    }

                }
                else if (ci.Sd_su_or == CiDictCodeConst.SD_SU_CHECKSTOP)
                {
                    if (ci.Fg_stop != null && ci.Fg_stop == true) {
                        if (ci.Sd_su_mp == CiDictCodeConst.SD_SU_MP_NONE)
                        {
                            ci.Su_or_name = "确认+停止";
                            ci.Ord_colligate = ((int)OrdPicStatusIndex.CONFIRM_STOP).ToString();
                        }
                        else if (ci.Sd_su_mp == CiDictCodeConst.SD_SU_MP_PERFORMED)
                        {
                            ci.Su_or_name = "执行中+停止";
                            ci.Ord_colligate = ((int)OrdPicStatusIndex.EXEC_STOP).ToString();

                        }
                        else {
                            ci.Su_or_name = "未知";
                            ci.Ord_colligate = ((int)OrdPicStatusIndex.UNKNOW).ToString();
                        }
                    }
                    else
                    {
                        ci.Su_or_name = "未知";
                        ci.Ord_colligate = ((int)OrdPicStatusIndex.UNKNOW).ToString();
                    }
                }
                else if (ci.Sd_su_or == CiDictCodeConst.SD_SU_FINISH)
                {
                    if (ci.Sd_su_mp == CiDictCodeConst.SD_SU_MP_EXEOK)
                    {
                        ci.Su_or_name = "完成";
                        ci.Ord_colligate = ((int)OrdPicStatusIndex.OVER).ToString();
                    }
                    else if (ci.Sd_su_mp == CiDictCodeConst.SD_SU_MP_EXECANC)
                    {
                        ci.Su_or_name = "取消";
                        ci.Ord_colligate = ((int)OrdPicStatusIndex.CANCEL).ToString();
                    }
                    else if (ci.Sd_su_mp == CiDictCodeConst.SD_SU_MP_CANCEL)
                    {
                        ci.Su_or_name = "不执行";
                        ci.Ord_colligate = ((int)OrdPicStatusIndex.NOTEXEC).ToString();
                    }
                    else
                    {
                        ci.Su_or_name = "未知";
                        ci.Ord_colligate = ((int)OrdPicStatusIndex.UNKNOW).ToString();
                    }
                }
                else if (ci.Sd_su_or == CiDictCodeConst.SD_SU_DOCTORCANCEL)
                {
                    ci.Su_or_name = "作废";
                    ci.Ord_colligate = ((int)OrdPicStatusIndex.OBSOLETE).ToString();
                }
                else if (ci.Sd_su_or == CiDictCodeConst.SD_SU_CHECKCANCEL)
                {
                    ci.Su_or_name = "已作废";
                    ci.Ord_colligate = ((int)OrdPicStatusIndex.CANCELLED).ToString();
                }
                else
                {
                    ci.Su_or_name = "未知";
                    ci.Ord_colligate = ((int)OrdPicStatusIndex.UNKNOW).ToString();
                }
                setOrderResultValue(ci);
            }
        }

        public void setOrderResultValue(CiOrderDO ci)
        {
            string sd_srvtp = ci.Sd_srvtp;
            switch (sd_srvtp)
            {
                case BdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST:
                    ISkintestCrudService skinService = XapServiceMgr.find<ISkintestCrudService>();
                    CiSkinTestRstDO[] rstDos = skinService.find(string.Format("id_or='{0}'", ci.Id_or), "", false);
                    if (rstDos != null && rstDos.Length > 0)
                    {
                        string rstSkin = rstDos[0].Sd_rst_skintest;
                        if (rstSkin == null)
                        {
                            ci.Result = "结果未出";
                        }
                        else
                        {
                            ci.Result = rstDos[0].Skinres_name;
                        }
                    }
                    else
                    {
                        ci.Result = "结果未出";
                    }
                    break;
            }
        }
        public CiSkinTestRstDO getCiSkinTestRstDO(CiOrderDO ci)
        {
            string sd_srvtp = ci.Sd_srvtp;
            switch (sd_srvtp)
            {
                //皮肤敏感性试验
                case BdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST:
                    ISkintestCrudService skinService = XapServiceMgr.find<ISkintestCrudService>();
                    CiSkinTestRstDO[] rstDos = skinService.find(string.Format("id_or='{0}'", ci.Id_or), "", false);
                    if (rstDos != null && rstDos.Length > 0)
                    {
                        return rstDos[0];
                    }
                    break;
            }
            return null;
        }
        /// <summary>
        /// 医嘱列表显示时，根据之前页面上的查询条件过滤出数据
        /// </summary>
        /// <param name="xaplist"></param>
        /// <param name="searchParamMap"></param>
        public void filterOrderItemBySearch(XapDataList<CiOrderDO> xaplist, XapDataList<CiOrderDO> fillModelDataList, Dictionary<string, object> searchParamMap)
        {
            List<CiOrderDO> list = new List<CiOrderDO>();
            if (xaplist != null && xaplist.Count > 0)
            {
                foreach (CiOrderDO cido in xaplist)
                {
                    list.Add(cido);
                }
            }
            else
            {
                return;
            }
            if (searchParamMap.ContainsKey("active") && (bool)searchParamMap["active"] == true)
            {
                list = list.Where(p => int.Parse(p.Sd_su_or) < 30).ToList();
            }

            if (searchParamMap.ContainsKey("group") && (string)searchParamMap["group"] == "长期")
            {
                list = list.Where(p => p.Fg_long == true).ToList();
            }
            else if (searchParamMap.ContainsKey("group") && (string)searchParamMap["group"] == "临时")
            {
                list = list.Where(p => p.Fg_long == false).ToList();
            }
            if (searchParamMap.ContainsKey("startDate") && (string)searchParamMap["startDate"] != "")
            {
                list.Where(p => p.Dt_effe >= DateTime.Parse((string)searchParamMap["startDate"]));
            }
            if (searchParamMap.ContainsKey("endDate") && (string)searchParamMap["endDate"] != "")
            {
                list.Where(p => p.Dt_effe <= DateTime.Parse((string)searchParamMap["endDate"]));
            }
            foreach (CiOrderDO cido in list)
            {
                fillModelDataList.Add(cido);
            }
        }

        /// <summary>
        /// 皮试逻辑判断
        /// </summary>
        /// <param name="param"></param>
        /// <returns></returns>
        public SkinTestRstDTO skinTestLogic(SkinTestParamDTO param)
        {
            return qryservice.skinTestLogicMainBP(param);
        }

        /// <summary>
        /// 会诊失效时间计算
        /// </summary>
        /// <param name="id_unit"></param>
        /// <param name="quan_time"></param>
        /// <param name="dt_plan"></param>
        /// <returns></returns>
        public DateTime GetConsTimeLimit(string id_unit, int quan_time, FDateTime dt_plan)
        {
            if (id_unit == CiDictCodeConst.ID_MEASDOC_TIME_DD)//天
            {
                return DateTime.Parse(dt_plan.ToTarget.AddDays(quan_time - 1).ToString("yyyy-MM-dd 23:59:59"));
            }
            if (id_unit == CiDictCodeConst.ID_MEASDOC_TIME_HH)//小时
            {
                return dt_plan.ToTarget.AddHours(quan_time);
            }
            if (id_unit == CiDictCodeConst.ID_MEASDOC_TIME_MM)//分
            {
                return dt_plan.ToTarget.AddMinutes(quan_time);
            }
            if (id_unit == CiDictCodeConst.ID_MEASDOC_TIME_SS)//秒
            {
                return dt_plan.ToTarget.AddSeconds(quan_time);
            }
            return dt_plan;
        }
        public MeasDocDO getMeasDocDoById(string id_measdocdo)
        {
            IMeasdocCrudService service = XapServiceMgr.find<IMeasdocCrudService>();
            MeasDocDO measddo = service.findById(id_measdocdo);
            return measddo;
        }
        /// <summary>
        /// 新启动一个线程设置药品服务的物品的库存信息
        /// </summary>
        /// <param name="drugs"></param>
        /// <param name="id_dep_mp"></param>
        public void threadSetMaterialInfoOfDrug(XapDataList<EmsOrDrug> drugs, MiddleWareXapDataList middle)
        {
            ThreadSetMaterialInfoOfDrug thread = new ThreadSetMaterialInfoOfDrug(drugs, middle);
            Thread t = new Thread(new ThreadStart(thread.run));
            t.Start();
        }
        /// <summary>
        /// 新启动一个线程进行皮试逻辑判断
        /// </summary>
        /// <param name="emsordrug"></param>
        /// <param name="PatInfo"></param>
        public void threadSkinTestLogic(EmsOrDrug emsordrug, Ent4BannerDTO PatInfo)
        {
            ThreadSkinTestLogic threadskin = new ThreadSkinTestLogic();
            threadskin.emsordrug = emsordrug;
            threadskin.PatInfo = PatInfo;
            threadskin.id_dep_mp = emsordrug.Id_mp_dep;
            Thread ts = new Thread(threadskin.run);
            ts.Start();
        }
        /// <summary>
        /// 校验药品的毒麻特性，是否符合核对用户信息
        /// 0非毒麻,1麻醉药品,2一类精神药品,3二类精神药品,4毒性药品,5放射性药品
        /// </summary>
        /// <param name="fg_pois"></param>
        /// <param name="sd_pois"></param>
        /// <returns></returns>
        public bool verifyPois(bool fg_pois, string sd_pois)
        {
            
            //if (fg_pois == true && (sd_pois == "1" || sd_pois == "2" || sd_pois == "4" || sd_pois == "5"))
            //{
            //    return true;
            //}
            //只有麻醉、精一的药品需要提示 ;
            if (fg_pois == true && (sd_pois == "1" || sd_pois == "2"))
            {
                return true;
            }
            return false;
        }
        /// <summary>
        /// 从banner中获取代理信息
        /// </summary>
        /// <param name="PatInfo"></param>
        /// <returns></returns>
        public OrSrvAgentInfoDO newOrSrvAgentInfoDOFromBanner(Ent4BannerDTO PatInfo)
        {
            OrSrvAgentInfoDO agentInfodo = new OrSrvAgentInfoDO();
            agentInfodo.Name_pat = PatInfo.Name_pat;
            agentInfodo.Id_pat = PatInfo.Id_pat;

            agentInfodo.Sd_sextp_pat = PatInfo.Sd_sex;
            string sd_sex = PatInfo.Sd_sex;
            switch (sd_sex)
            {
                case PiDictCodeConst.SD_SEX_UNKNOW:
                    agentInfodo.Id_sextp_pat = PiDictCodeConst.ID_SEX_UNKNOW;
                    break;
                case PiDictCodeConst.SD_SEX_MALE:
                    agentInfodo.Id_sextp_pat = PiDictCodeConst.ID_SEX_MALE;
                    break;
                case PiDictCodeConst.SD_SEX_FEMALE:
                    agentInfodo.Id_sextp_pat = PiDictCodeConst.ID_SEX_FEMALE;
                    break;
                case PiDictCodeConst.SD_SEX_UNEXPLAIN:
                    agentInfodo.Id_sextp_pat = PiDictCodeConst.ID_SEX_UNEXPLAIN;
                    break;
            }
            agentInfodo.Name_sextp_pat = PatInfo.Name_sex;
            agentInfodo.Name_idtp_pat = PatInfo.Id_idtp;
            string name_idtp_pat = PatInfo.Id_idtp;
            switch (name_idtp_pat)
            {
                case PiDictCodeConst.NAME_IDTP_IDCARD:
                    agentInfodo.Sd_idtp_pat = PiDictCodeConst.SD_IDTP_IDCARD;
                    agentInfodo.Id_idtp_pat = PiDictCodeConst.ID_IDTP_IDCARD;
                    break;
                case PiDictCodeConst.NAME_IDTP_HUKOUBU:
                    agentInfodo.Sd_idtp_pat = PiDictCodeConst.SD_IDTP_HUKOUBU;
                    agentInfodo.Id_idtp_pat = PiDictCodeConst.ID_IDTP_HUKOUBU;
                    break;
                case PiDictCodeConst.NAME_IDTP_HUZHAO:
                    agentInfodo.Sd_idtp_pat = PiDictCodeConst.SD_IDTP_HUZHAO;
                    agentInfodo.Id_idtp_pat = PiDictCodeConst.ID_IDTP_HUZHAO;
                    break;
                case PiDictCodeConst.NAME_IDTP_SOLDIERCARD:
                    agentInfodo.Sd_idtp_pat = PiDictCodeConst.SD_IDTP_SOLDIERCARD;
                    agentInfodo.Id_idtp_pat = PiDictCodeConst.ID_IDTP_SOLDIERCARD;
                    break;
                case PiDictCodeConst.NAME_IDTP_DRIVERCARD:
                    agentInfodo.Sd_idtp_pat = PiDictCodeConst.SD_IDTP_DRIVERCARD;
                    agentInfodo.Id_idtp_pat = PiDictCodeConst.ID_IDTP_DRIVERCARD;
                    break;
                case PiDictCodeConst.NAME_IDTP_HKMACPASS:
                    agentInfodo.Sd_idtp_pat = PiDictCodeConst.SD_IDTP_HKMACPASS;
                    agentInfodo.Id_idtp_pat = PiDictCodeConst.ID_IDTP_HKMACPASS;
                    break;
                case PiDictCodeConst.NAME_IDTP_TAIWANPASS:
                    agentInfodo.Sd_idtp_pat = PiDictCodeConst.SD_IDTP_TAIWANPASS;
                    agentInfodo.Id_idtp_pat = PiDictCodeConst.ID_IDTP_TAIWANPASS;
                    break;
                case PiDictCodeConst.NAME_IDTP_NSSF:
                    agentInfodo.Sd_idtp_pat = PiDictCodeConst.SD_IDTP_NSSF;
                    agentInfodo.Id_idtp_pat = PiDictCodeConst.ID_IDTP_NSSF;
                    break;
                case PiDictCodeConst.NAME_IDTP_OTHERS:
                    agentInfodo.Sd_idtp_pat = PiDictCodeConst.SD_IDTP_OTHERS;
                    agentInfodo.Id_idtp_pat = PiDictCodeConst.ID_IDTP_OTHERS;
                    break;
            }
            agentInfodo.Idno_pat = PatInfo.Id_code;
            agentInfodo.Id_en = PatInfo.Id_ent;
            //int age = (DateTime.Now - DateTime.Parse(PatInfo.Dt_birth)).Days / 365;
            try
            {
                int[] ages = CalcAgeArray.getAgeArray(DateTime.Parse(PatInfo.Dt_birth));
                if (ages != null)
                {
                    agentInfodo.Age_pat = ages[0];
                }
            }
            catch (Exception ex) {
                this.SetStatusMsg(ex.Message);
            }
            return agentInfodo;
        }




        //public const String SD_ENTP_OUTPATIENT = "00"; //门诊
        //public const String SD_ENTP_EMERGENCY = "01"; //急诊
        //public const String SD_ENTP_PHYSICALEXAM = "02"; //体检
        //public const String SD_ENTP_INPATIENT = "10"; //住院
        //public const String SD_ENTP_HOME = "20"; //家庭病床
        /// <summary>
        /// 频次的类型
        /// </summary>
        /// <param name="code_entp"></param>
        /// <returns></returns>
        public string getBdFreqType(String code_entp)
        {
            string freqType = "";
            if (EnDictCodeConst.SD_ENTP_OUTPATIENT == code_entp)//
            {
                freqType = " bd_freq.fg_use_op ='Y' ";
            }
            else if (EnDictCodeConst.SD_ENTP_INPATIENT == code_entp)
            {
                freqType = " bd_freq.fg_use_ip ='Y' ";
            }
            else if (EnDictCodeConst.SD_ENTP_EMERGENCY == code_entp)
            {
                freqType = " bd_freq.fg_use_er ='Y' ";
            }
            else if (EnDictCodeConst.SD_ENTP_PHYSICALEXAM == code_entp)
            {
                freqType = " bd_freq.fg_use_pe ='Y' ";
            }
            else if (EnDictCodeConst.SD_ENTP_HOME == code_entp)
            {
                freqType = " bd_freq.fg_use_fm ='Y' ";
            }

            return freqType;
        }
        public void clearEmsOrDrugPropety(EmsOrDrug ems)
        {
            ems.Id_srv = "";
            ems.Name_srv = "";
            ems.Id_mm = "";
            ems.Spec_mm = "";
            ems.Id_route = "";
            ems.Name_route = "";
            ems.Id_unit_base = "";
            ems.Name_unit_base = "";
            ems.Id_unit_med = "";
            ems.Name_unit_med = "";
            ems.Id_unit_sale = "";
            ems.Name_unit_sale = "";
            ems.Quan_med = null;
            ems.Quan_cur = null;
            ems.Id_freq = "";
            ems.Name_freq = "";
            ems.Use_days = null;
            ems.Id_mp_dep = "";
            ems.Name_mp_dep = "";
            ems.Price = null;
            ems.Totalprice = null;
        }
        /// <summary>
        /// 通过用法获得剂型id字符串
        /// </summary>
        /// <param name="id_route"></param>
        /// <returns></returns>
        public string getDrugRouteOfDoSages(string id_route) {
            IRoutedosageCrudService dosageservice = XapServiceMgr.find<IRoutedosageCrudService>();
            RouteDosageRefDO[] routeDosages = dosageservice.find(string.Format("id_route='{0}'",id_route),"",false);
            if (routeDosages != null) {
                string id_dosages = "";
                int i = 0;
                foreach(RouteDosageRefDO routedosage in routeDosages){
                    if (i == 0)
                    {
                        id_dosages += "'" + routedosage.Id_dosage + "'";
                    }
                    else {
                        id_dosages += ",'" + routedosage.Id_dosage + "'";
                    }
                    i++;
                }
                return id_dosages;
            }
            return null;
        }

        public RouteDosageRefDO[] getRouteDoSageRefDOById_dosages(List<string> ids) {
            string id_dosages = "";
            int j = 0;
            foreach (string id in ids)
            {
                if (j == 0)
                {
                    id_dosages += "'" + id + "'";
                }
                else
                {
                    id_dosages += ",'" + id + "'";
                }
                j++;
            }
            IRoutedosageCrudService dosageservice = XapServiceMgr.find<IRoutedosageCrudService>();
            RouteDosageRefDO[] routeDosages = dosageservice.find(string.Format("id_dosage in ({0})", id_dosages), "", false);
            return routeDosages;
        }
        /// <summary>
        /// 同步用法、频次、周期
        /// </summary>
        /// <param name="druglist"></param>
        /// <param name="index"></param>
        public void synRouteFreqToFirst(XapDataList<EmsOrDrug> druglist,int? index = null) {
            if (druglist != null && druglist.Count > 1) {
                EmsOrDrug first = druglist.First();
                if (index != null)
                {
                    druglist[(int)index].Id_route = first.Id_route;
                    druglist[(int)index].Name_route = first.Name_route;
                    druglist[(int)index].Id_freq = first.Id_freq;
                    druglist[(int)index].Name_freq = first.Name_freq;
                    druglist[(int)index].Use_days = first.Use_days;
                }
                else {
                    for (int i = 1; i < druglist.Count; i++)
                    {
                        druglist[i].Id_route = first.Id_route;
                        druglist[i].Name_route = first.Name_route;
                        druglist[i].Id_freq = first.Id_freq;
                        druglist[i].Name_freq = first.Name_freq;
                        druglist[i].Use_days = first.Use_days;
                    }
                }
            }
        }
        /// <summary>
        /// 从bd_udidoc中获得数据
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public UdidocDO getUdidocDOById(string id)
        {
            if (string.IsNullOrEmpty(id)) return null;
            IUdiHelperService service = XapServiceMgr.find<IUdiHelperService>();
            UdidocDO udidoc = service.getUdidocById(id);
            return udidoc;
        }



        /// <summary>
        /// 计算领量天数
        /// </summary>
        /// <param name="drug"></param>
        /// <returns></returns>
        public int getDrugDaysOfAvailable(EmsOrDrug drug)
        {
            if (String.IsNullOrEmpty(drug.Sd_srvtp) || String.IsNullOrEmpty(drug.Id_mm) || String.IsNullOrEmpty(drug.Id_unit_sale))
            {
                return 0;
            }


            if (drug.Sd_srvtp.StartsWith(BdSrvDictCodeConst.SD_SRVTP_DRUG_WESTDRUG) ||
                drug.Sd_srvtp.StartsWith(BdSrvDictCodeConst.SD_SRVTP_CYDRUG))
            {
                // 变动用药
                if (drug.Fg_dose_anoma != null && drug.Fg_dose_anoma.Value)
                {

                }
                else
                {
                    //取值总量单位的换算系数和物品的取整模式
                    object[] mmArray = getDrugMMFactorMupkgutp(drug.Id_mm, drug.Id_unit_sale);

                    double factor = mmArray[0] == null ? 0 : Convert.ToDouble(mmArray[0].ToString());

                    if (null != drug.Freqct && 0 != drug.Freqct && null != drug.Quan_med && 0 != drug.Quan_med)
                    {
                        double? days = ((drug.Quan_cur==null?0:drug.Quan_cur) * factor * drug.Factor_mb) / (drug.Freqct * drug.Quan_med);

                        return (int)(days != null?days.Value : 0);
                    }

                    
                }
            }
            return 0;
        }
        /// <summary>
        /// 获得医保信息
        /// </summary>
        /// <param name="id_hp"></param>
        /// <param name="id_srv"></param>
        /// <returns></returns>
        public HPSrvorcaDO getHpInfo(string id_hp, string id_srv)
        {
            HPSrvorcaDO hp = XapServiceMgr.find<ICiOrdQryService>().GetHpSrvOrCaDo(id_hp, id_srv);
            return hp;
        }
        /// <summary>
        /// 获得集合中医生开立的服务项目
        /// </summary>
        /// <param name="list"></param>
        /// <returns></returns>
        public List<CiEmsSrvDTO> getPhysignSrv(FArrayList list) {
            List<CiEmsSrvDTO> cests = new List<CiEmsSrvDTO>();
            if (list == null) return cests;
            foreach(CiEmsSrvDTO dto in list){
                if (dto.Eu_sourcemd != null && (dto.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN)
                     || dto.Eu_sourcemd == (int)OrSrvSourceFromEnum.CP)// 添加临床路径开的医嘱
                {
                    cests.Add(dto);
                }
            }
            return cests;
        }
        #region 校验医疗单的频次和剂量单位：当频次为always时，剂量单位必须为时间
        public bool validateBeforeSaveCiEmsDto(EmsUIDTO emsHeadDO, CiEmsDTO dto)
        {
            if (emsHeadDO.IsNEW && LogicEx.GetInstance().validateEmsUIDTO(dto))
            {
                List<string> errorList = LogicEx.GetInstance().validateFreqAndUnitmed(dto);
                if (errorList==null){
                    return false;
                }else if(errorList.Count > 0){
                    string strErr = "";
                    errorList.ForEach(
                        p => { strErr += string.Format("{0}.{1}\n", errorList.IndexOf(p) + 1, p); });
                    string errInfo = " 验证失败，操作取消！\n" + strErr;
                    this.ShowInfo(errInfo, "提示:");
                    return false;
                }
            }
            return true;
        }
        public bool validateEmsUIDTO(CiEmsDTO dto)
        {
            //转科，出院不做校验
            if (BdSrvDictCodeConst.SD_SRVTP_PATIMAN.Equals(dto.Sd_srvtp.Substring(0, 2)))
            {
                return false;
            }
            return true;
        }
        public List<string> validateFreqAndUnitmed(CiEmsDTO dto)
        {
            List<string> errorList = new List<string>();
            string id_freq = "", id_unit_med = "";
            FArrayList emssrvs = dto.Emssrvs;
            if (emssrvs == null) return errorList;
            foreach (CiEmsSrvDTO srvdto in emssrvs)
            {
                id_freq = srvdto.Id_freq;
                id_unit_med = srvdto.Id_unit_med;
                double? quan_med = srvdto.Quan_med;
                //药品:频次，剂量，剂量单位，频次，用法，用法要求不能为空
                if (BdSrvDictCodeConst.SD_SRVTP_DRUG.Equals(srvdto.Sd_srvtp.Substring(0, 2)))
                {
                    if (id_freq == null || id_freq == "")
                    {
                        errorList.Add("服务项目【" + srvdto.Name_srv + "】的频次不能为空！");
                    }
                    if (id_unit_med == null || id_unit_med == "")
                    {
                        errorList.Add("服务项目【" + srvdto.Name_srv + "】的剂量单位不能为空！");
                    }
                    if (quan_med == null)
                    {
                        errorList.Add("服务项目【" + srvdto.Name_srv + "】的剂量不能为空！");
                    }
                    //if (string.IsNullOrEmpty(srvdto.Id_route))
                    //{
                    //    errorList.Add("服务项目【" + srvdto.Name_srv + "】的用法不能为空！");
                    //}
                    //if (string.IsNullOrEmpty(srvdto.Id_routedes))
                    //{
                    //    errorList.Add("服务项目【" + srvdto.Name_srv + "】的用法要求不能为空！");
                    //}
                    //草药：煎法和煎法要求和其他药
                    if (BdSrvDictCodeConst.SD_SRVTP_HERBDRUG.Equals(srvdto.Sd_srvtp.Substring(0, 4)))
                    {
                        if (string.IsNullOrEmpty(srvdto.Id_boil))
                        {
                            errorList.Add("服务项目【" + srvdto.Name_srv + "】的煎法不能为空！");
                        }
                        //if (string.IsNullOrEmpty(srvdto.Id_boildes))
                        //{
                        //    errorList.Add("服务项目【" + srvdto.Name_srv + "】的煎法要求不能为空！");
                        //}
                    }
                }
                //备血：剂量，剂量单位，频次不能为空
                else if (BdSrvDictCodeConst.SD_SRVTP_BLOODPROD_BLOODPROD_READYBLOOD.Equals(srvdto.Sd_srvtp))
                {
                    if (id_freq == null || id_freq == "")
                    {
                        errorList.Add("服务项目【" + srvdto.Name_srv + "】的频次不能为空！");
                    }
                    if (id_unit_med == null || id_unit_med == "")
                    {
                        errorList.Add("服务项目【" + srvdto.Name_srv + "】的剂量单位不能为空！");
                    }
                    if (quan_med == null)
                    {
                        errorList.Add("服务项目【" + srvdto.Name_srv + "】的剂量不能为空！");
                    }
                }
                //其他服务：剂量null:1,剂量单位null：次，频次null：once
                else {
                    if (quan_med==null||quan_med==0) {
                        srvdto.Quan_med = 1;
                    }
                    if (string.IsNullOrEmpty(id_unit_med)) {
                        errorList.Add("服务项目【" + srvdto.Name_srv + "】的剂量单位不能为空！");
                    }
                    if (string.IsNullOrEmpty(id_freq)) {
                        srvdto.Id_freq = CiDictCodeConst.ID_FREQ_ONCE;
                        id_freq = srvdto.Id_freq;
                    }
                }
                
                if (errorList.Count > 0) return errorList;
                IFreqdefMDOCrudService freqdef = XapServiceMgr.find<IFreqdefMDOCrudService>();
                FreqDefDO fq = freqdef.findById(id_freq);
                if (fq == null)
                {
                    if (srvdto.Sd_srvtp.Equals(BdSrvDictCodeConst.SD_SRVTP_BLOODPROD_BLOODPROD_USEBLOOD))
                    {
                        this.ShowAlert("用血频次为空！");
                    }
                    else {
                        this.ShowAlert(srvdto.Name_srv + "频次为空！");
                    }
                    return null;
                }
                string sd_freq = fq.Sd_frequnitct;
                //频次为持续类型，剂量单位为时间
                ICiOrdQryService service = XapServiceMgr.find<ICiOrdQryService>();
                MeasDocDO meas = service.getMeasDocDOById(id_unit_med);
                if (BdSrvDictCodeConst.SD_FREQUNIT_CONTINUE.Equals(sd_freq))
                {
                    if (!meas.Sd_oppdimen.Equals(SysDictCodeConst.SD_OPPDIMEN_T))
                    {
                        errorList.Add("服务项目【" + srvdto.Name_srv + "】的频次为持续类型，剂量单位必须是时间类型！");
                        return errorList;
                    }
                }
            }
            return errorList;
        }
        #endregion
        #region 药品库存的判断
        public string validateDrugCount(List<EmsOrDrug> list)
        {
            string nocount = "";//无库存
            string stopSale = "";//停发
            string noDrug = "";//无此药
            List<GetStockReqDTO> reqDtos = new List<GetStockReqDTO>();
            for (int i = 0; i < list.Count; i++)
            {
                if (list[i].Fg_mm == true && list[i].Status != DOStatus.DELETED&&list[i].Fg_self!=true)//物品且非自备药时判断库存
                {
                    GetStockReqDTO reqDTO = new GetStockReqDTO();
                    reqDTO.Id_mm = list[i].Id_mm;
                    reqDTO.Id_dep = list[i].Id_dep_wh;
                    reqDTO.Req_unit_id = list[i].Id_unit_sale;
                    reqDtos.Add(reqDTO);
                }
            }
            if (reqDtos.Count > 0)
            {
                IMaterialStockService stoctService = XapServiceMgr.find<IMaterialStockService>();
                MaterialStockDTO[] stockdto = null;
                
                stockdto = stoctService.getMaterialStocks(reqDtos.ToArray());

                if (stockdto != null)
                {
                    string mmcounterror = "";
                    for (int i = list.Count - 1; i >= 0; i--)
                    {

                        MaterialStockDTO materialDo = stockdto.FirstOrDefault(p => p.Id_mm == list[i].Id_mm);
                        if (materialDo != null)
                        {
                            double mmcount = (double)materialDo.Quan_usable;
                            //药房无此药的移除
                            if (materialDo.Mmstatus == (int)MaterialStatus.NORELATION)
                            {
                                noDrug += list[i].Name_srv + ",";
                            }
                            else if (materialDo.Mmstatus == (int)MaterialStatus.STOP)
                            {
                                stopSale += list[i].Name_srv + ",";
                            }
                            else if (mmcount.CompareTo(0.00)==0||(list[i].Quan_cur!=null && mmcount < list[i].Quan_cur))
                            {
                                nocount += list[i].Name_srv + ",";
                            }
                        }
                    }
                    if (!string.IsNullOrEmpty(noDrug))
                    {
                        mmcounterror = "服务：" + noDrug.Substring(0,noDrug.Length-1) + "，药房无此药！\r\n";
                    }
                    if (!string.IsNullOrEmpty(stopSale))
                    {
                        mmcounterror += mmcounterror + "服务：" + stopSale.Substring(0, stopSale.Length - 1) + "，已停发！\r\n";
                    }
                    if (!string.IsNullOrEmpty(nocount))
                    {
                        mmcounterror += mmcounterror + "服务：" + nocount.Substring(0, nocount.Length - 1) + "，库存不足！";
                    }
                    if (string.IsNullOrEmpty(mmcounterror)) return null;
                    return mmcounterror;
                }
            }
            return null;
        }
        #endregion
        /// <summary>
        /// 后台方法内容已经被注释掉了。该方法应该废弃
        /// 保存到数据库之前，设置医保信息
        /// </summary>
        /// <param name="ciEmsDTO"></param>
        [Obsolete]
        public void setHpInfo(CiEmsDTO ciEmsDTO,string id_hp)
        {
            if (string.IsNullOrEmpty(id_hp)) return;
            FArrayList emssrvs = ciEmsDTO.Emssrvs;
            if (emssrvs == null || emssrvs.Count == 0) {
                throw new Exception("医嘱的费用项目为空，不能保存！");
            }
            foreach(CiEmsSrvDTO emssrv in emssrvs){
                HPSrvorcaDO hp = XapServiceMgr.find<ICiOrdQryService>().GetHpSrvOrCaDo(id_hp, emssrv.Id_srv);
                emssrv.Id_hp = id_hp;
                if (hp != null) {
                    emssrv.Id_hpsrvtp = hp.Id_hpsrvtp;
                    emssrv.Sd_hpsrvtp = hp.Sd_hpsrvtp;
                    string hpsrvtp_name = hp.Hpsrvtp_name;
                    emssrv.Limit = string.IsNullOrEmpty(hpsrvtp_name)?hp.Des:hpsrvtp_name+(string.IsNullOrEmpty(hp.Des)?"":"，"+hp.Des);
                }
            }
        }
        //获得药品的换算系数
        public double? getDrugFactor(string id_mm, string id_unit_sale)
        {
            MeterialAggDO aggDo = XapServiceMgr.find<IMeterialCrudService>().findById(id_mm);
            if (aggDo == null)
            {
                return 0;
            }
            MeterialDO mm = aggDo.getParentDO();

            MMPackageUnitDO mmpackageUnitDO = aggDo.getMMPackageUnitDO().FirstOrDefault(p => p.Id_unit_pkg == id_unit_sale);
            double? factor = null;//总量单位对应你的换算系数
            if (mmpackageUnitDO != null)
            {
                factor = aggDo.getMMPackageUnitDO().FirstOrDefault(p => p.Id_unit_pkg == id_unit_sale).Factor;
                return factor;
            }
            return 0;
        }
        /// <summary>
        /// 获得唯一的用血服务
        /// </summary>
        /// <returns></returns>
        public MedSrvDO getApBuSrv()
        {
            var service = XapServiceMgr.find<IMedsrvMDOCrudService>();
            //查询用血对应的服务
            MedSrvDO[] medSrcDOs = service.find(string.Format("sd_srvtp='{0}' and ds='0' and fg_or='Y' and fg_active='Y'", BdSrvDictCodeConst.SD_SRVTP_BLOODPROD_BLOODPROD_USEBLOOD), "", false);
            if (medSrcDOs != null && medSrcDOs.Length > 0)
            {
                return medSrcDOs[0];
            }
            return null;
        }
        /// <summary>
        /// 医嘱列表签署
        /// </summary>
        /// <param name="orders"></param>
        /// <param name="code_entp"></param>
        public void SignCiOrder(CiOrderDO[] orders, Ent4BannerDTO ent4BannerDTO)
        {
            ICiOrdMaintainService maintainService = XapServiceMgr.find<ICiOrdMaintainService>();
            IBsQueryService bsservice = XapServiceMgr.find<IBsQueryService>();
            if (orders.Count() == 0)
                return;
            string sql = "select ct.name from BD_SRV_REACT ct where ID_SRVREACT=";
            List<string> idors = orders.Select(p => p.Id_or).ToList();
            CiEnContextDTO ciEnContext = CiEnContextUtil.GetCiEnContext(ent4BannerDTO);
            ValidateRtnInfoDTO vlInfoDto = maintainService.ciOrderSign(idors.ToArray(), ciEnContext);
            FMap2 fm = vlInfoDto.Rtnvalue;
            ReactExtOrsAndStopOrsDO redo = (ReactExtOrsAndStopOrsDO)fm["willstopors"];
            if (redo == null)
                return;
            FMap2 fm1 = vlInfoDto.Scenedatum;
            fm1.Add("willstopors", redo);
            FArrayList fa2 = new FArrayList();
            FArrayList extdo = redo.Reactextdos;
            FArrayList wildo = redo.Stopordos;
            string msg = "";
            foreach (CiorderAggExtDO ciext in extdo)
            {
                CiorderAggDO aggdo = ciext.Aggdo;
                msg += aggdo.getParentDO().Name_or + "是";
                fa2.Add(aggdo.getParentDO());
                FArrayList fl = bsservice.getMapListWithDao(sql + "'" + ciext.Id_reacts + "'");
                if (fl != null)
                {
                    FMap m = (FMap)fl[0];
                    msg += m["name"] + "医嘱排斥，即将停止医嘱   ";
                }
            }
            foreach (CiOrderDO stopordo in wildo)
            {
                if (stopordo.Fg_stop == null || stopordo.Fg_stop == false)//已经停止的不用再提示停止信息 2016-07-08  zwq
                    msg += "'" + stopordo.Name_or + "' ";
            }
            var a = MessageBoxEx.Show(msg + "\r\n" + "是否继续？", "医嘱排斥", MessageBoxButtons.YesNo);
            if (a == DialogResult.Yes)
            {
                maintainService.ciOrderSignStep1(fm1, ent4BannerDTO.Code_entp, ciEnContext);
            }
            return;
        }
        /// <summary>
        /// 获得套内所有的临床项目，并组装成CiEmsSrvDTO
        /// </summary>
        /// <param name="id_srv"></param>
        /// <param name="code_entp"></param>
        /// <param name="Eu_sourcemd"></param>
        /// <returns></returns>
        public List<CiEmsSrvDTO> getSetClinicalSrvDO(string id_srv,string code_entp, int Eu_sourcemd)
        {
            List<CiEmsSrvDTO> emslist = new List<CiEmsSrvDTO>();
            GetMedSrvImpl medSrvImpl = new GetMedSrvImpl();
            IMeterialMDORService service = XapServiceMgr.find<IMeterialMDORService>();
            MedsrvAggDO medsrvagg = medSrvImpl.getMedSrvAggDOfindById(id_srv);
            if (medsrvagg != null)
            {
                MedSrvDO aggParent = medsrvagg.getParentDO();
                MedSrvSetItemDO[] medSrvSetItems = medsrvagg.getMedSrvSetItemDO();
                List<MedSrvSetItemDO> list = new List<MedSrvSetItemDO>();
                for(int i=0;i<medSrvSetItems.Length;i++){
                    if (medSrvSetItems[i].Fg_clinical != null && (bool)(medSrvSetItems[i].Fg_clinical) == true && medSrvSetItems[i].Ds == 0 && medSrvSetItems[i].Fg_active != null && (bool)(medSrvSetItems[i].Fg_active) == true) {
                        list.Add(medSrvSetItems[i]);
                    }
                }
                MedsrvAggDO[] medsrvaggs = medSrvImpl.getMedSrvDO(list);
                foreach(MedsrvAggDO agg in medsrvaggs)
                {
                     MedSrvDO medsrv = agg.getParentDO();
                     CiEmsSrvDTO stvdto = new CiEmsSrvDTO();
                     stvdto.Id_srv_set = id_srv;
                     stvdto.Fg_set = medsrv.Fg_set;
                     stvdto.Id_srv = medsrv.Id_srv;
                     stvdto.Id_freq = medsrv.Id_freq;
                     stvdto.Id_srvca = medsrv.Id_srvca;
                     stvdto.Sd_srvtp = medsrv.Sd_srvtp;
                     stvdto.Eu_blmd = medsrv.Eu_blmd;
                     stvdto.Fg_mm = medsrv.Fg_mm;
                     stvdto.Code_srv = medsrv.Code;
                     stvdto.Fg_bl = medsrv.Fg_bl;
                     stvdto.Id_srvtp = medsrv.Id_srvtp;
                     stvdto.Quan_med = medsrv.Quan_med;
                     stvdto.Id_unit_med = medsrv.Id_unit_med;
                     stvdto.Id_route = medsrv.Id_route;
                     stvdto.Eu_sourcemd = Eu_sourcemd;
                     stvdto.Des_srv = medsrv.Des;
                     stvdto.Fg_or = true;
                     stvdto.Id_primd = medsrv.Id_primd;
                     stvdto.Name_srv = medsrv.Name;
                     if (stvdto.Fg_mm != null && stvdto.Fg_mm == true) {
                         MeterialDO[] mms = service.find(string.Format("id_srv='{0}' and fg_active='Y' and ds=0 ",stvdto.Id_srv), "",false);
                         if (mms != null && mms.Length > 0) {
                             stvdto.Id_mm = mms[0].Id_mm;
                             IMaterialBaseInfoService meterialBaseService = XapServiceMgr.find<IMaterialBaseInfoService>();
                             MaterialUnitDTO[] materUnit = meterialBaseService.getMMunitByEntp(new string[]{mms[0].Id_mm},code_entp );
                             if (materUnit != null && materUnit.Length > 0)
                             {
                                 stvdto.Id_unit_sale = materUnit[0].Id_measdoc;
                             }
                             else {
                                 stvdto.Id_unit_sale = mms[0].Id_unit_pkgsp;
                             }
                             stvdto.Name_mm = mms[0].Name;
                             stvdto.Id_unit_base = mms[0].Id_unit_pkgbase;
                             
                             stvdto.Code_mm = mms[0].Code;
                             stvdto.Factor_mb = mms[0].Factor_mb;
                             stvdto.Factor_cb = mms[0].Factor_sb;
                             stvdto.Id_val = mms[0].Id_val;
                             stvdto.Sd_val = mms[0].Sd_val;
                             stvdto.Id_mmtp = mms[0].Id_mmtp;
                             stvdto.Sd_mmtp = mms[0].Sd_mmtp;
                             if (code_entp == EnDictCodeConst.SD_ENTP_INPATIENT)
                             {
                                 stvdto.Sd_roundmd = mms[0].Id_mupkgutp;
                             }
                             else if (code_entp == EnDictCodeConst.SD_ENTP_OUTPATIENT) {
                                 stvdto.Sd_roundmd = mms[0].Sd_opmutp;
                             }
                             stvdto.Fg_skintest = false;
                         }
                     }
                    emslist.Add(stvdto);
                }
                
            }
            return emslist;
        }
        /// <summary>
        /// 通过病历模板查询默认的病情描述
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        public string diseaseDescription(string id_ent)
        {
            IMrdocrefvalueCrudService mrdocservice = XapServiceMgr.find<IMrdocrefvalueCrudService>();
            string sql = string.Format("id_ent='{0}' and code_element in ('{1}','{2}','{3}')", 
                id_ent, CiDictCodeConst.CODE_ELEMENT_MAINSUIT, CiDictCodeConst.CODE_ELEMENT_NOWDISEASE, CiDictCodeConst.CODE_ELEMENT_TEST);

            MrDocRefValueDO[] mrdocs = mrdocservice.find(sql, "", false);
            if (mrdocs != null && mrdocs.Length > 0)
            {
                string clinial = "";
                MrDocRefValueDO item = mrdocs.FirstOrDefault(p => p.Code_element == CiDictCodeConst.CODE_ELEMENT_MAINSUIT);
                if (item != null)
                {
                    clinial = string.Format("以{0}之主诉就诊。", item.Content);
                }
                item = mrdocs.FirstOrDefault(p => p.Code_element == CiDictCodeConst.CODE_ELEMENT_NOWDISEASE);
                if (item != null)
                {
                    if (string.IsNullOrEmpty(clinial))
                    {
                        if (item.Content != "" && item.Content != null)
                        {
                            clinial = item.Content;
                        }
                    }
                    else
                    {
                        if (!string.IsNullOrEmpty(item.Content))
                        {
                            clinial += (item.Content + "\r\n");
                        }
                    }

                }
                item = mrdocs.FirstOrDefault(p => p.Code_element == CiDictCodeConst.CODE_ELEMENT_TEST);
                if (item != null)
                {
                    if (string.IsNullOrEmpty(clinial))
                    {
                        if (item.Content != "" && item.Content != null)
                        {
                            clinial = item.Content;
                        }
                    }
                    else
                    {
                        if (!string.IsNullOrEmpty(item.Content))
                        {
                            clinial += (item.Content + "\r\n");
                        }
                    }
                }
                return clinial;
            }
            return null;
        }
        /// <summary>
        /// 判断两个数字能不能整除
        /// </summary>
        /// <param name="d1"></param>
        /// <param name="d2"></param>
        /// <returns></returns>
        public bool divided(FDouble fd1 ,FDouble fd2) { 
            if(fd1==null||fd2==null) return false;
            string str1 = fd1.ToString();
            string str2 = fd2.ToString();
            string[] strAr1 = str1.Split('.');
            if(strAr1.Length==1){
                strAr1 = new string[]{strAr1[0],"1"};
            }
            strAr1[1] = numBenHandle(strAr1[1]);
            string[] strAr2 = str2.Split('.');
            if (strAr2.Length == 1) {
                strAr2 = new string[] { strAr2[0], "1" };
            }
            strAr2[1] = numBenHandle(strAr2[1]);
            int leng = strAr1[1].Length >= strAr2[1].Length ? strAr1.Length : strAr1.Length;
            if (Convert.ToInt32(fd1.DoubleValue() * Math.Pow(10, leng)) % Convert.ToInt32(fd2.DoubleValue() * Math.Pow(10, leng)) == 0)
            {
                return true;
            }
            return false;
        }
        private string numBenHandle(string input)
        {
            if (string.IsNullOrEmpty(input)) return "";
            int iL = input.Length;
            String rtnstr = "";
            char[] szInput = input.ToCharArray();
            for (int i = iL - 1; i >= 0; i--)
            {
                if (szInput[i] != '0')
                {
                    rtnstr = input.Substring(0, i + 1);
                    break;
                }
            }
            return rtnstr;
        }
        /// <summary>
        /// 判断医嘱的开单医生和登录医生是否一致
        /// </summary>
        /// <param name="order"></param>
        /// <returns></returns>
        public bool isIdEmpOrEqualIdpsn(CiOrderDO order)
        {
            string id_emp_or = order.Id_emp_or;
            string id_psn = UserManager.getInstance().CurrentUser.Id_psn;//当前登录医生
            if (!string.IsNullOrEmpty(id_emp_or) && !string.IsNullOrEmpty(id_psn) && id_emp_or.Equals(id_psn))
            {
                return true;
            }
            return false;
        }
        /// <summary>
        /// 判断医嘱的开单医生和登录医生是否一致
        /// </summary>
        /// <param name="order"></param>
        /// <returns></returns>
        public bool isIdEmpOrEqualIdpsn(params String[] Id_emp_or)
        {
            if (Id_emp_or == null) return false;
            string id_emp_or = Id_emp_or[0];
            string id_psn = UserManager.getInstance().CurrentUser.Id_psn;//当前登录医生
            if (!string.IsNullOrEmpty(id_emp_or) && !string.IsNullOrEmpty(id_psn) && id_emp_or.Equals(id_psn))
            {
                return true;
            }
            return false;
        }
    }
}
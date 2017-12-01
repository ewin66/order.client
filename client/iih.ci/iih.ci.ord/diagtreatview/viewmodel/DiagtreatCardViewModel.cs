using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Reflection;
using iih.bd.srv.mrctmca.d;
using iih.ci.mr.cimr.d;
using iih.ci.ord.diagtreatview.viewmodel.bp;
using iih.ci.ord.diagtreatview.viewmodel.cache;
using iih.ci.ord.dto.blexorder.d;
using iih.ci.ord.i;
using iih.en.pv.dto.d;
using iih.en.pv.i;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.bizcontrol.ClinicalTimeline;

namespace iih.ci.ord.diagtreatview.viewmodel
{
    public class DiagtreatCardViewModel
    {
        //private readonly CacheUtils CacheUtils;
        private readonly KeyPointCacheDataUtils KeyPointCacheUtils;
        private readonly NewCacheDataUtils NewCacheUtils;
        private readonly IEnOutQryService enQryService;
        //private readonly int preDates = 21;
        private readonly ICiOrdQryService qryService;
        public FDateTime dtacept = null;
        public FDateTime enddate = null;
        public List<Object> groupmodel = new List<object>(); 
        public DiagtreatCardViewModel()
        {
            qryService = XapServiceMgr.find<ICiOrdQryService>();
            enQryService = XapServiceMgr.find<IEnOutQryService>();
            //CacheUtils = new CacheUtils();
            KeyPointCacheUtils = new KeyPointCacheDataUtils();
            NewCacheUtils = new NewCacheDataUtils();
        }

        /// <summary>
        ///     获取患者就诊数据
        /// </summary>
        public IpBasicDTO GetIpBasicInfo(string Ident)
        {
            return enQryService.GetIpBasicInfo(Ident);
        }

        /// <summary>
        ///     检验闭环数据
        /// </summary>
        public void getlisLoopStep(EventLabelModel EventLabel)
        {
            var loopbp = new HandleLisOrRisExeLoopBP();
            loopbp.exec(EventLabel);
        }

        /// <summary>
        ///     获取执行闭环的数据
        /// </summary>
        public void GetExecuteSteps(RouteMark routeMark)
        {
            var loopbp = new HandleDrugExeLoopBP();
            loopbp.exec(routeMark);
        }

        public void refreshData(OrSrvSplitParamDTO param)
        {
            setWholeData(param);
        }

        public void setKeyPointData(string id_ent, DateTime start, DateTime end,
            DateTime startDate)
        {
            DiagTreatKeyPointRntDataDTO[] keylist = NewCacheUtils.Cache.CacheList.ToArray();
            KeyPointCacheUtils.Cache.MrcaList = NewCacheUtils.Cache.MrcaList;
            KeyPointCacheUtils.writeViewData(keylist, true);
        }

        #region 从缓存获取数据

        /// <summary>
        ///     获取病历文书
        /// </summary>
        public ExeEventGroupModel getMrList(MrCtmCaDO[] mrcas, CiMrDO[] cimrs)
        {
            var ad = new CiMrDataAdapter();
            return ad.exe(mrcas, cimrs);
        }

        public KeyPointViewData queryKeyPViewData(DateTime start, DateTime end)
        {
            return KeyPointCacheUtils.queryViewData(start, end);
        }

        public KeyPointViewData queryViewData(DateTime start, DateTime end)
        {
            return NewCacheUtils.queryViewData(start, end);
        }

        public List<FDate> getKeyPoints()
        {
            return KeyPointCacheUtils.Cache.KeyPointList;
        }

        public void setWholeData(OrSrvSplitParamDTO param)
        {
            Debug.WriteLine("helloworld:DiagtreatCardViewModel:setWholeData   后台查询开始:" +
                            DateTime.Now.ToString("yyyy/MM/dd HH:mm:ss fff"));
            DiagTreatViewRntDataDTO diagTreatViewRntData = qryService.getDiagTreatViewData(param);
            Debug.WriteLine("helloworld:DiagtreatCardViewModel:setWholeData  后台查询结束:" +
                            DateTime.Now.ToString("yyyy/MM/dd HH:mm:ss fff"));
            if (param.Dt_split_start == null)
            {
                param.Dt_split_start = diagTreatViewRntData.Dt_start;
            }
            if (param.Dt_split_end == null)
            {
                param.Dt_split_end = diagTreatViewRntData.Dt_end;
            }
            //DiagTreatInit.dtacept = diagTreatViewRntData.Dt_start;
            //DiagTreatInit.enddate = diagTreatViewRntData.Dt_end;
            dtacept = diagTreatViewRntData.Dt_start;
            enddate = diagTreatViewRntData.Dt_end;
            NewCacheUtils.setDate4Dic(param.Dt_split_start.Value, param.Dt_split_end.Value,
                diagTreatViewRntData.Mrctmcas);
            NewCacheUtils.writeViewData(diagTreatViewRntData, true);
            Debug.WriteLine("helloworld:DiagtreatCardViewModel:setWholeData  加载缓存结束:" +
                            DateTime.Now.ToString("yyyy/MM/dd HH:mm:ss fff"));
            //var i = 1;
        }

        #endregion

        #region 释放UI模型内存

        public void disposeuimodel()
        {
            foreach (object o in groupmodel)
            {
                if (o is ExeRouteGroupModel)
                {
                    clearRouteModel((ExeRouteGroupModel)o);

                }
                else if (o is ExeEventGroupModel)
                {
                    clearEventModel((ExeEventGroupModel)o);
                }
                else if (o is VitalSignGroupModel)
                {
                    clearVitModel((VitalSignGroupModel)o);
                }

            }
        }

        private void clearRouteModel(ExeRouteGroupModel routeGroupModel)
        {
            if (routeGroupModel.Listperiod != null)
            {
                foreach (List<DateTime> o in routeGroupModel.Listperiod)
                {
                    o.Clear();
                }
                routeGroupModel.Listperiod.Clear();
            }
            foreach (RouteMap o in routeGroupModel.RouteMaps)
            {
                foreach (var p in o.Routes)
                {
                    foreach (MarkAssist q in p.RouteAssistMarks)
                    {
                        this.Clear(q);
                    }
                }
                foreach (var r in o.Marks)
                {
                    this.Clear(r);
                }
            }
            routeGroupModel.RouteMaps.Clear();
            routeGroupModel.Name = null;
        }

        private void clearEventModel(ExeEventGroupModel routeGroupModel)
        {
            foreach (EventLabelModel o in routeGroupModel.EventLabels)
            {
                this.Clear(o);
            }
            routeGroupModel.EventLabels.Clear();
            routeGroupModel.Name = null;
        }

        private void clearVitModel(VitalSignGroupModel vitalsignModel)
        {
            if (vitalsignModel.GridItemConfigs != null)
            {
                foreach (VitalSignGridItemConfig o in vitalsignModel.GridItemConfigs)
                {
                    this.Clear(o);
                }

                vitalsignModel.GridItemConfigs.Clear();
            }
            foreach (var o in vitalsignModel.Items)
            {
                this.Clear(o);
            }
            vitalsignModel.Items.Clear();
            vitalsignModel.Name = null;
        }

        public void Clear<T>(T target, String[] notProps = null)
        {
            if (null == target)
                return;

            foreach (var property in target.GetType().GetProperties())
            {
                if (property.CanWrite)
                {
                    if (property.GetSetMethod() != null)
                    {
                        target.GetType().InvokeMember(property.Name, BindingFlags.SetProperty, null, target, new object[] { null });
                    }
                }
            }
        }
        #endregion
    }
}
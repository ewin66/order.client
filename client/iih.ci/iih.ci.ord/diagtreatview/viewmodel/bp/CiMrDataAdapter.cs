using System;
using System.Collections.Generic;
using iih.bd.srv.mrctmca.d;
using iih.ci.mr.cimr.d;
using xap.rui.bizcontrol.ClinicalTimeline;
using xap.rui.bizcontrol.ClinicalTimeline.enums;
using xap.rui.bizcontrol.ClinicalTimeline.info;

namespace iih.ci.ord.diagtreatview.viewmodel.bp
{
    public class CiMrDataAdapter
    {
        public ExeEventGroupModel exe(MrCtmCaDO[] mrcas, CiMrDO[] cimrs)
        {
            var mrcadic = new Dictionary<string, MrCtmCaDO>();
            foreach (MrCtmCaDO caDo in mrcas)
            {
                mrcadic.Add(caDo.Id_mrcactm, caDo);
            }

            var eventLabelGroupModel = new ExeEventGroupModel();
            eventLabelGroupModel.Name = "病历文书";
            eventLabelGroupModel.IsGroupIn = true;
            var calist = new List<MrCtmCaDO>();

            //   List<EventLabelExtInfo> eventlist=new List<EventLabelExtInfo>();
            foreach (CiMrDO cimr in cimrs)
            {
                if (cimr.Id_mrcactm == null) continue;
                if (mrcadic.ContainsKey(cimr.Id_mrcactm))
                {
                    MrCtmCaDO ca = mrcadic[cimr.Id_mrcactm];
                    if (!calist.Contains(ca))
                    {
                        calist.Add(ca);
                        int num = 1000;
                        if (ca.Sortno != null) num = (int) ca.Sortno;
                        //   eventlist.Add(new EventLabelExtInfo() { GroupName = ca.Name, IsShow = true, Order = num });
                        eventLabelGroupModel.GroupNameList.Add(new EventLabelExtInfo
                        {
                            GroupName = ca.Name,
                            IsShow = true,
                            Order = num
                        });
                    }
                    var eventlable = new EventLabelModel(cimr.Name, (DateTime) cimr.Dt_rd);
                    eventlable.NowType = ClinicalExeEventStatus.MedicalRecord;
                    eventlable.Id = cimr.Id_mr;
                    eventlable.GroupName = ca.Name;
                    eventLabelGroupModel.EventLabels.Add(eventlable);
                }
            }
            //if (eventlist.Count > 0)
            //{
            //    eventlist = eventlist.OrderBy(x => x.Order).ToList();
            //    eventLabelGroupModel.GroupNameList.AddRange(eventlist);
            //}
            if (eventLabelGroupModel.EventLabels.Count == 0)
            {
                eventLabelGroupModel.IsGroupIn = false;
            }
            else
            {
                eventLabelGroupModel.IsGroupIn = true;
            }

            return eventLabelGroupModel;
        }
    }
}
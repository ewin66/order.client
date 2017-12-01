using System;
using System.Collections.Generic;
using System.Linq;
using iih.ci.ord.cirptlab.d;
using iih.ci.ord.cirptlab.i;
using iih.ci.ord.dto.d;
using iih.ci.ord.dto.orobsandlab.d;
using iih.ci.ord.i;
using xap.cli.sdk.chart;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw.collections;
using xap.rui.control.extentions;

namespace iih.ci.ord.cilab.viewmodel
{
    public class CiRptlabViewModel
    {
        private readonly ICiOrdQryService qryservice;
        private readonly ICirptlabCrudService service;
        public CirptlabAggDO cirptlabAggDO;

        public CiRptlabViewModel()
        {
            service = XapServiceMgr.find<ICirptlabCrudService>();
            qryservice = XapServiceMgr.find<ICiOrdQryService>();
        }

        public XapAggDO<CirptlabAggDO> AggDo { get; set; }

        public CirptlabAggDO getCiRptlabDO(string id_lab)
        {
            // todo 修改成 检查的 id 
            //return service.findById(id_lab);
            CirptlabAggDO[] cirptlab = service.find("a0.Id_rptlab ='" + id_lab + "'", "", FBoolean.False);

            if (cirptlab != null && cirptlab.Count() > 0)
            {
                convert(cirptlab[0]);
                cirptlabAggDO = cirptlab[0];
                AggDo = new XapAggDO<CirptlabAggDO>(service, cirptlabAggDO);
            }
            return null;
        }

        public List<Reportlab> getCiRptlabAggDO(string idpat, int num, CiRptLabItmDO[] itms)
        {
            // todo 修改成 检查的 id 
            //return service.findById(id_lab);
            if (itms == null || itms.Length == 0)
                return null;
            string[] srvs = itms.Select(p => p.Id_srv).ToArray();
            LabDTO[] labs = qryservice.getLabItms(idpat, num, srvs);
            if (labs.Count() == 0 )
            {
                this.ShowAlert("没有符合要求的数据");
                return null;
            }

            var lablist = new List<Reportlab>();
            int i = 0;
            foreach (CiRptLabItmDO s2 in itms)
            {
                if (s2.Sd_restrptlabtp != "0")
                    continue;
                var lab = new Reportlab();
                lab.Name = s2.Name_srv;
                lab.YUnit = s2.Unit_name;
                i++;

                foreach (LabDTO ldo in labs)
                {
                    if (ldo.Val_rstrptlab==null)
                        continue;
                    if (s2.Id_srv.Equals(ldo.Id_srv))
                    {
                        var p = new LabPoint();
                        p.Xvalue = ldo.Dt_rptlab;
                        p.Yvalue = Double.Parse(ldo.Val_rstrptlab);
                        p.FlagException = false;
                        lab.AddPoint(p);
                    }
                }

                lablist.Add(lab);
                if (i == 5)
                    break;
            }
            if (lablist.Count == 0 || lablist.Count < itms.Count())
            {
                this.ShowAlert("结果值的类型不是数值");
                return null;
            }
               
            return lablist;
        }


        public List<Reportlab> getLabRpts4TreatView(string idpat, DateTime dt, CiRptLabItmDO[] itms)
        {
            // todo 修改成 检查的 id 
            //return service.findById(id_lab);
            if (itms == null || itms.Length == 0)
                return null;
            string[] srvs = itms.Select(p => p.Id_srv).ToArray();
            string[] rptids = itms.Select(p => p.Id_rptlab).ToArray();
    //        var dtn = this.NowTime();
            LabDTO[] labs = qryservice.getLabItms8DateBP(idpat, new FDateTime(dt.ToString()),
                new FDateTime((dt.AddDays(-200)).ToString()), srvs);
            if (labs.Count() == 0)
            {
                this.ShowAlert("没有符合要求的数据");
                return null;
            }
            if (itms.Count() > 5)
            {
                this.ShowAlert("勾选的数据不能超过5条");
                return null;
            }
            var lablist = new List<Reportlab>();
            int i = 0;
            foreach (CiRptLabItmDO s2 in itms)
            {
                if (s2.Sd_restrptlabtp != "0")
                    continue;
                var lab = new Reportlab();
                lab.Name = s2.Name_srv;
                lab.YUnit = s2.Unit_name;
                i++;

                foreach (LabDTO ldo in labs)
                {
                    if (ldo.Val_rstrptlab==null)
                        continue;
                    if (s2.Id_srv.Equals(ldo.Id_srv))
                    {
                       
                        var p = new LabPoint();
                        p.Xvalue = ldo.Dt_rptlab;
                        p.Yvalue = Double.Parse(ldo.Val_rstrptlab);
                        p.FlagException = false;
                        lab.AddPoint(p);
                    }
                }

                lablist.Add(lab);
                if (i == 5)
                    break;
            }
            if (lablist.Count == 0 || lablist.Count < itms.Count())
            {
                this.ShowAlert("结果值的类型不是数值");
                return null;
            }

            return lablist;
        }

        private void convert(CirptlabAggDO aggDO)
        {
            if (aggDO != null)
            {
                CiRptLabItmDO[] ciRptLabItms = aggDO.getCiRptLabItmDO();
                if (ciRptLabItms != null)
                {
                    foreach (CiRptLabItmDO item in ciRptLabItms)
                    {
                        if (item.Name_deviate == null)
                            continue;
                        if (item.Name_deviate.Equals("偏高"))
                            item.Name_deviate = "↑";
                        else if (item.Name_deviate.Equals("偏低"))
                        {
                            item.Name_deviate = "↓";
                        }
                    }
                }
            }
        }

        /// <summary>
        ///     通过医嘱获取检查检验明细
        /// </summary>
        public OrObsAandLabDTO GetObsAandLabDto(string id_or, string type)
        {
            OrObsAandLabDTO obsAandLabDto = qryservice.getObsAndLabDto(id_or, type);
            return obsAandLabDto;
        }



        //private bool validaterptdata(List<Reportlab> lablist,int num)
        //{
        //    bool flag = false;
        //    if (lablist.Count == 0 || lablist.Count < num)
        //    {
        //        flag = true;
        //        return true;
        //    }

        //    int sum = 0;
        //    foreach (Reportlab reportlab in lablist)
        //    {
        //        sum = sum + reportlab.points.Count;
        //    }
        //    if(sum==0)
        //    {
        //        flag = true;
        //    }
        //    return flag;
        //}
    }
}
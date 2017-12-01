using System.Collections.Generic;
using System.Linq;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.i;
using iih.mp.nr.dto.d;
using iih.mp.nr.foreign.i;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.bizcontrol.ClinicalTimeline;
using xap.rui.bizcontrol.ClinicalTimeline.data;
using xap.rui.bizcontrol.ClinicalTimeline.MedicalClosedLoop;
using xap.sys.orgfw.dept.d;
using xap.sys.orgfw.dept.i;

namespace iih.ci.ord.diagtreatview.viewmodel.bp
{
    public class HandleLisOrRisExeLoopBP
    {
        private IForeignService foreignservice;

        /// <summary>
        ///     检查检验闭环数据  RouteMark labelCheck
        /// </summary>
        public void exec(EventLabelModel EventLabel)
        {
            foreignservice = XapServiceMgr.find<IForeignService>();
            EventLabel.NowSelectedButton.ExeStatus = EventLabel.NowStates;
            EventLabel.NowSelectedButton.IdOr = EventLabel.Id;
            var paramDto = new OrdOrpltpParamDTO();
            paramDto.Id_or = EventLabel.Id;
            paramDto.Dt_mp_plan = EventLabel.DateTime;
            OrdOrpltpDetailDTO[] detailDtos = foreignservice.getOrdOrpltpDetail(new[] {paramDto});
            if (detailDtos == null || detailDtos.Count() == 0)
                return;

            getlisLoopStep(EventLabel.NowSelectedButton, detailDtos.ToList());
        }


        private void getlisLoopStep(EventLabelCheck labelCheck, List<OrdOrpltpDetailDTO> detailDtos)
        {
            if (labelCheck == null) return;
            //设置闭环数据
            setExeLoopDetail(labelCheck, detailDtos);
            //设置医嘱信息
            setOrdDetail(labelCheck);
        }


        private void setExeLoopDetail(EventLabelCheck labelCheck, List<OrdOrpltpDetailDTO> detailDtos)
        {
            var deptCrudService = XapServiceMgr.find<IDeptCrudService>();
            labelCheck.LoopNodeInfoList = new List<LoopNodeInfo>();
            labelCheck.LoopNameAllList = new List<LoopNodeInfo>();

            IOrderedEnumerable<OrdOrpltpDetailDTO> l = detailDtos.OrderBy(x => x.Sortno);
            List<OrdOrpltpDetailDTO> ll = l.ToList();
            Dictionary<string, string> depdic = getdepname(detailDtos);
            foreach (OrdOrpltpDetailDTO orpltpDetailDto in ll)
            {
                var step = new LoopNodeInfo();
                step.AbnormalSituations = orpltpDetailDto.Skip_reason;
                step.Name = orpltpDetailDto.Name_orpltpsta;
                step.ExecuteTime = orpltpDetailDto.Dt_mp.ToString();
                step.Index = (int) orpltpDetailDto.Sortno;
                if (orpltpDetailDto.Eu_su == 0)
                {
                    step.IsThrough = false;
                }
                if (orpltpDetailDto.Eu_su == 1)
                {
                    step.IsThrough = true;
                    step.IsSuccess = ExeStatuesNow.Success;
                }
                if (orpltpDetailDto.Eu_su == 2)
                {
                    step.IsSuccess = ExeStatuesNow.Break;
                    labelCheck.ExeStatus = ExeStatuses.Pending;
                }
                if (orpltpDetailDto.Eu_su == 4)
                {
                    step.IsThrough = true;
                    step.IsSuccess = ExeStatuesNow.Success;
                }

                step.Executor = orpltpDetailDto.Name_emp;
                //DeptDO dep = deptCrudService.findById(orpltpDetailDto.Id_dep);
                //if (dep != null) step.ExecuteOffice = dep.Name;
                if (null != orpltpDetailDto.Id_dep && depdic.ContainsKey(orpltpDetailDto.Id_dep))
                    step.ExecuteOffice = depdic[orpltpDetailDto.Id_dep];
                if (orpltpDetailDto.Eu_su == 1 || orpltpDetailDto.Eu_su == 2 || orpltpDetailDto.Eu_su == 4)
                {
                    labelCheck.LoopNodeInfoList.Add(step);

                    if (orpltpDetailDto.Eu_su == 2) break;
                }
                labelCheck.LoopNameAllList.Add(step);
            }
        }

        private void setOrdDetail(EventLabelCheck labelCheck)
        {
            var orService = XapServiceMgr.find<ICiorderCrudService>();
            labelCheck.MedicalInfoList = new List<MedicalInfo>();

            //获取已医嘱信息
            CiorderAggDO ciagg = orService.findById(labelCheck.IdOr);
            var orcontent = new OrContent();
            var medlist = new List<MedicalInfo>();
            var med = new MedicalInfo();
            med.Name = ciagg.getParentDO().Name_or;
            med.Order = 1;
            medlist.Add(med);
            orcontent.Des = ciagg.getParentDO().Des_or;
            orcontent.Medlist = medlist;
            labelCheck.OrCon = orcontent;
            if (ciagg.getParentDO().Sd_orrsttp == null || ciagg.getParentDO().Sd_orrsttp == "0")
            {
                labelCheck.IsShowReportButton = false;
            }
            else
            {
                labelCheck.IsShowReportButton = true;
            }

            //labelCheck.IsShowReportButton=ciagg.getParentDO()

            //    labelCheck.ACName = ciagg.getParentDO().Content_or;

            //IOrderedEnumerable<OrdSrvDO> srva = ciagg.getOrdSrvDO().OrderBy(x => x.Sortno);
            //foreach (OrdSrvDO srvDo in srva)
            //{
            //    if (srvDo.Fg_or == FBoolean.True && srvDo.Sd_srvtp.StartsWith("03"))
            //    {
            //        var med = new MedicalInfo();

            //        med.Units = srvDo.Quan_medu + " " + srvDo.Medu_name;
            //        med.MedicationModels = srvDo.Route_name;

            //        med.Name = srvDo.Name;
            //        med.Order = (int)srvDo.Sortno;
            //        labelCheck.MedicalInfoList.Add(med);
            //    }
            //}
        }

        private Dictionary<string, string> getdepname(List<OrdOrpltpDetailDTO> detailDtos)
        {
            var deptCrudService = XapServiceMgr.find<IDeptCrudService>();
            var dic = new Dictionary<string, string>();
            var id_deps = new List<string>();
            foreach (OrdOrpltpDetailDTO dto in detailDtos)
            {
                if (dto.Id_dep != null)
                    id_deps.Add(dto.Id_dep);
            }
            if (id_deps.Count > 0)
            {
                DeptDO[] deps = deptCrudService.findByIds(id_deps.ToArray(), FBoolean.False);
                if (deps != null && deps.Count() > 0)
                {
                    foreach (DeptDO dep in deps)
                    {
                        if (!dic.ContainsKey(dep.Id_dep))
                            dic.Add(dep.Id_dep, dep.Name);
                    }
                }
            }


            return dic;
        }
    }
}
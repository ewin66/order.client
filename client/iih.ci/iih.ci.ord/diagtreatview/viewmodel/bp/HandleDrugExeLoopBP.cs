using System.Collections.Generic;
using System.Linq;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.i;
using iih.mp.nr.dto.d;
using iih.mp.nr.foreign.i;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.bizcontrol.ClinicalTimeline;
using xap.rui.bizcontrol.ClinicalTimeline.MedicalClosedLoop;
using xap.sys.orgfw.dept.d;
using xap.sys.orgfw.dept.i;

namespace iih.ci.ord.diagtreatview.viewmodel.bp
{
    public class HandleDrugExeLoopBP
    {
        private IForeignService foreignservice;

        /// <summary>
        ///     用药闭环数据  RouteMark labelCheck
        /// </summary>
        public void exec(RouteMark routeMark)
        {
            if (routeMark == null) return;
            foreignservice = XapServiceMgr.find<IForeignService>();
            OrdOrpltpParamDTO[] paramDtos = getStepDetailDtos(routeMark);
            Dictionary<string, List<OrdOrpltpDetailDTO>> dic = getOrdDetails(paramDtos);
            if (dic.Count == 0) return;
            string key = routeMark.IdOr + "," + routeMark.Time;
            if (dic.ContainsKey(key))//外层为Pending，内层含有可执行点,需要对外层点进行校验
            GetExecuteSteps(routeMark, dic[key]);
            foreach (RouteMark mark in routeMark.RepeatdRouteMarks)
            {
                if (!(mark.ExeStatus == ExeStatuses.Executing || mark.ExeStatus == ExeStatuses.Executed)) continue;
                string keym = mark.IdOr + "," + mark.Time;
                if (dic.ContainsKey(keym))
                GetExecuteSteps(mark, dic[keym]);
            }
        }


        private void GetExecuteSteps(RouteMark routeMark, List<OrdOrpltpDetailDTO> detailDtos)
        {
            if (routeMark == null) return;


            //设置执行闭环数据
            setExeLoopDetail(routeMark, detailDtos);
            //设置医嘱信息
            setOrdDetail(routeMark);
        }


        private Dictionary<string, List<OrdOrpltpDetailDTO>> getOrdDetails(OrdOrpltpParamDTO[] paramsDtos)
        {
            var dic = new Dictionary<string, List<OrdOrpltpDetailDTO>>();
            OrdOrpltpDetailDTO[] detailDtos = foreignservice.getOrdOrpltpDetail(paramsDtos);
            foreach (OrdOrpltpDetailDTO orpltpDetailDto in detailDtos)
            {
                string key = orpltpDetailDto.Id_or + "," + orpltpDetailDto.Dt_mp_plan;
                if (dic.ContainsKey(key))
                {
                    List<OrdOrpltpDetailDTO> list = dic[key];
                    list.Add(orpltpDetailDto);
                }
                else
                {
                    var list = new List<OrdOrpltpDetailDTO>();
                    list.Add(orpltpDetailDto);
                    dic[key] = list;
                }
            }
            return dic;
        }


        private OrdOrpltpParamDTO[] getStepDetailDtos(RouteMark routeMark)
        {
            //Dictionary<string,object> dic=new Dictionary<string, object>();
            var listP = new List<OrdOrpltpParamDTO>();
            var param = new OrdOrpltpParamDTO();
            param.Id_or = routeMark.IdOr;
            param.Dt_mp_plan = routeMark.Time;
            listP.Add(param);
            //dic.Add(param.Id_or,null);
            foreach (RouteMark mark in routeMark.RepeatdRouteMarks)
            {
                if (!(mark.ExeStatus == ExeStatuses.Executing || mark.ExeStatus == ExeStatuses.Executed)) continue;

                var paramDto = new OrdOrpltpParamDTO();
                paramDto.Id_or = mark.IdOr;
                paramDto.Dt_mp_plan = mark.Time;
                listP.Add(paramDto);
            }
            if (listP.Count > 0)
                return listP.ToArray();
            return null;
        }


        private void setExeLoopDetail(RouteMark routeMark, List<OrdOrpltpDetailDTO> detailDtos)
        {
            routeMark.LoopNodeInfoList = new List<LoopNodeInfo>();
            routeMark.LoopNameAllList = new List<LoopNodeInfo>();
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
                    routeMark.ExecuteMsg = orpltpDetailDto.Skip_reason;
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
                    routeMark.LoopNodeInfoList.Add(step);
                    if (orpltpDetailDto.Eu_su == 2) break;
                }
                routeMark.LoopNameAllList.Add(step);
            }
        }

        private void setOrdDetail(RouteMark routeMark)
        {
            var orService = XapServiceMgr.find<ICiorderCrudService>();

            routeMark.MedicalInfoList = new List<MedicalInfo>();

            //获取已医嘱信息
            CiorderAggDO ciagg = orService.findById(routeMark.IdOr);

            IOrderedEnumerable<OrdSrvDO> srva = ciagg.getOrdSrvDO().OrderBy(x => x.Sortno);
            foreach (OrdSrvDO srvDo in srva)
            {
                if (srvDo.Fg_or == FBoolean.True && srvDo.Sd_srvtp.StartsWith("01"))
                {
                    var med = new MedicalInfo();

                    med.Units = srvDo.Quan_medu + " " + srvDo.Medu_name;
                    med.MedicationModels = srvDo.Route_name;

                    med.Name = srvDo.Name;
                    med.Order = (int) srvDo.Sortno;
                    routeMark.MedicalInfoList.Add(med);
                }
            }
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

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.appfw;
using iih.ci.ord.ciordems.d;
using iih.en.pv.dto.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.common.utils;
using iih.ci.ord.ciorder.viewmodel;
using iih.bd.fc.orwf.d;
using iih.bd.fc.wf.d;
using xap.cli.context;
using iih.ci.ord.i;
using iih.ci.ord.emsdi.d;
using iih.bd.bc.udi;
using xap.rui.control.extentions;

namespace iih.ci.ord.ciorder.utils
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.utils    </para>    
    /// <para>类 名 称 :  DrugUtils					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  张万青         				</para> 
    /// <para>修 改 人 :  张万青         				</para> 
    /// <para>创建时间 :  2017/1/3 14:24:54             </para>
    /// <para>更新时间 :  2017/1/3 14:24:54             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class DrugUtils
    {
        /// <summary>
        /// 通过服务id_srv和banner信息,获得服务关联的所有物品信息
        /// </summary>
        /// <param name="id_srvs"></param>
        /// <param name="PatInfo"></param>
        /// <param name="isOutPres">出院带药</param>>
        /// <returns></returns>
        public static XapDataList<EmsOrDrug> getMMOfDrug(string id_srvs, Ent4BannerDTO PatInfo,bool isOutPres=false)
        {
            //通过患者信息拼接就诊上下文
            CiEnContextDTO contextdto = CiEnContextUtil.GetCiEnContext(PatInfo);
            return new OrderCardViewModel().GetOrDrugs(id_srvs, PatInfo.Id_hp, isOutPres==true?EnDictCodeConst.SD_ENTP_OUTPATIENT:PatInfo.Code_entp, contextdto);
        }

        /// <summary>
        /// 针对一个医疗单的方法
        /// </summary>
        /// <param name="xapDataList"></param>
        /// <param name="id_route"></param>
        /// <param name="ent4BannerDTO"></param>
        public static void fillExecDetps(XapDataList<EmsOrDrug> xapDataList,string id_route, Ent4BannerDTO ent4BannerDTO)
        {
            List<string> idlist = new List<string>();
            xapDataList.ToList().ForEach(p => {
                if (!idlist.Contains(p.Id_srv)) {
                    OrWfExDeptParamDTO param = new OrWfExDeptParamDTO();
                    param.Eu_wftp = Convert.ToInt32(EnumFlow.NULL);            //    0执行与物资   1执行科室 2物资流向
                    param.Code_entp = ent4BannerDTO.Code_entp;                             //     就诊类型
                    param.Id_dept_ns = ent4BannerDTO.Id_dep_nur; //就诊护理病区
                    param.Id_dept_or = UserManager.getInstance().CurrentDept.Id_dep;//开单科室
                    param.Id_dept_en = ent4BannerDTO.Id_dep_phy; //id_dept_en;//就诊科室
                    param.Id_srv = p.Id_srv;    //服务
                    param.Sd_srvtp = p.Sd_srvtp; //服务类型sd
                    param.Id_srvca = p.Id_srvca;//服务分类
                    //dto.Innercode_srvca = "";//服务分类内码
                    // param.Id_mm = emsordrug.Id_mm; 传物品id_mm没有用
                    param.Id_usage = id_route;   //用法
                    OrWfDeptInfoDTO deps = new ICiOrdQryServiceImpl().getExeDepts4CiOrSrvN(param);
                    if (deps != null && deps.Orwfexedepts != null && deps.Orwfexedepts.Count != 0)
                    {
                        xapDataList.ToList().ForEach(drug => {
                            if (drug.Id_srv == p.Id_srv) {
                                drug.Id_mp_dep = (deps.Orwfexedepts[0] as OrWfExDeptDTO).Id_dept;
                                drug.Name_mp_dep = (deps.Orwfexedepts[0] as OrWfExDeptDTO).Name_dept;
                                if (deps != null && deps.Pharmwfwhdepts != null && deps.Pharmwfwhdepts.Count > 0)
                                {
                                    drug.Id_dep_wh = (deps.Pharmwfwhdepts[0] as OrWfExDeptDTO).Id_dept;
                                    drug.Name_dep_wh = (deps.Pharmwfwhdepts[0] as OrWfExDeptDTO).Name_dept;
                                }
                                drug.Str_mp_dep_ids = deps.Id_mp_depts;
                                drug.Str_wh_dep_ids = deps.Id_dept_whs;
                            }
                        });
                    }

                    idlist.Add(p.Id_srv);
                }
            });
        }
        /// <summary>
        /// 收集所有的执行科室
        /// </summary>
        /// <param name="xapDataList"></param>
        /// <returns></returns>
        public static string collectIdDepmps(XapDataList<EmsOrDrug> drugList)
        {
            List<string> idList = new List<string>();
            string retStrId = "";
            foreach (EmsOrDrug drug in drugList)
            {
                string ids = drug.Str_mp_dep_ids;
                if(ids==null)continue;
                string[] idArr = ids.Split(',');
                foreach(string id in idArr){
                    
                    if (retStrId.IndexOf(id)==-1) {
                        retStrId+=","+id;
                    }
                }
            }
            if (retStrId.Length > 0) {
                retStrId = retStrId.Substring(1);
            }
            return retStrId;   
        }
    }
}

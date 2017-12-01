using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.fc.mdwfor.i;
using xap.mw.serviceframework;
using iih.bd.fc.mdwfor.d;
using iih.bd.fc.wforqry.d;
using iih.ci.ord.ciordems.d;
using iih.bd.iih.bd.fc.i;
using iih.bd.fc.orwf.d;
using iih.bd.srv.service.i;
using System.Data;
using iih.ci.ord.i;
using xap.cli.context;
using iih.bd.fc.wf.d;
using iih.ci.ord.emsdi.d;
using xap.mw.log;

namespace iih.ci.ord.ciorder.viewmodel.impext
{
    /// <summary>
    /// 执行科室接口
    /// </summary>
    class GetDeptMpImp
    {
        public IMdwforQryRService ordmpService { get; set; }
        private IBdFcQryService bdSrvQryService;

        public GetDeptMpImp()
        {
            this.ordmpService = XapServiceMgr.find<IMdwforQryRService>();
            this.bdSrvQryService = XapServiceMgr.find<IBdFcQryService>();
            //MdWfOrDO[] md= ordmpService.getMdwfOrDos(new WforQryCondDTO());
        }

        /// <summary>
        /// Gets the dept_mp.
        /// </summary>
        /// <param name="id_entp">The  .</param>
        /// <param name="id_srvtp">The id_srvtp.</param>
        /// <param name="id_srv">The id_srv.</param>

        /// <returns>id_dept|name_dept</returns>
        /// Author:admin
        ///// Date:2015-09-19                   
        //public List<EmsDrugItemDO> GetDept_mp(string id_entp, string id_srvtp, string id_srvCa, string id_srv, string id_route)
        //{
        //    //入参数：就诊类型id、服务类型编码、服务分类id、服务项目id、医嘱用法id、医嘱长临标志。
        //    //传回参数：执行科室id
        //    //传入参数：就诊类型id、服务分类id，服务项目id，其他参数传值为null。

        //    List<EmsDrugItemDO> list = new List<EmsDrugItemDO>();
        //    MdWfOrDO[] md = ordmpService.getMdwfOrDos(new WforQryCondDTO()
        //    {
        //        Entp = id_entp,
        //        Srvtp = id_srvtp,
        //        Id_qry = id_srv,
        //        Srvca = id_srvCa,
        //        Usg = id_route



        //    });
        //    md.ToList().ForEach(p =>
        //    {
        //        list.Add(new EmsDrugItemDO { Id_dep = p.Id_dept, Name_dep = p.Dept_name });
        //    });
        //    return list;
        //}
        /// <summary>
        /// 获取执行科室id集合
        /// </summary>
        /// <param name="id_entp">The id_entp.</param>
        /// <param name="id_srvtp">The id_srvtp.</param>
        /// <param name="id_srvCa">The id_srv ca.</param>
        /// <param name="id_srv">The id_srv.</param>
        /// <param name="id_route">The id_route.</param>
        /// <returns></returns>
        /// Author:admin
        ///// Date:2015-12-10
        //public string GetDept_mp_ids(string code_entp, string id_entp, string sd_srvtp, string id_srvCa, string id_srv, string id_route, string id_mm,string id_dept_nur)
        //{

        //    OrWfExDeptParamDTO dto = new OrWfExDeptParamDTO();
        //    dto.Id_dept_en = id_entp;
        //    dto.Id_srvca = id_srvCa;
        //    dto.Id_srv = id_srv;
        //    dto.Sd_srvtp = sd_srvtp;
        //    dto.Id_usage = id_route;
        //    dto.Code_entp = code_entp;
        //    dto.Id_dept_ns = id_dept_nur;
        //    dto.Id_mm = "";// 基数药使用 todo
        //    OrWfExDeptDTO[] deps = new IBdFcQryServiceImpl().getOrExDept4OpenMode(dto);

        //    if (deps == null) return "";
        //    string str = string.Join("','", deps.Select(p => p.Id_dept));
        //    string strdep = "'" + str + "'";
        //    return strdep;
        //}

        /// <summary>
        /// 获取医嘱流向科室数据
        /// </summary>
        /// <param name="code_entp"></param>
        /// <param name="id_entp"></param>
        /// <param name="sd_srvtp"></param>
        /// <param name="id_srvCa"></param>
        /// <param name="id_srv"></param>
        /// <param name="id_route"></param>
        /// <param name="id_mm"></param>
        /// <param name="id_dept_nur"></param>
        /// <param name="id_dep_ent"></param>
        /// <param name="id_dep_follow"></param>
        /// <returns></returns>
        public OrWfDeptInfoDTO GetDept_mp_ids(string code_entp, string id_entp, string sd_srvtp, string id_srvCa, string id_srv, string id_route, string id_mm, string id_dept_nur, string id_dep_ent = "", string id_dep_follow = "")
        {
            DataTable dt = new DataTable();
            OrWfExDeptParamDTO dto = new OrWfExDeptParamDTO();
            dto.Eu_wftp = Convert.ToInt32(EnumFlow.NULL);            //    0执行与物资   1执行科室 2物资流向
            dto.Code_entp = code_entp;                              //     就诊类型                  
            dto.Id_dept_ns = id_dept_nur; //就诊护理病区
            dto.Id_dept_or = UserManager.getInstance().CurrentDept.Id_dep;//开单科室
            dto.Id_dept_en = id_dep_ent; //id_dept_en;//就诊科室
             //dto.Recurstr = "";   //长临需要的   不知道 就为空
            dto.Id_srv = id_srv;    //服务
            dto.Sd_srvtp = sd_srvtp; //服务类型sd
            dto.Id_srvca = id_srvCa;//服务分类
            dto.Id_dept_ex = id_dep_follow;        // 主服务执行科室--用于跟随情况
            //dto.Innercode_srvca = "";//服务分类内码
            dto.Id_mm = id_mm;          // 服务选取的关联物品
            dto.Id_usage = id_route;   //用法
            //dto.Weekno = "2";//生效日期时间相关的 周#与时间
            dto.Timestr = new DateTime();
            //dto.Reserv1 = "";  //暂时无用途   //预留项
            //dto.Reserv2 = "";  //暂时无用途
            //dto.Reserv3 = "";  //套内项目时： BD套内项目的科室计算方式sd值,BD套内项目的固定执行科室ID值,所属套的执行科室ID值
            OrWfDeptInfoDTO deps = null;
            try {
                deps = new ICiOrdQryServiceImpl().getExeDepts4CiOrSrvN(dto);
            }
            catch (Exception ex) {
                LogManager.GetLogger().ErrorEx("获取执行科室错误！", ex);
            }

            return deps;
        }




        ////执行科室页面默认值  临时方案
        ///// Author:admin
        ///// Date:2015-12-10
        //public string[] GetDept_mp_ids_2(string code_entp, string id_entp, string sd_srvtp, string id_srvCa, string id_srv, string id_route, string id_mm,string id_dep_nur )
        //{

        //    OrWfExDeptParamDTO dto = new OrWfExDeptParamDTO();
        //    dto.Id_dept_en = id_entp;
        //    dto.Id_srvca = id_srvCa;
        //    dto.Id_srv = id_srv;
        //    dto.Sd_srvtp = sd_srvtp;
        //    dto.Id_usage = id_route;
        //    dto.Code_entp = code_entp;
        //    dto.Id_dept_ns = id_dep_nur;
        //    dto.Id_mm = "";// 基数药使用 todo
        //    OrWfExDeptDTO[] deps = new IBdFcQryServiceImpl().getOrExDept4OpenMode(dto);
        //    string[] depts = null;
        //    if (deps != null && deps.Length > 0)
        //    {
        //        depts = new string[2];
        //        depts[0] = deps[0].Id_dept;

        //        depts[1] = deps[0].Name_dept;
        //    }

        //    return depts;

        //}
    }
}

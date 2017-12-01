using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.routedosage.i;
using xap.mw.serviceframework;
using iih.bd.srv.routedosage.d;
using iih.bd.bc.udi;

namespace iih.ci.ord.ciorder.viewmodel.impext
{
    public class GetSrvVsRouteImp
    {
        IRoutedosageCrudService service;
        GetSrvDrugPropImp drugpro = new GetSrvDrugPropImp();
        public GetSrvVsRouteImp()
        {
            service = XapServiceMgr.find<IRoutedosageCrudService>();
        }

        /// <summary>
        /// 获取服务默认的用法id集合 
        /// </summary>
        /// <param name="id_srvs">参数格式'A','B','C'</param>
        /// <returns></returns>
        private string GetdefaultDosages(string id_srvs)
        {
            MedSrvDrugDO[] drugs = new GetSrvDrugPropImp().GetMedSrvDrupProps(string.Format("a5.id_srv in({0})", id_srvs));

            string id_dosage = "'";
            id_dosage += string.Join("','", drugs.Select(p => p.Id_dosage)) + "'";
            return id_dosage;
        }

        /// <summary>
        /// 获取服务关联的并集用法
        /// </summary>
        /// <param name="id_srvs"></param>
        /// <returns></returns>
        public string GetDosageVsRounte(string id_srvs)
        {
            string id_routes = "'";
            string[] ss = id_srvs.Split(',');
            List<RouteDosageRefDO[]> list = new List<RouteDosageRefDO[]>();
            foreach (var item in ss)
            {
                list.Add(GetDosageVsRountes(item));
            }
            List<RouteDosageRefDO> result = new List<RouteDosageRefDO>();
            for (int i = 0; i < list.Count; i++)
            {
                //var xx = list[0].ToList().Intersect(list[i].ToList(), new ComparerHelper());

                result = Intersect(list[0], list[i]);
                list[0] = result.ToArray();
            }

            id_routes += string.Join("','", result.Select(p => p.Id_route)) + "'";
 
            return id_routes;
        }
        

        /// <summary>
        /// 求交集实验
        /// </summary>
        private List<RouteDosageRefDO> Intersect(RouteDosageRefDO[] a, RouteDosageRefDO[] b)
        {
            List<RouteDosageRefDO> list = new List<RouteDosageRefDO>();
            for (int i = 0; i < a.Length; i++)
            {
                if (b.FirstOrDefault(p=>p.Id_route==a[i].Id_route)!=null)
                {
                    list.Add(a[i]);
                }
            }
            return list;
        }

        /// <summary>
        /// 获取服务关联的用法的首个
        /// </summary>
        /// <param name="id_srvs"></param>
        /// <returns></returns>
        public RouteDosageRefDO[] GetDosageVsRountes(string id_srvs)
        {
            
            RouteDosageRefDO[] routes = service.find(string.Format("id_dosage in ({0})", GetdefaultDosages(id_srvs)), "", false);
            return routes;
          
            
        }

        /// <summary>
        /// 获取草药关联的用法
        /// </summary>
        /// <returns></returns>
        public string GetHerbRounte()
        {
            string id_routes = "'";
            RouteDosageRefDO[] routes = service.find(string.Format("id_dosage in ('{0}')", BdSrvDictCodeConst.ID_DRUG_CAOYAO_DOSAGE), "", false);
            id_routes += string.Join("','", routes.Select(p => p.Id_route)) + "'";
            return id_routes;
        }


    }

    public class ComparerHelper : IEqualityComparer<RouteDosageRefDO>
    {
        public bool Equals(RouteDosageRefDO x, RouteDosageRefDO y)
        {
            return x.Id_route == y.Id_route ||x.Route_name==y.Route_name;
        }
        public int GetHashCode(RouteDosageRefDO obj)
        {
            return obj.Id_route.GetHashCode();
        }
    }
}

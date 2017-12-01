using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;
using iih.bd.srv.medsrv.i;
using iih.ci.ord.ciordems.d;
using xap.rui.appfw;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.cior.d;
using iih.ci.ord.ciorder.d;
using xap.mw.core.data;

namespace iih.ci.ord.ciorder.viewmodel.impext
{
    class GetObsImp
    {
        IMedSrvRisDOCrudService service;
        public GetObsImp()
        {
            this.service = XapServiceMgr.find<IMedSrvRisDOCrudService>();
        }

        public XapDataList<EmsObsItemDO> GetObsList(string id_srv)
        {
            XapDataList<EmsObsItemDO> list = new XapDataList<EmsObsItemDO>();
            MedSrvRisDO[] ris = service.find(string.Format("a2.id_srv='{0}'", id_srv), "", false);//调用此服务报错
            ris.ToList().ForEach(p => list.Add(
                new EmsObsItemDO 
                {
                    Id_body = p.Id_body,
                    Sd_body = p.Sd_body,
                    Id_pos = p.Id_pos,
                    Sd_pos = p.Sd_pos,
                    
                    Name_body = p.Name_body,
                    Name_pos = p.Name_pos,
                    Name_srv = p.Srv_name
                }
                ));
            return list;
        }

        /// <summary>
        /// 检查的 ci_or_srv 的数据
        /// </summary>
        /// <param name="agg"></param>
        /// <param name="status"></param>
        /// <param name="emsHeadDO"></param>
        /// <param name="srvList"></param>
        public void SetCiORSrv(CiorderAggDO agg, EmsUIDTO emsHeadDO, List<OrdSrvDO> srvList)
        {
            int i = 1;

            XapDataList<EmsObsLap> list = emsHeadDO.Emsapobs.EmsOrObsList;
            foreach (EmsObsLap p in list)
            {
                
         
                //把检查的项目 对照成服务
                OrdSrvDO srv = new OrdSrvDO();
                if (emsHeadDO.Status == DOStatus.UPDATED)
                    //srv = agg.getOrdSrvDO()[emsHeadDO.Emsdrugs.EmsOrDrugList.IndexOf(p)];
                    srv = agg.getOrdSrvDO().FirstOrDefault(x => x.Id_orsrv == p.Id_srv);//找到数据库已经存在的
                if (srv == null)//数据库找不到 可能是修改时候 新增了 药品
                {
                    srv = new OrdSrvDO();
                }
                srv.Id_pat = emsHeadDO.PatInfo.Id_pat;//患者
                srv.Id_entp = emsHeadDO.PatInfo.Id_entp; //就诊类型
                srv.Code_entp = emsHeadDO.PatInfo.Code_entp;//就诊类型编码
                srv.Id_en = emsHeadDO.PatInfo.Id_ent;//就诊
                srv.Sortno = i;//TODO: 顺序应该是机制生成的 
                srv.Id_srvtp = emsHeadDO.MedSrvDO.Id_srvtp;//	服务类型
                srv.Sd_srvtp = emsHeadDO.MedSrvDO.Sd_srvtp;//服务类型编码
                srv.Id_srv = emsHeadDO.MedSrvDO.Id_srv;//服务项目
                srv.Name = emsHeadDO.Emsapobs.Name_srv;//服务项目名称
                srv.Name = p.Name_srv;
                agg.getParentDO().Dt_entry = emsHeadDO.Emsapobs.Dt_plan;//每条检查 不同的属性再进行独立赋值
                srv.Name = p.Name_srv;
                agg.getParentDO().Dt_entry = emsHeadDO.Emsapobs.Dt_plan;
                agg.getParentDO().Dt_stop = emsHeadDO.Emsapobs.Dt_plan;
                agg.getParentDO().Dt_effe = emsHeadDO.Emsapobs.Dt_plan;
                //agg.getParentDO().Content_or = cof.GetOrDes(emsHeadDO, emsType);
                //待完善
                srvList.Add(srv);
                i++;
            }
        }
    }
}

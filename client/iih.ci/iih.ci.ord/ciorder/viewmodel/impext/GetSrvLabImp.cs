using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.bc.udi;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.medsrv.i;
using iih.ci.ord.cior.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using xap.mw.core.data;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.rui.control.extentions;
using iih.ci.ord.ciorder.utils;

namespace iih.ci.ord.ciorder.viewmodel.impext
{
      public class GetSrvLabImp
    {
           IMedSrvLisDOCrudService service;

        public GetSrvLabImp()
        {
            this.service = XapServiceMgr.find<IMedSrvLisDOCrudService>();
        }

        public XapDataList<EmsObsItemDO> getLabImplList(EmsUIDTO headDO, MedsrvAggDO[] medsrvagg)
          {
              XapDataList<EmsObsItemDO> list = new XapDataList<EmsObsItemDO>();
              if (medsrvagg != null && medsrvagg.Length > 0 )
              {
                  int i = 1;
                foreach (MedsrvAggDO medsrvAgg in medsrvagg)
                {
                    EmsObsItemDO labItem = new EmsObsItemDO();


                    headDO.Emsaplab.Name_samptp = medsrvAgg.getMedSrvLisDO()[0].Samptp_name;
                    headDO.Emsaplab.Id_samptp = medsrvAgg.getMedSrvLisDO()[0].Samptp_code;
                    headDO.Emsaplab.Id_srv = medsrvAgg.getParentDO().Id_srv;
                    headDO.Emsaplab.Id_srvtp = medsrvAgg.getParentDO().Id_srvtp;
                    headDO.Emsaplab.Name_srv = medsrvAgg.getParentDO().Name;
                    headDO.Emsaplab.Des_sympsign = medsrvAgg.getMedSrvLisDO()[0].Note;
                    headDO.Emsaplab.Des_sympsign = medsrvAgg.getMedSrvLisDO()[0].Note;

                    labItem.Name_srv = medsrvAgg.getParentDO().Name;
                    labItem.Des_sympsign = medsrvAgg.getParentDO().Note;
                    headDO.Emsaplab.Des_sympsign = medsrvAgg.getParentDO().Note;
                    labItem.Sortno = i;
                    i++;
                    list.Add(labItem);

                }

            }
            return list;
          }


        public void SetCiORSrv(CiorderAggDO agg, EmsUIDTO emsHeadDO, List<OrdSrvDO> srvList)
        {
            int i = 1;
            //emsHeadDO.Emsaplab.EmsOrObsList
            emsHeadDO.Emsaplab.EmsOrObsList.ToList().ForEach(p =>
            {
                //把检查的项目 对照成服务
                OrdSrvDO srv = new OrdSrvDO();
                if (emsHeadDO.Status == DOStatus.UPDATED)
                    //srv = agg.getOrdSrvDO()[emsHeadDO.Emsdrugs.EmsOrDrugList.IndexOf(p)];
                    //srv = agg.getOrdSrvDO().First(x => x.Id_orsrv == p.Id_orsrv);//找到数据库已经存在的
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
                srv.Name = emsHeadDO.Emsaplab.Name_srv;//服务项目名称
                srv.Name = p.Name_srv;

                //agg.getParentDO().Content_or = LogicEx.GetInstance().GetOrDes(emsHeadDO);
                agg.getParentDO().Dt_entry = emsHeadDO.Emsaplab.Dt_plan;//每条检查 不同的属性再进行独立赋值
                srv.Name = p.Name_srv;
                agg.getParentDO().Dt_entry = emsHeadDO.Emsaplab.Dt_plan;
                agg.getParentDO().Dt_stop = CommonExtentions.NowTime(this);
                agg.getParentDO().Dt_effe =   CommonExtentions.NowTime(this);
                //agg.getParentDO().Content_or = emsHeadDO.Emsaplab.Name_samptp;
                //待完善
                srvList.Add(srv);
                i++;
            });
        }

        public XapDataList<EmsObsLap> GetLabImpList(EmsUIDTO headDO, MedSrvDO med)
          {

              XapDataList<EmsObsLap> list = new XapDataList<EmsObsLap>();
              MedSrvLisDO[] srvlis = service.find(string.Format("a1.id_srv='{0}'", med.Id_srv), "", false); //调用此服务报错
              if (srvlis != null && srvlis.Count() > 0)
              {
                  int i = 1;
                  foreach (MedSrvLisDO lis in srvlis)
                  {
                      EmsObsLap lab = new EmsObsLap();
                      lab.Id_srv = lis.Id_srv;
                      lab.Sd_contp = lis.Sd_contp;
                      lab.Id_contp = lis.Id_contp;
                      lab.Id_labgroup = lis.Id_labgroup;
                      lab.Sd_labgroup = lis.Sd_labgroup;
                      lab.Name_srv = med.Name;
                      lab.Id_srvca = med.Id_srvca;
                      //lab.Dt_plan = headDO.Dt_begin_ui;
                      //lab.Id_pps = lis.Id_pps;
                      //lab.Sd_pps = lis.Sd_pps;
                      //lab.Des_pps = lis.Des_pps;
                      lab.Sd_srvtp = med.Sd_srvtp;
                      lab.Id_su_obs = CiDictCodeConst.ID_CI_LAB_SQ;
                      lab.Sd_su_obs = CiDictCodeConst.SD_CI_LAB_SQ;
                      lab.Fg_or = med.Fg_or;
                      lab.Eu_blmd = med.Eu_blmd;
                      lab.Des_sympsign = lis.Des_labsamp;
                      lab.Announcements = lis.Note;//注意事项
                      lab.Fg_urgent = headDO.Emsaplab.Fg_urgent;
                      lab.Sd_samptp =lis.Sd_samptp;
                      lab.Id_samptp = lis.Id_samptp;
                      headDO.Emsaplab.Id_samptp = lis.Id_samptp;
                      headDO.Emsaplab.Sd_samptp = lis.Sd_samptp;
                      headDO.Emsaplab.Name_samptp = lis.Samptp_name;
                      headDO.Emsaplab.Id_sampcoltime = lis.Id_sampcoltime;//标本采集时间id
                      headDO.Emsaplab.Name_sampcoltime = lis.Name_sampcoltime;//标本采集时间名称
                      headDO.Emsaplab.Id_sampcollecttimetp = lis.Id_sampcollecttimetp;//标本采集时间类型
                      headDO.Emsaplab.Sd_sampcollecttimetp = lis.Sd_sampcollecttimetp;//标本采集时间类型编码
                      headDO.Emsaplab.Len_sampcoltime = lis.Len_sampcoltime;//标本采集时长
                      headDO.Emsaplab.Id_unit_sampcoltime = lis.Id_unit_sampcoltime;//标本采集时间时长单位
                      lab.Quan = lis.Quan;
                      lab.Id_quan = lis.Id_unit_quan;
                     // lab.Id_medu = lis.Id_unit_nuit;
                      lab.Quan_medu = med.Quan_med;
                      lab.Id_medu = med.Id_unit_med;
                      lab.Sd_colltp = lis.Sd_colltp;
                      lab.Id_colltp = lis.Id_colltp;
                      lab.Des_labsamp = lis.Des_labsamp;
                      lab.Fg_bl = med.Fg_bl;//zwq 2016-08-22
                      lab.Fg_chk = true;//新增时默认全部选中，2016-6-25
                      lab.Sv = lis.Sv;
                      lab.Sortno = i + "";
                      list.Add(lab);
                      i++;
                  }
                   
              }
              return list;
          }

          public MedSrvLisDO GetLabById(string id)
          {
              return this.service.findById(id);
          }
    }
}

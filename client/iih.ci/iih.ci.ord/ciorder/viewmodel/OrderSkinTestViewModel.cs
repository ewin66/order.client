using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.skintest.i;
using xap.mw.serviceframework;
using iih.ci.ord.skintest.d;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.ord.ciorder.d;
using xap.cli.context;
using iih.en.pv.inpatient.dto.d;

namespace iih.ci.ord.ciorder.viewmodel
{
    public class OrderSkinTestViewModel
    {
        ISkintestCrudService service;
        public OrderSkinTestViewModel()
        {
            service = XapServiceMgr.find<ISkintestCrudService>();
        }

        GetSrvSetImp srvSet = new GetSrvSetImp();

        //zzj
        //OrderSrvSetViewModel srvSetVM = new OrderSrvSetViewModel();

        //public CiorderAggDO GetSkinTestAgg(string id_mm, PatientsDTO patDo)
        //{
        //    CiorderAggDO agg = new CiorderAggDO();
        //    string id_srv = srvSet.GetSrvSetId(id_mm);

        //    MedSrvDO srv = new OrderSrvListViewModel("").GetSrvById(id_srv);//获取皮试服务
        //    List<MedSrvDO> srvList = srvSet.GetInSetSrv(id_srv);//根据服务套id 获取皮试服务套内 服务
        //    FillPatientDo(agg, srv,patDo);//填充主DO
        //    FillOrSrvDO(agg, srvList,patDo);//填充医嘱服务DO

        //    return agg;
        //}
        //private void FillPatientDo(CiorderAggDO agg, MedSrvDO srv, PatientsDTO patDo)
        //{
        //    CiOrderDO cior = new CiOrderDO();

        //    agg.setParentDO(srvSetVM.FillOrDO(srv, patDo));
        //}
        //private void FillOrSrvDO(CiorderAggDO agg, List<MedSrvDO> srvList, PatientsDTO patDo)
        //{
        //    List<OrdSrvDO> srvs = srvSetVM.FillOrSrv(srvList, null);
        //    agg.setOrdSrvDO(srvs.ToArray());
        //}


        //public List<OrdSrvDO> GetSkinSrvItem(string id_mm)
        //{
        //    //根据物品id 获取服务关联的 皮试服务
        //    string id_srv = srvSet.GetSrvSetId(id_mm);

        //    List<MedSrvDO> srvList = srvSet.GetInSetSrv(id_srv);//根据服务套id 获取皮试服务套内 服务
        //    return new OrderSrvSetViewModel().FillOrSrv(srvList, null);


        //    //！！！！！！如果 皮试液关联的有费用信息，还要吧费用信息生成一条srv 存到or_srv 表
        //    //原液皮试与皮试液的区别 原液不需要 收费，不要插入收费服务
        //    //     if (srvList.Count>0)
        //    //{


        //    //      MedSrvDO srv=srvList[0];
        //    //      CiorderAggDO agg = new CiorderAggDO();
        //    //      CiOrderDO PatientDo = new CiOrderDO();
        //    //      OrdSrvDO orSrv = new OrdSrvDO();
        //    //      agg.ParentDO = PatientDo;
        //    //      agg.setOrdSrvDO(new OrdSrvDO[] { orSrv });
        //    //      //srv 对照 patient ,srvskin 对照 orSrv
        //    //      //PatientDo.Name_or = srv.Name;




        //    //      CiorderAggDO backAgg = new OrderSaveViewModel().SaveAgg(agg)[0];
        //    //      string id_or = backAgg.getParentDO().Id_or;
        //    //     }
        //}

        public void AddSkinResult(CiorderAggDO backAgg)
        {
            CiOrderDO or = backAgg.getParentDO();
            //插入皮试结果表一条数据
            service.save(new CiSkinTestRstDO[] {
              new CiSkinTestRstDO { 
              Id_or = or.Id_or,
              Createdby = UserManager.getInstance().CurrentUser.Id_user,
              Createdtime = UserManager.getInstance().CurrentUser.Createdtime } });

        }
        ////拒绝皮试
        //public void dd(string txt)
        //{
        //    service.save(new CiSkinTestRstDO[] { new CiSkinTestRstDO { Id_or = "", Sd_rst_skintest="", Createdby = UserManager.getInstance().CurrentUser.Id_user, Createdtime = UserManager.getInstance().CurrentUser.Createdtime } });

        //}
        //public List<CiSkinTestRstDO> GetSkinTest(string skin_res )
        //{
        //    return new List<CiSkinTestRstDO>{   new CiSkinTestRstDO { 
        //      //Id_or = or.Id_or,
        //       Sd_rst_skintest=skin_res,
        //      Createdby = UserManager.getInstance().CurrentUser.Id_user,
        //      Createdtime = UserManager.getInstance().CurrentUser.Createdtime }};
        //}













    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using xap.mw.serviceframework;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.pres.i;
using iih.ci.ord.pres.d;
using xap.mw.core.data;
using xap.cli.context;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.dto.OrderPresSplitDTO.d;
using iih.ci.ord.i;
using xap.rui.appfw;
using xap.rui.control.extentions;

namespace iih.ci.ord.ciorder.viewmodel
{
    /// <summary>
    /// 处方
    /// </summary>
    /// Author:admin
    /// Date:2015-08-28
   public  class OrderPresViewModel
    {
        IPresCrudService service;
        private ICiOrdQryService orderQryservice;

        protected XapDataList<OrderPresSplitDTO> orderPresSplitDTO;
        //CiPresDO ciPresDO;
        public OrderPresViewModel(string id_en)
        {
            service = XapServiceMgr.find<IPresCrudService>();
            orderQryservice = XapServiceMgr.find<ICiOrdQryService>();

            this.init(id_en);

        }

       protected virtual void init(string id_en)
        {
            this.orderPresSplitDTO = GetOrPresDTOs(id_en);
        }

       protected virtual OrderPresSplitDTO[] GetOrPresDTOs(string id_en)
        {
            OrderPresSplitDTO[] tmpOrderPresSplitDTO = orderQryservice.getOrPresDTOs(id_en);

            foreach (OrderPresSplitDTO presSplitDto in tmpOrderPresSplitDTO)
            {
                if (presSplitDto.Fg_hp_pres.Equals("Y"))
                {
                    presSplitDto.Name_fg_hp = "医保";
                }else if (presSplitDto.Fg_hp_pres.Equals("N"))
                {
                    presSplitDto.Name_fg_hp = "非医保";
                }

                switch (presSplitDto.Sd_prestp)
                {
                    case "00":
                        presSplitDto.Name_prestp = "毒麻精一";
                        break;
                    case "01":
                        presSplitDto.Name_prestp = "毒麻精二";
                        break;
                    case "02":
                        presSplitDto.Name_prestp = "受控处方";
                        break;
                    case "03":
                        presSplitDto.Name_prestp = "儿科普通西药";
                        break;
                    case "04":
                        presSplitDto.Name_prestp = "儿科成药";
                        break;
                    case "05":
                        presSplitDto.Name_prestp = "急诊普通西药";
                        break;
                    case "06":
                        presSplitDto.Name_prestp = "急诊成药";
                        break;
                    case "07":
                        presSplitDto.Name_prestp = "草药";
                        break;
                    case "08":
                        presSplitDto.Name_prestp = "普通西药";
                        break;
                    case "09":
                        presSplitDto.Name_prestp = "成药";
                        break;
                }
            }

            return tmpOrderPresSplitDTO;
        }

       public object getOrderPresSplitList()
       {
           return orderPresSplitDTO;
       }

       #region 未被使用过
       public OrderPresViewModel()
        {
            service = XapServiceMgr.find<IPresCrudService>();
            orderQryservice = XapServiceMgr.find<ICiOrdQryService>();
        

        }


        //新增处方 时候  患者的一些信息 要获取
        public CiPresDO[] Save(CiPresDO presDO)
        {
            return service.save(new CiPresDO[] { presDO });
        }

        /* 首先 读取 该患者现有所有医嘱服务
         * 然后为不通类型医嘱统计数量
         * 每个类型的 4个医嘱 生成一个 处方 存入处方表
         * 然后去处方表 找到刚存入的处方，找到自动生成 的 处方id
         * 然后把处方id 写回到医嘱服务表
         * 
         * 
         * 
         * */

        public CiPresDO[] GetPresBypatId(string id_pat)
        {
            if (string.IsNullOrEmpty(id_pat))
            {
                return null;
            }
            CiPresDO[] ciPresDOs = service.find(string.Format("id_pati='{0}'", id_pat), "", false);
            return ciPresDOs;
        }

        /// <summary>
        /// Gets the门诊处方列表
        /// </summary>
        /// <param name="id_pat">The id_pat.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-09-07
        public List<OpPresList> GetPresListBypatId(string id_pat)
        {
            List<OpPresList> list = new List<OpPresList>();
            if (string.IsNullOrEmpty(id_pat))
            {
                return list;
            }

            CiPresDO[] ciPresDOs = service.find(string.Format("id_pati='{0}'", id_pat), "", false);
            
            ciPresDOs.ToList().ForEach(p =>
            {
                OrdSrvDO[] ciSrvs = modelSrv.GetSrvsByIdPres(p.Id_pres);
                ciSrvs.ToList().ForEach(x =>
                {
                    list.Add(new OpPresList
                    {
                        Name_prestp = p.Prestp_name="普通",
                        Pres_no = ciPresDOs.ToList().IndexOf(p)+1,
                        //Fg_skintest = x.fg,
                        Order_des = GetOrdDes(x),//医嘱内容
                        Name_dep_mp = x.Dep_mp_name,//开立科室
                        Name_emp_phy = x.Emp_name="王文刚"//开立医生
                    });
                });
            });




            return list;
        }
        OrderSrvViewModel modelSrv = new OrderSrvViewModel();
        Random ran = new Random();
        public string GetOrdDes(OrdSrvDO srvDo)
        {
            string des = srvDo.Name + "" + srvDo.Quan_medu + "" + srvDo.Medu_name;
            des += "\n" + srvDo.Route_name + "" + srvDo.Freq_name;

            return des;
        }
        public void CreatPres(string id_pat)
        {
            //TODO:执行之前 只针对未设置处方的，只生成新的处方，不进行修改，暂时只是按照 分类进行分方，并没有对每个方子里的条数 进行限制
            OrdSrvDO[] orderSrvs = modelSrv.GetSrvs(id_pat);//代表已经获取该患者的所有医嘱服务 参数 患者id
            //分组 医嘱服务

            var v = from c in orderSrvs
                    group c by new
                    {
                        SD_SRVTP = c.Sd_srvtp
                    } into s
                    select new
                    {
                        SD_SRVTP = s.Select(p => p.Sd_srvtp).First(),
                        ordSrvCount = s.Select(p => p.Sd_srvtp).Count()

                    };

            v.ToList().ForEach(p =>
            {
                OrdSrvDO srvtem = orderSrvs.First(t => t.Sd_srvtp == p.SD_SRVTP);
                string ci_code = "PRES" + CommonExtentions.NowTime(this).Year + CommonExtentions.NowTime(this).Month + CommonExtentions.NowTime(this).Day + CommonExtentions.NowTime(this).Hour + CommonExtentions.NowTime(this).Minute + CommonExtentions.NowTime(this).Second + CommonExtentions.NowTime(this).Millisecond + ran.Next(0, 100);//code 生成机制
                CiPresDO ci = new CiPresDO()
                {
                    //-此为处方所有字段，用到那个 解开注释加哪个
                    Id_pati = srvtem.Id_pat,
                    Id_entp = srvtem.Id_entp,// "0001AA10000000004O80",//TODO: 临时数据,
                    Code_entp = srvtem.Code_entp,// "01",
                    Id_en = srvtem.Id_en, //"0001AA1000000001OM3N",//TODO: 临时数据,
                    Id_di = "患者的诊断",//患者诊断,
                    //Id_diitm,
                    //Str_id_di,
                    //Str_name_di,
                    Id_srvtp = srvtem.Id_srvtp,
                    Sd_srvtp = p.SD_SRVTP,//服务类型编码,
                    Id_prestp = "01",//TODO:处方类型 后面改正
                    Sd_prestp = p.SD_SRVTP,
                    Code = ci_code,
                    Name = srvtem.Id_pat + "处方",
                    Id_dep_or = UserManager.getInstance().CurrentDept.Id_dep,//开立科室
                    Id_emp_or = UserManager.getInstance().CurrentUser.Id_user,//开立医生
                    Dt_entry = CommonExtentions.NowTime(this),//开立日期
                    //Fg_bb,
                    //No_bb,
                    //Id_bb,
                    Id_route = srvtem.Id_route,//用法,
                    Id_routedes = srvtem.Id_routedes,
                    //Id_boil,
                    //Id_boildes,
                    //Fg_charge,
                    Fg_dispense = false,//发药标识,
                    //Id_backtp,
                    //Sd_backtp,
                    //Fg_back,
                    //Id_emp,
                    //Fg_prn,
                    //Fg_prn_add,
                    //Id_pres_rel_add,
                    Id_su_bl = "1",//TODO：记账状态 先假数据
                    Sd_su_bl = "1",//记账状态,
                    //Fg_makeup,
                    Createdby = UserManager.getInstance().CurrentUser.Createdby,
                    Createdtime = UserManager.getInstance().CurrentUser.Createdtime,
                    Modifiedby = UserManager.getInstance().CurrentUser.Modifiedby,
                    Modifiedtime = UserManager.getInstance().CurrentUser.Modifiedtime,
                    //Ds,
                    //Sv

                };
                string id_pres = Save(ci)[0].Id_pres;
                orderSrvs.ToList().ForEach(x =>
                {
                    if (x.Sd_srvtp == p.SD_SRVTP)
                    {
                        x.Id_pres = id_pres;
                        x.Status = DOStatus.UPDATED;
                    }
                });
            });

            //所有的医嘱单已经生成完毕 更新srv

            modelSrv.Save(orderSrvs);



        }

       #endregion
    }

}

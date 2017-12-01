//using System;
//using System.Collections.Generic;
//using System.Linq;
//using System.Text;
//using System.ComponentModel;
//using iih.bd.bc.udi;
//using iih.bd.srv.medsrv.d;
//using iih.ci.ord.ciorder.d;
//using iih.en.pv.inpatient.dto.d;
//using iih.ci.ord.ciorder.viewmodel.impext;
//using iih.ci.ord.ciordems.d;
//using iih.ci.ord.ordsrvset.d;
//using iih.ci.ord.ordsrvset.i;
//using xap.mw.serviceframework;

//namespace iih.ci.ord.ciorder.viewmodel
//{
//    class OrderSrvSetViewModel
//    {
//        IOrdsrvsetCrudService service;
//        List<OrdSrvSetDO> ordSet = new List<OrdSrvSetDO>();
//        GetSrvSetImp srvSetVM = new GetSrvSetImp();
//        public OrderSrvSetViewModel()
//        {
//             service = XapServiceMgr.find<IOrdsrvsetCrudService>();
//        }

//        public void Save(OrdSrvSetDO[] orSrvItems)
//        {
//            service.save(orSrvItems);
//        }

//        public List<OrdSrvDO> GetSetItem(string  id_srv, PatientsDTO pat)
//        {
//            List<OrdSrvDO> list = new List<OrdSrvDO>();

//            List<MedSrvDO>  srvList= new GetSrvSetImp().GetInSetSrv(id_srv);
//            List<MedSrvSetItemDO> srvSetItem = srvSetVM.GetItemInSet(id_srv);

//            foreach (MedSrvSetItemDO item in srvSetItem)
//            {
//                MedSrvDO srv = new OrderSrvListViewModel("").GetSrvById(item.Id_srv);
//                OrdSrvDO orSrv = FillOrSrv(srv, pat);
//                orSrv.Pri = SrvSetItemPrice(srv, item);//获取价格
//                list.Add(orSrv);
//            }

//            //foreach (MedSrvDO item in srvList)//这样做就是为了一个 定价模式里的参考价格 
//            //{
//            //    OrdSrvDO orSrv=FillOrSrv(item, pat);
//            //    orSrv.Pri= SrvSetItemPrice(item, pat );//获取价格
//            //    list.Add(orSrv);
//            //}
//            return list;
 
//        }
//        /// <summary>
//        /// 获取要存入医嘱服务套表的 数据集合
//        /// </summary>
//        /// <returns></returns>
//        /// Author:admin
//        /// Date:2015-09-30
//        public List<OrdSrvSetDO> GetordSrvSets()
//        {
//            return ordSet;
//        }

       
//        void AddOrdSet()
//        {

//        }
//        /// <summary>
//        /// 获取参考价格时候 顺便增加 医嘱set表数据
//        /// </summary>
//        /// <param name="srv">The SRV.</param>
//        /// <param name="pat">The pat.</param>
//        /// <returns></returns>
//        /// Author:admin
//        /// Date:2015-09-29
//        public double SrvSetItemPrice(MedSrvDO srv,MedSrvSetItemDO setItem)
//        {
//            //服务套逻辑放到后台是不是更合理一点
//            /*
//             * 根据服务查询物品时候 ，顺便判断这个服务是不是 服务套，是服务套，走服务套逻辑
//             * 
//             */
//           double price=0;
//            GetprimdPriceImp pri = new GetprimdPriceImp();
//            //if (srv.Fg_set.Value)//如果是服务套
//            //{



//                //1、	当服务套的开立方式 
//                //ss.Where()
//                //判断服务套的开立方式
//            if (srv.Id_setord == BdSrvDictCodeConst.SD_SETORD_OR)//医嘱模式
//                {
//                    //服务套定价模式
//                    if (srv.Id_primd == "1")//成员合计价
//                    {
//                        //  a、调‘付款策略.本服务定价’接口； return（参考价格）。
//                         price = pri.GetPrice(srv.Id_srv);
//                        //b、将服务项目信息存到OR_SRV表里①。
//                        //c、OR_SRV_SET不存信息。


//                    }
//                    else if (srv.Id_primd == "2")//成员项目个数定价
//                    {
//                        /*
//                          获取当前录入画面上，套内项目一共选择了多少个(前端用户选择的检验项目，算出个数)，
//                         *调‘付款策略.套成员项目个数定价’接口，获取到收费srv，和参考价格。
//                          将收费srv、参考价格存在OR_SRV表⑦。
//                          画面上选择的套内项目，存OR_SRV_SET表⑧。
//                         */

//                        //需要存到医嘱套的，只要增加这句话
//                        ordSet.Add(FillOrSrvSet(setItem));

//                    }
//                    else if (srv.Id_primd == "3")//部位加收
//                    {
//                        //MedSrvSetItemDO setItem = new MedSrvSetItemDO();//套内项目
//                        if (!setItem.Fg_body.Value)//部位标识
//                        {
//                            //调‘付款策略.本服务定价’接口，获取到每个服务项目的参考价格
//                            //获取到参考价格后，srv存OR_SRV表②；
//                        }
//                        else if (setItem.Fg_body.Value && !setItem.Fg_body_bl.Value)
//                        {
//                            // 调‘付款策略.本服务定价’接口，获取到每个服务项目的参考价格
//                            //获取到参考价格后，srv存OR_SRV表③；同时将套内srv存OR_SRV_SET表④；
//                            ordSet.Add(FillOrSrvSet(setItem));
//                        }
//                        else if (setItem.Fg_body.Value && setItem.Fg_body_bl.Value)
//                        {
//                            //  获取部位srv项目的数量，调‘付款策略.部位个数加收’接口，获取到部位srv对应的收费srv、收费srv的参考价格
//                            //获取到参考价格、和付款策略返回的价格SRV存OR_SRV表⑤；同时将套内srv存OR_SRV_SET表⑥。
//                            ordSet.Add(FillOrSrvSet(setItem));
//                        }
//                        /*
//                         * 
//                         *  套内‘srv.部位=false’的srv，获取到参考价格后，srv存OR_SRV表②；
//                           套内‘srv.部位=ture、&部位srv.加收标志=false’的srv，获取到参考价格后，srv存OR_SRV表③；同时将套内srv存OR_SRV_SET表④；
//                           套内‘srv.部位=ture、& srv.加收标志=ture’的srv，获取到参考价格、和付款策略返回的价格SRV存OR_SRV表⑤；同时将套内srv存OR_SRV_SET表⑥。
//                                参考价格获取逻辑：
//                           if（srv.部位=false）{
//                              调‘付款策略.本服务定价’接口，获取到每个服务项目的参考价格
//                           }
//                           if（srv.部位=ture、& srv.加收标志=false）{         
//                              调‘付款策略.本服务定价’接口，获取到每个服务项目的参考价格
//                           } 
//                           if（srv.部位=ture、& srv.加收标志=ture）{
//                              获取部位srv项目的数量，调‘付款策略.部位个数加收’接口，获取到部位srv对应的收费srv、收费srv的参考价格
//                         * */
//                    }
//                }
//                else if (srv.Id_setord == BdSrvDictCodeConst.SD_SETORD_SRV)//服务模式
//                {
//                    //  服务套SRV存CI_OR表；
//                    //服务套SRV存CI_OR_SRV表；
//                    //套内明细SRV存CI_OR_SRV_SET表；

//                    ordSet.Add(FillOrSrvSet(setItem));

//                }
//            else if (srv.Id_setord == BdSrvDictCodeConst.SD_SETORD_SRVSET)//服务组合模式
//                {



//                }
//                return price;
//            //}
//        }

//        /// <summary>
//        /// 将medsrv 对照成 医嘱 主表do
//        /// </summary>
//        /// <param name="srvSet">The SRV set.</param>
//        /// <param name="pat">The pat.</param>
//        /// <returns></returns>
//        /// Author:admin
//        /// Date:2015-09-29
//       public CiOrderDO FillOrDO(MedSrvDO srvSet, PatientsDTO pat)
//        {
//            CiOrderDO or = new CiOrderDO
//            {


//                //Id_or,
//                //Id_grp,
//                //Id_org,
//                //Id_pat,
//                //Id_en,
//                //Id_entp,
//                //Code_entp,
//                Id_srvtp = srvSet.Id_srvtp,
//                //Sd_srvtp,
//                //Id_srv_set,
//                //Id_srv_pkg,
//                //Fg_long,
//                //Code_or,
//                //Des_or = srvSet.Name,
//                Des_or = "皮试医嘱测试",
//                Id_freq = srvSet.Id_freq,
//                //Orders,
//                //Fg_boil,
//                //Orders_boil,
//                //Id_route,
//                //Id_routedes,
//                //Id_boil,
//                //Id_boildes,
//                //Days_or,
//                //Id_su_or,
//                //Sd_su_or,
//                //Id_su_mp,
//                //Sd_su_mp,
//                //Id_su_bl,
//                //Sd_su_bl,
//                //Id_org_or,
//                //Id_dep_or,
//                //Id_wg_or,
//                //Id_emp_or,
//                //Dt_entry,
//                //Fg_sign,
//                //Id_emp_sign,
//                //Id_dep_sign,
//                //Dt_sign,
//                //Dt_effe,
//                //Dt_invalid,
//                //Fg_chk,
//                //Id_emp_chk,
//                //Id_dep_chk,
//                //Dt_chk,
//                //Fg_stop,
//                //Id_emp_stop,
//                //Id_dep_stop,
//                //Dt_stop,
//                //Fg_chk_stop,
//                //Id_emp_chk_stop,
//                //Id_dep_chk_stop,
//                //Dt_chk_stop,
//                //Fg_canc,
//                //Id_emp_canc,
//                //Id_dep_canc,
//                //Dt_canc,
//                //Fg_chk_canc,
//                //Id_emp_chk_canc,
//                //Id_dep_chk_canc,
//                //Dt_chk_canc,
//                //Fg_pmor,
//                //Des_pmor,
//                //Fg_active_pm,
//                //Id_reltp,
//                //Sd_reltp,
//                //Id_or_rel,
//                //Fg_bb,
//                //No_bb,
//                //Fg_ctlcp,
//                //Fg_mr,
//                //Fg_skintest,
//                //Fg_mp_in,
//                //Times_mp_in,
//                //Fg_mp_bed,
//                //Note_or,
//                //Createdby,
//                //Createdtime,
//                //Modifiedby,
//                //Modifiedtime,
//                //Ds,
//                //Sv

//            };

//            return or;
 
//        }




//       public OrdSrvDO FillOrSrv(MedSrvDO srv, PatientsDTO pat)
//       {
//           OrdSrvDO orSrv = new OrdSrvDO
//           {
//               //Id_orsrv,
//               //Id_or,
//               //Id_pres,
//               //Id_pat = pat.Id_pat,
//               //Id_entp,
//               //Code_entp,
//               //Id_en = pat.Id_ent,
//               //Sortno,
//               Id_srvtp = srv.Id_srvtp,
//               Sd_srvtp = srv.Sd_srvtp,
//               Id_srv = srv.Id_srv,
//               Name = srv.Name,
//               //Fg_dose_anoma,
//               //Quan_medu,
//               //Id_medu,
//               Id_route = srv.Id_route,
//               Id_routedes = srv.Id_routedes,
//               //Id_boil,
//               //Id_boildes,
//               //Id_freq,
//               //Id_org_srv,
//               //Id_dep_srv,
//               //Id_wg_or,
//               //Id_emp_srv,
//               //Id_org_mp,
//               //Id_dep_mp,
//               //Id_su_mp,
//               //Sd_su_mp,
//               //Id_su_bl,
//               //Sd_su_bl,
//               //Dt_last_mp,
//               //Dt_last_bl,
//               //Fg_or,
//               //Eu_blmd,
//               //Fg_mm,
//               //Pri,
//               //Fg_set,
//               //Fg_indic,
//               //Fg_propc,
//               //Fg_self,
//               //Fg_pres_outp,
//               //Note_srv,
//               //Ds,
//               //Sv



//           };
//           return orSrv;
//       }
//        /// <summary>
//        /// 套内项目转化为 医嘱服务 集合  
//        /// </summary>
//        /// <param name="srvSets">The SRV sets.</param>
//        /// <param name="pat">The pat.</param>
//        /// <returns></returns>
//        /// Author:admin
//        /// Date:2015-09-26
//        public List<OrdSrvDO> FillOrSrv(List<MedSrvDO> srvSets, PatientsDTO pat)
//        {
//            List<OrdSrvDO> listSrv = new List<OrdSrvDO>();
//            foreach (MedSrvDO item in srvSets)
//            {
//                listSrv.Add(FillOrSrv(item,pat));
//            }
//            //服务套的保存逻辑应该是 在新增保存时候 ，把套内项目都放到 or_srv 里一快保存了，不应该单独提出来
//            return listSrv;

//        }


//        public OrdSrvSetDO FillOrSrvSet(MedSrvDO srvSet, PatientsDTO pat)
//        {
//            OrdSrvSetDO set = new OrdSrvSetDO
//            {
//                   //Id_orsrvset,//主键
//                   //Id_orsrv,//套id
//                   //Id_srvsetdef,
//                   //Id_srvset,
//                   //Sortno,
//                   Des_srv="测试医嘱服务套",
//                   //Id_srvsetrole,
//                   //Sd_srvsetrole,
//                   //Id_medu,
//                   //Quan_medu,
//                   //Id_freqdef,
//                   //Ds,
//                   //Sv


//            };
//            return set;
//        }

//        /// <summary>
//        /// F将服务套转为医嘱服务套
//        /// </summary>
//        /// <param name="srvSet">The SRV set.</param>
//        /// <param name="pat">The pat.</param>
//        /// <returns></returns>
//        /// Author:admin
//        /// Date:2015-09-30
//        public OrdSrvSetDO FillOrSrvSet(MedSrvSetItemDO srvSet)
//        {
//            OrdSrvSetDO set = new OrdSrvSetDO
//            {
//                //Id_orsrvset,//主键
//                //Id_orsrv,//医嘱套服务id
//                Id_srvsetdef=srvSet.Id_srvsetdef,
//                Id_srvset=srvSet.Id_srv_set,
//                Sortno=srvSet.Sortno,
//                Des_srv = "测试医嘱服务套",
//                Id_srvsetrole = srvSet.Id_srvsetrole,
//                Sd_srvsetrole = srvSet.Sd_srvsetrole,
//                Id_medu = srvSet.Id_medu,
//                Quan_medu = srvSet.Quan_medu,
//                Id_freqdef=srvSet.Id_freq,
//                //Ds,
//                //Sv


//            };
//            return set;
//        }

//    }
//}

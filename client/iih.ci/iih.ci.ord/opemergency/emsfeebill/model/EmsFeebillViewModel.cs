
using iih.bl.hp.bdhpindicationdto.d;
using iih.ci.iih.ci.ord.dto.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.ord.ems.d;
using iih.ci.ord.emsdi.d;
using iih.ci.ord.i;
using iih.ci.ord.opemergency.ems.dp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;
using xap.mw.serviceframework;
using xap.rui.appfw;
using iih.ci.ord.opemergency.ems.common;

namespace iih.ci.ord.opemergency.emsfeebill.model
{
    /// <summary>
    /// <para>描    述 :  医疗单费用模型                   			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.emsfeebill.model    </para>    
    /// <para>类 名 称 :  EmsFeebillViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  1/10/2017 7:20:37 PM             </para>
    /// <para>更新时间 :  1/10/2017 7:20:37 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class EmsFeebillViewModel : BaseBizViewModel
    {
        #region 变量
        private CiEmsDTO ciEmsDto = null;
        private XapDataList<CiOrdFeeSrvDTO> tableDataSource = new XapDataList<CiOrdFeeSrvDTO>();
        private ICiOrdQryService ciOrdQryService;
        #endregion

        #region 构造函数
        public EmsFeebillViewModel()
        {
            this.ciOrdQryService = XapServiceMgr.find<ICiOrdQryService>();
        }
        #endregion

        #region 接口
        /// <summary>
        /// 获取数据源
        /// </summary>
        /// <returns></returns>
        public override object GetFormDataSource()
        {
            return tableDataSource;
        }

        /// <summary>
        /// 装载费用项目信息
        /// </summary>
        /// <param name="newDrug"></param>
        /// <returns></returns>
        public virtual EmsFeebillViewModel LoadEmsFeeSrv(CiOrdFeeSrvDTO newDrug)
        {
            {

                // 填充默认值
                newDrug.setAttrVal<int>("Use_days", 1);
                newDrug.Id_unit_sale = newDrug.Id_unit_med;
                newDrug.Name_unit_sale = newDrug.Name_unit_med;
                newDrug.Fg_or = false;
                newDrug.Fg_bl = true;
                newDrug.Eu_sourcemd = (int)OrSrvSourceFromEnum.PHYSIANFEEADD;
                #region 计算总量和价格
                newDrug.Quan_total_medu = this.GetLogicEx().getNotDrugTotal(
                    newDrug.Quan_med.ToDouble(),
                    newDrug.Id_freq,
                    newDrug.Freqct == null ? 1 : newDrug.Freqct.Value,
                    newDrug.getAttrVal<int>("Use_days"));

                newDrug.Price = this.GetLogicEx().getSrvNotMMPri(newDrug.Id_srv, newDrug.Id_primd,null,GetEnt4BannerDTO().Id_pripat);
                newDrug.Amt_cur = newDrug.Price * newDrug.Quan_cur;
                #endregion
                FArrayList list = new FArrayList();
                //判断是否是保外诊断
                CiEnContextDTO ciEnContextDTO = BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO;
                //保外诊断标识
                string eu_hpbeyond = ciEnContextDTO.Eu_hpbeyond;

                if (ent4BannerDTO != null && true == ent4BannerDTO.Fg_hpfundpay && HpBeyondEnum.HPDIAG.Equals(ciEnContextDTO.Eu_hpbeyond)/*保内诊断*/)
                {
                    BdHpIndicationDTO bdhpindication = HpJudgeUtil.getInstance().getBdHpIndicationDTO(newDrug.Id_srv, newDrug.Id_mm, this.ent4BannerDTO);
                    if (bdhpindication != null)
                    {
                        newDrug.Fg_treat = bdhpindication.Fg_indic;
                        newDrug.Id_hp = bdhpindication.Id_hp;
                        newDrug.Sd_hpsrvtp = bdhpindication.Sd_hpsrvtp;
                        newDrug.Id_hpsrvtp = bdhpindication.Id_hpsrvtp;
                        if (string.IsNullOrEmpty(bdhpindication.Id_hpsrvtp))
                        {
                            newDrug.Id_hpsrvtp = HpJudgeUtil.IdHpSrvtpFromSdHpSrvtp(bdhpindication.Sd_hpsrvtp);
                        }
                        newDrug.Name_hpsrvtp = HpJudgeUtil.NameHpSrvtpFromSdHpSrvtp(bdhpindication.Sd_hpsrvtp);
                        newDrug.Fg_selfpay = HpJudgeUtil.getInstance().isSelfPay(bdhpindication);
                        list.Add(bdhpindication);
                    }
                }
                else if (ciEnContextDTO.Fg_hpfundpay == null || !(bool)ciEnContextDTO.Fg_hpfundpay || (ciEnContextDTO.Eu_hpbeyond != null && !ciEnContextDTO.Eu_hpbeyond.Equals(HpBeyondEnum.HPDIAG)))
                {
                    newDrug.Fg_treat = false;
                    newDrug.Fg_selfpay = true;
                }
                newDrug.setAttrVal<FArrayList>("BdHpIndicationDTO",list);
                #region 计算执行科室
                CalculateDeptMp(newDrug);
                #endregion


            }
            return this;
        }

        /// <summary>
        /// 计算总量和价格
        /// </summary>
        /// <param name="newDrug"></param>
        public void ReCalculateInfo(CiOrdFeeSrvDTO newDrug)
        {

            #region 计算总量和价格
            if (null != newDrug) {
                newDrug.Quan_total_medu = this.GetLogicEx().getNotDrugTotal(
                newDrug.Quan_med.ToDouble(),
                newDrug.Id_freq,
                newDrug.Freqct == null ? 1 : newDrug.Freqct.Value,
                newDrug.getAttrVal("Use_days") == null ? 1 : newDrug.getAttrVal<int>("Use_days")
               );

                newDrug.Price = this.GetLogicEx().getSrvNotMMPri(newDrug.Id_srv, newDrug.Id_primd,null,GetEnt4BannerDTO().Id_pripat);
                newDrug.Amt_cur = newDrug.Price * newDrug.Quan_cur;
            }

            #endregion
        }

        public virtual EmsFeebillViewModel Reload(object ems = null)
        {
            if (ciEmsDto == null)
                return this;

            this.DeleteAllItems();
            if (this.tableDataSource.Count(p => !p.IsDELETED) == 0) {
                CiOrAggAndRelInfo info = this.ciOrdQryService.getCiOrAggAndRelInfo8Ems(this.ciEmsDto, BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO);
                if (null == info) {
                    return this;
                }

                // 转化为视图显示模型
                //this.szEmsOrDrug = Convert2Drugs(info, this.emsViewModel);

            }


            return this;
        }



        public void DeleteAllItems()
        {
            if (this.tableDataSource != null) {
                this.tableDataSource.ToList().ForEach(p =>
                {
                    this.tableDataSource.Delete(p, p.IsNEW);
                });
            }
        }

        /// <summary>
        /// 清空上下文信息
        /// </summary>
        public void ClearContext()
        {
            if (this.tableDataSource != null) {
                this.tableDataSource.Clear();
            }
            //this.emsViewModel = null;
            //this.emsDto = null;
            //this.SetNullQryBuffer();
        }
        #endregion

        #region 私有方法
        /// <summary>
        /// 计算执行科室
        /// </summary>
        /// <param name="newDrug"></param>
        protected void CalculateDeptMp(CiOrdFeeSrvDTO newDrug)
        {
            #region 计算执行科室
            // if (newDrug.Id_mp_dep == null || newDrug.Id_mp_dep.Length == 0) 
            {
                //执行科室
                OrWfDeptInfoDTO wf = new GetDeptMpImp().GetDept_mp_ids(
                   this.ent4BannerDTO.Code_entp,
                   this.ent4BannerDTO.Id_entp,
                   newDrug.Sd_srvtp,
                   newDrug.Id_srvca,
                   newDrug.Id_srv,
                   newDrug.Id_route,
                   "",
                   this.ent4BannerDTO.Id_dep_nur,
                   this.ent4BannerDTO.Id_dep_phy,
                   GetOrdDeptMp());
                if (wf != null) {
                    newDrug.Id_dep = wf.Firstid_mp_dept;
                    newDrug.Name_dep = wf.Firstname_mp_dept;
                    newDrug.setAttrVal<String>("str_id_mp_deps", wf.Id_mp_depts);
                }
            }
            #endregion
        }


        /// <summary>
        /// 获取医嘱执行科室
        /// </summary>
        /// <returns></returns>
        protected virtual String GetOrdDeptMp()
        {
            return "";
        }

        #endregion

    }
}
